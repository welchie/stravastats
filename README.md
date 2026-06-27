# Strava Stats & AI Training Analyst

This system pulls training data from the Strava API, persists it locally using a relational JPA database (H2), and integrates Google Gemini AI to analyze the athlete's athletic training.

---

## 🏗️ System Architecture

The following diagram illustrates how the system modules interact, route requests, persist records, and perform AI-driven training analysis:

```mermaid
graph TD
    Client["HTTP Client (Web/API)"] --> Controller["REST Controllers"]
    
    subgraph Spring Boot Application
        Controller --> StravaAthleteController["StravaAthleteController"]
        Controller --> GeminiController["GeminiController"]
        
        StravaAthleteController --> AthleteService["AthleteService / AthleteStatsService"]
        StravaAthleteController --> StravaRestClient["StravaRestClient (Lazy Refresh)"]
        
        GeminiController --> GeminiService["GeminiService"]
        GeminiController --> StravaRestClient
        
        AthleteService --> Repositories["JPA Repositories (Athlete, Activity, Stats)"]
        GeminiService --> ChatClient["Spring AI ChatClient (Gemini Pro/Flash)"]
    end

    subgraph External Systems & Storage
        StravaRestClient -->|HTTPS OAuth/API| StravaAPI["Strava API"]
        Repositories -->|SQL| H2DB["H2 Database (In-Memory/Persistent)"]
        ChatClient -->|REST| GeminiAPI["Google Gemini GenAI API"]
    end
    
    style Controller fill:#f9f,stroke:#333,stroke-width:2px
    style StravaAPI fill:#ff9,stroke:#f60,stroke-width:2px
    style GeminiAPI fill:#9cf,stroke:#39c,stroke-width:2px
    style H2DB fill:#cfc,stroke:#3c3,stroke-width:2px
```

---

## 🔄 Sequence: Activity Analysis

This sequence diagram depicts how a developer or user calls the AI analysis endpoint, triggers lazy authentication check, retrieves training records from Strava, and processes them with Google Gemini:

```mermaid
sequenceDiagram
    autonumber
    actor Dev as Developer / User
    participant GC as GeminiController
    participant SRC as StravaRestClient
    participant GS as GeminiService
    participant SAPI as Strava API
    participant GAI as Gemini AI

    Dev->>GC: GET /api/gemini/analyze/activities?numActivities=10
    GC->>SRC: getAthleteActivities("10")
    
    Note over SRC: Check if access token is expired <br> (expires_at check)
    alt Token is Expired / Null
        SRC->>SAPI: POST /oauth/token (client_id, client_secret, refresh_token)
        SAPI-->>SRC: Return new Access Token & Refresh Token
    end
    
    SRC->>SAPI: GET /athlete/activities?per_page=10 (Bearer Token)
    SAPI-->>SRC: List of StravaActivity JSON
    SRC-->>GC: Return List<StravaActivity>
    
    GC->>GS: analyzeActivities(activities)
    GS->>GAI: Prompt ChatClient with formatted activity logs
    GAI-->>GS: AI Training Analysis markdown response
    GS-->>GC: Return Analysis content
    GC-->>Dev: HTTP 200 (Markdown Analysis Response)
```

---

## ⚙️ Configuration & Environment Setup

To run the application, configure your credentials in your environment. The application will bind these properties automatically:

```bash
# Google GenAI API Key (AI Studio)
export GEMINI_API_KEY="AIzaSy..."

# Strava API Application Details
export STRAVA_CLIENT_ID="48445"
export STRAVA_CLIENT_SECRET="d906ca..."

# Athlete Account & Initial Refresh Token
export STRAVA_ATHLETE_ID="13986969"
export STRAVA_REFRESH_TOKEN="081f27..."
```

*Note: In production and dev profiles, settings are injected via environmental placeholders in the [application.properties](file:///Users/chriswelch/workspace/strava-stats/strava/src/main/resources/application.properties) file.*

---

## 🔌 API Endpoint Reference

### 1. Strava Athlete & Local DB Endpoints

| Method | Endpoint | Description |
|:---|:---|:---|
| **GET** | `/athlete` | Fetches active athlete profile from Strava, stores it in database, and returns payload. |
| **GET** | `/athlete/{id}` | Retrieves a previously stored athlete profile from local database. |
| **GET** | `/athlete/stats` | Fetches active athlete stats from Strava, links them to athlete in DB, and returns payload. |
| **GET** | `/athlete/activities` | Fetches activities list. Parameter: `numActivities` (e.g. `?numActivities=5`). |
| **GET** | `/athlete/activity/{id}` | Fetches detailed information for a specific activity ID. |

### 2. Gemini AI Analysis Endpoints

| Method | Endpoint | Description |
|:---|:---|:---|
| **GET** | `/api/gemini/joke` | Generates a topic-based joke using Gemini (default topic: `bicycles`). |
| **GET** | `/api/gemini/analyze/activities`| Fetches latest activities from Strava and runs a comprehensive training workload/fatigue analysis using Gemini. |
| **GET** | `/api/gemini/analyze/stats` | Gathers career/YTD statistics from Strava and requests Gemini to write an athlete career analysis. |

---

## 🛠️ Local Development & Build Commands

Build the project and run the tests locally using the Gradle wrapper:

* **Compile and build JAR**:
  ```bash
  ./gradlew build
  ```
* **Run Unit & Integration Tests**:
  ```bash
  ./gradlew test
  ```
* **Run application locally**:
  ```bash
  ./gradlew bootRun
  ```
