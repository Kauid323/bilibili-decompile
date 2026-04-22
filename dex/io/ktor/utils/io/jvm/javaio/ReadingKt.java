package io.ktor.utils.io.jvm.javaio;

import com.lynx.tasm.behavior.PropertyIDConstants;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.io.JvmCoreKt;

/* compiled from: Reading.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u0007¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Ljava/io/InputStream;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "Lio/ktor/utils/io/ByteReadChannel;", "toByteReadChannel", "(Ljava/io/InputStream;Lkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/pool/ObjectPool;)Lio/ktor/utils/io/ByteReadChannel;", "", "toByteReadChannelWithArrayPool", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ReadingKt {
    public static /* synthetic */ ByteReadChannel toByteReadChannel$default(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool objectPool, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = (CoroutineContext) Dispatchers.getIO();
        }
        return toByteReadChannel(inputStream, coroutineContext, objectPool);
    }

    public static final ByteReadChannel toByteReadChannel(InputStream $this$toByteReadChannel, CoroutineContext context, ObjectPool<ByteBuffer> objectPool) {
        Intrinsics.checkNotNullParameter($this$toByteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        return new RawSourceChannel(JvmCoreKt.asSource($this$toByteReadChannel), context);
    }

    public static /* synthetic */ ByteReadChannel toByteReadChannelWithArrayPool$default(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool objectPool, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = (CoroutineContext) Dispatchers.getIO();
        }
        if ((i & 2) != 0) {
            objectPool = ByteArrayPoolKt.getByteArrayPool();
        }
        return toByteReadChannelWithArrayPool(inputStream, coroutineContext, objectPool);
    }

    public static final ByteReadChannel toByteReadChannelWithArrayPool(InputStream $this$toByteReadChannel, CoroutineContext context, ObjectPool<byte[]> objectPool) {
        Intrinsics.checkNotNullParameter($this$toByteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        return new RawSourceChannel(JvmCoreKt.asSource($this$toByteReadChannel), context);
    }
}