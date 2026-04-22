package tv.danmaku.bili.ui.main2.resource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainFragmentOperator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.resource.MainFragmentService", f = "MainFragmentOperator.kt", i = {}, l = {BR.bannerItemDataList}, m = "forceUpdateBottomNav", n = {}, s = {}, v = 1)
public final class MainFragmentService$forceUpdateBottomNav$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MainFragmentService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainFragmentService$forceUpdateBottomNav$1(MainFragmentService mainFragmentService, Continuation<? super MainFragmentService$forceUpdateBottomNav$1> continuation) {
        super(continuation);
        this.this$0 = mainFragmentService;
    }

    public final Object invokeSuspend(Object obj) {
        Object forceUpdateBottomNav;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        forceUpdateBottomNav = this.this$0.forceUpdateBottomNav((Continuation) this);
        return forceUpdateBottomNav;
    }
}