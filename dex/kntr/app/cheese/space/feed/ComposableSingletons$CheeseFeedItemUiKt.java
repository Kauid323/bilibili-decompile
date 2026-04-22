package kntr.app.cheese.space.feed;

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

/* compiled from: CheeseFeedItemUi.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$CheeseFeedItemUiKt {
    public static final ComposableSingletons$CheeseFeedItemUiKt INSTANCE = new ComposableSingletons$CheeseFeedItemUiKt();
    private static Function2<Composer, Integer, Unit> lambda$1634460557 = ComposableLambdaKt.composableLambdaInstance(1634460557, false, new Function2() { // from class: kntr.app.cheese.space.feed.ComposableSingletons$CheeseFeedItemUiKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1634460557$lambda$0;
            lambda_1634460557$lambda$0 = ComposableSingletons$CheeseFeedItemUiKt.lambda_1634460557$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1634460557$lambda$0;
        }
    });

    /* renamed from: lambda$-1798536189  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f10lambda$1798536189 = ComposableLambdaKt.composableLambdaInstance(-1798536189, false, new Function4() { // from class: kntr.app.cheese.space.feed.ComposableSingletons$CheeseFeedItemUiKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__1798536189$lambda$0;
            lambda__1798536189$lambda$0 = ComposableSingletons$CheeseFeedItemUiKt.lambda__1798536189$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__1798536189$lambda$0;
        }
    });

    /* renamed from: lambda$-1802886666  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f11lambda$1802886666 = ComposableLambdaKt.composableLambdaInstance(-1802886666, false, new Function2() { // from class: kntr.app.cheese.space.feed.ComposableSingletons$CheeseFeedItemUiKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1802886666$lambda$0;
            lambda__1802886666$lambda$0 = ComposableSingletons$CheeseFeedItemUiKt.lambda__1802886666$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1802886666$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$1917091052 = ComposableLambdaKt.composableLambdaInstance(1917091052, false, new Function4() { // from class: kntr.app.cheese.space.feed.ComposableSingletons$CheeseFeedItemUiKt$$ExternalSyntheticLambda3
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_1917091052$lambda$0;
            lambda_1917091052$lambda$0 = ComposableSingletons$CheeseFeedItemUiKt.lambda_1917091052$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_1917091052$lambda$0;
        }
    });

    /* renamed from: getLambda$-1798536189$space_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m571getLambda$1798536189$space_debug() {
        return f10lambda$1798536189;
    }

    /* renamed from: getLambda$-1802886666$space_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m572getLambda$1802886666$space_debug() {
        return f11lambda$1802886666;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1634460557$space_debug() {
        return lambda$1634460557;
    }

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$1917091052$space_debug() {
        return lambda$1917091052;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1634460557$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C40@1488L42:CheeseFeedItemUi.kt#co2v8d");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1634460557, $changed, -1, "kntr.app.cheese.space.feed.ComposableSingletons$CheeseFeedItemUiKt.lambda$1634460557.<anonymous> (CheeseFeedItemUi.kt:40)");
            }
            TvImagePlaceholderKt.TvImagePlaceholder(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1798536189$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)43@1606L42:CheeseFeedItemUi.kt#co2v8d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1798536189, $changed, -1, "kntr.app.cheese.space.feed.ComposableSingletons$CheeseFeedItemUiKt.lambda$-1798536189.<anonymous> (CheeseFeedItemUi.kt:43)");
        }
        TvImagePlaceholderKt.TvImagePlaceholder(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1802886666$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:CheeseFeedItemUi.kt#co2v8d");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1802886666, $changed, -1, "kntr.app.cheese.space.feed.ComposableSingletons$CheeseFeedItemUiKt.lambda$-1802886666.<anonymous> (CheeseFeedItemUi.kt:57)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1917091052$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it):CheeseFeedItemUi.kt#co2v8d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1917091052, $changed, -1, "kntr.app.cheese.space.feed.ComposableSingletons$CheeseFeedItemUiKt.lambda$1917091052.<anonymous> (CheeseFeedItemUi.kt:58)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}