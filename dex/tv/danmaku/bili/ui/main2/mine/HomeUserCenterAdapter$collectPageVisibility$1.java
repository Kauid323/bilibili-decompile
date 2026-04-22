package tv.danmaku.bili.ui.main2.mine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeUserCenterAdapter.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterAdapter", f = "HomeUserCenterAdapter.kt", i = {}, l = {BR.backgroundHeaderImageUrl}, m = "collectPageVisibility$core_apinkDebug", n = {}, s = {}, v = 1)
public final class HomeUserCenterAdapter$collectPageVisibility$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HomeUserCenterAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeUserCenterAdapter$collectPageVisibility$1(HomeUserCenterAdapter homeUserCenterAdapter, Continuation<? super HomeUserCenterAdapter$collectPageVisibility$1> continuation) {
        super(continuation);
        this.this$0 = homeUserCenterAdapter;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collectPageVisibility$core_apinkDebug(null, (Continuation) this);
    }
}