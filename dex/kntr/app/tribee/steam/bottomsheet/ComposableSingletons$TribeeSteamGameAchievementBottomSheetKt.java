package kntr.app.tribee.steam.bottomsheet;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSteamGameAchievementBottomSheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt {
    public static final ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt INSTANCE = new ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt();
    private static Function2<Composer, Integer, Unit> lambda$1815285321 = ComposableLambdaKt.composableLambdaInstance(1815285321, false, new Function2() { // from class: kntr.app.tribee.steam.bottomsheet.ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1815285321$lambda$0;
            lambda_1815285321$lambda$0 = ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt.lambda_1815285321$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1815285321$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$349045567 = ComposableLambdaKt.composableLambdaInstance(349045567, false, new Function4() { // from class: kntr.app.tribee.steam.bottomsheet.ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_349045567$lambda$0;
            lambda_349045567$lambda$0 = ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt.lambda_349045567$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_349045567$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1815285321$consume_debug() {
        return lambda$1815285321;
    }

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$349045567$consume_debug() {
        return lambda$349045567;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_349045567$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)125@5429L6,126@5496L185,120@5129L583:TribeeSteamGameAchievementBottomSheet.kt#vmcmav");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(349045567, $changed, -1, "kntr.app.tribee.steam.bottomsheet.ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt.lambda$349045567.<anonymous> (TribeeSteamGameAchievementBottomSheet.kt:120)");
        }
        Modifier modifier = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(96)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16))), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 425353688, "CC(remember):TribeeSteamGameAchievementBottomSheet.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.bottomsheet.ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit lambda_349045567$lambda$0$0$0;
                    lambda_349045567$lambda$0$0$0 = ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt.lambda_349045567$lambda$0$0$0((GraphicsLayerScope) obj);
                    return lambda_349045567$lambda$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        SpacerKt.Spacer(GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) it$iv), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_349045567$lambda$0$0$0(GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setTranslationX($this$graphicsLayer.toPx-0680j_4(Dp.constructor-impl(1)));
        $this$graphicsLayer.setTranslationY($this$graphicsLayer.toPx-0680j_4(Dp.constructor-impl(1)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1815285321$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C138@6115L6,139@6182L185,133@5815L583:TribeeSteamGameAchievementBottomSheet.kt#vmcmav");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1815285321, $changed, -1, "kntr.app.tribee.steam.bottomsheet.ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt.lambda$1815285321.<anonymous> (TribeeSteamGameAchievementBottomSheet.kt:133)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(96)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16))), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 732484194, "CC(remember):TribeeSteamGameAchievementBottomSheet.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.bottomsheet.ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit lambda_1815285321$lambda$0$0$0;
                        lambda_1815285321$lambda$0$0$0 = ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt.lambda_1815285321$lambda$0$0$0((GraphicsLayerScope) obj);
                        return lambda_1815285321$lambda$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) it$iv), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1815285321$lambda$0$0$0(GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setTranslationX($this$graphicsLayer.toPx-0680j_4(Dp.constructor-impl(1)));
        $this$graphicsLayer.setTranslationY($this$graphicsLayer.toPx-0680j_4(Dp.constructor-impl(1)));
        return Unit.INSTANCE;
    }
}