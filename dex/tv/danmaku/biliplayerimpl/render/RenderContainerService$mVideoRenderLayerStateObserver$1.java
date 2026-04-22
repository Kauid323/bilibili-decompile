package tv.danmaku.biliplayerimpl.render;

import kotlin.Metadata;
import tv.danmaku.biliplayerimpl.core.IPlayerRenderContextService;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.render.core.IVideoRenderLayer;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;

/* compiled from: RenderContainerServiceV2.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"tv/danmaku/biliplayerimpl/render/RenderContainerService$mVideoRenderLayerStateObserver$1", "Ltv/danmaku/render/core/IVideoRenderLayer$VideoRenderLayerStateObserver;", "onCreate", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RenderContainerService$mVideoRenderLayerStateObserver$1 implements IVideoRenderLayer.VideoRenderLayerStateObserver {
    final /* synthetic */ RenderContainerService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderContainerService$mVideoRenderLayerStateObserver$1(RenderContainerService $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer.VideoRenderLayerStateObserver
    public void onCreate() {
        Collections.SafeIteratorList safeIteratorList;
        boolean z;
        IPlayerRenderContextService mRenderContextService;
        safeIteratorList = this.this$0.mVideoRenderLayerStateList;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$mVideoRenderLayerStateObserver$1$$ExternalSyntheticLambda0
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IVideoRenderLayer.VideoRenderLayerStateObserver) obj).onCreate();
            }
        });
        z = this.this$0.mPendingKeepTransform;
        if (z) {
            mRenderContextService = this.this$0.getMRenderContextService();
            IMediaPlayRenderContext it = mRenderContextService.getRenderContext();
            it.rotate(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            it.scale(1.0f);
            it.translate(0, 0);
            this.this$0.mPendingKeepTransform = false;
        }
    }
}