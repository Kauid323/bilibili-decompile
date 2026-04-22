package video.biz.offline.list.ui.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ImagePlaceHolder.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$ImagePlaceHolderKt {
    public static final ComposableSingletons$ImagePlaceHolderKt INSTANCE = new ComposableSingletons$ImagePlaceHolderKt();
    private static Function2<Composer, Integer, Unit> lambda$1802481785 = ComposableLambdaKt.composableLambdaInstance(1802481785, false, new Function2() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$ImagePlaceHolderKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1802481785$lambda$0;
            lambda_1802481785$lambda$0 = ComposableSingletons$ImagePlaceHolderKt.lambda_1802481785$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1802481785$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$621401839 = ComposableLambdaKt.composableLambdaInstance(621401839, false, new Function4() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$ImagePlaceHolderKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_621401839$lambda$0;
            lambda_621401839$lambda$0 = ComposableSingletons$ImagePlaceHolderKt.lambda_621401839$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_621401839$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1802481785$ui_debug() {
        return lambda$1802481785;
    }

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$621401839$ui_debug() {
        return lambda$621401839;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1802481785$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C28@1065L18:ImagePlaceHolder.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1802481785, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$ImagePlaceHolderKt.lambda$1802481785.<anonymous> (ImagePlaceHolder.kt:28)");
            }
            ImagePlaceHolderKt.ImagePlaceHolder(null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_621401839$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)31@1135L18:ImagePlaceHolder.kt#uys4uf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(621401839, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$ImagePlaceHolderKt.lambda$621401839.<anonymous> (ImagePlaceHolder.kt:31)");
        }
        ImagePlaceHolderKt.ImagePlaceHolder(null, $composer, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}