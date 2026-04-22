package kntr.app.digital.backpack.card;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CategoriesService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$CategoriesServiceKt {
    public static final ComposableSingletons$CategoriesServiceKt INSTANCE = new ComposableSingletons$CategoriesServiceKt();

    /* renamed from: lambda$-1340450901  reason: not valid java name */
    private static Function3<LazyGridItemScope, Composer, Integer, Unit> f21lambda$1340450901 = ComposableLambdaKt.composableLambdaInstance(-1340450901, false, new Function3() { // from class: kntr.app.digital.backpack.card.ComposableSingletons$CategoriesServiceKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1340450901$lambda$0;
            lambda__1340450901$lambda$0 = ComposableSingletons$CategoriesServiceKt.lambda__1340450901$lambda$0((LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1340450901$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$720962461 = ComposableLambdaKt.composableLambdaInstance(720962461, false, new Function4() { // from class: kntr.app.digital.backpack.card.ComposableSingletons$CategoriesServiceKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_720962461$lambda$0;
            lambda_720962461$lambda$0 = ComposableSingletons$CategoriesServiceKt.lambda_720962461$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_720962461$lambda$0;
        }
    });

    /* renamed from: getLambda$-1340450901$backpack_debug  reason: not valid java name */
    public final Function3<LazyGridItemScope, Composer, Integer, Unit> m834getLambda$1340450901$backpack_debug() {
        return f21lambda$1340450901;
    }

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$720962461$backpack_debug() {
        return lambda$720962461;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1340450901$lambda$0(LazyGridItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C131@5501L387:CategoriesService.kt#7m94um");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1340450901, $changed, -1, "kntr.app.digital.backpack.card.ComposableSingletons$CategoriesServiceKt.lambda$-1340450901.<anonymous> (CategoriesService.kt:131)");
            }
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(13), 1, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(1)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_720962461$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)219@10192L271:CategoriesService.kt#7m94um");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(720962461, $changed, -1, "kntr.app.digital.backpack.card.ComposableSingletons$CategoriesServiceKt.lambda$720962461.<anonymous> (CategoriesService.kt:219)");
        }
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}