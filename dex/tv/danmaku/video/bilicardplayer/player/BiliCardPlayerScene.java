package tv.danmaku.video.bilicardplayer.player;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.playerbizcommon.features.hardware.IHardwareDelegate;
import com.bilibili.playerbizcommon.features.headset.IPlayerHeadsetEventCallback;
import com.bilibili.playerbizcommon.features.headset.MediaSessionControllerCallback;
import com.bilibili.playerbizcommon.features.network.VideoEnvironment;
import com.bilibili.playerbizcommon.gesture.OnDoubleTapListener;
import com.bilibili.playerbizcommon.gesture.OnLongPressListener;
import com.bilibili.playerbizcommon.gesture.OnSingleTapListener;
import com.bilibili.playerbizcommon.mediasession.IMediaSessionPlayback;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.bili.wauth.WAuthErrorMsg;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.clock.PlayerProgressRangeObserver;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.panel.BuiltInLayer;
import tv.danmaku.biliplayerv2.service.ICurrentPositionInterceptor;
import tv.danmaku.biliplayerv2.service.IDurationInterceptor;
import tv.danmaku.biliplayerv2.service.IMediaItemParamsInterceptor;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.ISeekInterceptor;
import tv.danmaku.biliplayerv2.service.PlayerProgressObserver;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosBiz;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosScene;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuConfigChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.service.resolve.CommonResolveTaskProvider;
import tv.danmaku.biliplayerv2.service.setting.ICloudConfigObserver;
import tv.danmaku.biliplayerv2.utils.PlayerCloudConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.player.plugin.mod.X86IjkRequest;
import tv.danmaku.video.bilicardplayer.CardPlayerLayer;
import tv.danmaku.video.bilicardplayer.CardPlayerLog;
import tv.danmaku.video.bilicardplayer.CardTaskRepository;
import tv.danmaku.video.bilicardplayer.ICardPlayBufferingCallback;
import tv.danmaku.video.bilicardplayer.ICardPlaySateChangedCallback;
import tv.danmaku.video.bilicardplayer.ICardPlayerContext;
import tv.danmaku.video.bilicardplayer.ICardPlayerInfoListener;
import tv.danmaku.video.bilicardplayer.IControlContainerChangedCallback;
import tv.danmaku.video.bilicardplayer.IControlContainerVisibleCallback;
import tv.danmaku.video.bilicardplayer.IDanmakuParamsChangedCallback;
import tv.danmaku.video.bilicardplayer.IDanmakuStateChangedCallback;
import tv.danmaku.video.bilicardplayer.INetworkAlertCallback;
import tv.danmaku.video.bilicardplayer.IPlayerRenderCallback;
import tv.danmaku.video.bilicardplayer.IPlayerSeekCallback;
import tv.danmaku.video.bilicardplayer.IVideoEnvironmentChangedCallback;
import tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo;
import tv.danmaku.video.bilicardplayer.player.ICardPlayTask;
import tv.danmaku.video.playerservice.BLPlayerScene;
import tv.danmaku.video.playerservice.BLPlayerService;
import tv.danmaku.video.playerservice.RecyclableObject;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;

