package im.session.home;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import im.session.IMSessionViewModel;
import im.session.common.IMSessionPageKt;
import im.session.common.IMSessionPageState;
import im.session.common.IMSessionPageStateKt;
import im.session.di.IMSessionEntryPoint;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.PvEventTriggerKt;
import kntr.common.pv.PvState;
import kntr.common.pv.TransformerKt;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.trio.systemui.SystemUIKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: IMSessionHomePage.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a1\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"IMSessionHomePage", "", "(Landroidx/compose/runtime/Composer;I)V", "homeTabData", "Lim/session/home/IMHomeTabData;", "(Lim/session/home/IMHomeTabData;Landroidx/compose/runtime/Composer;II)V", "rememberTabStatePvEventTrigger", "Lkntr/common/pv/PvEventTrigger;", "eventId", "", "tabSelectedFlow", "Lkotlinx/coroutines/flow/Flow;", "", "tabHasNewPointFlow", "Lkotlinx/coroutines/flow/StateFlow;", "(Ljava/lang/String;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/StateFlow;Landroidx/compose/runtime/Composer;I)Lkntr/common/pv/PvEventTrigger;", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSessionHomePageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionHomePage$lambda$0(int i2, Composer composer, int i3) {
        IMSessionHomePage(composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionHomePage$lambda$3(IMHomeTabData iMHomeTabData, int i2, int i3, Composer composer, int i4) {
        IMSessionHomePage(iMHomeTabData, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final void IMSessionHomePage(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-906143743);
        ComposerKt.sourceInformation($composer2, "C(IMSessionHomePage)39@1547L37:IMSessionHomePage.kt#kfobb3");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-906143743, $changed, -1, "im.session.home.IMSessionHomePage (IMSessionHomePage.kt:38)");
            }
            IMSessionHomePage(null, $composer2, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.home.IMSessionHomePageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSessionHomePage$lambda$0;
                    IMSessionHomePage$lambda$0 = IMSessionHomePageKt.IMSessionHomePage$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSessionHomePage$lambda$0;
                }
            });
        }
    }

    public static final void IMSessionHomePage(IMHomeTabData homeTabData, Composer $composer, final int $changed, final int i2) {
        final IMHomeTabData homeTabData2;
        Composer $composer2 = $composer.startRestartGroup(1527751537);
        ComposerKt.sourceInformation($composer2, "C(IMSessionHomePage)N(homeTabData)44@1676L24,46@1749L206,55@1985L70,58@2074L26,60@2150L821,60@2106L865:IMSessionHomePage.kt#kfobb3");
        int $dirty = $changed;
        int i3 = i2 & 1;
        if (i3 != 0) {
            $dirty |= 6;
            homeTabData2 = homeTabData;
        } else if (($changed & 6) == 0) {
            homeTabData2 = homeTabData;
            $dirty |= $composer2.changedInstance(homeTabData2) ? 4 : 2;
        } else {
            homeTabData2 = homeTabData;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            final IMHomeTabData homeTabData3 = i3 != 0 ? null : homeTabData2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1527751537, $dirty2, -1, "im.session.home.IMSessionHomePage (IMSessionHomePage.kt:43)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -709583201, "CC(remember):IMSessionHomePage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                Object value$iv = ((IMSessionEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(IMSessionEntryPoint.class))).getHomeComponentFactory().build(scope).viewModel();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            IMSessionViewModel viewModel = (IMSessionViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final IMSessionPageState pageState = IMSessionPageStateKt.rememberSessionPageState(viewModel, $composer2, 0);
            final MainPopupChecker checker = AndroidMainPopupCheckerKt.rememberMainPopupChecker($composer2, 0);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, homeTabData3 != null, ComposableLambdaKt.rememberComposableLambda(-1716420423, true, new Function2() { // from class: im.session.home.IMSessionHomePageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSessionHomePage$lambda$2;
                    IMSessionHomePage$lambda$2 = IMSessionHomePageKt.IMSessionHomePage$lambda$2(MainPopupChecker.this, homeTabData3, pageState, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSessionHomePage$lambda$2;
                }
            }, $composer2, 54), $composer2, 384, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            homeTabData2 = homeTabData3;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.home.IMSessionHomePageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSessionHomePage$lambda$3;
                    IMSessionHomePage$lambda$3 = IMSessionHomePageKt.IMSessionHomePage$lambda$3(IMHomeTabData.this, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSessionHomePage$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionHomePage$lambda$2(MainPopupChecker $checker, IMHomeTabData $homeTabData, IMSessionPageState $pageState, Composer $composer, int $changed) {
        IMHomeTabData iMHomeTabData;
        ComposerKt.sourceInformation($composer, "C61@2177L28,62@2225L20,63@2295L7,64@2332L274,64@2311L295,80@2941L24:IMSessionHomePage.kt#kfobb3");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1716420423, $changed, -1, "im.session.home.IMSessionHomePage.<anonymous> (IMSessionHomePage.kt:61)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -212578741, "CC(remember):IMSessionHomePage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(lifecycleOwner) | $composer.changedInstance($checker);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new IMSessionHomePageKt$IMSessionHomePage$2$1$1(lifecycleOwner, $checker, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer, 6);
            if ($homeTabData != null) {
                $composer.startReplaceGroup(2000286635);
                ComposerKt.sourceInformation($composer, "*74@2648L224");
                rememberTabStatePvEventTrigger("im.my-message.0.0.pv", $homeTabData.getTabSelectedFlow(), FlowKt.stateIn($homeTabData.getTabHasNewPointFlow(), LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), SharingStarted.Companion.getEagerly(), false), $composer, 6);
                $composer.endReplaceGroup();
                iMHomeTabData = $homeTabData;
            } else {
                $composer.startReplaceGroup(2000286634);
                $composer.endReplaceGroup();
                iMHomeTabData = null;
            }
            if (iMHomeTabData != null) {
                $composer.startReplaceGroup(-212569642);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-212561241);
                ComposerKt.sourceInformation($composer, "79@2886L46");
                PvTriggerEntranceKt.rememberPvEventTrigger("im.my-message.0.0.pv", $composer, 6);
                $composer.endReplaceGroup();
            }
            IMSessionPageKt.IMSessionPage($pageState, null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final PvEventTrigger rememberTabStatePvEventTrigger(String eventId, Flow<Boolean> flow, StateFlow<Boolean> stateFlow, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(flow, "tabSelectedFlow");
        Intrinsics.checkNotNullParameter(stateFlow, "tabHasNewPointFlow");
        ComposerKt.sourceInformationMarkerStart($composer, 1769133992, "C(rememberTabStatePvEventTrigger)N(eventId,tabSelectedFlow,tabHasNewPointFlow)93@3246L7,94@3280L24,96@3317L603:IMSessionHomePage.kt#kfobb3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1769133992, $changed, -1, "im.session.home.rememberTabStatePvEventTrigger (IMSessionHomePage.kt:92)");
        }
        CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Lifecycle lifecycle = ((LifecycleOwner) consume).getLifecycle();
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
            $composer.updateRememberedValue(value$iv$iv);
            it$iv$iv = value$iv$iv;
        }
        CoroutineScope scope = (CoroutineScope) it$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.startReplaceGroup(-669254681);
        ComposerKt.sourceInformation($composer, "*113@4010L224,113@3989L245");
        ComposerKt.sourceInformationMarkerStart($composer, -669273725, "CC(remember):IMSessionHomePage.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(eventId)) || ($changed & 6) == 4) | $composer.changed(flow);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            StateFlow combinedStateFlow = FlowKt.stateIn(FlowKt.distinctUntilChanged(FlowKt.combine(TransformerKt.toPvStateFlow(lifecycle), flow, new IMSessionHomePageKt$rememberTabStatePvEventTrigger$1$combinedStateFlow$1(null))), scope, SharingStarted.Companion.getEagerly(), PvState.Invisible);
            Object value$iv = new PvEventTrigger(combinedStateFlow, eventId);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        PvEventTrigger trigger = (PvEventTrigger) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        PvEventTriggerKt.startObserveIn(trigger, lifecycle);
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -827008776, "CC(remember):IMSessionHomePage.kt#9igjgp");
        boolean invalid$iv2 = $composer.changedInstance(flow) | $composer.changedInstance(trigger) | $composer.changedInstance(stateFlow);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = (Function2) new IMSessionHomePageKt$rememberTabStatePvEventTrigger$2$1$1(flow, trigger, stateFlow, null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer, 6);
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return trigger;
    }
}