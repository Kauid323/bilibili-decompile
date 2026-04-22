package kotlinx.coroutines.selects;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectBuilder;

/* compiled from: Select.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001HB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u001a\u0010\u001d\u001a\u00020\u001b2\u0010\u0010\u001e\u001a\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u000e\u0010\u001f\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u000e\u0010$\u001a\u00028\u0000H\u0091@¢\u0006\u0002\u0010 J\u000e\u0010%\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u0010 J\u001c\u0010&\u001a\u000e\u0018\u00010\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0012\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001c\u0010*\u001a\u00020\u001b2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001a\u00020\u0014H\u0016J*\u0010.\u001a\u00028\u00002\u0010\u0010/\u001a\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0082@¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0012\u00102\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u00103\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u00105\u001a\u0002062\u0006\u0010\u001c\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u00010\u000eJ\u001a\u00107\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0002J\u000e\u00108\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010 J0\u0010'\u001a\u00020\u001b*\u0002092\u001c\u0010:\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0;H\u0096\u0002¢\u0006\u0002\u0010=JB\u0010'\u001a\u00020\u001b\"\u0004\b\u0001\u0010>*\b\u0012\u0004\u0012\u0002H>0?2\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H>\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0@H\u0096\u0002¢\u0006\u0002\u0010AJV\u0010'\u001a\u00020\u001b\"\u0004\b\u0001\u0010B\"\u0004\b\u0002\u0010>*\u000e\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u0002H>0C2\u0006\u0010D\u001a\u0002HB2\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H>\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000<\u0012\u0006\u0012\u0004\u0018\u00010\u000e0@H\u0096\u0002¢\u0006\u0002\u0010EJ \u0010F\u001a\u00020\u001b*\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010G\u001a\u00020\u0010H\u0001R$\u0010\b\u001a\u0014\u0012\u000e\u0012\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019X\u0082\u0004¨\u0006I"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "clauses", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "disposableHandleOrSegment", "", "inRegistrationPhase", "", "getInRegistrationPhase", "()Z", "indexInSegment", "", "internalResult", "isCancelled", "isSelected", "state", "Lkotlinx/atomicfu/AtomicRef;", "checkClauseObject", "", "clauseObject", "cleanup", "selectedClause", "complete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disposeOnCompletion", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "doSelect", "doSelectSuspend", "findClause", "invoke", "cause", "", "invokeOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "processResultAndInvokeBlockRecoveringException", "clause", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reregisterClause", "selectInRegistrationPhase", "trySelect", "result", "trySelectDetailed", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectInternal", "waitUntilSelected", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "register", "reregister", "ClauseData", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class SelectImplementation<R> implements CancelHandler, SelectBuilder<R>, SelectInstanceInternal<R> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state$volatile");
    private final CoroutineContext context;
    private Object disposableHandleOrSegment;
    private volatile /* synthetic */ Object state$volatile = SelectKt.access$getSTATE_REG$p();
    private List<SelectImplementation<R>.ClauseData> clauses = new ArrayList(2);
    private int indexInSegment = -1;
    private Object internalResult = SelectKt.access$getNO_RESULT$p();

    private final /* synthetic */ Object getState$volatile() {
        return this.state$volatile;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final /* synthetic */ void setState$volatile(Object obj) {
        this.state$volatile = obj;
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, obj, obj2, function1.invoke(obj2)));
    }

    public Object doSelect(Continuation<? super R> continuation) {
        return doSelect$suspendImpl(this, continuation);
    }

    public SelectImplementation(CoroutineContext context) {
        this.context = context;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.DefaultImpls.invoke(this, selectClause2, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @ReplaceWith(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
    public void onTimeout(long timeMillis, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        SelectBuilder.DefaultImpls.onTimeout(this, timeMillis, function1);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public CoroutineContext getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getInRegistrationPhase() {
        Object it = state$volatile$FU.get(this);
        return it == SelectKt.access$getSTATE_REG$p() || (it instanceof List);
    }

    private final boolean isSelected() {
        return state$volatile$FU.get(this) instanceof ClauseData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCancelled() {
        return state$volatile$FU.get(this) == SelectKt.access$getSTATE_CANCELLED$p();
    }

    static /* synthetic */ <R> Object doSelect$suspendImpl(SelectImplementation<R> selectImplementation, Continuation<? super R> continuation) {
        return selectImplementation.isSelected() ? selectImplementation.complete(continuation) : selectImplementation.doSelectSuspend(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doSelectSuspend(Continuation<? super R> continuation) {
        SelectImplementation$doSelectSuspend$1 selectImplementation$doSelectSuspend$1;
        SelectImplementation$doSelectSuspend$1 selectImplementation$doSelectSuspend$12;
        Object coroutine_suspended;
        SelectImplementation selectImplementation;
        Object complete;
        if (continuation instanceof SelectImplementation$doSelectSuspend$1) {
            selectImplementation$doSelectSuspend$1 = (SelectImplementation$doSelectSuspend$1) continuation;
            if ((selectImplementation$doSelectSuspend$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                selectImplementation$doSelectSuspend$1.label -= IntCompanionObject.MIN_VALUE;
                selectImplementation$doSelectSuspend$12 = selectImplementation$doSelectSuspend$1;
                Object $result = selectImplementation$doSelectSuspend$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (selectImplementation$doSelectSuspend$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        SelectImplementation selectImplementation2 = this;
                        selectImplementation$doSelectSuspend$12.L$0 = selectImplementation2;
                        selectImplementation$doSelectSuspend$12.label = 1;
                        Object waitUntilSelected = selectImplementation2.waitUntilSelected(selectImplementation$doSelectSuspend$12);
                        selectImplementation = selectImplementation2;
                        if (waitUntilSelected == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        selectImplementation = (SelectImplementation) selectImplementation$doSelectSuspend$12.L$0;
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                selectImplementation$doSelectSuspend$12.L$0 = null;
                selectImplementation$doSelectSuspend$12.label = 2;
                complete = selectImplementation.complete(selectImplementation$doSelectSuspend$12);
                if (complete != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return complete;
            }
        }
        selectImplementation$doSelectSuspend$1 = new SelectImplementation$doSelectSuspend$1(this, continuation);
        selectImplementation$doSelectSuspend$12 = selectImplementation$doSelectSuspend$1;
        Object $result2 = selectImplementation$doSelectSuspend$12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (selectImplementation$doSelectSuspend$12.label) {
        }
        selectImplementation$doSelectSuspend$12.L$0 = null;
        selectImplementation$doSelectSuspend$12.label = 2;
        complete = selectImplementation.complete(selectImplementation$doSelectSuspend$12);
        if (complete != coroutine_suspended) {
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause0 $this$invoke, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        register$default(this, new ClauseData($this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), function1, $this$invoke.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        register$default(this, new ClauseData(selectClause1.getClauseObject(), selectClause1.getRegFunc(), selectClause1.getProcessResFunc(), null, function2, selectClause1.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        register$default(this, new ClauseData(selectClause2.getClauseObject(), selectClause2.getRegFunc(), selectClause2.getProcessResFunc(), p, function2, selectClause2.getOnCancellationConstructor()), false, 1, null);
    }

    public static /* synthetic */ void register$default(SelectImplementation selectImplementation, ClauseData clauseData, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        selectImplementation.register(clauseData, z);
    }

    public final void register(SelectImplementation<R>.ClauseData clauseData, boolean reregister) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(state$volatile$FU.get(this) != SelectKt.access$getSTATE_CANCELLED$p())) {
                throw new AssertionError();
            }
        }
        Object it = state$volatile$FU.get(this);
        if (it instanceof ClauseData) {
            return;
        }
        if (!reregister) {
            checkClauseObject(clauseData.clauseObject);
        }
        if (clauseData.tryRegisterAsWaiter(this)) {
            if (!reregister) {
                List<SelectImplementation<R>.ClauseData> list = this.clauses;
                Intrinsics.checkNotNull(list);
                list.add(clauseData);
            }
            clauseData.disposableHandleOrSegment = this.disposableHandleOrSegment;
            clauseData.indexInSegment = this.indexInSegment;
            this.disposableHandleOrSegment = null;
            this.indexInSegment = -1;
            return;
        }
        state$volatile$FU.set(this, clauseData);
    }

    private final void checkClauseObject(Object clauseObject) {
        ClauseData it;
        Iterable clauses = this.clauses;
        Intrinsics.checkNotNull(clauses);
        Iterable $this$none$iv = clauses;
        boolean z = true;
        if (!($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
            Iterator<T> it2 = $this$none$iv.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object element$iv = it2.next();
                ClauseData it3 = (ClauseData) element$iv;
                if (it3.clauseObject == clauseObject) {
                    it = 1;
                    continue;
                } else {
                    it = null;
                    continue;
                }
                if (it != null) {
                    z = false;
                    break;
                }
            }
        }
        if (!z) {
            throw new IllegalStateException(("Cannot use select clauses on the same object: " + clauseObject).toString());
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnCompletion(DisposableHandle disposableHandle) {
        this.disposableHandleOrSegment = disposableHandle;
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(Segment<?> segment, int index) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = index;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void selectInRegistrationPhase(Object internalResult) {
        this.internalResult = internalResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0084, code lost:
        r2 = r4.getResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008d, code lost:
        if (r2 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008f, code lost:
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (r2 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009c, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitUntilSelected(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl cont = cancellable$iv;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = state$volatile$FU;
        while (true) {
            Object curState = handler$atomicfu$iv.get(this);
            if (curState == SelectKt.access$getSTATE_REG$p()) {
                if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(state$volatile$FU, this, curState, cont)) {
                    CancellableContinuationKt.invokeOnCancellation(cont, this);
                    break;
                }
            } else if (curState instanceof List) {
                if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(state$volatile$FU, this, curState, SelectKt.access$getSTATE_REG$p())) {
                    List list = (List) curState;
                    Iterable $this$forEach$iv = (Iterable) curState;
                    for (Object element$iv : $this$forEach$iv) {
                        reregisterClause(element$iv);
                    }
                }
            } else if (curState instanceof ClauseData) {
                cont.resume(Unit.INSTANCE, ((ClauseData) curState).createOnCancellationAction(this, this.internalResult));
            } else {
                throw new IllegalStateException(("unexpected state: " + curState).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reregisterClause(Object clauseObject) {
        ClauseData clause = findClause(clauseObject);
        Intrinsics.checkNotNull(clause);
        clause.disposableHandleOrSegment = null;
        clause.indexInSegment = -1;
        register(clause, true);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect(Object clauseObject, Object result) {
        return trySelectInternal(clauseObject, result) == 0;
    }

    public final TrySelectDetailedResult trySelectDetailed(Object clauseObject, Object result) {
        return SelectKt.access$TrySelectDetailedResult(trySelectInternal(clauseObject, result));
    }

    private final int trySelectInternal(Object clauseObject, Object internalResult) {
        while (true) {
            Object curState = state$volatile$FU.get(this);
            if (curState instanceof CancellableContinuation) {
                ClauseData clause = findClause(clauseObject);
                if (clause == null) {
                    continue;
                } else {
                    Function1 onCancellation = clause.createOnCancellationAction(this, internalResult);
                    if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(state$volatile$FU, this, curState, clause)) {
                        CancellableContinuation cont = (CancellableContinuation) curState;
                        this.internalResult = internalResult;
                        if (SelectKt.access$tryResume(cont, onCancellation)) {
                            return 0;
                        }
                        this.internalResult = SelectKt.access$getNO_RESULT$p();
                        return 2;
                    }
                }
            } else {
                if (Intrinsics.areEqual(curState, SelectKt.access$getSTATE_COMPLETED$p()) ? true : curState instanceof ClauseData) {
                    return 3;
                }
                if (Intrinsics.areEqual(curState, SelectKt.access$getSTATE_CANCELLED$p())) {
                    return 2;
                }
                if (Intrinsics.areEqual(curState, SelectKt.access$getSTATE_REG$p())) {
                    if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(state$volatile$FU, this, curState, CollectionsKt.listOf(clauseObject))) {
                        return 1;
                    }
                } else if (!(curState instanceof List)) {
                    throw new IllegalStateException(("Unexpected state: " + curState).toString());
                } else {
                    if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(state$volatile$FU, this, curState, CollectionsKt.plus((Collection<? extends Object>) curState, clauseObject))) {
                        return 1;
                    }
                }
            }
        }
    }

    private final SelectImplementation<R>.ClauseData findClause(Object clauseObject) {
        boolean z;
        List clauses = this.clauses;
        Object obj = null;
        if (clauses == null) {
            return null;
        }
        Iterator<T> it = clauses.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ClauseData it2 = (ClauseData) next;
            if (it2.clauseObject == clauseObject) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        SelectImplementation<R>.ClauseData clauseData = (ClauseData) obj;
        if (clauseData != null) {
            return clauseData;
        }
        throw new IllegalStateException(("Clause with object " + clauseObject + " is not found").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object complete(Continuation<? super R> continuation) {
        if (!DebugKt.getASSERTIONS_ENABLED() || isSelected()) {
            Object obj = state$volatile$FU.get(this);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
            ClauseData selectedClause = (ClauseData) obj;
            Object internalResult = this.internalResult;
            cleanup(selectedClause);
            if (!DebugKt.getRECOVER_STACK_TRACES()) {
                Object blockArgument = selectedClause.processResult(internalResult);
                return selectedClause.invokeBlock(blockArgument, continuation);
            }
            Object blockArgument2 = processResultAndInvokeBlockRecoveringException(selectedClause, internalResult, continuation);
            return blockArgument2;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d A[Catch: all -> 0x0032, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002d, B:17:0x0038), top: B:30:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processResultAndInvokeBlockRecoveringException(SelectImplementation<R>.ClauseData clauseData, Object internalResult, Continuation<? super R> continuation) {
        SelectImplementation$processResultAndInvokeBlockRecoveringException$1 selectImplementation$processResultAndInvokeBlockRecoveringException$1;
        SelectImplementation$processResultAndInvokeBlockRecoveringException$1 selectImplementation$processResultAndInvokeBlockRecoveringException$12;
        try {
            if (continuation instanceof SelectImplementation$processResultAndInvokeBlockRecoveringException$1) {
                selectImplementation$processResultAndInvokeBlockRecoveringException$1 = (SelectImplementation$processResultAndInvokeBlockRecoveringException$1) continuation;
                if ((selectImplementation$processResultAndInvokeBlockRecoveringException$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                    selectImplementation$processResultAndInvokeBlockRecoveringException$1.label -= IntCompanionObject.MIN_VALUE;
                    selectImplementation$processResultAndInvokeBlockRecoveringException$12 = selectImplementation$processResultAndInvokeBlockRecoveringException$1;
                    Object $result = selectImplementation$processResultAndInvokeBlockRecoveringException$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (selectImplementation$processResultAndInvokeBlockRecoveringException$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Object blockArgument = clauseData.processResult(internalResult);
                            selectImplementation$processResultAndInvokeBlockRecoveringException$12.label = 1;
                            Object invokeBlock = clauseData.invokeBlock(blockArgument, selectImplementation$processResultAndInvokeBlockRecoveringException$12);
                            if (invokeBlock == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return invokeBlock;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            return $result;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (selectImplementation$processResultAndInvokeBlockRecoveringException$12.label) {
            }
        } catch (Throwable e) {
            if (!DebugKt.getRECOVER_STACK_TRACES()) {
                throw e;
            }
            if (selectImplementation$processResultAndInvokeBlockRecoveringException$12 instanceof CoroutineStackFrame) {
                throw StackTraceRecoveryKt.recoverFromStackFrame(e, selectImplementation$processResultAndInvokeBlockRecoveringException$12);
            }
            throw e;
        }
        selectImplementation$processResultAndInvokeBlockRecoveringException$1 = new SelectImplementation$processResultAndInvokeBlockRecoveringException$1(this, continuation);
        selectImplementation$processResultAndInvokeBlockRecoveringException$12 = selectImplementation$processResultAndInvokeBlockRecoveringException$1;
        Object $result2 = selectImplementation$processResultAndInvokeBlockRecoveringException$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    private final void cleanup(SelectImplementation<R>.ClauseData clauseData) {
        if (DebugKt.getASSERTIONS_ENABLED() && !Intrinsics.areEqual(state$volatile$FU.get(this), clauseData)) {
            throw new AssertionError();
        }
        Iterable clauses = this.clauses;
        if (clauses == null) {
            return;
        }
        Iterable $this$forEach$iv = clauses;
        for (Object element$iv : $this$forEach$iv) {
            ClauseData clause = (ClauseData) element$iv;
            if (clause != clauseData) {
                clause.dispose();
            }
        }
        state$volatile$FU.set(this, SelectKt.access$getSTATE_COMPLETED$p());
        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = null;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public void invoke(Throwable cause) {
        Object cur;
        AtomicReferenceFieldUpdater handler$atomicfu$iv = state$volatile$FU;
        do {
            cur = handler$atomicfu$iv.get(this);
            if (cur == SelectKt.access$getSTATE_COMPLETED$p()) {
                return;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(handler$atomicfu$iv, this, cur, SelectKt.access$getSTATE_CANCELLED$p()));
        Iterable clauses = this.clauses;
        if (clauses == null) {
            return;
        }
        Iterable $this$forEach$iv = clauses;
        for (Object element$iv : $this$forEach$iv) {
            ClauseData it = (ClauseData) element$iv;
            it.dispose();
        }
        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = null;
    }

    /* compiled from: Select.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B¶\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012U\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000b\u0012U\u0010\f\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000e\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012g\u0010\u0010\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012\u0018\u00010\u0004j\u0004\u0018\u0001`\u0014¢\u0006\u0002\u0010\u0015J*\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u001a\u001a\u00020\nJ\u0018\u0010\u001b\u001a\u00028\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0086@¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001J\u0014\u0010 \u001a\u00020!2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\"R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000Rq\u0010\u0010\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012\u0018\u00010\u0004j\u0004\u0018\u0001`\u00148\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R]\u0010\f\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R]\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "clauseObject", "regFunc", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "param", "", "Lkotlinx/coroutines/selects/RegistrationFunction;", "processResFunc", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "block", "onCancellationConstructor", "internalResult", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "disposableHandleOrSegment", "indexInSegment", "", "createOnCancellationAction", "dispose", "invokeBlock", "argument", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processResult", "result", "tryRegisterAsWaiter", "", "Lkotlinx/coroutines/selects/SelectImplementation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final class ClauseData {
        private final Object block;
        public final Object clauseObject;
        public Object disposableHandleOrSegment;
        public int indexInSegment = -1;
        public final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;
        private final Object param;
        private final Function3<Object, Object, Object, Object> processResFunc;
        private final Function3<Object, SelectInstance<?>, Object, Unit> regFunc;

        /* JADX WARN: Multi-variable type inference failed */
        public ClauseData(Object clauseObject, Function3<Object, ? super SelectInstance<?>, Object, Unit> function3, Function3<Object, Object, Object, ? extends Object> function32, Object param, Object block, Function3<? super SelectInstance<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> function33) {
            this.clauseObject = clauseObject;
            this.regFunc = function3;
            this.processResFunc = function32;
            this.param = param;
            this.block = block;
            this.onCancellationConstructor = function33;
        }

        public final boolean tryRegisterAsWaiter(SelectImplementation<R> selectImplementation) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (((selectImplementation.getInRegistrationPhase() || selectImplementation.isCancelled()) ? 1 : 0) == 0) {
                    throw new AssertionError();
                }
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if ((((SelectImplementation) selectImplementation).internalResult == SelectKt.access$getNO_RESULT$p() ? 1 : 0) == 0) {
                    throw new AssertionError();
                }
            }
            this.regFunc.invoke(this.clauseObject, selectImplementation, this.param);
            return ((SelectImplementation) selectImplementation).internalResult == SelectKt.access$getNO_RESULT$p();
        }

        public final Object processResult(Object result) {
            return this.processResFunc.invoke(this.clauseObject, this.param, result);
        }

        public final Object invokeBlock(Object argument, Continuation<? super R> continuation) {
            Object block = this.block;
            if (this.param == SelectKt.getPARAM_CLAUSE_0()) {
                Intrinsics.checkNotNull(block, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                Function1 function1 = (Function1) block;
                return ((Function1) block).invoke(continuation);
            }
            Intrinsics.checkNotNull(block, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            Function2 function2 = (Function2) block;
            return ((Function2) block).invoke(argument, continuation);
        }

        public final void dispose() {
            Object $this$dispose_u24lambda_u242 = this.disposableHandleOrSegment;
            SelectImplementation<R> selectImplementation = SelectImplementation.this;
            if ($this$dispose_u24lambda_u242 instanceof Segment) {
                ((Segment) $this$dispose_u24lambda_u242).onCancellation(this.indexInSegment, null, selectImplementation.getContext());
                return;
            }
            DisposableHandle disposableHandle = $this$dispose_u24lambda_u242 instanceof DisposableHandle ? (DisposableHandle) $this$dispose_u24lambda_u242 : null;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }

        public final Function1<Throwable, Unit> createOnCancellationAction(SelectInstance<?> selectInstance, Object internalResult) {
            Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> function3 = this.onCancellationConstructor;
            if (function3 != null) {
                return function3.invoke(selectInstance, this.param, internalResult);
            }
            return null;
        }
    }
}