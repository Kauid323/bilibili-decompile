package kntr.app.tribee.operation.bottomsheet;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
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
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSendInviteCodeOptionsResp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope;
import kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: TribeeStationListBottomSheet.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a`\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"TribeeStationListBottomSheet", "", "maxHeight", "Landroidx/compose/ui/unit/Dp;", "tribeeList", "", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KTribeeSelectItem;", "onSelect", "Lkotlin/Function1;", "onDismiss", "Lkotlin/Function0;", "Landroidx/compose/runtime/DisallowComposableCalls;", "selectedItem", "modifier", "Landroidx/compose/ui/Modifier;", "TribeeStationListBottomSheet-Q1bl1hc", "(FLjava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KTribeeSelectItem;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TribeeStationItem", "item", "isSelected", "", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KTribeeSelectItem;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "operation_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeStationListBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeStationItem$lambda$1(KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem kTribeeSelectItem, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeStationItem(kTribeeSelectItem, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeStationListBottomSheet_Q1bl1hc$lambda$1(float f, List list, Function1 function1, Function0 function0, KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem kTribeeSelectItem, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m819TribeeStationListBottomSheetQ1bl1hc(f, list, function1, function0, kTribeeSelectItem, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: TribeeStationListBottomSheet-Q1bl1hc  reason: not valid java name */
    public static final void m819TribeeStationListBottomSheetQ1bl1hc(final float f, final List<KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem> list, final Function1<? super KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem, Unit> function1, final Function0<Unit> function0, final KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem selectedItem, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(list, "tribeeList");
        Intrinsics.checkNotNullParameter(function1, "onSelect");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer $composer3 = $composer.startRestartGroup(-2035502761);
        ComposerKt.sourceInformation($composer3, "C(TribeeStationListBottomSheet)N(maxHeight:c#ui.unit.Dp,tribeeList,onSelect,onDismiss,selectedItem,modifier)51@2236L1799,48@2139L1896:TribeeStationListBottomSheet.kt#k8oyq8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(f) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(selectedItem) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2035502761, $dirty2, -1, "kntr.app.tribee.operation.bottomsheet.TribeeStationListBottomSheet (TribeeStationListBottomSheet.kt:47)");
            }
            final Modifier modifier4 = modifier3;
            $composer2 = $composer3;
            ComposeBottomsheetKt.m1831BottomSheetContainerlVb_Clg(function0, null, 0L, true, false, false, null, ComposableLambdaKt.rememberComposableLambda(726667494, true, new Function3() { // from class: kntr.app.tribee.operation.bottomsheet.TribeeStationListBottomSheetKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeStationListBottomSheet_Q1bl1hc$lambda$0;
                    TribeeStationListBottomSheet_Q1bl1hc$lambda$0 = TribeeStationListBottomSheetKt.TribeeStationListBottomSheet_Q1bl1hc$lambda$0(modifier4, f, list, selectedItem, function1, function0, (BottomSheetScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeStationListBottomSheet_Q1bl1hc$lambda$0;
                }
            }, $composer3, 54), $composer2, (($dirty2 >> 9) & 14) | 12585984, ConstantsKt.RECOMMEND_RESERVATION_CARD_HEIGHT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.operation.bottomsheet.TribeeStationListBottomSheetKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeStationListBottomSheet_Q1bl1hc$lambda$1;
                    TribeeStationListBottomSheet_Q1bl1hc$lambda$1 = TribeeStationListBottomSheetKt.TribeeStationListBottomSheet_Q1bl1hc$lambda$1(f, list, function1, function0, selectedItem, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeStationListBottomSheet_Q1bl1hc$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeStationListBottomSheet_Q1bl1hc$lambda$0(Modifier $modifier, float f, final List $tribeeList, final KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem $selectedItem, final Function1 $onSelect, final Function0 $onDismiss, BottomSheetScope $this$BottomSheetContainer, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$BottomSheetContainer, "$this$BottomSheetContainer");
        ComposerKt.sourceInformation($composer, "C52@2246L1783:TribeeStationListBottomSheet.kt#k8oyq8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(726667494, $changed, -1, "kntr.app.tribee.operation.bottomsheet.TribeeStationListBottomSheet.<anonymous> (TribeeStationListBottomSheet.kt:52)");
            }
            Modifier modifier$iv$iv = PaddingKt.padding-VpY3zN4$default($modifier, Dp.constructor-impl(4), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv);
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
            ComposerKt.sourceInformationMarkerStart($composer, 2848551, "C58@2404L56,59@2496L9,60@2546L6,57@2375L260,72@2999L6,75@3121L898,64@2649L1370:TribeeStationListBottomSheet.kt#k8oyq8");
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_50(TribeeRes.INSTANCE.getString()), $composer, 0), PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16b(), $composer, 48, 0, 131064);
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl(16), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            Modifier modifier = BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0$default(SizeKt.heightIn-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, f, 1, (Object) null), 0.0f, Dp.constructor-impl(8), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
            ComposerKt.sourceInformationMarkerStart($composer, -692621646, "CC(remember):TribeeStationListBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($tribeeList) | $composer.changedInstance($selectedItem) | $composer.changed($onSelect) | $composer.changed($onDismiss);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.tribee.operation.bottomsheet.TribeeStationListBottomSheetKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0;
                        TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0 = TribeeStationListBottomSheetKt.TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0($tribeeList, $selectedItem, $onSelect, $onDismiss, (LazyListScope) obj);
                        return TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(modifier, (LazyListState) null, paddingValues, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer, 384, 506);
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
    public static final Unit TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0(final List $tribeeList, final KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem $selectedItem, final Function1 $onSelect, final Function0 $onDismiss, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.items$default($this$LazyColumn, $tribeeList.size(), (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1631501358, true, new Function4() { // from class: kntr.app.tribee.operation.bottomsheet.TribeeStationListBottomSheetKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0$0;
                TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0$0 = TribeeStationListBottomSheetKt.TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0$0($tribeeList, $selectedItem, $onSelect, $onDismiss, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0$0;
            }
        }), 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0$0(List $tribeeList, KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem $selectedItem, final Function1 $onSelect, final Function0 $onDismiss, LazyItemScope $this$items, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(it):TribeeStationListBottomSheet.kt#k8oyq8");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(it) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1631501358, $dirty2, -1, "kntr.app.tribee.operation.bottomsheet.TribeeStationListBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeStationListBottomSheet.kt:77)");
            }
            final KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem item = (KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem) CollectionsKt.getOrNull($tribeeList, it);
            if (item == null) {
                $composer.startReplaceGroup(2087998654);
            } else {
                $composer.startReplaceGroup(2087998655);
                ComposerKt.sourceInformation($composer, "*85@3616L146,78@3256L533");
                boolean z = $selectedItem != null && item.getId() == $selectedItem.getId();
                Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(65));
                ComposerKt.sourceInformationMarkerStart($composer, 1919912568, "CC(remember):TribeeStationListBottomSheet.kt#9igjgp");
                boolean invalid$iv = $composer.changed($onSelect) | $composer.changedInstance(item) | $composer.changed($onDismiss);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.operation.bottomsheet.TribeeStationListBottomSheetKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0$0$0$0$0;
                            TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0$0$0$0$0 = TribeeStationListBottomSheetKt.TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0$0$0$0$0($onSelect, item, $onDismiss);
                            return TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0$0$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                TribeeStationItem(item, z, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), $composer, 0, 0);
            }
            $composer.endReplaceGroup();
            if (it < $tribeeList.size() - 1) {
                $composer.startReplaceGroup(2088623956);
                ComposerKt.sourceInformation($composer, "93@3945L6,93@3889L76");
                DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 48, 1);
            } else {
                $composer.startReplaceGroup(2084787024);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeStationListBottomSheet_Q1bl1hc$lambda$0$0$0$0$0$0$0$0(Function1 $onSelect, KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem $item, Function0 $onDismiss) {
        $onSelect.invoke($item);
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    private static final void TribeeStationItem(final KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem item, final boolean isSelected, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        long j;
        Composer $composer3 = $composer.startRestartGroup(-747930357);
        ComposerKt.sourceInformation($composer3, "C(TribeeStationItem)N(item,isSelected,modifier)107@4212L1851:TribeeStationListBottomSheet.kt#k8oyq8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(isSelected) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-747930357, $dirty2, -1, "kntr.app.tribee.operation.bottomsheet.TribeeStationItem (TribeeStationListBottomSheet.kt:106)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty2 >> 6) & 14) | 384;
            Modifier modifier$iv$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            modifier3 = modifier4;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$TribeeStationItem_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 688042449, "C111@4318L638,130@4966L794:TribeeStationListBottomSheet.kt#k8oyq8");
            Modifier clip = ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6)));
            String $this$asRequest$iv = item.getFaceUrl();
            ImageRequest $this$TribeeStationItem_u24lambda_u240_u240 = new ImageRequest($this$asRequest$iv);
            $this$TribeeStationItem_u24lambda_u240_u240.contentScale(ContentScale.Companion.getCrop());
            BiliImageKt.BiliImage($this$TribeeStationItem_u24lambda_u240_u240.build(), clip, null, null, null, null, null, null, ComposableSingletons$TribeeStationListBottomSheetKt.INSTANCE.getLambda$1393844440$operation_debug(), $composer3, 100663296, 252);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(RowScope.-CC.weight$default($this$TribeeStationItem_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(8), 0.0f, 2, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv2 = (48 << 3) & 112;
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
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1812728345, "C137@5181L301,148@5607L6,145@5495L255:TribeeStationListBottomSheet.kt#k8oyq8");
            String title = item.getTitle();
            long sp = TextUnitKt.getSp(15);
            if (isSelected) {
                $composer3.startReplaceGroup(-1881183877);
                ComposerKt.sourceInformation($composer3, "140@5306L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(-1881182826);
                ComposerKt.sourceInformation($composer3, "140@5339L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            TextKt.Text-Nvy7gAk(title, (Modifier) null, j, (TextAutoSize) null, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(21), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 25008, 239594);
            TextKt.Text-Nvy7gAk(item.getSubTitle(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(17), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 25008, 239594);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (isSelected) {
                $composer3.startReplaceGroup(689466340);
                ComposerKt.sourceInformation($composer3, "157@5845L18,160@6015L6,156@5800L247");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCheckmark_line_500($composer3, 6), "checked icon", SizeKt.size-3ABfNKs(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), Dp.constructor-impl(22)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer3, Painter.$stable | 432, 0);
            } else {
                $composer3.startReplaceGroup(683704091);
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
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.operation.bottomsheet.TribeeStationListBottomSheetKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeStationItem$lambda$1;
                    TribeeStationItem$lambda$1 = TribeeStationListBottomSheetKt.TribeeStationItem$lambda$1(item, isSelected, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeStationItem$lambda$1;
                }
            });
        }
    }
}