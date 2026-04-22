package kntr.app.game.steam;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
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
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.Velocity;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.game.base.bridge.KntrGameReportService;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.ui.ExposerKt;
import kntr.app.game.base.ui.ExposureConfig;
import kntr.app.game.base.ui.page.FooterLoadingViewKt;
import kntr.app.game.base.ui.page.LoadComposableKt;
import kntr.app.game.base.ui.util.ClipBoard_androidKt;
import kntr.app.game.base.ui.util.GameClipboardManager;
import kntr.app.game.base.ui.util.MultiTouchFilterKt;
import kntr.app.game.base.viewmodel.PageLoadMoreState;
import kntr.app.game.bean.StatisticOverview;
import kntr.app.game.bean.SteamChartData;
import kntr.app.game.bean.SteamDetailGameItem;
import kntr.app.game.bean.SteamDetailPageData;
import kntr.app.game.bean.SteamGameListSortType;
import kntr.app.game.bean.UserSteamInfo;
import kntr.app.game.report.ReportKt;
import kntr.app.game.steam.chart.BarChartConfig;
import kntr.app.game.steam.chart.BarChartKt;
import kntr.app.game.steam.chart.BarData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.common.compose.res.CommonRes;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.router.GlobalRouterKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.datetime.Clock;
import org.jetbrains.compose.resources.FontResources_androidKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.game.base.ui.generated.resources.Font0_commonMainKt;
import srcs.app.game.base.ui.generated.resources.Res;
import srcs.app.game.gamebiz.generated.resources.Res;
import srcs.common.compose.res.generated.resources.Drawable0_commonMainKt;

