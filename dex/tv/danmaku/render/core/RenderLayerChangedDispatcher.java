package tv.danmaku.render.core;

import android.view.Choreographer;
import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.render.core.IVideoRenderLayer;

/* compiled from: RenderLayerChangedDispatcher.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0010\u001a\u00020\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/render/core/RenderLayerChangedDispatcher;", "", "<init>", "()V", "mRenderLayerChangedListener", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoRenderLayerChangedListener;", "mChoreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "mFrameCallbackIsScheduled", "", "mFrameCallbacks", "Landroid/view/Choreographer$FrameCallback;", "setVideoRenderLayerChangedListener", "", "listener", "dispatchRenderLayerChanged", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RenderLayerChangedDispatcher {
    private boolean mFrameCallbackIsScheduled;
    private IVideoRenderLayer.OnVideoRenderLayerChangedListener mRenderLayerChangedListener;
    private Choreographer mChoreographer = Choreographer.getInstance();
    private final Choreographer.FrameCallback mFrameCallbacks = new Choreographer.FrameCallback() { // from class: tv.danmaku.render.core.RenderLayerChangedDispatcher$$ExternalSyntheticLambda0
        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j) {
            RenderLayerChangedDispatcher.mFrameCallbacks$lambda$0(RenderLayerChangedDispatcher.this, j);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mFrameCallbacks$lambda$0(RenderLayerChangedDispatcher this$0, long it) {
        BLog.d("frame callback time base: " + (it / 1000000));
        this$0.mFrameCallbackIsScheduled = false;
        IVideoRenderLayer.OnVideoRenderLayerChangedListener onVideoRenderLayerChangedListener = this$0.mRenderLayerChangedListener;
        if (onVideoRenderLayerChangedListener != null) {
            onVideoRenderLayerChangedListener.onChanged();
        }
    }

    public final void setVideoRenderLayerChangedListener(IVideoRenderLayer.OnVideoRenderLayerChangedListener listener) {
        this.mRenderLayerChangedListener = listener;
    }

    public final void dispatchRenderLayerChanged() {
        if (this.mFrameCallbackIsScheduled) {
            return;
        }
        this.mFrameCallbackIsScheduled = true;
        this.mChoreographer.postFrameCallback(this.mFrameCallbacks);
    }
}