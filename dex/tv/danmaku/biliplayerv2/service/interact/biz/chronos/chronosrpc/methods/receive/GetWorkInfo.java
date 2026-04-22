package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import com.bilibili.common.chronoscommon.message.ResponseDefine;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.offline.DownloadedPageActivity;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.DefaultResponse;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* compiled from: GetWorkInfo.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetWorkInfo;", "", "<init>", "()V", "Request", "Response", "Attachment", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class GetWorkInfo {
    public static final String AD_PARAMS = "ad_params";
    public static final String AD_TRACK_ID = "ad_track_id";
    public static final String CM_CREATIVE_ID = "linked_creative_id";
    public static final String CM_LINKED_ID = "linked_id";
    public static final String CM_REQUEST_ID = "linked_request_id";
    public static final String CM_SOURCE_ID = "linked_source_id";
    public static final String CM_TRACK_ID = "linked_track_id";
    public static final Companion Companion = new Companion(null);
    public static final String NATURE_AD = "nature_ad";

    /* compiled from: GetWorkInfo.kt */
    @RequestDefine(method = "GetWorkInfo")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetWorkInfo$Request;", "", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
    }

    /* compiled from: GetWorkInfo.kt */
    @ResponseDefine
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR(\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR \u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R \u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR \u0010'\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR \u0010*\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR \u0010-\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR \u00100\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\"\u00103\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR\"\u00106\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR:\u0010D\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002070Ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000207`F8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR,\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR&\u0010Q\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010R8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006X"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetWorkInfo$Response;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/DefaultResponse;", "<init>", "()V", "workId", "", "getWorkId", "()Ljava/lang/String;", "setWorkId", "(Ljava/lang/String;)V", "workTitle", "getWorkTitle", "setWorkTitle", "videoList", "", "getVideoList", "()[Ljava/lang/String;", "setVideoList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "videoId", "getVideoId", "setVideoId", "videoTitle", "getVideoTitle", "setVideoTitle", "duration", "", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "upperId", "getUpperId", "setUpperId", "upperName", "getUpperName", "setUpperName", "upperAvatar", "getUpperAvatar", "setUpperAvatar", "sessionId", "getSessionId", "setSessionId", "epId", "getEpId", "setEpId", "seasonId", "getSeasonId", "setSeasonId", "seasonType", "getSeasonType", "setSeasonType", "hasPaymentToast", "", "getHasPaymentToast", "()Ljava/lang/Boolean;", "setHasPaymentToast", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "workState", "", "getWorkState", "()Ljava/lang/Integer;", "setWorkState", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "controlList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getControlList", "()Ljava/util/HashMap;", "setControlList", "(Ljava/util/HashMap;)V", "commercial", "", "getCommercial", "()Ljava/util/Map;", "setCommercial", "(Ljava/util/Map;)V", "attachment", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetWorkInfo$Attachment;", "getAttachment", "()Ljava/util/List;", "setAttachment", "(Ljava/util/List;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Response extends DefaultResponse {
        @JSONField(name = "attachment")
        private List<Attachment> attachment;
        @JSONField(name = "commercial")
        private Map<String, String> commercial;
        @JSONField(name = "control_list")
        private HashMap<String, Boolean> controlList = new HashMap<>();
        @JSONField(name = "duration")
        private Long duration;
        @JSONField(name = "ep_id")
        private String epId;
        @JSONField(name = "has_payment_toast")
        private Boolean hasPaymentToast;
        @JSONField(name = "season_id")
        private String seasonId;
        @JSONField(name = MediaItemParams.IJK_REPORT_KEY_SEASON_TYPE)
        private Long seasonType;
        @JSONField(name = "session_id")
        private String sessionId;
        @JSONField(name = "upper_avatar")
        private String upperAvatar;
        @JSONField(name = "upper_id")
        private String[] upperId;
        @JSONField(name = "upper_name")
        private String upperName;
        @JSONField(name = DownloadedPageActivity.KEY_VIDEO_ID)
        private String videoId;
        @JSONField(name = "video_list")
        private String[] videoList;
        @JSONField(name = DownloadedPageActivity.KEY_VIDEO_TITLE)
        private String videoTitle;
        @JSONField(name = "work_id")
        private String workId;
        @JSONField(name = "work_state")
        private Integer workState;
        @JSONField(name = "work_title")
        private String workTitle;

        public final String getWorkId() {
            return this.workId;
        }

        public final void setWorkId(String str) {
            this.workId = str;
        }

        public final String getWorkTitle() {
            return this.workTitle;
        }

        public final void setWorkTitle(String str) {
            this.workTitle = str;
        }

        public final String[] getVideoList() {
            return this.videoList;
        }

        public final void setVideoList(String[] strArr) {
            this.videoList = strArr;
        }

        public final String getVideoId() {
            return this.videoId;
        }

        public final void setVideoId(String str) {
            this.videoId = str;
        }

        public final String getVideoTitle() {
            return this.videoTitle;
        }

        public final void setVideoTitle(String str) {
            this.videoTitle = str;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }

        public final String[] getUpperId() {
            return this.upperId;
        }

        public final void setUpperId(String[] strArr) {
            this.upperId = strArr;
        }

        public final String getUpperName() {
            return this.upperName;
        }

        public final void setUpperName(String str) {
            this.upperName = str;
        }

        public final String getUpperAvatar() {
            return this.upperAvatar;
        }

        public final void setUpperAvatar(String str) {
            this.upperAvatar = str;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final void setSessionId(String str) {
            this.sessionId = str;
        }

        public final String getEpId() {
            return this.epId;
        }

        public final void setEpId(String str) {
            this.epId = str;
        }

        public final String getSeasonId() {
            return this.seasonId;
        }

        public final void setSeasonId(String str) {
            this.seasonId = str;
        }

        public final Long getSeasonType() {
            return this.seasonType;
        }

        public final void setSeasonType(Long l) {
            this.seasonType = l;
        }

        public final Boolean getHasPaymentToast() {
            return this.hasPaymentToast;
        }

        public final void setHasPaymentToast(Boolean bool) {
            this.hasPaymentToast = bool;
        }

        public final Integer getWorkState() {
            return this.workState;
        }

        public final void setWorkState(Integer num) {
            this.workState = num;
        }

        public final HashMap<String, Boolean> getControlList() {
            return this.controlList;
        }

        public final void setControlList(HashMap<String, Boolean> hashMap) {
            Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
            this.controlList = hashMap;
        }

        public final Map<String, String> getCommercial() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.commercial);
        }

        public final void setCommercial(Map<String, String> map) {
            this.commercial = map;
        }

        public final List<Attachment> getAttachment() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.attachment);
        }

        public final void setAttachment(List<Attachment> list) {
            this.attachment = list;
        }
    }

    /* compiled from: GetWorkInfo.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\u001c"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetWorkInfo$Attachment;", "", "<init>", "()V", "workId", "", "getWorkId", "()Ljava/lang/String;", "setWorkId", "(Ljava/lang/String;)V", "videoId", "getVideoId", "setVideoId", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "type", "", "getType", "()I", "setType", "(I)V", "index", "getIndex", "setIndex", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Attachment {
        @JSONField(name = "duration")
        private long duration;
        @JSONField(name = "index")
        private long index;
        @JSONField(name = "type")
        private int type;
        @JSONField(name = "work_id")
        private String workId = "";
        @JSONField(name = DownloadedPageActivity.KEY_VIDEO_ID)
        private String videoId = "";

        public final String getWorkId() {
            return this.workId;
        }

        public final void setWorkId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.workId = str;
        }

        public final String getVideoId() {
            return this.videoId;
        }

        public final void setVideoId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.videoId = str;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final void setDuration(long j) {
            this.duration = j;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i) {
            this.type = i;
        }

        public final long getIndex() {
            return this.index;
        }

        public final void setIndex(long j) {
            this.index = j;
        }
    }

    /* compiled from: GetWorkInfo.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetWorkInfo$Companion;", "", "<init>", "()V", "CM_LINKED_ID", "", "CM_CREATIVE_ID", "CM_REQUEST_ID", "CM_TRACK_ID", "CM_SOURCE_ID", "AD_PARAMS", "NATURE_AD", "AD_TRACK_ID", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}