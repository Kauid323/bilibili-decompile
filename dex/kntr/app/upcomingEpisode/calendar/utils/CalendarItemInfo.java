package kntr.app.upcomingEpisode.calendar.utils;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.model.Month;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeekCalendarLayoutInfo.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0012\u0010\u0013\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0012\u0010\u0015\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/utils/CalendarItemInfo;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "info", "month", "Lkntr/app/upcomingEpisode/calendar/model/Month;", "<init>", "(Landroidx/compose/foundation/lazy/LazyListItemInfo;Lkntr/app/upcomingEpisode/calendar/model/Month;)V", "getMonth", "()Lkntr/app/upcomingEpisode/calendar/model/Month;", "contentType", "", "getContentType", "()Ljava/lang/Object;", "index", "", "getIndex", "()I", "key", "getKey", "offset", "getOffset", "size", "getSize", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CalendarItemInfo implements LazyListItemInfo {
    public static final int $stable = 8;
    private final /* synthetic */ LazyListItemInfo $$delegate_0;
    private final Month month;

    public Object getContentType() {
        return this.$$delegate_0.getContentType();
    }

    public int getIndex() {
        return this.$$delegate_0.getIndex();
    }

    public Object getKey() {
        return this.$$delegate_0.getKey();
    }

    public int getOffset() {
        return this.$$delegate_0.getOffset();
    }

    public int getSize() {
        return this.$$delegate_0.getSize();
    }

    public CalendarItemInfo(LazyListItemInfo info, Month month) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(month, "month");
        this.$$delegate_0 = info;
        this.month = month;
    }

    public final Month getMonth() {
        return this.month;
    }
}