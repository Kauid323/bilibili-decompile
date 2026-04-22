package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.bili.ui.offline.DownloadedPageActivity;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ViewProgressChange.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ViewProgressChange;", "", "<init>", "()V", "Request", "VideoGuide", "Attention", "CommandDM", "VideoPoint", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ViewProgressChange {

    /* compiled from: ViewProgressChange.kt */
    @RequestDefine(method = "OnViewProgressChanged")
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R2\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ViewProgressChange$Request;", "", "<init>", "()V", "workId", "", "getWorkId", "()Ljava/lang/String;", "setWorkId", "(Ljava/lang/String;)V", "videoId", "getVideoId", "setVideoId", "videoGuide", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ViewProgressChange$VideoGuide;", "getVideoGuide", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ViewProgressChange$VideoGuide;", "setVideoGuide", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ViewProgressChange$VideoGuide;)V", "videoPoints", "Ljava/util/ArrayList;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ViewProgressChange$VideoPoint;", "Lkotlin/collections/ArrayList;", "getVideoPoints", "()Ljava/util/ArrayList;", "setVideoPoints", "(Ljava/util/ArrayList;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "video_guide")
        private VideoGuide videoGuide;
        @JSONField(name = DownloadedPageActivity.KEY_VIDEO_ID)
        private String videoId;
        @JSONField(name = "video_points")
        private ArrayList<VideoPoint> videoPoints;
        @JSONField(name = "work_id")
        private String workId;

        public final String getWorkId() {
            return this.workId;
        }

        public final void setWorkId(String str) {
            this.workId = str;
        }

        public final String getVideoId() {
            return this.videoId;
        }

        public final void setVideoId(String str) {
            this.videoId = str;
        }

        public final VideoGuide getVideoGuide() {
            return this.videoGuide;
        }

        public final void setVideoGuide(VideoGuide videoGuide) {
            this.videoGuide = videoGuide;
        }

        public final ArrayList<VideoPoint> getVideoPoints() {
            return this.videoPoints;
        }

        public final void setVideoPoints(ArrayList<VideoPoint> arrayList) {
            this.videoPoints = arrayList;
        }
    }

    /* compiled from: ViewProgressChange.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ViewProgressChange$VideoGuide;", "", "<init>", "()V", "attentions", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ViewProgressChange$Attention;", "getAttentions", "()Ljava/util/List;", "setAttentions", "(Ljava/util/List;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VideoGuide {
        @JSONField(name = "attentions")
        private List<Attention> attentions;

        public final List<Attention> getAttentions() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.attentions);
        }

        public final void setAttentions(List<Attention> list) {
            this.attentions = list;
        }
    }

    /* compiled from: ViewProgressChange.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013¨\u0006\u0018"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ViewProgressChange$Attention;", "", "<init>", "()V", "startTime", "", "getStartTime", "()Ljava/lang/Integer;", "setStartTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "endTime", "getEndTime", "setEndTime", "posX", "", "getPosX", "()Ljava/lang/Double;", "setPosX", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "posY", "getPosY", "setPosY", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Attention {
        @JSONField(name = ChronosDanmakuSender.KEY_CMTIME_END)
        private Integer endTime;
        @JSONField(name = "pos_x")
        private Double posX;
        @JSONField(name = "pos_y")
        private Double posY;
        @JSONField(name = ChronosDanmakuSender.KEY_CMTIME_START)
        private Integer startTime;

        public final Integer getStartTime() {
            return this.startTime;
        }

        public final void setStartTime(Integer num) {
            this.startTime = num;
        }

        public final Integer getEndTime() {
            return this.endTime;
        }

        public final void setEndTime(Integer num) {
            this.endTime = num;
        }

        public final Double getPosX() {
            return this.posX;
        }

        public final void setPosX(Double d) {
            this.posX = d;
        }

        public final Double getPosY() {
            return this.posY;
        }

        public final void setPosY(Double d) {
            this.posY = d;
        }
    }

    /* compiled from: ViewProgressChange.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR \u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR \u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR \u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR \u0010'\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\t¨\u0006*"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ViewProgressChange$CommandDM;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "oid", "", "getOid", "()Ljava/lang/Long;", "setOid", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", RankRouter.BundleKey.AUTHOR_SPACE_MID, "getMid", "setMid", "command", "getCommand", "setCommand", "content", "getContent", "setContent", "progress", "", "getProgress", "()Ljava/lang/Integer;", "setProgress", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ctime", "getCtime", "setCtime", "mtime", "getMtime", "setMtime", "extra", "getExtra", "setExtra", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CommandDM {
        @JSONField(name = "command")
        private String command;
        @JSONField(name = "content")
        private String content;
        @JSONField(name = "ctime")
        private String ctime;
        @JSONField(name = "extra")
        private String extra;
        @JSONField(name = "id")
        private String id;
        @JSONField(name = RankRouter.BundleKey.AUTHOR_SPACE_MID)
        private Long mid;
        @JSONField(name = "mtime")
        private String mtime;
        @JSONField(name = "oid")
        private Long oid;
        @JSONField(name = "progress")
        private Integer progress;

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final Long getOid() {
            return this.oid;
        }

        public final void setOid(Long l) {
            this.oid = l;
        }

        public final Long getMid() {
            return this.mid;
        }

        public final void setMid(Long l) {
            this.mid = l;
        }

        public final String getCommand() {
            return this.command;
        }

        public final void setCommand(String str) {
            this.command = str;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final Integer getProgress() {
            return this.progress;
        }

        public final void setProgress(Integer num) {
            this.progress = num;
        }

        public final String getCtime() {
            return this.ctime;
        }

        public final void setCtime(String str) {
            this.ctime = str;
        }

        public final String getMtime() {
            return this.mtime;
        }

        public final void setMtime(String str) {
            this.mtime = str;
        }

        public final String getExtra() {
            return this.extra;
        }

        public final void setExtra(String str) {
            this.extra = str;
        }
    }

    /* compiled from: ViewProgressChange.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ViewProgressChange$VideoPoint;", "", "<init>", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "getCover", "setCover", "from", "", "getFrom", "()Ljava/lang/Long;", "setFrom", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "to", "getTo", "setTo", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VideoPoint {
        @JSONField(name = "content")
        private String content;
        @JSONField(name = RankRouter.BundleKey.VIDEO_DETAIL_COVER)
        private String cover;
        @JSONField(name = "from")
        private Long from;
        @JSONField(name = "to")
        private Long to;
        @JSONField(name = "type")
        private Integer type;

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final String getCover() {
            return this.cover;
        }

        public final void setCover(String str) {
            this.cover = str;
        }

        public final Long getFrom() {
            return this.from;
        }

        public final void setFrom(Long l) {
            this.from = l;
        }

        public final Long getTo() {
            return this.to;
        }

        public final void setTo(Long l) {
            this.to = l;
        }

        public final Integer getType() {
            return this.type;
        }

        public final void setType(Integer num) {
            this.type = num;
        }
    }
}