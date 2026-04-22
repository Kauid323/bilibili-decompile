package io.ktor.utils.io.pool;

import com.google.common.util.concurrent.Striped$SmallLazyStriped$;
import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import io.ktor.utils.io.pool.ObjectPool;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultPool.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00028\u0000H$¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\tJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u000fJ\r\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u0018\u0010\tJ\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0007J\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001dR\u001c\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lio/ktor/utils/io/pool/DefaultPool;", "", "T", "Lio/ktor/utils/io/pool/ObjectPool;", "", "capacity", "<init>", "(I)V", "produceInstance", "()Ljava/lang/Object;", "instance", "clearInstance", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "validateInstance", "(Ljava/lang/Object;)V", "disposeInstance", "borrow", "recycle", "dispose", "()V", "", "tryPush", "(Ljava/lang/Object;)Z", "tryPop", "index", "pushTop", "popTop", "()I", TextAttributes.INLINE_IMAGE_PLACEHOLDER, "getCapacity", "maxIndex", "shift", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "instances", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "next", "[I", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public abstract class DefaultPool<T> implements ObjectPool<T> {
    private static final /* synthetic */ AtomicLongFieldUpdater top$FU = AtomicLongFieldUpdater.newUpdater(DefaultPool.class, PropsConstants.HIT_SLOP_TOP);
    private final int capacity;
    private final AtomicReferenceArray<T> instances;
    private final int maxIndex;
    private final int[] next;
    private final int shift;
    private volatile /* synthetic */ long top;

    protected abstract T produceInstance();

    @Override // io.ktor.utils.io.pool.ObjectPool, java.lang.AutoCloseable
    public void close() {
        ObjectPool.DefaultImpls.close(this);
    }

    public DefaultPool(int capacity) {
        this.capacity = capacity;
        if (!(this.capacity > 0)) {
            throw new IllegalArgumentException(("capacity should be positive but it is " + this.capacity).toString());
        }
        if (!(this.capacity <= 536870911)) {
            throw new IllegalArgumentException(("capacity should be less or equal to 536870911 but it is " + this.capacity).toString());
        }
        this.top = 0L;
        this.maxIndex = Integer.highestOneBit((this.capacity * 4) - 1) * 2;
        this.shift = Integer.numberOfLeadingZeros(this.maxIndex) + 1;
        this.instances = new AtomicReferenceArray<>(this.maxIndex + 1);
        this.next = new int[this.maxIndex + 1];
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final int getCapacity() {
        return this.capacity;
    }

    protected T clearInstance(T t) {
        Intrinsics.checkNotNullParameter(t, "instance");
        return t;
    }

    protected void validateInstance(T t) {
        Intrinsics.checkNotNullParameter(t, "instance");
    }

    protected void disposeInstance(T t) {
        Intrinsics.checkNotNullParameter(t, "instance");
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final T borrow() {
        T clearInstance;
        T tryPop = tryPop();
        return (tryPop == null || (clearInstance = clearInstance(tryPop)) == null) ? produceInstance() : clearInstance;
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void recycle(T t) {
        Intrinsics.checkNotNullParameter(t, "instance");
        validateInstance(t);
        if (!tryPush(t)) {
            disposeInstance(t);
        }
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void dispose() {
        while (true) {
            T tryPop = tryPop();
            if (tryPop == null) {
                return;
            }
            disposeInstance(tryPop);
        }
    }

    private final boolean tryPush(T t) {
        int index = ((System.identityHashCode(t) * (-1640531527)) >>> this.shift) + 1;
        for (int i = 0; i < 8; i++) {
            if (Striped$SmallLazyStriped$.ExternalSyntheticBackportWithForwarding0.m(this.instances, index, (Object) null, t)) {
                pushTop(index);
                return true;
            }
            index--;
            if (index == 0) {
                index = this.maxIndex;
            }
        }
        return false;
    }

    private final T tryPop() {
        int index = popTop();
        if (index == 0) {
            return null;
        }
        return this.instances.getAndSet(index, null);
    }

    private final void pushTop(int index) {
        long top;
        long newTop;
        if (!(index > 0)) {
            throw new IllegalArgumentException("index should be positive".toString());
        }
        do {
            top = this.top;
            long topVersion = ((top >> 32) & 4294967295L) + 1;
            int topIndex = (int) (top & 4294967295L);
            newTop = (topVersion << 32) | index;
            this.next[index] = topIndex;
        } while (!top$FU.compareAndSet(this, top, newTop));
    }

    private final int popTop() {
        long top;
        int topIndex;
        long newTop;
        do {
            top = this.top;
            if (top == 0) {
                return 0;
            }
            long newVersion = 1 + ((top >> 32) & 4294967295L);
            topIndex = (int) (top & 4294967295L);
            if (topIndex == 0) {
                return 0;
            }
            int next = this.next[topIndex];
            newTop = (newVersion << 32) | next;
        } while (!top$FU.compareAndSet(this, top, newTop));
        return topIndex;
    }
}