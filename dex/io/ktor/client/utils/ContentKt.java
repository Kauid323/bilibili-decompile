package io.ktor.client.utils;

import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlinx.coroutines.Job;

/* compiled from: Content.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", "Lkotlin/Function1;", "Lio/ktor/http/Headers;", "block", "wrapHeaders", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/jvm/functions/Function1;)Lio/ktor/http/content/OutgoingContent;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContentKt {
    public static final OutgoingContent wrapHeaders(final OutgoingContent $this$wrapHeaders, final Function1<? super Headers, ? extends Headers> function1) {
        Intrinsics.checkNotNullParameter($this$wrapHeaders, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if ($this$wrapHeaders instanceof OutgoingContent.NoContent) {
            return new OutgoingContent.NoContent(function1, $this$wrapHeaders) { // from class: io.ktor.client.utils.ContentKt$wrapHeaders$1
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$this_wrapHeaders = $this$wrapHeaders;
                    this.headers = (Headers) function1.invoke($this$wrapHeaders.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public HttpStatusCode getStatus() {
                    return this.$this_wrapHeaders.getStatus();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }
            };
        }
        if ($this$wrapHeaders instanceof OutgoingContent.ReadChannelContent) {
            return new OutgoingContent.ReadChannelContent(function1, $this$wrapHeaders) { // from class: io.ktor.client.utils.ContentKt$wrapHeaders$2
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$this_wrapHeaders = $this$wrapHeaders;
                    this.headers = (Headers) function1.invoke($this$wrapHeaders.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public HttpStatusCode getStatus() {
                    return this.$this_wrapHeaders.getStatus();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                public ByteReadChannel readFrom() {
                    return ((OutgoingContent.ReadChannelContent) this.$this_wrapHeaders).readFrom();
                }

                @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                public ByteReadChannel readFrom(LongRange range) {
                    Intrinsics.checkNotNullParameter(range, "range");
                    return ((OutgoingContent.ReadChannelContent) this.$this_wrapHeaders).readFrom(range);
                }
            };
        }
        if ($this$wrapHeaders instanceof OutgoingContent.WriteChannelContent) {
            return new OutgoingContent.WriteChannelContent(function1, $this$wrapHeaders) { // from class: io.ktor.client.utils.ContentKt$wrapHeaders$3
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$this_wrapHeaders = $this$wrapHeaders;
                    this.headers = (Headers) function1.invoke($this$wrapHeaders.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public HttpStatusCode getStatus() {
                    return this.$this_wrapHeaders.getStatus();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
                public Object writeTo(ByteWriteChannel channel, Continuation<? super Unit> continuation) {
                    Object writeTo = ((OutgoingContent.WriteChannelContent) this.$this_wrapHeaders).writeTo(channel, continuation);
                    return writeTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeTo : Unit.INSTANCE;
                }
            };
        }
        if ($this$wrapHeaders instanceof OutgoingContent.ByteArrayContent) {
            return new OutgoingContent.ByteArrayContent(function1, $this$wrapHeaders) { // from class: io.ktor.client.utils.ContentKt$wrapHeaders$4
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$this_wrapHeaders = $this$wrapHeaders;
                    this.headers = (Headers) function1.invoke($this$wrapHeaders.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public HttpStatusCode getStatus() {
                    return this.$this_wrapHeaders.getStatus();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
                public byte[] bytes() {
                    return ((OutgoingContent.ByteArrayContent) this.$this_wrapHeaders).bytes();
                }
            };
        }
        if ($this$wrapHeaders instanceof OutgoingContent.ProtocolUpgrade) {
            return new OutgoingContent.ProtocolUpgrade(function1, $this$wrapHeaders) { // from class: io.ktor.client.utils.ContentKt$wrapHeaders$5
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$this_wrapHeaders = $this$wrapHeaders;
                    this.headers = (Headers) function1.invoke($this$wrapHeaders.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.http.content.OutgoingContent.ProtocolUpgrade
                public Object upgrade(ByteReadChannel input, ByteWriteChannel output, CoroutineContext engineContext, CoroutineContext userContext, Continuation<? super Job> continuation) {
                    return ((OutgoingContent.ProtocolUpgrade) this.$this_wrapHeaders).upgrade(input, output, engineContext, userContext, continuation);
                }
            };
        }
        if ($this$wrapHeaders instanceof OutgoingContent.ContentWrapper) {
            return wrapHeaders(((OutgoingContent.ContentWrapper) $this$wrapHeaders).delegate(), function1);
        }
        throw new NoWhenBranchMatchedException();
    }
}