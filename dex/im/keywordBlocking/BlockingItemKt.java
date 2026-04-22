package im.keywordBlocking;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.base.loading.LoadingPainterKt;
import java.util.List;
import kntr.common.trio.list.DefaultListModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlockingItem.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t\u001a#\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0001¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"BlockingItemList", "", "list", "", "Lim/keywordBlocking/KBListItem;", "onClick", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BlockingItem", "item", "Lkotlin/Function0;", "(Lim/keywordBlocking/KBListItem;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "toDp", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/unit/IntSize;", "density", "Landroidx/compose/ui/unit/Density;", "toDp-viCIZxY", "(JLandroidx/compose/ui/unit/Density;)J", "keyword-blocking-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BlockingItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItem$lambda$1(KBListItem kBListItem, Function0 function0, int i2, Composer composer, int i3) {
        BlockingItem(kBListItem, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemList$lambda$1(List list, Function1 function1, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        BlockingItemList(list, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final void BlockingItemList(final List<KBListItem> list, final Function1<? super KBListItem, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(function1, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-861261486);
        ComposerKt.sourceInformation($composer2, "C(BlockingItemList)N(list,onClick,modifier)40@1512L21,44@1604L45,49@1865L125,41@1538L452:BlockingItem.kt#sbjqfg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i3 = i2 & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-861261486, $dirty, -1, "im.keywordBlocking.BlockingItemList (BlockingItem.kt:39)");
            }
            ScrollableState rememberScrollState = ScrollKt.rememberScrollState(0, $composer2, 0, 1);
            FlowLayoutKt.FlowRow(PaddingKt.padding-VpY3zN4$default(ScrollKt.verticalScroll$default(DefaultListModifierKt.defaultVerticalScrollableEffects(modifier4, rememberScrollState, $composer2, ($dirty >> 6) & 14), rememberScrollState, false, (FlingBehavior) null, false, 14, (Object) null), Dp.constructor-impl(12), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-552339273, true, new Function3() { // from class: im.keywordBlocking.BlockingItemKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit BlockingItemList$lambda$0;
                    BlockingItemList$lambda$0 = BlockingItemKt.BlockingItemList$lambda$0(list, function1, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return BlockingItemList$lambda$0;
                }
            }, $composer2, 54), $composer2, 1573296, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: im.keywordBlocking.BlockingItemKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit BlockingItemList$lambda$1;
                    BlockingItemList$lambda$1 = BlockingItemKt.BlockingItemList$lambda$1(list, function1, modifier5, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return BlockingItemList$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemList$lambda$0(List $list, final Function1 $onClick, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation($composer, "C*51@1929L45,51@1910L64:BlockingItem.kt#sbjqfg");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-552339273, $changed, -1, "im.keywordBlocking.BlockingItemList.<anonymous> (BlockingItem.kt:50)");
            }
            List $this$forEach$iv = $list;
            for (Object element$iv : $this$forEach$iv) {
                final KBListItem item = (KBListItem) element$iv;
                ComposerKt.sourceInformationMarkerStart($composer, -1721726485, "CC(remember):BlockingItem.kt#9igjgp");
                boolean invalid$iv = $composer.changed($onClick) | $composer.changedInstance(item);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: im.keywordBlocking.BlockingItemKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit BlockingItemList$lambda$0$0$0$0;
                            BlockingItemList$lambda$0$0$0$0 = BlockingItemKt.BlockingItemList$lambda$0$0$0$0($onClick, item);
                            return BlockingItemList$lambda$0$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                BlockingItem(item, (Function0) it$iv, $composer, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemList$lambda$0$0$0$0(Function1 $onClick, KBListItem $item) {
        $onClick.invoke($item);
        return Unit.INSTANCE;
    }

    public static final void BlockingItem(final KBListItem item, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer2 = $composer.startRestartGroup(1295656784);
        ComposerKt.sourceInformation($composer2, "C(BlockingItem)N(item,onClick)63@2107L22,64@2148L29,65@2204L9,65@2241L6,73@2482L7,77@2586L6,74@2495L651:BlockingItem.kt#sbjqfg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1295656784, $dirty, -1, "im.keywordBlocking.BlockingItem (BlockingItem.kt:62)");
            }
            TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer2, 0, 1);
            State clicked = SnapshotStateKt.rememberUpdatedState(function0, $composer2, ($dirty >> 3) & 14);
            TextStyle style = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
            TextLayoutResult textLayout = TextMeasurer.measure-wNUYSr0$default(textMeasurer, item.getKeyword(), style, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 1000, (Object) null);
            long j = textLayout.getSize-YbymL2g();
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            long size = m3173toDpviCIZxY(j, (Density) consume);
            Modifier modifier$iv = SizeKt.size-6HolHcs(PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) clicked.getValue(), 15, (Object) null), Dp.constructor-impl(14), Dp.constructor-impl(8)), size);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            RowScope $this$BlockingItem_u24lambda_u240 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer2, -2118180121, "C84@2900L113:BlockingItem.kt#sbjqfg");
            TextKt.Text-Nvy7gAk(item.getKeyword(), RowScope.-CC.weight$default($this$BlockingItem_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, style, $composer2, 0, 24960, 110588);
            if (item.isLoading()) {
                $composer2.startReplaceGroup(-2118042699);
                ComposerKt.sourceInformation($composer2, "87@3057L73");
                LoadingPainterKt.TinyLoadingAnimation(PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), Dp.constructor-impl(1)), $composer2, 6, 0);
            } else {
                $composer2.startReplaceGroup(-2121065354);
            }
            $composer2.endReplaceGroup();
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.keywordBlocking.BlockingItemKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit BlockingItem$lambda$1;
                    BlockingItem$lambda$1 = BlockingItemKt.BlockingItem$lambda$1(KBListItem.this, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return BlockingItem$lambda$1;
                }
            });
        }
    }

    /* renamed from: toDp-viCIZxY  reason: not valid java name */
    private static final long m3173toDpviCIZxY(long j, Density density) {
        return DpKt.DpSize-YgX7TsA(density.toDp-u2uoSUM((int) (j >> 32)), density.toDp-u2uoSUM((int) (4294967295L & j)));
    }
}