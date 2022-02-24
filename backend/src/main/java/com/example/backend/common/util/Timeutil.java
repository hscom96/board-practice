package com.example.backend.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Timeutil {

    public static long convertToTimestamp(LocalDateTime localDateTime) {
        return ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Seoul")).toEpochSecond() * 1000;
    }
}
