package tv.danmaku.bili.ui.favorites.model;

import com.bilibili.lib.feed.base.BaseFeedItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: FavoritesResponse.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/favorites/model/BaseFavItem;", "Lcom/bilibili/lib/feed/base/BaseFeedItem;", "isExposed", "", "<init>", "(Z)V", "()Z", "setExposed", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class BaseFavItem extends BaseFeedItem {
    public static final int $stable = 8;
    private boolean isExposed;

    public BaseFavItem() {
        this(false, 1, null);
    }

    public BaseFavItem(boolean isExposed) {
        this.isExposed = isExposed;
    }

    public /* synthetic */ BaseFavItem(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean isExposed() {
        return this.isExposed;
    }

    public final void setExposed(boolean z) {
        this.isExposed = z;
    }
}