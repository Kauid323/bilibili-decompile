package tv.danmaku.biliplayerimpl.render;

import android.graphics.Bitmap;
import com.bilibili.droid.thread.HandlerThreads;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;

/* compiled from: RenderContainerServiceV2.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"tv/danmaku/biliplayerimpl/render/RenderContainerService$takeVideoCapture$1", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "onResult", "", "capture", "Landroid/graphics/Bitmap;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RenderContainerService$takeVideoCapture$1 implements IMediaPlayRenderContext.OnTakeVideoCapture {
    final /* synthetic */ IMediaPlayRenderContext.OnTakeVideoCapture $callback;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderContainerService$takeVideoCapture$1(IMediaPlayRenderContext.OnTakeVideoCapture $callback) {
        this.$callback = $callback;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext.OnTakeVideoCapture
    public void onResult(final Bitmap capture) {
        final IMediaPlayRenderContext.OnTakeVideoCapture onTakeVideoCapture = this.$callback;
        HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.biliplayerimpl.render.RenderContainerService$takeVideoCapture$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                IMediaPlayRenderContext.OnTakeVideoCapture.this.onResult(capture);
            }
        });
    }
}