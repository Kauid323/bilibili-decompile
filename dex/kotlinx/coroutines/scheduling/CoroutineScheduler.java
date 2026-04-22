package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: CoroutineScheduler.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0000\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0003IJKB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0011\u0010\r\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0086\bJ\u0011\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0082\bJ\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0004H\u0002J\u001a\u0010&\u001a\u00020 2\n\u0010'\u001a\u00060(j\u0002`)2\u0006\u0010*\u001a\u00020+J\u0011\u0010\u0012\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0082\bJ\u000e\u0010,\u001a\b\u0018\u00010\u001dR\u00020\u0000H\u0002J\t\u0010-\u001a\u00020$H\u0082\bJ\t\u0010.\u001a\u00020\u0004H\u0082\bJ&\u0010/\u001a\u00020$2\n\u0010'\u001a\u00060(j\u0002`)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00100\u001a\u00020\u0018J\u0014\u00101\u001a\u00020$2\n\u00102\u001a\u00060(j\u0002`)H\u0016J\t\u00103\u001a\u00020\u0007H\u0082\bJ\t\u00104\u001a\u00020\u0004H\u0082\bJ\u0014\u00105\u001a\u00020\u00042\n\u00106\u001a\u00060\u001dR\u00020\u0000H\u0002J\u000e\u00107\u001a\b\u0018\u00010\u001dR\u00020\u0000H\u0002J\u0012\u00108\u001a\u00020\u00182\n\u00106\u001a\u00060\u001dR\u00020\u0000J\"\u00109\u001a\u00020$2\n\u00106\u001a\u00060\u001dR\u00020\u00002\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0004J\t\u0010<\u001a\u00020\u0007H\u0082\bJ\u000e\u0010=\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020\u0007J\u0018\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0018H\u0002J\u0006\u0010C\u001a\u00020$J\b\u0010D\u001a\u00020\tH\u0016J\t\u0010E\u001a\u00020\u0018H\u0082\bJ\u0012\u0010F\u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0007H\u0002J\b\u0010G\u001a\u00020\u0018H\u0002J$\u0010H\u001a\u0004\u0018\u00010 *\b\u0018\u00010\u001dR\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u00100\u001a\u00020\u0018H\u0002R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0015\u0010\r\u001a\u00020\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\t\u0010\u0010\u001a\u00020\u0011X\u0082\u0004R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0012\u001a\u00020\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0010\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\t\u0010\u001a\u001a\u00020\u0011X\u0082\u0004R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u001dR\u00020\u00000\u001c8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "(IIJLjava/lang/String;)V", "_isTerminated", "Lkotlinx/atomicfu/AtomicBoolean;", "availableCpuPermits", "getAvailableCpuPermits", "()I", "controlState", "Lkotlinx/atomicfu/AtomicLong;", "createdWorkers", "getCreatedWorkers", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "isTerminated", "", "()Z", "parkedWorkersStack", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "addToGlobalQueue", "task", "Lkotlinx/coroutines/scheduling/Task;", "state", "blockingTasks", "close", "", "createNewWorker", "createTask", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "currentWorker", "decrementBlockingTasks", "decrementCreatedWorkers", "dispatch", "tailDispatch", "execute", "command", "incrementBlockingTasks", "incrementCreatedWorkers", "parkedWorkersStackNextIndex", "worker", "parkedWorkersStackPop", "parkedWorkersStackPush", "parkedWorkersStackTopUpdate", "oldIndex", "newIndex", "releaseCpuPermit", "runSafely", "shutdown", "timeout", "signalBlockingWork", "stateSnapshot", "skipUnpark", "signalCpuWork", "toString", "tryAcquireCpuPermit", "tryCreateWorker", "tryUnpark", "submitToLocalQueue", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CoroutineScheduler implements Executor, Closeable {
    private static final long BLOCKING_MASK = 4398044413952L;
    private static final int BLOCKING_SHIFT = 21;
    private static final int CLAIMED = 0;
    private static final long CPU_PERMITS_MASK = 9223367638808264704L;
    private static final int CPU_PERMITS_SHIFT = 42;
    private static final long CREATED_MASK = 2097151;
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    private static final int PARKED = -1;
    private static final long PARKED_INDEX_MASK = 2097151;
    private static final long PARKED_VERSION_INC = 2097152;
    private static final long PARKED_VERSION_MASK = -2097152;
    private static final int TERMINATED = 1;
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;
    public final String schedulerName;
    public final ResizableAtomicArray<Worker> workers;
    public static final Companion Companion = new Companion(null);
    private static final /* synthetic */ AtomicLongFieldUpdater parkedWorkersStack$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater controlState$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _isTerminated$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkerState.values().length];
            try {
                iArr[WorkerState.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WorkerState.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[WorkerState.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[WorkerState.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<WorkerState> getEntries() {
            return $ENTRIES;
        }
    }

    private final /* synthetic */ long getControlState$volatile() {
        return this.controlState$volatile;
    }

    private final /* synthetic */ long getParkedWorkersStack$volatile() {
        return this.parkedWorkersStack$volatile;
    }

    private final /* synthetic */ int get_isTerminated$volatile() {
        return this._isTerminated$volatile;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void setControlState$volatile(long j) {
        this.controlState$volatile = j;
    }

    private final /* synthetic */ void setParkedWorkersStack$volatile(long j) {
        this.parkedWorkersStack$volatile = j;
    }

    private final /* synthetic */ void set_isTerminated$volatile(int i) {
        this._isTerminated$volatile = i;
    }

    public CoroutineScheduler(int corePoolSize, int maxPoolSize, long idleWorkerKeepAliveNs, String schedulerName) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.idleWorkerKeepAliveNs = idleWorkerKeepAliveNs;
        this.schedulerName = schedulerName;
        if (!(this.corePoolSize >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + this.corePoolSize + " should be at least 1").toString());
        }
        if (!(this.maxPoolSize >= this.corePoolSize)) {
            throw new IllegalArgumentException(("Max pool size " + this.maxPoolSize + " should be greater than or equals to core pool size " + this.corePoolSize).toString());
        }
        if (!(this.maxPoolSize <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + this.maxPoolSize + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(this.idleWorkerKeepAliveNs > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + this.idleWorkerKeepAliveNs + " must be positive").toString());
        }
        this.globalCpuQueue = new GlobalQueue();
        this.globalBlockingQueue = new GlobalQueue();
        this.workers = new ResizableAtomicArray<>((this.corePoolSize + 1) * 2);
        this.controlState$volatile = this.corePoolSize << 42;
        this._isTerminated$volatile = 0;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater access$getControlState$volatile$FU() {
        return controlState$volatile$FU;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ CoroutineScheduler(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, r3, r5);
        long j2;
        String str2;
        if ((i3 & 4) == 0) {
            j2 = j;
        } else {
            j2 = TasksKt.IDLE_WORKER_KEEP_ALIVE_NS;
        }
        if ((i3 & 8) == 0) {
            str2 = str;
        } else {
            str2 = TasksKt.DEFAULT_SCHEDULER_NAME;
        }
    }

    private final boolean addToGlobalQueue(Task task) {
        if (task.taskContext.getTaskMode() == 1) {
            return this.globalBlockingQueue.addLast(task);
        }
        return this.globalCpuQueue.addLast(task);
    }

    public final void parkedWorkersStackTopUpdate(Worker worker, int oldIndex, int newIndex) {
        int i;
        AtomicLongFieldUpdater handler$atomicfu$iv = parkedWorkersStack$volatile$FU;
        while (true) {
            long top = handler$atomicfu$iv.get(this);
            int index = (int) (2097151 & top);
            long updVersion = (PARKED_VERSION_INC + top) & PARKED_VERSION_MASK;
            if (index == oldIndex) {
                if (newIndex == 0) {
                    i = parkedWorkersStackNextIndex(worker);
                } else {
                    i = newIndex;
                }
            } else {
                i = index;
            }
            int updIndex = i;
            if (updIndex >= 0 && parkedWorkersStack$volatile$FU.compareAndSet(this, top, updVersion | updIndex)) {
                return;
            }
        }
    }

    public final boolean parkedWorkersStackPush(Worker worker) {
        long top;
        long updVersion;
        int updIndex;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        AtomicLongFieldUpdater handler$atomicfu$iv = parkedWorkersStack$volatile$FU;
        do {
            top = handler$atomicfu$iv.get(this);
            int index = (int) (2097151 & top);
            updVersion = (PARKED_VERSION_INC + top) & PARKED_VERSION_MASK;
            updIndex = worker.getIndexInArray();
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if ((updIndex != 0 ? 1 : 0) == 0) {
                    throw new AssertionError();
                }
            }
            worker.setNextParkedWorker(this.workers.get(index));
        } while (!parkedWorkersStack$volatile$FU.compareAndSet(this, top, updVersion | updIndex));
        return true;
    }

    private final Worker parkedWorkersStackPop() {
        AtomicLongFieldUpdater handler$atomicfu$iv = parkedWorkersStack$volatile$FU;
        while (true) {
            long top = handler$atomicfu$iv.get(this);
            int index = (int) (2097151 & top);
            Worker worker = this.workers.get(index);
            if (worker == null) {
                return null;
            }
            long updVersion = (PARKED_VERSION_INC + top) & PARKED_VERSION_MASK;
            int updIndex = parkedWorkersStackNextIndex(worker);
            if (updIndex >= 0 && parkedWorkersStack$volatile$FU.compareAndSet(this, top, updVersion | updIndex)) {
                worker.setNextParkedWorker(NOT_IN_STACK);
                return worker;
            }
        }
    }

    private final int parkedWorkersStackNextIndex(Worker worker) {
        Object next = worker.getNextParkedWorker();
        while (next != NOT_IN_STACK) {
            if (next == null) {
                return 0;
            }
            Worker nextWorker = (Worker) next;
            int updIndex = nextWorker.getIndexInArray();
            if (updIndex != 0) {
                return updIndex;
            }
            next = nextWorker.getNextParkedWorker();
        }
        return -1;
    }

    private final int getCreatedWorkers() {
        return (int) (access$getControlState$volatile$FU().get(this) & 2097151);
    }

    private final int getAvailableCpuPermits() {
        long state$iv = controlState$volatile$FU.get(this);
        return (int) ((CPU_PERMITS_MASK & state$iv) >> 42);
    }

    private final int createdWorkers(long state) {
        return (int) (2097151 & state);
    }

    private final int blockingTasks(long state) {
        return (int) ((BLOCKING_MASK & state) >> 21);
    }

    public final int availableCpuPermits(long state) {
        return (int) ((CPU_PERMITS_MASK & state) >> 42);
    }

    private final int incrementCreatedWorkers() {
        long state$iv = controlState$volatile$FU.incrementAndGet(this);
        return (int) (2097151 & state$iv);
    }

    private final int decrementCreatedWorkers() {
        long state$iv = access$getControlState$volatile$FU().getAndDecrement(this);
        return (int) (2097151 & state$iv);
    }

    private final long incrementBlockingTasks() {
        return controlState$volatile$FU.addAndGet(this, PARKED_VERSION_INC);
    }

    private final void decrementBlockingTasks() {
        access$getControlState$volatile$FU().addAndGet(this, PARKED_VERSION_MASK);
    }

    private final boolean tryAcquireCpuPermit() {
        long state;
        long update;
        AtomicLongFieldUpdater handler$atomicfu$iv = access$getControlState$volatile$FU();
        do {
            state = handler$atomicfu$iv.get(this);
            if (((int) ((CPU_PERMITS_MASK & state) >> 42)) == 0) {
                return false;
            }
            update = state - 4398046511104L;
        } while (!access$getControlState$volatile$FU().compareAndSet(this, state, update));
        return true;
    }

    private final long releaseCpuPermit() {
        return access$getControlState$volatile$FU().addAndGet(this, 4398046511104L);
    }

    public final boolean isTerminated() {
        return _isTerminated$volatile$FU.get(this) != 0;
    }

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        dispatch$default(this, command, null, false, 6, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown(10000L);
    }

    public final void shutdown(long timeout) {
        int created;
        Task task;
        if (_isTerminated$volatile$FU.compareAndSet(this, 0, 1)) {
            Worker currentWorker = currentWorker();
            Object lock$iv = this.workers;
            synchronized (lock$iv) {
                created = (int) (access$getControlState$volatile$FU().get(this) & 2097151);
            }
            int i = 1;
            if (1 <= created) {
                while (true) {
                    Worker worker = this.workers.get(i);
                    Intrinsics.checkNotNull(worker);
                    Worker worker2 = worker;
                    if (worker2 != currentWorker) {
                        while (worker2.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(worker2);
                            worker2.join(timeout);
                        }
                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            if ((worker2.state == WorkerState.TERMINATED ? 1 : 0) == 0) {
                                throw new AssertionError();
                            }
                        }
                        worker2.localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                    }
                    if (i == created) {
                        break;
                    }
                    i++;
                }
            }
            this.globalBlockingQueue.close();
            this.globalCpuQueue.close();
            while (true) {
                if (currentWorker != null) {
                    task = currentWorker.findTask(true);
                    if (task != null) {
                        continue;
                        runSafely(task);
                    }
                }
                task = this.globalCpuQueue.removeFirstOrNull();
                if (task == null && (task = this.globalBlockingQueue.removeFirstOrNull()) == null) {
                    break;
                }
                runSafely(task);
            }
            if (currentWorker != null) {
                currentWorker.tryReleaseCpu(WorkerState.TERMINATED);
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                long state$iv$iv = controlState$volatile$FU.get(this);
                if (!(((int) ((CPU_PERMITS_MASK & state$iv$iv) >> 42)) == this.corePoolSize)) {
                    throw new AssertionError();
                }
            }
            parkedWorkersStack$volatile$FU.set(this, 0L);
            controlState$volatile$FU.set(this, 0L);
        }
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            taskContext = TasksKt.NonBlockingContext;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, z);
    }

    public final void dispatch(Runnable block, TaskContext taskContext, boolean tailDispatch) {
        long stateSnapshot;
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
        if (abstractTimeSource != null) {
            abstractTimeSource.trackTask();
        }
        Task task = createTask(block, taskContext);
        boolean skipUnpark = false;
        Task $this$isBlocking$iv = task.taskContext.getTaskMode() == 1 ? 1 : null;
        if ($this$isBlocking$iv == null) {
            stateSnapshot = 0;
        } else {
            stateSnapshot = controlState$volatile$FU.addAndGet(this, PARKED_VERSION_INC);
        }
        Worker currentWorker = currentWorker();
        Task notAdded = submitToLocalQueue(currentWorker, task, tailDispatch);
        if (notAdded != null && !addToGlobalQueue(notAdded)) {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
        if (tailDispatch && currentWorker != null) {
            skipUnpark = true;
        }
        if ($this$isBlocking$iv != null) {
            signalBlockingWork(stateSnapshot, skipUnpark);
        } else if (skipUnpark) {
        } else {
            signalCpuWork();
        }
    }

    public final Task createTask(Runnable block, TaskContext taskContext) {
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (block instanceof Task) {
            ((Task) block).submissionTime = nanoTime;
            ((Task) block).taskContext = taskContext;
            return (Task) block;
        }
        return new TaskImpl(block, nanoTime, taskContext);
    }

    private final void signalBlockingWork(long stateSnapshot, boolean skipUnpark) {
        if (skipUnpark || tryUnpark() || tryCreateWorker(stateSnapshot)) {
            return;
        }
        tryUnpark();
    }

    public final void signalCpuWork() {
        if (tryUnpark() || tryCreateWorker$default(this, 0L, 1, null)) {
            return;
        }
        tryUnpark();
    }

    static /* synthetic */ boolean tryCreateWorker$default(CoroutineScheduler coroutineScheduler, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = controlState$volatile$FU.get(coroutineScheduler);
        }
        return coroutineScheduler.tryCreateWorker(j);
    }

    private final boolean tryCreateWorker(long state) {
        int created = (int) (2097151 & state);
        int blocking = (int) ((BLOCKING_MASK & state) >> 21);
        int cpuWorkers = RangesKt.coerceAtLeast(created - blocking, 0);
        if (cpuWorkers < this.corePoolSize) {
            int newCpuWorkers = createNewWorker();
            if (newCpuWorkers == 1 && this.corePoolSize > 1) {
                createNewWorker();
            }
            if (newCpuWorkers > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean tryUnpark() {
        Worker worker;
        do {
            worker = parkedWorkersStackPop();
            if (worker == null) {
                return false;
            }
        } while (!Worker.workerCtl$volatile$FU.compareAndSet(worker, -1, 0));
        LockSupport.unpark(worker);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006a A[Catch: all -> 0x0065, TRY_LEAVE, TryCatch #1 {all -> 0x0065, blocks: (B:22:0x005b, B:29:0x006a, B:39:0x009a, B:40:0x00a5, B:41:0x00a6, B:42:0x00b1), top: B:49:0x005b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a6 A[Catch: all -> 0x0065, TryCatch #1 {all -> 0x0065, blocks: (B:22:0x005b, B:29:0x006a, B:39:0x009a, B:40:0x00a5, B:41:0x00a6, B:42:0x00b1), top: B:49:0x005b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int createNewWorker() {
        boolean z;
        Object lock$iv = this.workers;
        synchronized (lock$iv) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                long state = controlState$volatile$FU.get(this);
                int created = (int) (state & 2097151);
                int blocking = (int) ((BLOCKING_MASK & state) >> 21);
                int cpuWorkers = RangesKt.coerceAtLeast(created - blocking, 0);
                if (cpuWorkers >= this.corePoolSize) {
                    return 0;
                }
                if (created >= this.maxPoolSize) {
                    return 0;
                }
                int newIndex = ((int) (access$getControlState$volatile$FU().get(this) & 2097151)) + 1;
                if (newIndex > 0) {
                    try {
                        if (this.workers.get(newIndex) == null) {
                            z = true;
                            if (z) {
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            Worker worker = new Worker(this, newIndex);
                            this.workers.setSynchronized(newIndex, worker);
                            long state$iv$iv = controlState$volatile$FU.incrementAndGet(this);
                            if (newIndex == ((int) (state$iv$iv & 2097151))) {
                                int cpuWorkers2 = cpuWorkers + 1;
                                worker.start();
                                return cpuWorkers2;
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
                z = false;
                if (z) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private final Task submitToLocalQueue(Worker $this$submitToLocalQueue, Task task, boolean tailDispatch) {
        if ($this$submitToLocalQueue == null || $this$submitToLocalQueue.state == WorkerState.TERMINATED) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 0 && $this$submitToLocalQueue.state == WorkerState.BLOCKING) {
            return task;
        }
        $this$submitToLocalQueue.mayHaveLocalTasks = true;
        return $this$submitToLocalQueue.localQueue.add(task, tailDispatch);
    }

    private final Worker currentWorker() {
        Thread currentThread = Thread.currentThread();
        Worker worker = currentThread instanceof Worker ? (Worker) currentThread : null;
        if (worker != null) {
            Worker it = worker;
            if (Intrinsics.areEqual(CoroutineScheduler.this, this)) {
                return worker;
            }
            return null;
        }
        return null;
    }

    public String toString() {
        int parkedWorkers = 0;
        int blockingWorkers = 0;
        int cpuWorkers = 0;
        int dormant = 0;
        int terminated = 0;
        ArrayList queueSizes = new ArrayList();
        int currentLength = this.workers.currentLength();
        for (int index = 1; index < currentLength; index++) {
            Worker worker = this.workers.get(index);
            if (worker != null) {
                int queueSize = worker.localQueue.getSize$kotlinx_coroutines_core();
                switch (WhenMappings.$EnumSwitchMapping$0[worker.state.ordinal()]) {
                    case 1:
                        parkedWorkers++;
                        continue;
                    case 2:
                        blockingWorkers++;
                        queueSizes.add(new StringBuilder().append(queueSize).append('b').toString());
                        continue;
                    case 3:
                        cpuWorkers++;
                        queueSizes.add(new StringBuilder().append(queueSize).append('c').toString());
                        continue;
                    case 4:
                        dormant++;
                        if (queueSize > 0) {
                            queueSizes.add(new StringBuilder().append(queueSize).append('d').toString());
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        terminated++;
                        continue;
                }
            }
        }
        long state = controlState$volatile$FU.get(this);
        StringBuilder sb = new StringBuilder();
        sb.append(this.schedulerName).append('@').append(DebugStringsKt.getHexAddress(this)).append("[Pool Size {core = ").append(this.corePoolSize).append(", max = ").append(this.maxPoolSize).append("}, Worker States {CPU = ").append(cpuWorkers).append(", blocking = ").append(blockingWorkers).append(", parked = ").append(parkedWorkers).append(", dormant = ").append(dormant).append(", terminated = ").append(terminated).append("}, running workers queues = ").append(queueSizes).append(", global CPU queue size = ").append(this.globalCpuQueue.getSize()).append(", global blocking queue size = ").append(this.globalBlockingQueue.getSize());
        sb.append(", Control State {created workers= ").append((int) (2097151 & state)).append(", blocking tasks = ").append((int) ((BLOCKING_MASK & state) >> 21)).append(", CPUs acquired = ").append(this.corePoolSize - ((int) ((CPU_PERMITS_MASK & state) >> 42))).append("}]");
        return sb.toString();
    }

    public final void runSafely(Task task) {
        try {
            task.run();
        } catch (Throwable e) {
            try {
                Thread thread = Thread.currentThread();
                thread.getUncaughtExceptionHandler().uncaughtException(thread, e);
                AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
                if (abstractTimeSource == null) {
                }
            } finally {
                AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.timeSource;
                if (abstractTimeSource2 != null) {
                    abstractTimeSource2.unTrackTask();
                }
            }
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020 H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010+\u001a\u00020\u000eH\u0002J\n\u0010,\u001a\u0004\u0018\u00010 H\u0002J\n\u0010-\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u0003H\u0002J\b\u00101\u001a\u00020\u000eH\u0002J\u0006\u00102\u001a\u00020\u000eJ\u000e\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003J\b\u00105\u001a\u00020%H\u0002J\n\u00106\u001a\u0004\u0018\u00010 H\u0002J\b\u00107\u001a\u00020%H\u0016J\u0006\u00108\u001a\u00020\u0010J\b\u00109\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020\u000eH\u0002J\b\u0010;\u001a\u00020%H\u0002J\u000e\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u001dJ\u0016\u0010>\u001a\u0004\u0018\u00010 2\n\u0010?\u001a\u00060\u0003j\u0002`@H\u0002J\b\u0010A\u001a\u00020%H\u0002R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0006\u0010\"\u001a\u00020#¨\u0006B"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "index", "", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "indexInArray", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "", "minDelayUntilStealableTaskNs", "", "nextParkedWorker", "", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "scheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "stolenTask", "Lkotlin/jvm/internal/Ref$ObjectRef;", "Lkotlinx/coroutines/scheduling/Task;", "terminationDeadline", "workerCtl", "Lkotlinx/atomicfu/AtomicInt;", "afterTask", "", "taskMode", "beforeTask", "executeTask", "task", "findAnyTask", "scanLocalQueue", "findBlockingTask", "findCpuTask", "findTask", "idleReset", "mode", "inStack", "isIo", "nextInt", "upperBound", "park", "pollGlobalQueues", "run", "runSingleTask", "runWorker", "tryAcquireCpuPermit", "tryPark", "tryReleaseCpu", "newState", "trySteal", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "tryTerminateWorker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public final class Worker extends Thread {
        private static final /* synthetic */ AtomicIntegerFieldUpdater workerCtl$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");
        private volatile int indexInArray;
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;
        public WorkerState state;
        private final Ref.ObjectRef<Task> stolenTask;
        private long terminationDeadline;
        private volatile /* synthetic */ int workerCtl$volatile;

        private final /* synthetic */ int getWorkerCtl$volatile() {
            return this.workerCtl$volatile;
        }

        private final /* synthetic */ void setWorkerCtl$volatile(int i) {
            this.workerCtl$volatile = i;
        }

        private Worker() {
            setDaemon(true);
            setContextClassLoader(CoroutineScheduler.this.getClass().getClassLoader());
            this.localQueue = new WorkQueue();
            this.stolenTask = new Ref.ObjectRef<>();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            int seed = (int) System.nanoTime();
            this.rngState = seed == 0 ? CoroutineScheduler.CPU_PERMITS_SHIFT : seed;
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final void setIndexInArray(int index) {
            setName(CoroutineScheduler.this.schedulerName + "-worker-" + (index == 0 ? "TERMINATED" : String.valueOf(index)));
            this.indexInArray = index;
        }

        public Worker(CoroutineScheduler this$0, int index) {
            this();
            setIndexInArray(index);
        }

        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        private final boolean tryAcquireCpuPermit() {
            CoroutineScheduler this_$iv;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler this_$iv2 = CoroutineScheduler.this;
            AtomicLongFieldUpdater handler$atomicfu$iv$iv = CoroutineScheduler.access$getControlState$volatile$FU();
            while (true) {
                long state$iv = handler$atomicfu$iv$iv.get(this_$iv2);
                if (((int) ((CoroutineScheduler.CPU_PERMITS_MASK & state$iv) >> 42)) == 0) {
                    this_$iv = null;
                    break;
                }
                long update$iv = state$iv - 4398046511104L;
                if (CoroutineScheduler.access$getControlState$volatile$FU().compareAndSet(this_$iv2, state$iv, update$iv)) {
                    this_$iv = 1;
                    break;
                }
            }
            if (this_$iv != null) {
                this.state = WorkerState.CPU_ACQUIRED;
                return true;
            }
            return false;
        }

        public final boolean tryReleaseCpu(WorkerState newState) {
            WorkerState previousState = this.state;
            boolean hadCpu = previousState == WorkerState.CPU_ACQUIRED;
            if (hadCpu) {
                CoroutineScheduler this_$iv = CoroutineScheduler.this;
                CoroutineScheduler.access$getControlState$volatile$FU().addAndGet(this_$iv, 4398046511104L);
            }
            if (previousState != newState) {
                this.state = newState;
            }
            return hadCpu;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            runWorker();
        }

        private final void runWorker() {
            boolean rescanned = false;
            while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                Task task = findTask(this.mayHaveLocalTasks);
                if (task != null) {
                    rescanned = false;
                    this.minDelayUntilStealableTaskNs = 0L;
                    executeTask(task);
                } else {
                    this.mayHaveLocalTasks = false;
                    if (this.minDelayUntilStealableTaskNs != 0) {
                        if (!rescanned) {
                            rescanned = true;
                        } else {
                            rescanned = false;
                            tryReleaseCpu(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                        }
                    } else {
                        tryPark();
                    }
                }
            }
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        public final long runSingleTask() {
            Task task;
            WorkerState stateSnapshot = this.state;
            boolean isCpuThread = this.state == WorkerState.CPU_ACQUIRED;
            if (isCpuThread) {
                task = findCpuTask();
            } else {
                task = findBlockingTask();
            }
            if (task == null) {
                if (this.minDelayUntilStealableTaskNs == 0) {
                    return -1L;
                }
                return this.minDelayUntilStealableTaskNs;
            }
            CoroutineScheduler.this.runSafely(task);
            if (!isCpuThread) {
                CoroutineScheduler this_$iv = CoroutineScheduler.this;
                CoroutineScheduler.access$getControlState$volatile$FU().addAndGet(this_$iv, CoroutineScheduler.PARKED_VERSION_MASK);
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(this.state == stateSnapshot)) {
                    throw new AssertionError();
                }
            }
            return 0L;
        }

        public final boolean isIo() {
            return this.state == WorkerState.BLOCKING;
        }

        private final void tryPark() {
            if (!inStack()) {
                CoroutineScheduler.this.parkedWorkersStackPush(this);
                return;
            }
            workerCtl$volatile$FU.set(this, -1);
            while (inStack() && workerCtl$volatile$FU.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu(WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        private final boolean inStack() {
            return this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK;
        }

        private final void executeTask(Task task) {
            int taskMode = task.taskContext.getTaskMode();
            idleReset(taskMode);
            beforeTask(taskMode);
            CoroutineScheduler.this.runSafely(task);
            afterTask(taskMode);
        }

        private final void beforeTask(int taskMode) {
            if (taskMode != 0 && tryReleaseCpu(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.signalCpuWork();
            }
        }

        private final void afterTask(int taskMode) {
            if (taskMode == 0) {
                return;
            }
            CoroutineScheduler this_$iv = CoroutineScheduler.this;
            CoroutineScheduler.access$getControlState$volatile$FU().addAndGet(this_$iv, CoroutineScheduler.PARKED_VERSION_MASK);
            WorkerState currentState = this.state;
            if (currentState != WorkerState.TERMINATED) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!(currentState == WorkerState.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.DORMANT;
            }
        }

        public final int nextInt(int upperBound) {
            int r = this.rngState;
            int r2 = r ^ (r << 13);
            int r3 = r2 ^ (r2 >> 17);
            int r4 = r3 ^ (r3 << 5);
            this.rngState = r4;
            int mask = upperBound - 1;
            if ((mask & upperBound) == 0) {
                return r4 & mask;
            }
            return (Integer.MAX_VALUE & r4) % upperBound;
        }

        private final void park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                tryTerminateWorker();
            }
        }

        private final void tryTerminateWorker() {
            Object lock$iv = CoroutineScheduler.this.workers;
            CoroutineScheduler this_$iv = CoroutineScheduler.this;
            synchronized (lock$iv) {
                if (this_$iv.isTerminated()) {
                    return;
                }
                int i = (int) (CoroutineScheduler.access$getControlState$volatile$FU().get(this_$iv) & 2097151);
                int $i$f$getCreatedWorkers = this_$iv.corePoolSize;
                if (i <= $i$f$getCreatedWorkers) {
                    return;
                }
                if (workerCtl$volatile$FU.compareAndSet(this, -1, 1)) {
                    int oldIndex = this.indexInArray;
                    setIndexInArray(0);
                    this_$iv.parkedWorkersStackTopUpdate(this, oldIndex, 0);
                    long state$iv$iv = CoroutineScheduler.access$getControlState$volatile$FU().getAndDecrement(this_$iv);
                    int lastIndex = (int) (2097151 & state$iv$iv);
                    if (lastIndex != oldIndex) {
                        Worker worker = this_$iv.workers.get(lastIndex);
                        Intrinsics.checkNotNull(worker);
                        Worker lastWorker = worker;
                        this_$iv.workers.setSynchronized(oldIndex, lastWorker);
                        lastWorker.setIndexInArray(oldIndex);
                        this_$iv.parkedWorkersStackTopUpdate(lastWorker, lastIndex, oldIndex);
                    }
                    this_$iv.workers.setSynchronized(lastIndex, null);
                    Unit unit = Unit.INSTANCE;
                    this.state = WorkerState.TERMINATED;
                }
            }
        }

        private final void idleReset(int mode) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!(mode == 1)) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.BLOCKING;
            }
        }

        public final Task findTask(boolean mayHaveLocalTasks) {
            return tryAcquireCpuPermit() ? findAnyTask(mayHaveLocalTasks) : findBlockingTask();
        }

        private final Task findBlockingTask() {
            Task pollBlocking = this.localQueue.pollBlocking();
            if (pollBlocking != null) {
                return pollBlocking;
            }
            Task removeFirstOrNull = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            if (removeFirstOrNull != null) {
                return removeFirstOrNull;
            }
            return trySteal(1);
        }

        private final Task findCpuTask() {
            Task pollCpu = this.localQueue.pollCpu();
            if (pollCpu != null) {
                return pollCpu;
            }
            Task removeFirstOrNull = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            if (removeFirstOrNull != null) {
                return removeFirstOrNull;
            }
            return trySteal(2);
        }

        private final Task findAnyTask(boolean scanLocalQueue) {
            Task it;
            Task it2;
            if (scanLocalQueue) {
                boolean globalFirst = nextInt(CoroutineScheduler.this.corePoolSize * 2) == 0;
                if (globalFirst && (it2 = pollGlobalQueues()) != null) {
                    return it2;
                }
                Task it3 = this.localQueue.poll();
                if (it3 != null) {
                    return it3;
                }
                if (!globalFirst && (it = pollGlobalQueues()) != null) {
                    return it;
                }
            } else {
                Task it4 = pollGlobalQueues();
                if (it4 != null) {
                    return it4;
                }
            }
            return trySteal(3);
        }

        private final Task pollGlobalQueues() {
            if (nextInt(2) == 0) {
                Task it = CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                if (it != null) {
                    return it;
                }
                return CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            Task it2 = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            if (it2 != null) {
                return it2;
            }
            return CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
        }

        private final Task trySteal(int stealingMode) {
            CoroutineScheduler this_$iv = CoroutineScheduler.this;
            int created = (int) (CoroutineScheduler.access$getControlState$volatile$FU().get(this_$iv) & 2097151);
            if (created < 2) {
                return null;
            }
            int currentIndex = nextInt(created);
            long minDelay = LongCompanionObject.MAX_VALUE;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            int i = 0;
            while (true) {
                if (i >= created) {
                    this.minDelayUntilStealableTaskNs = minDelay != LongCompanionObject.MAX_VALUE ? minDelay : 0L;
                    return null;
                }
                currentIndex++;
                if (currentIndex > created) {
                    currentIndex = 1;
                }
                Worker worker = coroutineScheduler.workers.get(currentIndex);
                if (worker != null && worker != this) {
                    long stealResult = worker.localQueue.trySteal(stealingMode, this.stolenTask);
                    if (stealResult == -1) {
                        Task result = this.stolenTask.element;
                        this.stolenTask.element = null;
                        return result;
                    } else if (stealResult > 0) {
                        minDelay = Math.min(minDelay, stealResult);
                    }
                }
                i++;
            }
        }
    }
}