package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import org.slf4j.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultTransform.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "body"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1", f = "DefaultTransform.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultTransformKt$defaultTransformers$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultTransformKt$defaultTransformers$1(Continuation<? super DefaultTransformKt$defaultTransformers$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        DefaultTransformKt$defaultTransformers$1 defaultTransformKt$defaultTransformers$1 = new DefaultTransformKt$defaultTransformers$1(continuation);
        defaultTransformKt$defaultTransformers$1.L$0 = pipelineContext;
        defaultTransformKt$defaultTransformers$1.L$1 = obj;
        return defaultTransformKt$defaultTransformers$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OutgoingContent.ReadChannelContent platformRequestDefaultTransform;
        Logger logger;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final PipelineContext $this$intercept = (PipelineContext) this.L$0;
                final Object body = this.L$1;
                if (((HttpRequestBuilder) $this$intercept.getContext()).getHeaders().get(HttpHeaders.INSTANCE.getAccept()) == null) {
                    ((HttpRequestBuilder) $this$intercept.getContext()).getHeaders().append(HttpHeaders.INSTANCE.getAccept(), "*/*");
                }
                final ContentType contentType = HttpMessagePropertiesKt.contentType((HttpMessageBuilder) $this$intercept.getContext());
                if (body instanceof String) {
                    platformRequestDefaultTransform = new TextContent((String) body, contentType == null ? ContentType.Text.INSTANCE.getPlain() : contentType, null, 4, null);
                } else if (body instanceof byte[]) {
                    platformRequestDefaultTransform = new OutgoingContent.ByteArrayContent(contentType, body) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$1
                        final /* synthetic */ Object $body;
                        private final long contentLength;
                        private final ContentType contentType;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.$body = body;
                            this.contentType = contentType == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType;
                            this.contentLength = ((byte[]) body).length;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public ContentType getContentType() {
                            return this.contentType;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public Long getContentLength() {
                            return Long.valueOf(this.contentLength);
                        }

                        @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
                        public byte[] bytes() {
                            return (byte[]) this.$body;
                        }
                    };
                } else if (body instanceof ByteReadChannel) {
                    platformRequestDefaultTransform = new OutgoingContent.ReadChannelContent($this$intercept, contentType, body) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$2
                        final /* synthetic */ Object $body;
                        private final Long contentLength;
                        private final ContentType contentType;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.$body = body;
                            String str = ((HttpRequestBuilder) $this$intercept.getContext()).getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
                            this.contentLength = str != null ? Long.valueOf(Long.parseLong(str)) : null;
                            this.contentType = contentType == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public Long getContentLength() {
                            return this.contentLength;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public ContentType getContentType() {
                            return this.contentType;
                        }

                        @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                        public ByteReadChannel readFrom() {
                            return (ByteReadChannel) this.$body;
                        }
                    };
                } else {
                    platformRequestDefaultTransform = body instanceof OutgoingContent ? (OutgoingContent) body : DefaultTransformersJvmKt.platformRequestDefaultTransform(contentType, (HttpRequestBuilder) $this$intercept.getContext(), body);
                }
                OutgoingContent content = platformRequestDefaultTransform;
                if ((content != null ? content.getContentType() : null) != null) {
                    ((HttpRequestBuilder) $this$intercept.getContext()).getHeaders().remove(HttpHeaders.INSTANCE.getContentType());
                    logger = DefaultTransformKt.LOGGER;
                    logger.trace("Transformed with default transformers request body for " + ((HttpRequestBuilder) $this$intercept.getContext()).getUrl() + " from " + Reflection.getOrCreateKotlinClass(body.getClass()));
                    this.L$0 = null;
                    this.label = 1;
                    if ($this$intercept.proceedWith(content, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}