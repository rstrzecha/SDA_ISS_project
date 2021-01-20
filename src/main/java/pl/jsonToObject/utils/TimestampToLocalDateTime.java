package pl.jsonToObject.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class TimestampToLocalDateTime {

    public static LocalDateTime getDateTime(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp*1000L),
                TimeZone.getDefault().toZoneId());
    }

}
