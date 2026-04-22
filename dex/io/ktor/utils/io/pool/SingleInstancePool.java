package io.ktor.utils.io.pool;

import com.lynx.tasm.behavior.PropertyIDConstants;
import io.ktor.utils.io.pool.ObjectPool;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pool.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00028\u0000H$¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H$¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\u0007J\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u0005R\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/ktor/utils/io/pool/SingleInstancePool;", "", "T", "Lio/ktor/utils/io/pool/ObjectPool;", "<init>", "()V", "produceInstance", "()Ljava/lang/Object;", "instance", "", "disposeInstance", "(Ljava/lang/Object;)V", "borrow", "recycle", "dispose", "", "getCapacity", "()I", "capacity", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public abstract class SingleInstancePool<T> implements ObjectPool<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater borrowed$FU = AtomicIntegerFieldUpdater.newUpdater(SingleInstancePool.class, "borrowed");
    private static final /* synthetic */ AtomicIntegerFieldUpdater disposed$FU = AtomicIntegerFieldUpdater.newUpdater(SingleInstancePool.class, "disposed");
    private volatile /* synthetic */ int borrowed = 0;
    private volatile /* synthetic */ int disposed = 0;
    private volatile /* synthetic */ Object instance = null;

    protected abstract void disposeInstance(T t);

    protected abstract T produceInstance();

    @Override // io.ktor.utils.io.pool.ObjectPool, java.lang.AutoCloseable
    public void close() {
        ObjectPool.DefaultImpls.close(this);
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final int getCapacity() {
        return 1;
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final T borrow() {
        int cur$iv;
        do {
            cur$iv = this.borrowed;
            if (cur$iv != 0) {
                throw new IllegalStateException("Instance is already consumed".toString());
            }
        } while (!borrowed$FU.compareAndSet(this, cur$iv, 1));
        T produceInstance = produceInstance();
        this.instance = produceInstance;
        return produceInstance;
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void recycle(T t) {
        Intrinsics.checkNotNullParameter(t, "instance");
        if (this.instance != t) {
            if (this.instance == null && this.borrowed != 0) {
                throw new IllegalStateException("Already recycled or an irrelevant instance tried to be recycled".toString());
            }
            throw new IllegalStateException("Unable to recycle irrelevant instance".toString());
        }
        this.instance = null;
        if (!disposed$FU.compareAndSet(this, 0, 1)) {
            throw new IllegalStateException("An instance is already disposed".toString());
        }
        disposeInstance(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void dispose() {
        Object value;
        if (!disposed$FU.compareAndSet(this, 0, 1) || (value = this.instance) == null) {
            return;
        }
        this.instance = null;
        disposeInstance(value);
    }
}