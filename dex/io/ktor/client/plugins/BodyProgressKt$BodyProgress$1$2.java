package io.ktor.client.plugins;

import io.ktor.client.content.ProgressListener;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BodyProgress.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.BodyProgressKt$BodyProgress$1$2", f = "BodyProgress.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BodyProgressKt$BodyProgress$1$2 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super HttpResponse>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyProgressKt$BodyProgress$1$2(Continuation<? super BodyProgressKt$BodyProgress$1$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> bodyProgressKt$BodyProgress$1$2 = new BodyProgressKt$BodyProgress$1$2(continuation);
        bodyProgressKt$BodyProgress$1$2.L$0 = obj;
        return bodyProgressKt$BodyProgress$1$2;
    }

    public final Object invoke(HttpResponse httpResponse, Continuation<? super HttpResponse> continuation) {
        return create(httpResponse, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AttributeKey attributeKey;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                HttpResponse response = (HttpResponse) this.L$0;
                Attributes attributes = response.getCall().getRequest().getAttributes();
                attributeKey = BodyProgressKt.DownloadProgressListenerAttributeKey;
                ProgressListener listener = (ProgressListener) attributes.getOrNull(attributeKey);
                if (listener == null) {
                    return null;
                }
                return BodyProgressKt.withObservableDownload(response, listener);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}