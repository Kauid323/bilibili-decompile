package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: Encoders.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\tJ!\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/ktor/util/Encoder;", "", "Lio/ktor/utils/io/ByteReadChannel;", "source", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "encode", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteWriteChannel;", "decode", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Encoder {
    ByteReadChannel decode(ByteReadChannel byteReadChannel, CoroutineContext coroutineContext);

    ByteReadChannel encode(ByteReadChannel byteReadChannel, CoroutineContext coroutineContext);

    ByteWriteChannel encode(ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext);

    /* compiled from: Encoders.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f/20260223061335dd3f5dbf-8baa-4d79-ac48-6db2fcfbbf6f.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ ByteReadChannel encode$default(Encoder encoder, ByteReadChannel byteReadChannel, CoroutineContext coroutineContext, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    coroutineContext = (CoroutineContext) EmptyCoroutineContext.INSTANCE;
                }
                return encoder.encode(byteReadChannel, coroutineContext);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
        }

        public static /* synthetic */ ByteWriteChannel encode$default(Encoder encoder, ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    coroutineContext = (CoroutineContext) EmptyCoroutineContext.INSTANCE;
                }
                return encoder.encode(byteWriteChannel, coroutineContext);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
        }

        public static /* synthetic */ ByteReadChannel decode$default(Encoder encoder, ByteReadChannel byteReadChannel, CoroutineContext coroutineContext, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    coroutineContext = (CoroutineContext) EmptyCoroutineContext.INSTANCE;
                }
                return encoder.decode(byteReadChannel, coroutineContext);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
    }
}