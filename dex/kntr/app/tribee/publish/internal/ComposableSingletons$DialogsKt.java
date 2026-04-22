package kntr.app.tribee.publish.internal;

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
import srcs.app.tribee.publish.ui.generated.resources.Res;
import srcs.app.tribee.publish.ui.generated.resources.String0_commonMainKt;

/* compiled from: Dialogs.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$DialogsKt {
    public static final ComposableSingletons$DialogsKt INSTANCE = new ComposableSingletons$DialogsKt();

    /* renamed from: lambda$-138278110  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f17lambda$138278110 = ComposableLambdaKt.composableLambdaInstance(-138278110, false, new Function2() { // from class: kntr.app.tribee.publish.internal.ComposableSingletons$DialogsKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__138278110$lambda$0;
            lambda__138278110$lambda$0 = ComposableSingletons$DialogsKt.lambda__138278110$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__138278110$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1236181611 = ComposableLambdaKt.composableLambdaInstance(1236181611, false, new Function2() { // from class: kntr.app.tribee.publish.internal.ComposableSingletons$DialogsKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1236181611$lambda$0;
            lambda_1236181611$lambda$0 = ComposableSingletons$DialogsKt.lambda_1236181611$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1236181611$lambda$0;
        }
    });

    /* renamed from: getLambda$-138278110$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m903getLambda$138278110$ui_debug() {
        return f17lambda$138278110;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1236181611$ui_debug() {
        return lambda$1236181611;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__138278110$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C99@4096L62,100@4194L9,101@4244L6,98@4067L348:Dialogs.kt#1zy72f");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-138278110, $changed, -1, "kntr.app.tribee.publish.internal.ComposableSingletons$DialogsKt.lambda$-138278110.<anonymous> (Dialogs.kt:98)");
            }
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_publish_failed_image_content(Res.string.INSTANCE), $composer, 0), PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16b(), $composer, 0, 0, 130040);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1236181611$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C149@5871L54,150@5961L9,151@6011L6,148@5842L340:Dialogs.kt#1zy72f");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1236181611, $changed, -1, "kntr.app.tribee.publish.internal.ComposableSingletons$DialogsKt.lambda$1236181611.<anonymous> (Dialogs.kt:148)");
            }
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_edit_confirm_content(Res.string.INSTANCE), $composer, 0), PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16b(), $composer, 0, 0, 130040);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}