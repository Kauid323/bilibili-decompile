package tv.danmaku.bili.ui.favorites.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.bilibili.lib.feed.base.BaseFeedHolder;
import com.bilibili.lib.feed.base.BaseFeedItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesFollowBinding;
import tv.danmaku.bili.ui.favorites.card.FollowHolder;
import tv.danmaku.bili.ui.favorites.model.FollowItem;

/* compiled from: FollowListAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FollowListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Ltv/danmaku/bili/ui/favorites/model/FollowItem;", "Ltv/danmaku/bili/ui/favorites/card/FollowHolder;", "clickListener", "Ltv/danmaku/bili/ui/favorites/adapter/FollowCardClickListener;", "<init>", "(Ltv/danmaku/bili/ui/favorites/adapter/FollowCardClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FollowListAdapter extends ListAdapter<FollowItem, FollowHolder> {
    public static final int $stable = 8;
    private final FollowCardClickListener clickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowListAdapter(FollowCardClickListener clickListener) {
        super(new DiffUtil.ItemCallback<FollowItem>() { // from class: tv.danmaku.bili.ui.favorites.adapter.FollowListAdapter.1
            public boolean areItemsTheSame(FollowItem oldItem, FollowItem newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.getOid() == newItem.getOid() && oldItem.getOtype() == newItem.getOtype();
            }

            public boolean areContentsTheSame(FollowItem oldItem, FollowItem newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
    }

    public FollowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BiliAppItemFavoritesFollowBinding inflate = BiliAppItemFavoritesFollowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new FollowHolder(inflate, this.clickListener);
    }

    public void onBindViewHolder(FollowHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BaseFeedHolder.bindData$default(holder, (BaseFeedItem) getItem(position), false, 2, (Object) null);
    }
}