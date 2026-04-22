package kntr.common.share.common.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareLocalContext;
import kntr.common.share.common.SharePanelHandler;
import kntr.common.share.common.SharePanelStyle;
import kntr.common.share.common.ShareParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePanel.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"SharePanel", "", "params", "Lkntr/common/share/common/ShareParams;", "style", "Lkntr/common/share/common/SharePanelStyle;", "handler", "Lkotlin/Function1;", "Lkntr/common/share/common/SharePanelHandler;", "Lkotlin/ExtensionFunctionType;", "(Lkntr/common/share/common/ShareParams;Lkntr/common/share/common/SharePanelStyle;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "common-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SharePanelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SharePanel$lambda$1(ShareParams shareParams, SharePanelStyle sharePanelStyle, Function1 function1, int i, int i2, Composer composer, int i3) {
        SharePanel(shareParams, sharePanelStyle, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SharePanel(final ShareParams params, SharePanelStyle style, Function1<? super SharePanelHandler, Unit> function1, Composer $composer, final int $changed, final int i) {
        Function1 function12;
        Function1 handler;
        SharePanelStyle style2;
        int $dirty;
        int i2;
        SharePanelStyle style3 = style;
        Intrinsics.checkNotNullParameter(params, "params");
        Composer $composer2 = $composer.startRestartGroup(-334870594);
        ComposerKt.sourceInformation($composer2, "C(SharePanel)N(params,style,handler)18@551L21,19@598L29,20@655L115,20@632L138:SharePanel.kt#y4rqem");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer2.changed(params) : $composer2.changedInstance(params) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                if (($changed & 64) == 0 ? $composer2.changed(style3) : $composer2.changedInstance(style3)) {
                    i2 = 32;
                    $dirty2 |= i2;
                }
            }
            i2 = 16;
            $dirty2 |= i2;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            function12 = function1;
        } else if (($changed & 384) == 0) {
            function12 = function1;
            $dirty2 |= $composer2.changedInstance(function12) ? 256 : 128;
        } else {
            function12 = function1;
        }
        boolean z = true;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                $dirty = $dirty2;
                handler = function12;
                style2 = style3;
            } else {
                if ((i & 2) != 0) {
                    style3 = new SharePanelStyle(null, false, 3, null);
                    $dirty2 &= -113;
                }
                if (i3 == 0) {
                    $dirty = $dirty2;
                    handler = function12;
                    style2 = style3;
                } else {
                    style2 = style3;
                    $dirty = $dirty2;
                    handler = null;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-334870594, $dirty, -1, "kntr.common.share.common.ui.SharePanel (SharePanel.kt:17)");
            }
            ShareLocalContext ctx = SharePannel_androidKt.provideLocalContext($composer2, 0);
            State currentHandler = SnapshotStateKt.rememberUpdatedState(handler, $composer2, ($dirty >> 6) & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, 311914929, "CC(remember):SharePanel.kt#9igjgp");
            boolean changedInstance = $composer2.changedInstance(ctx) | (($dirty & 14) == 4 || (($dirty & 8) != 0 && $composer2.changedInstance(params)));
            if (((($dirty & 112) ^ 48) <= 32 || !$composer2.changedInstance(style2)) && ($dirty & 48) != 32) {
                z = false;
            }
            boolean invalid$iv = changedInstance | z | $composer2.changed(currentHandler);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new SharePanelKt$SharePanel$1$1(ctx, params, style2, currentHandler, null);
                $composer2.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(params, (Function2) value$iv, $composer2, ShareParams.$stable | ($dirty & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            handler = function12;
            style2 = style3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final SharePanelStyle sharePanelStyle = style2;
            final Function1 function13 = handler;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.SharePanelKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit SharePanel$lambda$1;
                    SharePanel$lambda$1 = SharePanelKt.SharePanel$lambda$1(ShareParams.this, sharePanelStyle, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SharePanel$lambda$1;
                }
            });
        }
    }
}