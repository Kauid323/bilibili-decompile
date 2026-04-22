package tv.danmaku.biliplayer.preload.repository;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.transformer.IjkMediaItemTransformer;

/* compiled from: PreloadResolver.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
final /* synthetic */ class PreloadResolverKt$transformer$2 extends FunctionReferenceImpl implements Function0<IjkMediaItemTransformer> {
    public static final PreloadResolverKt$transformer$2 INSTANCE = new PreloadResolverKt$transformer$2();

    PreloadResolverKt$transformer$2() {
        super(0, IjkMediaItemTransformer.class, "<init>", "<init>()V", 0);
    }

    public final IjkMediaItemTransformer invoke() {
        return new IjkMediaItemTransformer();
    }
}