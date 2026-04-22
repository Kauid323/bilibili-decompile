package tv.danmaku.render.core;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.render.core.IVideoRenderLayer;

/* compiled from: VideoRenderLayerFactory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0014\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0007H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H&J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\u000f"}, d2 = {"Ltv/danmaku/render/core/VideoRenderLayerFactory;", "", "<init>", "()V", "create", "Ltv/danmaku/render/core/IVideoRenderLayer;", "type", "Ltv/danmaku/render/core/IVideoRenderLayer$Type;", "onCreate", "match", "", "layer", "getDefaultLayerType", "renderLayer", "checkVideoLayerType", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class VideoRenderLayerFactory {
    public abstract IVideoRenderLayer.Type getDefaultLayerType();

    public abstract boolean match(IVideoRenderLayer.Type type, IVideoRenderLayer iVideoRenderLayer);

    public abstract IVideoRenderLayer onCreate(IVideoRenderLayer.Type type);

    public abstract IVideoRenderLayer.Type type(IVideoRenderLayer iVideoRenderLayer);

    public static /* synthetic */ IVideoRenderLayer create$default(VideoRenderLayerFactory videoRenderLayerFactory, IVideoRenderLayer.Type type, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                type = null;
            }
            return videoRenderLayerFactory.create(type);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
    }

    public final IVideoRenderLayer create(IVideoRenderLayer.Type type) {
        return onCreate(checkVideoLayerType(type));
    }

    public static /* synthetic */ IVideoRenderLayer onCreate$default(VideoRenderLayerFactory videoRenderLayerFactory, IVideoRenderLayer.Type type, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                type = null;
            }
            return videoRenderLayerFactory.onCreate(type);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCreate");
    }

    private final IVideoRenderLayer.Type checkVideoLayerType(IVideoRenderLayer.Type type) {
        if (IVideoRenderLayer.Companion.externalRenderSwitch()) {
            return type;
        }
        if (type == IVideoRenderLayer.Type.TypeSurfaceViewWithExternalRender) {
            return IVideoRenderLayer.Type.TypeTextureView;
        }
        if (type == IVideoRenderLayer.Type.TypeTextureViewWithExternalRender) {
            return IVideoRenderLayer.Type.TypeTextureView;
        }
        return type;
    }
}