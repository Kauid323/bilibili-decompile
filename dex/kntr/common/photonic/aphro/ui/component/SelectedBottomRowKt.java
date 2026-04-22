package kntr.common.photonic.aphro.ui.component;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectedBottomRow.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001aU\u0010\r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"SelectedBottom", "", "state", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;", "hasBorder", "", "hasSelectBorder", "onAction", "Lkotlin/Function1;", "Lkntr/common/photonic/aphro/core/AphroAction;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/photonic/aphro/core/AphroState$AphroContent;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectedMediaItem", "data", "Lkntr/common/photonic/Asset;", "onCancelClick", "Lkotlin/Function0;", "onImageClick", "isSelected", "(ZZLkntr/common/photonic/Asset;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SelectedBottomRowKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedBottom$lambda$1(AphroState.AphroContent aphroContent, boolean z, boolean z2, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SelectedBottom(aphroContent, z, z2, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedMediaItem$lambda$1(boolean z, boolean z2, Asset asset, Function0 function0, Function0 function02, Modifier modifier, boolean z3, int i, int i2, Composer composer, int i3) {
        SelectedMediaItem(z, z2, asset, function0, function02, modifier, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SelectedBottom(final AphroState.AphroContent state, final boolean hasBorder, final boolean hasSelectBorder, final Function1<? super AphroAction, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer2 = $composer.startRestartGroup(1231215672);
        ComposerKt.sourceInformation($composer2, "C(SelectedBottom)N(state,hasBorder,hasSelectBorder,onAction,modifier)50@1906L1347:SelectedBottomRow.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(hasBorder) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(hasSelectBorder) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1231215672, $dirty2, -1, "kntr.common.photonic.aphro.ui.component.SelectedBottom (SelectedBottomRow.kt:49)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
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
            int $changed2 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$SelectedBottom_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1531995469, "C55@2175L913,51@1959L1129,83@3098L149:SelectedBottomRow.kt#gh748z");
            AnimatedVisibilityKt.AnimatedVisibility($this$SelectedBottom_u24lambda_u240, !state.getCurrentSelected().isEmpty() && state.getOption().getShowSelections(), (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), ExitTransition.Companion.getNone(), (String) null, ComposableLambdaKt.rememberComposableLambda(1355160454, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.component.SelectedBottomRowKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SelectedBottom$lambda$0$0;
                    SelectedBottom$lambda$0$0 = SelectedBottomRowKt.SelectedBottom$lambda$0$0(hasBorder, state, function1, hasSelectBorder, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SelectedBottom$lambda$0$0;
                }
            }, $composer2, 54), $composer2, ($changed2 & 14) | 1575936, 18);
            OriginalImageBarKt.OriginalImageBar(function1, state, SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), 0.0f, 1, (Object) null), $composer2, (($dirty2 >> 9) & 14) | 384 | (($dirty2 << 3) & 112), 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.component.SelectedBottomRowKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectedBottom$lambda$1;
                    SelectedBottom$lambda$1 = SelectedBottomRowKt.SelectedBottom$lambda$1(AphroState.AphroContent.this, hasBorder, hasSelectBorder, function1, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectedBottom$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedBottom$lambda$0$0(boolean $hasBorder, AphroState.AphroContent $state, Function1 $onAction, boolean $hasSelectBorder, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C56@2189L889:SelectedBottomRow.kt#gh748z");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1355160454, $changed, -1, "kntr.common.photonic.aphro.ui.component.SelectedBottom.<anonymous>.<anonymous> (SelectedBottomRow.kt:56)");
        }
        Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(76));
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        int i2 = ((6 >> 6) & 112) | 6;
        BoxScope $this$SelectedBottom_u24lambda_u240_u240_u240 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, 2141109689, "C73@2773L291:SelectedBottomRow.kt#gh748z");
        if ($hasBorder) {
            $composer.startReplaceGroup(2141114524);
            ComposerKt.sourceInformation($composer, "69@2694L6,63@2399L338");
            BoxKt.Box(BackgroundKt.background-bw27NRU$default($this$SelectedBottom_u24lambda_u240_u240_u240.align(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) 0.5d)), 0.0f, 1, (Object) null), Alignment.Companion.getTopCenter()), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
        } else {
            $composer.startReplaceGroup(2138743830);
        }
        $composer.endReplaceGroup();
        SelectedListKt.SelectedList($state, $onAction, $this$SelectedBottom_u24lambda_u240_u240_u240.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()), $hasBorder, $hasSelectBorder, null, $composer, 0, 32);
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

    public static final void SelectedMediaItem(final boolean hasBorder, final boolean hasSelectBorder, final Asset data, final Function0<Unit> function0, final Function0<Unit> function02, Modifier modifier, boolean isSelected, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        int $dirty;
        Modifier modifier3;
        boolean isSelected2;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(function0, "onCancelClick");
        Intrinsics.checkNotNullParameter(function02, "onImageClick");
        Composer $composer2 = $composer.startRestartGroup(1843884838);
        ComposerKt.sourceInformation($composer2, "C(SelectedMediaItem)N(hasBorder,hasSelectBorder,data,onCancelClick,onImageClick,modifier,isSelected)101@3545L35,102@3608L34,103@3688L1961,103@3653L1996:SelectedBottomRow.kt#gh748z");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(hasBorder) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(hasSelectBorder) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(data) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changedInstance(function02) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty2 |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty2 |= 1572864;
            z = isSelected;
        } else if ((1572864 & $changed) == 0) {
            z = isSelected;
            $dirty2 |= $composer2.changed(z) ? 1048576 : 524288;
        } else {
            z = isSelected;
        }
        int $dirty3 = $dirty2;
        if (!$composer2.shouldExecute((599187 & $dirty3) != 599186, $dirty3 & 1)) {
            $dirty = $dirty3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            isSelected2 = z;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                isSelected2 = z;
            } else {
                isSelected2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1843884838, $dirty3, -1, "kntr.common.photonic.aphro.ui.component.SelectedMediaItem (SelectedBottomRow.kt:100)");
            }
            final Function0 cancelClick = (Function0) SnapshotStateKt.rememberUpdatedState(function0, $composer2, ($dirty3 >> 9) & 14).getValue();
            final Function0 imageClick = (Function0) SnapshotStateKt.rememberUpdatedState(function02, $composer2, ($dirty3 >> 12) & 14).getValue();
            final boolean z2 = isSelected2;
            final Modifier modifier4 = modifier3;
            $dirty = $dirty3;
            BiliThemeKt.BiliTheme(ThemeStrategy.FollowApp, false, ComposableLambdaKt.rememberComposableLambda(1718280926, true, new Function2() { // from class: kntr.common.photonic.aphro.ui.component.SelectedBottomRowKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectedMediaItem$lambda$0;
                    SelectedMediaItem$lambda$0 = SelectedBottomRowKt.SelectedMediaItem$lambda$0(z2, modifier4, imageClick, hasBorder, hasSelectBorder, data, cancelClick, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectedMediaItem$lambda$0;
                }
            }, $composer2, 54), $composer2, 390, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z3 = isSelected2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.component.SelectedBottomRowKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectedMediaItem$lambda$1;
                    SelectedMediaItem$lambda$1 = SelectedBottomRowKt.SelectedMediaItem$lambda$1(hasBorder, hasSelectBorder, data, function0, function02, modifier5, z3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectedMediaItem$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedMediaItem$lambda$0(boolean $isSelected, Modifier $modifier, final Function0 $imageClick, final boolean $hasBorder, final boolean $hasSelectBorder, final Asset $data, final Function0 $cancelClick, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C104@3726L6,110@3985L60,113@4057L1586,105@3793L1850:SelectedBottomRow.kt#gh748z");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1718280926, $changed, -1, "kntr.common.photonic.aphro.ui.component.SelectedMediaItem.<anonymous> (SelectedBottomRow.kt:104)");
            }
            final long borderColor = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $isSelected ? 1.0f : 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            Modifier clip = ClipKt.clip(SizeKt.size-3ABfNKs($modifier, Dp.constructor-impl(56)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(5)));
            ComposerKt.sourceInformationMarkerStart($composer, 2000537786, "CC(remember):SelectedBottomRow.kt#9igjgp");
            boolean invalid$iv = $composer.changed($imageClick);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.component.SelectedBottomRowKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit SelectedMediaItem$lambda$0$0$0;
                        SelectedMediaItem$lambda$0$0$0 = SelectedBottomRowKt.SelectedMediaItem$lambda$0$0$0($imageClick);
                        return SelectedMediaItem$lambda$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BoxWithConstraintsKt.BoxWithConstraints(ClickableKt.clickable-oSLSa3U$default(clip, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(1482045256, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.component.SelectedBottomRowKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SelectedMediaItem$lambda$0$1;
                    SelectedMediaItem$lambda$0$1 = SelectedBottomRowKt.SelectedMediaItem$lambda$0$1($hasBorder, $hasSelectBorder, $data, $cancelClick, borderColor, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SelectedMediaItem$lambda$0$1;
                }
            }, $composer, 54), $composer, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedMediaItem$lambda$0$0$0(Function0 $imageClick) {
        $imageClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedMediaItem$lambda$0$1(boolean $hasBorder, boolean $hasSelectBorder, Asset $data, final Function0 $cancelClick, long $borderColor, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C114@4071L763,134@4848L100,139@5006L20,143@5192L69,138@4961L672:SelectedBottomRow.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1482045256, $dirty2, -1, "kntr.common.photonic.aphro.ui.component.SelectedMediaItem.<anonymous>.<anonymous> (SelectedBottomRow.kt:114)");
            }
            Modifier $this$ifMatch$iv = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, 2.0f), 0.0f, 1, (Object) null);
            if ($hasBorder) {
                $this$ifMatch$iv = BorderKt.border-xT4_qwU($this$ifMatch$iv, Dp.constructor-impl(1), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.04f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(5)));
            }
            if ($hasSelectBorder) {
                Modifier it = $this$ifMatch$iv;
                $this$ifMatch$iv = BorderKt.border-xT4_qwU(it, Dp.constructor-impl(2), $borderColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(5)));
            }
            BoxKt.Box($this$ifMatch$iv, $composer, 0);
            MediaItemKt.Thumb($data, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 48, 0);
            Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer, 6);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, -1683614867, "CC(remember):SelectedBottomRow.kt#9igjgp");
            boolean invalid$iv = $composer.changed($cancelClick);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.component.SelectedBottomRowKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit SelectedMediaItem$lambda$0$1$2$0;
                        SelectedMediaItem$lambda$0$1$2$0 = SelectedBottomRowKt.SelectedMediaItem$lambda$0$1$2$0($cancelClick);
                        return SelectedMediaItem$lambda$0$1$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconKt.Icon-ww6aTOc(xmark_close_line_500, (String) null, ZIndexModifierKt.zIndex($this$BoxWithConstraints.align(PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(2)), Dp.constructor-impl(16)), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(2)), Alignment.Companion.getTopEnd()), 1.0f), Color.Companion.getWhite-0d7_KjU(), $composer, Painter.$stable | 3120, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedMediaItem$lambda$0$1$2$0(Function0 $cancelClick) {
        $cancelClick.invoke();
        return Unit.INSTANCE;
    }
}