package kotlinx.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: CancellableContinuationImpl.kt */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006B\u001b\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103J\u001a\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002042\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0017\u00105\u001a\u00020/2\f\u00106\u001a\b\u0012\u0004\u0012\u00020/07H\u0082\bJ1\u00108\u001a\u00020/2!\u00109\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/0:2\u0006\u00102\u001a\u000203J\u001e\u0010=\u001a\u00020/2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030?2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u0010@\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001f\u0010A\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010\u00122\u0006\u00102\u001a\u000203H\u0010¢\u0006\u0002\bCJ\u0010\u0010D\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0002J\u0010\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u00020\u0012H\u0016J\r\u0010G\u001a\u00020/H\u0000¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020/H\u0002J\u0010\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020\nH\u0002J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020NH\u0016J\u0019\u0010O\u001a\u0004\u0018\u0001032\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0010¢\u0006\u0002\bPJ\n\u0010Q\u001a\u0004\u0018\u00010\u0012H\u0001J\u0010\u0010R\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`TH\u0016J\u001f\u0010U\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0010¢\u0006\u0004\bV\u0010WJ\b\u0010X\u001a\u00020/H\u0016J\n\u0010Y\u001a\u0004\u0018\u00010\u0010H\u0002J1\u0010Z\u001a\u00020/2'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u000103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/0:j\u0002`[H\u0016J\u001c\u0010Z\u001a\u00020/2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030?2\u0006\u0010\\\u001a\u00020\nH\u0016J\u0010\u0010]\u001a\u00020/2\u0006\u00100\u001a\u00020\u0012H\u0002J\u0015\u0010^\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0000¢\u0006\u0002\b_J\b\u0010`\u001a\u00020\u001dH\u0002J\u001a\u0010a\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010b\u001a\u00020(H\u0014J\u0015\u0010c\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\bdJ\r\u0010e\u001a\u00020/H\u0000¢\u0006\u0002\bfJ\b\u0010g\u001a\u00020\u001dH\u0001J:\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00028\u00002#\u00109\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u00010:H\u0016¢\u0006\u0002\u0010jJA\u0010k\u001a\u00020/2\b\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2%\b\u0002\u00109\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u00010:H\u0002J\u001b\u0010l\u001a\u00020/2\f\u0010m\u001a\b\u0012\u0004\u0012\u00028\u00000nH\u0016¢\u0006\u0002\u0010oJS\u0010p\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020q2\b\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2#\u00109\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u00010:2\b\u0010r\u001a\u0004\u0018\u00010\u0012H\u0002J\u000f\u0010s\u001a\u0004\u0018\u00010\u0012H\u0010¢\u0006\u0002\btJ\b\u0010u\u001a\u00020(H\u0016J\b\u0010v\u001a\u00020\u001dH\u0002J!\u0010v\u001a\u0004\u0018\u00010\u00122\u0006\u0010i\u001a\u00028\u00002\b\u0010r\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010wJF\u0010v\u001a\u0004\u0018\u00010\u00122\u0006\u0010i\u001a\u00028\u00002\b\u0010r\u001a\u0004\u0018\u00010\u00122#\u00109\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u00010:H\u0016¢\u0006\u0002\u0010xJC\u0010y\u001a\u0004\u0018\u00010z2\b\u0010-\u001a\u0004\u0018\u00010\u00122\b\u0010r\u001a\u0004\u0018\u00010\u00122#\u00109\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020/\u0018\u00010:H\u0002J\u0012\u0010{\u001a\u0004\u0018\u00010\u00122\u0006\u0010|\u001a\u000203H\u0016J\b\u0010}\u001a\u00020\u001dH\u0002J\u001a\u0010~\u001a\u00020/*\u00020\u007f2\u0006\u0010i\u001a\u00028\u0000H\u0016¢\u0006\u0003\u0010\u0080\u0001J\u0015\u0010\u0081\u0001\u001a\u00020/*\u00020\u007f2\u0006\u0010|\u001a\u000203H\u0016R\t\u0010\f\u001a\u00020\rX\u0082\u0004R\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004R\u0011\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fX\u0082\u0004R\u001c\u0010\u0013\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006\u0082\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/Waiter;", "delegate", "Lkotlin/coroutines/Continuation;", "resumeMode", "", "(Lkotlin/coroutines/Continuation;I)V", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicInt;", "_parentHandle", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/DisposableHandle;", "_state", "", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "parentHandle", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "stateDebugRepresentation", "", "getStateDebugRepresentation", "()Ljava/lang/String;", "alreadyResumedError", "", "proposedUpdate", "callCancelHandler", "", "handler", "Lkotlinx/coroutines/CancelHandler;", "cause", "", "Lkotlinx/coroutines/InternalCompletionHandler;", "callCancelHandlerSafely", "block", "Lkotlin/Function0;", "callOnCancellation", "onCancellation", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "callSegmentOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "cancel", "cancelCompletedResult", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "cancelLater", "completeResume", "token", "detachChild", "detachChild$kotlinx_coroutines_core", "detachChildIfNonResuable", "dispatchResume", "mode", "getContinuationCancellationCause", "parent", "Lkotlinx/coroutines/Job;", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "getResult", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "initCancellability", "installParentHandle", "invokeOnCancellation", "Lkotlinx/coroutines/CompletionHandler;", "index", "invokeOnCancellationImpl", "invokeOnCancellationInternal", "invokeOnCancellationInternal$kotlinx_coroutines_core", "isReusable", "multipleHandlersError", "nameString", "parentCancelled", "parentCancelled$kotlinx_coroutines_core", "releaseClaimedReusableContinuation", "releaseClaimedReusableContinuation$kotlinx_coroutines_core", "resetStateReusable", "resume", "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeImpl", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "resumedState", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "takeState", "takeState$kotlinx_coroutines_core", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tryResumeImpl", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeWithException", "exception", "trySuspend", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame, Waiter {
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    private final CoroutineContext context;
    private final Continuation<T> delegate;
    private static final /* synthetic */ AtomicIntegerFieldUpdater _decisionAndIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle$volatile");

    private final /* synthetic */ int get_decisionAndIndex$volatile() {
        return this._decisionAndIndex$volatile;
    }

    private final /* synthetic */ Object get_parentHandle$volatile() {
        return this._parentHandle$volatile;
    }

    private final /* synthetic */ Object get_state$volatile() {
        return this._state$volatile;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function1) {
        while (true) {
            function1.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final /* synthetic */ void set_decisionAndIndex$volatile(int i) {
        this._decisionAndIndex$volatile = i;
    }

    private final /* synthetic */ void set_parentHandle$volatile(Object obj) {
        this._parentHandle$volatile = obj;
    }

    private final /* synthetic */ void set_state$volatile(Object obj) {
        this._state$volatile = obj;
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Integer> function1) {
        int i;
        do {
            i = atomicIntegerFieldUpdater.get(obj);
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i, function1.invoke(Integer.valueOf(i)).intValue()));
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(Continuation<? super T> continuation, int resumeMode) {
        super(resumeMode);
        this.delegate = continuation;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(resumeMode != -1)) {
                throw new AssertionError();
            }
        }
        this.context = this.delegate.getContext();
        this._decisionAndIndex$volatile = (0 << 29) + 536870911;
        this._state$volatile = Active.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.context;
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle) _parentHandle$volatile$FU.get(this);
    }

    public final Object getState$kotlinx_coroutines_core() {
        return _state$volatile$FU.get(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCancelled() {
        return getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    private final String getStateDebugRepresentation() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return state$kotlinx_coroutines_core instanceof NotCompleted ? "Active" : state$kotlinx_coroutines_core instanceof CancelledContinuation ? "Cancelled" : "Completed";
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void initCancellability() {
        DisposableHandle handle = installParentHandle();
        if (handle != null && isCompleted()) {
            handle.dispose();
            _parentHandle$volatile$FU.set(this, NonDisposableHandle.INSTANCE);
        }
    }

    private final boolean isReusable() {
        if (DispatchedTaskKt.isReusableMode(this.resumeMode)) {
            Continuation<T> continuation = this.delegate;
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((DispatchedContinuation) continuation).isReusable$kotlinx_coroutines_core()) {
                return true;
            }
        }
        return false;
    }

    public final boolean resetStateReusable() {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if ((this.resumeMode == 2 ? 1 : 0) == 0) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if ((getParentHandle() != NonDisposableHandle.INSTANCE ? 1 : 0) == 0) {
                throw new AssertionError();
            }
        }
        Object state = _state$volatile$FU.get(this);
        if (DebugKt.getASSERTIONS_ENABLED() && (state instanceof NotCompleted)) {
            throw new AssertionError();
        }
        if ((state instanceof CompletedContinuation) && ((CompletedContinuation) state).idempotentResume != null) {
            detachChild$kotlinx_coroutines_core();
            return false;
        }
        _decisionAndIndex$volatile$FU.set(this, (0 << 29) + 536870911);
        _state$volatile$FU.set(this, Active.INSTANCE);
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object takenState, Throwable cause) {
        AtomicReferenceFieldUpdater handler$atomicfu$iv = _state$volatile$FU;
        while (true) {
            Object state = handler$atomicfu$iv.get(this);
            if (state instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (state instanceof CompletedExceptionally) {
                return;
            }
            if (!(state instanceof CompletedContinuation)) {
                if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_state$volatile$FU, this, state, new CompletedContinuation(state, null, null, null, cause, 14, null))) {
                    return;
                }
            } else if (((CompletedContinuation) state).getCancelled()) {
                throw new IllegalStateException("Must be called at most once".toString());
            } else {
                CompletedContinuation update = CompletedContinuation.copy$default((CompletedContinuation) state, null, null, null, null, cause, 15, null);
                if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_state$volatile$FU, this, state, update)) {
                    ((CompletedContinuation) state).invokeHandlers(this, cause);
                    return;
                }
            }
        }
    }

    private final boolean cancelLater(Throwable cause) {
        if (isReusable()) {
            Continuation<T> continuation = this.delegate;
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            DispatchedContinuation dispatched = (DispatchedContinuation) continuation;
            return dispatched.postponeCancellation$kotlinx_coroutines_core(cause);
        }
        return false;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(Throwable cause) {
        Object state;
        CancelledContinuation update;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = _state$volatile$FU;
        do {
            state = handler$atomicfu$iv.get(this);
            boolean z = false;
            if (!(state instanceof NotCompleted)) {
                return false;
            }
            CancellableContinuationImpl<T> cancellableContinuationImpl = this;
            if ((state instanceof CancelHandler) || (state instanceof Segment)) {
                z = true;
            }
            update = new CancelledContinuation(cancellableContinuationImpl, cause, z);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_state$volatile$FU, this, state, update));
        NotCompleted notCompleted = (NotCompleted) state;
        if (notCompleted instanceof CancelHandler) {
            callCancelHandler((CancelHandler) state, cause);
        } else if (notCompleted instanceof Segment) {
            callSegmentOnCancellation((Segment) state, cause);
        }
        detachChildIfNonResuable();
        dispatchResume(this.resumeMode);
        return true;
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable cause) {
        if (cancelLater(cause)) {
            return;
        }
        cancel(cause);
        detachChildIfNonResuable();
    }

    private final void callCancelHandlerSafely(Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Throwable ex) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, ex));
        }
    }

    private final void callCancelHandler(InternalCompletionHandler handler, Throwable cause) {
        try {
            handler.invoke(cause);
        } catch (Throwable ex$iv) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, ex$iv));
        }
    }

    public final void callCancelHandler(CancelHandler handler, Throwable cause) {
        try {
            handler.invoke(cause);
        } catch (Throwable ex$iv) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, ex$iv));
        }
    }

    private final void callSegmentOnCancellation(Segment<?> segment, Throwable cause) {
        int $this$index$iv = _decisionAndIndex$volatile$FU.get(this);
        int index = $this$index$iv & 536870911;
        if (!(index != 536870911)) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
        try {
            segment.onCancellation(index, cause, getContext());
        } catch (Throwable ex$iv) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, ex$iv));
        }
    }

    public final void callOnCancellation(Function1<? super Throwable, Unit> function1, Throwable cause) {
        try {
            function1.invoke(cause);
        } catch (Throwable ex) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, ex));
        }
    }

    public Throwable getContinuationCancellationCause(Job parent) {
        return parent.getCancellationException();
    }

    private final boolean trySuspend() {
        int cur;
        int index$iv;
        AtomicIntegerFieldUpdater handler$atomicfu$iv = _decisionAndIndex$volatile$FU;
        do {
            cur = handler$atomicfu$iv.get(this);
            int $this$decision$iv = cur >> 29;
            switch ($this$decision$iv) {
                case 0:
                    index$iv = cur & 536870911;
                    break;
                case 1:
                default:
                    throw new IllegalStateException("Already suspended".toString());
                case 2:
                    return false;
            }
        } while (!_decisionAndIndex$volatile$FU.compareAndSet(this, cur, (1 << 29) + index$iv));
        return true;
    }

    private final boolean tryResume() {
        int cur;
        int index$iv;
        AtomicIntegerFieldUpdater handler$atomicfu$iv = _decisionAndIndex$volatile$FU;
        do {
            cur = handler$atomicfu$iv.get(this);
            int $this$decision$iv = cur >> 29;
            switch ($this$decision$iv) {
                case 0:
                    index$iv = cur & 536870911;
                    break;
                case 1:
                    return false;
                default:
                    throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decisionAndIndex$volatile$FU.compareAndSet(this, cur, (2 << 29) + index$iv));
        return true;
    }

    public final Object getResult() {
        Job job;
        boolean isReusable = isReusable();
        if (trySuspend()) {
            if (getParentHandle() == null) {
                installParentHandle();
            }
            if (isReusable) {
                releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            }
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (isReusable) {
            releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        Object state = getState$kotlinx_coroutines_core();
        if (!(state instanceof CompletedExceptionally)) {
            if (DispatchedTaskKt.isCancellableMode(this.resumeMode) && (job = (Job) getContext().get(Job.Key)) != null && !job.isActive()) {
                CancellationException cause = job.getCancellationException();
                cancelCompletedResult$kotlinx_coroutines_core(state, cause);
                if (!DebugKt.getRECOVER_STACK_TRACES() || !(this instanceof CoroutineStackFrame)) {
                    throw cause;
                }
                throw StackTraceRecoveryKt.access$recoverFromStackFrame(cause, this);
            }
            return getSuccessfulResult$kotlinx_coroutines_core(state);
        }
        Throwable exception$iv = ((CompletedExceptionally) state).cause;
        if (DebugKt.getRECOVER_STACK_TRACES() && (this instanceof CoroutineStackFrame)) {
            throw StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv, this);
        }
        throw exception$iv;
    }

    private final DisposableHandle installParentHandle() {
        Job parent = (Job) getContext().get(Job.Key);
        if (parent == null) {
            return null;
        }
        DisposableHandle handle = JobKt.invokeOnCompletion$default(parent, true, false, new ChildContinuation(this), 2, null);
        AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_parentHandle$volatile$FU, this, (Object) null, handle);
        return handle;
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        Throwable cancellationCause;
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation == null || (cancellationCause = dispatchedContinuation.tryReleaseClaimedContinuation$kotlinx_coroutines_core(this)) == null) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
        cancel(cancellationCause);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        resumeImpl$default(this, CompletionStateKt.toState(result, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(T t, Function1<? super Throwable, Unit> function1) {
        resumeImpl(t, this.resumeMode, function1);
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(Segment<?> segment, int index) {
        int it;
        int decision$iv;
        AtomicIntegerFieldUpdater handler$atomicfu$iv = _decisionAndIndex$volatile$FU;
        do {
            it = handler$atomicfu$iv.get(this);
            int $this$index$iv = it & 536870911;
            if (!($this$index$iv == 536870911)) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
            decision$iv = it >> 29;
        } while (!handler$atomicfu$iv.compareAndSet(this, it, (decision$iv << 29) + index));
        invokeOnCancellationImpl(segment);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(Function1<? super Throwable, Unit> function1) {
        CancellableContinuationKt.invokeOnCancellation(this, new CancelHandler.UserSupplied(function1));
    }

    public final void invokeOnCancellationInternal$kotlinx_coroutines_core(CancelHandler handler) {
        invokeOnCancellationImpl(handler);
    }

    private final void invokeOnCancellationImpl(Object handler) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!((handler instanceof CancelHandler) || (handler instanceof Segment))) {
                throw new AssertionError();
            }
        }
        AtomicReferenceFieldUpdater handler$atomicfu$iv = _state$volatile$FU;
        while (true) {
            Object state = handler$atomicfu$iv.get(this);
            if (state instanceof Active) {
                if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_state$volatile$FU, this, state, handler)) {
                    return;
                }
            } else {
                if (state instanceof CancelHandler ? true : state instanceof Segment) {
                    multipleHandlersError(handler, state);
                } else if (state instanceof CompletedExceptionally) {
                    if (!((CompletedExceptionally) state).makeHandled()) {
                        multipleHandlersError(handler, state);
                    }
                    if (state instanceof CancelledContinuation) {
                        CompletedExceptionally completedExceptionally = state instanceof CompletedExceptionally ? (CompletedExceptionally) state : null;
                        Throwable cause = completedExceptionally != null ? completedExceptionally.cause : null;
                        if (handler instanceof CancelHandler) {
                            callCancelHandler((CancelHandler) handler, cause);
                            return;
                        }
                        Intrinsics.checkNotNull(handler, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        Segment segment = (Segment) handler;
                        callSegmentOnCancellation(segment, cause);
                        return;
                    }
                    return;
                } else if (state instanceof CompletedContinuation) {
                    if (((CompletedContinuation) state).cancelHandler != null) {
                        multipleHandlersError(handler, state);
                    }
                    if (handler instanceof Segment) {
                        return;
                    }
                    Intrinsics.checkNotNull(handler, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    CancelHandler cancelHandler = (CancelHandler) handler;
                    if (((CompletedContinuation) state).getCancelled()) {
                        callCancelHandler((CancelHandler) handler, ((CompletedContinuation) state).cancelCause);
                        return;
                    }
                    CompletedContinuation update = CompletedContinuation.copy$default((CompletedContinuation) state, null, (CancelHandler) handler, null, null, null, 29, null);
                    if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_state$volatile$FU, this, state, update)) {
                        return;
                    }
                } else if (handler instanceof Segment) {
                    return;
                } else {
                    Intrinsics.checkNotNull(handler, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    CancelHandler cancelHandler2 = (CancelHandler) handler;
                    CompletedContinuation update2 = new CompletedContinuation(state, (CancelHandler) handler, null, null, null, 28, null);
                    if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_state$volatile$FU, this, state, update2)) {
                        return;
                    }
                }
            }
        }
    }

    private final void multipleHandlersError(Object handler, Object state) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + handler + ", already has " + state).toString());
    }

    private final void dispatchResume(int mode) {
        if (tryResume()) {
            return;
        }
        DispatchedTaskKt.dispatch(this, mode);
    }

    private final Object resumedState(NotCompleted state, Object proposedUpdate, int resumeMode, Function1<? super Throwable, Unit> function1, Object idempotent) {
        if (proposedUpdate instanceof CompletedExceptionally) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if ((idempotent == null ? 1 : 0) == 0) {
                    throw new AssertionError();
                }
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(function1 == null)) {
                    throw new AssertionError();
                }
            }
        } else if ((DispatchedTaskKt.isCancellableMode(resumeMode) || idempotent != null) && (function1 != null || (state instanceof CancelHandler) || idempotent != null)) {
            return new CompletedContinuation(proposedUpdate, state instanceof CancelHandler ? (CancelHandler) state : null, function1, idempotent, null, 16, null);
        }
        return proposedUpdate;
    }

    private final void resumeImpl(Object proposedUpdate, int resumeMode, Function1<? super Throwable, Unit> function1) {
        Object state;
        Object update;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = _state$volatile$FU;
        do {
            state = handler$atomicfu$iv.get(this);
            if (state instanceof NotCompleted) {
                update = resumedState((NotCompleted) state, proposedUpdate, resumeMode, function1, null);
            } else if ((state instanceof CancelledContinuation) && ((CancelledContinuation) state).makeResumed()) {
                if (function1 != null) {
                    callOnCancellation(function1, ((CancelledContinuation) state).cause);
                    return;
                }
                return;
            } else {
                alreadyResumedError(proposedUpdate);
                throw new KotlinNothingValueException();
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_state$volatile$FU, this, state, update));
        detachChildIfNonResuable();
        dispatchResume(resumeMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void resumeImpl$default(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i, Function1 function1, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        cancellableContinuationImpl.resumeImpl(obj, i, function1);
    }

    private final Symbol tryResumeImpl(Object proposedUpdate, Object idempotent, Function1<? super Throwable, Unit> function1) {
        Object state;
        Object update;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = _state$volatile$FU;
        do {
            state = handler$atomicfu$iv.get(this);
            if (state instanceof NotCompleted) {
                update = resumedState((NotCompleted) state, proposedUpdate, this.resumeMode, function1, idempotent);
            } else if ((state instanceof CompletedContinuation) && idempotent != null && ((CompletedContinuation) state).idempotentResume == idempotent) {
                if (!DebugKt.getASSERTIONS_ENABLED() || Intrinsics.areEqual(((CompletedContinuation) state).result, proposedUpdate)) {
                    return CancellableContinuationImplKt.RESUME_TOKEN;
                }
                throw new AssertionError();
            } else {
                return null;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(_state$volatile$FU, this, state, update));
        detachChildIfNonResuable();
        return CancellableContinuationImplKt.RESUME_TOKEN;
    }

    private final Void alreadyResumedError(Object proposedUpdate) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + proposedUpdate).toString());
    }

    private final void detachChildIfNonResuable() {
        if (!isReusable()) {
            detachChild$kotlinx_coroutines_core();
        }
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle handle = getParentHandle();
        if (handle == null) {
            return;
        }
        handle.dispose();
        _parentHandle$volatile$FU.set(this, NonDisposableHandle.INSTANCE);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(T t, Object idempotent) {
        return tryResumeImpl(t, idempotent, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(T t, Object idempotent, Function1<? super Throwable, Unit> function1) {
        return tryResumeImpl(t, idempotent, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResumeWithException(Throwable exception) {
        return tryResumeImpl(new CompletedExceptionally(exception, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(Object token) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(token == CancellableContinuationImplKt.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        dispatchResume(this.resumeMode);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(CoroutineDispatcher $this$resumeUndispatched, T t) {
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dc = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        resumeImpl$default(this, t, (dc != null ? dc.dispatcher : null) == $this$resumeUndispatched ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatchedWithException(CoroutineDispatcher $this$resumeUndispatchedWithException, Throwable exception) {
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dc = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        resumeImpl$default(this, new CompletedExceptionally(exception, false, 2, null), (dc != null ? dc.dispatcher : null) == $this$resumeUndispatchedWithException ? 4 : this.resumeMode, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object state) {
        return state instanceof CompletedContinuation ? (T) ((CompletedContinuation) state).result : state;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object state) {
        Throwable it = super.getExceptionalResult$kotlinx_coroutines_core(state);
        if (it != null) {
            Continuation continuation$iv = this.delegate;
            if (!DebugKt.getRECOVER_STACK_TRACES() || !(continuation$iv instanceof CoroutineStackFrame)) {
                return it;
            }
            return StackTraceRecoveryKt.access$recoverFromStackFrame(it, (CoroutineStackFrame) continuation$iv);
        }
        return null;
    }

    public String toString() {
        return nameString() + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + getStateDebugRepresentation() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    protected String nameString() {
        return "CancellableContinuation";
    }
}