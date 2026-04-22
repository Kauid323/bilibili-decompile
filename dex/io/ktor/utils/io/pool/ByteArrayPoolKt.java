package io.ktor.utils.io.pool;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.StyleConstants;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import kotlin.Metadata;

/* compiled from: ByteArrayPool.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0003\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "DEFAULT_POOL_ARRAY_SIZE", TextAttributes.INLINE_IMAGE_PLACEHOLDER, "DEFAULT_POOL_CAPACITY", "Lio/ktor/utils/io/pool/ObjectPool;", "", "ByteArrayPool", "Lio/ktor/utils/io/pool/ObjectPool;", "getByteArrayPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteArrayPoolKt {
    private static final ObjectPool<byte[]> ByteArrayPool = new DefaultPool<byte[]>() { // from class: io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.ktor.utils.io.pool.DefaultPool
        public byte[] produceInstance() {
            return new byte[StyleConstants.TRANSFORM_SKEW];
        }
    };
    private static final int DEFAULT_POOL_ARRAY_SIZE = 4096;
    private static final int DEFAULT_POOL_CAPACITY = 128;

    public static final ObjectPool<byte[]> getByteArrayPool() {
        return ByteArrayPool;
    }
}