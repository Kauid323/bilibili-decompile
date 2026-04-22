package tv.danmaku.bili.ui.main2.mine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeUserCenterFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment", f = "HomeUserCenterFragment.kt", i = {0}, l = {2375}, m = "showTribeeRevisitPop", n = {"tribeeRevisitPop"}, s = {"L$0"}, v = 1)
public final class HomeUserCenterFragment$showTribeeRevisitPop$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HomeUserCenterFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeUserCenterFragment$showTribeeRevisitPop$1(HomeUserCenterFragment homeUserCenterFragment, Continuation<? super HomeUserCenterFragment$showTribeeRevisitPop$1> continuation) {
        super(continuation);
        this.this$0 = homeUserCenterFragment;
    }

    public final Object invokeSuspend(Object obj) {
        Object showTribeeRevisitPop;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        showTribeeRevisitPop = this.this$0.showTribeeRevisitPop(null, false, (Continuation) this);
        return showTribeeRevisitPop;
    }
}