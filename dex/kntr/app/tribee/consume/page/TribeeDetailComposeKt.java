package kntr.app.tribee.consume.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults;
import androidx.compose.material3.pulltorefresh.PullToRefreshState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bapis.bilibili.app.dynamic.v2.KGlobalPermissionType;
import com.bapis.bilibili.app.dynamic.v2.KPublishButton;
import com.bapis.bilibili.app.dynamic.v2.KTribeeBaseInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDesc;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDyn;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchBar;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSortInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSortItem;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSortType;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.iconfont.BiliIconfontKt;
import com.bilibili.compose.theme.BiliColors;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.consume.page.model.TribeeDynListState;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.track.TrackerKt;
import kntr.app.tribee.consume.widget.PriorityTextKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageRequest;
import kntr.base.net.comm.imp.InitGMultiDomainKt;
import kntr.base.router.Router;
import kntr.common.compose.list.LoadMoreListStateKt;
import kntr.common.compose.list.ReachedEdgeState;
import kntr.common.router.RouterKt;
import kntr.common.router.UrisKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.priority.ComposePriorityHorizonKt;
import kntr.common.trio.priority.PriorityHorizontalScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.consume.generated.resources.Res;
import srcs.app.tribee.consume.generated.resources.String0_commonMainKt;

