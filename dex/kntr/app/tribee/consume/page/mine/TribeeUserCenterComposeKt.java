package kntr.app.tribee.consume.page.mine;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
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
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
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
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
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
import com.bapis.bilibili.app.dynamic.v2.KGameStatsButton;
import com.bapis.bilibili.app.dynamic.v2.KNavigationEntry;
import com.bapis.bilibili.app.dynamic.v2.KNavigationEntryBasicInfo;
import com.bapis.bilibili.app.dynamic.v2.KNavigationEntryGameStats;
import com.bapis.bilibili.app.dynamic.v2.KNavigationEntryInviteCode;
import com.bapis.bilibili.app.dynamic.v2.KNavigationEntryJoinedOtherTribee;
import com.bapis.bilibili.app.dynamic.v2.KNavigationType;
import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDesc;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInteraction;
import com.bapis.bilibili.app.dynamic.v2.KTribeeNavigation;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.iconfont.BiliIconfontKt;
import com.bilibili.compose.theme.BiliColors;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.consume.TribeePreference;
import kntr.app.tribee.consume.page.TribeeDetailComposeKt;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.tribee.consume.viewmodel.track.TrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.net.comm.imp.InitGMultiDomainKt;
import kntr.base.router.Router;
import kntr.common.router.RouterKt;
import kntr.common.trio.p000switch.SimpleSwitchColors;
import kntr.common.trio.p000switch.SimpleSwitchKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: TribeeUserCenterCompose.kt */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a}\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0013\u001aq\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001aZ\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\nH\u0002\u001ag\u0010$\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u001a\b\u0002\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u001cH\u0003¢\u0006\u0002\u0010)\u001aW\u0010*\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001a\b\u0002\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u001cH\u0003¢\u0006\u0002\u0010+\u001a!\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010/\u001aM\u00100\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0003¢\u0006\u0002\u00101¨\u00062²\u0006\n\u0010\u001a\u001a\u00020\bX\u008a\u008e\u0002"}, d2 = {"TribeeUserCenterDrawer", "", "Landroidx/compose/foundation/layout/BoxScope;", "mine", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeNavigation;", "interaction", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInteraction;", "showDrawer", "", "onStateAction", "Lkotlin/Function1;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "onUIAction", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "modifier", "Landroidx/compose/ui/Modifier;", "onClickShare", "Lkotlin/Function0;", "dismissDrawer", "(Landroidx/compose/foundation/layout/BoxScope;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeNavigation;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInteraction;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "UserCenterPage", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeNavigation;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInteraction;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "joinedOtherItems", "Landroidx/compose/foundation/lazy/LazyListScope;", "colors", "Lcom/bilibili/compose/theme/BiliColors;", "isExpanded", "onClickItem", "Lkotlin/Function2;", "Lcom/bapis/bilibili/app/dynamic/v2/KNavigationType;", "", "basicInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KNavigationEntryBasicInfo;", "otherTribee", "Lcom/bapis/bilibili/app/dynamic/v2/KNavigationEntryJoinedOtherTribee;", "updateExpandStatus", "PlaceNormalItemByType", "entry", "Lcom/bapis/bilibili/app/dynamic/v2/KNavigationEntry;", "itemSectionPosition", "Lkntr/app/tribee/consume/page/mine/ItemSectionPosition;", "(Lkotlin/jvm/functions/Function1;Lcom/bapis/bilibili/app/dynamic/v2/KNavigationEntry;Lkntr/app/tribee/consume/page/mine/ItemSectionPosition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SimpleItem", "(Lkotlin/jvm/functions/Function1;Lcom/bapis/bilibili/app/dynamic/v2/KNavigationEntry;Lkntr/app/tribee/consume/page/mine/ItemSectionPosition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "GameStationItem", "desc", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeDesc;", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeDesc;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "RevisitSettings", "(Lcom/bapis/bilibili/app/dynamic/v2/KNavigationEntry;Lkntr/app/tribee/consume/page/mine/ItemSectionPosition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeUserCenterComposeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameStationItem$lambda$0(KTribeeDesc kTribeeDesc, Modifier modifier, int i, int i2, Composer composer, int i3) {
        GameStationItem(kTribeeDesc, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameStationItem$lambda$2(KTribeeDesc kTribeeDesc, Modifier modifier, int i, int i2, Composer composer, int i3) {
        GameStationItem(kTribeeDesc, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaceNormalItemByType$lambda$2(Function1 function1, KNavigationEntry kNavigationEntry, ItemSectionPosition itemSectionPosition, Modifier modifier, Function0 function0, Function2 function2, int i, int i2, Composer composer, int i3) {
        PlaceNormalItemByType(function1, kNavigationEntry, itemSectionPosition, modifier, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RevisitSettings$lambda$2(KNavigationEntry kNavigationEntry, ItemSectionPosition itemSectionPosition, Modifier modifier, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        RevisitSettings(kNavigationEntry, itemSectionPosition, modifier, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RevisitSettings$lambda$5(KNavigationEntry kNavigationEntry, ItemSectionPosition itemSectionPosition, Modifier modifier, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        RevisitSettings(kNavigationEntry, itemSectionPosition, modifier, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleItem$lambda$1(Function1 function1, KNavigationEntry kNavigationEntry, ItemSectionPosition itemSectionPosition, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        SimpleItem(function1, kNavigationEntry, itemSectionPosition, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleItem$lambda$6(Function1 function1, KNavigationEntry kNavigationEntry, ItemSectionPosition itemSectionPosition, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        SimpleItem(function1, kNavigationEntry, itemSectionPosition, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeUserCenterDrawer$lambda$6(BoxScope boxScope, KTribeeNavigation kTribeeNavigation, KTribeeInteraction kTribeeInteraction, boolean z, Function1 function1, Function1 function12, Modifier modifier, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        TribeeUserCenterDrawer(boxScope, kTribeeNavigation, kTribeeInteraction, z, function1, function12, modifier, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCenterPage$lambda$8(KTribeeNavigation kTribeeNavigation, KTribeeInteraction kTribeeInteraction, Function1 function1, Function1 function12, Modifier modifier, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        UserCenterPage(kTribeeNavigation, kTribeeInteraction, function1, function12, modifier, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r6v15 */
    public static final void TribeeUserCenterDrawer(final BoxScope $this$TribeeUserCenterDrawer, final KTribeeNavigation mine, final KTribeeInteraction interaction, final boolean showDrawer, final Function1<? super TribeeHomeStateAction, Unit> function1, final Function1<? super TribeeHomeUIAction, Unit> function12, Modifier modifier, Function0<Unit> function0, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
        Function0 function03;
        Composer $composer2;
        Modifier modifier2;
        Function0 dismissDrawer;
        Function0 dismissDrawer2;
        Function0 onClickShare;
        final Function0 dismissDrawer3;
        Intrinsics.checkNotNullParameter($this$TribeeUserCenterDrawer, "<this>");
        Intrinsics.checkNotNullParameter(mine, "mine");
        Intrinsics.checkNotNullParameter(function1, "onStateAction");
        Intrinsics.checkNotNullParameter(function12, "onUIAction");
        Composer $composer3 = $composer.startRestartGroup(1005774888);
        ComposerKt.sourceInformation($composer3, "C(TribeeUserCenterDrawer)N(mine,interaction,showDrawer,onStateAction,onUIAction,modifier,onClickShare,dismissDrawer)92@4389L2,93@4425L2,108@4789L361,95@4437L713,130@5495L6,135@5660L6,137@5689L544,120@5156L1077:TribeeUserCenterCompose.kt#x3q3r7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed($this$TribeeUserCenterDrawer) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(mine) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(interaction) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(showDrawer) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function12) ? 131072 : 65536;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= 1572864;
        } else if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changed(modifier) ? 1048576 : 524288;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty |= 12582912;
            function03 = function0;
        } else if ((12582912 & $changed) == 0) {
            function03 = function0;
            $dirty |= $composer3.changedInstance(function03) ? 8388608 : 4194304;
        } else {
            function03 = function0;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 67108864 : 33554432;
        }
        if ($composer3.shouldExecute(($dirty & 38347923) != 38347922, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 182035146, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda38
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onClickShare2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onClickShare = onClickShare2;
            } else {
                onClickShare = function03;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 182036298, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda39
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 dismissDrawer4 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                dismissDrawer3 = dismissDrawer4;
            } else {
                dismissDrawer3 = function02;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1005774888, $dirty, -1, "kntr.app.tribee.consume.page.mine.TribeeUserCenterDrawer (TribeeUserCenterCompose.kt:94)");
            }
            int $dirty2 = $dirty;
            final Function0 dismissDrawer5 = dismissDrawer3;
            AnimatedVisibilityKt.AnimatedVisibility(showDrawer, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(491097168, true, new Function3() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda40
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeUserCenterDrawer$lambda$2;
                    TribeeUserCenterDrawer$lambda$2 = TribeeUserCenterComposeKt.TribeeUserCenterDrawer$lambda$2(dismissDrawer3, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeUserCenterDrawer$lambda$2;
                }
            }, $composer3, 54), $composer3, 200112 | (($dirty >> 9) & 14), 16);
            Modifier align = $this$TribeeUserCenterDrawer.align(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(modifier3, Dp.constructor-impl(300)), 0.0f, 1, (Object) null), Alignment.Companion.getTopEnd());
            FiniteAnimationSpec tween$default = AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null);
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer2, 182070542, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda41
                    public final Object invoke(Object obj) {
                        int TribeeUserCenterDrawer$lambda$3$0;
                        TribeeUserCenterDrawer$lambda$3$0 = TribeeUserCenterComposeKt.TribeeUserCenterDrawer$lambda$3$0(((Integer) obj).intValue());
                        return Integer.valueOf(TribeeUserCenterDrawer$lambda$3$0);
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EnterTransition slideInHorizontally = EnterExitTransitionKt.slideInHorizontally(tween$default, (Function1) it$iv3);
            FiniteAnimationSpec tween$default2 = AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 182075822, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        int TribeeUserCenterDrawer$lambda$4$0;
                        TribeeUserCenterDrawer$lambda$4$0 = TribeeUserCenterComposeKt.TribeeUserCenterDrawer$lambda$4$0(((Integer) obj).intValue());
                        return Integer.valueOf(TribeeUserCenterDrawer$lambda$4$0);
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            modifier2 = modifier3;
            final Function0 function04 = onClickShare;
            Function0 onClickShare3 = onClickShare;
            AnimatedVisibilityKt.AnimatedVisibility(showDrawer, align, slideInHorizontally, EnterExitTransitionKt.slideOutHorizontally(tween$default2, (Function1) it$iv4), (String) null, ComposableLambdaKt.rememberComposableLambda(265364537, true, new Function3() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeUserCenterDrawer$lambda$5;
                    TribeeUserCenterDrawer$lambda$5 = TribeeUserCenterComposeKt.TribeeUserCenterDrawer$lambda$5($this$TribeeUserCenterDrawer, mine, interaction, function12, function1, function04, dismissDrawer5, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeUserCenterDrawer$lambda$5;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 9) & 14) | 200064, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            dismissDrawer = dismissDrawer5;
            dismissDrawer2 = onClickShare3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            dismissDrawer = function02;
            dismissDrawer2 = function03;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Function0 function05 = dismissDrawer2;
            final Function0 function06 = dismissDrawer;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeUserCenterDrawer$lambda$6;
                    TribeeUserCenterDrawer$lambda$6 = TribeeUserCenterComposeKt.TribeeUserCenterDrawer$lambda$6($this$TribeeUserCenterDrawer, mine, interaction, showDrawer, function1, function12, modifier4, function05, function06, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeUserCenterDrawer$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeUserCenterDrawer$lambda$2(final Function0 $dismissDrawer, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C114@5010L39,114@5070L63,109@4799L345:TribeeUserCenterCompose.kt#x3q3r7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(491097168, $changed, -1, "kntr.app.tribee.consume.page.mine.TribeeUserCenterDrawer.<anonymous> (TribeeUserCenterCompose.kt:109)");
        }
        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(BackgroundKt.background-bw27NRU$default(Modifier.Companion, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, -502017001, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = InteractionSourceKt.MutableInteractionSource();
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -502015057, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
        boolean invalid$iv = $composer.changed($dismissDrawer);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new Function0() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda37
                public final Object invoke() {
                    Unit TribeeUserCenterDrawer$lambda$2$1$0;
                    TribeeUserCenterDrawer$lambda$2$1$0 = TribeeUserCenterComposeKt.TribeeUserCenterDrawer$lambda$2$1$0($dismissDrawer);
                    return TribeeUserCenterDrawer$lambda$2$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BoxKt.Box(ClickableKt.clickable-O2vRcR0$default(fillMaxSize$default, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeUserCenterDrawer$lambda$2$1$0(Function0 $dismissDrawer) {
        $dismissDrawer.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int TribeeUserCenterDrawer$lambda$3$0(int it) {
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int TribeeUserCenterDrawer$lambda$4$0(int it) {
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeUserCenterDrawer$lambda$5(BoxScope $this_TribeeUserCenterDrawer, KTribeeNavigation $mine, KTribeeInteraction $interaction, Function1 $onUIAction, Function1 $onStateAction, Function0 $onClickShare, Function0 $dismissDrawer, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C145@5949L6,138@5699L528:TribeeUserCenterCompose.kt#x3q3r7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(265364537, $changed, -1, "kntr.app.tribee.consume.page.mine.TribeeUserCenterDrawer.<anonymous> (TribeeUserCenterCompose.kt:138)");
        }
        UserCenterPage($mine, $interaction, $onUIAction, $onStateAction, $this_TribeeUserCenterDrawer.align(WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(300)), 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2_float-0d7_KjU(), (Shape) null, 2, (Object) null)), Alignment.Companion.getTopEnd()), $onClickShare, $dismissDrawer, $composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r4v15 */
    public static final void UserCenterPage(final KTribeeNavigation mine, final KTribeeInteraction interaction, final Function1<? super TribeeHomeUIAction, Unit> function1, final Function1<? super TribeeHomeStateAction, Unit> function12, Modifier modifier, Function0<Unit> function0, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function03;
        Function0 dismissDrawer;
        Modifier modifier3;
        Function0 dismissDrawer2;
        Function0 onClickShare;
        Modifier modifier4;
        int $dirty;
        String str;
        Intrinsics.checkNotNullParameter(mine, "mine");
        Intrinsics.checkNotNullParameter(function1, "onUIAction");
        Intrinsics.checkNotNullParameter(function12, "onStateAction");
        Composer $composer2 = $composer.startRestartGroup(1212148686);
        ComposerKt.sourceInformation($composer2, "C(UserCenterPage)N(mine,interaction,onUIAction,onStateAction,modifier,onClickShare,dismissDrawer)163@6500L2,164@6536L2,166@6569L40,166@6548L61,170@6638L6,171@6667L34,172@6731L7,174@6797L1509,220@8359L3333,218@8312L3380:TribeeUserCenterCompose.kt#x3q3r7");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(mine) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(interaction) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function12) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty2 |= 196608;
            function03 = function0;
        } else if ((196608 & $changed) == 0) {
            function03 = function0;
            $dirty2 |= $composer2.changedInstance(function03) ? 131072 : 65536;
        } else {
            function03 = function0;
        }
        int i4 = i & 64;
        if (i4 != 0) {
            $dirty2 |= 1572864;
            dismissDrawer = function02;
        } else if (($changed & 1572864) == 0) {
            dismissDrawer = function02;
            $dirty2 |= $composer2.changedInstance(dismissDrawer) ? 1048576 : 524288;
        } else {
            dismissDrawer = function02;
        }
        if ($composer2.shouldExecute(($dirty2 & 599187) != 599186, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 938758064, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda30
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onClickShare2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onClickShare = onClickShare2;
            } else {
                onClickShare = function03;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 938759216, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda31
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 dismissDrawer3 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                dismissDrawer = dismissDrawer3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1212148686, $dirty2, -1, "kntr.app.tribee.consume.page.mine.UserCenterPage (TribeeUserCenterCompose.kt:165)");
            }
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 938760310, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new TribeeUserCenterComposeKt$UserCenterPage$3$1(null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv3, $composer2, 6);
            final BiliColors colors = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable);
            ComposerKt.sourceInformationMarkerStart($composer2, 938763440, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final MutableState isExpanded$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Router router = (Router) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 938769075, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            boolean invalid$iv = ((458752 & $dirty2) == 131072) | $composer2.changedInstance(router) | $composer2.changedInstance(interaction) | (($dirty2 & 896) == 256) | (($dirty2 & 7168) == 2048) | (($dirty2 & 3670016) == 1048576);
            Object value$iv5 = $composer2.rememberedValue();
            if (invalid$iv || value$iv5 == Composer.Companion.getEmpty()) {
                int $dirty3 = $dirty2;
                final Function0 function04 = onClickShare;
                $dirty = $dirty3;
                str = "CC(remember):TribeeUserCenterCompose.kt#9igjgp";
                final Function0 function05 = dismissDrawer;
                value$iv5 = new Function2() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda33
                    public final Object invoke(Object obj, Object obj2) {
                        Unit UserCenterPage$lambda$6$0;
                        UserCenterPage$lambda$6$0 = TribeeUserCenterComposeKt.UserCenterPage$lambda$6$0(function04, router, interaction, function12, function05, function1, (KNavigationType) obj, (String) obj2);
                        return UserCenterPage$lambda$6$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv5);
            } else {
                $dirty = $dirty2;
                str = "CC(remember):TribeeUserCenterCompose.kt#9igjgp";
            }
            final Function2 onClickItem = (Function2) value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 938820883, str);
            boolean invalid$iv2 = $composer2.changedInstance(mine) | (($dirty & 7168) == 2048) | (($dirty & 3670016) == 1048576) | $composer2.changed(onClickItem) | $composer2.changed(colors);
            Object value$iv6 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv6 == Composer.Companion.getEmpty()) {
                final Function0 function06 = dismissDrawer;
                value$iv6 = new Function1() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda34
                    public final Object invoke(Object obj) {
                        Unit UserCenterPage$lambda$7$0;
                        UserCenterPage$lambda$7$0 = TribeeUserCenterComposeKt.UserCenterPage$lambda$7$0(mine, colors, onClickItem, function12, function06, isExpanded$delegate, (LazyListScope) obj);
                        return UserCenterPage$lambda$7$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv6);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(modifier4, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv6, $composer2, ($dirty >> 12) & 14, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            dismissDrawer2 = dismissDrawer;
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            dismissDrawer2 = dismissDrawer;
            onClickShare = function03;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function07 = onClickShare;
            final Function0 function08 = dismissDrawer2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda35
                public final Object invoke(Object obj, Object obj2) {
                    Unit UserCenterPage$lambda$8;
                    UserCenterPage$lambda$8 = TribeeUserCenterComposeKt.UserCenterPage$lambda$8(mine, interaction, function1, function12, modifier5, function07, function08, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UserCenterPage$lambda$8;
                }
            });
        }
    }

    private static final boolean UserCenterPage$lambda$4(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void UserCenterPage$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCenterPage$lambda$6$0(Function0 $onClickShare, Router $router, KTribeeInteraction $interaction, Function1 $onStateAction, Function0 $dismissDrawer, Function1 $onUIAction, KNavigationType type, String jumpUri) {
        KToastDialog it;
        KGameStatsButton gameStats;
        Builder buildUpon;
        Builder appendQueryParameter;
        Uri p0;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(jumpUri, "jumpUri");
        if (Intrinsics.areEqual(type, KNavigationType.SHARE.INSTANCE)) {
            $onClickShare.invoke();
            TrackerKt.reportClickInMinePage("share");
        } else if (Intrinsics.areEqual(type, KNavigationType.JOINED_OTHER_TRIBEE.INSTANCE)) {
            TrackerKt.reportClickInMinePage("tribee");
            Uri uriOrNull = TribeeExtensionsKt.toUriOrNull(jumpUri);
            if (uriOrNull != null && (buildUpon = uriOrNull.buildUpon()) != null && (appendQueryParameter = buildUpon.appendQueryParameter("from_spmid", TribeeExtensionsKt.SPMID)) != null && (p0 = appendQueryParameter.build()) != null) {
                $router.launch(p0);
            }
        } else if (Intrinsics.areEqual(type, KNavigationType.MY_POST.INSTANCE)) {
            TrackerKt.reportClickInMinePage("post");
            Uri uri = TribeeExtensionsKt.toUriOrNull(jumpUri);
            if (uri != null) {
                $router.launch(uri);
            }
        } else if (Intrinsics.areEqual(type, KNavigationType.INVITE_CODE.INSTANCE)) {
            TrackerKt.reportClickInMinePage("invite_code");
            Uri uri2 = TribeeExtensionsKt.toUriOrNull(jumpUri);
            if (uri2 != null) {
                $router.launch(uri2);
            }
        } else if (Intrinsics.areEqual(type, KNavigationType.GAME_STATS.INSTANCE)) {
            TrackerKt.reportClickInMinePage("game_stats");
            boolean z = false;
            if ($interaction != null && (gameStats = $interaction.getGameStats()) != null && gameStats.getShowToast()) {
                z = true;
            }
            if (z) {
                KGameStatsButton gameStats2 = $interaction.getGameStats();
                if (gameStats2 != null && (it = gameStats2.getNoTribee()) != null) {
                    $onUIAction.invoke(new TribeeHomeUIAction.ToastDialog(it));
                }
            } else {
                Uri uri3 = TribeeExtensionsKt.toUriOrNull(jumpUri);
                if (uri3 != null) {
                    $router.launch(uri3);
                }
                $onStateAction.invoke(TribeeHomeStateAction.AwaitSteamBindResult.INSTANCE);
            }
        } else {
            Uri uri4 = TribeeExtensionsKt.toUriOrNull(jumpUri);
            if (uri4 != null) {
                $router.launch(uri4);
            }
        }
        $dismissDrawer.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCenterPage$lambda$7$0(final KTribeeNavigation $mine, BiliColors $colors, final Function2 $onClickItem, final Function1 $onStateAction, final Function0 $dismissDrawer, final MutableState $isExpanded$delegate, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        List $this$indexOfFirst$iv = $mine.getNavEntries();
        int index$iv = 0;
        Iterator it = $this$indexOfFirst$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                KNavigationEntry it2 = (KNavigationEntry) item$iv;
                if (Intrinsics.areEqual(it2.getNavigationType(), KNavigationType.JOINED_OTHER_TRIBEE.INSTANCE)) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        final int joinedEntryIndex = index$iv;
        KNavigationEntry kNavigationEntry = (KNavigationEntry) CollectionsKt.getOrNull($mine.getNavEntries(), joinedEntryIndex);
        KNavigationEntryBasicInfo joinedBasicInfo = kNavigationEntry != null ? kNavigationEntry.getBasicInfo() : null;
        KNavigationEntry kNavigationEntry2 = (KNavigationEntry) CollectionsKt.getOrNull($mine.getNavEntries(), joinedEntryIndex);
        KNavigationEntry.IData data = kNavigationEntry2 != null ? kNavigationEntry2.getData() : null;
        KNavigationEntry.KJoinedOtherTribee kJoinedOtherTribee = data instanceof KNavigationEntry.KJoinedOtherTribee ? (KNavigationEntry.KJoinedOtherTribee) data : null;
        KNavigationEntryJoinedOtherTribee joinedEntry = kJoinedOtherTribee != null ? kJoinedOtherTribee.getValue() : null;
        if (joinedEntryIndex >= 0 && joinedEntry != null && !joinedEntry.getTribeeList().isEmpty() && joinedBasicInfo != null) {
            for (int i = 0; i < joinedEntryIndex; i++) {
                final int index = i;
                final KNavigationEntry entry = (KNavigationEntry) CollectionsKt.getOrNull($mine.getNavEntries(), index);
                if (entry != null) {
                    LazyListScope.-CC.stickyHeader$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-902178570, true, new Function4() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            Unit UserCenterPage$lambda$7$0$1$0$0;
                            UserCenterPage$lambda$7$0$1$0$0 = TribeeUserCenterComposeKt.UserCenterPage$lambda$7$0$1$0$0($mine, index, entry, $onStateAction, $dismissDrawer, $onClickItem, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            return UserCenterPage$lambda$7$0$1$0$0;
                        }
                    }), 3, (Object) null);
                }
            }
            joinedOtherItems($this$LazyColumn, $colors, UserCenterPage$lambda$4($isExpanded$delegate), $onClickItem, joinedBasicInfo, joinedEntry, new Function1() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj) {
                    Unit UserCenterPage$lambda$7$0$2;
                    UserCenterPage$lambda$7$0$2 = TribeeUserCenterComposeKt.UserCenterPage$lambda$7$0$2($isExpanded$delegate, ((Boolean) obj).booleanValue());
                    return UserCenterPage$lambda$7$0$2;
                }
            });
            LazyListScope.-CC.items$default($this$LazyColumn, RangesKt.coerceAtLeast(($mine.getNavEntries().size() - 1) - joinedEntryIndex, 0), (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(2046203463, true, new Function4() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda32
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit UserCenterPage$lambda$7$0$3;
                    UserCenterPage$lambda$7$0$3 = TribeeUserCenterComposeKt.UserCenterPage$lambda$7$0$3(joinedEntryIndex, $mine, $onStateAction, $dismissDrawer, $onClickItem, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    return UserCenterPage$lambda$7$0$3;
                }
            }), 6, (Object) null);
        } else {
            Iterable $this$filter$iv = $mine.getNavEntries();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                KNavigationEntry it3 = (KNavigationEntry) element$iv$iv;
                if (!Intrinsics.areEqual(it3.getNavigationType(), KNavigationType.JOINED_OTHER_TRIBEE.INSTANCE)) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            final List commons = (List) destination$iv$iv;
            LazyListScope.-CC.items$default($this$LazyColumn, commons.size(), (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1427498512, true, new Function4() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda36
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit UserCenterPage$lambda$7$0$5;
                    UserCenterPage$lambda$7$0$5 = TribeeUserCenterComposeKt.UserCenterPage$lambda$7$0$5(commons, $mine, $onStateAction, $dismissDrawer, $onClickItem, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    return UserCenterPage$lambda$7$0$5;
                }
            }), 6, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCenterPage$lambda$7$0$1$0$0(KTribeeNavigation $mine, int $index, KNavigationEntry $entry, Function1 $onStateAction, Function0 $dismissDrawer, Function2 $onClickItem, LazyItemScope $this$stickyHeader, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$stickyHeader, "$this$stickyHeader");
        ComposerKt.sourceInformation($composer, "CN(it)230@9003L616:TribeeUserCenterCompose.kt#x3q3r7");
        if ($composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-902178570, $changed, -1, "kntr.app.tribee.consume.page.mine.UserCenterPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeUserCenterCompose.kt:230)");
            }
            PlaceNormalItemByType($onStateAction, $entry, MineMenuGroupUtil.INSTANCE.getSectionPosition((KNavigationEntry) CollectionsKt.getOrNull($mine.getNavEntries(), $index - 1), $entry, (KNavigationEntry) CollectionsKt.getOrNull($mine.getNavEntries(), $index + 1)), null, $dismissDrawer, $onClickItem, $composer, 0, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCenterPage$lambda$7$0$2(MutableState $isExpanded$delegate, boolean it) {
        UserCenterPage$lambda$5($isExpanded$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCenterPage$lambda$7$0$3(int $joinedEntryIndex, KTribeeNavigation $mine, Function1 $onStateAction, Function0 $dismissDrawer, Function2 $onClickItem, LazyItemScope $this$items, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(it):TribeeUserCenterCompose.kt#x3q3r7");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(it) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2046203463, $dirty2, -1, "kntr.app.tribee.consume.page.mine.UserCenterPage.<anonymous>.<anonymous>.<anonymous> (TribeeUserCenterCompose.kt:254)");
            }
            int index = it + $joinedEntryIndex + 1;
            KNavigationEntry entry = (KNavigationEntry) CollectionsKt.getOrNull($mine.getNavEntries(), index);
            if (entry == null) {
                $composer.startReplaceGroup(-23341367);
            } else {
                $composer.startReplaceGroup(-23341366);
                ComposerKt.sourceInformation($composer, "*256@10212L572");
                PlaceNormalItemByType($onStateAction, entry, MineMenuGroupUtil.INSTANCE.getSectionPosition((KNavigationEntry) CollectionsKt.getOrNull($mine.getNavEntries(), index - 1), entry, (KNavigationEntry) CollectionsKt.getOrNull($mine.getNavEntries(), index + 1)), null, $dismissDrawer, $onClickItem, $composer, 0, 8);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCenterPage$lambda$7$0$5(List $commons, KTribeeNavigation $mine, Function1 $onStateAction, Function0 $dismissDrawer, Function2 $onClickItem, LazyItemScope $this$items, int index, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index):TribeeUserCenterCompose.kt#x3q3r7");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1427498512, $dirty2, -1, "kntr.app.tribee.consume.page.mine.UserCenterPage.<anonymous>.<anonymous>.<anonymous> (TribeeUserCenterCompose.kt:273)");
            }
            KNavigationEntry entry = (KNavigationEntry) CollectionsKt.getOrNull($commons, index);
            if (entry == null) {
                $composer.startReplaceGroup(2137045248);
            } else {
                $composer.startReplaceGroup(2137045249);
                ComposerKt.sourceInformation($composer, "*274@11072L572");
                PlaceNormalItemByType($onStateAction, entry, MineMenuGroupUtil.INSTANCE.getSectionPosition((KNavigationEntry) CollectionsKt.getOrNull($mine.getNavEntries(), index - 1), entry, (KNavigationEntry) CollectionsKt.getOrNull($mine.getNavEntries(), index + 1)), null, $dismissDrawer, $onClickItem, $composer, 0, 8);
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

    private static final void joinedOtherItems(LazyListScope $this$joinedOtherItems, final BiliColors colors, final boolean isExpanded, final Function2<? super KNavigationType, ? super String, Unit> function2, final KNavigationEntryBasicInfo basicInfo, final KNavigationEntryJoinedOtherTribee otherTribee, final Function1<? super Boolean, Unit> function1) {
        final int itemsCount;
        final List tribeeList = otherTribee.getTribeeList();
        LazyListScope.-CC.stickyHeader$default($this$joinedOtherItems, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1225299701, true, new Function4() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda12
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit joinedOtherItems$lambda$0;
                joinedOtherItems$lambda$0 = TribeeUserCenterComposeKt.joinedOtherItems$lambda$0(colors, function1, isExpanded, basicInfo, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return joinedOtherItems$lambda$0;
            }
        }), 3, (Object) null);
        final boolean showExpand = tribeeList.size() > 3;
        if (isExpanded) {
            itemsCount = tribeeList.size();
        } else {
            itemsCount = RangesKt.coerceAtMost(tribeeList.size(), 3);
        }
        LazyListScope.-CC.items$default($this$joinedOtherItems, itemsCount, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-571201448, true, new Function4() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda13
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit joinedOtherItems$lambda$1;
                joinedOtherItems$lambda$1 = TribeeUserCenterComposeKt.joinedOtherItems$lambda$1(tribeeList, showExpand, itemsCount, colors, function2, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return joinedOtherItems$lambda$1;
            }
        }), 6, (Object) null);
        if (showExpand) {
            LazyListScope.-CC.item$default($this$joinedOtherItems, "toExpand", (Object) null, ComposableLambdaKt.composableLambdaInstance(1616174470, true, new Function3() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit joinedOtherItems$lambda$2;
                    joinedOtherItems$lambda$2 = TribeeUserCenterComposeKt.joinedOtherItems$lambda$2(colors, function1, isExpanded, otherTribee, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return joinedOtherItems$lambda$2;
                }
            }), 2, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit joinedOtherItems$lambda$0(final BiliColors $colors, final Function1 $updateExpandStatus, final boolean $isExpanded, KNavigationEntryBasicInfo $basicInfo, LazyItemScope $this$stickyHeader, int it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$stickyHeader, "$this$stickyHeader");
        ComposerKt.sourceInformation($composer, "CN(it)310@12340L903,328@13293L39,328@13334L79,303@12094L2221:TribeeUserCenterCompose.kt#x3q3r7");
        if ($composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1225299701, $changed, -1, "kntr.app.tribee.consume.page.mine.joinedOtherItems.<anonymous> (TribeeUserCenterCompose.kt:303)");
            }
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(4), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(44));
            ComposerKt.sourceInformationMarkerStart($composer, 691982652, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            boolean invalid$iv = $composer.changed($colors);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda23
                    public final Object invoke(Object obj) {
                        Unit joinedOtherItems$lambda$0$0$0;
                        joinedOtherItems$lambda$0$0$0 = TribeeUserCenterComposeKt.joinedOtherItems$lambda$0$0$0($colors, (DrawScope) obj);
                        return joinedOtherItems$lambda$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier drawBehind = DrawModifierKt.drawBehind(modifier, (Function1) it$iv);
            ComposerKt.sourceInformationMarkerStart($composer, 692012284, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 692013636, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($updateExpandStatus) | $composer.changed($isExpanded);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda24
                    public final Object invoke() {
                        Unit joinedOtherItems$lambda$0$2$0;
                        joinedOtherItems$lambda$0$2$0 = TribeeUserCenterComposeKt.joinedOtherItems$lambda$0$2$0($updateExpandStatus, $isExpanded);
                        return joinedOtherItems$lambda$0$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(drawBehind, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((384 >> 6) & 112) | 6;
            RowScope $this$joinedOtherItems_u24lambda_u240_u243 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 515236068, "C333@13499L523,352@14150L6,349@14036L269:TribeeUserCenterCompose.kt#x3q3r7");
            $composer.startReplaceGroup(847906246);
            ComposerKt.sourceInformation($composer, "*338@13716L6");
            String $this$asRequest$iv = $basicInfo.getIcon();
            ImageRequest $this$joinedOtherItems_u24lambda_u240_u243_u240 = new ImageRequest($this$asRequest$iv);
            $this$joinedOtherItems_u24lambda_u240_u243_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), 0, 2, (Object) null));
            ImmutableImageRequest build = $this$joinedOtherItems_u24lambda_u240_u243_u240.build();
            $composer.endReplaceGroup();
            BiliImageKt.BiliImage(build, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(8), 0.0f, 10, (Object) null), Dp.constructor-impl(20)), "icon", null, null, null, null, null, null, $composer, 432, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
            TextKt.Text-Nvy7gAk($basicInfo.getTitle(), RowScope.-CC.weight$default($this$joinedOtherItems_u24lambda_u240_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer, 24576, 24960, 241640);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit joinedOtherItems$lambda$0$0$0(BiliColors $colors, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        DrawScope.-CC.drawRect-n-J9OG0$default($this$drawBehind, $colors.getBg2_float-0d7_KjU(), 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
        long j = $colors.getGraph_bg_bright-0d7_KjU();
        Path $this$joinedOtherItems_u24lambda_u240_u240_u240_u240 = AndroidPath_androidKt.Path();
        Rect rect = androidx.compose.ui.geometry.SizeKt.toRect-uvyYCjk($this$drawBehind.getSize-NH-jbRc());
        float x$iv = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(12));
        float y$iv = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(12));
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long v2$iv$iv2 = CornerRadius.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        float x$iv2 = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(12));
        float y$iv2 = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(12));
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
        long v2$iv$iv3 = Float.floatToRawIntBits(y$iv2);
        Path.-CC.addRoundRect$default($this$joinedOtherItems_u24lambda_u240_u240_u240_u240, RoundRectKt.RoundRect-ZAM2FJo$default(rect, v2$iv$iv2, CornerRadius.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv3 & 4294967295L)), 0L, 0L, 24, (Object) null), (Path.Direction) null, 2, (Object) null);
        DrawScope.-CC.drawPath-LG529CI$default($this$drawBehind, $this$joinedOtherItems_u24lambda_u240_u240_u240_u240, j, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit joinedOtherItems$lambda$0$2$0(Function1 $updateExpandStatus, boolean $isExpanded) {
        $updateExpandStatus.invoke(Boolean.valueOf(!$isExpanded));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit joinedOtherItems$lambda$1(List $tribeeList, boolean $showExpand, int $itemsCount, BiliColors $colors, final Function2 $onClickItem, LazyItemScope $this$items, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(it)392@15606L39,394@15712L121,371@14609L1235:TribeeUserCenterCompose.kt#x3q3r7");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(it) ? 32 : 16;
        }
        if ($composer.shouldExecute(($dirty & 145) != 144, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-571201448, $dirty, -1, "kntr.app.tribee.consume.page.mine.joinedOtherItems.<anonymous> (TribeeUserCenterCompose.kt:370)");
            }
            final KTribeeDesc desc = (KTribeeDesc) CollectionsKt.getOrNull($tribeeList, it);
            int $this$dp$iv = $itemsCount - 1;
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, ($showExpand || it != $itemsCount + (-1)) ? Dp.constructor-impl(0) : Dp.constructor-impl(4), 7, (Object) null), $colors.getGraph_bg_bright-0d7_KjU(), (it < $tribeeList.size() - 1 || $showExpand) ? RectangleShapeKt.getRectangleShape() : (Shape) RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(12), 3, (Object) null)), Dp.constructor-impl(12), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(8), 0.0f, it == $this$dp$iv ? Dp.constructor-impl(16) : Dp.constructor-impl(8), 5, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 831256031, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 831259505, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onClickItem) | $composer.changedInstance(desc);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda29
                    public final Object invoke() {
                        Unit joinedOtherItems$lambda$1$1$0;
                        joinedOtherItems$lambda$1$1$0 = TribeeUserCenterComposeKt.joinedOtherItems$lambda$1$1$0($onClickItem, desc);
                        return joinedOtherItems$lambda$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            GameStationItem(desc, ClickableKt.clickable-O2vRcR0$default(modifier, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null), $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit joinedOtherItems$lambda$1$1$0(Function2 $onClickItem, KTribeeDesc $desc) {
        KNavigationType.JOINED_OTHER_TRIBEE joined_other_tribee = KNavigationType.JOINED_OTHER_TRIBEE.INSTANCE;
        String jumpUri = $desc != null ? $desc.getJumpUri() : null;
        if (jumpUri == null) {
            jumpUri = "";
        }
        $onClickItem.invoke(joined_other_tribee, jumpUri);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit joinedOtherItems$lambda$2(BiliColors $colors, final Function1 $updateExpandStatus, final boolean $isExpanded, KNavigationEntryJoinedOtherTribee $otherTribee, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Painter arrow_expand_line_900;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C413@16449L39,414@16516L87,402@15919L1879:TribeeUserCenterCompose.kt#x3q3r7");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1616174470, $changed, -1, "kntr.app.tribee.consume.page.mine.joinedOtherItems.<anonymous> (TribeeUserCenterCompose.kt:402)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(4), 7, (Object) null), $colors.getGraph_bg_bright-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(12), 3, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer, -1634478035, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1634475843, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            boolean invalid$iv = $composer.changed($updateExpandStatus) | $composer.changed($isExpanded);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda25
                    public final Object invoke() {
                        Unit joinedOtherItems$lambda$2$1$0;
                        joinedOtherItems$lambda$2$1$0 = TribeeUserCenterComposeKt.joinedOtherItems$lambda$2$1$0($updateExpandStatus, $isExpanded);
                        return joinedOtherItems$lambda$2$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            ComposerKt.sourceInformationMarkerStart($composer, 988613848, "C418@16637L209,423@16863L921:TribeeUserCenterCompose.kt#x3q3r7");
            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null), Dp.constructor-impl((float) 0.5d), $colors.getLine_regular-0d7_KjU(), $composer, 54, 0);
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(40));
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(2), Alignment.Companion.getCenterHorizontally());
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
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
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1549237933, "C431@17333L6,428@17148L265,437@17674L6,434@17434L332:TribeeUserCenterCompose.kt#x3q3r7");
            TextKt.Text-Nvy7gAk($isExpanded ? $otherTribee.getLessText() : $otherTribee.getMoreText(), Modifier.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24624, 0, 262120);
            if ($isExpanded) {
                $composer.startReplaceGroup(1019817539);
                ComposerKt.sourceInformation($composer, "435@17504L23");
                arrow_expand_line_900 = BiliIconfont.INSTANCE.getArrow_collapse_line_900($composer, 6);
            } else {
                $composer.startReplaceGroup(1019818881);
                ComposerKt.sourceInformation($composer, "435@17546L21");
                arrow_expand_line_900 = BiliIconfont.INSTANCE.getArrow_expand_line_900($composer, 6);
            }
            $composer.endReplaceGroup();
            BiliIconfontKt.BiliIcon-ww6aTOc(arrow_expand_line_900, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), "expandable icon", BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 432, 0);
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
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit joinedOtherItems$lambda$2$1$0(Function1 $updateExpandStatus, boolean $isExpanded) {
        $updateExpandStatus.invoke(Boolean.valueOf(!$isExpanded));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlaceNormalItemByType$lambda$1$0(KNavigationType kNavigationType, String str) {
        Intrinsics.checkNotNullParameter(kNavigationType, "<unused var>");
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r5v6 */
    private static final void PlaceNormalItemByType(final Function1<? super TribeeHomeStateAction, Unit> function1, final KNavigationEntry entry, final ItemSectionPosition itemSectionPosition, Modifier modifier, Function0<Unit> function0, Function2<? super KNavigationType, ? super String, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Function2 function22;
        Modifier modifier3;
        Function0 dismissDrawer;
        Function2 onClickItem;
        Modifier modifier4;
        Modifier modifier5;
        Function0 dismissDrawer2;
        Modifier modifier6;
        int $dirty;
        int $dirty2;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(1082932602);
        ComposerKt.sourceInformation($composer2, "C(PlaceNormalItemByType)N(onStateAction,entry,itemSectionPosition,modifier,dismissDrawer,onClickItem):TribeeUserCenterCompose.kt#x3q3r7");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changedInstance(function1) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changedInstance(entry) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty3 |= $composer2.changed(itemSectionPosition.ordinal()) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                modifier2 = modifier;
                if ($composer2.changed(modifier2)) {
                    i2 = 2048;
                    $dirty3 |= i2;
                }
            } else {
                modifier2 = modifier;
            }
            i2 = 1024;
            $dirty3 |= i2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty3 |= 24576;
            function02 = function0;
        } else if (($changed & 24576) == 0) {
            function02 = function0;
            $dirty3 |= $composer2.changedInstance(function02) ? 16384 : 8192;
        } else {
            function02 = function0;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty3 |= 196608;
            function22 = function2;
        } else if ((196608 & $changed) == 0) {
            function22 = function2;
            $dirty3 |= $composer2.changedInstance(function22) ? 131072 : 65536;
        } else {
            function22 = function2;
        }
        if ($composer2.shouldExecute((74899 & $dirty3) != 74898, $dirty3 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "456@18203L2,457@18260L11");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 8) != 0) {
                    modifier4 = SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(PaddingKt.padding(Modifier.Companion, MineMenuGroupUtil.INSTANCE.checkItemSectionPadding(itemSectionPosition)), Dp.constructor-impl(12), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null);
                    $dirty3 &= -7169;
                } else {
                    modifier4 = modifier2;
                }
                if (i3 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 1316156572, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    modifier5 = modifier4;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda26
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    dismissDrawer2 = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    modifier5 = modifier4;
                    dismissDrawer2 = function02;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 1316158405, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
                    Object it$iv2 = $composer2.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function2() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda27
                            public final Object invoke(Object obj, Object obj2) {
                                Unit PlaceNormalItemByType$lambda$1$0;
                                PlaceNormalItemByType$lambda$1$0 = TribeeUserCenterComposeKt.PlaceNormalItemByType$lambda$1$0((KNavigationType) obj, (String) obj2);
                                return PlaceNormalItemByType$lambda$1$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    Function2 onClickItem2 = it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    modifier6 = modifier5;
                    dismissDrawer = dismissDrawer2;
                    $dirty = $dirty3;
                    onClickItem = onClickItem2;
                } else {
                    modifier6 = modifier5;
                    dismissDrawer = dismissDrawer2;
                    onClickItem = function22;
                    $dirty = $dirty3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                modifier6 = modifier2;
                dismissDrawer = function02;
                onClickItem = function22;
                $dirty = $dirty3;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1082932602, $dirty, -1, "kntr.app.tribee.consume.page.mine.PlaceNormalItemByType (TribeeUserCenterCompose.kt:458)");
            }
            if (Intrinsics.areEqual(entry.getNavigationType(), KNavigationType.DISPLAY_APP_MINE.INSTANCE)) {
                $composer2.startReplaceGroup(2146307317);
                ComposerKt.sourceInformation($composer2, "461@18369L251");
                $dirty2 = $dirty;
                RevisitSettings(entry, itemSectionPosition, modifier6, dismissDrawer, function1, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (57344 & ($dirty << 12)), 0);
                $composer2.endReplaceGroup();
            } else {
                $dirty2 = $dirty;
                $composer2.startReplaceGroup(2146597694);
                ComposerKt.sourceInformation($composer2, "471@18662L242");
                SimpleItem(function1, entry, itemSectionPosition, modifier6, onClickItem, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & ($dirty2 >> 3)), 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            dismissDrawer = function02;
            onClickItem = function22;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final Function0 function03 = dismissDrawer;
            final Function2 function23 = onClickItem;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda28
                public final Object invoke(Object obj, Object obj2) {
                    Unit PlaceNormalItemByType$lambda$2;
                    PlaceNormalItemByType$lambda$2 = TribeeUserCenterComposeKt.PlaceNormalItemByType$lambda$2(function1, entry, itemSectionPosition, modifier7, function03, function23, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PlaceNormalItemByType$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleItem$lambda$0$0(KNavigationType kNavigationType, String str) {
        Intrinsics.checkNotNullParameter(kNavigationType, "<unused var>");
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v20 */
    private static final void SimpleItem(final Function1<? super TribeeHomeStateAction, Unit> function1, final KNavigationEntry entry, final ItemSectionPosition itemSectionPosition, Modifier modifier, Function2<? super KNavigationType, ? super String, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 onClickItem;
        Modifier modifier3;
        boolean z;
        KNavigationEntryGameStats value;
        String str;
        final BiliColors colors;
        Function0 factory$iv$iv$iv;
        String supplementaryText;
        KNavigationEntryGameStats value2;
        KNavigationEntryInviteCode value3;
        KNavigationEntryInviteCode value4;
        Composer $composer2 = $composer.startRestartGroup(-1688479753);
        ComposerKt.sourceInformation($composer2, "C(SimpleItem)N(onStateAction,entry,itemSectionPosition,modifier,onClickItem)488@19175L11,499@19676L6,505@19810L6,506@19943L39,506@20003L629,518@20644L206,501@19688L3541:TribeeUserCenterCompose.kt#x3q3r7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(entry) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(itemSectionPosition.ordinal()) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            onClickItem = function2;
        } else if (($changed & 24576) == 0) {
            onClickItem = function2;
            $dirty |= $composer2.changedInstance(onClickItem) ? 16384 : 8192;
        } else {
            onClickItem = function2;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 868602658, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function2() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SimpleItem$lambda$0$0;
                            SimpleItem$lambda$0$0 = TribeeUserCenterComposeKt.SimpleItem$lambda$0$0((KNavigationType) obj, (String) obj2);
                            return SimpleItem$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function2 onClickItem2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onClickItem = onClickItem2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1688479753, $dirty2, -1, "kntr.app.tribee.consume.page.mine.SimpleItem (TribeeUserCenterCompose.kt:489)");
            }
            final KNavigationEntryBasicInfo info = entry.getBasicInfo();
            if (info == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier5 = modifier4;
                    final Function2 function22 = onClickItem;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SimpleItem$lambda$1;
                            SimpleItem$lambda$1 = TribeeUserCenterComposeKt.SimpleItem$lambda$1(function1, entry, itemSectionPosition, modifier5, function22, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return SimpleItem$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            KNavigationEntry.IData data = entry.getData();
            if (data instanceof KNavigationEntry.KInviteCode) {
                KNavigationEntry.KInviteCode data2 = entry.getData();
                KNavigationEntry.KInviteCode kInviteCode = data2 instanceof KNavigationEntry.KInviteCode ? data2 : null;
                z = (kInviteCode == null || (value4 = kInviteCode.getValue()) == null || !value4.isNewCodeMyPageRedDot()) ? false : true;
            } else if (data instanceof KNavigationEntry.KGameStats) {
                KNavigationEntry.KGameStats data3 = entry.getData();
                KNavigationEntry.KGameStats kGameStats = data3 instanceof KNavigationEntry.KGameStats ? data3 : null;
                z = (kGameStats != null && (value = kGameStats.getValue()) != null && !value.isBind()) && !TribeePreference.INSTANCE.getHasDidTapEntryGameStats();
            } else {
                z = false;
            }
            final boolean hasRedDot = z;
            BiliColors colors2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable);
            Modifier modifier6 = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(modifier4, Dp.constructor-impl(44)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_bright-0d7_KjU(), MineMenuGroupUtil.INSTANCE.checkItemSectionBackgroundShape(itemSectionPosition));
            ComposerKt.sourceInformationMarkerStart($composer2, 868627262, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 868629772, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            boolean invalid$iv = ((57344 & $dirty2) == 16384) | $composer2.changedInstance(entry) | $composer2.changedInstance(info) | $composer2.changed(hasRedDot) | (($dirty2 & 14) == 4);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv || value$iv3 == Composer.Companion.getEmpty()) {
                final Function2 function23 = onClickItem;
                str = "CC(remember):TribeeUserCenterCompose.kt#9igjgp";
                colors = colors2;
                value$iv3 = new Function0() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit SimpleItem$lambda$3$0;
                        SimpleItem$lambda$3$0 = TribeeUserCenterComposeKt.SimpleItem$lambda$3$0(function23, entry, info, hasRedDot, function1);
                        return SimpleItem$lambda$3$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            } else {
                colors = colors2;
                str = "CC(remember):TribeeUserCenterCompose.kt#9igjgp";
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier7 = ClickableKt.clickable-O2vRcR0$default(modifier6, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) value$iv3, 28, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 868649861, str);
            boolean invalid$iv2 = $composer2.changed(colors) | (($dirty2 & 896) == 256);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        Unit SimpleItem$lambda$4$0;
                        SimpleItem$lambda$4$0 = TribeeUserCenterComposeKt.SimpleItem$lambda$4$0(colors, itemSectionPosition, (DrawScope) obj);
                        return SimpleItem$lambda$4$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = DrawModifierKt.drawBehind(modifier7, (Function1) it$iv3);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Function2 onClickItem3 = onClickItem;
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
            modifier3 = modifier4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((384 >> 6) & 112) | 6;
            RowScope $this$SimpleItem_u24lambda_u245 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1484981229, "C526@20924L491,545@21522L6,542@21425L236,587@22956L28,589@23062L6,586@22914L309:TribeeUserCenterCompose.kt#x3q3r7");
            $composer2.startReplaceGroup(1987565072);
            ComposerKt.sourceInformation($composer2, "*531@21116L6");
            String $this$asRequest$iv = info.getIcon();
            ImageRequest $this$SimpleItem_u24lambda_u245_u240 = new ImageRequest($this$asRequest$iv);
            ColorFilter.Companion companion = ColorFilter.Companion;
            BiliTheme biliTheme = BiliTheme.INSTANCE;
            int $changed$iv$iv$iv2 = BiliTheme.$stable;
            $this$SimpleItem_u24lambda_u245_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(companion, biliTheme.getColors($composer2, $changed$iv$iv$iv2).getText1-0d7_KjU(), 0, 2, (Object) null));
            ImmutableImageRequest build = $this$SimpleItem_u24lambda_u245_u240.build();
            $composer2.endReplaceGroup();
            BiliImageKt.BiliImage(build, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(8), Dp.constructor-impl(12)), Dp.constructor-impl(20)), "icon", null, null, null, null, null, null, $composer2, 384, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
            TextKt.Text-Nvy7gAk(info.getTitle(), RowScope.-CC.weight$default($this$SimpleItem_u24lambda_u245, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer2, 24576, 24960, 241640);
            if (hasRedDot) {
                $composer2.startReplaceGroup(1485674171);
                ComposerKt.sourceInformation($composer2, "556@21836L93,552@21700L244");
                Modifier modifier8 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6));
                ComposerKt.sourceInformationMarkerStart($composer2, 1987592248, str);
                boolean invalid$iv3 = $composer2.changed(colors);
                Object it$iv4 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function1() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj) {
                            Unit SimpleItem$lambda$5$1$0;
                            SimpleItem$lambda$5$1$0 = TribeeUserCenterComposeKt.SimpleItem$lambda$5$1$0(colors, (DrawScope) obj);
                            return SimpleItem$lambda$5$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv4 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                SpacerKt.Spacer(DrawModifierKt.drawBehind(modifier8, (Function1) it$iv4), $composer2, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1485966935);
                ComposerKt.sourceInformation($composer2, "");
                KNavigationEntry.IData data4 = entry.getData();
                if (data4 instanceof KNavigationEntry.KInviteCode) {
                    KNavigationEntry.KInviteCode data5 = entry.getData();
                    KNavigationEntry.KInviteCode kInviteCode2 = data5 instanceof KNavigationEntry.KInviteCode ? data5 : null;
                    Long it = (kInviteCode2 == null || (value3 = kInviteCode2.getValue()) == null) ? null : Long.valueOf(value3.getUseable());
                    supplementaryText = (it != null ? it.longValue() : -1L) > 0 ? String.valueOf(it) : null;
                } else if (data4 instanceof KNavigationEntry.KGameStats) {
                    KNavigationEntry.KGameStats data6 = entry.getData();
                    KNavigationEntry.KGameStats kGameStats2 = data6 instanceof KNavigationEntry.KGameStats ? data6 : null;
                    supplementaryText = (kGameStats2 == null || (value2 = kGameStats2.getValue()) == null) ? null : value2.getText();
                } else {
                    supplementaryText = null;
                }
                String str2 = supplementaryText;
                if (str2 == null || StringsKt.isBlank(str2)) {
                    $composer2.startReplaceGroup(1464152359);
                } else {
                    $composer2.startReplaceGroup(1486612944);
                    ComposerKt.sourceInformation($composer2, "579@22761L6,576@22633L247");
                    TextKt.Text-Nvy7gAk(supplementaryText, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer2, 24576, 24960, 241642);
                }
                $composer2.endReplaceGroup();
                $composer2.endReplaceGroup();
            }
            BiliIconfontKt.BiliIcon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_900($composer2, 6), SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, Dp.constructor-impl(16), 0.0f, 10, (Object) null), Dp.constructor-impl(12)), "arrow icon", BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), $composer2, Painter.$stable | 384, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onClickItem = onClickItem3;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier9 = modifier3;
            final Function2 function24 = onClickItem;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit SimpleItem$lambda$6;
                    SimpleItem$lambda$6 = TribeeUserCenterComposeKt.SimpleItem$lambda$6(function1, entry, itemSectionPosition, modifier9, function24, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SimpleItem$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleItem$lambda$3$0(Function2 $onClickItem, KNavigationEntry $entry, KNavigationEntryBasicInfo $info, boolean $hasRedDot, Function1 $onStateAction) {
        $onClickItem.invoke($entry.getNavigationType(), $info.getJumpUri());
        if ($hasRedDot) {
            KNavigationType navigationType = $entry.getNavigationType();
            if (Intrinsics.areEqual(navigationType, KNavigationType.INVITE_CODE.INSTANCE)) {
                $onStateAction.invoke(new TribeeHomeStateAction.ReportNotification(false, false));
            } else if (Intrinsics.areEqual(navigationType, KNavigationType.GAME_STATS.INSTANCE)) {
                TribeePreference.INSTANCE.setHasDidTapEntryGameStats(true);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleItem$lambda$4$0(BiliColors $colors, ItemSectionPosition $itemSectionPosition, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        MineMenuGroupUtil.m743checkItemSectionDividerWBdyNhk$default(MineMenuGroupUtil.INSTANCE, $this$drawBehind, $colors.getLine_regular-0d7_KjU(), $itemSectionPosition, 0L, 0L, 0.0f, 28, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleItem$lambda$5$1$0(BiliColors $colors, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        DrawScope.-CC.drawCircle-VaOC9Bg$default($this$drawBehind, $colors.getStress_red-0d7_KjU(), 0.0f, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
        return Unit.INSTANCE;
    }

    private static final void GameStationItem(final KTribeeDesc desc, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(-2099669171);
        ComposerKt.sourceInformation($composer3, "C(GameStationItem)N(desc,modifier)604@23360L970:TribeeUserCenterCompose.kt#x3q3r7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(desc) ? 4 : 2;
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
        if ($composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            final Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2099669171, $dirty, -1, "kntr.app.tribee.consume.page.mine.GameStationItem (TribeeUserCenterCompose.kt:602)");
            }
            if (desc == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj, Object obj2) {
                            Unit GameStationItem$lambda$0;
                            GameStationItem$lambda$0 = TribeeUserCenterComposeKt.GameStationItem$lambda$0(desc, modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return GameStationItem$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty >> 3) & 14) | 384;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$GameStationItem_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 117742168, "C608@23466L103,610@23579L745:TribeeUserCenterCompose.kt#x3q3r7");
            TribeeDetailComposeKt.TribeeImage(desc.getFaceUrl(), ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), $composer3, 0, 0);
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(RowScope.-CC.weight$default($this$GameStationItem_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(8), 0.0f, 2, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv2 = (48 << 3) & 112;
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
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -538033740, "C620@23903L6,617@23794L252,628@24171L6,625@24059L255:TribeeUserCenterCompose.kt#x3q3r7");
            TextKt.Text-Nvy7gAk(desc.getTitle(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(15), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(21), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 25008, 239594);
            TextKt.Text-Nvy7gAk(desc.getSubTitle(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(17), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 25008, 239594);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit GameStationItem$lambda$2;
                    GameStationItem$lambda$2 = TribeeUserCenterComposeKt.GameStationItem$lambda$2(desc, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GameStationItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RevisitSettings$lambda$1$0(TribeeHomeStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0580  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0614  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x067e  */
    /* JADX WARN: Type inference failed for: r6v38 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void RevisitSettings(final KNavigationEntry entry, final ItemSectionPosition itemSectionPosition, Modifier modifier, Function0<Unit> function0, Function1<? super TribeeHomeStateAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Function0 dismissDrawer;
        final Function1<? super TribeeHomeStateAction, Unit> function12;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        boolean z;
        boolean invalid$iv;
        Object it$iv;
        Composer $composer3 = $composer.startRestartGroup(-192644097);
        ComposerKt.sourceInformation($composer3, "C(RevisitSettings)N(entry,itemSectionPosition,modifier,dismissDrawer,onStateAction)643@24558L2,644@24615L2,647@24729L6,653@24883L6,655@25018L206,648@24740L2714:TribeeUserCenterCompose.kt#x3q3r7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(entry) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(itemSectionPosition.ordinal()) ? 32 : 16;
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
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            dismissDrawer = function0;
        } else if (($changed & 3072) == 0) {
            dismissDrawer = function0;
            $dirty |= $composer3.changedInstance(dismissDrawer) ? 2048 : 1024;
        } else {
            dismissDrawer = function0;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            function12 = function1;
        } else if (($changed & 24576) == 0) {
            function12 = function1;
            $dirty |= $composer3.changedInstance(function12) ? 16384 : 8192;
        } else {
            function12 = function1;
        }
        if ($composer3.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -447378271, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda15
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv2 = value$iv;
                }
                Function0 dismissDrawer2 = (Function0) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                dismissDrawer = dismissDrawer2;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -447376447, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
                Object it$iv3 = $composer3.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda16
                        public final Object invoke(Object obj) {
                            Unit RevisitSettings$lambda$1$0;
                            RevisitSettings$lambda$1$0 = TribeeUserCenterComposeKt.RevisitSettings$lambda$1$0((TribeeHomeStateAction) obj);
                            return RevisitSettings$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv3 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                function12 = it$iv3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-192644097, $dirty, -1, "kntr.app.tribee.consume.page.mine.RevisitSettings (TribeeUserCenterCompose.kt:645)");
            }
            KNavigationEntry.KDisplayAppMine data = entry.getData();
            KNavigationEntry.KDisplayAppMine settings2 = data instanceof KNavigationEntry.KDisplayAppMine ? data : null;
            if (settings2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier5 = modifier4;
                    final Function0 function02 = dismissDrawer;
                    final Function1<? super TribeeHomeStateAction, Unit> function13 = function12;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda17
                        public final Object invoke(Object obj, Object obj2) {
                            Unit RevisitSettings$lambda$2;
                            RevisitSettings$lambda$2 = TribeeUserCenterComposeKt.RevisitSettings$lambda$2(entry, itemSectionPosition, modifier5, function02, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return RevisitSettings$lambda$2;
                        }
                    });
                    return;
                }
                return;
            }
            int $dirty2 = $dirty;
            final BiliColors colors = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable);
            Modifier modifier6 = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(modifier4, Dp.constructor-impl(63)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_bg_bright-0d7_KjU(), MineMenuGroupUtil.INSTANCE.checkItemSectionBackgroundShape(itemSectionPosition));
            ComposerKt.sourceInformationMarkerStart($composer3, -447363347, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(colors) | (($dirty2 & 112) == 32);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda18
                    public final Object invoke(Object obj) {
                        Unit RevisitSettings$lambda$3$0;
                        RevisitSettings$lambda$3$0 = TribeeUserCenterComposeKt.RevisitSettings$lambda$3$0(colors, itemSectionPosition, (DrawScope) obj);
                        return RevisitSettings$lambda$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv4 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = DrawModifierKt.drawBehind(modifier6, (Function1) it$iv4);
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
            modifier3 = modifier4;
            $composer2 = $composer3;
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((384 >> 6) & 112) | 6;
            RowScope $this$RevisitSettings_u24lambda_u244 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 764638754, "C675@25752L262,663@25298L727,685@26035L609,709@26825L6,710@26897L6,711@26963L6,712@27036L6,714@27105L271,705@26654L794:TribeeUserCenterCompose.kt#x3q3r7");
            $composer3.startReplaceGroup(-1222257654);
            ComposerKt.sourceInformation($composer3, "*669@25517L6");
            KNavigationEntryBasicInfo basicInfo = entry.getBasicInfo();
            String $this$asRequest$iv = basicInfo != null ? basicInfo.getIcon() : null;
            if ($this$asRequest$iv == null) {
                $this$asRequest$iv = "";
            }
            ImageRequest $this$RevisitSettings_u24lambda_u244_u240 = new ImageRequest($this$asRequest$iv);
            ColorFilter.Companion companion = ColorFilter.Companion;
            BiliTheme biliTheme = BiliTheme.INSTANCE;
            int $changed$iv$iv$iv2 = BiliTheme.$stable;
            $this$RevisitSettings_u24lambda_u244_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(companion, biliTheme.getColors($composer3, $changed$iv$iv$iv2).getText1-0d7_KjU(), 0, 2, (Object) null));
            ImmutableImageRequest build = $this$RevisitSettings_u24lambda_u244_u240.build();
            $composer3.endReplaceGroup();
            BiliImageKt.BiliImage(build, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(8), Dp.constructor-impl(12)), Dp.constructor-impl(20)), null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-933595316, true, new Function4() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit RevisitSettings$lambda$4$1;
                    RevisitSettings$lambda$4$1 = TribeeUserCenterComposeKt.RevisitSettings$lambda$4$1(colors, (ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return RevisitSettings$lambda$4$1;
                }
            }, $composer3, 54), $composer3, 100663296, 252);
            Modifier modifier$iv$iv = RowScope.-CC.weight$default($this$RevisitSettings_u24lambda_u244, Modifier.Companion, 1.0f, false, 2, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
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
            Function0 dismissDrawer3 = dismissDrawer;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1037482129, "C691@26270L9,692@26319L6,689@26173L173:TribeeUserCenterCompose.kt#x3q3r7");
            KNavigationEntryBasicInfo basicInfo2 = entry.getBasicInfo();
            String title = basicInfo2 != null ? basicInfo2.getTitle() : null;
            if (title == null) {
                title = "";
            }
            TextKt.Text-Nvy7gAk(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 0, 0, 131066);
            KNavigationEntryBasicInfo basicInfo3 = entry.getBasicInfo();
            String desc = basicInfo3 != null ? basicInfo3.getSubtitle() : null;
            if (desc != null && (!StringsKt.isBlank(desc))) {
                z = true;
                if (z) {
                    $composer3.startReplaceGroup(1011503229);
                } else {
                    $composer3.startReplaceGroup(1037756540);
                    ComposerKt.sourceInformation($composer3, "699@26536L9,700@26589L6,697@26459L161");
                    TextKt.Text-Nvy7gAk(desc, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 0, 0, 131066);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                boolean isDisplay = settings2.getValue().isDisplay();
                SimpleSwitchColors simpleSwitchColors = new SimpleSwitchColors(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU(), 0L, 0L, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_white-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_white-0d7_KjU(), 0L, 0L, null, null, 972, null);
                Modifier modifier7 = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, -1222204278, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
                invalid$iv = ((57344 & $dirty2) != 16384) | (($dirty2 & 7168) != 2048);
                it$iv = $composer3.rememberedValue();
                if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    dismissDrawer = dismissDrawer3;
                    Object value$iv4 = new Function1() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda20
                        public final Object invoke(Object obj) {
                            Unit RevisitSettings$lambda$4$3$0;
                            RevisitSettings$lambda$4$3$0 = TribeeUserCenterComposeKt.RevisitSettings$lambda$4$3$0(function12, dismissDrawer, ((Boolean) obj).booleanValue());
                            return RevisitSettings$lambda$4$3$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv4);
                    it$iv = value$iv4;
                } else {
                    dismissDrawer = dismissDrawer3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                SimpleSwitchKt.SimpleSwitch(isDisplay, (Function1) it$iv, modifier7, false, null, simpleSwitchColors, $composer3, (SimpleSwitchColors.$stable << 15) | 384, 24);
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
            z = false;
            if (z) {
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            boolean isDisplay2 = settings2.getValue().isDisplay();
            SimpleSwitchColors simpleSwitchColors2 = new SimpleSwitchColors(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU(), 0L, 0L, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_white-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_white-0d7_KjU(), 0L, 0L, null, null, 972, null);
            Modifier modifier72 = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -1222204278, "CC(remember):TribeeUserCenterCompose.kt#9igjgp");
            invalid$iv = ((57344 & $dirty2) != 16384) | (($dirty2 & 7168) != 2048);
            it$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            dismissDrawer = dismissDrawer3;
            Object value$iv42 = new Function1() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj) {
                    Unit RevisitSettings$lambda$4$3$0;
                    RevisitSettings$lambda$4$3$0 = TribeeUserCenterComposeKt.RevisitSettings$lambda$4$3$0(function12, dismissDrawer, ((Boolean) obj).booleanValue());
                    return RevisitSettings$lambda$4$3$0;
                }
            };
            $composer3.updateRememberedValue(value$iv42);
            it$iv = value$iv42;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SimpleSwitchKt.SimpleSwitch(isDisplay2, (Function1) it$iv, modifier72, false, null, simpleSwitchColors2, $composer3, (SimpleSwitchColors.$stable << 15) | 384, 24);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier8 = modifier3;
            final Function0 function03 = dismissDrawer;
            final Function1<? super TribeeHomeStateAction, Unit> function14 = function12;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2) {
                    Unit RevisitSettings$lambda$5;
                    RevisitSettings$lambda$5 = TribeeUserCenterComposeKt.RevisitSettings$lambda$5(entry, itemSectionPosition, modifier8, function03, function14, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RevisitSettings$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RevisitSettings$lambda$3$0(BiliColors $colors, ItemSectionPosition $itemSectionPosition, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        MineMenuGroupUtil.m743checkItemSectionDividerWBdyNhk$default(MineMenuGroupUtil.INSTANCE, $this$drawBehind, $colors.getLine_regular-0d7_KjU(), $itemSectionPosition, 0L, 0L, 0.0f, 28, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RevisitSettings$lambda$4$1(BiliColors $colors, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)677@25819L19,676@25770L230:TribeeUserCenterCompose.kt#x3q3r7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-933595316, $changed, -1, "kntr.app.tribee.consume.page.mine.RevisitSettings.<anonymous>.<anonymous> (TribeeUserCenterCompose.kt:676)");
        }
        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getEye_browse_line_500($composer, 6), "icon", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $colors.getText1-0d7_KjU(), $composer, Painter.$stable | 432, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RevisitSettings$lambda$4$3$0(Function1 $onStateAction, Function0 $dismissDrawer, boolean checked) {
        TrackerKt.reportClickInMinePage(checked ? "entry-on" : "entry-off");
        $onStateAction.invoke(new TribeeHomeStateAction.SwitchRevisitSettings(checked));
        $dismissDrawer.invoke();
        return Unit.INSTANCE;
    }
}