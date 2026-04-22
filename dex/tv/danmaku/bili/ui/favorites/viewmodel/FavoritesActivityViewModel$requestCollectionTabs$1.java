package tv.danmaku.bili.ui.favorites.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesActivityViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel", f = "FavoritesActivityViewModel.kt", i = {}, l = {BR.bgWidth}, m = "requestCollectionTabs", n = {}, s = {}, v = 1)
public final class FavoritesActivityViewModel$requestCollectionTabs$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FavoritesActivityViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesActivityViewModel$requestCollectionTabs$1(FavoritesActivityViewModel favoritesActivityViewModel, Continuation<? super FavoritesActivityViewModel$requestCollectionTabs$1> continuation) {
        super(continuation);
        this.this$0 = favoritesActivityViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object requestCollectionTabs;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        requestCollectionTabs = this.this$0.requestCollectionTabs(0, (Continuation) this);
        return requestCollectionTabs;
    }
}