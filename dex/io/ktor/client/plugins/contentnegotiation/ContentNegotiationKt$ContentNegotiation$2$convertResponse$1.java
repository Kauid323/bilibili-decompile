package io.ktor.client.plugins.contentnegotiation;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentNegotiation.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt", f = "ContentNegotiation.kt", i = {0}, l = {TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS}, m = "ContentNegotiation$lambda$13$convertResponse", n = {"requestUrl"}, s = {"L$0"})
public final class ContentNegotiationKt$ContentNegotiation$2$convertResponse$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentNegotiationKt$ContentNegotiation$2$convertResponse$1(Continuation<? super ContentNegotiationKt$ContentNegotiation$2$convertResponse$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object ContentNegotiation$lambda$13$convertResponse;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        ContentNegotiation$lambda$13$convertResponse = ContentNegotiationKt.ContentNegotiation$lambda$13$convertResponse(null, null, null, null, null, null, null, null, (Continuation) this);
        return ContentNegotiation$lambda$13$convertResponse;
    }
}