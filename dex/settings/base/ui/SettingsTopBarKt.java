package settings.base.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsTopBar.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aP\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0013\b\u0002\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a)\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0003¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"SettingsTopBar", "", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "showBackButton", "", "onBack", "Lkotlin/Function0;", "actionContent", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BackIcon", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SettingsTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackIcon$lambda$2(Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        BackIcon(modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$1(String str, Modifier modifier, boolean z, Function0 function0, Function2 function2, int i, int i2, Composer composer, int i3) {
        SettingsTopBar(str, modifier, z, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SettingsTopBar(final String title, Modifier modifier, boolean showBackButton, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        final Function0 onBack;
        Function2 actionContent;
        Composer $composer2;
        Modifier modifier3;
        boolean showBackButton2;
        Modifier modifier4;
        boolean showBackButton3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 onBack2;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(1943615339);
        ComposerKt.sourceInformation($composer3, "C(SettingsTopBar)N(title,modifier,showBackButton,onBack,actionContent)41@1677L11,43@1737L11,44@1794L10,44@1805L17,45@1911L5,45@1849L1487:SettingsTopBar.kt#d1bdve");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z = showBackButton;
        } else if (($changed & 384) == 0) {
            z = showBackButton;
            $dirty |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = showBackButton;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onBack = function0;
        } else if (($changed & 3072) == 0) {
            onBack = function0;
            $dirty |= $composer3.changedInstance(onBack) ? 2048 : 1024;
        } else {
            onBack = function0;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            actionContent = function2;
        } else if (($changed & 24576) == 0) {
            actionContent = function2;
            $dirty |= $composer3.changedInstance(actionContent) ? 16384 : 8192;
        } else {
            actionContent = function2;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            showBackButton2 = z;
        } else {
            if (i2 != 0) {
                modifier4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                showBackButton3 = z;
            } else {
                showBackButton3 = true;
            }
            if (i4 != 0) {
                onBack = null;
            }
            if (i5 != 0) {
                actionContent = ComposableSingletons$SettingsTopBarKt.INSTANCE.getLambda$51232450$base_debug();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1943615339, $dirty2, -1, "settings.base.ui.SettingsTopBar (SettingsTopBar.kt:39)");
            }
            long titleColor = BiliTheme.INSTANCE.getThemeColors($composer3, BiliTheme.$stable).getTextTitle-0d7_KjU();
            long iconColor = BiliTheme.INSTANCE.getThemeColors($composer3, BiliTheme.$stable).getActionIcon-0d7_KjU();
            float paddingTop = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer3, 6), $composer3, 0).calculateTopPadding-D9Ej5fM();
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(modifier4, ColorKt.Color(BiliTheme.INSTANCE.getTheme($composer3, BiliTheme.$stable).getPrimary()), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            Modifier modifier5 = modifier4;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            $composer2 = $composer3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Function2 actionContent2 = actionContent;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -17104536, "C47@1960L142,54@2112L1218:SettingsTopBar.kt#d1bdve");
            SpacerKt.Spacer(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, paddingTop), 0.0f, 1, (Object) null), $composer3, 0);
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44)), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            int $changed$iv$iv$iv2 = ((390 >> 3) & 14) | ((390 >> 3) & 112);
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, $changed$iv$iv$iv2);
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i9 = ((390 >> 6) & 112) | 6;
            RowScope $this$SettingsTopBar_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -290686599, "C58@2291L467,69@2835L221,69@2771L285,77@3069L251:SettingsTopBar.kt#d1bdve");
            Modifier modifier$iv3 = RowScope.-CC.weight$default($this$SettingsTopBar_u24lambda_u240_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv3 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i11 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 578682421, "C:SettingsTopBar.kt#d1bdve");
            if (showBackButton3) {
                $composer3.startReplaceGroup(578701640);
                ComposerKt.sourceInformation($composer3, "64@2620L106,64@2557L169");
                showBackButton2 = showBackButton3;
                onBack2 = onBack;
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(iconColor)), ComposableLambdaKt.rememberComposableLambda(-161533884, true, new Function2() { // from class: settings.base.ui.SettingsTopBarKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SettingsTopBar$lambda$0$0$0$0;
                        SettingsTopBar$lambda$0$0$0$0 = SettingsTopBarKt.SettingsTopBar$lambda$0$0$0$0(onBack, (Composer) obj, ((Integer) obj2).intValue());
                        return SettingsTopBar$lambda$0$0$0$0;
                    }
                }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
            } else {
                showBackButton2 = showBackButton3;
                onBack2 = onBack;
                $composer3.startReplaceGroup(576179449);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(titleColor)), ComposableLambdaKt.rememberComposableLambda(-806224891, true, new Function2() { // from class: settings.base.ui.SettingsTopBarKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingsTopBar$lambda$0$0$1;
                    SettingsTopBar$lambda$0$0$1 = SettingsTopBarKt.SettingsTopBar$lambda$0$0$1(title, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingsTopBar$lambda$0$0$1;
                }
            }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
            Modifier modifier$iv4 = RowScope.-CC.weight$default($this$SettingsTopBar_u24lambda_u240_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv4 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv7);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i12 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i13 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -344357132, "C82@3291L15:SettingsTopBar.kt#d1bdve");
            actionContent2.invoke($composer3, Integer.valueOf(($dirty2 >> 12) & 14));
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
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            actionContent = actionContent2;
            onBack = onBack2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z2 = showBackButton2;
            final Function0 function02 = onBack;
            final Function2 function22 = actionContent;
            endRestartGroup.updateScope(new Function2() { // from class: settings.base.ui.SettingsTopBarKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingsTopBar$lambda$1;
                    SettingsTopBar$lambda$1 = SettingsTopBarKt.SettingsTopBar$lambda$1(title, modifier6, z2, function02, function22, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingsTopBar$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$0$0$0$0(Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C65@2646L58:SettingsTopBar.kt#d1bdve");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-161533884, $changed, -1, "settings.base.ui.SettingsTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTopBar.kt:65)");
            }
            BackIcon(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $onBack, $composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$0$0$1(String $title, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C72@2921L14,70@2853L189:SettingsTopBar.kt#d1bdve");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-806224891, $changed, -1, "settings.base.ui.SettingsTopBar.<anonymous>.<anonymous>.<anonymous> (SettingsTopBar.kt:70)");
            }
            TextKt.Text-Nvy7gAk($title, (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, SettingsTopBar_androidKt.getTitleTextStyle($composer, 0), $composer, 0, 24960, 110590);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void BackIcon(Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        final Function0 onBack;
        Modifier modifier3;
        Function0 onBack2;
        Function0 function02;
        Composer $composer2 = $composer.startRestartGroup(-401476274);
        ComposerKt.sourceInformation($composer2, "C(BackIcon)N(modifier,onBack)105@3773L24,106@3847L16,107@3899L7,104@3736L212:SettingsTopBar.kt#d1bdve");
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
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            onBack = function0;
        } else if (($changed & 48) == 0) {
            onBack = function0;
            $dirty |= $composer2.changedInstance(onBack) ? 32 : 16;
        } else {
            onBack = function0;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                onBack2 = onBack;
            } else {
                onBack2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-401476274, $dirty2, -1, "settings.base.ui.BackIcon (SettingsTopBar.kt:92)");
            }
            if (onBack2 != null) {
                $composer2.startReplaceGroup(1104376470);
                $composer2.endReplaceGroup();
                function02 = onBack2;
            } else {
                $composer2.startReplaceGroup(1104417421);
                ComposerKt.sourceInformation($composer2, "97@3593L7,98@3613L108");
                final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
                ComposerKt.sourceInformationMarkerStart($composer2, 728365530, "CC(remember):SettingsTopBar.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: settings.base.ui.SettingsTopBarKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit BackIcon$lambda$0$0;
                            BackIcon$lambda$0$0 = SettingsTopBarKt.BackIcon$lambda$0$0(backHandler);
                            return BackIcon$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                function02 = (Function0) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            }
            final Function0 backAction = function02;
            Painter arrow_back_left_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 728372926, "CC(remember):SettingsTopBar.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(backAction);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: settings.base.ui.SettingsTopBarKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit BackIcon$lambda$1$0;
                        BackIcon$lambda$1$0 = SettingsTopBarKt.BackIcon$lambda$1$0(backAction);
                        return BackIcon$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier4 = ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            CompositionLocal this_$iv = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IconKt.Icon-ww6aTOc(arrow_back_left_line_500, (String) null, modifier4, ((Color) consume).unbox-impl(), $composer2, Painter.$stable | 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            onBack = onBack2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: settings.base.ui.SettingsTopBarKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BackIcon$lambda$2;
                    BackIcon$lambda$2 = SettingsTopBarKt.BackIcon$lambda$2(modifier2, onBack, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BackIcon$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackIcon$lambda$0$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackIcon$lambda$1$0(Function0 $backAction) {
        $backAction.invoke();
        return Unit.INSTANCE;
    }
}