package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.rx3.DispatcherScheduler;

/* compiled from: RxScheduler.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\t\u001a\u00020\nX\u0082\u0004¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/rx3/DispatcherScheduler;", "Lio/reactivex/rxjava3/core/Scheduler;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "schedulerJob", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "workerCounter", "Lkotlinx/atomicfu/AtomicLong;", "createWorker", "Lio/reactivex/rxjava3/core/Scheduler$Worker;", "scheduleDirect", "Lio/reactivex/rxjava3/disposables/Disposable;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "delay", "", "unit", "Ljava/util/concurrent/TimeUnit;", "shutdown", "", "toString", "", "DispatcherWorker", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DispatcherScheduler extends Scheduler {
    private static final AtomicLongFieldUpdater workerCounter$FU = AtomicLongFieldUpdater.newUpdater(DispatcherScheduler.class, "workerCounter");
    public final CoroutineDispatcher dispatcher;
    private final CoroutineScope scope;
    private final CompletableJob schedulerJob = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
    @Volatile
    private volatile long workerCounter = 1;

    public DispatcherScheduler(CoroutineDispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.scope = CoroutineScopeKt.CoroutineScope(this.schedulerJob.plus(this.dispatcher));
    }

    public Disposable scheduleDirect(Runnable block, long delay, TimeUnit unit) {
        Disposable scheduleTask;
        scheduleTask = RxSchedulerKt.scheduleTask(this.scope, block, unit.toMillis(delay), new Function1<Function1<? super Continuation<? super Unit>, ? extends Object>, Runnable>() { // from class: kotlinx.coroutines.rx3.DispatcherScheduler$scheduleDirect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Runnable invoke(final Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
                final DispatcherScheduler dispatcherScheduler = DispatcherScheduler.this;
                return new Runnable() { // from class: kotlinx.coroutines.rx3.DispatcherScheduler$scheduleDirect$1$invoke$$inlined$Runnable$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CoroutineScope coroutineScope;
                        coroutineScope = DispatcherScheduler.this.scope;
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DispatcherScheduler$scheduleDirect$1$1$1(function1, null), 3, null);
                    }
                };
            }
        });
        return scheduleTask;
    }

    public Scheduler.Worker createWorker() {
        return new DispatcherWorker(workerCounter$FU.getAndIncrement(this), this.dispatcher, this.schedulerJob);
    }

    public void shutdown() {
        Job.DefaultImpls.cancel$default((Job) this.schedulerJob, (CancellationException) null, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RxScheduler.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R-\u0010\t\u001a\u001e\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b0\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lkotlinx/coroutines/rx3/DispatcherScheduler$DispatcherWorker;", "Lio/reactivex/rxjava3/core/Scheduler$Worker;", "counter", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "parentJob", "Lkotlinx/coroutines/Job;", "(JLkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/Job;)V", "blockChannel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "workerJob", "Lkotlinx/coroutines/CompletableJob;", "workerScope", "Lkotlinx/coroutines/CoroutineScope;", "dispose", "isDisposed", "", "schedule", "Lio/reactivex/rxjava3/disposables/Disposable;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "delay", "unit", "Ljava/util/concurrent/TimeUnit;", "toString", "", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DispatcherWorker extends Scheduler.Worker {
        private final Channel<Function1<Continuation<? super Unit>, Object>> blockChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        private final long counter;
        private final CoroutineDispatcher dispatcher;
        private final CompletableJob workerJob;
        private final CoroutineScope workerScope;

        public DispatcherWorker(long counter, CoroutineDispatcher dispatcher, Job parentJob) {
            this.counter = counter;
            this.dispatcher = dispatcher;
            this.workerJob = SupervisorKt.SupervisorJob(parentJob);
            this.workerScope = CoroutineScopeKt.CoroutineScope(this.workerJob.plus(this.dispatcher));
            BuildersKt__Builders_commonKt.launch$default(this.workerScope, null, null, new AnonymousClass1(null), 3, null);
        }

        /* compiled from: RxScheduler.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.rx3.DispatcherScheduler$DispatcherWorker$1", f = "RxScheduler.kt", i = {0, 1}, l = {190, 82}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$0", "L$0"})
        /* renamed from: kotlinx.coroutines.rx3.DispatcherScheduler$DispatcherWorker$1  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            Object L$0;
            Object L$1;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0078 A[Catch: all -> 0x00a5, TryCatch #1 {all -> 0x00a5, blocks: (B:21:0x0070, B:23:0x0078, B:28:0x0099), top: B:42:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0099 A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #1 {all -> 0x00a5, blocks: (B:21:0x0070, B:23:0x0078, B:28:0x0099), top: B:42:0x0070 }] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x008f -> B:27:0x0096). Please submit an issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object $result) {
                ReceiveChannel $this$consume$iv$iv;
                AnonymousClass1 anonymousClass1;
                Throwable cause$iv$iv;
                int i;
                ChannelIterator it;
                boolean z;
                boolean z2;
                boolean z3;
                boolean z4;
                AnonymousClass1 anonymousClass12;
                Object obj;
                Object $result2;
                int $i$f$consume;
                Object hasNext;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                try {
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            anonymousClass1 = this;
                            $this$consume$iv$iv = DispatcherWorker.this.blockChannel;
                            cause$iv$iv = null;
                            i = 0;
                            try {
                                it = $this$consume$iv$iv.iterator();
                                z = false;
                                z2 = false;
                                anonymousClass1.L$0 = $this$consume$iv$iv;
                                anonymousClass1.L$1 = it;
                                anonymousClass1.label = 1;
                                hasNext = it.hasNext(anonymousClass1);
                                if (hasNext == $result3) {
                                    return $result3;
                                }
                                Object obj2 = $result3;
                                $result2 = $result;
                                $result = hasNext;
                                z3 = z;
                                z4 = z2;
                                anonymousClass12 = anonymousClass1;
                                obj = obj2;
                                try {
                                    if (((Boolean) $result).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                                        return Unit.INSTANCE;
                                    }
                                    Object e$iv = it.next();
                                    Function1 it2 = (Function1) e$iv;
                                    anonymousClass12.L$0 = $this$consume$iv$iv;
                                    anonymousClass12.L$1 = it;
                                    anonymousClass12.label = 2;
                                    if (it2.invoke(anonymousClass12) == obj) {
                                        return obj;
                                    }
                                    $result = $result2;
                                    $result3 = obj;
                                    anonymousClass1 = anonymousClass12;
                                    z2 = z4;
                                    z = z3;
                                    $i$f$consume = i;
                                    i = $i$f$consume;
                                    anonymousClass1.L$0 = $this$consume$iv$iv;
                                    anonymousClass1.L$1 = it;
                                    anonymousClass1.label = 1;
                                    hasNext = it.hasNext(anonymousClass1);
                                    if (hasNext == $result3) {
                                    }
                                } catch (Throwable th) {
                                    e$iv$iv = th;
                                    Throwable cause$iv$iv2 = e$iv$iv;
                                    try {
                                        throw e$iv$iv;
                                    } catch (Throwable e$iv$iv) {
                                        ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv2);
                                        throw e$iv$iv;
                                    }
                                }
                            } catch (Throwable th2) {
                                e$iv$iv = th2;
                                Throwable cause$iv$iv22 = e$iv$iv;
                                throw e$iv$iv;
                            }
                        case 1:
                            ChannelIterator channelIterator = (ChannelIterator) this.L$1;
                            cause$iv$iv = null;
                            ReceiveChannel $this$consume$iv$iv2 = (ReceiveChannel) this.L$0;
                            $this$consume$iv$iv = $this$consume$iv$iv2;
                            ResultKt.throwOnFailure($result);
                            it = channelIterator;
                            i = 0;
                            z3 = false;
                            z4 = false;
                            anonymousClass12 = this;
                            obj = $result3;
                            $result2 = $result;
                            if (((Boolean) $result).booleanValue()) {
                            }
                            break;
                        case 2:
                            anonymousClass1 = this;
                            z2 = false;
                            z = false;
                            $i$f$consume = 0;
                            it = (ChannelIterator) anonymousClass1.L$1;
                            cause$iv$iv = null;
                            $this$consume$iv$iv = (ReceiveChannel) anonymousClass1.L$0;
                            ResultKt.throwOnFailure($result);
                            i = $i$f$consume;
                            anonymousClass1.L$0 = $this$consume$iv$iv;
                            anonymousClass1.L$1 = it;
                            anonymousClass1.label = 1;
                            hasNext = it.hasNext(anonymousClass1);
                            if (hasNext == $result3) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Throwable th3) {
                    e$iv$iv = th3;
                }
            }
        }

        public Disposable schedule(Runnable block, long delay, TimeUnit unit) {
            Disposable scheduleTask;
            scheduleTask = RxSchedulerKt.scheduleTask(this.workerScope, block, unit.toMillis(delay), new Function1<Function1<? super Continuation<? super Unit>, ? extends Object>, Runnable>() { // from class: kotlinx.coroutines.rx3.DispatcherScheduler$DispatcherWorker$schedule$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Runnable invoke(final Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
                    final DispatcherScheduler.DispatcherWorker dispatcherWorker = DispatcherScheduler.DispatcherWorker.this;
                    return new Runnable() { // from class: kotlinx.coroutines.rx3.DispatcherScheduler$DispatcherWorker$schedule$1$invoke$$inlined$Runnable$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            DispatcherScheduler.DispatcherWorker.this.blockChannel.mo1399trySendJP2dKIU(function1);
                        }
                    };
                }
            });
            return scheduleTask;
        }

        public boolean isDisposed() {
            return !CoroutineScopeKt.isActive(this.workerScope);
        }

        public void dispose() {
            SendChannel.DefaultImpls.close$default(this.blockChannel, null, 1, null);
            Job.DefaultImpls.cancel$default((Job) this.workerJob, (CancellationException) null, 1, (Object) null);
        }

        public String toString() {
            return this.dispatcher + " (worker " + this.counter + ", " + (isDisposed() ? "disposed" : "active") + ')';
        }
    }

    public String toString() {
        return this.dispatcher.toString();
    }
}