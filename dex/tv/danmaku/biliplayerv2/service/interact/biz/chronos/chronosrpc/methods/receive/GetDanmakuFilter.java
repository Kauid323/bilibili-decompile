package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive;

import com.alibaba.fastjson.annotation.JSONField;
import com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig;
import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import com.bilibili.common.chronoscommon.message.ResponseDefine;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.offline.DownloadedPageActivity;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: GetDanmakuFilter.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuFilter;", "", "<init>", "()V", "Request", "Response", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class GetDanmakuFilter {

    /* compiled from: GetDanmakuFilter.kt */
    @RequestDefine(method = "GetDanmakuFilter")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuFilter$Request;", "", "<init>", "()V", "abKeys", "", "", "getAbKeys", "()[Ljava/lang/String;", "setAbKeys", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "configKeys", "getConfigKeys", "setConfigKeys", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "ab_keys")
        private String[] abKeys;
        @JSONField(name = "config_keys")
        private String[] configKeys;

        public final String[] getAbKeys() {
            return this.abKeys;
        }

        public final void setAbKeys(String[] strArr) {
            this.abKeys = strArr;
        }

        public final String[] getConfigKeys() {
            return this.configKeys;
        }

        public final void setConfigKeys(String[] strArr) {
            this.configKeys = strArr;
        }
    }

    /* compiled from: GetDanmakuFilter.kt */
    @ResponseDefine
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u001c\b\u0007\u0018\u0000 N2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0013\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R(\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0013\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R(\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0013\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R\"\u0010 \u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\"\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012R(\u0010&\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0013\u0012\u0004\b'\u0010\u0003\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012R(\u0010*\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u00101\u0012\u0004\b,\u0010\u0003\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R(\u00102\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107R(\u00109\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b:\u00105\"\u0004\b;\u00107R(\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b=\u00105\"\u0004\b>\u00107R\"\u0010?\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b@\u0010.\"\u0004\bA\u00100R\"\u0010B\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\bC\u0010\u0010\"\u0004\bD\u0010\u0012R\"\u0010E\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\bF\u0010\u0010\"\u0004\bG\u0010\u0012R\"\u0010H\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\bI\u0010\u0010\"\u0004\bJ\u0010\u0012R\"\u0010K\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\bL\u0010\u0010\"\u0004\bM\u0010\u0012¨\u0006O"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuFilter$Response;", "", "<init>", "()V", "workId", "", "getWorkId", "()Ljava/lang/String;", "setWorkId", "(Ljava/lang/String;)V", "videoId", "getVideoId", "setVideoId", "blockColor", "", "getBlockColor", "()Ljava/lang/Boolean;", "setBlockColor", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "blockTop", "getBlockTop$annotations", "getBlockTop", "setBlockTop", "blockBottom", "getBlockBottom$annotations", "getBlockBottom", "setBlockBottom", "blockScroll", "getBlockScroll$annotations", "getBlockScroll", "setBlockScroll", "blockSpecial", "getBlockSpecial", "setBlockSpecial", "blockRepeat", "getBlockRepeat", "setBlockRepeat", "blockEnable", "getBlockEnable$annotations", "getBlockEnable", "setBlockEnable", "aiLevel", "", "getAiLevel$annotations", "getAiLevel", "()Ljava/lang/Integer;", "setAiLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "userHashBlockList", "", "getUserHashBlockList", "()[Ljava/lang/String;", "setUserHashBlockList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "regexBlockList", "getRegexBlockList", "setRegexBlockList", "contentBlockList", "getContentBlockList", "setContentBlockList", "seniorMode", "getSeniorMode", "setSeniorMode", "blockFixed", "getBlockFixed", "setBlockFixed", "blockFold", "getBlockFold", "setBlockFold", "blockBottomArea", "getBlockBottomArea", "setBlockBottomArea", "blockMask", "getBlockMask", "setBlockMask", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Response {
        public static final Companion Companion = new Companion(null);
        @JSONField(name = "block_bottom")
        private Boolean blockBottom;
        @JSONField(name = "block_bottom_area")
        private Boolean blockBottomArea;
        @JSONField(name = "block_colorful")
        private Boolean blockColor;
        @JSONField(name = "blocker_enabled")
        private Boolean blockEnable;
        @JSONField(name = "block_fixed")
        private Boolean blockFixed;
        @JSONField(name = "block_fold")
        private Boolean blockFold;
        @JSONField(name = "block_mask")
        private Boolean blockMask;
        @JSONField(name = "block_repeat")
        private Boolean blockRepeat;
        @JSONField(name = "block_scroll")
        private Boolean blockScroll;
        @JSONField(name = "block_special")
        private Boolean blockSpecial;
        @JSONField(name = "block_top")
        private Boolean blockTop;
        @JSONField(name = "content_block_list")
        private String[] contentBlockList;
        @JSONField(name = "regex_block_list")
        private String[] regexBlockList;
        @JSONField(name = "user_hash_block_list")
        private String[] userHashBlockList;
        @JSONField(name = DownloadedPageActivity.KEY_VIDEO_ID)
        private String videoId;
        @JSONField(name = "work_id")
        private String workId;
        @JSONField(name = "ai_level")
        private Integer aiLevel = -1;
        @JSONField(name = "senior_mode")
        private Integer seniorMode = -1;

        @Deprecated(message = "removed in chronos")
        public static /* synthetic */ void getAiLevel$annotations() {
        }

        @Deprecated(message = "removed in chronos")
        public static /* synthetic */ void getBlockBottom$annotations() {
        }

        @Deprecated(message = "removed in chronos")
        public static /* synthetic */ void getBlockEnable$annotations() {
        }

        @Deprecated(message = "removed in chronos")
        public static /* synthetic */ void getBlockScroll$annotations() {
        }

        @Deprecated(message = "removed in chronos")
        public static /* synthetic */ void getBlockTop$annotations() {
        }

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

        public final Boolean getBlockColor() {
            return this.blockColor;
        }

        public final void setBlockColor(Boolean bool) {
            this.blockColor = bool;
        }

        public final Boolean getBlockTop() {
            return this.blockTop;
        }

        public final void setBlockTop(Boolean bool) {
            this.blockTop = bool;
        }

        public final Boolean getBlockBottom() {
            return this.blockBottom;
        }

        public final void setBlockBottom(Boolean bool) {
            this.blockBottom = bool;
        }

        public final Boolean getBlockScroll() {
            return this.blockScroll;
        }

        public final void setBlockScroll(Boolean bool) {
            this.blockScroll = bool;
        }

        public final Boolean getBlockSpecial() {
            return this.blockSpecial;
        }

        public final void setBlockSpecial(Boolean bool) {
            this.blockSpecial = bool;
        }

        public final Boolean getBlockRepeat() {
            return this.blockRepeat;
        }

        public final void setBlockRepeat(Boolean bool) {
            this.blockRepeat = bool;
        }

        public final Boolean getBlockEnable() {
            return this.blockEnable;
        }

        public final void setBlockEnable(Boolean bool) {
            this.blockEnable = bool;
        }

        public final Integer getAiLevel() {
            return this.aiLevel;
        }

        public final void setAiLevel(Integer num) {
            this.aiLevel = num;
        }

        public final String[] getUserHashBlockList() {
            return this.userHashBlockList;
        }

        public final void setUserHashBlockList(String[] strArr) {
            this.userHashBlockList = strArr;
        }

        public final String[] getRegexBlockList() {
            return this.regexBlockList;
        }

        public final void setRegexBlockList(String[] strArr) {
            this.regexBlockList = strArr;
        }

        public final String[] getContentBlockList() {
            return this.contentBlockList;
        }

        public final void setContentBlockList(String[] strArr) {
            this.contentBlockList = strArr;
        }

        public final Integer getSeniorMode() {
            return this.seniorMode;
        }

        public final void setSeniorMode(Integer num) {
            this.seniorMode = num;
        }

        public final Boolean getBlockFixed() {
            return this.blockFixed;
        }

        public final void setBlockFixed(Boolean bool) {
            this.blockFixed = bool;
        }

        public final Boolean getBlockFold() {
            return this.blockFold;
        }

        public final void setBlockFold(Boolean bool) {
            this.blockFold = bool;
        }

        public final Boolean getBlockBottomArea() {
            return this.blockBottomArea;
        }

        public final void setBlockBottomArea(Boolean bool) {
            this.blockBottomArea = bool;
        }

        public final Boolean getBlockMask() {
            return this.blockMask;
        }

        public final void setBlockMask(Boolean bool) {
            this.blockMask = bool;
        }

        /* compiled from: GetDanmakuFilter.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuFilter$Response$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuFilter$Response;", "danmakuParams", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "displayParams", "Ltv/danmaku/biliplayerv2/service/Video$DisplayParams;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Response create(DanmakuParams danmakuParams, Video.DisplayParams displayParams) {
                int i;
                int i2;
                DmViewReply dmViewReply;
                Response result = new Response();
                result.setWorkId(displayParams != null ? String.valueOf(displayParams.getAvid()) : null);
                result.setVideoId(displayParams != null ? String.valueOf(displayParams.getCid()) : null);
                result.setBlockColor(danmakuParams != null ? Boolean.valueOf(danmakuParams.isDanmakuBlockColorful()) : null);
                result.setBlockTop(danmakuParams != null ? Boolean.valueOf(danmakuParams.isDanmakuBlockTop()) : null);
                result.setBlockBottom(danmakuParams != null ? Boolean.valueOf(danmakuParams.isDanmakuBlockBottom()) : null);
                result.setBlockScroll(danmakuParams != null ? Boolean.valueOf(danmakuParams.isDanmakuBlockScroll()) : null);
                BLog.d("danmaku filter sync", "block scroll from chronos request=" + result.getBlockScroll());
                result.setBlockSpecial(danmakuParams != null ? Boolean.valueOf(danmakuParams.isDanmakuBlockSpecial()) : null);
                result.setBlockRepeat(danmakuParams != null ? Boolean.valueOf(danmakuParams.isDanmakuDuplicateMerging()) : null);
                if (danmakuParams != null && danmakuParams.isDanmakuRecommandEnable()) {
                    i = Integer.valueOf(danmakuParams.getDanmakuBlockLevel());
                } else {
                    i = -1;
                }
                result.setAiLevel(i);
                DanmuPlayerViewConfig config = (danmakuParams == null || (dmViewReply = danmakuParams.getDmViewReply()) == null) ? null : dmViewReply.getPlayerConfig();
                if (config != null && config.hasDanmukuPlayerConfig()) {
                    i2 = Integer.valueOf(config.getDanmukuPlayerConfig().getPlayerDanmakuSeniorModeSwitch());
                } else {
                    i2 = 0;
                }
                result.setSeniorMode(i2);
                result.setBlockFixed(danmakuParams != null ? Boolean.valueOf(danmakuParams.getDanmakuBlockFixed()) : null);
                result.setBlockFold(danmakuParams != null ? Boolean.valueOf(!danmakuParams.getEnableDanmakuFold()) : null);
                result.setBlockBottomArea(danmakuParams != null ? Boolean.valueOf(danmakuParams.getDanmakuAvoidScript()) : null);
                result.setBlockMask(danmakuParams != null ? Boolean.valueOf(!danmakuParams.getDanmakuAvoidFigure()) : null);
                return result;
            }
        }
    }
}