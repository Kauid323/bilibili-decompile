package kntr.base.localization.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
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
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.localization.Localization;
import kntr.common.trio.systemui.SystemUIKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.TimeZone;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.base.localization.preview.generated.resources.Res;
import srcs.base.localization.preview.generated.resources.String0_commonMainKt;

/* compiled from: LocalizationPreviewPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$LocalizationPreviewPageKt {
    public static final ComposableSingletons$LocalizationPreviewPageKt INSTANCE = new ComposableSingletons$LocalizationPreviewPageKt();

    /* renamed from: lambda$-1383794864  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f45lambda$1383794864 = ComposableLambdaKt.composableLambdaInstance(-1383794864, false, new Function2() { // from class: kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1383794864$lambda$0;
            lambda__1383794864$lambda$0 = ComposableSingletons$LocalizationPreviewPageKt.lambda__1383794864$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1383794864$lambda$0;
        }
    });

    /* renamed from: lambda$-50040388  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f47lambda$50040388 = ComposableLambdaKt.composableLambdaInstance(-50040388, false, new Function2() { // from class: kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__50040388$lambda$0;
            lambda__50040388$lambda$0 = ComposableSingletons$LocalizationPreviewPageKt.lambda__50040388$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__50040388$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$2028237477 = ComposableLambdaKt.composableLambdaInstance(2028237477, false, new Function2() { // from class: kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_2028237477$lambda$0;
            lambda_2028237477$lambda$0 = ComposableSingletons$LocalizationPreviewPageKt.lambda_2028237477$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_2028237477$lambda$0;
        }
    });

    /* renamed from: lambda$-580829884  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f48lambda$580829884 = ComposableLambdaKt.composableLambdaInstance(-580829884, false, new Function2() { // from class: kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt$$ExternalSyntheticLambda3
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__580829884$lambda$0;
            lambda__580829884$lambda$0 = ComposableSingletons$LocalizationPreviewPageKt.lambda__580829884$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__580829884$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1105070051 = ComposableLambdaKt.composableLambdaInstance(1105070051, false, new Function2() { // from class: kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt$$ExternalSyntheticLambda4
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1105070051$lambda$0;
            lambda_1105070051$lambda$0 = ComposableSingletons$LocalizationPreviewPageKt.lambda_1105070051$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1105070051$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$6839932 = ComposableLambdaKt.composableLambdaInstance(6839932, false, new Function2() { // from class: kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt$$ExternalSyntheticLambda5
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_6839932$lambda$0;
            lambda_6839932$lambda$0 = ComposableSingletons$LocalizationPreviewPageKt.lambda_6839932$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_6839932$lambda$0;
        }
    });

    /* renamed from: lambda$-396605069  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f46lambda$396605069 = ComposableLambdaKt.composableLambdaInstance(-396605069, false, new Function3() { // from class: kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt$$ExternalSyntheticLambda6
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__396605069$lambda$0;
            lambda__396605069$lambda$0 = ComposableSingletons$LocalizationPreviewPageKt.lambda__396605069$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__396605069$lambda$0;
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1017194529 = ComposableLambdaKt.composableLambdaInstance(1017194529, false, new Function3() { // from class: kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt$$ExternalSyntheticLambda7
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_1017194529$lambda$0;
            lambda_1017194529$lambda$0 = ComposableSingletons$LocalizationPreviewPageKt.lambda_1017194529$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_1017194529$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$163286937 = ComposableLambdaKt.composableLambdaInstance(163286937, false, new Function2() { // from class: kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt$$ExternalSyntheticLambda8
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_163286937$lambda$0;
            lambda_163286937$lambda$0 = ComposableSingletons$LocalizationPreviewPageKt.lambda_163286937$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_163286937$lambda$0;
        }
    });

    /* renamed from: getLambda$-1383794864$preview_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1635getLambda$1383794864$preview_debug() {
        return f45lambda$1383794864;
    }

    /* renamed from: getLambda$-396605069$preview_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1636getLambda$396605069$preview_debug() {
        return f46lambda$396605069;
    }

    /* renamed from: getLambda$-50040388$preview_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1637getLambda$50040388$preview_debug() {
        return f47lambda$50040388;
    }

    /* renamed from: getLambda$-580829884$preview_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1638getLambda$580829884$preview_debug() {
        return f48lambda$580829884;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1017194529$preview_debug() {
        return lambda$1017194529;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1105070051$preview_debug() {
        return lambda$1105070051;
    }

    public final Function2<Composer, Integer, Unit> getLambda$163286937$preview_debug() {
        return lambda$163286937;
    }

    public final Function2<Composer, Integer, Unit> getLambda$2028237477$preview_debug() {
        return lambda$2028237477;
    }

    public final Function2<Composer, Integer, Unit> getLambda$6839932$preview_debug() {
        return lambda$6839932;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1383794864$lambda$0(Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C79@3657L28,80@3705L20,82@3805L6,82@3735L242:LocalizationPreviewPage.kt#3k1zvn");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1383794864, $changed, -1, "kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt.lambda$-1383794864.<anonymous> (LocalizationPreviewPage.kt:79)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg3-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 386580886, "C83@3847L32,83@3832L48,84@3893L18,85@3924L14,86@3951L16:LocalizationPreviewPage.kt#3k1zvn");
            LocalizationPreviewPageKt.TopBar(StringResourcesKt.stringResource(String0_commonMainKt.getTitle(Res.string.INSTANCE), $composer, 0), null, $composer, 0, 2);
            LocalizationPreviewPageKt.LocalizationInfo(null, $composer, 0, 1);
            LocalizationPreviewPageKt.NumberFormat(null, $composer, 0, 1);
            LocalizationPreviewPageKt.DateTimeFormat(null, $composer, 0, 1);
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
    public static final Unit lambda_6839932$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C94@4235L6,94@4173L138,97@4382L6,97@4320L139,100@4530L6,100@4468L166,103@4705L6,103@4643L151:LocalizationPreviewPage.kt#3k1zvn");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(6839932, $changed, -1, "kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt.lambda$6839932.<anonymous> (LocalizationPreviewPage.kt:94)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBl6-0d7_KjU())), f47lambda$50040388, $composer, ProvidedValue.$stable | 48);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGr6-0d7_KjU())), lambda$2028237477, $composer, ProvidedValue.$stable | 48);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa6-0d7_KjU())), f48lambda$580829884, $composer, ProvidedValue.$stable | 48);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBl6-0d7_KjU())), lambda$1105070051, $composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__50040388$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C95@4261L40:LocalizationPreviewPage.kt#3k1zvn");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-50040388, $changed, -1, "kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt.lambda$-50040388.<anonymous> (LocalizationPreviewPage.kt:95)");
            }
            LocalizationPreviewPageKt.InfoItem("sLocale", Localization.INSTANCE.getSYSTEM(), null, $composer, 6, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2028237477$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C98@4408L41:LocalizationPreviewPage.kt#3k1zvn");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2028237477, $changed, -1, "kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt.lambda$2028237477.<anonymous> (LocalizationPreviewPage.kt:98)");
            }
            LocalizationPreviewPageKt.InfoItem("cLocale", Localization.INSTANCE.getCurrent(), null, $composer, 6, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__580829884$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C101@4556L68:LocalizationPreviewPage.kt#3k1zvn");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-580829884, $changed, -1, "kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt.lambda$-580829884.<anonymous> (LocalizationPreviewPage.kt:101)");
            }
            LocalizationPreviewPageKt.InfoItem("supports", CollectionsKt.joinToString$default(Localization.INSTANCE.getSUPPORTED_LIST(), ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), null, $composer, 6, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1105070051$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C104@4731L53:LocalizationPreviewPage.kt#3k1zvn");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1105070051, $changed, -1, "kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt.lambda$1105070051.<anonymous> (LocalizationPreviewPage.kt:104)");
            }
            LocalizationPreviewPageKt.InfoItem("timezone", TimeZone.Companion.currentSystemDefault(), null, $composer, 6, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__396605069$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C209@9038L13:LocalizationPreviewPage.kt#3k1zvn");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-396605069, $changed, -1, "kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt.lambda$-396605069.<anonymous> (LocalizationPreviewPage.kt:209)");
            }
            TextKt.Text-Nvy7gAk("测！！！！", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1017194529$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C297@12205L13:LocalizationPreviewPage.kt#3k1zvn");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1017194529, $changed, -1, "kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt.lambda$1017194529.<anonymous> (LocalizationPreviewPage.kt:297)");
            }
            TextKt.Text-Nvy7gAk("测！！！！", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_163286937$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C387@14747L41:LocalizationPreviewPage.kt#3k1zvn");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(163286937, $changed, -1, "kntr.base.localization.preview.ComposableSingletons$LocalizationPreviewPageKt.lambda$163286937.<anonymous> (LocalizationPreviewPage.kt:387)");
            }
            LocalizationPreviewPageKt.BackIcon(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}