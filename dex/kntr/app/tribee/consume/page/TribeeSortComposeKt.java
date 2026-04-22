package kntr.app.tribee.consume.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.TextAutoSize;
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
import com.bapis.bilibili.app.dynamic.v2.KTribeeSortInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSortItem;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TribeeSortCompose.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\n\u001aS\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"TribeeSortLayout", "", "tribeeSortInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSortInfo;", "modifier", "Landroidx/compose/ui/Modifier;", "onClick", "Lkotlin/Function2;", "", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSortItem;", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSortInfo;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TribeeSortItemLayout", "isSelected", "", "isEnd", "sortItem", "index", "(ZZLcom/bapis/bilibili/app/dynamic/v2/KTribeeSortItem;ILandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSortComposeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSortItemLayout$lambda$2(boolean z, boolean z2, KTribeeSortItem kTribeeSortItem, int i, Modifier modifier, Function2 function2, int i2, int i3, Composer composer, int i4) {
        TribeeSortItemLayout(z, z2, kTribeeSortItem, i, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSortLayout$lambda$2(KTribeeSortInfo kTribeeSortInfo, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        TribeeSortLayout(kTribeeSortInfo, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSortLayout$lambda$0$0(int i, KTribeeSortItem kTribeeSortItem) {
        Intrinsics.checkNotNullParameter(kTribeeSortItem, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v15 */
    public static final void TribeeSortLayout(final KTribeeSortInfo tribeeSortInfo, Modifier modifier, Function2<? super Integer, ? super KTribeeSortItem, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 function22;
        Composer $composer2;
        Modifier modifier3;
        Function2 onClick;
        Modifier modifier4;
        Function2 onClick2;
        Arrangement.Horizontal horizontalArrangement$iv;
        Function0 factory$iv$iv$iv;
        CompositionLocalMap localMap$iv$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(tribeeSortInfo, "tribeeSortInfo");
        Composer $composer3 = $composer.startRestartGroup(1540377179);
        ComposerKt.sourceInformation($composer3, "C(TribeeSortLayout)N(tribeeSortInfo,modifier,onClick)28@1156L33,32@1320L1873:TribeeSortCompose.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(tribeeSortInfo) ? 4 : 2;
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
            function22 = function2;
        } else if (($changed & 384) == 0) {
            function22 = function2;
            $dirty |= $composer3.changedInstance(function22) ? 256 : 128;
        } else {
            function22 = function2;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onClick = function22;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                onClick2 = function22;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer3, -1461243588, "CC(remember):TribeeSortCompose.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function2() { // from class: kntr.app.tribee.consume.page.TribeeSortComposeKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TribeeSortLayout$lambda$0$0;
                            TribeeSortLayout$lambda$0$0 = TribeeSortComposeKt.TribeeSortLayout$lambda$0$0(((Integer) obj).intValue(), (KTribeeSortItem) obj2);
                            return TribeeSortLayout$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1540377179, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeSortLayout (TribeeSortCompose.kt:29)");
            }
            boolean isShowTips = !StringsKt.isBlank(tribeeSortInfo.getTipsText());
            boolean isShowSortList = !tribeeSortInfo.getSortItems().isEmpty();
            Modifier modifier$iv$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(modifier4, Dp.constructor-impl(33)), Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(12), 0.0f, 10, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            if (isShowTips && isShowSortList) {
                horizontalArrangement$iv = (Arrangement.Horizontal) Arrangement.INSTANCE.getSpaceBetween();
            } else if (isShowTips) {
                horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            } else {
                horizontalArrangement$iv = Arrangement.INSTANCE.getEnd();
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
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
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((384 >> 6) & 112) | 6;
            RowScope $this$TribeeSortLayout_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1502791481, "C:TribeeSortCompose.kt#iitu82");
            if (isShowTips) {
                $composer3.startReplaceGroup(-1502795295);
                ComposerKt.sourceInformation($composer3, "50@1900L6,48@1812L322");
                localMap$iv$iv = localMap$iv$iv2;
                TextKt.Text-Nvy7gAk(tribeeSortInfo.getTipsText(), RowScope.-CC.weight$default($this$TribeeSortLayout_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 24960, 241640);
            } else {
                localMap$iv$iv = localMap$iv$iv2;
                $composer3.startReplaceGroup(-1504603773);
            }
            $composer3.endReplaceGroup();
            if (!isShowTips || !isShowSortList) {
                $composer3.startReplaceGroup(-1504603773);
            } else {
                $composer3.startReplaceGroup(-1502430301);
                ComposerKt.sourceInformation($composer3, "61@2202L40");
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(36)), $composer3, 6);
            }
            $composer3.endReplaceGroup();
            if (isShowSortList) {
                $composer3.startReplaceGroup(-1502297838);
                ComposerKt.sourceInformation($composer3, "68@2411L6,65@2296L881");
                Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getSpaceAround();
                Composer $composer$iv2 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv2 = (432 << 3) & 112;
                Modifier modifier$iv$iv2 = modifier$iv;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                Composer $composer$iv$iv2 = $composer3;
                Composer $composer$iv$iv$iv = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv$iv.startReusableNode();
                if ($composer$iv$iv$iv.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv$iv$iv.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv$iv$iv.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv$iv);
                $composer$iv$iv = $composer3;
                MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv2;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i7 = ((432 >> 6) & 112) | 6;
                RowScope $this$TribeeSortLayout_u24lambda_u241_u240 = RowScopeInstance.INSTANCE;
                Composer $composer4 = $composer$iv$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer4, 1657198283, "C:TribeeSortCompose.kt#iitu82");
                $composer4.startReplaceGroup(-1054919873);
                ComposerKt.sourceInformation($composer4, "*81@3111L6,73@2666L479");
                Iterable $this$forEachIndexed$iv = tribeeSortInfo.getSortItems();
                boolean z = false;
                int index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    KTribeeSortItem sortItem = (KTribeeSortItem) item$iv;
                    int index = index$iv;
                    Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                    MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                    boolean areEqual = Intrinsics.areEqual(sortItem.getSortType(), tribeeSortInfo.getCurSortType());
                    Modifier materialized$iv$iv3 = materialized$iv$iv2;
                    boolean z2 = index == tribeeSortInfo.getSortItems().size() + (-1);
                    RowScope $this$TribeeSortLayout_u24lambda_u241_u2402 = $this$TribeeSortLayout_u24lambda_u241_u240;
                    BiliTheme biliTheme = BiliTheme.INSTANCE;
                    boolean z3 = z;
                    int $i$f$forEachIndexed = BiliTheme.$stable;
                    Composer $composer5 = $composer4;
                    TribeeSortItemLayout(areEqual, z2, sortItem, index, BackgroundKt.background-bw27NRU$default(Modifier.Companion, biliTheme.getColors($composer4, $i$f$forEachIndexed).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), onClick2, $composer5, ($dirty2 << 9) & 458752, 0);
                    materialized$iv$iv2 = materialized$iv$iv3;
                    $composer$iv$iv2 = $composer$iv$iv2;
                    $composer$iv2 = $composer$iv2;
                    localMap$iv$iv = localMap$iv$iv;
                    index$iv = index$iv2;
                    $this$TribeeSortLayout_u24lambda_u241_u240 = $this$TribeeSortLayout_u24lambda_u241_u2402;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    z = z3;
                    $composer$iv$iv$iv = $composer$iv$iv$iv;
                    $composer4 = $composer5;
                    modifier$iv$iv2 = modifier$iv$iv2;
                }
                Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                Composer $composer6 = $composer4;
                $composer$iv = $composer$iv2;
                $composer6.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                $composer$iv$iv$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                $composer$iv$iv = $composer3;
                $composer$iv = $composer3;
                $composer3.startReplaceGroup(-1504603773);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onClick = onClick2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function2 function23 = onClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeSortComposeKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSortLayout$lambda$2;
                    TribeeSortLayout$lambda$2 = TribeeSortComposeKt.TribeeSortLayout$lambda$2(tribeeSortInfo, modifier5, function23, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSortLayout$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSortItemLayout$lambda$0$0(int i, KTribeeSortItem kTribeeSortItem) {
        Intrinsics.checkNotNullParameter(kTribeeSortItem, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x0269, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeSortItemLayout(final boolean isSelected, final boolean isEnd, final KTribeeSortItem sortItem, final int index, Modifier modifier, Function2<? super Integer, ? super KTribeeSortItem, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Function2 onClick;
        Modifier modifier3;
        Function2 onClick2;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        long j;
        Intrinsics.checkNotNullParameter(sortItem, "sortItem");
        Composer $composer2 = $composer.startRestartGroup(1208773704);
        ComposerKt.sourceInformation($composer2, "C(TribeeSortItemLayout)N(isSelected,isEnd,sortItem,index,modifier,onClick)96@3408L33,98@3451L1046:TribeeSortCompose.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(isSelected) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(isEnd) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(sortItem) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(index) ? 2048 : 1024;
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
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            onClick = function2;
        } else if ((196608 & $changed) == 0) {
            onClick = function2;
            $dirty |= $composer2.changedInstance(onClick) ? 131072 : 65536;
        } else {
            onClick = function2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onClick2 = onClick;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1990366025, "CC(remember):TribeeSortCompose.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function2() { // from class: kntr.app.tribee.consume.page.TribeeSortComposeKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TribeeSortItemLayout$lambda$0$0;
                            TribeeSortItemLayout$lambda$0$0 = TribeeSortComposeKt.TribeeSortItemLayout$lambda$0$0(((Integer) obj).intValue(), (KTribeeSortItem) obj2);
                            return TribeeSortItemLayout$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function2 onClick3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onClick = onClick3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1208773704, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeSortItemLayout (TribeeSortCompose.kt:97)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(modifier4, Dp.constructor-impl(33));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1424580306, "C106@3725L6,107@3768L72,103@3622L541:TribeeSortCompose.kt#iitu82");
            Modifier modifier5 = BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1847073396, "CC(remember):TribeeSortCompose.kt#9igjgp");
            boolean invalid$iv = ((458752 & $dirty2) == 131072) | (($dirty2 & 7168) == 2048) | $composer2.changedInstance(sortItem);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeSortComposeKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit TribeeSortItemLayout$lambda$1$0$0;
                    TribeeSortItemLayout$lambda$1$0$0 = TribeeSortComposeKt.TribeeSortItemLayout$lambda$1$0$0(onClick, index, sortItem);
                    return TribeeSortItemLayout$lambda$1$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            onClick2 = onClick;
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
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 591192082, "C111@3866L287:TribeeSortCompose.kt#iitu82");
            Modifier modifier6 = SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(36), 0.0f, 2, (Object) null);
            String text = sortItem.getText();
            if (isSelected) {
                $composer2.startReplaceGroup(850359511);
                ComposerKt.sourceInformation($composer2, "114@4018L6");
                j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU();
            } else {
                $composer2.startReplaceGroup(850360407);
                ComposerKt.sourceInformation($composer2, "114@4046L6");
                j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU();
            }
            $composer2.endReplaceGroup();
            TextKt.Text-Nvy7gAk(text, modifier6, j, (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 24624, 0, 261096);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (!isEnd) {
                $composer2.startReplaceGroup(1425121348);
                ComposerKt.sourceInformation($composer2, "127@4446L6,121@4199L282");
                SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, Dp.constructor-impl(8), 0.0f, 10, (Object) null), Dp.constructor-impl((float) 0.5d)), Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), $composer2, 0);
            } else {
                $composer2.startReplaceGroup(1420959350);
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
            final Modifier modifier7 = modifier3;
            final Function2 function22 = onClick2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeSortComposeKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSortItemLayout$lambda$2;
                    TribeeSortItemLayout$lambda$2 = TribeeSortComposeKt.TribeeSortItemLayout$lambda$2(isSelected, isEnd, sortItem, index, modifier7, function22, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSortItemLayout$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSortItemLayout$lambda$1$0$0(Function2 $onClick, int $index, KTribeeSortItem $sortItem) {
        $onClick.invoke(Integer.valueOf($index), $sortItem);
        return Unit.INSTANCE;
    }
}