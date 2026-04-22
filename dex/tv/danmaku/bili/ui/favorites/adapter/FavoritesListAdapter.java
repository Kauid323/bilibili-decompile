package tv.danmaku.bili.ui.favorites.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.feed.base.BaseFeedHolder;
import com.bilibili.lib.feed.base.BaseFeedItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesArticleBinding;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesInvalidVideoBinding;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesVideoBinding;
import tv.danmaku.bili.ui.favorites.adapter.holder.FavoritesInvalidVideoHolder;
import tv.danmaku.bili.ui.favorites.card.BaseFavoritesHolder;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;

/* compiled from: FavoritesListAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J,\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FavoritesListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "cardClickListener", "Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;", "<init>", "(Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "payloads", "", "", "notifyCheckAll", "checked", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class FavoritesListAdapter extends ListAdapter<FavoritesMediasItem, BaseFavoritesHolder<FavoritesMediasItem>> {
    public static final int $stable = 8;
    private final FavCardClickListener cardClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesListAdapter(FavCardClickListener cardClickListener) {
        super(new DiffUtil.ItemCallback<FavoritesMediasItem>() { // from class: tv.danmaku.bili.ui.favorites.adapter.FavoritesListAdapter.1
            public boolean areItemsTheSame(FavoritesMediasItem oldItem, FavoritesMediasItem newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.getOid() == newItem.getOid() && oldItem.getOtype() == newItem.getOtype();
            }

            public boolean areContentsTheSame(FavoritesMediasItem oldItem, FavoritesMediasItem newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }

            public Object getChangePayload(FavoritesMediasItem oldItem, FavoritesMediasItem newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                int i = 5;
                if ((oldItem.getEnableDrag() && oldItem.getCanDrag()) || (newItem.getEnableDrag() && newItem.getCanDrag())) {
                    return 5;
                }
                if (oldItem.isCheckMode() != newItem.isCheckMode()) {
                    i = newItem.isCheckMode() ? 1 : 2;
                } else if (oldItem.isChecked() != newItem.isChecked()) {
                    i = newItem.isChecked() ? 3 : 4;
                }
                return Integer.valueOf(i);
            }
        });
        Intrinsics.checkNotNullParameter(cardClickListener, "cardClickListener");
        this.cardClickListener = cardClickListener;
    }

    public int getItemViewType(int position) {
        if (((FavoritesMediasItem) getItem(position)).isInvalid()) {
            return 5;
        }
        return ((FavoritesMediasItem) getItem(position)).getCardType();
    }

    @Override // 
    public BaseFavoritesHolder<FavoritesMediasItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 3:
                BiliAppItemFavoritesArticleBinding inflate = BiliAppItemFavoritesArticleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                return new FavoritesArticleHolder(inflate, this.cardClickListener);
            case 4:
            default:
                BiliAppItemFavoritesVideoBinding inflate2 = BiliAppItemFavoritesVideoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
                return new FavoritesVideoHolder(inflate2, this.cardClickListener);
            case 5:
                BiliAppItemFavoritesInvalidVideoBinding inflate3 = BiliAppItemFavoritesInvalidVideoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(...)");
                return new FavoritesInvalidVideoHolder(inflate3, this.cardClickListener);
        }
    }

    public void onBindViewHolder(BaseFavoritesHolder<FavoritesMediasItem> baseFavoritesHolder, int position) {
        Intrinsics.checkNotNullParameter(baseFavoritesHolder, "holder");
        BaseFeedHolder.bindData$default(baseFavoritesHolder, (BaseFeedItem) getItem(position), false, 2, (Object) null);
    }

    public void onBindViewHolder(BaseFavoritesHolder<FavoritesMediasItem> baseFavoritesHolder, int position, List<Object> list) {
        Intrinsics.checkNotNullParameter(baseFavoritesHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (list.isEmpty()) {
            super.onBindViewHolder((RecyclerView.ViewHolder) baseFavoritesHolder, position, list);
        } else {
            BaseFeedHolder.bindData$default(baseFavoritesHolder, (BaseFeedItem) getItem(position), list, false, 4, (Object) null);
        }
    }

    public final void notifyCheckAll(boolean checked) {
        notifyItemRangeChanged(0, getItemCount(), Integer.valueOf(checked ? 3 : 4));
    }
}