package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: PreviewStub.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"PREVIEW_ROUTE", "", "PreviewStub", "", "(Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PreviewStubKt {
    public static final String PREVIEW_ROUTE = "bilibili://photonic/preview";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewStub$lambda$0(int i, Composer composer, int i2) {
        PreviewStub(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PreviewStub(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-112385976);
        ComposerKt.sourceInformation($composer2, "C(PreviewStub):PreviewStub.kt#n54g3c");
        if ($composer2.shouldExecute($changed != 0, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-112385976, $changed, -1, "kntr.common.photonic.aphro.ui.preview.PreviewStub (PreviewStub.kt:9)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.PreviewStubKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit PreviewStub$lambda$0;
                    PreviewStub$lambda$0 = PreviewStubKt.PreviewStub$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return PreviewStub$lambda$0;
                }
            });
        }
    }
}