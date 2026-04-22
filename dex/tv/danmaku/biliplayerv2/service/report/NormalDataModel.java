package tv.danmaku.biliplayerv2.service.report;

import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.media.resource.PlayerCodecConfig;
import com.bilibili.lib.tf.TfTypeExt;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.service.report.VideoFormat;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: NormalDataModel.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\bG\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010i\u001a\u00020j2\b\u0010@\u001a\u0004\u0018\u00010k2\b\u0010H\u001a\u0004\u0018\u00010l¢\u0006\u0002\u0010mJo\u0010n\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010o\u001a\u00020l2\b\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020\u00152\u0006\u00108\u001a\u00020s2\b\u0010t\u001a\u0004\u0018\u00010\u00152\u0006\u0010u\u001a\u00020l2\u0006\u0010v\u001a\u00020\u00152\u0006\u0010w\u001a\u00020l2\u0006\u0010P\u001a\u00020x2\u0006\u0010S\u001a\u00020\t¢\u0006\u0002\u0010yJ\u0010\u0010z\u001a\u00020\u00152\u0006\u0010{\u001a\u00020\u0015H\u0002J\u0017\u00103\u001a\u00020\u00152\b\u0010|\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010}J\u0012\u00106\u001a\u00020\u00152\b\u0010~\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010A\u001a\u00020\u00152\b\u0010@\u001a\u0004\u0018\u00010kH\u0002J\u0010\u0010\u007f\u001a\u00020\t2\u0006\u0010v\u001a\u00020\u0015H\u0002J\"\u0010Q\u001a\u00020\t2\u0006\u0010P\u001a\u00020x2\u0006\u0010C\u001a\u00020l2\b\u0010p\u001a\u0004\u0018\u00010qH\u0002R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\u001a\u0010 \u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\rR\u001a\u0010#\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\rR\u001a\u0010&\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010\rR\u001a\u0010)\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001a\u0010,\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001a\u0010/\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u001a\u00102\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\u001a\u00105\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R\u001a\u00108\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010\rR\u001a\u0010;\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000b\"\u0004\b=\u0010\rR\u001a\u0010>\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0017\"\u0004\b?\u0010\u0019R\u001a\u0010@\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0017\"\u0004\bB\u0010\u0019R\u001a\u0010C\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u000b\"\u0004\bD\u0010\rR\u001a\u0010E\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u000b\"\u0004\bG\u0010\rR\u001a\u0010H\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000b\"\u0004\bI\u0010\rR\u001a\u0010J\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u000b\"\u0004\bL\u0010\rR\u001a\u0010M\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u000b\"\u0004\bO\u0010\rR\u001a\u0010P\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u000b\"\u0004\bR\u0010\rR\u001a\u0010S\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u000b\"\u0004\bU\u0010\rR\u001a\u0010V\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u000b\"\u0004\bX\u0010\rR\u001a\u0010Y\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u000b\"\u0004\b[\u0010\rR\"\u0010\\\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR(\u0010c\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010h¨\u0006\u0080\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/NormalDataModel;", "", "commonField", "Ltv/danmaku/biliplayerv2/service/report/PlayerReportCommonField;", "playerConfig", "Lcom/bilibili/lib/media/resource/PlayerCodecConfig;", "<init>", "(Ltv/danmaku/biliplayerv2/service/report/PlayerReportCommonField;Lcom/bilibili/lib/media/resource/PlayerCodecConfig;)V", "fromSpmid", "", "getFromSpmid", "()Ljava/lang/String;", "setFromSpmid", "(Ljava/lang/String;)V", "spmid", "getSpmid", "setSpmid", "seasonId", "getSeasonId", "setSeasonId", "type", "", "getType", "()I", "setType", "(I)V", "subType", "getSubType", "setSubType", "epId", "getEpId", "setEpId", "progress", "getProgress", "setProgress", "avid", "getAvid", "setAvid", "cid", "getCid", "setCid", "networkType", "getNetworkType", "setNetworkType", "danmaku", "getDanmaku", "setDanmaku", "status", "getStatus", "setStatus", "playMethod", "getPlayMethod", "setPlayMethod", "playType", "getPlayType", "setPlayType", "speed", "getSpeed", "setSpeed", "playerClarity", "getPlayerClarity", "setPlayerClarity", "isAutoplay", "setAutoplay", "videoFormat", "getVideoFormat", "setVideoFormat", "isVertical", "setVertical", "playerState", "getPlayerState", "setPlayerState", "isLocalVideo", "setLocalVideo", "dmServiceSwitch", "getDmServiceSwitch", "setDmServiceSwitch", "trackId", "getTrackId", "setTrackId", LoginSceneProcessor.SCENE_KEY, "getScene", "setScene", IjkMediaMeta.IJKM_KEY_LANGUAGE, "getLanguage", "setLanguage", "playStateHb", "getPlayStateHb", "setPlayStateHb", "sceneHb", "getSceneHb", "setSceneHb", "progressStrategy", "Lkotlin/Function0;", "", "getProgressStrategy", "()Lkotlin/jvm/functions/Function0;", "setProgressStrategy", "(Lkotlin/jvm/functions/Function0;)V", "extraParams", "", "getExtraParams", "()Ljava/util/Map;", "setExtraParams", "(Ljava/util/Map;)V", "updateVideoInfo", "", "Ltv/danmaku/biliplayerv2/service/report/VideoFormat;", "", "(Ltv/danmaku/biliplayerv2/service/report/VideoFormat;Ljava/lang/Boolean;)V", "refreshPlayableData", "isDanmakuShow", "screenType", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "playMode", "", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "isAutoPlay", "playState", "isDanmakuClosed", "Ltv/danmaku/biliplayerv2/service/report/PlayScene;", "(Ljava/lang/String;IZLtv/danmaku/biliplayerv2/ScreenModeType;IFLjava/lang/Integer;ZIZLtv/danmaku/biliplayerv2/service/report/PlayScene;Ljava/lang/String;)Ltv/danmaku/biliplayerv2/service/report/NormalDataModel;", "generateNetworkType", "networkState", "playerCompleteAction", "(Ljava/lang/Integer;)I", "config", "getPlaybackStatus", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NormalDataModel {
    private String avid;
    private String cid;
    private int danmaku;
    private String dmServiceSwitch;
    private String epId;
    private Map<String, String> extraParams;
    private String fromSpmid;
    private int isAutoplay;
    private String isLocalVideo;
    private String isVertical;
    private String language;
    private int networkType;
    private int playMethod;
    private String playStateHb;
    private int playType;
    private String playerClarity;
    private String playerState;
    private String progress;
    private Function0<Long> progressStrategy;
    private String scene;
    private String sceneHb;
    private String seasonId;
    private String speed;
    private String spmid;
    private int status;
    private int subType;
    private String trackId;
    private int type;
    private int videoFormat;

    /* compiled from: NormalDataModel.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[ScreenModeType.values().length];
            try {
                iArr[ScreenModeType.THUMB.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ScreenModeType.LANDSCAPE_FULLSCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ScreenModeType.VERTICAL_FULLSCREEN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PlayScene.values().length];
            try {
                iArr2[PlayScene.INLINE.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[PlayScene.INLINEV3.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[PlayScene.MINI_SCREEN.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[PlayScene.DEFAULT.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[TfTypeExt.values().length];
            try {
                iArr3[TfTypeExt.C_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr3[TfTypeExt.C_PKG.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr3[TfTypeExt.U_CARD.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr3[TfTypeExt.U_PKG.ordinal()] = 4;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr3[TfTypeExt.T_CARD.ordinal()] = 5;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr3[TfTypeExt.T_PKG.ordinal()] = 6;
            } catch (NoSuchFieldError e13) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[PlayerCodecConfig.Player.values().length];
            try {
                iArr4[PlayerCodecConfig.Player.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr4[PlayerCodecConfig.Player.IJK_PLAYER.ordinal()] = 2;
            } catch (NoSuchFieldError e15) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    public NormalDataModel(PlayerReportCommonField commonField, PlayerCodecConfig playerConfig) {
        Intrinsics.checkNotNullParameter(commonField, "commonField");
        this.fromSpmid = "";
        this.spmid = "";
        this.seasonId = "";
        this.epId = "";
        this.progress = "";
        this.avid = "";
        this.cid = "";
        this.speed = "";
        this.playerClarity = "";
        this.isVertical = "";
        this.playerState = "";
        this.isLocalVideo = "";
        this.dmServiceSwitch = "";
        this.trackId = "";
        this.scene = "0";
        this.language = "";
        this.playStateHb = "";
        this.sceneHb = "";
        this.fromSpmid = commonField.getFromSpmid();
        this.spmid = commonField.getSpmid();
        this.seasonId = String.valueOf(commonField.getSeasonid());
        this.type = commonField.getType();
        this.subType = commonField.getSubType();
        this.epId = commonField.getEpid();
        this.avid = String.valueOf(commonField.getAvid());
        this.cid = String.valueOf(commonField.getVideoId());
        this.trackId = commonField.getTrackid();
        this.isVertical = commonField.isVertical() ? "1" : "2";
        this.playType = getPlayType(playerConfig);
        this.progressStrategy = commonField.getProgressStrategy();
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final void setFromSpmid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fromSpmid = str;
    }

    public final String getSpmid() {
        return this.spmid;
    }

    public final void setSpmid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spmid = str;
    }

    public final String getSeasonId() {
        return this.seasonId;
    }

    public final void setSeasonId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.seasonId = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final int getSubType() {
        return this.subType;
    }

    public final void setSubType(int i) {
        this.subType = i;
    }

    public final String getEpId() {
        return this.epId;
    }

    public final void setEpId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.epId = str;
    }

    public final String getProgress() {
        return this.progress;
    }

    public final void setProgress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.progress = str;
    }

    public final String getAvid() {
        return this.avid;
    }

    public final void setAvid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avid = str;
    }

    public final String getCid() {
        return this.cid;
    }

    public final void setCid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cid = str;
    }

    public final int getNetworkType() {
        return this.networkType;
    }

    public final void setNetworkType(int i) {
        this.networkType = i;
    }

    public final int getDanmaku() {
        return this.danmaku;
    }

    public final void setDanmaku(int i) {
        this.danmaku = i;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final int getPlayMethod() {
        return this.playMethod;
    }

    public final void setPlayMethod(int i) {
        this.playMethod = i;
    }

    public final int getPlayType() {
        return this.playType;
    }

    public final void setPlayType(int i) {
        this.playType = i;
    }

    public final String getSpeed() {
        return this.speed;
    }

    public final void setSpeed(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.speed = str;
    }

    public final String getPlayerClarity() {
        return this.playerClarity;
    }

    public final void setPlayerClarity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playerClarity = str;
    }

    public final int isAutoplay() {
        return this.isAutoplay;
    }

    public final void setAutoplay(int i) {
        this.isAutoplay = i;
    }

    public final int getVideoFormat() {
        return this.videoFormat;
    }

    public final void setVideoFormat(int i) {
        this.videoFormat = i;
    }

    public final String isVertical() {
        return this.isVertical;
    }

    public final void setVertical(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isVertical = str;
    }

    public final String getPlayerState() {
        return this.playerState;
    }

    public final void setPlayerState(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playerState = str;
    }

    public final String isLocalVideo() {
        return this.isLocalVideo;
    }

    public final void setLocalVideo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isLocalVideo = str;
    }

    public final String getDmServiceSwitch() {
        return this.dmServiceSwitch;
    }

    public final void setDmServiceSwitch(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dmServiceSwitch = str;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final void setTrackId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.trackId = str;
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setScene(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scene = str;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.language = str;
    }

    public final String getPlayStateHb() {
        return this.playStateHb;
    }

    public final void setPlayStateHb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playStateHb = str;
    }

    public final String getSceneHb() {
        return this.sceneHb;
    }

    public final void setSceneHb(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sceneHb = str;
    }

    public final Function0<Long> getProgressStrategy() {
        return this.progressStrategy;
    }

    public final void setProgressStrategy(Function0<Long> function0) {
        this.progressStrategy = function0;
    }

    public final Map<String, String> getExtraParams() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.extraParams);
    }

    public final void setExtraParams(Map<String, String> map) {
        this.extraParams = map;
    }

    public final void updateVideoInfo(VideoFormat videoFormat, Boolean isLocalVideo) {
        this.videoFormat = getVideoFormat(videoFormat);
        this.isLocalVideo = Intrinsics.areEqual(isLocalVideo, true) ? "true" : "false";
    }

    public final NormalDataModel refreshPlayableData(String progress, int networkType, boolean isDanmakuShow, ScreenModeType screenType, int playMode, float speed, Integer quality, boolean isAutoPlay, int playState, boolean isDanmakuClosed, PlayScene scene, String language) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
        Intrinsics.checkNotNullParameter(language, IjkMediaMeta.IJKM_KEY_LANGUAGE);
        this.progress = progress;
        this.networkType = generateNetworkType(networkType);
        this.danmaku = isDanmakuShow ? 1 : 2;
        this.status = (screenType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[screenType.ordinal()]) == 1 ? 1 : 2;
        this.playMethod = getPlayMethod(Integer.valueOf(playMode));
        this.speed = String.valueOf(speed);
        this.playerClarity = (quality == null || (r9 = String.valueOf(quality.intValue())) == null) ? "-1" : "-1";
        this.isAutoplay = isAutoPlay ? 1 : 2;
        String str = "2";
        this.playerState = playState == 4 ? "1" : "2";
        this.language = language;
        this.playStateHb = getPlaybackStatus(playState);
        this.dmServiceSwitch = isDanmakuClosed ? "2" : "1";
        switch (WhenMappings.$EnumSwitchMapping$1[scene.ordinal()]) {
            case 1:
            case 2:
                str = "1";
                break;
            case 3:
                break;
            default:
                str = "0";
                break;
        }
        this.scene = str;
        this.sceneHb = getScene(scene, Intrinsics.areEqual("1", this.isVertical), screenType);
        return this;
    }

    private final int generateNetworkType(int networkState) {
        int i;
        switch (networkState) {
            case -1:
                return 3;
            case 0:
            default:
                return networkState;
            case 1:
                return 1;
            case 2:
                TfTypeExt typeExt = FreeDataManager.getInstance().getFreeDataCondition().getTypeExt();
                switch (typeExt == null ? -1 : WhenMappings.$EnumSwitchMapping$2[typeExt.ordinal()]) {
                    case 1:
                    case 2:
                        i = 5;
                        break;
                    case 3:
                    case 4:
                        i = 4;
                        break;
                    case 5:
                    case 6:
                        i = 6;
                        break;
                    default:
                        i = 2;
                        break;
                }
                int networkType = i;
                return networkType;
        }
    }

    private final int getPlayMethod(Integer playerCompleteAction) {
        if (playerCompleteAction != null && playerCompleteAction.intValue() == 1) {
            return 1;
        }
        if (playerCompleteAction != null && playerCompleteAction.intValue() == 0) {
            return 2;
        }
        if (playerCompleteAction != null && playerCompleteAction.intValue() == 2) {
            return 3;
        }
        return (playerCompleteAction != null && playerCompleteAction.intValue() == 4) ? 5 : 2;
    }

    private final int getPlayType(PlayerCodecConfig config) {
        if (config == null) {
            return 1;
        }
        PlayerCodecConfig.Player player = config.mPlayer;
        switch (player == null ? -1 : WhenMappings.$EnumSwitchMapping$3[player.ordinal()]) {
            case 1:
            default:
                return 1;
            case 2:
                return config.mUseIJKMediaCodec ? 6 : 5;
        }
    }

    private final int getVideoFormat(VideoFormat videoFormat) {
        if (Intrinsics.areEqual(videoFormat, VideoFormat.DASH.INSTANCE)) {
            return 1;
        }
        return Intrinsics.areEqual(videoFormat, VideoFormat.FLV.INSTANCE) ? 2 : 0;
    }

    private final String getPlaybackStatus(int playState) {
        switch (playState) {
            case 0:
            case 1:
            case 6:
            case 7:
            case 8:
            default:
                return "stopped";
            case 2:
            case 3:
            case 5:
            case 101:
                return "paused";
            case 4:
            case 100:
                return "playing";
        }
    }

    private final String getScene(PlayScene scene, boolean isVertical, ScreenModeType screenType) {
        if (WhenMappings.$EnumSwitchMapping$1[scene.ordinal()] == 4) {
            switch (screenType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[screenType.ordinal()]) {
                case -1:
                case 1:
                    if (isVertical) {
                        return "portrait_half_screen";
                    }
                    return "landscape_half_screen";
                case 0:
                default:
                    throw new NoWhenBranchMatchedException();
                case 2:
                    return "landscape_full_screen";
                case 3:
                    return "portrait_full_screen";
            }
        }
        return scene.getValue();
    }
}