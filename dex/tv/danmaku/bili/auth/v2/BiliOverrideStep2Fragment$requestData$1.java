package tv.danmaku.bili.auth.v2;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliOverrideStep2Fragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliOverrideStep2Fragment", f = "BiliOverrideStep2Fragment.kt", i = {}, l = {BR.hasImgBadge}, m = "requestData-0E7RQCE", n = {}, s = {}, v = 1)
public final class BiliOverrideStep2Fragment$requestData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BiliOverrideStep2Fragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliOverrideStep2Fragment$requestData$1(BiliOverrideStep2Fragment biliOverrideStep2Fragment, Continuation<? super BiliOverrideStep2Fragment$requestData$1> continuation) {
        super(continuation);
        this.this$0 = biliOverrideStep2Fragment;
    }

    public final Object invokeSuspend(Object obj) {
        Object m732requestData0E7RQCE;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m732requestData0E7RQCE = this.this$0.m732requestData0E7RQCE(null, null, (Continuation) this);
        return m732requestData0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m732requestData0E7RQCE : Result.box-impl(m732requestData0E7RQCE);
    }
}