/* compiled from: BiliCardPlayerScene.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0002_`B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020\u001f2\b\b\u0002\u0010&\u001a\u00020\u001cJ\b\u0010'\u001a\u00020\u0017H\u0002J\u000e\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u001cJ\u0010\u0010*\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010\u0013J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\nJ\u001a\u0010/\u001a\u00020\u00172\b\b\u0002\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020-H\u0002J\u0010\u00102\u001a\u00020\u00172\b\b\u0002\u00103\u001a\u00020\u001cJ\"\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u001c2\b\b\u0002\u00106\u001a\u00020\u001cH\u0002J\u0006\u00107\u001a\u000208J\b\u00109\u001a\u0004\u0018\u00010:J\"\u0010;\u001a\u00020\u00172\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0=2\u0006\u0010@\u001a\u00020>J>\u0010A\u001a\u00020\u00172\b\u0010B\u001a\u0004\u0018\u00010C2\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010E2\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010E2\b\b\u0002\u0010I\u001a\u00020\u001cJ2\u0010J\u001a\u00020\u0017\"\b\b\u0000\u0010K*\u00020L2\u000e\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u0002HK0N2\u0010\b\u0002\u0010O\u001a\n\u0012\u0004\u0012\u0002HK\u0018\u00010PJ.\u0010Q\u001a\u00020\u0017\"\b\b\u0000\u0010K*\u00020L2\u000e\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u0002HK0N2\f\u0010O\u001a\b\u0012\u0004\u0012\u0002HK0PJ8\u0010Q\u001a\u00020\u0017\"\b\b\u0000\u0010K*\u00020L2\u000e\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u0002HK0N2\f\u0010O\u001a\b\u0012\u0004\u0012\u0002HK0P2\b\b\u0002\u0010R\u001a\u00020\u001cJ\u001e\u0010S\u001a\u00020\u0017\"\b\b\u0000\u0010K*\u00020L2\f\u0010O\u001a\b\u0012\u0004\u0012\u0002HK0PJ\u0016\u0010T\u001a\u00020\u00172\u000e\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u00020L0NJ\u0006\u0010U\u001a\u00020\u001cJ\u0006\u0010V\u001a\u00020\u0017J\u0010\u0010W\u001a\u00020\u00172\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u00020\u00172\u0006\u0010[\u001a\u00020\u001cH\u0016J\u000e\u0010\\\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u000fJ\u000e\u0010^\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u000fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene;", "Ltv/danmaku/video/playerservice/BLPlayerScene;", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "()V", "mBiliCardPlayer", "Ltv/danmaku/video/bilicardplayer/player/IBiliCardPlayer;", "mBLPlayerService", "Ltv/danmaku/video/playerservice/BLPlayerService;", "mCurrentTask", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask;", "mContext", "Landroid/content/Context;", "mPlayerReadyObservers", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "Ltv/danmaku/video/bilicardplayer/player/CardPlayerReadyObserver;", "kotlin.jvm.PlatformType", "mDeadBiliCardPlayer", "mPlayerExtraConfiguration", "Ltv/danmaku/video/bilicardplayer/player/PlayerExtraConfiguration;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "initialize", "", "context", "service", "release", "isActive", "", "ensureCardPlayer", "sharedId", "", "onStateChanged", "source", "event", "Landroidx/lifecycle/Lifecycle$Event;", "processDeadCardPlayer", "prepareForShare", "needMute", "markPlayerInvalid", "setMute", "isMute", "setPlayerExtraConfiguration", "configuration", "commit", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask$Token;", WAuthErrorMsg.ERROR_MESSAGE_REQUEST, "play", "index", "token", "stop", "isFromOther", "stopInternal", X86IjkRequest.POOL, "changeContainer", "getCurrentPosition", "", "getPlayingContext", "Ltv/danmaku/video/bilicardplayer/ICardPlayerContext;", "setControlContainerConfig", "config", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "initializeType", "updateViewPort", "viewPort", "Landroid/graphics/Rect;", "builtInLayers", "", "Ltv/danmaku/biliplayerv2/panel/BuiltInLayer;", "customerLayers", "", "immediately", "startService", "T", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "clazz", "Ljava/lang/Class;", "client", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "bindService", "autoCreate", "unbindService", "stopService", "performBackPressed", "show", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "registerPlayerReadyObserver", "observer", "unregisterPlayerReadyObserver", "Companion", "CardPlayTask", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BiliCardPlayerScene implements BLPlayerScene, LifecycleEventObserver {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "BiliCardPlayerScene";
    private LifecycleOwner lifecycleOwner;
    private BLPlayerService mBLPlayerService;
    private IBiliCardPlayer mBiliCardPlayer;
    private Context mContext;
    private CardPlayTask mCurrentTask;
    private IBiliCardPlayer mDeadBiliCardPlayer;
    private PlayerExtraConfiguration mPlayerExtraConfiguration;
    private final Collections.SafeIteratorList<CardPlayerReadyObserver> mPlayerReadyObservers = Collections.safeIteratorList(new LinkedList());

    /* compiled from: BiliCardPlayerScene.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$Companion;", "", "<init>", "()V", "TAG", "", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.video.playerservice.BLPlayerScene
    public void initialize(Context context, BLPlayerService service, LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(service, "service");
        this.mBLPlayerService = service;
        this.mContext = context;
        this.lifecycleOwner = lifecycleOwner;
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
        if (lifecycleOwner2 == null || (lifecycle = lifecycleOwner2.getLifecycle()) == null) {
            return;
        }
        lifecycle.addObserver((LifecycleObserver) this);
    }

    @Override // tv.danmaku.video.playerservice.BLPlayerScene
    public void release() {
        markPlayerInvalid();
        processDeadCardPlayer();
    }

    @Override // tv.danmaku.video.playerservice.BLPlayerScene
    public boolean isActive() {
        LifecycleOwner owner = this.lifecycleOwner;
        if (owner == null) {
            return true;
        }
        return owner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED);
    }

    static /* synthetic */ boolean ensureCardPlayer$default(BiliCardPlayerScene biliCardPlayerScene, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return biliCardPlayerScene.ensureCardPlayer(i);
    }

    private final boolean ensureCardPlayer(int sharedId) {
        Context context = this.mContext;
        if (context != null && this.mBiliCardPlayer == null) {
            CardPlayerLog.i(TAG, "initialize biliCardPlayer");
            DefaultCardPlayer cardPlayer = new DefaultCardPlayer();
            this.mBiliCardPlayer = cardPlayer;
            cardPlayer.initialize(this.lifecycleOwner, context, sharedId, this.mPlayerExtraConfiguration);
            cardPlayer.listenPlayerReady(new BiliCardPlayerScene$ensureCardPlayer$1(this));
            return true;
        }
        return false;
    }

    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_START || event == Lifecycle.Event.ON_RESUME) {
            processDeadCardPlayer();
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            this.mContext = null;
            this.mPlayerReadyObservers.clear();
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver((LifecycleObserver) this);
            }
            this.lifecycleOwner = null;
        }
    }

    private final void processDeadCardPlayer() {
        IBiliCardPlayer it = this.mDeadBiliCardPlayer;
        if (it != null) {
            this.mCurrentTask = null;
            it.release();
        }
        this.mDeadBiliCardPlayer = null;
    }

    public static /* synthetic */ int prepareForShare$default(BiliCardPlayerScene biliCardPlayerScene, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return biliCardPlayerScene.prepareForShare(z);
    }

    public final int prepareForShare(boolean needMute) {
        IBiliCardPlayer it;
        BLog.i(TAG, "card player prepare for share");
        IBiliCardPlayer player = this.mBiliCardPlayer;
        if (player == null) {
            return -1;
        }
        PlayerExtraConfiguration playerExtraConfiguration = this.mPlayerExtraConfiguration;
        boolean z = false;
        if (playerExtraConfiguration != null && playerExtraConfiguration.getKeepRender()) {
            z = true;
        }
        int res = player.prepareForShare(z, needMute);
        markPlayerInvalid();
        if (res == -1 && (it = this.mDeadBiliCardPlayer) != null) {
            CardPlayerLog.i(TAG, "stop card player form failed share play");
            stopInternal$default(this, it, false, false, 4, null);
        }
        return res;
    }

    private final void markPlayerInvalid() {
        CardPlayTask.Token token$bilicardplayer_apinkDebug;
        if (this.mBiliCardPlayer != null) {
            BLog.i(TAG, "card player mark player invalid");
            CardPlayTask cardPlayTask = this.mCurrentTask;
            if (cardPlayTask != null && (token$bilicardplayer_apinkDebug = cardPlayTask.getToken$bilicardplayer_apinkDebug()) != null) {
                token$bilicardplayer_apinkDebug.release$bilicardplayer_apinkDebug();
            }
            CardPlayTask cardPlayTask2 = this.mCurrentTask;
            if (cardPlayTask2 != null) {
                cardPlayTask2.setToken$bilicardplayer_apinkDebug(CardPlayTask.Companion.getINVALID_TOKEN());
            }
            this.mDeadBiliCardPlayer = this.mBiliCardPlayer;
            this.mBiliCardPlayer = null;
        }
    }

    public final void setMute(boolean isMute) {
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer != null) {
            iBiliCardPlayer.setMute(isMute);
        }
    }

    public final void setPlayerExtraConfiguration(PlayerExtraConfiguration configuration) {
        this.mPlayerExtraConfiguration = configuration;
    }

    public final CardPlayTask.Token commit(CardPlayTask request) {
        Lifecycle.State state;
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(request, WAuthErrorMsg.ERROR_MESSAGE_REQUEST);
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null || (state = lifecycle.getCurrentState()) == null) {
            state = Lifecycle.State.RESUMED;
        }
        boolean hasCreated = state.isAtLeast(Lifecycle.State.CREATED);
        if (!hasCreated) {
            CardPlayerLog.w(TAG, "lifecycle state error: " + state);
            return CardPlayTask.Companion.getINVALID_TOKEN();
        }
        CardPlayerLog.i(TAG, "commit playRequest: " + request);
        if (request.getSharedRecordId() > 0) {
            markPlayerInvalid();
        }
        processDeadCardPlayer();
        boolean initResult = ensureCardPlayer(request.getSharedRecordId());
        CardPlayerLog.i(TAG, "ensure create card player result: " + initResult);
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        request.setToken$bilicardplayer_apinkDebug(new CardPlayTask.Token(iBiliCardPlayer != null ? iBiliCardPlayer.getCardPlayerContext() : null));
        if (!request.different(this.mCurrentTask)) {
            CardPlayerLog.e(TAG, "request already attached");
        } else {
            CardPlayTask old = this.mCurrentTask;
            IBiliCardPlayer player = this.mBiliCardPlayer;
            if (old != null && player != null) {
                CardPlayerLog.i(TAG, "attach new request, new: " + request);
                stopInternal(player, true, !Intrinsics.areEqual(old.getContainer(), request.getContainer()));
            }
            IBiliCardPlayer iBiliCardPlayer2 = this.mBiliCardPlayer;
            if (iBiliCardPlayer2 != null) {
                iBiliCardPlayer2.attachToTask(request);
            }
        }
        this.mCurrentTask = request;
        play(request.getStartIndex$bilicardplayer_apinkDebug(), request.getToken$bilicardplayer_apinkDebug());
        return request.getToken$bilicardplayer_apinkDebug();
    }

    static /* synthetic */ void play$default(BiliCardPlayerScene biliCardPlayerScene, int i, CardPlayTask.Token token, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        biliCardPlayerScene.play(i, token);
    }

    private final void play(int index, CardPlayTask.Token token) {
        CardPlayerLog.i(TAG, "play {index: " + index + ", token: " + token + "}");
        CardPlayTask cardPlayTask = this.mCurrentTask;
        if (!Intrinsics.areEqual(token, cardPlayTask != null ? cardPlayTask.getToken$bilicardplayer_apinkDebug() : null)) {
            CardPlayerLog.w(TAG, "current host do not match token");
            return;
        }
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer != null) {
            iBiliCardPlayer.play(index);
        }
    }

    public static /* synthetic */ void stop$default(BiliCardPlayerScene biliCardPlayerScene, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        biliCardPlayerScene.stop(z);
    }

    public final void stop(boolean isFromOther) {
        IBiliCardPlayer it = this.mBiliCardPlayer;
        if (it != null) {
            stopInternal$default(this, it, isFromOther, false, 4, null);
        }
    }

    static /* synthetic */ void stopInternal$default(BiliCardPlayerScene biliCardPlayerScene, IBiliCardPlayer iBiliCardPlayer, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        biliCardPlayerScene.stopInternal(iBiliCardPlayer, z, z2);
    }

    private final void stopInternal(IBiliCardPlayer player, final boolean isFromOther, boolean changeContainer) {
        CardPlayTask it = this.mCurrentTask;
        if (it != null) {
            CardPlayerLog.i(TAG, "stop play, request: " + it);
            it.getToken$bilicardplayer_apinkDebug().release$bilicardplayer_apinkDebug();
            CardPlayerCallbacksInfo<ICardPlayerInfoListener> cardPlayInfoListeners = it.getCardPlayInfoListeners();
            if (cardPlayInfoListeners != null) {
                cardPlayInfoListeners.visit(new CardPlayerCallbacksInfo.Visitor<ICardPlayerInfoListener>() { // from class: tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene$stopInternal$1$1
                    @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
                    public void onVisit(ICardPlayerInfoListener callback) {
                        Intrinsics.checkNotNullParameter(callback, "callback");
                        callback.onInfo(isFromOther ? 1 : 3, null);
                    }
                });
            }
            player.detachFromTask(it, changeContainer);
            BLPlayerService bLPlayerService = this.mBLPlayerService;
            if (bLPlayerService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBLPlayerService");
                bLPlayerService = null;
            }
            bLPlayerService.getRecyclableObjectPool().put(it);
        }
        this.mCurrentTask = null;
    }

    public final long getCurrentPosition() {
        ICardPlayerContext cardPlayerContext;
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer == null || (cardPlayerContext = iBiliCardPlayer.getCardPlayerContext()) == null) {
            return 0L;
        }
        return cardPlayerContext.getCurrentPosition();
    }

    public final ICardPlayerContext getPlayingContext() {
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer != null) {
            return iBiliCardPlayer.getCardPlayerContext();
        }
        return null;
    }

    public final void setControlContainerConfig(Map<ControlContainerType, ControlContainerConfig> map, ControlContainerType initializeType) {
        Intrinsics.checkNotNullParameter(map, "config");
        Intrinsics.checkNotNullParameter(initializeType, "initializeType");
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer != null) {
            iBiliCardPlayer.setControlContainerConfig(map, initializeType);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateViewPort$default(BiliCardPlayerScene biliCardPlayerScene, Rect rect, List list, List list2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        if ((i & 4) != 0) {
            list2 = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        biliCardPlayerScene.updateViewPort(rect, list, list2, z);
    }

    public final void updateViewPort(Rect viewPort, List<? extends BuiltInLayer> list, List<String> list2, boolean immediately) {
        ICardPlayerContext cardPlayerContext;
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer == null || (cardPlayerContext = iBiliCardPlayer.getCardPlayerContext()) == null) {
            return;
        }
        cardPlayerContext.updateViewPort(viewPort, list, list2, immediately);
    }

    public static /* synthetic */ void startService$default(BiliCardPlayerScene biliCardPlayerScene, Class cls, PlayerServiceManager.Client client, int i, Object obj) {
        if ((i & 2) != 0) {
            client = null;
        }
        biliCardPlayerScene.startService(cls, client);
    }

    public final <T extends IPlayerService> void startService(Class<? extends T> cls, PlayerServiceManager.Client<T> client) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer != null) {
            iBiliCardPlayer.startService(cls, client);
        }
    }

    public final <T extends IPlayerService> void bindService(Class<? extends T> cls, PlayerServiceManager.Client<T> client) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(client, "client");
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer != null) {
            iBiliCardPlayer.bindService(cls, client, false);
        }
    }

    public static /* synthetic */ void bindService$default(BiliCardPlayerScene biliCardPlayerScene, Class cls, PlayerServiceManager.Client client, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        biliCardPlayerScene.bindService(cls, client, z);
    }

    public final <T extends IPlayerService> void bindService(Class<? extends T> cls, PlayerServiceManager.Client<T> client, boolean autoCreate) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(client, "client");
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer != null) {
            iBiliCardPlayer.bindService(cls, client, autoCreate);
        }
    }

    public final <T extends IPlayerService> void unbindService(PlayerServiceManager.Client<T> client) {
        Intrinsics.checkNotNullParameter(client, "client");
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer != null) {
            iBiliCardPlayer.unbindService(client);
        }
    }

    public final void stopService(Class<? extends IPlayerService> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer != null) {
            iBiliCardPlayer.stopService(cls);
        }
    }

    public final boolean performBackPressed() {
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer != null) {
            return iBiliCardPlayer.performBackPressed();
        }
        return false;
    }

    public final void show() {
        CardPlayTask cardPlayTask = this.mCurrentTask;
        if ((cardPlayTask != null ? cardPlayTask.getToken$bilicardplayer_apinkDebug() : null) != null) {
            CardPlayTask cardPlayTask2 = this.mCurrentTask;
            if (!Intrinsics.areEqual(cardPlayTask2 != null ? cardPlayTask2.getToken$bilicardplayer_apinkDebug() : null, CardPlayTask.Companion.getINVALID_TOKEN())) {
                IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
                if (iBiliCardPlayer != null) {
                    iBiliCardPlayer.show();
                    return;
                }
                return;
            }
        }
        CardPlayerLog.w(TAG, "do not attach a request this moment, do nothing");
    }

    @Override // tv.danmaku.video.playerservice.BLPlayerScene
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer != null) {
            iBiliCardPlayer.performConfigurationChanged(newConfig);
        }
    }

    @Override // tv.danmaku.video.playerservice.BLPlayerScene
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        if (iBiliCardPlayer != null) {
            iBiliCardPlayer.performMultiWindowModeChanged(isInMultiWindowMode);
        }
    }

    public final void registerPlayerReadyObserver(CardPlayerReadyObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.mPlayerReadyObservers.contains(observer)) {
            CardPlayerLog.w(TAG, "observer: " + observer + " already add");
            return;
        }
        this.mPlayerReadyObservers.add(observer);
        IBiliCardPlayer iBiliCardPlayer = this.mBiliCardPlayer;
        boolean z = false;
        if (iBiliCardPlayer != null && iBiliCardPlayer.isReady()) {
            z = true;
        }
        if (z) {
            observer.onReady();
        }
    }

    public final void unregisterPlayerReadyObserver(CardPlayerReadyObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerReadyObservers.remove(observer);
    }

    /* compiled from: BiliCardPlayerScene.kt */
    @Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010 \n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 æ\u00012\u00020\u00012\u00020\u0002:\u0004æ\u0001ç\u0001B\t\b\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010h\u001a\u00020\u0006J\u000e\u0010i\u001a\u00020\u00002\u0006\u0010j\u001a\u00020\u0018J\u000e\u0010k\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\u001eJ\u0016\u0010m\u001a\u00020\u00002\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020qJ\u000e\u0010r\u001a\u00020\u00002\u0006\u0010s\u001a\u00020\u0006J\u000e\u0010t\u001a\u00020\u00002\u0006\u0010u\u001a\u000209J\u000e\u0010v\u001a\u00020\u00002\u0006\u0010u\u001a\u00020;J\u000e\u0010w\u001a\u00020\u00002\u0006\u0010u\u001a\u00020=J\u000e\u0010x\u001a\u00020\u00002\u0006\u0010u\u001a\u00020?J\u000e\u0010y\u001a\u00020\u00002\u0006\u0010z\u001a\u00020\u0006J\u000e\u0010{\u001a\u00020\u00002\u0006\u0010|\u001a\u00020\u0013J\u000e\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\u0013J\u000f\u0010\u007f\u001a\u00020\u00002\u0007\u0010\u0080\u0001\u001a\u00020IJ\u0010\u0010\u0081\u0001\u001a\u00020\u00002\u0007\u0010\u0082\u0001\u001a\u00020*J\u001c\u0010\u0083\u0001\u001a\u00020\u00002\u0013\u0010\u0084\u0001\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,J\u0010\u0010\u0085\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020-J\u0010\u0010\u0087\u0001\u001a\u00020\u00002\u0007\u0010\u0088\u0001\u001a\u000201J\u0010\u0010\u0089\u0001\u001a\u00020\u00002\u0007\u0010\u008a\u0001\u001a\u00020\u0006J\u000f\u0010\u008b\u0001\u001a\u00020\u00002\u0006\u0010u\u001a\u000205J\u000f\u0010\u008c\u0001\u001a\u00020\u00002\u0006\u0010u\u001a\u000207J\u000f\u0010\u008d\u0001\u001a\u00020\u00002\u0006\u0010u\u001a\u00020AJ\u000f\u0010\u008e\u0001\u001a\u00020\u00002\u0006\u0010u\u001a\u00020CJ\u000f\u0010\u008f\u0001\u001a\u00020\u00002\u0006\u0010u\u001a\u00020EJ\u000f\u0010\u0090\u0001\u001a\u00020\u00002\u0006\u0010u\u001a\u00020GJ\u0010\u0010\u0091\u0001\u001a\u00020\u00002\u0007\u0010\u008a\u0001\u001a\u00020\u0006J\u0010\u0010\u0092\u0001\u001a\u00020\u00002\u0007\u0010\u008a\u0001\u001a\u00020\u0006J\u0010\u0010\u0093\u0001\u001a\u00020\u00002\u0007\u0010\u0094\u0001\u001a\u00020\u0006J\u0012\u0010\u0095\u0001\u001a\u00020\u00002\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010KJ\u0010\u0010\u0097\u0001\u001a\u00020\u00002\u0007\u0010\u0098\u0001\u001a\u00020MJ\u0010\u0010\u0099\u0001\u001a\u00020\u00002\u0007\u0010\u009a\u0001\u001a\u00020\u0006J\u0010\u0010\u009b\u0001\u001a\u00020\u00002\u0007\u0010\u008a\u0001\u001a\u00020\u0006J\u0010\u0010\u009c\u0001\u001a\u00020\u00002\u0007\u0010\u009d\u0001\u001a\u00020MJ\u0010\u0010\u009e\u0001\u001a\u00020\u00002\u0007\u0010\u009f\u0001\u001a\u00020\u0013J\u0010\u0010 \u0001\u001a\u00020\u00002\u0007\u0010¡\u0001\u001a\u00020\u0006J\u0010\u0010¢\u0001\u001a\u00020\u00002\u0007\u0010¡\u0001\u001a\u00020\u0006J\u0010\u0010£\u0001\u001a\u00020\u00002\u0007\u0010¤\u0001\u001a\u00020[J\u0010\u0010¥\u0001\u001a\u00020\u00002\u0007\u0010\u008a\u0001\u001a\u00020\u0006J\u0010\u0010¦\u0001\u001a\u00020\u00002\u0007\u0010§\u0001\u001a\u00020]J\u0010\u0010¨\u0001\u001a\u00020\u00002\u0007\u0010§\u0001\u001a\u00020_J\u0010\u0010©\u0001\u001a\u00020\u00002\u0007\u0010§\u0001\u001a\u00020aJ\u0010\u0010ª\u0001\u001a\u00020\u00002\u0007\u0010«\u0001\u001a\u00020cJ\u0010\u0010¬\u0001\u001a\u00020\u00002\u0007\u0010\u00ad\u0001\u001a\u00020eJ\u0010\u0010®\u0001\u001a\u00020\u00002\u0007\u0010¯\u0001\u001a\u00020\u0006J\u0010\u0010°\u0001\u001a\u00020\u00002\u0007\u0010§\u0001\u001a\u00020VJ\u0010\u0010±\u0001\u001a\u00020\u00002\u0007\u0010²\u0001\u001a\u00020\u0006J\u0010\u0010³\u0001\u001a\u00020\u00002\u0007\u0010´\u0001\u001a\u00020gJ\t\u0010µ\u0001\u001a\u00020\u0018H\u0016J\u0010\u0010¶\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0·\u0001H\u0016J\u0014\u0010¸\u0001\u001a\u00020\u00062\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010º\u0001\u001a\t\u0012\u0004\u0012\u00020!0·\u0001H\u0016J\t\u0010»\u0001\u001a\u00020\u0006H\u0016J\b\u0010z\u001a\u00020\u0006H\u0016J\t\u0010¼\u0001\u001a\u00020\u0013H\u0016J\t\u0010½\u0001\u001a\u00020\u0013H\u0016J\u0011\u0010¾\u0001\u001a\n\u0012\u0004\u0012\u00020I\u0018\u000104H\u0016J\u000b\u0010¿\u0001\u001a\u0004\u0018\u00010*H\u0016J\u0017\u0010À\u0001\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.\u0018\u00010,H\u0016J\t\u0010Á\u0001\u001a\u00020-H\u0016J\u000b\u0010Â\u0001\u001a\u0004\u0018\u000101H\u0016J\t\u0010Ã\u0001\u001a\u00020\u0006H\u0016J\u000f\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020504H\u0016J\u000f\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u00020704H\u0016J\u000f\u0010Æ\u0001\u001a\b\u0012\u0004\u0012\u00020904H\u0016J\u000f\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020;04H\u0016J\u000f\u0010È\u0001\u001a\b\u0012\u0004\u0012\u00020=04H\u0016J\u000f\u0010É\u0001\u001a\b\u0012\u0004\u0012\u00020?04H\u0016J\u000f\u0010Ê\u0001\u001a\b\u0012\u0004\u0012\u00020A04H\u0016J\u000f\u0010Ë\u0001\u001a\b\u0012\u0004\u0012\u00020C04H\u0016J\u000f\u0010Ì\u0001\u001a\b\u0012\u0004\u0012\u00020E04H\u0016J\u000f\u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00020G04H\u0016J\t\u0010\u0094\u0001\u001a\u00020\u0006H\u0016J\t\u0010Î\u0001\u001a\u00020\u0006H\u0016J\t\u0010Ï\u0001\u001a\u00020\u0006H\u0016J\u000b\u0010Ð\u0001\u001a\u0004\u0018\u00010KH\u0016J\t\u0010Ñ\u0001\u001a\u00020MH\u0016J\t\u0010Ò\u0001\u001a\u00020\u0006H\u0016J\t\u0010Ó\u0001\u001a\u00020\u0006H\u0016J\t\u0010Ô\u0001\u001a\u00020MH\u0016J\t\u0010Õ\u0001\u001a\u00020\u0013H\u0016J\t\u0010Ö\u0001\u001a\u00020\u0006H\u0016J\b\u0010Y\u001a\u00020\u0006H\u0016J\u000b\u0010×\u0001\u001a\u0004\u0018\u00010[H\u0016J\u0010\u0010Ø\u0001\u001a\t\u0012\u0004\u0012\u00020]0·\u0001H\u0016J\u000b\u0010Ù\u0001\u001a\u0004\u0018\u00010_H\u0016J\u000b\u0010Ú\u0001\u001a\u0004\u0018\u00010aH\u0016J\t\u0010Û\u0001\u001a\u00020cH\u0016J\t\u0010Ü\u0001\u001a\u00020eH\u0016J\t\u0010Ý\u0001\u001a\u00020\u0006H\u0016J\t\u0010Þ\u0001\u001a\u00020\u0006H\u0016J\t\u0010ß\u0001\u001a\u00020\u0006H\u0016J\u000b\u0010à\u0001\u001a\u0004\u0018\u00010VH\u0016J\t\u0010á\u0001\u001a\u00020\u0006H\u0016J\t\u0010â\u0001\u001a\u00020gH\u0016J\n\u0010ã\u0001\u001a\u00030ä\u0001H\u0016J\t\u0010å\u0001\u001a\u00020gH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u0018@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020!0\u001dj\b\u0012\u0004\u0012\u00020!`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020504X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020704X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020904X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020;04X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020=04X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?04X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020A04X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020C04X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020E04X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020G04X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020I04X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\\\u001a\u0012\u0012\u0004\u0012\u00020]0\u001dj\b\u0012\u0004\u0012\u00020]`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006è\u0001"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask;", "Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask;", "Ltv/danmaku/video/playerservice/RecyclableObject;", "<init>", "()V", "recycledState", "", "value", "isRecycled", "()Z", "setRecycled", "(Z)V", "token", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask$Token;", "getToken$bilicardplayer_apinkDebug", "()Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask$Token;", "setToken$bilicardplayer_apinkDebug", "(Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask$Token;)V", "startIndex", "", "getStartIndex$bilicardplayer_apinkDebug", "()I", "setStartIndex$bilicardplayer_apinkDebug", "(I)V", "Landroid/view/ViewGroup;", "mContainer", "setMContainer", "(Landroid/view/ViewGroup;)V", "mPlayableParamsList", "Ljava/util/ArrayList;", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "Lkotlin/collections/ArrayList;", "mPlayerLayerDescriptors", "Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask$PlayerLayerDescriptor;", "mShouldShowWhenFirstRender", "mIsMute", "enablePreload", "mDanmakuIsInlineMode", "mDanmakuSwitchShareEnable", "mDesiredQuality", "mMaxQuality", "mCommonResolveTaskProvider", "Ltv/danmaku/biliplayerv2/service/resolve/CommonResolveTaskProvider;", "mControlContainerConfig", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "mInitializedControlContainerType", "mHardwareDelegate", "Lcom/bilibili/playerbizcommon/features/hardware/IHardwareDelegate;", "mEnableGravitySensor", "mControlContainerChangedCallbackInfo", "Ltv/danmaku/video/bilicardplayer/player/CardPlayerCallbacksInfo;", "Ltv/danmaku/video/bilicardplayer/IControlContainerChangedCallback;", "mControlContainerVisibleCallbackInfo", "Ltv/danmaku/video/bilicardplayer/IControlContainerVisibleCallback;", "mPlayerStateChangedCallbackInfo", "Ltv/danmaku/video/bilicardplayer/ICardPlaySateChangedCallback;", "mPlayerRenderCallbackInfo", "Ltv/danmaku/video/bilicardplayer/IPlayerRenderCallback;", "mPlayerSeekCallbackInfo", "Ltv/danmaku/video/bilicardplayer/IPlayerSeekCallback;", "mPlayerBufferingCallbackInfo", "Ltv/danmaku/video/bilicardplayer/ICardPlayBufferingCallback;", "mDanmakuVisibleCallbackInfo", "Ltv/danmaku/video/bilicardplayer/IDanmakuStateChangedCallback;", "mDanmakuParamsCallbackInfo", "Ltv/danmaku/video/bilicardplayer/IDanmakuParamsChangedCallback;", "mNetworkAlertCallbackInfo", "Ltv/danmaku/video/bilicardplayer/INetworkAlertCallback;", "mVideoEnvironmentChangedCallbackInfo", "Ltv/danmaku/video/bilicardplayer/IVideoEnvironmentChangedCallback;", "mInfoListeners", "Ltv/danmaku/video/bilicardplayer/ICardPlayerInfoListener;", "mHistoryReader", "Ltv/danmaku/video/bilicardplayer/player/IMediaHistoryReader;", "mStartPosition", "", "mNetworkAlertEnable", "mNetworkToastEnable", "mIsAutoShowControlContainer", "mFakeDuration", "mSharedRecordId", "isChronosEnable", "mUseTransparentLayer", "mMediaItemParamsInterceptor", "Ltv/danmaku/biliplayerv2/service/IMediaItemParamsInterceptor;", "mForbiddenInnerTouchEvent", "mResetAudioIndexEnable", "enableDaltonismFilter", "mCardTaskRepository", "Ltv/danmaku/video/bilicardplayer/CardTaskRepository;", "mSeekInterceptors", "Ltv/danmaku/biliplayerv2/service/ISeekInterceptor;", "mCurrentPositionInterceptor", "Ltv/danmaku/biliplayerv2/service/ICurrentPositionInterceptor;", "mDurationInterceptor", "Ltv/danmaku/biliplayerv2/service/IDurationInterceptor;", "danmakuInteractConf", "Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask$DanmakuInteractConf;", "reportScene", "Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask$CardPlayerReportScene;", "mLiveSocketScene", "", "forcePreload", "setContainer", "container", "addPlayableParams", "playableParams", "addPlayerLayer", "over", "Ltv/danmaku/biliplayerv2/panel/BuiltInLayer;", "layer", "Ltv/danmaku/video/bilicardplayer/CardPlayerLayer;", "setShowWhenFirstRender", "showWhenFirstRender", "addPlayerStateChangedCallback", "callback", "addPlayerRenderCallback", "addPlayerSeekCallback", "addPlayerBufferingCallback", "setMute", "isMute", "setDesiredQuality", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "setMaxQuality", "maxQuality", "addCardPlayInfoListener", "listener", "setCommonResolveTaskProvider", "taskProvider", "setControlContainerConfig", "config", "setControlContainerType", "type", "setHardwareDelegate", "delegate", "setGravitySensorEnable", "enable", "addControlContainerChangedCallback", "addControlContainerVisibleCallback", "addDanmakuStateChangedCallback", "addDanmakuParamsChangedCallback", "addNetworkAlertCallback", "addVideoEnvironmentChangedCallback", "setNetworkAlertEnable", "setNetworkToastEnable", "setAutoShowControlContainer", "isAutoShowControlContainer", "setMediaHistoryReader", "reader", "setStartPosition", "position", "setDanmakuInlineMode", "isInline", "setDanmakuSwitchShareEnable", "setCustomFakeDuration", "duration", "setSharedRecordId", "id", "setChronosEnable", "boolean", "setDaltonismFilterEnable", "setTaskRepository", "repository", "setResetAudioIndexEnable", "addSeekInterceptor", "interceptor", "setCurrentPositionInterceptor", "setDurationPositionInterceptor", "setDanmakuInteractConf", "conf", "setReportScene", LoginSceneProcessor.SCENE_KEY, "setLayerTransparent", "transparent", "setMediaItemSettingInterceptor", "forbiddenInnerTouchEvent", "forbidden", "setLiveSocketScene", "socketScene", "getContainer", "getPlayableParamsList", "", "different", "cardPlayTask", "getPlayerLayerDescriptors", "shouldShowWhenFirstRender", "getDesiredQuality", "getMaxQuality", "getCardPlayInfoListeners", "getCommonTaskProvider", "getControlContainerConfig", "getInitializedControlContainerType", "getHardwareDelegate", "enableGravitySensor", "getControlContainerChangedCallbacks", "getControlContainerVisibleCallbacks", "getPlayerStateChangedCallbacks", "getPlayerRenderCallbacks", "getPlayerSeekCallbacks", "getPlayerBufferingCallback", "getDanmakuStateChangedCallbacks", "getDanmakuParamsChangedCallbacks", "getNetworkAlertCallbacks", "getVideoEnvironmentChangedCallbacks", "enableNetworkAlert", "enableNetworkToast", "getMediaHistoryReader", "getStartPosition", "isDanmakuInlineMode", "isDanmakuSwitchShareEnable", "getCustomFakeDuration", "getSharedRecordId", "enableChronos", "getCardTaskRepository", "getSeekInterceptor", "getCurrentPositionInterceptor", "getDurationInterceptor", "getDanmakuInteractConf", "getCardPlayerReportScene", "enablePreLoad", "useTransparentLayer", "isInnerTouchEventForbidden", "getMediaItemSettingInterceptor", "enableResetAudioIndex", "getLiveScene", "recycle", "", "toString", "Companion", "Token", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CardPlayTask implements ICardPlayTask, RecyclableObject {
        public static final Companion Companion = new Companion(null);
        private static final Token INVALID_TOKEN = new Token(null);
        private boolean enablePreload;
        private boolean isChronosEnable;
        private CardTaskRepository mCardTaskRepository;
        private CommonResolveTaskProvider mCommonResolveTaskProvider;
        private ViewGroup mContainer;
        private Map<ControlContainerType, ControlContainerConfig> mControlContainerConfig;
        private ICurrentPositionInterceptor mCurrentPositionInterceptor;
        private boolean mDanmakuIsInlineMode;
        private boolean mDanmakuSwitchShareEnable;
        private IDurationInterceptor mDurationInterceptor;
        private boolean mEnableGravitySensor;
        private long mFakeDuration;
        private boolean mForbiddenInnerTouchEvent;
        private IHardwareDelegate mHardwareDelegate;
        private IMediaHistoryReader mHistoryReader;
        private boolean mIsAutoShowControlContainer;
        private IMediaItemParamsInterceptor mMediaItemParamsInterceptor;
        private boolean mResetAudioIndexEnable;
        private boolean mShouldShowWhenFirstRender;
        private long mStartPosition;
        private boolean mUseTransparentLayer;
        private boolean recycledState;
        private int startIndex;
        private Token token = INVALID_TOKEN;
        private final ArrayList<Video.PlayableParams> mPlayableParamsList = new ArrayList<>();
        private final ArrayList<ICardPlayTask.PlayerLayerDescriptor> mPlayerLayerDescriptors = new ArrayList<>();
        private boolean mIsMute = true;
        private int mDesiredQuality = 32;
        private int mMaxQuality = -1;
        private ControlContainerType mInitializedControlContainerType = ControlContainerType.INITIAL;
        private CardPlayerCallbacksInfo<IControlContainerChangedCallback> mControlContainerChangedCallbackInfo = new CardPlayerCallbacksInfo<>();
        private CardPlayerCallbacksInfo<IControlContainerVisibleCallback> mControlContainerVisibleCallbackInfo = new CardPlayerCallbacksInfo<>();
        private CardPlayerCallbacksInfo<ICardPlaySateChangedCallback> mPlayerStateChangedCallbackInfo = new CardPlayerCallbacksInfo<>();
        private CardPlayerCallbacksInfo<IPlayerRenderCallback> mPlayerRenderCallbackInfo = new CardPlayerCallbacksInfo<>();
        private CardPlayerCallbacksInfo<IPlayerSeekCallback> mPlayerSeekCallbackInfo = new CardPlayerCallbacksInfo<>();
        private CardPlayerCallbacksInfo<ICardPlayBufferingCallback> mPlayerBufferingCallbackInfo = new CardPlayerCallbacksInfo<>();
        private CardPlayerCallbacksInfo<IDanmakuStateChangedCallback> mDanmakuVisibleCallbackInfo = new CardPlayerCallbacksInfo<>();
        private CardPlayerCallbacksInfo<IDanmakuParamsChangedCallback> mDanmakuParamsCallbackInfo = new CardPlayerCallbacksInfo<>();
        private CardPlayerCallbacksInfo<INetworkAlertCallback> mNetworkAlertCallbackInfo = new CardPlayerCallbacksInfo<>();
        private CardPlayerCallbacksInfo<IVideoEnvironmentChangedCallback> mVideoEnvironmentChangedCallbackInfo = new CardPlayerCallbacksInfo<>();
        private CardPlayerCallbacksInfo<ICardPlayerInfoListener> mInfoListeners = new CardPlayerCallbacksInfo<>();
        private boolean mNetworkAlertEnable = true;
        private boolean mNetworkToastEnable = true;
        private int mSharedRecordId = -1;
        private boolean enableDaltonismFilter = true;
        private final ArrayList<ISeekInterceptor> mSeekInterceptors = new ArrayList<>(4);
        private ICardPlayTask.DanmakuInteractConf danmakuInteractConf = new ICardPlayTask.DanmakuInteractConf(true, false);
        private ICardPlayTask.CardPlayerReportScene reportScene = ICardPlayTask.CardPlayerReportScene.Inline;
        private String mLiveSocketScene = "";

        /* compiled from: BiliCardPlayerScene.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask$Companion;", "", "<init>", "()V", "INVALID_TOKEN", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask$Token;", "getINVALID_TOKEN", "()Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask$Token;", "obtain", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask;", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Token getINVALID_TOKEN() {
                return CardPlayTask.INVALID_TOKEN;
            }

            public final CardPlayTask obtain() {
                CardPlayerLog.i(BiliCardPlayerScene.TAG, "obtain cardPlayTask");
                CardPlayTask task = (CardPlayTask) BLPlayerService.Companion.getInstance().getRecyclableObjectPool().get(CardPlayTask.class);
                if (task == null) {
                    CardPlayerLog.i(BiliCardPlayerScene.TAG, "do not found a request from pool, create it");
                    return new CardPlayTask();
                }
                return task;
            }
        }

        @Override // tv.danmaku.video.playerservice.RecyclableObject
        public boolean isRecycled() {
            return this.recycledState;
        }

        @Override // tv.danmaku.video.playerservice.RecyclableObject
        public void setRecycled(boolean value) {
            this.recycledState = value;
        }

        public final Token getToken$bilicardplayer_apinkDebug() {
            return this.token;
        }

        public final void setToken$bilicardplayer_apinkDebug(Token token) {
            Intrinsics.checkNotNullParameter(token, "<set-?>");
            this.token = token;
        }

        public final int getStartIndex$bilicardplayer_apinkDebug() {
            return this.startIndex;
        }

        public final void setStartIndex$bilicardplayer_apinkDebug(int i) {
            this.startIndex = i;
        }

        private final void setMContainer(ViewGroup value) {
            this.mContainer = value;
            CardPlayerLog.i(BiliCardPlayerScene.TAG, "card play task container is set value: " + value);
        }

        public final CardPlayTask enablePreload(boolean forcePreload) {
            this.enablePreload = forcePreload;
            return this;
        }

        public final CardPlayTask setContainer(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            setMContainer(container);
            return this;
        }

        public final CardPlayTask addPlayableParams(Video.PlayableParams playableParams) {
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
            this.mPlayableParamsList.add(playableParams);
            return this;
        }

        public final CardPlayTask addPlayerLayer(BuiltInLayer over, CardPlayerLayer layer) {
            Intrinsics.checkNotNullParameter(over, "over");
            Intrinsics.checkNotNullParameter(layer, "layer");
            this.mPlayerLayerDescriptors.add(new ICardPlayTask.PlayerLayerDescriptor(over, layer));
            return this;
        }

        public final CardPlayTask setShowWhenFirstRender(boolean showWhenFirstRender) {
            this.mShouldShowWhenFirstRender = showWhenFirstRender;
            return this;
        }

        public final CardPlayTask addPlayerStateChangedCallback(ICardPlaySateChangedCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mPlayerStateChangedCallbackInfo.add(callback);
            return this;
        }

        public final CardPlayTask addPlayerRenderCallback(IPlayerRenderCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mPlayerRenderCallbackInfo.add(callback);
            return this;
        }

        public final CardPlayTask addPlayerSeekCallback(IPlayerSeekCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mPlayerSeekCallbackInfo.add(callback);
            return this;
        }

        public final CardPlayTask addPlayerBufferingCallback(ICardPlayBufferingCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mPlayerBufferingCallbackInfo.add(callback);
            return this;
        }

        public final CardPlayTask setMute(boolean isMute) {
            this.mIsMute = isMute;
            return this;
        }

        public final CardPlayTask setDesiredQuality(int quality) {
            this.mDesiredQuality = quality;
            return this;
        }

        public final CardPlayTask setMaxQuality(int maxQuality) {
            this.mMaxQuality = maxQuality;
            return this;
        }

        public final CardPlayTask addCardPlayInfoListener(ICardPlayerInfoListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mInfoListeners.add(listener);
            return this;
        }

        public final CardPlayTask setCommonResolveTaskProvider(CommonResolveTaskProvider taskProvider) {
            Intrinsics.checkNotNullParameter(taskProvider, "taskProvider");
            this.mCommonResolveTaskProvider = taskProvider;
            return this;
        }

        public final CardPlayTask setControlContainerConfig(Map<ControlContainerType, ControlContainerConfig> map) {
            Intrinsics.checkNotNullParameter(map, "config");
            this.mControlContainerConfig = map;
            return this;
        }

        public final CardPlayTask setControlContainerType(ControlContainerType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.mInitializedControlContainerType = type;
            return this;
        }

        public final CardPlayTask setHardwareDelegate(IHardwareDelegate delegate) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.mHardwareDelegate = delegate;
            return this;
        }

        public final CardPlayTask setGravitySensorEnable(boolean enable) {
            this.mEnableGravitySensor = enable;
            return this;
        }

        public final CardPlayTask addControlContainerChangedCallback(IControlContainerChangedCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mControlContainerChangedCallbackInfo.add(callback);
            return this;
        }

        public final CardPlayTask addControlContainerVisibleCallback(IControlContainerVisibleCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mControlContainerVisibleCallbackInfo.add(callback);
            return this;
        }

        public final CardPlayTask addDanmakuStateChangedCallback(IDanmakuStateChangedCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mDanmakuVisibleCallbackInfo.add(callback);
            return this;
        }

        public final CardPlayTask addDanmakuParamsChangedCallback(IDanmakuParamsChangedCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mDanmakuParamsCallbackInfo.add(callback);
            return this;
        }

        public final CardPlayTask addNetworkAlertCallback(INetworkAlertCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mNetworkAlertCallbackInfo.add(callback);
            return this;
        }

        public final CardPlayTask addVideoEnvironmentChangedCallback(IVideoEnvironmentChangedCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mVideoEnvironmentChangedCallbackInfo.add(callback);
            return this;
        }

        public final CardPlayTask setNetworkAlertEnable(boolean enable) {
            this.mNetworkAlertEnable = enable;
            return this;
        }

        public final CardPlayTask setNetworkToastEnable(boolean enable) {
            this.mNetworkToastEnable = enable;
            return this;
        }

        public final CardPlayTask setAutoShowControlContainer(boolean isAutoShowControlContainer) {
            this.mIsAutoShowControlContainer = isAutoShowControlContainer;
            return this;
        }

        public final CardPlayTask setMediaHistoryReader(IMediaHistoryReader reader) {
            this.mHistoryReader = reader;
            return this;
        }

        public final CardPlayTask setStartPosition(long position) {
            this.mStartPosition = position;
            return this;
        }

        public final CardPlayTask setDanmakuInlineMode(boolean isInline) {
            this.mDanmakuIsInlineMode = isInline;
            return this;
        }

        public final CardPlayTask setDanmakuSwitchShareEnable(boolean enable) {
            this.mDanmakuSwitchShareEnable = enable;
            return this;
        }

        public final CardPlayTask setCustomFakeDuration(long duration) {
            this.mFakeDuration = duration;
            return this;
        }

        public final CardPlayTask setSharedRecordId(int id) {
            this.mSharedRecordId = id;
            return this;
        }

        public final CardPlayTask setChronosEnable(boolean z) {
            this.isChronosEnable = z;
            return this;
        }

        public final CardPlayTask setDaltonismFilterEnable(boolean z) {
            this.enableDaltonismFilter = z;
            return this;
        }

        public final CardPlayTask setTaskRepository(CardTaskRepository repository) {
            Intrinsics.checkNotNullParameter(repository, "repository");
            this.mCardTaskRepository = repository;
            return this;
        }

        public final CardPlayTask setResetAudioIndexEnable(boolean enable) {
            this.mResetAudioIndexEnable = enable;
            return this;
        }

        public final CardPlayTask addSeekInterceptor(ISeekInterceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            if (!this.mSeekInterceptors.contains(interceptor)) {
                this.mSeekInterceptors.add(interceptor);
            }
            return this;
        }

        public final CardPlayTask setCurrentPositionInterceptor(ICurrentPositionInterceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this.mCurrentPositionInterceptor = interceptor;
            return this;
        }

        public final CardPlayTask setDurationPositionInterceptor(IDurationInterceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this.mDurationInterceptor = interceptor;
            return this;
        }

        public final CardPlayTask setDanmakuInteractConf(ICardPlayTask.DanmakuInteractConf conf) {
            Intrinsics.checkNotNullParameter(conf, "conf");
            this.danmakuInteractConf = conf;
            return this;
        }

        public final CardPlayTask setReportScene(ICardPlayTask.CardPlayerReportScene scene) {
            Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
            this.reportScene = scene;
            return this;
        }

        public final CardPlayTask setLayerTransparent(boolean transparent) {
            this.mUseTransparentLayer = transparent;
            return this;
        }

        public final CardPlayTask setMediaItemSettingInterceptor(IMediaItemParamsInterceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this.mMediaItemParamsInterceptor = interceptor;
            return this;
        }

        public final CardPlayTask forbiddenInnerTouchEvent(boolean forbidden) {
            this.mForbiddenInnerTouchEvent = forbidden;
            return this;
        }

        public final CardPlayTask setLiveSocketScene(String socketScene) {
            Intrinsics.checkNotNullParameter(socketScene, "socketScene");
            this.mLiveSocketScene = socketScene;
            return this;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public ViewGroup getContainer() {
            ViewGroup container = this.mContainer;
            if (container == null) {
                throw new IllegalArgumentException("card play task can not use null container");
            }
            return container;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public List<Video.PlayableParams> getPlayableParamsList() {
            return this.mPlayableParamsList;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean different(ICardPlayTask cardPlayTask) {
            if (cardPlayTask instanceof CardPlayTask) {
                return !Intrinsics.areEqual(((CardPlayTask) cardPlayTask).token, this.token);
            }
            return true;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public List<ICardPlayTask.PlayerLayerDescriptor> getPlayerLayerDescriptors() {
            return this.mPlayerLayerDescriptors;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean shouldShowWhenFirstRender() {
            return this.mShouldShowWhenFirstRender;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean isMute() {
            return this.mIsMute;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public int getDesiredQuality() {
            return this.mDesiredQuality;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public int getMaxQuality() {
            return this.mMaxQuality;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public CardPlayerCallbacksInfo<ICardPlayerInfoListener> getCardPlayInfoListeners() {
            return this.mInfoListeners;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public CommonResolveTaskProvider getCommonTaskProvider() {
            return this.mCommonResolveTaskProvider;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public Map<ControlContainerType, ControlContainerConfig> getControlContainerConfig() {
            return this.mControlContainerConfig;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public ControlContainerType getInitializedControlContainerType() {
            return this.mInitializedControlContainerType;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public IHardwareDelegate getHardwareDelegate() {
            return this.mHardwareDelegate;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean enableGravitySensor() {
            return this.mEnableGravitySensor;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public CardPlayerCallbacksInfo<IControlContainerChangedCallback> getControlContainerChangedCallbacks() {
            return this.mControlContainerChangedCallbackInfo;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public CardPlayerCallbacksInfo<IControlContainerVisibleCallback> getControlContainerVisibleCallbacks() {
            return this.mControlContainerVisibleCallbackInfo;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public CardPlayerCallbacksInfo<ICardPlaySateChangedCallback> getPlayerStateChangedCallbacks() {
            return this.mPlayerStateChangedCallbackInfo;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public CardPlayerCallbacksInfo<IPlayerRenderCallback> getPlayerRenderCallbacks() {
            return this.mPlayerRenderCallbackInfo;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public CardPlayerCallbacksInfo<IPlayerSeekCallback> getPlayerSeekCallbacks() {
            return this.mPlayerSeekCallbackInfo;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public CardPlayerCallbacksInfo<ICardPlayBufferingCallback> getPlayerBufferingCallback() {
            return this.mPlayerBufferingCallbackInfo;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public CardPlayerCallbacksInfo<IDanmakuStateChangedCallback> getDanmakuStateChangedCallbacks() {
            return this.mDanmakuVisibleCallbackInfo;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public CardPlayerCallbacksInfo<IDanmakuParamsChangedCallback> getDanmakuParamsChangedCallbacks() {
            return this.mDanmakuParamsCallbackInfo;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public CardPlayerCallbacksInfo<INetworkAlertCallback> getNetworkAlertCallbacks() {
            return this.mNetworkAlertCallbackInfo;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public CardPlayerCallbacksInfo<IVideoEnvironmentChangedCallback> getVideoEnvironmentChangedCallbacks() {
            return this.mVideoEnvironmentChangedCallbackInfo;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean isAutoShowControlContainer() {
            return this.mIsAutoShowControlContainer;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean enableNetworkAlert() {
            return this.mNetworkAlertEnable;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean enableNetworkToast() {
            return this.mNetworkToastEnable;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public IMediaHistoryReader getMediaHistoryReader() {
            return this.mHistoryReader;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public long getStartPosition() {
            return this.mStartPosition;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean isDanmakuInlineMode() {
            return this.mDanmakuIsInlineMode;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean isDanmakuSwitchShareEnable() {
            return this.mDanmakuSwitchShareEnable;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public long getCustomFakeDuration() {
            return this.mFakeDuration;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public int getSharedRecordId() {
            return this.mSharedRecordId;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean enableChronos() {
            return this.isChronosEnable;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean enableDaltonismFilter() {
            return this.enableDaltonismFilter;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public CardTaskRepository getCardTaskRepository() {
            return this.mCardTaskRepository;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public List<ISeekInterceptor> getSeekInterceptor() {
            return this.mSeekInterceptors;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public ICurrentPositionInterceptor getCurrentPositionInterceptor() {
            return this.mCurrentPositionInterceptor;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public IDurationInterceptor getDurationInterceptor() {
            return this.mDurationInterceptor;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public ICardPlayTask.DanmakuInteractConf getDanmakuInteractConf() {
            return this.danmakuInteractConf;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public ICardPlayTask.CardPlayerReportScene getCardPlayerReportScene() {
            return this.reportScene;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean enablePreLoad() {
            return this.enablePreload;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean useTransparentLayer() {
            return this.mUseTransparentLayer;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean isInnerTouchEventForbidden() {
            return this.mForbiddenInnerTouchEvent;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public IMediaItemParamsInterceptor getMediaItemSettingInterceptor() {
            return this.mMediaItemParamsInterceptor;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public boolean enableResetAudioIndex() {
            return this.mResetAudioIndexEnable;
        }

        @Override // tv.danmaku.video.bilicardplayer.player.ICardPlayTask
        public String getLiveScene() {
            return this.mLiveSocketScene;
        }

        @Override // tv.danmaku.video.playerservice.RecyclableObject
        public void recycle() {
            setMContainer(null);
            this.mPlayableParamsList.clear();
            this.mShouldShowWhenFirstRender = false;
            this.mIsMute = true;
            this.mDanmakuIsInlineMode = false;
            this.mDanmakuSwitchShareEnable = false;
            this.mPlayerLayerDescriptors.clear();
            this.mPlayerStateChangedCallbackInfo.clear();
            this.mControlContainerChangedCallbackInfo.clear();
            this.mNetworkAlertCallbackInfo.clear();
            this.mVideoEnvironmentChangedCallbackInfo.clear();
            this.mDesiredQuality = 32;
            this.mMaxQuality = -1;
            this.mInfoListeners.clear();
            this.mCommonResolveTaskProvider = null;
            this.mControlContainerConfig = null;
            this.mInitializedControlContainerType = ControlContainerType.INITIAL;
            this.mHardwareDelegate = null;
            this.mEnableGravitySensor = false;
            this.mControlContainerVisibleCallbackInfo.clear();
            this.mPlayerRenderCallbackInfo.clear();
            this.mPlayerSeekCallbackInfo.clear();
            this.mDanmakuVisibleCallbackInfo.clear();
            this.mPlayerBufferingCallbackInfo.clear();
            this.mDanmakuParamsCallbackInfo.clear();
            this.mHistoryReader = null;
            this.mStartPosition = 0L;
            this.mNetworkToastEnable = true;
            this.mNetworkAlertEnable = true;
            this.mFakeDuration = 0L;
            this.mSharedRecordId = -1;
            this.token = INVALID_TOKEN;
            this.isChronosEnable = false;
            this.mCardTaskRepository = null;
            this.mSeekInterceptors.clear();
            this.mCurrentPositionInterceptor = null;
            this.mDurationInterceptor = null;
            this.danmakuInteractConf = new ICardPlayTask.DanmakuInteractConf(true, false);
            this.reportScene = ICardPlayTask.CardPlayerReportScene.Inline;
            this.mUseTransparentLayer = false;
            this.mMediaItemParamsInterceptor = null;
            this.mForbiddenInnerTouchEvent = false;
            this.mLiveSocketScene = "";
        }

        public String toString() {
            String obj = super.toString();
            return obj + "@token:" + this.token;
        }

        /* compiled from: BiliCardPlayerScene.kt */
        @Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\tH\u0016J:\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010&2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\t2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010/\u001a\u00020\t2\u0006\u0010,\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\t2\u0006\u0010,\u001a\u000200H\u0016J\u0010\u00102\u001a\u00020\t2\u0006\u0010,\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\t2\u0006\u0010,\u001a\u000203H\u0016J \u00105\u001a\u00020\t2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0016J\u0010\u0010:\u001a\u00020\t2\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010;\u001a\u00020\t2\u0006\u00106\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\t2\u0006\u00106\u001a\u00020<H\u0016J\u0018\u0010>\u001a\u00020\t2\u000e\u0010?\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030@H\u0016J\u0018\u0010A\u001a\u00020\t2\u000e\u0010?\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030@H\u0016J\n\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020FH\u0016J\u0012\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020*H\u0016J\n\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020KH\u0016J\u0012\u0010N\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010OH\u0016J\b\u0010P\u001a\u00020\tH\u0016J\u0010\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u001aH\u0016J\u0010\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020*H\u0016J\u0010\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020*H\u0016J\u0018\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0016J$\u0010\\\u001a\u00020\t2\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020*2\b\u0010`\u001a\u0004\u0018\u00010$H\u0016J\r\u0010a\u001a\u00020\tH\u0000¢\u0006\u0002\bbJ\u0010\u0010c\u001a\u00020\t2\u0006\u0010d\u001a\u00020*H\u0016J\u0010\u0010e\u001a\u00020\t2\u0006\u0010d\u001a\u00020*H\u0016J\b\u0010f\u001a\u00020\u000bH\u0016J\b\u0010g\u001a\u00020\u000bH\u0016J\b\u0010h\u001a\u00020\tH\u0016J\b\u0010i\u001a\u00020\tH\u0016J\b\u0010j\u001a\u00020\u001aH\u0016J\b\u0010k\u001a\u00020lH\u0016J\b\u0010m\u001a\u00020\u000bH\u0016J\b\u0010n\u001a\u00020\u000bH\u0016J\b\u0010o\u001a\u00020\tH\u0016J\b\u0010p\u001a\u00020\tH\u0016J\b\u0010q\u001a\u00020\tH\u0016J\u0010\u0010r\u001a\u00020\t2\u0006\u0010s\u001a\u00020*H\u0016J\b\u0010t\u001a\u00020\tH\u0016J\b\u0010u\u001a\u00020\tH\u0016J\u0006\u0010v\u001a\u00020*J\u0010\u0010w\u001a\u00020\t2\u0006\u0010x\u001a\u00020\u001aH\u0016J\u0010\u0010y\u001a\u00020\t2\u0006\u0010z\u001a\u00020lH\u0016J\n\u0010{\u001a\u0004\u0018\u00010|H\u0016J\u0010\u0010}\u001a\u00020\t2\u0006\u0010~\u001a\u00020*H\u0016J\u0011\u0010\u007f\u001a\u00020\t2\u0007\u00106\u001a\u00030\u0080\u0001H\u0016J\u0012\u0010\u0081\u0001\u001a\u00020\t2\u0007\u00106\u001a\u00030\u0080\u0001H\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\t2\u0007\u00106\u001a\u00030\u0083\u0001H\u0016J\u0012\u0010\u0084\u0001\u001a\u00020\t2\u0007\u00106\u001a\u00030\u0083\u0001H\u0016J\f\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0016J\t\u0010\u0087\u0001\u001a\u00020*H\u0016J\f\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0016J\u0012\u0010\u008a\u0001\u001a\u00020\t2\u0007\u0010\u008b\u0001\u001a\u00020*H\u0016J\t\u0010\u008c\u0001\u001a\u00020\tH\u0016J\t\u0010\u008d\u0001\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008e\u0001"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask$Token;", "Ltv/danmaku/video/bilicardplayer/ICardPlayerContext;", "mContext", "<init>", "(Ltv/danmaku/video/bilicardplayer/ICardPlayerContext;)V", "getDanmakuReportParams", "", "", "seekTo", "", "targetPosition", "", "setPlaySpeed", "speed", "", "getPlaySpeed", "hideBufferingView", "showBufferingView", "report", "event", "Ltv/danmaku/biliplayerv2/service/report/NeuronsEvents$Event;", "getCurrentPlayUrl", "takeVideoCapture", "callback", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "width", "", "height", "setAspectRatio", "ratio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "getVideoWidth", "getVideoHeight", "resetVideoFlip", "updateViewPort", "viewPort", "Landroid/graphics/Rect;", "builtInLayers", "", "Ltv/danmaku/biliplayerv2/panel/BuiltInLayer;", "customerLayers", "immediately", "", "addDoubleTapListener", "listener", "Lcom/bilibili/playerbizcommon/gesture/OnDoubleTapListener;", "removerDoubleTapListener", "addSingleTapListener", "Lcom/bilibili/playerbizcommon/gesture/OnSingleTapListener;", "removerSingleTapListener", "addLongPressListener", "Lcom/bilibili/playerbizcommon/gesture/OnLongPressListener;", "removeLongPressListener", "registerPlayerProgressRangeObserver", "observer", "Ltv/danmaku/biliplayerv2/clock/PlayerProgressRangeObserver;", "startPosition", "endPosition", "unregisterPlayerProgressRangeObserver", "registerPlayerProgressObserver", "Ltv/danmaku/biliplayerv2/service/PlayerProgressObserver;", "unregisterPlayerProgressObserver", "registerChronosMessageHandler", "handler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosRequestHandler;", "unregisterChronosMessageHandler", "getChronosRemoteHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IRemoteHandler;", "setVisibleRect", "visibleRect", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$VisibleRect;", "getMediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "autoCreate", "getMediaSessionPlayback", "Lcom/bilibili/playerbizcommon/mediasession/IMediaSessionPlayback;", "setMediaSessionPlayback", "playback", "setMediaSessionControllerCallback", "Lcom/bilibili/playerbizcommon/features/headset/MediaSessionControllerCallback;", "updateMediaSessionPlaybackState", "setRenderViewOffset", "offsetY", "blockBottomChronos", "block", "setDanmakuAvoidScript", "avoidScript", "setSceneAndBizParams", LoginSceneProcessor.SCENE_KEY, "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;", "biz", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosBiz;", "setBackgroundImage", "bitmap", "Landroid/graphics/Bitmap;", "recycle", "rect", "release", "release$bilicardplayer_apinkDebug", "showDanmaku", "fromUser", "hideDanmaku", "getCurrentPosition", "getRealCurrentPosition", "replay", "reload", "getPlayerState", "getCurrentControlContainerType", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "getDuration", "getRealDuration", "hideControl", "showControl", "pause", "setAudioOnly", "audioOnly", "resume", "stop", "isActive", "switchOrientation", "orientation", "setControlContainerType", "type", "getVideoEnvironment", "Lcom/bilibili/playerbizcommon/features/network/VideoEnvironment;", "setNetworkAlertEnable", "enable", "addCloudConfigObserver", "Ltv/danmaku/biliplayerv2/service/setting/ICloudConfigObserver;", "removeCloudConfigObserver", "addHeadsetEventObserver", "Lcom/bilibili/playerbizcommon/features/headset/IPlayerHeadsetEventCallback;", "removeHeadsetEventObserver", "getPlayerSettingCloudConfig", "Ltv/danmaku/biliplayerv2/utils/PlayerCloudConfig;", "isNetworkPanelShowed", "getCurrentPlayableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "setMute", "isMute", "allowToContinuePlay", "getBufferedPosition", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Token implements ICardPlayerContext {
            private ICardPlayerContext mContext;

            public Token(ICardPlayerContext mContext) {
                this.mContext = mContext;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public Map<String, String> getDanmakuReportParams() {
                Map<String, String> danmakuReportParams;
                ICardPlayerContext iCardPlayerContext = this.mContext;
                return (iCardPlayerContext == null || (danmakuReportParams = iCardPlayerContext.getDanmakuReportParams()) == null) ? MapsKt.emptyMap() : danmakuReportParams;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void seekTo(long targetPosition) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.seekTo(targetPosition);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void setPlaySpeed(float speed) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.setPlaySpeed(speed);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public float getPlaySpeed() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getPlaySpeed();
                }
                return 1.0f;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void hideBufferingView() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.hideBufferingView();
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void showBufferingView() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.showBufferingView();
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void report(NeuronsEvents.Event event) {
                Intrinsics.checkNotNullParameter(event, "event");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.report(event);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public String getCurrentPlayUrl() {
                String currentPlayUrl;
                ICardPlayerContext iCardPlayerContext = this.mContext;
                return (iCardPlayerContext == null || (currentPlayUrl = iCardPlayerContext.getCurrentPlayUrl()) == null) ? "" : currentPlayUrl;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void takeVideoCapture(IMediaPlayRenderContext.OnTakeVideoCapture callback, int width, int height) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.takeVideoCapture(callback, width, height);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void setAspectRatio(AspectRatio ratio) {
                Intrinsics.checkNotNullParameter(ratio, "ratio");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.setAspectRatio(ratio);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public int getVideoWidth() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getVideoWidth();
                }
                return 0;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public int getVideoHeight() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getVideoHeight();
                }
                return 0;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void resetVideoFlip() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.resetVideoFlip();
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void updateViewPort(Rect viewPort, List<? extends BuiltInLayer> list, List<String> list2, boolean immediately) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.updateViewPort(viewPort, list, list2, immediately);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void addDoubleTapListener(OnDoubleTapListener listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.addDoubleTapListener(listener);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void removerDoubleTapListener(OnDoubleTapListener listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.removerDoubleTapListener(listener);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void addSingleTapListener(OnSingleTapListener listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.addSingleTapListener(listener);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void removerSingleTapListener(OnSingleTapListener listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.removerSingleTapListener(listener);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void addLongPressListener(OnLongPressListener listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.addLongPressListener(listener);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void removeLongPressListener(OnLongPressListener listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.removeLongPressListener(listener);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void registerPlayerProgressRangeObserver(PlayerProgressRangeObserver observer, long startPosition, long endPosition) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.registerPlayerProgressRangeObserver(observer, startPosition, endPosition);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void unregisterPlayerProgressRangeObserver(PlayerProgressRangeObserver observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.unregisterPlayerProgressRangeObserver(observer);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void registerPlayerProgressObserver(PlayerProgressObserver observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.registerPlayerProgressObserver(observer);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void unregisterPlayerProgressObserver(PlayerProgressObserver observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.unregisterPlayerProgressObserver(observer);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void registerChronosMessageHandler(ChronosRequestHandler<?, ?> chronosRequestHandler) {
                Intrinsics.checkNotNullParameter(chronosRequestHandler, "handler");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.registerChronosMessageHandler(chronosRequestHandler);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void unregisterChronosMessageHandler(ChronosRequestHandler<?, ?> chronosRequestHandler) {
                Intrinsics.checkNotNullParameter(chronosRequestHandler, "handler");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.unregisterChronosMessageHandler(chronosRequestHandler);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public IRemoteHandler getChronosRemoteHandler() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getChronosRemoteHandler();
                }
                return null;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void setVisibleRect(DanmakuConfigChange.VisibleRect visibleRect) {
                Intrinsics.checkNotNullParameter(visibleRect, "visibleRect");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.setVisibleRect(visibleRect);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public MediaSessionCompat getMediaSession(boolean autoCreate) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getMediaSession(autoCreate);
                }
                return null;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public IMediaSessionPlayback getMediaSessionPlayback() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getMediaSessionPlayback();
                }
                return null;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void setMediaSessionPlayback(IMediaSessionPlayback playback) {
                Intrinsics.checkNotNullParameter(playback, "playback");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.setMediaSessionPlayback(playback);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void setMediaSessionControllerCallback(MediaSessionControllerCallback callback) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.setMediaSessionControllerCallback(callback);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void updateMediaSessionPlaybackState() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.updateMediaSessionPlaybackState();
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void setRenderViewOffset(int offsetY) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.setRenderViewOffset(offsetY);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void blockBottomChronos(boolean block) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.blockBottomChronos(block);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void setDanmakuAvoidScript(boolean avoidScript) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.setDanmakuAvoidScript(avoidScript);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void setSceneAndBizParams(ChronosScene scene, ChronosBiz biz) {
                Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
                Intrinsics.checkNotNullParameter(biz, "biz");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.setSceneAndBizParams(scene, biz);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void setBackgroundImage(Bitmap bitmap, boolean recycle, Rect rect) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.setBackgroundImage(bitmap, recycle, rect);
                }
            }

            public final void release$bilicardplayer_apinkDebug() {
                this.mContext = null;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void showDanmaku(boolean fromUser) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.showDanmaku(fromUser);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void hideDanmaku(boolean fromUser) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.hideDanmaku(fromUser);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public long getCurrentPosition() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getCurrentPosition();
                }
                return 0L;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public long getRealCurrentPosition() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getRealCurrentPosition();
                }
                return 0L;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void replay() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.replay();
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void reload() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.reload();
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public int getPlayerState() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getPlayerState();
                }
                return 0;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public ControlContainerType getCurrentControlContainerType() {
                ControlContainerType currentControlContainerType;
                ICardPlayerContext iCardPlayerContext = this.mContext;
                return (iCardPlayerContext == null || (currentControlContainerType = iCardPlayerContext.getCurrentControlContainerType()) == null) ? ControlContainerType.INITIAL : currentControlContainerType;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public long getDuration() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getDuration();
                }
                return 0L;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public long getRealDuration() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getRealDuration();
                }
                return 0L;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void hideControl() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.hideControl();
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void showControl() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.showControl();
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void pause() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.pause();
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void setAudioOnly(boolean audioOnly) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.setAudioOnly(audioOnly);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void resume() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.resume();
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void stop() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.stop();
                }
            }

            public final boolean isActive() {
                return this.mContext != null;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void switchOrientation(int orientation) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.switchOrientation(orientation);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void setControlContainerType(ControlContainerType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.setControlContainerType(type);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public VideoEnvironment getVideoEnvironment() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getVideoEnvironment();
                }
                return null;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void setNetworkAlertEnable(boolean enable) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.setNetworkAlertEnable(enable);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void addCloudConfigObserver(ICloudConfigObserver observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.addCloudConfigObserver(observer);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void removeCloudConfigObserver(ICloudConfigObserver observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.removeCloudConfigObserver(observer);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void addHeadsetEventObserver(IPlayerHeadsetEventCallback observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.addHeadsetEventObserver(observer);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void removeHeadsetEventObserver(IPlayerHeadsetEventCallback observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.removeHeadsetEventObserver(observer);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public PlayerCloudConfig getPlayerSettingCloudConfig() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getPlayerSettingCloudConfig();
                }
                return null;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public boolean isNetworkPanelShowed() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.isNetworkPanelShowed();
                }
                return false;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public Video.PlayableParams getCurrentPlayableParams() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getCurrentPlayableParams();
                }
                return null;
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void setMute(boolean isMute) {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.setMute(isMute);
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public void allowToContinuePlay() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    iCardPlayerContext.allowToContinuePlay();
                }
            }

            @Override // tv.danmaku.video.bilicardplayer.ICardPlayerContext
            public long getBufferedPosition() {
                ICardPlayerContext iCardPlayerContext = this.mContext;
                if (iCardPlayerContext != null) {
                    return iCardPlayerContext.getBufferedPosition();
                }
                return 0L;
            }
        }
    }
}