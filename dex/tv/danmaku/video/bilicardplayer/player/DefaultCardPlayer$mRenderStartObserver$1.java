package tv.danmaku.video.bilicardplayer.player;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.service.IRenderStartObserver;
import tv.danmaku.biliplayerv2.service.interact.biz.IInteractLayerService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.video.bilicardplayer.IPlayerRenderCallback;
import tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo;
import tv.danmaku.video.bilicardplayer.player.ICardPlayTask;

/* compiled from: DefaultCardPlayer.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$mRenderStartObserver$1", "Ltv/danmaku/biliplayerv2/service/IRenderStartObserver;", "onVideoRenderStart", "", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DefaultCardPlayer$mRenderStartObserver$1 implements IRenderStartObserver {
    final /* synthetic */ DefaultCardPlayer this$0;

    @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
    public /* synthetic */ void onAudioRenderStart() {
        IRenderStartObserver.CC.$default$onAudioRenderStart(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultCardPlayer$mRenderStartObserver$1(DefaultCardPlayer $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
    public void onVideoRenderStart() {
        ICardPlayTask iCardPlayTask;
        boolean z;
        ICardPlayTask iCardPlayTask2;
        CardPlayerCallbacksInfo callbacks;
        IPlayerContainer iPlayerContainer;
        ICardPlayTask iCardPlayTask3;
        IPlayerContainer iPlayerContainer2;
        this.this$0.showPlayerIfNeed();
        iCardPlayTask = this.this$0.mCardPlayTask;
        if (iCardPlayTask != null && iCardPlayTask.isAutoShowControlContainer()) {
            iPlayerContainer2 = this.this$0.mPlayerContainer;
            if (iPlayerContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer2 = null;
            }
            iPlayerContainer2.getControlContainerService().show();
        }
        z = this.this$0.mWaitRenderStart;
        if (z) {
            iPlayerContainer = this.this$0.mPlayerContainer;
            if (iPlayerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer = null;
            }
            IInteractLayerService interactLayerService = iPlayerContainer.getInteractLayerService();
            iCardPlayTask3 = this.this$0.mCardPlayTask;
            IInteractLayerService.CC.reloadViewProgress$default(interactLayerService, (iCardPlayTask3 != null ? iCardPlayTask3.getCardPlayerReportScene() : null) == ICardPlayTask.CardPlayerReportScene.Inline, null, 2, null);
            this.this$0.mWaitRenderStart = false;
        }
        iCardPlayTask2 = this.this$0.mCardPlayTask;
        if (iCardPlayTask2 == null || (callbacks = iCardPlayTask2.getPlayerRenderCallbacks()) == null) {
            return;
        }
        callbacks.visit(new CardPlayerCallbacksInfo.Visitor<IPlayerRenderCallback>() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$mRenderStartObserver$1$onVideoRenderStart$1
            @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerCallbacksInfo.Visitor
            public void onVisit(IPlayerRenderCallback callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                callback.onVideoRenderStart();
            }
        });
    }
}