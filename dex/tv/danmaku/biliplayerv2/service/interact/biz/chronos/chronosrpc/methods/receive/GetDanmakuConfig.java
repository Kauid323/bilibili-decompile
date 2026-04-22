package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive;

import android.content.Context;
import android.graphics.Rect;
import com.alibaba.fastjson.annotation.JSONField;
import com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig;
import com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig;
import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import com.bapis.bilibili.community.service.dm.v1.SubtitleItem;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import com.bilibili.common.chronoscommon.message.ResponseDefine;
import com.bilibili.lib.accounts.BiliAccounts;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.bili.ui.offline.DownloadedPageActivity;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.utils.PlayerCloudConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: GetDanmakuConfig.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig;", "", "<init>", "()V", "Request", "Response", "VisibleRect", "SubtitleConfig", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class GetDanmakuConfig {

    /* compiled from: GetDanmakuConfig.kt */
    @RequestDefine(method = "GetDanmakuConfig")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$Request;", "", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
    }

    /* compiled from: GetDanmakuConfig.kt */
    @ResponseDefine
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R(\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R(\u0010%\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\"\u0010)\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b*\u0010\u001e\"\u0004\b+\u0010 R\"\u0010,\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R \u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R \u00105\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010;\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b<\u0010\u0003\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\"\u0010?\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006G"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$Response;", "", "<init>", "()V", "workId", "", "getWorkId", "()Ljava/lang/String;", "setWorkId", "(Ljava/lang/String;)V", "videoId", "getVideoId", "setVideoId", "transparency", "", "getTransparency", "()Ljava/lang/Float;", "setTransparency", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "scale", "getScale", "setScale", "screenOccupancy", "getScreenOccupancy", "setScreenOccupancy", "overlap", "", "getOverlap$annotations", "getOverlap", "()Ljava/lang/Boolean;", "setOverlap", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "duration", "getDuration", "setDuration", "maskEnabled", "getMaskEnabled$annotations", "getMaskEnabled", "setMaskEnabled", "commonDanmakuInteraction", "getCommonDanmakuInteraction", "setCommonDanmakuInteraction", "commonDanmakuMonospaced", "getCommonDanmakuMonospaced", "setCommonDanmakuMonospaced", "visibleRect", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$VisibleRect;", "getVisibleRect", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$VisibleRect;", "setVisibleRect", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$VisibleRect;)V", "subtitleConfig", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$SubtitleConfig;", "getSubtitleConfig", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$SubtitleConfig;", "setSubtitleConfig", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$SubtitleConfig;)V", "foldDanmakuEnabled", "getFoldDanmakuEnabled$annotations", "getFoldDanmakuEnabled", "setFoldDanmakuEnabled", "density", "", "getDensity", "()Ljava/lang/Integer;", "setDensity", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Response {
        public static final Companion Companion = new Companion(null);
        @JSONField(name = "common_danmaku_interaction")
        private Boolean commonDanmakuInteraction;
        @JSONField(name = "common_danmaku_monospaced")
        private Boolean commonDanmakuMonospaced;
        @JSONField(name = "density_mode")
        private Integer density;
        @JSONField(name = "duration")
        private Float duration;
        @JSONField(name = "fold_danmaku_enabled")
        private Boolean foldDanmakuEnabled;
        @JSONField(name = "mask_enabled")
        private Boolean maskEnabled;
        @JSONField(name = "overlap")
        private Boolean overlap;
        @JSONField(name = "scale")
        private Float scale;
        @JSONField(name = "screen_occupancy")
        private Float screenOccupancy;
        @JSONField(name = "subtitle_config")
        private SubtitleConfig subtitleConfig;
        @JSONField(name = "transparency")
        private Float transparency;
        @JSONField(name = DownloadedPageActivity.KEY_VIDEO_ID)
        private String videoId;
        @JSONField(name = "visible_rect")
        private VisibleRect visibleRect;
        @JSONField(name = "work_id")
        private String workId;

        @Deprecated(message = "use DanmakuFilterChange.Request.blockFold instead")
        public static /* synthetic */ void getFoldDanmakuEnabled$annotations() {
        }

        @Deprecated(message = "use DanmakuFilterChange.Request.blockMask instead")
        public static /* synthetic */ void getMaskEnabled$annotations() {
        }

        @Deprecated(message = "use DanmakuConfigChange.Request.density instead")
        public static /* synthetic */ void getOverlap$annotations() {
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

        public final Float getTransparency() {
            return this.transparency;
        }

        public final void setTransparency(Float f) {
            this.transparency = f;
        }

        public final Float getScale() {
            return this.scale;
        }

        public final void setScale(Float f) {
            this.scale = f;
        }

        public final Float getScreenOccupancy() {
            return this.screenOccupancy;
        }

        public final void setScreenOccupancy(Float f) {
            this.screenOccupancy = f;
        }

        public final Boolean getOverlap() {
            return this.overlap;
        }

        public final void setOverlap(Boolean bool) {
            this.overlap = bool;
        }

        public final Float getDuration() {
            return this.duration;
        }

        public final void setDuration(Float f) {
            this.duration = f;
        }

        public final Boolean getMaskEnabled() {
            return this.maskEnabled;
        }

        public final void setMaskEnabled(Boolean bool) {
            this.maskEnabled = bool;
        }

        public final Boolean getCommonDanmakuInteraction() {
            return this.commonDanmakuInteraction;
        }

        public final void setCommonDanmakuInteraction(Boolean bool) {
            this.commonDanmakuInteraction = bool;
        }

        public final Boolean getCommonDanmakuMonospaced() {
            return this.commonDanmakuMonospaced;
        }

        public final void setCommonDanmakuMonospaced(Boolean bool) {
            this.commonDanmakuMonospaced = bool;
        }

        public final VisibleRect getVisibleRect() {
            return this.visibleRect;
        }

        public final void setVisibleRect(VisibleRect visibleRect) {
            this.visibleRect = visibleRect;
        }

        public final SubtitleConfig getSubtitleConfig() {
            return this.subtitleConfig;
        }

        public final void setSubtitleConfig(SubtitleConfig subtitleConfig) {
            this.subtitleConfig = subtitleConfig;
        }

        public final Boolean getFoldDanmakuEnabled() {
            return this.foldDanmakuEnabled;
        }

        public final void setFoldDanmakuEnabled(Boolean bool) {
            this.foldDanmakuEnabled = bool;
        }

        public final Integer getDensity() {
            return this.density;
        }

        public final void setDensity(Integer num) {
            this.density = num;
        }

        /* compiled from: GetDanmakuConfig.kt */
        @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0089\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$Response$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$Response;", "context", "Landroid/content/Context;", "danmakuParams", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "displayParams", "Ltv/danmaku/biliplayerv2/service/Video$DisplayParams;", "mainSubtitle", "Lcom/bapis/bilibili/community/service/dm/v1/SubtitleItem;", "maskEnable", "", "cloudConfig", "Ltv/danmaku/biliplayerv2/utils/PlayerCloudConfig;", "renderBounds", "Landroid/graphics/Rect;", "displayDensity", "", "subtitleBottomMargin", "visibleRectX", "visibleRectY", "viceSubtitle", "draggable", "fontMode", "", "(Landroid/content/Context;Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;Ltv/danmaku/biliplayerv2/service/Video$DisplayParams;Lcom/bapis/bilibili/community/service/dm/v1/SubtitleItem;ZLtv/danmaku/biliplayerv2/utils/PlayerCloudConfig;Landroid/graphics/Rect;FFFFLcom/bapis/bilibili/community/service/dm/v1/SubtitleItem;ZLjava/lang/Integer;)Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$Response;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Response create(Context context, DanmakuParams danmakuParams, Video.DisplayParams displayParams, SubtitleItem mainSubtitle, boolean maskEnable, PlayerCloudConfig cloudConfig, Rect renderBounds, float displayDensity, float subtitleBottomMargin, float visibleRectX, float visibleRectY, SubtitleItem viceSubtitle, boolean draggable, Integer fontMode) {
                String lan;
                DmViewReply dmViewReply;
                DanmuPlayerViewConfig playerConfig;
                DanmuPlayerConfig danmukuPlayerConfig;
                Intrinsics.checkNotNullParameter(context, "context");
                Response result = new Response();
                SubtitleConfig subtitleConfig = new SubtitleConfig();
                VisibleRect visibleRect = new VisibleRect();
                boolean isLogin = BiliAccounts.get(context).isLogin();
                boolean enableFeedbackSubtitle = cloudConfig != null && cloudConfig.enableFeedbackSubtitle();
                result.setWorkId(displayParams != null ? String.valueOf(displayParams.getAvid()) : null);
                result.setVideoId(displayParams != null ? String.valueOf(displayParams.getCid()) : null);
                result.setTransparency(danmakuParams != null ? Float.valueOf(danmakuParams.getDanmakuAlphaFactor()) : null);
                result.setScale(danmakuParams != null ? Float.valueOf(danmakuParams.getDanmakuTextSizeScaleFactor()) : null);
                result.setScreenOccupancy(danmakuParams != null ? Float.valueOf(RangesKt.coerceAtMost(danmakuParams.getDanmakuDisplayDomain(), 1.0f)) : null);
                result.setOverlap(Boolean.valueOf(Intrinsics.areEqual(danmakuParams != null ? Float.valueOf(danmakuParams.getDanmakuScreenDomain()) : null, 2.0f)));
                result.setDuration(danmakuParams != null ? Float.valueOf(danmakuParams.getDanmakuDuration() * ((float) IjkMediaCodecInfo.RANK_MAX)) : null);
                result.setMaskEnabled(Boolean.valueOf(maskEnable));
                result.setFoldDanmakuEnabled((danmakuParams == null || (dmViewReply = danmakuParams.getDmViewReply()) == null || (playerConfig = dmViewReply.getPlayerConfig()) == null || (danmukuPlayerConfig = playerConfig.getDanmukuPlayerConfig()) == null) ? null : Boolean.valueOf(danmukuPlayerConfig.getPlayerDanmakuEnableHerdDm()));
                subtitleConfig.setBottomMargin(Float.valueOf(subtitleBottomMargin));
                String str = "NULL";
                subtitleConfig.setLanguage((mainSubtitle == null || (r12 = mainSubtitle.getLan()) == null) ? "NULL" : "NULL");
                if (viceSubtitle != null && (lan = viceSubtitle.getLan()) != null) {
                    str = lan;
                }
                subtitleConfig.setSecondaryLanguage(str);
                subtitleConfig.setEnableEdit(Boolean.valueOf(enableFeedbackSubtitle && isLogin));
                subtitleConfig.setDraggable(Boolean.valueOf(draggable));
                subtitleConfig.setFontMode(fontMode);
                result.setSubtitleConfig(subtitleConfig);
                result.setCommonDanmakuInteraction(cloudConfig != null ? Boolean.valueOf(cloudConfig.enableDanmakuInteraction()) : null);
                result.setCommonDanmakuMonospaced(cloudConfig != null ? Boolean.valueOf(cloudConfig.enableDanmakuMonospaced()) : null);
                if (renderBounds != null) {
                    if (!(displayDensity == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN)) {
                        visibleRect.setOrigin(new float[]{visibleRectX + DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN + visibleRectY});
                        visibleRect.setSize(new int[]{((int) (renderBounds.width() / displayDensity)) - ((int) visibleRectX), ((int) (renderBounds.height() / displayDensity)) - ((int) visibleRectY)});
                    }
                }
                result.setVisibleRect(visibleRect);
                result.setDensity(danmakuParams != null ? Integer.valueOf(danmakuParams.getDanmakuDensity()) : null);
                return result;
            }
        }
    }

    /* compiled from: GetDanmakuConfig.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$VisibleRect;", "", "<init>", "()V", "origin", "", "getOrigin", "()[F", "setOrigin", "([F)V", "size", "", "getSize", "()[I", "setSize", "([I)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VisibleRect {
        @JSONField(name = "origin")
        private float[] origin;
        @JSONField(name = "size")
        private int[] size;

        public final float[] getOrigin() {
            return this.origin;
        }

        public final void setOrigin(float[] fArr) {
            this.origin = fArr;
        }

        public final int[] getSize() {
            return this.size;
        }

        public final void setSize(int[] iArr) {
            this.size = iArr;
        }
    }

    /* compiled from: GetDanmakuConfig.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\"\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetDanmakuConfig$SubtitleConfig;", "", "<init>", "()V", "bottomMargin", "", "getBottomMargin", "()Ljava/lang/Float;", "setBottomMargin", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", IjkMediaMeta.IJKM_KEY_LANGUAGE, "", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "enableEdit", "", "getEnableEdit", "()Ljava/lang/Boolean;", "setEnableEdit", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "secondaryLanguage", "getSecondaryLanguage", "setSecondaryLanguage", "draggable", "getDraggable", "setDraggable", "fontMode", "", "getFontMode", "()Ljava/lang/Integer;", "setFontMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SubtitleConfig {
        @JSONField(name = "bottom_margin")
        private Float bottomMargin;
        @JSONField(name = "draggable")
        private Boolean draggable;
        @JSONField(name = "enable_edit")
        private Boolean enableEdit;
        @JSONField(name = "font_mode")
        private Integer fontMode;
        @JSONField(name = IjkMediaMeta.IJKM_KEY_LANGUAGE)
        private String language;
        @JSONField(name = "secondary_language")
        private String secondaryLanguage;

        public final Float getBottomMargin() {
            return this.bottomMargin;
        }

        public final void setBottomMargin(Float f) {
            this.bottomMargin = f;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final void setLanguage(String str) {
            this.language = str;
        }

        public final Boolean getEnableEdit() {
            return this.enableEdit;
        }

        public final void setEnableEdit(Boolean bool) {
            this.enableEdit = bool;
        }

        public final String getSecondaryLanguage() {
            return this.secondaryLanguage;
        }

        public final void setSecondaryLanguage(String str) {
            this.secondaryLanguage = str;
        }

        public final Boolean getDraggable() {
            return this.draggable;
        }

        public final void setDraggable(Boolean bool) {
            this.draggable = bool;
        }

        public final Integer getFontMode() {
            return this.fontMode;
        }

        public final void setFontMode(Integer num) {
            this.fontMode = num;
        }
    }
}