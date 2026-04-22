package io.ktor.util;

import io.ktor.util.ContentEncoder;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentEncodersJvm.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\b\u000b\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\b\u000b\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/util/DeflateEncoder;", "Lio/ktor/util/ContentEncoder;", "Lio/ktor/util/Encoder;", "<init>", "()V", "Lio/ktor/utils/io/ByteReadChannel;", "source", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "decode", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "encode", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteWriteChannel;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeflateEncoder implements ContentEncoder, Encoder {
    public static final DeflateEncoder INSTANCE = new DeflateEncoder();
    private static final String name = "deflate";
    private final /* synthetic */ Encoder $$delegate_0 = EncodersJvmKt.getDeflate();

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

    private DeflateEncoder() {
    }

    @Override // io.ktor.util.ContentEncoder
    public Long predictCompressedLength(long contentLength) {
        return ContentEncoder.DefaultImpls.predictCompressedLength(this, contentLength);
    }

    @Override // io.ktor.util.ContentEncoder
    public String getName() {
        return name;
    }
}