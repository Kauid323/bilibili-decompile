package kntr.app.im.chat.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupBubbleMenu.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$PopupBubbleMenuKt {
    public static final ComposableSingletons$PopupBubbleMenuKt INSTANCE = new ComposableSingletons$PopupBubbleMenuKt();

    /* renamed from: lambda$-510611428  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f51lambda$510611428 = ComposableLambdaKt.composableLambdaInstance(-510611428, false, new Function2() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda14
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__510611428$lambda$0;
            lambda__510611428$lambda$0 = ComposableSingletons$PopupBubbleMenuKt.lambda__510611428$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__510611428$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1292727251 = ComposableLambdaKt.composableLambdaInstance(1292727251, false, new Function2() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda15
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1292727251$lambda$0;
            lambda_1292727251$lambda$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_1292727251$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1292727251$lambda$0;
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$420965273 = ComposableLambdaKt.composableLambdaInstance(420965273, false, new Function3() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda16
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_420965273$lambda$0;
            lambda_420965273$lambda$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_420965273$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_420965273$lambda$0;
        }
    });

    /* renamed from: lambda$-641420030  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f52lambda$641420030 = ComposableLambdaKt.composableLambdaInstance(-641420030, false, new Function3() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda17
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__641420030$lambda$0;
            lambda__641420030$lambda$0 = ComposableSingletons$PopupBubbleMenuKt.lambda__641420030$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__641420030$lambda$0;
        }
    });

    /* renamed from: lambda$-878037855  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f53lambda$878037855 = ComposableLambdaKt.composableLambdaInstance(-878037855, false, new Function3() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda18
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__878037855$lambda$0;
            lambda__878037855$lambda$0 = ComposableSingletons$PopupBubbleMenuKt.lambda__878037855$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__878037855$lambda$0;
        }
    });

    /* renamed from: lambda$-1114655680  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f50lambda$1114655680 = ComposableLambdaKt.composableLambdaInstance(-1114655680, false, new Function3() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda19
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1114655680$lambda$0;
            lambda__1114655680$lambda$0 = ComposableSingletons$PopupBubbleMenuKt.lambda__1114655680$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1114655680$lambda$0;
        }
    });
    private static Function3<PaddingValues, Composer, Integer, Unit> lambda$492475797 = ComposableLambdaKt.composableLambdaInstance(492475797, false, new Function3() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda20
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_492475797$lambda$0;
            lambda_492475797$lambda$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0((PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_492475797$lambda$0;
        }
    });

    /* renamed from: getLambda$-1114655680$ui_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1943getLambda$1114655680$ui_debug() {
        return f50lambda$1114655680;
    }

    /* renamed from: getLambda$-510611428$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1944getLambda$510611428$ui_debug() {
        return f51lambda$510611428;
    }

    /* renamed from: getLambda$-641420030$ui_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1945getLambda$641420030$ui_debug() {
        return f52lambda$641420030;
    }

    /* renamed from: getLambda$-878037855$ui_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1946getLambda$878037855$ui_debug() {
        return f53lambda$878037855;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1292727251$ui_debug() {
        return lambda$1292727251;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$420965273$ui_debug() {
        return lambda$420965273;
    }

    public final Function3<PaddingValues, Composer, Integer, Unit> getLambda$492475797$ui_debug() {
        return lambda$492475797;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__510611428$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C675@23921L24,674@23864L327:PopupBubbleMenu.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-510611428, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$-510611428.<anonymous> (PopupBubbleMenu.kt:674)");
            }
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_back_left_line_800($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), 0L, $composer, Painter.$stable | 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1292727251$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C712@25619L28,711@25562L331:PopupBubbleMenu.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1292727251, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$1292727251.<anonymous> (PopupBubbleMenu.kt:711)");
            }
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_800($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), 0L, $composer, Painter.$stable | 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0714, code lost:
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x074d, code lost:
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0922, code lost:
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0959, code lost:
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x02fb, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0334, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x04b4, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0509, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0542, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x06bf, code lost:
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0718  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0751  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x081f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x082b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x091a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0926  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0951  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x095d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x09bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0627  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x06b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit lambda_492475797$lambda$0(PaddingValues innerPadding, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 value$iv;
        boolean invalid$iv;
        boolean invalid$iv2;
        Function0 factory$iv$iv$iv3;
        boolean invalid$iv3;
        boolean invalid$iv4;
        boolean invalid$iv5;
        Function0 factory$iv$iv$iv4;
        boolean invalid$iv6;
        boolean invalid$iv7;
        boolean invalid$iv8;
        Function0 factory$iv$iv$iv5;
        boolean invalid$iv9;
        Object it$iv;
        Function0 value$iv2;
        boolean invalid$iv10;
        boolean invalid$iv11;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "CN(innerPadding)890@31427L7151:PopupBubbleMenu.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(492475797, $dirty, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$492475797.<anonymous> (PopupBubbleMenu.kt:890)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), innerPadding), Color.Companion.getBlue-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$lambda_492475797_u24lambda_u240_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 983840543, "C897@31635L1724,942@33372L1721,988@35107L1725,1034@36846L1722:PopupBubbleMenu.kt#92mklk");
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default($this$lambda_492475797_u24lambda_u240_u240.align(Modifier.Companion, Alignment.Companion.getCenterStart()), Dp.constructor-impl(10), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -13037995, "C903@31853L37,905@31945L92,904@31907L208,914@32221L76,917@32317L1028,912@32133L1212:PopupBubbleMenu.kt#92mklk");
            final PopupState popupState = PopupBubbleMenuKt.rememberPopupState(false, $composer, 6, 0);
            ComposerKt.sourceInformationMarkerStart($composer, -1524439163, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            boolean invalid$iv12 = $composer.changed(popupState);
            Object it$iv2 = $composer.rememberedValue();
            if (!invalid$iv12 && it$iv2 != Composer.Companion.getEmpty()) {
                value$iv = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.Button(value$iv, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, lambda$420965273, $composer, 805306368, 510);
                ComposerKt.sourceInformationMarkerStart($composer, -1524430347, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                invalid$iv = $composer.changed(popupState);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv3 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit lambda_492475797$lambda$0$0$0$1$0;
                        lambda_492475797$lambda$0$0$0$1$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$0$1$0(PopupState.this);
                        return lambda_492475797$lambda$0$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                Function0 function0 = (Function0) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1524426323, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                invalid$iv2 = $composer.changed(popupState);
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv4 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        Unit lambda_492475797$lambda$0$0$0$2$0;
                        lambda_492475797$lambda$0$0$0$2$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$0$2$0(PopupState.this, (LazyListScope) obj);
                        return lambda_492475797$lambda$0$0$0$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer);
                PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState, function0, null, null, 0.0f, null, null, null, (Function1) it$iv4, $composer, 0, 252);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default($this$lambda_492475797_u24lambda_u240_u240.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if (!$composer.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv8;
                    $composer.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv8;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i6 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1788288045, "C948@33588L37,950@33680L92,949@33642L208,959@33956L76,962@34052L1027,957@33868L1211:PopupBubbleMenu.kt#92mklk");
                final PopupState popupState2 = PopupBubbleMenuKt.rememberPopupState(false, $composer, 6, 0);
                ComposerKt.sourceInformationMarkerStart($composer, -1050689874, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                invalid$iv3 = $composer.changed(popupState2);
                Object it$iv5 = $composer.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv5 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit lambda_492475797$lambda$0$0$1$0$0;
                        lambda_492475797$lambda$0$0$1$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$1$0$0(PopupState.this);
                        return lambda_492475797$lambda$0$0$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.Button((Function0) it$iv5, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, f52lambda$641420030, $composer, 805306368, 510);
                ComposerKt.sourceInformationMarkerStart($composer, -1050681058, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                invalid$iv4 = $composer.changed(popupState2);
                Object it$iv6 = $composer.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv6 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit lambda_492475797$lambda$0$0$1$1$0;
                        lambda_492475797$lambda$0$0$1$1$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$1$1$0(PopupState.this);
                        return lambda_492475797$lambda$0$0$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
                Function0 function02 = (Function0) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1050677035, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                invalid$iv5 = $composer.changed(popupState2);
                Object it$iv7 = $composer.rememberedValue();
                if (invalid$iv5) {
                }
                Object value$iv7 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj) {
                        Unit lambda_492475797$lambda$0$0$1$2$0;
                        lambda_492475797$lambda$0$0$1$2$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$1$2$0(PopupState.this, (LazyListScope) obj);
                        return lambda_492475797$lambda$0$0$1$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer);
                PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState2, function02, null, null, 0.0f, null, null, null, (Function1) it$iv7, $composer, 0, 252);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv4 = PaddingKt.padding-VpY3zN4$default($this$lambda_492475797_u24lambda_u240_u240.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv4 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
                int $changed$iv$iv4 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if (!$composer.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                int i8 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 747996237, "C994@35326L37,996@35418L92,995@35380L208,1005@35694L76,1008@35790L1028,1003@35606L1212:PopupBubbleMenu.kt#92mklk");
                final PopupState popupState3 = PopupBubbleMenuKt.rememberPopupState(false, $composer, 6, 0);
                ComposerKt.sourceInformationMarkerStart($composer, -807153011, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                invalid$iv6 = $composer.changed(popupState3);
                Object it$iv8 = $composer.rememberedValue();
                if (invalid$iv6) {
                }
                Object value$iv8 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda30
                    public final Object invoke() {
                        Unit lambda_492475797$lambda$0$0$2$0$0;
                        lambda_492475797$lambda$0$0$2$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$2$0$0(PopupState.this);
                        return lambda_492475797$lambda$0$0$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv8);
                it$iv8 = value$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.Button((Function0) it$iv8, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, f53lambda$878037855, $composer, 805306368, 510);
                ComposerKt.sourceInformationMarkerStart($composer, -807144195, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                invalid$iv7 = $composer.changed(popupState3);
                Object it$iv9 = $composer.rememberedValue();
                if (invalid$iv7) {
                }
                Object value$iv9 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit lambda_492475797$lambda$0$0$2$1$0;
                        lambda_492475797$lambda$0$0$2$1$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$2$1$0(PopupState.this);
                        return lambda_492475797$lambda$0$0$2$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv9);
                it$iv9 = value$iv9;
                Function0 function03 = (Function0) it$iv9;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -807140171, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                invalid$iv8 = $composer.changed(popupState3);
                Object it$iv10 = $composer.rememberedValue();
                if (invalid$iv8) {
                }
                Object value$iv10 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit lambda_492475797$lambda$0$0$2$2$0;
                        lambda_492475797$lambda$0$0$2$2$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$2$2$0(PopupState.this, (LazyListScope) obj);
                        return lambda_492475797$lambda$0$0$2$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv10);
                it$iv10 = value$iv10;
                ComposerKt.sourceInformationMarkerEnd($composer);
                PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState3, function03, null, null, 0.0f, null, null, null, (Function1) it$iv10, $composer, 0, 252);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv5 = PaddingKt.padding-VpY3zN4$default($this$lambda_492475797_u24lambda_u240_u240.align(Modifier.Companion, Alignment.Companion.getTopCenter()), Dp.constructor-impl(10), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv5 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv5, false);
                int $changed$iv$iv5 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv5);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if (!$composer.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                    $composer.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                int i10 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -292295602, "C1040@37062L37,1042@37154L92,1041@37116L208,1051@37430L76,1054@37526L1028,1049@37342L1212:PopupBubbleMenu.kt#92mklk");
                final PopupState popupState4 = PopupBubbleMenuKt.rememberPopupState(false, $composer, 6, 0);
                ComposerKt.sourceInformationMarkerStart($composer, -563616148, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                invalid$iv9 = $composer.changed(popupState4);
                it$iv = $composer.rememberedValue();
                if (!invalid$iv9 && it$iv != Composer.Companion.getEmpty()) {
                    value$iv2 = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ButtonKt.Button(value$iv2, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, f50lambda$1114655680, $composer, 805306368, 510);
                    ComposerKt.sourceInformationMarkerStart($composer, -563607332, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                    invalid$iv10 = $composer.changed(popupState4);
                    Object it$iv11 = $composer.rememberedValue();
                    if (invalid$iv10) {
                    }
                    Object value$iv11 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit lambda_492475797$lambda$0$0$3$1$0;
                            lambda_492475797$lambda$0$0$3$1$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$3$1$0(PopupState.this);
                            return lambda_492475797$lambda$0$0$3$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv11);
                    it$iv11 = value$iv11;
                    Function0 function04 = (Function0) it$iv11;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -563603308, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                    invalid$iv11 = $composer.changed(popupState4);
                    Object it$iv12 = $composer.rememberedValue();
                    if (invalid$iv11) {
                    }
                    Object value$iv12 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            Unit lambda_492475797$lambda$0$0$3$2$0;
                            lambda_492475797$lambda$0$0$3$2$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$3$2$0(PopupState.this, (LazyListScope) obj);
                            return lambda_492475797$lambda$0$0$3$2$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv12);
                    it$iv12 = value$iv12;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState4, function04, null, null, 0.0f, null, null, null, (Function1) it$iv12, $composer, 0, 252);
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
                }
                value$iv2 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit lambda_492475797$lambda$0$0$3$0$0;
                        lambda_492475797$lambda$0$0$3$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$3$0$0(PopupState.this);
                        return lambda_492475797$lambda$0$0$3$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.Button(value$iv2, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, f50lambda$1114655680, $composer, 805306368, 510);
                ComposerKt.sourceInformationMarkerStart($composer, -563607332, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                invalid$iv10 = $composer.changed(popupState4);
                Object it$iv112 = $composer.rememberedValue();
                if (invalid$iv10) {
                }
                Object value$iv112 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit lambda_492475797$lambda$0$0$3$1$0;
                        lambda_492475797$lambda$0$0$3$1$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$3$1$0(PopupState.this);
                        return lambda_492475797$lambda$0$0$3$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv112);
                it$iv112 = value$iv112;
                Function0 function042 = (Function0) it$iv112;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -563603308, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                invalid$iv11 = $composer.changed(popupState4);
                Object it$iv122 = $composer.rememberedValue();
                if (invalid$iv11) {
                }
                Object value$iv122 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit lambda_492475797$lambda$0$0$3$2$0;
                        lambda_492475797$lambda$0$0$3$2$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$3$2$0(PopupState.this, (LazyListScope) obj);
                        return lambda_492475797$lambda$0$0$3$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv122);
                it$iv122 = value$iv122;
                ComposerKt.sourceInformationMarkerEnd($composer);
                PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState4, function042, null, null, 0.0f, null, null, null, (Function1) it$iv122, $composer, 0, 252);
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
                }
            }
            value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit lambda_492475797$lambda$0$0$0$0$0;
                    lambda_492475797$lambda$0$0$0$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$0$0$0(PopupState.this);
                    return lambda_492475797$lambda$0$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button(value$iv, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, lambda$420965273, $composer, 805306368, 510);
            ComposerKt.sourceInformationMarkerStart($composer, -1524430347, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            invalid$iv = $composer.changed(popupState);
            Object it$iv32 = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv32 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit lambda_492475797$lambda$0$0$0$1$0;
                    lambda_492475797$lambda$0$0$0$1$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$0$1$0(PopupState.this);
                    return lambda_492475797$lambda$0$0$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv32);
            it$iv32 = value$iv32;
            Function0 function05 = (Function0) it$iv32;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1524426323, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            invalid$iv2 = $composer.changed(popupState);
            Object it$iv42 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv42 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    Unit lambda_492475797$lambda$0$0$0$2$0;
                    lambda_492475797$lambda$0$0$0$2$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$0$2$0(PopupState.this, (LazyListScope) obj);
                    return lambda_492475797$lambda$0$0$0$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv42);
            it$iv42 = value$iv42;
            ComposerKt.sourceInformationMarkerEnd($composer);
            PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState, function05, null, null, 0.0f, null, null, null, (Function1) it$iv42, $composer, 0, 252);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv32 = PaddingKt.padding-VpY3zN4$default($this$lambda_492475797_u24lambda_u240_u240.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), Dp.constructor-impl(10), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv32 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv32 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv32, false);
            int $changed$iv$iv32 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv32 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer, modifier$iv32);
            Function0 factory$iv$iv$iv82 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
            }
            $composer.startReusableNode();
            if (!$composer.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
            int i52 = ($changed$iv$iv$iv32 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
            int i62 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1788288045, "C948@33588L37,950@33680L92,949@33642L208,959@33956L76,962@34052L1027,957@33868L1211:PopupBubbleMenu.kt#92mklk");
            final PopupState popupState22 = PopupBubbleMenuKt.rememberPopupState(false, $composer, 6, 0);
            ComposerKt.sourceInformationMarkerStart($composer, -1050689874, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            invalid$iv3 = $composer.changed(popupState22);
            Object it$iv52 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv52 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda8
                public final Object invoke() {
                    Unit lambda_492475797$lambda$0$0$1$0$0;
                    lambda_492475797$lambda$0$0$1$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$1$0$0(PopupState.this);
                    return lambda_492475797$lambda$0$0$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv52);
            it$iv52 = value$iv52;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) it$iv52, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, f52lambda$641420030, $composer, 805306368, 510);
            ComposerKt.sourceInformationMarkerStart($composer, -1050681058, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            invalid$iv4 = $composer.changed(popupState22);
            Object it$iv62 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv62 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit lambda_492475797$lambda$0$0$1$1$0;
                    lambda_492475797$lambda$0$0$1$1$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$1$1$0(PopupState.this);
                    return lambda_492475797$lambda$0$0$1$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv62);
            it$iv62 = value$iv62;
            Function0 function022 = (Function0) it$iv62;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1050677035, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            invalid$iv5 = $composer.changed(popupState22);
            Object it$iv72 = $composer.rememberedValue();
            if (invalid$iv5) {
            }
            Object value$iv72 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj) {
                    Unit lambda_492475797$lambda$0$0$1$2$0;
                    lambda_492475797$lambda$0$0$1$2$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$1$2$0(PopupState.this, (LazyListScope) obj);
                    return lambda_492475797$lambda$0$0$1$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv72);
            it$iv72 = value$iv72;
            ComposerKt.sourceInformationMarkerEnd($composer);
            PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState22, function022, null, null, 0.0f, null, null, null, (Function1) it$iv72, $composer, 0, 252);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv42 = PaddingKt.padding-VpY3zN4$default($this$lambda_492475797_u24lambda_u240_u240.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), Dp.constructor-impl(10), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv42 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv42 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv42, false);
            int $changed$iv$iv42 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv42 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer, modifier$iv42);
            Function0 factory$iv$iv$iv92 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
            }
            $composer.startReusableNode();
            if (!$composer.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv42, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
            int i72 = ($changed$iv$iv$iv42 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope32 = BoxScopeInstance.INSTANCE;
            int i82 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 747996237, "C994@35326L37,996@35418L92,995@35380L208,1005@35694L76,1008@35790L1028,1003@35606L1212:PopupBubbleMenu.kt#92mklk");
            final PopupState popupState32 = PopupBubbleMenuKt.rememberPopupState(false, $composer, 6, 0);
            ComposerKt.sourceInformationMarkerStart($composer, -807153011, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            invalid$iv6 = $composer.changed(popupState32);
            Object it$iv82 = $composer.rememberedValue();
            if (invalid$iv6) {
            }
            Object value$iv82 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda30
                public final Object invoke() {
                    Unit lambda_492475797$lambda$0$0$2$0$0;
                    lambda_492475797$lambda$0$0$2$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$2$0$0(PopupState.this);
                    return lambda_492475797$lambda$0$0$2$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv82);
            it$iv82 = value$iv82;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) it$iv82, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, f53lambda$878037855, $composer, 805306368, 510);
            ComposerKt.sourceInformationMarkerStart($composer, -807144195, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            invalid$iv7 = $composer.changed(popupState32);
            Object it$iv92 = $composer.rememberedValue();
            if (invalid$iv7) {
            }
            Object value$iv92 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit lambda_492475797$lambda$0$0$2$1$0;
                    lambda_492475797$lambda$0$0$2$1$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$2$1$0(PopupState.this);
                    return lambda_492475797$lambda$0$0$2$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv92);
            it$iv92 = value$iv92;
            Function0 function032 = (Function0) it$iv92;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -807140171, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            invalid$iv8 = $composer.changed(popupState32);
            Object it$iv102 = $composer.rememberedValue();
            if (invalid$iv8) {
            }
            Object value$iv102 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit lambda_492475797$lambda$0$0$2$2$0;
                    lambda_492475797$lambda$0$0$2$2$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$2$2$0(PopupState.this, (LazyListScope) obj);
                    return lambda_492475797$lambda$0$0$2$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv102);
            it$iv102 = value$iv102;
            ComposerKt.sourceInformationMarkerEnd($composer);
            PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState32, function032, null, null, 0.0f, null, null, null, (Function1) it$iv102, $composer, 0, 252);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv52 = PaddingKt.padding-VpY3zN4$default($this$lambda_492475797_u24lambda_u240_u240.align(Modifier.Companion, Alignment.Companion.getTopCenter()), Dp.constructor-impl(10), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv52 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv52 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv52, false);
            int $changed$iv$iv52 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv52 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer, modifier$iv52);
            Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv52 = (($changed$iv$iv52 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
            }
            $composer.startReusableNode();
            if (!$composer.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv52, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
            int i92 = ($changed$iv$iv$iv52 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope42 = BoxScopeInstance.INSTANCE;
            int i102 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -292295602, "C1040@37062L37,1042@37154L92,1041@37116L208,1051@37430L76,1054@37526L1028,1049@37342L1212:PopupBubbleMenu.kt#92mklk");
            final PopupState popupState42 = PopupBubbleMenuKt.rememberPopupState(false, $composer, 6, 0);
            ComposerKt.sourceInformationMarkerStart($composer, -563616148, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            invalid$iv9 = $composer.changed(popupState42);
            it$iv = $composer.rememberedValue();
            if (!invalid$iv9) {
                value$iv2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.Button(value$iv2, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, f50lambda$1114655680, $composer, 805306368, 510);
                ComposerKt.sourceInformationMarkerStart($composer, -563607332, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                invalid$iv10 = $composer.changed(popupState42);
                Object it$iv1122 = $composer.rememberedValue();
                if (invalid$iv10) {
                }
                Object value$iv1122 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit lambda_492475797$lambda$0$0$3$1$0;
                        lambda_492475797$lambda$0$0$3$1$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$3$1$0(PopupState.this);
                        return lambda_492475797$lambda$0$0$3$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv1122);
                it$iv1122 = value$iv1122;
                Function0 function0422 = (Function0) it$iv1122;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -563603308, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                invalid$iv11 = $composer.changed(popupState42);
                Object it$iv1222 = $composer.rememberedValue();
                if (invalid$iv11) {
                }
                Object value$iv1222 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit lambda_492475797$lambda$0$0$3$2$0;
                        lambda_492475797$lambda$0$0$3$2$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$3$2$0(PopupState.this, (LazyListScope) obj);
                        return lambda_492475797$lambda$0$0$3$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv1222);
                it$iv1222 = value$iv1222;
                ComposerKt.sourceInformationMarkerEnd($composer);
                PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState42, function0422, null, null, 0.0f, null, null, null, (Function1) it$iv1222, $composer, 0, 252);
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
                }
            }
            value$iv2 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit lambda_492475797$lambda$0$0$3$0$0;
                    lambda_492475797$lambda$0$0$3$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$3$0$0(PopupState.this);
                    return lambda_492475797$lambda$0$0$3$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button(value$iv2, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, f50lambda$1114655680, $composer, 805306368, 510);
            ComposerKt.sourceInformationMarkerStart($composer, -563607332, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            invalid$iv10 = $composer.changed(popupState42);
            Object it$iv11222 = $composer.rememberedValue();
            if (invalid$iv10) {
            }
            Object value$iv11222 = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit lambda_492475797$lambda$0$0$3$1$0;
                    lambda_492475797$lambda$0$0$3$1$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$3$1$0(PopupState.this);
                    return lambda_492475797$lambda$0$0$3$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv11222);
            it$iv11222 = value$iv11222;
            Function0 function04222 = (Function0) it$iv11222;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -563603308, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            invalid$iv11 = $composer.changed(popupState42);
            Object it$iv12222 = $composer.rememberedValue();
            if (invalid$iv11) {
            }
            Object value$iv12222 = new Function1() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit lambda_492475797$lambda$0$0$3$2$0;
                    lambda_492475797$lambda$0$0$3$2$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$3$2$0(PopupState.this, (LazyListScope) obj);
                    return lambda_492475797$lambda$0$0$3$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv12222);
            it$iv12222 = value$iv12222;
            ComposerKt.sourceInformationMarkerEnd($composer);
            PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState42, function04222, null, null, 0.0f, null, null, null, (Function1) it$iv12222, $composer, 0, 252);
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
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$0$0$0(PopupState $popupState) {
        $popupState.setVisible(!$popupState.isVisible());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_420965273$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C909@32079L18:PopupBubbleMenu.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(420965273, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$420965273.<anonymous> (PopupBubbleMenu.kt:909)");
            }
            TextKt.Text-Nvy7gAk("Show PopUp", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$0$1$0(PopupState $popupState) {
        $popupState.setVisible(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$0$2$0(final PopupState $popupState, LazyListScope $this$PopupBubbleMenu) {
        Intrinsics.checkNotNullParameter($this$PopupBubbleMenu, "$this$PopupBubbleMenu");
        LazyListScope.-CC.items$default($this$PopupBubbleMenu, 10, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1326434179, true, new Function4() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda22
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit lambda_492475797$lambda$0$0$0$2$0$0;
                lambda_492475797$lambda$0$0$0$2$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$0$2$0$0(PopupState.this, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return lambda_492475797$lambda$0$0$0$2$0$0;
            }
        }), 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0179, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit lambda_492475797$lambda$0$0$0$2$0$0(final PopupState $popupState, LazyItemScope $this$items, final int index, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index)919@32384L921:PopupBubbleMenu.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        if ($composer.shouldExecute(($dirty & 145) != 144, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1326434179, $dirty, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$492475797.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PopupBubbleMenu.kt:919)");
            }
            Modifier modifier$iv = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1776109595, "C923@32573L100,926@32714L266,922@32510L643:PopupBubbleMenu.kt#92mklk");
            ComposerKt.sourceInformationMarkerStart($composer, -1882367445, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            boolean invalid$iv = $composer.changed($popupState);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda26
                public final Object invoke() {
                    Unit lambda_492475797$lambda$0$0$0$2$0$0$0$0$0;
                    lambda_492475797$lambda$0$0$0$2$0$0$0$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$0$2$0$0$0$0$0(PopupState.this);
                    return lambda_492475797$lambda$0$0$0$2$0$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            PopupBubbleMenuKt.PopupBubbleMenuItem((Function0) it$iv, ComposableLambdaKt.rememberComposableLambda(268661605, true, new Function2() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda27
                public final Object invoke(Object obj, Object obj2) {
                    Unit lambda_492475797$lambda$0$0$0$2$0$0$0$1;
                    lambda_492475797$lambda$0$0$0$2$0$0$0$1 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$0$2$0$0$0$1(index, (Composer) obj, ((Integer) obj2).intValue());
                    return lambda_492475797$lambda$0$0$0$2$0$0$0$1;
                }
            }, $composer, 54), null, false, PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null), null, null, $composer, 1597488, 44);
            if (index != 9) {
                $composer.startReplaceGroup(1776770762);
                ComposerKt.sourceInformation($composer, "936@33232L17");
                DividerKt.VerticalDivider-9IZ8Weo((Modifier) null, 0.0f, 0L, $composer, 0, 7);
            } else {
                $composer.startReplaceGroup(1743834843);
            }
            $composer.endReplaceGroup();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$0$2$0$0$0$0$0(PopupState $popupState) {
        $popupState.setVisible(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$0$2$0$0$0$1(int $index, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C927@32752L194:PopupBubbleMenu.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(268661605, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$492475797.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PopupBubbleMenu.kt:927)");
            }
            TextKt.Text-Nvy7gAk("Item " + $index, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 2, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 48, 0, 262140);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$1$0$0(PopupState $popupState) {
        $popupState.setVisible(!$popupState.isVisible());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__641420030$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C954@33814L18:PopupBubbleMenu.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-641420030, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$-641420030.<anonymous> (PopupBubbleMenu.kt:954)");
            }
            TextKt.Text-Nvy7gAk("Show PopUp", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$1$1$0(PopupState $popupState) {
        $popupState.setVisible(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$1$2$0(final PopupState $popupState, LazyListScope $this$PopupBubbleMenu) {
        Intrinsics.checkNotNullParameter($this$PopupBubbleMenu, "$this$PopupBubbleMenu");
        LazyListScope.-CC.items$default($this$PopupBubbleMenu, 4, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1930804844, true, new Function4() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda23
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit lambda_492475797$lambda$0$0$1$2$0$0;
                lambda_492475797$lambda$0$0$1$2$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$1$2$0$0(PopupState.this, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return lambda_492475797$lambda$0$0$1$2$0$0;
            }
        }), 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0179, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit lambda_492475797$lambda$0$0$1$2$0$0(final PopupState $popupState, LazyItemScope $this$items, final int index, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index)964@34118L921:PopupBubbleMenu.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        if ($composer.shouldExecute(($dirty & 145) != 144, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1930804844, $dirty, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$492475797.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PopupBubbleMenu.kt:964)");
            }
            Modifier modifier$iv = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1112169070, "C968@34307L100,971@34448L266,967@34244L643:PopupBubbleMenu.kt#92mklk");
            ComposerKt.sourceInformationMarkerStart($composer, -1421348396, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            boolean invalid$iv = $composer.changed($popupState);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda12
                public final Object invoke() {
                    Unit lambda_492475797$lambda$0$0$1$2$0$0$0$0$0;
                    lambda_492475797$lambda$0$0$1$2$0$0$0$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$1$2$0$0$0$0$0(PopupState.this);
                    return lambda_492475797$lambda$0$0$1$2$0$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            PopupBubbleMenuKt.PopupBubbleMenuItem((Function0) it$iv, ComposableLambdaKt.rememberComposableLambda(-976356914, true, new Function2() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit lambda_492475797$lambda$0$0$1$2$0$0$0$1;
                    lambda_492475797$lambda$0$0$1$2$0$0$0$1 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$1$2$0$0$0$1(index, (Composer) obj, ((Integer) obj2).intValue());
                    return lambda_492475797$lambda$0$0$1$2$0$0$0$1;
                }
            }, $composer, 54), null, false, PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null), null, null, $composer, 1597488, 44);
            if (index != 9) {
                $composer.startReplaceGroup(-1111507903);
                ComposerKt.sourceInformation($composer, "981@34966L17");
                DividerKt.VerticalDivider-9IZ8Weo((Modifier) null, 0.0f, 0L, $composer, 0, 7);
            } else {
                $composer.startReplaceGroup(-1146163950);
            }
            $composer.endReplaceGroup();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$1$2$0$0$0$0$0(PopupState $popupState) {
        $popupState.setVisible(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$1$2$0$0$0$1(int $index, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C972@34486L194:PopupBubbleMenu.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-976356914, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$492475797.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PopupBubbleMenu.kt:972)");
            }
            TextKt.Text-Nvy7gAk("Item " + $index, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 2, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 48, 0, 262140);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$2$0$0(PopupState $popupState) {
        $popupState.setVisible(!$popupState.isVisible());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__878037855$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C1000@35552L18:PopupBubbleMenu.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-878037855, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$-878037855.<anonymous> (PopupBubbleMenu.kt:1000)");
            }
            TextKt.Text-Nvy7gAk("Show PopUp", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$2$1$0(PopupState $popupState) {
        $popupState.setVisible(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$2$2$0(final PopupState $popupState, LazyListScope $this$PopupBubbleMenu) {
        Intrinsics.checkNotNullParameter($this$PopupBubbleMenu, "$this$PopupBubbleMenu");
        LazyListScope.-CC.items$default($this$PopupBubbleMenu, 10, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1694187019, true, new Function4() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit lambda_492475797$lambda$0$0$2$2$0$0;
                lambda_492475797$lambda$0$0$2$2$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$2$2$0$0(PopupState.this, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return lambda_492475797$lambda$0$0$2$2$0$0;
            }
        }), 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0179, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit lambda_492475797$lambda$0$0$2$2$0$0(final PopupState $popupState, LazyItemScope $this$items, final int index, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index)1010@35857L921:PopupBubbleMenu.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        if ($composer.shouldExecute(($dirty & 145) != 144, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1694187019, $dirty, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$492475797.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PopupBubbleMenu.kt:1010)");
            }
            Modifier modifier$iv = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 2142506387, "C1014@36046L100,1017@36187L266,1013@35983L643:PopupBubbleMenu.kt#92mklk");
            ComposerKt.sourceInformationMarkerStart($composer, -1177811533, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            boolean invalid$iv = $composer.changed($popupState);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda28
                public final Object invoke() {
                    Unit lambda_492475797$lambda$0$0$2$2$0$0$0$0$0;
                    lambda_492475797$lambda$0$0$2$2$0$0$0$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$2$2$0$0$0$0$0(PopupState.this);
                    return lambda_492475797$lambda$0$0$2$2$0$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            PopupBubbleMenuKt.PopupBubbleMenuItem((Function0) it$iv, ComposableLambdaKt.rememberComposableLambda(-1212974739, true, new Function2() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda29
                public final Object invoke(Object obj, Object obj2) {
                    Unit lambda_492475797$lambda$0$0$2$2$0$0$0$1;
                    lambda_492475797$lambda$0$0$2$2$0$0$0$1 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$2$2$0$0$0$1(index, (Composer) obj, ((Integer) obj2).intValue());
                    return lambda_492475797$lambda$0$0$2$2$0$0$0$1;
                }
            }, $composer, 54), null, false, PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null), null, null, $composer, 1597488, 44);
            if (index != 9) {
                $composer.startReplaceGroup(2143167554);
                ComposerKt.sourceInformation($composer, "1027@36705L17");
                DividerKt.VerticalDivider-9IZ8Weo((Modifier) null, 0.0f, 0L, $composer, 0, 7);
            } else {
                $composer.startReplaceGroup(2106786419);
            }
            $composer.endReplaceGroup();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$2$2$0$0$0$0$0(PopupState $popupState) {
        $popupState.setVisible(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$2$2$0$0$0$1(int $index, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1018@36225L194:PopupBubbleMenu.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1212974739, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$492475797.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PopupBubbleMenu.kt:1018)");
            }
            TextKt.Text-Nvy7gAk("Item " + $index, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 2, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 48, 0, 262140);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$3$0$0(PopupState $popupState) {
        $popupState.setVisible(!$popupState.isVisible());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1114655680$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C1046@37288L18:PopupBubbleMenu.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1114655680, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$-1114655680.<anonymous> (PopupBubbleMenu.kt:1046)");
            }
            TextKt.Text-Nvy7gAk("Show PopUp", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$3$1$0(PopupState $popupState) {
        $popupState.setVisible(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$3$2$0(final PopupState $popupState, LazyListScope $this$PopupBubbleMenu) {
        Intrinsics.checkNotNullParameter($this$PopupBubbleMenu, "$this$PopupBubbleMenu");
        LazyListScope.-CC.items$default($this$PopupBubbleMenu, 10, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1457569194, true, new Function4() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda25
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit lambda_492475797$lambda$0$0$3$2$0$0;
                lambda_492475797$lambda$0$0$3$2$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$3$2$0$0(PopupState.this, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return lambda_492475797$lambda$0$0$3$2$0$0;
            }
        }), 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0179, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit lambda_492475797$lambda$0$0$3$2$0$0(final PopupState $popupState, LazyItemScope $this$items, final int index, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index)1056@37593L921:PopupBubbleMenu.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        if ($composer.shouldExecute(($dirty & 145) != 144, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1457569194, $dirty, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$492475797.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PopupBubbleMenu.kt:1056)");
            }
            Modifier modifier$iv = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1102214548, "C1060@37782L100,1063@37923L266,1059@37719L643:PopupBubbleMenu.kt#92mklk");
            ComposerKt.sourceInformationMarkerStart($composer, -934274670, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            boolean invalid$iv = $composer.changed($popupState);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda21
                public final Object invoke() {
                    Unit lambda_492475797$lambda$0$0$3$2$0$0$0$0$0;
                    lambda_492475797$lambda$0$0$3$2$0$0$0$0$0 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$3$2$0$0$0$0$0(PopupState.this);
                    return lambda_492475797$lambda$0$0$3$2$0$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            PopupBubbleMenuKt.PopupBubbleMenuItem((Function0) it$iv, ComposableLambdaKt.rememberComposableLambda(-1449592564, true, new Function2() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt$$ExternalSyntheticLambda24
                public final Object invoke(Object obj, Object obj2) {
                    Unit lambda_492475797$lambda$0$0$3$2$0$0$0$1;
                    lambda_492475797$lambda$0$0$3$2$0$0$0$1 = ComposableSingletons$PopupBubbleMenuKt.lambda_492475797$lambda$0$0$3$2$0$0$0$1(index, (Composer) obj, ((Integer) obj2).intValue());
                    return lambda_492475797$lambda$0$0$3$2$0$0$0$1;
                }
            }, $composer, 54), null, false, PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(10), 0.0f, 2, (Object) null), null, null, $composer, 1597488, 44);
            if (index != 9) {
                $composer.startReplaceGroup(1102875715);
                ComposerKt.sourceInformation($composer, "1073@38441L17");
                DividerKt.VerticalDivider-9IZ8Weo((Modifier) null, 0.0f, 0L, $composer, 0, 7);
            } else {
                $composer.startReplaceGroup(1064772468);
            }
            $composer.endReplaceGroup();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$3$2$0$0$0$0$0(PopupState $popupState) {
        $popupState.setVisible(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_492475797$lambda$0$0$3$2$0$0$0$1(int $index, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1064@37961L194:PopupBubbleMenu.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1449592564, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$PopupBubbleMenuKt.lambda$492475797.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PopupBubbleMenu.kt:1064)");
            }
            TextKt.Text-Nvy7gAk("Item " + $index, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 2, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 48, 0, 262140);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}