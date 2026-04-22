package tv.danmaku.biliplayerv2.utils;

import BottomSheetItemData$;
import com.bapis.bilibili.app.distribution.BoolValue;
import com.bapis.bilibili.app.distribution.DistributionMoss;
import com.bapis.bilibili.app.distribution.GetUserPreferenceReply;
import com.bapis.bilibili.app.distribution.GetUserPreferenceReq;
import com.bapis.bilibili.app.distribution.SetUserPreferenceReply;
import com.bapis.bilibili.app.distribution.SetUserPreferenceReq;
import com.bapis.bilibili.app.distribution.setting.play.PlayConfig;
import com.bapis.bilibili.app.distribution.setting.play.SpecificPlayConfig;
import com.bapis.bilibili.playershared.UnsupportScene;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.device.settings.generated.api.DistributionSettings;
import com.bilibili.lib.deviceconfig.generated.api.IPlayAbilityConf;
import com.bilibili.lib.media.resource.PlayConfig;
import com.bilibili.lib.media.util.PlayerCloudSetting;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.google.protobuf.Any;
import com.google.protobuf.MessageLite;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerCloudConfig.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u0098\u00012\u00020\u0001:\u0004\u0098\u0001\u0099\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bJ\u0010\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\rJ\r\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u001bJ\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010\"\u001a\u00020\rJ\u0006\u0010#\u001a\u00020\rJ\u000e\u0010$\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010%\u001a\u00020\rJ\u0006\u0010&\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010(\u001a\u00020\rJ\u0006\u0010)\u001a\u00020\rJ\u0006\u0010*\u001a\u00020\rJ\u0006\u0010+\u001a\u00020\rJ\u0006\u0010,\u001a\u00020\rJ\u000e\u0010-\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010.\u001a\u00020\rJ\u0006\u0010/\u001a\u00020\rJ\u000e\u00100\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u00101\u001a\u00020\rJ\u0006\u00102\u001a\u00020\rJ\u0006\u00103\u001a\u00020\rJ\u000e\u00104\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u00105\u001a\u00020\rJ\u0006\u00106\u001a\u00020\rJ\u000e\u00107\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u00108\u001a\u00020\rJ\u0006\u00109\u001a\u00020\rJ\u000e\u0010:\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010;\u001a\u00020\rJ\u0006\u0010<\u001a\u00020\rJ\u000e\u0010=\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010>\u001a\u00020\rJ\u0006\u0010?\u001a\u00020\rJ\u000e\u0010@\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010A\u001a\u00020\rJ\u0006\u0010B\u001a\u00020\rJ\u0006\u0010C\u001a\u00020\rJ\u000e\u0010D\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010E\u001a\u00020\rJ\u0006\u0010F\u001a\u00020\rJ\u000e\u0010G\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010H\u001a\u00020\rJ\u0006\u0010I\u001a\u00020\rJ\u000e\u0010J\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010K\u001a\u00020\rJ\u0006\u0010L\u001a\u00020\rJ\u000e\u0010M\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010N\u001a\u00020\rJ\u0006\u0010O\u001a\u00020\rJ\u000e\u0010P\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010Q\u001a\u00020\rJ\u0006\u0010R\u001a\u00020\rJ\u000e\u0010S\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0010\u0010T\u001a\u00020\r2\b\b\u0002\u0010U\u001a\u00020\rJ\u0010\u0010V\u001a\u00020\r2\b\b\u0002\u0010U\u001a\u00020\rJ\u000e\u0010W\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0010\u0010X\u001a\u00020\r2\b\b\u0002\u0010U\u001a\u00020\rJ\u000e\u0010Y\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0010\u0010Z\u001a\u00020\r2\b\b\u0002\u0010U\u001a\u00020\rJ\u0010\u0010[\u001a\u00020\r2\b\b\u0002\u0010U\u001a\u00020\rJ\u000e\u0010\\\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0010\u0010]\u001a\u00020\r2\b\b\u0002\u0010U\u001a\u00020\rJ\u0006\u0010^\u001a\u00020\rJ\u0006\u0010_\u001a\u00020\rJ\u000e\u0010`\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010a\u001a\u00020\rJ\u0006\u0010b\u001a\u00020\rJ\u0010\u0010c\u001a\u00020\r2\b\b\u0002\u0010U\u001a\u00020\rJ\u0006\u0010d\u001a\u00020\rJ\u0006\u0010e\u001a\u00020\rJ\u0006\u0010f\u001a\u00020\rJ\b\u0010g\u001a\u0004\u0018\u00010hJ\u0006\u0010i\u001a\u00020\rJ\u000e\u0010j\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010k\u001a\u00020\rJ\u0006\u0010l\u001a\u00020\rJ\u000e\u0010m\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010n\u001a\u00020\rJ\u0006\u0010o\u001a\u00020\rJ\u000e\u0010p\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010q\u001a\u00020\rJ\u0006\u0010r\u001a\u00020\rJ\u000e\u0010s\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010t\u001a\u00020\u00112\u0006\u0010u\u001a\u00020vJ\u0006\u0010w\u001a\u00020vJ\u0006\u0010x\u001a\u00020\rJ\u0006\u0010y\u001a\u00020\rJ\u0006\u0010z\u001a\u00020\rJ\u0006\u0010{\u001a\u00020\rJ\u0006\u0010|\u001a\u00020\rJ\u000e\u0010}\u001a\u00020\u00112\u0006\u0010~\u001a\u00020\rJ\u0006\u0010\u007f\u001a\u00020\rJ\u000f\u0010\u0080\u0001\u001a\u00020\u00112\u0006\u0010~\u001a\u00020\rJ*\u0010\u0081\u0001\u001a\u00020\u00112\u0007\u0010\u0082\u0001\u001a\u00020\u001b2\u0007\u0010\u0083\u0001\u001a\u00020\u001b2\u000f\u0010\u0084\u0001\u001a\n\u0012\u0005\u0012\u00030\u0086\u00010\u0085\u0001J\u0007\u0010\u0087\u0001\u001a\u00020\rJ2\u0010\u0088\u0001\u001a\u00020\u00112\u0006\u0010~\u001a\u00020\r2\u0007\u0010\u0082\u0001\u001a\u00020\u001b2\u0007\u0010\u0083\u0001\u001a\u00020\u001b2\u000f\u0010\u0084\u0001\u001a\n\u0012\u0005\u0012\u00030\u0089\u00010\u0085\u0001J\u0007\u0010\u008a\u0001\u001a\u00020\rJ\u0007\u0010\u008b\u0001\u001a\u00020\rJ\u0007\u0010\u008c\u0001\u001a\u00020\rJ\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010hJ\u0007\u0010\u008e\u0001\u001a\u00020\rJ\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010hJ\u0007\u0010\u0090\u0001\u001a\u00020\rJ\u0007\u0010\u0091\u0001\u001a\u00020\rJ\u0007\u0010\u0092\u0001\u001a\u00020\rJ\u0007\u0010\u0093\u0001\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0094\u0001\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010\u000fR\u0013\u0010\u0096\u0001\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010\u000f¨\u0006\u009a\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/PlayerCloudConfig;", "", "<init>", "()V", "mPlayAbilityConf", "Lcom/bilibili/lib/deviceconfig/generated/api/IPlayAbilityConf;", "mPlayConfig", "Lcom/bilibili/lib/media/resource/PlayConfig;", "mDistributionPlayConfig", "Lcom/bilibili/lib/device/settings/generated/api/DistributionSettings;", "mDisableScene", "Lcom/bapis/bilibili/playershared/UnsupportScene;", "hasArcConfig", "", "getHasArcConfig", "()Z", "setPlayMenuConfigDisableScene", "", LoginSceneProcessor.SCENE_KEY, "setPlayMenuConfig", "playConfig", "supportBackground", "isBackgroundDisabled", "getBackgroundDisabledCode", "", "()Ljava/lang/Long;", "getBackgroundDisabledReason", "", "showBackground", "setBackground", "show", "getProjectionDisabledReason", "getProjectionPlayMenuConfig", "Lcom/bilibili/lib/media/resource/PlayConfig$PlayMenuConfig;", "supportFlip", "showFlip", "setFlip", "supportProjection", "showProjection", "setProjection", "supportTogetherWatchEnter", "supportFullTogetherWatchEnter", "supportDubbing", "supportSubtitle", "showSubtitle", "setSubtitle", "supportFeedback", "showFeedback", "setFeedback", "supportSkipHeadTail", "supportPlaybackRate", "showPlaybackRate", "setPlaybackRate", "supportPlaybackMode", "showPlaybackMode", "setPlaybackMode", "supportTimeUp", "showTimeUp", "setTimeUp", "supportScaleMode", "showScaleMode", "setScaleMode", "supportLockScreen", "showLockScreen", "setLockScreen", "supportSnapshot", "supportRecord", "showSnapshot", "setSnapshot", "supportRecommend", "showRecommend", "setRecommend", "supportDislike", "showDislike", "setDislike", "supportCoin", "showCoin", "setCoin", "supportCharge", "showCharge", "setCharge", "supportPlaybackSpeed", "showPlaybackSpeed", "setPlaybackSpeed", "supportPages", "default", "showPages", "setPages", "showDolby", "setDolby", "supportDolby", "showHiRes", "setHiRes", "supportHiRes", "supportQuality", "showQuality", "setQuality", "supportShare", "supportLike", "supportNext", "supportDanmaku", "supportOuterDanmaku", "supportMiniPlayer", "miniDisableInfo", "Ltv/danmaku/biliplayerv2/utils/PlayerCloudConfig$DisableInfo;", "showMiniPlayer", "setMiniPlayer", "supportWholeScene", "showWholeScene", "setWholeScene", "supportInnerDanmaku", "showInnerDanmaku", "setInnerDanmakuSetting", "supportDaltonism", "showDaltonism", "setDaltonismShow", "setSelectedDaltonismMode", "mode", "", "getSelectedDaltonismMode", "shouldAutoPlayWhenEnterDetailPage", "enableDanmakuInteraction", "enableDanmakuMonospaced", "enableGravityRotate", "enableFeedbackSubtitle", "setFeedbackSubtitleEnable", "enable", "enableSubtitle", "setSubtitleEnable", "getSegmentProgress", "aid", "cid", "callback", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "Lcom/bapis/bilibili/app/distribution/GetUserPreferenceReply;", "getDefaultSegmentProgress", "setSegmentProgress", "Lcom/bapis/bilibili/app/distribution/SetUserPreferenceReply;", "isPlayStoryOpen", "isPlayLandscapeStoryOpen", "supportListen", "listenDisableInfo", "supportWatchLater", "watchLaterDisableInfo", "supportScreenRecordHalf", "supportScreenRecordFull", "isLikeDisabled", "isCoinDisabled", "supportTranslate", "getSupportTranslate", "enableTranslate", "getEnableTranslate", "Companion", "DisableInfo", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerCloudConfig {
    public static final Companion Companion = new Companion(null);
    private static final String TYPE_URL_SPECIFIC_PLAY_CONFIG = "type.googleapis.com/bilibili.app.distribution.play.v1.SpecificPlayConfig";
    private UnsupportScene mDisableScene;
    private final DistributionSettings mDistributionPlayConfig;
    private IPlayAbilityConf mPlayAbilityConf;
    private PlayConfig mPlayConfig;

    public PlayerCloudConfig() {
        Object obj = BLRouter.get$default(BLRouter.INSTANCE, IPlayAbilityConf.class, (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(obj);
        this.mPlayAbilityConf = (IPlayAbilityConf) obj;
        Object obj2 = BLRouter.get$default(BLRouter.INSTANCE, DistributionSettings.class, (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(obj2);
        this.mDistributionPlayConfig = (DistributionSettings) obj2;
        this.mDisableScene = UnsupportScene.UNKNOWN_SCENE;
    }

    /* compiled from: PlayerCloudConfig.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/PlayerCloudConfig$Companion;", "", "<init>", "()V", "TYPE_URL_SPECIFIC_PLAY_CONFIG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean getHasArcConfig() {
        return this.mPlayConfig != null;
    }

    public final void setPlayMenuConfigDisableScene(UnsupportScene scene) {
        Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
        this.mDisableScene = scene;
    }

    public final boolean setPlayMenuConfig(PlayConfig playConfig) {
        boolean changed = !Intrinsics.areEqual(this.mPlayConfig, playConfig);
        this.mPlayConfig = playConfig;
        return changed;
    }

    public final boolean supportBackground() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mBackgroundPlayConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean isBackgroundDisabled() {
        PlayConfig playConfig;
        PlayConfig.PlayMenuConfig playMenuConfig;
        return (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (playMenuConfig = playConfig.mBackgroundPlayConfig) == null || !playMenuConfig.isDisabled()) ? false : true;
    }

    public final Long getBackgroundDisabledCode() {
        PlayConfig playConfig;
        PlayConfig.PlayMenuConfig playMenuConfig;
        PlayConfig.PlayMenuConfig.ExtraContent extraContent;
        if (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (playMenuConfig = playConfig.mBackgroundPlayConfig) == null || (extraContent = playMenuConfig.getExtraContent()) == null) {
            return null;
        }
        return Long.valueOf(extraContent.getDisabledCode());
    }

    public final String getBackgroundDisabledReason() {
        PlayConfig playConfig;
        PlayConfig.PlayMenuConfig playMenuConfig;
        PlayConfig.PlayMenuConfig.ExtraContent extraContent;
        if (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (playMenuConfig = playConfig.mBackgroundPlayConfig) == null || (extraContent = playMenuConfig.getExtraContent()) == null) {
            return null;
        }
        return extraContent.getDisabledReason();
    }

    public final boolean showBackground() {
        return this.mPlayAbilityConf.getBackgroundPlayConf().getSwitch(true);
    }

    public final void setBackground(boolean show) {
        this.mPlayAbilityConf.getBackgroundPlayConf().setSwitch(show);
    }

    public final String getProjectionDisabledReason() {
        PlayConfig playConfig;
        PlayConfig.PlayMenuConfig playMenuConfig;
        PlayConfig.PlayMenuConfig.ExtraContent extraContent;
        if (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (playMenuConfig = playConfig.mCastConfig) == null || (extraContent = playMenuConfig.getExtraContent()) == null) {
            return null;
        }
        return extraContent.getDisabledReason();
    }

    public final PlayConfig.PlayMenuConfig getProjectionPlayMenuConfig() {
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null) {
            return playConfig.mCastConfig;
        }
        return null;
    }

    public final boolean supportFlip() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mFlipConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean showFlip() {
        return this.mPlayAbilityConf.getFlipConf().getSwitch(true);
    }

    public final void setFlip(boolean show) {
        this.mPlayAbilityConf.getFlipConf().setSwitch(show);
    }

    public final boolean supportProjection() {
        PlayConfig playConfig;
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (it = playConfig.mCastConfig) == null) {
            return false;
        }
        return ((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1;
    }

    public final boolean showProjection() {
        return this.mPlayAbilityConf.getCastConf().getSwitch(true);
    }

    public final void setProjection(boolean show) {
        this.mPlayAbilityConf.getCastConf().setSwitch(show);
    }

    public final boolean supportTogetherWatchEnter() {
        PlayConfig playConfig;
        PlayConfig.PlayMenuConfig playMenuConfig;
        return (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (playMenuConfig = playConfig.mTogetherWatchEnterConfig) == null || !playMenuConfig.isSupport()) ? false : true;
    }

    public final boolean supportFullTogetherWatchEnter() {
        PlayConfig playConfig;
        PlayConfig.PlayMenuConfig playMenuConfig;
        return (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (playMenuConfig = playConfig.mTogetherWatchFullEnterConfig) == null || !playMenuConfig.isSupport()) ? false : true;
    }

    public final boolean supportDubbing() {
        PlayConfig playConfig;
        PlayConfig.PlayMenuConfig playMenuConfig;
        return (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (playMenuConfig = playConfig.mDubbingConfig) == null || !playMenuConfig.isSupport()) ? false : true;
    }

    public final boolean supportSubtitle() {
        PlayConfig playConfig;
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (it = playConfig.mSubtitleConfig) == null) {
            return false;
        }
        return ((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1;
    }

    public final boolean showSubtitle() {
        return this.mPlayAbilityConf.getSubtitleConf().getSwitch(true);
    }

    public final void setSubtitle(boolean show) {
        this.mPlayAbilityConf.getSubtitleConf().setSwitch(show);
    }

    public final boolean supportFeedback() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mFeedbackConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean showFeedback() {
        return this.mPlayAbilityConf.getFeedbackConf().getSwitch(true);
    }

    public final void setFeedback(boolean show) {
        this.mPlayAbilityConf.getFeedbackConf().setSwitch(show);
    }

    public final boolean supportSkipHeadTail() {
        PlayConfig playConfig;
        PlayConfig.PlayMenuConfig playMenuConfig;
        return (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (playMenuConfig = playConfig.mSkipHeadTailConfig) == null || !playMenuConfig.isSupport()) ? false : true;
    }

    public final boolean supportPlaybackRate() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mPlaybackRateConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean showPlaybackRate() {
        return this.mPlayAbilityConf.getPlaybackRateConf().getSwitch(true);
    }

    public final void setPlaybackRate(boolean show) {
        this.mPlayAbilityConf.getPlaybackRateConf().setSwitch(show);
    }

    public final boolean supportPlaybackMode() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mPlaybackModeConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean showPlaybackMode() {
        return this.mPlayAbilityConf.getPlaybackModeConf().getSwitch(true);
    }

    public final void setPlaybackMode(boolean show) {
        this.mPlayAbilityConf.getPlaybackModeConf().setSwitch(show);
    }

    public final boolean supportTimeUp() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mTimeUpConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean showTimeUp() {
        return this.mPlayAbilityConf.getTimeUpConf().getSwitch(true);
    }

    public final void setTimeUp(boolean show) {
        this.mPlayAbilityConf.getTimeUpConf().setSwitch(show);
    }

    public final boolean supportScaleMode() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mScaleModeConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean showScaleMode() {
        return this.mPlayAbilityConf.getScaleModeConf().getSwitch(true);
    }

    public final void setScaleMode(boolean show) {
        this.mPlayAbilityConf.getScaleModeConf().setSwitch(show);
    }

    public final boolean supportLockScreen() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mLockScreenConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean showLockScreen() {
        return this.mPlayAbilityConf.getLockScreenConf().getSwitch(true);
    }

    public final void setLockScreen(boolean show) {
        this.mPlayAbilityConf.getLockScreenConf().setSwitch(show);
    }

    public final boolean supportSnapshot() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mSnapshotConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean supportRecord() {
        PlayConfig playConfig;
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (it = playConfig.mRecordConfig) == null) {
            return false;
        }
        return ((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1;
    }

    public final boolean showSnapshot() {
        return this.mPlayAbilityConf.getScreenShotConf().getSwitch(true);
    }

    public final void setSnapshot(boolean show) {
        this.mPlayAbilityConf.getScreenShotConf().setSwitch(show);
    }

    public final boolean supportRecommend() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mRecommendConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean showRecommend() {
        return this.mPlayAbilityConf.getRecommendConf().getSwitch(true);
    }

    public final void setRecommend(boolean show) {
        this.mPlayAbilityConf.getRecommendConf().setSwitch(show);
    }

    public final boolean supportDislike() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mDislikeConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean showDislike() {
        return this.mPlayAbilityConf.getDislikeConf().getSwitch(true);
    }

    public final void setDislike(boolean show) {
        this.mPlayAbilityConf.getDislikeConf().setSwitch(show);
    }

    public final boolean supportCoin() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mCoinConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean showCoin() {
        return this.mPlayAbilityConf.getCoinConf().getSwitch(true);
    }

    public final void setCoin(boolean show) {
        this.mPlayAbilityConf.getCoinConf().setSwitch(show);
    }

    public final boolean supportCharge() {
        PlayConfig playConfig;
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (it = playConfig.mChargeConfig) == null) {
            return false;
        }
        return ((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1;
    }

    public final boolean showCharge() {
        return this.mPlayAbilityConf.getElecConf().getSwitch(false);
    }

    public final void setCharge(boolean show) {
        this.mPlayAbilityConf.getElecConf().setSwitch(show);
    }

    public final boolean supportPlaybackSpeed() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mPlaybackSpeedConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean showPlaybackSpeed() {
        return this.mPlayAbilityConf.getPlaybackSpeedConf().getSwitch(true);
    }

    public final void setPlaybackSpeed(boolean show) {
        this.mPlayAbilityConf.getPlaybackSpeedConf().setSwitch(show);
    }

    public static /* synthetic */ boolean supportPages$default(PlayerCloudConfig playerCloudConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return playerCloudConfig.supportPages(z);
    }

    public final boolean supportPages(boolean z) {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return z;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig == null || (it = playConfig.mPagesConfig) == null) {
            return false;
        }
        return ((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1;
    }

    public static /* synthetic */ boolean showPages$default(PlayerCloudConfig playerCloudConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return playerCloudConfig.showPages(z);
    }

    public final boolean showPages(boolean z) {
        return this.mPlayAbilityConf.getSelectionsConf().getSwitch(z);
    }

    public final void setPages(boolean show) {
        this.mPlayAbilityConf.getSelectionsConf().setSwitch(show);
    }

    public static /* synthetic */ boolean showDolby$default(PlayerCloudConfig playerCloudConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return playerCloudConfig.showDolby(z);
    }

    public final boolean showDolby(boolean z) {
        return this.mPlayAbilityConf.getDolbyConf().getSwitch(z);
    }

    public final void setDolby(boolean show) {
        this.mPlayAbilityConf.getDolbyConf().setSwitch(show);
    }

    public static /* synthetic */ boolean supportDolby$default(PlayerCloudConfig playerCloudConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return playerCloudConfig.supportDolby(z);
    }

    public final boolean supportDolby(boolean z) {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return z;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig == null || (it = playConfig.mDolbyConfig) == null) {
            return false;
        }
        return ((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1;
    }

    public static /* synthetic */ boolean showHiRes$default(PlayerCloudConfig playerCloudConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return playerCloudConfig.showHiRes(z);
    }

    public final boolean showHiRes(boolean z) {
        return this.mPlayAbilityConf.getLossLessConf().getSwitch(z);
    }

    public final void setHiRes(boolean show) {
        this.mPlayAbilityConf.getLossLessConf().setSwitch(show);
    }

    public static /* synthetic */ boolean supportHiRes$default(PlayerCloudConfig playerCloudConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return playerCloudConfig.supportHiRes(z);
    }

    public final boolean supportHiRes(boolean z) {
        PlayConfig.PlayMenuConfig playMenuConfig;
        if (this.mPlayConfig == null) {
            return z;
        }
        PlayConfig playConfig = this.mPlayConfig;
        return (playConfig == null || (playMenuConfig = playConfig.mHiResConfig) == null || !playMenuConfig.isSupport()) ? false : true;
    }

    public final boolean supportQuality() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mQualityConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean showQuality() {
        return this.mPlayAbilityConf.getDefinitionConf().getSwitch(true);
    }

    public final void setQuality(boolean show) {
        this.mPlayAbilityConf.getDefinitionConf().setSwitch(show);
    }

    public final boolean supportShare() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mShareConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean supportLike() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mLikeConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean supportNext$default(PlayerCloudConfig playerCloudConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return playerCloudConfig.supportNext(z);
    }

    public final boolean supportNext(boolean z) {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return z;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig == null || (it = playConfig.mNextConfig) == null) {
            return false;
        }
        return ((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1;
    }

    public final boolean supportDanmaku() {
        PlayConfig.PlayMenuConfig playMenuConfig;
        List unsupportedScene;
        PlayConfig.PlayMenuConfig playMenuConfig2;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (!((playConfig == null || (playMenuConfig2 = playConfig.mDanmakuConfig) == null || playMenuConfig2.isSupport()) ? false : true)) {
            PlayConfig playConfig2 = this.mPlayConfig;
            if (!((playConfig2 == null || (playMenuConfig = playConfig2.mDanmakuConfig) == null || (unsupportedScene = playMenuConfig.getUnsupportedScene()) == null || !unsupportedScene.contains(this.mDisableScene)) ? false : true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean supportOuterDanmaku() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        boolean z = false;
        if (playConfig != null && (it = playConfig.mOuterDanmakuSettingSwitchConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == null) {
                z = true;
            }
        }
        return !z;
    }

    public final boolean supportMiniPlayer() {
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null) {
            return true;
        }
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig != null && (it = playConfig.mMiniPlayerConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1) {
                return true;
            }
        }
        return false;
    }

    public final DisableInfo miniDisableInfo() {
        PlayConfig.PlayMenuConfig it;
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig == null || (it = playConfig.mMiniPlayerConfig) == null) {
            return null;
        }
        boolean isDisabled = it.isDisabled();
        PlayConfig.PlayMenuConfig.ExtraContent extraContent = it.getExtraContent();
        Long valueOf = extraContent != null ? Long.valueOf(extraContent.getDisabledCode()) : null;
        PlayConfig.PlayMenuConfig.ExtraContent extraContent2 = it.getExtraContent();
        return new DisableInfo(isDisabled, valueOf, extraContent2 != null ? extraContent2.getDisabledReason() : null);
    }

    public final boolean showMiniPlayer() {
        return this.mPlayAbilityConf.getSmallWindowConf().getSwitch(true);
    }

    public final void setMiniPlayer(boolean show) {
        this.mPlayAbilityConf.getSmallWindowConf().setSwitch(show);
    }

    public final boolean supportWholeScene() {
        PlayConfig.PlayMenuConfig it;
        PlayConfig playConfig = this.mPlayConfig;
        if (playConfig == null || (it = playConfig.mWholeSceneConfig) == null) {
            return false;
        }
        return ((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1;
    }

    public final boolean showWholeScene() {
        return this.mPlayAbilityConf.getPanoramaConf().getSwitch(true);
    }

    public final void setWholeScene(boolean show) {
        this.mPlayAbilityConf.getPanoramaConf().setSwitch(show);
    }

    public final boolean supportInnerDanmaku() {
        PlayConfig playConfig;
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (it = playConfig.mInnerDanmakuSettingSwitchConfig) == null) {
            return false;
        }
        return ((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1;
    }

    public final boolean showInnerDanmaku() {
        return this.mPlayAbilityConf.getInnerDmConf().getSwitch(true);
    }

    public final void setInnerDanmakuSetting(boolean show) {
        this.mPlayAbilityConf.getInnerDmConf().setSwitch(show);
    }

    public final boolean supportDaltonism() {
        PlayConfig.PlayMenuConfig it;
        PlayConfig playConfig = this.mPlayConfig;
        boolean z = false;
        if (playConfig != null && (it = playConfig.mFilterConfig) != null) {
            if (((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == null) {
                z = true;
            }
        }
        return !z;
    }

    public final boolean showDaltonism() {
        return this.mPlayAbilityConf.getColorFilterConf().getSwitch(true);
    }

    public final void setDaltonismShow(boolean show) {
        this.mPlayAbilityConf.getColorFilterConf().setSwitch(show);
    }

    public final void setSelectedDaltonismMode(int mode) {
        PlayerCloudSetting.setSettingLongValue$default(PlayerCloudSetting.INSTANCE, PlayerCloudSetting.Setting.ColorFilter, mode, false, 4, (Object) null);
    }

    public final int getSelectedDaltonismMode() {
        return (int) PlayerCloudSetting.INSTANCE.getSettingLongValue(PlayerCloudSetting.Setting.ColorFilter);
    }

    public final boolean shouldAutoPlayWhenEnterDetailPage() {
        if (this.mDistributionPlayConfig.getPlayConfig().hasShouldAutoPlay()) {
            return this.mDistributionPlayConfig.getPlayConfig().getShouldAutoPlay().getValue();
        }
        return true;
    }

    public final boolean enableDanmakuInteraction() {
        if (this.mDistributionPlayConfig.getPlayConfig().hasEnableDanmakuInteraction()) {
            return this.mDistributionPlayConfig.getPlayConfig().getEnableDanmakuInteraction().getValue();
        }
        return true;
    }

    public final boolean enableDanmakuMonospaced() {
        if (this.mDistributionPlayConfig.getPlayConfig().hasEnableDanmakuMonospaced()) {
            return this.mDistributionPlayConfig.getPlayConfig().getEnableDanmakuMonospaced().getValue();
        }
        return true;
    }

    public final boolean enableGravityRotate() {
        if (this.mDistributionPlayConfig.getPlayConfig().hasEnableGravityRotateScreen()) {
            return this.mDistributionPlayConfig.getPlayConfig().getEnableGravityRotateScreen().getValue();
        }
        return true;
    }

    public final boolean enableFeedbackSubtitle() {
        if (this.mDistributionPlayConfig.getPlayConfig().hasEnableEditSubtitle()) {
            return this.mDistributionPlayConfig.getPlayConfig().getEnableEditSubtitle().getValue();
        }
        return false;
    }

    public final void setFeedbackSubtitleEnable(boolean enable) {
        PlayConfig.Builder builder = this.mDistributionPlayConfig.getPlayConfig().toBuilder();
        DistributionSettings distributionSettings = this.mDistributionPlayConfig;
        com.bapis.bilibili.app.distribution.setting.play.PlayConfig build = builder.setEnableEditSubtitle(BoolValue.newBuilder().setValue(enable)).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        distributionSettings.setPlayConfig(build);
    }

    public final boolean enableSubtitle() {
        return PlayerCloudSetting.INSTANCE.getSettingBooleanValue(PlayerCloudSetting.Setting.Subtitle);
    }

    public final void setSubtitleEnable(boolean enable) {
        PlayerCloudSetting.setSettingBooleanValue$default(PlayerCloudSetting.INSTANCE, PlayerCloudSetting.Setting.Subtitle, enable, false, 4, (Object) null);
    }

    public final void getSegmentProgress(String aid, String cid, MossResponseHandler<GetUserPreferenceReply> mossResponseHandler) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(mossResponseHandler, "callback");
        HashMap map = new HashMap();
        map.put("aid", aid);
        map.put("cid", cid);
        GetUserPreferenceReq.Builder builder = GetUserPreferenceReq.newBuilder();
        builder.addTypeUrl(TYPE_URL_SPECIFIC_PLAY_CONFIG);
        builder.putAllExtraContext(map);
        DistributionMoss distributionMoss = new DistributionMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
        GetUserPreferenceReq build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        distributionMoss.getUserPreference(build, mossResponseHandler);
    }

    public final boolean getDefaultSegmentProgress() {
        SpecificPlayConfig config = this.mDistributionPlayConfig.getSpecificPlayConfig();
        if (config.hasEnableSegmentedSection()) {
            return config.getEnableSegmentedSection().getValue();
        }
        return true;
    }

    public final void setSegmentProgress(boolean enable, String aid, String cid, MossResponseHandler<SetUserPreferenceReply> mossResponseHandler) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(mossResponseHandler, "callback");
        MessageLite $this$pack$iv = SpecificPlayConfig.getDefaultInstance().toBuilder().setEnableSegmentedSection(BoolValue.newBuilder().setValue(enable)).build();
        Any build = Any.newBuilder().setTypeUrl(TYPE_URL_SPECIFIC_PLAY_CONFIG).setValue($this$pack$iv.toByteString()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        Any config = build;
        HashMap map = new HashMap();
        map.put("aid", aid);
        map.put("cid", cid);
        SetUserPreferenceReq.Builder builder = SetUserPreferenceReq.newBuilder();
        builder.addPreference(config);
        builder.putAllExtraContext(map);
        DistributionMoss distributionMoss = new DistributionMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
        SetUserPreferenceReq build2 = builder.build();
        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
        distributionMoss.setUserPreference(build2, mossResponseHandler);
    }

    public final boolean isPlayStoryOpen() {
        if (this.mDistributionPlayConfig.getPlayConfig().hasShouldAutoStory()) {
            return this.mDistributionPlayConfig.getPlayConfig().getShouldAutoStory().getValue();
        }
        return true;
    }

    public final boolean isPlayLandscapeStoryOpen() {
        if (this.mDistributionPlayConfig.getPlayConfig().hasLandscapeAutoStory()) {
            return this.mDistributionPlayConfig.getPlayConfig().getLandscapeAutoStory().getValue();
        }
        return true;
    }

    public final boolean supportListen() {
        com.bilibili.lib.media.resource.PlayConfig playConfig;
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (it = playConfig.mListenConfig) == null) {
            return false;
        }
        return ((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1;
    }

    public final DisableInfo listenDisableInfo() {
        PlayConfig.PlayMenuConfig it;
        com.bilibili.lib.media.resource.PlayConfig playConfig = this.mPlayConfig;
        if (playConfig == null || (it = playConfig.mListenConfig) == null) {
            return null;
        }
        boolean isDisabled = it.isDisabled();
        PlayConfig.PlayMenuConfig.ExtraContent extraContent = it.getExtraContent();
        Long valueOf = extraContent != null ? Long.valueOf(extraContent.getDisabledCode()) : null;
        PlayConfig.PlayMenuConfig.ExtraContent extraContent2 = it.getExtraContent();
        return new DisableInfo(isDisabled, valueOf, extraContent2 != null ? extraContent2.getDisabledReason() : null);
    }

    public final boolean supportWatchLater() {
        com.bilibili.lib.media.resource.PlayConfig playConfig;
        PlayConfig.PlayMenuConfig it;
        if (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (it = playConfig.mWatchLaterConfig) == null) {
            return false;
        }
        return ((!it.isSupport() || it.getUnsupportedScene().contains(this.mDisableScene)) ? null : 1) == 1;
    }

    public final DisableInfo watchLaterDisableInfo() {
        PlayConfig.PlayMenuConfig it;
        com.bilibili.lib.media.resource.PlayConfig playConfig = this.mPlayConfig;
        if (playConfig == null || (it = playConfig.mWatchLaterConfig) == null) {
            return null;
        }
        boolean isDisabled = it.isDisabled();
        PlayConfig.PlayMenuConfig.ExtraContent extraContent = it.getExtraContent();
        Long valueOf = extraContent != null ? Long.valueOf(extraContent.getDisabledCode()) : null;
        PlayConfig.PlayMenuConfig.ExtraContent extraContent2 = it.getExtraContent();
        return new DisableInfo(isDisabled, valueOf, extraContent2 != null ? extraContent2.getDisabledReason() : null);
    }

    public final boolean supportScreenRecordHalf() {
        PlayConfig.PlayMenuConfig config;
        com.bilibili.lib.media.resource.PlayConfig playConfig = this.mPlayConfig;
        if (playConfig == null || (config = playConfig.mScreenRecordConfig) == null) {
            return true;
        }
        return (!config.isSupport() || config.getUnsupportedScene().contains(this.mDisableScene) || config.getUnsupportedState() == PlayConfig.UnsupportedState.HALF) ? false : true;
    }

    public final boolean supportScreenRecordFull() {
        PlayConfig.PlayMenuConfig config;
        com.bilibili.lib.media.resource.PlayConfig playConfig = this.mPlayConfig;
        if (playConfig == null || (config = playConfig.mScreenRecordConfig) == null) {
            return true;
        }
        return (!config.isSupport() || config.getUnsupportedScene().contains(this.mDisableScene) || config.getUnsupportedState() == PlayConfig.UnsupportedState.FULL) ? false : true;
    }

    public final boolean isLikeDisabled() {
        com.bilibili.lib.media.resource.PlayConfig playConfig;
        PlayConfig.PlayMenuConfig playMenuConfig;
        return (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (playMenuConfig = playConfig.mLikeConfig) == null || !playMenuConfig.isDisabled()) ? false : true;
    }

    public final boolean isCoinDisabled() {
        com.bilibili.lib.media.resource.PlayConfig playConfig;
        PlayConfig.PlayMenuConfig playMenuConfig;
        return (this.mPlayConfig == null || (playConfig = this.mPlayConfig) == null || (playMenuConfig = playConfig.mCoinConfig) == null || !playMenuConfig.isDisabled()) ? false : true;
    }

    public final boolean getSupportTranslate() {
        PlayConfig.PlayMenuConfig $this$_get_supportTranslate__u24lambda_u240;
        com.bilibili.lib.media.resource.PlayConfig playConfig = this.mPlayConfig;
        return (playConfig == null || ($this$_get_supportTranslate__u24lambda_u240 = playConfig.mTranslateConfig) == null || !$this$_get_supportTranslate__u24lambda_u240.isSupport() || $this$_get_supportTranslate__u24lambda_u240.getUnsupportedScene().contains(this.mDisableScene)) ? false : true;
    }

    public final boolean getEnableTranslate() {
        PlayConfig.PlayMenuConfig playMenuConfig;
        if (getSupportTranslate()) {
            com.bilibili.lib.media.resource.PlayConfig playConfig = this.mPlayConfig;
            return playConfig != null && (playMenuConfig = playConfig.mTranslateConfig) != null && !playMenuConfig.isDisabled();
        }
        return false;
    }

    /* compiled from: PlayerCloudConfig.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/PlayerCloudConfig$DisableInfo;", "", "isDisable", "", "disableCode", "", "disableReason", "", "<init>", "(ZLjava/lang/Long;Ljava/lang/String;)V", "()Z", "getDisableCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDisableReason", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(ZLjava/lang/Long;Ljava/lang/String;)Ltv/danmaku/biliplayerv2/utils/PlayerCloudConfig$DisableInfo;", "equals", "other", "hashCode", "", "toString", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DisableInfo {
        private final Long disableCode;
        private final String disableReason;
        private final boolean isDisable;

        public static /* synthetic */ DisableInfo copy$default(DisableInfo disableInfo, boolean z, Long l, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = disableInfo.isDisable;
            }
            if ((i & 2) != 0) {
                l = disableInfo.disableCode;
            }
            if ((i & 4) != 0) {
                str = disableInfo.disableReason;
            }
            return disableInfo.copy(z, l, str);
        }

        public final boolean component1() {
            return this.isDisable;
        }

        public final Long component2() {
            return this.disableCode;
        }

        public final String component3() {
            return this.disableReason;
        }

        public final DisableInfo copy(boolean z, Long l, String str) {
            return new DisableInfo(z, l, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DisableInfo) {
                DisableInfo disableInfo = (DisableInfo) obj;
                return this.isDisable == disableInfo.isDisable && Intrinsics.areEqual(this.disableCode, disableInfo.disableCode) && Intrinsics.areEqual(this.disableReason, disableInfo.disableReason);
            }
            return false;
        }

        public int hashCode() {
            return (((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isDisable) * 31) + (this.disableCode == null ? 0 : this.disableCode.hashCode())) * 31) + (this.disableReason != null ? this.disableReason.hashCode() : 0);
        }

        public String toString() {
            boolean z = this.isDisable;
            Long l = this.disableCode;
            return "DisableInfo(isDisable=" + z + ", disableCode=" + l + ", disableReason=" + this.disableReason + ")";
        }

        public DisableInfo(boolean isDisable, Long disableCode, String disableReason) {
            this.isDisable = isDisable;
            this.disableCode = disableCode;
            this.disableReason = disableReason;
        }

        public final boolean isDisable() {
            return this.isDisable;
        }

        public final Long getDisableCode() {
            return this.disableCode;
        }

        public final String getDisableReason() {
            return this.disableReason;
        }
    }
}