package im.keywordBlocking.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KBOperationService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.service.KBOperationService", f = "KBOperationService.kt", i = {0, 0, 0}, l = {19}, m = "addItem-gIAlu-s$keyword_blocking_debug", n = {"text", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-KBOperationService$addItem$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
public final class KBOperationService$addItem$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KBOperationService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KBOperationService$addItem$1(KBOperationService kBOperationService, Continuation<? super KBOperationService$addItem$1> continuation) {
        super(continuation);
        this.this$0 = kBOperationService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m3188addItemgIAlus$keyword_blocking_debug = this.this$0.m3188addItemgIAlus$keyword_blocking_debug(null, (Continuation) this);
        return m3188addItemgIAlus$keyword_blocking_debug == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3188addItemgIAlus$keyword_blocking_debug : Result.box-impl(m3188addItemgIAlus$keyword_blocking_debug);
    }
}