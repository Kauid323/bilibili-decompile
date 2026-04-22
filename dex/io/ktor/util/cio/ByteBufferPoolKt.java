package io.ktor.util.cio;

import io.ktor.utils.io.pool.ByteBufferPool;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;

/* compiled from: ByteBufferPool.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0014\u0010\u0001\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0003\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "DEFAULT_BUFFER_SIZE", "I", "DEFAULT_KTOR_POOL_SIZE", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "KtorDefaultPool", "Lio/ktor/utils/io/pool/ObjectPool;", "getKtorDefaultPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ByteBufferPoolKt {
    public static final int DEFAULT_KTOR_POOL_SIZE = 2048;
    public static final int DEFAULT_BUFFER_SIZE = 4098;
    private static final ObjectPool<ByteBuffer> KtorDefaultPool = new ByteBufferPool<>((int) DEFAULT_KTOR_POOL_SIZE, (int) DEFAULT_BUFFER_SIZE);

    public static final ObjectPool<ByteBuffer> getKtorDefaultPool() {
        return KtorDefaultPool;
    }
}