package tv.danmaku.bili.ui.favorites.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesEditListViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel", f = "FavoritesEditListViewModel.kt", i = {}, l = {BR.headerCover}, m = "sortMedias", n = {}, s = {}, v = 1)
public final class FavoritesEditListViewModel$sortMedias$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FavoritesEditListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesEditListViewModel$sortMedias$1(FavoritesEditListViewModel favoritesEditListViewModel, Continuation<? super FavoritesEditListViewModel$sortMedias$1> continuation) {
        super(continuation);
        this.this$0 = favoritesEditListViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object sortMedias;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        sortMedias = this.this$0.sortMedias(null, (Continuation) this);
        return sortMedias;
    }
}