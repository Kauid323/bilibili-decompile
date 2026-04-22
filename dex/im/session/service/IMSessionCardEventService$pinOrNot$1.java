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
@DebugMetadata(c = "im.session.service.IMSessionCardEventService", f = "IMSessionCardEventService.kt", i = {0, 1}, l = {37, 39}, m = "pinOrNot-gIAlu-s", n = {"session", "session"}, s = {"L$0", "L$0"}, v = 1)
public final class IMSessionCardEventService$pinOrNot$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionCardEventService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionCardEventService$pinOrNot$1(IMSessionCardEventService iMSessionCardEventService, Continuation<? super IMSessionCardEventService$pinOrNot$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionCardEventService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m3353pinOrNotgIAlus = this.this$0.m3353pinOrNotgIAlus(null, (Continuation) this);
        return m3353pinOrNotgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3353pinOrNotgIAlus : Result.box-impl(m3353pinOrNotgIAlus);
    }
}