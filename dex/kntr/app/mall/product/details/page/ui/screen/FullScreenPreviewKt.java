package kntr.app.mall.product.details.page.ui.screen;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kntr.app.mall.product.details.page.ui.components.DetailDescComponentKt;
import kntr.app.mall.product.details.page.utils.ScreenKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.Pixel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: FullScreenPreview.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001aY\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f0\u0003H\u0001¢\u0006\u0002\u0010\u000e\u001a\u0017\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"FullScreenImagePreview", "", "imageUrls", "", "", "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "initialIndex", "", "imageSizes", "Lkotlin/Pair;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ILjava/util/List;Landroidx/compose/runtime/Composer;II)V", "BlackPlaceHolder", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FullScreenPreviewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackPlaceHolder$lambda$0(Modifier modifier, int i, int i2, Composer composer, int i3) {
        BlackPlaceHolder(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullScreenImagePreview$lambda$5(List list, Function0 function0, Modifier modifier, int i, List list2, int i2, int i3, Composer composer, int i4) {
        FullScreenImagePreview(list, function0, modifier, i, list2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final void FullScreenImagePreview(final List<String> list, final Function0<Unit> function0, Modifier modifier, int initialIndex, List<Pair<Float, Float>> list2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int initialIndex2;
        final List imageSizes;
        Modifier modifier3;
        int initialIndex3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(list, "imageUrls");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer $composer2 = $composer.startRestartGroup(-2063510111);
        ComposerKt.sourceInformation($composer2, "C(FullScreenImagePreview)N(imageUrls,onDismiss,modifier,initialIndex,imageSizes)32@1327L135,38@1578L18,36@1492L115,40@1630L16,41@1686L7,48@1911L82,42@1722L1827:FullScreenPreview.kt#dsyj5e");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            initialIndex2 = initialIndex;
        } else if (($changed & 3072) == 0) {
            initialIndex2 = initialIndex;
            $dirty |= $composer2.changed(initialIndex2) ? 2048 : 1024;
        } else {
            initialIndex2 = initialIndex;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            imageSizes = list2;
        } else if (($changed & 24576) == 0) {
            imageSizes = list2;
            $dirty |= $composer2.changedInstance(imageSizes) ? 16384 : 8192;
        } else {
            imageSizes = list2;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 != 0) {
                initialIndex2 = 0;
            }
            if (i4 != 0) {
                imageSizes = CollectionsKt.emptyList();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2063510111, $dirty2, -1, "kntr.app.mall.product.details.page.ui.screen.FullScreenImagePreview (FullScreenPreview.kt:30)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1241681864, "CC(remember):FullScreenPreview.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(list) | (($dirty2 & 7168) == 2048);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = Integer.valueOf(list.isEmpty() ? 0 : RangesKt.coerceIn(initialIndex2, 0, CollectionsKt.getLastIndex(list)));
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            int safeStartIndex = ((Number) it$iv).intValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1241689779, "CC(remember):FullScreenPreview.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(list);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenPreviewKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        int size;
                        size = list.size();
                        return Integer.valueOf(size);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int initialIndex4 = initialIndex2;
            PagerState pagerState = PagerStateKt.rememberPagerState(safeStartIndex, 0.0f, (Function0) it$iv2, $composer2, 0, 2);
            float screenWidth = ScreenKt.getScreenWidth($composer2, 0);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$FullScreenImagePreview_u24lambda_u242 = (Density) consume;
            final float widthPixel = $this$FullScreenImagePreview_u24lambda_u242.toPx-0680j_4(screenWidth);
            Modifier modifier4 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1241700499, "CC(remember):FullScreenPreview.kt#9igjgp");
            boolean invalid$iv3 = ($dirty2 & 112) == 32;
            FullScreenPreviewKt$FullScreenImagePreview$1$1 value$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = new FullScreenPreviewKt$FullScreenImagePreview$1$1(function0);
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (PointerInputEventHandler) value$iv3);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            initialIndex3 = initialIndex4;
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -332976051, "C:FullScreenPreview.kt#dsyj5e");
            if (!list.isEmpty()) {
                $composer2.startReplaceGroup(-332951500);
                ComposerKt.sourceInformation($composer2, "57@2216L1241,54@2098L1359");
                PagerKt.HorizontalPager--8jOkeI(pagerState, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (PaddingValues) null, (PageSize) null, 0, 0.0f, (Alignment.Vertical) null, (TargetedFlingBehavior) null, false, false, (Function1) null, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(-763360957, true, new Function4() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenPreviewKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        Unit FullScreenImagePreview$lambda$4$0;
                        FullScreenImagePreview$lambda$4$0 = FullScreenPreviewKt.FullScreenImagePreview$lambda$4$0(imageSizes, list, widthPixel, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        return FullScreenImagePreview$lambda$4$0;
                    }
                }, $composer2, 54), $composer2, 48, 24576, 16380);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-331614315);
                ComposerKt.sourceInformation($composer2, "86@3515L18");
                BlackPlaceHolder(null, $composer2, 0, 1);
                $composer2.endReplaceGroup();
            }
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
            modifier3 = modifier2;
            initialIndex3 = initialIndex2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final int i7 = initialIndex3;
            final List list3 = imageSizes;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenPreviewKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FullScreenImagePreview$lambda$5;
                    FullScreenImagePreview$lambda$5 = FullScreenPreviewKt.FullScreenImagePreview$lambda$5(list, function0, modifier5, i7, list3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FullScreenImagePreview$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullScreenImagePreview$lambda$4$0(List $imageSizes, List $imageUrls, float $widthPixel, PagerScope $this$HorizontalPager, int page, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Float aspectRatio;
        Intrinsics.checkNotNullParameter($this$HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation($composer, "CN(page)58@2260L21,59@2298L1145:FullScreenPreview.kt#dsyj5e");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-763360957, $changed, -1, "kntr.app.mall.product.details.page.ui.screen.FullScreenImagePreview.<anonymous>.<anonymous> (FullScreenPreview.kt:58)");
        }
        ScrollState scrollState = ScrollKt.rememberScrollState(0, $composer, 0, 1);
        Modifier modifier$iv = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), scrollState, false, (FlingBehavior) null, false, 14, (Object) null);
        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
        ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
        int $changed$iv$iv = (384 << 3) & 112;
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
        int i2 = ((384 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -1591720639, "C73@2966L459:FullScreenPreview.kt#dsyj5e");
        Pair imageSize = (Pair) CollectionsKt.getOrNull($imageSizes, page);
        if (imageSize != null && ((Number) imageSize.getFirst()).floatValue() > 0.0f && ((Number) imageSize.getSecond()).floatValue() > 0.0f) {
            aspectRatio = Float.valueOf(((Number) imageSize.getFirst()).floatValue() / ((Number) imageSize.getSecond()).floatValue());
        } else {
            aspectRatio = null;
        }
        DetailDescComponentKt.m463ImageWithDynamicRatioQ4leyOY((String) $imageUrls.get(page), BackgroundKt.background-bw27NRU$default(Modifier.Companion, Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null), 0, null, false, aspectRatio, Pixel.m1516boximpl(Pixel.m1517constructorimpl((int) $widthPixel)), null, ComposableSingletons$FullScreenPreviewKt.INSTANCE.getLambda$1594471539$product_details_page_debug(), ComposableSingletons$FullScreenPreviewKt.INSTANCE.getLambda$1208910525$product_details_page_debug(), $composer, 905994288, 140);
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

    public static final void BlackPlaceHolder(Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-1233165634);
        ComposerKt.sourceInformation($composer2, "C(BlackPlaceHolder)N(modifier)93@3632L123:FullScreenPreview.kt#dsyj5e");
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
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1233165634, $dirty, -1, "kntr.app.mall.product.details.page.ui.screen.BlackPlaceHolder (FullScreenPreview.kt:92)");
            }
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.FullScreenPreviewKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit BlackPlaceHolder$lambda$0;
                    BlackPlaceHolder$lambda$0 = FullScreenPreviewKt.BlackPlaceHolder$lambda$0(modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BlackPlaceHolder$lambda$0;
                }
            });
        }
    }
}