package kntr.app.cheese.space.product;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.bilibili.ogv.operation3.module.placeholder.TvImagePlaceholderKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheeseProductUi.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$CheeseProductUiKt {
    public static final ComposableSingletons$CheeseProductUiKt INSTANCE = new ComposableSingletons$CheeseProductUiKt();

    /* renamed from: lambda$-217572294  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f12lambda$217572294 = ComposableLambdaKt.composableLambdaInstance(-217572294, false, new Function2() { // from class: kntr.app.cheese.space.product.ComposableSingletons$CheeseProductUiKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__217572294$lambda$0;
            lambda__217572294$lambda$0 = ComposableSingletons$CheeseProductUiKt.lambda__217572294$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__217572294$lambda$0;
        }
    });

    /* renamed from: lambda$-354567248  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f13lambda$354567248 = ComposableLambdaKt.composableLambdaInstance(-354567248, false, new Function4() { // from class: kntr.app.cheese.space.product.ComposableSingletons$CheeseProductUiKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__354567248$lambda$0;
            lambda__354567248$lambda$0 = ComposableSingletons$CheeseProductUiKt.lambda__354567248$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__354567248$lambda$0;
        }
    });

    /* renamed from: getLambda$-217572294$space_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m584getLambda$217572294$space_debug() {
        return f12lambda$217572294;
    }

    /* renamed from: getLambda$-354567248$space_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m585getLambda$354567248$space_debug() {
        return f13lambda$354567248;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__217572294$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C198@6831L42:CheeseProductUi.kt#kcnsom");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-217572294, $changed, -1, "kntr.app.cheese.space.product.ComposableSingletons$CheeseProductUiKt.lambda$-217572294.<anonymous> (CheeseProductUi.kt:198)");
            }
            TvImagePlaceholderKt.TvImagePlaceholder(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__354567248$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)201@6949L42:CheeseProductUi.kt#kcnsom");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-354567248, $changed, -1, "kntr.app.cheese.space.product.ComposableSingletons$CheeseProductUiKt.lambda$-354567248.<anonymous> (CheeseProductUi.kt:201)");
        }
        TvImagePlaceholderKt.TvImagePlaceholder(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}