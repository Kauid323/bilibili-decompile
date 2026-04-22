package kntr.common.photonic.aphro.ui.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.ui.component.OriginalImageBarKt;
import kntr.common.photonic.aphro.ui.component.SelectedBottomRowKt;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: GalleryPreviewFooter.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0081\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015\u001aG\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0003¢\u0006\u0002\u0010\u0017\u001a[\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u0019¨\u0006\u001a²\u0006\n\u0010\u001b\u001a\u00020\u0011X\u008a\u008e\u0002"}, d2 = {"GalleryPreviewFooter", "", "state", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;", "imagePreviewState", "Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;", "hasBorder", "", "hasSelectBorder", "onAction", "Lkotlin/Function1;", "Lkntr/common/photonic/aphro/core/AphroAction;", "onConfirmSelection", "Lkotlin/Function0;", "onOriginImageClickedWithNoSelect", "onSelectedItemClick", "Lkotlin/Function2;", "", "Lkntr/common/photonic/Asset;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/photonic/aphro/core/AphroState$AphroContent;Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BottomActionBar", "(Lkntr/common/photonic/aphro/core/AphroState$AphroContent;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SelectedMediaList", "(Lkntr/common/photonic/aphro/core/AphroState$AphroContent;Lkotlin/jvm/functions/Function1;Lkntr/common/photonic/aphro/ui/preview/state/ImagePreviewState;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/runtime/Composer;I)V", "ui_debug", "currentSelectedIndex"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GalleryPreviewFooterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomActionBar$lambda$2(AphroState.AphroContent aphroContent, Function1 function1, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        BottomActionBar(aphroContent, function1, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GalleryPreviewFooter$lambda$1(AphroState.AphroContent aphroContent, ImagePreviewState imagePreviewState, boolean z, boolean z2, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        GalleryPreviewFooter(aphroContent, imagePreviewState, z, z2, function1, function0, function02, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedMediaList$lambda$5(AphroState.AphroContent aphroContent, Function1 function1, ImagePreviewState imagePreviewState, Function2 function2, boolean z, boolean z2, int i, Composer composer, int i2) {
        SelectedMediaList(aphroContent, function1, imagePreviewState, function2, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void GalleryPreviewFooter(final AphroState.AphroContent state, final ImagePreviewState imagePreviewState, final boolean hasBorder, final boolean hasSelectBorder, final Function1<? super AphroAction, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, final Function2<? super Integer, ? super Asset, Unit> function2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(imagePreviewState, "imagePreviewState");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Intrinsics.checkNotNullParameter(function0, "onConfirmSelection");
        Intrinsics.checkNotNullParameter(function02, "onOriginImageClickedWithNoSelect");
        Intrinsics.checkNotNullParameter(function2, "onSelectedItemClick");
        Composer $composer2 = $composer.startRestartGroup(727897427);
        ComposerKt.sourceInformation($composer2, "C(GalleryPreviewFooter)N(state,imagePreviewState,hasBorder,hasSelectBorder,onAction,onConfirmSelection,onOriginImageClickedWithNoSelect,onSelectedItemClick,modifier)58@2511L1092:GalleryPreviewFooter.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(imagePreviewState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(hasBorder) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(hasSelectBorder) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        int i2 = i & 256;
        if (i2 != 0) {
            $dirty |= 100663296;
        } else if ((100663296 & $changed) == 0) {
            $dirty |= $composer2.changed(modifier) ? 67108864 : 33554432;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute((38347923 & $dirty2) != 38347922, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(727897427, $dirty2, -1, "kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooter (GalleryPreviewFooter.kt:57)");
            }
            Modifier modifier4 = modifier3;
            Modifier modifier$iv = WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
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
            ColumnScope $this$GalleryPreviewFooter_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 2096628064, "C72@2943L382,70@2855L470,89@3377L220:GalleryPreviewFooter.kt#n54g3c");
            modifier2 = modifier4;
            AnimatedVisibilityKt.AnimatedVisibility($this$GalleryPreviewFooter_u24lambda_u240, !state.getCurrentSelected().isEmpty(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(227669573, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit GalleryPreviewFooter$lambda$0$0;
                    GalleryPreviewFooter$lambda$0$0 = GalleryPreviewFooterKt.GalleryPreviewFooter$lambda$0$0(AphroState.AphroContent.this, function1, imagePreviewState, function2, hasBorder, hasSelectBorder, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return GalleryPreviewFooter$lambda$0$0;
                }
            }, $composer2, 54), $composer2, ((((0 >> 6) & 112) | 6) & 14) | 1572864, 30);
            BottomActionBar(state, function1, function0, function02, $composer2, ($dirty2 & 14) | (($dirty2 >> 9) & 112) | (($dirty2 >> 9) & 896) | (($dirty2 >> 9) & 7168), 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit GalleryPreviewFooter$lambda$1;
                    GalleryPreviewFooter$lambda$1 = GalleryPreviewFooterKt.GalleryPreviewFooter$lambda$1(AphroState.AphroContent.this, imagePreviewState, hasBorder, hasSelectBorder, function1, function0, function02, function2, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GalleryPreviewFooter$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GalleryPreviewFooter$lambda$0$0(AphroState.AphroContent $state, Function1 $onAction, ImagePreviewState $imagePreviewState, Function2 $onSelectedItemClick, boolean $hasBorder, boolean $hasSelectBorder, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C76@3011L304:GalleryPreviewFooter.kt#n54g3c");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(227669573, $changed, -1, "kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooter.<anonymous>.<anonymous> (GalleryPreviewFooter.kt:76)");
        }
        SelectedMediaList($state, $onAction, $imagePreviewState, $onSelectedItemClick, $hasBorder, $hasSelectBorder, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x020e, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v23 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void BottomActionBar(final AphroState.AphroContent state, final Function1<? super AphroAction, Unit> function1, final Function0<Unit> function0, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
        final Function0 onOriginImageClickedWithNoSelect;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Composer $composer2 = $composer.startRestartGroup(1749889803);
        ComposerKt.sourceInformation($composer2, "C(BottomActionBar)N(state,onAction,onConfirmSelection,onOriginImageClickedWithNoSelect)103@3808L2,105@3820L1894:GalleryPreviewFooter.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            onOriginImageClickedWithNoSelect = function02;
        } else if (($changed & 3072) == 0) {
            onOriginImageClickedWithNoSelect = function02;
            $dirty |= $composer2.changedInstance(onOriginImageClickedWithNoSelect) ? 2048 : 1024;
        } else {
            onOriginImageClickedWithNoSelect = function02;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1983073555, "CC(remember):GalleryPreviewFooter.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onOriginImageClickedWithNoSelect2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onOriginImageClickedWithNoSelect = onOriginImageClickedWithNoSelect2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1749889803, $dirty2, -1, "kntr.common.photonic.aphro.ui.preview.BottomActionBar (GalleryPreviewFooter.kt:104)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((6 >> 6) & 112) | 6;
            BoxScope $this$BottomActionBar_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1489890067, "C114@4100L264,108@3899L476,130@4725L6,132@4835L68,122@4385L1323:GalleryPreviewFooter.kt#n54g3c");
            Modifier align = $this$BottomActionBar_u24lambda_u241.align(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenter());
            ComposerKt.sourceInformationMarkerStart($composer2, -48056083, "CC(remember):GalleryPreviewFooter.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 112) == 32) | (($dirty2 & 14) == 4) | (($dirty2 & 7168) == 2048);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit BottomActionBar$lambda$1$0$0;
                    BottomActionBar$lambda$1$0$0 = GalleryPreviewFooterKt.BottomActionBar$lambda$1$0$0(function1, state, onOriginImageClickedWithNoSelect);
                    return BottomActionBar$lambda$1$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            OriginalImageBarKt.OriginImage(state, ClickableKt.clickable-oSLSa3U$default(align, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), null, $composer2, $dirty2 & 14, 4);
            Modifier modifier = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.defaultMinSize-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(AlphaKt.alpha(Modifier.Companion, !state.getCurrentSelected().isEmpty() ? 1.0f : 0.4f), 0.0f, 0.0f, Dp.constructor-impl(12), 0.0f, 11, (Object) null), Dp.constructor-impl(66), 0.0f, 2, (Object) null), Dp.constructor-impl(30)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15)));
            ComposerKt.sourceInformationMarkerStart($composer2, -48032759, "CC(remember):GalleryPreviewFooter.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 896) == 256;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit BottomActionBar$lambda$1$1$0;
                        BottomActionBar$lambda$1$1$0 = GalleryPreviewFooterKt.BottomActionBar$lambda$1$1$0(function0);
                        return BottomActionBar$lambda$1$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv2 = $this$BottomActionBar_u24lambda_u241.align(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), Alignment.Companion.getCenterEnd());
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 396765391, "C150@5555L6,137@5005L693:GalleryPreviewFooter.kt#n54g3c");
            if (!state.getCurrentSelected().isEmpty()) {
                $composer2.startReplaceGroup(396838705);
                ComposerKt.sourceInformation($composer2, "140@5120L162");
                String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_436(Res.string.INSTANCE), new Object[]{Integer.valueOf(state.getCurrentSelected().size())}, $composer2, 0);
                $composer2.endReplaceGroup();
                str = stringResource;
            } else {
                $composer2.startReplaceGroup(397049536);
                ComposerKt.sourceInformation($composer2, "145@5336L51");
                String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_202(Res.string.INSTANCE), $composer2, 0);
                $composer2.endReplaceGroup();
                str = stringResource2;
            }
            TextKt.Text-Nvy7gAk(str, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_white-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 1, 0, (Function1) null, (TextStyle) null, $composer2, 24624, 24576, 244712);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            final Function0 function03 = onOriginImageClickedWithNoSelect;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomActionBar$lambda$2;
                    BottomActionBar$lambda$2 = GalleryPreviewFooterKt.BottomActionBar$lambda$2(AphroState.AphroContent.this, function1, function0, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomActionBar$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomActionBar$lambda$1$0$0(Function1 $onAction, AphroState.AphroContent $state, Function0 $onOriginImageClickedWithNoSelect) {
        $onAction.invoke(new AphroAction.CheckUseOriginImage(!$state.getUseOriginImage()));
        if ($state.getCurrentSelected().isEmpty()) {
            $onOriginImageClickedWithNoSelect.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomActionBar$lambda$1$1$0(Function0 $onConfirmSelection) {
        $onConfirmSelection.invoke();
        return Unit.INSTANCE;
    }

    private static final void SelectedMediaList(final AphroState.AphroContent state, final Function1<? super AphroAction, Unit> function1, final ImagePreviewState imagePreviewState, final Function2<? super Integer, ? super Asset, Unit> function2, final boolean hasBorder, final boolean hasSelectBorder, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-400498500);
        ComposerKt.sourceInformation($composer2, "C(SelectedMediaList)N(state,onAction,imagePreviewState,onSelectedItemClick,hasBorder,hasSelectBorder)168@6040L43,172@6127L289,172@6089L327,191@6743L844,180@6422L1165:GalleryPreviewFooter.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(imagePreviewState) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(hasBorder) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changed(hasSelectBorder) ? 131072 : 65536;
        }
        if ($composer2.shouldExecute(($dirty & 74899) != 74898, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-400498500, $dirty, -1, "kntr.common.photonic.aphro.ui.preview.SelectedMediaList (GalleryPreviewFooter.kt:167)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1668007847, "CC(remember):GalleryPreviewFooter.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(-1, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState currentSelectedIndex$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            List<Asset> currentSelected = state.getCurrentSelected();
            ComposerKt.sourceInformationMarkerStart($composer2, 1668010877, "CC(remember):GalleryPreviewFooter.kt#9igjgp");
            boolean invalid$iv = (($dirty & 896) == 256) | (($dirty & 14) == 4);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new GalleryPreviewFooterKt$SelectedMediaList$1$1(imagePreviewState, state, currentSelectedIndex$delegate, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(currentSelected, (Function2) it$iv2, $composer2, 0);
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(76)), 0.0f, Dp.constructor-impl(10), 1, (Object) null);
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer2, 1668031144, "CC(remember):GalleryPreviewFooter.kt#9igjgp");
            boolean invalid$iv2 = (($dirty & 14) == 4) | ((57344 & $dirty) == 16384) | ((458752 & $dirty) == 131072) | (($dirty & 112) == 32) | (($dirty & 7168) == 2048);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = new Function1() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        Unit SelectedMediaList$lambda$4$0;
                        SelectedMediaList$lambda$4$0 = GalleryPreviewFooterKt.SelectedMediaList$lambda$4$0(AphroState.AphroContent.this, hasBorder, hasSelectBorder, function1, function2, currentSelectedIndex$delegate, (LazyListScope) obj);
                        return SelectedMediaList$lambda$4$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyRow(modifier, (LazyListState) null, paddingValues, false, horizontal, (Alignment.Vertical) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv3, $composer2, 24966, 490);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectedMediaList$lambda$5;
                    SelectedMediaList$lambda$5 = GalleryPreviewFooterKt.SelectedMediaList$lambda$5(AphroState.AphroContent.this, function1, imagePreviewState, function2, hasBorder, hasSelectBorder, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectedMediaList$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SelectedMediaList$lambda$1(MutableState<Integer> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Number) $this$getValue$iv.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectedMediaList$lambda$2(MutableState<Integer> mutableState, int i) {
        Object value$iv = Integer.valueOf(i);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedMediaList$lambda$4$0(final AphroState.AphroContent $state, final boolean $hasBorder, final boolean $hasSelectBorder, final Function1 $onAction, final Function2 $onSelectedItemClick, final MutableState $currentSelectedIndex$delegate, LazyListScope $this$LazyRow) {
        Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
        final List items$iv = $state.getCurrentSelected();
        final Function2 key$iv = new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2) {
                Object SelectedMediaList$lambda$4$0$0;
                SelectedMediaList$lambda$4$0$0 = GalleryPreviewFooterKt.SelectedMediaList$lambda$4$0$0(((Integer) obj).intValue(), (Asset) obj2);
                return SelectedMediaList$lambda$4$0$0;
            }
        };
        $this$LazyRow.items(items$iv.size(), new Function1<Integer, Object>() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$SelectedMediaList$lambda$4$0$$inlined$itemsIndexed$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return key$iv.invoke(Integer.valueOf(index), items$iv.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$SelectedMediaList$lambda$4$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                items$iv.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$SelectedMediaList$lambda$4$0$$inlined$itemsIndexed$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, final int it, Composer $composer, int $changed) {
                int SelectedMediaList$lambda$1;
                ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if ($composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                    }
                    int $changed2 = ($dirty & 14) | ($dirty & 112);
                    final Asset item = (Asset) items$iv.get(it);
                    $composer.startReplaceGroup(930246552);
                    ComposerKt.sourceInformation($composer, "CN(index,item)*200@7061L281,207@7375L121,196@6891L680:GalleryPreviewFooter.kt#n54g3c");
                    boolean z = $hasBorder;
                    boolean z2 = $hasSelectBorder;
                    ComposerKt.sourceInformationMarkerStart($composer, 1969675644, "CC(remember):GalleryPreviewFooter.kt#9igjgp");
                    boolean invalid$iv = $composer.changed($onAction) | $composer.changed($state) | $composer.changedInstance(item);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        final AphroState.AphroContent aphroContent = $state;
                        final Function1 function1 = $onAction;
                        final MutableState mutableState = $currentSelectedIndex$delegate;
                        Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$SelectedMediaList$2$1$2$1$1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2287invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2287invoke() {
                                if (AphroState.AphroContent.this.getCurrentSelected().size() == 1) {
                                    function1.invoke(new AphroAction.CheckUseOriginImage(false));
                                }
                                function1.invoke(new AphroAction.UnSelectAsset(item));
                                GalleryPreviewFooterKt.SelectedMediaList$lambda$2(mutableState, -1);
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    Function0 function0 = (Function0) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 1969685532, "CC(remember):GalleryPreviewFooter.kt#9igjgp");
                    boolean invalid$iv2 = (((($changed2 & 112) ^ 48) > 32 && $composer.changed(it)) || ($changed2 & 48) == 32) | $composer.changed($onSelectedItemClick) | $composer.changedInstance(item);
                    Object it$iv2 = $composer.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        final Function2 function2 = $onSelectedItemClick;
                        final MutableState mutableState2 = $currentSelectedIndex$delegate;
                        Object value$iv2 = (Function0) new Function0<Unit>() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewFooterKt$SelectedMediaList$2$1$2$2$1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2288invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2288invoke() {
                                GalleryPreviewFooterKt.SelectedMediaList$lambda$2(mutableState2, it);
                                function2.invoke(Integer.valueOf(it), item);
                            }
                        };
                        $composer.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    Function0 function02 = (Function0) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    SelectedMediaList$lambda$1 = GalleryPreviewFooterKt.SelectedMediaList$lambda$1($currentSelectedIndex$delegate);
                    SelectedBottomRowKt.SelectedMediaItem(z, z2, item, function0, function02, null, SelectedMediaList$lambda$1 == it, $composer, $changed2 & 896, 32);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SelectedMediaList$lambda$4$0$0(int i, Asset item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.getIdentifier();
    }
}