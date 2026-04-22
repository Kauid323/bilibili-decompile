package video.biz.offline.base.infra.utils;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.IVBLog;

/* compiled from: Log.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lvideo/biz/offline/base/infra/utils/OfflineLog;", "Lvideo/base/log/IVBLog;", "<init>", "()V", "logType", "", "getLogType", "()Ljava/lang/String;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineLog implements IVBLog {
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

    @Override // video.base.log.IVBLog
    public String getLogType() {
        return "Offline-Common";
    }
}