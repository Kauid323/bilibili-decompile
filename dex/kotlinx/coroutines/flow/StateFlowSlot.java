package kotlinx.coroutines.flow;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Concurrent_commonKt;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StateFlow.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u000e\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00100\u000f2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\tR\"\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "()V", "_state", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Lkotlinx/coroutines/internal/WorkaroundAtomicReference;", "allocateLocked", "", "flow", "awaitPending", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "freeLocked", "", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {
    private final AtomicReference<Object> _state = new AtomicReference<>(null);

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(StateFlowImpl<?> stateFlowImpl) {
        Symbol symbol;
        if (Concurrent_commonKt.getValue(this._state) != null) {
            return false;
        }
        AtomicReference<Object> atomicReference = this._state;
        symbol = StateFlowKt.NONE;
        Concurrent_commonKt.setValue(atomicReference, symbol);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public Continuation<Unit>[] freeLocked(StateFlowImpl<?> stateFlowImpl) {
        Concurrent_commonKt.setValue(this._state, null);
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    public final void makePending() {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        AtomicReference $this$loop$iv = this._state;
        while (true) {
            Object state = Concurrent_commonKt.getValue($this$loop$iv);
            if (state == null) {
                return;
            }
            symbol = StateFlowKt.PENDING;
            if (state == symbol) {
                return;
            }
            symbol2 = StateFlowKt.NONE;
            if (state == symbol2) {
                AtomicReference<Object> atomicReference = this._state;
                symbol3 = StateFlowKt.PENDING;
                if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(atomicReference, state, symbol3)) {
                    return;
                }
            } else {
                AtomicReference<Object> atomicReference2 = this._state;
                symbol4 = StateFlowKt.NONE;
                if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(atomicReference2, state, symbol4)) {
                    Result.Companion companion = Result.Companion;
                    ((CancellableContinuationImpl) state).resumeWith(Result.constructor-impl(Unit.INSTANCE));
                    return;
                }
            }
        }
    }

    public final boolean takePending() {
        Symbol symbol;
        Symbol symbol2;
        AtomicReference<Object> atomicReference = this._state;
        symbol = StateFlowKt.NONE;
        Object state = atomicReference.getAndSet(symbol);
        Intrinsics.checkNotNull(state);
        if (DebugKt.getASSERTIONS_ENABLED() && (state instanceof CancellableContinuationImpl)) {
            throw new AssertionError();
        }
        symbol2 = StateFlowKt.PENDING;
        return state == symbol2;
    }

    public final Object awaitPending(Continuation<? super Unit> continuation) {
        Symbol symbol;
        Symbol symbol2;
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl cont = cancellable$iv;
        if (DebugKt.getASSERTIONS_ENABLED() && (Concurrent_commonKt.getValue(this._state) instanceof CancellableContinuationImpl)) {
            throw new AssertionError();
        }
        AtomicReference atomicReference = this._state;
        symbol = StateFlowKt.NONE;
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(atomicReference, symbol, cont)) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                Object value = Concurrent_commonKt.getValue(this._state);
                symbol2 = StateFlowKt.PENDING;
                if (!(value == symbol2)) {
                    throw new AssertionError();
                }
            }
            Result.Companion companion = Result.Companion;
            cont.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}