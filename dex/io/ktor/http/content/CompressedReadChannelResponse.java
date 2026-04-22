package io.ktor.http.content;

import faceverify.q;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.ContentEncoder;
import io.ktor.util.StringValuesBuilder;
import io.ktor.util.StringValuesKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompressedContent.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0010*\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0017\u001a\u00020\u0016\"\b\b\u0000\u0010\u0010*\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u0004\u0018\u00010/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00106\u001a\u0004\u0018\u0001038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lio/ktor/http/content/CompressedReadChannelResponse;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/http/content/OutgoingContent;", "original", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "delegateChannel", "Lio/ktor/util/ContentEncoder;", "encoder", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/jvm/functions/Function0;Lio/ktor/util/ContentEncoder;Lkotlin/coroutines/CoroutineContext;)V", "readFrom", "()Lio/ktor/utils/io/ByteReadChannel;", "", "T", "Lio/ktor/util/AttributeKey;", q.KEY_RES_9_KEY, "getProperty", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "value", "", "setProperty", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "Lio/ktor/http/content/OutgoingContent;", "getOriginal", "()Lio/ktor/http/content/OutgoingContent;", "Lkotlin/jvm/functions/Function0;", "getDelegateChannel", "()Lkotlin/jvm/functions/Function0;", "Lio/ktor/util/ContentEncoder;", "getEncoder", "()Lio/ktor/util/ContentEncoder;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lio/ktor/http/Headers;", "headers$delegate", "Lkotlin/Lazy;", "getHeaders", "()Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CompressedReadChannelResponse extends OutgoingContent.ReadChannelContent {
    private final CoroutineContext coroutineContext;
    private final Function0<ByteReadChannel> delegateChannel;
    private final ContentEncoder encoder;
    private final Lazy headers$delegate;
    private final OutgoingContent original;

    public final OutgoingContent getOriginal() {
        return this.original;
    }

    public final Function0<ByteReadChannel> getDelegateChannel() {
        return this.delegateChannel;
    }

    public final ContentEncoder getEncoder() {
        return this.encoder;
    }

    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public CompressedReadChannelResponse(OutgoingContent original, Function0<? extends ByteReadChannel> function0, ContentEncoder encoder, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(function0, "delegateChannel");
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.original = original;
        this.delegateChannel = function0;
        this.encoder = encoder;
        this.coroutineContext = coroutineContext;
        this.headers$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: io.ktor.http.content.CompressedReadChannelResponse$$ExternalSyntheticLambda0
            public final Object invoke() {
                Headers headers_delegate$lambda$2;
                headers_delegate$lambda$2 = CompressedReadChannelResponse.headers_delegate$lambda$2(CompressedReadChannelResponse.this);
                return headers_delegate$lambda$2;
            }
        });
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel readFrom() {
        return this.encoder.encode((ByteReadChannel) this.delegateChannel.invoke(), this.coroutineContext);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Headers getHeaders() {
        return (Headers) this.headers$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Headers headers_delegate$lambda$2(CompressedReadChannelResponse this$0) {
        Headers.Companion companion = Headers.Companion;
        StringValuesBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        StringValuesKt.appendFiltered$default(headersBuilder, this$0.original.getHeaders(), false, new Function2() { // from class: io.ktor.http.content.CompressedReadChannelResponse$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                boolean headers_delegate$lambda$2$lambda$1$lambda$0;
                headers_delegate$lambda$2$lambda$1$lambda$0 = CompressedReadChannelResponse.headers_delegate$lambda$2$lambda$1$lambda$0((String) obj, (String) obj2);
                return Boolean.valueOf(headers_delegate$lambda$2$lambda$1$lambda$0);
            }
        }, 2, (Object) null);
        headersBuilder.append(HttpHeaders.INSTANCE.getContentEncoding(), this$0.encoder.getName());
        return headersBuilder.m3526build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean headers_delegate$lambda$2$lambda$1$lambda$0(String name, String str) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        return !StringsKt.equals(name, HttpHeaders.INSTANCE.getContentLength(), true);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.original.getContentType();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public HttpStatusCode getStatus() {
        return this.original.getStatus();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        Long contentLength = this.original.getContentLength();
        if (contentLength != null) {
            long it = contentLength.longValue();
            Long predictCompressedLength = this.encoder.predictCompressedLength(it);
            if (predictCompressedLength != null) {
                long it2 = predictCompressedLength.longValue();
                if (it2 >= 0) {
                    return predictCompressedLength;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public <T> T getProperty(AttributeKey<T> attributeKey) {
        Intrinsics.checkNotNullParameter(attributeKey, q.KEY_RES_9_KEY);
        return (T) this.original.getProperty(attributeKey);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public <T> void setProperty(AttributeKey<T> attributeKey, T t) {
        Intrinsics.checkNotNullParameter(attributeKey, q.KEY_RES_9_KEY);
        this.original.setProperty(attributeKey, t);
    }
}