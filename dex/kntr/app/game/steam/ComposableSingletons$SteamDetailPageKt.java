package kntr.app.game.steam;

import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SteamDetailPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SteamDetailPageKt {
    public static final ComposableSingletons$SteamDetailPageKt INSTANCE = new ComposableSingletons$SteamDetailPageKt();
    private static Function2<Composer, Integer, Unit> lambda$687161177 = ComposableLambdaKt.composableLambdaInstance(687161177, false, new Function2() { // from class: kntr.app.game.steam.ComposableSingletons$SteamDetailPageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_687161177$lambda$0;
            lambda_687161177$lambda$0 = ComposableSingletons$SteamDetailPageKt.lambda_687161177$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_687161177$lambda$0;
        }
    });

    /* renamed from: lambda$-1477981277  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f28lambda$1477981277 = ComposableLambdaKt.composableLambdaInstance(-1477981277, false, new Function4() { // from class: kntr.app.game.steam.ComposableSingletons$SteamDetailPageKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__1477981277$lambda$0;
            lambda__1477981277$lambda$0 = ComposableSingletons$SteamDetailPageKt.lambda__1477981277$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__1477981277$lambda$0;
        }
    });

    /* renamed from: lambda$-1451404886  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f27lambda$1451404886 = ComposableLambdaKt.composableLambdaInstance(-1451404886, false, new Function2() { // from class: kntr.app.game.steam.ComposableSingletons$SteamDetailPageKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1451404886$lambda$0;
            lambda__1451404886$lambda$0 = ComposableSingletons$SteamDetailPageKt.lambda__1451404886$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1451404886$lambda$0;
        }
    });

    /* renamed from: getLambda$-1451404886$gamebiz_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1253getLambda$1451404886$gamebiz_debug() {
        return f27lambda$1451404886;
    }

    /* renamed from: getLambda$-1477981277$gamebiz_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m1254getLambda$1477981277$gamebiz_debug() {
        return f28lambda$1477981277;
    }

    public final Function2<Composer, Integer, Unit> getLambda$687161177$gamebiz_debug() {
        return lambda$687161177;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_687161177$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1235@50423L53:SteamDetailPage.kt#xy3gb6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(687161177, $changed, -1, "kntr.app.game.steam.ComposableSingletons$SteamDetailPageKt.lambda$687161177.<anonymous> (SteamDetailPage.kt:1235)");
            }
            SteamDetailPageKt.m1276SteamCoverPlaceHolderif577FI(Dp.constructor-impl(118), Dp.constructor-impl(55), null, $composer, 54, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1477981277$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)1236@50520L53:SteamDetailPage.kt#xy3gb6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1477981277, $changed, -1, "kntr.app.game.steam.ComposableSingletons$SteamDetailPageKt.lambda$-1477981277.<anonymous> (SteamDetailPage.kt:1236)");
        }
        SteamDetailPageKt.m1276SteamCoverPlaceHolderif577FI(Dp.constructor-impl(118), Dp.constructor-impl(55), null, $composer, 54, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1451404886$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1396@57372L19,1395@57327L156:SteamDetailPage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1451404886, $changed, -1, "kntr.app.game.steam.ComposableSingletons$SteamDetailPageKt.lambda$-1451404886.<anonymous> (SteamDetailPage.kt:1395)");
            }
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_left_line_500($composer, 6), RoomRecommendViewModel.EMPTY_CURSOR, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), $composer, Painter.$stable | 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}