package tv.danmaku.biliplayerv2.service;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import android.text.TextUtils;
import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.player.history.IMediaHistoryKeyParams;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.DisplayOrientation;
import tv.danmaku.biliplayerv2.service.report.heartbeat.ReportMetaInfo;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.share.SharableObject;
import tv.danmaku.videoplayer.coreV2.VideoBizType;
import tv.danmaku.videoplayer.coreV2.transformer.P2PParams;

/* compiled from: IVideoPlayDirectorService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\t123456789B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010-\u001a\u00020\u00192\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010/\u001a\u00020\u000bH\u0016J\b\u00100\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010\u0003\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001d¨\u0006:"}, d2 = {"Ltv/danmaku/biliplayerv2/service/Video;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "type", "", "getType", "()I", "setType", "(I)V", "currentIndex", "getCurrentIndex", "setCurrentIndex", "extra", "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "forceReplay", "", "getForceReplay", "()Z", "setForceReplay", "(Z)V", "isPlayCompleted", "setPlayCompleted", "description", "getDescription", "setDescription", "mComparator", "Ltv/danmaku/biliplayerv2/service/Video$Comparator;", "getMComparator", "()Ltv/danmaku/biliplayerv2/service/Video$Comparator;", "setMComparator", "(Ltv/danmaku/biliplayerv2/service/Video$Comparator;)V", "enablePreload", "getEnablePreload$annotations", "getEnablePreload", "setEnablePreload", "equals", "other", "hashCode", "toString", "Comparator", "PlayableParams", "ProjectionParams", "DisplayParams", "FeedbackParams", "DanmakuResolveParams", "ReportCommonParams", "InteractParams", "VideoType", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Video {
    private int currentIndex;
    private boolean enablePreload;
    private Object extra;
    private boolean forceReplay;
    private boolean isPlayCompleted;
    private Comparator mComparator;
    private String id = "@" + this;
    private int type = -1;
    private String description = "video";

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/Video$Comparator;", "", "equals", "", "video1", "Ltv/danmaku/biliplayerv2/service/Video;", "video2", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface Comparator {
        boolean equals(Video video2, Video video3);
    }

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/Video$ReportCommonParams;", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/ReportMetaInfo;", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ReportCommonParams extends ReportMetaInfo {
    }

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/Video$VideoType;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "INTERACT", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum VideoType {
        NORMAL,
        INTERACT;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<VideoType> getEntries() {
            return $ENTRIES;
        }
    }

    @Deprecated(message = "use PlayDirectorServiceV2-PlayableParams.enablePreload")
    public static /* synthetic */ void getEnablePreload$annotations() {
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final void setCurrentIndex(int i) {
        this.currentIndex = i;
    }

    public final Object getExtra() {
        return this.extra;
    }

    public final void setExtra(Object obj) {
        this.extra = obj;
    }

    public final boolean getForceReplay() {
        return this.forceReplay;
    }

    public final void setForceReplay(boolean z) {
        this.forceReplay = z;
    }

    public final boolean isPlayCompleted() {
        return this.isPlayCompleted;
    }

    public final void setPlayCompleted(boolean z) {
        this.isPlayCompleted = z;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final Comparator getMComparator() {
        return this.mComparator;
    }

    public final void setMComparator(Comparator comparator) {
        this.mComparator = comparator;
    }

    public final boolean getEnablePreload() {
        return this.enablePreload;
    }

    public final void setEnablePreload(boolean z) {
        this.enablePreload = z;
    }

    public boolean equals(Object other) {
        if (other instanceof Video) {
            if (this.mComparator == null) {
                return TextUtils.equals(this.id, ((Video) other).id);
            }
            Comparator comparator = this.mComparator;
            Intrinsics.checkNotNull(comparator);
            return comparator.equals(this, (Video) other);
        }
        return false;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return String.valueOf(super.hashCode());
    }

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010U\u001a\u00020\u001dH&J\b\u0010V\u001a\u00020\u001dH&J\b\u0010W\u001a\u00020XH'J\b\u0010Y\u001a\u00020ZH&J\n\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\n\u0010]\u001a\u0004\u0018\u00010^H&J\n\u0010_\u001a\u0004\u0018\u00010`H\u0016J\n\u0010a\u001a\u0004\u0018\u00010bH\u0016J\n\u0010c\u001a\u0004\u0018\u00010dH\u0016J\n\u0010e\u001a\u0004\u0018\u00010fH\u0016J\n\u0010g\u001a\u0004\u0018\u00010hH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010%\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001c\u0010(\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001a\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001c\u00101\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\u001c\u00104\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\u001c\u00107\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010!R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\tR\u001a\u0010B\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0013\"\u0004\bD\u0010\u0015R\u001c\u0010E\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001f\"\u0004\bG\u0010!R\u001a\u0010H\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0007\"\u0004\bJ\u0010\tR(\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR(\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010N\"\u0004\bT\u0010P¨\u0006i"}, d2 = {"Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "Ltv/danmaku/videoplayer/core/share/SharableObject;", "<init>", "()V", "enablePreload", "", "getEnablePreload", "()Z", "setEnablePreload", "(Z)V", "videoType", "Ltv/danmaku/biliplayerv2/service/Video$VideoType;", "getVideoType", "()Ltv/danmaku/biliplayerv2/service/Video$VideoType;", "setVideoType", "(Ltv/danmaku/biliplayerv2/service/Video$VideoType;)V", "expectedQuality", "", "getExpectedQuality", "()I", "setExpectedQuality", "(I)V", "fnVer", "getFnVer", "setFnVer", "fnVal", "getFnVal", "setFnVal", "jumpFrom", "", "getJumpFrom", "()Ljava/lang/String;", "setJumpFrom", "(Ljava/lang/String;)V", "shareJumpFrom", "getShareJumpFrom", "setShareJumpFrom", "from", "getFrom", "setFrom", "trackId", "getTrackId", "setTrackId", "needResolveFromLocalCache", "getNeedResolveFromLocalCache", "setNeedResolveFromLocalCache", "forceLocalOnly", "getForceLocalOnly", "setForceLocalOnly", "spmid", "getSpmid", "setSpmid", "fromSpmid", "getFromSpmid", "setFromSpmid", "flashJsonStr", "getFlashJsonStr", "setFlashJsonStr", "bizType", "Ltv/danmaku/videoplayer/coreV2/VideoBizType;", "getBizType", "()Ltv/danmaku/videoplayer/coreV2/VideoBizType;", "setBizType", "(Ltv/danmaku/videoplayer/coreV2/VideoBizType;)V", "isEnableSafeConnection", "setEnableSafeConnection", "fromAutoPlay", "getFromAutoPlay", "setFromAutoPlay", "playMode", "getPlayMode", "setPlayMode", "autoStartWhenPrepared", "getAutoStartWhenPrepared", "setAutoStartWhenPrepared", "legacyExtra", "", "getLegacyExtra", "()Ljava/util/Map;", "setLegacyExtra", "(Ljava/util/Map;)V", "extraJsonParams", "", "getExtraJsonParams", "setExtraJsonParams", "getLogDescription", "id", "getDisplayParams", "Ltv/danmaku/biliplayerv2/service/Video$DisplayParams;", "getFeedbackParams", "Ltv/danmaku/biliplayerv2/service/Video$FeedbackParams;", "getDanmakuResolveParams", "Ltv/danmaku/biliplayerv2/service/Video$DanmakuResolveParams;", "getReportCommonParams", "Ltv/danmaku/biliplayerv2/service/Video$ReportCommonParams;", "getResolveParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "getMediaHistoryKayParams", "Lcom/bilibili/player/history/IMediaHistoryKeyParams;", "getProjectionParams", "Ltv/danmaku/biliplayerv2/service/Video$ProjectionParams;", "getInteractParams", "Ltv/danmaku/biliplayerv2/service/Video$InteractParams;", "getP2PParams", "Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class PlayableParams extends SharableObject {
        private boolean enablePreload;
        private int expectedQuality;
        private Map<String, String> extraJsonParams;
        private String flashJsonStr;
        private int fnVer;
        private boolean forceLocalOnly;
        private String from;
        private int fromAutoPlay;
        private String fromSpmid;
        private boolean isEnableSafeConnection;
        private String jumpFrom;
        private Map<String, String> legacyExtra;
        private boolean needResolveFromLocalCache;
        private String shareJumpFrom;
        private String spmid;
        private String trackId;
        private VideoType videoType = VideoType.NORMAL;
        private int fnVal = 16;
        private VideoBizType bizType = VideoBizType.UNKNOWN;
        private String playMode = "1";
        private boolean autoStartWhenPrepared = true;

        @Deprecated(message = "不应继续使用display params，业务上自行维护一些相关数据和字段")
        public abstract DisplayParams getDisplayParams();

        public abstract FeedbackParams getFeedbackParams();

        public abstract String getLogDescription();

        public abstract ReportCommonParams getReportCommonParams();

        public abstract String id();

        public final boolean getEnablePreload() {
            return this.enablePreload;
        }

        public final void setEnablePreload(boolean z) {
            this.enablePreload = z;
        }

        public final VideoType getVideoType() {
            return this.videoType;
        }

        public final void setVideoType(VideoType videoType) {
            Intrinsics.checkNotNullParameter(videoType, "<set-?>");
            this.videoType = videoType;
        }

        public final int getExpectedQuality() {
            return this.expectedQuality;
        }

        public final void setExpectedQuality(int i) {
            this.expectedQuality = i;
        }

        public final int getFnVer() {
            return this.fnVer;
        }

        public final void setFnVer(int i) {
            this.fnVer = i;
        }

        public final int getFnVal() {
            return this.fnVal;
        }

        public final void setFnVal(int i) {
            this.fnVal = i;
        }

        public final String getJumpFrom() {
            return this.jumpFrom;
        }

        public final void setJumpFrom(String str) {
            this.jumpFrom = str;
        }

        public final String getShareJumpFrom() {
            return this.shareJumpFrom;
        }

        public final void setShareJumpFrom(String str) {
            this.shareJumpFrom = str;
        }

        public final String getFrom() {
            return this.from;
        }

        public final void setFrom(String str) {
            this.from = str;
        }

        public final String getTrackId() {
            return this.trackId;
        }

        public final void setTrackId(String str) {
            this.trackId = str;
        }

        public final boolean getNeedResolveFromLocalCache() {
            return this.needResolveFromLocalCache;
        }

        public final void setNeedResolveFromLocalCache(boolean z) {
            this.needResolveFromLocalCache = z;
        }

        public final boolean getForceLocalOnly() {
            return this.forceLocalOnly;
        }

        public final void setForceLocalOnly(boolean z) {
            this.forceLocalOnly = z;
        }

        public final String getSpmid() {
            return this.spmid;
        }

        public final void setSpmid(String str) {
            this.spmid = str;
        }

        public final String getFromSpmid() {
            return this.fromSpmid;
        }

        public final void setFromSpmid(String str) {
            this.fromSpmid = str;
        }

        public final String getFlashJsonStr() {
            return this.flashJsonStr;
        }

        public final void setFlashJsonStr(String str) {
            this.flashJsonStr = str;
        }

        public final VideoBizType getBizType() {
            return this.bizType;
        }

        public final void setBizType(VideoBizType videoBizType) {
            Intrinsics.checkNotNullParameter(videoBizType, "<set-?>");
            this.bizType = videoBizType;
        }

        public final boolean isEnableSafeConnection() {
            return this.isEnableSafeConnection;
        }

        public final void setEnableSafeConnection(boolean z) {
            this.isEnableSafeConnection = z;
        }

        public final int getFromAutoPlay() {
            return this.fromAutoPlay;
        }

        public final void setFromAutoPlay(int i) {
            this.fromAutoPlay = i;
        }

        public final String getPlayMode() {
            return this.playMode;
        }

        public final void setPlayMode(String str) {
            this.playMode = str;
        }

        public final boolean getAutoStartWhenPrepared() {
            return this.autoStartWhenPrepared;
        }

        public final void setAutoStartWhenPrepared(boolean z) {
            this.autoStartWhenPrepared = z;
        }

        public final Map<String, String> getLegacyExtra() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.legacyExtra);
        }

        public final void setLegacyExtra(Map<String, String> map) {
            this.legacyExtra = map;
        }

        public final Map<String, String> getExtraJsonParams() {
            return this.extraJsonParams;
        }

        public final void setExtraJsonParams(Map<String, String> map) {
            this.extraJsonParams = map;
        }

        public DanmakuResolveParams getDanmakuResolveParams() {
            return null;
        }

        public IResolveParams getResolveParams() {
            return null;
        }

        public IMediaHistoryKeyParams getMediaHistoryKayParams() {
            return null;
        }

        public ProjectionParams getProjectionParams() {
            return null;
        }

        public InteractParams getInteractParams() {
            return null;
        }

        public P2PParams getP2PParams() {
            return null;
        }
    }

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/Video$ProjectionParams;", "", "<init>", "()V", "businessType", "", "getBusinessType", "()I", "setBusinessType", "(I)V", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ProjectionParams {
        public static final int BUSINESS_TYPE_PGC = 2;
        public static final int BUSINESS_TYPE_PUGV = 3;
        public static final int BUSINESS_TYPE_UGC = 1;
        public static final Companion Companion = new Companion(null);
        private int businessType = 1;

        /* compiled from: IVideoPlayDirectorService.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/Video$ProjectionParams$Companion;", "", "<init>", "()V", "BUSINESS_TYPE_UGC", "", "BUSINESS_TYPE_PGC", "BUSINESS_TYPE_PUGV", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public final int getBusinessType() {
            return this.businessType;
        }

        public final void setBusinessType(int i) {
            this.businessType = i;
        }
    }

    /* compiled from: IVideoPlayDirectorService.kt */
    @Deprecated(message = "不应继续使用display params，业务上自行维护一些相关数据和字段")
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001c\u0010.\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\"\u00101\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR\u001c\u0010:\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR\u001c\u0010=\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\tR\u001c\u0010@\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0007\"\u0004\bB\u0010\tR\u001c\u0010C\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0007\"\u0004\bE\u0010\tR\u001c\u0010F\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0007\"\u0004\bH\u0010\tR\u001c\u0010I\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0007\"\u0004\bK\u0010\t¨\u0006L"}, d2 = {"Ltv/danmaku/biliplayerv2/service/Video$DisplayParams;", "", "<init>", "()V", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "getCover", "setCover", "author", "getAuthor", "setAuthor", RankRouter.BundleKey.AUTHOR_SPACE_MID, "", "getMid", "()J", "setMid", "(J)V", "from", "getFrom", "setFrom", "avid", "getAvid", "setAvid", "cid", "getCid", "setCid", "displayRotate", "", "getDisplayRotate", "()F", "setDisplayRotate", "(F)V", "displayOrientation", "Ltv/danmaku/biliplayerv2/DisplayOrientation;", "getDisplayOrientation", "()Ltv/danmaku/biliplayerv2/DisplayOrientation;", "setDisplayOrientation", "(Ltv/danmaku/biliplayerv2/DisplayOrientation;)V", "seekIconUrl1", "getSeekIconUrl1", "setSeekIconUrl1", "seekIconUrl2", "getSeekIconUrl2", "setSeekIconUrl2", "danmakuAssist", "", "getDanmakuAssist", "()Ljava/util/List;", "setDanmakuAssist", "(Ljava/util/List;)V", "dragLeftIcon", "getDragLeftIcon", "setDragLeftIcon", "middleIcon", "getMiddleIcon", "setMiddleIcon", "dragRightIcon", "getDragRightIcon", "setDragRightIcon", "dragSpriteImg", "getDragSpriteImg", "setDragSpriteImg", "dragSpriteMeta", "getDragSpriteMeta", "setDragSpriteMeta", "finishSpriteImg", "getFinishSpriteImg", "setFinishSpriteImg", "finishSpriteMeta", "getFinishSpriteMeta", "setFinishSpriteMeta", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DisplayParams {
        private long avid;
        private long cid;
        private List<Long> danmakuAssist;
        private float displayRotate;
        private String dragLeftIcon;
        private String dragRightIcon;
        private String dragSpriteImg;
        private String dragSpriteMeta;
        private String finishSpriteImg;
        private String finishSpriteMeta;
        private long mid;
        private String middleIcon;
        private String seekIconUrl1;
        private String seekIconUrl2;
        private String title = "";
        private String cover = "";
        private String author = "";
        private String from = "";
        private DisplayOrientation displayOrientation = DisplayOrientation.LANDSCAPE;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final String getCover() {
            return this.cover;
        }

        public final void setCover(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cover = str;
        }

        public final String getAuthor() {
            return this.author;
        }

        public final void setAuthor(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.author = str;
        }

        public final long getMid() {
            return this.mid;
        }

        public final void setMid(long j) {
            this.mid = j;
        }

        public final String getFrom() {
            return this.from;
        }

        public final void setFrom(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.from = str;
        }

        public final long getAvid() {
            return this.avid;
        }

        public final void setAvid(long j) {
            this.avid = j;
        }

        public final long getCid() {
            return this.cid;
        }

        public final void setCid(long j) {
            this.cid = j;
        }

        public final float getDisplayRotate() {
            return this.displayRotate;
        }

        public final void setDisplayRotate(float f) {
            this.displayRotate = f;
        }

        public final DisplayOrientation getDisplayOrientation() {
            return this.displayOrientation;
        }

        public final void setDisplayOrientation(DisplayOrientation displayOrientation) {
            Intrinsics.checkNotNullParameter(displayOrientation, "<set-?>");
            this.displayOrientation = displayOrientation;
        }

        public final String getSeekIconUrl1() {
            return this.seekIconUrl1;
        }

        public final void setSeekIconUrl1(String str) {
            this.seekIconUrl1 = str;
        }

        public final String getSeekIconUrl2() {
            return this.seekIconUrl2;
        }

        public final void setSeekIconUrl2(String str) {
            this.seekIconUrl2 = str;
        }

        public final List<Long> getDanmakuAssist() {
            return this.danmakuAssist;
        }

        public final void setDanmakuAssist(List<Long> list) {
            this.danmakuAssist = list;
        }

        public final String getDragLeftIcon() {
            return this.dragLeftIcon;
        }

        public final void setDragLeftIcon(String str) {
            this.dragLeftIcon = str;
        }

        public final String getMiddleIcon() {
            return this.middleIcon;
        }

        public final void setMiddleIcon(String str) {
            this.middleIcon = str;
        }

        public final String getDragRightIcon() {
            return this.dragRightIcon;
        }

        public final void setDragRightIcon(String str) {
            this.dragRightIcon = str;
        }

        public final String getDragSpriteImg() {
            return this.dragSpriteImg;
        }

        public final void setDragSpriteImg(String str) {
            this.dragSpriteImg = str;
        }

        public final String getDragSpriteMeta() {
            return this.dragSpriteMeta;
        }

        public final void setDragSpriteMeta(String str) {
            this.dragSpriteMeta = str;
        }

        public final String getFinishSpriteImg() {
            return this.finishSpriteImg;
        }

        public final void setFinishSpriteImg(String str) {
            this.finishSpriteImg = str;
        }

        public final String getFinishSpriteMeta() {
            return this.finishSpriteMeta;
        }

        public final void setFinishSpriteMeta(String str) {
            this.finishSpriteMeta = str;
        }
    }

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006 "}, d2 = {"Ltv/danmaku/biliplayerv2/service/Video$FeedbackParams;", "", "<init>", "()V", "aId", "", "getAId", "()J", "setAId", "(J)V", "cId", "getCId", "setCId", "seasonId", "getSeasonId", "setSeasonId", "isBangumi", "", "()Z", "setBangumi", "(Z)V", "isShowBangumiSkipHeadOption", "setShowBangumiSkipHeadOption", "spmid", "", "getSpmid", "()Ljava/lang/String;", "setSpmid", "(Ljava/lang/String;)V", "fromSpmid", "getFromSpmid", "setFromSpmid", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class FeedbackParams {
        private long aId;
        private long cId;
        private boolean isBangumi;
        private boolean isShowBangumiSkipHeadOption;
        private long seasonId;
        private String spmid = "";
        private String fromSpmid = "";

        public final long getAId() {
            return this.aId;
        }

        public final void setAId(long j) {
            this.aId = j;
        }

        public final long getCId() {
            return this.cId;
        }

        public final void setCId(long j) {
            this.cId = j;
        }

        public final long getSeasonId() {
            return this.seasonId;
        }

        public final void setSeasonId(long j) {
            this.seasonId = j;
        }

        public final boolean isBangumi() {
            return this.isBangumi;
        }

        public final void setBangumi(boolean z) {
            this.isBangumi = z;
        }

        public final boolean isShowBangumiSkipHeadOption() {
            return this.isShowBangumiSkipHeadOption;
        }

        public final void setShowBangumiSkipHeadOption(boolean z) {
            this.isShowBangumiSkipHeadOption = z;
        }

        public final String getSpmid() {
            return this.spmid;
        }

        public final void setSpmid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.spmid = str;
        }

        public final String getFromSpmid() {
            return this.fromSpmid;
        }

        public final void setFromSpmid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.fromSpmid = str;
        }
    }

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u000eHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0087\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\nHÖ\u0001J\t\u00108\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\"R\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010%R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00069"}, d2 = {"Ltv/danmaku/biliplayerv2/service/Video$DanmakuResolveParams;", "", "avid", "", "cid", "spmid", "", "epid", "seasonId", "page", "", "from", "link", "isRealTime", "", IjkMediaMeta.IJKM_KEY_LANGUAGE, "productionType", "extension", "<init>", "(JJLjava/lang/String;JJILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ILjava/lang/Object;)V", "getAvid", "()J", "getCid", "getSpmid", "()Ljava/lang/String;", "getEpid", "getSeasonId", "getPage", "()I", "getFrom", "getLink", "()Z", "getLanguage", "setLanguage", "(Ljava/lang/String;)V", "getProductionType", "setProductionType", "(I)V", "getExtension", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DanmakuResolveParams {
        private final long avid;
        private final long cid;
        private final long epid;
        private final Object extension;
        private final String from;
        private final boolean isRealTime;
        private String language;
        private final String link;
        private final int page;
        private int productionType;
        private final long seasonId;
        private final String spmid;

        public final long component1() {
            return this.avid;
        }

        public final String component10() {
            return this.language;
        }

        public final int component11() {
            return this.productionType;
        }

        public final Object component12() {
            return this.extension;
        }

        public final long component2() {
            return this.cid;
        }

        public final String component3() {
            return this.spmid;
        }

        public final long component4() {
            return this.epid;
        }

        public final long component5() {
            return this.seasonId;
        }

        public final int component6() {
            return this.page;
        }

        public final String component7() {
            return this.from;
        }

        public final String component8() {
            return this.link;
        }

        public final boolean component9() {
            return this.isRealTime;
        }

        public final DanmakuResolveParams copy(long j, long j2, String str, long j3, long j4, int i, String str2, String str3, boolean z, String str4, int i2, Object obj) {
            Intrinsics.checkNotNullParameter(str2, "from");
            Intrinsics.checkNotNullParameter(str3, "link");
            return new DanmakuResolveParams(j, j2, str, j3, j4, i, str2, str3, z, str4, i2, obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DanmakuResolveParams) {
                DanmakuResolveParams danmakuResolveParams = (DanmakuResolveParams) obj;
                return this.avid == danmakuResolveParams.avid && this.cid == danmakuResolveParams.cid && Intrinsics.areEqual(this.spmid, danmakuResolveParams.spmid) && this.epid == danmakuResolveParams.epid && this.seasonId == danmakuResolveParams.seasonId && this.page == danmakuResolveParams.page && Intrinsics.areEqual(this.from, danmakuResolveParams.from) && Intrinsics.areEqual(this.link, danmakuResolveParams.link) && this.isRealTime == danmakuResolveParams.isRealTime && Intrinsics.areEqual(this.language, danmakuResolveParams.language) && this.productionType == danmakuResolveParams.productionType && Intrinsics.areEqual(this.extension, danmakuResolveParams.extension);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.avid) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cid)) * 31) + (this.spmid == null ? 0 : this.spmid.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.epid)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.seasonId)) * 31) + this.page) * 31) + this.from.hashCode()) * 31) + this.link.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRealTime)) * 31) + (this.language == null ? 0 : this.language.hashCode())) * 31) + this.productionType) * 31) + (this.extension != null ? this.extension.hashCode() : 0);
        }

        public String toString() {
            long j = this.avid;
            long j2 = this.cid;
            String str = this.spmid;
            long j3 = this.epid;
            long j4 = this.seasonId;
            int i = this.page;
            String str2 = this.from;
            String str3 = this.link;
            boolean z = this.isRealTime;
            String str4 = this.language;
            int i2 = this.productionType;
            return "DanmakuResolveParams(avid=" + j + ", cid=" + j2 + ", spmid=" + str + ", epid=" + j3 + ", seasonId=" + j4 + ", page=" + i + ", from=" + str2 + ", link=" + str3 + ", isRealTime=" + z + ", language=" + str4 + ", productionType=" + i2 + ", extension=" + this.extension + ")";
        }

        public DanmakuResolveParams(long avid, long cid, String spmid, long epid, long seasonId, int page, String from, String link, boolean isRealTime, String language, int productionType, Object extension) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(link, "link");
            this.avid = avid;
            this.cid = cid;
            this.spmid = spmid;
            this.epid = epid;
            this.seasonId = seasonId;
            this.page = page;
            this.from = from;
            this.link = link;
            this.isRealTime = isRealTime;
            this.language = language;
            this.productionType = productionType;
            this.extension = extension;
        }

        public /* synthetic */ DanmakuResolveParams(long j, long j2, String str, long j3, long j4, int i, String str2, String str3, boolean z, String str4, int i2, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? 0L : j3, (i3 & 16) != 0 ? 0L : j4, (i3 & 32) != 0 ? 1 : i, (i3 & 64) != 0 ? "" : str2, (i3 & 128) != 0 ? "" : str3, (i3 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? false : z, (i3 & 512) != 0 ? null : str4, (i3 & 1024) != 0 ? 0 : i2, (i3 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? null : obj);
        }

        public final long getAvid() {
            return this.avid;
        }

        public final long getCid() {
            return this.cid;
        }

        public final String getSpmid() {
            return this.spmid;
        }

        public final long getEpid() {
            return this.epid;
        }

        public final long getSeasonId() {
            return this.seasonId;
        }

        public final int getPage() {
            return this.page;
        }

        public final String getFrom() {
            return this.from;
        }

        public final String getLink() {
            return this.link;
        }

        public final boolean isRealTime() {
            return this.isRealTime;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final void setLanguage(String str) {
            this.language = str;
        }

        public final int getProductionType() {
            return this.productionType;
        }

        public final void setProductionType(int i) {
            this.productionType = i;
        }

        public final Object getExtension() {
            return this.extension;
        }
    }

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u0019"}, d2 = {"Ltv/danmaku/biliplayerv2/service/Video$InteractParams;", "", "<init>", "()V", "avId", "", "getAvId", "()J", "setAvId", "(J)V", "historyNodeId", "getHistoryNodeId", "setHistoryNodeId", "historyCid", "getHistoryCid", "setHistoryCid", "rootCid", "getRootCid", "setRootCid", "rootNodeId", "getRootNodeId", "setRootNodeId", "version", "getVersion", "setVersion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class InteractParams {
        private long avId;
        private long historyCid;
        private long historyNodeId;
        private long rootCid;
        private long rootNodeId;
        private long version;

        public final long getAvId() {
            return this.avId;
        }

        public final void setAvId(long j) {
            this.avId = j;
        }

        public final long getHistoryNodeId() {
            return this.historyNodeId;
        }

        public final void setHistoryNodeId(long j) {
            this.historyNodeId = j;
        }

        public final long getHistoryCid() {
            return this.historyCid;
        }

        public final void setHistoryCid(long j) {
            this.historyCid = j;
        }

        public final long getRootCid() {
            return this.rootCid;
        }

        public final void setRootCid(long j) {
            this.rootCid = j;
        }

        public final long getRootNodeId() {
            return this.rootNodeId;
        }

        public final void setRootNodeId(long j) {
            this.rootNodeId = j;
        }

        public final long getVersion() {
            return this.version;
        }

        public final void setVersion(long j) {
            this.version = j;
        }
    }
}