package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import faceverify.q;
import io.ktor.client.content.ObservableContent;
import io.ktor.client.content.ProgressListener;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BodyProgress.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lio/ktor/http/content/OutgoingContent;", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/request/HttpRequestBuilder;", q.KEY_RES_9_CONTENT}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.BodyProgressKt$BodyProgress$1$1", f = "BodyProgress.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BodyProgressKt$BodyProgress$1$1 extends SuspendLambda implements Function3<HttpRequestBuilder, OutgoingContent, Continuation<? super OutgoingContent>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyProgressKt$BodyProgress$1$1(Continuation<? super BodyProgressKt$BodyProgress$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(HttpRequestBuilder httpRequestBuilder, OutgoingContent outgoingContent, Continuation<? super OutgoingContent> continuation) {
        BodyProgressKt$BodyProgress$1$1 bodyProgressKt$BodyProgress$1$1 = new BodyProgressKt$BodyProgress$1$1(continuation);
        bodyProgressKt$BodyProgress$1$1.L$0 = httpRequestBuilder;
        bodyProgressKt$BodyProgress$1$1.L$1 = outgoingContent;
        return bodyProgressKt$BodyProgress$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AttributeKey attributeKey;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                HttpRequestBuilder request = (HttpRequestBuilder) this.L$0;
                OutgoingContent content = (OutgoingContent) this.L$1;
                Attributes attributes = request.getAttributes();
                attributeKey = BodyProgressKt.UploadProgressListenerAttributeKey;
                ProgressListener listener = (ProgressListener) attributes.getOrNull(attributeKey);
                if (listener == null) {
                    return null;
                }
                return new ObservableContent(content, request.getExecutionContext(), listener);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}