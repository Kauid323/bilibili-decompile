package im.keywordBlocking.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KBPageLoadService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.service.KBPageLoadService", f = "KBPageLoadService.kt", i = {0, 0}, l = {16}, m = "load-IoAF18A$keyword_blocking_debug", n = {"$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-KBPageLoadService$load$2"}, s = {"I$0", "I$1"}, v = 1)
public final class KBPageLoadService$load$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KBPageLoadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KBPageLoadService$load$1(KBPageLoadService kBPageLoadService, Continuation<? super KBPageLoadService$load$1> continuation) {
        super(continuation);
        this.this$0 = kBPageLoadService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m3191loadIoAF18A$keyword_blocking_debug = this.this$0.m3191loadIoAF18A$keyword_blocking_debug((Continuation) this);
        return m3191loadIoAF18A$keyword_blocking_debug == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3191loadIoAF18A$keyword_blocking_debug : Result.box-impl(m3191loadIoAF18A$keyword_blocking_debug);
    }
}