package kea.examn2022.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalUnit;

public class DurationFormatter {
    public static String formatDuration(Duration duration) {
        return "%dh %dm".formatted(duration.toHours(), duration.toMinutesPart());
    }
}