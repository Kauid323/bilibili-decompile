package io.ktor.client.plugins.sse;

import com.tencent.open.SocialConstants;
import faceverify.q;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.SSEClientResponseAdapter;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SSE.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lio/ktor/http/content/OutgoingContent;", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/request/HttpRequestBuilder;", q.KEY_RES_9_CONTENT}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.SSEKt$SSE$2$1", f = "SSE.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SSEKt$SSE$2$1 extends SuspendLambda implements Function3<HttpRequestBuilder, OutgoingContent, Continuation<? super OutgoingContent>, Object> {
    final /* synthetic */ long $reconnectionTime;
    final /* synthetic */ boolean $showCommentEvents;
    final /* synthetic */ boolean $showRetryEvents;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSEKt$SSE$2$1(long j, boolean z, boolean z2, Continuation<? super SSEKt$SSE$2$1> continuation) {
        super(3, continuation);
        this.$reconnectionTime = j;
        this.$showCommentEvents = z;
        this.$showRetryEvents = z2;
    }

    public final Object invoke(HttpRequestBuilder httpRequestBuilder, OutgoingContent outgoingContent, Continuation<? super OutgoingContent> continuation) {
        SSEKt$SSE$2$1 sSEKt$SSE$2$1 = new SSEKt$SSE$2$1(this.$reconnectionTime, this.$showCommentEvents, this.$showRetryEvents, continuation);
        sSEKt$SSE$2$1.L$0 = httpRequestBuilder;
        sSEKt$SSE$2$1.L$1 = outgoingContent;
        return sSEKt$SSE$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object attributeValue;
        Object attributeValue2;
        Object attributeValue3;
        Object attributeValue4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                HttpRequestBuilder request = (HttpRequestBuilder) this.L$0;
                OutgoingContent content = (OutgoingContent) this.L$1;
                attributeValue = SSEKt.getAttributeValue(request, BuildersKt.getSseRequestAttr());
                if (!Intrinsics.areEqual(attributeValue, Boxing.boxBoolean(true))) {
                    return content;
                }
                SSEKt.getLOGGER().trace("Sending SSE request " + request.getUrl());
                request.setCapability(SSECapability.INSTANCE, Unit.INSTANCE);
                attributeValue2 = SSEKt.getAttributeValue(request, BuildersKt.getReconnectionTimeAttr());
                Duration localReconnectionTime = (Duration) attributeValue2;
                attributeValue3 = SSEKt.getAttributeValue(request, BuildersKt.getShowCommentEventsAttr());
                Boolean localShowCommentEvents = (Boolean) attributeValue3;
                attributeValue4 = SSEKt.getAttributeValue(request, BuildersKt.getShowRetryEventsAttr());
                Boolean localShowRetryEvents = (Boolean) attributeValue4;
                request.getAttributes().put(HttpRequestKt.getResponseAdapterAttributeKey(), new SSEClientResponseAdapter());
                ContentType it = content.getContentType();
                if (it != null) {
                    HttpMessagePropertiesKt.contentType(request, it);
                }
                return new SSEClientContent(localReconnectionTime != null ? localReconnectionTime.unbox-impl() : this.$reconnectionTime, localShowCommentEvents != null ? localShowCommentEvents.booleanValue() : this.$showCommentEvents, localShowRetryEvents != null ? localShowRetryEvents.booleanValue() : this.$showRetryEvents, content, null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}