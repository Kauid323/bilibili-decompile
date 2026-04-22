package tv.danmaku.bili.downloadeshare;

import com.bilibili.lib.downloadshare.api.DownloadShareInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DownloadShareContext.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/downloadeshare/DownloadShareContext;", "", "parameter", "Ltv/danmaku/bili/downloadeshare/DownloadShareParameter;", "<init>", "(Ltv/danmaku/bili/downloadeshare/DownloadShareParameter;)V", "getParameter", "()Ltv/danmaku/bili/downloadeshare/DownloadShareParameter;", "downloadInfo", "Lcom/bilibili/lib/downloadshare/api/DownloadShareInfo;", "getDownloadInfo", "()Lcom/bilibili/lib/downloadshare/api/DownloadShareInfo;", "setDownloadInfo", "(Lcom/bilibili/lib/downloadshare/api/DownloadShareInfo;)V", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DownloadShareContext {
    private DownloadShareInfo downloadInfo;
    private final DownloadShareParameter parameter;

    public DownloadShareContext(DownloadShareParameter parameter) {
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        this.parameter = parameter;
    }

    public final DownloadShareParameter getParameter() {
        return this.parameter;
    }

    public final DownloadShareInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public final void setDownloadInfo(DownloadShareInfo downloadShareInfo) {
        this.downloadInfo = downloadShareInfo;
    }
}