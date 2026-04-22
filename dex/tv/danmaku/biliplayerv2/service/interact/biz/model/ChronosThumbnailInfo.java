package tv.danmaku.biliplayerv2.service.interact.biz.model;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.VideoPoint;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosThumbnailInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo;", "", "<init>", "()V", "cid", "", "getCid", "()Ljava/lang/String;", "setCid", "(Ljava/lang/String;)V", "watchPoints", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo$WatchPoint;", "getWatchPoints", "()Ljava/util/List;", "setWatchPoints", "(Ljava/util/List;)V", "segmentSwitchVisibility", "", "getSegmentSwitchVisibility", "()Z", "setSegmentSwitchVisibility", "(Z)V", "WatchPoint", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosThumbnailInfo {
    private String cid;
    private boolean segmentSwitchVisibility;
    private List<WatchPoint> watchPoints;

    public final String getCid() {
        return this.cid;
    }

    public final void setCid(String str) {
        this.cid = str;
    }

    public final List<WatchPoint> getWatchPoints() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.watchPoints);
    }

    public final void setWatchPoints(List<WatchPoint> list) {
        this.watchPoints = list;
    }

    public final boolean getSegmentSwitchVisibility() {
        return this.segmentSwitchVisibility;
    }

    public final void setSegmentSwitchVisibility(boolean z) {
        this.segmentSwitchVisibility = z;
    }

    /* compiled from: ChronosThumbnailInfo.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo$WatchPoint;", "", "<init>", "()V", "videoPoint", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoPoint;", "getVideoPoint", "()Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoPoint;", "setVideoPoint", "(Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoPoint;)V", "type", "", "getType", "()I", "from", "getFrom", "to", "getTo", "content", "", "getContent", "()Ljava/lang/String;", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "getCover", "logoUrl", "getLogoUrl", "teamType", "getTeamType", "teamName", "getTeamName", "index", "getIndex", "setIndex", "(I)V", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class WatchPoint {
        public static final Companion Companion = new Companion(null);
        public static final int TYPE_CHAPTER = 2;
        public static final int TYPE_HEADER_TAIL = 10;
        public static final int TYPE_HIGHLIGHT = 1;
        private int index;
        private VideoPoint videoPoint;

        /* compiled from: ChronosThumbnailInfo.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo$WatchPoint$Companion;", "", "<init>", "()V", "TYPE_HIGHLIGHT", "", "TYPE_CHAPTER", "TYPE_HEADER_TAIL", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public final VideoPoint getVideoPoint() {
            return this.videoPoint;
        }

        public final void setVideoPoint(VideoPoint videoPoint) {
            this.videoPoint = videoPoint;
        }

        public final int getType() {
            VideoPoint videoPoint = this.videoPoint;
            if (videoPoint != null) {
                return videoPoint.getType();
            }
            return 0;
        }

        public final int getFrom() {
            VideoPoint videoPoint = this.videoPoint;
            if (videoPoint != null) {
                return (int) videoPoint.getFrom();
            }
            return 0;
        }

        public final int getTo() {
            VideoPoint videoPoint = this.videoPoint;
            if (videoPoint != null) {
                return (int) videoPoint.getTo();
            }
            return 0;
        }

        public final String getContent() {
            VideoPoint videoPoint = this.videoPoint;
            if (videoPoint != null) {
                return videoPoint.getContent();
            }
            return null;
        }

        public final String getCover() {
            VideoPoint videoPoint = this.videoPoint;
            if (videoPoint != null) {
                return videoPoint.getCover();
            }
            return null;
        }

        public final String getLogoUrl() {
            VideoPoint videoPoint = this.videoPoint;
            if (videoPoint != null) {
                return videoPoint.getLogoUrl();
            }
            return null;
        }

        public final String getTeamType() {
            VideoPoint videoPoint = this.videoPoint;
            if (videoPoint != null) {
                return videoPoint.getTeamType();
            }
            return null;
        }

        public final String getTeamName() {
            VideoPoint videoPoint = this.videoPoint;
            if (videoPoint != null) {
                return videoPoint.getTeamName();
            }
            return null;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }
}