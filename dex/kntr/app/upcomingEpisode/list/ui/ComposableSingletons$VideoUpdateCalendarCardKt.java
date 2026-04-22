package kntr.app.upcomingEpisode.list.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
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
import kntr.common.compose.res.TVPlaceHolderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoUpdateCalendarCard.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$VideoUpdateCalendarCardKt {
    public static final ComposableSingletons$VideoUpdateCalendarCardKt INSTANCE = new ComposableSingletons$VideoUpdateCalendarCardKt();
    private static Function2<Composer, Integer, Unit> lambda$1774088582 = ComposableLambdaKt.composableLambdaInstance(1774088582, false, new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.ComposableSingletons$VideoUpdateCalendarCardKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1774088582$lambda$0;
            lambda_1774088582$lambda$0 = ComposableSingletons$VideoUpdateCalendarCardKt.lambda_1774088582$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1774088582$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$1315202000 = ComposableLambdaKt.composableLambdaInstance(1315202000, false, new Function4() { // from class: kntr.app.upcomingEpisode.list.ui.ComposableSingletons$VideoUpdateCalendarCardKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_1315202000$lambda$0;
            lambda_1315202000$lambda$0 = ComposableSingletons$VideoUpdateCalendarCardKt.lambda_1315202000$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_1315202000$lambda$0;
        }
    });

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$1315202000$main_debug() {
        return lambda$1315202000;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1774088582$main_debug() {
        return lambda$1774088582;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1315202000$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)251@9478L6,254@9652L6,246@9245L447:VideoUpdateCalendarCard.kt#kr57tx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1315202000, $changed, -1, "kntr.app.upcomingEpisode.list.ui.ComposableSingletons$VideoUpdateCalendarCardKt.lambda$1315202000.<anonymous> (VideoUpdateCalendarCard.kt:246)");
        }
        TVPlaceHolderKt.m1876TVPlaceholderiJQMabo(BackgroundKt.background-bw27NRU(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_weak-0d7_KjU(), $composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1774088582$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C263@10004L6,266@10178L6,258@9771L447:VideoUpdateCalendarCard.kt#kr57tx");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1774088582, $changed, -1, "kntr.app.upcomingEpisode.list.ui.ComposableSingletons$VideoUpdateCalendarCardKt.lambda$1774088582.<anonymous> (VideoUpdateCalendarCard.kt:258)");
            }
            TVPlaceHolderKt.m1876TVPlaceholderiJQMabo(BackgroundKt.background-bw27NRU(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_weak-0d7_KjU(), $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}