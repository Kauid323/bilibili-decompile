package tv.danmaku.bili.ui.main2.mine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$scrollToAdapterPosition$2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeUserCenterFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$scrollToAdapterPosition$2$2", f = "HomeUserCenterFragment.kt", i = {}, l = {2315, 2324}, m = "emit", n = {}, s = {}, v = 1)
public final class HomeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HomeUserCenterFragment$scrollToAdapterPosition$2.AnonymousClass2<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HomeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1(HomeUserCenterFragment$scrollToAdapterPosition$2.AnonymousClass2<? super T> anonymousClass2, Continuation<? super HomeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass2;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(0, (Continuation) this);
    }
}