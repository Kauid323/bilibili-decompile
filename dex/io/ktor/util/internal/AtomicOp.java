package io.ktor.util.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* compiled from: LockFreeLinkedList.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0004\b\r\u0010\u000bJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u000bR\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/util/internal/AtomicOp;", "T", "Lio/ktor/util/internal/OpDescriptor;", "<init>", "()V", "", "decision", "", "tryDecide", "(Ljava/lang/Object;)Z", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "affected", "prepare", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "perform", "isDecided", "()Z", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AtomicOp<T> extends OpDescriptor {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = LockFreeLinkedListKt.access$getNO_DECISION$p();

    public abstract void complete(T t, Object obj);

    public abstract Object prepare(T t);

    public final boolean isDecided() {
        return this._consensus != LockFreeLinkedListKt.access$getNO_DECISION$p();
    }

    public final boolean tryDecide(Object decision) {
        if (!(decision != LockFreeLinkedListKt.access$getNO_DECISION$p())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        return AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_consensus$FU, this, LockFreeLinkedListKt.access$getNO_DECISION$p(), decision);
    }

    private final Object decide(Object decision) {
        return tryDecide(decision) ? decision : this._consensus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.util.internal.OpDescriptor
    public final Object perform(Object affected) {
        Object decision = this._consensus;
        if (decision == LockFreeLinkedListKt.access$getNO_DECISION$p()) {
            decision = decide(prepare(affected));
        }
        complete(affected, decision);
        return decision;
    }
}