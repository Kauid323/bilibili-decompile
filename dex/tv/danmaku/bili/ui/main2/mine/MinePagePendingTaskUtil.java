package tv.danmaku.bili.ui.main2.mine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: MinePagePendingTaskUtil.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/MinePagePendingTaskUtil;", "", "<init>", "()V", "pendingTasks", "", "Ltv/danmaku/bili/ui/main2/mine/PendingTask;", "hasWaitingTasks", "", "registerTask", "", "task", "unregisterTask", "executes", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MinePagePendingTaskUtil {
    public static final int $stable = 8;
    private final List<PendingTask> pendingTasks = new ArrayList();

    public final boolean hasWaitingTasks() {
        PendingTask it;
        Iterable $this$any$iv = this.pendingTasks;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            PendingTask it2 = (PendingTask) element$iv;
            if (it2.getTaskStatusFlow().getValue() == TaskStatus.WAITING_BE_EXECUTE) {
                it = 1;
                continue;
            } else {
                it = null;
                continue;
            }
            if (it != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerTask$lambda$0(PendingTask $task, PendingTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $task.getClass() == it.getClass();
    }

    public final void registerTask(final PendingTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        CollectionsKt.removeAll(this.pendingTasks, new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.MinePagePendingTaskUtil$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean registerTask$lambda$0;
                registerTask$lambda$0 = MinePagePendingTaskUtil.registerTask$lambda$0(PendingTask.this, (PendingTask) obj);
                return Boolean.valueOf(registerTask$lambda$0);
            }
        });
        this.pendingTasks.add(task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean unregisterTask$lambda$0(PendingTask $task, PendingTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $task.getClass() == it.getClass();
    }

    public final void unregisterTask(final PendingTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        CollectionsKt.removeAll(this.pendingTasks, new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.MinePagePendingTaskUtil$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean unregisterTask$lambda$0;
                unregisterTask$lambda$0 = MinePagePendingTaskUtil.unregisterTask$lambda$0(PendingTask.this, (PendingTask) obj);
                return Boolean.valueOf(unregisterTask$lambda$0);
            }
        });
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|8))|42|6|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
        r9 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x011b, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011c, code lost:
        r7 = r8;
        r3 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0120  */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00de -> B:22:0x0069). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x011c -> B:39:0x011d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executes(Continuation<? super Unit> continuation) {
        MinePagePendingTaskUtil$executes$1 minePagePendingTaskUtil$executes$1;
        MinePagePendingTaskUtil minePagePendingTaskUtil;
        Iterator it;
        PendingTask task;
        boolean z;
        Iterator it2;
        MinePagePendingTaskUtil minePagePendingTaskUtil2;
        boolean z2;
        if (continuation instanceof MinePagePendingTaskUtil$executes$1) {
            minePagePendingTaskUtil$executes$1 = (MinePagePendingTaskUtil$executes$1) continuation;
            if ((minePagePendingTaskUtil$executes$1.label & Integer.MIN_VALUE) != 0) {
                minePagePendingTaskUtil$executes$1.label -= Integer.MIN_VALUE;
                Object $result = minePagePendingTaskUtil$executes$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                minePagePendingTaskUtil = minePagePendingTaskUtil$executes$1.label;
                switch (minePagePendingTaskUtil) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        MinePagePendingTaskUtil minePagePendingTaskUtil3 = this;
                        Iterable $this$forEach$iv = minePagePendingTaskUtil3.pendingTasks;
                        z2 = false;
                        it2 = $this$forEach$iv.iterator();
                        minePagePendingTaskUtil = minePagePendingTaskUtil3;
                        if (!it2.hasNext()) {
                            Object element$iv = it2.next();
                            PendingTask task2 = (PendingTask) element$iv;
                            try {
                            } catch (Exception e) {
                                e = e;
                                Iterator it3 = it2;
                                task = task2;
                                z = z2;
                                it = it3;
                                BLog.e("MinePagePendingTaskUtil", "task has error! : " + Reflection.getOrCreateKotlinClass(task.getClass()).getSimpleName(), e);
                                minePagePendingTaskUtil$executes$1.L$0 = it;
                                minePagePendingTaskUtil$executes$1.L$1 = null;
                                minePagePendingTaskUtil$executes$1.label = 3;
                                if (task.onFailed(minePagePendingTaskUtil$executes$1) != coroutine_suspended) {
                                }
                            }
                            BLog.d("MinePagePendingTaskUtil", "start executing task. : " + Reflection.getOrCreateKotlinClass(task2.getClass()).getSimpleName());
                            minePagePendingTaskUtil$executes$1.L$0 = it2;
                            minePagePendingTaskUtil$executes$1.L$1 = task2;
                            minePagePendingTaskUtil$executes$1.label = 1;
                            if (task2.onExecute(minePagePendingTaskUtil$executes$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Iterator it4 = it2;
                            task = task2;
                            z = z2;
                            it = it4;
                            minePagePendingTaskUtil = minePagePendingTaskUtil;
                            BLog.d("MinePagePendingTaskUtil", "task be successful! : " + Reflection.getOrCreateKotlinClass(task.getClass()).getSimpleName());
                            minePagePendingTaskUtil$executes$1.L$0 = it;
                            minePagePendingTaskUtil$executes$1.L$1 = task;
                            minePagePendingTaskUtil$executes$1.label = 2;
                            minePagePendingTaskUtil2 = minePagePendingTaskUtil;
                            if (task.onSuccessful(minePagePendingTaskUtil$executes$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z2 = z;
                            it2 = it;
                            minePagePendingTaskUtil = minePagePendingTaskUtil2;
                            if (!it2.hasNext()) {
                                CollectionsKt.removeAll(minePagePendingTaskUtil.pendingTasks, new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.MinePagePendingTaskUtil$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj) {
                                        boolean executes$lambda$1;
                                        executes$lambda$1 = MinePagePendingTaskUtil.executes$lambda$1((PendingTask) obj);
                                        return Boolean.valueOf(executes$lambda$1);
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }
                        break;
                    case 1:
                        minePagePendingTaskUtil = this;
                        z = false;
                        task = (PendingTask) minePagePendingTaskUtil$executes$1.L$1;
                        it = (Iterator) minePagePendingTaskUtil$executes$1.L$0;
                        ResultKt.throwOnFailure($result);
                        BLog.d("MinePagePendingTaskUtil", "task be successful! : " + Reflection.getOrCreateKotlinClass(task.getClass()).getSimpleName());
                        minePagePendingTaskUtil$executes$1.L$0 = it;
                        minePagePendingTaskUtil$executes$1.L$1 = task;
                        minePagePendingTaskUtil$executes$1.label = 2;
                        minePagePendingTaskUtil2 = minePagePendingTaskUtil;
                        if (task.onSuccessful(minePagePendingTaskUtil$executes$1) == coroutine_suspended) {
                        }
                        z2 = z;
                        it2 = it;
                        minePagePendingTaskUtil = minePagePendingTaskUtil2;
                        if (!it2.hasNext()) {
                        }
                        break;
                    case 2:
                        minePagePendingTaskUtil2 = this;
                        z = false;
                        PendingTask pendingTask = (PendingTask) minePagePendingTaskUtil$executes$1.L$1;
                        it = (Iterator) minePagePendingTaskUtil$executes$1.L$0;
                        ResultKt.throwOnFailure($result);
                        z2 = z;
                        it2 = it;
                        minePagePendingTaskUtil = minePagePendingTaskUtil2;
                        if (!it2.hasNext()) {
                        }
                        break;
                    case 3:
                        MinePagePendingTaskUtil minePagePendingTaskUtil4 = this;
                        z = false;
                        it2 = (Iterator) minePagePendingTaskUtil$executes$1.L$0;
                        ResultKt.throwOnFailure($result);
                        z2 = z;
                        minePagePendingTaskUtil = minePagePendingTaskUtil4;
                        if (!it2.hasNext()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        minePagePendingTaskUtil$executes$1 = new MinePagePendingTaskUtil$executes$1(this, continuation);
        Object $result2 = minePagePendingTaskUtil$executes$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        minePagePendingTaskUtil = minePagePendingTaskUtil$executes$1.label;
        switch (minePagePendingTaskUtil) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean executes$lambda$1(PendingTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        return task.ifRemoveInList();
    }
}