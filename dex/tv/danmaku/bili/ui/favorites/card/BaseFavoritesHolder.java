package tv.danmaku.bili.ui.favorites.card;

import android.view.View;
import com.bilibili.lib.feed.base.BaseFeedHolder;
import com.bilibili.lib.feed.base.BaseFeedItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BaseFavoritesHolder.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "T", "Lcom/bilibili/lib/feed/base/BaseFeedItem;", "Lcom/bilibili/lib/feed/base/BaseFeedHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class BaseFavoritesHolder<T extends BaseFeedItem> extends BaseFeedHolder<T> {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFavoritesHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }
}