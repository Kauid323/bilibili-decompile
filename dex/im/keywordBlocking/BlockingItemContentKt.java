package im.keywordBlocking;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.im.Res;
import bili.resource.im.String1_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: BlockingItemContent.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t\u001a\u0015\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\f\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"BlockingItemContent", "", "page", "Lim/keywordBlocking/KBPageData;", "onAction", "Lkotlin/Function1;", "Lim/keywordBlocking/KBAction;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lim/keywordBlocking/KBPageData;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BlockingItemHeader", "(Lim/keywordBlocking/KBPageData;Landroidx/compose/runtime/Composer;I)V", "BlockingAddButton", "onClick", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "keyword-blocking-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BlockingItemContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingAddButton$lambda$1(Function0 function0, int i2, Composer composer, int i3) {
        BlockingAddButton(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemContent$lambda$1(KBPageData kBPageData, Function1 function1, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        BlockingItemContent(kBPageData, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemHeader$lambda$2(KBPageData kBPageData, int i2, Composer composer, int i3) {
        BlockingItemHeader(kBPageData, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0201, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BlockingItemContent(final KBPageData page, final Function1<? super KBAction, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer2 = $composer.startRestartGroup(-1926238688);
        ComposerKt.sourceInformation($composer2, "C(BlockingItemContent)N(page,onAction,modifier)43@1610L14,43@1625L17,44@1647L571:BlockingItemContent.kt#sbjqfg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(page) ? 4 : 2;
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
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1926238688, $dirty2, -1, "im.keywordBlocking.BlockingItemContent (BlockingItemContent.kt:42)");
            }
            PaddingValues padding = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer2, 6), $composer2, 0);
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(modifier4, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(RangesKt.coerceAtLeast(padding.calculateBottomPadding-D9Ej5fM(), Dp.constructor-impl(16))), 7, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ColumnScope $this$BlockingItemContent_u24lambda_u240 = columnScope;
            ComposerKt.sourceInformationMarkerStart($composer2, 1498438957, "C51@1892L24,54@1989L35,52@1925L169:BlockingItemContent.kt#sbjqfg");
            BlockingItemHeader(page, $composer2, $dirty2 & 14);
            List<KBListItem> items = page.getItems();
            ComposerKt.sourceInformationMarkerStart($composer2, 1710907545, "CC(remember):BlockingItemContent.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: im.keywordBlocking.BlockingItemContentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit BlockingItemContent$lambda$0$0$0;
                    BlockingItemContent$lambda$0$0$0 = BlockingItemContentKt.BlockingItemContent$lambda$0$0$0(function1, (KBListItem) obj);
                    return BlockingItemContent$lambda$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BlockingItemKt.BlockingItemList(items, (Function1) it$iv, ColumnScope.-CC.weight$default($this$BlockingItemContent_u24lambda_u240, SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), 1.0f, false, 2, (Object) null), $composer2, 0, 0);
            if (page.getDisplayAddButton()) {
                $composer2.startReplaceGroup(1498667674);
                ComposerKt.sourceInformation($composer2, "58@2172L29,58@2144L58");
                ComposerKt.sourceInformationMarkerStart($composer2, 1710913395, "CC(remember):BlockingItemContent.kt#9igjgp");
                boolean invalid$iv2 = ($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32;
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: im.keywordBlocking.BlockingItemContentKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit BlockingItemContent$lambda$0$1$0;
                            BlockingItemContent$lambda$0$1$0 = BlockingItemContentKt.BlockingItemContent$lambda$0$1$0(function1);
                            return BlockingItemContent$lambda$0$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                BlockingAddButton((Function0) it$iv2, $composer2, 0);
            } else {
                $composer2.startReplaceGroup(1496551180);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: im.keywordBlocking.BlockingItemContentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit BlockingItemContent$lambda$1;
                    BlockingItemContent$lambda$1 = BlockingItemContentKt.BlockingItemContent$lambda$1(KBPageData.this, function1, modifier5, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return BlockingItemContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemContent$lambda$0$0$0(Function1 $onAction, KBListItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onAction.invoke(new KBActionClickItem(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlockingItemContent$lambda$0$1$0(Function1 $onAction) {
        $onAction.invoke(KBActionAddItem.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void BlockingItemHeader(final KBPageData page, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(page, "page");
        Composer $composer2 = $composer.startRestartGroup(246975604);
        ComposerKt.sourceInformation($composer2, "C(BlockingItemHeader)N(page):BlockingItemContent.kt#sbjqfg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(page) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(246975604, $dirty, -1, "im.keywordBlocking.BlockingItemHeader (BlockingItemContent.kt:64)");
            }
            if (page.getDisplayLimitsHint()) {
                $composer2.startReplaceGroup(371352287);
                ComposerKt.sourceInformation($composer2, "70@2467L6,66@2328L879");
                Modifier modifier$iv$iv = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getPay_yellow_thin-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(10));
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv3;
                    $composer2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv3;
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
                ComposerKt.sourceInformationMarkerStart($composer2, -1782087162, "C76@2752L30,78@2866L6,75@2707L235,83@3035L9,84@3084L6,81@2955L242:BlockingItemContent.kt#sbjqfg");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getWarning_report_circle_fill_500($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_notice-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
                TextKt.Text-Nvy7gAk(page.getLimitsHint(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_notice-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 0, 24960, 110586);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(372234578);
                ComposerKt.sourceInformation($composer2, "90@3229L812");
                Modifier modifier$iv$iv2 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(12), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(12), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 13, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(16));
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                int $changed$iv$iv2 = (438 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv4;
                    $composer2.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv4;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i5 = ((438 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                RowScope $this$BlockingItemHeader_u24lambda_u241 = rowScope2;
                ComposerKt.sourceInformationMarkerStart($composer2, -1436322816, "C96@3509L49,98@3642L9,99@3691L6,95@3480L318,105@3841L78,106@3955L9,107@4004L6,104@3812L219:BlockingItemContent.kt#sbjqfg");
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_868(Res.string.INSTANCE), $composer2, 0), RowScope.-CC.weight$default($this$BlockingItemHeader_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 0, 24960, 110584);
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_861(Res.string.INSTANCE), new Object[]{Integer.valueOf(page.getItems().size()), Integer.valueOf(page.getLimit())}, $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.keywordBlocking.BlockingItemContentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit BlockingItemHeader$lambda$2;
                    BlockingItemHeader$lambda$2 = BlockingItemContentKt.BlockingItemHeader$lambda$2(KBPageData.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return BlockingItemHeader$lambda$2;
                }
            });
        }
    }

    public static final void BlockingAddButton(final Function0<Unit> function0, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer2 = $composer.startRestartGroup(1485661759);
        ComposerKt.sourceInformation($composer2, "C(BlockingAddButton)N(onClick)120@4291L6,115@4121L1071:BlockingItemContent.kt#sbjqfg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1485661759, $dirty2, -1, "im.keywordBlocking.BlockingAddButton (BlockingItemContent.kt:114)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(BackgroundKt.background-bw27NRU(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl((float) 47.5d), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(11), 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(3), Alignment.Companion.getCenterHorizontally());
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1521805484, "C131@4695L17,132@4743L6,130@4654L201,138@4890L49,139@4971L9,140@5016L6,137@4865L321:BlockingItemContent.kt#sbjqfg");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getPlus_add_line_500($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
            String stringResource = StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_867(Res.string.INSTANCE), $composer2, 0);
            TextStyle t16 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16();
            TextKt.Text-Nvy7gAk(stringResource, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), TextUnitKt.getSp(22), TextOverflow.Companion.getClip-gIe3tQ8(), false, 1, 0, (Function1) null, t16, $composer2, 0, 25008, 107514);
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
            endRestartGroup.updateScope(new Function2() { // from class: im.keywordBlocking.BlockingItemContentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit BlockingAddButton$lambda$1;
                    BlockingAddButton$lambda$1 = BlockingItemContentKt.BlockingAddButton$lambda$1(function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return BlockingAddButton$lambda$1;
                }
            });
        }
    }
}