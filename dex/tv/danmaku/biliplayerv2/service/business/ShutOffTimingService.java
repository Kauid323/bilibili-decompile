package tv.danmaku.biliplayerv2.service.business;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bilibili.app.comm.timing.service.TimingCallback;
import com.bilibili.base.BiliContext;
import com.bilibili.base.util.ContextUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService;
import tv.danmaku.biliplayerv2.service.FunctionWidgetToken;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: ShutOffTimingService.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0013\u0016\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010#\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000fH\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\b\u0010*\u001a\u00020\u0007H\u0016J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u000fH\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\b\u0010.\u001a\u00020\u000fH\u0016J\u0010\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00192\u0006\u00100\u001a\u000201H\u0016J\b\u00103\u001a\u00020\u0019H\u0016J\b\u00104\u001a\u00020\u0019H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u00066"}, d2 = {"Ltv/danmaku/biliplayerv2/service/business/ShutOffTimingService;", "Ltv/danmaku/biliplayerv2/service/business/IShutOffTimeService;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mShutOffTime", "", "mTimingHelper", "Ltv/danmaku/biliplayerv2/service/business/TimingReminderHelper;", "mFunctionWidgetToken", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;", "mLastPlayerState", "", "mIsPlayerAttached", "", "mPendingOnTimeAfterAttach", "isCustomizeTotalTime", "mTimingCallback", "tv/danmaku/biliplayerv2/service/business/ShutOffTimingService$mTimingCallback$1", "Ltv/danmaku/biliplayerv2/service/business/ShutOffTimingService$mTimingCallback$1;", "mPlayerStateObserver", "tv/danmaku/biliplayerv2/service/business/ShutOffTimingService$mPlayerStateObserver$1", "Ltv/danmaku/biliplayerv2/service/business/ShutOffTimingService$mPlayerStateObserver$1;", "onTime", "", "serviceConfig", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceConfig;", "onStart", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onStop", "onCollectSharedParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "onAttachByShared", "bindPlayerContainer", "playerContainer", "startShutOffTiming", "time", "isCustomize", "getLeftTime", "getTotalTime", "setDisableOnTimeAlert", "disable", "isDisableOnTimeAlert", "isInSleepMode", "registerTimingCallback", "callback", "Lcom/bilibili/app/comm/timing/service/TimingCallback;", "unregisterTimingCallback", "existTimingReminder", "checkAndResumePlayer", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ShutOffTimingService implements IShutOffTimeService {
    public static final long CURRENT_VIDEO_LEFT_TIME = -1;
    public static final Companion Companion = new Companion(null);
    private static final String KEY_SHARE_MINI_PLAYER_LAST_STATE = "key_share_mini_player_last_state";
    private static final long MINUTE = 60000;
    private static final long SECONDS = 1000;
    private static final String TAG = "ShutOffTimingService";
    private FunctionWidgetToken mFunctionWidgetToken;
    private int mLastPlayerState;
    private boolean mPendingOnTimeAfterAttach;
    private PlayerContainer mPlayerContainer;
    private long mShutOffTime;
    private final TimingReminderHelper mTimingHelper = new TimingReminderHelper();
    private boolean mIsPlayerAttached = true;
    private final ShutOffTimingService$mTimingCallback$1 mTimingCallback = new TimingCallback() { // from class: tv.danmaku.biliplayerv2.service.business.ShutOffTimingService$mTimingCallback$1
        public void onTimingEnd() {
            PlayerContainer playerContainer;
            boolean z;
            PlayerContainer playerContainer2;
            Context context;
            IPlayerCoreService playerCoreService;
            ShutOffTimingService shutOffTimingService = ShutOffTimingService.this;
            playerContainer = ShutOffTimingService.this.mPlayerContainer;
            shutOffTimingService.mLastPlayerState = (playerContainer == null || (playerCoreService = playerContainer.getPlayerCoreService()) == null) ? 0 : playerCoreService.getState();
            ShutOffTimingService.this.mShutOffTime = 0L;
            z = ShutOffTimingService.this.mIsPlayerAttached;
            if (z) {
                ShutOffTimingService.this.onTime();
            } else if (!BiliContext.isVisible()) {
                Activity activity = BiliContext.topActivitiy();
                playerContainer2 = ShutOffTimingService.this.mPlayerContainer;
                if (Intrinsics.areEqual(activity, (playerContainer2 == null || (context = playerContainer2.getContext()) == null) ? null : ContextUtilKt.findFragmentActivityOrNull(context))) {
                    BLog.i("ShutOffTimingService", "pending onTime after attach");
                    ShutOffTimingService.this.mPendingOnTimeAfterAttach = true;
                }
            }
        }

        public void onClickClose() {
            ShutOffTimingService.this.existTimingReminder();
        }

        public void onClickRepeat() {
            ShutOffTimingService.this.existTimingReminder();
        }
    };
    private final ShutOffTimingService$mPlayerStateObserver$1 mPlayerStateObserver = new PlayerStateObserver() { // from class: tv.danmaku.biliplayerv2.service.business.ShutOffTimingService$mPlayerStateObserver$1
        /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
            r0 = r3.this$0.mPlayerContainer;
         */
        @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPlayerStateChanged(int state) {
            FunctionWidgetToken functionWidgetToken;
            PlayerContainer playerContainer;
            AbsFunctionWidgetService functionWidgetService;
            FunctionWidgetToken functionWidgetToken2;
            if (state == 4) {
                functionWidgetToken = ShutOffTimingService.this.mFunctionWidgetToken;
                boolean z = false;
                if (functionWidgetToken != null && functionWidgetToken.isShowing()) {
                    z = true;
                }
                if (z && playerContainer != null && (functionWidgetService = playerContainer.getFunctionWidgetService()) != null) {
                    functionWidgetToken2 = ShutOffTimingService.this.mFunctionWidgetToken;
                    Intrinsics.checkNotNull(functionWidgetToken2);
                    functionWidgetService.hideWidget(functionWidgetToken2);
                }
            }
        }
    };

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onPlayerReset() {
        IPlayerService.CC.$default$onPlayerReset(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.business.IShutOffTimeService
    public boolean isCustomizeTotalTime() {
        return this.mTimingHelper.isCustomizeTotalTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTime() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            return;
        }
        BLog.i(TAG, "ShutOffClock onTime");
        int state = playerContainer.getPlayerCoreService().getState();
        if (state != 5) {
            playerContainer.getPlayerCoreService().pause();
        }
        boolean isShowing = playerContainer.getControlContainerService().isShowing();
        if (isShowing) {
            playerContainer.getControlContainerService().hide();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public PlayerServiceManager.ServiceConfig serviceConfig() {
        return PlayerServiceManager.ServiceConfig.Companion.obtain(true);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        Bundle bundle2;
        IPlayerCoreService playerCoreService;
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer != null && (playerCoreService = playerContainer.getPlayerCoreService()) != null) {
            playerCoreService.registerState(this.mPlayerStateObserver, 4);
        }
        this.mTimingHelper.registerTimingCallback(this.mTimingCallback);
        this.mLastPlayerState = (bundle == null || (bundle2 = bundle.getBundle()) == null) ? 0 : bundle2.getInt(KEY_SHARE_MINI_PLAYER_LAST_STATE);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        IPlayerCoreService playerCoreService;
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer != null && (playerCoreService = playerContainer.getPlayerCoreService()) != null) {
            playerCoreService.unregisterState(this.mPlayerStateObserver);
        }
        this.mTimingHelper.unregisterTimingCallback(this.mTimingCallback);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPlayerService.CC.$default$onCollectSharedParams(this, sharingType, bundle);
        bundle.getBundle().putInt(KEY_SHARE_MINI_PLAYER_LAST_STATE, this.mLastPlayerState);
        this.mIsPlayerAttached = false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onAttachByShared(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        this.mIsPlayerAttached = true;
        if (this.mPendingOnTimeAfterAttach) {
            this.mPendingOnTimeAfterAttach = false;
            onTime();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.business.IShutOffTimeService
    public void startShutOffTiming(long time, boolean isCustomize) {
        if (time < -1) {
            PlayerLog.i(TAG, "invalid shut off time");
            return;
        }
        this.mShutOffTime = time;
        this.mTimingHelper.startTiming(this.mShutOffTime, isCustomize);
        PlayerLog.i(TAG, "[player]sleep mode timing:" + time);
    }

    @Override // tv.danmaku.biliplayerv2.service.business.IShutOffTimeService
    public long getLeftTime() {
        if (this.mShutOffTime < 0) {
            return -1L;
        }
        return this.mTimingHelper.getLeftTime();
    }

    @Override // tv.danmaku.biliplayerv2.service.business.IShutOffTimeService
    public long getTotalTime() {
        if (this.mShutOffTime < 0) {
            return this.mShutOffTime;
        }
        return this.mTimingHelper.getTotalTime();
    }

    @Override // tv.danmaku.biliplayerv2.service.business.IShutOffTimeService
    public void setDisableOnTimeAlert(boolean disable) {
    }

    @Override // tv.danmaku.biliplayerv2.service.business.IShutOffTimeService
    public boolean isDisableOnTimeAlert() {
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.business.IShutOffTimeService
    public boolean isInSleepMode() {
        return this.mTimingHelper.isInSleepMode();
    }

    @Override // tv.danmaku.biliplayerv2.service.business.IShutOffTimeService
    public void registerTimingCallback(TimingCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mTimingHelper.registerTimingCallback(callback);
    }

    @Override // tv.danmaku.biliplayerv2.service.business.IShutOffTimeService
    public void unregisterTimingCallback(TimingCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mTimingHelper.unregisterTimingCallback(callback);
    }

    @Override // tv.danmaku.biliplayerv2.service.business.IShutOffTimeService
    public void existTimingReminder() {
        checkAndResumePlayer();
    }

    private final void checkAndResumePlayer() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer != null && this.mLastPlayerState == 4) {
            playerContainer.getPlayerCoreService().resume();
        }
    }

    /* compiled from: ShutOffTimingService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/business/ShutOffTimingService$Companion;", "", "<init>", "()V", "CURRENT_VIDEO_LEFT_TIME", "", "SECONDS", "MINUTE", "TAG", "", "KEY_SHARE_MINI_PLAYER_LAST_STATE", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}