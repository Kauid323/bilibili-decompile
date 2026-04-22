package kntr.app.upcomingEpisode.calendar.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VisibleItemState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/utils/VisibleItemState;", "", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "<init>", "(II)V", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VisibleItemState {
    public static final int $stable = 0;
    private final int firstVisibleItemIndex;
    private final int firstVisibleItemScrollOffset;

    public VisibleItemState() {
        this(0, 0, 3, null);
    }

    public VisibleItemState(int firstVisibleItemIndex, int firstVisibleItemScrollOffset) {
        this.firstVisibleItemIndex = firstVisibleItemIndex;
        this.firstVisibleItemScrollOffset = firstVisibleItemScrollOffset;
    }

    public /* synthetic */ VisibleItemState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getFirstVisibleItemIndex() {
        return this.firstVisibleItemIndex;
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.firstVisibleItemScrollOffset;
    }
}