package kntr.app.deepsearch.ui.cards;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextPainterKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.broadcast.message.deepsearch.KCardItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCard;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Map;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.ui.config.PreviewConfig;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Card.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001aW\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0012\u0010\u0010\u001a\u00020\f*\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0003\u001a\u001f\u0010\u0012\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010\u0016\u001a#\u0010!\u001a\u00020\f*\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010\u00032\u0006\u0010#\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010$\u001a\u0019\u0010%\u001a\u00020\f*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010&\"@\u0010\u0017\u001a'\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00150\u0019\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001c0\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Card", RoomRecommendViewModel.EMPTY_CURSOR, "item", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KCardItem;", "lastItem", "dispatcher", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "modifier", "Landroidx/compose/ui/Modifier;", "embed", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KCardItem;Lcom/bapis/bilibili/broadcast/message/deepsearch/KCardItem;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "embedPaddingStart", "cardItem", "Empty", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KCardItem$ICardItem;", "type", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KCardItem$KCardType;", "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KCardItem$ICardItem;Lcom/bapis/bilibili/broadcast/message/deepsearch/KCardItem$KCardType;Landroidx/compose/runtime/Composer;I)V", "margins", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/Pair;", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/runtime/Composable;", "getMargins", "()Ljava/util/Map;", "margins$delegate", "Lkotlin/Lazy;", "marginBetween", "up", "down", "(Landroidx/compose/ui/Modifier;Lcom/bapis/bilibili/broadcast/message/deepsearch/KCardItem;Lcom/bapis/bilibili/broadcast/message/deepsearch/KCardItem;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "drawType", "(Landroidx/compose/ui/Modifier;Lcom/bapis/bilibili/broadcast/message/deepsearch/KCardItem;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CardKt {
    private static final Lazy margins$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.deepsearch.ui.cards.CardKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            Map margins_delegate$lambda$0;
            margins_delegate$lambda$0 = CardKt.margins_delegate$lambda$0();
            return margins_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Card$lambda$0(KCardItem kCardItem, KCardItem kCardItem2, Function1 function1, String str, String str2, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        Card(kCardItem, kCardItem2, function1, str, str2, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Empty$lambda$1(KCardItem.ICardItem iCardItem, KCardItem.KCardType kCardType, int i, Composer composer, int i2) {
        Empty(iCardItem, kCardType, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void Card(final KCardItem item, final KCardItem lastItem, final Function1<? super DeepSearchAction, Unit> function1, final String sessionId, final String queryId, Modifier modifier, boolean embed, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Modifier modifier3;
        boolean embed2;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(function1, "dispatcher");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        Composer $composer2 = $composer.startRestartGroup(-254157075);
        ComposerKt.sourceInformation($composer2, "C(Card)N(item,lastItem,dispatcher,sessionId,queryId,modifier,embed)32@1204L29,32@1234L14:Card.kt#pp6rt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(lastItem) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(sessionId) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(queryId) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty |= 1572864;
            z = embed;
        } else if ((1572864 & $changed) == 0) {
            z = embed;
            $dirty |= $composer2.changed(z) ? 1048576 : 524288;
        } else {
            z = embed;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute((599187 & $dirty2) != 599186, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                embed2 = z;
            } else {
                embed2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-254157075, $dirty2, -1, "kntr.app.deepsearch.ui.cards.Card (Card.kt:31)");
            }
            Modifier modifierWithMargin = drawType(marginBetween(modifier4, lastItem, item, $composer2, (($dirty2 >> 15) & 14) | ($dirty2 & 112) | (($dirty2 << 6) & 896)), item, $composer2, ($dirty2 << 3) & 112);
            KCardItem.KAuthor cardItem = item.getCardItem();
            if (cardItem instanceof KCardItem.KAuthor) {
                $composer2.startReplaceGroup(568199105);
                ComposerKt.sourceInformation($composer2, "36@1332L212");
                modifier3 = modifier4;
                AuthorKt.Author(embed2, cardItem.getValue(), queryId, modifierWithMargin, function1, $composer2, (($dirty2 >> 18) & 14) | (($dirty2 >> 6) & 896) | (57344 & ($dirty2 << 6)), 0);
                $composer2.endReplaceGroup();
            } else {
                modifier3 = modifier4;
                if (!(cardItem instanceof KCardItem.KPictures)) {
                    if (cardItem instanceof KCardItem.KText) {
                        $composer2.startReplaceGroup(568216773);
                        ComposerKt.sourceInformation($composer2, "55@1885L184");
                        TextContentKt.TextContent(((KCardItem.KText) cardItem).getValue(), queryId, modifierWithMargin, function1, $composer2, (($dirty2 >> 9) & 112) | (($dirty2 << 3) & 7168), 0);
                        $composer2.endReplaceGroup();
                    } else if (cardItem instanceof KCardItem.KVideo) {
                        $composer2.startReplaceGroup(568224096);
                        ComposerKt.sourceInformation($composer2, "63@2114L179");
                        VideoKt.Video(((KCardItem.KVideo) cardItem).getValue(), queryId, modifierWithMargin, function1, $composer2, (($dirty2 >> 9) & 112) | (($dirty2 << 3) & 7168), 0);
                        $composer2.endReplaceGroup();
                    } else if (cardItem != null) {
                        $composer2.startReplaceGroup(568197500);
                        $composer2.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    } else {
                        $composer2.startReplaceGroup(568230261);
                        ComposerKt.sourceInformation($composer2, "70@2311L40");
                        Empty(cardItem, item.getCardType(), $composer2, 0);
                        $composer2.endReplaceGroup();
                    }
                } else {
                    $composer2.startReplaceGroup(568207462);
                    ComposerKt.sourceInformation($composer2, "45@1592L249");
                    PictureKt.Picture(((KCardItem.KPictures) cardItem).getValue(), function1, sessionId, queryId, modifierWithMargin, embed2, $composer2, (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896) | (($dirty2 >> 3) & 7168) | (($dirty2 >> 3) & 458752), 0);
                    $composer2.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            embed2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = embed2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.cards.CardKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit Card$lambda$0;
                    Card$lambda$0 = CardKt.Card$lambda$0(item, lastItem, function1, sessionId, queryId, modifier5, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Card$lambda$0;
                }
            });
        }
    }

    public static final Modifier embedPaddingStart(Modifier $this$embedPaddingStart, KCardItem cardItem) {
        Intrinsics.checkNotNullParameter($this$embedPaddingStart, "<this>");
        Intrinsics.checkNotNullParameter(cardItem, "cardItem");
        KCardItem.KPictures cardItem2 = cardItem.getCardItem();
        if (cardItem2 instanceof KCardItem.KPictures) {
            if (Intrinsics.areEqual(cardItem2.getValue().getSource(), KPictureCard.KSource.VIDEO.INSTANCE)) {
                return $this$embedPaddingStart;
            }
            return PaddingKt.padding-VpY3zN4$default($this$embedPaddingStart, Dp.constructor-impl(12), 0.0f, 2, (Object) null);
        }
        return PaddingKt.padding-VpY3zN4$default($this$embedPaddingStart, Dp.constructor-impl(12), 0.0f, 2, (Object) null);
    }

    private static final void Empty(final KCardItem.ICardItem item, final KCardItem.KCardType type, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-19896755);
        ComposerKt.sourceInformation($composer2, "C(Empty)N(item,type)92@2845L83,92@2824L104:Card.kt#pp6rt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(type) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-19896755, $dirty, -1, "kntr.app.deepsearch.ui.cards.Empty (Card.kt:91)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1940909312, "CC(remember):Card.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(item) | $composer2.changedInstance(type);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new CardKt$Empty$1$1(item, type, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(item, (Function2) it$iv, $composer2, $dirty & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.cards.CardKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit Empty$lambda$1;
                    Empty$lambda$1 = CardKt.Empty$lambda$1(item, type, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Empty$lambda$1;
                }
            });
        }
    }

    private static final Map<Pair<KCardItem.KCardType, KCardItem.KCardType>, Function2<Composer, Integer, Dp>> getMargins() {
        return (Map) margins$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map margins_delegate$lambda$0() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(TuplesKt.to(KCardItem.KCardType.TEXT.INSTANCE, KCardItem.KCardType.PICTURE.INSTANCE), new Function2() { // from class: kntr.app.deepsearch.ui.cards.CardKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                Dp margins_delegate$lambda$0$0;
                margins_delegate$lambda$0$0 = CardKt.margins_delegate$lambda$0$0((Composer) obj, ((Integer) obj2).intValue());
                return margins_delegate$lambda$0$0;
            }
        }), TuplesKt.to(TuplesKt.to(KCardItem.KCardType.AUTHOR.INSTANCE, KCardItem.KCardType.PICTURE.INSTANCE), new Function2() { // from class: kntr.app.deepsearch.ui.cards.CardKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                Dp margins_delegate$lambda$0$1;
                margins_delegate$lambda$0$1 = CardKt.margins_delegate$lambda$0$1((Composer) obj, ((Integer) obj2).intValue());
                return margins_delegate$lambda$0$1;
            }
        }), TuplesKt.to(TuplesKt.to(KCardItem.KCardType.TEXT.INSTANCE, KCardItem.KCardType.VIDEO.INSTANCE), new Function2() { // from class: kntr.app.deepsearch.ui.cards.CardKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                Dp margins_delegate$lambda$0$2;
                margins_delegate$lambda$0$2 = CardKt.margins_delegate$lambda$0$2((Composer) obj, ((Integer) obj2).intValue());
                return margins_delegate$lambda$0$2;
            }
        }), TuplesKt.to(TuplesKt.to(KCardItem.KCardType.VIDEO.INSTANCE, KCardItem.KCardType.TEXT.INSTANCE), new Function2() { // from class: kntr.app.deepsearch.ui.cards.CardKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2) {
                Dp margins_delegate$lambda$0$3;
                margins_delegate$lambda$0$3 = CardKt.margins_delegate$lambda$0$3((Composer) obj, ((Integer) obj2).intValue());
                return margins_delegate$lambda$0$3;
            }
        }), TuplesKt.to(TuplesKt.to(KCardItem.KCardType.PICTURE.INSTANCE, KCardItem.KCardType.TEXT.INSTANCE), new Function2() { // from class: kntr.app.deepsearch.ui.cards.CardKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2) {
                Dp margins_delegate$lambda$0$4;
                margins_delegate$lambda$0$4 = CardKt.margins_delegate$lambda$0$4((Composer) obj, ((Integer) obj2).intValue());
                return margins_delegate$lambda$0$4;
            }
        })});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp margins_delegate$lambda$0$0(Composer $composer, int $changed) {
        $composer.startReplaceGroup(2101487814);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2101487814, $changed, -1, "kntr.app.deepsearch.ui.cards.margins$delegate.<anonymous>.<anonymous> (Card.kt:101)");
        }
        float f = Dp.constructor-impl(8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return Dp.box-impl(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp margins_delegate$lambda$0$1(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-592313435);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-592313435, $changed, -1, "kntr.app.deepsearch.ui.cards.margins$delegate.<anonymous>.<anonymous> (Card.kt:104)");
        }
        float f = Dp.constructor-impl(8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return Dp.box-impl(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp margins_delegate$lambda$0$2(Composer $composer, int $changed) {
        $composer.startReplaceGroup(1008852612);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1008852612, $changed, -1, "kntr.app.deepsearch.ui.cards.margins$delegate.<anonymous>.<anonymous> (Card.kt:107)");
        }
        float f = Dp.constructor-impl(12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return Dp.box-impl(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp margins_delegate$lambda$0$3(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-1684948637);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1684948637, $changed, -1, "kntr.app.deepsearch.ui.cards.margins$delegate.<anonymous>.<anonymous> (Card.kt:110)");
        }
        float f = Dp.constructor-impl(12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return Dp.box-impl(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp margins_delegate$lambda$0$4(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-83782590);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-83782590, $changed, -1, "kntr.app.deepsearch.ui.cards.margins$delegate.<anonymous>.<anonymous> (Card.kt:113)");
        }
        float f = Dp.constructor-impl(12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return Dp.box-impl(f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006f, code lost:
        if (r0 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Modifier marginBetween(Modifier $this$marginBetween, KCardItem up, KCardItem down, Composer $composer, int $changed) {
        Modifier modifier;
        ComposerKt.sourceInformationMarkerStart($composer, 1519763059, "C(marginBetween)N(up,down):Card.kt#pp6rt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1519763059, $changed, -1, "kntr.app.deepsearch.ui.cards.marginBetween (Card.kt:123)");
        }
        Dp dp = null;
        Function2<Composer, Integer, Dp> function2 = getMargins().get(TuplesKt.to(up != null ? up.getCardType() : null, down.getCardType()));
        if (function2 == null) {
            $composer.startReplaceGroup(2011149766);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(203423131);
            ComposerKt.sourceInformation($composer, "123@3715L8");
            float f = ((Dp) function2.invoke($composer, 0)).unbox-impl();
            $composer.endReplaceGroup();
            dp = Dp.box-impl(f);
        }
        if (dp != null) {
            float it = dp.unbox-impl();
            modifier = PaddingKt.padding-qDBjuR0$default($this$marginBetween, 0.0f, it, 0.0f, 0.0f, 13, (Object) null);
        }
        modifier = $this$marginBetween;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return modifier;
    }

    private static final Modifier drawType(Modifier $this$drawType, final KCardItem item, Composer $composer, int $changed) {
        Modifier modifier;
        ComposerKt.sourceInformationMarkerStart($composer, 2094054559, "C(drawType)N(item)130@3870L55:Card.kt#pp6rt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2094054559, $changed, -1, "kntr.app.deepsearch.ui.cards.drawType (Card.kt:128)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1953228074, "CC(remember):Card.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = Boolean.valueOf(PreviewConfig.INSTANCE.getShowType());
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        boolean showType = ((Boolean) it$iv).booleanValue();
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (showType) {
            $composer.startReplaceGroup(-420429971);
            ComposerKt.sourceInformation($composer, "134@3980L22,136@4045L9,137@4104L6,140@4218L6,145@4383L192");
            final TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer, 0, 1);
            TextStyle t22_cozy = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT22_cozy();
            long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU();
            long j3 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU();
            long v1$iv$iv = Float.floatToRawIntBits(3.0f);
            long v2$iv$iv = Float.floatToRawIntBits(3.0f);
            final TextStyle style = TextStyle.copy-p1EtxEg$default(t22_cozy, j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, new Shadow(j3, Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), 2.0f, (DefaultConstructorMarker) null), (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16769022, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1953211521, "CC(remember):Card.kt#9igjgp");
            boolean invalid$iv = $composer.changed(textMeasurer) | $composer.changedInstance(item) | $composer.changed(style);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.deepsearch.ui.cards.CardKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit drawType$lambda$1$0;
                        drawType$lambda$1$0 = CardKt.drawType$lambda$1$0(textMeasurer, item, style, (ContentDrawScope) obj);
                        return drawType$lambda$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            modifier = DrawModifierKt.drawWithContent($this$drawType, (Function1) it$iv2);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-419817969);
            $composer.endReplaceGroup();
            modifier = $this$drawType;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawType$lambda$1$0(TextMeasurer $textMeasurer, KCardItem $item, TextStyle $style, ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        TextPainterKt.drawText-TPWCCtM$default((DrawScope) $this$drawWithContent, $textMeasurer, $item.getCardType().getName(), 0L, $style, 0, false, 0, 0L, 0, 500, (Object) null);
        return Unit.INSTANCE;
    }
}