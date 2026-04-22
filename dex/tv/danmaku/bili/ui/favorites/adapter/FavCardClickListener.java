package tv.danmaku.bili.ui.favorites.adapter;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;

/* compiled from: FavoritesListAdapter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FavCardClickListener;", "", "onItemClick", "", "item", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", FavoritesConstsKt.POS, "", "onCheckClick", "onMoreClick", "onClearInvalidItem", "startDrag", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface FavCardClickListener {
    void onCheckClick(int i);

    void onClearInvalidItem(FavoritesMediasItem favoritesMediasItem);

    void onItemClick(FavoritesMediasItem favoritesMediasItem, int i);

    void onMoreClick(FavoritesMediasItem favoritesMediasItem);

    void startDrag(RecyclerView.ViewHolder viewHolder);
}