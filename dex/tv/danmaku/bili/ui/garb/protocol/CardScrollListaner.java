package tv.danmaku.bili.ui.garb.protocol;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: CardScrollListaner.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/protocol/CardScrollListaner;", "", "onScrolled", "", "dx", "", "dy", "offset", "onScrollStateChanged", "position", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface CardScrollListaner {
    void onScrollStateChanged(int i);

    void onScrolled(int i, int i2, int i3);
}