package settings.language;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import bili.resource.settings.SettingsRes;
import bili.resource.settings.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.localization.Locale;
import kntr.base.localization.Localization;
import kntr.base.localization.Translation;
import kntr.base.neuron.KNeuron;
import kntr.common.language.settings.LanguageSettingsServiceKt;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.trio.systemui.SystemUIKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;
import settings.base.ui.SettingsTopBarKt;

/* compiled from: LanguageSettingsPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$LanguageSettingsPageKt {
    public static final ComposableSingletons$LanguageSettingsPageKt INSTANCE = new ComposableSingletons$LanguageSettingsPageKt();
    private static Function2<Composer, Integer, Unit> lambda$2027889651 = ComposableLambdaKt.composableLambdaInstance(2027889651, false, new Function2() { // from class: settings.language.ComposableSingletons$LanguageSettingsPageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_2027889651$lambda$0;
            lambda_2027889651$lambda$0 = ComposableSingletons$LanguageSettingsPageKt.lambda_2027889651$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_2027889651$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$2027889651$language_debug() {
        return lambda$2027889651;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2027889651$lambda$0(Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C65@2981L54,67@3062L28,68@3110L20,70@3181L16,71@3263L16,73@3303L38,74@3376L50,76@3459L115,76@3436L138,82@3584L1211:LanguageSettingsPage.kt#nusb0j");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2027889651, $changed, -1, "settings.language.ComposableSingletons$LanguageSettingsPageKt.lambda$2027889651.<anonymous> (LanguageSettingsPage.kt:65)");
            }
            PvTriggerEntranceKt.rememberPvEventTrigger("main.setting-language.0.0.pv", $composer, 6);
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            State appLocale$delegate = SnapshotStateKt.collectAsState(Localization.INSTANCE.getLocaleFlow(), (CoroutineContext) null, $composer, 0, 1);
            State appTranslationEnabled$delegate = SnapshotStateKt.collectAsState(Translation.INSTANCE.getUserEnabledFlow(), (CoroutineContext) null, $composer, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer, -1113187111, "CC(remember):LanguageSettingsPage.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(lambda_2027889651$lambda$0$0(appLocale$delegate), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState locale$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1113184763, "CC(remember):LanguageSettingsPage.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(lambda_2027889651$lambda$0$1(appTranslationEnabled$delegate)), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState translationEnabled$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1113182042, "CC(remember):LanguageSettingsPage.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: settings.language.ComposableSingletons$LanguageSettingsPageKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult lambda_2027889651$lambda$0$8$0;
                        lambda_2027889651$lambda$0$8$0 = ComposableSingletons$LanguageSettingsPageKt.lambda_2027889651$lambda$0$8$0(locale$delegate, translationEnabled$delegate, (DisposableEffectScope) obj);
                        return lambda_2027889651$lambda$0$8$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.DisposableEffect(unit, (Function1) it$iv3, $composer, 54);
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -821431058, "C83@3656L61,83@3641L77,88@3888L6,84@3731L1054:LanguageSettingsPage.kt#nusb0j");
            SettingsTopBarKt.SettingsTopBar(StringResourcesKt.stringResource(String0_commonMainKt.getSettings_global_string_198(SettingsRes.INSTANCE.getString()), $composer, 0), null, false, null, null, $composer, 0, 30);
            Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg3-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1249980758, "C90@3997L270,90@3933L334,102@4468L303,98@4284L487:LanguageSettingsPage.kt#nusb0j");
            Locale lambda_2027889651$lambda$0$3 = lambda_2027889651$lambda$0$3(locale$delegate);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1287249429, "CC(remember):LanguageSettingsPage.kt#9igjgp");
            Object it$iv4 = $composer.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: settings.language.ComposableSingletons$LanguageSettingsPageKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit lambda_2027889651$lambda$0$9$0$0$0;
                        lambda_2027889651$lambda$0$9$0$0$0 = ComposableSingletons$LanguageSettingsPageKt.lambda_2027889651$lambda$0$9$0$0$0(locale$delegate, (Locale) obj);
                        return lambda_2027889651$lambda$0$9$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LanguageSettingsPageKt.AppLanguageSettings(lambda_2027889651$lambda$0$3, fillMaxWidth$default, (Function1) it$iv4, $composer, 432, 0);
            Locale lambda_2027889651$lambda$0$32 = lambda_2027889651$lambda$0$3(locale$delegate);
            boolean lambda_2027889651$lambda$0$6 = lambda_2027889651$lambda$0$6(translationEnabled$delegate);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1287264534, "CC(remember):LanguageSettingsPage.kt#9igjgp");
            Object it$iv5 = $composer.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function1() { // from class: settings.language.ComposableSingletons$LanguageSettingsPageKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit lambda_2027889651$lambda$0$9$0$1$0;
                        lambda_2027889651$lambda$0$9$0$1$0 = ComposableSingletons$LanguageSettingsPageKt.lambda_2027889651$lambda$0$9$0$1$0(translationEnabled$delegate, ((Boolean) obj).booleanValue());
                        return lambda_2027889651$lambda$0$9$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LanguageSettingsPageKt.AiTranslationSettings(lambda_2027889651$lambda$0$32, lambda_2027889651$lambda$0$6, fillMaxWidth$default2, (Function1) it$iv5, $composer, 3456, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Locale lambda_2027889651$lambda$0$0(State<Locale> state) {
        Object thisObj$iv = state.getValue();
        return (Locale) thisObj$iv;
    }

    private static final boolean lambda_2027889651$lambda$0$1(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale lambda_2027889651$lambda$0$3(MutableState<Locale> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Locale) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean lambda_2027889651$lambda$0$6(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void lambda_2027889651$lambda$0$7(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult lambda_2027889651$lambda$0$8$0(final MutableState $locale$delegate, final MutableState $translationEnabled$delegate, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: settings.language.ComposableSingletons$LanguageSettingsPageKt$lambda_2027889651$lambda$0$8$0$$inlined$onDispose$1
            public void dispose() {
                Locale lambda_2027889651$lambda$0$3;
                boolean lambda_2027889651$lambda$0$6;
                lambda_2027889651$lambda$0$3 = ComposableSingletons$LanguageSettingsPageKt.lambda_2027889651$lambda$0$3($locale$delegate);
                lambda_2027889651$lambda$0$6 = ComposableSingletons$LanguageSettingsPageKt.lambda_2027889651$lambda$0$6($translationEnabled$delegate);
                LanguageSettingsServiceKt.applyLanguageSettings(lambda_2027889651$lambda$0$3, lambda_2027889651$lambda$0$6);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2027889651$lambda$0$9$0$0$0(MutableState $locale$delegate, Locale it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $locale$delegate.setValue(it);
        KNeuron.INSTANCE.reportClick(false, "main.setting-language.option.0.click", MapsKt.mapOf(TuplesKt.to("text", it.toLanguageTag())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2027889651$lambda$0$9$0$1$0(MutableState $translationEnabled$delegate, boolean it) {
        lambda_2027889651$lambda$0$7($translationEnabled$delegate, it);
        KNeuron.INSTANCE.reportClick(false, "main.setting-language.option.0.click", MapsKt.mapOf(TuplesKt.to("always_translate_switch", it ? "1" : "0")));
        return Unit.INSTANCE;
    }
}