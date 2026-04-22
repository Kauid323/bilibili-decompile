package tv.danmaku.bili.ui.favorites.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesEditListViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel", f = "FavoritesEditListViewModel.kt", i = {}, l = {BR.imageHeight}, m = "onDeleteSuccess", n = {}, s = {}, v = 1)
public final class FavoritesEditListViewModel$onDeleteSuccess$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FavoritesEditListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesEditListViewModel$onDeleteSuccess$1(FavoritesEditListViewModel favoritesEditListViewModel, Continuation<? super FavoritesEditListViewModel$onDeleteSuccess$1> continuation) {
        super(continuation);
        this.this$0 = favoritesEditListViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onDeleteSuccess(false, (Continuation) this);
    }
}