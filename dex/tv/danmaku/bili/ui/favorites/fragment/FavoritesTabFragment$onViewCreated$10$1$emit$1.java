package tv.danmaku.bili.ui.favorites.fragment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$onViewCreated$10;
import tv.danmaku.bili.ui.favorites.state.FavoritesEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesTabFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$onViewCreated$10$1", f = "FavoritesTabFragment.kt", i = {}, l = {BR.leftMargin, BR.newBadgeVisible}, m = "emit", n = {}, s = {}, v = 1)
public final class FavoritesTabFragment$onViewCreated$10$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FavoritesTabFragment$onViewCreated$10.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FavoritesTabFragment$onViewCreated$10$1$emit$1(FavoritesTabFragment$onViewCreated$10.AnonymousClass1<? super T> anonymousClass1, Continuation<? super FavoritesTabFragment$onViewCreated$10$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((FavoritesEvent) null, (Continuation) this);
    }
}