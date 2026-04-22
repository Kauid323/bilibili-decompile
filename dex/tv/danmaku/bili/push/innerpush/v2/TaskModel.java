package tv.danmaku.bili.push.innerpush.v2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage;
import tv.danmaku.bili.push.innerpush.v2.InnerPushType;

/* compiled from: InnerPushTaskManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J/\u0010\u0014\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\b\tHÆ\u0003¢\u0006\u0002\u0010\u000fJC\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032)\b\u0002\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\b\tHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR4\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\b\t¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/TaskModel;", "", "type", "Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;", "task", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;Lkotlin/jvm/functions/Function2;)V", "getType", "()Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;", "getTask", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "delayTime", "", "component1", "component2", "copy", "(Ltv/danmaku/bili/push/innerpush/v2/InnerPushType;Lkotlin/jvm/functions/Function2;)Ltv/danmaku/bili/push/innerpush/v2/TaskModel;", "equals", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TaskModel {
    public static final int $stable = 8;
    private final Function2<CoroutineScope, Continuation<? super Boolean>, Object> task;
    private final InnerPushType type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskModel copy$default(TaskModel taskModel, InnerPushType innerPushType, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            innerPushType = taskModel.type;
        }
        if ((i & 2) != 0) {
            function2 = taskModel.task;
        }
        return taskModel.copy(innerPushType, function2);
    }

    public final InnerPushType component1() {
        return this.type;
    }

    public final Function2<CoroutineScope, Continuation<? super Boolean>, Object> component2() {
        return this.task;
    }

    public final TaskModel copy(InnerPushType innerPushType, Function2<? super CoroutineScope, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(innerPushType, "type");
        Intrinsics.checkNotNullParameter(function2, "task");
        return new TaskModel(innerPushType, function2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TaskModel) {
            TaskModel taskModel = (TaskModel) obj;
            return Intrinsics.areEqual(this.type, taskModel.type) && Intrinsics.areEqual(this.task, taskModel.task);
        }
        return false;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.task.hashCode();
    }

    public String toString() {
        InnerPushType innerPushType = this.type;
        return "TaskModel(type=" + innerPushType + ", task=" + this.task + ")";
    }

    public TaskModel(InnerPushType type, Function2<? super CoroutineScope, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(function2, "task");
        this.type = type;
        this.task = function2;
    }

    public final Function2<CoroutineScope, Continuation<? super Boolean>, Object> getTask() {
        return this.task;
    }

    public final InnerPushType getType() {
        return this.type;
    }

    public final long delayTime() {
        if (this.type instanceof InnerPushType.Normal) {
            long now = System.currentTimeMillis();
            long lastShowTime = InnerPushLocalStorage.INSTANCE.getInnerPushLastShowTime();
            long j = 1000;
            if (now > (((InnerPushType.Normal) this.type).getCacheTime() * j) + lastShowTime) {
                return 0L;
            }
            return ((((InnerPushType.Normal) this.type).getCacheTime() * j) + lastShowTime) - now;
        }
        return 0L;
    }
}