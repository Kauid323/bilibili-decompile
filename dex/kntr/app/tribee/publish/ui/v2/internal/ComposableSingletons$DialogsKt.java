package kntr.app.tribee.publish.ui.v2.internal;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.publishV2.ui.generated.resources.Res;
import srcs.app.tribee.publishV2.ui.generated.resources.String0_commonMainKt;

/* compiled from: Dialogs.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$DialogsKt {
    public static final ComposableSingletons$DialogsKt INSTANCE = new ComposableSingletons$DialogsKt();

    /* renamed from: lambda$-1865050566  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f18lambda$1865050566 = ComposableLambdaKt.composableLambdaInstance(-1865050566, false, new Function2() { // from class: kntr.app.tribee.publish.ui.v2.internal.ComposableSingletons$DialogsKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1865050566$lambda$0;
            lambda__1865050566$lambda$0 = ComposableSingletons$DialogsKt.lambda__1865050566$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1865050566$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$660796099 = ComposableLambdaKt.composableLambdaInstance(660796099, false, new Function2() { // from class: kntr.app.tribee.publish.ui.v2.internal.ComposableSingletons$DialogsKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_660796099$lambda$0;
            lambda_660796099$lambda$0 = ComposableSingletons$DialogsKt.lambda_660796099$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_660796099$lambda$0;
        }
    });

    /* renamed from: getLambda$-1865050566$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m957getLambda$1865050566$ui_debug() {
        return f18lambda$1865050566;
    }

    public final Function2<Composer, Integer, Unit> getLambda$660796099$ui_debug() {
        return lambda$660796099;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1865050566$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C105@4445L62,106@4547L9,107@4601L6,104@4412L372:Dialogs.kt#vjrpu9");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1865050566, $changed, -1, "kntr.app.tribee.publish.ui.v2.internal.ComposableSingletons$DialogsKt.lambda$-1865050566.<anonymous> (Dialogs.kt:104)");
            }
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_publish_failed_image_content(Res.string.INSTANCE), $composer, 0), PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16b(), $composer, 0, 0, 130040);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_660796099$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C163@6606L54,164@6700L9,165@6754L6,162@6573L364:Dialogs.kt#vjrpu9");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(660796099, $changed, -1, "kntr.app.tribee.publish.ui.v2.internal.ComposableSingletons$DialogsKt.lambda$660796099.<anonymous> (Dialogs.kt:162)");
            }
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_edit_confirm_content(Res.string.INSTANCE), $composer, 0), PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16b(), $composer, 0, 0, 130040);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}