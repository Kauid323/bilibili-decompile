package kntr.base.dd.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecisionUpdater;
import kntr.base.dd.KDeviceDecision;
import kntr.base.dd.internal.IDeviceDecisionDebugger;
import kntr.base.dd.internal.IDeviceDecisionDebuggerKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: DDDebuggerPreview.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aJ\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001d\u0010\u000f\u001a\u0019\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0002\b\u0012H\u0001¢\u0006\u0002\u0010\u0013\u001a'\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0017\u001a\u001c\u0010\u0018\u001a\u00020\u0005*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00190\f\u001a\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u0005*\u00020\u001bH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"debugger", "Lkntr/base/dd/internal/IDeviceDecisionDebugger;", "getDebugger", "()Lkntr/base/dd/internal/IDeviceDecisionDebugger;", "QUERY_DEFAULT_VALUE", "", "DDDebuggerPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "TableView", "T", "items", "", "modifier", "Landroidx/compose/ui/Modifier;", "itemContent", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "TitleRow", "mainTitle", "subTitle", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "toPrettyJson", "", "errorMessage", "Lkntr/base/dd/IDeviceDecisionUpdater$Result;", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDDebuggerPreviewKt {
    private static final String QUERY_DEFAULT_VALUE = "DEBUGGER_QUERY_DEFAULT_VALUE";
    private static final IDeviceDecisionDebugger debugger = IDeviceDecisionDebuggerKt.getDebugger(KDeviceDecision.INSTANCE);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DDDebuggerPreview$lambda$0(int i, Composer composer, int i2) {
        DDDebuggerPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TableView$lambda$1(List list, Modifier modifier, Function4 function4, int i, int i2, Composer composer, int i3) {
        TableView(list, modifier, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TitleRow$lambda$1(String str, String str2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TitleRow(str, str2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final IDeviceDecisionDebugger getDebugger() {
        return debugger;
    }

    public static final void DDDebuggerPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-938541298);
        ComposerKt.sourceInformation($composer2, "C(DDDebuggerPreview)74@2769L11889:DDDebuggerPreview.kt#veq8ty");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-938541298, $changed, -1, "kntr.base.dd.preview.DDDebuggerPreview (DDDebuggerPreview.kt:73)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableSingletons$DDDebuggerPreviewKt.INSTANCE.m1374getLambda$18439082$preview_debug(), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.dd.preview.DDDebuggerPreviewKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit DDDebuggerPreview$lambda$0;
                    DDDebuggerPreview$lambda$0 = DDDebuggerPreviewKt.DDDebuggerPreview$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DDDebuggerPreview$lambda$0;
                }
            });
        }
    }

    public static final <T> void TableView(final List<? extends T> list, Modifier modifier, final Function4<? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        Composer $composer2 = $composer.startRestartGroup(-719171678);
        ComposerKt.sourceInformation($composer2, "C(TableView)N(items,modifier,itemContent)342@14995L6,344@15072L388,337@14812L648:DDDebuggerPreview.kt#veq8ty");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 256 : 128;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-719171678, $dirty, -1, "kntr.base.dd.preview.TableView (DDDebuggerPreview.kt:336)");
            }
            Modifier modifier5 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(PaddingKt.padding-VpY3zN4$default(modifier4, Dp.constructor-impl(16), 0.0f, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            PaddingValues paddingValues = PaddingKt.PaddingValues-YgX7TsA$default(0.0f, Dp.constructor-impl(12), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 365764934, "CC(remember):DDDebuggerPreview.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(list) | (($dirty & 896) == 256);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.base.dd.preview.DDDebuggerPreviewKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit TableView$lambda$0$0;
                        TableView$lambda$0$0 = DDDebuggerPreviewKt.TableView$lambda$0$0(list, function4, (LazyListScope) obj);
                        return TableView$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(modifier5, (LazyListState) null, paddingValues, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer2, 384, 506);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.dd.preview.DDDebuggerPreviewKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TableView$lambda$1;
                    TableView$lambda$1 = DDDebuggerPreviewKt.TableView$lambda$1(list, modifier6, function4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TableView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TableView$lambda$0$0(final List $items, final Function4 $itemContent, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        $this$LazyColumn.items($items.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.base.dd.preview.DDDebuggerPreviewKt$TableView$lambda$0$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                $items.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.base.dd.preview.DDDebuggerPreviewKt$TableView$lambda$0$0$$inlined$itemsIndexed$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Composer $composer2;
                ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                Object item = $items.get(it);
                int $changed2 = ($dirty & 14) | ($dirty & 112);
                $composer.startReplaceGroup(-1600884845);
                ComposerKt.sourceInformation($composer, "CN(index,item)*346@15131L24:DDDebuggerPreview.kt#veq8ty");
                $itemContent.invoke(Integer.valueOf(it), item, $composer, Integer.valueOf((($changed2 >> 3) & 14) | (($changed2 >> 3) & 112)));
                if (it < CollectionsKt.getLastIndex($items)) {
                    $composer.startReplaceGroup(-1600804556);
                    ComposerKt.sourceInformation($composer, "348@15215L215");
                    DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(6)), Dp.constructor-impl((float) 0.5d), 0L, $composer, 54, 4);
                    $composer.endReplaceGroup();
                    $composer2 = $composer;
                } else {
                    $composer2 = $composer;
                    $composer2.startReplaceGroup(-1615905493);
                    $composer2.endReplaceGroup();
                }
                $composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    public static final void TitleRow(final String mainTitle, final String subTitle, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(mainTitle, "mainTitle");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Composer $composer3 = $composer.startRestartGroup(1305674862);
        ComposerKt.sourceInformation($composer3, "C(TitleRow)N(mainTitle,subTitle,modifier)365@15578L462:DDDebuggerPreview.kt#veq8ty");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(mainTitle) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(subTitle) ? 32 : 16;
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
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1305674862, $dirty2, -1, "kntr.base.dd.preview.TitleRow (DDDebuggerPreview.kt:364)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
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
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -643802308, "C372@15823L9,373@15868L6,370@15757L134,378@15966L9,379@16011L6,376@15901L133:DDDebuggerPreview.kt#veq8ty");
            modifier3 = modifier4;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(mainTitle, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT15(), $composer3, $dirty2 & 14, 0, 131066);
            TextKt.Text-Nvy7gAk(subTitle, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT15(), $composer3, ($dirty2 >> 3) & 14, 0, 131066);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.base.dd.preview.DDDebuggerPreviewKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit TitleRow$lambda$1;
                    TitleRow$lambda$1 = DDDebuggerPreviewKt.TitleRow$lambda$1(mainTitle, subTitle, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TitleRow$lambda$1;
                }
            });
        }
    }

    public static final String toPrettyJson(List<? extends Map<String, String>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        try {
            StringFormat $this$encodeToString$iv = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.base.dd.preview.DDDebuggerPreviewKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit prettyJson$lambda$0;
                    prettyJson$lambda$0 = DDDebuggerPreviewKt.toPrettyJson$lambda$0((JsonBuilder) obj);
                    return prettyJson$lambda$0;
                }
            }, 1, (Object) null);
            $this$encodeToString$iv.getSerializersModule();
            return $this$encodeToString$iv.encodeToString(new ArrayListSerializer(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE)), list);
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("DDLib", "toPrettyJson has exception " + e.getMessage() + ".");
            return "[]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toPrettyJson$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setPrettyPrint(true);
        $this$Json.setEncodeDefaults(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String errorMessage(IDeviceDecisionUpdater.Result $this$errorMessage) {
        if ($this$errorMessage instanceof IDeviceDecisionUpdater.Result.Error) {
            return ((IDeviceDecisionUpdater.Result.Error) $this$errorMessage).getMessage();
        }
        if ($this$errorMessage instanceof IDeviceDecisionUpdater.Result.Success) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}