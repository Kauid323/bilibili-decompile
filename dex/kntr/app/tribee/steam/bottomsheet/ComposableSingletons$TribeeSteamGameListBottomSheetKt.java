package kntr.app.tribee.steam.bottomsheet;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSteamGameListBottomSheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$TribeeSteamGameListBottomSheetKt {
    public static final ComposableSingletons$TribeeSteamGameListBottomSheetKt INSTANCE = new ComposableSingletons$TribeeSteamGameListBottomSheetKt();

    /* renamed from: lambda$-1593982518  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f22lambda$1593982518 = ComposableLambdaKt.composableLambdaInstance(-1593982518, false, new Function2() { // from class: kntr.app.tribee.steam.bottomsheet.ComposableSingletons$TribeeSteamGameListBottomSheetKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1593982518$lambda$0;
            lambda__1593982518$lambda$0 = ComposableSingletons$TribeeSteamGameListBottomSheetKt.lambda__1593982518$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1593982518$lambda$0;
        }
    });

    /* renamed from: lambda$-395486016  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f23lambda$395486016 = ComposableLambdaKt.composableLambdaInstance(-395486016, false, new Function4() { // from class: kntr.app.tribee.steam.bottomsheet.ComposableSingletons$TribeeSteamGameListBottomSheetKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__395486016$lambda$0;
            lambda__395486016$lambda$0 = ComposableSingletons$TribeeSteamGameListBottomSheetKt.lambda__395486016$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__395486016$lambda$0;
        }
    });

    /* renamed from: getLambda$-1593982518$consume_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1099getLambda$1593982518$consume_debug() {
        return f22lambda$1593982518;
    }

    /* renamed from: getLambda$-395486016$consume_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m1100getLambda$395486016$consume_debug() {
        return f23lambda$395486016;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1593982518$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C128@5809L6,123@5521L468:TribeeSteamGameListBottomSheet.kt#vmcmav");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1593982518, $changed, -1, "kntr.app.tribee.steam.bottomsheet.ComposableSingletons$TribeeSteamGameListBottomSheetKt.lambda$-1593982518.<anonymous> (TribeeSteamGameListBottomSheet.kt:123)");
            }
            BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(64), Dp.constructor-impl(28)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__395486016$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)139@6389L6,134@6101L468:TribeeSteamGameListBottomSheet.kt#vmcmav");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-395486016, $changed, -1, "kntr.app.tribee.steam.bottomsheet.ComposableSingletons$TribeeSteamGameListBottomSheetKt.lambda$-395486016.<anonymous> (TribeeSteamGameListBottomSheet.kt:134)");
        }
        BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(64), Dp.constructor-impl(28)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}