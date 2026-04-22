package io.ktor.utils.io.pool;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.StyleConstants;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import com.mall.data.page.order.OrderResultCode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteBufferPools.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/utils/io/pool/ByteBufferPool;", "Lio/ktor/utils/io/pool/DefaultPool;", "Ljava/nio/ByteBuffer;", "", "capacity", "bufferSize", "<init>", "(II)V", "produceInstance", "()Ljava/nio/ByteBuffer;", "instance", "clearInstance", "(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;", "", "validateInstance", "(Ljava/nio/ByteBuffer;)V", TextAttributes.INLINE_IMAGE_PLACEHOLDER, "getBufferSize", "()I", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteBufferPool extends DefaultPool<ByteBuffer> {
    private final int bufferSize;

    public ByteBufferPool() {
        this(0, 0, 3, null);
    }

    public /* synthetic */ ByteBufferPool(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? OrderResultCode.CODE_ASYN_LOADING : i, (i3 & 2) != 0 ? StyleConstants.TRANSFORM_SKEW : i2);
    }

    public final int getBufferSize() {
        return this.bufferSize;
    }

    public ByteBufferPool(int capacity, int bufferSize) {
        super(capacity);
        this.bufferSize = bufferSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.utils.io.pool.DefaultPool
    public ByteBuffer produceInstance() {
        ByteBuffer allocate = ByteBuffer.allocate(this.bufferSize);
        Intrinsics.checkNotNull(allocate);
        return allocate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.utils.io.pool.DefaultPool
    public ByteBuffer clearInstance(ByteBuffer instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        instance.clear();
        instance.order(ByteOrder.BIG_ENDIAN);
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.utils.io.pool.DefaultPool
    public void validateInstance(ByteBuffer instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (!(instance.capacity() == this.bufferSize)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (instance.isDirect()) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }
}