package tv.danmaku.bili.fullscreen.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.account.R;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.utils.ModifierUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginIdlePage;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: FullscreenLoginIdlePage.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a+\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"FullscreenLoginIdle", "", LoginReporterV2.PAGE_FROM_KEY, "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginIdlePage;", "onAction", "Lkotlin/Function1;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "(Ltv/danmaku/bili/fullscreen/state/FullscreenLoginIdlePage;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SmsOrPasswordActionPanel", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenLoginIdlePageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginIdle$lambda$1(FullscreenLoginIdlePage fullscreenLoginIdlePage, Function1 function1, int i, Composer composer, int i2) {
        FullscreenLoginIdle(fullscreenLoginIdlePage, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsOrPasswordActionPanel$lambda$1(Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        SmsOrPasswordActionPanel(modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x019f, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FullscreenLoginIdle(final FullscreenLoginIdlePage page, final Function1<? super IFullscreenAction, Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer3 = $composer.startRestartGroup(316828222);
        ComposerKt.sourceInformation($composer3, "C(FullscreenLoginIdle)N(page,onAction)28@1068L809:FullscreenLoginIdlePage.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(page) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(316828222, $dirty, -1, "tv.danmaku.bili.fullscreen.page.FullscreenLoginIdle (FullscreenLoginIdlePage.kt:27)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier modifier$iv$iv = Modifier.Companion;
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & BR.containerVisible) | 6;
            BoxScope $this$FullscreenLoginIdle_u24lambda_u240 = boxScope;
            ComposerKt.sourceInformationMarkerStart($composer3, -163211434, "C40@1588L283:FullscreenLoginIdlePage.kt#gqoihp");
            if (page.getSkippable()) {
                $composer3.startReplaceGroup(-163201267);
                ComposerKt.sourceInformation($composer3, "31@1145L72,33@1299L46,36@1493L6,37@1541L9,30@1116L453");
                String stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_146, $composer3, 0);
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer3, -2083468666, "CC(remember):FullscreenLoginIdlePage.kt#9igjgp");
                boolean invalid$iv = ($dirty & BR.containerVisible) == 32;
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginIdlePageKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit FullscreenLoginIdle$lambda$0$0$0;
                        FullscreenLoginIdle$lambda$0$0$0 = FullscreenLoginIdlePageKt.FullscreenLoginIdle$lambda$0$0$0(function1);
                        return FullscreenLoginIdle$lambda$0$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                TextKt.Text--4IGK_g(stringResource, $this$FullscreenLoginIdle_u24lambda_u240.align(PaddingKt.padding-VpY3zN4(ModifierUtilsKt.clickableNoInteraction$default(modifier, false, (Function0) it$iv, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(11)), Alignment.Companion.getTopEnd()), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer3, 0, 0, 65528);
            } else {
                $composer3.startReplaceGroup(-164310230);
            }
            $composer3.endReplaceGroup();
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((BR.nickTextColor >> 3) & 14) | ((BR.nickTextColor >> 3) & BR.containerVisible));
            int $changed$iv$iv2 = (BR.nickTextColor << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((BR.nickTextColor >> 6) & BR.containerVisible) | 6;
            ColumnScope $this$FullscreenLoginIdle_u24lambda_u240_u241 = columnScope;
            ComposerKt.sourceInformationMarkerStart($composer3, 1908189470, "C44@1730L41,45@1784L77:FullscreenLoginIdlePage.kt#gqoihp");
            CommonKt.LogoGroup(ColumnScope.-CC.weight$default($this$FullscreenLoginIdle_u24lambda_u240_u241, Modifier.Companion, 4.0f, false, 2, (Object) null), $composer3, 0);
            SmsOrPasswordActionPanel(ColumnScope.-CC.weight$default($this$FullscreenLoginIdle_u24lambda_u240_u241, Modifier.Companion, 6.0f, false, 2, (Object) null), function1, $composer3, $dirty & BR.containerVisible, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginIdlePageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit FullscreenLoginIdle$lambda$1;
                    FullscreenLoginIdle$lambda$1 = FullscreenLoginIdlePageKt.FullscreenLoginIdle$lambda$1(FullscreenLoginIdlePage.this, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return FullscreenLoginIdle$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenLoginIdle$lambda$0$0$0(Function1 $onAction) {
        $onAction.invoke(IFullscreenLoginAction.SkipLogin.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x01cf, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x021e, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SmsOrPasswordActionPanel(Modifier modifier, final Function1<? super IFullscreenAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-83163679);
        ComposerKt.sourceInformation($composer2, "C(SmsOrPasswordActionPanel)N(modifier,onAction)55@2017L714:FullscreenLoginIdlePage.kt#gqoihp");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-83163679, $dirty, -1, "tv.danmaku.bili.fullscreen.page.SmsOrPasswordActionPanel (FullscreenLoginIdlePage.kt:54)");
            }
            Modifier modifier$iv = SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(modifier3, 0.0f, Dp.constructor-impl(100), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl((float) BR.headerTitle));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(24));
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((BR.pendentVisible >> 3) & 14) | ((BR.pendentVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.pendentVisible << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((BR.pendentVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -638243387, "C63@2291L77,64@2397L78,62@2258L227,70@2528L76,71@2634L81,69@2495L230:FullscreenLoginIdlePage.kt#gqoihp");
            String stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_186, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -1683152423, "CC(remember):FullscreenLoginIdlePage.kt#9igjgp");
            boolean invalid$iv = ($dirty & BR.containerVisible) == 32;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginIdlePageKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit SmsOrPasswordActionPanel$lambda$0$0$0;
                    SmsOrPasswordActionPanel$lambda$0$0$0 = FullscreenLoginIdlePageKt.SmsOrPasswordActionPanel$lambda$0$0$0(function1);
                    return SmsOrPasswordActionPanel$lambda$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CommonKt.LoginButton(stringResource, false, null, (Function0) it$iv, $composer2, 0, 6);
            String stringResource2 = StringResources_androidKt.stringResource(R.string.account_global_string_72, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -1683144836, "CC(remember):FullscreenLoginIdlePage.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & BR.containerVisible) == 32;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginIdlePageKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit SmsOrPasswordActionPanel$lambda$0$1$0;
                    SmsOrPasswordActionPanel$lambda$0$1$0 = FullscreenLoginIdlePageKt.SmsOrPasswordActionPanel$lambda$0$1$0(function1);
                    return SmsOrPasswordActionPanel$lambda$0$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CommonKt.SwitchLogin(stringResource2, null, (Function0) it$iv2, $composer2, 0, 2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.FullscreenLoginIdlePageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SmsOrPasswordActionPanel$lambda$1;
                    SmsOrPasswordActionPanel$lambda$1 = FullscreenLoginIdlePageKt.SmsOrPasswordActionPanel$lambda$1(modifier2, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SmsOrPasswordActionPanel$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsOrPasswordActionPanel$lambda$0$0$0(Function1 $onAction) {
        $onAction.invoke(new IFullscreenLoginAction.SwitchToSms(false, 1, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmsOrPasswordActionPanel$lambda$0$1$0(Function1 $onAction) {
        $onAction.invoke(IFullscreenLoginAction.SwitchToPassword.INSTANCE);
        return Unit.INSTANCE;
    }
}