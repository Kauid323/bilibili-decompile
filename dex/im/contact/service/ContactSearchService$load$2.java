package im.contact.service;

import com.yalantis.ucrop.UCrop;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContactSearchService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.service.ContactSearchService", f = "ContactSearchService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {UCrop.RESULT_ERROR}, m = "load-gIAlu-s", n = {"params", "$this$iv", "request$iv", "$completion$iv", "reqSerializer$iv", "respSerializer$iv", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-ContactSearchService$load$3", "$i$f$contactsSearch", "$i$f$suspendCall", "$i$f$suspendCancellableCoroutine"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
public final class ContactSearchService$load$2 extends ContinuationImpl {
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
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ContactSearchService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSearchService$load$2(ContactSearchService contactSearchService, Continuation<? super ContactSearchService$load$2> continuation) {
        super(continuation);
        this.this$0 = contactSearchService;
    }

    public final Object invokeSuspend(Object obj) {
        Object m3163loadgIAlus;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m3163loadgIAlus = this.this$0.m3163loadgIAlus(null, (Continuation) this);
        return m3163loadgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3163loadgIAlus : Result.box-impl(m3163loadgIAlus);
    }
}