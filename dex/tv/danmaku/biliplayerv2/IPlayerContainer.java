package tv.danmaku.biliplayerv2;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.panel.BuiltInLayer;
import tv.danmaku.biliplayerv2.panel.IPlayerLayer;
import tv.danmaku.biliplayerv2.panel.VideoInset;
import tv.danmaku.biliplayerv2.playerimpl.IBiliPlayerImplService;
import tv.danmaku.biliplayerv2.profiler.PlayerProfiler;
import tv.danmaku.biliplayerv2.profiler.ProfilerHandler;
import tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService;
import tv.danmaku.biliplayerv2.service.IActivityStateService;
import tv.danmaku.biliplayerv2.service.IControlContainerService;
import tv.danmaku.biliplayerv2.service.IPlayDirectorServiceV3;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IPlayerServiceManager;
import tv.danmaku.biliplayerv2.service.IRenderContainerService;
import tv.danmaku.biliplayerv2.service.IToastService;
import tv.danmaku.biliplayerv2.service.IVideosPlayDirectorService;
import tv.danmaku.biliplayerv2.service.IWithViewPlayerService;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.report.IReporterService;
import tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatService;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.coreV2.MediaPlayContextImpl;

/* compiled from: PlayerContainer.kt */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 i2\u00020\u0001:\u0003ijkJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001eH&J\u001a\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H'J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H'J\b\u0010%\u001a\u00020&H&J\b\u0010'\u001a\u00020(H&J\b\u0010)\u001a\u00020*H&J\b\u0010+\u001a\u00020,H&J\b\u0010-\u001a\u00020.H&J\b\u0010/\u001a\u000200H&J\b\u00101\u001a\u000202H&J\b\u00103\u001a\u000204H&J\b\u00105\u001a\u000206H&J\b\u00107\u001a\u000208H&J\b\u00109\u001a\u00020:H&J\b\u0010;\u001a\u00020<H&J\b\u0010=\u001a\u00020>H&J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020AH&J\b\u0010B\u001a\u00020\u001eH&J\u001a\u0010C\u001a\u00020\u00032\b\b\u0002\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH&J\u001a\u0010H\u001a\u00020\u00032\u0006\u0010D\u001a\u00020E2\b\u0010I\u001a\u0004\u0018\u00010GH&J\u0010\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020LH&J\u0010\u0010M\u001a\u00020\u00032\u0006\u0010K\u001a\u00020LH&J\u0012\u0010N\u001a\u00020\u001e2\b\u0010O\u001a\u0004\u0018\u00010PH&J@\u0010Q\u001a\u00020\u00032\b\u0010R\u001a\u0004\u0018\u00010S2\u0010\b\u0002\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010U2\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010U2\b\b\u0002\u0010X\u001a\u00020\u001eH&J\u001c\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u00102\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030[H&J \u0010Y\u001a\u00020\u00032\n\u0010Z\u001a\u0006\u0012\u0002\b\u00030[2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030[H&J\u0014\u0010\\\u001a\u00020\u00032\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030[H&J\u0018\u0010]\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u001eH&J)\u0010_\u001a\u00020\u00032\u0006\u0010`\u001a\u00020a2\u0012\u0010b\u001a\n\u0012\u0006\b\u0001\u0012\u00020W0c\"\u00020WH&¢\u0006\u0002\u0010dJ\n\u0010e\u001a\u0004\u0018\u00010fH&J\u0010\u0010g\u001a\u00020\u00032\u0006\u0010h\u001a\u00020\u001eH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006lÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/IPlayerContainer;", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "addBuiltInLayer", "layer", "Ltv/danmaku/biliplayerv2/panel/BuiltInLayer;", "service", "Ltv/danmaku/biliplayerv2/service/IWithViewPlayerService;", "removeBuiltInLayer", "onStart", "onResume", "onPause", "onStop", "onDestroyView", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onBackPressed", "", "setProjectionCallback", "businessType", "", "callback", "Ltv/danmaku/biliplayerv2/ProjectionCallback;", "dispatchProjectionCallback", "getFunctionWidgetService", "Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService;", "getVideoPlayDirectorService", "Ltv/danmaku/biliplayerv2/service/IVideosPlayDirectorService;", "getPlayDirectorServiceV3", "Ltv/danmaku/biliplayerv2/service/IPlayDirectorServiceV3;", "getControlContainerService", "Ltv/danmaku/biliplayerv2/service/IControlContainerService;", "getPlayerCoreService", "Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;", "getInteractLayerService", "Ltv/danmaku/biliplayerv2/service/interact/biz/IInteractLayerService;", "getToastService", "Ltv/danmaku/biliplayerv2/service/IToastService;", "getRenderContainerService", "Ltv/danmaku/biliplayerv2/service/IRenderContainerService;", "getHeartbeatService", "Ltv/danmaku/biliplayerv2/service/report/heartbeat/IHeartbeatService;", "getPlayerServiceManager", "Ltv/danmaku/biliplayerv2/service/IPlayerServiceManager;", "getPlayerSettingService", "Ltv/danmaku/biliplayerv2/service/setting/IPlayerSettingService;", "getReporterService", "Ltv/danmaku/biliplayerv2/service/report/IReporterService;", "getActivityStateService", "Ltv/danmaku/biliplayerv2/service/IActivityStateService;", "dispatchVideoInsetChanged", "inset", "Ltv/danmaku/biliplayerv2/panel/VideoInset;", "changeOrientationEnable", "collectShareParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "sharingBundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "attachByShared", "bundle", "addOnKeyListener", "listener", "Landroid/view/View$OnKeyListener;", "removeOnKeyListener", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "updateViewPort", "viewPort", "Landroid/graphics/Rect;", "builtInLayers", "", "customerLayers", "", "immediately", "addPlayerLayer", "over", "Ltv/danmaku/biliplayerv2/panel/IPlayerLayer;", "removePlayerLayer", "setBuiltInLayerVisibility", "visibility", "setProfilerHandler", "handler", "Ltv/danmaku/biliplayerv2/profiler/ProfilerHandler;", "scopes", "", "(Ltv/danmaku/biliplayerv2/profiler/ProfilerHandler;[Ljava/lang/String;)V", "getPlayerProfiler", "Ltv/danmaku/biliplayerv2/profiler/PlayerProfiler;", "setHeartBeatEnable", "enable", "Companion", "SharedRecord", "Builder", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IPlayerContainer {
    public static final Companion Companion = Companion.$$INSTANCE;

    void addBuiltInLayer(BuiltInLayer builtInLayer, IWithViewPlayerService iWithViewPlayerService);

    void addOnKeyListener(View.OnKeyListener onKeyListener);

    void addPlayerLayer(BuiltInLayer builtInLayer, IPlayerLayer<?> iPlayerLayer);

    void addPlayerLayer(IPlayerLayer<?> iPlayerLayer, IPlayerLayer<?> iPlayerLayer2);

    void attachByShared(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle);

    boolean changeOrientationEnable();

    void collectShareParams(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle);

    boolean dispatchKeyEvent(KeyEvent keyEvent);

    @Deprecated(message = "use [PlayerSettingsWidgetActionDelegate] instead")
    void dispatchProjectionCallback(int i);

    void dispatchVideoInsetChanged(VideoInset videoInset);

    IActivityStateService getActivityStateService();

    IControlContainerService getControlContainerService();

    AbsFunctionWidgetService getFunctionWidgetService();

    IHeartbeatService getHeartbeatService();

    IInteractLayerService getInteractLayerService();

    IPlayDirectorServiceV3 getPlayDirectorServiceV3();

    IPlayerCoreService getPlayerCoreService();

    PlayerProfiler getPlayerProfiler();

    IPlayerServiceManager getPlayerServiceManager();

    IPlayerSettingService getPlayerSettingService();

    IRenderContainerService getRenderContainerService();

    IReporterService getReporterService();

    IToastService getToastService();

    IVideosPlayDirectorService getVideoPlayDirectorService();

    boolean onBackPressed();

    void onConfigurationChanged(Configuration configuration);

    void onCreate(Bundle bundle);

    View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    void onDestroy();

    void onDestroyView();

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void onViewCreated(View view2, Bundle bundle);

    void removeBuiltInLayer(BuiltInLayer builtInLayer);

    void removeOnKeyListener(View.OnKeyListener onKeyListener);

    void removePlayerLayer(IPlayerLayer<?> iPlayerLayer);

    void setBuiltInLayerVisibility(BuiltInLayer builtInLayer, boolean z);

    void setHeartBeatEnable(boolean z);

    void setProfilerHandler(ProfilerHandler profilerHandler, String... strArr);

    @Deprecated(message = "use [PlayerSettingsWidgetActionDelegate] instead")
    void setProjectionCallback(int i, ProjectionCallback projectionCallback);

    void updateViewPort(Rect rect, List<? extends BuiltInLayer> list, List<String> list2, boolean z);

    /* compiled from: PlayerContainer.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ3\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fJI\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/biliplayerv2/IPlayerContainer$Companion;", "", "<init>", "()V", "sPlayerSharedRecord", "Landroidx/collection/SparseArrayCompat;", "Ltv/danmaku/biliplayerv2/IPlayerContainer$SharedRecord;", "prepareForShare", "", "playerContainer", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "interceptor", "Lkotlin/Function1;", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "retrieveSharedRecord", "id", "forceDestroyShareRecord", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final SparseArrayCompat<SharedRecord> sPlayerSharedRecord = new SparseArrayCompat<>(0, 1, (DefaultConstructorMarker) null);

        /* compiled from: PlayerContainer.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PlayerSharingType.values().length];
                try {
                    iArr[PlayerSharingType.NORMAL.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[PlayerSharingType.PLAYER_CORE.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public final int prepareForShare(IPlayerContainer playerContainer) {
            Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
            return prepareForShare(PlayerSharingType.NORMAL, playerContainer, null, null);
        }

        public final int prepareForShare(IPlayerContainer playerContainer, Function1<? super PlayerSharingBundle, Unit> function1) {
            Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
            return prepareForShare(PlayerSharingType.NORMAL, playerContainer, null, function1);
        }

        public static /* synthetic */ int prepareForShare$default(Companion companion, PlayerSharingType playerSharingType, IPlayerContainer iPlayerContainer, PlayerSharingBundle playerSharingBundle, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                playerSharingType = PlayerSharingType.NORMAL;
            }
            if ((i & 4) != 0) {
                playerSharingBundle = null;
            }
            return companion.prepareForShare(playerSharingType, iPlayerContainer, playerSharingBundle, function1);
        }

        public final int prepareForShare(PlayerSharingType sharingType, IPlayerContainer playerContainer, PlayerSharingBundle bundle, Function1<? super PlayerSharingBundle, Unit> function1) {
            Video.DisplayParams displayParams;
            Video.DisplayParams displayParams2;
            Intrinsics.checkNotNullParameter(sharingType, "sharingType");
            Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
            IPlayerCoreService playerCoreService = playerContainer.getPlayerCoreService();
            int currentPlayState = playerCoreService.getState();
            PlayerLog.i("IPlayerContainer", "prepare for share");
            int id = playerContainer.hashCode();
            if (sPlayerSharedRecord.containsKey(id)) {
                PlayerLog.e("IPlayerContainer", "something error, this playerContainer@" + playerContainer + " has been shared");
                return id;
            } else if (currentPlayState != 4 && currentPlayState != 5 && currentPlayState != 6) {
                PlayerLog.i("IPlayerContainer", "prepare for share failed");
                return -1;
            } else {
                long avid = 0;
                switch (WhenMappings.$EnumSwitchMapping$0[sharingType.ordinal()]) {
                    case 1:
                        PlayerSharingBundle sharingBundle = bundle == null ? new PlayerSharingBundle() : bundle;
                        playerContainer.collectShareParams(PlayerSharingType.NORMAL, sharingBundle);
                        boolean sharedContext = sharingBundle.sharedObject("key_share_media_context");
                        if (!sharedContext) {
                            BLog.e(PlayerContainerKt.TAG, "No media playcontext, share failed!!");
                            return -1;
                        }
                        Video.PlayableParams playableParams = PlayerContainerKt.getPlayDirector(playerContainer).getCurrentPlayableParams();
                        if (playableParams != null && (displayParams = playableParams.getDisplayParams()) != null) {
                            avid = displayParams.getAvid();
                        }
                        if (function1 != null) {
                            function1.invoke(sharingBundle);
                        }
                        int fromAutoPlay = playableParams != null ? playableParams.getFromAutoPlay() : 0;
                        sharingBundle.getBundle().putInt("from_auto_play", fromAutoPlay);
                        sPlayerSharedRecord.append(id, new SharedRecord(avid, sharingBundle));
                        PlayerLog.i("IPlayerContainer", "prepare for share success");
                        return id;
                    case 2:
                        PlayerSharingBundle sharingBundle2 = bundle == null ? new PlayerSharingBundle() : bundle;
                        playerContainer.collectShareParams(PlayerSharingType.PLAYER_CORE, sharingBundle2);
                        boolean sharedPlayer = sharingBundle2.sharedObject("key_share_player_core");
                        if (sharedPlayer) {
                            Video.PlayableParams currentPlayableParams = PlayerContainerKt.getPlayDirector(playerContainer).getCurrentPlayableParams();
                            if (currentPlayableParams != null && (displayParams2 = currentPlayableParams.getDisplayParams()) != null) {
                                avid = displayParams2.getAvid();
                            }
                            sPlayerSharedRecord.append(id, new SharedRecord(avid, sharingBundle2));
                            PlayerLog.i("IPlayerContainer", "prepare for share player core success");
                            return id;
                        }
                        PlayerLog.i("IPlayerContainer", "prepare for share player core failed");
                        return -1;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        }

        public final SharedRecord retrieveSharedRecord(int id) {
            SharedRecord record = (SharedRecord) sPlayerSharedRecord.get(id);
            sPlayerSharedRecord.remove(id);
            return record;
        }

        public final boolean forceDestroyShareRecord(int id) {
            SharedRecord record = retrieveSharedRecord(id);
            if (record == null) {
                return false;
            }
            PlayerSharingBundle sharingBundle = record.getSharingBundle();
            MediaPlayContextImpl mediaContext = (MediaPlayContextImpl) PlayerSharingBundle.getSharableObject$default(sharingBundle, "key_share_media_context", false, 2, null);
            sharingBundle.clearAll();
            if (mediaContext != null) {
                mediaContext.release();
                return true;
            }
            return false;
        }
    }

    /* compiled from: PlayerContainer.kt */
    /* renamed from: tv.danmaku.biliplayerv2.IPlayerContainer$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = IPlayerContainer.Companion;
        }

        public static /* synthetic */ void collectShareParams$default(IPlayerContainer iPlayerContainer, PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collectShareParams");
            }
            if ((i & 1) != 0) {
                playerSharingType = PlayerSharingType.NORMAL;
            }
            iPlayerContainer.collectShareParams(playerSharingType, playerSharingBundle);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void updateViewPort$default(IPlayerContainer iPlayerContainer, Rect rect, List list, List list2, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateViewPort");
            }
            if ((i & 2) != 0) {
                list = null;
            }
            if ((i & 4) != 0) {
                list2 = null;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            iPlayerContainer.updateViewPort(rect, list, list2, z);
        }
    }

    /* compiled from: PlayerContainer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/biliplayerv2/IPlayerContainer$SharedRecord;", "", "avId", "", "sharingBundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "<init>", "(JLtv/danmaku/biliplayerv2/PlayerSharingBundle;)V", "getAvId", "()J", "getSharingBundle", "()Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SharedRecord {
        private final long avId;
        private final PlayerSharingBundle sharingBundle;

        public SharedRecord(long avId, PlayerSharingBundle sharingBundle) {
            Intrinsics.checkNotNullParameter(sharingBundle, "sharingBundle");
            this.avId = avId;
            this.sharingBundle = sharingBundle;
        }

        public final long getAvId() {
            return this.avId;
        }

        public final PlayerSharingBundle getSharingBundle() {
            return this.sharingBundle;
        }
    }

    /* compiled from: PlayerContainer.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0007J\u001a\u0010\u0010\u001a\u00020\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ*\u0010\u0010\u001a\u00020\u00002\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0012j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\u0013J\u0006\u0010\u0014\u001a\u00020\u0015R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/biliplayerv2/IPlayerContainer$Builder;", "", "<init>", "()V", "mContext", "Landroid/content/Context;", "mPlayerParams", "Ltv/danmaku/biliplayerv2/PlayerParamsV2;", "mControlContainerConfig", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "setContext", "context", "setPlayerParams", "playerParams", "setControlContainerConfig", "controlContainerConfig", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "build", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Builder {
        private Context mContext;
        private Map<ControlContainerType, ControlContainerConfig> mControlContainerConfig;
        private PlayerParamsV2 mPlayerParams;

        public final Builder setContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.mContext = context;
            return this;
        }

        public final Builder setPlayerParams(PlayerParamsV2 playerParams) {
            Intrinsics.checkNotNullParameter(playerParams, "playerParams");
            this.mPlayerParams = playerParams;
            return this;
        }

        public final Builder setControlContainerConfig(Map<ControlContainerType, ControlContainerConfig> map) {
            Map controlContainerConfig = EnhancedUnmodifiabilityKt.unmodifiable(map);
            Intrinsics.checkNotNullParameter(controlContainerConfig, "controlContainerConfig");
            this.mControlContainerConfig = controlContainerConfig;
            return this;
        }

        public final Builder setControlContainerConfig(HashMap<ControlContainerType, ControlContainerConfig> hashMap) {
            Intrinsics.checkNotNullParameter(hashMap, "controlContainerConfig");
            this.mControlContainerConfig = hashMap;
            return this;
        }

        public final IPlayerContainer build() {
            if (this.mContext == null) {
                throw new IllegalArgumentException("context could not is null");
            }
            if (this.mPlayerParams == null) {
                throw new IllegalArgumentException("playerParams could not is null");
            }
            if (this.mControlContainerConfig == null) {
                throw new IllegalArgumentException("controlContainerConfig could not is null");
            }
            IBiliPlayerImplService implService = (IBiliPlayerImplService) BLRouter.INSTANCE.get(IBiliPlayerImplService.class, "default");
            if (implService == null) {
                throw new RuntimeException();
            }
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            PlayerParamsV2 playerParamsV2 = this.mPlayerParams;
            Intrinsics.checkNotNull(playerParamsV2);
            Map<ControlContainerType, ControlContainerConfig> map = this.mControlContainerConfig;
            Intrinsics.checkNotNull(map);
            return implService.createPlayerContainer(context, playerParamsV2, map);
        }
    }
}