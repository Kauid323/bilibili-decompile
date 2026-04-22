package kntr.app.tribee.operation.bottomsheet;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeStationListBottomSheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$TribeeStationListBottomSheetKt {
    public static final ComposableSingletons$TribeeStationListBottomSheetKt INSTANCE = new ComposableSingletons$TribeeStationListBottomSheetKt();
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$1393844440 = ComposableLambdaKt.composableLambdaInstance(1393844440, false, new Function4() { // from class: kntr.app.tribee.operation.bottomsheet.ComposableSingletons$TribeeStationListBottomSheetKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_1393844440$lambda$0;
            lambda_1393844440$lambda$0 = ComposableSingletons$TribeeStationListBottomSheetKt.lambda_1393844440$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_1393844440$lambda$0;
        }
    });

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$1393844440$operation_debug() {
        return lambda$1393844440;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1393844440$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)123@4799L6,118@4595L336:TribeeStationListBottomSheet.kt#k8oyq8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1393844440, $changed, -1, "kntr.app.tribee.operation.bottomsheet.ComposableSingletons$TribeeStationListBottomSheetKt.lambda$1393844440.<anonymous> (TribeeStationListBottomSheet.kt:118)");
        }
        SpacerKt.Spacer(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}