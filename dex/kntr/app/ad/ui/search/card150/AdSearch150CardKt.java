package kntr.app.ad.ui.search.card150;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.color.ThemeColorsKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.GarbInfo;
import java.util.List;
import kntr.app.ad.ui.search.components.AdSearchCoverKt;
import kntr.app.ad.ui.uikit.modifiers.DropShadowModifierKt;
import kntr.app.ad.ui.uikit.modifiers.TouchCapture;
import kntr.app.ad.ui.uikit.modifiers.TouchCaptureModifierKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdSearch150Card.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001as\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a9\u0010\u0013\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"AdSearch150Card", RoomRecommendViewModel.EMPTY_CURSOR, "bgColor", "Landroidx/compose/ui/graphics/Color;", "coverUrl", RoomRecommendViewModel.EMPTY_CURSOR, "buttonLabels", RoomRecommendViewModel.EMPTY_CURSOR, "onCardClick", "Lkotlin/Function0;", "onButtonClick", "Lkotlin/Function1;", RoomRecommendViewModel.EMPTY_CURSOR, "onTouchCapture", "Lkntr/app/ad/ui/uikit/modifiers/TouchCapture;", "modifier", "Landroidx/compose/ui/Modifier;", "AdSearch150Card-ivE2bt0", "(Landroidx/compose/ui/graphics/Color;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AdSearch150ButtonList", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ad-search_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdSearch150CardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdSearch150ButtonList$lambda$1(List list, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AdSearch150ButtonList(list, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdSearch150Card_ivE2bt0$lambda$3(Color color, String str, List list, Function0 function0, Function1 function1, Function1 function12, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m476AdSearch150CardivE2bt0(color, str, list, function0, function1, function12, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: AdSearch150Card-ivE2bt0  reason: not valid java name */
    public static final void m476AdSearch150CardivE2bt0(final Color bgColor, final String coverUrl, final List<String> list, final Function0<Unit> function0, final Function1<? super Integer, Unit> function1, final Function1<? super TouchCapture, Unit> function12, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(function0, "onCardClick");
        Intrinsics.checkNotNullParameter(function1, "onButtonClick");
        Intrinsics.checkNotNullParameter(function12, "onTouchCapture");
        Composer $composer3 = $composer.startRestartGroup(1218554706);
        ComposerKt.sourceInformation($composer3, "C(AdSearch150Card)N(bgColor:c#ui.graphics.Color,coverUrl,buttonLabels,onCardClick,onButtonClick,onTouchCapture,modifier)73@2966L7,78@3241L39,80@3343L53,47@1906L2160:AdSearch150Card.kt#swobc1");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(bgColor) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(coverUrl) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function12) ? 131072 : 65536;
        }
        int i2 = i & 64;
        if (i2 != 0) {
            $dirty |= 1572864;
            modifier2 = modifier;
        } else if ((1572864 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 1048576 : 524288;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute((599187 & $dirty2) != 599186, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1218554706, $dirty2, -1, "kntr.app.ad.ui.search.card150.AdSearch150Card (AdSearch150Card.kt:46)");
            }
            if (bgColor != null) {
                $composer3.startReplaceGroup(900032532);
                ComposerKt.sourceInformation($composer3, "58@2357L6");
                modifier4 = BackgroundKt.background$default(Modifier.Companion, Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{bgColor, Color.box-impl(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(900497656);
                $composer3.endReplaceGroup();
                modifier4 = Modifier.Companion;
            }
            Modifier modifier5 = PaddingKt.padding-qDBjuR0(modifier2.then(modifier4), Dp.constructor-impl(5), Dp.constructor-impl(10), Dp.constructor-impl(5), Dp.constructor-impl(6));
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8));
            long j2 = Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.05f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            float f = Dp.constructor-impl(0);
            float f2 = Dp.constructor-impl(2);
            long v1$iv$iv = Float.floatToRawIntBits(f);
            long v2$iv$iv = Float.floatToRawIntBits(f2);
            Modifier m533dropShadowDPi4msk = DropShadowModifierKt.m533dropShadowDPi4msk(modifier5, shape, j2, DpOffset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), Dp.constructor-impl(4), Dp.constructor-impl(0));
            CompositionLocal this_$iv = BiliThemeKt.getLocalTheme();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier6 = TouchCaptureModifierKt.touchCaptureAbsolute(ClipKt.clip(BackgroundKt.background-bw27NRU(m533dropShadowDPi4msk, ThemeColorsKt.isNightTheme((GarbInfo) consume) ? ColorKt.Color(4280559144L) : Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), function12);
            ComposerKt.sourceInformationMarkerStart($composer3, -1494948647, "CC(remember):AdSearch150Card.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Indication indication = RippleKt.ripple-H2RKhps$default(false, 0.0f, 0L, 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -1494945369, "CC(remember):AdSearch150Card.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 7168) == 2048;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.ad.ui.search.card150.AdSearch150CardKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit AdSearch150Card_ivE2bt0$lambda$1$0;
                        AdSearch150Card_ivE2bt0$lambda$1$0 = AdSearch150CardKt.AdSearch150Card_ivE2bt0$lambda$1$0(function0);
                        return AdSearch150Card_ivE2bt0$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0(ClickableKt.clickable-O2vRcR0$default(modifier6, mutableInteractionSource, indication, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null), Dp.constructor-impl(7), Dp.constructor-impl(7), Dp.constructor-impl(7), Dp.constructor-impl(12));
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier2;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1472031218, "C85@3535L231:AdSearch150Card.kt#swobc1");
            AdSearchCoverKt.m477AdSearchCover6a0pyJM(coverUrl, AspectRatioKt.aspectRatio$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), 1.7777778f, false, 2, (Object) null), 0.0f, $composer3, ($dirty2 >> 3) & 14, 4);
            List<String> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                $composer$iv$iv = $composer3;
                $composer$iv = $composer3;
                $composer$iv2 = $composer3;
                $composer2 = $composer3;
                $composer2.startReplaceGroup(-1475555206);
                $composer2.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1471765983);
                ComposerKt.sourceInformation($composer3, "95@3825L225");
                $composer$iv$iv = $composer3;
                $composer$iv = $composer3;
                $composer$iv2 = $composer3;
                AdSearch150ButtonList(list, function1, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer3, (($dirty2 >> 6) & 14) | 384 | (($dirty2 >> 9) & 112), 0);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.search.card150.AdSearch150CardKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdSearch150Card_ivE2bt0$lambda$3;
                    AdSearch150Card_ivE2bt0$lambda$3 = AdSearch150CardKt.AdSearch150Card_ivE2bt0$lambda$3(bgColor, coverUrl, list, function0, function1, function12, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdSearch150Card_ivE2bt0$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdSearch150Card_ivE2bt0$lambda$1$0(Function0 $onCardClick) {
        $onCardClick.invoke();
        return Unit.INSTANCE;
    }

    private static final void AdSearch150ButtonList(final List<String> list, final Function1<? super Integer, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        final Function1<? super Integer, Unit> function12 = function1;
        Composer $composer2 = $composer.startRestartGroup(930430737);
        ComposerKt.sourceInformation($composer2, "C(AdSearch150ButtonList)N(buttonLabels,onButtonClick,modifier)112@4226L1060:AdSearch150Card.kt#swobc1");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? 32 : 16;
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
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(930430737, $dirty2, -1, "kntr.app.ad.ui.search.card150.AdSearch150ButtonList (AdSearch150Card.kt:111)");
            }
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            int $changed$iv = (($dirty2 >> 6) & 14) | 48;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier$iv$iv = modifier4;
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
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$AdSearch150ButtonList_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1143031750, "C:AdSearch150Card.kt#swobc1");
            $composer2.startReplaceGroup(1283798384);
            ComposerKt.sourceInformation($composer2, "*118@4428L24,126@4761L6,127@4828L6,125@4696L167,130@4963L307,117@4394L876");
            List<String> $this$forEachIndexed$iv = list;
            boolean z2 = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                final String label = (String) item$iv;
                final int index = index$iv;
                boolean z3 = z2;
                ComposerKt.sourceInformationMarkerStart($composer2, -1432731937, "CC(remember):AdSearch150Card.kt#9igjgp");
                boolean invalid$iv = (($dirty2 & 112) == 32) | $composer2.changed(index);
                boolean z4 = z;
                Object it$iv = $composer2.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ButtonKt.Button((Function0) it$iv, SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$AdSearch150ButtonList_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(36)), false, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6)), ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg2_float-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), 0L, 0L, $composer2, ButtonDefaults.$stable << 12, 12), (ButtonElevation) null, (BorderStroke) null, PaddingKt.PaddingValues-YgX7TsA(Dp.constructor-impl(6), Dp.constructor-impl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-237963625, true, new Function3() { // from class: kntr.app.ad.ui.search.card150.AdSearch150CardKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit AdSearch150ButtonList$lambda$0$0$1;
                            AdSearch150ButtonList$lambda$0$0$1 = AdSearch150CardKt.AdSearch150ButtonList$lambda$0$0$1(label, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return AdSearch150ButtonList$lambda$0$0$1;
                        }
                    }, $composer2, 54), $composer2, 817889280, 356);
                    function12 = function1;
                    index$iv = index$iv2;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    z = z4;
                    z2 = z3;
                    $this$AdSearch150ButtonList_u24lambda_u240 = $this$AdSearch150ButtonList_u24lambda_u240;
                    $dirty2 = $dirty2;
                }
                Object value$iv = new Function0() { // from class: kntr.app.ad.ui.search.card150.AdSearch150CardKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit AdSearch150ButtonList$lambda$0$0$0$0;
                        AdSearch150ButtonList$lambda$0$0$0$0 = AdSearch150CardKt.AdSearch150ButtonList$lambda$0$0$0$0(function12, index);
                        return AdSearch150ButtonList$lambda$0$0$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ButtonKt.Button((Function0) it$iv, SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$AdSearch150ButtonList_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(36)), false, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6)), ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg2_float-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), 0L, 0L, $composer2, ButtonDefaults.$stable << 12, 12), (ButtonElevation) null, (BorderStroke) null, PaddingKt.PaddingValues-YgX7TsA(Dp.constructor-impl(6), Dp.constructor-impl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-237963625, true, new Function3() { // from class: kntr.app.ad.ui.search.card150.AdSearch150CardKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit AdSearch150ButtonList$lambda$0$0$1;
                        AdSearch150ButtonList$lambda$0$0$1 = AdSearch150CardKt.AdSearch150ButtonList$lambda$0$0$1(label, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return AdSearch150ButtonList$lambda$0$0$1;
                    }
                }, $composer2, 54), $composer2, 817889280, 356);
                function12 = function1;
                index$iv = index$iv2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z = z4;
                z2 = z3;
                $this$AdSearch150ButtonList_u24lambda_u240 = $this$AdSearch150ButtonList_u24lambda_u240;
                $dirty2 = $dirty2;
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
            modifier3 = modifier$iv$iv;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.search.card150.AdSearch150CardKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdSearch150ButtonList$lambda$1;
                    AdSearch150ButtonList$lambda$1 = AdSearch150CardKt.AdSearch150ButtonList$lambda$1(list, function1, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdSearch150ButtonList$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdSearch150ButtonList$lambda$0$0$0$0(Function1 $onButtonClick, int $index) {
        $onButtonClick.invoke(Integer.valueOf($index));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdSearch150ButtonList$lambda$0$0$1(String $label, RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C131@4981L275:AdSearch150Card.kt#swobc1");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-237963625, $changed, -1, "kntr.app.ad.ui.search.card150.AdSearch150ButtonList.<anonymous>.<anonymous>.<anonymous> (AdSearch150Card.kt:131)");
            }
            TextKt.Text-Nvy7gAk($label, (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(13), (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(18), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer, 1597440, 25008, 239534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}