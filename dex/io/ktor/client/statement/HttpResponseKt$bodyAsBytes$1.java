package io.ktor.client.statement;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpResponse.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", i = {}, l = {TbsListener.ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED}, m = "bodyAsBytes", n = {}, s = {})
public final class HttpResponseKt$bodyAsBytes$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpResponseKt$bodyAsBytes$1(Continuation<? super HttpResponseKt$bodyAsBytes$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpResponseKt.bodyAsBytes(null, (Continuation) this);
    }
}