package im.session.secondary;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import im.provided.IMProvidedUIEntryPoint;
import im.provided.IMProvidedUIService;
import im.session.IMSessionViewModel;
import im.session.common.IMSessionPageKt;
import im.session.common.IMSessionPageState;
import im.session.common.IMSessionPageStateKt;
import im.session.di.IMSessionEntryPoint;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.pv.PvEventTrigger;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IMSessionSecondaryPage.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"IMSessionSecondaryPage", "", "type", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSessionSecondaryPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionSecondaryPage$lambda$5(String str, int i2, Composer composer, int i3) {
        IMSessionSecondaryPage(str, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void IMSessionSecondaryPage(final String type, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(type, "type");
        Composer $composer2 = $composer.startRestartGroup(1699887061);
        ComposerKt.sourceInformation($composer2, "C(IMSessionSecondaryPage)N(type)30@1220L90,33@1340L243,33@1315L268,40@1601L24,43@1675L278,54@1981L115,58@2118L35,60@2169L399,60@2159L409:IMSessionSecondaryPage.kt#e8iotq");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(type) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1699887061, $dirty2, -1, "im.session.secondary.IMSessionSecondaryPage (IMSessionSecondaryPage.kt:28)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1503895471, "CC(remember):IMSessionSecondaryPage.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                KSessionPageType.Companion companion = KSessionPageType.Companion;
                Integer intOrNull = StringsKt.toIntOrNull(type);
                Object value$iv = companion.fromValue(intOrNull != null ? intOrNull.intValue() : 0);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final KSessionPageType pageType = (KSessionPageType) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1503899464, "CC(remember):IMSessionSecondaryPage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(pageType);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new IMSessionSecondaryPageKt$IMSessionSecondaryPage$1$1(pageType, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(pageType, (Function2) it$iv2, $composer2, 0);
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1503910219, "CC(remember):IMSessionSecondaryPage.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                Object value$iv3 = ((IMSessionEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(IMSessionEntryPoint.class))).getSecondaryComponentFactory().build(scope, pageType).viewModel();
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            IMSessionViewModel viewModel = (IMSessionViewModel) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1503919848, "CC(remember):IMSessionSecondaryPage.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv2 = Gripper_component_holder_androidKt.getRootGripperComponent();
                Object value$iv4 = (IMProvidedUIService) ((IMProvidedUIEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv2, Reflection.getOrCreateKotlinClass(IMProvidedUIEntryPoint.class))).service().get(pageType.getName());
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final IMProvidedUIService service = (IMProvidedUIService) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final IMSessionPageState pageState = IMSessionPageStateKt.rememberSessionPageState(viewModel, $composer2, 0);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(973491485, true, new Function2() { // from class: im.session.secondary.IMSessionSecondaryPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSessionSecondaryPage$lambda$4;
                    IMSessionSecondaryPage$lambda$4 = IMSessionSecondaryPageKt.IMSessionSecondaryPage$lambda$4(pageType, pageState, service, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSessionSecondaryPage$lambda$4;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.secondary.IMSessionSecondaryPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSessionSecondaryPage$lambda$5;
                    IMSessionSecondaryPage$lambda$5 = IMSessionSecondaryPageKt.IMSessionSecondaryPage$lambda$5(type, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSessionSecondaryPage$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008f, code lost:
        if (((java.lang.Boolean) r7.getValue()).booleanValue() == true) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit IMSessionSecondaryPage$lambda$4(KSessionPageType $pageType, IMSessionPageState $pageState, IMProvidedUIService $service, Composer $composer, int $changed) {
        boolean z;
        ComposerKt.sourceInformation($composer, "C61@2196L28,62@2244L20,63@2289L48,64@2371L69,64@2346L94,67@2449L24:IMSessionSecondaryPage.kt#e8iotq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(973491485, $changed, -1, "im.session.secondary.IMSessionSecondaryPage.<anonymous> (IMSessionSecondaryPage.kt:61)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger("im.fold-message.0.0.pv", $composer, 6);
            ComposerKt.sourceInformationMarkerStart($composer, -777546910, "CC(remember):IMSessionSecondaryPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(pvTrigger) | $composer.changedInstance($pageType);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new IMSessionSecondaryPageKt$IMSessionSecondaryPage$2$1$1(pvTrigger, $pageType, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect($pageType, (Function2) it$iv, $composer, 0);
            IMSessionPageKt.IMSessionPage($pageState, null, $composer, 0, 2);
            if ($service != null && (r7 = $service.mo3218getNeedShow()) != null) {
                z = true;
            }
            z = false;
            if (z) {
                $composer.startReplaceGroup(1665997500);
                ComposerKt.sourceInformation($composer, "70@2543L9");
                $service.content($composer, 0);
            } else {
                $composer.startReplaceGroup(1663494405);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}