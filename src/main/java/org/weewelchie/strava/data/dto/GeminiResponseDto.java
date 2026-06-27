package org.weewelchie.strava.data.dto;

import java.time.Instant;

public record GeminiResponseDto(
    String title,
    String topic,
    String content,
    Instant timestamp
) {}
