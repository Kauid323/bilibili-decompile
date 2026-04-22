package tv.danmaku.biliplayerv2.service.resolve;

import android.os.SystemClock;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.biliplayerv2.profiler.PlayerProfiler;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayerResolveService.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u000f\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u00104\u001a\u0002052\u000e\u00106\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000J\b\u00107\u001a\u000205H\u0017J\b\u00108\u001a\u00020\u001bH\u0007J\u001e\u00109\u001a\u0002052\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00000\u0007H\u0007J\u0012\u0010:\u001a\u0002052\b\u0010;\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010<\u001a\u0002052\b\u0010=\u001a\u0004\u0018\u00010\u0013H\u0007J$\u0010>\u001a\u0002052\u0006\u0010?\u001a\u00020\u00152\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010AJ\b\u0010B\u001a\u000205H\u0004J\b\u0010C\u001a\u000205H\u0004J\b\u0010D\u001a\u000205H\u0004J\b\u0010E\u001a\u000205H\u0004J\b\u0010F\u001a\u000205H\u0004J\u0018\u0010G\u001a\u0002052\u000e\u00106\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000H\u0007J\u000f\u0010H\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010IJ\u000f\u0010J\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010IJ\b\u0010K\u001a\u000205H&J\b\u0010L\u001a\u000205H\u0016J\u0018\u0010M\u001a\u0002052\u000e\u0010N\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000H\u0016J\b\u0010O\u001a\u00020\u001bH\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00000\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u0012\u0010+\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0017R\u0014\u0010-\u001a\u00020\u001bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006P"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/Task;", "R", "E", "", "<init>", "()V", "mParentTasks", "", "mChildTasks", "childTasks", "getChildTasks", "()Ljava/util/List;", "mBackupTask", "backupTask", "getBackupTask", "()Ltv/danmaku/biliplayerv2/service/resolve/Task;", "mDispatcher", "Ltv/danmaku/biliplayerv2/service/resolve/ResolveDispatcher;", "mProfiler", "Ltv/danmaku/biliplayerv2/profiler/PlayerProfiler;", "entryId", "", "getEntryId", "()Ljava/lang/String;", "setEntryId", "(Ljava/lang/String;)V", "isPrimary", "", "()Z", "setPrimary", "(Z)V", "isCompleted", "setCompleted", "timeConsume", "", "getTimeConsume", "()J", "setTimeConsume", "(J)V", "mStartTimestamp", "threadDispatchStartTimestamp", "getThreadDispatchStartTimestamp", "setThreadDispatchStartTimestamp", "description", "getDescription", "isAsynchronous", "progress", "", "getProgress", "()F", "setProgress", "(F)V", "setBackupTask", "", "task", "setBackupTaskProperty", "hasBackupTask", "setChildTasks", "setDispatcher", "dispatcher", "setProfiler", "profiler", "doProfile", "tag", "argsMap", "", "dispatchTaskStart", "dispatchTaskError", "dispatchTaskProgress", "dispatchTaskSucceed", "dispatchToBackupTask", "dependOn", "getError", "()Ljava/lang/Object;", "getResult", "run", SplashCustomReporterKt.STATE_CANCEL, "onDependSucceed", "dt", "isReady", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class Task<R, E> {
    private boolean isCompleted;
    private boolean isPrimary;
    private Task<?, ?> mBackupTask;
    private ResolveDispatcher mDispatcher;
    private PlayerProfiler mProfiler;
    private long mStartTimestamp;
    private float progress;
    private long threadDispatchStartTimestamp;
    private long timeConsume;
    private final List<Task<?, ?>> mParentTasks = new ArrayList(0);
    private final List<Task<?, ?>> mChildTasks = new ArrayList(0);
    private String entryId = "";
    private final boolean isAsynchronous = true;

    public abstract String getDescription();

    public abstract E getError();

    public abstract R getResult();

    public abstract void run();

    public final List<Task<?, ?>> getChildTasks() {
        return this.mChildTasks;
    }

    public final Task<?, ?> getBackupTask() {
        return this.mBackupTask;
    }

    public final String getEntryId() {
        return this.entryId;
    }

    public final void setEntryId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.entryId = str;
    }

    public final boolean isPrimary() {
        return this.isPrimary;
    }

    public final void setPrimary(boolean z) {
        this.isPrimary = z;
    }

    public final boolean isCompleted() {
        return this.isCompleted;
    }

    public final void setCompleted(boolean z) {
        this.isCompleted = z;
    }

    public final long getTimeConsume() {
        return this.timeConsume;
    }

    public final void setTimeConsume(long j) {
        this.timeConsume = j;
    }

    public final long getThreadDispatchStartTimestamp() {
        return this.threadDispatchStartTimestamp;
    }

    public final void setThreadDispatchStartTimestamp(long j) {
        this.threadDispatchStartTimestamp = j;
    }

    public boolean isAsynchronous() {
        return this.isAsynchronous;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final void setProgress(float f) {
        this.progress = f;
    }

    public final void setBackupTask(Task<?, ?> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.mBackupTask = task;
    }

    public void setBackupTaskProperty() {
        Task it = this.mBackupTask;
        if (it != null) {
            it.mProfiler = this.mProfiler;
            it.isPrimary = this.isPrimary;
            it.entryId = this.entryId;
            it.setChildTasks(getChildTasks());
        }
    }

    public final boolean hasBackupTask() {
        return this.mBackupTask != null;
    }

    public final void setChildTasks(List<Task<?, ?>> list) {
        Intrinsics.checkNotNullParameter(list, "childTasks");
        this.mChildTasks.clear();
        this.mChildTasks.addAll(list);
    }

    public final void setDispatcher(ResolveDispatcher dispatcher) {
        this.mDispatcher = dispatcher;
    }

    public final void setProfiler(PlayerProfiler profiler) {
        this.mProfiler = profiler;
    }

    public final void doProfile(String tag, Map<String, String> map) {
        Map argsMap = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(tag, "tag");
        PlayerProfiler playerProfiler = this.mProfiler;
        if (playerProfiler != null) {
            playerProfiler.doProfile(tag, argsMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dispatchTaskStart() {
        this.mStartTimestamp = SystemClock.elapsedRealtime();
        ResolveDispatcher resolveDispatcher = this.mDispatcher;
        if (resolveDispatcher != null) {
            resolveDispatcher.dispatchTaskStart(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dispatchTaskError() {
        this.timeConsume = SystemClock.elapsedRealtime() - this.mStartTimestamp;
        ResolveDispatcher resolveDispatcher = this.mDispatcher;
        if (resolveDispatcher != null) {
            resolveDispatcher.dispatchTaskError(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dispatchTaskProgress() {
        ResolveDispatcher resolveDispatcher = this.mDispatcher;
        if (resolveDispatcher != null) {
            resolveDispatcher.dispatchTaskProgress(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dispatchTaskSucceed() {
        this.progress = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        this.timeConsume = SystemClock.elapsedRealtime() - this.mStartTimestamp;
        this.threadDispatchStartTimestamp = SystemClock.elapsedRealtime();
        ResolveDispatcher resolveDispatcher = this.mDispatcher;
        if (resolveDispatcher != null) {
            resolveDispatcher.dispatchTaskSucceed(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void dispatchToBackupTask() {
        Task<?, ?> backupTask = getBackupTask();
        if (backupTask != null) {
            backupTask.run();
        }
    }

    @Deprecated(message = "hitPreloadV2 全量后可删除")
    public final void dependOn(Task<?, ?> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.mParentTasks.add(task);
        task.getChildTasks().add(this);
    }

    public void cancel() {
        if (!this.mParentTasks.isEmpty()) {
            this.mParentTasks.clear();
        }
        if (!this.mChildTasks.isEmpty()) {
            this.mChildTasks.clear();
        }
        this.mDispatcher = null;
    }

    public void onDependSucceed(Task<?, ?> task) {
        Intrinsics.checkNotNullParameter(task, "dt");
        this.mParentTasks.remove(task);
    }

    public boolean isReady() {
        return this.mParentTasks.isEmpty();
    }
}