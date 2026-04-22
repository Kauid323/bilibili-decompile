package tv.danmaku.bili.ui.favorites.fragment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$onViewCreated$7;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesFolderTabFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$onViewCreated$7$1", f = "FavoritesFolderTabFragment.kt", i = {}, l = {BR.hasStarted}, m = "emit", n = {}, s = {}, v = 1)
public final class FavoritesFolderTabFragment$onViewCreated$7$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FavoritesFolderTabFragment$onViewCreated$7.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FavoritesFolderTabFragment$onViewCreated$7$1$emit$1(FavoritesFolderTabFragment$onViewCreated$7.AnonymousClass1<? super T> anonymousClass1, Continuation<? super FavoritesFolderTabFragment$onViewCreated$7$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((FavoritesPageEvent) null, (Continuation) this);
    }
}