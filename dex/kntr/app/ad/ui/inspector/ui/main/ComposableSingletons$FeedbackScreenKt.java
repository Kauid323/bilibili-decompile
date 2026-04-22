package kntr.app.ad.ui.inspector.ui.main;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import kntr.app.ad.ui.inspector.ui.components.AppIcons;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeedbackScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$FeedbackScreenKt {
    public static final ComposableSingletons$FeedbackScreenKt INSTANCE = new ComposableSingletons$FeedbackScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$1362446093 = ComposableLambdaKt.composableLambdaInstance(1362446093, false, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ComposableSingletons$FeedbackScreenKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1362446093$lambda$0;
            lambda_1362446093$lambda$0 = ComposableSingletons$FeedbackScreenKt.lambda_1362446093$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1362446093$lambda$0;
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$973775362 = ComposableLambdaKt.composableLambdaInstance(973775362, false, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.main.ComposableSingletons$FeedbackScreenKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_973775362$lambda$0;
            lambda_973775362$lambda$0 = ComposableSingletons$FeedbackScreenKt.lambda_973775362$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_973775362$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$509023905 = ComposableLambdaKt.composableLambdaInstance(509023905, false, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ComposableSingletons$FeedbackScreenKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_509023905$lambda$0;
            lambda_509023905$lambda$0 = ComposableSingletons$FeedbackScreenKt.lambda_509023905$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_509023905$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1362446093$ad_inspector_debug() {
        return lambda$1362446093;
    }

    public final Function2<Composer, Integer, Unit> getLambda$509023905$ad_inspector_debug() {
        return lambda$509023905;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$973775362$ad_inspector_debug() {
        return lambda$973775362;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1362446093$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C89@3597L133:FeedbackScreen.kt#flo5hv");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1362446093, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ComposableSingletons$FeedbackScreenKt.lambda$1362446093.<anonymous> (FeedbackScreen.kt:89)");
            }
            TextKt.Text-Nvy7gAk("请描述您遇到的问题或建议...", (Modifier) null, ColorKt.Color(4288455599L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 390, 0, 262138);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_973775362$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C161@7208L464:FeedbackScreen.kt#flo5hv");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(973775362, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ComposableSingletons$FeedbackScreenKt.lambda$973775362.<anonymous> (FeedbackScreen.kt:161)");
            }
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1322117356, "C165@7409L204,170@7638L12:FeedbackScreen.kt#flo5hv");
            IconKt.Icon-ww6aTOc(AppIcons.INSTANCE.getSend(), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), 0L, $composer, 438, 8);
            TextKt.Text-Nvy7gAk("提交反馈", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_509023905$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C186@8110L10,184@8018L285:FeedbackScreen.kt#flo5hv");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(509023905, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ComposableSingletons$FeedbackScreenKt.lambda$509023905.<anonymous> (FeedbackScreen.kt:184)");
            }
            TextKt.Text-Nvy7gAk("反馈已提交，感谢您的建议！", PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), ColorKt.Color(4278556265L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), $composer, 438, 0, 130040);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}