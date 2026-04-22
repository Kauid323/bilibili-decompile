package tv.danmaku.videoplayer.coreV2.transformer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.VideoBizType;

/* compiled from: IMediaItemTransformer.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u0016"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;", "", "seasonId", "", "epid", "avid", "cid", RankRouter.BundleKey.AUTHOR_SPACE_MID, "type", "Ltv/danmaku/videoplayer/coreV2/VideoBizType;", "createTime", "<init>", "(JJJJJLtv/danmaku/videoplayer/coreV2/VideoBizType;J)V", "getSeasonId", "()J", "getEpid", "getAvid", "getCid", "getMid", "getType", "()Ltv/danmaku/videoplayer/coreV2/VideoBizType;", "getCreateTime", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class P2PParams {
    private final long avid;
    private final long cid;
    private final long createTime;
    private final long epid;
    private final long mid;
    private final long seasonId;
    private final VideoBizType type;

    public P2PParams(long seasonId, long epid, long avid, long cid, long mid, VideoBizType type, long createTime) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.seasonId = seasonId;
        this.epid = epid;
        this.avid = avid;
        this.cid = cid;
        this.mid = mid;
        this.type = type;
        this.createTime = createTime;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ P2PParams(long j, long j2, long j3, long j4, long j5, VideoBizType videoBizType, long j6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, videoBizType, r14);
        long j7;
        if ((i & 64) == 0) {
            j7 = j6;
        } else {
            j7 = 0;
        }
    }

    public final long getSeasonId() {
        return this.seasonId;
    }

    public final long getEpid() {
        return this.epid;
    }

    public final long getAvid() {
        return this.avid;
    }

    public final long getCid() {
        return this.cid;
    }

    public final long getMid() {
        return this.mid;
    }

    public final VideoBizType getType() {
        return this.type;
    }

    public final long getCreateTime() {
        return this.createTime;
    }
}