package kntr.watch.later.watchlater.compose;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.ScrollKt;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults;
import androidx.compose.material3.pulltorefresh.PullToRefreshKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
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
import bili.resource.common.CommonRes;
import bili.resource.common.String0_commonMainKt;
import bili.resource.favorites.FavoritesRes;
import bili.resource.favorites.Res;
import bili.resource.homepage.HomepageRes;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.consts.Tabs;
import kntr.watch.later.watchlater.consts.WatchLaterConstsKt;
import kntr.watch.later.watchlater.consts.WatchLaterConsts_androidKt;
import kntr.watch.later.watchlater.data.PageState;
import kntr.watch.later.watchlater.data.WatchLaterItem;
import kntr.watch.later.watchlater.data.WatchLaterList;
import kntr.watch.later.watchlater.data.WatchLaterState;
import kntr.watch.later.watchlater.data.WatchLaterTabState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.common.compose.res.generated.resources.Drawable0_commonMainKt;

/* compiled from: WatchLaterPageCompose.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u0084\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\n26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\n21\u0010\u0017\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000e2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u0010%\u001aA\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u0010*\u001a\u0090\u0004\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\n26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020321\u0010\u0017\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000e2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u00105\u001at\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.2\u0006\u00108\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u00109\u001a\u0088\u0002\u0010:\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020>26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\n2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020\u00072\b\b\u0002\u0010B\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010C\u001aÐ\u0001\u0010D\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000526\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010E\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010F\u001a\u001b\u0010G\u001a\u00020\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u0010H\u001a\r\u0010I\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010J\u001a\r\u0010K\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010J¨\u0006L"}, d2 = {"WatchLaterPage", "", "pageState", "Lkntr/watch/later/watchlater/data/WatchLaterState;", "buttonClickable", "", "tabAllListState", "Landroidx/compose/foundation/lazy/LazyListState;", "tabToViewListState", "onBackClick", "Lkotlin/Function0;", "onManageClick", "onPlayButtonClick", "onCardClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "checkMode", "Lkntr/watch/later/watchlater/data/WatchLaterItem;", "item", "onCardLongClick", "onClickMoveTo", "onClickCopyTo", "onTabClick", "", "index", "Lkotlin/coroutines/Continuation;", "", "onLoadMore", "Lkotlin/Function1;", "onRefresh", "onRetryClick", "onThreePointClick", "onCheckAllClick", "onCancelAllClick", "onDeleteClick", "onSortButtonClick", "(Lkntr/watch/later/watchlater/data/WatchLaterState;ZLandroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "WatchLaterToolBar", "title", "", "manageText", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "WatchLaterContentPage", "isCheckMode", "tabList", "Lkntr/watch/later/watchlater/consts/Tabs;", "asc", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "pageAllState", "Lkntr/watch/later/watchlater/data/WatchLaterTabState;", "pageToViewState", "(ZLkntr/watch/later/watchlater/consts/Tabs;ZZLandroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkntr/watch/later/watchlater/data/WatchLaterTabState;Lkntr/watch/later/watchlater/data/WatchLaterTabState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "WatchLaterTabRow", "selectedTabIndex", "ascend", "(ILkntr/watch/later/watchlater/consts/Tabs;ZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "WatchLaterListPage", "list", "Lkntr/watch/later/watchlater/data/WatchLaterList;", "hasMore", "Lkntr/watch/later/watchlater/data/PageState;", "modifier", "Landroidx/compose/ui/Modifier;", "listState", "isRefreshing", "(ZLkntr/watch/later/watchlater/data/WatchLaterList;ZLkntr/watch/later/watchlater/data/PageState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;ZLandroidx/compose/runtime/Composer;III)V", "ListPage", "state", "(ZLkntr/watch/later/watchlater/data/WatchLaterList;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;II)V", "ErrorPage", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "EmptyPage", "(Landroidx/compose/runtime/Composer;I)V", "LoadingPage", "watch_later_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WatchLaterPageComposeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyPage$lambda$1(int i, Composer composer, int i2) {
        EmptyPage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorPage$lambda$1(Function0 function0, int i, Composer composer, int i2) {
        ErrorPage(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListPage$lambda$2(boolean z, WatchLaterList watchLaterList, boolean z2, Function2 function2, Function2 function22, Function1 function1, Function0 function0, LazyListState lazyListState, int i, int i2, Composer composer, int i3) {
        ListPage(z, watchLaterList, z2, function2, function22, function1, function0, lazyListState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingPage$lambda$1(int i, Composer composer, int i2) {
        LoadingPage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterContentPage$lambda$1(boolean z, Tabs tabs, boolean z2, boolean z3, PagerState pagerState, LazyListState lazyListState, LazyListState lazyListState2, Function0 function0, Function0 function02, Function2 function2, Function2 function22, Function0 function03, Function0 function04, WatchLaterTabState watchLaterTabState, WatchLaterTabState watchLaterTabState2, Function2 function23, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function0 function05, int i, int i2, int i3, Composer composer, int i4) {
        WatchLaterContentPage(z, tabs, z2, z3, pagerState, lazyListState, lazyListState2, function0, function02, function2, function22, function03, function04, watchLaterTabState, watchLaterTabState2, function23, function1, function12, function13, function14, function15, function16, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterListPage$lambda$1(boolean z, WatchLaterList watchLaterList, boolean z2, PageState pageState, Function2 function2, Function2 function22, Function0 function0, Function0 function02, Function0 function03, Function1 function1, Modifier modifier, LazyListState lazyListState, boolean z3, int i, int i2, int i3, Composer composer, int i4) {
        WatchLaterListPage(z, watchLaterList, z2, pageState, function2, function22, function0, function02, function03, function1, modifier, lazyListState, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterPage$lambda$3(WatchLaterState watchLaterState, boolean z, LazyListState lazyListState, LazyListState lazyListState2, Function0 function0, Function0 function02, Function0 function03, Function2 function2, Function2 function22, Function0 function04, Function0 function05, Function2 function23, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function0 function06, Function0 function07, int i, int i2, Composer composer, int i3) {
        WatchLaterPage(watchLaterState, z, lazyListState, lazyListState2, function0, function02, function03, function2, function22, function04, function05, function23, function1, function12, function13, function14, function15, function16, function06, function07, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterTabRow$lambda$1(int i, Tabs tabs, boolean z, boolean z2, boolean z3, Function1 function1, Function0 function0, Function0 function02, int i2, Composer composer, int i3) {
        WatchLaterTabRow(i, tabs, z, z2, z3, function1, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterToolBar$lambda$1(String str, String str2, boolean z, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        WatchLaterToolBar(str, str2, z, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void WatchLaterPage(final WatchLaterState pageState, final boolean buttonClickable, final LazyListState tabAllListState, final LazyListState tabToViewListState, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function2, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function22, final Function0<Unit> function04, final Function0<Unit> function05, final Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function23, final Function1<? super Integer, Unit> function1, final Function1<? super Integer, Unit> function12, final Function1<? super Integer, Unit> function13, final Function1<? super WatchLaterItem, Unit> function14, final Function1<? super Integer, Unit> function15, final Function1<? super Integer, Unit> function16, final Function0<Unit> function06, final Function0<Unit> function07, Composer $composer, final int $changed, final int $changed1) {
        Function1<? super Integer, Unit> function17;
        Function0<Unit> function08;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        StringResource common_global_string_233;
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(tabAllListState, "tabAllListState");
        Intrinsics.checkNotNullParameter(tabToViewListState, "tabToViewListState");
        Intrinsics.checkNotNullParameter(function0, "onBackClick");
        Intrinsics.checkNotNullParameter(function02, "onManageClick");
        Intrinsics.checkNotNullParameter(function03, "onPlayButtonClick");
        Intrinsics.checkNotNullParameter(function2, "onCardClick");
        Intrinsics.checkNotNullParameter(function22, "onCardLongClick");
        Intrinsics.checkNotNullParameter(function04, "onClickMoveTo");
        Intrinsics.checkNotNullParameter(function05, "onClickCopyTo");
        Intrinsics.checkNotNullParameter(function23, "onTabClick");
        Intrinsics.checkNotNullParameter(function1, "onLoadMore");
        Intrinsics.checkNotNullParameter(function12, "onRefresh");
        Intrinsics.checkNotNullParameter(function13, "onRetryClick");
        Intrinsics.checkNotNullParameter(function14, "onThreePointClick");
        Intrinsics.checkNotNullParameter(function15, "onCheckAllClick");
        Intrinsics.checkNotNullParameter(function16, "onCancelAllClick");
        Intrinsics.checkNotNullParameter(function06, "onDeleteClick");
        Intrinsics.checkNotNullParameter(function07, "onSortButtonClick");
        Composer $composer3 = $composer.startRestartGroup(1411605904);
        ComposerKt.sourceInformation($composer3, "C(WatchLaterPage)N(pageState,buttonClickable,tabAllListState,tabToViewListState,onBackClick,onManageClick,onPlayButtonClick,onCardClick,onCardLongClick,onClickMoveTo,onClickCopyTo,onTabClick,onLoadMore,onRefresh,onRetryClick,onThreePointClick,onCheckAllClick,onCancelAllClick,onDeleteClick,onSortButtonClick)101@4845L20,105@4979L41,103@4895L125,108@5087L6,108@5025L1688:WatchLaterPageCompose.kt#b3vx81");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(pageState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(buttonClickable) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(tabAllListState) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(tabToViewListState) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 16384 : 8192;
        }
        if (($changed & 196608) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function03) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 67108864 : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changedInstance(function04) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(function05) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changedInstance(function23) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer3.changedInstance(function12) ? 2048 : 1024;
        }
        if (($changed1 & 24576) == 0) {
            $dirty1 |= $composer3.changedInstance(function13) ? 16384 : 8192;
        }
        if (($changed1 & 196608) == 0) {
            function17 = function15;
            $dirty1 |= $composer3.changedInstance(function14) ? 131072 : 65536;
        } else {
            function17 = function15;
        }
        if (($changed1 & 1572864) == 0) {
            $dirty1 |= $composer3.changedInstance(function17) ? 1048576 : 524288;
        }
        if (($changed1 & 12582912) == 0) {
            function08 = function06;
            $dirty1 |= $composer3.changedInstance(function16) ? 8388608 : 4194304;
        } else {
            function08 = function06;
        }
        if (($changed1 & 100663296) == 0) {
            $dirty1 |= $composer3.changedInstance(function08) ? 67108864 : 33554432;
        }
        if (($changed1 & 805306368) == 0) {
            $dirty1 |= $composer3.changedInstance(function07) ? 536870912 : 268435456;
        }
        int $dirty12 = $dirty1;
        if ($composer3.shouldExecute((($dirty & 306783379) == 306783378 && (306783379 & $dirty12) == 306783378) ? false : true, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1411605904, $dirty, $dirty12, "kntr.watch.later.watchlater.compose.WatchLaterPage (WatchLaterPageCompose.kt:100)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -656364668, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = WatchLaterConstsKt.getTabList();
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Tabs tabList = (Tabs) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            int watchLaterInitialPageIndex = WatchLaterConsts_androidKt.getWatchLaterInitialPageIndex();
            ComposerKt.sourceInformationMarkerStart($composer3, -656360359, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            Object value$iv2 = $composer3.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        int WatchLaterPage$lambda$1$0;
                        WatchLaterPage$lambda$1$0 = WatchLaterPageComposeKt.WatchLaterPage$lambda$1$0(Tabs.this);
                        return Integer.valueOf(WatchLaterPage$lambda$1$0);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            PagerState pagerState = PagerStateKt.rememberPagerState(watchLaterInitialPageIndex, 0.0f, (Function0) value$iv2, $composer3, 384, 2);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 122451084, "C110@5149L57,112@5249L270,109@5110L549,123@5668L1039:WatchLaterPageCompose.kt#b3vx81");
            String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_292(CommonRes.INSTANCE.getString()), $composer3, 0);
            if (pageState.isCheckMode()) {
                common_global_string_233 = bili.resource.homepage.String0_commonMainKt.getHomepage_global_string_111(HomepageRes.INSTANCE.getString());
            } else {
                common_global_string_233 = String0_commonMainKt.getCommon_global_string_233(CommonRes.INSTANCE.getString());
            }
            int $dirty2 = $dirty;
            $composer2 = $composer3;
            WatchLaterToolBar(stringResource, StringResourcesKt.stringResource(common_global_string_233, $composer3, 0), buttonClickable, function0, function02, $composer3, (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344));
            WatchLaterContentPage(pageState.isCheckMode(), tabList, pageState.getAsc(), buttonClickable, pagerState, tabAllListState, tabToViewListState, function07, function03, function2, function22, function04, function05, pageState.getTabAll(), pageState.getTabToView(), function23, function1, function12, function13, function14, function15, function16, function06, $composer3, (($dirty2 << 6) & 7168) | 48 | (($dirty2 << 9) & 458752) | (($dirty2 << 9) & 3670016) | (($dirty12 >> 6) & 29360128) | (($dirty2 << 6) & 234881024) | (($dirty2 << 6) & 1879048192), (($dirty2 >> 24) & 14) | (($dirty2 >> 24) & 112) | (($dirty12 << 6) & 896) | (($dirty12 << 12) & 458752) | (($dirty12 << 12) & 3670016) | (($dirty12 << 12) & 29360128) | (($dirty12 << 12) & 234881024) | (1879048192 & ($dirty12 << 12)), (($dirty12 >> 18) & 14) | (($dirty12 >> 18) & 112) | (($dirty12 >> 18) & 896));
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterPage$lambda$3;
                    WatchLaterPage$lambda$3 = WatchLaterPageComposeKt.WatchLaterPage$lambda$3(WatchLaterState.this, buttonClickable, tabAllListState, tabToViewListState, function0, function02, function03, function2, function22, function04, function05, function23, function1, function12, function13, function14, function15, function16, function06, function07, $changed, $changed1, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterPage$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int WatchLaterPage$lambda$1$0(Tabs $tabList) {
        return $tabList.getTabs().size();
    }

    public static final void WatchLaterToolBar(final String title, final String manageText, final boolean buttonClickable, final Function0<Unit> function0, final Function0<Unit> function02, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(manageText, "manageText");
        Intrinsics.checkNotNullParameter(function0, "onBackClick");
        Intrinsics.checkNotNullParameter(function02, "onManageClick");
        Composer $composer3 = $composer.startRestartGroup(1713489879);
        ComposerKt.sourceInformation($composer3, "C(WatchLaterToolBar)N(title,manageText,buttonClickable,onBackClick,onManageClick)162@6993L11,159@6902L2152:WatchLaterPageCompose.kt#b3vx81");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(manageText) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(buttonClickable) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1713489879, $dirty2, -1, "kntr.watch.later.watchlater.compose.WatchLaterToolBar (WatchLaterPageCompose.kt:158)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getThemeColors($composer3, BiliTheme.$stable).getPrimary-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(44));
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 746703037, "C174@7377L11,175@7430L9,167@7139L388,179@7536L1512:WatchLaterPageCompose.kt#b3vx81");
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(80), 0.0f, 2, (Object) null);
            int i3 = TextAlign.Companion.getCenter-e0LSkKk();
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(title, modifier, BiliTheme.INSTANCE.getThemeColors($composer3, BiliTheme.$stable).getTextTitle-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i3), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT17b(), $composer3, ($dirty2 & 14) | 48, 24960, 109560);
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((390 >> 6) & 112) | 6;
            RowScope $this$WatchLaterToolBar_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1473732965, "C185@7709L424,196@8146L38,199@8272L11,200@8330L9,207@8622L107,213@8926L97,197@8197L841:WatchLaterPageCompose.kt#b3vx81");
            IconButtonKt.IconButton(function0, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$WatchLaterPageComposeKt.INSTANCE.m2580getLambda$803165361$watch_later_debug(), $composer3, (($dirty2 >> 9) & 14) | 1572864, 62);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$WatchLaterToolBar_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
            long j = BiliTheme.INSTANCE.getThemeColors($composer3, BiliTheme.$stable).getActionIcon-0d7_KjU();
            TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14();
            Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(12), 0.0f, 11, (Object) null), Dp.constructor-impl(4), 0.0f, Dp.constructor-impl(4), 0.0f, 10, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1155946424, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier3 = ClickableKt.clickable-O2vRcR0$default(modifier2, (MutableInteractionSource) it$iv, (Indication) null, buttonClickable, (String) null, (Role) null, function02, 24, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1155956142, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda18
                    public final Object invoke(Object obj) {
                        Unit WatchLaterToolBar$lambda$0$0$1$0;
                        WatchLaterToolBar$lambda$0$0$1$0 = WatchLaterPageComposeKt.WatchLaterToolBar$lambda$0$0$1$0(buttonClickable, (GraphicsLayerScope) obj);
                        return WatchLaterToolBar$lambda$0$0$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text-Nvy7gAk(manageText, GraphicsLayerModifierKt.graphicsLayer(modifier3, (Function1) it$iv2), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t14, $composer3, ($dirty2 >> 3) & 14, 0, 131064);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterToolBar$lambda$1;
                    WatchLaterToolBar$lambda$1 = WatchLaterPageComposeKt.WatchLaterToolBar$lambda$1(title, manageText, buttonClickable, function0, function02, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterToolBar$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterToolBar$lambda$0$0$1$0(boolean $buttonClickable, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha($buttonClickable ? 1.0f : 0.4f);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:203:0x045b, code lost:
        if (r1 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L180;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void WatchLaterContentPage(final boolean isCheckMode, final Tabs tabList, final boolean asc, final boolean buttonClickable, final PagerState pagerState, final LazyListState tabAllListState, final LazyListState tabToViewListState, final Function0<Unit> function0, final Function0<Unit> function02, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function2, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function22, final Function0<Unit> function03, final Function0<Unit> function04, final WatchLaterTabState pageAllState, final WatchLaterTabState pageToViewState, final Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function23, final Function1<? super Integer, Unit> function1, final Function1<? super Integer, Unit> function12, final Function1<? super Integer, Unit> function13, final Function1<? super WatchLaterItem, Unit> function14, final Function1<? super Integer, Unit> function15, final Function1<? super Integer, Unit> function16, final Function0<Unit> function05, Composer $composer, final int $changed, final int $changed1, final int $changed2) {
        final Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function24;
        Function1<? super Integer, Unit> function17;
        Function1<? super Integer, Unit> function18;
        Function0<Unit> function06;
        Composer $composer2;
        int $dirty1;
        Intrinsics.checkNotNullParameter(tabList, "tabList");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Intrinsics.checkNotNullParameter(tabAllListState, "tabAllListState");
        Intrinsics.checkNotNullParameter(tabToViewListState, "tabToViewListState");
        Intrinsics.checkNotNullParameter(function0, "onSortButtonClick");
        Intrinsics.checkNotNullParameter(function02, "onPlayButtonClick");
        Intrinsics.checkNotNullParameter(function2, "onCardClick");
        Intrinsics.checkNotNullParameter(function22, "onCardLongClick");
        Intrinsics.checkNotNullParameter(function03, "onClickMoveTo");
        Intrinsics.checkNotNullParameter(function04, "onClickCopyTo");
        Intrinsics.checkNotNullParameter(pageAllState, "pageAllState");
        Intrinsics.checkNotNullParameter(pageToViewState, "pageToViewState");
        Intrinsics.checkNotNullParameter(function23, "onTabClick");
        Intrinsics.checkNotNullParameter(function1, "onLoadMore");
        Intrinsics.checkNotNullParameter(function12, "onRefresh");
        Intrinsics.checkNotNullParameter(function13, "onRetryClick");
        Intrinsics.checkNotNullParameter(function14, "onThreePointClick");
        Intrinsics.checkNotNullParameter(function15, "onCheckAllClick");
        Intrinsics.checkNotNullParameter(function16, "onCancelAllClick");
        Intrinsics.checkNotNullParameter(function05, "onDeleteClick");
        Composer $composer3 = $composer.startRestartGroup(2103326883);
        ComposerKt.sourceInformation($composer3, "C(WatchLaterContentPage)N(isCheckMode,tabList,asc,buttonClickable,pagerState,tabAllListState,tabToViewListState,onSortButtonClick,onPlayButtonClick,onCardClick,onCardLongClick,onClickMoveTo,onClickCopyTo,pageAllState,pageToViewState,onTabClick,onLoadMore,onRefresh,onRetryClick,onThreePointClick,onCheckAllClick,onCancelAllClick,onDeleteClick)248@10050L24,249@10079L2893:WatchLaterPageCompose.kt#b3vx81");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        int $dirty2 = $changed2;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(isCheckMode) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(tabList) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(asc) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(buttonClickable) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(pagerState) ? 16384 : 8192;
        }
        if (($changed & 196608) == 0) {
            $dirty |= $composer3.changed(tabAllListState) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(tabToViewListState) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 67108864 : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty12 |= $composer3.changedInstance(function22) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty12 |= $composer3.changedInstance(function03) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            $dirty12 |= $composer3.changedInstance(function04) ? 256 : 128;
        }
        if (($changed1 & 3072) == 0) {
            $dirty12 |= $composer3.changed(pageAllState) ? 2048 : 1024;
        }
        if (($changed1 & 24576) == 0) {
            $dirty12 |= $composer3.changed(pageToViewState) ? 16384 : 8192;
        }
        if ((196608 & $changed1) == 0) {
            function24 = function23;
            $dirty12 |= $composer3.changedInstance(function24) ? 131072 : 65536;
        } else {
            function24 = function23;
        }
        if (($changed1 & 1572864) == 0) {
            $dirty12 |= $composer3.changedInstance(function1) ? 1048576 : 524288;
        }
        if (($changed1 & 12582912) == 0) {
            function17 = function13;
            $dirty12 |= $composer3.changedInstance(function12) ? 8388608 : 4194304;
        } else {
            function17 = function13;
        }
        if (($changed1 & 100663296) == 0) {
            $dirty12 |= $composer3.changedInstance(function17) ? 67108864 : 33554432;
        }
        if (($changed1 & 805306368) == 0) {
            function18 = function15;
            $dirty12 |= $composer3.changedInstance(function14) ? 536870912 : 268435456;
        } else {
            function18 = function15;
        }
        int $dirty13 = $dirty12;
        if (($changed2 & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(function18) ? 4 : 2;
        }
        if (($changed2 & 48) == 0) {
            function06 = function05;
            $dirty2 |= $composer3.changedInstance(function16) ? 32 : 16;
        } else {
            function06 = function05;
        }
        if (($changed2 & 384) == 0) {
            $dirty2 |= $composer3.changedInstance(function06) ? 256 : 128;
        }
        if ($composer3.shouldExecute((($dirty & 306783379) == 306783378 && (306783379 & $dirty13) == 306783378 && ($dirty2 & 147) == 146) ? false : true, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2103326883, $dirty, $dirty13, "kntr.watch.later.watchlater.compose.WatchLaterContentPage (WatchLaterPageCompose.kt:247)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer3.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            $dirty1 = $dirty13;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1723191465, "C256@10343L162,250@10131L487,270@10797L6,265@10627L200,275@10934L2032,272@10836L2130:WatchLaterPageCompose.kt#b3vx81");
            int currentPage = pagerState.getCurrentPage();
            ComposerKt.sourceInformationMarkerStart($composer3, 1606985275, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(scope) | ((57344 & $dirty) == 16384) | $composer3.changedInstance(function24);
            Object value$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = new Function1() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit WatchLaterContentPage$lambda$0$0$0;
                    WatchLaterContentPage$lambda$0$0$0 = WatchLaterPageComposeKt.WatchLaterContentPage$lambda$0$0$0(scope, pagerState, function24, ((Integer) obj).intValue());
                    return WatchLaterContentPage$lambda$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            WatchLaterTabRow(currentPage, tabList, asc, buttonClickable, isCheckMode, value$iv, function0, function02, $composer3, ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 12) & 57344) | (($dirty >> 3) & 3670016) | (29360128 & ($dirty >> 3)));
            DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), 0.0f, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer3, 6, 2);
            PagerKt.HorizontalPager--8jOkeI(pagerState, (Modifier) null, (PaddingValues) null, (PageSize) null, 0, 0.0f, (Alignment.Vertical) null, (TargetedFlingBehavior) null, false, false, (Function1) null, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(1503807258, true, new Function4() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit WatchLaterContentPage$lambda$0$1;
                    WatchLaterContentPage$lambda$0$1 = WatchLaterPageComposeKt.WatchLaterContentPage$lambda$0$1(WatchLaterTabState.this, pageToViewState, tabAllListState, tabToViewListState, isCheckMode, function2, function22, function1, function12, function13, function14, function15, function16, function05, function04, function03, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    return WatchLaterContentPage$lambda$0$1;
                }
            }, $composer3, 54), $composer3, (($dirty >> 12) & 14) | 100663296, 24576, 16126);
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
            $dirty1 = $dirty13;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterContentPage$lambda$1;
                    WatchLaterContentPage$lambda$1 = WatchLaterPageComposeKt.WatchLaterContentPage$lambda$1(isCheckMode, tabList, asc, buttonClickable, pagerState, tabAllListState, tabToViewListState, function0, function02, function2, function22, function03, function04, pageAllState, pageToViewState, function23, function1, function12, function13, function14, function15, function16, function05, $changed, $changed1, $changed2, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterContentPage$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterContentPage$lambda$0$0$0(CoroutineScope $scope, PagerState $pagerState, Function2 $onTabClick, int index) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new WatchLaterPageComposeKt$WatchLaterContentPage$1$1$1$1($pagerState, index, $onTabClick, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x04b0, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x018e, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01de, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x022e, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L45;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit WatchLaterContentPage$lambda$0$1(WatchLaterTabState $pageAllState, WatchLaterTabState $pageToViewState, LazyListState $tabAllListState, LazyListState $tabToViewListState, boolean $isCheckMode, Function2 $onCardClick, Function2 $onCardLongClick, final Function1 $onLoadMore, final Function1 $onRefresh, final Function1 $onRetryClick, Function1 $onThreePointClick, final Function1 $onCheckAllClick, final Function1 $onCancelAllClick, Function0 $onDeleteClick, Function0 $onClickCopyTo, Function0 $onClickMoveTo, PagerScope $this$HorizontalPager, final int index, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        boolean checkedAll;
        int checkedCount;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter($this$HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation($composer, "CN(index)277@11035L1921:WatchLaterPageCompose.kt#b3vx81");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1503807258, $changed, -1, "kntr.watch.later.watchlater.compose.WatchLaterContentPage.<anonymous>.<anonymous> (WatchLaterPageCompose.kt:276)");
        }
        WatchLaterTabState pageState = index == 0 ? $pageAllState : $pageToViewState;
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Modifier modifier$iv = Modifier.Companion;
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        int i2 = ((0 >> 6) & 112) | 6;
        BoxScope $this$WatchLaterContentPage_u24lambda_u240_u241_u240 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -296534298, "C287@11552L21,288@11607L20,289@11664L23,278@11057L708:WatchLaterPageCompose.kt#b3vx81");
        WatchLaterList data = pageState.getData();
        boolean isRefreshing = pageState.isRefreshing();
        boolean hasMore = pageState.getHasMore();
        PageState pageState2 = pageState.getPageState();
        LazyListState lazyListState = index == 0 ? $tabAllListState : $tabToViewListState;
        ComposerKt.sourceInformationMarkerStart($composer, -425193643, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
        boolean invalid$iv = $composer.changed($onLoadMore) | (((($changed & 112) ^ 48) > 32 && $composer.changed(index)) || ($changed & 48) == 32);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv) {
        }
        Object value$iv = new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda21
            public final Object invoke() {
                Unit WatchLaterContentPage$lambda$0$1$0$0$0;
                WatchLaterContentPage$lambda$0$1$0$0$0 = WatchLaterPageComposeKt.WatchLaterContentPage$lambda$0$1$0$0$0($onLoadMore, index);
                return WatchLaterContentPage$lambda$0$1$0$0$0;
            }
        };
        $composer.updateRememberedValue(value$iv);
        it$iv = value$iv;
        Function0 function0 = (Function0) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -425191884, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed($onRefresh) | (((($changed & 112) ^ 48) > 32 && $composer.changed(index)) || ($changed & 48) == 32);
        Object value$iv2 = $composer.rememberedValue();
        if (invalid$iv2) {
        }
        value$iv2 = new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda22
            public final Object invoke() {
                Unit WatchLaterContentPage$lambda$0$1$0$1$0;
                WatchLaterContentPage$lambda$0$1$0$1$0 = WatchLaterPageComposeKt.WatchLaterContentPage$lambda$0$1$0$1$0($onRefresh, index);
                return WatchLaterContentPage$lambda$0$1$0$1$0;
            }
        };
        $composer.updateRememberedValue(value$iv2);
        Function0 function02 = value$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -425190057, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
        boolean invalid$iv3 = $composer.changed($onRetryClick) | (((($changed & 112) ^ 48) > 32 && $composer.changed(index)) || ($changed & 48) == 32);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv3) {
        }
        Object value$iv3 = new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit WatchLaterContentPage$lambda$0$1$0$2$0;
                WatchLaterContentPage$lambda$0$1$0$2$0 = WatchLaterPageComposeKt.WatchLaterContentPage$lambda$0$1$0$2$0($onRetryClick, index);
                return WatchLaterContentPage$lambda$0$1$0$2$0;
            }
        };
        $composer.updateRememberedValue(value$iv3);
        it$iv2 = value$iv3;
        ComposerKt.sourceInformationMarkerEnd($composer);
        WatchLaterListPage($isCheckMode, data, hasMore, pageState2, $onCardClick, $onCardLongClick, function0, function02, (Function0) it$iv2, $onThreePointClick, null, lazyListState, isRefreshing, $composer, 0, 0, 1024);
        if ($isCheckMode) {
            $composer.startReplaceGroup(-295821237);
            ComposerKt.sourceInformation($composer, "301@12231L693");
            Iterable $this$filter$iv = pageState.getData().getList();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Iterable $this$filter$iv2 = $this$filter$iv;
                WatchLaterItem it = (WatchLaterItem) element$iv$iv;
                WatchLaterItem it2 = it.getCardType() == 0 ? 1 : null;
                if (it2 != null) {
                    destination$iv$iv.add(element$iv$iv);
                }
                $this$filter$iv = $this$filter$iv2;
            }
            Iterable $this$all$iv = (List) destination$iv$iv;
            if (!($this$all$iv instanceof Collection) || !((Collection) $this$all$iv).isEmpty()) {
                Iterator it3 = $this$all$iv.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        Object element$iv = it3.next();
                        WatchLaterItem it4 = (WatchLaterItem) element$iv;
                        if (!it4.isChecked()) {
                            checkedAll = false;
                            break;
                        }
                    } else {
                        checkedAll = true;
                        break;
                    }
                }
            } else {
                checkedAll = true;
            }
            Iterable $this$filter$iv3 = pageState.getData().getList();
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$filter$iv3) {
                Iterable $this$filter$iv4 = $this$filter$iv3;
                WatchLaterItem it5 = (WatchLaterItem) element$iv$iv2;
                WatchLaterItem it6 = it5.getCardType() == 0 ? 1 : null;
                if (it6 != null) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
                $this$filter$iv3 = $this$filter$iv4;
            }
            Iterable $this$count$iv = (List) destination$iv$iv2;
            if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
                checkedCount = 0;
            } else {
                int count$iv = 0;
                for (Object element$iv2 : $this$count$iv) {
                    WatchLaterItem it7 = (WatchLaterItem) element$iv2;
                    if (it7.isChecked() && (count$iv = count$iv + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
                checkedCount = count$iv;
            }
            Modifier modifier$iv2 = $this$WatchLaterContentPage_u24lambda_u240_u241_u240.align(Modifier.Companion, Alignment.Companion.getBottomStart());
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
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
            $composer$iv = $composer;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -676628129, "C309@12596L26,310@12671L27,306@12419L483:WatchLaterPageCompose.kt#b3vx81");
            ComposerKt.sourceInformationMarkerStart($composer, 2056388475, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            $composer$iv$iv$iv = $composer;
            boolean invalid$iv4 = $composer.changed($onCheckAllClick) | (((($changed & 112) ^ 48) > 32 && $composer.changed(index)) || ($changed & 48) == 32);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv4 = new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit WatchLaterContentPage$lambda$0$1$0$7$0$0;
                    WatchLaterContentPage$lambda$0$1$0$7$0$0 = WatchLaterPageComposeKt.WatchLaterContentPage$lambda$0$1$0$7$0$0($onCheckAllClick, index);
                    return WatchLaterContentPage$lambda$0$1$0$7$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv4);
            it$iv3 = value$iv4;
            Function0 function03 = (Function0) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 2056390876, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            boolean invalid$iv5 = $composer.changed($onCancelAllClick) | (((($changed & 112) ^ 48) > 32 && $composer.changed(index)) || ($changed & 48) == 32);
            Object value$iv5 = $composer.rememberedValue();
            if (invalid$iv5 || value$iv5 == Composer.Companion.getEmpty()) {
                value$iv5 = new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit WatchLaterContentPage$lambda$0$1$0$7$1$0;
                        WatchLaterContentPage$lambda$0$1$0$7$1$0 = WatchLaterPageComposeKt.WatchLaterContentPage$lambda$0$1$0$7$1$0($onCancelAllClick, index);
                        return WatchLaterContentPage$lambda$0$1$0$7$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            WatchLaterWidgetKt.FooterBatchEditView(checkedAll, checkedCount, function03, value$iv5, $onDeleteClick, $onClickCopyTo, $onClickMoveTo, null, $composer, 0, 128);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
        } else {
            $composer$iv = $composer;
            $composer$iv$iv$iv = $composer;
            $composer.startReplaceGroup(-307562270);
        }
        $composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer$iv);
        $composer$iv$iv$iv.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterContentPage$lambda$0$1$0$0$0(Function1 $onLoadMore, int $index) {
        $onLoadMore.invoke(Integer.valueOf($index));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterContentPage$lambda$0$1$0$1$0(Function1 $onRefresh, int $index) {
        $onRefresh.invoke(Integer.valueOf($index));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterContentPage$lambda$0$1$0$2$0(Function1 $onRetryClick, int $index) {
        $onRetryClick.invoke(Integer.valueOf($index));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterContentPage$lambda$0$1$0$7$0$0(Function1 $onCheckAllClick, int $index) {
        $onCheckAllClick.invoke(Integer.valueOf($index));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterContentPage$lambda$0$1$0$7$1$0(Function1 $onCancelAllClick, int $index) {
        $onCancelAllClick.invoke(Integer.valueOf($index));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void WatchLaterTabRow(final int selectedTabIndex, final Tabs tabList, final boolean ascend, final boolean buttonClickable, final boolean isCheckMode, final Function1<? super Integer, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        boolean z;
        TextStyle t13;
        long j;
        Object value$iv;
        long j2;
        Object it$iv;
        boolean invalid$iv;
        Object it$iv2;
        int i = selectedTabIndex;
        Intrinsics.checkNotNullParameter(tabList, "tabList");
        Intrinsics.checkNotNullParameter(function1, "onTabClick");
        Intrinsics.checkNotNullParameter(function0, "onSortButtonClick");
        Intrinsics.checkNotNullParameter(function02, "onPlayButtonClick");
        Composer $composer2 = $composer.startRestartGroup(270160883);
        ComposerKt.sourceInformation($composer2, "C(WatchLaterTabRow)N(selectedTabIndex,tabList,ascend,buttonClickable,isCheckMode,onTabClick,onSortButtonClick,onPlayButtonClick)333@13258L3033:WatchLaterPageCompose.kt#b3vx81");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(i) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(tabList) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(ascend) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(buttonClickable) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(isCheckMode) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 8388608 : 4194304;
        }
        if (!$composer2.shouldExecute((4793491 & $dirty) != 4793490, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(270160883, $dirty, -1, "kntr.watch.later.watchlater.compose.WatchLaterTabRow (WatchLaterPageCompose.kt:332)");
            }
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(52)), Dp.constructor-impl(12));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1123484656, "C342@13529L1432,370@14970L1315:WatchLaterPageCompose.kt#b3vx81");
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -2044682948, "C:WatchLaterPageCompose.kt#b3vx81");
            $composer2.startReplaceGroup(1596610874);
            ComposerKt.sourceInformation($composer2, "*352@14065L101,363@14728L115,359@14510L21,345@13668L1269");
            Iterable $this$forEachIndexed$iv = tabList.getTabs();
            boolean z3 = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String title = (String) item$iv;
                final int index = index$iv;
                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                boolean isSelected = i == index;
                int i6 = TextAlign.Companion.getCenter-e0LSkKk();
                if (isSelected) {
                    z = z3;
                    $composer2.startReplaceGroup(-1758217175);
                    ComposerKt.sourceInformation($composer2, "348@13812L9");
                    t13 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13b();
                } else {
                    z = z3;
                    $composer2.startReplaceGroup(-1758216216);
                    ComposerKt.sourceInformation($composer2, "348@13842L9");
                    t13 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13();
                }
                $composer2.endReplaceGroup();
                TextStyle textStyle = t13;
                if (isSelected) {
                    $composer2.startReplaceGroup(-1758214097);
                    ComposerKt.sourceInformation($composer2, "349@13911L6");
                    j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                } else {
                    $composer2.startReplaceGroup(-1758213046);
                    ComposerKt.sourceInformation($composer2, "349@13944L6");
                    j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU();
                }
                $composer2.endReplaceGroup();
                long j3 = j;
                Modifier modifier = Modifier.Companion;
                CompositionLocalMap localMap$iv$iv3 = localMap$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer2, -1758209302, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                int $changed$iv$iv$iv3 = $changed$iv$iv$iv2;
                boolean invalid$iv2 = (57344 & $dirty) == 16384;
                Object it$iv3 = $composer2.rememberedValue();
                if (!invalid$iv2 && it$iv3 != Composer.Companion.getEmpty()) {
                    value$iv = it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) value$iv), index != 1 ? Dp.constructor-impl(8) : Dp.constructor-impl(0), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    if (!isSelected) {
                        $composer2.startReplaceGroup(-1758201196);
                        ComposerKt.sourceInformation($composer2, "356@14314L6");
                        j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink_thin-0d7_KjU();
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(-1758200336);
                        $composer2.endReplaceGroup();
                        j2 = Color.Companion.getTransparent-0d7_KjU();
                    }
                    MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                    boolean z4 = z2;
                    Modifier modifier3 = BackgroundKt.background-bw27NRU(modifier2, j2, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
                    boolean z5 = !isCheckMode;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1758188072, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                    it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv2);
                        it$iv = value$iv2;
                    }
                    MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1758195142, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                    invalid$iv = ((458752 & $dirty) != 131072) | $composer2.changed(index);
                    it$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda13
                            public final Object invoke() {
                                Unit WatchLaterTabRow$lambda$0$0$0$2$0;
                                WatchLaterTabRow$lambda$0$0$0$2$0 = WatchLaterPageComposeKt.WatchLaterTabRow$lambda$0$0$0$2$0(function1, index);
                                return WatchLaterTabRow$lambda$0$0$0$2$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv3);
                        it$iv2 = value$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    TextKt.Text-Nvy7gAk(title, PaddingKt.padding-VpY3zN4(ClickableKt.clickable-O2vRcR0$default(modifier3, mutableInteractionSource, (Indication) null, z5, (String) null, (Role) null, (Function0) it$iv2, 24, (Object) null), Dp.constructor-impl(8), Dp.constructor-impl(5)), j3, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i6), 0L, 0, false, 0, 0, (Function1) null, textStyle, $composer2, 0, 0, 130040);
                    i = selectedTabIndex;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    index$iv = index$iv2;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    z3 = z;
                    localMap$iv$iv2 = localMap$iv$iv3;
                    $changed$iv$iv$iv2 = $changed$iv$iv$iv3;
                    z2 = z4;
                }
                Object obj = new Function1() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj2) {
                        Unit WatchLaterTabRow$lambda$0$0$0$0$0;
                        WatchLaterTabRow$lambda$0$0$0$0$0 = WatchLaterPageComposeKt.WatchLaterTabRow$lambda$0$0$0$0$0(isCheckMode, (GraphicsLayerScope) obj2);
                        return WatchLaterTabRow$lambda$0$0$0$0$0;
                    }
                };
                $composer2.updateRememberedValue(obj);
                value$iv = obj;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier22 = PaddingKt.padding-qDBjuR0$default(GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) value$iv), index != 1 ? Dp.constructor-impl(8) : Dp.constructor-impl(0), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                if (!isSelected) {
                }
                MeasurePolicy measurePolicy$iv$iv22 = measurePolicy$iv$iv;
                boolean z42 = z2;
                Modifier modifier32 = BackgroundKt.background-bw27NRU(modifier22, j2, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
                boolean z52 = !isCheckMode;
                ComposerKt.sourceInformationMarkerStart($composer2, -1758188072, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                }
                MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1758195142, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                invalid$iv = ((458752 & $dirty) != 131072) | $composer2.changed(index);
                it$iv2 = $composer2.rememberedValue();
                if (!invalid$iv) {
                }
                Object value$iv32 = new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda13
                    public final Object invoke() {
                        Unit WatchLaterTabRow$lambda$0$0$0$2$0;
                        WatchLaterTabRow$lambda$0$0$0$2$0 = WatchLaterPageComposeKt.WatchLaterTabRow$lambda$0$0$0$2$0(function1, index);
                        return WatchLaterTabRow$lambda$0$0$0$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv32);
                it$iv2 = value$iv32;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                TextKt.Text-Nvy7gAk(title, PaddingKt.padding-VpY3zN4(ClickableKt.clickable-O2vRcR0$default(modifier32, mutableInteractionSource2, (Indication) null, z52, (String) null, (Role) null, (Function0) it$iv2, 24, (Object) null), Dp.constructor-impl(8), Dp.constructor-impl(5)), j3, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i6), 0L, 0, false, 0, 0, (Function1) null, textStyle, $composer2, 0, 0, 130040);
                i = selectedTabIndex;
                measurePolicy$iv$iv = measurePolicy$iv$iv22;
                index$iv = index$iv2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z3 = z;
                localMap$iv$iv2 = localMap$iv$iv3;
                $changed$iv$iv$iv2 = $changed$iv$iv$iv3;
                z2 = z42;
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv3 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer2.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope3 = RowScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1297936504, "C373@15041L175,376@15256L6,377@15306L18,378@15363L6,380@15456L9,371@14988L713,386@15714L40,388@15800L62,389@15902L6,390@15957L13,391@16009L6,392@16066L9,387@15767L508:WatchLaterPageCompose.kt#b3vx81");
            Res.string string = FavoritesRes.INSTANCE.getString();
            String stringResource = StringResourcesKt.stringResource(ascend ? bili.resource.favorites.String0_commonMainKt.getFavorites_global_string_225(string) : bili.resource.favorites.String0_commonMainKt.getFavorites_global_string_229(string), $composer2, 0);
            BiliTheme biliTheme = BiliTheme.INSTANCE;
            int $changed$iv = BiliTheme.$stable;
            long j4 = biliTheme.getColors($composer2, $changed$iv).getText2-0d7_KjU();
            WatchLaterWidgetKt.m2598IconTextH8uBujs(stringResource, null, BiliIconfont.INSTANCE.getList_sort_line_500($composer2, 6), 0, Dp.constructor-impl(2), 0.0f, j4, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bold-0d7_KjU(), BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), ascend, buttonClickable && !isCheckMode, (!buttonClickable || isCheckMode) ? 0.4f : 1.0f, function0, $composer2, (Painter.$stable << 6) | 24576 | (($dirty << 21) & 1879048192), ($dirty >> 12) & 896, 42);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer2, 6);
            WatchLaterWidgetKt.m2598IconTextH8uBujs(StringResourcesKt.stringResource(bili.resource.favorites.String0_commonMainKt.getFavorites_global_string_79(FavoritesRes.INSTANCE.getString()), $composer2, 0), null, BiliIconfont.INSTANCE.getPlay_fill_500($composer2, 6), 0, 0.0f, 0.0f, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), false, buttonClickable && !isCheckMode, (!buttonClickable || isCheckMode) ? 0.4f : 1.0f, function02, $composer2, Painter.$stable << 6, ($dirty >> 15) & 896, 570);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj2, Object obj3) {
                    Unit WatchLaterTabRow$lambda$1;
                    WatchLaterTabRow$lambda$1 = WatchLaterPageComposeKt.WatchLaterTabRow$lambda$1(selectedTabIndex, tabList, ascend, buttonClickable, isCheckMode, function1, function0, function02, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                    return WatchLaterTabRow$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterTabRow$lambda$0$0$0$0$0(boolean $isCheckMode, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha($isCheckMode ? 0.4f : 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterTabRow$lambda$0$0$0$2$0(Function1 $onTabClick, int $index) {
        $onTabClick.invoke(Integer.valueOf($index));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x013e, code lost:
        if (r3.changed(r72) != false) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void WatchLaterListPage(final boolean isCheckMode, final WatchLaterList list, final boolean hasMore, final PageState pageState, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function2, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function22, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function1<? super WatchLaterItem, Unit> function1, Modifier modifier, LazyListState listState, boolean isRefreshing, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        LazyListState listState2;
        boolean isRefreshing2;
        Modifier modifier3;
        LazyListState listState3;
        Modifier modifier4;
        int $dirty1;
        Composer $composer3;
        BoxScope $this$WatchLaterListPage_u24lambda_u240;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv2;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(function2, "onCardClick");
        Intrinsics.checkNotNullParameter(function22, "onCardLongClick");
        Intrinsics.checkNotNullParameter(function0, "onLoadMore");
        Intrinsics.checkNotNullParameter(function02, "onRefresh");
        Intrinsics.checkNotNullParameter(function03, "onRetryClick");
        Intrinsics.checkNotNullParameter(function1, "onThreePointClick");
        Composer $composer4 = $composer.startRestartGroup(-1791994725);
        ComposerKt.sourceInformation($composer4, "C(WatchLaterListPage)N(isCheckMode,list,hasMore,pageState,onCardClick,onCardLongClick,onLoadMore,onRefresh,onRetryClick,onThreePointClick,modifier,listState,isRefreshing)418@16919L28,419@16952L1304:WatchLaterPageCompose.kt#b3vx81");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(isCheckMode) ? 4 : 2;
        }
        int i2 = 32;
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(hasMore) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(pageState) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer4.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer4.changedInstance(function22) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer4.changedInstance(function02) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer4.changedInstance(function03) ? 67108864 : 33554432;
        }
        if ((805306368 & $changed) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 536870912 : 268435456;
        }
        int i3 = i & 1024;
        if (i3 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty12 |= $composer4.changed(modifier) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            if ((i & 2048) != 0) {
            }
            i2 = 16;
            $dirty12 |= i2;
        }
        int i4 = i & 4096;
        if (i4 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty12 |= $composer4.changed(isRefreshing) ? 256 : 128;
        }
        if ($composer4.shouldExecute((($dirty & 306783379) == 306783378 && ($dirty12 & 147) == 146) ? false : true, $dirty & 1)) {
            $composer4.startDefaults();
            ComposerKt.sourceInformation($composer4, "415@16828L23");
            if (($changed & 1) != 0 && !$composer4.getDefaultsInvalid()) {
                $composer4.skipToGroupEnd();
                if ((i & 2048) != 0) {
                    $dirty12 &= -113;
                }
                modifier4 = modifier;
                listState2 = listState;
                isRefreshing2 = isRefreshing;
                $dirty1 = $dirty12;
            } else {
                if (i3 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if ((i & 2048) == 0) {
                    listState3 = listState;
                } else {
                    listState3 = LazyListStateKt.rememberLazyListState(0, 0, $composer4, 0, 3);
                    $dirty12 &= -113;
                }
                if (i4 == 0) {
                    isRefreshing2 = isRefreshing;
                    modifier4 = modifier3;
                    $dirty1 = $dirty12;
                    listState2 = listState3;
                } else {
                    modifier4 = modifier3;
                    listState2 = listState3;
                    isRefreshing2 = false;
                    $dirty1 = $dirty12;
                }
            }
            $composer4.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1791994725, $dirty, $dirty1, "kntr.watch.later.watchlater.compose.WatchLaterListPage (WatchLaterPageCompose.kt:417)");
            }
            PullToRefreshState pullRefreshState = PullToRefreshKt.rememberPullToRefreshState($composer4, 0);
            int $dirty2 = $dirty;
            $composer2 = $composer4;
            int $dirty13 = $dirty1;
            Modifier modifier$iv = PullToRefreshKt.pullToRefresh-Z4HSEVQ$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), isRefreshing2, pullRefreshState, !isCheckMode, 0.0f, function02, 8, (Object) null);
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((0 >> 6) & 112) | 6;
            BoxScope $this$WatchLaterListPage_u24lambda_u2402 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -36981675, "C460@18222L6,456@18042L208:WatchLaterPageCompose.kt#b3vx81");
            if (!(pageState instanceof PageState.Empty)) {
                if (pageState instanceof PageState.Error) {
                    $composer2.startReplaceGroup(-36878725);
                    ComposerKt.sourceInformation($composer2, "436@17427L38");
                    ErrorPage(function03, $composer2, ($dirty2 >> 24) & 14);
                    $composer2.endReplaceGroup();
                    $composer$iv$iv = $composer2;
                    $composer3 = $composer2;
                    $composer$iv = $composer2;
                    $composer$iv2 = $composer2;
                    modifier2 = modifier4;
                    $this$WatchLaterListPage_u24lambda_u240 = $this$WatchLaterListPage_u24lambda_u2402;
                } else if (!(pageState instanceof PageState.Loading)) {
                    if (pageState instanceof PageState.Success) {
                        $composer2.startReplaceGroup(-36678310);
                        ComposerKt.sourceInformation($composer2, "444@17618L391");
                        $composer3 = $composer2;
                        $this$WatchLaterListPage_u24lambda_u240 = $this$WatchLaterListPage_u24lambda_u2402;
                        $composer$iv$iv = $composer2;
                        $composer$iv = $composer2;
                        $composer$iv2 = $composer2;
                        modifier2 = modifier4;
                        ListPage(isCheckMode, list, hasMore, function2, function22, function1, function0, listState2, $composer3, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | (($dirty2 >> 3) & 7168) | (($dirty2 >> 3) & 57344) | (($dirty2 >> 12) & 458752) | (3670016 & $dirty2) | (($dirty13 << 18) & 29360128), 0);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(-693929835);
                        $composer2.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    $composer2.startReplaceGroup(-36772364);
                    ComposerKt.sourceInformation($composer2, "440@17535L13");
                    LoadingPage($composer2, 0);
                    $composer2.endReplaceGroup();
                    $composer$iv$iv = $composer2;
                    $composer3 = $composer2;
                    $composer$iv = $composer2;
                    $composer$iv2 = $composer2;
                    modifier2 = modifier4;
                    $this$WatchLaterListPage_u24lambda_u240 = $this$WatchLaterListPage_u24lambda_u2402;
                }
            } else {
                $composer2.startReplaceGroup(-36957930);
                ComposerKt.sourceInformation($composer2, "432@17348L11");
                EmptyPage($composer2, 0);
                $composer2.endReplaceGroup();
                $composer$iv$iv = $composer2;
                $composer3 = $composer2;
                $composer$iv = $composer2;
                $composer$iv2 = $composer2;
                modifier2 = modifier4;
                $this$WatchLaterListPage_u24lambda_u240 = $this$WatchLaterListPage_u24lambda_u2402;
            }
            Composer $composer5 = $composer3;
            PullToRefreshDefaults.INSTANCE.Indicator-2poqoh4(pullRefreshState, isRefreshing2, $this$WatchLaterListPage_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getTopCenter()), 0L, BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.0f, $composer5, (($dirty13 >> 3) & 112) | (PullToRefreshDefaults.$stable << 18), 40);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            listState2 = listState;
            isRefreshing2 = isRefreshing;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final LazyListState lazyListState = listState2;
            final boolean z = isRefreshing2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterListPage$lambda$1;
                    WatchLaterListPage$lambda$1 = WatchLaterPageComposeKt.WatchLaterListPage$lambda$1(isCheckMode, list, hasMore, pageState, function2, function22, function0, function02, function03, function1, modifier5, lazyListState, z, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterListPage$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ListPage(final boolean isCheckMode, final WatchLaterList list, final boolean hasMore, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function2, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function22, final Function1<? super WatchLaterItem, Unit> function1, final Function0<Unit> function0, LazyListState state, Composer $composer, final int $changed, final int i) {
        LazyListState lazyListState;
        LazyListState state2;
        int $dirty;
        boolean invalid$iv;
        Object it$iv;
        int i2;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(function2, "onCardClick");
        Intrinsics.checkNotNullParameter(function22, "onCardLongClick");
        Intrinsics.checkNotNullParameter(function1, "onThreePointClick");
        Intrinsics.checkNotNullParameter(function0, "onLoadMore");
        Composer $composer2 = $composer.startRestartGroup(-721115697);
        ComposerKt.sourceInformation($composer2, "C(ListPage)N(isCheckMode,list,hasMore,onCardClick,onCardLongClick,onThreePointClick,onLoadMore,state)479@18773L1166,477@18695L1244,511@20004L16,511@19950L71:WatchLaterPageCompose.kt#b3vx81");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(isCheckMode) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(hasMore) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changedInstance(function22) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            if ((i & 128) == 0) {
                lazyListState = state;
                if ($composer2.changed(lazyListState)) {
                    i2 = 8388608;
                    $dirty2 |= i2;
                }
            } else {
                lazyListState = state;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        } else {
            lazyListState = state;
        }
        if ($composer2.shouldExecute((4793491 & $dirty2) != 4793490, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "475@18662L23");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
            } else if ((i & 128) != 0) {
                $dirty = $dirty2 & (-29360129);
                state2 = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-721115697, $dirty, -1, "kntr.watch.later.watchlater.compose.ListPage (WatchLaterPageCompose.kt:476)");
                }
                final LazyListState lazyListState2 = state2;
                int $dirty3 = $dirty;
                CompositionLocalKt.CompositionLocalProvider(OverscrollKt.getLocalOverscrollFactory().provides((Object) null), ComposableLambdaKt.rememberComposableLambda(1600846095, true, new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ListPage$lambda$0;
                        ListPage$lambda$0 = WatchLaterPageComposeKt.ListPage$lambda$0(lazyListState2, list, function2, isCheckMode, function22, function1, (Composer) obj, ((Integer) obj2).intValue());
                        return ListPage$lambda$0;
                    }
                }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
                Boolean valueOf = Boolean.valueOf(hasMore);
                ComposerKt.sourceInformationMarkerStart($composer2, -1502396321, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                invalid$iv = ($dirty3 & 3670016) != 1048576;
                it$iv = $composer2.rememberedValue();
                if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = (Function1) new WatchLaterPageComposeKt$ListPage$2$1(function0, null);
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                WatchLaterWidgetKt.OnBottomReached(state2, valueOf, 2, (Function1) it$iv, $composer2, (($dirty3 >> 21) & 14) | 384 | (($dirty3 >> 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $dirty = $dirty2;
            state2 = lazyListState;
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final LazyListState lazyListState22 = state2;
            int $dirty32 = $dirty;
            CompositionLocalKt.CompositionLocalProvider(OverscrollKt.getLocalOverscrollFactory().provides((Object) null), ComposableLambdaKt.rememberComposableLambda(1600846095, true, new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit ListPage$lambda$0;
                    ListPage$lambda$0 = WatchLaterPageComposeKt.ListPage$lambda$0(lazyListState22, list, function2, isCheckMode, function22, function1, (Composer) obj, ((Integer) obj2).intValue());
                    return ListPage$lambda$0;
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            Boolean valueOf2 = Boolean.valueOf(hasMore);
            ComposerKt.sourceInformationMarkerStart($composer2, -1502396321, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            if (($dirty32 & 3670016) != 1048576) {
            }
            it$iv = $composer2.rememberedValue();
            if (!invalid$iv) {
            }
            Object value$iv2 = (Function1) new WatchLaterPageComposeKt$ListPage$2$1(function0, null);
            $composer2.updateRememberedValue(value$iv2);
            it$iv = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            WatchLaterWidgetKt.OnBottomReached(state2, valueOf2, 2, (Function1) it$iv, $composer2, (($dirty32 >> 21) & 14) | 384 | (($dirty32 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2.skipToGroupEnd();
            state2 = lazyListState;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final LazyListState lazyListState3 = state2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit ListPage$lambda$2;
                    ListPage$lambda$2 = WatchLaterPageComposeKt.ListPage$lambda$2(isCheckMode, list, hasMore, function2, function22, function1, function0, lazyListState3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ListPage$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListPage$lambda$0(LazyListState $state, final WatchLaterList $list, final Function2 $onCardClick, final boolean $isCheckMode, final Function2 $onCardLongClick, final Function1 $onThreePointClick, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C485@18916L1017,480@18783L1150:WatchLaterPageCompose.kt#b3vx81");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1600846095, $changed, -1, "kntr.watch.later.watchlater.compose.ListPage.<anonymous> (WatchLaterPageCompose.kt:480)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 814810920, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            boolean invalid$iv = $composer.changed($list) | $composer.changed($onCardClick) | $composer.changed($isCheckMode) | $composer.changed($onCardLongClick) | $composer.changed($onThreePointClick);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function1() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        Unit ListPage$lambda$0$0$0;
                        ListPage$lambda$0$0$0 = WatchLaterPageComposeKt.ListPage$lambda$0$0$0(WatchLaterList.this, $onCardClick, $isCheckMode, $onCardLongClick, $onThreePointClick, (LazyListScope) obj);
                        return ListPage$lambda$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(fillMaxSize$default, $state, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer, 6, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListPage$lambda$0$0$0(WatchLaterList $list, final Function2 $onCardClick, final boolean $isCheckMode, final Function2 $onCardLongClick, final Function1 $onThreePointClick, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final List items$iv = $list.getList();
        final Function2 key$iv = new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda17
            public final Object invoke(Object obj, Object obj2) {
                Object ListPage$lambda$0$0$0$0;
                ListPage$lambda$0$0$0$0 = WatchLaterPageComposeKt.ListPage$lambda$0$0$0$0(((Integer) obj).intValue(), (WatchLaterItem) obj2);
                return ListPage$lambda$0$0$0$0;
            }
        };
        $this$LazyColumn.items(items$iv.size(), new Function1<Integer, Object>() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$ListPage$lambda$0$0$0$$inlined$itemsIndexed$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return key$iv.invoke(Integer.valueOf(index), items$iv.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$ListPage$lambda$0$0$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                items$iv.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$ListPage$lambda$0$0$0$$inlined$itemsIndexed$default$3
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
                if ($composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                    }
                    int $changed2 = ($dirty & 14) | ($dirty & 112);
                    final WatchLaterItem item = (WatchLaterItem) items$iv.get(it);
                    $composer.startReplaceGroup(-872043402);
                    ComposerKt.sourceInformation($composer, "CN(item):WatchLaterPageCompose.kt#b3vx81");
                    if (item.getCardType() == 0) {
                        $composer.startReplaceGroup(-871992749);
                        ComposerKt.sourceInformation($composer, "495@19359L34,496@19437L38,490@19106L455");
                        boolean isChecked = item.isChecked();
                        Modifier animateItem$default = LazyItemScope.-CC.animateItem$default($this$items, Modifier.Companion, (FiniteAnimationSpec) null, (FiniteAnimationSpec) null, (FiniteAnimationSpec) null, 7, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer, 1495899530, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                        boolean invalid$iv = $composer.changed($onCardClick) | $composer.changed($isCheckMode) | $composer.changedInstance(item);
                        Object it$iv = $composer.rememberedValue();
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            final Function2 function2 = $onCardClick;
                            final boolean z = $isCheckMode;
                            Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$ListPage$1$1$1$2$1$1
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2589invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: collision with other method in class */
                                public final void m2589invoke() {
                                    function2.invoke(Boolean.valueOf(z), item);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        Function0 function0 = (Function0) it$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, 1495902030, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                        boolean invalid$iv2 = $composer.changed($onCardLongClick) | $composer.changed($isCheckMode) | $composer.changedInstance(item);
                        Object it$iv2 = $composer.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                            final Function2 function22 = $onCardLongClick;
                            final boolean invalid$iv3 = $isCheckMode;
                            Object value$iv2 = (Function0) new Function0<Unit>() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$ListPage$1$1$1$2$2$1
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2590invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: collision with other method in class */
                                public final void m2590invoke() {
                                    function22.invoke(Boolean.valueOf(invalid$iv3), item);
                                }
                            };
                            $composer.updateRememberedValue(value$iv2);
                            it$iv2 = value$iv2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer2 = $composer;
                        WatchLaterCardKt.WatchLaterCard(isChecked, item, function0, (Function0) it$iv2, $onThreePointClick, animateItem$default, $isCheckMode, $composer2, ($changed2 >> 3) & 112, 0);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2 = $composer;
                        if (item.getCardType() == 1) {
                            $composer2.startReplaceGroup(-871486023);
                            ComposerKt.sourceInformation($composer2, "500@19647L153");
                            WatchLaterCardKt.WatchLaterDividerCard(item.getTitle(), LazyItemScope.-CC.animateItem$default($this$items, Modifier.Companion, (FiniteAnimationSpec) null, (FiniteAnimationSpec) null, (FiniteAnimationSpec) null, 7, (Object) null), $composer2, 0, 0);
                        } else {
                            $composer2.startReplaceGroup(-890960998);
                        }
                        $composer2.endReplaceGroup();
                    }
                    $composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }));
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$WatchLaterPageComposeKt.INSTANCE.getLambda$1580674010$watch_later_debug(), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ListPage$lambda$0$0$0$0(int i, WatchLaterItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.getItemId();
    }

    public static final void ErrorPage(final Function0<Unit> function0, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function0, "onRetryClick");
        Composer $composer2 = $composer.startRestartGroup(1844091046);
        ComposerKt.sourceInformation($composer2, "C(ErrorPage)N(onRetryClick)521@20242L21,516@20092L521:WatchLaterPageCompose.kt#b3vx81");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1844091046, $dirty2, -1, "kntr.watch.later.watchlater.compose.ErrorPage (WatchLaterPageCompose.kt:515)");
            }
            Modifier modifier$iv = ScrollKt.verticalScroll$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(130), 7, (Object) null), ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -573093301, "C525@20363L57,526@20450L75,524@20327L280:WatchLaterPageCompose.kt#b3vx81");
            WatchLaterWidgetKt.PageLoadingView(StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_164(CommonRes.INSTANCE.getString()), $composer2, 0), ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_status_error(kntr.common.compose.res.CommonRes.INSTANCE.getDrawable()), $composer2, 0), true, function0, $composer2, (Painter.$stable << 3) | 384 | (($dirty2 << 9) & 7168), 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit ErrorPage$lambda$1;
                    ErrorPage$lambda$1 = WatchLaterPageComposeKt.ErrorPage$lambda$1(function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ErrorPage$lambda$1;
                }
            });
        }
    }

    public static final void EmptyPage(Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(398767429);
        ComposerKt.sourceInformation($composer2, "C(EmptyPage)540@20810L21,535@20660L487:WatchLaterPageCompose.kt#b3vx81");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(398767429, $changed, -1, "kntr.watch.later.watchlater.compose.EmptyPage (WatchLaterPageCompose.kt:534)");
            }
            Modifier modifier$iv = ScrollKt.verticalScroll$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(130), 7, (Object) null), ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -707138974, "C544@20931L63,545@21024L75,543@20895L246:WatchLaterPageCompose.kt#b3vx81");
            WatchLaterWidgetKt.PageLoadingView(StringResourcesKt.stringResource(bili.resource.favorites.String0_commonMainKt.getFavorites_global_string_230(FavoritesRes.INSTANCE.getString()), $composer2, 0), ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_status_empty(kntr.common.compose.res.CommonRes.INSTANCE.getDrawable()), $composer2, 0), false, null, $composer2, (Painter.$stable << 3) | 384, 8);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit EmptyPage$lambda$1;
                    EmptyPage$lambda$1 = WatchLaterPageComposeKt.EmptyPage$lambda$1($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return EmptyPage$lambda$1;
                }
            });
        }
    }

    public static final void LoadingPage(Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1562632524);
        ComposerKt.sourceInformation($composer2, "C(LoadingPage)553@21196L248:WatchLaterPageCompose.kt#b3vx81");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1562632524, $changed, -1, "kntr.watch.later.watchlater.compose.LoadingPage (WatchLaterPageCompose.kt:552)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(130), 7, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (54 << 3) & 112;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 2113788363, "C560@21420L6,560@21376L62:WatchLaterPageCompose.kt#b3vx81");
            ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8((Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.0f, 0L, 0, 0.0f, $composer2, 0, 61);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoadingPage$lambda$1;
                    LoadingPage$lambda$1 = WatchLaterPageComposeKt.LoadingPage$lambda$1($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LoadingPage$lambda$1;
                }
            });
        }
    }
}