package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: DanmakuConfigChange.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange;", "", "<init>", "()V", "Request", "VisibleRect", "SubtitleConfig", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuConfigChange {

    /* compiled from: DanmakuConfigChange.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0018\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR(\u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0018\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\"\u0010 \u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\"\u0010#\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R \u0010&\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010,\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00102\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0018\u0012\u0004\b3\u0010\u0003\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017R\"\u00106\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006>"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$Request;", "", "<init>", "()V", "transparency", "", "getTransparency", "()Ljava/lang/Float;", "setTransparency", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "scale", "getScale", "setScale", "screenOccupancy", "getScreenOccupancy", "setScreenOccupancy", "overlap", "", "getOverlap$annotations", "getOverlap", "()Ljava/lang/Boolean;", "setOverlap", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "duration", "getDuration", "setDuration", "maskEnabled", "getMaskEnabled$annotations", "getMaskEnabled", "setMaskEnabled", "commonDanmakuInteraction", "getCommonDanmakuInteraction", "setCommonDanmakuInteraction", "commonDanmakuMonospaced", "getCommonDanmakuMonospaced", "setCommonDanmakuMonospaced", "visibleRect", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$VisibleRect;", "getVisibleRect", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$VisibleRect;", "setVisibleRect", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$VisibleRect;)V", "subtitleConfig", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$SubtitleConfig;", "getSubtitleConfig", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$SubtitleConfig;", "setSubtitleConfig", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$SubtitleConfig;)V", "foldDanmakuEnabled", "getFoldDanmakuEnabled$annotations", "getFoldDanmakuEnabled", "setFoldDanmakuEnabled", "density", "", "getDensity", "()Ljava/lang/Integer;", "setDensity", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @RequestDefine(method = "OnDanmakuConfigChanged")
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        public static final Companion Companion = new Companion(null);
        public static final String TAG = "DanmakuConfigChange.Request";
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
        @JSONField(name = "visible_rect")
        private VisibleRect visibleRect;

        @Deprecated(message = "use DanmakuFilterChange.Request.blockFold instead")
        public static /* synthetic */ void getFoldDanmakuEnabled$annotations() {
        }

        @Deprecated(message = "use DanmakuFilterChange.Request.blockMask instead")
        public static /* synthetic */ void getMaskEnabled$annotations() {
        }

        @Deprecated(message = "use DanmakuConfigChange.Request.density instead")
        public static /* synthetic */ void getOverlap$annotations() {
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

        /* compiled from: DanmakuConfigChange.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$Request$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$Request;", "key", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuConfig$DanmakuOptionName;", "params", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {

            /* compiled from: DanmakuConfigChange.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[DanmakuConfig.DanmakuOptionName.values().length];
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.TRANSPARENCY.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.TEXTSIZE_SCALE.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.SCREEN_DOMAIN.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.SCROLL_DURATION_FACTOR.ordinal()] = 4;
                    } catch (NoSuchFieldError e4) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.DISPLAY_DOMAIN.ordinal()] = 5;
                    } catch (NoSuchFieldError e5) {
                    }
                    try {
                        iArr[DanmakuConfig.DanmakuOptionName.DENSITY.ordinal()] = 6;
                    } catch (NoSuchFieldError e6) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Request create(DanmakuConfig.DanmakuOptionName key, DanmakuParams params) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(params, "params");
                Request req = new Request();
                boolean findConfig = true;
                switch (WhenMappings.$EnumSwitchMapping$0[key.ordinal()]) {
                    case 1:
                        req.setTransparency(Float.valueOf(params.getDanmakuAlphaFactor()));
                        break;
                    case 2:
                        req.setScale(Float.valueOf(params.getDanmakuTextSizeScaleFactor()));
                        break;
                    case 3:
                        req.setScreenOccupancy(Float.valueOf(Math.min(params.getDanmakuScreenDomain(), 1.0f)));
                        req.setOverlap(Boolean.valueOf(params.getDanmakuScreenDomain() == 2.0f));
                        break;
                    case 4:
                        req.setDuration(Float.valueOf(params.getDanmakuDuration() * ((float) IjkMediaCodecInfo.RANK_MAX)));
                        break;
                    case 5:
                        req.setScreenOccupancy(Float.valueOf(params.getDanmakuDisplayDomain()));
                        BLog.d(Request.TAG, "screenOccupancy: " + req.getScreenOccupancy());
                        break;
                    case 6:
                        req.setDensity(Integer.valueOf(params.getDanmakuDensity()));
                        BLog.d(Request.TAG, "density: " + req.getDensity());
                        break;
                    default:
                        findConfig = false;
                        break;
                }
                if (findConfig) {
                    return req;
                }
                return null;
            }

            public final Request create(DanmakuParams params) {
                Intrinsics.checkNotNullParameter(params, "params");
                Request req = new Request();
                req.setTransparency(Float.valueOf(params.getDanmakuAlphaFactor()));
                req.setScale(Float.valueOf(params.getDanmakuTextSizeScaleFactor()));
                req.setScreenOccupancy(Float.valueOf(Math.min(params.getDanmakuScreenDomain(), 1.0f)));
                req.setOverlap(Boolean.valueOf(params.getDanmakuScreenDomain() == 2.0f));
                req.setDuration(Float.valueOf(params.getDanmakuDuration() * ((float) IjkMediaCodecInfo.RANK_MAX)));
                return req;
            }
        }
    }

    /* compiled from: DanmakuConfigChange.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$VisibleRect;", "", "<init>", "()V", "origin", "", "getOrigin", "()[F", "setOrigin", "([F)V", "size", "", "getSize", "()[I", "setSize", "([I)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
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

    /* compiled from: DanmakuConfigChange.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR \u0010\u001b\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR\"\u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006("}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$SubtitleConfig;", "", "<init>", "()V", "fixedBottomMargin", "", "getFixedBottomMargin", "()Ljava/lang/Boolean;", "setFixedBottomMargin", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "bottomMargin", "", "getBottomMargin", "()Ljava/lang/Float;", "setBottomMargin", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", IjkMediaMeta.IJKM_KEY_LANGUAGE, "", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "enableEdit", "getEnableEdit", "setEnableEdit", "secondaryLanguage", "getSecondaryLanguage", "setSecondaryLanguage", "draggable", "getDraggable", "setDraggable", "fontMode", "", "getFontMode", "()Ljava/lang/Integer;", "setFontMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SubtitleConfig {
        @JSONField(name = "bottom_margin")
        private Float bottomMargin;
        @JSONField(name = "draggable")
        private Boolean draggable;
        @JSONField(name = "enable_edit")
        private Boolean enableEdit;
        @JSONField(name = "fixed_bottom_margin")
        private Boolean fixedBottomMargin;
        @JSONField(name = "font_mode")
        private Integer fontMode;
        @JSONField(name = IjkMediaMeta.IJKM_KEY_LANGUAGE)
        private String language;
        @JSONField(name = "secondary_language")
        private String secondaryLanguage;

        public final Boolean getFixedBottomMargin() {
            return this.fixedBottomMargin;
        }

        public final void setFixedBottomMargin(Boolean bool) {
            this.fixedBottomMargin = bool;
        }

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