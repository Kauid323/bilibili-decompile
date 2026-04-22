package tv.danmaku.bili.ui.favorites.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.bilibili.lib.feed.base.BaseFeedHolder;
import com.bilibili.lib.feed.base.BaseFeedItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesAddFolderBinding;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesCompactFolderBinding;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesFolderBinding;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.favorites.card.BaseFavoritesHolder;
import tv.danmaku.bili.ui.favorites.card.CompactFolderHolder;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesFolderItem;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.util.FavoritesFolderUtilsKt;

/* compiled from: FolderListAdapter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001Bõ\u0001\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005\u0012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000b0\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u0012K\u0010\u0010\u001aG\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u0011\u00126\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u001e\u0010\u001f\u001a\u00020\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#R>\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000RS\u0010\u0010\u001aG\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FolderListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesFolderItem;", "Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "onItemClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "item", "", FavoritesConstsKt.POS, "", "onItemLongClick", "Lkotlin/Function1;", "onAddFolderClick", "Lkotlin/Function0;", "onFolderItemClick", "Lkotlin/Function3;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "", "fid", "onPlayItemClick", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "layoutType", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "setLayoutType", "compact", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FolderListAdapter extends ListAdapter<FavoritesFolderItem, BaseFavoritesHolder<FavoritesFolderItem>> {
    public static final int $stable = 8;
    private int layoutType;
    private final Function0<Unit> onAddFolderClick;
    private final Function3<FavoritesMediasItem, Integer, Long, Unit> onFolderItemClick;
    private final Function2<FavoritesFolderItem, Integer, Unit> onItemClick;
    private final Function1<FavoritesFolderItem, Unit> onItemLongClick;
    private final Function2<FavoritesMediasItem, Long, Unit> onPlayItemClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FolderListAdapter(Function2<? super FavoritesFolderItem, ? super Integer, Unit> function2, Function1<? super FavoritesFolderItem, Unit> function1, Function0<Unit> function0, Function3<? super FavoritesMediasItem, ? super Integer, ? super Long, Unit> function3, Function2<? super FavoritesMediasItem, ? super Long, Unit> function22) {
        super(new DiffUtil.ItemCallback<FavoritesFolderItem>() { // from class: tv.danmaku.bili.ui.favorites.adapter.FolderListAdapter.1
            public boolean areItemsTheSame(FavoritesFolderItem oldItem, FavoritesFolderItem newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.getFid() == newItem.getFid() && oldItem.getType() == newItem.getType();
            }

            public boolean areContentsTheSame(FavoritesFolderItem oldItem, FavoritesFolderItem newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
        int i;
        Intrinsics.checkNotNullParameter(function2, "onItemClick");
        Intrinsics.checkNotNullParameter(function1, "onItemLongClick");
        Intrinsics.checkNotNullParameter(function0, "onAddFolderClick");
        Intrinsics.checkNotNullParameter(function3, "onFolderItemClick");
        Intrinsics.checkNotNullParameter(function22, "onPlayItemClick");
        this.onItemClick = function2;
        this.onItemLongClick = function1;
        this.onAddFolderClick = function0;
        this.onFolderItemClick = function3;
        this.onPlayItemClick = function22;
        if (FavoritesFolderUtilsKt.compactLayoutType()) {
            i = 2;
        } else {
            i = 0;
        }
        this.layoutType = i;
    }

    public int getItemViewType(int position) {
        if (((FavoritesFolderItem) getItem(position)).viewType == 1) {
            return 1;
        }
        return this.layoutType;
    }

    public BaseFavoritesHolder<FavoritesFolderItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 1:
                BiliAppItemFavoritesAddFolderBinding inflate = BiliAppItemFavoritesAddFolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                return new AddFolderHolder(inflate, this.onAddFolderClick);
            case 2:
                BiliAppItemFavoritesCompactFolderBinding inflate2 = BiliAppItemFavoritesCompactFolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
                return new CompactFolderHolder(inflate2, this.onItemClick, this.onItemLongClick, this.onPlayItemClick);
            default:
                BiliAppItemFavoritesFolderBinding inflate3 = BiliAppItemFavoritesFolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(...)");
                return new FolderHolder(inflate3, this.onItemClick, this.onItemLongClick, this.onFolderItemClick);
        }
    }

    public void onBindViewHolder(BaseFavoritesHolder<FavoritesFolderItem> baseFavoritesHolder, int position) {
        Intrinsics.checkNotNullParameter(baseFavoritesHolder, "holder");
        BaseFeedHolder.bindData$default(baseFavoritesHolder, (BaseFeedItem) getItem(position), false, 2, (Object) null);
    }

    public final void setLayoutType(boolean compact) {
        this.layoutType = compact ? 2 : 0;
        notifyDataSetChanged();
    }
}