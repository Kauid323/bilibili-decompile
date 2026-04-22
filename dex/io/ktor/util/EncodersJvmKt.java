package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperations_jvmKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.Checksum;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;

/* compiled from: EncodersJvm.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0082\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u001a)\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a,\u0010\u0013\u001a\u00020\u0000*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001b¨\u0006\u001e"}, d2 = {"", "flag", "", "has", "(II)Z", "Lio/ktor/utils/io/ByteReadChannel;", "source", "gzip", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "inflate", "(Lio/ktor/utils/io/ByteReadChannel;ZLkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "Ljava/util/zip/Inflater;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "Ljava/nio/ByteBuffer;", "buffer", "Ljava/util/zip/Checksum;", "checksum", "inflateTo", "(Ljava/util/zip/Inflater;Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/ByteBuffer;Ljava/util/zip/Checksum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "GZIP_HEADER_SIZE", "I", "Lio/ktor/util/Encoder;", "Deflate", "Lio/ktor/util/Encoder;", "getDeflate", "()Lio/ktor/util/Encoder;", "GZip", "getGZip", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EncodersJvmKt {
    private static final int GZIP_HEADER_SIZE = 10;
    private static final Encoder Deflate = new Encoder() { // from class: io.ktor.util.EncodersJvmKt$Deflate$1
        @Override // io.ktor.util.Encoder
        public ByteReadChannel encode(ByteReadChannel source, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            return DeflaterKt.deflated$default(source, false, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteWriteChannel encode(ByteWriteChannel source, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            return DeflaterKt.deflated$default(source, false, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteReadChannel decode(ByteReadChannel source, CoroutineContext coroutineContext) {
            ByteReadChannel inflate;
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            inflate = EncodersJvmKt.inflate(source, false, coroutineContext);
            return inflate;
        }
    };
    private static final Encoder GZip = new Encoder() { // from class: io.ktor.util.EncodersJvmKt$GZip$1
        @Override // io.ktor.util.Encoder
        public ByteReadChannel encode(ByteReadChannel source, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            return DeflaterKt.deflated$default(source, true, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteWriteChannel encode(ByteWriteChannel source, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            return DeflaterKt.deflated$default(source, true, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteReadChannel decode(ByteReadChannel source, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            return EncodersJvmKt.inflate$default(source, false, coroutineContext, 2, null);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean has(int $this$has, int flag) {
        return ($this$has & flag) != 0;
    }

    public static final Encoder getDeflate() {
        return Deflate;
    }

    public static final Encoder getGZip() {
        return GZip;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ByteReadChannel inflate$default(ByteReadChannel byteReadChannel, boolean z, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return inflate(byteReadChannel, z, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel inflate(ByteReadChannel source, boolean gzip, CoroutineContext coroutineContext) {
        return ByteWriteChannelOperationsKt.writer$default(GlobalScope.INSTANCE, coroutineContext, false, new EncodersJvmKt$inflate$1(gzip, source, null), 2, (Object) null).getChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object inflateTo(Inflater $this$inflateTo, ByteWriteChannel channel, ByteBuffer buffer, Checksum checksum, Continuation<? super Integer> continuation) {
        EncodersJvmKt$inflateTo$1 encodersJvmKt$inflateTo$1;
        int inflated;
        if (continuation instanceof EncodersJvmKt$inflateTo$1) {
            encodersJvmKt$inflateTo$1 = (EncodersJvmKt$inflateTo$1) continuation;
            if ((encodersJvmKt$inflateTo$1.label & Integer.MIN_VALUE) != 0) {
                encodersJvmKt$inflateTo$1.label -= Integer.MIN_VALUE;
                Object $result = encodersJvmKt$inflateTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (encodersJvmKt$inflateTo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        buffer.clear();
                        inflated = $this$inflateTo.inflate(buffer.array(), buffer.position(), buffer.remaining());
                        buffer.position(buffer.position() + inflated);
                        buffer.flip();
                        DeflaterKt.updateKeepPosition(checksum, buffer);
                        encodersJvmKt$inflateTo$1.I$0 = inflated;
                        encodersJvmKt$inflateTo$1.label = 1;
                        if (ByteWriteChannelOperations_jvmKt.writeFully(channel, buffer, encodersJvmKt$inflateTo$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        inflated = encodersJvmKt$inflateTo$1.I$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxInt(inflated);
            }
        }
        encodersJvmKt$inflateTo$1 = new EncodersJvmKt$inflateTo$1(continuation);
        Object $result2 = encodersJvmKt$inflateTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (encodersJvmKt$inflateTo$1.label) {
        }
        return Boxing.boxInt(inflated);
    }
}