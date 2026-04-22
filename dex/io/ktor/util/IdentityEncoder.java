package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentEncoder.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ \u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u000eJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/util/IdentityEncoder;", "Lio/ktor/util/ContentEncoder;", "Lio/ktor/util/Encoder;", "<init>", "()V", "", "contentLength", "predictCompressedLength", "(J)Ljava/lang/Long;", "Lio/ktor/utils/io/ByteReadChannel;", "source", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "decode", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "encode", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteWriteChannel;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IdentityEncoder implements ContentEncoder, Encoder {
    public static final IdentityEncoder INSTANCE = new IdentityEncoder();
    private static final String name = "identity";
    private final /* synthetic */ Identity $$delegate_0 = Identity.INSTANCE;

    @Override // io.ktor.util.Encoder
    public ByteReadChannel decode(ByteReadChannel byteReadChannel, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "source");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return this.$$delegate_0.decode(byteReadChannel, coroutineContext);
    }

    @Override // io.ktor.util.Encoder
    public ByteReadChannel encode(ByteReadChannel byteReadChannel, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "source");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return this.$$delegate_0.encode(byteReadChannel, coroutineContext);
    }

    @Override // io.ktor.util.Encoder
    public ByteWriteChannel encode(ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "source");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return this.$$delegate_0.encode(byteWriteChannel, coroutineContext);
    }

    private IdentityEncoder() {
    }

    @Override // io.ktor.util.ContentEncoder
    public String getName() {
        return name;
    }

    @Override // io.ktor.util.ContentEncoder
    public Long predictCompressedLength(long contentLength) {
        return Long.valueOf(contentLength);
    }
}