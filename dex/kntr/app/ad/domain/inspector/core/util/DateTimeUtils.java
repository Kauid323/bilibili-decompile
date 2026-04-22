package kntr.app.ad.domain.inspector.core.util;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: DateTimeUtils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lkntr/app/ad/domain/inspector/core/util/DateTimeUtils;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "currentTimeMillis", RoomRecommendViewModel.EMPTY_CURSOR, "formatTimestamp", RoomRecommendViewModel.EMPTY_CURSOR, "timestamp", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DateTimeUtils {
    public static final int $stable = 0;
    public static final DateTimeUtils INSTANCE = new DateTimeUtils();

    private DateTimeUtils() {
    }

    public final long currentTimeMillis() {
        return Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public final String formatTimestamp(long timestamp) {
        Instant instant = Instant.Companion.fromEpochMilliseconds(timestamp);
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(instant, TimeZone.Companion.currentSystemDefault());
        int millis = instant.getNanosecondsOfSecond() / 1000000;
        int year = localDateTime.getYear();
        String padStart = StringsKt.padStart(String.valueOf(localDateTime.getMonthNumber()), 2, '0');
        String padStart2 = StringsKt.padStart(String.valueOf(localDateTime.getDayOfMonth()), 2, '0');
        String padStart3 = StringsKt.padStart(String.valueOf(localDateTime.getHour()), 2, '0');
        String padStart4 = StringsKt.padStart(String.valueOf(localDateTime.getMinute()), 2, '0');
        String padStart5 = StringsKt.padStart(String.valueOf(localDateTime.getSecond()), 2, '0');
        return year + "-" + padStart + "-" + padStart2 + " " + padStart3 + ":" + padStart4 + ":" + padStart5 + "." + StringsKt.padStart(String.valueOf(millis), 3, '0');
    }
}