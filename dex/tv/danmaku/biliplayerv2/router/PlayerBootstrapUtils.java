package tv.danmaku.biliplayerv2.router;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import bolts.Continuation;
import bolts.Task;
import com.bapis.bilibili.app.distribution.BoolValue;
import com.bapis.bilibili.app.distribution.setting.play.PlayConfig;
import com.bapis.bilibili.app.show.mixture.v1.ClarityReply;
import com.bapis.bilibili.community.service.dm.v1.DanmuPlayerConfig;
import com.bapis.bilibili.community.service.dm.v1.DanmuPlayerViewConfig;
import com.bapis.bilibili.community.service.dm.v1.DmViewReply;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.ProcessUtils;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.SharedPrefX;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.device.settings.generated.api.DistributionSettings;
import com.bilibili.lib.foundation.Foundation;
import com.bilibili.lib.media.util.PlayerCloudSetting;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.tribe.core.api.DynamicBundleInfo;
import com.bilibili.lib.tribe.runtime.TribeApi;
import com.bilibili.lib.ui.helper.FloatWindowPermissionHelper;
import com.bilibili.moduleservice.list.IPegasusInlineConfig;
import com.bilibili.moduleservice.list.IPegasusStyleService;
import com.bilibili.moduleservice.list.PegasusInlineSwitchState;
import com.bilibili.moduleservice.player.MiniPlayerAutoPlaySetting;
import com.bilibili.pegasus.InlineDefaultVolumeSettingService;
import com.bilibili.pegasus.PegasusVideoMode;
import com.bilibili.pegasus.PegasusVideoModeService;
import com.bilibili.tribe.extra.BundleCallback;
import com.bilibili.tribe.extra.TribeHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kntr.base.localization.Locale;
import kntr.base.localization.Localization;
import kntr.base.localization.Translation;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.playerimpl.IBiliPlayerImplService;
import tv.danmaku.biliplayerv2.service.business.ShutOffTimingService;
import tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.helper.InteractExtensionKt;
import tv.danmaku.biliplayerv2.service.interact.log.DanmakuLogger;
import tv.danmaku.biliplayerv2.service.kvo.PlayerKVOService;
import tv.danmaku.biliplayerv2.service.resolve.danmaku.DanmakuRpcWrapper;
import tv.danmaku.biliplayerv2.service.setting.DanmakuKeys;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.service.setting.Player;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkJNILibManager;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.player.plugin.mod.IjkX86Helper;
import tv.danmaku.videoplayer.coreV2.ABRManagerKt;
import video.biz.offline.list.logic.tree.VideoFile;

