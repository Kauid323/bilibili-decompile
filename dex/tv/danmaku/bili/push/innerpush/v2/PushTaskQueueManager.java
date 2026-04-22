package tv.danmaku.bili.push.innerpush.v2;

import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import tv.danmaku.bili.BR;

/* compiled from: InnerPushTaskManager.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010¢\u0006\u0002\b\u0012H\u0086@¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/PushTaskQueueManager;", "", "<init>", "()V", "taskQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ltv/danmaku/bili/push/innerpush/v2/TaskModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isProcessing", "", "addTask", "", "type", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;", "task", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNextTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTask", "(Ltv/danmaku/bili/push/innerpush/v2/TaskModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushTaskQueueManager {
    private static final String TAG = "PushTaskQueueManager";
    private boolean isProcessing;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final ConcurrentLinkedQueue<TaskModel> taskQueue = new ConcurrentLinkedQueue<>();
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    /* compiled from: InnerPushTaskManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/PushTaskQueueManager$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Object addTask(InnerPushType type, Function2<? super CoroutineScope, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        synchronized (this.taskQueue) {
            this.taskQueue.add(new TaskModel(type, function2));
        }
        Object processNextTask = processNextTask(continuation);
        return processNextTask == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? processNextTask : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processNextTask(Continuation<? super Unit> continuation) {
        TaskModel task;
        if (this.isProcessing) {
            return Unit.INSTANCE;
        }
        synchronized (this.taskQueue) {
            task = this.taskQueue.poll();
        }
        if (task == null) {
            return Unit.INSTANCE;
        }
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new PushTaskQueueManager$processNextTask$2(task, this, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processTask(TaskModel task, Continuation<? super Unit> continuation) {
        PushTaskQueueManager$processTask$1 pushTaskQueueManager$processTask$1;
        Object invoke;
        if (continuation instanceof PushTaskQueueManager$processTask$1) {
            pushTaskQueueManager$processTask$1 = (PushTaskQueueManager$processTask$1) continuation;
            if ((pushTaskQueueManager$processTask$1.label & Integer.MIN_VALUE) != 0) {
                pushTaskQueueManager$processTask$1.label -= Integer.MIN_VALUE;
                Object $result = pushTaskQueueManager$processTask$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pushTaskQueueManager$processTask$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.isProcessing = true;
                        Function2<CoroutineScope, Continuation<? super Boolean>, Object> task2 = task.getTask();
                        CoroutineScope coroutineScope = this.scope;
                        pushTaskQueueManager$processTask$1.label = 1;
                        invoke = task2.invoke(coroutineScope, pushTaskQueueManager$processTask$1);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        invoke = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean result = ((Boolean) invoke).booleanValue();
                Log.i(TAG, "processTask result: " + (result));
                return Unit.INSTANCE;
            }
        }
        pushTaskQueueManager$processTask$1 = new PushTaskQueueManager$processTask$1(this, continuation);
        Object $result2 = pushTaskQueueManager$processTask$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pushTaskQueueManager$processTask$1.label) {
        }
        boolean result2 = ((Boolean) invoke).booleanValue();
        Log.i(TAG, "processTask result: " + (result2));
        return Unit.INSTANCE;
    }
}