/* compiled from: SteamDetailPage.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a-\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u000b\u001a;\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u000f\u001a9\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0003¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0014\u001a5\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u001a\u001a/\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010 \u001a\u001f\u0010!\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010 \u001a=\u0010\"\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030$2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020%H\u0007¢\u0006\u0002\u0010'\u001a5\u0010(\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020\u00012\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010,\u001a=\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u00101\u001a\u00020\u000eH\u0007¢\u0006\u0002\u00102\u001a)\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0004\b7\u00108\u001a\n\u00109\u001a\u00020:*\u00020;\u001a9\u0010<\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010=\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010>\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006?²\u0006\n\u0010@\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010A\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010B\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010C\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010D\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010E\u001a\u00020\u000eX\u008a\u008e\u0002"}, d2 = {"FOOTER_KEY", RoomRecommendViewModel.EMPTY_CURSOR, "SteamDetailPage", RoomRecommendViewModel.EMPTY_CURSOR, RouterHelperKt.PARAM_SOURCE_FROM, "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SteamDetailPageWithNavigation", "onBackPress", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SteamDetailPageConfigurable", "showNavigation", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SteamDetailPageContent", "showNavigationFlag", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SteamGamelistEmpty", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SteamUserCard", "data", "Lkntr/app/game/bean/SteamDetailPageData;", "onClickRefresh", "isRotating", "(Lkntr/app/game/bean/SteamDetailPageData;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SteamGameIDCard", "code", "onCopy", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SteamGameTotalCard", "(Lkntr/app/game/bean/SteamDetailPageData;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SteamGameChartItem", "SteamGameListCardTitle", "onClickSortType", "Lkotlin/Function1;", "Lkntr/app/game/bean/SteamGameListSortType;", "sortType", "(Lkntr/app/game/bean/SteamDetailPageData;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkntr/app/game/bean/SteamGameListSortType;Landroidx/compose/runtime/Composer;II)V", "SteamGameListCardTitleItem", "title", "focus", "asc", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZZLandroidx/compose/runtime/Composer;II)V", "SteamGameListItem", "item", "Lkntr/app/game/bean/SteamDetailGameItem;", "steamId", "isFirst", "(Lkntr/app/game/bean/SteamDetailGameItem;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "SteamCoverPlaceHolder", "width", "Landroidx/compose/ui/unit/Dp;", "height", "SteamCoverPlaceHolder-if577FI", "(FFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BarData", "Lkntr/app/game/steam/chart/BarData;", "Lkntr/app/game/bean/SteamChartData;", "SteamDetailTopAppBar", "immersive", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "gamebiz_debug", "showSticky", "reachEnd", "isFolded", "showPrice", "priceExposed", "timeExposed"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SteamDetailPageKt {
    private static final String FOOTER_KEY = "footer";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamCoverPlaceHolder_if577FI$lambda$1(float f, float f2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m1276SteamCoverPlaceHolderif577FI(f, f2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPage$lambda$1(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SteamDetailPage(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPageConfigurable$lambda$1(String str, Modifier modifier, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        SteamDetailPageConfigurable(str, modifier, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPageContent$lambda$7(String str, Modifier modifier, String str2, Function0 function0, int i, int i2, Composer composer, int i3) {
        SteamDetailPageContent(str, modifier, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPageWithNavigation$lambda$0(String str, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SteamDetailPageWithNavigation(str, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailTopAppBar$lambda$3(String str, Function0 function0, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        SteamDetailTopAppBar(str, function0, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameChartItem$lambda$7$1(SteamDetailPageData steamDetailPageData, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SteamGameChartItem(steamDetailPageData, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameChartItem$lambda$8(SteamDetailPageData steamDetailPageData, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SteamGameChartItem(steamDetailPageData, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameIDCard$lambda$3(String str, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        SteamGameIDCard(str, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameListCardTitle$lambda$1(SteamDetailPageData steamDetailPageData, Function1 function1, Modifier modifier, SteamGameListSortType steamGameListSortType, int i, int i2, Composer composer, int i3) {
        SteamGameListCardTitle(steamDetailPageData, function1, modifier, steamGameListSortType, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameListCardTitleItem$lambda$1(Modifier modifier, String str, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        SteamGameListCardTitleItem(modifier, str, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameListItem$lambda$2(SteamDetailGameItem steamDetailGameItem, String str, Modifier modifier, String str2, boolean z, int i, int i2, Composer composer, int i3) {
        SteamGameListItem(steamDetailGameItem, str, modifier, str2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameTotalCard$lambda$1(SteamDetailPageData steamDetailPageData, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SteamGameTotalCard(steamDetailPageData, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGamelistEmpty$lambda$1(Modifier modifier, int i, int i2, Composer composer, int i3) {
        SteamGamelistEmpty(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamUserCard$lambda$1(SteamDetailPageData steamDetailPageData, Function0 function0, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SteamUserCard(steamDetailPageData, function0, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SteamDetailPage(final String sourceFrom, final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        Composer $composer2 = $composer.startRestartGroup(927202728);
        ComposerKt.sourceInformation($composer2, "C(SteamDetailPage)N(sourceFrom,modifier)125@5649L7,130@5806L51,126@5661L203:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(sourceFrom) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(927202728, $dirty2, -1, "kntr.app.game.steam.SteamDetailPage (SteamDetailPage.kt:124)");
            }
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer2, 1983600731, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(backHandler);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda33
                    public final Object invoke() {
                        Unit SteamDetailPage$lambda$0$0;
                        SteamDetailPage$lambda$0$0 = SteamDetailPageKt.SteamDetailPage$lambda$0$0(backHandler);
                        return SteamDetailPage$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SteamDetailPageContent(sourceFrom, modifier, "true", (Function0) it$iv, $composer2, ($dirty2 & 14) | 384 | ($dirty2 & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda34
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamDetailPage$lambda$1;
                    SteamDetailPage$lambda$1 = SteamDetailPageKt.SteamDetailPage$lambda$1(sourceFrom, modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamDetailPage$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPage$lambda$0$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    public static final void SteamDetailPageWithNavigation(final String sourceFrom, final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        Intrinsics.checkNotNullParameter(function0, "onBackPress");
        Composer $composer2 = $composer.startRestartGroup(1773021466);
        ComposerKt.sourceInformation($composer2, "C(SteamDetailPageWithNavigation)N(sourceFrom,onBackPress,modifier)142@6011L163:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(sourceFrom) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1773021466, $dirty2, -1, "kntr.app.game.steam.SteamDetailPageWithNavigation (SteamDetailPage.kt:141)");
            }
            SteamDetailPageContent(sourceFrom, modifier, "true", function0, $composer2, ($dirty2 & 14) | 384 | (($dirty2 >> 3) & 112) | (($dirty2 << 6) & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamDetailPageWithNavigation$lambda$0;
                    SteamDetailPageWithNavigation$lambda$0 = SteamDetailPageKt.SteamDetailPageWithNavigation$lambda$0(sourceFrom, function0, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamDetailPageWithNavigation$lambda$0;
                }
            });
        }
    }

    public static final void SteamDetailPageConfigurable(final String sourceFrom, Modifier modifier, boolean showNavigation, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Function0 onBackPress;
        Modifier modifier3;
        boolean showNavigation2;
        Function0 function02;
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        Composer $composer2 = $composer.startRestartGroup(-1485427385);
        ComposerKt.sourceInformation($composer2, "C(SteamDetailPageConfigurable)N(sourceFrom,modifier,showNavigation,onBackPress)157@6413L7,159@6426L271:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(sourceFrom) ? 4 : 2;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z = showNavigation;
        } else if (($changed & 384) == 0) {
            z = showNavigation;
            $dirty |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = showNavigation;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onBackPress = function0;
        } else if (($changed & 3072) == 0) {
            onBackPress = function0;
            $dirty |= $composer2.changedInstance(onBackPress) ? 2048 : 1024;
        } else {
            onBackPress = function0;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            showNavigation2 = z;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                showNavigation2 = z;
            } else {
                showNavigation2 = false;
            }
            if (i4 != 0) {
                onBackPress = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1485427385, $dirty2, -1, "kntr.app.game.steam.SteamDetailPageConfigurable (SteamDetailPage.kt:156)");
            }
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            String str = showNavigation2 ? "true" : "false";
            if (onBackPress == null) {
                $composer2.startReplaceGroup(-1318736544);
                ComposerKt.sourceInformation($composer2, "164@6631L59");
                ComposerKt.sourceInformationMarkerStart($composer2, -1566560542, "CC(remember):SteamDetailPage.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(backHandler);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda18
                        public final Object invoke() {
                            Unit SteamDetailPageConfigurable$lambda$0$0;
                            SteamDetailPageConfigurable$lambda$0$0 = SteamDetailPageKt.SteamDetailPageConfigurable$lambda$0$0(backHandler);
                            return SteamDetailPageConfigurable$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
                function02 = (Function0) it$iv;
            } else {
                $composer2.startReplaceGroup(-1566561007);
                $composer2.endReplaceGroup();
                function02 = onBackPress;
            }
            SteamDetailPageContent(sourceFrom, modifier3, str, function02, $composer2, ($dirty2 & 14) | ($dirty2 & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final boolean z2 = showNavigation2;
            final Function0 function03 = onBackPress;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamDetailPageConfigurable$lambda$1;
                    SteamDetailPageConfigurable$lambda$1 = SteamDetailPageKt.SteamDetailPageConfigurable$lambda$1(sourceFrom, modifier4, z2, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamDetailPageConfigurable$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPageConfigurable$lambda$0$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v20 */
    private static final void SteamDetailPageContent(final String sourceFrom, Modifier modifier, String showNavigationFlag, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String showNavigationFlag2;
        Function0 onBackPress;
        Composer $composer2;
        Modifier modifier3;
        String showNavigationFlag3;
        Function0 onBackPress2;
        String spmidFrom;
        String spmidFrom2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv;
        Composer $composer$iv2;
        Composer $composer3;
        Function0 factory$iv$iv$iv3;
        Composer $composer4 = $composer.startRestartGroup(-2605236);
        ComposerKt.sourceInformation($composer4, "C(SteamDetailPageContent)N(sourceFrom,modifier,showNavigationFlag,onBackPress)175@6880L2,178@6987L19,178@6977L29,179@7023L24,180@7075L34,185@7244L58,186@7334L209,186@7307L236,194@7590L137,194@7567L160,204@7846L156,214@8074L143,221@8263L14431:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(sourceFrom) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            showNavigationFlag2 = showNavigationFlag;
        } else if (($changed & 384) == 0) {
            showNavigationFlag2 = showNavigationFlag;
            $dirty |= $composer4.changed(showNavigationFlag2) ? 256 : 128;
        } else {
            showNavigationFlag2 = showNavigationFlag;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onBackPress = function0;
        } else if (($changed & 3072) == 0) {
            onBackPress = function0;
            $dirty |= $composer4.changedInstance(onBackPress) ? 2048 : 1024;
        } else {
            onBackPress = function0;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                showNavigationFlag2 = "false";
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, 1791340590, "CC(remember):SteamDetailPage.kt#9igjgp");
                Object it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda38
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onBackPress3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onBackPress2 = onBackPress3;
            } else {
                onBackPress2 = onBackPress;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2605236, $dirty2, -1, "kntr.app.game.steam.SteamDetailPageContent (SteamDetailPage.kt:176)");
            }
            boolean showNavigation = Intrinsics.areEqual(showNavigationFlag2, "true");
            ComposerKt.sourceInformationMarkerStart($composer4, 1791344031, "CC(remember):SteamDetailPage.kt#9igjgp");
            Object it$iv2 = $composer4.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda39
                    public final Object invoke(Object obj) {
                        SteamDetailVM SteamDetailPageContent$lambda$1$0;
                        SteamDetailPageContent$lambda$1$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$1$0((CreationExtras) obj);
                        return SteamDetailPageContent$lambda$1$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function1 initializer$iv = (Function1) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.startReplaceableGroup(419377738);
            ComposerKt.sourceInformation($composer4, "CC(viewModel)P(2,1)*124@5789L7,129@5965L288:ViewModel.kt#3tja67");
            HasDefaultViewModelProviderFactory current = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer4, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SteamDetailVM.class);
            InitializerViewModelFactoryBuilder $this$viewModel_u24lambda_u243$iv = new InitializerViewModelFactoryBuilder();
            $this$viewModel_u24lambda_u243$iv.addInitializer(Reflection.getOrCreateKotlinClass(SteamDetailVM.class), initializer$iv);
            ViewModel viewModel = ViewModelKt.viewModel(orCreateKotlinClass, current, (String) null, $this$viewModel_u24lambda_u243$iv.build(), current instanceof HasDefaultViewModelProviderFactory ? current.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, $composer4, ((384 << 3) & 112) | ((384 << 3) & 896), 0);
            $composer4.endReplaceableGroup();
            final SteamDetailVM viewModel2 = (SteamDetailVM) viewModel;
            ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer4, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer4.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4);
                $composer4.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final GameClipboardManager clipboardManager = ClipBoard_androidKt.rememberPlatformClipboardManager($composer4, 0);
            String spmidFrom3 = KntrGameReportService.INSTANCE.getSpmidFrom();
            PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger("game-ball.steam-game-list.0.0.pv", $composer4, 6);
            ComposerKt.sourceInformationMarkerStart($composer4, 1791355325, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv = $composer4.changedInstance(pvTrigger) | (($dirty2 & 14) == 4) | $composer4.changed(spmidFrom3);
            Object value$iv3 = $composer4.rememberedValue();
            if (invalid$iv || value$iv3 == Composer.Companion.getEmpty()) {
                spmidFrom = spmidFrom3;
                spmidFrom2 = "CC(remember):SteamDetailPage.kt#9igjgp";
                value$iv3 = new SteamDetailPageKt$SteamDetailPageContent$2$1(pvTrigger, "game-ball.steam-game-list", sourceFrom, spmidFrom3, null);
                $composer4.updateRememberedValue(value$iv3);
            } else {
                spmidFrom = spmidFrom3;
                spmidFrom2 = "CC(remember):SteamDetailPage.kt#9igjgp";
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(sourceFrom, (Function2) value$iv3, $composer4, $dirty2 & 14);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 1791363445, spmidFrom2);
            Object it$iv3 = $composer4.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda40
                    public final Object invoke(Object obj) {
                        DisposableEffectResult SteamDetailPageContent$lambda$3$0;
                        SteamDetailPageContent$lambda$3$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$3$0(r1, (DisposableEffectScope) obj);
                        return SteamDetailPageContent$lambda$3$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.DisposableEffect(unit, (Function1) it$iv3, $composer4, 54);
            ComposerKt.sourceInformationMarkerStart($composer4, 1791371656, spmidFrom2);
            Object it$iv4 = $composer4.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda41
                    public final Object invoke() {
                        Job SteamDetailPageContent$lambda$4$0;
                        SteamDetailPageContent$lambda$4$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$4$0(scope, viewModel2);
                        return SteamDetailPageContent$lambda$4$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            }
            final Function0 loadMore = (Function0) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            showNavigationFlag3 = showNavigationFlag2;
            ComposerKt.sourceInformationMarkerStart($composer4, 1791378939, spmidFrom2);
            Object it$iv5 = $composer4.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv6 = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4279464097L)), Color.box-impl(ColorKt.Color(4279049279L))}), 0.0f, 0.0f, 0, 14, (Object) null);
                $composer4.updateRememberedValue(value$iv6);
                it$iv5 = value$iv6;
            }
            final Brush steamBrush = (Brush) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = MultiTouchFilterKt.singleTouchOnly$default(BackgroundKt.background$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), steamBrush, (Shape) null, 0.0f, 6, (Object) null), 0L, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            Modifier modifier5 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            $composer2 = $composer4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((0 >> 6) & 112) | 6;
            BoxScope $this$SteamDetailPageContent_u24lambda_u246 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 1407679590, "C222@8361L13650:SteamDetailPage.kt#xy3gb6");
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -1812943485, "C238@8923L13078,232@8689L13312:SteamDetailPage.kt#xy3gb6");
            if (showNavigation) {
                $composer4.startReplaceGroup(-1813337372);
                ComposerKt.sourceInformation($composer4, "225@8487L174");
                $composer$iv = $composer4;
                $composer$iv2 = $composer4;
                SteamDetailTopAppBar(RoomRecommendViewModel.EMPTY_CURSOR, onBackPress2, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, $composer4, (($dirty2 >> 6) & 112) | 390, 8);
            } else {
                $composer$iv = $composer4;
                $composer$iv2 = $composer4;
                $composer4.startReplaceGroup(-1821745998);
            }
            $composer4.endReplaceGroup();
            modifier3 = modifier5;
            LoadComposableKt.LoadComposable(viewModel2, sourceFrom, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), false, false, ComposableLambdaKt.rememberComposableLambda(121651222, true, new Function5() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda42
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    Unit SteamDetailPageContent$lambda$6$0$0;
                    SteamDetailPageContent$lambda$6$0$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0(SteamDetailVM.this, steamBrush, scope, clipboardManager, sourceFrom, loadMore, (SteamDetailPageData) obj, (SteamDetailVM) obj2, (PageLoadMoreState) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    return SteamDetailPageContent$lambda$6$0$0;
                }
            }, $composer4, 54), $composer4, (($dirty2 << 3) & 112) | 224640, 0);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (showNavigation) {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(1420861626);
                ComposerKt.sourceInformation($composer3, "511@22092L586");
                Modifier modifier$iv3 = ClipKt.clipToBounds(ZIndexModifierKt.zIndex(PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs($this$SteamDetailPageContent_u24lambda_u246.align(Modifier.Companion, Alignment.Companion.getTopEnd()), Dp.constructor-impl(168)), Dp.constructor-impl(93)), 0.0f, Dp.constructor-impl(0), Dp.constructor-impl(53), 0.0f, 9, (Object) null), 1.0f));
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer3.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i10 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -2102719963, "C521@22447L217:SteamDetailPage.kt#xy3gb6");
                Modifier modifier6 = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(115)), Dp.constructor-impl(93));
                ImageRequest imageRequest = new ImageRequest("https://i0.hdslb.com/bfs/game/d5f155b6956b755f8954f5c4f37942521fc5732b.png");
                Unit unit2 = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), modifier6, (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 48, 508);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(1398940348);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onBackPress = onBackPress2;
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            showNavigationFlag3 = showNavigationFlag2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final String str = showNavigationFlag3;
            final Function0 function02 = onBackPress;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda44
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamDetailPageContent$lambda$7;
                    SteamDetailPageContent$lambda$7 = SteamDetailPageKt.SteamDetailPageContent$lambda$7(sourceFrom, modifier7, str, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamDetailPageContent$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SteamDetailVM SteamDetailPageContent$lambda$1$0(CreationExtras $this$viewModel) {
        Intrinsics.checkNotNullParameter($this$viewModel, "$this$viewModel");
        return new SteamDetailVM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult SteamDetailPageContent$lambda$3$0(final String $spmid, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.app.game.steam.SteamDetailPageKt$SteamDetailPageContent$lambda$3$0$$inlined$onDispose$1
            public void dispose() {
                KntrGameReportService.INSTANCE.setSpmidFrom($spmid);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job SteamDetailPageContent$lambda$4$0(CoroutineScope $scope, SteamDetailVM $viewModel) {
        return BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new SteamDetailPageKt$SteamDetailPageContent$loadMore$1$1$1($viewModel, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0637, code lost:
        if (r11.changedInstance(r93) == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0114, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0188, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0549, code lost:
        if (r94.changedInstance(r2) == false) goto L93;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x069c  */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SteamDetailPageContent$lambda$6$0$0(SteamDetailVM $viewModel, final Brush $steamBrush, final CoroutineScope $scope, final GameClipboardManager $clipboardManager, final String $sourceFrom, final Function0 $loadMore, final SteamDetailPageData page, final SteamDetailVM vm, final PageLoadMoreState loadMoreState, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        List exposedList;
        String str;
        Toaster toaster;
        Modifier materialized$iv$iv;
        Composer $composer$iv;
        LazyListState lazyListState;
        Composer $composer$iv$iv;
        CompositionLocalMap localMap$iv$iv;
        Composer $composer$iv$iv$iv;
        boolean z;
        Composer $composer$iv$iv$iv2;
        PageLoadMoreState pageLoadMoreState;
        boolean z2;
        boolean invalid$iv;
        Object value$iv;
        String str2;
        SteamDetailGameItem steamDetailGameItem;
        boolean z3;
        int i;
        Composer composer;
        Composer $composer$iv2;
        State reachEnd$delegate;
        Composer composer2;
        boolean invalid$iv2;
        Object value$iv2;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(vm, "vm");
        Intrinsics.checkNotNullParameter(loadMoreState, "loadMoreState");
        ComposerKt.sourceInformation($composer, "CN(page,vm,loadMoreState)242@9082L23,243@9140L232,250@9406L260,258@9711L7,259@9756L301,259@9735L322,269@10093L36,271@10175L98,271@10147L126,277@10340L1189,306@11579L9466,487@21174L687,487@21124L737:SteamDetailPage.kt#xy3gb6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(121651222, $changed, -1, "kntr.app.game.steam.SteamDetailPageContent.<anonymous>.<anonymous>.<anonymous> (SteamDetailPage.kt:240)");
        }
        String steamFriendCode = page.getSteamFriendCode();
        final int gameListTitleIndex = steamFriendCode == null || steamFriendCode.length() == 0 ? 3 : 4;
        final LazyListState lazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, $composer, 0, 3);
        ComposerKt.sourceInformationMarkerStart($composer, 942714526, "CC(remember):SteamDetailPage.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    boolean SteamDetailPageContent$lambda$6$0$0$0$0;
                    SteamDetailPageContent$lambda$6$0$0$0$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$0$0(lazyListState2, gameListTitleIndex);
                    return Boolean.valueOf(SteamDetailPageContent$lambda$6$0$0$0$0);
                }
            });
            $composer.updateRememberedValue(value$iv3);
            it$iv = value$iv3;
        }
        State showSticky$delegate = (State) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        List<SteamDetailGameItem> list = page.getList();
        Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
        ComposerKt.sourceInformationMarkerStart($composer, 942723066, "CC(remember):SteamDetailPage.kt#9igjgp");
        boolean invalid$iv3 = $composer.changed(valueOf);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv3 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv4 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda11
                public final Object invoke() {
                    boolean SteamDetailPageContent$lambda$6$0$0$2$0;
                    SteamDetailPageContent$lambda$6$0$0$2$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$2$0(lazyListState2);
                    return Boolean.valueOf(SteamDetailPageContent$lambda$6$0$0$2$0);
                }
            });
            $composer.updateRememberedValue(value$iv4);
            it$iv2 = value$iv4;
        }
        State reachEnd$delegate2 = (State) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        CompositionLocal this_$iv = ToasterKt.getLocalToaster();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Toaster toaster2 = (Toaster) consume;
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, 942734307, "CC(remember):SteamDetailPage.kt#9igjgp");
        boolean invalid$iv4 = $composer.changedInstance($viewModel) | $composer.changedInstance(toaster2);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv4) {
        }
        Object value$iv5 = (Function2) new SteamDetailPageKt$SteamDetailPageContent$4$1$1$1$1($viewModel, toaster2, null);
        $composer.updateRememberedValue(value$iv5);
        it$iv3 = value$iv5;
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(unit, (Function2) it$iv3, $composer, 6);
        ComposerKt.sourceInformationMarkerStart($composer, 942744826, "CC(remember):SteamDetailPage.kt#9igjgp");
        Object it$iv4 = $composer.rememberedValue();
        if (it$iv4 == Composer.Companion.getEmpty()) {
            Object value$iv6 = (List) new ArrayList();
            $composer.updateRememberedValue(value$iv6);
            it$iv4 = value$iv6;
        }
        List exposedList2 = (List) it$iv4;
        ComposerKt.sourceInformationMarkerEnd($composer);
        SteamGameListSortType sortType = vm.getSortType();
        ComposerKt.sourceInformationMarkerStart($composer, 942747512, "CC(remember):SteamDetailPage.kt#9igjgp");
        boolean invalid$iv5 = $composer.changedInstance(exposedList2);
        Object it$iv5 = $composer.rememberedValue();
        if (invalid$iv5) {
        }
        Object value$iv7 = (Function2) new SteamDetailPageKt$SteamDetailPageContent$4$1$1$2$1(exposedList2, null);
        $composer.updateRememberedValue(value$iv7);
        it$iv5 = value$iv7;
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(sortType, (Function2) it$iv5, $composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, 942753883, "CC(remember):SteamDetailPage.kt#9igjgp");
        Object it$iv6 = $composer.rememberedValue();
        if (it$iv6 == Composer.Companion.getEmpty()) {
            Object value$iv8 = new NestedScrollConnection() { // from class: kntr.app.game.steam.SteamDetailPageKt$SteamDetailPageContent$4$1$1$nestedScrollConnection$1$1
                /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
                public long m1281onPreScrollOzD1aCk(long j2, int i2) {
                    return Offset.Companion.getZero-F1C5BW0();
                }

                /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
                public long m1279onPostScrollDzOQY0M(long j2, long j3, int i2) {
                    return j3;
                }

                /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
                public Object m1280onPreFlingQWom1Mo(long j2, Continuation<? super Velocity> continuation) {
                    return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
                }

                /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
                public Object m1278onPostFlingRZ2iAVY(long j2, long j3, Continuation<? super Velocity> continuation) {
                    return Velocity.box-impl(j3);
                }
            };
            $composer.updateRememberedValue(value$iv8);
            it$iv6 = value$iv8;
        }
        SteamDetailPageKt$SteamDetailPageContent$4$1$1$nestedScrollConnection$1$1 nestedScrollConnection = (SteamDetailPageKt$SteamDetailPageContent$4$1$1$nestedScrollConnection$1$1) it$iv6;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (6 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv);
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
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
        int i2 = ($changed$iv$iv$iv >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i3 = ((6 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -7505828, "C332@12744L6,336@12944L8083,328@12559L8468:SteamDetailPage.kt#xy3gb6");
        if (SteamDetailPageContent$lambda$6$0$0$1(showSticky$delegate)) {
            $composer.startReplaceGroup(-7753612);
            ComposerKt.sourceInformation($composer, "308@11682L834");
            materialized$iv$iv = materialized$iv$iv2;
            $composer$iv = $composer;
            Modifier modifier$iv2 = BackgroundKt.background$default(ZIndexModifierKt.zIndex(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(72)), 2.0f), $steamBrush, (Shape) null, 0.0f, 6, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            toaster = toaster2;
            exposedList = exposedList2;
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i5 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1155412473, "C319@12218L188,316@12043L447:SteamDetailPage.kt#xy3gb6");
            SteamGameListSortType sortType2 = vm.getSortType();
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, -1976928679, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv6 = $composer.changedInstance($scope) | $composer.changedInstance(vm);
            Object value$iv9 = $composer.rememberedValue();
            if (!invalid$iv6 && value$iv9 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer);
                z = false;
                $composer$iv$iv$iv2 = $composer;
                $composer$iv$iv$iv = $composer;
                localMap$iv$iv = localMap$iv$iv2;
                str = "CC(remember):SteamDetailPage.kt#9igjgp";
                lazyListState = lazyListState2;
                $composer$iv$iv = $composer;
                SteamGameListCardTitle(page, value$iv9, modifier, sortType2, $composer, ($changed & 14) | 384, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
            }
            value$iv9 = new Function1() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj) {
                    Unit SteamDetailPageContent$lambda$6$0$0$8$0$0$0;
                    SteamDetailPageContent$lambda$6$0$0$8$0$0$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$0$0$0($scope, vm, (SteamGameListSortType) obj);
                    return SteamDetailPageContent$lambda$6$0$0$8$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv9);
            ComposerKt.sourceInformationMarkerEnd($composer);
            z = false;
            $composer$iv$iv$iv2 = $composer;
            $composer$iv$iv$iv = $composer;
            localMap$iv$iv = localMap$iv$iv2;
            str = "CC(remember):SteamDetailPage.kt#9igjgp";
            lazyListState = lazyListState2;
            $composer$iv$iv = $composer;
            SteamGameListCardTitle(page, value$iv9, modifier, sortType2, $composer, ($changed & 14) | 384, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
        } else {
            exposedList = exposedList2;
            str = "CC(remember):SteamDetailPage.kt#9igjgp";
            toaster = toaster2;
            materialized$iv$iv = materialized$iv$iv2;
            $composer$iv = $composer;
            lazyListState = lazyListState2;
            $composer$iv$iv = $composer;
            localMap$iv$iv = localMap$iv$iv2;
            $composer$iv$iv$iv = $composer;
            z = false;
            $composer$iv$iv$iv2 = $composer;
            $composer.startReplaceGroup(-19344698);
        }
        $composer.endReplaceGroup();
        Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(ClipKt.clipToBounds(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null)), nestedScrollConnection, (NestedScrollDispatcher) null, 2, (Object) null);
        String str3 = str;
        ComposerKt.sourceInformationMarkerStart($composer, -1524222353, str3);
        final List exposedList3 = exposedList;
        final Toaster toaster3 = toaster;
        boolean changedInstance = $composer.changedInstance(page) | $composer.changedInstance(exposedList3) | $composer.changedInstance(vm) | $composer.changedInstance($scope) | $composer.changedInstance($clipboardManager) | $composer.changedInstance(toaster3) | $composer.changed($sourceFrom);
        if ((($changed & 896) ^ 384) > 256) {
            pageLoadMoreState = loadMoreState;
        } else {
            pageLoadMoreState = loadMoreState;
        }
        if (($changed & 384) != 256) {
            z2 = z;
            invalid$iv = changedInstance | z2;
            value$iv = $composer.rememberedValue();
            if (!invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                str2 = str3;
                steamDetailGameItem = null;
                z3 = true;
                i = $changed;
                composer = $composer;
                $composer$iv2 = $composer$iv;
                reachEnd$delegate = reachEnd$delegate2;
                value$iv = new Function1() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj) {
                        Unit SteamDetailPageContent$lambda$6$0$0$8$1$0;
                        SteamDetailPageContent$lambda$6$0$0$8$1$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0(SteamDetailPageData.this, $steamBrush, exposedList3, vm, $scope, $clipboardManager, toaster3, $sourceFrom, loadMoreState, $loadMore, (LazyListScope) obj);
                        return SteamDetailPageContent$lambda$6$0$0$8$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                str2 = str3;
                i = $changed;
                steamDetailGameItem = null;
                $composer$iv2 = $composer$iv;
                z3 = true;
                composer = $composer;
                reachEnd$delegate = reachEnd$delegate2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(nestedScroll$default, lazyListState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer, 0, 508);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            Boolean valueOf2 = Boolean.valueOf(SteamDetailPageContent$lambda$6$0$0$3(reachEnd$delegate));
            List<SteamDetailGameItem> list2 = page.getList();
            SteamDetailGameItem steamDetailGameItem2 = list2 == null ? (SteamDetailGameItem) CollectionsKt.getOrNull(list2, 0) : steamDetailGameItem;
            ComposerKt.sourceInformationMarkerStart(composer, 943100069, str2);
            State reachEnd$delegate3 = reachEnd$delegate;
            boolean changed = composer.changed(reachEnd$delegate3);
            if (((i & 896) ^ 384) <= 256) {
                composer2 = composer;
            } else {
                composer2 = composer;
            }
            if ((i & 384) != 256) {
                z3 = false;
            }
            LazyListState lazyListState3 = lazyListState;
            invalid$iv2 = changed | z3 | composer2.changedInstance(page) | composer2.changed(lazyListState3);
            value$iv2 = $composer.rememberedValue();
            if (!invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = new SteamDetailPageKt$SteamDetailPageContent$4$1$1$4$1(loadMoreState, $loadMore, page, reachEnd$delegate3, lazyListState3, null);
                $composer.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf2, steamDetailGameItem2, (Function2) value$iv2, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return Unit.INSTANCE;
        }
        z2 = true;
        invalid$iv = changedInstance | z2;
        value$iv = $composer.rememberedValue();
        if (!invalid$iv) {
        }
        str2 = str3;
        steamDetailGameItem = null;
        z3 = true;
        i = $changed;
        composer = $composer;
        $composer$iv2 = $composer$iv;
        reachEnd$delegate = reachEnd$delegate2;
        value$iv = new Function1() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                Unit SteamDetailPageContent$lambda$6$0$0$8$1$0;
                SteamDetailPageContent$lambda$6$0$0$8$1$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0(SteamDetailPageData.this, $steamBrush, exposedList3, vm, $scope, $clipboardManager, toaster3, $sourceFrom, loadMoreState, $loadMore, (LazyListScope) obj);
                return SteamDetailPageContent$lambda$6$0$0$8$1$0;
            }
        };
        $composer.updateRememberedValue(value$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        LazyDslKt.LazyColumn(nestedScroll$default, lazyListState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer, 0, 508);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
        $composer$iv$iv$iv.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
        Boolean valueOf22 = Boolean.valueOf(SteamDetailPageContent$lambda$6$0$0$3(reachEnd$delegate));
        List<SteamDetailGameItem> list22 = page.getList();
        if (list22 == null) {
        }
        ComposerKt.sourceInformationMarkerStart(composer, 943100069, str2);
        State reachEnd$delegate32 = reachEnd$delegate;
        boolean changed2 = composer.changed(reachEnd$delegate32);
        if (((i & 896) ^ 384) <= 256) {
        }
        if ((i & 384) != 256) {
        }
        LazyListState lazyListState32 = lazyListState;
        invalid$iv2 = changed2 | z3 | composer2.changedInstance(page) | composer2.changed(lazyListState32);
        value$iv2 = $composer.rememberedValue();
        if (!invalid$iv2) {
        }
        value$iv2 = new SteamDetailPageKt$SteamDetailPageContent$4$1$1$4$1(loadMoreState, $loadMore, page, reachEnd$delegate32, lazyListState32, null);
        $composer.updateRememberedValue(value$iv2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(valueOf22, steamDetailGameItem2, (Function2) value$iv2, composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        return Unit.INSTANCE;
    }

    private static final boolean SteamDetailPageContent$lambda$6$0$0$1(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SteamDetailPageContent$lambda$6$0$0$0$0(LazyListState $lazyListState, int $gameListTitleIndex) {
        return $lazyListState.getFirstVisibleItemIndex() > $gameListTitleIndex + (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SteamDetailPageContent$lambda$6$0$0$3(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SteamDetailPageContent$lambda$6$0$0$2$0(LazyListState $lazyListState) {
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.lastOrNull($lazyListState.getLayoutInfo().getVisibleItemsInfo());
        return Intrinsics.areEqual(lazyListItemInfo != null ? lazyListItemInfo.getKey() : null, FOOTER_KEY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$0$0$0(CoroutineScope $scope, SteamDetailVM $vm, SteamGameListSortType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new SteamDetailPageKt$SteamDetailPageContent$4$1$1$3$1$1$1$1($vm, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$1$0(final SteamDetailPageData $page, final Brush $steamBrush, final List $exposedList, final SteamDetailVM $vm, final CoroutineScope $scope, final GameClipboardManager $clipboardManager, final Toaster $toaster, final String $sourceFrom, final PageLoadMoreState $loadMoreState, final Function0 $loadMore, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-361270991, true, new Function3() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda48
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$0;
                SteamDetailPageContent$lambda$6$0$0$8$1$0$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0$0($steamBrush, $page, $exposedList, $vm, $scope, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SteamDetailPageContent$lambda$6$0$0$8$1$0$0;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-385449432, true, new Function3() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda49
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$1;
                SteamDetailPageContent$lambda$6$0$0$8$1$0$1 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0$1($steamBrush, $page, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SteamDetailPageContent$lambda$6$0$0$8$1$0$1;
            }
        }), 3, (Object) null);
        final String it = $page.getSteamFriendCode();
        if (it != null) {
            if (it.length() > 0) {
                LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1561141974, true, new Function3() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda50
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0;
                        SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0($steamBrush, it, $scope, $clipboardManager, $toaster, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0;
                    }
                }), 3, (Object) null);
            }
        }
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1646257559, true, new Function3() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda51
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$3;
                SteamDetailPageContent$lambda$6$0$0$8$1$0$3 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0$3($steamBrush, $page, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SteamDetailPageContent$lambda$6$0$0$8$1$0$3;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1387901610, true, new Function3() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda52
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$4;
                SteamDetailPageContent$lambda$6$0$0$8$1$0$4 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0$4($steamBrush, $vm, $page, $scope, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SteamDetailPageContent$lambda$6$0$0$8$1$0$4;
            }
        }), 3, (Object) null);
        final List<SteamDetailGameItem> list = $page.getList();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        final Function2 key$iv = new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Object SteamDetailPageContent$lambda$6$0$0$8$1$0$5;
                SteamDetailPageContent$lambda$6$0$0$8$1$0$5 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0$5(((Integer) obj).intValue(), (SteamDetailGameItem) obj2);
                return SteamDetailPageContent$lambda$6$0$0$8$1$0$5;
            }
        };
        $this$LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: kntr.app.game.steam.SteamDetailPageKt$SteamDetailPageContent$lambda$6$0$0$8$1$0$$inlined$itemsIndexed$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return key$iv.invoke(Integer.valueOf(index), list.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: kntr.app.game.steam.SteamDetailPageKt$SteamDetailPageContent$lambda$6$0$0$8$1$0$$inlined$itemsIndexed$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                SteamDetailGameItem steamDetailGameItem = (SteamDetailGameItem) list.get(index);
                return "SteamDetailGameItem";
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.game.steam.SteamDetailPageKt$SteamDetailPageContent$lambda$6$0$0$8$1$0$$inlined$itemsIndexed$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, final int it2, Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it2) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                int $changed2 = ($dirty & 14) | ($dirty & 112);
                final SteamDetailGameItem item = (SteamDetailGameItem) list.get(it2);
                $composer.startReplaceGroup(1208646073);
                ComposerKt.sourceInformation($composer, "CN(index,item)*450@19244L761,447@19053L952,443@18830L1317:SteamDetailPage.kt#xy3gb6");
                final String key = "steam_game_list_" + item.getAppId();
                UserSteamInfo userSteamInfo = $page.getUserSteamInfo();
                String steamId = userSteamInfo != null ? userSteamInfo.getSteamId() : null;
                Modifier modifier = Modifier.Companion;
                ExposureConfig exposureConfig = new ExposureConfig(true, 0.0f, 0, 0L, 14, null);
                ComposerKt.sourceInformationMarkerStart($composer, -930827880, "CC(remember):SteamDetailPage.kt#9igjgp");
                boolean invalid$iv = (((($changed2 & 112) ^ 48) > 32 && $composer.changed(it2)) || ($changed2 & 48) == 32) | $composer.changedInstance($exposedList) | $composer.changed(key) | (((($changed2 & 896) ^ 384) > 256 && $composer.changed(item)) || ($changed2 & 384) == 256);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    final List list2 = $exposedList;
                    Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.app.game.steam.SteamDetailPageKt$SteamDetailPageContent$4$1$1$3$2$1$8$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1277invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m1277invoke() {
                            if (!list2.contains(key)) {
                                ReportKt.reportExposure("game-ball.steam-game-list.steam-game-list.list.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("app_id", item.getAppId()), TuplesKt.to(AdAlarmExtraKey.STATUS, "1"), TuplesKt.to("index", String.valueOf(it2))}));
                                list2.add(key);
                            }
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                SteamDetailPageKt.SteamGameListItem(item, steamId, ExposerKt.reportOnExposure(modifier, key, null, null, exposureConfig, (Function0) it$iv, $composer, (ExposureConfig.$stable << 12) | 6, 6), $sourceFrom, it2 == 0, $composer, ($changed2 >> 6) & 14, 0);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        $this$LazyColumn.item(FOOTER_KEY, "FOOTER", ComposableLambdaKt.composableLambdaInstance(127093483, true, new Function3() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$8;
                SteamDetailPageContent$lambda$6$0$0$8$1$0$8 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0$8(PageLoadMoreState.this, $page, $loadMore, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SteamDetailPageContent$lambda$6$0$0$8$1$0$8;
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01e5, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$0(Brush $steamBrush, final SteamDetailPageData $page, final List $exposedList, final SteamDetailVM $vm, final CoroutineScope $scope, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C344@13414L650,344@13334L730,339@13069L2030:SteamDetailPage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-361270991, $changed, -1, "kntr.app.game.steam.SteamDetailPageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamDetailPage.kt:338)");
            }
            Modifier background$default = BackgroundKt.background$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $steamBrush, (Shape) null, 0.0f, 6, (Object) null);
            ExposureConfig exposureConfig = new ExposureConfig(true, 0.0f, 0, 0L, 14, null);
            ComposerKt.sourceInformationMarkerStart($composer, 710943323, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($page) | $composer.changedInstance($exposedList);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$0$0$0;
                        SteamDetailPageContent$lambda$6$0$0$8$1$0$0$0$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0$0$0$0(SteamDetailPageData.this, $exposedList, r3);
                        return SteamDetailPageContent$lambda$6$0$0$8$1$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = ExposerKt.reportOnExposure(background$default, "steam_user_card", null, null, exposureConfig, (Function0) it$iv, $composer, (ExposureConfig.$stable << 12) | 54, 6);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
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
            ComposerKt.sourceInformationMarkerStart($composer, 1030631281, "C355@14164L16,358@14330L569,356@14213L782,371@15028L41:SteamDetailPage.kt#xy3gb6");
            State isRotating$delegate = SnapshotStateKt.collectAsState($vm.getRefreshSteam(), (CoroutineContext) null, $composer, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer, -243842464, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($scope) | $composer.changedInstance($vm);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$0$1$1$0;
                    SteamDetailPageContent$lambda$6$0$0$8$1$0$0$1$1$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0$0$1$1$0($scope, $vm);
                    return SteamDetailPageContent$lambda$6$0$0$8$1$0$0$1$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SteamUserCard($page, (Function0) it$iv2, SteamDetailPageContent$lambda$6$0$0$8$1$0$0$1$0(isRotating$delegate), null, $composer, 0, 8);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
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
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$0$0$0(SteamDetailPageData $page, List $exposedList, String $userCardKey) {
        if ($page.isLastRefreshWithin5Min() || $exposedList.contains($userCardKey)) {
            return Unit.INSTANCE;
        }
        ReportKt.reportExposure("game-ball.steam-game-list.steam-game-list.update-button.show", MapsKt.mapOf(TuplesKt.to(AdAlarmExtraKey.STATUS, "1")));
        $exposedList.add($userCardKey);
        return Unit.INSTANCE;
    }

    private static final boolean SteamDetailPageContent$lambda$6$0$0$8$1$0$0$1$0(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$0$1$1$0(CoroutineScope $scope, SteamDetailVM $vm) {
        ReportKt.reportClick("game-ball.steam-game-list.steam-game-list.update-button.click", MapsKt.mapOf(TuplesKt.to(AdAlarmExtraKey.STATUS, "1")));
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new SteamDetailPageKt$SteamDetailPageContent$4$1$1$3$2$1$1$2$1$1$1($vm, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$1(Brush $steamBrush, SteamDetailPageData $page, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C375@15185L417:SteamDetailPage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-385449432, $changed, -1, "kntr.app.game.steam.SteamDetailPageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamDetailPage.kt:375)");
            }
            Modifier modifier$iv = BackgroundKt.background$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $steamBrush, (Shape) null, 0.0f, 6, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -733546813, "C381@15474L24,382@15531L41:SteamDetailPage.kt#xy3gb6");
            SteamGameTotalCard($page, null, $composer, 0, 2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer, 6);
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
    /* JADX WARN: Code restructure failed: missing block: B:25:0x01be, code lost:
        if (r2 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0(Brush $steamBrush, final String $it, final CoroutineScope $scope, final GameClipboardManager $clipboardManager, final Toaster $toaster, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C393@16152L191,393@16112L231,388@15807L1347:SteamDetailPage.kt#xy3gb6");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1561141974, $changed, -1, "kntr.app.game.steam.SteamDetailPageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamDetailPage.kt:388)");
            }
            Modifier background$default = BackgroundKt.background$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $steamBrush, (Shape) null, 0.0f, 6, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1313863157, "CC(remember):SteamDetailPage.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0$0$0;
                        SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0$0$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0$0$0();
                        return SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = ExposerKt.reportOnExposure(background$default, "steam_id_card", null, null, null, (Function0) it$iv, $composer, 196662, 14);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
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
            ComposerKt.sourceInformationMarkerStart($composer, 1651926480, "C397@16461L572,397@16425L609,406@17075L41:SteamDetailPage.kt#xy3gb6");
            ComposerKt.sourceInformationMarkerStart($composer, 191836316, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($clipboardManager) | $composer.changed($it) | $composer.changedInstance($toaster);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda21
                public final Object invoke() {
                    Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0$1$0$0;
                    SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0$1$0$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0$1$0$0($scope, $clipboardManager, $it, $toaster);
                    return SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SteamGameIDCard($it, null, (Function0) it$iv2, $composer, 0, 2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer, 6);
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
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0$0$0() {
        ReportKt.reportExposure$default("game-ball.steam-game-list.steam-game-list.friendcode-copy-button.show", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$2$0$1$0$0(CoroutineScope $scope, GameClipboardManager $clipboardManager, String $it, Toaster $toaster) {
        ReportKt.reportClick$default("game-ball.steam-game-list.steam-game-list.friendcode-copy-button.click", null, 2, null);
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new SteamDetailPageKt$SteamDetailPageContent$4$1$1$3$2$1$3$1$2$1$1$1($clipboardManager, $it, $toaster, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$3(Brush $steamBrush, SteamDetailPageData $page, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C412@17304L243:SteamDetailPage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1646257559, $changed, -1, "kntr.app.game.steam.SteamDetailPageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamDetailPage.kt:412)");
            }
            Modifier modifier$iv = BackgroundKt.background$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $steamBrush, (Shape) null, 0.0f, 6, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1979454533, "C413@17412L31,414@17476L41:SteamDetailPage.kt#xy3gb6");
            SteamGameChartItem($page, null, $composer, 0, 2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer, 6);
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
    /* JADX WARN: Code restructure failed: missing block: B:21:0x017b, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$4(Brush $steamBrush, final SteamDetailVM $vm, SteamDetailPageData $page, final CoroutineScope $scope, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C418@17633L802:SteamDetailPage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1387901610, $changed, -1, "kntr.app.game.steam.SteamDetailPageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamDetailPage.kt:418)");
            }
            Modifier modifier$iv = BackgroundKt.background$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $steamBrush, (Shape) null, 0.0f, 6, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1069616544, "C427@18109L204,424@17922L483:SteamDetailPage.kt#xy3gb6");
            SteamGameListSortType sortType = $vm.getSortType();
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, -381132532, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($vm);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda32
                public final Object invoke(Object obj) {
                    Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$4$0$0$0;
                    SteamDetailPageContent$lambda$6$0$0$8$1$0$4$0$0$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0$4$0$0$0($scope, $vm, (SteamGameListSortType) obj);
                    return SteamDetailPageContent$lambda$6$0$0$8$1$0$4$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SteamGameListCardTitle($page, (Function1) it$iv, modifier, sortType, $composer, 384, 0);
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
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$4$0$0$0(CoroutineScope $scope, SteamDetailVM $vm, SteamGameListSortType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new SteamDetailPageKt$SteamDetailPageContent$4$1$1$3$2$1$5$1$1$1$1($vm, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SteamDetailPageContent$lambda$6$0$0$8$1$0$5(int index, SteamDetailGameItem steamDetailGameItem) {
        Intrinsics.checkNotNullParameter(steamDetailGameItem, "<unused var>");
        return Integer.valueOf(index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$8(PageLoadMoreState $loadMoreState, SteamDetailPageData $page, final Function0 $loadMore, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C:SteamDetailPage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(127093483, $changed, -1, "kntr.app.game.steam.SteamDetailPageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamDetailPage.kt:469)");
            }
            if (Intrinsics.areEqual($loadMoreState, PageLoadMoreState.Companion.getIdle())) {
                $composer.startReplaceGroup(1877756440);
                ComposerKt.sourceInformation($composer, "470@20357L13");
                FooterLoadingViewKt.LoadingMore(null, $composer, 0, 1);
                $composer.endReplaceGroup();
            } else if (Intrinsics.areEqual($loadMoreState, PageLoadMoreState.Companion.getLoading())) {
                $composer.startReplaceGroup(1877758840);
                ComposerKt.sourceInformation($composer, "471@20432L13");
                FooterLoadingViewKt.LoadingMore(null, $composer, 0, 1);
                $composer.endReplaceGroup();
            } else if (Intrinsics.areEqual($loadMoreState, PageLoadMoreState.Companion.getNoMore())) {
                $composer.startReplaceGroup(-1918934092);
                ComposerKt.sourceInformation($composer, RoomRecommendViewModel.EMPTY_CURSOR);
                List<SteamDetailGameItem> list = $page.getList();
                int size = list != null ? list.size() : 0;
                if (size > 0) {
                    $composer.startReplaceGroup(-1918823112);
                    ComposerKt.sourceInformation($composer, "475@20668L15");
                    FooterLoadingViewKt.LoadMoreEmpty(null, $composer, 0, 1);
                    $composer.endReplaceGroup();
                } else {
                    $composer.startReplaceGroup(-1918722765);
                    ComposerKt.sourceInformation($composer, "477@20769L20");
                    SteamGamelistEmpty(null, $composer, 0, 1);
                    $composer.endReplaceGroup();
                }
                $composer.endReplaceGroup();
            } else {
                if (Intrinsics.areEqual($loadMoreState, PageLoadMoreState.Companion.getError())) {
                    $composer.startReplaceGroup(1877774503);
                    ComposerKt.sourceInformation($composer, "480@20935L14,480@20921L28");
                    ComposerKt.sourceInformationMarkerStart($composer, 1877774937, "CC(remember):SteamDetailPage.kt#9igjgp");
                    Object it$iv = $composer.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda29
                            public final Object invoke() {
                                Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$8$0$0;
                                SteamDetailPageContent$lambda$6$0$0$8$1$0$8$0$0 = SteamDetailPageKt.SteamDetailPageContent$lambda$6$0$0$8$1$0$8$0$0($loadMore);
                                return SteamDetailPageContent$lambda$6$0$0$8$1$0$8$0$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    FooterLoadingViewKt.LoadMoreError(null, (Function0) it$iv, $composer, 48, 1);
                } else {
                    $composer.startReplaceGroup(-1939288041);
                }
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamDetailPageContent$lambda$6$0$0$8$1$0$8$0$0(Function0 $loadMore) {
        $loadMore.invoke();
        return Unit.INSTANCE;
    }

    public static final void SteamGamelistEmpty(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1698876144);
        ComposerKt.sourceInformation($composer2, "C(SteamGamelistEmpty)N(modifier)532@22770L703:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1698876144, $dirty, -1, "kntr.app.game.steam.SteamGamelistEmpty (SteamDetailPage.kt:531)");
            }
            Modifier modifier$iv$iv = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            Modifier modifier4 = modifier3;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 206300066, "C537@22948L41,539@23027L51,538@22998L176,543@23183L41,546@23298L6,544@23233L234:SteamDetailPage.kt#xy3gb6");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), $composer2, 6);
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_status_empty(CommonRes.INSTANCE.getDrawable()), $composer2, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 432, 120);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
            TextKt.Text-Nvy7gAk("暂无游戏数据", (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), TextUnitKt.getSp(20), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 1597446, 48, 258986);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda43
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGamelistEmpty$lambda$1;
                    SteamGamelistEmpty$lambda$1 = SteamDetailPageKt.SteamGamelistEmpty$lambda$1(modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGamelistEmpty$lambda$1;
                }
            });
        }
    }

    public static final void SteamUserCard(final SteamDetailPageData data, final Function0<Unit> function0, final boolean isRotating, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2;
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Function0 factory$iv$iv$iv3;
        Function0 value$iv;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(function0, "onClickRefresh");
        Composer $composer3 = $composer.startRestartGroup(1081917224);
        ComposerKt.sourceInformation($composer3, "C(SteamUserCard)N(data,onClickRefresh,isRotating,modifier)562@23639L5317:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(data) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(isRotating) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if ((i & 8) != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1081917224, $dirty2, -1, "kntr.app.game.steam.SteamUserCard (SteamDetailPage.kt:561)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(SizeKt.heightIn-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(50), 0.0f, 2, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(0));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            modifier2 = modifier3;
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i3 = ((390 >> 6) & 112) | 6;
            RowScope $this$SteamUserCard_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1059699457, "C571@23904L302,579@24215L40,581@24280L3087,652@27406L108,657@27551L307,657@27524L334,668@27868L39,670@27935L1015:SteamDetailPage.kt#xy3gb6");
            ImageRequest imageRequest = new ImageRequest("https://i0.hdslb.com/bfs/game/c3de2e5f23ed2f623a0c72de1c01731fce34b022.png");
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(50)), Dp.constructor-impl(50)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 0, 508);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer3, 6);
            Modifier modifier$iv2 = RowScope.-CC.weight$default($this$SteamUserCard_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -2069540120, "C584@24356L238,591@24607L40,597@24870L2487,593@24661L2696:SteamDetailPage.kt#xy3gb6");
            UserSteamInfo userSteamInfo = data.getUserSteamInfo();
            if (userSteamInfo == null || (str = userSteamInfo.getSteamUserName()) == null) {
                str = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(15), (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(21), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1597824, 48, 260010);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer3, 6);
            FlowLayoutKt.FlowRow(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(5)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(5)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-1094242649, true, new Function3() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda35
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SteamUserCard$lambda$0$0$0;
                    SteamUserCard$lambda$0$0$0 = SteamDetailPageKt.SteamUserCard$lambda$0$0$0(SteamDetailPageData.this, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SteamUserCard$lambda$0$0$0;
                }
            }, $composer3, 54), $composer3, 1573302, 56);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 727027640, "CC(remember):SteamDetailPage.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            Animatable rotateAnim = (Animatable) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Boolean valueOf = Boolean.valueOf(isRotating);
            ComposerKt.sourceInformationMarkerStart($composer3, 727032479, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(rotateAnim) | (($dirty2 & 896) == 256);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new SteamDetailPageKt$SteamUserCard$1$2$1(isRotating, rotateAnim, null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer3, ($dirty2 >> 6) & 14);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer3, 6);
            Modifier modifier$iv3 = SizeKt.heightIn-VpY3zN4$default(SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(50), 1, (Object) null), Dp.constructor-impl(50), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv3 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i7 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 312910847, "C688@28646L40,689@28699L241:SteamDetailPage.kt#xy3gb6");
            if (!data.isLastRefreshWithin5Min()) {
                $composer3.startReplaceGroup(312936855);
                ComposerKt.sourceInformation($composer3, "677@28265L22,683@28539L20,676@28216L402");
                Painter arrow_refresh_line_500 = BiliIconfont.INSTANCE.getArrow_refresh_line_500($composer3, 6);
                Modifier rotate = RotateKt.rotate(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), ((Number) rotateAnim.getValue()).floatValue());
                ComposerKt.sourceInformationMarkerStart($composer3, 1949767885, "CC(remember):SteamDetailPage.kt#9igjgp");
                boolean invalid$iv2 = ($dirty2 & 112) == 32;
                Object it$iv3 = $composer3.rememberedValue();
                if (!invalid$iv2 && it$iv3 != Composer.Companion.getEmpty()) {
                    value$iv = it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    IconKt.Icon-ww6aTOc(arrow_refresh_line_500, "Refresh", ClickableKt.clickable-oSLSa3U$default(rotate, false, (String) null, (Role) null, (MutableInteractionSource) null, value$iv, 15, (Object) null), Color.Companion.getWhite-0d7_KjU(), $composer3, Painter.$stable | 3120, 0);
                }
                value$iv = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda36
                    public final Object invoke() {
                        Unit SteamUserCard$lambda$0$3$0$0;
                        SteamUserCard$lambda$0$3$0$0 = SteamDetailPageKt.SteamUserCard$lambda$0$3$0$0(function0);
                        return SteamUserCard$lambda$0$3$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                IconKt.Icon-ww6aTOc(arrow_refresh_line_500, "Refresh", ClickableKt.clickable-oSLSa3U$default(rotate, false, (String) null, (Role) null, (MutableInteractionSource) null, value$iv, 15, (Object) null), Color.Companion.getWhite-0d7_KjU(), $composer3, Painter.$stable | 3120, 0);
            } else {
                $composer3.startReplaceGroup(284949993);
            }
            $composer3.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer3, 6);
            TextKt.Text-Nvy7gAk(data.lastRefreshTimeDesc(), (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(9), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), TextUnitKt.getSp(12), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24960, 48, 259050);
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
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda37
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamUserCard$lambda$1;
                    SteamUserCard$lambda$1 = SteamDetailPageKt.SteamUserCard$lambda$1(SteamDetailPageData.this, function0, isRotating, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamUserCard$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamUserCard$lambda$0$0$0(SteamDetailPageData $data, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        Composer composer;
        long j2;
        long j3;
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation($composer, "C601@25068L9,598@24888L453:SteamDetailPage.kt#xy3gb6");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1094242649, $changed, -1, "kntr.app.game.steam.SteamUserCard.<anonymous>.<anonymous>.<anonymous> (SteamDetailPage.kt:598)");
            }
            UserSteamInfo userSteamInfo = $data.getUserSteamInfo();
            TextKt.Text-Nvy7gAk("等级 : Lv." + (userSteamInfo != null ? Integer.valueOf(userSteamInfo.getSteamUserLevel()) : null), PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU(Modifier.Companion, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), 0.0f, Dp.constructor-impl(4), Dp.constructor-impl(1), 2, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 384, 0, 131064);
            UserSteamInfo userSteamInfo2 = $data.getUserSteamInfo();
            String createdYears = userSteamInfo2 != null ? userSteamInfo2.createdYears() : null;
            String str = createdYears;
            if (str == null || str.length() == 0) {
                composer = $composer;
                composer.startReplaceGroup(194348251);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(219644592);
                ComposerKt.sourceInformation($composer, "612@25651L9,609@25485L459");
                TextKt.Text-Nvy7gAk("年限：" + createdYears + "年", PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU(Modifier.Companion, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), 0.0f, Dp.constructor-impl(4), Dp.constructor-impl(1), 2, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 384, 0, 131064);
                $composer.endReplaceGroup();
                composer = $composer;
            }
            UserSteamInfo userSteamInfo3 = $data.getUserSteamInfo();
            String it = userSteamInfo3 != null ? userSteamInfo3.personStateDesc() : null;
            if (it == null) {
                composer.startReplaceGroup(220201134);
                $composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(220201135);
                ComposerKt.sourceInformation(composer, "*633@26602L9,623@26157L1168");
                if (!(it.length() == 0)) {
                    int state = $data.getUserSteamInfo().getPersonState();
                    switch (state) {
                        case 0:
                            j2 = Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                            break;
                        case 1:
                            j2 = ColorKt.Color(4280993892L);
                            break;
                        default:
                            j2 = ColorKt.Color(4278234860L);
                            break;
                    }
                    TextStyle t12 = BiliTheme.INSTANCE.getTextStyle(composer, BiliTheme.$stable).getT12();
                    Modifier modifier = Modifier.Companion;
                    switch (state) {
                        case 0:
                            j3 = Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                            break;
                        case 1:
                            j3 = Color.copy-wmQWz5c$default(ColorKt.Color(4280993892L), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                            break;
                        default:
                            j3 = Color.copy-wmQWz5c$default(ColorKt.Color(4278234860L), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                            break;
                    }
                    TextKt.Text-Nvy7gAk(it, PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU(modifier, j3, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), Dp.constructor-impl(4), 0.0f, Dp.constructor-impl(4), Dp.constructor-impl(1), 2, (Object) null), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t12, $composer, 0, 0, 131064);
                }
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamUserCard$lambda$0$3$0$0(Function0 $onClickRefresh) {
        $onClickRefresh.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v17 */
    public static final void SteamGameIDCard(final String code, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Composer $composer2;
        Modifier modifier3;
        Function0 onCopy;
        final Function0 onCopy2;
        Intrinsics.checkNotNullParameter(code, "code");
        Composer $composer3 = $composer.startRestartGroup(1238511423);
        ComposerKt.sourceInformation($composer3, "C(SteamGameIDCard)N(code,modifier,onCopy)704@29071L2,714@29437L12,706@29083L1404:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(code) ? 4 : 2;
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
            function02 = function0;
        } else if (($changed & 384) == 0) {
            function02 = function0;
            $dirty |= $composer3.changedInstance(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 503539681, "CC(remember):SteamDetailPage.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onCopy3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onCopy2 = onCopy3;
            } else {
                onCopy2 = function02;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1238511423, $dirty2, -1, "kntr.app.game.steam.SteamGameIDCard (SteamDetailPage.kt:705)");
            }
            Modifier modifier5 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(PaddingKt.padding-VpY3zN4(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(34)), Dp.constructor-impl(10), Dp.constructor-impl(0)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.06f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Dp.constructor-impl(10), Dp.constructor-impl(0));
            ComposerKt.sourceInformationMarkerStart($composer3, 503551403, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit SteamGameIDCard$lambda$1$0;
                        SteamGameIDCard$lambda$1$0 = SteamDetailPageKt.SteamGameIDCard$lambda$1$0(onCopy2);
                        return SteamGameIDCard$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((384 >> 6) & 112) | 6;
            RowScope $this$SteamGameIDCard_u24lambda_u242 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 774193546, "C720@29637L9,717@29523L138,722@29670L39,727@29865L9,723@29718L215,730@29942L38,731@29989L198,738@30196L39,740@30285L13,739@30244L237:SteamDetailPage.kt#xy3gb6");
            TextKt.Text-Nvy7gAk("好友码", (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, 390, 0, 131066);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer3, 6);
            modifier3 = modifier4;
            onCopy = onCopy2;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(code, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(1), 0.0f, 0.0f, 13, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, ($dirty2 & 14) | 1573296, 0, 131000);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$SteamGameIDCard_u24lambda_u242, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
            TextKt.Text-Nvy7gAk("复制", (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(17), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1597830, 48, 260010);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(1)), $composer3, 6);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCopy_line_500($composer3, 6), "copy", PaddingKt.padding-qDBjuR0$default(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(15)), Dp.constructor-impl(12)), 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer3, Painter.$stable | 3504, 0);
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
            onCopy = function02;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function0 function03 = onCopy;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGameIDCard$lambda$3;
                    SteamGameIDCard$lambda$3 = SteamDetailPageKt.SteamGameIDCard$lambda$3(code, modifier6, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGameIDCard$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameIDCard$lambda$1$0(Function0 $onCopy) {
        $onCopy.invoke();
        return Unit.INSTANCE;
    }

    public static final void SteamGameTotalCard(final SteamDetailPageData data, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Function0 factory$iv$iv$iv3;
        String playHourLast2weeksAll;
        String playHourAll;
        String gamesCount;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer $composer3 = $composer.startRestartGroup(805158563);
        ComposerKt.sourceInformation($composer3, "C(SteamGameTotalCard)N(data,modifier)753@30601L2415:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(data) ? 4 : 2;
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
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(805158563, $dirty, -1, "kntr.app.game.steam.SteamGameTotalCard (SteamDetailPage.kt:752)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(PaddingKt.padding-VpY3zN4(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(61)), Dp.constructor-impl(10), Dp.constructor-impl(0)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.06f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Dp.constructor-impl(10), Dp.constructor-impl(8));
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            String str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier modifier$iv$iv = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            Composer $composer$iv = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            Composer $composer4 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer4, 169020634, "C763@30998L1042,789@32101L909:SteamDetailPage.kt#xy3gb6");
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20));
            String str4 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            String str5 = "C101@5233L9:Row.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((6 >> 6) & 112) | 6;
            RowScope $this$SteamGameTotalCard_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            String str6 = "C:SteamDetailPage.kt#xy3gb6";
            ComposerKt.sourceInformationMarkerStart($composer4, 1754835670, "C:SteamDetailPage.kt#xy3gb6");
            StatisticOverview statisticOverview = data.getStatisticOverview();
            if (statisticOverview == null || (str = statisticOverview.getTotalPrice()) == null) {
                str = AdSearchSubCardType.CARD_TYPE_NONE;
            }
            StatisticOverview statisticOverview2 = data.getStatisticOverview();
            String str7 = (statisticOverview2 == null || (gamesCount = statisticOverview2.getGamesCount()) == null) ? AdSearchSubCardType.CARD_TYPE_NONE : gamesCount;
            StatisticOverview statisticOverview3 = data.getStatisticOverview();
            String str8 = (statisticOverview3 == null || (playHourAll = statisticOverview3.getPlayHourAll()) == null) ? AdSearchSubCardType.CARD_TYPE_NONE : playHourAll;
            StatisticOverview statisticOverview4 = data.getStatisticOverview();
            List values = CollectionsKt.listOf(new String[]{str, str7, str8, (statisticOverview4 == null || (playHourLast2weeksAll = statisticOverview4.getPlayHourLast2weeksAll()) == null) ? AdSearchSubCardType.CARD_TYPE_NONE : playHourLast2weeksAll});
            $composer4.startReplaceGroup(-1190307878);
            ComposerKt.sourceInformation($composer4, "*773@31431L585");
            List $this$forEach$iv = values;
            boolean z = false;
            Iterator it = $this$forEach$iv.iterator();
            while (it.hasNext()) {
                Object element$iv = it.next();
                String it2 = (String) element$iv;
                List values2 = values;
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                boolean z2 = z;
                Iterator it3 = it;
                Modifier modifier$iv3 = SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$SteamGameTotalCard_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
                Composer $composer$iv2 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, str2);
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                String str9 = str6;
                String str10 = str5;
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                String str11 = str2;
                String str12 = str4;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, str3);
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer4.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                Composer $composer5 = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i8 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 2104139351, "C778@31693L9,779@31756L68,774@31505L493:SteamDetailPage.kt#xy3gb6");
                TextKt.Text-Nvy7gAk(it2, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer4, 0, 14)}), 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT16(), $composer4, 432, 24960, 109432);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $this$forEach$iv = $this$forEach$iv2;
                z = z2;
                it = it3;
                $composer$iv = $composer$iv2;
                values = values2;
                str5 = str10;
                str6 = str9;
                str4 = str12;
                str2 = str11;
                str3 = str3;
                $composer4 = $composer5;
            }
            String str13 = str5;
            String str14 = str6;
            Composer $composer6 = $composer4;
            Composer $composer$iv3 = $composer$iv;
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv4 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(17));
            ComposerKt.sourceInformationMarkerStart($composer6, 844473419, str4);
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer6, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv4 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, str2);
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer6, modifier$iv4);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, str3);
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                $composer6.createNode(factory$iv$iv$iv7);
            } else {
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, str13);
            int i10 = ((6 >> 6) & 112) | 6;
            RowScope $this$SteamGameTotalCard_u24lambda_u240_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer6, 1331725618, str14);
            StatisticOverview statisticOverview5 = data.getStatisticOverview();
            String str15 = (statisticOverview5 == null || (str15 = statisticOverview5.getTotalPriceText()) == null) ? "账号价值" : "账号价值";
            StatisticOverview statisticOverview6 = data.getStatisticOverview();
            String str16 = (statisticOverview6 == null || (str16 = statisticOverview6.getGamesCountText()) == null) ? "游戏数量" : "游戏数量";
            StatisticOverview statisticOverview7 = data.getStatisticOverview();
            String str17 = (statisticOverview7 == null || (r48 = statisticOverview7.getPlayHourAllText()) == null) ? "游戏时长h" : "游戏时长h";
            StatisticOverview statisticOverview8 = data.getStatisticOverview();
            List titles = CollectionsKt.listOf(new String[]{str15, str16, str17, (statisticOverview8 == null || (r48 = statisticOverview8.getPlayHourLast2weeksAllText()) == null) ? "近两周时长h" : "近两周时长h"});
            $composer6.startReplaceGroup(-1896692289);
            ComposerKt.sourceInformation($composer6, "*803@32768L9,799@32565L421");
            List $this$forEach$iv3 = titles;
            boolean z3 = false;
            Iterator it4 = $this$forEach$iv3.iterator();
            while (it4.hasNext()) {
                Object element$iv2 = it4.next();
                String it5 = (String) element$iv2;
                TextKt.Text-Nvy7gAk(it5, SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$SteamGameTotalCard_u24lambda_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getClip-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT12(), $composer6, 1573248, 24960, 109496);
                z3 = z3;
                it4 = it4;
                $this$forEach$iv3 = $this$forEach$iv3;
                titles = titles;
            }
            $composer6.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            $composer6.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier$iv$iv;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda31
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGameTotalCard$lambda$1;
                    SteamGameTotalCard$lambda$1 = SteamDetailPageKt.SteamGameTotalCard$lambda$1(SteamDetailPageData.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGameTotalCard$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0579, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L62;
     */
    /* JADX WARN: Removed duplicated region for block: B:152:0x08f0  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0933  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0966  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0979  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0a11  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0a1d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0a23  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0a9d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0ab0  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0c25  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0c30  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0db9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x05b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SteamGameChartItem(final SteamDetailPageData data, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3;
        final long debounceDelay;
        Modifier modifier3;
        Object value$iv;
        List timeChartData;
        boolean invalid$iv;
        Object it$iv;
        Iterable priceDistributionChart;
        Object value$iv2;
        List priceChartData;
        Object it$iv2;
        Function0 factory$iv$iv$iv3;
        Float valueOf;
        int i2;
        float maxValue;
        Float valueOf2;
        int i3;
        Object value$iv3;
        boolean invalid$iv2;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer $composer4 = $composer.startRestartGroup(-1275287296);
        ComposerKt.sourceInformation($composer4, "C(SteamGameChartItem)N(data,modifier)819@33146L33,820@33201L34,821@33283L28,824@33359L8686:SteamDetailPage.kt#xy3gb6");
        int currentMarker = $composer4.getCurrentMarker();
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(data) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer4.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1275287296, $dirty, -1, "kntr.app.game.steam.SteamGameChartItem (SteamDetailPage.kt:818)");
            }
            ComposerKt.sourceInformationMarkerStart($composer4, -1485408415, "CC(remember):SteamDetailPage.kt#9igjgp");
            Object it$iv3 = $composer4.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            final MutableState isFolded$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -1485406654, "CC(remember):SteamDetailPage.kt#9igjgp");
            Object it$iv4 = $composer4.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv5 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            }
            final MutableState showPrice$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -1485404036, "CC(remember):SteamDetailPage.kt#9igjgp");
            Object it$iv5 = $composer4.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                long[] jArr = {0};
                $composer4.updateRememberedValue(jArr);
                it$iv5 = jArr;
            }
            final long[] lastClickTimeRef = (long[]) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(10), Dp.constructor-impl(0));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            final Modifier modifier$iv$iv = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((432 >> 6) & 112) | 6;
            $composer4.startReplaceGroup(-2015283760);
            ComposerKt.sourceInformation($composer4, "C829@33582L3442,909@37107L34,910@37169L34,914@37273L125,919@37441L119,924@37612L633,924@37586L659,945@38297L3742:SteamDetailPage.kt#xy3gb6");
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i8 = ((390 >> 6) & 112) | 6;
            RowScope $this$SteamGameChartItem_u24lambda_u247_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -429596692, "C836@33842L9,833@33733L184,839@33930L38,880@36061L40,882@36159L28,888@36423L24,881@36114L403,895@36696L76,891@36530L484:SteamDetailPage.kt#xy3gb6");
            TextKt.Text-Nvy7gAk("游戏数分布", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT13b(), $composer4, 390, 0, 130042);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$SteamGameChartItem_u24lambda_u247_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer4, 0);
            if (SteamGameChartItem$lambda$1(isFolded$delegate)) {
                $composer3 = $composer4;
                debounceDelay = 300;
                $composer4.startReplaceGroup(-463162532);
            } else {
                $composer4.startReplaceGroup(-429373896);
                ComposerKt.sourceInformation($composer4, "846@34325L465,857@34950L9,841@34014L973,859@35004L39,866@35372L465,877@35997L9,861@35061L973");
                Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU(Modifier.Companion, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), SteamGameChartItem$lambda$4(showPrice$delegate) ? 0.06f : 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), 0.0f, Dp.constructor-impl(4), Dp.constructor-impl(1), 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer4, 955989495, "CC(remember):SteamDetailPage.kt#9igjgp");
                boolean invalid$iv3 = $composer4.changedInstance(lastClickTimeRef);
                Object it$iv6 = $composer4.rememberedValue();
                if (!invalid$iv3 && it$iv6 != Composer.Companion.getEmpty()) {
                    value$iv3 = it$iv6;
                    debounceDelay = 300;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    TextKt.Text-Nvy7gAk("游戏时长", ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv3, 15, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), !SteamGameChartItem$lambda$4(showPrice$delegate) ? 0.6f : 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12_cozy(), $composer4, 6, 0, 131064);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer4, 6);
                    $composer3 = $composer4;
                    Modifier modifier6 = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU(Modifier.Companion, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), !SteamGameChartItem$lambda$4(showPrice$delegate) ? 0.2f : 0.06f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), 0.0f, Dp.constructor-impl(4), Dp.constructor-impl(1), 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer4, 956022999, "CC(remember):SteamDetailPage.kt#9igjgp");
                    invalid$iv2 = $composer4.changedInstance(lastClickTimeRef);
                    Object it$iv7 = $composer4.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv6 = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda24
                        public final Object invoke() {
                            Unit SteamGameChartItem$lambda$7$0$1$0;
                            SteamGameChartItem$lambda$7$0$1$0 = SteamDetailPageKt.SteamGameChartItem$lambda$7$0$1$0(lastClickTimeRef, debounceDelay, showPrice$delegate);
                            return SteamGameChartItem$lambda$7$0$1$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv6);
                    it$iv7 = value$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    TextKt.Text-Nvy7gAk("游戏价格", ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv7, 15, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), !SteamGameChartItem$lambda$4(showPrice$delegate) ? 0.8f : 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12_cozy(), $composer4, 6, 0, 131064);
                }
                debounceDelay = 300;
                Object obj = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda23
                    public final Object invoke() {
                        Unit SteamGameChartItem$lambda$7$0$0$0;
                        SteamGameChartItem$lambda$7$0$0$0 = SteamDetailPageKt.SteamGameChartItem$lambda$7$0$0$0(lastClickTimeRef, r2, showPrice$delegate);
                        return SteamGameChartItem$lambda$7$0$0$0;
                    }
                };
                $composer4.updateRememberedValue(obj);
                value$iv3 = obj;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                TextKt.Text-Nvy7gAk("游戏时长", ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv3, 15, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), !SteamGameChartItem$lambda$4(showPrice$delegate) ? 0.6f : 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12_cozy(), $composer4, 6, 0, 131064);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer4, 6);
                $composer3 = $composer4;
                Modifier modifier62 = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU(Modifier.Companion, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), !SteamGameChartItem$lambda$4(showPrice$delegate) ? 0.2f : 0.06f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), 0.0f, Dp.constructor-impl(4), Dp.constructor-impl(1), 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer4, 956022999, "CC(remember):SteamDetailPage.kt#9igjgp");
                invalid$iv2 = $composer4.changedInstance(lastClickTimeRef);
                Object it$iv72 = $composer4.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv62 = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda24
                    public final Object invoke() {
                        Unit SteamGameChartItem$lambda$7$0$1$0;
                        SteamGameChartItem$lambda$7$0$1$0 = SteamDetailPageKt.SteamGameChartItem$lambda$7$0$1$0(lastClickTimeRef, debounceDelay, showPrice$delegate);
                        return SteamGameChartItem$lambda$7$0$1$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv62);
                it$iv72 = value$iv62;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                TextKt.Text-Nvy7gAk("游戏价格", ClickableKt.clickable-oSLSa3U$default(modifier62, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv72, 15, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), !SteamGameChartItem$lambda$4(showPrice$delegate) ? 0.8f : 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12_cozy(), $composer4, 6, 0, 131064);
            }
            $composer4.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(15)), $composer4, 6);
            Painter arrow_forward_right_line_500 = BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer4, 6);
            Modifier rotate = RotateKt.rotate(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), SteamGameChartItem$lambda$1(isFolded$delegate) ? 90.0f : 270.0f);
            ComposerKt.sourceInformationMarkerStart($composer4, 956056190, "CC(remember):SteamDetailPage.kt#9igjgp");
            Object it$iv8 = $composer4.rememberedValue();
            if (it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv7 = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda25
                    public final Object invoke() {
                        Unit SteamGameChartItem$lambda$7$0$2$0;
                        SteamGameChartItem$lambda$7$0$2$0 = SteamDetailPageKt.SteamGameChartItem$lambda$7$0$2$0(isFolded$delegate);
                        return SteamGameChartItem$lambda$7$0$2$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv7);
                it$iv8 = value$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            IconKt.Icon-ww6aTOc(arrow_forward_right_line_500, "fold", ClickableKt.clickable-oSLSa3U$default(rotate, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv8, 15, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer4, Painter.$stable | 3120, 0);
            Modifier modifier7 = PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(4), Dp.constructor-impl(0));
            ComposerKt.sourceInformationMarkerStart($composer4, 956064978, "CC(remember):SteamDetailPage.kt#9igjgp");
            Object it$iv9 = $composer4.rememberedValue();
            if (it$iv9 == Composer.Companion.getEmpty()) {
                Object value$iv8 = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda26
                    public final Object invoke() {
                        Unit SteamGameChartItem$lambda$7$0$3$0;
                        SteamGameChartItem$lambda$7$0$3$0 = SteamDetailPageKt.SteamGameChartItem$lambda$7$0$3$0(isFolded$delegate);
                        return SteamGameChartItem$lambda$7$0$3$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv8);
                it$iv9 = value$iv8;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            TextKt.Text-Nvy7gAk(SteamGameChartItem$lambda$1(isFolded$delegate) ? "展开" : "收起", ClickableKt.clickable-oSLSa3U$default(modifier7, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv9, 15, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(17), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer4, 1597824, 48, 260008);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (SteamGameChartItem$lambda$1(isFolded$delegate)) {
                $composer3.endToMarker(currentMarker);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda27
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit SteamGameChartItem$lambda$7$1;
                            SteamGameChartItem$lambda$7$1 = SteamDetailPageKt.SteamGameChartItem$lambda$7$1(SteamDetailPageData.this, modifier$iv$iv, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                            return SteamGameChartItem$lambda$7$1;
                        }
                    });
                    return;
                }
                return;
            }
            Composer $composer5 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer5, 627831884, "CC(remember):SteamDetailPage.kt#9igjgp");
            Object it$iv10 = $composer5.rememberedValue();
            if (it$iv10 == Composer.Companion.getEmpty()) {
                Object value$iv9 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer5.updateRememberedValue(value$iv9);
                it$iv10 = value$iv9;
            }
            MutableState priceExposed$delegate = (MutableState) it$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, 627833868, "CC(remember):SteamDetailPage.kt#9igjgp");
            Object it$iv11 = $composer5.rememberedValue();
            if (it$iv11 == Composer.Companion.getEmpty()) {
                modifier3 = modifier$iv$iv;
                Object value$iv10 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer5.updateRememberedValue(value$iv10);
                it$iv11 = value$iv10;
            } else {
                modifier3 = modifier$iv$iv;
            }
            MutableState timeExposed$delegate = (MutableState) it$iv11;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            List<SteamChartData> playtimeDistributionChart = data.getPlaytimeDistributionChart();
            ComposerKt.sourceInformationMarkerStart($composer5, 627837287, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv4 = $composer5.changed(playtimeDistributionChart);
            Object it$iv12 = $composer5.rememberedValue();
            if (!invalid$iv4 && it$iv12 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer5);
                timeChartData = (List) it$iv12;
                List<SteamChartData> priceDistributionChart2 = data.getPriceDistributionChart();
                ComposerKt.sourceInformationMarkerStart($composer5, 627842657, "CC(remember):SteamDetailPage.kt#9igjgp");
                invalid$iv = $composer5.changed(priceDistributionChart2);
                it$iv = $composer5.rememberedValue();
                if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    priceDistributionChart = data.getPriceDistributionChart();
                    if (priceDistributionChart == null) {
                        Iterable $this$map$iv = priceDistributionChart;
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            SteamChartData it = (SteamChartData) item$iv$iv;
                            destination$iv$iv.add(BarData(it));
                            $this$map$iv = $this$map$iv;
                        }
                        value$iv2 = (List) destination$iv$iv;
                    } else {
                        value$iv2 = null;
                    }
                    $composer5.updateRememberedValue(value$iv2);
                    it$iv = value$iv2;
                }
                priceChartData = (List) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                Boolean valueOf3 = Boolean.valueOf(SteamGameChartItem$lambda$4(showPrice$delegate));
                ComposerKt.sourceInformationMarkerStart($composer5, 627848643, "CC(remember):SteamDetailPage.kt#9igjgp");
                it$iv2 = $composer5.rememberedValue();
                if (it$iv2 != Composer.Companion.getEmpty()) {
                    Object value$iv11 = (Function2) new SteamDetailPageKt$SteamGameChartItem$1$3$1(showPrice$delegate, priceExposed$delegate, timeExposed$delegate, null);
                    $composer5.updateRememberedValue(value$iv11);
                    it$iv2 = value$iv11;
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                EffectsKt.LaunchedEffect(valueOf3, (Function2) it$iv2, $composer5, 0);
                Modifier modifier$iv3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(110));
                ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv3 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer5, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer5.startReusableNode();
                if ($composer5.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer5.useNode();
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer5.createNode(factory$iv$iv$iv3);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer5);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i10 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer5, 1430950587, "C:SteamDetailPage.kt#xy3gb6");
                if (timeChartData != null) {
                    $composer5.startReplaceGroup(1430907991);
                    $composer5.endReplaceGroup();
                } else {
                    $composer5.startReplaceGroup(1430907992);
                    ComposerKt.sourceInformation($composer5, "*960@38912L1264");
                    Iterator it2 = timeChartData.iterator();
                    if (it2.hasNext()) {
                        float value = ((BarData) it2.next()).getValue();
                        while (it2.hasNext()) {
                            value = Math.max(value, ((BarData) it2.next()).getValue());
                            timeChartData = timeChartData;
                        }
                        valueOf = Float.valueOf(value);
                    } else {
                        valueOf = null;
                    }
                    float maxCount = valueOf != null ? valueOf.floatValue() : 0.0f;
                    if (maxCount < 10.0f) {
                        i2 = 1;
                        maxValue = 10.0f;
                    } else if (maxCount < 50.0f) {
                        i2 = 1;
                        maxValue = 50.0f;
                    } else if (maxCount < 100.0f) {
                        maxValue = 100.0f;
                        i2 = 1;
                    } else {
                        i2 = 1;
                        maxValue = (((int) (maxCount / 100)) + 1) * 100.0f;
                    }
                    BarChartKt.BarChart(timeChartData, GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i2, (Object) null), Dp.constructor-impl(110)), 0.0f, 0.0f, SteamGameChartItem$lambda$4(showPrice$delegate) ? 0.0f : 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 0, (ColorFilter) null, 524283, (Object) null), new BarChartConfig(true, true, false, true, true, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 10.0f, 10.0f, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.Companion.getWhite-0d7_KjU(), 0.42f, Float.valueOf(maxValue), Float.valueOf(0.0f), 0.0f, null, Dp.constructor-impl(110), 32768, null), $composer5, 0, 0);
                    Unit unit = Unit.INSTANCE;
                    $composer5.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                }
                if (priceChartData != null) {
                    $composer5.startReplaceGroup(1432732279);
                    $composer5.endReplaceGroup();
                } else {
                    $composer5.startReplaceGroup(1432732280);
                    ComposerKt.sourceInformation($composer5, "*1003@40751L1264");
                    Iterator it3 = priceChartData.iterator();
                    if (it3.hasNext()) {
                        float value2 = ((BarData) it3.next()).getValue();
                        while (it3.hasNext()) {
                            value2 = Math.max(value2, ((BarData) it3.next()).getValue());
                        }
                        valueOf2 = Float.valueOf(value2);
                    } else {
                        valueOf2 = null;
                    }
                    float maxCount2 = valueOf2 != null ? valueOf2.floatValue() : 0.0f;
                    float maxValue2 = 10.0f;
                    if (maxCount2 < 10.0f) {
                        i3 = 1;
                    } else {
                        maxValue2 = 50.0f;
                        if (maxCount2 < 50.0f) {
                            i3 = 1;
                        } else if (maxCount2 < 100.0f) {
                            maxValue2 = 100.0f;
                            i3 = 1;
                        } else {
                            i3 = 1;
                            maxValue2 = (((int) (maxCount2 / 100)) + 1) * 100.0f;
                        }
                    }
                    BarChartKt.BarChart(priceChartData, GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i3, (Object) null), Dp.constructor-impl(110)), 0.0f, 0.0f, SteamGameChartItem$lambda$4(showPrice$delegate) ? 1.0f : 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 0, (ColorFilter) null, 524283, (Object) null), new BarChartConfig(true, true, false, true, true, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 10.0f, 10.0f, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.Companion.getWhite-0d7_KjU(), 0.42f, Float.valueOf(maxValue2), Float.valueOf(0.0f), 0.0f, null, Dp.constructor-impl(110), 32768, null), $composer5, 0, 0);
                    Unit unit3 = Unit.INSTANCE;
                    $composer5.endReplaceGroup();
                    Unit unit4 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer5.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            Iterable playtimeDistributionChart2 = data.getPlaytimeDistributionChart();
            if (playtimeDistributionChart2 != null) {
                Iterable $this$map$iv2 = playtimeDistributionChart2;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv2 : $this$map$iv2) {
                    SteamChartData it4 = (SteamChartData) item$iv$iv2;
                    destination$iv$iv2.add(BarData(it4));
                    $this$map$iv2 = $this$map$iv2;
                }
                value$iv = (List) destination$iv$iv2;
            } else {
                value$iv = null;
            }
            $composer5.updateRememberedValue(value$iv);
            it$iv12 = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            timeChartData = (List) it$iv12;
            List<SteamChartData> priceDistributionChart22 = data.getPriceDistributionChart();
            ComposerKt.sourceInformationMarkerStart($composer5, 627842657, "CC(remember):SteamDetailPage.kt#9igjgp");
            invalid$iv = $composer5.changed(priceDistributionChart22);
            it$iv = $composer5.rememberedValue();
            if (!invalid$iv) {
            }
            priceDistributionChart = data.getPriceDistributionChart();
            if (priceDistributionChart == null) {
            }
            $composer5.updateRememberedValue(value$iv2);
            it$iv = value$iv2;
            priceChartData = (List) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Boolean valueOf32 = Boolean.valueOf(SteamGameChartItem$lambda$4(showPrice$delegate));
            ComposerKt.sourceInformationMarkerStart($composer5, 627848643, "CC(remember):SteamDetailPage.kt#9igjgp");
            it$iv2 = $composer5.rememberedValue();
            if (it$iv2 != Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer5);
            EffectsKt.LaunchedEffect(valueOf32, (Function2) it$iv2, $composer5, 0);
            Modifier modifier$iv32 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(110));
            ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv32 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv32 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv32 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer5, modifier$iv32);
            Function0 factory$iv$iv$iv62 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
            int i92 = ($changed$iv$iv$iv32 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i102 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, 1430950587, "C:SteamDetailPage.kt#xy3gb6");
            if (timeChartData != null) {
            }
            if (priceChartData != null) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda28
                public final Object invoke(Object obj2, Object obj3) {
                    Unit SteamGameChartItem$lambda$8;
                    SteamGameChartItem$lambda$8 = SteamDetailPageKt.SteamGameChartItem$lambda$8(SteamDetailPageData.this, modifier2, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return SteamGameChartItem$lambda$8;
                }
            });
        }
    }

    private static final boolean SteamGameChartItem$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void SteamGameChartItem$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SteamGameChartItem$lambda$4(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void SteamGameChartItem$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameChartItem$lambda$7$0$0$0(long[] $lastClickTimeRef, long $debounceDelay, MutableState $showPrice$delegate) {
        long currentTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
        if (currentTime - $lastClickTimeRef[0] >= $debounceDelay) {
            $lastClickTimeRef[0] = currentTime;
            if (SteamGameChartItem$lambda$4($showPrice$delegate)) {
                SteamGameChartItem$lambda$5($showPrice$delegate, false);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameChartItem$lambda$7$0$1$0(long[] $lastClickTimeRef, long $debounceDelay, MutableState $showPrice$delegate) {
        long currentTime = Clock.System.INSTANCE.now().toEpochMilliseconds();
        if (currentTime - $lastClickTimeRef[0] >= $debounceDelay) {
            $lastClickTimeRef[0] = currentTime;
            if (!SteamGameChartItem$lambda$4($showPrice$delegate)) {
                SteamGameChartItem$lambda$5($showPrice$delegate, true);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameChartItem$lambda$7$0$2$0(MutableState $isFolded$delegate) {
        SteamGameChartItem$lambda$2($isFolded$delegate, !SteamGameChartItem$lambda$1($isFolded$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameChartItem$lambda$7$0$3$0(MutableState $isFolded$delegate) {
        SteamGameChartItem$lambda$2($isFolded$delegate, !SteamGameChartItem$lambda$1($isFolded$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SteamGameChartItem$lambda$7$3(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SteamGameChartItem$lambda$7$4(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SteamGameChartItem$lambda$7$6(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SteamGameChartItem$lambda$7$7(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    public static final void SteamGameListCardTitle(final SteamDetailPageData data, final Function1<? super SteamGameListSortType, Unit> function1, Modifier modifier, SteamGameListSortType sortType, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        SteamGameListSortType sortType2;
        Modifier modifier3;
        Modifier modifier4;
        final SteamGameListSortType sortType3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(function1, "onClickSortType");
        Composer $composer2 = $composer.startRestartGroup(-2042217926);
        ComposerKt.sourceInformation($composer2, "C(SteamGameListCardTitle)N(data,onClickSortType,modifier,sortType)1047@42466L6,1042@42309L4767:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(data) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
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
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(sortType == null ? -1 : sortType.ordinal()) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                sortType3 = sortType;
            } else {
                sortType3 = SteamGameListSortType.Last2Weeks;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2042217926, $dirty2, -1, "kntr.app.game.steam.SteamGameListCardTitle (SteamDetailPage.kt:1041)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(72)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getWh0-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(8), Dp.constructor-impl(8), 0.0f, 0.0f, 12, (Object) null)), Dp.constructor-impl(10), Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
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
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -2011153829, "C1052@42681L6,1053@42724L9,1050@42618L157,1056@42784L40,1058@42916L4154,1058@42897L4173:SteamDetailPage.kt#xy3gb6");
            TextKt.Text-Nvy7gAk("我的游戏", (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14b(), $composer2, 6, 24576, 114682);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer2, 6);
            StatisticOverview statisticOverview = data.getStatisticOverview();
            final int gameCount = (statisticOverview == null || (gameCount = statisticOverview.getGamesCount()) == null) ? 0 : 0;
            sortType2 = sortType3;
            BoxWithConstraintsKt.BoxWithConstraints((Modifier) null, (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(-1088248594, true, new Function3() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SteamGameListCardTitle$lambda$0$0;
                    SteamGameListCardTitle$lambda$0$0 = SteamDetailPageKt.SteamGameListCardTitle$lambda$0$0(gameCount, sortType3, function1, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SteamGameListCardTitle$lambda$0$0;
                }
            }, $composer2, 54), $composer2, 3072, 7);
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
            sortType2 = sortType;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final SteamGameListSortType steamGameListSortType = sortType2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGameListCardTitle$lambda$1;
                    SteamGameListCardTitle$lambda$1 = SteamDetailPageKt.SteamGameListCardTitle$lambda$1(SteamDetailPageData.this, function1, modifier5, steamGameListSortType, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGameListCardTitle$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x02a0, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x035d, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x040d, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SteamGameListCardTitle$lambda$0$0(Object $gameCount, final SteamGameListSortType $sortType, final Function1 $onClickSortType, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C1065@43223L3837:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1088248594, $dirty, -1, "kntr.app.game.steam.SteamGameListCardTitle.<anonymous>.<anonymous> (SteamDetailPage.kt:1059)");
            }
            float screenWidth = $this$BoxWithConstraints.getMaxWidth-D9Ej5fM();
            float columnWidth = Dp.constructor-impl(Dp.constructor-impl(screenWidth - Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(118) + Dp.constructor-impl(60)) + Dp.constructor-impl(12)) + Dp.constructor-impl(30))) / 2);
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(18));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv = (390 << 3) & 112;
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
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1403772367, "C1072@43535L6,1073@43585L9,1069@43390L261,1076@43668L40,1098@44778L40,1120@45886L40,1142@47006L40:SteamDetailPage.kt#xy3gb6");
            TextKt.Text-Nvy7gAk("游戏数量 " + $gameCount, SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(118)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13(), $composer, 48, 24576, 114680);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer, 6);
            $composer.startMovableGroup(1755840438, $composer.joinKey($composer.joinKey("totalTime", Integer.valueOf($sortType.getType())), Boolean.valueOf($sortType.getAsc())));
            ComposerKt.sourceInformation($composer, "1083@44061L659,1078@43793L950");
            boolean isTotalTime = $sortType.isTotalTime();
            boolean asc = $sortType.getAsc();
            Modifier modifier = SizeKt.width-3ABfNKs(Modifier.Companion, columnWidth);
            ComposerKt.sourceInformationMarkerStart($composer, 1755850813, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($sortType.ordinal()) | $composer.changed($onClickSortType);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda45
                public final Object invoke() {
                    Unit SteamGameListCardTitle$lambda$0$0$0$0$0;
                    SteamGameListCardTitle$lambda$0$0$0$0$0 = SteamDetailPageKt.SteamGameListCardTitle$lambda$0$0$0$0$0(SteamGameListSortType.this, $onClickSortType);
                    return SteamGameListCardTitle$lambda$0$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SteamGameListCardTitleItem(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), "总时长", isTotalTime, asc, $composer, 48, 0);
            $composer.endMovableGroup();
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer, 6);
            $composer.startMovableGroup(1755875956, $composer.joinKey($composer.joinKey("recentTime", Integer.valueOf($sortType.getType())), Boolean.valueOf($sortType.getAsc())));
            ComposerKt.sourceInformation($composer, "1105@45167L661,1100@44904L947");
            boolean isLast2Weeks = $sortType.isLast2Weeks();
            boolean asc2 = $sortType.getAsc();
            Modifier modifier2 = SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60));
            ComposerKt.sourceInformationMarkerStart($composer, 1755886207, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($sortType.ordinal()) | $composer.changed($onClickSortType);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda46
                public final Object invoke() {
                    Unit SteamGameListCardTitle$lambda$0$0$0$1$0;
                    SteamGameListCardTitle$lambda$0$0$0$1$0 = SteamDetailPageKt.SteamGameListCardTitle$lambda$0$0$0$1$0(SteamGameListSortType.this, $onClickSortType);
                    return SteamGameListCardTitle$lambda$0$0$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SteamGameListCardTitleItem(ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), "两周内", isLast2Weeks, asc2, $composer, 48, 0);
            $composer.endMovableGroup();
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer, 6);
            $composer.startMovableGroup(1755911424, $composer.joinKey($composer.joinKey("achievement", Integer.valueOf($sortType.getType())), Boolean.valueOf($sortType.getAsc())));
            ComposerKt.sourceInformation($composer, "1127@46283L665,1122@46013L958");
            boolean isAchievements = $sortType.isAchievements();
            boolean asc3 = $sortType.getAsc();
            Modifier modifier3 = SizeKt.width-3ABfNKs(Modifier.Companion, columnWidth);
            ComposerKt.sourceInformationMarkerStart($composer, 1755921923, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed($sortType.ordinal()) | $composer.changed($onClickSortType);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda47
                public final Object invoke() {
                    Unit SteamGameListCardTitle$lambda$0$0$0$2$0;
                    SteamGameListCardTitle$lambda$0$0$0$2$0 = SteamDetailPageKt.SteamGameListCardTitle$lambda$0$0$0$2$0(SteamGameListSortType.this, $onClickSortType);
                    return SteamGameListCardTitle$lambda$0$0$0$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SteamGameListCardTitleItem(ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), "成就", isAchievements, asc3, $composer, 48, 0);
            $composer.endMovableGroup();
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
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
    public static final Unit SteamGameListCardTitle$lambda$0$0$0$0$0(SteamGameListSortType $sortType, Function1 $onClickSortType) {
        ReportKt.reportClick("game-ball.steam-game-list.steam-game-list.filter.click", MapsKt.mapOf(TuplesKt.to("method", String.valueOf($sortType.getType()))));
        if ($sortType.isTotalTime()) {
            $onClickSortType.invoke($sortType.opposite());
        } else {
            $onClickSortType.invoke(SteamGameListSortType.TotalTime);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameListCardTitle$lambda$0$0$0$1$0(SteamGameListSortType $sortType, Function1 $onClickSortType) {
        ReportKt.reportClick("game-ball.steam-game-list.steam-game-list.filter.click", MapsKt.mapOf(TuplesKt.to("method", String.valueOf($sortType.getType()))));
        if ($sortType.isLast2Weeks()) {
            $onClickSortType.invoke($sortType.opposite());
        } else {
            $onClickSortType.invoke(SteamGameListSortType.Last2Weeks);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameListCardTitle$lambda$0$0$0$2$0(SteamGameListSortType $sortType, Function1 $onClickSortType) {
        ReportKt.reportClick("game-ball.steam-game-list.steam-game-list.filter.click", MapsKt.mapOf(TuplesKt.to("method", String.valueOf($sortType.getType()))));
        if ($sortType.isAchievements()) {
            $onClickSortType.invoke($sortType.opposite());
        } else {
            $onClickSortType.invoke(SteamGameListSortType.Achievements);
        }
        return Unit.INSTANCE;
    }

    public static final void SteamGameListCardTitleItem(Modifier modifier, String title, boolean focus, boolean asc, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        boolean focus2;
        boolean asc2;
        Modifier modifier3;
        String title2;
        Modifier modifier4;
        String title3;
        Function0 factory$iv$iv$iv;
        long j2;
        Painter list_sort_positive_line;
        long j3;
        Composer $composer2 = $composer.startRestartGroup(996334485);
        ComposerKt.sourceInformation($composer2, "C(SteamGameListCardTitleItem)N(modifier,title,focus,asc)1155@47248L672:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            str = title;
        } else if (($changed & 48) == 0) {
            str = title;
            $dirty |= $composer2.changed(str) ? 32 : 16;
        } else {
            str = title;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            focus2 = focus;
        } else if (($changed & 384) == 0) {
            focus2 = focus;
            $dirty |= $composer2.changed(focus2) ? 256 : 128;
        } else {
            focus2 = focus;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            asc2 = asc;
        } else if (($changed & 3072) == 0) {
            asc2 = asc;
            $dirty |= $composer2.changed(asc2) ? 2048 : 1024;
        } else {
            asc2 = asc;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            title2 = str;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                title3 = str;
            } else {
                title3 = "总时长";
            }
            if (i4 != 0) {
                focus2 = false;
            }
            if (i5 != 0) {
                asc2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(996334485, $dirty2, -1, "kntr.app.game.steam.SteamGameListCardTitleItem (SteamDetailPage.kt:1154)");
            }
            Modifier modifier$iv = SizeKt.fillMaxHeight$default(modifier4, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            modifier3 = modifier4;
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
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i7 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1260033270, "C1162@47512L9,1159@47370L192,1165@47571L39,1166@47619L295:SteamDetailPage.kt#xy3gb6");
            if (focus2) {
                $composer2.startReplaceGroup(-456286211);
                ComposerKt.sourceInformation($composer2, "1161@47443L6");
                j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa10-0d7_KjU();
            } else {
                $composer2.startReplaceGroup(-456285348);
                ComposerKt.sourceInformation($composer2, "1161@47470L6");
                j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa5-0d7_KjU();
            }
            $composer2.endReplaceGroup();
            TextKt.Text-Nvy7gAk(title3, (Modifier) null, j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer2, ($dirty2 >> 3) & 14, 24576, 114682);
            title2 = title3;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer2, 6);
            if (asc2 && focus2) {
                $composer2.startReplaceGroup(-456278901);
                ComposerKt.sourceInformation($composer2, "1167@47678L18");
                list_sort_positive_line = BiliIconfont.INSTANCE.getList_sort_line_500($composer2, 6);
            } else {
                $composer2.startReplaceGroup(-456277712);
                ComposerKt.sourceInformation($composer2, "1167@47715L23");
                list_sort_positive_line = BiliIconfont.INSTANCE.getList_sort_positive_line($composer2, 6);
            }
            $composer2.endReplaceGroup();
            Painter painter = list_sort_positive_line;
            Modifier modifier5 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14));
            if (focus2) {
                $composer2.startReplaceGroup(-456272675);
                ComposerKt.sourceInformation($composer2, "1170@47866L6");
                j3 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa10-0d7_KjU();
            } else {
                $composer2.startReplaceGroup(-456271812);
                ComposerKt.sourceInformation($composer2, "1170@47893L6");
                j3 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa5-0d7_KjU();
            }
            $composer2.endReplaceGroup();
            IconKt.Icon-ww6aTOc(painter, "sort", modifier5, j3, $composer2, Painter.$stable | 432, 0);
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
            final Modifier modifier6 = modifier3;
            final String str2 = title2;
            final boolean z = focus2;
            final boolean z2 = asc2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGameListCardTitleItem$lambda$1;
                    SteamGameListCardTitleItem$lambda$1 = SteamDetailPageKt.SteamGameListCardTitleItem$lambda$1(modifier6, str2, z, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGameListCardTitleItem$lambda$1;
                }
            });
        }
    }

    public static final void SteamGameListItem(final SteamDetailGameItem item, final String steamId, Modifier modifier, String sourceFrom, boolean isFirst, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final String sourceFrom2;
        final boolean isFirst2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(item, "item");
        Composer $composer2 = $composer.startRestartGroup(-1781355004);
        ComposerKt.sourceInformation($composer2, "C(SteamGameListItem)N(item,steamId,modifier,sourceFrom,isFirst)1185@48218L6,1185@48240L967,1207@49215L6768,1183@48114L7869:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(steamId) ? 32 : 16;
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
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            sourceFrom2 = sourceFrom;
        } else if (($changed & 3072) == 0) {
            sourceFrom2 = sourceFrom;
            $dirty |= $composer2.changed(sourceFrom2) ? 2048 : 1024;
        } else {
            sourceFrom2 = sourceFrom;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            isFirst2 = isFirst;
        } else if (($changed & 24576) == 0) {
            isFirst2 = isFirst;
            $dirty |= $composer2.changed(isFirst2) ? 16384 : 8192;
        } else {
            isFirst2 = isFirst;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                sourceFrom2 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            if (i4 != 0) {
                isFirst2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1781355004, $dirty2, -1, "kntr.app.game.steam.SteamGameListItem (SteamDetailPage.kt:1182)");
            }
            Modifier modifier5 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1809802955, "CC(remember):SteamDetailPage.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 112) == 32) | (($dirty2 & 14) == 4) | (($dirty2 & 7168) == 2048);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda15
                    public final Object invoke() {
                        Unit SteamGameListItem$lambda$0$0;
                        SteamGameListItem$lambda$0$0 = SteamDetailPageKt.SteamGameListItem$lambda$0$0(steamId, item, sourceFrom2);
                        return SteamGameListItem$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            modifier3 = modifier4;
            BoxWithConstraintsKt.BoxWithConstraints(ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(1121094234, true, new Function3() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SteamGameListItem$lambda$1;
                    SteamGameListItem$lambda$1 = SteamDetailPageKt.SteamGameListItem$lambda$1(isFirst2, item, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SteamGameListItem$lambda$1;
                }
            }, $composer2, 54), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final String str = sourceFrom2;
            final boolean z = isFirst2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGameListItem$lambda$2;
                    SteamGameListItem$lambda$2 = SteamDetailPageKt.SteamGameListItem$lambda$2(SteamDetailGameItem.this, steamId, modifier6, str, z, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGameListItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameListItem$lambda$0$0(String $steamId, SteamDetailGameItem $item, String $sourceFrom) {
        Uri uri = Uri.Companion.parse("bilibili://game/compose/steam/game/detail_page").buildUpon().appendQueryParameter("steamId", $steamId == null ? RoomRecommendViewModel.EMPTY_CURSOR : $steamId).appendQueryParameter("appId", $item.getAppId()).appendQueryParameter(RouterHelperKt.PARAM_SOURCE_FROM, $sourceFrom).appendQueryParameter("steamGameName", $item.getAppName()).build();
        GlobalRouterKt.getGlobalRouter().launch(uri);
        ReportKt.reportClick("game-ball.steam-game-list.steam-game-list.list.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("app_id", $item.getAppId()), TuplesKt.to(AdAlarmExtraKey.STATUS, "1"), TuplesKt.to("sourcefrom", $sourceFrom), TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom())}));
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -50
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit SteamGameListItem$lambda$1(boolean r206, kntr.app.game.bean.SteamDetailGameItem r207, androidx.compose.foundation.layout.BoxWithConstraintsScope r208, androidx.compose.runtime.Composer r209, int r210) {
        /*
            Method dump skipped, instructions count: 3504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.game.steam.SteamDetailPageKt.SteamGameListItem$lambda$1(boolean, kntr.app.game.bean.SteamDetailGameItem, androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* renamed from: SteamCoverPlaceHolder-if577FI  reason: not valid java name */
    public static final void m1276SteamCoverPlaceHolderif577FI(final float f, final float f2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1290082125);
        ComposerKt.sourceInformation($composer2, "C(SteamCoverPlaceHolder)N(width:c#ui.unit.Dp,height:c#ui.unit.Dp,modifier)1355@56100L396:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(f) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(f2) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if ((i & 4) != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1290082125, $dirty2, -1, "kntr.app.game.steam.SteamCoverPlaceHolder (SteamDetailPage.kt:1354)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.size-VpY3zN4(Modifier.Companion, f, f2), ColorKt.Color(4294046451L), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            modifier2 = modifier3;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1920970423, "C1361@56244L91,1360@56215L275:SteamDetailPage.kt#xy3gb6");
            ImageKt.Image(ImageResourcesKt.painterResource(srcs.app.game.gamebiz.generated.resources.Drawable0_commonMainKt.getCover_steam_default(Res.drawable.INSTANCE), $composer2, 0), (String) null, SizeKt.size-VpY3zN4(Modifier.Companion, f, f2), (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 24624, 104);
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
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda30
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamCoverPlaceHolder_if577FI$lambda$1;
                    SteamCoverPlaceHolder_if577FI$lambda$1 = SteamDetailPageKt.SteamCoverPlaceHolder_if577FI$lambda$1(f, f2, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamCoverPlaceHolder_if577FI$lambda$1;
                }
            });
        }
    }

    public static final BarData BarData(SteamChartData $this$BarData) {
        Intrinsics.checkNotNullParameter($this$BarData, "<this>");
        return new BarData($this$BarData.getLabel(), $this$BarData.getCount(), 0L, null, 12, null);
    }

    public static final void SteamDetailTopAppBar(final String title, final Function0<Unit> function0, Modifier modifier, boolean immersive, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean immersive2;
        Modifier modifier3;
        Modifier modifier4;
        boolean immersive3;
        Modifier modifier5;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function0, "onBackPress");
        Composer $composer2 = $composer.startRestartGroup(1579777030);
        ComposerKt.sourceInformation($composer2, "C(SteamDetailTopAppBar)N(title,onBackPress,modifier,immersive)1378@56761L7,1382@56908L892:SteamDetailPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
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
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            immersive2 = immersive;
        } else if (($changed & 3072) == 0) {
            immersive2 = immersive;
            $dirty |= $composer2.changed(immersive2) ? 2048 : 1024;
        } else {
            immersive2 = immersive;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                immersive3 = immersive2;
            } else {
                immersive3 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1579777030, $dirty, -1, "kntr.app.game.steam.SteamDetailTopAppBar (SteamDetailPage.kt:1377)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            $composer2.startReplaceGroup(2042277126);
            ComposerKt.sourceInformation($composer2, "*1379@56824L10");
            float statusBarHeight = density.toDp-u2uoSUM(WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer2, 6).getTop(density));
            $composer2.endReplaceGroup();
            int $this$dp$iv = Dp.compareTo-0680j_4(statusBarHeight, Dp.constructor-impl(24));
            boolean z = $this$dp$iv > 0;
            $composer2.startReplaceGroup(2042282881);
            ComposerKt.sourceInformation($composer2, RoomRecommendViewModel.EMPTY_CURSOR);
            Modifier mod = modifier4;
            if (immersive3) {
                $composer2.startReplaceGroup(2105425986);
                ComposerKt.sourceInformation($composer2, "1387@57081L10");
                Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(mod, WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer2, 6));
                $composer2.endReplaceGroup();
                modifier5 = windowInsetsPadding;
            } else {
                $composer2.startReplaceGroup(2105525775);
                $composer2.endReplaceGroup();
                modifier5 = mod;
            }
            $composer2.endReplaceGroup();
            Modifier modifier$iv = SizeKt.defaultMinSize-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(modifier5, 0.0f, 0.0f, Dp.constructor-impl(15), 0.0f, 11, (Object) null), 0.0f, Dp.constructor-impl(40), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier4;
            boolean immersive4 = immersive3;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$SteamDetailTopAppBar_u24lambda_u242 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -643286764, "C1394@57279L214,1405@57695L9,1401@57502L292:SteamDetailPage.kt#xy3gb6");
            IconButtonKt.IconButton(function0, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$SteamDetailPageKt.INSTANCE.m1253getLambda$1451404886$gamebiz_debug(), $composer2, (($dirty >> 3) & 14) | 1572864, 62);
            String str = title == null ? RoomRecommendViewModel.EMPTY_CURSOR : title;
            TextKt.Text-Nvy7gAk(str, SizeKt.widthIn-VpY3zN4$default($this$SteamDetailTopAppBar_u24lambda_u242.align(Modifier.Companion, Alignment.Companion.getCenter()), 0.0f, Dp.constructor-impl(250), 1, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT17(), $composer2, 1573248, 0, 129976);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            immersive2 = immersive4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z2 = immersive2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamDetailPageKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamDetailTopAppBar$lambda$3;
                    SteamDetailTopAppBar$lambda$3 = SteamDetailPageKt.SteamDetailTopAppBar$lambda$3(title, function0, modifier6, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamDetailTopAppBar$lambda$3;
                }
            });
        }
    }
}