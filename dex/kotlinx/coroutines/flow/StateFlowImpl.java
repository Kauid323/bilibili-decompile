package kotlinx.coroutines.flow;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StateFlow.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0003H\u0014J\u001d\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\"2\u0006\u0010#\u001a\u00020\u0011H\u0014¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020&2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010'J&\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020&H\u0016J\u0015\u00100\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u001a\u00102\u001a\u00020\u001c2\b\u00103\u001a\u0004\u0018\u00010\b2\u0006\u00104\u001a\u00020\bH\u0002R\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\t¨\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "initialState", "", "(Ljava/lang/Object;)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "sequence", "", "value", "getValue", "()Ljava/lang/Object;", "setValue", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compareAndSet", "", "expect", "update", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "createSlot", "createSlotArray", "", "size", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "emit", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "resetReplayCache", "tryEmit", "(Ljava/lang/Object;)Z", "updateState", "expectedState", "newState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    private int sequence;

    private final /* synthetic */ Object get_state$volatile() {
        return this._state$volatile;
    }

    private final /* synthetic */ void set_state$volatile(Object obj) {
        this._state$volatile = obj;
    }

    public StateFlowImpl(Object initialState) {
        this._state$volatile = initialState;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol this_$iv = NullSurrogateKt.NULL;
        T t = (T) _state$volatile$FU.get(this);
        if (t == this_$iv) {
            return null;
        }
        return t;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t) {
        updateState(null, t == null ? NullSurrogateKt.NULL : t);
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T t, T t2) {
        return updateState(t == null ? NullSurrogateKt.NULL : t, t2 == null ? NullSurrogateKt.NULL : t2);
    }

    private final boolean updateState(Object expectedState, Object newState) {
        synchronized (this) {
            Object oldState = _state$volatile$FU.get(this);
            if (expectedState != null && !Intrinsics.areEqual(oldState, expectedState)) {
                return false;
            }
            if (Intrinsics.areEqual(oldState, newState)) {
                return true;
            }
            _state$volatile$FU.set(this, newState);
            int curSequence = this.sequence;
            if ((curSequence & 1) == 0) {
                int curSequence2 = curSequence + 1;
                this.sequence = curSequence2;
                Object curSlots = getSlots();
                Unit unit = Unit.INSTANCE;
                while (true) {
                    StateFlowSlot[] stateFlowSlotArr = (StateFlowSlot[]) curSlots;
                    if (stateFlowSlotArr != null) {
                        for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                            if (stateFlowSlot != null) {
                                stateFlowSlot.makePending();
                            }
                        }
                    }
                    synchronized (this) {
                        if (this.sequence == curSequence2) {
                            this.sequence = curSequence2 + 1;
                            return true;
                        }
                        curSequence2 = this.sequence;
                        curSlots = getSlots();
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            } else {
                this.sequence = curSequence + 2;
                return true;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        return CollectionsKt.listOf(getValue());
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t) {
        setValue(t);
        return true;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae A[Catch: all -> 0x00f7, TryCatch #0 {all -> 0x00f7, blocks: (B:13:0x003f, B:29:0x00a4, B:31:0x00ae, B:33:0x00b3, B:44:0x00dc, B:46:0x00e2, B:35:0x00b9, B:39:0x00c1, B:16:0x0059, B:19:0x006c, B:28:0x0094, B:22:0x007c, B:24:0x0080), top: B:53:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b3 A[Catch: all -> 0x00f7, TryCatch #0 {all -> 0x00f7, blocks: (B:13:0x003f, B:29:0x00a4, B:31:0x00ae, B:33:0x00b3, B:44:0x00dc, B:46:0x00e2, B:35:0x00b9, B:39:0x00c1, B:16:0x0059, B:19:0x006c, B:28:0x0094, B:22:0x007c, B:24:0x0080), top: B:53:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e2 A[Catch: all -> 0x00f7, TRY_LEAVE, TryCatch #0 {all -> 0x00f7, blocks: (B:13:0x003f, B:29:0x00a4, B:31:0x00ae, B:33:0x00b3, B:44:0x00dc, B:46:0x00e2, B:35:0x00b9, B:39:0x00c1, B:16:0x0059, B:19:0x006c, B:28:0x0094, B:22:0x007c, B:24:0x0080), top: B:53:0x0022 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e0 -> B:29:0x00a4). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00f3 -> B:29:0x00a4). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        StateFlowImpl$collect$1 stateFlowImpl$collect$1;
        StateFlowImpl$collect$1 stateFlowImpl$collect$12;
        Object coroutine_suspended;
        StateFlowImpl stateFlowImpl;
        StateFlowSlot slot;
        Job collectorJob;
        Object oldState;
        Object newState;
        FlowCollector<? super T> flowCollector2;
        Object newState2;
        Object obj;
        try {
            if (continuation instanceof StateFlowImpl$collect$1) {
                stateFlowImpl$collect$1 = (StateFlowImpl$collect$1) continuation;
                if ((stateFlowImpl$collect$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                    stateFlowImpl$collect$1.label -= IntCompanionObject.MIN_VALUE;
                    stateFlowImpl$collect$12 = stateFlowImpl$collect$1;
                    Object $result = stateFlowImpl$collect$12.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (stateFlowImpl$collect$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            stateFlowImpl = this;
                            slot = stateFlowImpl.allocateSlot();
                            if (flowCollector instanceof SubscribedFlowCollector) {
                                stateFlowImpl$collect$12.L$0 = stateFlowImpl;
                                stateFlowImpl$collect$12.L$1 = flowCollector;
                                stateFlowImpl$collect$12.L$2 = slot;
                                stateFlowImpl$collect$12.label = 1;
                                if (((SubscribedFlowCollector) flowCollector).onSubscription(stateFlowImpl$collect$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            collectorJob = (Job) stateFlowImpl$collect$12.getContext().get(Job.Key);
                            oldState = null;
                            break;
                        case 1:
                            Object newState3 = stateFlowImpl$collect$12.L$2;
                            slot = (StateFlowSlot) newState3;
                            flowCollector = (FlowCollector) stateFlowImpl$collect$12.L$1;
                            stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$12.L$0;
                            ResultKt.throwOnFailure($result);
                            collectorJob = (Job) stateFlowImpl$collect$12.getContext().get(Job.Key);
                            oldState = null;
                            break;
                        case 2:
                            newState = stateFlowImpl$collect$12.L$4;
                            collectorJob = (Job) stateFlowImpl$collect$12.L$3;
                            slot = (StateFlowSlot) stateFlowImpl$collect$12.L$2;
                            flowCollector2 = (FlowCollector) stateFlowImpl$collect$12.L$1;
                            stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$12.L$0;
                            ResultKt.throwOnFailure($result);
                            FlowCollector<? super T> flowCollector3 = flowCollector2;
                            oldState = newState;
                            flowCollector = flowCollector3;
                            if (!slot.takePending()) {
                                stateFlowImpl$collect$12.L$0 = stateFlowImpl;
                                stateFlowImpl$collect$12.L$1 = flowCollector;
                                stateFlowImpl$collect$12.L$2 = slot;
                                stateFlowImpl$collect$12.L$3 = collectorJob;
                                stateFlowImpl$collect$12.L$4 = oldState;
                                stateFlowImpl$collect$12.label = 3;
                                if (slot.awaitPending(stateFlowImpl$collect$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            break;
                        case 3:
                            Object oldState2 = stateFlowImpl$collect$12.L$4;
                            collectorJob = (Job) stateFlowImpl$collect$12.L$3;
                            slot = (StateFlowSlot) stateFlowImpl$collect$12.L$2;
                            FlowCollector<? super T> flowCollector4 = (FlowCollector) stateFlowImpl$collect$12.L$1;
                            stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$12.L$0;
                            ResultKt.throwOnFailure($result);
                            oldState = oldState2;
                            flowCollector = flowCollector4;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    newState2 = _state$volatile$FU.get(stateFlowImpl);
                    if (collectorJob != null) {
                        JobKt.ensureActive(collectorJob);
                    }
                    if (oldState != null || !Intrinsics.areEqual(oldState, newState2)) {
                        Object oldState3 = NullSurrogateKt.NULL;
                        obj = newState2 == oldState3 ? null : newState2;
                        stateFlowImpl$collect$12.L$0 = stateFlowImpl;
                        stateFlowImpl$collect$12.L$1 = flowCollector;
                        stateFlowImpl$collect$12.L$2 = slot;
                        stateFlowImpl$collect$12.L$3 = collectorJob;
                        stateFlowImpl$collect$12.L$4 = newState2;
                        stateFlowImpl$collect$12.label = 2;
                        if (flowCollector.emit(obj, stateFlowImpl$collect$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowCollector2 = flowCollector;
                        newState = newState2;
                        FlowCollector<? super T> flowCollector32 = flowCollector2;
                        oldState = newState;
                        flowCollector = flowCollector32;
                    }
                    if (!slot.takePending()) {
                    }
                    newState2 = _state$volatile$FU.get(stateFlowImpl);
                    if (collectorJob != null) {
                    }
                    if (oldState != null) {
                    }
                    Object oldState32 = NullSurrogateKt.NULL;
                    if (newState2 == oldState32) {
                    }
                    stateFlowImpl$collect$12.L$0 = stateFlowImpl;
                    stateFlowImpl$collect$12.L$1 = flowCollector;
                    stateFlowImpl$collect$12.L$2 = slot;
                    stateFlowImpl$collect$12.L$3 = collectorJob;
                    stateFlowImpl$collect$12.L$4 = newState2;
                    stateFlowImpl$collect$12.label = 2;
                    if (flowCollector.emit(obj, stateFlowImpl$collect$12) == coroutine_suspended) {
                    }
                }
            }
            switch (stateFlowImpl$collect$12.label) {
            }
            newState2 = _state$volatile$FU.get(stateFlowImpl);
            if (collectorJob != null) {
            }
            if (oldState != null) {
            }
            Object oldState322 = NullSurrogateKt.NULL;
            if (newState2 == oldState322) {
            }
            stateFlowImpl$collect$12.L$0 = stateFlowImpl;
            stateFlowImpl$collect$12.L$1 = flowCollector;
            stateFlowImpl$collect$12.L$2 = slot;
            stateFlowImpl$collect$12.L$3 = collectorJob;
            stateFlowImpl$collect$12.L$4 = newState2;
            stateFlowImpl$collect$12.label = 2;
            if (flowCollector.emit(obj, stateFlowImpl$collect$12) == coroutine_suspended) {
            }
        } catch (Throwable th) {
            stateFlowImpl.freeSlot(slot);
            throw th;
        }
        stateFlowImpl$collect$1 = new StateFlowImpl$collect$1(this, continuation);
        stateFlowImpl$collect$12 = stateFlowImpl$collect$1;
        Object $result2 = stateFlowImpl$collect$12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot[] createSlotArray(int size) {
        return new StateFlowSlot[size];
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, context, capacity, onBufferOverflow);
    }
}