/* compiled from: PlayerBootstrapUtils.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0082@¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\f\u0010 \u001a\u00020\u0005*\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ltv/danmaku/biliplayerv2/router/PlayerBootstrapUtils;", "", "<init>", "()V", "TAG", "", "PLAYER_SWITCH_STATES_EVENT", "PLAYER_PARAMETERS_STATE_EVENT", "PREF_KEY_FLOAT_WINDOW_SIZE", "STORY_PLAY_MODE", "PREF_KEY_RESET_AUTO", "DEFAULT_SIZE_SECTION", "", "bootInProcess", "", "context", "Landroid/content/Context;", "processName", "launchWithUI", "launchWithWorker", "startupIjkService", "initOnlineParams", "initAbrParamsPrefer", "setUserQn", "uniformQualitySetting", "getClarity", "Lcom/bapis/bilibili/app/show/mixture/v1/ClarityReply;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportPlayerSettings", "reportParameterState", "requestDefaultDanmakuConfig", "preloadPlayerServices", "toIntStr", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerBootstrapUtils {
    private static final int DEFAULT_SIZE_SECTION = 1;
    public static final PlayerBootstrapUtils INSTANCE = new PlayerBootstrapUtils();
    private static final String PLAYER_PARAMETERS_STATE_EVENT = "player.parameters.state.sys";
    private static final String PLAYER_SWITCH_STATES_EVENT = "player.switchStates.0.other";
    private static final String PREF_KEY_FLOAT_WINDOW_SIZE = "float_window_size";
    private static final String PREF_KEY_RESET_AUTO = "pref_player_quality_has_reset_auto";
    private static final String STORY_PLAY_MODE = "story_play_mode";
    private static final String TAG = "PlayerBootstrapUtils";

    /* compiled from: PlayerBootstrapUtils.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PegasusInlineSwitchState.values().length];
            try {
                iArr[PegasusInlineSwitchState.ALL_NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PegasusInlineSwitchState.WIFI_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PegasusInlineSwitchState.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PlayerBootstrapUtils() {
    }

    public final void bootInProcess(Context context, String processName) {
        Context playerContext;
        Intrinsics.checkNotNullParameter(context, "context");
        BLog.i(TAG, "init bootInProcess " + (processName == null ? IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN : processName));
        if (ProcessUtils.isMainProcess()) {
            BLog.i(TAG, "init bootInProcess main");
            Application application = BiliContext.application();
            if (application == null || (playerContext = application.getApplicationContext()) == null) {
                playerContext = context;
            }
            startupIjkService(playerContext);
            initOnlineParams();
            initAbrParamsPrefer();
            uniformQualitySetting();
        }
        if (ProcessUtils.isDownloadProcess()) {
            BLog.i(TAG, "init bootInProcess download");
            initOnlineParams();
        }
    }

    public final void launchWithUI(Context context, String processName) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (ProcessUtils.isMainProcess()) {
            BLog.i(TAG, "init launchWithUI");
            reportPlayerSettings();
            reportParameterState();
            requestDefaultDanmakuConfig();
        }
    }

    public final void launchWithWorker(Context context, String processName) {
        Intrinsics.checkNotNullParameter(context, "context");
        BLog.i(TAG, "init BiliRenderContext");
        BiliRenderContext.init(context);
        preloadPlayerServices();
    }

    private final void startupIjkService(final Context context) {
        BLog.i(TAG, "start up ijk service");
        Task.callInBackground(new Callable() { // from class: tv.danmaku.biliplayerv2.router.PlayerBootstrapUtils$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean startupIjkService$lambda$0;
                startupIjkService$lambda$0 = PlayerBootstrapUtils.startupIjkService$lambda$0();
                return startupIjkService$lambda$0;
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.biliplayerv2.router.PlayerBootstrapUtils$$ExternalSyntheticLambda3
            public final Object then(Task task) {
                Unit startupIjkService$lambda$1;
                startupIjkService$lambda$1 = PlayerBootstrapUtils.startupIjkService$lambda$1(context, task);
                return startupIjkService$lambda$1;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean startupIjkService$lambda$0() {
        return Boolean.valueOf(!IjkX86Helper.isX86Device());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startupIjkService$lambda$1(Context $context, Task task) {
        boolean z = false;
        if (task != null && task.isCompleted()) {
            z = true;
        }
        if (z && ((Boolean) task.getResult()).booleanValue()) {
            TribeHelper.INSTANCE.getAndInstall("ijklibsv2download", new BundleCallback() { // from class: tv.danmaku.biliplayerv2.router.PlayerBootstrapUtils$startupIjkService$2$1
                public void onSuccess() {
                    boolean enable_ffmpeg_v2 = DeviceDecision.INSTANCE.getBoolean("ijkplayer.enable_ffmpeg_v2", false);
                    DynamicBundleInfo dynamicBundleInfo = TribeApi.INSTANCE.get("ijklibsv2download");
                    Intrinsics.checkNotNull(dynamicBundleInfo, "null cannot be cast to non-null type com.bilibili.lib.tribe.core.api.DynamicBundleInfo");
                    File lib_dir = dynamicBundleInfo.getLibDir();
                    BLog.i("PlayerBootstrapUtils", "enable_ffmpeg_v2:" + enable_ffmpeg_v2 + "  bundle:" + lib_dir.getPath());
                    File[] listFiles = lib_dir.listFiles();
                    if (listFiles != null) {
                        int length = listFiles.length;
                        for (int i = 0; i < length; i++) {
                            BLog.i("PlayerBootstrapUtils", "ijklibsv2download lib_dir shared file:" + listFiles[i].getName());
                        }
                    }
                    IjkJNILibManager.getInstance().init(enable_ffmpeg_v2, lib_dir);
                }

                public void onError(Throwable t) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    BLog.e("PlayerBootstrapUtils", "load ijklibsv2download error! " + t.getMessage());
                }

                public void onProgress(long totalBytes, long downloadedBytes, int progress, long bytesPerSecond) {
                    BundleCallback.DefaultImpls.onProgress(this, totalBytes, downloadedBytes, progress, bytesPerSecond);
                }
            });
            IjkMediaPlayer.startIjkServer(null, $context);
        }
        return Unit.INSTANCE;
    }

    private final void initOnlineParams() {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.biliplayerv2.router.PlayerBootstrapUtils$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit initOnlineParams$lambda$0;
                initOnlineParams$lambda$0 = PlayerBootstrapUtils.initOnlineParams$lambda$0();
                return initOnlineParams$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initOnlineParams$lambda$0() {
        if (ConfigManager.Companion.isHitFF("player.quality_setting_new")) {
            BLog.i(TAG, "initOnlineParams");
            ABRManagerKt.initOnlineParamsCallback();
        }
        return Unit.INSTANCE;
    }

    private final void initAbrParamsPrefer() {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.biliplayerv2.router.PlayerBootstrapUtils$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit initAbrParamsPrefer$lambda$0;
                initAbrParamsPrefer$lambda$0 = PlayerBootstrapUtils.initAbrParamsPrefer$lambda$0();
                return initAbrParamsPrefer$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initAbrParamsPrefer$lambda$0() {
        int preferMode = IPlayerSettingService.Companion.getInt("story_quality_mode", 1);
        BLog.i(TAG, "init prefer mode: " + preferMode);
        ABRManagerKt.setUserPlayPrefer(preferMode);
        INSTANCE.setUserQn();
        final BiliAccounts accounts = BiliAccounts.get(Foundation.Companion.instance().getApp().getApplicationContext());
        accounts.subscribe(Topic.ACCOUNT_INFO_UPDATE, new PassportObserver() { // from class: tv.danmaku.biliplayerv2.router.PlayerBootstrapUtils$initAbrParamsPrefer$1$1
            public void onChange(Topic topic) {
                accounts.unsubscribe(Topic.ACCOUNT_INFO_UPDATE, this);
                PlayerBootstrapUtils.INSTANCE.setUserQn();
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUserQn() {
        int qn;
        boolean isAuto = IPlayerSettingService.Companion.getBoolean(Player.KEY_PLAY_QUALITY_AUTO_SWITCH, false);
        if (isAuto) {
            ABRManagerKt.setUserQn(0);
            return;
        }
        int userQn = IPlayerSettingService.Companion.getInt(Player.KEY_PLAY_QUALITY_USER_SETTING, 0);
        boolean vip = BiliAccountInfo.Companion.get().isEffectiveVip();
        BLog.i(TAG, "setUserQn onStart: is " + userQn + " " + vip);
        if (vip) {
            qn = userQn;
        } else {
            qn = Math.min(userQn, 80);
        }
        ABRManagerKt.setUserQn(qn);
    }

    private final void uniformQualitySetting() {
        boolean isStoryAutoClarity = false;
        if (DeviceDecision.INSTANCE.getBoolean("ff_player_reset_auto", false) && !IPlayerSettingService.Companion.getBoolean(PREF_KEY_RESET_AUTO, false)) {
            IPlayerSettingService.Companion.putBoolean(Player.KEY_QUALITY_USER_SETTING_UNIFORM, true);
            IPlayerSettingService.Companion.putBoolean(PREF_KEY_RESET_AUTO, true);
            IPlayerSettingService.Companion.putBoolean(Player.KEY_PLAY_QUALITY_AUTO_SWITCH, true);
            BLog.i(TAG, "hit reset auto");
        } else if (!IPlayerSettingService.Companion.getBoolean(Player.KEY_QUALITY_USER_SETTING_UNIFORM, false)) {
            int userClarity = IPlayerSettingService.Companion.getInt(Player.KEY_PLAY_QUALITY_USER_SETTING, 0);
            boolean isAutoClarity = IPlayerSettingService.Companion.getBoolean(Player.KEY_PLAY_QUALITY_AUTO_SWITCH, true) || userClarity == 0;
            int storyUserClarity = IPlayerSettingService.Companion.getInt(Player.KEY_STORY_PLAY_QUALITY_USER_SETTING, 0);
            if (IPlayerSettingService.Companion.getBoolean(Player.KEY_STORY_PLAY_QUALITY_AUTO_SWITCH, true) || storyUserClarity == 0) {
                isStoryAutoClarity = true;
            }
            if ((isAutoClarity && isStoryAutoClarity) || (!isAutoClarity && !isStoryAutoClarity && userClarity == storyUserClarity)) {
                IPlayerSettingService.Companion.putBoolean(Player.KEY_QUALITY_USER_SETTING_UNIFORM, true);
                BLog.i(TAG, "user has same quality， uniform quality setting");
                return;
            }
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new PlayerBootstrapUtils$uniformQualitySetting$1(isAutoClarity, userClarity, isStoryAutoClarity, storyUserClarity, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getClarity(kotlin.coroutines.Continuation<? super ClarityReply> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PlayerBootstrapUtils$getClarity$2(null), continuation);
    }

    private final void reportPlayerSettings() {
        String str;
        if (BiliAccounts.get(BiliContext.application()).isLogin()) {
            HashMap params = new HashMap();
            params.put("background_play_switch", toIntStr(PlayerCloudSetting.INSTANCE.getSettingBooleanValue(PlayerCloudSetting.Setting.BackgroundPlay)));
            HashMap hashMap = params;
            String autoMiniPlay = "0";
            switch (IPlayerSettingService.Companion.getInt(Player.KEY_PLAY_COMPLETED_ACTION, 0)) {
                case 0:
                    str = "1";
                    break;
                case 1:
                    str = "4";
                    break;
                case 2:
                    str = "3";
                    break;
                case 3:
                default:
                    str = "0";
                    break;
                case 4:
                    str = "2";
                    break;
            }
            hashMap.put("playing_type", str);
            params.put("full_view_switch", toIntStr(PlayerCloudSetting.INSTANCE.getSettingBooleanValue(PlayerCloudSetting.Setting.WholeScreen)));
            params.put("dolby_switch", toIntStr(PlayerCloudSetting.INSTANCE.getSettingBooleanValue(PlayerCloudSetting.Setting.DolbyAudio)));
            params.put("hires_switch", toIntStr(PlayerCloudSetting.INSTANCE.getSettingBooleanValue(PlayerCloudSetting.Setting.HiRes)));
            int userClarity = IPlayerSettingService.Companion.getInt(Player.KEY_PLAY_QUALITY_USER_SETTING, 0);
            boolean isAutoClarity = IPlayerSettingService.Companion.getBoolean(Player.KEY_PLAY_QUALITY_AUTO_SWITCH, false) || userClarity == 0;
            params.put("is_auto_clarity", toIntStr(isAutoClarity));
            params.put("autoplay_mobile_network", toIntStr(IPlayerSettingService.Companion.getBoolean(Player.KEY_AUTO_PLAY_MOBILE_NETWORK, true)));
            params.put("player_clarity", isAutoClarity ? "" : String.valueOf(userClarity));
            Object obj = BLRouter.get$default(BLRouter.INSTANCE, DistributionSettings.class, (String) null, 2, (Object) null);
            Intrinsics.checkNotNull(obj);
            DistributionSettings distributionPlayConfig = (DistributionSettings) obj;
            params.put("detail_autoplay_switch", toIntStr(distributionPlayConfig.getPlayConfig().hasShouldAutoPlay() ? distributionPlayConfig.getPlayConfig().getShouldAutoPlay().getValue() : true));
            params.put("auto_fullscreen_switch", toIntStr(distributionPlayConfig.getPlayConfig().hasShouldAutoFullScreen() ? distributionPlayConfig.getPlayConfig().getShouldAutoFullScreen().getValue() : false));
            params.put("fingers_rotate_switch", toIntStr(IPlayerSettingService.Companion.getBoolean(Player.KEY_ENABLE_DOUBLE_FINGER_RESIZE, true)));
            params.put("https_play_switch", toIntStr(distributionPlayConfig.getPlayConfig().hasEnablePlayurlHTTPS() ? distributionPlayConfig.getPlayConfig().getEnablePlayurlHTTPS().getValue() : false));
            HashMap hashMap2 = params;
            Application it = BiliContext.application();
            hashMap2.put("miniplayer_size", String.valueOf((it != null ? BiliGlobalPreferenceHelper.getInstance(it).optInteger(PREF_KEY_FLOAT_WINDOW_SIZE, 1) : 1) + 1));
            int storyPlayMode = IPlayerSettingService.Companion.getInt(STORY_PLAY_MODE, 0);
            params.put("story_playing_type", storyPlayMode != 0 ? "1" : "3");
            String floatPermission = FloatWindowPermissionHelper.checkFloatWindowPermission() ? "1" : "0";
            MiniPlayerAutoPlaySetting miniPlayerAutoPlaySetting = (MiniPlayerAutoPlaySetting) BLRouter.get$default(BLRouter.INSTANCE, MiniPlayerAutoPlaySetting.class, (String) null, 2, (Object) null);
            if (miniPlayerAutoPlaySetting != null && miniPlayerAutoPlaySetting.getSpEnableAutoMiniPlay()) {
                autoMiniPlay = "1";
            }
            params.put("auto_pip", autoMiniPlay);
            params.put("display_over_apps", floatPermission);
            Iterable entrySet = params.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
            Iterable $this$map$iv = entrySet;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Map.Entry it2 = (Map.Entry) item$iv$iv;
                destination$iv$iv.add(it2.getKey() + ":" + it2.getValue() + VideoFile.TREE_END);
                userClarity = userClarity;
                isAutoClarity = isAutoClarity;
            }
            BLog.d(TAG, "start report player settings " + CollectionsKt.joinToString$default((List) destination$iv$iv, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.biliplayerv2.router.PlayerBootstrapUtils$$ExternalSyntheticLambda6
                public final Object invoke(Object obj2) {
                    CharSequence reportPlayerSettings$lambda$2;
                    reportPlayerSettings$lambda$2 = PlayerBootstrapUtils.reportPlayerSettings$lambda$2((String) obj2);
                    return reportPlayerSettings$lambda$2;
                }
            }, 31, (Object) null));
            Neurons.report$default(false, 0, PLAYER_SWITCH_STATES_EVENT, params, (String) null, 0, 48, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence reportPlayerSettings$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void reportParameterState() {
        boolean autoVolumeState;
        boolean z;
        long volumeBalanceMode;
        boolean danmakuShieldSwitch;
        Object obj;
        Object obj2;
        String str;
        PegasusInlineSwitchState indexPageAutoPlayStatus;
        boolean isSingleColumnStyle;
        String str2;
        Object obj3;
        PlayConfig playConfig;
        BoolValue landscapeAutoStory;
        PlayConfig playConfig2;
        BoolValue shouldAutoStory;
        PegasusVideoMode videoMode;
        PlayConfig playConfig3;
        PlayConfig playConfig4;
        Context applicationContext;
        HashMap params = new HashMap();
        DistributionSettings distributionPlayConfig = (DistributionSettings) BLRouter.get$default(BLRouter.INSTANCE, DistributionSettings.class, (String) null, 2, (Object) null);
        MiniPlayerAutoPlaySetting miniPlayerAutoPlaySetting = (MiniPlayerAutoPlaySetting) BLRouter.get$default(BLRouter.INSTANCE, MiniPlayerAutoPlaySetting.class, (String) null, 2, (Object) null);
        SharedPreferences globalPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
        Application application = BiliContext.application();
        SharedPrefX playerPreference = (application == null || (applicationContext = application.getApplicationContext()) == null) ? null : BLKV.getBLSharedPreferences(applicationContext, "biliplayer", false, 0);
        boolean z2 = true;
        if ((distributionPlayConfig == null || (playConfig4 = distributionPlayConfig.getPlayConfig()) == null || !playConfig4.hasVolumeBalance()) ? false : true) {
            autoVolumeState = distributionPlayConfig.getPlayConfig().getVolumeBalance().getValue();
        } else {
            autoVolumeState = false;
        }
        if (globalPreference != null) {
            z = globalPreference.getBoolean("pref_player_background_auto_play_ai", true);
        } else {
            z = true;
        }
        String backgroundAutoFromAIState = toIntStr(z);
        params.put("backstage_continuous_state", backgroundAutoFromAIState);
        params.put("autovolume_state", toIntStr(autoVolumeState));
        if (autoVolumeState) {
            if ((distributionPlayConfig == null || (playConfig3 = distributionPlayConfig.getPlayConfig()) == null || !playConfig3.hasVolumeBalanceMode()) ? false : true) {
                volumeBalanceMode = distributionPlayConfig.getPlayConfig().getVolumeBalanceMode().getValue();
                params.put("autovolume_state_2", String.valueOf(volumeBalanceMode));
                HashMap hashMap = params;
                PegasusVideoModeService pegasusVideoModeService = (PegasusVideoModeService) BLRouter.get$default(BLRouter.INSTANCE, PegasusVideoModeService.class, (String) null, 2, (Object) null);
                hashMap.put("tm_card_play_state", String.valueOf((pegasusVideoModeService != null || (videoMode = pegasusVideoModeService.getVideoMode()) == null) ? -1 : videoMode.getValue()));
                if (globalPreference == null) {
                    danmakuShieldSwitch = globalPreference.getBoolean("danmaku_shield_switch", true);
                } else {
                    danmakuShieldSwitch = true;
                }
                params.put("selected_dm_state", !danmakuShieldSwitch ? "1" : "0");
                HashMap hashMap2 = params;
                if ((distributionPlayConfig != null || (playConfig2 = distributionPlayConfig.getPlayConfig()) == null || (shouldAutoStory = playConfig2.getShouldAutoStory()) == null || shouldAutoStory.getValue()) ? false : true) {
                    obj = "1";
                } else {
                    obj = "0";
                }
                hashMap2.put("fullscreen_story_state", obj);
                if (playerPreference == null && playerPreference.getBoolean(Player.PREF_SHOW_AUTO_LANDSCAPE_STORY_SWITCH, false)) {
                    HashMap hashMap3 = params;
                    if (!((distributionPlayConfig == null || (playConfig = distributionPlayConfig.getPlayConfig()) == null || (landscapeAutoStory = playConfig.getLandscapeAutoStory()) == null || landscapeAutoStory.getValue()) ? false : true)) {
                        obj3 = "1";
                    } else {
                        obj3 = "0";
                    }
                    hashMap3.put("fullscreen_story_state_2", obj3);
                }
                params.put("inside_auto_miniplayer", !((miniPlayerAutoPlaySetting == null && miniPlayerAutoPlaySetting.getSpEnableInnerAutoMiniPlay()) ? false : false) ? "1" : "0");
                HashMap hashMap4 = params;
                if (miniPlayerAutoPlaySetting == null && miniPlayerAutoPlaySetting.getSpEnableAutoMiniPlay()) {
                    obj2 = "1";
                } else {
                    obj2 = "0";
                }
                hashMap4.put("auto_pip", obj2);
                HashMap hashMap5 = params;
                String str3 = "3";
                switch (IPlayerSettingService.Companion.getInt(Player.KEY_PLAY_COMPLETED_ACTION, 0)) {
                    case 0:
                        str = "1";
                        break;
                    case 1:
                        str = "4";
                        break;
                    case 2:
                        str = "3";
                        break;
                    case 3:
                    default:
                        str = "0";
                        break;
                    case 4:
                        str = "2";
                        break;
                }
                hashMap5.put("playing_type_state", str);
                IPegasusInlineConfig iPegasusInlineConfig = (IPegasusInlineConfig) BLRouter.get$default(BLRouter.INSTANCE, IPegasusInlineConfig.class, (String) null, 2, (Object) null);
                indexPageAutoPlayStatus = iPegasusInlineConfig == null ? iPegasusInlineConfig.getCurrentState() : null;
                IPegasusStyleService iPegasusStyleService = (IPegasusStyleService) BLRouter.get$default(BLRouter.INSTANCE, IPegasusStyleService.class, (String) null, 2, (Object) null);
                isSingleColumnStyle = iPegasusStyleService == null ? iPegasusStyleService.isSingleColumnStyle() : false;
                IPegasusStyleService iPegasusStyleService2 = (IPegasusStyleService) BLRouter.get$default(BLRouter.INSTANCE, IPegasusStyleService.class, (String) null, 2, (Object) null);
                boolean isDoubleColumnStyle = iPegasusStyleService2 == null ? iPegasusStyleService2.isDoubleColumnStyle() : false;
                HashMap hashMap6 = params;
                switch (indexPageAutoPlayStatus != null ? -1 : WhenMappings.$EnumSwitchMapping$0[indexPageAutoPlayStatus.ordinal()]) {
                    case 1:
                        str3 = "1";
                        break;
                    case 2:
                        str3 = "2";
                        break;
                    case 3:
                        break;
                    default:
                        str3 = "0";
                        break;
                }
                hashMap6.put("autoplay_state", str3);
                HashMap hashMap7 = params;
                if (isSingleColumnStyle) {
                    str2 = isDoubleColumnStyle ? "1" : "0";
                } else {
                    str2 = "2";
                }
                hashMap7.put("single_double_state", str2);
                InlineDefaultVolumeSettingService inlineDefaultVolumeSettingService = (InlineDefaultVolumeSettingService) BLRouter.get$default(BLRouter.INSTANCE, InlineDefaultVolumeSettingService.class, (String) null, 2, (Object) null);
                boolean volumeOn = inlineDefaultVolumeSettingService == null ? inlineDefaultVolumeSettingService.getVolumeOn() : false;
                params.put("tm_volume_status", !volumeOn ? "1" : "2");
                params.put("system_language_identifer", Localization.INSTANCE.getSYSTEM().toString());
                params.put("app_language_identifer", ((Locale) Localization.INSTANCE.getLocaleFlow().getValue()).toString());
                params.put("always_translate_switch", ((Boolean) Translation.INSTANCE.getAlwaysTranslateFlow().getValue()).booleanValue() ? "1" : "0");
                Neurons.report$default(false, 4, PLAYER_PARAMETERS_STATE_EVENT, params, (String) null, 0, 48, (Object) null);
            }
        }
        volumeBalanceMode = 0;
        params.put("autovolume_state_2", String.valueOf(volumeBalanceMode));
        HashMap hashMap8 = params;
        PegasusVideoModeService pegasusVideoModeService2 = (PegasusVideoModeService) BLRouter.get$default(BLRouter.INSTANCE, PegasusVideoModeService.class, (String) null, 2, (Object) null);
        hashMap8.put("tm_card_play_state", String.valueOf((pegasusVideoModeService2 != null || (videoMode = pegasusVideoModeService2.getVideoMode()) == null) ? -1 : videoMode.getValue()));
        if (globalPreference == null) {
        }
        params.put("selected_dm_state", !danmakuShieldSwitch ? "1" : "0");
        HashMap hashMap22 = params;
        if ((distributionPlayConfig != null || (playConfig2 = distributionPlayConfig.getPlayConfig()) == null || (shouldAutoStory = playConfig2.getShouldAutoStory()) == null || shouldAutoStory.getValue()) ? false : true) {
        }
        hashMap22.put("fullscreen_story_state", obj);
        if (playerPreference == null && playerPreference.getBoolean(Player.PREF_SHOW_AUTO_LANDSCAPE_STORY_SWITCH, false)) {
        }
        params.put("inside_auto_miniplayer", !((miniPlayerAutoPlaySetting == null && miniPlayerAutoPlaySetting.getSpEnableInnerAutoMiniPlay()) ? false : false) ? "1" : "0");
        HashMap hashMap42 = params;
        if (miniPlayerAutoPlaySetting == null) {
        }
        obj2 = "0";
        hashMap42.put("auto_pip", obj2);
        HashMap hashMap52 = params;
        String str32 = "3";
        switch (IPlayerSettingService.Companion.getInt(Player.KEY_PLAY_COMPLETED_ACTION, 0)) {
        }
        hashMap52.put("playing_type_state", str);
        IPegasusInlineConfig iPegasusInlineConfig2 = (IPegasusInlineConfig) BLRouter.get$default(BLRouter.INSTANCE, IPegasusInlineConfig.class, (String) null, 2, (Object) null);
        if (iPegasusInlineConfig2 == null) {
        }
        IPegasusStyleService iPegasusStyleService3 = (IPegasusStyleService) BLRouter.get$default(BLRouter.INSTANCE, IPegasusStyleService.class, (String) null, 2, (Object) null);
        isSingleColumnStyle = iPegasusStyleService3 == null ? iPegasusStyleService3.isSingleColumnStyle() : false;
        IPegasusStyleService iPegasusStyleService22 = (IPegasusStyleService) BLRouter.get$default(BLRouter.INSTANCE, IPegasusStyleService.class, (String) null, 2, (Object) null);
        boolean isDoubleColumnStyle2 = iPegasusStyleService22 == null ? iPegasusStyleService22.isDoubleColumnStyle() : false;
        HashMap hashMap62 = params;
        switch (indexPageAutoPlayStatus != null ? -1 : WhenMappings.$EnumSwitchMapping$0[indexPageAutoPlayStatus.ordinal()]) {
        }
        hashMap62.put("autoplay_state", str32);
        HashMap hashMap72 = params;
        if (isSingleColumnStyle) {
        }
        hashMap72.put("single_double_state", str2);
        InlineDefaultVolumeSettingService inlineDefaultVolumeSettingService2 = (InlineDefaultVolumeSettingService) BLRouter.get$default(BLRouter.INSTANCE, InlineDefaultVolumeSettingService.class, (String) null, 2, (Object) null);
        if (inlineDefaultVolumeSettingService2 == null) {
        }
        params.put("tm_volume_status", !volumeOn ? "1" : "2");
        params.put("system_language_identifer", Localization.INSTANCE.getSYSTEM().toString());
        params.put("app_language_identifer", ((Locale) Localization.INSTANCE.getLocaleFlow().getValue()).toString());
        params.put("always_translate_switch", ((Boolean) Translation.INSTANCE.getAlwaysTranslateFlow().getValue()).booleanValue() ? "1" : "0");
        Neurons.report$default(false, 4, PLAYER_PARAMETERS_STATE_EVENT, params, (String) null, 0, 48, (Object) null);
    }

    private final void requestDefaultDanmakuConfig() {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.biliplayerv2.router.PlayerBootstrapUtils$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                DmViewReply requestDefaultDanmakuConfig$lambda$0;
                requestDefaultDanmakuConfig$lambda$0 = PlayerBootstrapUtils.requestDefaultDanmakuConfig$lambda$0();
                return requestDefaultDanmakuConfig$lambda$0;
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.biliplayerv2.router.PlayerBootstrapUtils$$ExternalSyntheticLambda1
            public final Object then(Task task) {
                Unit requestDefaultDanmakuConfig$lambda$1;
                requestDefaultDanmakuConfig$lambda$1 = PlayerBootstrapUtils.requestDefaultDanmakuConfig$lambda$1(task);
                return requestDefaultDanmakuConfig$lambda$1;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DmViewReply requestDefaultDanmakuConfig$lambda$0() {
        return DanmakuRpcWrapper.requestDefaultDanmakuView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestDefaultDanmakuConfig$lambda$1(Task task) {
        if (task.isCompleted() && task.getResult() != null) {
            Object result = task.getResult();
            Intrinsics.checkNotNull(result);
            DanmuPlayerViewConfig playerConfig = ((DmViewReply) result).getPlayerConfig();
            if (playerConfig.hasDanmukuPlayerConfig()) {
                DanmuPlayerConfig danmuPlayerConfig = playerConfig.getDanmukuPlayerConfig();
                IPlayerSettingService.Companion.putBoolean(DanmakuKeys.PREF_DANMAKU_SWITCH_SAVE, danmuPlayerConfig.getPlayerDanmakuSwitchSave());
                boolean danmakuSwitch = danmuPlayerConfig.getPlayerDanmakuSwitch();
                IPlayerSettingService.Companion.putBoolean(DanmakuKeys.PREF_DANMAKU_SWITCH, danmakuSwitch);
                boolean inlineDanmakuSwitch = danmuPlayerConfig.getInlinePlayerDanmakuSwitch();
                IPlayerSettingService.Companion.putBoolean(DanmakuKeys.PREF_INLINE_DANMAKU_SWITCH, inlineDanmakuSwitch);
                boolean aiRecommendedSwitch = danmuPlayerConfig.getPlayerDanmakuAiRecommendedSwitch();
                IPlayerSettingService.Companion.putBoolean(DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_SWITCH, aiRecommendedSwitch);
                int aiRecLevel = danmuPlayerConfig.getPlayerDanmakuAiRecommendedLevelV2();
                if (danmuPlayerConfig.getPlayerDanmakuAiRecommendedLevelV2MapMap().containsKey(Integer.valueOf(aiRecLevel))) {
                    IPlayerSettingService.Companion.putInt(DanmakuKeys.PREF_DANMAKU_AI_RECOMMEND_LEVEL_V2, aiRecLevel);
                }
                boolean blockrepeat = danmuPlayerConfig.getPlayerDanmakuBlockrepeat();
                IPlayerSettingService.Companion.putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKREPEAT, blockrepeat);
                boolean blocktop = danmuPlayerConfig.getPlayerDanmakuBlocktop();
                IPlayerSettingService.Companion.putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKTOP, blocktop);
                boolean blockscroll = danmuPlayerConfig.getPlayerDanmakuBlockscroll();
                IPlayerSettingService.Companion.putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKSCROLL, blockscroll);
                boolean blockbottom = danmuPlayerConfig.getPlayerDanmakuBlockbottom();
                IPlayerSettingService.Companion.putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKBOTTOM, blockbottom);
                boolean blockcolorful = danmuPlayerConfig.getPlayerDanmakuBlockcolorful();
                IPlayerSettingService.Companion.putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKCOLORFUL, blockcolorful);
                boolean blockspecial = danmuPlayerConfig.getPlayerDanmakuBlockspecial();
                IPlayerSettingService.Companion.putBoolean(DanmakuKeys.PREF_DANMAKU_BLOCKSPECIAL, blockspecial);
                float opacity = danmuPlayerConfig.getPlayerDanmakuOpacity();
                if (0.2f <= opacity && opacity <= 1.0f) {
                    IPlayerSettingService.Companion.putFloat(DanmakuKeys.PREF_DANMAKU_OPACITY, opacity);
                }
                float scaleFactor = danmuPlayerConfig.getPlayerDanmakuScalingfactor();
                if (0.5f <= scaleFactor && scaleFactor <= 2.0f) {
                    IPlayerSettingService.Companion.putFloat(DanmakuKeys.PREF_DANMAKU_SCALING_FACTOR, scaleFactor);
                }
                float domain = danmuPlayerConfig.getPlayerDanmakuDomain();
                BLog.d(TAG, "danmaku domain from bootstrap, value=" + domain);
                if (0.25f <= domain && domain <= 2.0f) {
                    IPlayerSettingService.Companion.putFloat(DanmakuKeys.PREF_DANMAKU_DOMAIN, domain);
                }
                int speed = danmuPlayerConfig.getPlayerDanmakuSpeed();
                float localSpeed = PlayerKVOService.INSTANCE.translateKVOSpeedToLocal(speed);
                IPlayerSettingService.Companion.putFloat(DanmakuKeys.PREF_DANMAKU_SPEED, PlayerKVOService.INSTANCE.ensureDanmakuSpeed(localSpeed));
                boolean enableblocklist = danmuPlayerConfig.getPlayerDanmakuEnableblocklist();
                IPlayerSettingService.Companion.putBoolean(DanmakuKeys.PREF_DANMAKU_ENABLEBLOCKLIST, enableblocklist);
                DanmakuLogger danmakuLogger = DanmakuLogger.INSTANCE;
                Intrinsics.checkNotNull(danmuPlayerConfig);
                danmakuLogger.logReq("request default dmView success, " + InteractExtensionKt.contentString(danmuPlayerConfig));
            }
        }
        return Unit.INSTANCE;
    }

    private final void preloadPlayerServices() {
        Iterable coreService;
        Class[] preloadList = {ShutOffTimingService.class, InteractLayerService.class};
        try {
            for (Class cls : preloadList) {
                cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            IBiliPlayerImplService implService = (IBiliPlayerImplService) BLRouter.INSTANCE.get(IBiliPlayerImplService.class, "default");
            if (implService == null || (coreService = implService.getCoreService()) == null) {
                return;
            }
            Iterable $this$forEach$iv = coreService;
            for (Object element$iv : $this$forEach$iv) {
                Class it = (Class) element$iv;
                it.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
        } catch (Exception e) {
            BLog.e("preload classes error:" + ExceptionsKt.stackTraceToString(e));
        }
    }

    private final String toIntStr(boolean $this$toIntStr) {
        return $this$toIntStr ? "1" : "0";
    }
}