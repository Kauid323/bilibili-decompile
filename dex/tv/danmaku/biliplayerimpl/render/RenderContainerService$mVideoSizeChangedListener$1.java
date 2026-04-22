package tv.danmaku.biliplayerimpl.render;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.render.core.IVideoRenderLayer;

/* compiled from: RenderContainerServiceV2.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"tv/danmaku/biliplayerimpl/render/RenderContainerService$mVideoSizeChangedListener$1", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoSizeChangedListener;", "onChanged", "", "width", "", "height", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RenderContainerService$mVideoSizeChangedListener$1 implements IVideoRenderLayer.OnVideoSizeChangedListener {
    final /* synthetic */ RenderContainerService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderContainerService$mVideoSizeChangedListener$1(RenderContainerService $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer.OnVideoSizeChangedListener
    public void onChanged(final int width, final int height) {
        Collections.SafeIteratorList safeIteratorList;
        safeIteratorList = this.this$0.mVideoSizeChangedListeners;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$mVideoSizeChangedListener$1$$ExternalSyntheticLambda0
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IVideoRenderLayer.OnVideoSizeChangedListener) obj).onChanged(width, height);
            }
        });
    }
}