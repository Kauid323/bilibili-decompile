package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: Undispatched.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0082\b\u001aO\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n2\u0006\u0010\u000b\u001a\u0002H\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000¢\u0006\u0002\u0010\f\u001a;\u0010\r\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000¢\u0006\u0002\u0010\u000e\u001aV\u0010\u000f\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\u000b\u001a\u0002H\t2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n¢\u0006\u0002\b\u0011H\u0000¢\u0006\u0002\u0010\u0012\u001aV\u0010\u0013\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\u000b\u001a\u0002H\t2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n¢\u0006\u0002\b\u0011H\u0000¢\u0006\u0002\u0010\u0012\u001a?\u0010\u0014\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00062\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\u0082\b¨\u0006\u001a"}, d2 = {"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UndispatchedKt {
    public static final <T> void startCoroutineUnintercepted(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Continuation actualCompletion$iv = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            Object value$iv = !(function1 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function1, actualCompletion$iv) : ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(actualCompletion$iv);
            if (value$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return;
            }
            Result.Companion companion = Result.Companion;
            actualCompletion$iv.resumeWith(Result.constructor-impl(value$iv));
        } catch (Throwable e$iv) {
            Result.Companion companion2 = Result.Companion;
            actualCompletion$iv.resumeWith(Result.constructor-impl(ResultKt.createFailure(e$iv)));
        }
    }

    public static final <R, T> void startCoroutineUndispatched(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Continuation actualCompletion$iv = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            CoroutineContext context$iv = continuation.getContext();
            Object oldValue$iv = ThreadContextKt.updateThreadContext(context$iv, null);
            Object wrapWithContinuationImpl = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function2, r, actualCompletion$iv) : ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, actualCompletion$iv);
            ThreadContextKt.restoreThreadContext(context$iv, oldValue$iv);
            Object value$iv = wrapWithContinuationImpl;
            if (value$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return;
            }
            Result.Companion companion = Result.Companion;
            actualCompletion$iv.resumeWith(Result.constructor-impl(value$iv));
        } catch (Throwable e$iv) {
            Result.Companion companion2 = Result.Companion;
            actualCompletion$iv.resumeWith(Result.constructor-impl(ResultKt.createFailure(e$iv)));
        }
    }

    private static final <T> void startDirect(Continuation<? super T> continuation, Function1<? super Continuation<? super T>, ? extends Object> function1) {
        Continuation actualCompletion = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            Object value = function1.invoke(actualCompletion);
            if (value != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Result.Companion companion = Result.Companion;
                actualCompletion.resumeWith(Result.constructor-impl(value));
            }
        } catch (Throwable e) {
            Result.Companion companion2 = Result.Companion;
            actualCompletion.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v3 */
    public static final <T, R> Object startUndispatchedOrReturn(ScopeCoroutine<? super T> scopeCoroutine, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object state$iv;
        CompletedExceptionally completedExceptionally = 2;
        try {
            completedExceptionally = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function2, r, scopeCoroutine) : ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, scopeCoroutine);
        } catch (Throwable e$iv) {
            completedExceptionally = new CompletedExceptionally(e$iv, false, completedExceptionally, null);
        }
        Throwable e$iv2 = completedExceptionally;
        if (e$iv2 != IntrinsicsKt.getCOROUTINE_SUSPENDED() && (state$iv = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(e$iv2)) != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if (state$iv instanceof CompletedExceptionally) {
                Throwable th = ((CompletedExceptionally) state$iv).cause;
                Throwable exception$iv$iv = ((CompletedExceptionally) state$iv).cause;
                Continuation continuation$iv$iv = scopeCoroutine.uCont;
                if (DebugKt.getRECOVER_STACK_TRACES() && (continuation$iv$iv instanceof CoroutineStackFrame)) {
                    throw StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv$iv, (CoroutineStackFrame) continuation$iv$iv);
                }
                throw exception$iv$iv;
            }
            return JobSupportKt.unboxState(state$iv);
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v3 */
    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(ScopeCoroutine<? super T> scopeCoroutine, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object state$iv;
        Object state$iv2;
        CompletedExceptionally completedExceptionally = 2;
        boolean z = false;
        try {
            completedExceptionally = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function2, r, scopeCoroutine) : ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, scopeCoroutine);
        } catch (Throwable e$iv) {
            completedExceptionally = new CompletedExceptionally(e$iv, false, completedExceptionally, null);
        }
        Throwable e$iv2 = completedExceptionally;
        if (e$iv2 != IntrinsicsKt.getCOROUTINE_SUSPENDED() && (state$iv = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(e$iv2)) != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if (state$iv instanceof CompletedExceptionally) {
                Throwable e = ((CompletedExceptionally) state$iv).cause;
                if (((e instanceof TimeoutCancellationException) && ((TimeoutCancellationException) e).coroutine == scopeCoroutine) ? true : true) {
                    Throwable exception$iv$iv = ((CompletedExceptionally) state$iv).cause;
                    Continuation continuation$iv$iv = scopeCoroutine.uCont;
                    if (DebugKt.getRECOVER_STACK_TRACES() && (continuation$iv$iv instanceof CoroutineStackFrame)) {
                        throw StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv$iv, (CoroutineStackFrame) continuation$iv$iv);
                    }
                    throw exception$iv$iv;
                } else if (e$iv2 instanceof CompletedExceptionally) {
                    Throwable exception$iv$iv2 = ((CompletedExceptionally) e$iv2).cause;
                    Continuation continuation$iv$iv2 = scopeCoroutine.uCont;
                    if (DebugKt.getRECOVER_STACK_TRACES() && (continuation$iv$iv2 instanceof CoroutineStackFrame)) {
                        throw StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv$iv2, (CoroutineStackFrame) continuation$iv$iv2);
                    }
                    throw exception$iv$iv2;
                } else {
                    state$iv2 = e$iv2;
                }
            } else {
                state$iv2 = JobSupportKt.unboxState(state$iv);
            }
            return state$iv2;
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    private static final <T> Object undispatchedResult(ScopeCoroutine<? super T> scopeCoroutine, Function1<? super Throwable, Boolean> function1, Function0<? extends Object> function0) {
        Object result;
        Object state;
        try {
            result = function0.invoke();
        } catch (Throwable e) {
            result = new CompletedExceptionally(e, false, 2, null);
        }
        if (result != IntrinsicsKt.getCOROUTINE_SUSPENDED() && (state = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(result)) != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if (state instanceof CompletedExceptionally) {
                if (!function1.invoke(((CompletedExceptionally) state).cause).booleanValue()) {
                    if (!(result instanceof CompletedExceptionally)) {
                        return result;
                    }
                    Throwable exception$iv = ((CompletedExceptionally) result).cause;
                    Continuation continuation$iv = scopeCoroutine.uCont;
                    if (DebugKt.getRECOVER_STACK_TRACES() && (continuation$iv instanceof CoroutineStackFrame)) {
                        throw StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv, (CoroutineStackFrame) continuation$iv);
                    }
                    throw exception$iv;
                }
                Throwable exception$iv2 = ((CompletedExceptionally) state).cause;
                Continuation continuation$iv2 = scopeCoroutine.uCont;
                if (DebugKt.getRECOVER_STACK_TRACES() && (continuation$iv2 instanceof CoroutineStackFrame)) {
                    throw StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv2, (CoroutineStackFrame) continuation$iv2);
                }
                throw exception$iv2;
            }
            return JobSupportKt.unboxState(state);
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}