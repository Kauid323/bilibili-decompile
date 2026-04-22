package tv.danmaku.render.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;
import tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter;

/* compiled from: RenderLayerVisibilityChangedDispatcher.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/render/core/RenderLayerVisibilityChangedDispatcher;", "", "mRenderContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;", "<init>", "(Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;)V", "mIsVisibility", "", "dispatchVisibilityChanged", "", "visibility", "", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RenderLayerVisibilityChangedDispatcher {
    private boolean mIsVisibility;
    private final IMediaPlayRenderContext mRenderContext;

    public RenderLayerVisibilityChangedDispatcher(IMediaPlayRenderContext mRenderContext) {
        Intrinsics.checkNotNullParameter(mRenderContext, "mRenderContext");
        this.mRenderContext = mRenderContext;
    }

    public final void dispatchVisibilityChanged(int visibility) {
        boolean isVisibility = visibility == 0;
        if (this.mIsVisibility == isVisibility) {
            return;
        }
        this.mIsVisibility = isVisibility;
        this.mRenderContext.invokeOp(IMediaPlayAdapter.Ops.PerformVisibilityChanged, Boolean.valueOf(this.mIsVisibility));
    }
}