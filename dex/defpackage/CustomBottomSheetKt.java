package defpackage;

import ComposableSingletons;
import ComposableSingletons$CustomBottomSheetKt$;
import CustomBottomSheetKt$CustomBottomSheet$lambda$2$0$0$0$;
import androidx.compose.foundation.BasicMarqueeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.MarqueeSpacing;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CustomBottomSheet.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a+\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"CustomBottomSheet", "", "items", "", "LBottomSheetItemData;", "onDismissRequest", "Lkotlin/Function0;", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "BottomSheetItem", "item", "showArrow", "", "onClick", "(LBottomSheetItemData;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "watch_later_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: CustomBottomSheetKt  reason: default package */
public final class CustomBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetItem$lambda$1(BottomSheetItemData bottomSheetItemData, boolean z, Function0 function0, int i, Composer composer, int i2) {
        BottomSheetItem(bottomSheetItemData, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomBottomSheet$lambda$3(List list, Function0 function0, int i, Composer composer, int i2) {
        CustomBottomSheet(list, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CustomBottomSheet(final List<BottomSheetItemData> list, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        boolean z;
        BottomSheetItemData it;
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Composer $composer3 = $composer.startRestartGroup(377044086);
        ComposerKt.sourceInformation($composer3, "C(CustomBottomSheet)N(items,onDismissRequest)53@2221L82,82@3228L6,58@2436L42,90@3488L804,57@2391L1901:CustomBottomSheet.kt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(377044086, $dirty2, -1, "CustomBottomSheet (CustomBottomSheet.kt:51)");
            }
            SheetState sheetState = ModalBottomSheetKt.rememberModalBottomSheetState(true, (Function1) null, $composer3, 6, 2);
            List<BottomSheetItemData> $this$any$iv = list;
            if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
                Iterator<T> it2 = $this$any$iv.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Object element$iv = it2.next();
                        BottomSheetItemData it3 = (BottomSheetItemData) element$iv;
                        if (it3.getShowArrowRight() || it3.getSummary() != null) {
                            it = 1;
                            continue;
                        } else {
                            it = null;
                            continue;
                        }
                        if (it != null) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            } else {
                z = false;
            }
            final boolean showArrowCondition = z;
            long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU();
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(8), Dp.constructor-impl(8), 0.0f, 0.0f, 12, (Object) null);
            Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null);
            ModalBottomSheetProperties modalBottomSheetProperties = new ModalBottomSheetProperties();
            ComposerKt.sourceInformationMarkerStart($composer3, 1562124800, "CC(remember):CustomBottomSheet.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 112) == 32;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: CustomBottomSheetKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit CustomBottomSheet$lambda$1$0;
                        CustomBottomSheet$lambda$1$0 = CustomBottomSheetKt.CustomBottomSheet$lambda$1$0(function0);
                        return CustomBottomSheet$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            ModalBottomSheetKt.ModalBottomSheet-YbuCTN8((Function0) it$iv, wrapContentHeight$default, sheetState, 0.0f, false, shape, j, 0L, 0.0f, 0L, ComposableSingletons.CustomBottomSheetKt.INSTANCE.getLambda$1248120683$watch_later_debug(), (Function2) null, modalBottomSheetProperties, ComposableLambdaKt.rememberComposableLambda(1615524056, true, new Function3() { // from class: CustomBottomSheetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit CustomBottomSheet$lambda$2;
                    CustomBottomSheet$lambda$2 = CustomBottomSheetKt.CustomBottomSheet$lambda$2(list, showArrowCondition, function0, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return CustomBottomSheet$lambda$2;
                }
            }, $composer3, 54), $composer2, 48, 3462, 2968);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: CustomBottomSheetKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomBottomSheet$lambda$3;
                    CustomBottomSheet$lambda$3 = CustomBottomSheetKt.CustomBottomSheet$lambda$3(list, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomBottomSheet$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomBottomSheet$lambda$1$0(Function0 $onDismissRequest) {
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0167, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit CustomBottomSheet$lambda$2(final List $items, final boolean $showArrowCondition, final Function0 $onDismissRequest, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C91@3498L788:CustomBottomSheet.kt");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1615524056, $changed, -1, "CustomBottomSheet.<anonymous> (CustomBottomSheet.kt:91)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
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
            ComposerKt.sourceInformationMarkerStart($composer, 80239584, "C92@3530L746,92@3519L757:CustomBottomSheet.kt");
            ComposerKt.sourceInformationMarkerStart($composer, 1526609368, "CC(remember):CustomBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($items) | $composer.changed($showArrowCondition) | $composer.changed($onDismissRequest);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: CustomBottomSheetKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit CustomBottomSheet$lambda$2$0$0$0;
                    CustomBottomSheet$lambda$2$0$0$0 = CustomBottomSheetKt.CustomBottomSheet$lambda$2$0$0$0($items, $showArrowCondition, $onDismissRequest, (LazyListScope) obj);
                    return CustomBottomSheet$lambda$2$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn((Modifier) null, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer, 0, 511);
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
    public static final Unit CustomBottomSheet$lambda$2$0$0$0(final List $items, boolean $showArrowCondition, Function0 $onDismissRequest, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        $this$LazyColumn.items($items.size(), (Function1) null, new Function1<Integer, Object>() { // from class: CustomBottomSheetKt$CustomBottomSheet$lambda$2$0$0$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                $items.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new CustomBottomSheetKt$CustomBottomSheet$lambda$2$0$0$0$.inlined.itemsIndexed.default.3($items, $showArrowCondition, $onDismissRequest, $items)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BottomSheetItem(final BottomSheetItemData item, final boolean showArrow, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        long textColor;
        long iconTint;
        Function0 factory$iv$iv$iv;
        Painter icon;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(887803267);
        ComposerKt.sourceInformation($composer3, "C(BottomSheetItem)N(item,showArrow,onClick)135@4744L1908:CustomBottomSheet.kt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(showArrow) ? 32 : 16;
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
                ComposerKt.traceEventStart(887803267, $dirty2, -1, "BottomSheetItem (CustomBottomSheet.kt:120)");
            }
            if (!Color.equals-impl0(item.getTextColor-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU())) {
                $composer3.startReplaceGroup(138692217);
                $composer3.endReplaceGroup();
                textColor = item.getTextColor-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(138736113);
                ComposerKt.sourceInformation($composer3, "125@4558L6");
                long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU();
                $composer3.endReplaceGroup();
                textColor = j;
            }
            if (!Color.equals-impl0(item.getIconTint-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU())) {
                $composer3.startReplaceGroup(138849914);
                $composer3.endReplaceGroup();
                iconTint = item.getIconTint-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(138892849);
                ComposerKt.sourceInformation($composer3, "132@4716L6");
                long j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU();
                $composer3.endReplaceGroup();
                iconTint = j2;
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(53)), item.getEnabled(), (String) null, (Role) null, (MutableInteractionSource) null, function0, 14, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((384 >> 6) & 112) | 6;
            RowScope $this$BottomSheetItem_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -199737888, "C156@5385L953:CustomBottomSheet.kt");
            Function2 iconProvider = item.getIconProvider();
            if (iconProvider == null) {
                $composer3.startReplaceGroup(-199767278);
                $composer3.endReplaceGroup();
                icon = null;
            } else {
                $composer3.startReplaceGroup(824839887);
                ComposerKt.sourceInformation($composer3, "146@5101L8");
                $composer3.endReplaceGroup();
                icon = (Painter) iconProvider.invoke($composer3, 0);
            }
            if (icon == null) {
                $composer3.startReplaceGroup(-199749422);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-199749421);
                ComposerKt.sourceInformation($composer3, "*147@5137L176,153@5326L39");
                IconKt.Icon-ww6aTOc(icon, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), iconTint, $composer3, Painter.$stable | 432, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer3, 6);
                Unit unit = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            Modifier modifier$iv2 = RowScope.-CC.weight$default($this$BottomSheetItem_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 44076483, "C161@5535L9,159@5461L369:CustomBottomSheet.kt");
            String text = item.getText();
            TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14();
            TextKt.Text-Nvy7gAk(text, item.getMaxLines() == 1 ? BasicMarqueeKt.basicMarquee-1Mj1MLw$default(Modifier.Companion, 0, 0, 0, 0, (MarqueeSpacing) null, 0.0f, 63, (Object) null) : Modifier.Companion, item.getEnabled() ? textColor : Color.copy-wmQWz5c$default(textColor, 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, item.getMaxLines(), 0, (Function1) null, t14, $composer3, 1572864, 0, 114616);
            String it = item.getSummary();
            String it2 = (it == null || StringsKt.isBlank(it)) ? null : it;
            if (it2 == null) {
                $composer3.startReplaceGroup(44484906);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(44484907);
                ComposerKt.sourceInformation($composer3, "*171@5983L9,172@6036L6,169@5908L406");
                TextStyle t10 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10();
                long j3 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU();
                int maxLines = item.getMaxLines();
                Modifier it3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null);
                TextKt.Text-Nvy7gAk(it2, item.getMaxLines() == 1 ? BasicMarqueeKt.basicMarquee-1Mj1MLw$default(it3, 0, 0, 0, 0, (MarqueeSpacing) null, 0.0f, 63, (Object) null) : it3, j3, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, maxLines, 0, (Function1) null, t10, $composer3, 0, 0, 114680);
                Unit unit3 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (showArrow) {
                $composer3.startReplaceGroup(-198506848);
                ComposerKt.sourceInformation($composer3, "183@6377L40,185@6475L20,184@6430L206");
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer3, 6);
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_right_line_500($composer3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), textColor, $composer3, Painter.$stable | 432, 0);
            } else {
                $composer3.startReplaceGroup(-204828709);
            }
            $composer3.endReplaceGroup();
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
            endRestartGroup.updateScope(new Function2() { // from class: CustomBottomSheetKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomSheetItem$lambda$1;
                    BottomSheetItem$lambda$1 = CustomBottomSheetKt.BottomSheetItem$lambda$1(item, showArrow, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomSheetItem$lambda$1;
                }
            });
        }
    }
}