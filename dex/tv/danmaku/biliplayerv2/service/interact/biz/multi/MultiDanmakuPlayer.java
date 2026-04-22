package tv.danmaku.biliplayerv2.service.interact.biz.multi;

import androidx.lifecycle.Observer;
import com.bilibili.common.chronoscommon.EnhancedChronosRenderer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.service.IPlayDirector;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.biz.ViewProgressObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.SampleLocalServiceHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.IMediaPlayContext;

/* compiled from: MultiDanmakuPlayer.kt */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0013\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fJ\u0006\u0010\u001b\u001a\u00020\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/multi/MultiDanmakuPlayer;", "", "render", "Lcom/bilibili/common/chronoscommon/EnhancedChronosRenderer;", "localHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/SampleLocalServiceHandler;", "remoteHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IRemoteHandler;", "<init>", "(Lcom/bilibili/common/chronoscommon/EnhancedChronosRenderer;Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/SampleLocalServiceHandler;Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IRemoteHandler;)V", "getRender", "()Lcom/bilibili/common/chronoscommon/EnhancedChronosRenderer;", "getRemoteHandler", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/remote/IRemoteHandler;", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mMediaPlayContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext;", "mViewProgressObserver", "tv/danmaku/biliplayerv2/service/interact/biz/multi/MultiDanmakuPlayer$mViewProgressObserver$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/multi/MultiDanmakuPlayer$mViewProgressObserver$1;", "mSegmentSwitchObserver", "Landroidx/lifecycle/Observer;", "", "start", "", "playerContainer", "release", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MultiDanmakuPlayer {
    private final SampleLocalServiceHandler localHandler;
    private IMediaPlayContext mMediaPlayContext;
    private PlayerContainer mPlayerContainer;
    private final Observer<Boolean> mSegmentSwitchObserver;
    private final MultiDanmakuPlayer$mViewProgressObserver$1 mViewProgressObserver;
    private final IRemoteHandler remoteHandler;
    private final EnhancedChronosRenderer render;

    /* JADX WARN: Type inference failed for: r0v3, types: [tv.danmaku.biliplayerv2.service.interact.biz.multi.MultiDanmakuPlayer$mViewProgressObserver$1] */
    public MultiDanmakuPlayer(EnhancedChronosRenderer render, SampleLocalServiceHandler localHandler, IRemoteHandler remoteHandler) {
        Intrinsics.checkNotNullParameter(render, "render");
        Intrinsics.checkNotNullParameter(localHandler, "localHandler");
        Intrinsics.checkNotNullParameter(remoteHandler, "remoteHandler");
        this.render = render;
        this.localHandler = localHandler;
        this.remoteHandler = remoteHandler;
        this.mViewProgressObserver = new ViewProgressObserver() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.multi.MultiDanmakuPlayer$mViewProgressObserver$1
            @Override // tv.danmaku.biliplayerv2.service.interact.biz.ViewProgressObserver
            public void onUpdate(ViewProgressDetail viewProgressDetail) {
                PlayerContainer playerContainer;
                Video.DisplayParams displayParams;
                IPlayDirector playDirector;
                Video.PlayableParams currentPlayableParams;
                playerContainer = MultiDanmakuPlayer.this.mPlayerContainer;
                if (playerContainer == null || (playDirector = PlayerContainerKt.getPlayDirector(playerContainer)) == null || (currentPlayableParams = playDirector.getCurrentPlayableParams()) == null) {
                    displayParams = null;
                } else {
                    displayParams = currentPlayableParams.getDisplayParams();
                }
                if (displayParams == null) {
                    return;
                }
                MultiDanmakuPlayer.this.getRemoteHandler().configChronos(viewProgressDetail, displayParams.getAvid(), displayParams.getCid());
            }
        };
        this.mSegmentSwitchObserver = new Observer() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.multi.MultiDanmakuPlayer$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                MultiDanmakuPlayer.mSegmentSwitchObserver$lambda$0(MultiDanmakuPlayer.this, ((Boolean) obj).booleanValue());
            }
        };
    }

    public final IRemoteHandler getRemoteHandler() {
        return this.remoteHandler;
    }

    public final EnhancedChronosRenderer getRender() {
        return this.render;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSegmentSwitchObserver$lambda$0(MultiDanmakuPlayer this$0, boolean it) {
        this$0.remoteHandler.onSegmentSettingChanged(it);
    }

    public final void start(PlayerContainer playerContainer) {
        IInteractLayerService interactLayerService;
        IInteractLayerService interactLayerService2;
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
        this.localHandler.onBindPlayerContainer(playerContainer);
        this.localHandler.onStart(true);
        this.remoteHandler.onBindPlayerContainer(playerContainer);
        this.remoteHandler.onStart(true);
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 != null && (interactLayerService2 = playerContainer2.getInteractLayerService()) != null) {
            interactLayerService2.registerViewProgressObserver(this.mViewProgressObserver);
        }
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null || (interactLayerService = playerContainer3.getInteractLayerService()) == null) {
            return;
        }
        interactLayerService.addSegmentSwitchObserver(this.mSegmentSwitchObserver);
    }

    public final void release() {
        IInteractLayerService interactLayerService;
        IInteractLayerService interactLayerService2;
        this.render.release();
        this.localHandler.onStop();
        this.remoteHandler.onStop();
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer != null && (interactLayerService2 = playerContainer.getInteractLayerService()) != null) {
            interactLayerService2.unregisterViewProgressObserver(this.mViewProgressObserver);
        }
        PlayerContainer playerContainer2 = this.mPlayerContainer;
        if (playerContainer2 != null && (interactLayerService = playerContainer2.getInteractLayerService()) != null) {
            interactLayerService.removeSegmentSwitchObserver(this.mSegmentSwitchObserver);
        }
        this.mMediaPlayContext = null;
        this.mPlayerContainer = null;
    }
}