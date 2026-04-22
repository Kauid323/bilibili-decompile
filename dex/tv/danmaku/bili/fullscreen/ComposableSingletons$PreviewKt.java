package tv.danmaku.bili.fullscreen;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material.SliderColors;
import androidx.compose.material.SliderKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.page.PhoneLoginPageKt;
import tv.danmaku.bili.fullscreen.service.IspCode;
import tv.danmaku.bili.fullscreen.service.PhoneInfo;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;
import tv.danmaku.bili.fullscreen.state.PhoneOnePassLoginState;

/* compiled from: Preview.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ComposableSingletons$PreviewKt {
    public static final ComposableSingletons$PreviewKt INSTANCE = new ComposableSingletons$PreviewKt();

    /* renamed from: lambda$-1487654524  reason: not valid java name */
    private static Function3<BoxWithConstraintsScope, Composer, Integer, Unit> f6lambda$1487654524 = ComposableLambdaKt.composableLambdaInstance(-1487654524, false, new Function3() { // from class: tv.danmaku.bili.fullscreen.ComposableSingletons$PreviewKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1487654524$lambda$0;
            lambda__1487654524$lambda$0 = ComposableSingletons$PreviewKt.lambda__1487654524$lambda$0((BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1487654524$lambda$0;
        }
    });

    /* renamed from: lambda$-1677530214  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f7lambda$1677530214 = ComposableLambdaKt.composableLambdaInstance(-1677530214, false, new Function2() { // from class: tv.danmaku.bili.fullscreen.ComposableSingletons$PreviewKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1677530214$lambda$0;
            lambda__1677530214$lambda$0 = ComposableSingletons$PreviewKt.lambda__1677530214$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1677530214$lambda$0;
        }
    });

    /* renamed from: getLambda$-1487654524$accountui_apinkDebug  reason: not valid java name */
    public final Function3<BoxWithConstraintsScope, Composer, Integer, Unit> m1028getLambda$1487654524$accountui_apinkDebug() {
        return f6lambda$1487654524;
    }

    /* renamed from: getLambda$-1677530214$accountui_apinkDebug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1029getLambda$1677530214$accountui_apinkDebug() {
        return f7lambda$1677530214;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1677530214$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C45@1634L1553:Preview.kt#8ty1lm");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1677530214, $changed, -1, "tv.danmaku.bili.fullscreen.ComposableSingletons$PreviewKt.lambda$-1677530214.<anonymous> (Preview.kt:45)");
            }
            BoxWithConstraintsKt.BoxWithConstraints((Modifier) null, (Alignment) null, false, f6lambda$1487654524, $composer, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1487654524$lambda$0(BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C49@1801L6,47@1707L1470:Preview.kt#8ty1lm");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1487654524, $dirty, -1, "tv.danmaku.bili.fullscreen.ComposableSingletons$PreviewKt.lambda$-1487654524.<anonymous> (Preview.kt:46)");
            }
            float defaultWidth = $this$BoxWithConstraints.getMaxWidth-D9Ej5fM();
            Modifier modifier$iv = WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getStress_red-0d7_KjU(), (Shape) null, 2, (Object) null));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.negativeBtnVisible << 3) & BR.containerVisible;
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
            int i2 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -649084380, "C53@1975L83,56@2075L63,61@2234L58,59@2155L339,71@2659L6,68@2511L652:Preview.kt#8ty1lm");
            ComposerKt.sourceInformationMarkerStart($composer, 948892417, "CC(remember):Preview.kt#9igjgp");
            Object value$iv = $composer.rememberedValue();
            if (value$iv == Composer.Companion.getEmpty()) {
                value$iv = SnapshotStateKt.mutableStateOf$default(Float.valueOf(defaultWidth), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv);
            }
            final MutableState width$delegate = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text--4IGK_g(lambda__1487654524$lambda$0$0$1(width$delegate) + ".dp", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 0, 0, 131070);
            float lambda__1487654524$lambda$0$0$1 = lambda__1487654524$lambda$0$0$1(width$delegate);
            ClosedFloatingPointRange rangeTo = RangesKt.rangeTo(300.0f, defaultWidth);
            int i3 = (int) ((defaultWidth - 300.0f) - 1);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 948900680, "CC(remember):Preview.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.fullscreen.ComposableSingletons$PreviewKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit lambda__1487654524$lambda$0$0$3$0;
                        lambda__1487654524$lambda$0$0$3$0 = ComposableSingletons$PreviewKt.lambda__1487654524$lambda$0$0$3$0(width$delegate, ((Float) obj).floatValue());
                        return lambda__1487654524$lambda$0$0$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            SliderKt.Slider(lambda__1487654524$lambda$0$0$1, (Function1) it$iv, fillMaxWidth$default, false, rangeTo, i3, (Function0) null, (MutableInteractionSource) null, (SliderColors) null, $composer, (int) BR.pendentVisible, (int) BR.preSaleCountdownClickable);
            float $this$dp$iv = lambda__1487654524$lambda$0$0$1(width$delegate);
            Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl($this$dp$iv)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & BR.containerVisible;
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
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1378144329, "C79@2996L2,80@3039L2,81@3083L2,78@2957L2,82@3121L2,73@2711L434:Preview.kt#8ty1lm");
            PhoneOnePassLoginState phoneOnePassLoginState = new PhoneOnePassLoginState(new PhoneInfo("", "123456781234", "", IspCode.ChinaTelecom), false, null, false, null, null, null, BR.countdownTotal, null);
            ComposerKt.sourceInformationMarkerStart($composer, 1568485610, "CC(remember):Preview.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: tv.danmaku.bili.fullscreen.ComposableSingletons$PreviewKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit lambda__1487654524$lambda$0$0$4$0$0;
                        lambda__1487654524$lambda$0$0$4$0$0 = ComposableSingletons$PreviewKt.lambda__1487654524$lambda$0$0$4$0$0((IFullscreenAction) obj);
                        return lambda__1487654524$lambda$0$0$4$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            Function1 function1 = (Function1) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1568486986, "CC(remember):Preview.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: tv.danmaku.bili.fullscreen.ComposableSingletons$PreviewKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit lambda__1487654524$lambda$0$0$4$1$0;
                        lambda__1487654524$lambda$0$0$4$1$0 = ComposableSingletons$PreviewKt.lambda__1487654524$lambda$0$0$4$1$0(((Boolean) obj).booleanValue());
                        return lambda__1487654524$lambda$0$0$4$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            Function1 function12 = (Function1) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1568488394, "CC(remember):Preview.kt#9igjgp");
            Object it$iv4 = $composer.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function0() { // from class: tv.danmaku.bili.fullscreen.ComposableSingletons$PreviewKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            }
            Function0 function0 = (Function0) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1568484362, "CC(remember):Preview.kt#9igjgp");
            Object it$iv5 = $composer.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv6 = new Function1() { // from class: tv.danmaku.bili.fullscreen.ComposableSingletons$PreviewKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        Unit lambda__1487654524$lambda$0$0$4$3$0;
                        lambda__1487654524$lambda$0$0$4$3$0 = ComposableSingletons$PreviewKt.lambda__1487654524$lambda$0$0$4$3$0(((Boolean) obj).booleanValue());
                        return lambda__1487654524$lambda$0$0$4$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv6);
                it$iv5 = value$iv6;
            }
            Function1 function13 = (Function1) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1568489610, "CC(remember):Preview.kt#9igjgp");
            Object it$iv6 = $composer.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv7 = new Function1() { // from class: tv.danmaku.bili.fullscreen.ComposableSingletons$PreviewKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        Unit lambda__1487654524$lambda$0$0$4$4$0;
                        lambda__1487654524$lambda$0$0$4$4$0 = ComposableSingletons$PreviewKt.lambda__1487654524$lambda$0$0$4$4$0((String) obj);
                        return lambda__1487654524$lambda$0$0$4$4$0;
                    }
                };
                $composer.updateRememberedValue(value$iv7);
                it$iv6 = value$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            PhoneLoginPageKt.PhoneLoginPage(phoneOnePassLoginState, function1, function12, function0, function13, (Function1) it$iv6, $composer, 224688, 0);
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

    private static final float lambda__1487654524$lambda$0$0$1(MutableState<Float> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    private static final void lambda__1487654524$lambda$0$0$2(MutableState<Float> mutableState, float f) {
        Object value$iv = Float.valueOf(f);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1487654524$lambda$0$0$3$0(MutableState $width$delegate, float it) {
        lambda__1487654524$lambda$0$0$2($width$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1487654524$lambda$0$0$4$3$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1487654524$lambda$0$0$4$0$0(IFullscreenAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1487654524$lambda$0$0$4$1$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1487654524$lambda$0$0$4$4$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}