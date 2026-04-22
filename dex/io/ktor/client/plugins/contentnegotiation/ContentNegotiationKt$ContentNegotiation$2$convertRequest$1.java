package io.ktor.client.plugins.contentnegotiation;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentNegotiation.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt", f = "ContentNegotiation.kt", i = {0, 0, 0, 0, 0}, l = {184}, m = "ContentNegotiation$lambda$13$convertRequest", n = {SocialConstants.TYPE_REQUEST, "body", "contentType", "matchingRegistrations", "registration"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5"})
public final class ContentNegotiationKt$ContentNegotiation$2$convertRequest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentNegotiationKt$ContentNegotiation$2$convertRequest$1(Continuation<? super ContentNegotiationKt$ContentNegotiation$2$convertRequest$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object ContentNegotiation$lambda$13$convertRequest;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        ContentNegotiation$lambda$13$convertRequest = ContentNegotiationKt.ContentNegotiation$lambda$13$convertRequest(null, null, null, null, null, (Continuation) this);
        return ContentNegotiation$lambda$13$convertRequest;
    }
}