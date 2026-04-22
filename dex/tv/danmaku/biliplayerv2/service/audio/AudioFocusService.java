package tv.danmaku.biliplayerv2.service.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import androidx.core.content.ContextCompat;
import com.bilibili.base.BiliContext;
import com.bilibili.base.MainThread;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.service.IMediaCenterObserver;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.PlayerErrorObserver;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.player.plugin.mod.X86IjkRequest;
import tv.danmaku.videoplayer.core.common.PlayerAudioManager;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

/* compiled from: AudioFocusService.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0004\u0010\u0013\u0016\u0019\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\u001a\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010%\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\u001eH\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\b\u0010,\u001a\u00020\u001eH\u0002J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\nH\u0002J\b\u0010/\u001a\u00020\bH\u0002J\b\u00100\u001a\u00020\u001eH\u0002J\b\u00101\u001a\u00020\u001eH\u0002J\b\u00102\u001a\u00020\u001eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Ltv/danmaku/biliplayerv2/service/audio/AudioFocusService;", "Ltv/danmaku/biliplayerv2/service/audio/IAudioFocusService;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mDisableRequestFocus", "", "mAudioFocusState", "Ltv/danmaku/biliplayerv2/service/audio/AudioFocusEvent;", "mWaitGiveUpAudioFocus", "mAudioNoisyReceiverRegistered", "mAudioNoisyIntentFilter", "Landroid/content/IntentFilter;", "mMediaCenterObserver", "tv/danmaku/biliplayerv2/service/audio/AudioFocusService$mMediaCenterObserver$1", "Ltv/danmaku/biliplayerv2/service/audio/AudioFocusService$mMediaCenterObserver$1;", "mPlayerErrorObserver", "tv/danmaku/biliplayerv2/service/audio/AudioFocusService$mPlayerErrorObserver$1", "Ltv/danmaku/biliplayerv2/service/audio/AudioFocusService$mPlayerErrorObserver$1;", "mPlayerStateObserver", "tv/danmaku/biliplayerv2/service/audio/AudioFocusService$mPlayerStateObserver$1", "Ltv/danmaku/biliplayerv2/service/audio/AudioFocusService$mPlayerStateObserver$1;", "mAudioFocusReceiver", "tv/danmaku/biliplayerv2/service/audio/AudioFocusService$mAudioFocusReceiver$1", "Ltv/danmaku/biliplayerv2/service/audio/AudioFocusService$mAudioFocusReceiver$1;", "mAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "onStart", "", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onStop", "onAttachByShared", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "onCollectSharedParams", "bindPlayerContainer", "playerContainer", "disableRequestAudioFocus", "disable", "tryToGetAudioFocus", "giveUpAudioFocus", "releaseAudioFocus", "notifyAudioFocusChanged", "event", "requestAudioFocus", "abandonAudioFocus", "registerAudioNoisyReceiver", "unregisterAudioNoisyReceiver", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AudioFocusService implements IAudioFocusService, IPlayerService {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "AudioFocusService";
    private boolean mAudioNoisyReceiverRegistered;
    private boolean mDisableRequestFocus;
    private PlayerContainer mPlayerContainer;
    private boolean mWaitGiveUpAudioFocus;
    private AudioFocusEvent mAudioFocusState = AudioFocusEvent.UNKNOWN;
    private final IntentFilter mAudioNoisyIntentFilter = new IntentFilter("android.media.AUDIO_BECOMING_NOISY");
    private final AudioFocusService$mMediaCenterObserver$1 mMediaCenterObserver = new IMediaCenterObserver() { // from class: tv.danmaku.biliplayerv2.service.audio.AudioFocusService$mMediaCenterObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public /* synthetic */ void onPlayerReconnect() {
            IMediaCenterObserver.CC.$default$onPlayerReconnect(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public /* synthetic */ void onRestoreFromMediaCenterTerminate() {
            IMediaCenterObserver.CC.$default$onRestoreFromMediaCenterTerminate(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public void onTerminateByMediaCenter() {
            BLog.i("AudioFocusService", this + " TerminateByMediaCenter give up audio force");
            AudioFocusService.this.giveUpAudioFocus();
        }

        @Override // tv.danmaku.biliplayerv2.service.IMediaCenterObserver
        public void onPreparedFromMediaCenterTerminate() {
        }
    };
    private final AudioFocusService$mPlayerErrorObserver$1 mPlayerErrorObserver = new PlayerErrorObserver() { // from class: tv.danmaku.biliplayerv2.service.audio.AudioFocusService$mPlayerErrorObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerErrorObserver
        public void onPlayerError(IMediaPlayer player, int what, int extra) {
            Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
            AudioFocusService.this.giveUpAudioFocus();
        }
    };
    private final AudioFocusService$mPlayerStateObserver$1 mPlayerStateObserver = new PlayerStateObserver() { // from class: tv.danmaku.biliplayerv2.service.audio.AudioFocusService$mPlayerStateObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
        public void onPlayerStateChanged(int state) {
            boolean z;
            AudioFocusEvent audioFocusEvent;
            switch (state) {
                case 4:
                    AudioFocusService.this.tryToGetAudioFocus();
                    return;
                case 5:
                    z = AudioFocusService.this.mWaitGiveUpAudioFocus;
                    if (z) {
                        audioFocusEvent = AudioFocusService.this.mAudioFocusState;
                        if (audioFocusEvent != AudioFocusEvent.LOSS_TRANSIENT) {
                            AudioFocusService.this.giveUpAudioFocus();
                            return;
                        }
                        return;
                    }
                    return;
                case 6:
                case 7:
                    AudioFocusService.this.giveUpAudioFocus();
                    return;
                default:
                    return;
            }
        }
    };
    private final AudioFocusService$mAudioFocusReceiver$1 mAudioFocusReceiver = new BroadcastReceiver() { // from class: tv.danmaku.biliplayerv2.service.audio.AudioFocusService$mAudioFocusReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AudioFocusEvent event;
            if (intent == null) {
                return;
            }
            BLog.i("AudioFocusService", "audio focus change from broadcast -> " + intent.getAction());
            String action = intent.getAction();
            if (action != null) {
                switch (action.hashCode()) {
                    case -549244379:
                        if (action.equals("android.media.AUDIO_BECOMING_NOISY")) {
                            event = AudioFocusEvent.BECOMING_NOISY;
                            break;
                        }
                    default:
                        event = AudioFocusEvent.UNKNOWN;
                        break;
                }
                AudioFocusService.this.notifyAudioFocusChanged(event);
            }
            event = AudioFocusEvent.UNKNOWN;
            AudioFocusService.this.notifyAudioFocusChanged(event);
        }
    };
    private final AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: tv.danmaku.biliplayerv2.service.audio.AudioFocusService$$ExternalSyntheticLambda0
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i) {
            AudioFocusService.mAudioFocusChangeListener$lambda$0(AudioFocusService.this, i);
        }
    };

    /* compiled from: AudioFocusService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AudioFocusEvent.values().length];
            try {
                iArr[AudioFocusEvent.GAIN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AudioFocusEvent.GAIN_TRANSIENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AudioFocusEvent.LOSS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[AudioFocusEvent.LOSS_TRANSIENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[AudioFocusEvent.BECOMING_NOISY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[AudioFocusEvent.ABANDON_MONOPOLY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[AudioFocusEvent.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onPlayerReset() {
        IPlayerService.CC.$default$onPlayerReset(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ PlayerServiceManager.ServiceConfig serviceConfig() {
        return IPlayerService.CC.$default$serviceConfig(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mAudioFocusChangeListener$lambda$0(final AudioFocusService this$0, final int focusChange) {
        MainThread.runOnMainThread(new Function0() { // from class: tv.danmaku.biliplayerv2.service.audio.AudioFocusService$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit mAudioFocusChangeListener$lambda$0$0;
                mAudioFocusChangeListener$lambda$0$0 = AudioFocusService.mAudioFocusChangeListener$lambda$0$0(focusChange, this$0);
                return mAudioFocusChangeListener$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mAudioFocusChangeListener$lambda$0$0(int $focusChange, AudioFocusService this$0) {
        AudioFocusEvent event;
        BLog.i(TAG, "audio focus change from system -> " + $focusChange);
        switch ($focusChange) {
            case -2:
                event = AudioFocusEvent.LOSS_TRANSIENT;
                break;
            case -1:
                event = AudioFocusEvent.LOSS;
                break;
            case 1:
                event = AudioFocusEvent.GAIN;
                break;
            case 2:
                event = AudioFocusEvent.GAIN_TRANSIENT;
                break;
            case 101:
                event = AudioFocusEvent.ABANDON_MONOPOLY;
                break;
            default:
                event = AudioFocusEvent.UNKNOWN;
                break;
        }
        this$0.notifyAudioFocusChanged(event);
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerCoreService().addMediaCenterObserver(this.mMediaCenterObserver);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        playerContainer3.getPlayerCoreService().registerPlayerErrorObserver(this.mPlayerErrorObserver);
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer4;
        }
        playerContainer2.getPlayerCoreService().registerState(this.mPlayerStateObserver, 5, 4, 7, 6);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        releaseAudioFocus();
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getPlayerCoreService().removeMediaCenterObserver(this.mMediaCenterObserver);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        playerContainer3.getPlayerCoreService().unregisterPlayerErrorObserver(this.mPlayerErrorObserver);
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer4;
        }
        playerContainer2.getPlayerCoreService().unregisterState(this.mPlayerStateObserver);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onAttachByShared(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        releaseAudioFocus();
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.audio.IAudioFocusService
    public void disableRequestAudioFocus(boolean disable) {
        this.mDisableRequestFocus = disable;
        if (!disable) {
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            if (playerContainer.getPlayerCoreService().getState() == 4) {
                tryToGetAudioFocus();
                return;
            }
            return;
        }
        giveUpAudioFocus();
    }

    @Override // tv.danmaku.biliplayerv2.service.audio.IAudioFocusService
    public void tryToGetAudioFocus() {
        this.mWaitGiveUpAudioFocus = requestAudioFocus();
        registerAudioNoisyReceiver();
    }

    @Override // tv.danmaku.biliplayerv2.service.audio.IAudioFocusService
    public void giveUpAudioFocus() {
        abandonAudioFocus();
        unregisterAudioNoisyReceiver();
        this.mWaitGiveUpAudioFocus = false;
    }

    private final void releaseAudioFocus() {
        giveUpAudioFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyAudioFocusChanged(AudioFocusEvent event) {
        BLog.i(TAG, "audio focus event -> " + event);
        if (this.mPlayerContainer == null) {
            return;
        }
        this.mAudioFocusState = event;
        PlayerContainer playerContainer = null;
        switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
            case 1:
            case 2:
                PlayerContainer playerContainer2 = this.mPlayerContainer;
                if (playerContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer2 = null;
                }
                if (playerContainer2.getPlayerCoreService().getState() != 4) {
                    BLog.i(TAG, "focusChange call player resume");
                    PlayerContainer playerContainer3 = this.mPlayerContainer;
                    if (playerContainer3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainer = playerContainer3;
                    }
                    playerContainer.getPlayerCoreService().resume();
                    return;
                }
                return;
            case 3:
                boolean isBackground = !BiliContext.isVisible();
                PlayerContainer playerContainer4 = this.mPlayerContainer;
                if (playerContainer4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer4 = null;
                }
                if (playerContainer4.getPlayerCoreService().getState() == 4 && isBackground) {
                    BLog.i(TAG, "focusChange call player pause, isBackground: true");
                    PlayerContainer playerContainer5 = this.mPlayerContainer;
                    if (playerContainer5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainer = playerContainer5;
                    }
                    playerContainer.getPlayerCoreService().pause();
                    return;
                }
                return;
            case 4:
            case 5:
                PlayerContainer playerContainer6 = this.mPlayerContainer;
                if (playerContainer6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainer6 = null;
                }
                if (playerContainer6.getPlayerCoreService().getState() == 4) {
                    BLog.i(TAG, "focusChange call player pause: " + event);
                    PlayerContainer playerContainer7 = this.mPlayerContainer;
                    if (playerContainer7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    } else {
                        playerContainer = playerContainer7;
                    }
                    playerContainer.getPlayerCoreService().pause();
                    return;
                }
                return;
            case 6:
                tryToGetAudioFocus();
                return;
            case 7:
                BLog.i(TAG, "focusChange UNKNOWN");
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean requestAudioFocus() {
        if (!this.mDisableRequestFocus) {
            return PlayerAudioManager.Companion.getInstance().requestAudioFocus(this.mAudioFocusChangeListener, 3, 2) != 0;
        }
        BLog.i(TAG, "disableRequestFocus");
        return false;
    }

    private final void abandonAudioFocus() {
        PlayerAudioManager.Companion.getInstance().abandonAudioFocus(this.mAudioFocusChangeListener);
    }

    private final void registerAudioNoisyReceiver() {
        if (!this.mAudioNoisyReceiverRegistered) {
            ContextCompat.registerReceiver(FoundationAlias.getFapp(), this.mAudioFocusReceiver, this.mAudioNoisyIntentFilter, 2);
            this.mAudioNoisyReceiverRegistered = true;
        }
    }

    private final void unregisterAudioNoisyReceiver() {
        if (this.mAudioNoisyReceiverRegistered) {
            try {
                FoundationAlias.getFapp().unregisterReceiver(this.mAudioFocusReceiver);
            } catch (IllegalArgumentException ignored) {
                PlayerLog.w(PlayerLogModule.PlaybackV2, ignored);
            }
            this.mAudioNoisyReceiverRegistered = false;
        }
    }

    /* compiled from: AudioFocusService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/audio/AudioFocusService$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}