package kntr.app.tribee.consume.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.LoopCount;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import srcs.app.tribee.consume.generated.resources.Res;

/* compiled from: TribeeJoinedSuccessfulBgImage.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"TribeeJoinedSuccessfulBgImage", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeJoinedSuccessfulBgImage_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeJoinedSuccessfulBgImage$lambda$1(Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeJoinedSuccessfulBgImage(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TribeeJoinedSuccessfulBgImage(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(94903662);
        ComposerKt.sourceInformation($composer2, "C(TribeeJoinedSuccessfulBgImage)N(modifier)13@471L233:TribeeJoinedSuccessfulBgImage.android.kt#iitu82");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(94903662, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeJoinedSuccessfulBgImage (TribeeJoinedSuccessfulBgImage.android.kt:12)");
            }
            String $this$asRequest$iv = Res.INSTANCE.getUri("files/tribee_joined_successful_bg.webp");
            ImageRequest $this$TribeeJoinedSuccessfulBgImage_u24lambda_u240 = new ImageRequest($this$asRequest$iv);
            $this$TribeeJoinedSuccessfulBgImage_u24lambda_u240.autoPlay(true);
            $this$TribeeJoinedSuccessfulBgImage_u24lambda_u240.m1485animateLoopCountSW3asMM(LoopCount.m1495constructorimpl(1));
            BiliImageKt.BiliImage($this$TribeeJoinedSuccessfulBgImage_u24lambda_u240.build(), modifier3, null, null, null, null, null, null, null, $composer2, ($dirty2 << 3) & 112, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeJoinedSuccessfulBgImage_androidKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeJoinedSuccessfulBgImage$lambda$1;
                    TribeeJoinedSuccessfulBgImage$lambda$1 = TribeeJoinedSuccessfulBgImage_androidKt.TribeeJoinedSuccessfulBgImage$lambda$1(modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeJoinedSuccessfulBgImage$lambda$1;
                }
            });
        }
    }
}