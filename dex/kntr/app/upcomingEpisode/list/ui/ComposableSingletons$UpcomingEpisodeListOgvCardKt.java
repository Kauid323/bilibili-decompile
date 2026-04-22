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

/* compiled from: UpcomingEpisodeListOgvCard.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$UpcomingEpisodeListOgvCardKt {
    public static final ComposableSingletons$UpcomingEpisodeListOgvCardKt INSTANCE = new ComposableSingletons$UpcomingEpisodeListOgvCardKt();

    /* renamed from: lambda$-521174877  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f35lambda$521174877 = ComposableLambdaKt.composableLambdaInstance(-521174877, false, new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.ComposableSingletons$UpcomingEpisodeListOgvCardKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__521174877$lambda$0;
            lambda__521174877$lambda$0 = ComposableSingletons$UpcomingEpisodeListOgvCardKt.lambda__521174877$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__521174877$lambda$0;
        }
    });

    /* renamed from: lambda$-118491411  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f34lambda$118491411 = ComposableLambdaKt.composableLambdaInstance(-118491411, false, new Function4() { // from class: kntr.app.upcomingEpisode.list.ui.ComposableSingletons$UpcomingEpisodeListOgvCardKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__118491411$lambda$0;
            lambda__118491411$lambda$0 = ComposableSingletons$UpcomingEpisodeListOgvCardKt.lambda__118491411$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__118491411$lambda$0;
        }
    });

    /* renamed from: getLambda$-118491411$main_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m1231getLambda$118491411$main_debug() {
        return f34lambda$118491411;
    }

    /* renamed from: getLambda$-521174877$main_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1232getLambda$521174877$main_debug() {
        return f35lambda$521174877;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__118491411$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)127@4853L6,130@5039L6,122@4600L483:UpcomingEpisodeListOgvCard.kt#kr57tx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-118491411, $changed, -1, "kntr.app.upcomingEpisode.list.ui.ComposableSingletons$UpcomingEpisodeListOgvCardKt.lambda$-118491411.<anonymous> (UpcomingEpisodeListOgvCard.kt:122)");
        }
        TVPlaceHolderKt.m1876TVPlaceholderiJQMabo(BackgroundKt.background-bw27NRU(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_weak-0d7_KjU(), $composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__521174877$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C139@5427L6,142@5613L6,134@5174L483:UpcomingEpisodeListOgvCard.kt#kr57tx");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-521174877, $changed, -1, "kntr.app.upcomingEpisode.list.ui.ComposableSingletons$UpcomingEpisodeListOgvCardKt.lambda$-521174877.<anonymous> (UpcomingEpisodeListOgvCard.kt:134)");
            }
            TVPlaceHolderKt.m1876TVPlaceholderiJQMabo(BackgroundKt.background-bw27NRU(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_weak-0d7_KjU(), $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}