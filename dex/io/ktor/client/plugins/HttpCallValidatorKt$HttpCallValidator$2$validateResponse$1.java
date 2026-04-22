package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCallValidator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidatorKt", f = "HttpCallValidator.kt", i = {0}, l = {94}, m = "HttpCallValidator$lambda$2$validateResponse", n = {"response"}, s = {"L$0"})
public final class HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1(Continuation<? super HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object HttpCallValidator$lambda$2$validateResponse;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        HttpCallValidator$lambda$2$validateResponse = HttpCallValidatorKt.HttpCallValidator$lambda$2$validateResponse(null, null, (Continuation) this);
        return HttpCallValidator$lambda$2$validateResponse;
    }
}