/* compiled from: TribeeDetailCompose.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\r\u001ac\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001b\u001aw\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010#2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0004\b&\u0010'\u001aC\u0010(\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020 H\u0007¢\u0006\u0002\u0010.\u001a\u001f\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u00101\u001aU\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00182\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020 2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u0002072\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0004\b8\u00109\u001a?\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0004\b<\u0010=\u001a'\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010B\u001a=\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020F2\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010G¨\u0006H²\u0006\n\u0010I\u001a\u00020 X\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020 X\u008a\u0084\u0002²\u0006\n\u0010K\u001a\u00020 X\u008a\u0084\u0002"}, d2 = {"TribeeListPager", "", "pageState", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "fromSpmid", "", "modifier", "Landroidx/compose/ui/Modifier;", "onStateAction", "Lkotlin/Function1;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "(Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;Landroidx/compose/foundation/pager/PagerState;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "TribeeDynList", "selectedCategoryId", "", "category", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeCategory;", "listState", "Lkntr/app/tribee/consume/page/model/TribeeDynListState;", "basicInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeBaseInfo;", "isLoadingMore", "", "(JLcom/bapis/bilibili/app/dynamic/v2/KTribeeCategory;Lkntr/app/tribee/consume/page/model/TribeeDynListState;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeBaseInfo;ZLjava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "SimpleNavigationRow", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NavigationRow", "bgColor", "Landroidx/compose/ui/graphics/Color;", "scrollProgress", "", "hasRedDot", "onClickUserCenter", "Lkotlin/Function0;", "onUIAction", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "NavigationRow-pzZJ40c", "(JFZLcom/bapis/bilibili/app/dynamic/v2/KTribeeBaseInfo;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "NavigationSearchBar", "searchUri", "router", "Lkntr/base/router/Router;", "tribeeId", "alpha", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeBaseInfo;Ljava/lang/String;Lkntr/base/router/Router;Ljava/lang/String;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "TribeeImage", "url", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TribeeJoinButton", "isJoined", "iconSize", "Landroidx/compose/ui/unit/Dp;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "TribeeJoinButton-YiiH-5w", "(ZLandroidx/compose/ui/Modifier;FFJLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "TribeeHomeHeader", "tribeeColor", "TribeeHomeHeader-euL9pac", "(JLcom/bapis/bilibili/app/dynamic/v2/KTribeeBaseInfo;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "RefreshIndicator", "isRefreshing", "refreshState", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "(ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TribeeFloatPublish", "hasJoined", "publishButton", "Lcom/bapis/bilibili/app/dynamic/v2/KPublishButton;", "(ZLcom/bapis/bilibili/app/dynamic/v2/KPublishButton;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "consume_debug", "titleAlpha", "searchBarAlpha", "searchIconAlpha"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeDetailComposeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow_pzZJ40c$lambda$8(long j, float f, boolean z, KTribeeBaseInfo kTribeeBaseInfo, Modifier modifier, Function0 function0, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        m696NavigationRowpzZJ40c(j, f, z, kTribeeBaseInfo, modifier, function0, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationSearchBar$lambda$2(KTribeeBaseInfo kTribeeBaseInfo, String str, Router router, String str2, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        NavigationSearchBar(kTribeeBaseInfo, str, router, str2, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RefreshIndicator$lambda$3(boolean z, PullToRefreshState pullToRefreshState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RefreshIndicator(z, pullToRefreshState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleNavigationRow$lambda$3(Modifier modifier, int i, int i2, Composer composer, int i3) {
        SimpleNavigationRow(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDynList$lambda$5(long j, KTribeeCategory kTribeeCategory, TribeeDynListState tribeeDynListState, KTribeeBaseInfo kTribeeBaseInfo, boolean z, String str, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        TribeeDynList(j, kTribeeCategory, tribeeDynListState, kTribeeBaseInfo, z, str, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeFloatPublish$lambda$4(boolean z, KPublishButton kPublishButton, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        TribeeFloatPublish(z, kPublishButton, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeHeader_euL9pac$lambda$1(long j, KTribeeBaseInfo kTribeeBaseInfo, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        m697TribeeHomeHeadereuL9pac(j, kTribeeBaseInfo, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeHeader_euL9pac$lambda$3(long j, KTribeeBaseInfo kTribeeBaseInfo, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        m697TribeeHomeHeadereuL9pac(j, kTribeeBaseInfo, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeImage$lambda$1(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeImage(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeJoinButton_YiiH_5w$lambda$6(boolean z, Modifier modifier, float f, float f2, long j, Function1 function1, int i, int i2, Composer composer, int i3) {
        m698TribeeJoinButtonYiiH5w(z, modifier, f, f2, j, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeListPager$lambda$3(TribeeHomeContentState tribeeHomeContentState, PagerState pagerState, String str, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        TribeeListPager(tribeeHomeContentState, pagerState, str, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeListPager$lambda$0$0(TribeeHomeStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v8 */
    public static final void TribeeListPager(final TribeeHomeContentState pageState, final PagerState pagerState, final String fromSpmid, Modifier modifier, Function1<? super TribeeHomeStateAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 onStateAction;
        Modifier modifier3;
        final Function1 onStateAction2;
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Composer $composer2 = $composer.startRestartGroup(-154825177);
        ComposerKt.sourceInformation($composer2, "C(TribeeListPager)N(pageState,pagerState,fromSpmid,modifier,onStateAction)106@5210L2,112@5347L152,118@5507L800,108@5222L1085:TribeeDetailCompose.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(pageState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(pagerState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(fromSpmid) ? 256 : 128;
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
            onStateAction = function1;
        } else if (($changed & 24576) == 0) {
            onStateAction = function1;
            $dirty |= $composer2.changedInstance(onStateAction) ? 16384 : 8192;
        } else {
            onStateAction = function1;
        }
        if (!$composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1536866633, "CC(remember):TribeeDetailCompose.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda37
                        public final Object invoke(Object obj) {
                            Unit TribeeListPager$lambda$0$0;
                            TribeeListPager$lambda$0$0 = TribeeDetailComposeKt.TribeeListPager$lambda$0$0((TribeeHomeStateAction) obj);
                            return TribeeListPager$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onStateAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onStateAction2 = onStateAction;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-154825177, $dirty, -1, "kntr.app.tribee.consume.page.TribeeListPager (TribeeDetailCompose.kt:107)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1536871167, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda38
                    public final Object invoke(Object obj) {
                        Object TribeeListPager$lambda$1$0;
                        TribeeListPager$lambda$1$0 = TribeeDetailComposeKt.TribeeListPager$lambda$1$0(TribeeHomeContentState.this, ((Integer) obj).intValue());
                        return TribeeListPager$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function1 onStateAction3 = onStateAction2;
            PagerKt.HorizontalPager--8jOkeI(pagerState, modifier3, (PaddingValues) null, (PageSize) null, 1, 0.0f, (Alignment.Vertical) null, (TargetedFlingBehavior) null, false, false, (Function1) it$iv2, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(192311720, true, new Function4() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda39
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit TribeeListPager$lambda$2;
                    TribeeListPager$lambda$2 = TribeeDetailComposeKt.TribeeListPager$lambda$2(TribeeHomeContentState.this, fromSpmid, onStateAction2, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    return TribeeListPager$lambda$2;
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | 24576 | (($dirty >> 6) & 112), 24576, 15340);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onStateAction = onStateAction3;
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Function1 function12 = onStateAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda40
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeListPager$lambda$3;
                    TribeeListPager$lambda$3 = TribeeDetailComposeKt.TribeeListPager$lambda$3(TribeeHomeContentState.this, pagerState, fromSpmid, modifier4, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeListPager$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TribeeListPager$lambda$1$0(TribeeHomeContentState $pageState, int it) {
        KTribeeCategory kTribeeCategory = (KTribeeCategory) CollectionsKt.getOrNull(CollectionsKt.toList($pageState.getCategoryList().keySet()), it);
        if (kTribeeCategory != null) {
            return Long.valueOf(kTribeeCategory.getId());
        }
        return Long.valueOf(TribeeExtensionsKt.getDEFAULT_CATEGORY().getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeListPager$lambda$2(TribeeHomeContentState $pageState, String $fromSpmid, Function1 $onStateAction, PagerScope $this$HorizontalPager, int pageIndex, Composer $composer, int $changed) {
        boolean invalid$iv;
        Long l;
        KTribeeCategory kTribeeCategory;
        Intrinsics.checkNotNullParameter($this$HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation($composer, "CN(pageIndex)124@5689L239,130@5937L364:TribeeDetailCompose.kt#iitu82");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(192311720, $changed, -1, "kntr.app.tribee.consume.page.TribeeListPager.<anonymous> (TribeeDetailCompose.kt:119)");
        }
        Map.Entry entry = (Map.Entry) CollectionsKt.getOrNull(CollectionsKt.toList($pageState.getCategoryList().entrySet()), pageIndex);
        ComposerKt.sourceInformationMarkerStart($composer, 127975255, "CC(remember):TribeeDetailCompose.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed($pageState);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
            Iterable $this$any$iv = $pageState.getObservedRequestingActions();
            boolean z = false;
            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                Iterator<T> it = $this$any$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object element$iv = it.next();
                    TribeeHomeStateAction action = (TribeeHomeStateAction) element$iv;
                    TribeeHomeStateAction.LoadMore loadMore = action instanceof TribeeHomeStateAction.LoadMore ? (TribeeHomeStateAction.LoadMore) action : null;
                    Long valueOf = loadMore != null ? Long.valueOf(loadMore.getCategoryId()) : null;
                    if (entry == null || (kTribeeCategory = (KTribeeCategory) entry.getKey()) == null) {
                        invalid$iv = invalid$iv2;
                        l = null;
                    } else {
                        Long valueOf2 = Long.valueOf(kTribeeCategory.getId());
                        invalid$iv = invalid$iv2;
                        l = valueOf2;
                    }
                    if (Intrinsics.areEqual(valueOf, l)) {
                        z = true;
                        break;
                    }
                    invalid$iv2 = invalid$iv;
                }
            }
            Object value$iv = Boolean.valueOf(z);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        boolean isLoadingMore = ((Boolean) it$iv).booleanValue();
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
        TribeeDynList($pageState.getCategoryId(), entry != null ? (KTribeeCategory) entry.getKey() : null, entry != null ? (TribeeDynListState) entry.getValue() : null, $pageState.getBaseInfo(), isLoadingMore, $fromSpmid, fillMaxSize$default, $onStateAction, $composer, 1572864, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDynList$lambda$0$0(TribeeHomeStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x0150, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeDynList(final long selectedCategoryId, final KTribeeCategory category, final TribeeDynListState listState, final KTribeeBaseInfo basicInfo, final boolean isLoadingMore, final String fromSpmid, Modifier modifier, Function1<? super TribeeHomeStateAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Function1 function12;
        Composer $composer2;
        Modifier modifier2;
        Function1 onStateAction;
        Modifier modifier3;
        Object obj;
        Composer $composer3;
        int $dirty;
        Object obj2;
        String str;
        int $dirty2;
        Composer $composer4;
        Object emptyList;
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Composer $composer5 = $composer.startRestartGroup(-384622613);
        ComposerKt.sourceInformation($composer5, "C(TribeeDynList)N(selectedCategoryId,category,listState,basicInfo,isLoadingMore,fromSpmid,modifier,onStateAction)152@6612L2,154@6636L57:TribeeDetailCompose.kt#iitu82");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer5.changed(selectedCategoryId) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer5.changedInstance(category) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty3 |= $composer5.changed(listState) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty3 |= $composer5.changedInstance(basicInfo) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty3 |= $composer5.changed(isLoadingMore) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty3 |= $composer5.changed(fromSpmid) ? 131072 : 65536;
        }
        int i2 = i & 64;
        if (i2 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer5.changed(modifier) ? 1048576 : 524288;
        }
        int i3 = i & 128;
        if (i3 != 0) {
            $dirty3 |= 12582912;
            function12 = function1;
        } else if (($changed & 12582912) == 0) {
            function12 = function1;
            $dirty3 |= $composer5.changedInstance(function12) ? 8388608 : 4194304;
        } else {
            function12 = function1;
        }
        if ($composer5.shouldExecute(($dirty3 & 4793491) != 4793490, $dirty3 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer5, -255134387, "CC(remember):TribeeDetailCompose.kt#9igjgp");
                Object it$iv = $composer5.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj3) {
                            Unit TribeeDynList$lambda$0$0;
                            TribeeDynList$lambda$0$0 = TribeeDetailComposeKt.TribeeDynList$lambda$0$0((TribeeHomeStateAction) obj3);
                            return TribeeDynList$lambda$0$0;
                        }
                    };
                    $composer5.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onStateAction2 = (Function1) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                onStateAction = onStateAction2;
            } else {
                onStateAction = function12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-384622613, $dirty3, -1, "kntr.app.tribee.consume.page.TribeeDynList (TribeeDetailCompose.kt:153)");
            }
            ComposerKt.sourceInformationMarkerStart($composer5, -255133564, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            boolean invalid$iv = ($dirty3 & 896) == 256;
            Object it$iv2 = $composer5.rememberedValue();
            if (invalid$iv) {
            }
            if (listState == null || (emptyList = listState.items()) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            Object value$iv2 = emptyList;
            $composer5.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            final List items = (List) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            if (category != null) {
                if ((listState != null ? listState.getContent() : null) == null) {
                    obj = null;
                    modifier2 = modifier3;
                    $composer3 = $composer5;
                } else {
                    if (items.isEmpty()) {
                        $composer5.startReplaceGroup(681161522);
                        ComposerKt.sourceInformation($composer5, "167@7122L6,164@7011L213");
                        TribeePageStatusComposeKt.TribeeEmpty(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxHeight$default(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(150), 0.0f, 0.0f, 13, (Object) null), null, null, $composer5, 0, 6);
                        $composer5.endReplaceGroup();
                        modifier2 = modifier3;
                        $composer2 = $composer5;
                    } else {
                        int $dirty4 = $dirty3;
                        $composer5.startReplaceGroup(681548092);
                        ComposerKt.sourceInformation($composer5, "173@7278L75,178@7445L176,176@7376L256,188@7786L6,190@7886L14,190@7901L17,191@7930L4479,184@7641L4768");
                        ComposerKt.sourceInformationMarkerStart($composer5, -255113002, "CC(remember):TribeeDetailCompose.kt#9igjgp");
                        boolean invalid$iv2 = ($dirty4 & 896) == 256;
                        Object it$iv3 = $composer5.rememberedValue();
                        if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                            Object value$iv3 = listState.getLazyListState();
                            $composer5.updateRememberedValue(value$iv3);
                            it$iv3 = value$iv3;
                        }
                        LazyListState lazyListState = (LazyListState) it$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerStart($composer5, -255107557, "CC(remember):TribeeDetailCompose.kt#9igjgp");
                        boolean invalid$iv3 = $composer5.changedInstance(category) | (($dirty4 & 14) == 4) | (($dirty4 & 29360128) == 8388608);
                        Object value$iv4 = $composer5.rememberedValue();
                        if (invalid$iv3 || value$iv4 == Composer.Companion.getEmpty()) {
                            $dirty = $dirty4;
                            obj2 = null;
                            str = "CC(remember):TribeeDetailCompose.kt#9igjgp";
                            value$iv4 = new TribeeDetailComposeKt$TribeeDynList$2$1(category, selectedCategoryId, onStateAction, null);
                            $composer5.updateRememberedValue(value$iv4);
                        } else {
                            $dirty = $dirty4;
                            str = "CC(remember):TribeeDetailCompose.kt#9igjgp";
                            obj2 = null;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        LoadMoreListStateKt.applyLoadMoreEffects(lazyListState, 2, (Function1<? super ReachedEdgeState, Boolean>) null, (Function1) value$iv4, $composer5, 48, 2);
                        Modifier modifier4 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, obj2), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                        PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer5, 6), $composer5, 0);
                        ComposerKt.sourceInformationMarkerStart($composer5, -255087734, str);
                        int $dirty5 = $dirty;
                        boolean invalid$iv4 = (($dirty5 & 896) == 256) | $composer5.changedInstance(basicInfo) | ((458752 & $dirty5) == 131072) | $composer5.changedInstance(category) | ((29360128 & $dirty5) == 8388608) | $composer5.changedInstance(items) | (($dirty5 & 14) == 4) | ((57344 & $dirty5) == 16384);
                        Object value$iv5 = $composer5.rememberedValue();
                        if (invalid$iv4 || value$iv5 == Composer.Companion.getEmpty()) {
                            $dirty2 = $dirty5;
                            modifier2 = modifier3;
                            final Function1 function13 = onStateAction;
                            $composer4 = $composer5;
                            value$iv5 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj3) {
                                    Unit TribeeDynList$lambda$4$0;
                                    TribeeDynList$lambda$4$0 = TribeeDetailComposeKt.TribeeDynList$lambda$4$0(TribeeDynListState.this, items, isLoadingMore, basicInfo, fromSpmid, category, function13, selectedCategoryId, (LazyListScope) obj3);
                                    return TribeeDynList$lambda$4$0;
                                }
                            };
                            $composer5.updateRememberedValue(value$iv5);
                        } else {
                            modifier2 = modifier3;
                            $composer4 = $composer5;
                            $dirty2 = $dirty5;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        LazyDslKt.LazyColumn(modifier4, lazyListState, asPaddingValues, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv5, $composer4, 0, (int) InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
                        $composer4.endReplaceGroup();
                        $composer2 = $composer4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            } else {
                obj = null;
                modifier2 = modifier3;
                $composer3 = $composer5;
            }
            $composer2 = $composer3;
            $composer2.startReplaceGroup(680912375);
            ComposerKt.sourceInformation($composer2, "159@6866L6,156@6760L208");
            SpacerKt.Spacer(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxHeight$default(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg3-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, 1, obj), 0.0f, Dp.constructor-impl(150), 0.0f, 0.0f, 13, (Object) null), $composer2, 0);
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer5;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            onStateAction = function12;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final Function1 function14 = onStateAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj3, Object obj4) {
                    Unit TribeeDynList$lambda$5;
                    TribeeDynList$lambda$5 = TribeeDetailComposeKt.TribeeDynList$lambda$5(selectedCategoryId, category, listState, basicInfo, isLoadingMore, fromSpmid, modifier5, function14, $changed, i, (Composer) obj3, ((Integer) obj4).intValue());
                    return TribeeDynList$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDynList$lambda$4$0(TribeeDynListState $listState, final List $items, boolean $isLoadingMore, final KTribeeBaseInfo $basicInfo, final String $fromSpmid, final KTribeeCategory $category, final Function1 $onStateAction, final long $selectedCategoryId, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final KTribeeSortInfo sortInfo = $listState.getTribeeSortInfo();
        if (sortInfo != null && sortInfo.getShowSort()) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1747781185, true, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda45
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeDynList$lambda$4$0$0;
                    TribeeDynList$lambda$4$0$0 = TribeeDetailComposeKt.TribeeDynList$lambda$4$0$0(sortInfo, $basicInfo, $fromSpmid, $category, $onStateAction, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeDynList$lambda$4$0$0;
                }
            }), 3, (Object) null);
        }
        LazyListScope.-CC.items$default($this$LazyColumn, $items.size(), (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-799091539, true, new Function4() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda46
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit TribeeDynList$lambda$4$0$1;
                TribeeDynList$lambda$4$0$1 = TribeeDetailComposeKt.TribeeDynList$lambda$4$0$1($category, $basicInfo, $items, sortInfo, $fromSpmid, $selectedCategoryId, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return TribeeDynList$lambda$4$0$1;
            }
        }), 6, (Object) null);
        if (!$listState.hasMore() && $items.size() >= 10) {
            LazyListScope.-CC.item$default($this$LazyColumn, "TheEnd", (Object) null, ComposableSingletons$TribeeDetailComposeKt.INSTANCE.getLambda$1168152630$consume_debug(), 2, (Object) null);
        }
        if ($listState.hasMore() && $isLoadingMore) {
            LazyListScope.-CC.item$default($this$LazyColumn, "LoadingMore", (Object) null, ComposableSingletons$TribeeDetailComposeKt.INSTANCE.m677getLambda$1179084233$consume_debug(), 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDynList$lambda$4$0$0(final KTribeeSortInfo $sortInfo, final KTribeeBaseInfo $basicInfo, final String $fromSpmid, final KTribeeCategory $category, final Function1 $onStateAction, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C200@8335L6,201@8382L1228,195@8084L1549:TribeeDetailCompose.kt#iitu82");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1747781185, $changed, -1, "kntr.app.tribee.consume.page.TribeeDynList.<anonymous>.<anonymous>.<anonymous> (TribeeDetailCompose.kt:195)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -285494581, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($basicInfo) | $composer.changed($fromSpmid) | $composer.changedInstance($sortInfo) | $composer.changedInstance($category) | $composer.changed($onStateAction);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda23
                    public final Object invoke(Object obj, Object obj2) {
                        Unit TribeeDynList$lambda$4$0$0$0$0;
                        TribeeDynList$lambda$4$0$0$0$0 = TribeeDetailComposeKt.TribeeDynList$lambda$4$0$0$0$0($basicInfo, $fromSpmid, $sortInfo, $category, $onStateAction, ((Integer) obj).intValue(), (KTribeeSortItem) obj2);
                        return TribeeDynList$lambda$4$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TribeeSortComposeKt.TribeeSortLayout($sortInfo, modifier, (Function2) value$iv, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDynList$lambda$4$0$0$0$0(KTribeeBaseInfo $basicInfo, String $fromSpmid, KTribeeSortInfo $sortInfo, KTribeeCategory $category, Function1 $onStateAction, int index, KTribeeSortItem sortItem) {
        String str;
        Object element$iv;
        KTribeeDesc tribeeInfo;
        Intrinsics.checkNotNullParameter(sortItem, "sortItem");
        String str2 = null;
        if ($basicInfo == null || (tribeeInfo = $basicInfo.getTribeeInfo()) == null) {
            str = null;
        } else {
            str = String.valueOf(tribeeInfo.getId());
        }
        String str3 = str == null ? "" : str;
        Iterable $this$firstOrNull$iv = $sortInfo.getSortItems();
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                KTribeeSortItem it2 = (KTribeeSortItem) element$iv;
                if (Intrinsics.areEqual(it2.getSortType(), $sortInfo.getCurSortType())) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        KTribeeSortItem kTribeeSortItem = (KTribeeSortItem) element$iv;
        if (kTribeeSortItem != null) {
            str2 = kTribeeSortItem.getText();
        }
        String str4 = str2 == null ? "" : str2;
        List $this$indexOfFirst$iv = $sortInfo.getSortItems();
        int index$iv = 0;
        Iterator it3 = $this$indexOfFirst$iv.iterator();
        while (true) {
            if (it3.hasNext()) {
                Object item$iv = it3.next();
                KTribeeSortItem it4 = (KTribeeSortItem) item$iv;
                if (Intrinsics.areEqual(it4.getSortType(), $sortInfo.getCurSortType())) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        TrackerKt.reportTribeeSortClick(str3, $fromSpmid, str4, String.valueOf(index$iv + 1), sortItem.getText(), String.valueOf(index + 1), $category.getName());
        $onStateAction.invoke(new TribeeHomeStateAction.SwitchSortType(sortItem.getSortType()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeDynList$lambda$4$0$1(KTribeeCategory $category, KTribeeBaseInfo $basicInfo, List $items, KTribeeSortInfo $sortInfo, String $fromSpmid, long $selectedCategoryId, LazyItemScope $this$items, int it, Composer $composer, int $changed) {
        KTribeeSortType kTribeeSortType;
        KTribeeDesc tribeeInfo;
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(it)229@9723L783,251@10665L6,255@10852L6,248@10524L366:TribeeDetailCompose.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(it) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-799091539, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeDynList.<anonymous>.<anonymous>.<anonymous> (TribeeDetailCompose.kt:229)");
            }
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, it == 0 ? Dp.constructor-impl(0) : Dp.constructor-impl(6), 0.0f, Dp.constructor-impl(6), 5, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            String valueOf = ($basicInfo == null || (tribeeInfo = $basicInfo.getTribeeInfo()) == null) ? null : String.valueOf(tribeeInfo.getId());
            if (valueOf == null) {
                valueOf = "";
            }
            KTribeeDyn kTribeeDyn = (KTribeeDyn) $items.get(it);
            if ($sortInfo == null || (kTribeeSortType = $sortInfo.getCurSortType()) == null) {
                kTribeeSortType = KTribeeSortType.TRIBEE_SORT_TYPE_DEFAULT.INSTANCE;
            }
            TribeePostComposeKt.TribeePost(valueOf, $fromSpmid, $category, $selectedCategoryId, kTribeeDyn, kTribeeSortType, modifier, $composer, 0, 0);
            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void SimpleNavigationRow(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1335157033);
        ComposerKt.sourceInformation($composer2, "C(SimpleNavigationRow)N(modifier)300@12539L7,302@12572L92,313@12886L2,307@12669L813:TribeeDetailCompose.kt#iitu82");
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
                ComposerKt.traceEventStart(1335157033, $dirty, -1, "kntr.app.tribee.consume.page.SimpleNavigationRow (TribeeDetailCompose.kt:299)");
            }
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer2, -1109308187, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda41
                    public final Object invoke() {
                        Unit SimpleNavigationRow$lambda$0$0;
                        SimpleNavigationRow$lambda$0$0 = TribeeDetailComposeKt.SimpleNavigationRow$lambda$0$0(backHandler);
                        return SimpleNavigationRow$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Function0 onBack = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier4 = SizeKt.height-3ABfNKs(WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null)), Dp.constructor-impl(44));
            ComposerKt.sourceInformationMarkerStart($composer2, -1109298229, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda42
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier4, (MutableInteractionSource) null, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier5 = modifier3;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1979508324, "C317@13004L24,319@13105L6,325@13312L39,327@13430L12,316@12962L514:TribeeDetailCompose.kt#iitu82");
            Painter arrow_back_left_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer2, 6);
            long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU();
            Modifier modifier6 = PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer2, -1864959700, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1864955951, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda43
                    public final Object invoke() {
                        Unit SimpleNavigationRow$lambda$2$1$0;
                        SimpleNavigationRow$lambda$2$1$0 = TribeeDetailComposeKt.SimpleNavigationRow$lambda$2$1$0(onBack);
                        return SimpleNavigationRow$lambda$2$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BiliIconfontKt.BiliIcon-ww6aTOc(arrow_back_left_line_500, ClickableKt.clickable-O2vRcR0$default(modifier6, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv4, 28, (Object) null), "back icon", j, $composer2, Painter.$stable | 384, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda44
                public final Object invoke(Object obj, Object obj2) {
                    Unit SimpleNavigationRow$lambda$3;
                    SimpleNavigationRow$lambda$3 = TribeeDetailComposeKt.SimpleNavigationRow$lambda$3(modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SimpleNavigationRow$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleNavigationRow$lambda$0$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleNavigationRow$lambda$2$1$0(Function0 $onBack) {
        $onBack.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow_pzZJ40c$lambda$1$0(TribeeHomeStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow_pzZJ40c$lambda$2$0(TribeeHomeUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x02b6, code lost:
        if (r0 == null) goto L242;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0c83  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0d0d  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0d88  */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* renamed from: NavigationRow-pzZJ40c  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m696NavigationRowpzZJ40c(final long j, final float scrollProgress, final boolean hasRedDot, final KTribeeBaseInfo basicInfo, Modifier modifier, Function0<Unit> function0, Function1<? super TribeeHomeStateAction, Unit> function1, Function1<? super TribeeHomeUIAction, Unit> function12, Composer $composer, final int $changed, final int i) {
        Function1 function13;
        int $dirty;
        Modifier modifier2;
        final Function0 onClickUserCenter;
        Function1 onUIAction;
        Function1 onStateAction;
        Function0 onClickUserCenter2;
        Function1 onStateAction2;
        final Function1 onUIAction2;
        Ref.ObjectRef tribeeId;
        String str;
        Function0 factory$iv$iv$iv;
        final Function0 onBack;
        Function0 factory$iv$iv$iv2;
        BoxScope $this$NavigationRow_pzZJ40c_u24lambda_u246_u242;
        Composer $composer$iv;
        String str2;
        int i2;
        Composer $composer$iv2;
        int $dirty2;
        String searchUri;
        Function0 onClickUserCenter3;
        Composer $composer$iv$iv$iv;
        String str3;
        Composer $composer$iv3;
        Composer $composer2;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv4;
        String str4;
        boolean z;
        final String searchUri2;
        Composer $composer$iv5;
        final Ref.ObjectRef tribeeId2;
        Composer $composer3;
        Function0 factory$iv$iv$iv3;
        final boolean z2;
        final Function1 onStateAction3;
        Object value$iv;
        boolean invalid$iv;
        Object it$iv;
        String str5;
        Ref.ObjectRef tribeeId3;
        BoxScope $this$NavigationRow_pzZJ40c_u24lambda_u246_u2422;
        String str6;
        float f;
        int $dirty3;
        int i3;
        Function0 factory$iv$iv$iv4;
        String title;
        KTribeeDesc tribeeInfo;
        KTribeeDesc tribeeInfo2;
        KTribeeSearchBar searchBar;
        Composer $composer4 = $composer.startRestartGroup(-1816185467);
        ComposerKt.sourceInformation($composer4, "C(NavigationRow)N(bgColor:c#ui.graphics.Color,scrollProgress,hasRedDot,basicInfo,modifier,onClickUserCenter,onStateAction,onUIAction)340@13692L2,341@13749L2,342@13800L2,344@13835L6,345@13893L7,347@13926L92,352@14048L7,377@15199L82,370@14896L6797,531@21725L110,531@21699L136:TribeeDetailCompose.kt#iitu82");
        int $dirty4 = $changed;
        if (($changed & 6) == 0) {
            $dirty4 |= $composer4.changed(j) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty4 |= $composer4.changed(scrollProgress) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty4 |= $composer4.changed(hasRedDot) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty4 |= $composer4.changedInstance(basicInfo) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty4 |= $composer4.changed(modifier) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty4 |= 196608;
        } else if ((196608 & $changed) == 0) {
            $dirty4 |= $composer4.changedInstance(function0) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty4 |= 1572864;
            function13 = function1;
        } else if ((1572864 & $changed) == 0) {
            function13 = function1;
            $dirty4 |= $composer4.changedInstance(function13) ? 1048576 : 524288;
        } else {
            function13 = function1;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty4 |= $composer4.changedInstance(function12) ? 8388608 : 4194304;
        }
        if ($composer4.shouldExecute(($dirty4 & 4793491) != 4793490, $dirty4 & 1)) {
            modifier2 = i4 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, -1597505401, "CC(remember):TribeeDetailCompose.kt#9igjgp");
                Object it$iv2 = $composer4.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda24
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 onClickUserCenter4 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onClickUserCenter2 = onClickUserCenter4;
            } else {
                onClickUserCenter2 = function0;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, -1597503577, "CC(remember):TribeeDetailCompose.kt#9igjgp");
                Object it$iv3 = $composer4.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda29
                        public final Object invoke(Object obj) {
                            Unit NavigationRow_pzZJ40c$lambda$1$0;
                            NavigationRow_pzZJ40c$lambda$1$0 = TribeeDetailComposeKt.NavigationRow_pzZJ40c$lambda$1$0((TribeeHomeStateAction) obj);
                            return NavigationRow_pzZJ40c$lambda$1$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                Function1 onStateAction4 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onStateAction2 = onStateAction4;
            } else {
                onStateAction2 = function13;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, -1597501945, "CC(remember):TribeeDetailCompose.kt#9igjgp");
                Object it$iv4 = $composer4.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda30
                        public final Object invoke(Object obj) {
                            Unit NavigationRow_pzZJ40c$lambda$2$0;
                            NavigationRow_pzZJ40c$lambda$2$0 = TribeeDetailComposeKt.NavigationRow_pzZJ40c$lambda$2$0((TribeeHomeUIAction) obj);
                            return NavigationRow_pzZJ40c$lambda$2$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                Function1 onUIAction3 = it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onUIAction2 = onUIAction3;
            } else {
                onUIAction2 = function12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1816185467, $dirty4, -1, "kntr.app.tribee.consume.page.NavigationRow (TribeeDetailCompose.kt:343)");
            }
            final BiliColors colors = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable);
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer4, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer4, -1597497823, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            int $dirty5 = $dirty4;
            Object value$iv5 = $composer4.rememberedValue();
            if (value$iv5 == Composer.Companion.getEmpty()) {
                value$iv5 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda31
                    public final Object invoke() {
                        Unit NavigationRow_pzZJ40c$lambda$3$0;
                        NavigationRow_pzZJ40c$lambda$3$0 = TribeeDetailComposeKt.NavigationRow_pzZJ40c$lambda$3$0(backHandler);
                        return NavigationRow_pzZJ40c$lambda$3$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv5);
            }
            Function0 onBack2 = (Function0) value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final Router router = (Router) consume;
            final boolean isJoined = basicInfo != null ? basicInfo.isJoined() : false;
            final KTribeeDesc desc = basicInfo != null ? basicInfo.getTribeeInfo() : null;
            boolean enableSearch = (basicInfo == null || (searchBar = basicInfo.getSearchBar()) == null) ? false : searchBar.getEnableSearch();
            Ref.ObjectRef tribeeId4 = new Ref.ObjectRef();
            tribeeId4.element = String.valueOf((basicInfo == null || (tribeeInfo2 = basicInfo.getTribeeInfo()) == null) ? null : Long.valueOf(tribeeInfo2.getId()));
            if (basicInfo == null || (tribeeInfo = basicInfo.getTribeeInfo()) == null) {
                tribeeId = tribeeId4;
            } else {
                tribeeId = tribeeId4;
                Builder appendQueryDroppingNull = UrisKt.appendQueryDroppingNull(UrisKt.toUri("bilibili://tribee/search").buildUpon(), "tribee_id", String.valueOf(tribeeInfo.getId()));
                KTribeeSearchBar searchBar2 = basicInfo.getSearchBar();
                Builder appendQueryDroppingNull2 = UrisKt.appendQueryDroppingNull(appendQueryDroppingNull, "global_search_uri", searchBar2 != null ? searchBar2.getSearchUri() : null);
                KTribeeSearchBar searchBar3 = basicInfo.getSearchBar();
                Builder appendQueryDroppingNull3 = UrisKt.appendQueryDroppingNull(appendQueryDroppingNull2, "hint", searchBar3 != null ? searchBar3.getHint() : null);
                KTribeeSearchBar searchBar4 = basicInfo.getSearchBar();
                str = UrisKt.appendQueryDroppingNull(appendQueryDroppingNull3, "enable_history", searchBar4 != null && searchBar4.getEnableSearchHistory() ? "1" : "0").build().toString();
            }
            str = "";
            String searchUri3 = str;
            Ref.ObjectRef tribeeId5 = tribeeId;
            Function0 onClickUserCenter5 = onClickUserCenter2;
            final Function1 onStateAction5 = onStateAction2;
            Modifier modifier3 = SizeKt.height-3ABfNKs(WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxWidth$default(BackgroundKt.background-bw27NRU$default(modifier2, Color.copy-wmQWz5c$default(j, scrollProgress, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null)), TribeeHomePageKt.getNAVIGATION_HEIGHT());
            String str7 = "CC(remember):TribeeDetailCompose.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer4, -1597457097, str7);
            boolean invalid$iv2 = (29360128 & $dirty5) == 8388608;
            Object it$iv5 = $composer4.rememberedValue();
            if (invalid$iv2 || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv6 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda33
                    public final Object invoke() {
                        Unit NavigationRow_pzZJ40c$lambda$5$0;
                        NavigationRow_pzZJ40c$lambda$5$0 = TribeeDetailComposeKt.NavigationRow_pzZJ40c$lambda$5$0(onUIAction2);
                        return NavigationRow_pzZJ40c$lambda$5$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv6);
                it$iv5 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier3, (MutableInteractionSource) null, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv5, 28, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            onUIAction = onUIAction2;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i9 = ((384 >> 6) & 112) | 6;
            RowScope $this$NavigationRow_pzZJ40c_u24lambda_u246 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 1299221062, "C383@15397L24,385@15498L6,391@15705L39,393@15823L12,382@15355L514,397@15879L4160,489@20049L1638:TribeeDetailCompose.kt#iitu82");
            Painter arrow_back_left_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer4, 6);
            long j2 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText2-0d7_KjU();
            Modifier modifier4 = PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer4, 319009928, str7);
            Object it$iv6 = $composer4.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv7 = InteractionSourceKt.MutableInteractionSource();
                $composer4.updateRememberedValue(value$iv7);
                it$iv6 = value$iv7;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, 319013677, str7);
            Object value$iv8 = $composer4.rememberedValue();
            if (value$iv8 == Composer.Companion.getEmpty()) {
                onBack = onBack2;
                value$iv8 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda34
                    public final Object invoke() {
                        Unit NavigationRow_pzZJ40c$lambda$6$1$0;
                        NavigationRow_pzZJ40c$lambda$6$1$0 = TribeeDetailComposeKt.NavigationRow_pzZJ40c$lambda$6$1$0(onBack);
                        return NavigationRow_pzZJ40c$lambda$6$1$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv8);
            } else {
                onBack = onBack2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            BiliIconfontKt.BiliIcon-ww6aTOc(arrow_back_left_line_500, ClickableKt.clickable-O2vRcR0$default(modifier4, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) value$iv8, 28, (Object) null), "back icon", j2, $composer4, Painter.$stable | 384, 0);
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$NavigationRow_pzZJ40c_u24lambda_u246, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(44));
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i11 = ((0 >> 6) & 112) | 6;
            BoxScope $this$NavigationRow_pzZJ40c_u24lambda_u246_u2423 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1589523838, "C:TribeeDetailCompose.kt#iitu82");
            if ((desc == null || (title = desc.getTitle()) == null || !(StringsKt.isBlank(title) ^ true)) ? false : true) {
                $composer4.startReplaceGroup(-1589565255);
                ComposerKt.sourceInformation($composer4, "400@16066L237,407@16478L992,404@16320L1150");
                $this$NavigationRow_pzZJ40c_u24lambda_u246_u242 = $this$NavigationRow_pzZJ40c_u24lambda_u246_u2423;
                $composer$iv = $composer4;
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                final State titleAlpha$delegate = AnimateAsStateKt.animateFloatAsState(scrollProgress >= 0.6f ? (scrollProgress - 0.6f) / 0.4f : 0.0f, AnimationSpecKt.tween$default(200, 0, EasingKt.getLinearOutSlowInEasing(), 2, (Object) null), 0.0f, (String) null, (Function1) null, $composer4, 0, 28);
                ComposePriorityHorizonKt.PriorityHorizon(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, Alignment.Companion.getCenterVertically(), ComposableLambdaKt.rememberComposableLambda(2127187381, true, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda35
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit NavigationRow_pzZJ40c$lambda$6$2$1;
                        NavigationRow_pzZJ40c$lambda$6$2$1 = TribeeDetailComposeKt.NavigationRow_pzZJ40c$lambda$6$2$1(desc, titleAlpha$delegate, colors, isJoined, onStateAction5, (PriorityHorizontalScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return NavigationRow_pzZJ40c$lambda$6$2$1;
                    }
                }, $composer4, 54), $composer4, 3462, 2);
                $composer4.endReplaceGroup();
                i2 = -1605513081;
            } else {
                $this$NavigationRow_pzZJ40c_u24lambda_u246_u242 = $this$NavigationRow_pzZJ40c_u24lambda_u246_u2423;
                $composer$iv = $composer4;
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                i2 = -1605513081;
                $composer4.startReplaceGroup(-1605513081);
                $composer4.endReplaceGroup();
            }
            if (enableSearch) {
                $composer4.startReplaceGroup(-1588058314);
                ComposerKt.sourceInformation($composer4, "433@17604L460,456@18500L237");
                State searchBarAlpha$delegate = AnimateAsStateKt.animateFloatAsState(scrollProgress <= 0.4f ? 1.0f : scrollProgress < 1.0f ? (1.0f - scrollProgress) / 0.6f : 0.0f, AnimationSpecKt.tween$default(200, 0, EasingKt.getLinearOutSlowInEasing(), 2, (Object) null), 0.0f, (String) null, (Function1) null, $composer4, 0, 28);
                if (NavigationRow_pzZJ40c$lambda$6$2$2(searchBarAlpha$delegate) > 0.0f) {
                    $composer4.startReplaceGroup(-1587541451);
                    ComposerKt.sourceInformation($composer4, "445@18128L266");
                    str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                    $composer$iv$iv$iv2 = $composer4;
                    $this$NavigationRow_pzZJ40c_u24lambda_u246_u2422 = $this$NavigationRow_pzZJ40c_u24lambda_u246_u242;
                    $composer$iv$iv$iv = $composer4;
                    $composer$iv3 = $composer4;
                    $composer2 = $composer4;
                    $composer$iv4 = $composer$iv;
                    tribeeId3 = tribeeId5;
                    str6 = str2;
                    str5 = str7;
                    $composer$iv2 = $composer4;
                    $composer$iv5 = $composer4;
                    f = 0.0f;
                    $composer3 = $composer4;
                    onClickUserCenter3 = onClickUserCenter5;
                    z = true;
                    $dirty3 = $dirty5;
                    NavigationSearchBar(basicInfo, searchUri3, router, (String) tribeeId5.element, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), NavigationRow_pzZJ40c$lambda$6$2$2(searchBarAlpha$delegate), $composer4, (($dirty5 >> 9) & 14) | 24576, 0);
                    $composer4.endReplaceGroup();
                    i3 = -1605513081;
                } else {
                    str5 = str7;
                    $composer$iv2 = $composer4;
                    onClickUserCenter3 = onClickUserCenter5;
                    tribeeId3 = tribeeId5;
                    $composer$iv$iv$iv = $composer4;
                    str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                    $composer$iv3 = $composer4;
                    $composer2 = $composer4;
                    $composer$iv$iv$iv2 = $composer4;
                    $this$NavigationRow_pzZJ40c_u24lambda_u246_u2422 = $this$NavigationRow_pzZJ40c_u24lambda_u246_u242;
                    $composer$iv4 = $composer$iv;
                    str6 = str2;
                    z = true;
                    f = 0.0f;
                    $composer$iv5 = $composer4;
                    $composer3 = $composer4;
                    $dirty3 = $dirty5;
                    i3 = -1605513081;
                    $composer4.startReplaceGroup(-1605513081);
                    $composer4.endReplaceGroup();
                }
                final State searchIconAlpha$delegate = AnimateAsStateKt.animateFloatAsState(scrollProgress >= 0.6f ? (scrollProgress - 0.6f) / 0.4f : f, AnimationSpecKt.tween$default(200, 0, EasingKt.getLinearOutSlowInEasing(), 2, (Object) null), 0.0f, (String) null, (Function1) null, $composer4, 0, 28);
                if (NavigationRow_pzZJ40c$lambda$6$2$3(searchIconAlpha$delegate) > f) {
                    $composer4.startReplaceGroup(-1586844044);
                    ComposerKt.sourceInformation($composer4, "467@19091L27,461@18802L1195");
                    Modifier modifier5 = PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs($this$NavigationRow_pzZJ40c_u24lambda_u246_u2422.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), Dp.constructor-impl(44)), Dp.constructor-impl(10));
                    str7 = str5;
                    ComposerKt.sourceInformationMarkerStart($composer4, -466821770, str7);
                    boolean invalid$iv3 = $composer4.changed(searchIconAlpha$delegate);
                    Object it$iv7 = $composer4.rememberedValue();
                    if (invalid$iv3 || it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv9 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda36
                            public final Object invoke(Object obj) {
                                Unit NavigationRow_pzZJ40c$lambda$6$2$4$0;
                                NavigationRow_pzZJ40c$lambda$6$2$4$0 = TribeeDetailComposeKt.NavigationRow_pzZJ40c$lambda$6$2$4$0(searchIconAlpha$delegate, (GraphicsLayerScope) obj);
                                return NavigationRow_pzZJ40c$lambda$6$2$4$0;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv9);
                        it$iv7 = value$iv9;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Modifier modifier$iv3 = GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) it$iv7);
                    ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, str3);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv3 = (0 << 3) & 112;
                    str4 = str6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, str4);
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                    Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv7;
                        $composer4.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv7;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                    $dirty2 = $dirty3;
                    searchUri = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i12 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i13 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 489063531, "C470@19226L25,472@19353L6,476@19555L39,469@19168L807:TribeeDetailCompose.kt#iitu82");
                    Painter magnifier_search_line_500 = BiliIconfont.INSTANCE.getMagnifier_search_line_500($composer4, 6);
                    long j3 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText2-0d7_KjU();
                    Modifier modifier6 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1262713848, str7);
                    Object it$iv8 = $composer4.rememberedValue();
                    if (it$iv8 == Composer.Companion.getEmpty()) {
                        Object value$iv10 = InteractionSourceKt.MutableInteractionSource();
                        $composer4.updateRememberedValue(value$iv10);
                        it$iv8 = value$iv10;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    tribeeId2 = tribeeId3;
                    searchUri2 = searchUri3;
                    BiliIconfontKt.BiliIcon-ww6aTOc(magnifier_search_line_500, ClickableKt.clickable-O2vRcR0$default(modifier6, (MutableInteractionSource) it$iv8, (Indication) null, false, (String) null, (Role) null, new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda25
                        public final Object invoke() {
                            Unit NavigationRow_pzZJ40c$lambda$6$2$5$1;
                            NavigationRow_pzZJ40c$lambda$6$2$5$1 = TribeeDetailComposeKt.NavigationRow_pzZJ40c$lambda$6$2$5$1(Router.this, searchUri2, tribeeId2);
                            return NavigationRow_pzZJ40c$lambda$6$2$5$1;
                        }
                    }, 28, (Object) null), (String) null, j3, $composer4, Painter.$stable | 384, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                } else {
                    searchUri2 = searchUri3;
                    $dirty2 = $dirty3;
                    searchUri = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    tribeeId2 = tribeeId3;
                    str4 = str6;
                    str7 = str5;
                    $composer4.startReplaceGroup(i3);
                }
                $composer4.endReplaceGroup();
            } else {
                $composer$iv2 = $composer4;
                $dirty2 = $dirty5;
                searchUri = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                onClickUserCenter3 = onClickUserCenter5;
                $composer$iv$iv$iv = $composer4;
                str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                $composer$iv3 = $composer4;
                $composer2 = $composer4;
                $composer$iv$iv$iv2 = $composer4;
                $composer$iv4 = $composer$iv;
                str4 = str2;
                z = true;
                searchUri2 = searchUri3;
                $composer$iv5 = $composer4;
                tribeeId2 = tribeeId5;
                $composer3 = $composer4;
                $composer4.startReplaceGroup(i2);
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            Modifier modifier$iv4 = PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), Dp.constructor-impl(10));
            Composer $composer$iv6 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv6, 1042775818, str3);
            Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv4 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv6, -1159599143, str4);
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv6, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer$iv6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv6, modifier$iv4);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Box = $changed$iv$iv4 << 6;
            int $changed$iv$iv$iv4 = ($i$f$Box & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv6, -553112988, searchUri);
            if (!($composer$iv6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv6.startReusableNode();
            if ($composer$iv6.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer$iv6.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer$iv6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i14 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i15 = ((6 >> 6) & 112) | 6;
            BoxScope $this$NavigationRow_pzZJ40c_u24lambda_u246_u243 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv6, 80290268, "C493@20184L13,495@20289L6,498@20414L39,500@20532L587,492@20138L1019:TribeeDetailCompose.kt#iitu82");
            Painter menu_line_500 = BiliIconfont.INSTANCE.getMenu_line_500($composer$iv6, 6);
            long j4 = BiliTheme.INSTANCE.getColors($composer$iv6, BiliTheme.$stable).getText2-0d7_KjU();
            Modifier modifier7 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer$iv6, -1659970645, str7);
            Object it$iv9 = $composer$iv6.rememberedValue();
            if (it$iv9 == Composer.Companion.getEmpty()) {
                Object value$iv11 = InteractionSourceKt.MutableInteractionSource();
                $composer$iv6.updateRememberedValue(value$iv11);
                it$iv9 = value$iv11;
            }
            MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) it$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
            ComposerKt.sourceInformationMarkerStart($composer$iv6, -1659966321, str7);
            $dirty = $dirty2;
            Composer $composer5 = $composer3;
            boolean changedInstance = (($dirty & 896) == 256 ? z : false) | ((458752 & $dirty) == 131072 ? z : false) | $composer5.changedInstance(basicInfo);
            if (($dirty & 3670016) != 1048576) {
                z = false;
            }
            boolean invalid$iv4 = changedInstance | z;
            Object it$iv10 = $composer$iv6.rememberedValue();
            if (!invalid$iv4 && it$iv10 != Composer.Companion.getEmpty()) {
                value$iv = it$iv10;
                onClickUserCenter = onClickUserCenter3;
                z2 = hasRedDot;
                onStateAction3 = onStateAction5;
                ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                BiliIconfontKt.BiliIcon-ww6aTOc(menu_line_500, ClickableKt.clickable-O2vRcR0$default(modifier7, mutableInteractionSource2, (Indication) null, false, (String) null, (Role) null, (Function0) value$iv, 28, (Object) null), "user center icon", j4, $composer$iv6, Painter.$stable | 384, 0);
                if (z2) {
                    onStateAction = onStateAction3;
                    $composer$iv6.startReplaceGroup(60264670);
                } else {
                    $composer$iv6.startReplaceGroup(81297395);
                    ComposerKt.sourceInformation($composer$iv6, "522@21458L186,516@21204L459");
                    Modifier modifier8 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default($this$NavigationRow_pzZJ40c_u24lambda_u246_u243.align(Modifier.Companion, Alignment.Companion.getTopEnd()), 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(8));
                    ComposerKt.sourceInformationMarkerStart($composer$iv6, -1659937090, str7);
                    boolean invalid$iv5 = $composer$iv6.changed(colors);
                    onStateAction = onStateAction3;
                    Object it$iv11 = $composer$iv6.rememberedValue();
                    if (!invalid$iv5 && it$iv11 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                        SpacerKt.Spacer(DrawModifierKt.drawBehind(modifier8, (Function1) it$iv11), $composer$iv6, 0);
                    }
                    Object value$iv12 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda27
                        public final Object invoke(Object obj) {
                            Unit NavigationRow_pzZJ40c$lambda$6$3$2$0;
                            NavigationRow_pzZJ40c$lambda$6$3$2$0 = TribeeDetailComposeKt.NavigationRow_pzZJ40c$lambda$6$3$2$0(colors, (DrawScope) obj);
                            return NavigationRow_pzZJ40c$lambda$6$3$2$0;
                        }
                    };
                    $composer$iv6.updateRememberedValue(value$iv12);
                    it$iv11 = value$iv12;
                    ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                    SpacerKt.Spacer(DrawModifierKt.drawBehind(modifier8, (Function1) it$iv11), $composer$iv6, 0);
                }
                $composer$iv6.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                $composer$iv6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                ComposerKt.sourceInformationMarkerStart($composer5, -1597248237, str7);
                invalid$iv = $composer5.changedInstance(basicInfo);
                it$iv = $composer5.rememberedValue();
                if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv13 = (Function2) new TribeeDetailComposeKt$NavigationRow$6$1(basicInfo, null);
                    $composer5.updateRememberedValue(value$iv13);
                    it$iv = value$iv13;
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                EffectsKt.LaunchedEffect(basicInfo, (Function2) it$iv, $composer5, ($dirty >> 9) & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer4 = $composer5;
            }
            onClickUserCenter = onClickUserCenter3;
            z2 = hasRedDot;
            onStateAction3 = onStateAction5;
            Object obj = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda26
                public final Object invoke() {
                    Unit NavigationRow_pzZJ40c$lambda$6$3$1$0;
                    NavigationRow_pzZJ40c$lambda$6$3$1$0 = TribeeDetailComposeKt.NavigationRow_pzZJ40c$lambda$6$3$1$0(z2, onClickUserCenter, basicInfo, onStateAction3);
                    return NavigationRow_pzZJ40c$lambda$6$3$1$0;
                }
            };
            $composer$iv6.updateRememberedValue(obj);
            value$iv = obj;
            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
            BiliIconfontKt.BiliIcon-ww6aTOc(menu_line_500, ClickableKt.clickable-O2vRcR0$default(modifier7, mutableInteractionSource2, (Indication) null, false, (String) null, (Role) null, (Function0) value$iv, 28, (Object) null), "user center icon", j4, $composer$iv6, Painter.$stable | 384, 0);
            if (z2) {
            }
            $composer$iv6.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
            $composer$iv6.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
            ComposerKt.sourceInformationMarkerStart($composer5, -1597248237, str7);
            invalid$iv = $composer5.changedInstance(basicInfo);
            it$iv = $composer5.rememberedValue();
            if (!invalid$iv) {
            }
            Object value$iv132 = (Function2) new TribeeDetailComposeKt$NavigationRow$6$1(basicInfo, null);
            $composer5.updateRememberedValue(value$iv132);
            it$iv = value$iv132;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            EffectsKt.LaunchedEffect(basicInfo, (Function2) it$iv, $composer5, ($dirty >> 9) & 14);
            if (ComposerKt.isTraceInProgress()) {
            }
            $composer4 = $composer5;
        } else {
            $dirty = $dirty4;
            $composer4.skipToGroupEnd();
            modifier2 = modifier;
            onClickUserCenter = function0;
            onUIAction = function12;
            onStateAction = function13;
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier9 = modifier2;
            final Function0 function02 = onClickUserCenter;
            final Function1 function14 = onStateAction;
            final Function1 function15 = onUIAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda28
                public final Object invoke(Object obj2, Object obj3) {
                    Unit NavigationRow_pzZJ40c$lambda$8;
                    NavigationRow_pzZJ40c$lambda$8 = TribeeDetailComposeKt.NavigationRow_pzZJ40c$lambda$8(j, scrollProgress, hasRedDot, basicInfo, modifier9, function02, function14, function15, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return NavigationRow_pzZJ40c$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow_pzZJ40c$lambda$3$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow_pzZJ40c$lambda$5$0(Function1 $onUIAction) {
        $onUIAction.invoke(TribeeHomeUIAction.ScrollToTop.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow_pzZJ40c$lambda$6$1$0(Function0 $onBack) {
        $onBack.invoke();
        return Unit.INSTANCE;
    }

    private static final float NavigationRow_pzZJ40c$lambda$6$2$0(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow_pzZJ40c$lambda$6$2$1(KTribeeDesc $desc, final State $titleAlpha$delegate, BiliColors $colors, boolean $isJoined, Function1 $onStateAction, PriorityHorizontalScope $this$PriorityHorizon, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$PriorityHorizon, "$this$PriorityHorizon");
        ComposerKt.sourceInformation($composer, "C409@16556L41,411@16723L22,408@16500L481:TribeeDetailCompose.kt#iitu82");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2127187381, $changed, -1, "kntr.app.tribee.consume.page.NavigationRow.<anonymous>.<anonymous>.<anonymous> (TribeeDetailCompose.kt:408)");
        }
        String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_station(Res.string.INSTANCE), $composer, 0);
        String title = $desc.getTitle();
        Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(8), 0.0f, 11, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, -177351893, "CC(remember):TribeeDetailCompose.kt#9igjgp");
        boolean invalid$iv = $composer.changed($titleAlpha$delegate);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj) {
                    Unit NavigationRow_pzZJ40c$lambda$6$2$1$0$0;
                    NavigationRow_pzZJ40c$lambda$6$2$1$0$0 = TribeeDetailComposeKt.NavigationRow_pzZJ40c$lambda$6$2$1$0$0($titleAlpha$delegate, (GraphicsLayerScope) obj);
                    return NavigationRow_pzZJ40c$lambda$6$2$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        PriorityTextKt.PriorityOverflowText(stringResource, title, GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) it$iv), new TextStyle($colors.getText1-0d7_KjU(), TextUnitKt.getSp(14), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null), $composer, 0, 0);
        if ($isJoined || NavigationRow_pzZJ40c$lambda$6$2$0($titleAlpha$delegate) <= 0.0f) {
            $composer.startReplaceGroup(-1219532275);
        } else {
            $composer.startReplaceGroup(-1202594371);
            ComposerKt.sourceInformation($composer, "419@17062L368");
            m698TribeeJoinButtonYiiH5w(false, SizeKt.size-VpY3zN4($this$PriorityHorizon.priority((Modifier) Modifier.Companion, 2), Dp.constructor-impl(50), Dp.constructor-impl(20)), NavigationRow_pzZJ40c$lambda$6$2$0($titleAlpha$delegate), Dp.constructor-impl(12), TextUnitKt.getSp(11), $onStateAction, $composer, 27654, 0);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow_pzZJ40c$lambda$6$2$1$0$0(State $titleAlpha$delegate, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha(NavigationRow_pzZJ40c$lambda$6$2$0($titleAlpha$delegate));
        return Unit.INSTANCE;
    }

    private static final float NavigationRow_pzZJ40c$lambda$6$2$2(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final float NavigationRow_pzZJ40c$lambda$6$2$3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow_pzZJ40c$lambda$6$2$4$0(State $searchIconAlpha$delegate, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha(NavigationRow_pzZJ40c$lambda$6$2$3($searchIconAlpha$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow_pzZJ40c$lambda$6$2$5$1(Router $router, String $searchUri, Ref.ObjectRef $tribeeId) {
        $router.launch(Uri.Companion.parse($searchUri));
        TrackerKt.reportTribeeSearchBarClick((String) $tribeeId.element);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow_pzZJ40c$lambda$6$3$1$0(boolean $hasRedDot, Function0 $onClickUserCenter, KTribeeBaseInfo $basicInfo, Function1 $onStateAction) {
        TrackerKt.reportMenuNotifyClick($hasRedDot ? "red_point" : "no_notice");
        $onClickUserCenter.invoke();
        if ($basicInfo != null && $basicInfo.isNewCodeRedDot()) {
            $onStateAction.invoke(new TribeeHomeStateAction.ReportNotification(true, false));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRow_pzZJ40c$lambda$6$3$2$0(BiliColors $colors, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        DrawScope.-CC.drawCircle-VaOC9Bg$default($this$drawBehind, $colors.getBg3-0d7_KjU(), 0.0f, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
        DrawScope.-CC.drawCircle-VaOC9Bg$default($this$drawBehind, $colors.getStress_red-0d7_KjU(), $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(3)), 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 124, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x02c1, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationSearchBar(final KTribeeBaseInfo basicInfo, final String searchUri, final Router router, final String tribeeId, Modifier modifier, float alpha, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final float alpha2;
        Modifier modifier3;
        float alpha3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        KTribeeSearchBar searchBar;
        Intrinsics.checkNotNullParameter(searchUri, "searchUri");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Composer $composer2 = $composer.startRestartGroup(-1925081312);
        ComposerKt.sourceInformation($composer2, "C(NavigationSearchBar)N(basicInfo,searchUri,router,tribeeId,modifier,alpha)546@22087L22,545@22040L1455:TribeeDetailCompose.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(basicInfo) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(searchUri) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(router) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(tribeeId) ? 2048 : 1024;
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
            alpha2 = alpha;
        } else if ((196608 & $changed) == 0) {
            alpha2 = alpha;
            $dirty |= $composer2.changed(alpha2) ? 131072 : 65536;
        } else {
            alpha2 = alpha;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            alpha3 = alpha2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                alpha2 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1925081312, $dirty2, -1, "kntr.app.tribee.consume.page.NavigationSearchBar (TribeeDetailCompose.kt:544)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1127771318, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            boolean invalid$iv = (458752 & $dirty2) == 131072;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit NavigationSearchBar$lambda$0$0;
                        NavigationSearchBar$lambda$0$0 = TribeeDetailComposeKt.NavigationSearchBar$lambda$0$0(alpha2, (GraphicsLayerScope) obj);
                        return NavigationSearchBar$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = GraphicsLayerModifierKt.graphicsLayer(modifier4, (Function1) it$iv);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 225521496, "C556@22417L6,558@22505L39,561@22659L144,549@22172L1317:TribeeDetailCompose.kt#iitu82");
            Modifier modifier5 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(34)), 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(17))), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 145831597, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            boolean z = alpha2 > 0.3f;
            ComposerKt.sourceInformationMarkerStart($composer2, 145836630, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(router) | (($dirty2 & 112) == 32) | (($dirty2 & 7168) == 2048);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit NavigationSearchBar$lambda$1$1$0;
                    NavigationSearchBar$lambda$1$1$0 = TribeeDetailComposeKt.NavigationSearchBar$lambda$1$1$0(Router.this, searchUri, tribeeId);
                    return NavigationSearchBar$lambda$1$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-O2vRcR0$default(modifier5, mutableInteractionSource, (Indication) null, z, (String) null, (Role) null, (Function0) it$iv3, 24, (Object) null), 0.0f, Dp.constructor-impl(6), 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            alpha3 = alpha2;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i7 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 71444964, "C568@22960L25,570@23063L6,567@22914L248,573@23175L38,576@23323L9,577@23372L6,574@23226L253:TribeeDetailCompose.kt#iitu82");
            BiliIconfontKt.BiliIcon-ww6aTOc(BiliIconfont.INSTANCE.getMagnifier_search_line_500($composer2, 6), SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(16)), (String) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
            SpacerKt.Spacer(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer2, 6);
            TextKt.Text-Nvy7gAk((basicInfo == null || (searchBar = basicInfo.getSearchBar()) == null || (r5 = searchBar.getHint()) == null) ? "" : "", (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 0, 24960, 110586);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            final float f = alpha3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NavigationSearchBar$lambda$2;
                    NavigationSearchBar$lambda$2 = TribeeDetailComposeKt.NavigationSearchBar$lambda$2(basicInfo, searchUri, router, tribeeId, modifier6, f, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NavigationSearchBar$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationSearchBar$lambda$0$0(float $alpha, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha($alpha);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationSearchBar$lambda$1$1$0(Router $router, String $searchUri, String $tribeeId) {
        $router.launch(Uri.Companion.parse($searchUri));
        TrackerKt.reportTribeeSearchBarClick($tribeeId);
        return Unit.INSTANCE;
    }

    public static final void TribeeImage(final String url, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(url, "url");
        Composer $composer3 = $composer.startRestartGroup(1413671120);
        ComposerKt.sourceInformation($composer3, "C(TribeeImage)N(url,modifier)590@23588L154:TribeeDetailCompose.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(url) ? 4 : 2;
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
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1413671120, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeImage (TribeeDetailCompose.kt:589)");
            }
            ImageRequest $this$TribeeImage_u24lambda_u240 = new ImageRequest(url);
            $this$TribeeImage_u24lambda_u240.contentScale(ContentScale.Companion.getCrop());
            $composer2 = $composer3;
            BiliImageKt.BiliImage($this$TribeeImage_u24lambda_u240.build(), modifier3, null, null, null, null, null, null, null, $composer3, $dirty2 & 112, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeImage$lambda$1;
                    TribeeImage$lambda$1 = TribeeDetailComposeKt.TribeeImage$lambda$1(url, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeImage$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeJoinButton_YiiH_5w$lambda$0$0(TribeeHomeStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0194, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01d5, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* renamed from: TribeeJoinButton-YiiH-5w  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m698TribeeJoinButtonYiiH5w(final boolean isJoined, Modifier modifier, float alpha, float f, long j, Function1<? super TribeeHomeStateAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        final float alpha2;
        float f2;
        long j2;
        final Function1 onStateAction;
        Composer $composer2;
        Modifier modifier2;
        Function1 onStateAction2;
        float alpha3;
        float f3;
        long j3;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        long j4;
        Composer $composer3 = $composer.startRestartGroup(-284447564);
        ComposerKt.sourceInformation($composer3, "C(TribeeJoinButton)N(isJoined,modifier,alpha,iconSize:c#ui.unit.Dp,fontSize:c#ui.unit.TextUnit,onStateAction)606@23972L2,608@24007L6,609@24045L7,613@24130L443,622@24588L22,624@24679L39,626@24777L366,610@24057L2029:TribeeDetailCompose.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(isJoined) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            alpha2 = alpha;
        } else if (($changed & 384) == 0) {
            alpha2 = alpha;
            $dirty |= $composer3.changed(alpha2) ? 256 : 128;
        } else {
            alpha2 = alpha;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            f2 = f;
        } else if (($changed & 3072) == 0) {
            f2 = f;
            $dirty |= $composer3.changed(f2) ? 2048 : 1024;
        } else {
            f2 = f;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            j2 = j;
        } else if (($changed & 24576) == 0) {
            j2 = j;
            $dirty |= $composer3.changed(j2) ? 16384 : 8192;
        } else {
            j2 = j;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
            onStateAction = function1;
        } else if (($changed & 196608) == 0) {
            onStateAction = function1;
            $dirty |= $composer3.changedInstance(onStateAction) ? 131072 : 65536;
        } else {
            onStateAction = function1;
        }
        if (!$composer3.shouldExecute(($dirty & 74899) != 74898, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            onStateAction2 = onStateAction;
            alpha3 = alpha2;
            f3 = f2;
            j3 = j2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i3 != 0) {
                alpha2 = 1.0f;
            }
            if (i4 != 0) {
                f2 = Dp.constructor-impl(16);
            }
            if (i5 != 0) {
                j3 = TextUnitKt.getSp(14);
            } else {
                j3 = j2;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1523804790, "CC(remember):TribeeDetailCompose.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda16
                        public final Object invoke(Object obj) {
                            Unit TribeeJoinButton_YiiH_5w$lambda$0$0;
                            TribeeJoinButton_YiiH_5w$lambda$0$0 = TribeeDetailComposeKt.TribeeJoinButton_YiiH_5w$lambda$0$0((TribeeHomeStateAction) obj);
                            return TribeeJoinButton_YiiH_5w$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onStateAction3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onStateAction = onStateAction3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-284447564, $dirty, -1, "kntr.app.tribee.consume.page.TribeeJoinButton (TribeeDetailCompose.kt:607)");
            }
            final BiliColors colors = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer3, 1523810287, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            boolean invalid$iv = (($dirty & 14) == 4) | $composer3.changed(colors) | (($dirty & 896) == 256) | $composer3.changed(density);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj) {
                    Unit TribeeJoinButton_YiiH_5w$lambda$1$0;
                    TribeeJoinButton_YiiH_5w$lambda$1$0 = TribeeDetailComposeKt.TribeeJoinButton_YiiH_5w$lambda$1$0(isJoined, colors, alpha2, density, (DrawScope) obj);
                    return TribeeJoinButton_YiiH_5w$lambda$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier drawBehind = DrawModifierKt.drawBehind(modifier3, (Function1) it$iv2);
            ComposerKt.sourceInformationMarkerStart($composer3, 1523824522, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 896) == 256;
            modifier2 = modifier3;
            Object value$iv3 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            value$iv3 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj) {
                    Unit TribeeJoinButton_YiiH_5w$lambda$2$0;
                    TribeeJoinButton_YiiH_5w$lambda$2$0 = TribeeDetailComposeKt.TribeeJoinButton_YiiH_5w$lambda$2$0(alpha2, (GraphicsLayerScope) obj);
                    return TribeeJoinButton_YiiH_5w$lambda$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(drawBehind, (Function1) value$iv3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1523827451, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1523830914, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            boolean invalid$iv3 = (($dirty & 14) == 4) | ((458752 & $dirty) == 131072);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda19
                    public final Object invoke() {
                        Unit TribeeJoinButton_YiiH_5w$lambda$4$0;
                        TribeeJoinButton_YiiH_5w$lambda$4$0 = TribeeDetailComposeKt.TribeeJoinButton_YiiH_5w$lambda$4$0(isJoined, onStateAction);
                        return TribeeJoinButton_YiiH_5w$lambda$4$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(graphicsLayer, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv4, 28, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            onStateAction2 = onStateAction;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            alpha3 = alpha2;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -643991072, "C650@25628L124,648@25587L493:TribeeDetailCompose.kt#iitu82");
            if (!isJoined) {
                $composer3.startReplaceGroup(-643974302);
                ComposerKt.sourceInformation($composer3, "641@25349L17,642@25401L6,640@25303L264");
                BiliIconfontKt.BiliIcon-ww6aTOc(BiliIconfont.INSTANCE.getPlus_add_line_800($composer3, 6), SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(1), Dp.constructor-impl(2), 0.0f, 9, (Object) null), f2), "join icon", BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer3, Painter.$stable | 384, 0);
            } else {
                $composer3.startReplaceGroup(-669084054);
            }
            $composer3.endReplaceGroup();
            Res.string stringVar = Res.string.INSTANCE;
            String stringResource = StringResourcesKt.stringResource(isJoined ? String0_commonMainKt.getTribee_joined(stringVar) : String0_commonMainKt.getTribee_to_join(stringVar), $composer3, 0);
            if (isJoined) {
                $composer3.startReplaceGroup(-643451146);
                $composer3.endReplaceGroup();
                j4 = colors.getText3-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(-643393145);
                ComposerKt.sourceInformation($composer3, "658@25927L6");
                long j5 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer3.endReplaceGroup();
                j4 = j5;
            }
            TextKt.Text-Nvy7gAk(stringResource, (Modifier) null, j4, (TextAutoSize) null, j3, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, j3, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, $dirty & 57344, (($dirty >> 9) & 112) | 24960, 239594);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f3 = f2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final float f4 = alpha3;
            final float f5 = f3;
            final long j6 = j3;
            final Function1 function12 = onStateAction2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeJoinButton_YiiH_5w$lambda$6;
                    TribeeJoinButton_YiiH_5w$lambda$6 = TribeeDetailComposeKt.TribeeJoinButton_YiiH_5w$lambda$6(isJoined, modifier4, f4, f5, j6, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeJoinButton_YiiH_5w$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeJoinButton_YiiH_5w$lambda$1$0(boolean $isJoined, BiliColors $colors, float $alpha, Density $density, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        long j = Color.copy-wmQWz5c$default($isJoined ? $colors.getGraph_bg_thick-0d7_KjU() : $colors.getBrand_pink-0d7_KjU(), $alpha, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        int bits$iv$iv$iv = (int) ($this$drawBehind.getDrawContext().getSize-NH-jbRc() & 4294967295L);
        float x$iv = Float.intBitsToFloat(bits$iv$iv$iv) / 2.0f;
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(x$iv);
        DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$drawBehind, j, 0L, 0L, CornerRadius.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), new Stroke($density.toPx-0680j_4(Dp.constructor-impl(1)), 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), 0.0f, (ColorFilter) null, 0, 230, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeJoinButton_YiiH_5w$lambda$2$0(float $alpha, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha($alpha);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeJoinButton_YiiH_5w$lambda$4$0(boolean $isJoined, Function1 $onStateAction) {
        TribeeHomeStateAction.ToJoinTribee toJoinTribee;
        TrackerKt.reportJoinButtonClick($isJoined);
        if ($isJoined) {
            toJoinTribee = TribeeHomeStateAction.ToExitTribee.INSTANCE;
        } else {
            toJoinTribee = TribeeHomeStateAction.ToJoinTribee.INSTANCE;
        }
        $onStateAction.invoke(toJoinTribee);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeHeader_euL9pac$lambda$0$0(TribeeHomeStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* renamed from: TribeeHomeHeader-euL9pac  reason: not valid java name */
    public static final void m697TribeeHomeHeadereuL9pac(final long j, final KTribeeBaseInfo basicInfo, Modifier modifier, Function1<? super TribeeHomeStateAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function12;
        Composer $composer2;
        Modifier modifier3;
        Function1 onStateAction;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(basicInfo, "basicInfo");
        Composer $composer3 = $composer.startRestartGroup(-24259105);
        ComposerKt.sourceInformation($composer3, "C(TribeeHomeHeader)N(tribeeColor:c#ui.graphics.Color,basicInfo,modifier,onStateAction)672@26268L2,674@26303L6,677@26398L1878:TribeeDetailCompose.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(j) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(basicInfo) ? 32 : 16;
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
            function12 = function1;
        } else if (($changed & 3072) == 0) {
            function12 = function1;
            $dirty |= $composer3.changedInstance(function12) ? 2048 : 1024;
        } else {
            function12 = function1;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onStateAction = function12;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                onStateAction = function12;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer3, -1838158111, "CC(remember):TribeeDetailCompose.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda12
                        public final Object invoke(Object obj) {
                            Unit TribeeHomeHeader_euL9pac$lambda$0$0;
                            TribeeHomeHeader_euL9pac$lambda$0$0 = TribeeDetailComposeKt.TribeeHomeHeader_euL9pac$lambda$0$0((TribeeHomeStateAction) obj);
                            return TribeeHomeHeader_euL9pac$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onStateAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onStateAction = onStateAction2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-24259105, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeHomeHeader (TribeeDetailCompose.kt:673)");
            }
            final BiliColors colors = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable);
            boolean isJoined = basicInfo.isJoined();
            final KTribeeDesc desc = basicInfo.getTribeeInfo();
            if (desc != null) {
                Modifier modifier5 = modifier4;
                modifier3 = modifier5;
                Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, (Object) null), j, (Shape) null, 2, (Object) null)), 0.0f, TribeeHomePageKt.getNAVIGATION_HEIGHT(), 0.0f, Dp.constructor-impl(10), 5, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
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
                $composer2 = $composer3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i5 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 1111359095, "C686@26663L1607:TribeeDetailCompose.kt#iitu82");
                Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv2 = (6 << 3) & 112;
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
                int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i7 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 2112551219, "C690@26767L1493:TribeeDetailCompose.kt#iitu82");
                Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(6));
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv3 = (390 << 3) & 112;
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
                int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i9 = ((390 >> 6) & 112) | 6;
                RowScope $this$TribeeHomeHeader_euL9pac_u24lambda_u242_u240_u240 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, 263345865, "C697@27035L162,708@27480L561,702@27215L826,722@28059L187:TribeeDetailCompose.kt#iitu82");
                TribeeImage(desc.getFaceUrl(), ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), $composer3, 0, 0);
                ComposePriorityHorizonKt.PriorityHorizon(PaddingKt.padding-VpY3zN4$default(RowScope.-CC.weight$default($this$TribeeHomeHeader_euL9pac_u24lambda_u242_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null), null, Alignment.Companion.getCenterVertically(), ComposableLambdaKt.rememberComposableLambda(-925839926, true, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit TribeeHomeHeader_euL9pac$lambda$2$0$0$0;
                        TribeeHomeHeader_euL9pac$lambda$2$0$0$0 = TribeeDetailComposeKt.TribeeHomeHeader_euL9pac$lambda$2$0$0$0(desc, colors, (PriorityHorizontalScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return TribeeHomeHeader_euL9pac$lambda$2$0$0$0;
                    }
                }, $composer3, 54), $composer3, 3456, 2);
                m698TribeeJoinButtonYiiH5w(isJoined, SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(74), Dp.constructor-impl(30)), 0.0f, 0.0f, 0L, onStateAction, $composer3, (($dirty2 << 6) & 458752) | 48, 28);
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier6 = modifier4;
                    final Function1 function13 = onStateAction;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TribeeHomeHeader_euL9pac$lambda$1;
                            TribeeHomeHeader_euL9pac$lambda$1 = TribeeDetailComposeKt.TribeeHomeHeader_euL9pac$lambda$1(j, basicInfo, modifier6, function13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return TribeeHomeHeader_euL9pac$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier7 = modifier3;
            final Function1 function14 = onStateAction;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeHomeHeader_euL9pac$lambda$3;
                    TribeeHomeHeader_euL9pac$lambda$3 = TribeeDetailComposeKt.TribeeHomeHeader_euL9pac$lambda$3(j, basicInfo, modifier7, function14, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeHomeHeader_euL9pac$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeHeader_euL9pac$lambda$2$0$0$0(KTribeeDesc $desc, BiliColors $colors, PriorityHorizontalScope $this$PriorityHorizon, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$PriorityHorizon, "$this$PriorityHorizon");
        ComposerKt.sourceInformation($composer, "C710@27558L41,709@27502L521:TribeeDetailCompose.kt#iitu82");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-925839926, $changed, -1, "kntr.app.tribee.consume.page.TribeeHomeHeader.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeDetailCompose.kt:709)");
        }
        PriorityTextKt.PriorityOverflowText(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_station(Res.string.INSTANCE), $composer, 0), $desc.getTitle(), PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, Dp.constructor-impl(8), 0.0f, 11, (Object) null), new TextStyle($colors.getText1-0d7_KjU(), TextUnitKt.getSp(17), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777208, (DefaultConstructorMarker) null), $composer, 384, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void RefreshIndicator(final boolean isRefreshing, final PullToRefreshState refreshState, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(refreshState, "refreshState");
        Composer $composer2 = $composer.startRestartGroup(2034970067);
        ComposerKt.sourceInformation($composer2, "C(RefreshIndicator)N(isRefreshing,refreshState,modifier)739@28482L169,747@28692L85,746@28656L362:TribeeDetailCompose.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(isRefreshing) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(refreshState) ? 32 : 16;
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
                ComposerKt.traceEventStart(2034970067, $dirty2, -1, "kntr.app.tribee.consume.page.RefreshIndicator (TribeeDetailCompose.kt:738)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1396119676, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | (($dirty2 & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        float RefreshIndicator$lambda$0$0;
                        RefreshIndicator$lambda$0$0 = TribeeDetailComposeKt.RefreshIndicator$lambda$0$0(isRefreshing, refreshState);
                        return Float.valueOf(RefreshIndicator$lambda$0$0);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Function0 scaleFraction = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1396126312, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(scaleFraction);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda21
                    public final Object invoke(Object obj) {
                        Unit RefreshIndicator$lambda$1$0;
                        RefreshIndicator$lambda$1$0 = TribeeDetailComposeKt.RefreshIndicator$lambda$1$0(scaleFraction, (GraphicsLayerScope) obj);
                        return RefreshIndicator$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = GraphicsLayerModifierKt.graphicsLayer(modifier4, (Function1) it$iv2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -147009443, "C755@28933L6,756@28991L6,752@28817L195:TribeeDetailCompose.kt#iitu82");
            modifier3 = modifier4;
            PullToRefreshDefaults.INSTANCE.Indicator-2poqoh4(refreshState, isRefreshing, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.0f, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 << 3) & 112) | (PullToRefreshDefaults.$stable << 18), 36);
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
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda32
                public final Object invoke(Object obj, Object obj2) {
                    Unit RefreshIndicator$lambda$3;
                    RefreshIndicator$lambda$3 = TribeeDetailComposeKt.RefreshIndicator$lambda$3(isRefreshing, refreshState, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RefreshIndicator$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float RefreshIndicator$lambda$0$0(boolean $isRefreshing, PullToRefreshState $refreshState) {
        if ($isRefreshing) {
            return 1.0f;
        }
        return RangesKt.coerceIn(EasingKt.getLinearOutSlowInEasing().transform($refreshState.getDistanceFraction()), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RefreshIndicator$lambda$1$0(Function0 $scaleFraction, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setScaleX(((Number) $scaleFraction.invoke()).floatValue());
        $this$graphicsLayer.setScaleY(((Number) $scaleFraction.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeFloatPublish$lambda$0$0(TribeeHomeStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v11 */
    public static final void TribeeFloatPublish(final boolean hasJoined, final KPublishButton publishButton, Modifier modifier, Function1<? super TribeeHomeStateAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Function1 onStateAction;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(publishButton, "publishButton");
        Composer $composer2 = $composer.startRestartGroup(-1319199786);
        ComposerKt.sourceInformation($composer2, "C(TribeeFloatPublish)N(hasJoined,publishButton,modifier,onStateAction)766@29205L2,768@29240L6,786@29829L39,788@29939L381,778@29527L1209:TribeeDetailCompose.kt#iitu82");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(hasJoined) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(publishButton) ? 32 : 16;
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
            onStateAction = function1;
        } else if (($changed & 3072) == 0) {
            onStateAction = function1;
            $dirty |= $composer2.changedInstance(onStateAction) ? 2048 : 1024;
        } else {
            onStateAction = function1;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -735636552, "CC(remember):TribeeDetailCompose.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj) {
                            Unit TribeeFloatPublish$lambda$0$0;
                            TribeeFloatPublish$lambda$0$0 = TribeeDetailComposeKt.TribeeFloatPublish$lambda$0$0((TribeeHomeStateAction) obj);
                            return TribeeFloatPublish$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onStateAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onStateAction = onStateAction2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1319199786, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeFloatPublish (TribeeDetailCompose.kt:767)");
            }
            BiliColors colors = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable);
            final Function2 placeholder = ComposableSingletons$TribeeDetailComposeKt.INSTANCE.m678getLambda$1591105093$consume_debug();
            Modifier modifier5 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(ShadowKt.shadow-s4CzXII$default(modifier4, Dp.constructor-impl(2), RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 28, (Object) null), Dp.constructor-impl(48)), RoundedCornerShapeKt.getCircleShape()), colors.getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -735616547, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -735612685, "CC(remember):TribeeDetailCompose.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | $composer2.changedInstance(publishButton) | (($dirty2 & 7168) == 2048);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit TribeeFloatPublish$lambda$2$0;
                        TribeeFloatPublish$lambda$2$0 = TribeeDetailComposeKt.TribeeFloatPublish$lambda$2$0(hasJoined, publishButton, onStateAction);
                        return TribeeFloatPublish$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier5, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 215262955, "C804@30657L17,798@30402L328:TribeeDetailCompose.kt#iitu82");
            String $this$asRequest$iv = publishButton.getIconUrl();
            ImageRequest $this$TribeeFloatPublish_u24lambda_u243_u240 = new ImageRequest($this$asRequest$iv);
            $this$TribeeFloatPublish_u24lambda_u243_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, colors.getBrand_pink-0d7_KjU(), 0, 2, (Object) null));
            BiliImageKt.BiliImage($this$TribeeFloatPublish_u24lambda_u243_u240.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), null, null, null, null, null, placeholder, ComposableLambdaKt.rememberComposableLambda(-1568139903, true, new Function4() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit TribeeFloatPublish$lambda$3$1;
                    TribeeFloatPublish$lambda$3$1 = TribeeDetailComposeKt.TribeeFloatPublish$lambda$3$1(placeholder, (ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return TribeeFloatPublish$lambda$3$1;
                }
            }, $composer2, 54), $composer2, 113246256, 124);
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
            final Function1 function12 = onStateAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeDetailComposeKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeFloatPublish$lambda$4;
                    TribeeFloatPublish$lambda$4 = TribeeDetailComposeKt.TribeeFloatPublish$lambda$4(hasJoined, publishButton, modifier6, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeFloatPublish$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeFloatPublish$lambda$2$0(boolean $hasJoined, KPublishButton $publishButton, Function1 $onStateAction) {
        TrackerKt.reportPublishInBottom($hasJoined, Intrinsics.areEqual($publishButton.getPermType(), KGlobalPermissionType.QUALIFIED_BUT_BANNED.INSTANCE));
        $onStateAction.invoke(new TribeeHomeStateAction.GoToPublish(String.valueOf(TribeeExtensionsKt.getCurrentTimeMillis())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeFloatPublish$lambda$3$1(Function2 $placeholder, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)804@30659L13:TribeeDetailCompose.kt#iitu82");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1568139903, $changed, -1, "kntr.app.tribee.consume.page.TribeeFloatPublish.<anonymous>.<anonymous> (TribeeDetailCompose.kt:804)");
        }
        $placeholder.invoke($composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}