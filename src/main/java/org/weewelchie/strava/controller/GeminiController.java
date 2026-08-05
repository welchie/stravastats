package org.weewelchie.strava.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import org.weewelchie.strava.client.StravaRestClient;
import org.weewelchie.strava.data.beans.StravaActivity;
import org.weewelchie.strava.data.beans.StravaAthleteStats;
import org.weewelchie.strava.data.dto.GeminiResponseDto;
import org.weewelchie.strava.service.GeminiService;

@RestController
@RequestMapping("/api/gemini")
public class GeminiController {

    private final GeminiService geminiService;
    private final StravaRestClient stravaRestClient;

    public GeminiController(GeminiService geminiService, StravaRestClient stravaRestClient) {
        this.geminiService = geminiService;
        this.stravaRestClient = stravaRestClient;
    }

    @GetMapping(value = "/joke", produces = MediaType.APPLICATION_JSON_VALUE)
    public GeminiResponseDto jokeJson(
            @RequestParam(value = "topic", defaultValue = "bicycles") String topic) {
        String result = geminiService.getJoke(topic);
        return new GeminiResponseDto("Gemini Joke: " + topic, topic, result, java.time.Instant.now());
    }

    @GetMapping(value = "/joke", produces = MediaType.TEXT_HTML_VALUE)
    public String jokeHtml(
            @RequestParam(value = "topic", defaultValue = "bicycles") String topic,
            @RequestParam(value = "raw", defaultValue = "false") boolean raw) {
        String result = geminiService.getJoke(topic);
        if (raw) {
            return result;
        }
        return formatAsHtml("Gemini Joke: " + topic, result);
    }

    @GetMapping(value = "/analyze/activities", produces = MediaType.APPLICATION_JSON_VALUE)
    public GeminiResponseDto analyzeActivitiesJson(
            @RequestParam(name = "numActivities", defaultValue = "10") String numActivities) throws IOException {
        List<StravaActivity> activities = stravaRestClient.getAthleteActivities(numActivities);
        String result = geminiService.analyzeActivities(activities);
        return new GeminiResponseDto("Strava Training Workload Analysis", "activities", result, java.time.Instant.now());
    }

    @GetMapping(value = "/analyze/activities", produces = MediaType.TEXT_HTML_VALUE)
    public String analyzeActivitiesHtml(
            @RequestParam(name = "numActivities", defaultValue = "10") String numActivities,
            @RequestParam(value = "raw", defaultValue = "false") boolean raw) throws IOException {
        List<StravaActivity> activities = stravaRestClient.getAthleteActivities(numActivities);
        String result = geminiService.analyzeActivities(activities);
        if (raw) {
            return result;
        }
        return formatAsHtml("Strava Training Workload Analysis", result);
    }

    @GetMapping(value = "/analyze/stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public GeminiResponseDto analyzeStatsJson() {
        StravaAthleteStats stats = stravaRestClient.getAthleteStats();
        String result = geminiService.analyzeStats(stats);
        return new GeminiResponseDto("Athlete Career Summary", "stats", result, java.time.Instant.now());
    }

    @GetMapping(value = "/analyze/stats", produces = MediaType.TEXT_HTML_VALUE)
    public String analyzeStatsHtml(@RequestParam(value = "raw", defaultValue = "false") boolean raw) {
        StravaAthleteStats stats = stravaRestClient.getAthleteStats();
        String result = geminiService.analyzeStats(stats);
        if (raw) {
            return result;
        }
        return formatAsHtml("Athlete Career Summary", result);
    }

    private String formatAsHtml(String title, String markdownContent) {
        String safeTitle = HtmlUtils.htmlEscape(title == null ? "" : title);
        String base64Content = markdownContent == null ? "" : Base64.getEncoder()
                .encodeToString(markdownContent.getBytes(StandardCharsets.UTF_8));

        return """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>{{title}}</title>
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;600;700&display=swap" rel="stylesheet">
            <script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
            <style>
                :root {
                    --bg-color: #0b0f19;
                    --card-bg: #151f32;
                    --text-color: #f3f4f6;
                    --text-muted: #9ca3af;
                    --accent-color: #3b82f6;
                    --accent-gradient: linear-gradient(135deg, #3b82f6 0%, #8b5cf6 100%);
                    --border-color: #1e293b;
                }
                body {
                    font-family: 'Outfit', sans-serif;
                    background-color: var(--bg-color);
                    color: var(--text-color);
                    line-height: 1.7;
                    margin: 0;
                    padding: 0;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    min-height: 100vh;
                }
                .container {
                    width: 100%;
                    max-width: 800px;
                    margin: 40px 20px;
                    background-color: var(--card-bg);
                    border: 1px solid var(--border-color);
                    border-radius: 16px;
                    padding: 40px;
                    box-shadow: 0 10px 25px -5px rgba(0, 0, 0, 0.3), 0 8px 10px -6px rgba(0, 0, 0, 0.3);
                }
                h1, h2, h3 {
                    color: #ffffff;
                    font-weight: 600;
                }
                h1 {
                    font-size: 2rem;
                    margin-top: 0;
                    margin-bottom: 24px;
                    background: var(--accent-gradient);
                    -webkit-background-clip: text;
                    -webkit-text-fill-color: transparent;
                    border-bottom: 1px solid var(--border-color);
                    padding-bottom: 16px;
                }
                p, li {
                    color: var(--text-color);
                }
                li {
                    margin-bottom: 8px;
                }
                code {
                    font-family: 'Fira Code', monospace;
                    background-color: rgba(255, 255, 255, 0.1);
                    padding: 2px 6px;
                    border-radius: 4px;
                    font-size: 0.9em;
                }
                pre {
                    background-color: #0b0f19;
                    border: 1px solid var(--border-color);
                    padding: 16px;
                    border-radius: 8px;
                    overflow-x: auto;
                }
                pre code {
                    background-color: transparent;
                    padding: 0;
                }
                blockquote {
                    border-left: 4px solid var(--accent-color);
                    margin: 0;
                    padding-left: 16px;
                    color: var(--text-muted);
                    font-style: italic;
                }
                hr {
                    border: 0;
                    border-top: 1px solid var(--border-color);
                    margin: 32px 0;
                }
                table {
                    width: 100%;
                    border-collapse: collapse;
                    margin: 24px 0;
                }
                th, td {
                    border: 1px solid var(--border-color);
                    padding: 12px;
                    text-align: left;
                }
                th {
                    background-color: rgba(255, 255, 255, 0.05);
                }
            </style>
        </head>
        <body>
            <div class="container">
                <h1>{{title}}</h1>
                <div id="content">Rendering response...</div>
            </div>
            <script>
                function base64ToUtf8(base64) {
                    const binaryString = atob(base64);
                    const bytes = new Uint8Array(binaryString.length);
                    for (let i = 0; i < binaryString.length; i++) {
                        bytes[i] = binaryString.charCodeAt(i);
                    }
                    return new TextDecoder().decode(bytes);
                }
                const rawMarkdown = base64ToUtf8(`{{content}}`);
                document.getElementById('content').innerHTML = marked.parse(rawMarkdown);
            </script>
        </body>
        </html>
        """.replace("{{title}}", safeTitle).replace("{{content}}", base64Content);
    }
}
