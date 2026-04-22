package video.biz.offline.base.infra.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.IVBLog;

/* compiled from: Log.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0003J\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0007J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lvideo/biz/offline/base/infra/utils/DownloadLog;", "Lvideo/base/log/IVBLog;", "key", "", "<init>", "(Ljava/lang/String;)V", "add", "", "isPending", "", "beginFlow", "resolvePlayView", "params", "configTasks", "count", "", "startDownload", "task", "progress", "current", "", "total", "taskComplete", "allComplete", "fail", "error", "", "retry", "times", "logType", "getLogType", "()Ljava/lang/String;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DownloadLog implements IVBLog {
    public static final int $stable = 0;
    private final String key;

    public DownloadLog() {
        this(null, 1, null);
    }

    public DownloadLog(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
    }

    public /* synthetic */ DownloadLog(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    @Override // video.base.log.IVBLog
    public /* bridge */ void debug(String message) {
        IVBLog.CC.$default$debug(this, message);
    }

    @Override // video.base.log.IVBLog
    public /* bridge */ void error(String message) {
        IVBLog.CC.$default$error(this, message);
    }

    @Override // video.base.log.IVBLog
    public /* bridge */ void error(String message, Throwable throwable) {
        IVBLog.CC.$default$error(this, message, throwable);
    }

    @Override // video.base.log.IVBLog
    public /* bridge */ void info(String message) {
        IVBLog.CC.$default$info(this, message);
    }

    @Override // video.base.log.IVBLog
    public /* bridge */ void warn(String message) {
        IVBLog.CC.$default$warn(this, message);
    }

    public final void add(boolean isPending) {
        info("下载流程:1. 添加到下载队列, 是否等待: " + isPending);
    }

    public final void beginFlow() {
        info("下载流程:2. 进入正式下载流程");
    }

    public final void resolvePlayView(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        info("下载流程:3. 请求playView参数: " + params);
    }

    public final void configTasks(int count) {
        info("下载流程:4. 配置下载任务: " + count + " 个");
    }

    public final void startDownload(String task) {
        Intrinsics.checkNotNullParameter(task, "task");
        info("下载流程:5. 开始资源下载: " + task);
    }

    public final void progress(long current, long total) {
        info("下载流程:6. 下载进度: " + ((int) ((100 * current) / total)) + " " + current + EntryScannerKt.PATH_SEPARATOR + total);
    }

    public final void taskComplete(String task) {
        Intrinsics.checkNotNullParameter(task, "task");
        info("下载流程:7. 单个task下载完成 " + task);
    }

    public final void allComplete() {
        info("下载流程:7. all task 下载完成");
    }

    public final void fail(String task, Throwable error) {
        Intrinsics.checkNotNullParameter(task, "task");
        info("下载流程:8. " + task + " 下载失败, 原始error: " + error);
    }

    public final void retry(int times) {
        info("下载流程:9. 重试下载, times: " + times);
    }

    @Override // video.base.log.IVBLog
    public String getLogType() {
        return "Download" + (this.key.length() > 0 ? "-" + this.key : "");
    }
}