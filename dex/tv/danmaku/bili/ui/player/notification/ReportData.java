package tv.danmaku.bili.ui.player.notification;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ReportData.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/ReportData;", "", "cardEntityId", "", "trackId", "", "<init>", "(JLjava/lang/String;)V", "getCardEntityId", "()J", "setCardEntityId", "(J)V", "getTrackId", "()Ljava/lang/String;", "setTrackId", "(Ljava/lang/String;)V", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ReportData {
    private long cardEntityId;
    private String trackId;

    public ReportData(long cardEntityId, String trackId) {
        this.cardEntityId = cardEntityId;
        this.trackId = trackId;
    }

    public final long getCardEntityId() {
        return this.cardEntityId;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final void setCardEntityId(long j) {
        this.cardEntityId = j;
    }

    public final void setTrackId(String str) {
        this.trackId = str;
    }
}