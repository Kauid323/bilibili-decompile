package kntr.app.ad.ui.inspector.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kntr.app.ad.ui.inspector.model.UserRole;
import kntr.app.ad.ui.inspector.ui.LocalUserRoleKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StatsPanel.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\f\u001a=\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a5\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u001b\u0010\u001c\u001a+\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u001e\u001a9\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010&¨\u0006'²\u0006\n\u0010\u0019\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"StatsPanel", RoomRecommendViewModel.EMPTY_CURSOR, "isAnyFilterActive", RoomRecommendViewModel.EMPTY_CURSOR, "onClearAllFilters", "Lkotlin/Function0;", "filterContent", "Landroidx/compose/runtime/Composable;", "countItem1", "Lkntr/app/ad/ui/inspector/ui/components/StatsPanelCountItem;", "countItem2", "countItem3", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkntr/app/ad/ui/inspector/ui/components/StatsPanelCountItem;Lkntr/app/ad/ui/inspector/ui/components/StatsPanelCountItem;Lkntr/app/ad/ui/inspector/ui/components/StatsPanelCountItem;Landroidx/compose/runtime/Composer;I)V", "CommonCountItem", "count", RoomRecommendViewModel.EMPTY_CURSOR, "label", RoomRecommendViewModel.EMPTY_CURSOR, "selected", "color", "Landroidx/compose/ui/graphics/Color;", "onClick", "CommonCountItem-ww6aTOc", "(ILjava/lang/String;ZJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CommonFilterButton", "isFilterExpanded", "themeColor", "CommonFilterButton-Bx497Mc", "(ZZLkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "CommonFilterItem", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ModernSearchField", "value", "onValueChange", "Lkotlin/Function1;", "placeholder", "leadingIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)V", "ad-inspector_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StatsPanelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonCountItem_ww6aTOc$lambda$1(int i, String str, boolean z, long j2, Function0 function0, int i2, Composer composer, int i3) {
        m412CommonCountItemww6aTOc(i, str, z, j2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonFilterButton_Bx497Mc$lambda$2(boolean z, boolean z2, Function0 function0, long j2, int i, Composer composer, int i2) {
        m413CommonFilterButtonBx497Mc(z, z2, function0, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonFilterItem$lambda$1(String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        CommonFilterItem(str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernSearchField$lambda$1(String str, Function1 function1, String str2, ImageVector imageVector, int i, Composer composer, int i2) {
        ModernSearchField(str, function1, str2, imageVector, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsPanel$lambda$4(boolean z, Function0 function0, Function2 function2, StatsPanelCountItem statsPanelCountItem, StatsPanelCountItem statsPanelCountItem2, StatsPanelCountItem statsPanelCountItem3, int i, Composer composer, int i2) {
        StatsPanel(z, function0, function2, statsPanelCountItem, statsPanelCountItem2, statsPanelCountItem3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void StatsPanel(final boolean isAnyFilterActive, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final StatsPanelCountItem countItem1, final StatsPanelCountItem countItem2, final StatsPanelCountItem countItem3, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(function0, "onClearAllFilters");
        Intrinsics.checkNotNullParameter(function2, "filterContent");
        Intrinsics.checkNotNullParameter(countItem1, "countItem1");
        Intrinsics.checkNotNullParameter(countItem2, "countItem2");
        Intrinsics.checkNotNullParameter(countItem3, "countItem3");
        Composer $composer3 = $composer.startRestartGroup(-320997940);
        ComposerKt.sourceInformation($composer3, "C(StatsPanel)N(isAnyFilterActive,onClearAllFilters,filterContent,countItem1,countItem2,countItem3)68@2537L34,70@2608L7,76@2812L3252,71@2626L3438:StatsPanel.kt#pigpjk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(isAnyFilterActive) ? 4 : 2;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(countItem1) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(countItem2) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changed(countItem3) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute((74883 & $dirty2) != 74882, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-320997940, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.components.StatsPanel (StatsPanel.kt:66)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 758634126, "CC(remember):StatsPanel.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState isFilterExpanded$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocal this_$iv = LocalUserRoleKt.getLocalUserRole();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final long themeColor = ((UserRole) consume).m353getColor0d7_KjU();
            $composer2 = $composer3;
            SurfaceKt.Surface-T9BRK9s(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)), Color.Companion.getWhite-0d7_KjU(), 0L, 0.0f, 0.0f, BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl(1), ColorKt.Color(4293257195L)), ComposableLambdaKt.rememberComposableLambda(2098260775, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit StatsPanel$lambda$3;
                    StatsPanel$lambda$3 = StatsPanelKt.StatsPanel$lambda$3(StatsPanelCountItem.this, countItem2, countItem3, isAnyFilterActive, themeColor, isFilterExpanded$delegate, function2, (Composer) obj, ((Integer) obj2).intValue());
                    return StatsPanel$lambda$3;
                }
            }, $composer3, 54), $composer2, 14156166, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit StatsPanel$lambda$4;
                    StatsPanel$lambda$4 = StatsPanelKt.StatsPanel$lambda$4(isAnyFilterActive, function0, function2, countItem1, countItem2, countItem3, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return StatsPanel$lambda$4;
                }
            });
        }
    }

    private static final boolean StatsPanel$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void StatsPanel$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsPanel$lambda$3(StatsPanelCountItem $countItem1, StatsPanelCountItem $countItem2, StatsPanelCountItem $countItem3, boolean $isAnyFilterActive, long $themeColor, final MutableState $isFilterExpanded$delegate, final Function2 $filterContent, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C77@2822L3236:StatsPanel.kt#pigpjk");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2098260775, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.StatsPanel.<anonymous> (StatsPanel.kt:77)");
            }
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
            int $changed2 = ((6 >> 6) & 112) | 6;
            ColumnScope $this$StatsPanel_u24lambda_u243_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -321671866, "C79@2900L1703,142@5174L874,130@4640L1408:StatsPanel.kt#pigpjk");
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(4));
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
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
            int i2 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -797136831, "C88@3256L275,96@3549L17,99@3606L275,107@3899L17,110@3956L275,118@4249L17,124@4476L40,121@4310L279:StatsPanel.kt#pigpjk");
            m412CommonCountItemww6aTOc($countItem1.getCount(), $countItem1.getLabel(), $countItem1.getSelected(), ColorKt.Color(4279286145L), $countItem1.getOnClick(), $composer, 3072);
            VerticalDividerKt.VerticalDivider($composer, 0);
            m412CommonCountItemww6aTOc($countItem2.getCount(), $countItem2.getLabel(), $countItem2.getSelected(), ColorKt.Color(4293870660L), $countItem2.getOnClick(), $composer, 3072);
            VerticalDividerKt.VerticalDivider($composer, 0);
            m412CommonCountItemww6aTOc($countItem3.getCount(), $countItem3.getLabel(), $countItem3.getSelected(), ColorKt.Color(4294286859L), $countItem3.getOnClick(), $composer, 3072);
            VerticalDividerKt.VerticalDivider($composer, 0);
            boolean StatsPanel$lambda$1 = StatsPanel$lambda$1($isFilterExpanded$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, 1498344309, "CC(remember):StatsPanel.kt#9igjgp");
            Object value$iv = $composer.rememberedValue();
            if (value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit StatsPanel$lambda$3$0$0$0$0;
                        StatsPanel$lambda$3$0$0$0$0 = StatsPanelKt.StatsPanel$lambda$3$0$0$0$0($isFilterExpanded$delegate);
                        return StatsPanel$lambda$3$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            m413CommonFilterButtonBx497Mc(StatsPanel$lambda$1, $isAnyFilterActive, (Function0) value$iv, $themeColor, $composer, 384);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            AnimatedVisibilityKt.AnimatedVisibility($this$StatsPanel_u24lambda_u243_u240, StatsPanel$lambda$1($isFilterExpanded$delegate), (Modifier) null, EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(200, 0, (Easing) null, 6, (Object) null), Alignment.Companion.getTop(), false, (Function1) null, 12, (Object) null).plus(EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.3f, 1, (Object) null)), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(200, 0, (Easing) null, 6, (Object) null), Alignment.Companion.getTop(), false, (Function1) null, 12, (Object) null).plus(EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null)), (String) null, ComposableLambdaKt.rememberComposableLambda(-2121738727, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit StatsPanel$lambda$3$0$1;
                    StatsPanel$lambda$3$0$1 = StatsPanelKt.StatsPanel$lambda$3$0$1($filterContent, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return StatsPanel$lambda$3$0$1;
                }
            }, $composer, 54), $composer, ($changed2 & 14) | 1572864, 18);
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
    public static final Unit StatsPanel$lambda$3$0$0$0$0(MutableState $isFilterExpanded$delegate) {
        StatsPanel$lambda$2($isFilterExpanded$delegate, !StatsPanel$lambda$1($isFilterExpanded$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsPanel$lambda$3$0$1(Function2 $filterContent, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C143@5192L152,148@5362L672:StatsPanel.kt#pigpjk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2121738727, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.StatsPanel.<anonymous>.<anonymous>.<anonymous> (StatsPanel.kt:143)");
        }
        DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, 2, (Object) null), 0.0f, ColorKt.Color(4293257195L), $composer, 390, 2);
        Modifier modifier$iv = PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(16), Dp.constructor-impl(12));
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (6 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
        Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
        int $i$f$Box = $changed$iv$iv << 6;
        int $changed$iv$iv$iv = ($i$f$Box & 896) | 6;
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
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i2 = ((6 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -52379393, "C149@5455L70:StatsPanel.kt#pigpjk");
        ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        Modifier modifier$iv2 = Modifier.Companion;
        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        int i4 = ((0 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 1948166359, "C150@5488L15:StatsPanel.kt#pigpjk");
        $filterContent.invoke($composer, 0);
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
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0205, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L60;
     */
    /* renamed from: CommonCountItem-ww6aTOc  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m412CommonCountItemww6aTOc(final int count, final String label, final boolean selected, final long j2, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Object it$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer4 = $composer.startRestartGroup(-1443524463);
        ComposerKt.sourceInformation($composer4, "C(CommonCountItem)N(count,label,selected,color:c#ui.graphics.Color,onClick)181@6269L1730:StatsPanel.kt#pigpjk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(count) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(label) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(selected) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(j2) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1443524463, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.components.CommonCountItem (StatsPanel.kt:179)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(56));
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -1870201818, "C187@6551L39,189@6657L57,182@6355L1638:StatsPanel.kt#pigpjk");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer4, -60324418, "CC(remember):StatsPanel.kt#9igjgp");
            Object it$iv2 = $composer4.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object MutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                $composer4.updateRememberedValue(MutableInteractionSource);
                it$iv = MutableInteractionSource;
            } else {
                it$iv = it$iv2;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -60321008, "CC(remember):StatsPanel.kt#9igjgp");
            boolean invalid$iv = (57344 & $dirty2) == 16384;
            Object it$iv3 = $composer4.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit CommonCountItem_ww6aTOc$lambda$0$1$0;
                    CommonCountItem_ww6aTOc$lambda$0$1$0 = StatsPanelKt.CommonCountItem_ww6aTOc$lambda$0$1$0(function0);
                    return CommonCountItem_ww6aTOc$lambda$0$1$0;
                }
            };
            $composer4.updateRememberedValue(value$iv);
            it$iv3 = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-O2vRcR0$default(modifier, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null), Dp.constructor-impl(8), Dp.constructor-impl(0));
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -1060415545, "C196@6889L10,193@6784L334,203@7132L40,207@7260L10,205@7186L179:StatsPanel.kt#pigpjk");
            TextKt.Text-Nvy7gAk(String.valueOf(count), (Modifier) null, selected ? j2 : ColorKt.Color(4279310375L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getTitleMedium(), 0L, TextUnitKt.getSp(18), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer4, 0, 0, 131066);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer4, 6);
            $composer2 = $composer4;
            TextKt.Text-Nvy7gAk(label, (Modifier) null, selected ? j2 : ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelMedium(), $composer4, ($dirty2 >> 3) & 14, 0, 131066);
            if (selected) {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(-1059834017);
                ComposerKt.sourceInformation($composer3, "212@7411L40,213@7468L381");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer3, 6);
                BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), Dp.constructor-impl(24)), j2, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(1), Dp.constructor-impl(1), 0.0f, 0.0f, 12, (Object) null)), $composer3, 0);
                $composer3.endReplaceGroup();
            } else {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(-1059372861);
                ComposerKt.sourceInformation($composer3, "225@7929L40");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer3, 6);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommonCountItem_ww6aTOc$lambda$1;
                    CommonCountItem_ww6aTOc$lambda$1 = StatsPanelKt.CommonCountItem_ww6aTOc$lambda$1(count, label, selected, j2, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return CommonCountItem_ww6aTOc$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonCountItem_ww6aTOc$lambda$0$1$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: CommonFilterButton-Bx497Mc  reason: not valid java name */
    private static final void m413CommonFilterButtonBx497Mc(final boolean isFilterExpanded, final boolean isAnyFilterActive, final Function0<Unit> function0, final long j2, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(163462715);
        ComposerKt.sourceInformation($composer3, "C(CommonFilterButton)N(isFilterExpanded,isAnyFilterActive,onClick,themeColor:c#ui.graphics.Color)244@8256L13,241@8184L908:StatsPanel.kt#pigpjk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(isFilterExpanded) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(isAnyFilterActive) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(j2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(163462715, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.components.CommonFilterButton (StatsPanel.kt:240)");
            }
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer3, -1826113944, "CC(remember):StatsPanel.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit CommonFilterButton_Bx497Mc$lambda$0$0;
                        CommonFilterButton_Bx497Mc$lambda$0$0 = StatsPanelKt.CommonFilterButton_Bx497Mc$lambda$0$0(function0);
                        return CommonFilterButton_Bx497Mc$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(8), Dp.constructor-impl(4));
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
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
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 179307469, "C248@8393L693:StatsPanel.kt#pigpjk");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -2093714580, "C251@8482L242,258@8738L338:StatsPanel.kt#pigpjk");
            IconKt.Icon-ww6aTOc(AppIcons.INSTANCE.getFilterAlt(), "筛选", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), isAnyFilterActive ? j2 : ColorKt.Color(4285231744L), $composer3, 438, 0);
            AppIcons appIcons = AppIcons.INSTANCE;
            IconKt.Icon-ww6aTOc(isFilterExpanded ? appIcons.getKeyboardArrowUp() : appIcons.getKeyboardArrowDown(), isFilterExpanded ? "收起筛选" : "展开筛选", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), isAnyFilterActive ? j2 : ColorKt.Color(4288455599L), $composer3, 384, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommonFilterButton_Bx497Mc$lambda$2;
                    CommonFilterButton_Bx497Mc$lambda$2 = StatsPanelKt.CommonFilterButton_Bx497Mc$lambda$2(isFilterExpanded, isAnyFilterActive, function0, j2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return CommonFilterButton_Bx497Mc$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonFilterButton_Bx497Mc$lambda$0$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    public static final void CommonFilterItem(final String label, final boolean selected, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-358153120);
        ComposerKt.sourceInformation($composer3, "C(CommonFilterItem)N(label,selected,onClick)277@9262L7,282@9495L622,278@9280L837:StatsPanel.kt#pigpjk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(label) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(selected) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-358153120, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.components.CommonFilterItem (StatsPanel.kt:276)");
            }
            CompositionLocal this_$iv = LocalUserRoleKt.getLocalUserRole();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final long themeColor = ((UserRole) consume).m353getColor0d7_KjU();
            $composer2 = $composer3;
            SurfaceKt.Surface-T9BRK9s((Modifier) null, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)), selected ? Color.copy-wmQWz5c$default(themeColor, 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : ColorKt.Color(4294178038L), 0L, 0.0f, 0.0f, selected ? BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl(1), themeColor) : null, ComposableLambdaKt.rememberComposableLambda(1929850085, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommonFilterItem$lambda$0;
                    CommonFilterItem$lambda$0 = StatsPanelKt.CommonFilterItem$lambda$0(selected, themeColor, function0, label, (Composer) obj, ((Integer) obj2).intValue());
                    return CommonFilterItem$lambda$0;
                }
            }, $composer3, 54), $composer2, 12582912, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommonFilterItem$lambda$1;
                    CommonFilterItem$lambda$1 = StatsPanelKt.CommonFilterItem$lambda$1(label, selected, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return CommonFilterItem$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonFilterItem$lambda$0(boolean $selected, long $themeColor, final Function0 $onClick, String $label, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C286@9587L10,293@9915L39,295@10021L13,283@9505L606:StatsPanel.kt#pigpjk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1929850085, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.CommonFilterItem.<anonymous> (StatsPanel.kt:283)");
            }
            TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall();
            FontWeight.Companion companion = FontWeight.Companion;
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default(bodySmall, 0L, 0L, $selected ? companion.getMedium() : companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777211, (Object) null);
            long Color = $selected ? $themeColor : ColorKt.Color(4285231744L);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, -839926708, "CC(remember):StatsPanel.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -839923342, "CC(remember):StatsPanel.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onClick);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit CommonFilterItem$lambda$0$1$0;
                        CommonFilterItem$lambda$0$1$0 = StatsPanelKt.CommonFilterItem$lambda$0$1$0($onClick);
                        return CommonFilterItem$lambda$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text-Nvy7gAk($label, PaddingKt.padding-VpY3zN4(ClickableKt.clickable-O2vRcR0$default(modifier, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(6)), Color, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, textStyle, $composer, 0, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonFilterItem$lambda$0$1$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    public static final void ModernSearchField(final String value, final Function1<? super String, Unit> function1, final String placeholder, final ImageVector leadingIcon, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(leadingIcon, "leadingIcon");
        Composer $composer3 = $composer.startRestartGroup(601760335);
        ComposerKt.sourceInformation($composer3, "C(ModernSearchField)N(value,onValueChange,placeholder,leadingIcon)311@10370L7,316@10538L1881,312@10388L2031:StatsPanel.kt#pigpjk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(value) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(placeholder) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(leadingIcon) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(601760335, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.components.ModernSearchField (StatsPanel.kt:310)");
            }
            CompositionLocal this_$iv = LocalUserRoleKt.getLocalUserRole();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final long themeColor = ((UserRole) consume).m353getColor0d7_KjU();
            $composer2 = $composer3;
            SurfaceKt.Surface-T9BRK9s(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(34)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)), ColorKt.Color(4294178038L), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(2136255316, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit ModernSearchField$lambda$0;
                    ModernSearchField$lambda$0 = StatsPanelKt.ModernSearchField$lambda$0(leadingIcon, themeColor, value, function1, placeholder, (Composer) obj, ((Integer) obj2).intValue());
                    return ModernSearchField$lambda$0;
                }
            }, $composer3, 54), $composer2, 12583302, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit ModernSearchField$lambda$1;
                    ModernSearchField$lambda$1 = StatsPanelKt.ModernSearchField$lambda$1(value, function1, placeholder, leadingIcon, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ModernSearchField$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernSearchField$lambda$0(ImageVector $leadingIcon, final long $themeColor, final String $value, final Function1 $onValueChange, final String $placeholder, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C317@10548L1865:StatsPanel.kt#pigpjk");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2136255316, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.ModernSearchField.<anonymous> (StatsPanel.kt:317)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(8));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv = (390 << 3) & 112;
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
            int i2 = ((390 >> 6) & 112) | 6;
            final RowScope $this$ModernSearchField_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1572301299, "C321@10715L196,328@10925L39,335@11169L10,339@11367L483,330@10978L935:StatsPanel.kt#pigpjk");
            IconKt.Icon-ww6aTOc($leadingIcon, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), ColorKt.Color(4288455599L), $composer, 3504, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            BasicTextFieldKt.BasicTextField($value, $onValueChange, RowScope.-CC.weight$default($this$ModernSearchField_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), false, false, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), ColorKt.Color(4281811281L), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (VisualTransformation) null, (Function1) null, (MutableInteractionSource) null, new SolidColor($themeColor, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-88284939, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ModernSearchField$lambda$0$0$0;
                    ModernSearchField$lambda$0$0$0 = StatsPanelKt.ModernSearchField$lambda$0$0$0($this$ModernSearchField_u24lambda_u240_u240, $value, $placeholder, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ModernSearchField$lambda$0$0$0;
                }
            }, $composer, 54), $composer, 100663296, 196608, 16088);
            if ($value.length() > 0) {
                $composer.startReplaceGroup(1573489094);
                ComposerKt.sourceInformation($composer, "356@12011L21,358@12105L284,355@11969L420");
                ComposerKt.sourceInformationMarkerStart($composer, -641977459, "CC(remember):StatsPanel.kt#9igjgp");
                boolean invalid$iv = $composer.changed($onValueChange);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda12
                        public final Object invoke() {
                            Unit ModernSearchField$lambda$0$0$1$0;
                            ModernSearchField$lambda$0$0$1$0 = StatsPanelKt.ModernSearchField$lambda$0$0$1$0($onValueChange);
                            return ModernSearchField$lambda$0$0$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                IconButtonKt.IconButton((Function0) it$iv, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(1841898993, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.StatsPanelKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ModernSearchField$lambda$0$0$2;
                        ModernSearchField$lambda$0$0$2 = StatsPanelKt.ModernSearchField$lambda$0$0$2($themeColor, (Composer) obj, ((Integer) obj2).intValue());
                        return ModernSearchField$lambda$0$0$2;
                    }
                }, $composer, 54), $composer, 1572912, 60);
            } else {
                $composer.startReplaceGroup(1561618698);
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
    public static final Unit ModernSearchField$lambda$0$0$0(RowScope $this_Row, String $value, String $placeholder, Function2 innerTextField, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        ComposerKt.sourceInformation($composer, "CN(innerTextField)340@11407L425:StatsPanel.kt#pigpjk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changedInstance(innerTextField) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-88284939, $dirty, -1, "kntr.app.ad.ui.inspector.ui.components.ModernSearchField.<anonymous>.<anonymous>.<anonymous> (StatsPanel.kt:340)");
            }
            Modifier modifier$iv = RowScope.-CC.weight$default($this_Row, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1098399565, "C348@11794L16:StatsPanel.kt#pigpjk");
            if ($value.length() == 0) {
                $composer.startReplaceGroup(-1098352632);
                ComposerKt.sourceInformation($composer, "344@11632L10,342@11520L223");
                TextKt.Text-Nvy7gAk($placeholder, (Modifier) null, ColorKt.Color(4288455599L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), $composer, 384, 0, 131066);
            } else {
                $composer.startReplaceGroup(-1109788377);
            }
            $composer.endReplaceGroup();
            innerTextField.invoke($composer, Integer.valueOf($dirty & 14));
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
    public static final Unit ModernSearchField$lambda$0$0$1$0(Function1 $onValueChange) {
        $onValueChange.invoke(RoomRecommendViewModel.EMPTY_CURSOR);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernSearchField$lambda$0$0$2(long $themeColor, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C359@12127L244:StatsPanel.kt#pigpjk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1841898993, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.ModernSearchField.<anonymous>.<anonymous>.<anonymous> (StatsPanel.kt:359)");
            }
            IconKt.Icon-ww6aTOc(AppIcons.INSTANCE.getClose(), "清除", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), $themeColor, $composer, 438, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}