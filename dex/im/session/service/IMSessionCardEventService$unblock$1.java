package im.session.service;

import com.unionpay.tsmservice.mini.data.Constant;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionCardEventService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionCardEventService", f = "IMSessionCardEventService.kt", i = {0, 0, 0}, l = {Constant.JAR_VERSION_CODE}, m = "unblock-gIAlu-s", n = {"session", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMSessionCardEventService$unblock$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
public final class IMSessionCardEventService$unblock$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionCardEventService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionCardEventService$unblock$1(IMSessionCardEventService iMSessionCardEventService, Continuation<? super IMSessionCardEventService$unblock$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionCardEventService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m3354unblockgIAlus = this.this$0.m3354unblockgIAlus(null, (Continuation) this);
        return m3354unblockgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3354unblockgIAlus : Result.box-impl(m3354unblockgIAlus);
    }
}