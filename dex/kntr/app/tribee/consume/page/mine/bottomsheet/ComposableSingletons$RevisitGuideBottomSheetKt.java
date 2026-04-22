package kntr.app.tribee.consume.page.mine.bottomsheet;

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

/* compiled from: RevisitGuideBottomSheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$RevisitGuideBottomSheetKt {
    public static final ComposableSingletons$RevisitGuideBottomSheetKt INSTANCE = new ComposableSingletons$RevisitGuideBottomSheetKt();
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$208110568 = ComposableLambdaKt.composableLambdaInstance(208110568, false, new Function4() { // from class: kntr.app.tribee.consume.page.mine.bottomsheet.ComposableSingletons$RevisitGuideBottomSheetKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_208110568$lambda$0;
            lambda_208110568$lambda$0 = ComposableSingletons$RevisitGuideBottomSheetKt.lambda_208110568$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_208110568$lambda$0;
        }
    });

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$208110568$consume_debug() {
        return lambda$208110568;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_208110568$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)85@3278L6,81@3082L265:RevisitGuideBottomSheet.kt#63y5ux");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(208110568, $changed, -1, "kntr.app.tribee.consume.page.mine.bottomsheet.ComposableSingletons$RevisitGuideBottomSheetKt.lambda$208110568.<anonymous> (RevisitGuideBottomSheet.kt:81)");
        }
        SpacerKt.Spacer(BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(297), Dp.constructor-impl(188)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg3-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}