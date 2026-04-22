package io.ktor.client.plugins.cookies;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AcceptAllCookiesStorage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", i = {0, 0, 0}, l = {77}, m = "get", n = {"this", "requestUrl", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
public final class AcceptAllCookiesStorage$get$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AcceptAllCookiesStorage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcceptAllCookiesStorage$get$1(AcceptAllCookiesStorage acceptAllCookiesStorage, Continuation<? super AcceptAllCookiesStorage$get$1> continuation) {
        super(continuation);
        this.this$0 = acceptAllCookiesStorage;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.get(null, (Continuation) this);
    }
}