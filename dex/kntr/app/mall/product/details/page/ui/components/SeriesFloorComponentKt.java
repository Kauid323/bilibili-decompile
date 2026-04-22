package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SeriesFloorComponent.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"SeriesFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SeriesFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeriesFloorComponent$lambda$0(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SeriesFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeriesFloorComponent$lambda$1(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SeriesFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SeriesFloorComponent(final ContentModule module, final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer2 = $composer.startRestartGroup(-327737214);
        ComposerKt.sourceInformation($composer2, "C(SeriesFloorComponent)N(module,pageViewModelWrapper,modifier):SeriesFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(module) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(pageViewModelWrapper) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if ((i & 4) != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-327737214, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.SeriesFloorComponent (SeriesFloorComponent.kt:12)");
            }
            if (module instanceof ContentModule.SeriesModule) {
                pageViewModelWrapper.getViewModel();
                ((ContentModule.SeriesModule) module).getData();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier2 = modifier;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SeriesFloorComponentKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SeriesFloorComponent$lambda$0;
                            SeriesFloorComponent$lambda$0 = SeriesFloorComponentKt.SeriesFloorComponent$lambda$0(ContentModule.this, pageViewModelWrapper, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return SeriesFloorComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier3 = modifier;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.SeriesFloorComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit SeriesFloorComponent$lambda$1;
                    SeriesFloorComponent$lambda$1 = SeriesFloorComponentKt.SeriesFloorComponent$lambda$1(ContentModule.this, pageViewModelWrapper, modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SeriesFloorComponent$lambda$1;
                }
            });
        }
    }
}