package io.ktor.client.statement;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpResponse.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", i = {0}, l = {TbsListener.ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED}, m = "bodyAsText", n = {"decoder"}, s = {"L$0"})
public final class HttpResponseKt$bodyAsText$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpResponseKt$bodyAsText$1(Continuation<? super HttpResponseKt$bodyAsText$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpResponseKt.bodyAsText(null, null, (Continuation) this);
    }
}