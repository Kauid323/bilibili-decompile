package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;

/* compiled from: DispatchedContinuation.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0003\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0082\b\u001aR\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00122%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0012\u0010\u001a\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\r0\u0005H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED", "executeUnconfined", "", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "yieldUndispatched", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DispatchedContinuationKt {
    private static final Symbol UNDEFINED = new Symbol("UNDEFINED");
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");

    public static final /* synthetic */ Symbol access$getUNDEFINED$p() {
        return UNDEFINED;
    }

    public static /* synthetic */ void resumeCancellableWith$default(Continuation continuation, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        resumeCancellableWith(continuation, obj, function1);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:15|(2:16|17)|(3:76|77|(9:79|80|20|(15:22|23|24|25|26|27|(2:58|59)(1:29)|30|31|32|33|34|35|(1:46)|39)(1:74)|40|(1:41)|43|44|45))|19|20|(0)(0)|40|(1:41)|43|44|45) */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0128, code lost:
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void resumeCancellableWith(Continuation<? super T> continuation, Object result, Function1<? super Throwable, Unit> function1) {
        Job job$iv$iv;
        boolean z;
        UndispatchedCoroutine updateUndispatchedCompletion;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation.resumeWith(result);
            return;
        }
        DispatchedContinuation this_$iv = (DispatchedContinuation) continuation;
        Object state$iv = CompletionStateKt.toState(result, function1);
        if (this_$iv.dispatcher.isDispatchNeeded(this_$iv.getContext())) {
            this_$iv._state = state$iv;
            this_$iv.resumeMode = 1;
            this_$iv.dispatcher.mo1456dispatch(this_$iv.getContext(), this_$iv);
            return;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
        }
        EventLoop eventLoop$iv$iv = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$iv$iv.isUnconfinedLoopActive()) {
            this_$iv._state = state$iv;
            this_$iv.resumeMode = 1;
            eventLoop$iv$iv.dispatchUnconfined(this_$iv);
            return;
        }
        DispatchedContinuation $this$runUnconfinedEventLoop$iv$iv$iv = this_$iv;
        eventLoop$iv$iv.incrementUseCount(true);
        try {
            job$iv$iv = (Job) this_$iv.getContext().get(Job.Key);
        } catch (Throwable th) {
            e$iv$iv$iv = th;
        }
        if (job$iv$iv != null) {
            try {
            } catch (Throwable th2) {
                e$iv$iv$iv = th2;
                try {
                    $this$runUnconfinedEventLoop$iv$iv$iv.handleFatalException$kotlinx_coroutines_core(e$iv$iv$iv, null);
                } finally {
                    eventLoop$iv$iv.decrementUseCount(true);
                }
            }
            if (!job$iv$iv.isActive()) {
                CancellationException cause$iv$iv = job$iv$iv.getCancellationException();
                this_$iv.cancelCompletedResult$kotlinx_coroutines_core(state$iv, cause$iv$iv);
                Result.Companion companion = Result.Companion;
                this_$iv.resumeWith(Result.constructor-impl(ResultKt.createFailure(cause$iv$iv)));
                z = true;
                if (z) {
                    Continuation continuation$iv$iv$iv = this_$iv.continuation;
                    Object countOrElement$iv$iv$iv = this_$iv.countOrElement;
                    CoroutineContext context$iv$iv$iv = continuation$iv$iv$iv.getContext();
                    try {
                        Object oldValue$iv$iv$iv = ThreadContextKt.updateThreadContext(context$iv$iv$iv, countOrElement$iv$iv$iv);
                        if (oldValue$iv$iv$iv != ThreadContextKt.NO_THREAD_ELEMENTS) {
                            try {
                                updateUndispatchedCompletion = CoroutineContextKt.updateUndispatchedCompletion(continuation$iv$iv$iv, context$iv$iv$iv, oldValue$iv$iv$iv);
                            } catch (Throwable th3) {
                                e$iv$iv$iv = th3;
                                $this$runUnconfinedEventLoop$iv$iv$iv.handleFatalException$kotlinx_coroutines_core(e$iv$iv$iv, null);
                            }
                        } else {
                            updateUndispatchedCompletion = null;
                        }
                        UndispatchedCoroutine undispatchedCompletion$iv$iv$iv = updateUndispatchedCompletion;
                        try {
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        try {
                            this_$iv.continuation.resumeWith(result);
                            Unit unit = Unit.INSTANCE;
                            if (undispatchedCompletion$iv$iv$iv == null || undispatchedCompletion$iv$iv$iv.clearThreadContext()) {
                                ThreadContextKt.restoreThreadContext(context$iv$iv$iv, oldValue$iv$iv$iv);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            if (undispatchedCompletion$iv$iv$iv == null || undispatchedCompletion$iv$iv$iv.clearThreadContext()) {
                                ThreadContextKt.restoreThreadContext(context$iv$iv$iv, oldValue$iv$iv$iv);
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        e$iv$iv$iv = th6;
                    }
                }
                do {
                } while (eventLoop$iv$iv.processUnconfinedEvent());
            }
        }
        z = false;
        if (z) {
        }
        do {
        } while (eventLoop$iv$iv.processUnconfinedEvent());
    }

    /* JADX WARN: Finally extract failed */
    public static final boolean yieldUndispatched(DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Object contState$iv = Unit.INSTANCE;
        if (DebugKt.getASSERTIONS_ENABLED()) {
        }
        EventLoop eventLoop$iv = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$iv.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$iv.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = contState$iv;
            dispatchedContinuation.resumeMode = 1;
            eventLoop$iv.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        DispatchedContinuation<? super Unit> $this$runUnconfinedEventLoop$iv$iv = dispatchedContinuation;
        eventLoop$iv.incrementUseCount(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (eventLoop$iv.processUnconfinedEvent());
        } catch (Throwable e$iv$iv) {
            try {
                $this$runUnconfinedEventLoop$iv$iv.handleFatalException$kotlinx_coroutines_core(e$iv$iv, null);
            } finally {
                eventLoop$iv.decrementUseCount(true);
            }
        }
        return false;
    }

    static /* synthetic */ boolean executeUnconfined$default(DispatchedContinuation $this$executeUnconfined_u24default, Object contState, int mode, boolean doYield, Function0 block, int i, Object obj) {
        if ((i & 4) != 0) {
            doYield = false;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if ((mode != -1 ? 1 : 0) == 0) {
                throw new AssertionError();
            }
        }
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (doYield && eventLoop.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop.isUnconfinedLoopActive()) {
            $this$executeUnconfined_u24default._state = contState;
            $this$executeUnconfined_u24default.resumeMode = mode;
            eventLoop.dispatchUnconfined($this$executeUnconfined_u24default);
            return true;
        }
        DispatchedContinuation $this$runUnconfinedEventLoop$iv = $this$executeUnconfined_u24default;
        eventLoop.incrementUseCount(true);
        try {
            block.invoke();
            do {
            } while (eventLoop.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
        } catch (Throwable e$iv) {
            try {
                $this$runUnconfinedEventLoop$iv.handleFatalException$kotlinx_coroutines_core(e$iv, null);
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                eventLoop.decrementUseCount(true);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        eventLoop.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        return false;
    }

    private static final boolean executeUnconfined(DispatchedContinuation<?> dispatchedContinuation, Object contState, int mode, boolean doYield, Function0<Unit> function0) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if ((mode != -1 ? 1 : 0) == 0) {
                throw new AssertionError();
            }
        }
        EventLoop eventLoop = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (doYield && eventLoop.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = contState;
            dispatchedContinuation.resumeMode = mode;
            eventLoop.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        DispatchedContinuation<?> $this$runUnconfinedEventLoop$iv = dispatchedContinuation;
        eventLoop.incrementUseCount(true);
        try {
            function0.invoke();
            do {
            } while (eventLoop.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
        } catch (Throwable e$iv) {
            try {
                $this$runUnconfinedEventLoop$iv.handleFatalException$kotlinx_coroutines_core(e$iv, null);
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                eventLoop.decrementUseCount(true);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        eventLoop.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        return false;
    }
}