package tv.danmaku.bili.ui.main2.mine.modularvip;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MineVipService.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.modularvip.MineVipService", f = "MineVipService.kt", i = {}, l = {BR.btnTryAgainText}, m = "reportRealExposureApi", n = {}, s = {}, v = 1)
public final class MineVipService$reportRealExposureApi$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MineVipService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineVipService$reportRealExposureApi$1(MineVipService mineVipService, Continuation<? super MineVipService$reportRealExposureApi$1> continuation) {
        super(continuation);
        this.this$0 = mineVipService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.reportRealExposureApi(null, 0L, (Continuation) this);
    }
}