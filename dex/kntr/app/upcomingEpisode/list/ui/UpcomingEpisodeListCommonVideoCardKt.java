package kntr.app.upcomingEpisode.list.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bapis.bilibili.community.interfacess.watch.v1.KArchiveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarCardType;
import com.bapis.bilibili.community.interfacess.watch.v1.KLiveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KLiveInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KUpInfo;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.list.model.CalendarCard;
import kntr.app.upcomingEpisode.list.model.CardUiType;
import kntr.app.upcomingEpisode.list.utils.UpcomingEpisodeExtensionsKt;
import kntr.app.upcomingEpisode.list.utils.UpcomingEpisodeUtilsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UpcomingEpisodeListCommonVideoCard.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\u001aW\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\f\u001a\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0015\u001a1\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010\u001e\u001a)\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u001bH\u0003¢\u0006\u0002\u0010\"\u001aG\u0010#\u001a\u00020\u00012\b\u0010$\u001a\u0004\u0018\u00010\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010\u001b2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010\u001bH\u0003¢\u0006\u0002\u0010*¨\u0006+"}, d2 = {"UpcomingEpisodeListCommonVideoCard", "", "card", "Lkntr/app/upcomingEpisode/list/model/CalendarCard;", "cardUiType", "Lkntr/app/upcomingEpisode/list/model/CardUiType;", "modifier", "Landroidx/compose/ui/Modifier;", "onAuthorLayoutClick", "Lkotlin/Function0;", "onThreePointClick", "onCardClick", "(Lkntr/app/upcomingEpisode/list/model/CalendarCard;Lkntr/app/upcomingEpisode/list/model/CardUiType;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "getTitleStyle", "Landroidx/compose/ui/text/TextStyle;", "(Lkntr/app/upcomingEpisode/list/model/CardUiType;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "getTitleColor", "Landroidx/compose/ui/graphics/Color;", "(Lkntr/app/upcomingEpisode/list/model/CardUiType;Landroidx/compose/runtime/Composer;I)J", "getTitleFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "(Lkntr/app/upcomingEpisode/list/model/CardUiType;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/font/FontWeight;", "SetTitle", "cardTUiType", "cardType", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarCardType;", "videoTitle", "", "isVideoPlaying", "", "(Lkntr/app/upcomingEpisode/list/model/CardUiType;Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarCardType;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "SetViewsAndDanmakuInfo", "viewCount", "danmaku", "(Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarCardType;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "SetCover", "ugcCover", "liveCover", "videoTime", "liveStatus", "", "liveEndText", "(Ljava/lang/String;Ljava/lang/String;Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarCardType;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpcomingEpisodeListCommonVideoCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetCover$lambda$1(String str, String str2, KCalendarCardType kCalendarCardType, String str3, Long l, String str4, int i, Composer composer, int i2) {
        SetCover(str, str2, kCalendarCardType, str3, l, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetTitle$lambda$1(CardUiType cardUiType, KCalendarCardType kCalendarCardType, String str, boolean z, int i, int i2, Composer composer, int i3) {
        SetTitle(cardUiType, kCalendarCardType, str, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetViewsAndDanmakuInfo$lambda$1(KCalendarCardType kCalendarCardType, String str, String str2, int i, Composer composer, int i2) {
        SetViewsAndDanmakuInfo(kCalendarCardType, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListCommonVideoCard$lambda$4(CalendarCard calendarCard, CardUiType cardUiType, Modifier modifier, Function0 function0, Function0 function02, Function0 function03, int i, int i2, Composer composer, int i3) {
        UpcomingEpisodeListCommonVideoCard(calendarCard, cardUiType, modifier, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v49 */
    /* JADX WARN: Type inference failed for: r14v18 */
    public static final void UpcomingEpisodeListCommonVideoCard(final CalendarCard card, final CardUiType cardUiType, Modifier modifier, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function04;
        Function0 onThreePointClick;
        Function0 onCardClick;
        int $dirty;
        Composer $composer2;
        Modifier modifier3;
        Function0 onAuthorLayoutClick;
        Function0 onAuthorLayoutClick2;
        Function0 onThreePointClick2;
        Function0 onCardClick2;
        long j;
        float f;
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(cardUiType, "cardUiType");
        Composer $composer3 = $composer.startRestartGroup(-328940494);
        ComposerKt.sourceInformation($composer3, "C(UpcomingEpisodeListCommonVideoCard)N(card,cardUiType,modifier,onAuthorLayoutClick,onThreePointClick,onCardClick)61@2768L2,62@2808L2,63@2842L2,82@3529L4891:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(card) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(cardUiType.ordinal()) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            function04 = function0;
        } else if (($changed & 3072) == 0) {
            function04 = function0;
            $dirty2 |= $composer3.changedInstance(function04) ? 2048 : 1024;
        } else {
            function04 = function0;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= 24576;
            onThreePointClick = function02;
        } else if (($changed & 24576) == 0) {
            onThreePointClick = function02;
            $dirty2 |= $composer3.changedInstance(onThreePointClick) ? 16384 : 8192;
        } else {
            onThreePointClick = function02;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= 196608;
            onCardClick = function03;
        } else if ((196608 & $changed) == 0) {
            onCardClick = function03;
            $dirty2 |= $composer3.changedInstance(onCardClick) ? 131072 : 65536;
        } else {
            onCardClick = function03;
        }
        if ($composer3.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1715770452, "CC(remember):UpcomingEpisodeListCommonVideoCard.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListCommonVideoCardKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onAuthorLayoutClick2 = (Function0) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onAuthorLayoutClick2 = function04;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1715771732, "CC(remember):UpcomingEpisodeListCommonVideoCard.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListCommonVideoCardKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                onThreePointClick2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onThreePointClick2 = onThreePointClick;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1715772820, "CC(remember):UpcomingEpisodeListCommonVideoCard.kt#9igjgp");
                Object it$iv3 = $composer3.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListCommonVideoCardKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                onCardClick2 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onCardClick2 = onCardClick;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-328940494, $dirty2, -1, "kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListCommonVideoCard (UpcomingEpisodeListCommonVideoCard.kt:64)");
            }
            KLiveCardInfo liveCardInfo = card.getLiveCardInfo();
            final KLiveInfo liveInfo = liveCardInfo != null ? liveCardInfo.getLiveInfo() : null;
            final KArchiveCardInfo archiveCardInfo = card.getArchiveCardInfo();
            final KUpInfo upInfo = card.getUpInfo();
            final KCalendarCardType cardType = card.getCalendarCardType();
            final KLiveCardInfo liveCardInfo2 = card.getLiveCardInfo();
            if (cardUiType == CardUiType.TYPE_DIM) {
                $composer3.startReplaceGroup(1715782391);
                ComposerKt.sourceInformation($composer3, "71@3134L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(1715783287);
                ComposerKt.sourceInformation($composer3, "71@3162L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            final long upNameColor = j;
            float f2 = archiveCardInfo != null && archiveCardInfo.isUnread() ? Dp.constructor-impl(6) : Dp.constructor-impl(8);
            float f3 = Dp.constructor-impl(8);
            if (archiveCardInfo != null && archiveCardInfo.isUnread()) {
                $dirty = $dirty2;
                f = Dp.constructor-impl(6);
            } else {
                $dirty = $dirty2;
                f = Dp.constructor-impl(8);
            }
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(f2, f3, Dp.constructor-impl(8), f);
            Modifier modifier$iv = ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(112)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            $composer2 = $composer3;
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
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -2016546777, "C111@4541L6,110@4482L88,113@4582L3832,102@4165L4249:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
            if (cardUiType == CardUiType.TYPE_HIGHLIGHT && UpcomingEpisodeExtensionsKt.isUgc(cardType)) {
                $composer3.startReplaceGroup(-2016617427);
                ComposerKt.sourceInformation($composer3, "97@4077L6,91@3805L305");
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(8), 0.0f, 0.0f, Dp.constructor-impl(8), 6, (Object) null)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null), $composer3, 0);
            } else {
                $composer3.startReplaceGroup(-2020389290);
            }
            $composer3.endReplaceGroup();
            final Function0 function05 = onAuthorLayoutClick2;
            final Function0 function06 = onThreePointClick2;
            CardKt.Card(ClickableKt.clickable-oSLSa3U$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), archiveCardInfo != null && archiveCardInfo.isUnread() ? Dp.constructor-impl(2) : Dp.constructor-impl(0), 0.0f, 0.0f, 0.0f, 14, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, onCardClick2, 15, (Object) null), shape, CardDefaults.INSTANCE.cardColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2-0d7_KjU(), 0L, 0L, 0L, $composer3, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(604695098, true, new Function3() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListCommonVideoCardKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit UpcomingEpisodeListCommonVideoCard$lambda$3$0;
                    UpcomingEpisodeListCommonVideoCard$lambda$3$0 = UpcomingEpisodeListCommonVideoCardKt.UpcomingEpisodeListCommonVideoCard$lambda$3$0(archiveCardInfo, upInfo, upNameColor, function05, function06, liveCardInfo2, cardType, liveInfo, cardUiType, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return UpcomingEpisodeListCommonVideoCard$lambda$3$0;
                }
            }, $composer3, 54), $composer3, 196608, 24);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onAuthorLayoutClick = onAuthorLayoutClick2;
            onCardClick = onCardClick2;
            onThreePointClick = onThreePointClick2;
        } else {
            $dirty = $dirty2;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onAuthorLayoutClick = function04;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function07 = onAuthorLayoutClick;
            final Function0 function08 = onThreePointClick;
            final Function0 function09 = onCardClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListCommonVideoCardKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit UpcomingEpisodeListCommonVideoCard$lambda$4;
                    UpcomingEpisodeListCommonVideoCard$lambda$4 = UpcomingEpisodeListCommonVideoCardKt.UpcomingEpisodeListCommonVideoCard$lambda$4(CalendarCard.this, cardUiType, modifier5, function07, function08, function09, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UpcomingEpisodeListCommonVideoCard$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListCommonVideoCard$lambda$3$0(KArchiveCardInfo $archiveCardInfo, KUpInfo $upInfo, long $upNameColor, Function0 $onAuthorLayoutClick, Function0 $onThreePointClick, KLiveCardInfo $liveCardInfo, KCalendarCardType $cardType, KLiveInfo $liveInfo, CardUiType $cardUiType, ColumnScope $this$Card, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        String title;
        String view;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C115@4683L3721:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(604695098, $changed, -1, "kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListCommonVideoCard.<anonymous>.<anonymous> (UpcomingEpisodeListCommonVideoCard.kt:114)");
            }
            float startPadding = $archiveCardInfo != null && $archiveCardInfo.isUnread() ? Dp.constructor-impl(10) : Dp.constructor-impl(12);
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0(Modifier.Companion, startPadding, Dp.constructor-impl(8), Dp.constructor-impl(12), Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
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
            int i2 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$UpcomingEpisodeListCommonVideoCard_u24lambda_u243_u240_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1926963088, "C125@5015L1143,152@6175L40,153@6232L2158:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((438 >> 6) & 112) | 6;
            RowScope $this$UpcomingEpisodeListCommonVideoCard_u24lambda_u243_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -187008434, "C134@5383L306,143@5794L22,149@6100L6,142@5741L399:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
            UpcomingEpisodeUtilsKt.m1310SetUpIconNamewC_cr3g($upInfo != null ? $upInfo.getAvatar() : null, $upInfo != null ? $upInfo.getName() : null, $upNameColor, $onAuthorLayoutClick, RowScope.-CC.weight$default($this$UpcomingEpisodeListCommonVideoCard_u24lambda_u243_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, $composer, 0, 32);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getMore_vertical_fill_500($composer, 6), (String) null, ClickableKt.clickable-oSLSa3U$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), false, (String) null, (Role) null, (MutableInteractionSource) null, $onThreePointClick, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_weak-0d7_KjU(), $composer, Painter.$stable | 48, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            Modifier modifier$iv3 = ColumnScope.-CC.weight$default($this$UpcomingEpisodeListCommonVideoCard_u24lambda_u243_u240_u240, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv3 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Row = $changed$iv$iv3 << 6;
            int $changed$iv$iv$iv3 = ($i$f$Row & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((432 >> 6) & 112) | 6;
            RowScope $this$UpcomingEpisodeListCommonVideoCard_u24lambda_u243_u240_u240_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -698547017, "C163@6641L371,171@7033L39,173@7129L1243:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
            SetCover($archiveCardInfo != null ? $archiveCardInfo.getCover() : null, $liveCardInfo != null ? $liveCardInfo.getCover() : null, $cardType, $archiveCardInfo != null ? $archiveCardInfo.getDuration() : null, $liveInfo != null ? Long.valueOf($liveInfo.getLiveStatus()) : null, $liveInfo != null ? $liveInfo.getEndText() : null, $composer, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            Modifier modifier$iv4 = SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$UpcomingEpisodeListCommonVideoCard_u24lambda_u243_u240_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            int $i$f$Column = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, $i$f$Column);
            int $changed$iv$iv4 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -574232857, "C186@7643L148,191@7816L40,199@8175L175:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
            if (UpcomingEpisodeExtensionsKt.isUgc($cardType)) {
                title = $archiveCardInfo != null ? $archiveCardInfo.getTitle() : null;
            } else {
                title = $liveCardInfo != null ? $liveCardInfo.getTitle() : null;
            }
            SetTitle($cardUiType, $cardType, title, false, $composer, 0, 8);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(7)), $composer, 6);
            if (UpcomingEpisodeExtensionsKt.isUgc($cardType)) {
                view = $archiveCardInfo != null ? $archiveCardInfo.getView() : null;
            } else {
                view = $liveCardInfo != null ? $liveCardInfo.getView() : null;
            }
            String view2 = view;
            SetViewsAndDanmakuInfo($cardType, view2, $archiveCardInfo != null ? $archiveCardInfo.getDanmaku() : null, $composer, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final TextStyle getTitleStyle(CardUiType cardUiType, Composer $composer, int $changed) {
        TextStyle t14;
        ComposerKt.sourceInformationMarkerStart($composer, 1155580327, "C(getTitleStyle)N(cardUiType):UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1155580327, $changed, -1, "kntr.app.upcomingEpisode.list.ui.getTitleStyle (UpcomingEpisodeListCommonVideoCard.kt:214)");
        }
        if (cardUiType == CardUiType.TYPE_HIGHLIGHT) {
            $composer.startReplaceGroup(-1883831445);
            ComposerKt.sourceInformation($composer, "214@8573L9");
            t14 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14b();
        } else {
            $composer.startReplaceGroup(-1883830486);
            ComposerKt.sourceInformation($composer, "214@8603L9");
            t14 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14();
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return t14;
    }

    private static final long getTitleColor(CardUiType cardUiType, Composer $composer, int $changed) {
        long j;
        ComposerKt.sourceInformationMarkerStart($composer, 367859988, "C(getTitleColor)N(cardUiType):UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(367859988, $changed, -1, "kntr.app.upcomingEpisode.list.ui.getTitleColor (UpcomingEpisodeListCommonVideoCard.kt:219)");
        }
        if (cardUiType == CardUiType.TYPE_HIGHLIGHT) {
            $composer.startReplaceGroup(1326133945);
            ComposerKt.sourceInformation($composer, "219@8761L6");
            j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU();
        } else {
            $composer.startReplaceGroup(1326134841);
            ComposerKt.sourceInformation($composer, "219@8789L6");
            j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU();
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j;
    }

    private static final FontWeight getTitleFontWeight(CardUiType cardUiType, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -423074712, "C(getTitleFontWeight)N(cardUiType):UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-423074712, $changed, -1, "kntr.app.upcomingEpisode.list.ui.getTitleFontWeight (UpcomingEpisodeListCommonVideoCard.kt:223)");
        }
        FontWeight fontWeight = cardUiType == CardUiType.TYPE_HIGHLIGHT ? new FontWeight(500) : null;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return fontWeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x034e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SetTitle(final CardUiType cardTUiType, final KCalendarCardType cardType, final String videoTitle, boolean isVideoPlaying, Composer $composer, final int $changed, final int i) {
        boolean isVideoPlaying2;
        int $dirty;
        boolean isVideoPlaying3;
        Function0 factory$iv$iv$iv;
        Modifier modifier$iv$iv;
        CompositionLocalMap localMap$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer2;
        Composer $composer$iv$iv;
        Composer $composer3 = $composer.startRestartGroup(354347780);
        ComposerKt.sourceInformation($composer3, "C(SetTitle)N(cardTUiType,cardType,videoTitle,isVideoPlaying)233@9141L3357:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(cardTUiType.ordinal()) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(cardType) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(videoTitle) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= 3072;
            isVideoPlaying2 = isVideoPlaying;
        } else if (($changed & 3072) == 0) {
            isVideoPlaying2 = isVideoPlaying;
            $dirty2 |= $composer3.changed(isVideoPlaying2) ? 2048 : 1024;
        } else {
            isVideoPlaying2 = isVideoPlaying;
        }
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer3.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                isVideoPlaying3 = false;
            } else {
                isVideoPlaying3 = isVideoPlaying2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(354347780, $dirty2, -1, "kntr.app.upcomingEpisode.list.ui.SetTitle (UpcomingEpisodeListCommonVideoCard.kt:232)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(40));
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((54 >> 6) & 112) | 6;
            BoxScope $this$SetTitle_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1030219626, "C:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
            if (!isVideoPlaying3) {
                modifier$iv$iv = modifier$iv;
                localMap$iv$iv = localMap$iv$iv2;
            } else if (!UpcomingEpisodeExtensionsKt.isUgc(cardType)) {
                modifier$iv$iv = modifier$iv;
                localMap$iv$iv = localMap$iv$iv2;
            } else {
                $composer3.startReplaceGroup(-1030180040);
                ComposerKt.sourceInformation($composer3, "292@11550L26,293@11607L31,294@11664L26,286@11320L548");
                AnnotatedString.Builder $this$SetTitle_u24lambda_u240_u240 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                InlineTextContentKt.appendInlineContent($this$SetTitle_u24lambda_u240_u240, "viewIcon", " ");
                $this$SetTitle_u24lambda_u240_u240.append(videoTitle);
                AnnotatedString annotatedString = $this$SetTitle_u24lambda_u240_u240.toAnnotatedString();
                Map inlineContent = MapsKt.mapOf(TuplesKt.to("viewIcon", new InlineTextContent(new Placeholder(TextUnitKt.getSp(20), TextUnitKt.getSp(16), PlaceholderVerticalAlign.Companion.getCenter-J6kI3mc(), (DefaultConstructorMarker) null), ComposableSingletons$UpcomingEpisodeListCommonVideoCardKt.INSTANCE.getLambda$609461443$main_debug())));
                TextKt.Text-Z58ophY(annotatedString, $this$SetTitle_u24lambda_u240.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getTopStart()), getTitleColor(cardTUiType, $composer3, $dirty2 & 14), (TextAutoSize) null, 0L, (FontStyle) null, getTitleFontWeight(cardTUiType, $composer3, $dirty2 & 14), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), true, 2, 0, inlineContent, (Function1) null, getTitleStyle(cardTUiType, $composer3, $dirty2 & 14), $composer3, 0, 28032, 167864);
                $composer3.endReplaceGroup();
                $dirty = $dirty2;
                $composer$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
                $composer2 = $composer3;
                $composer$iv$iv = $composer3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                isVideoPlaying2 = isVideoPlaying3;
            }
            $composer3.startReplaceGroup(-1027762660);
            ComposerKt.sourceInformation($composer3, "");
            if (videoTitle == null) {
                $composer3.startReplaceGroup(-1027762661);
                $composer3.endReplaceGroup();
                $dirty = $dirty2;
                $composer$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
                $composer2 = $composer3;
                $composer$iv$iv = $composer3;
            } else {
                $composer3.startReplaceGroup(-1027762660);
                ComposerKt.sourceInformation($composer3, "*307@12122L26,308@12183L31,309@12244L26,302@11932L536");
                $composer$iv = $composer3;
                $dirty = $dirty2;
                $composer$iv$iv$iv = $composer3;
                $composer2 = $composer3;
                $composer$iv$iv = $composer3;
                TextKt.Text-Nvy7gAk(videoTitle, $this$SetTitle_u24lambda_u240.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getTopStart()), getTitleColor(cardTUiType, $composer3, $dirty2 & 14), (TextAutoSize) null, 0L, (FontStyle) null, getTitleFontWeight(cardTUiType, $composer3, $dirty2 & 14), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), true, 2, 0, (Function1) null, getTitleStyle(cardTUiType, $composer3, $dirty2 & 14), $composer2, 0, 28032, 102328);
                $composer2.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
            }
            isVideoPlaying2 = isVideoPlaying3;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z = isVideoPlaying2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListCommonVideoCardKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit SetTitle$lambda$1;
                    SetTitle$lambda$1 = UpcomingEpisodeListCommonVideoCardKt.SetTitle$lambda$1(CardUiType.this, cardType, videoTitle, z, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SetTitle$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0670, code lost:
        if ((!kotlin.text.StringsKt.isBlank(r117)) == true) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x08aa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x08d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SetViewsAndDanmakuInfo(final KCalendarCardType cardType, final String viewCount, final String danmaku, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        boolean z;
        Composer $composer$iv$iv$iv;
        String str;
        String str2;
        Composer $composer$iv;
        Composer $composer3;
        String str3;
        String str4;
        Composer $composer$iv2;
        String str5;
        Composer $composer4;
        Composer $composer$iv$iv$iv2;
        String str6;
        int i;
        Composer $composer$iv$iv;
        int $dirty;
        Composer $composer$iv3;
        Composer $composer5;
        Composer $composer$iv4;
        Composer $composer$iv$iv$iv3;
        Composer $composer$iv$iv$iv4;
        Composer $composer6;
        Composer $composer$iv5;
        Composer $composer7;
        Function0 factory$iv$iv$iv3;
        Painter painter;
        Composer $composer8 = $composer.startRestartGroup(-338308695);
        ComposerKt.sourceInformation($composer8, "C(SetViewsAndDanmakuInfo)N(cardType,viewCount,danmaku)327@12650L2871:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer8.changedInstance(cardType) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer8.changed(viewCount) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer8.changed(danmaku) ? 256 : 128;
        }
        int $dirty3 = $dirty2;
        if ($composer8.shouldExecute(($dirty3 & 147) != 146, $dirty3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-338308695, $dirty3, -1, "kntr.app.upcomingEpisode.list.ui.SetViewsAndDanmakuInfo (UpcomingEpisodeListCommonVideoCard.kt:326)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            ComposerKt.sourceInformationMarkerStart($composer8, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer8, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
            CompositionLocalMap localMap$iv$iv = $composer8.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer8, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer8.startReusableNode();
            if ($composer8.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer8.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer8.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer8);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer8, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i3 = ((438 >> 6) & 112) | 6;
            RowScope $this$SetViewsAndDanmakuInfo_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer8, 1586959008, "C336@12908L1354:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
            boolean isLive = UpcomingEpisodeExtensionsKt.isLive(cardType);
            Modifier modifier$iv2 = SizeKt.wrapContentWidth$default(Modifier.Companion, (Alignment.Horizontal) null, false, 3, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer8, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer8, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer8.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer8, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer8.startReusableNode();
            if ($composer8.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer8.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer8.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer8);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer8, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer8, -433127150, "C:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
            if (viewCount != null && (!StringsKt.isBlank(viewCount))) {
                z = true;
                if (!z) {
                    $composer8.startReplaceGroup(-433091594);
                    ComposerKt.sourceInformation($composer8, "345@13212L671,361@13900L39,365@14063L9,366@14116L6,363@13981L200,369@14198L40");
                    Modifier modifier$iv3 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16));
                    Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer8, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv3 = (54 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer8.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer8, modifier$iv3);
                    Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer8, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer8.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer8.startReusableNode();
                    if ($composer8.getInserting()) {
                        $composer8.createNode(factory$iv$iv$iv6);
                    } else {
                        $composer8.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer8);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer8, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i7 = ((54 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer8, 2092945941, "C358@13823L6,349@13389L476:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
                    if (isLive) {
                        $composer8.startReplaceGroup(2093013520);
                        ComposerKt.sourceInformation($composer8, "352@13516L19");
                        Painter eye_browse_line_500 = BiliIconfont.INSTANCE.getEye_browse_line_500($composer8, 6);
                        $composer8.endReplaceGroup();
                        painter = eye_browse_line_500;
                    } else {
                        $composer8.startReplaceGroup(2093114859);
                        ComposerKt.sourceInformation($composer8, "354@13618L24");
                        Painter playdata_square_line_500 = BiliIconfont.INSTANCE.getPlaydata_square_line_500($composer8, 6);
                        $composer8.endReplaceGroup();
                        painter = playdata_square_line_500;
                    }
                    IconKt.Icon-ww6aTOc(painter, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getGraph_medium-0d7_KjU(), $composer8, Painter.$stable | 432, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    $composer8.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer8, 6);
                    $composer$iv$iv$iv = $composer8;
                    $composer$iv$iv$iv2 = $composer8;
                    $composer$iv$iv = $composer8;
                    str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    $composer$iv = $composer8;
                    $composer$iv2 = $composer8;
                    str6 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                    $dirty = $dirty3;
                    $composer2 = $composer8;
                    str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    str4 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                    str5 = "C:UpcomingEpisodeListCommonVideoCard.kt#kr57tx";
                    $composer4 = $composer8;
                    $composer$iv3 = $composer8;
                    str = "C101@5233L9:Row.kt#2w3rfo";
                    TextKt.Text-Nvy7gAk(viewCount, (Modifier) null, BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer8, BiliTheme.$stable).getT12(), $composer8, ($dirty3 >> 3) & 14, 24576, 114682);
                    $composer3 = $composer8;
                    i = 6;
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer3, 6);
                } else {
                    $composer$iv$iv$iv = $composer8;
                    str = "C101@5233L9:Row.kt#2w3rfo";
                    str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    $composer$iv = $composer8;
                    $composer3 = $composer8;
                    str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    str4 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                    $composer$iv2 = $composer8;
                    str5 = "C:UpcomingEpisodeListCommonVideoCard.kt#kr57tx";
                    $composer4 = $composer8;
                    $composer$iv$iv$iv2 = $composer8;
                    str6 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                    i = 6;
                    $composer$iv$iv = $composer8;
                    $dirty = $dirty3;
                    $composer2 = $composer8;
                    $composer$iv3 = $composer8;
                    $composer3.startReplaceGroup(-446189807);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer8);
                ComposerKt.sourceInformationMarkerEnd($composer8);
                if (isLive) {
                    Composer $composer9 = $composer4;
                    $composer9.startReplaceGroup(1588318822);
                    ComposerKt.sourceInformation($composer9, "373@14298L1207");
                    Modifier modifier$iv4 = RowScope.-CC.weight$default($this$SetViewsAndDanmakuInfo_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
                    Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer9, 844473419, str6);
                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer9, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv4 = (384 << 3) & 112;
                    String str7 = str3;
                    ComposerKt.sourceInformationMarkerStart($composer9, -1159599143, str7);
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer9, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer9.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer9, modifier$iv4);
                    Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | i;
                    String str8 = str2;
                    ComposerKt.sourceInformationMarkerStart($composer9, -553112988, str8);
                    if (!($composer9.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer9.startReusableNode();
                    if ($composer9.getInserting()) {
                        $composer9.createNode(factory$iv$iv$iv7);
                    } else {
                        $composer9.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer9);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                    int i8 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer9, 1456264949, str);
                    RowScope rowScope2 = RowScopeInstance.INSTANCE;
                    int i9 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer9, 1478466928, str5);
                    boolean z2 = danmaku != null;
                    if (z2) {
                        $composer9.startReplaceGroup(1478500562);
                        ComposerKt.sourceInformation($composer9, "381@14578L509,392@15108L39,396@15285L9,397@15342L6,394@15197L276");
                        Modifier modifier$iv5 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16));
                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer9, 1042775818, str4);
                        MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv5 = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer9, -1159599143, str7);
                        int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer9, 0));
                        CompositionLocalMap localMap$iv$iv5 = $composer9.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer9, modifier$iv5);
                        Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                        $composer$iv$iv$iv4 = $composer9;
                        ComposerKt.sourceInformationMarkerStart($composer9, -553112988, str8);
                        if (!($composer9.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer9.startReusableNode();
                        if ($composer9.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv8;
                            $composer9.createNode(factory$iv$iv$iv3);
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv8;
                            $composer9.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer9);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                        int i10 = ($changed$iv$iv$iv5 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer9, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i11 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer9, 1443010192, "C386@14828L28,389@15019L6,385@14771L294:UpcomingEpisodeListCommonVideoCard.kt#kr57tx");
                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getDanmu_flying_square_line_300($composer9, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getGraph_medium-0d7_KjU(), $composer9, Painter.$stable | 432, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer9);
                        ComposerKt.sourceInformationMarkerEnd($composer9);
                        $composer9.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer9);
                        ComposerKt.sourceInformationMarkerEnd($composer9);
                        ComposerKt.sourceInformationMarkerEnd($composer9);
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer9, 6);
                        $composer$iv$iv$iv3 = $composer9;
                        $composer6 = $composer9;
                        $composer$iv4 = $composer9;
                        $composer$iv5 = $composer9;
                        TextKt.Text-Nvy7gAk(danmaku, (Modifier) null, BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer9, BiliTheme.$stable).getT12(), $composer9, ($dirty >> 6) & 14, 24960, 110586);
                        $composer9.endReplaceGroup();
                        $composer7 = $composer9;
                    } else {
                        $composer$iv4 = $composer9;
                        $composer$iv$iv$iv3 = $composer9;
                        $composer$iv$iv$iv4 = $composer9;
                        $composer6 = $composer9;
                        $composer$iv5 = $composer9;
                        $composer7 = $composer9;
                        $composer7.startReplaceGroup(1464058902);
                        $composer7.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                    $composer$iv$iv$iv3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    $composer6.endReplaceGroup();
                    $composer5 = $composer6;
                } else {
                    $composer5 = $composer4;
                    $composer5.startReplaceGroup(1574109941);
                    $composer5.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv$iv$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            z = false;
            if (!z) {
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer8);
            ComposerKt.sourceInformationMarkerEnd($composer8);
            if (isLive) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer8;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListCommonVideoCardKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit SetViewsAndDanmakuInfo$lambda$1;
                    SetViewsAndDanmakuInfo$lambda$1 = UpcomingEpisodeListCommonVideoCardKt.SetViewsAndDanmakuInfo$lambda$1(cardType, viewCount, danmaku, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SetViewsAndDanmakuInfo$lambda$1;
                }
            });
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -95
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    private static final void SetCover(java.lang.String r157, java.lang.String r158, com.bapis.bilibili.community.interfacess.watch.v1.KCalendarCardType r159, java.lang.String r160, java.lang.Long r161, java.lang.String r162, androidx.compose.runtime.Composer r163, int r164) {
        /*
            Method dump skipped, instructions count: 2726
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListCommonVideoCardKt.SetCover(java.lang.String, java.lang.String, com.bapis.bilibili.community.interfacess.watch.v1.KCalendarCardType, java.lang.String, java.lang.Long, java.lang.String, androidx.compose.runtime.Composer, int):void");
    }
}