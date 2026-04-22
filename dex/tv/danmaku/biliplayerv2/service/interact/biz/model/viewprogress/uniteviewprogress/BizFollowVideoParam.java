package tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DmResource.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/BizFollowVideoParam;", "", "<init>", "()V", "seasonId", "", "getSeasonId", "()J", "setSeasonId", "(J)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BizFollowVideoParam {
    private long seasonId;

    public final long getSeasonId() {
        return this.seasonId;
    }

    public final void setSeasonId(long j) {
        this.seasonId = j;
    }
}