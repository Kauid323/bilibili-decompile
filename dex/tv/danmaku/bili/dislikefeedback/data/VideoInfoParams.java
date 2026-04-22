package tv.danmaku.bili.dislikefeedback.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: VideoInfoParams.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/dislikefeedback/data/VideoInfoParams;", "", "avid", "", "bvid", "", "cid", "<init>", "(JLjava/lang/String;J)V", "getAvid", "()J", "getBvid", "()Ljava/lang/String;", "getCid", "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class VideoInfoParams {
    private final long avid;
    private final String bvid;
    private final long cid;

    public VideoInfoParams(long avid, String bvid, long cid) {
        Intrinsics.checkNotNullParameter(bvid, "bvid");
        this.avid = avid;
        this.bvid = bvid;
        this.cid = cid;
    }

    public final long getAvid() {
        return this.avid;
    }

    public final String getBvid() {
        return this.bvid;
    }

    public final long getCid() {
        return this.cid;
    }
}