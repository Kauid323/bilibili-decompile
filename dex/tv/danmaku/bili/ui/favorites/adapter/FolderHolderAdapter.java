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
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesFolderItemBinding;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;

/* compiled from: FolderListAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B@\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/FolderHolderAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "Ltv/danmaku/bili/ui/favorites/adapter/FolderItemHolder;", "isDefaultFolder", "", "onLongClick", "Lkotlin/Function0;", "", "onFolderItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "item", "<init>", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FolderHolderAdapter extends ListAdapter<FavoritesMediasItem, FolderItemHolder> {
    public static final int $stable = 8;
    private final boolean isDefaultFolder;
    private final Function1<FavoritesMediasItem, Unit> onFolderItemClick;
    private final Function0<Unit> onLongClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FolderHolderAdapter(boolean isDefaultFolder, Function0<Unit> function0, Function1<? super FavoritesMediasItem, Unit> function1) {
        super(new DiffUtil.ItemCallback<FavoritesMediasItem>() { // from class: tv.danmaku.bili.ui.favorites.adapter.FolderHolderAdapter.1
            public boolean areItemsTheSame(FavoritesMediasItem oldItem, FavoritesMediasItem newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }

            public boolean areContentsTheSame(FavoritesMediasItem oldItem, FavoritesMediasItem newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
        Intrinsics.checkNotNullParameter(function0, "onLongClick");
        Intrinsics.checkNotNullParameter(function1, "onFolderItemClick");
        this.isDefaultFolder = isDefaultFolder;
        this.onLongClick = function0;
        this.onFolderItemClick = function1;
    }

    public FolderItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BiliAppItemFavoritesFolderItemBinding inflate = BiliAppItemFavoritesFolderItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new FolderItemHolder(inflate, this.onLongClick, this.onFolderItemClick, this.isDefaultFolder);
    }

    public void onBindViewHolder(FolderItemHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BaseFeedHolder.bindData$default(holder, (BaseFeedItem) getItem(position), false, 2, (Object) null);
    }
}