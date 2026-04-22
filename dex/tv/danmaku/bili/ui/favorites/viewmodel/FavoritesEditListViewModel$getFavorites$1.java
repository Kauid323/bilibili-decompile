package tv.danmaku.bili.ui.favorites.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListDataPacker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesEditListViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesEditListViewModel", f = "FavoritesEditListViewModel.kt", i = {0, 0, 1, 1, 1, 1, 2, 2}, l = {BR.button, BR.chatPlayerInputHint, BR.countdownTip}, m = "getFavorites", n = {"firstLoad", HotListDataPacker.METHOD_REFRESH, "$this$suspendThen$iv", "res", "firstLoad", HotListDataPacker.METHOD_REFRESH, "$this$suspendThen$iv", "firstLoad"}, s = {"Z$0", "Z$1", "L$0", "L$1", "Z$0", "Z$1", "L$0", "Z$0"}, v = 1)
public final class FavoritesEditListViewModel$getFavorites$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FavoritesEditListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesEditListViewModel$getFavorites$1(FavoritesEditListViewModel favoritesEditListViewModel, Continuation<? super FavoritesEditListViewModel$getFavorites$1> continuation) {
        super(continuation);
        this.this$0 = favoritesEditListViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object favorites;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        favorites = this.this$0.getFavorites(false, false, (Continuation) this);
        return favorites;
    }
}