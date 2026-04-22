package kntr.app.tribee.steam.bottomsheet;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
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
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.KThreeDot;
import com.bapis.bilibili.app.dynamic.v2.KThreeDotItem;
import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.tribee.steam.track.SteamTrackerKt;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSteamThreeDotBottomSheet.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"TribeeSteamThreeDotBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "threeDot", "Lcom/bapis/bilibili/app/dynamic/v2/KThreeDot;", "onUIAction", "Lkotlin/Function1;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlin/jvm/functions/Function0;Lcom/bapis/bilibili/app/dynamic/v2/KThreeDot;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamThreeDotBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamThreeDotBottomSheet$lambda$1(Function0 function0, KThreeDot kThreeDot, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeSteamThreeDotBottomSheet(function0, kThreeDot, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TribeeSteamThreeDotBottomSheet(final Function0<Unit> function0, final KThreeDot threeDot, final Function1<? super TribeeSteamUIAction, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(threeDot, "threeDot");
        Intrinsics.checkNotNullParameter(function1, "onUIAction");
        Composer $composer3 = $composer.startRestartGroup(776176973);
        ComposerKt.sourceInformation($composer3, "C(TribeeSteamThreeDotBottomSheet)N(onDismissRequest,threeDot,onUIAction,modifier)42@1772L6,68@2646L3539,39@1631L4554:TribeeSteamThreeDotBottomSheet.kt#vmcmav");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(threeDot) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(776176973, $dirty2, -1, "kntr.app.tribee.steam.bottomsheet.TribeeSteamThreeDotBottomSheet (TribeeSteamThreeDotBottomSheet.kt:38)");
            }
            $composer2 = $composer3;
            ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(function0, modifier3, (SheetState) null, 0.0f, false, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2_float-0d7_KjU(), 0L, 0.0f, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ComposableSingletons$TribeeSteamThreeDotBottomSheetKt.INSTANCE.getLambda$1997033592$consume_debug(), (Function2) null, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(-1476947925, true, new Function3() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamThreeDotBottomSheetKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeSteamThreeDotBottomSheet$lambda$0;
                    TribeeSteamThreeDotBottomSheet$lambda$0 = TribeeSteamThreeDotBottomSheetKt.TribeeSteamThreeDotBottomSheet$lambda$0(threeDot, function1, function0, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeSteamThreeDotBottomSheet$lambda$0;
                }
            }, $composer3, 54), $composer2, ($dirty2 & 14) | 805306368 | (($dirty2 >> 6) & 112), 3078, 6556);
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
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamThreeDotBottomSheetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamThreeDotBottomSheet$lambda$1;
                    TribeeSteamThreeDotBottomSheet$lambda$1 = TribeeSteamThreeDotBottomSheetKt.TribeeSteamThreeDotBottomSheet$lambda$1(function0, threeDot, function1, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamThreeDotBottomSheet$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamThreeDotBottomSheet$lambda$0(final KThreeDot $threeDot, final Function1 $onUIAction, final Function0 $onDismissRequest, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C*73@2867L3302,70@2699L3470:TribeeSteamThreeDotBottomSheet.kt#vmcmav");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1476947925, $changed, -1, "kntr.app.tribee.steam.bottomsheet.TribeeSteamThreeDotBottomSheet.<anonymous> (TribeeSteamThreeDotBottomSheet.kt:69)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(16), 7, (Object) null), 0.0f, 1, (Object) null);
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer, -1960660319, "CC(remember):TribeeSteamThreeDotBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($threeDot) | $composer.changed($onUIAction) | $composer.changed($onDismissRequest);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamThreeDotBottomSheetKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0;
                        TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0 = TribeeSteamThreeDotBottomSheetKt.TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0($threeDot, $onUIAction, $onDismissRequest, (LazyListScope) obj);
                        return TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(fillMaxWidth$default, (LazyListState) null, (PaddingValues) null, false, vertical, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer, 24582, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0(KThreeDot $threeDotList, final Function1 $onUIAction, final Function0 $onDismissRequest, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final List items$iv = $threeDotList.getItem();
        final Function1 key$iv = new Function1() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamThreeDotBottomSheetKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Object TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0$0;
                TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0$0 = TribeeSteamThreeDotBottomSheetKt.TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0$0((KThreeDotItem) obj);
                return TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0$0;
            }
        };
        final Function1 contentType$iv = new Function1() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamThreeDotBottomSheetKt$TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m1108invoke((KThreeDotItem) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m1108invoke(KThreeDotItem kThreeDotItem) {
                return null;
            }
        };
        $this$LazyColumn.items(items$iv.size(), new Function1<Integer, Object>() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamThreeDotBottomSheetKt$TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0$$inlined$items$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return key$iv.invoke(items$iv.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamThreeDotBottomSheetKt$TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke(items$iv.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamThreeDotBottomSheetKt$TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                String pageType;
                Function0 factory$iv$iv$iv;
                ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if ($composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    int i = $dirty & 14;
                    final KThreeDotItem item = (KThreeDotItem) items$iv.get(it);
                    $composer.startReplaceGroup(-271244934);
                    ComposerKt.sourceInformation($composer, "CN(item)*84@3378L144,84@3357L165,98@3969L6,99@4031L1323,89@3543L2594:TribeeSteamThreeDotBottomSheet.kt#vmcmav");
                    KThreeDotItem.KBusinessType type = item.getType();
                    if (Intrinsics.areEqual(type, KThreeDotItem.KBusinessType.THREEDOT_BUSINESS_MYSELF.INSTANCE)) {
                        pageType = "4";
                    } else {
                        pageType = Intrinsics.areEqual(type, KThreeDotItem.KBusinessType.THREEDOT_BUSINESS_UNBIND.INSTANCE) ? "5" : null;
                    }
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer, 1792373747, "CC(remember):TribeeSteamThreeDotBottomSheet.kt#9igjgp");
                    boolean invalid$iv = $composer.changed(pageType);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = (Function2) new TribeeSteamThreeDotBottomSheetKt$TribeeSteamThreeDotBottomSheet$1$1$1$1$2$1$1(pageType, null);
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer, 6);
                    Modifier modifier = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(52)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, 1792395822, "CC(remember):TribeeSteamThreeDotBottomSheet.kt#9igjgp");
                    boolean invalid$iv2 = $composer.changedInstance(item) | $composer.changed($onUIAction) | $composer.changed($onDismissRequest);
                    Object it$iv2 = $composer.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        final Function1 function1 = $onUIAction;
                        final Function0 function0 = $onDismissRequest;
                        Object value$iv2 = (Function0) new Function0<Unit>() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamThreeDotBottomSheetKt$TribeeSteamThreeDotBottomSheet$1$1$1$1$2$2$1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1109invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m1109invoke() {
                                KThreeDotItem.KBusinessType type2 = item.getType();
                                if (Intrinsics.areEqual(type2, KThreeDotItem.KBusinessType.THREEDOT_BUSINESS_MYSELF.INSTANCE)) {
                                    SteamTrackerKt.reportSteamPageFloatClick("my_data");
                                    function1.invoke(new TribeeSteamUIAction.RouterTo(item.getJumpUrl()));
                                } else if (Intrinsics.areEqual(type2, KThreeDotItem.KBusinessType.THREEDOT_BUSINESS_UNBIND.INSTANCE)) {
                                    SteamTrackerKt.reportSteamPageFloatClick("unbound");
                                    KToastDialog it2 = item.getToast();
                                    if (it2 != null) {
                                        function1.invoke(new TribeeSteamUIAction.ToastDialog(it2));
                                    }
                                }
                                function0.invoke();
                            }
                        };
                        $composer.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                    int $changed$iv$iv = (432 << 3) & 112;
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
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i3 = ((432 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 1453479727, "C130@5721L9,131@5782L6,127@5550L271,137@6015L9,138@6076L6,134@5847L268:TribeeSteamThreeDotBottomSheet.kt#vmcmav");
                    TextKt.Text-Nvy7gAk(item.getTitle(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 48, 0, 131064);
                    TextKt.Text-Nvy7gAk(item.getDesc(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(16), 0.0f, 11, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 48, 0, 131064);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
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
    public static final Object TribeeSteamThreeDotBottomSheet$lambda$0$0$0$0$0(KThreeDotItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTitle();
    }
}