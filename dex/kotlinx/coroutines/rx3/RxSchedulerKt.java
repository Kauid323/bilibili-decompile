package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InterruptibleKt;

/* compiled from: RxScheduler.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0007¢\u0006\u0002\b\u0000\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0001\u001aQ\u0010\u0006\u001a\u00020\u0007*\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\f\u001a\u00020\r2,\u0010\u000e\u001a(\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f\u0012\b\u0012\u00060\nj\u0002`\u000b0\u000fH\u0002ø\u0001\u0000*8\b\u0002\u0010\u0013\"\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f2\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lio/reactivex/rxjava3/core/Scheduler;", "asCoroutineDispatcher0", "Lkotlinx/coroutines/rx3/SchedulerCoroutineDispatcher;", "asScheduler", "scheduleTask", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lkotlinx/coroutines/CoroutineScope;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "delayMillis", "", "adaptForScheduling", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "Task", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RxSchedulerKt {
    public static final CoroutineDispatcher asCoroutineDispatcher(Scheduler $this$asCoroutineDispatcher) {
        if ($this$asCoroutineDispatcher instanceof DispatcherScheduler) {
            return ((DispatcherScheduler) $this$asCoroutineDispatcher).dispatcher;
        }
        return new SchedulerCoroutineDispatcher($this$asCoroutineDispatcher);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.2, binary compatibility with earlier versions")
    /* renamed from: asCoroutineDispatcher  reason: collision with other method in class */
    public static final /* synthetic */ SchedulerCoroutineDispatcher m1473asCoroutineDispatcher(Scheduler $this$asCoroutineDispatcher0) {
        return new SchedulerCoroutineDispatcher($this$asCoroutineDispatcher0);
    }

    public static final Scheduler asScheduler(CoroutineDispatcher $this$asScheduler) {
        if ($this$asScheduler instanceof SchedulerCoroutineDispatcher) {
            return ((SchedulerCoroutineDispatcher) $this$asScheduler).getScheduler();
        }
        return new DispatcherScheduler($this$asScheduler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v4, types: [kotlinx.coroutines.DisposableHandle, T] */
    public static final Disposable scheduleTask(CoroutineScope $this$scheduleTask, Runnable block, long delayMillis, Function1<? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? extends Runnable> function1) {
        CoroutineContext ctx = $this$scheduleTask.getCoroutineContext();
        final Ref.ObjectRef handle = new Ref.ObjectRef();
        Disposable disposable = Disposable.-CC.fromRunnable(new Runnable() { // from class: kotlinx.coroutines.rx3.RxSchedulerKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RxSchedulerKt.scheduleTask$lambda$0(Ref.ObjectRef.this);
            }
        });
        Runnable decoratedBlock = RxJavaPlugins.onSchedule(block);
        Runnable toSchedule = function1.invoke(new RxSchedulerKt$scheduleTask$toSchedule$1(disposable, ctx, decoratedBlock));
        if (CoroutineScopeKt.isActive($this$scheduleTask)) {
            if (delayMillis <= 0) {
                toSchedule.run();
            } else {
                handle.element = DelayKt.getDelay(ctx).invokeOnTimeout(delayMillis, toSchedule, ctx);
            }
            return disposable;
        }
        return Disposable.-CC.disposed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleTask$lambda$0(Ref.ObjectRef $handle) {
        DisposableHandle disposableHandle = (DisposableHandle) $handle.element;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object scheduleTask$task(Disposable disposable, CoroutineContext ctx, final Runnable decoratedBlock, Continuation<? super Unit> continuation) {
        RxSchedulerKt$scheduleTask$task$1 rxSchedulerKt$scheduleTask$task$1;
        RxSchedulerKt$scheduleTask$task$1 rxSchedulerKt$scheduleTask$task$12;
        Throwable e;
        CoroutineContext ctx2;
        if (continuation instanceof RxSchedulerKt$scheduleTask$task$1) {
            rxSchedulerKt$scheduleTask$task$1 = (RxSchedulerKt$scheduleTask$task$1) continuation;
            if ((rxSchedulerKt$scheduleTask$task$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                rxSchedulerKt$scheduleTask$task$1.label -= IntCompanionObject.MIN_VALUE;
                rxSchedulerKt$scheduleTask$task$12 = rxSchedulerKt$scheduleTask$task$1;
                Object $result = rxSchedulerKt$scheduleTask$task$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rxSchedulerKt$scheduleTask$task$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (disposable.isDisposed()) {
                            return Unit.INSTANCE;
                        }
                        try {
                            rxSchedulerKt$scheduleTask$task$12.L$0 = ctx;
                            rxSchedulerKt$scheduleTask$task$12.label = 1;
                            if (InterruptibleKt.runInterruptible$default(null, new Function0<Unit>() { // from class: kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    decoratedBlock.run();
                                }
                            }, rxSchedulerKt$scheduleTask$task$12, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } catch (Throwable th) {
                            e = th;
                            ctx2 = ctx;
                            RxCancellableKt.handleUndeliverableException(e, ctx2);
                            return Unit.INSTANCE;
                        }
                    case 1:
                        ctx2 = (CoroutineContext) rxSchedulerKt$scheduleTask$task$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                        } catch (Throwable th2) {
                            e = th2;
                            RxCancellableKt.handleUndeliverableException(e, ctx2);
                            return Unit.INSTANCE;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        rxSchedulerKt$scheduleTask$task$1 = new RxSchedulerKt$scheduleTask$task$1(continuation);
        rxSchedulerKt$scheduleTask$task$12 = rxSchedulerKt$scheduleTask$task$1;
        Object $result2 = rxSchedulerKt$scheduleTask$task$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rxSchedulerKt$scheduleTask$task$12.label) {
        }
        return Unit.INSTANCE;
    }
}