package tv.danmaku.biliplayerv2.service.interact.biz;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IInteractLayerService.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/ChronosSaveState;", "", "remoteToken", "", "workId", "", "videoId", "<init>", "(Ljava/lang/String;JJ)V", "getRemoteToken", "()Ljava/lang/String;", "getWorkId", "()J", "getVideoId", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosSaveState {
    private final String remoteToken;
    private final long videoId;
    private final long workId;

    public ChronosSaveState(String remoteToken, long workId, long videoId) {
        this.remoteToken = remoteToken;
        this.workId = workId;
        this.videoId = videoId;
    }

    public final String getRemoteToken() {
        return this.remoteToken;
    }

    public final long getWorkId() {
        return this.workId;
    }

    public final long getVideoId() {
        return this.videoId;
    }
}