package tv.danmaku.bili.ui.favorites.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.feed.base.BaseFeedHolder;
import com.bilibili.playset.playlist.entity.SortRecord;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesArticleBinding;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesInvalidVideoBinding;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesVideoBinding;
import tv.danmaku.bili.ui.favorites.adapter.holder.FavoritesInvalidVideoHolder;
import tv.danmaku.bili.ui.favorites.card.BaseFavoritesHolder;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel;

/* compiled from: FavoritesEditListAdapter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J \u0010\u0016\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H\u0016J\u001e\u0010!\u001a\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J,\u0010!\u001a\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001b\u001a\u00020\u00142\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0010H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FavoritesEditListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "mSortOps", "", "Lcom/bilibili/playset/playlist/entity/SortRecord;", "viewModel", "Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesEditListViewModel;", "cardClickListener", "Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;", "<init>", "(Ljava/util/List;Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesEditListViewModel;Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;)V", "getViewModel", "()Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesEditListViewModel;", "mDataList", "", "swap", "", "from", "", "target", "setItemList", "itemList", "notifyDataSetChange", "", "getItemViewType", "position", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesEditListAdapter extends RecyclerView.Adapter<BaseFavoritesHolder<FavoritesMediasItem>> {
    public static final int $stable = 8;
    private final FavCardClickListener cardClickListener;
    private List<FavoritesMediasItem> mDataList;
    private final List<SortRecord> mSortOps;
    private final FavoritesEditListViewModel viewModel;

    public FavoritesEditListAdapter(List<SortRecord> list, FavoritesEditListViewModel viewModel, FavCardClickListener cardClickListener) {
        Intrinsics.checkNotNullParameter(list, "mSortOps");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(cardClickListener, "cardClickListener");
        this.mSortOps = list;
        this.viewModel = viewModel;
        this.cardClickListener = cardClickListener;
        this.mDataList = new ArrayList();
    }

    public final FavoritesEditListViewModel getViewModel() {
        return this.viewModel;
    }

    public final void swap(int from, int target) {
        BLog.i(FavoritesEditListViewModel.TAG, "media sort from:" + from + " target: " + target);
        Collections.swap(this.viewModel.getSortedList(), from, target);
        Collections.swap(this.mDataList, from, target);
        notifyItemMoved(from, target);
        int prePosition = target - 1;
        FavoritesMediasItem preMedia = prePosition >= 0 ? this.viewModel.getSortedList().get(prePosition) : null;
        FavoritesMediasItem insertMedia = this.viewModel.getSortedList().get(target);
        SortRecord opRecord = (SortRecord) CollectionsKt.last(this.mSortOps);
        opRecord.setPreId(preMedia != null ? preMedia.getOid() : 0L);
        opRecord.setPreType(preMedia != null ? preMedia.getOtype() : 0);
        opRecord.setInsertId(insertMedia.getOid());
        opRecord.setInsertType(insertMedia.getOtype());
    }

    public static /* synthetic */ void setItemList$default(FavoritesEditListAdapter favoritesEditListAdapter, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        favoritesEditListAdapter.setItemList(list, z);
    }

    public void setItemList(List<FavoritesMediasItem> list, boolean notifyDataSetChange) {
        Intrinsics.checkNotNullParameter(list, "itemList");
        this.mDataList.clear();
        this.mDataList.addAll(list);
        if (notifyDataSetChange) {
            notifyDataSetChanged();
        }
    }

    public int getItemViewType(int position) {
        if (this.mDataList.get(position).isInvalid()) {
            return 5;
        }
        return this.mDataList.get(position).getCardType();
    }

    public int getItemCount() {
        return this.mDataList.size();
    }

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
        BaseFeedHolder.bindData$default(baseFavoritesHolder, this.mDataList.get(position), false, 2, (Object) null);
    }

    public void onBindViewHolder(BaseFavoritesHolder<FavoritesMediasItem> baseFavoritesHolder, int position, List<Object> list) {
        Intrinsics.checkNotNullParameter(baseFavoritesHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (list.isEmpty()) {
            super.onBindViewHolder((RecyclerView.ViewHolder) baseFavoritesHolder, position, list);
        } else {
            BaseFeedHolder.bindData$default(baseFavoritesHolder, this.mDataList.get(position), list, false, 4, (Object) null);
        }
    }
}