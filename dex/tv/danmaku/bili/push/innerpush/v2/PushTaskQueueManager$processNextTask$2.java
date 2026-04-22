package tv.danmaku.bili.push.innerpush.v2;

import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerPushTaskManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.PushTaskQueueManager$processNextTask$2", f = "InnerPushTaskManager.kt", i = {}, l = {BR.chatRoomConfig, 100}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PushTaskQueueManager$processNextTask$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TaskModel $task;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PushTaskQueueManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushTaskQueueManager$processNextTask$2(TaskModel taskModel, PushTaskQueueManager pushTaskQueueManager, Continuation<? super PushTaskQueueManager$processNextTask$2> continuation) {
        super(2, continuation);
        this.$task = taskModel;
        this.this$0 = pushTaskQueueManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> pushTaskQueueManager$processNextTask$2 = new PushTaskQueueManager$processNextTask$2(this.$task, this.this$0, continuation);
        pushTaskQueueManager$processNextTask$2.L$0 = obj;
        return pushTaskQueueManager$processNextTask$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object processTask;
        Object processNextTask;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                long delayTime = this.$task.delayTime();
                if (delayTime <= 0) {
                    this.label = 1;
                    processTask = this.this$0.processTask(this.$task, (Continuation) this);
                    if (processTask == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(delayTime, this.this$0, this.$task, null), 3, (Object) null);
                }
                this.this$0.isProcessing = false;
                this.label = 2;
                processNextTask = this.this$0.processNextTask((Continuation) this);
                if (processNextTask == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                this.this$0.isProcessing = false;
                this.label = 2;
                processNextTask = this.this$0.processNextTask((Continuation) this);
                if (processNextTask == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InnerPushTaskManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.PushTaskQueueManager$processNextTask$2$1", f = "InnerPushTaskManager.kt", i = {}, l = {BR.cardStyle, BR.changeEpBtnVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.push.innerpush.v2.PushTaskQueueManager$processNextTask$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayTime;
        final /* synthetic */ TaskModel $task;
        int label;
        final /* synthetic */ PushTaskQueueManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, PushTaskQueueManager pushTaskQueueManager, TaskModel taskModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$delayTime = j;
            this.this$0 = pushTaskQueueManager;
            this.$task = taskModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$delayTime, this.this$0, this.$task, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            ConcurrentLinkedQueue concurrentLinkedQueue;
            ConcurrentLinkedQueue concurrentLinkedQueue2;
            Object processNextTask;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    BLog.i("PushTaskQueueManager", "delayTime: " + this.$delayTime);
                    this.label = 1;
                    if (DelayKt.delay(this.$delayTime, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    concurrentLinkedQueue = this.this$0.taskQueue;
                    PushTaskQueueManager pushTaskQueueManager = this.this$0;
                    TaskModel taskModel = this.$task;
                    synchronized (concurrentLinkedQueue) {
                        concurrentLinkedQueue2 = pushTaskQueueManager.taskQueue;
                        concurrentLinkedQueue2.add(taskModel);
                    }
                    this.label = 2;
                    processNextTask = this.this$0.processNextTask((Continuation) this);
                    if (processNextTask == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    concurrentLinkedQueue = this.this$0.taskQueue;
                    PushTaskQueueManager pushTaskQueueManager2 = this.this$0;
                    TaskModel taskModel2 = this.$task;
                    synchronized (concurrentLinkedQueue) {
                    }
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}