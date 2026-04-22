package tv.danmaku.biliplayerimpl.render;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.render.core.IVideoRenderLayer;
import tv.danmaku.render.core.SurfaceVideoRenderLayer;
import tv.danmaku.render.core.SurfaceVideoRenderLayerWithExternalRender;
import tv.danmaku.render.core.TextureVideoRenderLayer;
import tv.danmaku.render.core.TextureVideoRenderLayerWithExternalRender;
import tv.danmaku.render.core.VideoRenderLayerFactory;

/* compiled from: DefaultVideoRenderLayerFactory.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/biliplayerimpl/render/DefaultVideoRenderLayerFactory;", "Ltv/danmaku/render/core/VideoRenderLayerFactory;", "mPlayerParams", "Ltv/danmaku/biliplayerv2/PlayerParamsV2;", "<init>", "(Ltv/danmaku/biliplayerv2/PlayerParamsV2;)V", "defaultType", "Ltv/danmaku/render/core/IVideoRenderLayer$Type;", "onCreate", "Ltv/danmaku/render/core/IVideoRenderLayer;", "type", "match", "", "layer", "getDefaultLayerType", "renderLayer", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DefaultVideoRenderLayerFactory extends VideoRenderLayerFactory {
    public static final Companion Companion = new Companion(null);
    private static final Map<IVideoRenderLayer.Type, Class<? extends IVideoRenderLayer>> TYPE_LAYER_MAPPER = MapsKt.mapOf(new Pair[]{new Pair(IVideoRenderLayer.Type.TypeSurfaceView, SurfaceVideoRenderLayer.class), new Pair(IVideoRenderLayer.Type.TypeTextureView, TextureVideoRenderLayer.class), new Pair(IVideoRenderLayer.Type.TypeSurfaceViewWithExternalRender, SurfaceVideoRenderLayerWithExternalRender.class), new Pair(IVideoRenderLayer.Type.TypeTextureViewWithExternalRender, TextureVideoRenderLayerWithExternalRender.class)});
    private IVideoRenderLayer.Type defaultType;
    private final PlayerParamsV2 mPlayerParams;

    public DefaultVideoRenderLayerFactory(PlayerParamsV2 mPlayerParams) {
        Intrinsics.checkNotNullParameter(mPlayerParams, "mPlayerParams");
        this.mPlayerParams = mPlayerParams;
    }

    /* compiled from: DefaultVideoRenderLayerFactory.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/biliplayerimpl/render/DefaultVideoRenderLayerFactory$Companion;", "", "<init>", "()V", "TYPE_LAYER_MAPPER", "", "Ltv/danmaku/render/core/IVideoRenderLayer$Type;", "Ljava/lang/Class;", "Ltv/danmaku/render/core/IVideoRenderLayer;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.render.core.VideoRenderLayerFactory
    public IVideoRenderLayer onCreate(IVideoRenderLayer.Type type) {
        IVideoRenderLayer.Type realType = type;
        if (realType == null) {
            realType = this.mPlayerParams.getConfig().getVideoRenderLayerType();
        }
        if (realType == null) {
            realType = getDefaultLayerType();
        }
        Class clazz = TYPE_LAYER_MAPPER.get(realType);
        if (clazz == null) {
            throw new IllegalArgumentException("do not found a suitable layer");
        }
        IVideoRenderLayer newInstance = clazz.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        return newInstance;
    }

    @Override // tv.danmaku.render.core.VideoRenderLayerFactory
    public boolean match(IVideoRenderLayer.Type type, IVideoRenderLayer layer) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(layer, "layer");
        return Intrinsics.areEqual(TYPE_LAYER_MAPPER.get(type), layer.getClass());
    }

    @Override // tv.danmaku.render.core.VideoRenderLayerFactory
    public IVideoRenderLayer.Type getDefaultLayerType() {
        IVideoRenderLayer.Type type;
        if (this.defaultType == null) {
            if (IVideoRenderLayer.Companion.enableExternalRender()) {
                type = IVideoRenderLayer.Type.TypeSurfaceViewWithExternalRender;
            } else {
                type = IVideoRenderLayer.Type.TypeTextureView;
            }
            this.defaultType = type;
        }
        IVideoRenderLayer.Type type2 = this.defaultType;
        Intrinsics.checkNotNull(type2);
        return type2;
    }

    @Override // tv.danmaku.render.core.VideoRenderLayerFactory
    public IVideoRenderLayer.Type type(IVideoRenderLayer renderLayer) {
        Intrinsics.checkNotNullParameter(renderLayer, "renderLayer");
        Class clazz = renderLayer.getClass();
        Object result = null;
        Map $this$forEach$iv = TYPE_LAYER_MAPPER;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            if (Intrinsics.areEqual(clazz, element$iv.getValue())) {
                result = element$iv.getKey();
            }
        }
        if (result == null) {
            throw new IllegalArgumentException("unknown renderLayer: " + renderLayer);
        }
        return (IVideoRenderLayer.Type) result;
    }
}