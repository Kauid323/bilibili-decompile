package io.ktor.http.content;

import faceverify.q;
import io.grpc.internal.GrpcUtil;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* compiled from: OutgoingContent.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006!\"#$%&B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000fR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 \u0082\u0001\u0006'()*+,¨\u0006-"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", "", "<init>", "()V", "T", "Lio/ktor/util/AttributeKey;", q.KEY_RES_9_KEY, "getProperty", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "value", "", "setProperty", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "Lio/ktor/http/Headers;", GrpcUtil.TE_TRAILERS, "()Lio/ktor/http/Headers;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "getHeaders", "headers", "Lio/ktor/util/Attributes;", "extensionProperties", "Lio/ktor/util/Attributes;", "NoContent", "ReadChannelContent", "WriteChannelContent", "ByteArrayContent", "ProtocolUpgrade", "ContentWrapper", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "Lio/ktor/http/content/OutgoingContent$ContentWrapper;", "Lio/ktor/http/content/OutgoingContent$NoContent;", "Lio/ktor/http/content/OutgoingContent$ProtocolUpgrade;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class OutgoingContent {
    private Attributes extensionProperties;

    public /* synthetic */ OutgoingContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OutgoingContent() {
    }

    public ContentType getContentType() {
        return null;
    }

    public Long getContentLength() {
        return null;
    }

    public HttpStatusCode getStatus() {
        return null;
    }

    public Headers getHeaders() {
        return Headers.Companion.getEmpty();
    }

    public <T> T getProperty(AttributeKey<T> attributeKey) {
        Intrinsics.checkNotNullParameter(attributeKey, q.KEY_RES_9_KEY);
        Attributes attributes = this.extensionProperties;
        if (attributes != null) {
            return (T) attributes.getOrNull(attributeKey);
        }
        return null;
    }

    public <T> void setProperty(AttributeKey<T> attributeKey, T t) {
        Intrinsics.checkNotNullParameter(attributeKey, q.KEY_RES_9_KEY);
        if (t == null && this.extensionProperties == null) {
            return;
        }
        if (t == null) {
            Attributes attributes = this.extensionProperties;
            if (attributes != null) {
                attributes.remove(attributeKey);
                return;
            }
            return;
        }
        Attributes attributes2 = this.extensionProperties;
        if (attributes2 == null) {
            attributes2 = AttributesJvmKt.Attributes$default(false, 1, (Object) null);
        }
        Attributes it = attributes2;
        this.extensionProperties = it;
        attributes2.put(attributeKey, t);
    }

    public Headers trailers() {
        return null;
    }

    /* compiled from: OutgoingContent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/http/content/OutgoingContent$NoContent;", "Lio/ktor/http/content/OutgoingContent;", "<init>", "()V", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class NoContent extends OutgoingContent {
        public NoContent() {
            super(null);
        }
    }

    /* compiled from: OutgoingContent.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/http/content/OutgoingContent;", "<init>", "()V", "Lio/ktor/utils/io/ByteReadChannel;", "readFrom", "()Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/ranges/LongRange;", "range", "(Lkotlin/ranges/LongRange;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class ReadChannelContent extends OutgoingContent {
        public abstract ByteReadChannel readFrom();

        public ReadChannelContent() {
            super(null);
        }

        public ByteReadChannel readFrom(LongRange range) {
            Intrinsics.checkNotNullParameter(range, "range");
            if (range.isEmpty()) {
                return ByteReadChannel.Companion.getEmpty();
            }
            return ByteWriteChannelOperationsKt.writer(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), true, new OutgoingContent$ReadChannelContent$readFrom$1(this, range, null)).getChannel();
        }
    }

    /* compiled from: OutgoingContent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "Lio/ktor/http/content/OutgoingContent;", "<init>", "()V", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", "writeTo", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class WriteChannelContent extends OutgoingContent {
        public abstract Object writeTo(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation);

        public WriteChannelContent() {
            super(null);
        }
    }

    /* compiled from: OutgoingContent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "Lio/ktor/http/content/OutgoingContent;", "<init>", "()V", "", "bytes", "()[B", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class ByteArrayContent extends OutgoingContent {
        public abstract byte[] bytes();

        public ByteArrayContent() {
            super(null);
        }
    }

    /* compiled from: OutgoingContent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH¦@¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lio/ktor/http/content/OutgoingContent$ProtocolUpgrade;", "Lio/ktor/http/content/OutgoingContent;", "<init>", "()V", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "Lkotlin/coroutines/CoroutineContext;", "engineContext", "userContext", "Lkotlinx/coroutines/Job;", "upgrade", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class ProtocolUpgrade extends OutgoingContent {
        public abstract Object upgrade(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, Continuation<? super Job> continuation);

        public ProtocolUpgrade() {
            super(null);
        }

        @Override // io.ktor.http.content.OutgoingContent
        public final HttpStatusCode getStatus() {
            return HttpStatusCode.Companion.getSwitchingProtocols();
        }
    }

    /* compiled from: OutgoingContent.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\t\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\u0006*\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H&¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lio/ktor/http/content/OutgoingContent$ContentWrapper;", "Lio/ktor/http/content/OutgoingContent;", "delegate", "<init>", "(Lio/ktor/http/content/OutgoingContent;)V", "", "T", "Lio/ktor/util/AttributeKey;", q.KEY_RES_9_KEY, "getProperty", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "value", "", "setProperty", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "()Lio/ktor/http/content/OutgoingContent;", "copy", "(Lio/ktor/http/content/OutgoingContent;)Lio/ktor/http/content/OutgoingContent$ContentWrapper;", "Lio/ktor/http/content/OutgoingContent;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "headers", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class ContentWrapper extends OutgoingContent {
        private final OutgoingContent delegate;

        public abstract ContentWrapper copy(OutgoingContent outgoingContent);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContentWrapper(OutgoingContent delegate) {
            super(null);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.delegate = delegate;
        }

        @Override // io.ktor.http.content.OutgoingContent
        public ContentType getContentType() {
            return this.delegate.getContentType();
        }

        @Override // io.ktor.http.content.OutgoingContent
        public Long getContentLength() {
            return this.delegate.getContentLength();
        }

        @Override // io.ktor.http.content.OutgoingContent
        public HttpStatusCode getStatus() {
            return this.delegate.getStatus();
        }

        @Override // io.ktor.http.content.OutgoingContent
        public Headers getHeaders() {
            return this.delegate.getHeaders();
        }

        @Override // io.ktor.http.content.OutgoingContent
        public <T> T getProperty(AttributeKey<T> attributeKey) {
            Intrinsics.checkNotNullParameter(attributeKey, q.KEY_RES_9_KEY);
            return (T) this.delegate.getProperty(attributeKey);
        }

        @Override // io.ktor.http.content.OutgoingContent
        public <T> void setProperty(AttributeKey<T> attributeKey, T t) {
            Intrinsics.checkNotNullParameter(attributeKey, q.KEY_RES_9_KEY);
            this.delegate.setProperty(attributeKey, t);
        }

        public final OutgoingContent delegate() {
            return this.delegate;
        }
    }
}