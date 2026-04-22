package im.contact.service;

import host.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContactLoadService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.service.ContactLoadService", f = "ContactLoadService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {R.styleable.CameraView_cameraVideoSizeMaxWidth}, m = "load-0E7RQCE$contact_debug", n = {"tab", "paging", "$this$iv", "request$iv", "$completion$iv", "reqSerializer$iv", "respSerializer$iv", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-ContactLoadService$load$2", "$i$f$contacts", "$i$f$suspendCall", "$i$f$suspendCancellableCoroutine"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
public final class ContactLoadService$load$1 extends ContinuationImpl {
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
    final /* synthetic */ ContactLoadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactLoadService$load$1(ContactLoadService contactLoadService, Continuation<? super ContactLoadService$load$1> continuation) {
        super(continuation);
        this.this$0 = contactLoadService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m3160load0E7RQCE$contact_debug = this.this$0.m3160load0E7RQCE$contact_debug(null, null, (Continuation) this);
        return m3160load0E7RQCE$contact_debug == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3160load0E7RQCE$contact_debug : Result.box-impl(m3160load0E7RQCE$contact_debug);
    }
}