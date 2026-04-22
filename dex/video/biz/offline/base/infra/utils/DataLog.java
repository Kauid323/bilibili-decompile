package video.biz.offline.base.infra.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.IVBLog;

/* compiled from: Log.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lvideo/biz/offline/base/infra/utils/DataLog;", "Lvideo/base/log/IVBLog;", "<init>", "()V", "loadTaskFiles", "", "count", "", "time", "", "loadDramaFiles", "loadDisFilesError", "fileType", "", "throwable", "", "logType", "getLogType", "()Ljava/lang/String;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DataLog implements IVBLog {
    public static final int $stable = 0;

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

    public final void loadTaskFiles(int count, long time) {
        info("加载task文件: " + count + " 个, 耗时: " + time + " ms");
    }

    public final void loadDramaFiles(int count, long time) {
        info("加载drama文件: " + count + " 个, 耗时: " + time + " ms");
    }

    public final void loadDisFilesError(String fileType, Throwable throwable) {
        Intrinsics.checkNotNullParameter(fileType, "fileType");
        error("加载文件失败 type:[" + fileType + "] error: " + throwable);
    }

    @Override // video.base.log.IVBLog
    public String getLogType() {
        return "Offline-Data";
    }
}