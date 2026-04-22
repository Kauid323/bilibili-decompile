package tv.danmaku.biliplayerv2.service.interact.biz.broadcast;

import android.text.TextUtils;
import com.bapis.bilibili.broadcast.message.main.CommandDm;
import com.bapis.bilibili.broadcast.message.main.DanmakuElem;
import com.bapis.bilibili.broadcast.message.main.DanmukuEvent;
import com.bapis.bilibili.broadcast.v1.BroadcastRoomMoss;
import com.bapis.bilibili.broadcast.v1.RoomJoinEvent;
import com.bapis.bilibili.broadcast.v1.RoomLeaveEvent;
import com.bapis.bilibili.broadcast.v1.RoomReq;
import com.bapis.bilibili.broadcast.v1.RoomResp;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import com.bilibili.lib.moss.util.any.AnyKt;
import com.google.protobuf.Any;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.service.IPlayDirector;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.LifecycleObserver;
import tv.danmaku.biliplayerv2.service.LifecycleState;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.VideoDirectorObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.EntryScannerKt;

/* compiled from: DanmakuBroadcastService.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0004\u0017\u001a\u001d \u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020#H\u0016J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u000eH\u0016J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0012\u0010.\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0014\u00101\u001a\u00020#2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u00103\u001a\u00020#H\u0002J\u0010\u00104\u001a\u00020#2\u0006\u00102\u001a\u00020\u0005H\u0002J\u0010\u00105\u001a\u00020#2\u0006\u00102\u001a\u00020\u0005H\u0002J\u0010\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u0015H\u0002J\n\u00108\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u0006:"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/broadcast/DanmakuBroadcastService;", "Ltv/danmaku/biliplayerv2/service/interact/biz/broadcast/IOnlineDanmakuService;", "<init>", "()V", "DANMUKU_EVENT_PATH", "", "DANMUKU_COMMOND_PATH", "mWeakPlayerController", "Ljava/lang/ref/WeakReference;", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mWeekVideosPlayDirectorService", "Ltv/danmaku/biliplayerv2/service/IPlayDirector;", "mRoomId", "mOnlineDanmakuState", "", "mInBackground", "mRoomReqHandler", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "Lcom/bapis/bilibili/broadcast/v1/RoomReq;", "mMessageCache", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bapis/bilibili/broadcast/v1/RoomResp;", "mRoomRespHandler", "tv/danmaku/biliplayerv2/service/interact/biz/broadcast/DanmakuBroadcastService$mRoomRespHandler$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/broadcast/DanmakuBroadcastService$mRoomRespHandler$1;", "mVideoPlayEventListener", "tv/danmaku/biliplayerv2/service/interact/biz/broadcast/DanmakuBroadcastService$mVideoPlayEventListener$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/broadcast/DanmakuBroadcastService$mVideoPlayEventListener$1;", "mLifecycleObserver", "tv/danmaku/biliplayerv2/service/interact/biz/broadcast/DanmakuBroadcastService$mLifecycleObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/broadcast/DanmakuBroadcastService$mLifecycleObserver$1;", "mPlayerStateObserver", "tv/danmaku/biliplayerv2/service/interact/biz/broadcast/DanmakuBroadcastService$mPlayerStateObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/broadcast/DanmakuBroadcastService$mPlayerStateObserver$1;", "onStart", "", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onStop", "bindPlayerContainer", "playerContainer", "setOnlineDanmaku", "state", "handBroadcastEvent", "event", "Lcom/bapis/bilibili/broadcast/message/main/DanmukuEvent;", "handBroadcastInteractEvent", "dm", "Lcom/bapis/bilibili/broadcast/message/main/CommandDm;", "joinRoom", "roomId", "leaveRoom", "joinRemoteRoom", "leaveRemoteRoom", "findInCache", "item", "getRoomID", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuBroadcastService implements IOnlineDanmakuService {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_CHECK_SIZE = 10;
    private static final String TAG = "DanmakuOnlineService";
    private boolean mInBackground;
    private String mRoomId;
    private MossResponseHandler<RoomReq> mRoomReqHandler;
    private WeakReference<PlayerContainer> mWeakPlayerController;
    private WeakReference<IPlayDirector> mWeekVideosPlayDirectorService;
    private final String DANMUKU_EVENT_PATH = "bilibili.broadcast.message.main.DanmukuEvent";
    private final String DANMUKU_COMMOND_PATH = "bilibili.broadcast.message.main.CommandDm";
    private boolean mOnlineDanmakuState = true;
    private CopyOnWriteArrayList<RoomResp> mMessageCache = new CopyOnWriteArrayList<>();
    private final DanmakuBroadcastService$mRoomRespHandler$1 mRoomRespHandler = new MossResponseHandler<RoomResp>() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.broadcast.DanmakuBroadcastService$mRoomRespHandler$1

        /* compiled from: DanmakuBroadcastService.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RoomResp.EventCase.values().length];
                try {
                    iArr[RoomResp.EventCase.JOIN.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[RoomResp.EventCase.MSG.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[RoomResp.EventCase.ERR.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ void onCompleted() {
            MossResponseHandler.-CC.$default$onCompleted(this);
        }

        public /* synthetic */ void onHeaders(Map map) {
            MossResponseHandler.-CC.$default$onHeaders(this, map);
        }

        public /* synthetic */ long onNextForAck(Object obj) {
            return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
        }

        public /* synthetic */ void onUpstreamAck(Long l) {
            MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
        }

        public /* synthetic */ void onValid() {
            MossResponseHandler.-CC.$default$onValid(this);
        }

        public void onNext(RoomResp value) {
            boolean findInCache;
            String str;
            String str2;
            if (value != null) {
                DanmakuBroadcastService danmakuBroadcastService = DanmakuBroadcastService.this;
                RoomResp.EventCase eventCase = value.getEventCase();
                switch (eventCase == null ? -1 : WhenMappings.$EnumSwitchMapping$0[eventCase.ordinal()]) {
                    case 1:
                        BLog.i("DanmakuOnlineService", "----- JOIN");
                        return;
                    case 2:
                        findInCache = danmakuBroadcastService.findInCache(value);
                        if (findInCache) {
                            return;
                        }
                        String targetPath = value.getMsg().getTargetPath();
                        str = danmakuBroadcastService.DANMUKU_COMMOND_PATH;
                        if (!Intrinsics.areEqual(targetPath, str)) {
                            str2 = danmakuBroadcastService.DANMUKU_EVENT_PATH;
                            if (Intrinsics.areEqual(targetPath, str2)) {
                                DanmukuEvent event = null;
                                try {
                                    Any body = value.getMsg().getBody();
                                    Intrinsics.checkNotNullExpressionValue(body, "getBody(...)");
                                    event = (DanmukuEvent) AnyKt.unpack(body, DanmukuEvent.class);
                                } catch (Exception e) {
                                    BLog.v("DanmakuOnlineService", "parseException");
                                }
                                danmakuBroadcastService.handBroadcastEvent(event);
                                return;
                            }
                            return;
                        }
                        CommandDm event2 = null;
                        try {
                            Any body2 = value.getMsg().getBody();
                            Intrinsics.checkNotNullExpressionValue(body2, "getBody(...)");
                            event2 = (CommandDm) AnyKt.unpack(body2, CommandDm.class);
                        } catch (Exception e2) {
                            BLog.v("DanmakuOnlineService", "parseException");
                        }
                        danmakuBroadcastService.handBroadcastInteractEvent(event2);
                        return;
                    case 3:
                        BLog.e("DanmakuOnlineService", "----- ERR");
                        return;
                    default:
                        BLog.e("DanmakuOnlineService", "----- INVALID EVENT CASE");
                        return;
                }
            }
        }

        public void onError(MossException t) {
            BLog.e("DanmakuOnlineService", "----- onError");
        }
    };
    private final DanmakuBroadcastService$mVideoPlayEventListener$1 mVideoPlayEventListener = new VideoDirectorObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.broadcast.DanmakuBroadcastService$mVideoPlayEventListener$1
        @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
        public /* synthetic */ void onItemCompleted(Video.PlayableParams playableParams) {
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        }

        @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
        public /* synthetic */ void onItemStart(Video.PlayableParams playableParams) {
            Intrinsics.checkNotNullParameter(playableParams, "item");
        }

        @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
        public /* synthetic */ void onPlayableParamsChanged(Video.PlayableParams playableParams) {
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        }

        @Override // tv.danmaku.biliplayerv2.service.ResolveListener
        public /* synthetic */ void onResolveFailed(Video.PlayableParams playableParams, String str) {
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        }

        @Override // tv.danmaku.biliplayerv2.service.ResolveListener
        public /* synthetic */ void onResolveSucceed(Video.PlayableParams playableParams) {
            Intrinsics.checkNotNullParameter(playableParams, "playableParams");
        }

        @Override // tv.danmaku.biliplayerv2.service.VideoDirectorObserver
        public void onItemWillChange(Video.PlayableParams playableParams, Video.PlayableParams old) {
            String str;
            String roomID;
            String str2;
            Intrinsics.checkNotNullParameter(playableParams, "new");
            str = DanmakuBroadcastService.this.mRoomId;
            if (str != null) {
                roomID = DanmakuBroadcastService.this.getRoomID();
                str2 = DanmakuBroadcastService.this.mRoomId;
                if (!TextUtils.equals(str2, roomID)) {
                    DanmakuBroadcastService.this.leaveRoom();
                }
            }
        }
    };
    private final DanmakuBroadcastService$mLifecycleObserver$1 mLifecycleObserver = new LifecycleObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.broadcast.DanmakuBroadcastService$mLifecycleObserver$1

        /* compiled from: DanmakuBroadcastService.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LifecycleState.values().length];
                try {
                    iArr[LifecycleState.ACTIVITY_RESUME.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[LifecycleState.ACTIVITY_PAUSE.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // tv.danmaku.biliplayerv2.service.LifecycleObserver
        public void onLifecycleChanged(LifecycleState state) {
            String str;
            Intrinsics.checkNotNullParameter(state, "state");
            switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                case 1:
                    DanmakuBroadcastService.this.mInBackground = false;
                    DanmakuBroadcastService.joinRoom$default(DanmakuBroadcastService.this, null, 1, null);
                    return;
                case 2:
                    DanmakuBroadcastService.this.mInBackground = true;
                    str = DanmakuBroadcastService.this.mRoomId;
                    if (str != null) {
                        DanmakuBroadcastService.this.leaveRoom();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final DanmakuBroadcastService$mPlayerStateObserver$1 mPlayerStateObserver = new PlayerStateObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.broadcast.DanmakuBroadcastService$mPlayerStateObserver$1
        @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
        public void onPlayerStateChanged(int state) {
            DanmakuBroadcastService.joinRoom$default(DanmakuBroadcastService.this, null, 1, null);
        }
    };

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onAttachByShared(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle) {
        Intrinsics.checkNotNullParameter(playerSharingType, "sharingType");
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onCollectSharedParams(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle) {
        IPlayerService.CC.$default$onCollectSharedParams(this, playerSharingType, playerSharingBundle);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onPlayerReset() {
        IPlayerService.CC.$default$onPlayerReset(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ PlayerServiceManager.ServiceConfig serviceConfig() {
        return IPlayerService.CC.$default$serviceConfig(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        WeakReference<PlayerContainer> weakReference = this.mWeakPlayerController;
        PlayerContainer playerContainer = weakReference != null ? weakReference.get() : null;
        if (playerContainer == null) {
            return;
        }
        this.mWeekVideosPlayDirectorService = new WeakReference<>(PlayerContainerKt.getPlayDirector(playerContainer));
        PlayerContainerKt.getPlayDirector(playerContainer).addVideoDirectorObserver(this.mVideoPlayEventListener);
        playerContainer.getPlayerCoreService().registerState(this.mPlayerStateObserver, 4);
        playerContainer.getActivityStateService().registerLifecycle(this.mLifecycleObserver, LifecycleState.ACTIVITY_RESUME, LifecycleState.ACTIVITY_PAUSE);
        joinRoom$default(this, null, 1, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        leaveRoom();
        this.mMessageCache.clear();
        WeakReference<PlayerContainer> weakReference = this.mWeakPlayerController;
        PlayerContainer playerContainer = weakReference != null ? weakReference.get() : null;
        if (playerContainer == null) {
            return;
        }
        PlayerContainerKt.getPlayDirector(playerContainer).removeVideoDirectorObserver(this.mVideoPlayEventListener);
        playerContainer.getActivityStateService().unregisterLifecycle(this.mLifecycleObserver);
        playerContainer.getPlayerCoreService().unregisterState(this.mPlayerStateObserver);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mWeakPlayerController = new WeakReference<>(playerContainer);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.broadcast.IOnlineDanmakuService
    public void setOnlineDanmaku(boolean state) {
        this.mOnlineDanmakuState = state;
        if (state) {
            joinRoom$default(this, null, 1, null);
        } else {
            leaveRoom();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handBroadcastEvent(DanmukuEvent event) {
        List dmList;
        if (event == null || (dmList = event.getElemsList()) == null) {
            return;
        }
        BLog.v(TAG, "handBroadcastEvent " + event);
        if (dmList.isEmpty()) {
            return;
        }
        List $this$forEach$iv = dmList;
        for (Object element$iv : $this$forEach$iv) {
            final DanmakuElem it = (DanmakuElem) element$iv;
            final AddCustomDanmaku.NormalExtra extra = new AddCustomDanmaku.NormalExtra();
            extra.setAppearanceTime(Long.valueOf(it.getProgress()));
            extra.setMode(Integer.valueOf(it.getMode()));
            extra.setFontSize(Integer.valueOf(it.getFontsize()));
            extra.setColor(Integer.valueOf(it.getColor() & DanmakuConfig.COLOR_DEFAULT));
            extra.setUserHash(it.getMidHash());
            extra.setContent(it.getContent());
            extra.setCtime(Long.valueOf(it.getCtime()));
            extra.setAction(it.getAction());
            extra.setPool(Integer.valueOf(it.getPool()));
            extra.setWeight(Integer.valueOf(it.getWeight()));
            extra.setAttr(Integer.valueOf(it.getAttr()));
            extra.setAnimation(it.getAnimation());
            HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.broadcast.DanmakuBroadcastService$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DanmakuBroadcastService.handBroadcastEvent$lambda$0$0(DanmakuBroadcastService.this, it, extra);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handBroadcastEvent$lambda$0$0(DanmakuBroadcastService this$0, DanmakuElem $it, AddCustomDanmaku.NormalExtra $extra) {
        PlayerContainer playerContainer;
        IInteractLayerService interactLayerService;
        WeakReference<PlayerContainer> weakReference = this$0.mWeakPlayerController;
        if (weakReference == null || (playerContainer = weakReference.get()) == null || (interactLayerService = playerContainer.getInteractLayerService()) == null) {
            return;
        }
        interactLayerService.addDanmaku($it.getIdStr(), 105, $extra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handBroadcastInteractEvent(final CommandDm dm) {
        if (dm == null) {
            return;
        }
        BLog.v(TAG, "handBroadcastInteractEvent " + dm);
        final AddCustomDanmaku.InteractExtra extra = new AddCustomDanmaku.InteractExtra();
        extra.setVideoId(String.valueOf(dm.getOid()));
        extra.setUserId(String.valueOf(dm.getMid()));
        extra.setType(Integer.valueOf(dm.getType()));
        extra.setCommand(dm.getCommand());
        extra.setContent(dm.getContent());
        extra.setState(Integer.valueOf(dm.getState()));
        extra.setAppearanceTime(Long.valueOf(dm.getProgress()));
        String ctime = dm.getCtime();
        Intrinsics.checkNotNullExpressionValue(ctime, "getCtime(...)");
        extra.setCtime(StringsKt.toLongOrNull(ctime));
        String mtime = dm.getMtime();
        Intrinsics.checkNotNullExpressionValue(mtime, "getMtime(...)");
        extra.setMtime(StringsKt.toLongOrNull(mtime));
        extra.setExtra(dm.getExtra());
        HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.broadcast.DanmakuBroadcastService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DanmakuBroadcastService.handBroadcastInteractEvent$lambda$0(DanmakuBroadcastService.this, dm, extra);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handBroadcastInteractEvent$lambda$0(DanmakuBroadcastService this$0, CommandDm $dm, AddCustomDanmaku.InteractExtra $extra) {
        PlayerContainer playerContainer;
        IInteractLayerService interactLayerService;
        WeakReference<PlayerContainer> weakReference = this$0.mWeakPlayerController;
        if (weakReference == null || (playerContainer = weakReference.get()) == null || (interactLayerService = playerContainer.getInteractLayerService()) == null) {
            return;
        }
        interactLayerService.addDanmaku($dm.getIdStr(), AddCustomDanmaku.TYPE_REAL_TIME_INTERACT, $extra);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void joinRoom$default(DanmakuBroadcastService danmakuBroadcastService, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        danmakuBroadcastService.joinRoom(str);
    }

    private final void joinRoom(String roomId) {
        BLog.e(TAG, "----- joinRoom");
        if (this.mOnlineDanmakuState && this.mRoomId == null && !this.mInBackground) {
            this.mRoomId = roomId == null ? getRoomID() : roomId;
            if (this.mRoomId != null) {
                String str = this.mRoomId;
                Intrinsics.checkNotNull(str);
                joinRemoteRoom(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void leaveRoom() {
        BLog.e(TAG, "----- leaveRoom");
        if (this.mRoomId != null) {
            final String roomID = this.mRoomId;
            Intrinsics.checkNotNull(roomID);
            HandlerThreads.post(2, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.broadcast.DanmakuBroadcastService$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    DanmakuBroadcastService.this.leaveRemoteRoom(roomID);
                }
            });
            this.mRoomId = null;
        }
    }

    private final void joinRemoteRoom(final String roomId) {
        BLog.e(TAG, "----- joinRoom:" + roomId);
        HandlerThreads.post(2, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.broadcast.DanmakuBroadcastService$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DanmakuBroadcastService.joinRemoteRoom$lambda$0(DanmakuBroadcastService.this, roomId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void joinRemoteRoom$lambda$0(DanmakuBroadcastService this$0, String $roomId) {
        this$0.mRoomReqHandler = new BroadcastRoomMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null).enter(this$0.mRoomRespHandler);
        RoomReq join = RoomReq.newBuilder().setId($roomId).setJoin(RoomJoinEvent.getDefaultInstance()).build();
        MossResponseHandler<RoomReq> mossResponseHandler = this$0.mRoomReqHandler;
        if (mossResponseHandler != null) {
            mossResponseHandler.onNext(join);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void leaveRemoteRoom(final String roomId) {
        BLog.e(TAG, "----- leaveRoom:" + roomId);
        HandlerThreads.post(2, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.broadcast.DanmakuBroadcastService$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                DanmakuBroadcastService.leaveRemoteRoom$lambda$0(roomId, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void leaveRemoteRoom$lambda$0(String $roomId, DanmakuBroadcastService this$0) {
        RoomReq leave = RoomReq.newBuilder().setId($roomId).setLeave(RoomLeaveEvent.getDefaultInstance()).build();
        MossResponseHandler<RoomReq> mossResponseHandler = this$0.mRoomReqHandler;
        if (mossResponseHandler != null) {
            mossResponseHandler.onNext(leave);
        }
        this$0.mRoomReqHandler = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean findInCache(RoomResp item) {
        if (this.mMessageCache.contains(item)) {
            return true;
        }
        if (this.mMessageCache.size() >= 10) {
            this.mMessageCache.remove(0);
        }
        this.mMessageCache.add(item);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getRoomID() {
        Video.DisplayParams displayParams;
        IPlayDirector iPlayDirector;
        WeakReference<IPlayDirector> weakReference = this.mWeekVideosPlayDirectorService;
        Video.PlayableParams playableParam = (weakReference == null || (iPlayDirector = weakReference.get()) == null) ? null : iPlayDirector.getCurrentPlayableParams();
        if (playableParam == null || (displayParams = playableParam.getDisplayParams()) == null) {
            return null;
        }
        return "video://" + displayParams.getAvid() + EntryScannerKt.PATH_SEPARATOR + displayParams.getCid();
    }

    /* compiled from: DanmakuBroadcastService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/broadcast/DanmakuBroadcastService$Companion;", "", "<init>", "()V", "TAG", "", "MAX_CHECK_SIZE", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}