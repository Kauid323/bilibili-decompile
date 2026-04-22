package im.session.service;

import host.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionCardEventService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionCardEventService", f = "IMSessionCardEventService.kt", i = {0, 0, 0, 0}, l = {R.styleable.CameraView_cameraVideoSizeAspectRatio}, m = "pin-gIAlu-s", n = {"session", "req", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMSessionCardEventService$pin$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
public final class IMSessionCardEventService$pin$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionCardEventService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionCardEventService$pin$1(IMSessionCardEventService iMSessionCardEventService, Continuation<? super IMSessionCardEventService$pin$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionCardEventService;
    }

    public final Object invokeSuspend(Object obj) {
        Object m3350pingIAlus;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m3350pingIAlus = this.this$0.m3350pingIAlus(null, (Continuation) this);
        return m3350pingIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3350pingIAlus : Result.box-impl(m3350pingIAlus);
    }
}