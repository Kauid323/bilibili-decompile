package kntr.base.imageloader;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BiliImage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$BiliImageKt {
    public static final ComposableSingletons$BiliImageKt INSTANCE = new ComposableSingletons$BiliImageKt();
    private static Function2<Composer, Integer, Unit> lambda$838573043 = ComposableLambdaKt.composableLambdaInstance(838573043, false, new Function2() { // from class: kntr.base.imageloader.ComposableSingletons$BiliImageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_838573043$lambda$0;
            lambda_838573043$lambda$0 = ComposableSingletons$BiliImageKt.lambda_838573043$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_838573043$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$1478878682 = ComposableLambdaKt.composableLambdaInstance(1478878682, false, new Function4() { // from class: kntr.base.imageloader.ComposableSingletons$BiliImageKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_1478878682$lambda$0;
            lambda_1478878682$lambda$0 = ComposableSingletons$BiliImageKt.lambda_1478878682$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_1478878682$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$331894858 = ComposableLambdaKt.composableLambdaInstance(331894858, false, new Function2() { // from class: kntr.base.imageloader.ComposableSingletons$BiliImageKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_331894858$lambda$0;
            lambda_331894858$lambda$0 = ComposableSingletons$BiliImageKt.lambda_331894858$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_331894858$lambda$0;
        }
    });

    /* renamed from: lambda$-826557967  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f44lambda$826557967 = ComposableLambdaKt.composableLambdaInstance(-826557967, false, new Function4() { // from class: kntr.base.imageloader.ComposableSingletons$BiliImageKt$$ExternalSyntheticLambda3
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__826557967$lambda$0;
            lambda__826557967$lambda$0 = ComposableSingletons$BiliImageKt.lambda__826557967$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__826557967$lambda$0;
        }
    });

    /* renamed from: getLambda$-826557967$imageloader_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m1447getLambda$826557967$imageloader_debug() {
        return f44lambda$826557967;
    }

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$1478878682$imageloader_debug() {
        return lambda$1478878682;
    }

    public final Function2<Composer, Integer, Unit> getLambda$331894858$imageloader_debug() {
        return lambda$331894858;
    }

    public final Function2<Composer, Integer, Unit> getLambda$838573043$imageloader_debug() {
        return lambda$838573043;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_838573043$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C41@1706L20:BiliImage.kt#2bx67y");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(838573043, $changed, -1, "kntr.base.imageloader.ComposableSingletons$BiliImageKt.lambda$838573043.<anonymous> (BiliImage.kt:41)");
            }
            BiliImageKt.DefaultPlaceHolder($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1478878682$lambda$0(ImageFailScope imageFailScope, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(imageFailScope, "<this>");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)42@1807L20:BiliImage.kt#2bx67y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1478878682, $changed, -1, "kntr.base.imageloader.ComposableSingletons$BiliImageKt.lambda$1478878682.<anonymous> (BiliImage.kt:42)");
        }
        BiliImageKt.DefaultPlaceHolder($composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_331894858$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C175@6049L20:BiliImage.kt#2bx67y");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(331894858, $changed, -1, "kntr.base.imageloader.ComposableSingletons$BiliImageKt.lambda$331894858.<anonymous> (BiliImage.kt:175)");
            }
            BiliImageKt.DefaultPlaceHolder($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__826557967$lambda$0(ImageFailScope imageFailScope, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(imageFailScope, "<this>");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)176@6150L20:BiliImage.kt#2bx67y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-826557967, $changed, -1, "kntr.base.imageloader.ComposableSingletons$BiliImageKt.lambda$-826557967.<anonymous> (BiliImage.kt:176)");
        }
        BiliImageKt.DefaultPlaceHolder($composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}