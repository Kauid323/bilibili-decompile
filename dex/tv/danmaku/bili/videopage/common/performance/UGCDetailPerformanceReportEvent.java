package tv.danmaku.bili.videopage.common.performance;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UGCProfilerReporter.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0017¢\u0006\u0002\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/videopage/common/performance/UGCDetailPerformanceReportEvent;", "", "<init>", "()V", "pageName", "", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "pageArg", "getPageArg", "setPageArg", "ua", "getUa", "setUa", "h5Child", "getH5Child", "setH5Child", "args", "getArgs", "setArgs", "asArgs", "", "()[Ljava/lang/String;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
final class UGCDetailPerformanceReportEvent {
    private String args;
    private String h5Child;
    private String pageArg;
    private String pageName;
    private String ua;

    public final String getPageName() {
        return this.pageName;
    }

    public final void setPageName(String str) {
        this.pageName = str;
    }

    public final String getPageArg() {
        return this.pageArg;
    }

    public final void setPageArg(String str) {
        this.pageArg = str;
    }

    public final String getUa() {
        return this.ua;
    }

    public final void setUa(String str) {
        this.ua = str;
    }

    public final String getH5Child() {
        return this.h5Child;
    }

    public final void setH5Child(String str) {
        this.h5Child = str;
    }

    public final String getArgs() {
        return this.args;
    }

    public final void setArgs(String str) {
        this.args = str;
    }

    public final String[] asArgs() {
        return new String[]{this.pageName, this.pageArg, this.ua, this.h5Child, this.args};
    }
}