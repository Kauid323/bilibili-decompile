package tv.danmaku.video.bilicardplayer.player;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.service.IActivityStateService;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.LifecycleObserver;
import tv.danmaku.biliplayerv2.service.LifecycleState;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.lock.DisablePlayLock;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

/* compiled from: CardBackgroundPlayService.kt */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006#"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/CardBackgroundPlayService;", "Ltv/danmaku/video/bilicardplayer/player/ICardBackgroundPlayService;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mActivityStateService", "Ltv/danmaku/biliplayerv2/service/IActivityStateService;", "mPlayerCoreService", "Ltv/danmaku/biliplayerv2/service/IPlayerCoreService;", "mPendingState", "", "mPlayerWillShare", "", "mDisablePlayLock", "Ltv/danmaku/biliplayerv2/service/lock/DisablePlayLock;", "mActivityLifecycleObserver", "tv/danmaku/video/bilicardplayer/player/CardBackgroundPlayService$mActivityLifecycleObserver$1", "Ltv/danmaku/video/bilicardplayer/player/CardBackgroundPlayService$mActivityLifecycleObserver$1;", "isInMultiWindowMode", "context", "Landroid/content/Context;", "tryToRestorePlayer", "", "serviceConfig", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceConfig;", "onStart", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onCollectSharedParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "onStop", "bindPlayerContainer", "playerContainer", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CardBackgroundPlayService implements ICardBackgroundPlayService {
    private final CardBackgroundPlayService$mActivityLifecycleObserver$1 mActivityLifecycleObserver = new LifecycleObserver() { // from class: tv.danmaku.video.bilicardplayer.player.CardBackgroundPlayService$mActivityLifecycleObserver$1

        /* compiled from: CardBackgroundPlayService.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LifecycleState.values().length];
                try {
                    iArr[LifecycleState.ACTIVITY_PAUSE.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[LifecycleState.ACTIVITY_RESUME.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[LifecycleState.ACTIVITY_STOP.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
            if (r0.isHeld() == false) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void pausePlayerAndHeldLock() {
            DisablePlayLock disablePlayLock;
            IPlayerCoreService iPlayerCoreService;
            int i;
            IPlayerCoreService iPlayerCoreService2;
            DisablePlayLock disablePlayLock2;
            disablePlayLock = CardBackgroundPlayService.this.mDisablePlayLock;
            IPlayerCoreService iPlayerCoreService3 = null;
            if (disablePlayLock != null) {
                disablePlayLock2 = CardBackgroundPlayService.this.mDisablePlayLock;
                Intrinsics.checkNotNull(disablePlayLock2);
            }
            CardBackgroundPlayService cardBackgroundPlayService = CardBackgroundPlayService.this;
            iPlayerCoreService = CardBackgroundPlayService.this.mPlayerCoreService;
            if (iPlayerCoreService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
                iPlayerCoreService = null;
            }
            cardBackgroundPlayService.mDisablePlayLock = iPlayerCoreService.acquireDisablePlayLock("CardbackgroundPlay");
            i = CardBackgroundPlayService.this.mPendingState;
            if (i == 4) {
                iPlayerCoreService2 = CardBackgroundPlayService.this.mPlayerCoreService;
                if (iPlayerCoreService2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
                } else {
                    iPlayerCoreService3 = iPlayerCoreService2;
                }
                iPlayerCoreService3.pause();
            }
        }

        @Override // tv.danmaku.biliplayerv2.service.LifecycleObserver
        public void onLifecycleChanged(LifecycleState state) {
            IPlayerCoreService iPlayerCoreService;
            boolean z;
            PlayerContainer playerContainer;
            boolean isInMultiWindowMode;
            DisablePlayLock disablePlayLock;
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            IPlayerCoreService iPlayerCoreService2;
            DisablePlayLock disablePlayLock2;
            IPlayerCoreService iPlayerCoreService3;
            DisablePlayLock disablePlayLock3;
            boolean z2;
            PlayerContainer playerContainer2;
            boolean isInMultiWindowMode2;
            Intrinsics.checkNotNullParameter(state, "state");
            PlayerContainer playerContainer3 = null;
            PlayerContainer playerContainer4 = null;
            IPlayerCoreService iPlayerCoreService4 = null;
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                    CardBackgroundPlayService cardBackgroundPlayService = CardBackgroundPlayService.this;
                    iPlayerCoreService = CardBackgroundPlayService.this.mPlayerCoreService;
                    if (iPlayerCoreService == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
                        iPlayerCoreService = null;
                    }
                    cardBackgroundPlayService.mPendingState = iPlayerCoreService.getState();
                    z = CardBackgroundPlayService.this.mPlayerWillShare;
                    if (z) {
                        return;
                    }
                    CardBackgroundPlayService cardBackgroundPlayService2 = CardBackgroundPlayService.this;
                    playerContainer = CardBackgroundPlayService.this.mPlayerContainer;
                    if (playerContainer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainer3 = playerContainer;
                    }
                    isInMultiWindowMode = cardBackgroundPlayService2.isInMultiWindowMode(playerContainer3.getContext());
                    if (!isInMultiWindowMode) {
                        PlayerLog.i(PlayerLogModule.ActivityState, "disable play true on activity pause");
                        pausePlayerAndHeldLock();
                        return;
                    }
                    return;
                case 2:
                    PlayerLog.i(PlayerLogModule.ActivityState, "disable play false on activity resume");
                    disablePlayLock = CardBackgroundPlayService.this.mDisablePlayLock;
                    if (disablePlayLock != null) {
                        disablePlayLock2 = CardBackgroundPlayService.this.mDisablePlayLock;
                        Intrinsics.checkNotNull(disablePlayLock2);
                        if (disablePlayLock2.isHeld()) {
                            iPlayerCoreService3 = CardBackgroundPlayService.this.mPlayerCoreService;
                            if (iPlayerCoreService3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
                                iPlayerCoreService3 = null;
                            }
                            disablePlayLock3 = CardBackgroundPlayService.this.mDisablePlayLock;
                            Intrinsics.checkNotNull(disablePlayLock3);
                            iPlayerCoreService3.releaseDisablePlayLock(disablePlayLock3);
                            CardBackgroundPlayService.this.mDisablePlayLock = null;
                        }
                    }
                    CardBackgroundPlayService.this.tryToRestorePlayer();
                    i = CardBackgroundPlayService.this.mPendingState;
                    if (i != 5) {
                        i2 = CardBackgroundPlayService.this.mPendingState;
                        if (i2 != 6) {
                            i3 = CardBackgroundPlayService.this.mPendingState;
                            if (i3 != 7) {
                                i4 = CardBackgroundPlayService.this.mPendingState;
                                if (i4 != 8) {
                                    i5 = CardBackgroundPlayService.this.mPendingState;
                                    if (i5 != 0) {
                                        iPlayerCoreService2 = CardBackgroundPlayService.this.mPlayerCoreService;
                                        if (iPlayerCoreService2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
                                        } else {
                                            iPlayerCoreService4 = iPlayerCoreService2;
                                        }
                                        iPlayerCoreService4.resume();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    z2 = CardBackgroundPlayService.this.mPlayerWillShare;
                    if (z2) {
                        return;
                    }
                    CardBackgroundPlayService cardBackgroundPlayService3 = CardBackgroundPlayService.this;
                    playerContainer2 = CardBackgroundPlayService.this.mPlayerContainer;
                    if (playerContainer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainer4 = playerContainer2;
                    }
                    isInMultiWindowMode2 = cardBackgroundPlayService3.isInMultiWindowMode(playerContainer4.getContext());
                    if (isInMultiWindowMode2) {
                        PlayerLog.i(PlayerLogModule.ActivityState, "disable play true on activity stop");
                        pausePlayerAndHeldLock();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private IActivityStateService mActivityStateService;
    private DisablePlayLock mDisablePlayLock;
    private int mPendingState;
    private PlayerContainer mPlayerContainer;
    private IPlayerCoreService mPlayerCoreService;
    private boolean mPlayerWillShare;

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onAttachByShared(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle) {
        Intrinsics.checkNotNullParameter(playerSharingType, "sharingType");
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onPlayerReset() {
        IPlayerService.CC.$default$onPlayerReset(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isInMultiWindowMode(Context context) {
        return Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryToRestorePlayer() {
        IPlayerCoreService iPlayerCoreService = this.mPlayerCoreService;
        if (iPlayerCoreService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerCoreService");
            iPlayerCoreService = null;
        }
        iPlayerCoreService.tryToRestoreFromShutDownByOthers();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public PlayerServiceManager.ServiceConfig serviceConfig() {
        return PlayerServiceManager.ServiceConfig.Companion.obtain(true);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        PlayerContainer playerContainer = this.mPlayerContainer;
        IActivityStateService iActivityStateService = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        this.mActivityStateService = playerContainer.getActivityStateService();
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer2 = null;
        }
        this.mPlayerCoreService = playerContainer2.getPlayerCoreService();
        IActivityStateService iActivityStateService2 = this.mActivityStateService;
        if (iActivityStateService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityStateService");
        } else {
            iActivityStateService = iActivityStateService2;
        }
        iActivityStateService.registerLifecycle(this.mActivityLifecycleObserver, LifecycleState.ACTIVITY_RESUME, LifecycleState.ACTIVITY_PAUSE, LifecycleState.ACTIVITY_START, LifecycleState.ACTIVITY_STOP, LifecycleState.ACTIVITY_DESTROY);
        this.mPlayerWillShare = false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.mPlayerWillShare = true;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        IActivityStateService iActivityStateService = this.mActivityStateService;
        if (iActivityStateService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityStateService");
            iActivityStateService = null;
        }
        iActivityStateService.unregisterLifecycle(this.mActivityLifecycleObserver);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }
}