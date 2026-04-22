package tv.danmaku.bili.appwidget.hotlist.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: HotListWidgetView.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/appwidget/hotlist/view/HotListCardType;", "", "titleLines", "", "hideFillLayout", "", "<init>", "(Ljava/lang/String;IIZ)V", "getTitleLines", "()I", "getHideFillLayout", "()Z", "SMALL_CARD", "MIDDLE_CARD", "LARGE_CARD", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum HotListCardType {
    SMALL_CARD(1, false, 2, null),
    MIDDLE_CARD(2, false, 2, null),
    LARGE_CARD(3, false);
    
    private final boolean hideFillLayout;
    private final int titleLines;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<HotListCardType> getEntries() {
        return $ENTRIES;
    }

    HotListCardType(int titleLines, boolean hideFillLayout) {
        this.titleLines = titleLines;
        this.hideFillLayout = hideFillLayout;
    }

    /* synthetic */ HotListCardType(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? true : z);
    }

    public final boolean getHideFillLayout() {
        return this.hideFillLayout;
    }

    public final int getTitleLines() {
        return this.titleLines;
    }
}