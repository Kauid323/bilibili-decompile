package kntr.app.upcomingEpisode.list.utils;

import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarCardType;
import com.bapis.bilibili.community.interfacess.watch.v1.KWatchBizType;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.list.model.CalendarCard;
import kntr.base.localization.NumberFormatKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: UpcomingEpisodeExtensions.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0000\u001a\f\u0010\n\u001a\u00020\b*\u00020\u000bH\u0000\u001a\f\u0010\f\u001a\u00020\b*\u00020\u0007H\u0000\u001a\f\u0010\r\u001a\u00020\b*\u00020\u0007H\u0000\u001a\u0012\u0010\u000e\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0000\u001a\f\u0010\u0012\u001a\u00020\b*\u00020\u0007H\u0000¨\u0006\u0013"}, d2 = {"isUgc", "", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarCardType;", "isOgv", "isLive", "isReserve", "safeParseToLong", "", "", "defaultValue", "toAnchorBizTypeString", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;", "convertTimestampToString", "convertTimestampToFormattedString", "getLatestUpcomingIndex", "", "", "Lkntr/app/upcomingEpisode/list/model/CalendarCard;", "readableString", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpcomingEpisodeExtensionsKt {
    public static final boolean isUgc(KCalendarCardType $this$isUgc) {
        Intrinsics.checkNotNullParameter($this$isUgc, "<this>");
        return Intrinsics.areEqual($this$isUgc, KCalendarCardType.CALENDAR_CARD_TYPE_ARCHIVE.INSTANCE);
    }

    public static final boolean isOgv(KCalendarCardType $this$isOgv) {
        Intrinsics.checkNotNullParameter($this$isOgv, "<this>");
        return Intrinsics.areEqual($this$isOgv, KCalendarCardType.CALENDAR_CARD_TYPE_OGV.INSTANCE);
    }

    public static final boolean isLive(KCalendarCardType $this$isLive) {
        Intrinsics.checkNotNullParameter($this$isLive, "<this>");
        return Intrinsics.areEqual($this$isLive, KCalendarCardType.CALENDAR_CARD_TYPE_LIVE.INSTANCE);
    }

    public static final boolean isReserve(KCalendarCardType $this$isReserve) {
        Intrinsics.checkNotNullParameter($this$isReserve, "<this>");
        return Intrinsics.areEqual($this$isReserve, KCalendarCardType.CALENDAR_CARD_TYPE_RESERVE.INSTANCE);
    }

    public static /* synthetic */ long safeParseToLong$default(String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return safeParseToLong(str, j);
    }

    public static final long safeParseToLong(String $this$safeParseToLong, long defaultValue) {
        Intrinsics.checkNotNullParameter($this$safeParseToLong, "<this>");
        if ($this$safeParseToLong.length() == 0) {
            return defaultValue;
        }
        try {
            return Long.parseLong($this$safeParseToLong);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static final String toAnchorBizTypeString(KWatchBizType $this$toAnchorBizTypeString) {
        Intrinsics.checkNotNullParameter($this$toAnchorBizTypeString, "<this>");
        return String.valueOf($this$toAnchorBizTypeString.getValue());
    }

    public static final String convertTimestampToString(long $this$convertTimestampToString) {
        Instant instant = Instant.Companion.fromEpochSeconds$default(Instant.Companion, $this$convertTimestampToString, 0L, 2, (Object) null);
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(instant, TimeZone.Companion.currentSystemDefault());
        String formattedHour = StringsKt.padStart(String.valueOf(localDateTime.getHour()), 2, '0');
        String formattedMinute = StringsKt.padStart(String.valueOf(localDateTime.getMinute()), 2, '0');
        return formattedHour + ":" + formattedMinute;
    }

    public static final String convertTimestampToFormattedString(long $this$convertTimestampToFormattedString) {
        Instant instant = Instant.Companion.fromEpochSeconds$default(Instant.Companion, $this$convertTimestampToFormattedString, 0L, 2, (Object) null);
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(instant, TimeZone.Companion.currentSystemDefault());
        int month = localDateTime.getMonthNumber();
        int day = localDateTime.getDayOfMonth();
        String formattedHour = StringsKt.padStart(String.valueOf(localDateTime.getHour()), 2, '0');
        String formattedMinute = StringsKt.padStart(String.valueOf(localDateTime.getMinute()), 2, '0');
        return month + "月" + day + "日 " + formattedHour + ":" + formattedMinute;
    }

    public static final int getLatestUpcomingIndex(List<CalendarCard> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        long currentTime = Clock.System.INSTANCE.now().getEpochSeconds();
        int res = -1;
        long minDiff = Long.MAX_VALUE;
        List<CalendarCard> $this$forEachIndexed$iv = list;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CalendarCard card = (CalendarCard) item$iv;
            if (!isReserve(card.getCalendarCardType())) {
                if (card.getAnchorTime() > currentTime) {
                    return res;
                }
                long diff = Math.abs(card.getAnchorTime() - currentTime);
                if (diff < minDiff) {
                    res = index;
                    minDiff = diff;
                } else if (diff == minDiff && index > res) {
                    res = index;
                }
            }
            index = index$iv;
        }
        return res;
    }

    public static final String readableString(long $this$readableString) {
        if ($this$readableString <= 0) {
            return "-";
        }
        return NumberFormatKt.formatNumber($this$readableString, 1, true);
    }
}