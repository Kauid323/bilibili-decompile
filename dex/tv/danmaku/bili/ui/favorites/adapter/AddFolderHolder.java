package tv.danmaku.bili.ui.favorites.adapter;

import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppItemFavoritesAddFolderBinding;
import tv.danmaku.bili.ui.favorites.card.BaseFavoritesHolder;
import tv.danmaku.bili.ui.favorites.model.FavoritesFolderItem;

/* compiled from: FolderListAdapter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\u0007H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/favorites/adapter/AddFolderHolder;", "Ltv/danmaku/bili/ui/favorites/card/BaseFavoritesHolder;", "Ltv/danmaku/bili/ui/favorites/model/FavoritesFolderItem;", "binding", "Ltv/danmaku/bili/databinding/BiliAppItemFavoritesAddFolderBinding;", "onAddFolderClick", "Lkotlin/Function0;", "", "<init>", "(Ltv/danmaku/bili/databinding/BiliAppItemFavoritesAddFolderBinding;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppItemFavoritesAddFolderBinding;", "bind", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AddFolderHolder extends BaseFavoritesHolder<FavoritesFolderItem> {
    public static final int $stable = 8;
    private final BiliAppItemFavoritesAddFolderBinding binding;
    private final Function0<Unit> onAddFolderClick;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AddFolderHolder(BiliAppItemFavoritesAddFolderBinding binding, Function0<Unit> function0) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(function0, "onAddFolderClick");
        FrameLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = binding;
        this.onAddFolderClick = function0;
    }

    public final BiliAppItemFavoritesAddFolderBinding getBinding() {
        return this.binding;
    }

    protected void bind() {
        this.binding.container.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.adapter.AddFolderHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddFolderHolder.bind$lambda$0(AddFolderHolder.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0(AddFolderHolder this$0, View it) {
        this$0.onAddFolderClick.invoke();
    }
}