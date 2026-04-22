package im.session.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionInteractiveService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionInteractiveService", f = "IMSessionInteractiveService.kt", i = {0, 0}, l = {17}, m = "updateInteractiveUnread-IoAF18A", n = {"$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-IMSessionInteractiveService$updateInteractiveUnread$2"}, s = {"I$0", "I$1"}, v = 1)
public final class IMSessionInteractiveService$updateInteractiveUnread$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSessionInteractiveService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionInteractiveService$updateInteractiveUnread$1(IMSessionInteractiveService iMSessionInteractiveService, Continuation<? super IMSessionInteractiveService$updateInteractiveUnread$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionInteractiveService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m3360updateInteractiveUnreadIoAF18A = this.this$0.m3360updateInteractiveUnreadIoAF18A((Continuation) this);
        return m3360updateInteractiveUnreadIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3360updateInteractiveUnreadIoAF18A : Result.box-impl(m3360updateInteractiveUnreadIoAF18A);
    }
}