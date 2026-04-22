package im.session.service;

import com.tencent.smtt.sdk.TbsListener;
import host.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionUpdateService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionUpdateService", f = "IMSessionUpdateService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {TbsListener.ErrorCode.NONEEDTODOWN_ERROR, R.styleable.CameraView_cameraVideoCodec}, m = "update-gIAlu-s", n = {"param", "req", "$this$iv", "request$iv", "$completion$iv", "reqSerializer$iv", "respSerializer$iv", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMSessionUpdateService$update$2", "$i$f$sessionListUpdate", "$i$f$suspendCall", "$i$f$suspendCancellableCoroutine", "param", "req", "resp", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMSessionUpdateService$update$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
public final class IMSessionUpdateService$update$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionUpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionUpdateService$update$1(IMSessionUpdateService iMSessionUpdateService, Continuation<? super IMSessionUpdateService$update$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionUpdateService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m3367updategIAlus = this.this$0.m3367updategIAlus(null, (Continuation) this);
        return m3367updategIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3367updategIAlus : Result.box-impl(m3367updategIAlus);
    }
}