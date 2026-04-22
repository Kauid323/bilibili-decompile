package im.session.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionCardEventService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionCardEventService", f = "IMSessionCardEventService.kt", i = {0, 0, 0}, l = {25}, m = "delete-gIAlu-s", n = {"session", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMSessionCardEventService$delete$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
public final class IMSessionCardEventService$delete$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionCardEventService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionCardEventService$delete$1(IMSessionCardEventService iMSessionCardEventService, Continuation<? super IMSessionCardEventService$delete$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionCardEventService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m3352deletegIAlus = this.this$0.m3352deletegIAlus(null, (Continuation) this);
        return m3352deletegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3352deletegIAlus : Result.box-impl(m3352deletegIAlus);
    }
}