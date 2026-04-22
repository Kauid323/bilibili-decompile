package kntr.common.trio.systemui;

import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: ScrollToTop.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a)\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0002\u0010\u000b\"\u001d\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f²\u0006\f\u0010\r\u001a\u0004\u0018\u00010\u000eX\u008a\u008e\u0002"}, d2 = {"LocalScrollToTopRequestFlow", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkotlinx/coroutines/flow/Flow;", "", "getLocalScrollToTopRequestFlow", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "preferScrollToTop", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "scrollToTopRequestFlow", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/ScrollableState;Lkotlinx/coroutines/flow/Flow;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "trio_debug", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ScrollToTopKt {
    private static final ProvidableCompositionLocal<Flow<Unit>> LocalScrollToTopRequestFlow = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, new Function0() { // from class: kntr.common.trio.systemui.ScrollToTopKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            Flow LocalScrollToTopRequestFlow$lambda$0;
            LocalScrollToTopRequestFlow$lambda$0 = ScrollToTopKt.LocalScrollToTopRequestFlow$lambda$0();
            return LocalScrollToTopRequestFlow$lambda$0;
        }
    }, 1, (Object) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow LocalScrollToTopRequestFlow$lambda$0() {
        return FlowKt.emptyFlow();
    }

    public static final ProvidableCompositionLocal<Flow<Unit>> getLocalScrollToTopRequestFlow() {
        return LocalScrollToTopRequestFlow;
    }

    public static final Modifier preferScrollToTop(Modifier $this$preferScrollToTop, ScrollableState state, Flow<Unit> flow, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter($this$preferScrollToTop, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        ComposerKt.sourceInformationMarkerStart($composer, 520360527, "C(preferScrollToTop)N(state,scrollToTopRequestFlow)27@1173L7,29@1245L33,30@1304L1275,30@1283L1296,61@2617L38:ScrollToTop.kt#kklx1l");
        if ((i & 2) != 0) {
            CompositionLocal this_$iv = LocalScrollToTopRequestFlow;
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            flow = (Flow) consume;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(520360527, $changed, -1, "kntr.common.trio.systemui.preferScrollToTop (ScrollToTop.kt:28)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1850266576, "CC(remember):ScrollToTop.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        final MutableState layoutCoordinates$delegate = (MutableState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, 1850269706, "CC(remember):ScrollToTop.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(flow) | $composer.changedInstance(state);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = (Function2) new ScrollToTopKt$preferScrollToTop$1$1(flow, state, layoutCoordinates$delegate, null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer, 6);
        ComposerKt.sourceInformationMarkerStart($composer, 1850310485, "CC(remember):ScrollToTop.kt#9igjgp");
        Object it$iv3 = $composer.rememberedValue();
        if (it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = new Function1() { // from class: kntr.common.trio.systemui.ScrollToTopKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit preferScrollToTop$lambda$4$0;
                    preferScrollToTop$lambda$4$0 = ScrollToTopKt.preferScrollToTop$lambda$4$0(layoutCoordinates$delegate, (LayoutCoordinates) obj);
                    return preferScrollToTop$lambda$4$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned($this$preferScrollToTop, (Function1) it$iv3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return onGloballyPositioned;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates preferScrollToTop$lambda$1(MutableState<LayoutCoordinates> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (LayoutCoordinates) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preferScrollToTop$lambda$4$0(MutableState $layoutCoordinates$delegate, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $layoutCoordinates$delegate.setValue(it);
        return Unit.INSTANCE;
    }
}