package tv.danmaku.bili.ui.watchlater.compose;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.OverscrollConfiguration_androidKt;
import androidx.compose.foundation.OverscrollEffect;
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
import androidx.compose.material.DividerKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import bili.resource.playerbaseres.R;
import com.bilibili.compose.swiperefresh.BiliSwipeRefreshIndicatorKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.google.accompanist.swiperefresh.SwipeRefreshKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.ui.watchlater.consts.Tabs;
import tv.danmaku.bili.ui.watchlater.consts.WatchLaterConstsKt;
import tv.danmaku.bili.ui.watchlater.data.PageState;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterItem;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterList;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterState;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterTabState;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.AbsoluteCommentItem;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

/* compiled from: WatchLaterPageCompose.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u0084\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\n26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\n21\u0010\u0017\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000e2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010'\u001aA\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010,\u001a\u0090\u0004\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00102\u001a\u0002032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\n26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020521\u0010\u0017\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000e2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u00107\u001at\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u00182\u0006\u0010/\u001a\u0002002\u0006\u0010:\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u001d2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010;\u001aþ\u0001\u0010<\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u00052\u0006\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u000726\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\n2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u001dH\u0007¢\u0006\u0002\u0010C\u001aÐ\u0001\u0010D\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u00052\u0006\u0010=\u001a\u00020>2\u0006\u0010@\u001a\u00020\u00052\b\b\u0002\u0010E\u001a\u00020\u000726\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\u000e2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010F\u001a#\u0010G\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010I\u001a\r\u0010J\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010K\u001a\r\u0010L\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010K¨\u0006M"}, d2 = {"WatchLaterPage", "", "pageState", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterState;", "buttonClickable", "", "tabAllListState", "Landroidx/compose/foundation/lazy/LazyListState;", "tabToViewListState", "onBackClick", "Lkotlin/Function0;", "onManageClick", "onPlayButtonClick", "onCardClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "checkMode", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterItem;", "item", "onCardLongClick", "onClickMoveTo", "onClickCopyTo", "onTabClick", "", "index", "Lkotlin/coroutines/Continuation;", "", "onLoadMore", "Lkotlin/Function1;", "onRefresh", "onRetryClick", "onThreePointClick", "", "aid", "onCheckAllClick", "onCancelAllClick", "onDeleteClick", "onSortButtonClick", "(Ltv/danmaku/bili/ui/watchlater/data/WatchLaterState;ZLandroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "WatchLaterToolBar", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "manageText", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "WatchLaterContentPage", "isCheckMode", "tabList", "Ltv/danmaku/bili/ui/watchlater/consts/Tabs;", "asc", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "pageAllState", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterTabState;", "pageToViewState", "(ZLtv/danmaku/bili/ui/watchlater/consts/Tabs;ZZLandroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ltv/danmaku/bili/ui/watchlater/data/WatchLaterTabState;Ltv/danmaku/bili/ui/watchlater/data/WatchLaterTabState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "WatchLaterTabRow", "selectedTabIndex", "ascend", "(ILtv/danmaku/bili/ui/watchlater/consts/Tabs;ZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "WatchLaterListPage", "list", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterList;", "isRefreshing", "hasMore", "Ltv/danmaku/bili/ui/watchlater/data/PageState;", "listState", "(ZLtv/danmaku/bili/ui/watchlater/data/WatchLaterList;ZZLtv/danmaku/bili/ui/watchlater/data/PageState;Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ListPage", "state", "(ZLtv/danmaku/bili/ui/watchlater/data/WatchLaterList;ZLandroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ErrorPage", "networkActive", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "EmptyPage", "(Landroidx/compose/runtime/Composer;I)V", "LoadingPage", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterPageComposeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyPage$lambda$1(int i, Composer composer, int i2) {
        EmptyPage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorPage$lambda$1(boolean z, Function0 function0, int i, Composer composer, int i2) {
        ErrorPage(z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListPage$lambda$2(boolean z, WatchLaterList watchLaterList, boolean z2, LazyListState lazyListState, Function2 function2, Function2 function22, Function1 function1, Function0 function0, int i, int i2, Composer composer, int i3) {
        ListPage(z, watchLaterList, z2, lazyListState, function2, function22, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
    public static final Unit WatchLaterListPage$lambda$1(boolean z, WatchLaterList watchLaterList, boolean z2, boolean z3, PageState pageState, LazyListState lazyListState, Function2 function2, Function2 function22, Function0 function0, Function0 function02, Function0 function03, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        WatchLaterListPage(z, watchLaterList, z2, z3, pageState, lazyListState, function2, function22, function0, function02, function03, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
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

    public static final void WatchLaterPage(final WatchLaterState pageState, final boolean buttonClickable, final LazyListState tabAllListState, final LazyListState tabToViewListState, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function2, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function22, final Function0<Unit> function04, final Function0<Unit> function05, final Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function23, final Function1<? super Integer, Unit> function1, final Function1<? super Integer, Unit> function12, final Function1<? super Integer, Unit> function13, final Function1<? super Long, Unit> function14, final Function1<? super Integer, Unit> function15, final Function1<? super Integer, Unit> function16, final Function0<Unit> function06, final Function0<Unit> function07, Composer $composer, final int $changed, final int $changed1) {
        Function1<? super Integer, Unit> function17;
        Function0<Unit> function08;
        Composer $composer2;
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
        Composer $composer3 = $composer.startRestartGroup(260080733);
        ComposerKt.sourceInformation($composer3, "C(WatchLaterPage)N(pageState,buttonClickable,tabAllListState,tabToViewListState,onBackClick,onManageClick,onPlayButtonClick,onCardClick,onCardLongClick,onClickMoveTo,onClickCopyTo,onTabClick,onLoadMore,onRefresh,onRetryClick,onThreePointClick,onCheckAllClick,onCancelAllClick,onDeleteClick,onSortButtonClick)90@4116L32,95@4240L33,93@4170L103,98@4288L1816,98@4278L1826:WatchLaterPageCompose.kt#ooxe70");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(pageState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(buttonClickable) ? 32 : 16;
        }
        int i = $changed & 384;
        int i2 = IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
        if (i == 0) {
            $dirty |= $composer3.changed(tabAllListState) ? 256 : 128;
        }
        int i3 = $changed & 3072;
        int i4 = IjkMediaMeta.FF_PROFILE_H264_INTRA;
        if (i3 == 0) {
            $dirty |= $composer3.changed(tabToViewListState) ? 2048 : 1024;
        }
        int i5 = $changed & 24576;
        int i6 = IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID;
        if (i5 == 0) {
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
            if (!$composer3.changedInstance(function1)) {
                i2 = 128;
            }
            $dirty1 |= i2;
        }
        if (($changed1 & 3072) == 0) {
            if (!$composer3.changedInstance(function12)) {
                i4 = 1024;
            }
            $dirty1 |= i4;
        }
        if (($changed1 & 24576) == 0) {
            if (!$composer3.changedInstance(function13)) {
                i6 = 8192;
            }
            $dirty1 |= i6;
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
                ComposerKt.traceEventStart(260080733, $dirty, $dirty12, "tv.danmaku.bili.ui.watchlater.compose.WatchLaterPage (WatchLaterPageCompose.kt:89)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 829507997, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = WatchLaterConstsKt.getTabList();
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Tabs tabList = (Tabs) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            int watchLaterInitialPage = WatchLaterConstsKt.getWatchLaterInitialPage();
            ComposerKt.sourceInformationMarkerStart($composer3, 829511966, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            Object value$iv2 = $composer3.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        int WatchLaterPage$lambda$1$0;
                        WatchLaterPage$lambda$1$0 = WatchLaterPageComposeKt.WatchLaterPage$lambda$1$0(Tabs.this);
                        return Integer.valueOf(WatchLaterPage$lambda$1$0);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final PagerState pagerState = PagerStateKt.rememberPagerState(watchLaterInitialPage, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (Function0) value$iv2, $composer3, 384, 2);
            $composer2 = $composer3;
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(2137509, true, new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterPage$lambda$2;
                    WatchLaterPage$lambda$2 = WatchLaterPageComposeKt.WatchLaterPage$lambda$2(WatchLaterState.this, buttonClickable, function0, function02, tabList, pagerState, tabAllListState, tabToViewListState, function07, function03, function2, function22, function04, function05, function23, function1, function12, function13, function14, function15, function16, function06, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterPage$lambda$2;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda2
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterPage$lambda$2(final WatchLaterState $pageState, final boolean $buttonClickable, final Function0 $onBackClick, final Function0 $onManageClick, final Tabs $tabList, final PagerState $pagerState, final LazyListState $tabAllListState, final LazyListState $tabToViewListState, final Function0 $onSortButtonClick, final Function0 $onPlayButtonClick, final Function2 $onCardClick, final Function2 $onCardLongClick, final Function0 $onClickMoveTo, final Function0 $onClickCopyTo, final Function2 $onTabClick, final Function1 $onLoadMore, final Function1 $onRefresh, final Function1 $onRetryClick, final Function1 $onThreePointClick, final Function1 $onCheckAllClick, final Function1 $onCancelAllClick, final Function0 $onDeleteClick, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C99@4316L570,111@4928L6,111@4940L1158,99@4298L1800:WatchLaterPageCompose.kt#ooxe70");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2137509, $changed, -1, "tv.danmaku.bili.ui.watchlater.compose.WatchLaterPage.<anonymous> (WatchLaterPageCompose.kt:99)");
            }
            ScaffoldKt.Scaffold-27mzLpw((Modifier) null, (ScaffoldState) null, ComposableLambdaKt.rememberComposableLambda(-87914006, true, new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterPage$lambda$2$0;
                    WatchLaterPage$lambda$2$0 = WatchLaterPageComposeKt.WatchLaterPage$lambda$2$0(WatchLaterState.this, $buttonClickable, $onBackClick, $onManageClick, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterPage$lambda$2$0;
                }
            }, $composer, 54), (Function2) null, (Function3) null, (Function2) null, 0, false, (Function3) null, false, (Shape) null, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0L, 0L, 0L, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), 0L, ComposableLambdaKt.rememberComposableLambda(-455189661, true, new Function3() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit WatchLaterPage$lambda$2$1;
                    WatchLaterPage$lambda$2$1 = WatchLaterPageComposeKt.WatchLaterPage$lambda$2$1(WatchLaterState.this, $tabList, $buttonClickable, $pagerState, $tabAllListState, $tabToViewListState, $onSortButtonClick, $onPlayButtonClick, $onCardClick, $onCardLongClick, $onClickMoveTo, $onClickCopyTo, $onTabClick, $onLoadMore, $onRefresh, $onRetryClick, $onThreePointClick, $onCheckAllClick, $onCancelAllClick, $onDeleteClick, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return WatchLaterPage$lambda$2$1;
                }
            }, $composer, 54), $composer, 384, 12582912, 98299);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterPage$lambda$2$0(WatchLaterState $pageState, boolean $buttonClickable, Function0 $onBackClick, Function0 $onManageClick, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C101@4373L89,102@4493L228,100@4330L546:WatchLaterPageCompose.kt#ooxe70");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-87914006, $changed, -1, "tv.danmaku.bili.ui.watchlater.compose.WatchLaterPage.<anonymous>.<anonymous> (WatchLaterPageCompose.kt:100)");
            }
            WatchLaterToolBar(StringResources_androidKt.stringResource(R.string.playerbaseres_global_string_163, $composer, 0), StringResources_androidKt.stringResource($pageState.isCheckMode() ? bili.resource.homepage.R.string.homepage_global_string_111 : bili.resource.common.R.string.common_global_string_233, $composer, 0), $buttonClickable, $onBackClick, $onManageClick, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterPage$lambda$2$1(WatchLaterState $pageState, Tabs $tabList, boolean $buttonClickable, PagerState $pagerState, LazyListState $tabAllListState, LazyListState $tabToViewListState, Function0 $onSortButtonClick, Function0 $onPlayButtonClick, Function2 $onCardClick, Function2 $onCardLongClick, Function0 $onClickMoveTo, Function0 $onClickCopyTo, Function2 $onTabClick, Function1 $onLoadMore, Function1 $onRefresh, Function1 $onRetryClick, Function1 $onThreePointClick, Function1 $onCheckAllClick, Function1 $onCancelAllClick, Function0 $onDeleteClick, PaddingValues it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)112@4954L1134:WatchLaterPageCompose.kt#ooxe70");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-455189661, $changed, -1, "tv.danmaku.bili.ui.watchlater.compose.WatchLaterPage.<anonymous>.<anonymous> (WatchLaterPageCompose.kt:112)");
            }
            WatchLaterContentPage($pageState.isCheckMode(), $tabList, $pageState.getAsc(), $buttonClickable, $pagerState, $tabAllListState, $tabToViewListState, $onSortButtonClick, $onPlayButtonClick, $onCardClick, $onCardLongClick, $onClickMoveTo, $onClickCopyTo, $pageState.getTabAll(), $pageState.getTabToView(), $onTabClick, $onLoadMore, $onRefresh, $onRetryClick, $onThreePointClick, $onCheckAllClick, $onCancelAllClick, $onDeleteClick, $composer, 48, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void WatchLaterToolBar(final String title, final String manageText, final boolean buttonClickable, final Function0<Unit> function0, final Function0<Unit> function02, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(manageText, "manageText");
        Intrinsics.checkNotNullParameter(function0, "onBackClick");
        Intrinsics.checkNotNullParameter(function02, "onManageClick");
        Composer $composer3 = $composer.startRestartGroup(-1687195420);
        ComposerKt.sourceInformation($composer3, "C(WatchLaterToolBar)N(title,manageText,buttonClickable,onBackClick,onManageClick)151@6358L11,149@6283L1997:WatchLaterPageCompose.kt#ooxe70");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(manageText) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(buttonClickable) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1687195420, $dirty2, -1, "tv.danmaku.bili.ui.watchlater.compose.WatchLaterToolBar (WatchLaterPageCompose.kt:148)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getThemeColors($composer3, BiliTheme.$stable).getPrimary-0d7_KjU(), (Shape) null, 2, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(44));
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
            ComposerKt.sourceInformationMarkerStart($composer3, -218369974, "C161@6701L11,162@6754L9,155@6487L363,166@6859L1415:WatchLaterPageCompose.kt#ooxe70");
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(80), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null);
            int i3 = TextAlign.Companion.getCenter-e0LSkKk();
            $composer2 = $composer3;
            TextKt.Text--4IGK_g(title, modifier, BiliTheme.INSTANCE.getThemeColors($composer3, BiliTheme.$stable).getTextTitle-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i3), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT17b(), $composer3, ($dirty2 & 14) | 48, 3120, 54776);
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
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
            ComposerKt.sourceInformationMarkerStart($composer3, -1608825468, "C171@7011L437,181@7461L38,184@7587L11,185@7645L9,190@7869L91,197@8161L89,182@7512L752:WatchLaterPageCompose.kt#ooxe70");
            IconButtonKt.IconButton(function0, (Modifier) null, false, (MutableInteractionSource) null, ComposableSingletons$WatchLaterPageComposeKt.INSTANCE.getLambda$622589982$core_apinkDebug(), $composer3, (($dirty2 >> 9) & 14) | 24576, 14);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$WatchLaterToolBar_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
            long j = BiliTheme.INSTANCE.getThemeColors($composer3, BiliTheme.$stable).getActionIcon-0d7_KjU();
            TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14();
            Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 11, (Object) null), Dp.constructor-impl(4), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(4), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 10, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -1298797291, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier3 = ClickableKt.clickable-O2vRcR0$default(modifier2, (MutableInteractionSource) it$iv, (Indication) null, buttonClickable, (String) null, (Role) null, function02, 24, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -1298787949, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda3
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
            TextKt.Text--4IGK_g(manageText, GraphicsLayerModifierKt.graphicsLayer(modifier3, (Function1) it$iv2), j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t14, $composer3, ($dirty2 >> 3) & 14, 0, 65528);
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda4
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

    /* JADX WARN: Code restructure failed: missing block: B:203:0x044a, code lost:
        if (r1 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L180;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void WatchLaterContentPage(final boolean isCheckMode, final Tabs tabList, final boolean asc, final boolean buttonClickable, final PagerState pagerState, final LazyListState tabAllListState, final LazyListState tabToViewListState, final Function0<Unit> function0, final Function0<Unit> function02, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function2, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function22, final Function0<Unit> function03, final Function0<Unit> function04, final WatchLaterTabState pageAllState, final WatchLaterTabState pageToViewState, final Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function23, final Function1<? super Integer, Unit> function1, final Function1<? super Integer, Unit> function12, final Function1<? super Integer, Unit> function13, final Function1<? super Long, Unit> function14, final Function1<? super Integer, Unit> function15, final Function1<? super Integer, Unit> function16, final Function0<Unit> function05, Composer $composer, final int $changed, final int $changed1, final int $changed2) {
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
        Composer $composer3 = $composer.startRestartGroup(-715989328);
        ComposerKt.sourceInformation($composer3, "C(WatchLaterContentPage)N(isCheckMode,tabList,asc,buttonClickable,pagerState,tabAllListState,tabToViewListState,onSortButtonClick,onPlayButtonClick,onCardClick,onCardLongClick,onClickMoveTo,onClickCopyTo,pageAllState,pageToViewState,onTabClick,onLoadMore,onRefresh,onRetryClick,onThreePointClick,onCheckAllClick,onCancelAllClick,onDeleteClick)232@9255L24,233@9284L2645:WatchLaterPageCompose.kt#ooxe70");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        int $dirty2 = $changed2;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(isCheckMode) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(tabList) ? 32 : 16;
        }
        int i = $changed & 384;
        int i2 = IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN;
        if (i == 0) {
            $dirty |= $composer3.changed(asc) ? 256 : 128;
        }
        int i3 = $changed & 3072;
        int i4 = IjkMediaMeta.FF_PROFILE_H264_INTRA;
        if (i3 == 0) {
            $dirty |= $composer3.changed(buttonClickable) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(pagerState) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
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
            if (!$composer3.changed(pageAllState)) {
                i4 = 1024;
            }
            $dirty12 |= i4;
        }
        if (($changed1 & 24576) == 0) {
            $dirty12 |= $composer3.changed(pageToViewState) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
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
            if (!$composer3.changedInstance(function06)) {
                i2 = 128;
            }
            $dirty2 |= i2;
        }
        if ($composer3.shouldExecute((($dirty & 306783379) == 306783378 && (306783379 & $dirty13) == 306783378 && ($dirty2 & 147) == 146) ? false : true, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-715989328, $dirty, $dirty13, "tv.danmaku.bili.ui.watchlater.compose.WatchLaterContentPage (WatchLaterPageCompose.kt:231)");
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
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1302366626, "C240@9548L162,234@9336L486,252@9955L6,249@9831L153,257@10090L1833,254@9993L1930:WatchLaterPageCompose.kt#ooxe70");
            int currentPage = pagerState.getCurrentPage();
            ComposerKt.sourceInformationMarkerStart($composer3, -1620551800, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(scope) | ((57344 & $dirty) == 16384) | $composer3.changedInstance(function24);
            Object value$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda15
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
            DividerKt.Divider-oMI9zvI(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, $composer3, 6, 12);
            PagerKt.HorizontalPager--8jOkeI(pagerState, (Modifier) null, (PaddingValues) null, (PageSize) null, 0, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (Alignment.Vertical) null, (TargetedFlingBehavior) null, false, false, (Function1) null, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(-1328731289, true, new Function4() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit WatchLaterContentPage$lambda$0$1;
                    WatchLaterContentPage$lambda$0$1 = WatchLaterPageComposeKt.WatchLaterContentPage$lambda$0$1(WatchLaterTabState.this, pageToViewState, isCheckMode, tabAllListState, tabToViewListState, function2, function22, function1, function12, function13, function14, function15, function16, function05, function04, function03, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda17
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
    /* JADX WARN: Code restructure failed: missing block: B:133:0x04a4, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x018b, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01db, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x022b, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L45;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit WatchLaterContentPage$lambda$0$1(WatchLaterTabState $pageAllState, WatchLaterTabState $pageToViewState, boolean $isCheckMode, LazyListState $tabAllListState, LazyListState $tabToViewListState, Function2 $onCardClick, Function2 $onCardLongClick, final Function1 $onLoadMore, final Function1 $onRefresh, final Function1 $onRetryClick, Function1 $onThreePointClick, final Function1 $onCheckAllClick, final Function1 $onCancelAllClick, Function0 $onDeleteClick, Function0 $onClickCopyTo, Function0 $onClickMoveTo, PagerScope $this$HorizontalPager, final int index, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        boolean checkedAll;
        int checkedCount;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter($this$HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation($composer, "CN(index)259@10191L1722:WatchLaterPageCompose.kt#ooxe70");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1328731289, $changed, -1, "tv.danmaku.bili.ui.watchlater.compose.WatchLaterContentPage.<anonymous>.<anonymous> (WatchLaterPageCompose.kt:258)");
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
        ComposerKt.sourceInformationMarkerStart($composer, -2048975648, "C269@10708L21,270@10763L20,271@10820L23,260@10213L707:WatchLaterPageCompose.kt#ooxe70");
        WatchLaterList data = pageState.getData();
        boolean isRefreshing = pageState.isRefreshing();
        boolean hasMore = pageState.getHasMore();
        PageState pageState2 = pageState.getPageState();
        LazyListState lazyListState = index == 0 ? $tabAllListState : $tabToViewListState;
        ComposerKt.sourceInformationMarkerStart($composer, -343176478, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
        boolean invalid$iv = $composer.changed($onLoadMore) | (((($changed & 112) ^ 48) > 32 && $composer.changed(index)) || ($changed & 48) == 32);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv) {
        }
        Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda21
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
        ComposerKt.sourceInformationMarkerStart($composer, -343174719, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed($onRefresh) | (((($changed & 112) ^ 48) > 32 && $composer.changed(index)) || ($changed & 48) == 32);
        Object value$iv2 = $composer.rememberedValue();
        if (invalid$iv2) {
        }
        value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda22
            public final Object invoke() {
                Unit WatchLaterContentPage$lambda$0$1$0$1$0;
                WatchLaterContentPage$lambda$0$1$0$1$0 = WatchLaterPageComposeKt.WatchLaterContentPage$lambda$0$1$0$1$0($onRefresh, index);
                return WatchLaterContentPage$lambda$0$1$0$1$0;
            }
        };
        $composer.updateRememberedValue(value$iv2);
        Function0 function02 = value$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -343172892, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
        boolean invalid$iv3 = $composer.changed($onRetryClick) | (((($changed & 112) ^ 48) > 32 && $composer.changed(index)) || ($changed & 48) == 32);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv3) {
        }
        Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda23
            public final Object invoke() {
                Unit WatchLaterContentPage$lambda$0$1$0$2$0;
                WatchLaterContentPage$lambda$0$1$0$2$0 = WatchLaterPageComposeKt.WatchLaterContentPage$lambda$0$1$0$2$0($onRetryClick, index);
                return WatchLaterContentPage$lambda$0$1$0$2$0;
            }
        };
        $composer.updateRememberedValue(value$iv3);
        it$iv2 = value$iv3;
        ComposerKt.sourceInformationMarkerEnd($composer);
        WatchLaterListPage($isCheckMode, data, isRefreshing, hasMore, pageState2, lazyListState, $onCardClick, $onCardLongClick, function0, function02, (Function0) it$iv2, $onThreePointClick, $composer, 0, 0, 0);
        if ($isCheckMode) {
            $composer.startReplaceGroup(-2048263548);
            ComposerKt.sourceInformation($composer, "277@11222L659");
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
            ComposerKt.sourceInformationMarkerStart($composer, 2082151315, "C284@11554L26,285@11629L27,281@11377L482:WatchLaterPageCompose.kt#ooxe70");
            ComposerKt.sourceInformationMarkerStart($composer, 759908040, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            $composer$iv$iv$iv = $composer;
            boolean invalid$iv4 = $composer.changed($onCheckAllClick) | (((($changed & 112) ^ 48) > 32 && $composer.changed(index)) || ($changed & 48) == 32);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv4 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda24
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
            ComposerKt.sourceInformationMarkerStart($composer, 759910441, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            boolean invalid$iv5 = $composer.changed($onCancelAllClick) | (((($changed & 112) ^ 48) > 32 && $composer.changed(index)) || ($changed & 48) == 32);
            Object value$iv5 = $composer.rememberedValue();
            if (invalid$iv5 || value$iv5 == Composer.Companion.getEmpty()) {
                value$iv5 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda25
                    public final Object invoke() {
                        Unit WatchLaterContentPage$lambda$0$1$0$7$1$0;
                        WatchLaterContentPage$lambda$0$1$0$7$1$0 = WatchLaterPageComposeKt.WatchLaterContentPage$lambda$0$1$0$7$1$0($onCancelAllClick, index);
                        return WatchLaterContentPage$lambda$0$1$0$7$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            WatchLaterWidgetKt.FooterBatchEditView(null, checkedAll, checkedCount, function03, value$iv5, $onDeleteClick, $onClickCopyTo, $onClickMoveTo, $composer, 0, 1);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
        } else {
            $composer$iv = $composer;
            $composer$iv$iv$iv = $composer;
            $composer.startReplaceGroup(-2059160203);
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

    /* JADX WARN: Removed duplicated region for block: B:113:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0465  */
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
        Composer $composer2 = $composer.startRestartGroup(-1451923968);
        ComposerKt.sourceInformation($composer2, "C(WatchLaterTabRow)N(selectedTabIndex,tabList,ascend,buttonClickable,isCheckMode,onTabClick,onSortButtonClick,onPlayButtonClick)308@12205L3008:WatchLaterPageCompose.kt#ooxe70");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(i) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(tabList) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(ascend) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(buttonClickable) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(isCheckMode) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
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
                ComposerKt.traceEventStart(-1451923968, $dirty, -1, "tv.danmaku.bili.ui.watchlater.compose.WatchLaterTabRow (WatchLaterPageCompose.kt:307)");
            }
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(52)), Dp.constructor-impl(12));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((AbsoluteCommentItem.BILI_PLAYER_HEIGHT >> 3) & 14) | ((AbsoluteCommentItem.BILI_PLAYER_HEIGHT >> 3) & 112));
            int $changed$iv$iv = (AbsoluteCommentItem.BILI_PLAYER_HEIGHT << 3) & 112;
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
            int i3 = ((AbsoluteCommentItem.BILI_PLAYER_HEIGHT >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 2097351139, "C316@12451L1355,344@13815L1392:WatchLaterPageCompose.kt#ooxe70");
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1625479356, "C:WatchLaterPageCompose.kt#ooxe70");
            $composer2.startReplaceGroup(1299361210);
            ComposerKt.sourceInformation($composer2, "*325@12959L93,337@13595L99,334@13425L21,319@12590L1192");
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
                    $composer2.startReplaceGroup(-1470348682);
                    ComposerKt.sourceInformation($composer2, "322@12734L9");
                    t13 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13b();
                } else {
                    z = z3;
                    $composer2.startReplaceGroup(-1470347723);
                    ComposerKt.sourceInformation($composer2, "322@12764L9");
                    t13 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13();
                }
                $composer2.endReplaceGroup();
                TextStyle textStyle = t13;
                if (isSelected) {
                    $composer2.startReplaceGroup(-1470345604);
                    ComposerKt.sourceInformation($composer2, "323@12833L6");
                    j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                } else {
                    $composer2.startReplaceGroup(-1470344553);
                    ComposerKt.sourceInformation($composer2, "323@12866L6");
                    j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU();
                }
                $composer2.endReplaceGroup();
                long j3 = j;
                Modifier modifier = Modifier.Companion;
                CompositionLocalMap localMap$iv$iv3 = localMap$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer2, -1470341713, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                boolean invalid$iv2 = (57344 & $dirty) == 16384;
                Object it$iv3 = $composer2.rememberedValue();
                if (!invalid$iv2 && it$iv3 != Composer.Companion.getEmpty()) {
                    value$iv = it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) value$iv), index != 1 ? Dp.constructor-impl(8) : Dp.constructor-impl(0), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null);
                    if (!isSelected) {
                        $composer2.startReplaceGroup(-1470333311);
                        ComposerKt.sourceInformation($composer2, "330@13217L6");
                        j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink_thin-0d7_KjU();
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(-1470332451);
                        $composer2.endReplaceGroup();
                        j2 = Color.Companion.getTransparent-0d7_KjU();
                    }
                    int $changed$iv$iv$iv3 = $changed$iv$iv$iv2;
                    boolean z4 = z2;
                    Modifier modifier3 = BackgroundKt.background-bw27NRU(modifier2, j2, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
                    boolean z5 = !isCheckMode;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1470321355, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                    it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv2);
                        it$iv = value$iv2;
                    }
                    MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1470326873, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                    invalid$iv = ((458752 & $dirty) != 131072) | $composer2.changed(index);
                    it$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda6
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
                    TextKt.Text--4IGK_g(title, PaddingKt.padding-VpY3zN4(ClickableKt.clickable-O2vRcR0$default(modifier3, mutableInteractionSource, (Indication) null, z5, (String) null, (Role) null, (Function0) it$iv2, 24, (Object) null), Dp.constructor-impl(8), Dp.constructor-impl(5)), j3, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i6), 0L, 0, false, 0, 0, (Function1) null, textStyle, $composer2, 0, 0, 65016);
                    i = selectedTabIndex;
                    $changed$iv$iv$iv2 = $changed$iv$iv$iv3;
                    index$iv = index$iv2;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    z3 = z;
                    localMap$iv$iv2 = localMap$iv$iv3;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    z2 = z4;
                }
                Object obj = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj2) {
                        Unit WatchLaterTabRow$lambda$0$0$0$0$0;
                        WatchLaterTabRow$lambda$0$0$0$0$0 = WatchLaterPageComposeKt.WatchLaterTabRow$lambda$0$0$0$0$0(isCheckMode, (GraphicsLayerScope) obj2);
                        return WatchLaterTabRow$lambda$0$0$0$0$0;
                    }
                };
                $composer2.updateRememberedValue(obj);
                value$iv = obj;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier22 = PaddingKt.padding-qDBjuR0$default(GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) value$iv), index != 1 ? Dp.constructor-impl(8) : Dp.constructor-impl(0), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null);
                if (!isSelected) {
                }
                int $changed$iv$iv$iv32 = $changed$iv$iv$iv2;
                boolean z42 = z2;
                Modifier modifier32 = BackgroundKt.background-bw27NRU(modifier22, j2, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
                boolean z52 = !isCheckMode;
                ComposerKt.sourceInformationMarkerStart($composer2, -1470321355, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                }
                MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1470326873, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                invalid$iv = ((458752 & $dirty) != 131072) | $composer2.changed(index);
                it$iv2 = $composer2.rememberedValue();
                if (!invalid$iv) {
                }
                Object value$iv32 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit WatchLaterTabRow$lambda$0$0$0$2$0;
                        WatchLaterTabRow$lambda$0$0$0$2$0 = WatchLaterPageComposeKt.WatchLaterTabRow$lambda$0$0$0$2$0(function1, index);
                        return WatchLaterTabRow$lambda$0$0$0$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv32);
                it$iv2 = value$iv32;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                TextKt.Text--4IGK_g(title, PaddingKt.padding-VpY3zN4(ClickableKt.clickable-O2vRcR0$default(modifier32, mutableInteractionSource2, (Indication) null, z52, (String) null, (Role) null, (Function0) it$iv2, 24, (Object) null), Dp.constructor-impl(8), Dp.constructor-impl(5)), j3, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i6), 0L, 0, false, 0, 0, (Function1) null, textStyle, $composer2, 0, 0, 65016);
                i = selectedTabIndex;
                $changed$iv$iv$iv2 = $changed$iv$iv$iv32;
                index$iv = index$iv2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                z3 = z;
                localMap$iv$iv2 = localMap$iv$iv3;
                measurePolicy$iv$iv = measurePolicy$iv$iv2;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1992760302, "C347@13886L184,349@14114L6,351@14245L6,353@14338L9,345@13833L749,359@14595L40,361@14681L80,362@14801L6,364@14932L6,365@14989L9,360@14648L549:WatchLaterPageCompose.kt#ooxe70");
            String stringResource = StringResources_androidKt.stringResource(ascend ? bili.resource.favorites.R.string.favorites_global_string_225 : bili.resource.following.R.string.following_global_string_873, $composer2, 0);
            BiliTheme biliTheme = BiliTheme.INSTANCE;
            int $changed$iv = BiliTheme.$stable;
            long j4 = biliTheme.getColors($composer2, $changed$iv).getText2-0d7_KjU();
            int i9 = com.bilibili.iconfont.R.drawable.ref_list_sort_line_500;
            WatchLaterWidgetKt.m1791IconTextH8uBujs(stringResource, null, Integer.valueOf(i9), 0, Dp.constructor-impl(2), DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, j4, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bold-0d7_KjU(), BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), ascend, buttonClickable && !isCheckMode, (!buttonClickable || isCheckMode) ? 0.4f : 1.0f, function0, $composer2, (($dirty << 21) & 1879048192) | 24576, ($dirty >> 12) & 896, 42);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer2, 6);
            WatchLaterWidgetKt.m1791IconTextH8uBujs(StringResources_androidKt.stringResource(bili.resource.favorites.R.string.favorites_global_string_79, $composer2, 0), null, Integer.valueOf(com.bilibili.iconfont.R.drawable.ref_play_fill_500), 0, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), false, buttonClickable && !isCheckMode, (!buttonClickable || isCheckMode) ? 0.4f : 1.0f, function02, $composer2, 0, ($dirty >> 15) & 896, 570);
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda7
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

    public static final void WatchLaterListPage(final boolean isCheckMode, final WatchLaterList list, boolean isRefreshing, final boolean hasMore, final PageState pageState, LazyListState listState, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function2, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function22, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function1<? super Long, Unit> function1, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        boolean isRefreshing2;
        LazyListState listState2;
        boolean isRefreshing3;
        boolean isRefreshing4;
        int $dirty;
        int i2;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(function2, "onCardClick");
        Intrinsics.checkNotNullParameter(function22, "onCardLongClick");
        Intrinsics.checkNotNullParameter(function0, "onLoadMore");
        Intrinsics.checkNotNullParameter(function02, "onRefresh");
        Intrinsics.checkNotNullParameter(function03, "onRetryClick");
        Intrinsics.checkNotNullParameter(function1, "onThreePointClick");
        Composer $composer3 = $composer.startRestartGroup(-1353523761);
        ComposerKt.sourceInformation($composer3, "C(WatchLaterListPage)N(isCheckMode,list,isRefreshing,hasMore,pageState,listState,onCardClick,onCardLongClick,onLoadMore,onRefresh,onRetryClick,onThreePointClick)390@15752L54,394@15939L32,395@15978L871,389@15722L1127:WatchLaterPageCompose.kt#ooxe70");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(isCheckMode) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(list) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(isRefreshing) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(hasMore) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changed(pageState) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0 && $composer3.changed(listState)) {
                i2 = 131072;
                $dirty2 |= i2;
            }
            i2 = 65536;
            $dirty2 |= i2;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 67108864 : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty2 |= $composer3.changedInstance(function02) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(function03) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if ($composer3.shouldExecute((($dirty2 & 306783379) == 306783378 && ($dirty1 & 19) == 18) ? false : true, $dirty2 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "381@15419L23");
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                isRefreshing4 = isRefreshing;
                listState2 = listState;
                $dirty = $dirty2;
            } else {
                if (i3 != 0) {
                    isRefreshing3 = false;
                } else {
                    isRefreshing3 = isRefreshing;
                }
                if ((i & 32) == 0) {
                    listState2 = listState;
                    isRefreshing4 = isRefreshing3;
                    $dirty = $dirty2;
                } else {
                    isRefreshing4 = isRefreshing3;
                    $dirty = $dirty2 & (-458753);
                    listState2 = LazyListStateKt.rememberLazyListState(0, 0, $composer3, 0, 3);
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1353523761, $dirty, $dirty1, "tv.danmaku.bili.ui.watchlater.compose.WatchLaterListPage (WatchLaterPageCompose.kt:388)");
            }
            $composer2 = $composer3;
            final LazyListState lazyListState = listState2;
            isRefreshing2 = isRefreshing4;
            SwipeRefreshKt.SwipeRefresh-Fsagccs(SwipeRefreshKt.rememberSwipeRefreshState(isRefreshing4, $composer3, ($dirty >> 6) & 14), function02, SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), !isCheckMode, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (Alignment) null, (PaddingValues) null, BiliSwipeRefreshIndicatorKt.biliThemeSwipeRefreshIndicator($composer3, 0), false, ComposableLambdaKt.rememberComposableLambda(-2134220968, true, new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterListPage$lambda$0;
                    WatchLaterListPage$lambda$0 = WatchLaterPageComposeKt.WatchLaterListPage$lambda$0(PageState.this, function03, isCheckMode, list, hasMore, lazyListState, function2, function22, function1, function0, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterListPage$lambda$0;
                }
            }, $composer2, 54), $composer2, (($dirty >> 24) & 112) | 805306752, 368);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            isRefreshing2 = isRefreshing;
            listState2 = listState;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z = isRefreshing2;
            final LazyListState lazyListState2 = listState2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterListPage$lambda$1;
                    WatchLaterListPage$lambda$1 = WatchLaterPageComposeKt.WatchLaterListPage$lambda$1(isCheckMode, list, z, hasMore, pageState, lazyListState2, function2, function22, function0, function02, function03, function1, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterListPage$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterListPage$lambda$0(PageState $pageState, Function0 $onRetryClick, boolean $isCheckMode, WatchLaterList $list, boolean $hasMore, LazyListState $listState, Function2 $onCardClick, Function2 $onCardLongClick, Function1 $onThreePointClick, Function0 $onLoadMore, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:WatchLaterPageCompose.kt#ooxe70");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2134220968, $changed, -1, "tv.danmaku.bili.ui.watchlater.compose.WatchLaterListPage.<anonymous> (WatchLaterPageCompose.kt:396)");
            }
            if ($pageState instanceof PageState.Empty) {
                $composer.startReplaceGroup(2119056127);
                ComposerKt.sourceInformation($composer, "398@16059L11");
                EmptyPage($composer, 0);
                $composer.endReplaceGroup();
            } else if ($pageState instanceof PageState.Error) {
                $composer.startReplaceGroup(2119138432);
                ComposerKt.sourceInformation($composer, "402@16138L138");
                ErrorPage(((PageState.Error) $pageState).getNetworkActive(), $onRetryClick, $composer, 0);
                $composer.endReplaceGroup();
            } else if ($pageState instanceof PageState.Loading) {
                $composer.startReplaceGroup(2119340893);
                ComposerKt.sourceInformation($composer, "409@16346L13");
                LoadingPage($composer, 0);
                $composer.endReplaceGroup();
            } else if (!($pageState instanceof PageState.Success)) {
                $composer.startReplaceGroup(2008018415);
                $composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            } else {
                $composer.startReplaceGroup(2119434916);
                ComposerKt.sourceInformation($composer, "413@16429L390");
                ListPage($isCheckMode, $list, $hasMore, $listState, $onCardClick, $onCardLongClick, $onThreePointClick, $onLoadMore, $composer, 0, 0);
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

    /* JADX WARN: Removed duplicated region for block: B:84:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ListPage(final boolean isCheckMode, final WatchLaterList list, final boolean hasMore, LazyListState state, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function2, final Function2<? super Boolean, ? super WatchLaterItem, Unit> function22, final Function1<? super Long, Unit> function1, final Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
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
        Composer $composer2 = $composer.startRestartGroup(980977436);
        ComposerKt.sourceInformation($composer2, "C(ListPage)N(isCheckMode,list,hasMore,state,onCardClick,onCardLongClick,onThreePointClick,onLoadMore)444@17352L1143,442@17269L1226,475@18560L16,475@18506L71:WatchLaterPageCompose.kt#ooxe70");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(isCheckMode) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(hasMore) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                lazyListState = state;
                if ($composer2.changed(lazyListState)) {
                    i2 = IjkMediaMeta.FF_PROFILE_H264_INTRA;
                    $dirty2 |= i2;
                }
            } else {
                lazyListState = state;
            }
            i2 = 1024;
            $dirty2 |= i2;
        } else {
            lazyListState = state;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function22) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 8388608 : 4194304;
        }
        if ($composer2.shouldExecute((4793491 & $dirty2) != 4793490, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "436@17023L23");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
            } else if ((i & 8) != 0) {
                $dirty = $dirty2 & (-7169);
                state2 = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(980977436, $dirty, -1, "tv.danmaku.bili.ui.watchlater.compose.ListPage (WatchLaterPageCompose.kt:441)");
                }
                final LazyListState lazyListState2 = state2;
                int $dirty3 = $dirty;
                CompositionLocalKt.CompositionLocalProvider(OverscrollConfiguration_androidKt.getLocalOverscrollConfiguration().provides((Object) null), ComposableLambdaKt.rememberComposableLambda(-996734372, true, new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ListPage$lambda$0;
                        ListPage$lambda$0 = WatchLaterPageComposeKt.ListPage$lambda$0(lazyListState2, list, isCheckMode, function2, function22, function1, (Composer) obj, ((Integer) obj2).intValue());
                        return ListPage$lambda$0;
                    }
                }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
                Boolean valueOf = Boolean.valueOf(hasMore);
                ComposerKt.sourceInformationMarkerStart($composer2, 2121531052, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                invalid$iv = ($dirty3 & 29360128) != 8388608;
                it$iv = $composer2.rememberedValue();
                if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = (Function1) new WatchLaterPageComposeKt$ListPage$2$1(function0, null);
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                WatchLaterWidgetKt.OnBottomReached(state2, valueOf, 2, (Function1) it$iv, $composer2, (($dirty3 >> 9) & 14) | 384 | (($dirty3 >> 3) & 112), 0);
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
            CompositionLocalKt.CompositionLocalProvider(OverscrollConfiguration_androidKt.getLocalOverscrollConfiguration().provides((Object) null), ComposableLambdaKt.rememberComposableLambda(-996734372, true, new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit ListPage$lambda$0;
                    ListPage$lambda$0 = WatchLaterPageComposeKt.ListPage$lambda$0(lazyListState22, list, isCheckMode, function2, function22, function1, (Composer) obj, ((Integer) obj2).intValue());
                    return ListPage$lambda$0;
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            Boolean valueOf2 = Boolean.valueOf(hasMore);
            ComposerKt.sourceInformationMarkerStart($composer2, 2121531052, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            invalid$iv = ($dirty32 & 29360128) != 8388608;
            it$iv = $composer2.rememberedValue();
            if (!invalid$iv) {
            }
            Object value$iv2 = (Function1) new WatchLaterPageComposeKt$ListPage$2$1(function0, null);
            $composer2.updateRememberedValue(value$iv2);
            it$iv = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            WatchLaterWidgetKt.OnBottomReached(state2, valueOf2, 2, (Function1) it$iv, $composer2, (($dirty32 >> 9) & 14) | 384 | (($dirty32 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2.skipToGroupEnd();
            state2 = lazyListState;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final LazyListState lazyListState3 = state2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit ListPage$lambda$2;
                    ListPage$lambda$2 = WatchLaterPageComposeKt.ListPage$lambda$2(isCheckMode, list, hasMore, lazyListState3, function2, function22, function1, function0, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ListPage$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListPage$lambda$0(LazyListState $state, final WatchLaterList $list, final boolean $isCheckMode, final Function2 $onCardClick, final Function2 $onCardLongClick, final Function1 $onThreePointClick, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C449@17474L1015,445@17362L1127:WatchLaterPageCompose.kt#ooxe70");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-996734372, $changed, -1, "tv.danmaku.bili.ui.watchlater.compose.ListPage.<anonymous> (WatchLaterPageCompose.kt:445)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -84019565, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
            boolean invalid$iv = $composer.changed($list) | $composer.changed($isCheckMode) | $composer.changed($onCardClick) | $composer.changed($onCardLongClick) | $composer.changed($onThreePointClick);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda18
                    public final Object invoke(Object obj) {
                        Unit ListPage$lambda$0$0$0;
                        ListPage$lambda$0$0$0 = WatchLaterPageComposeKt.ListPage$lambda$0$0$0(WatchLaterList.this, $isCheckMode, $onCardClick, $onCardLongClick, $onThreePointClick, (LazyListScope) obj);
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
    public static final Unit ListPage$lambda$0$0$0(WatchLaterList $list, final boolean $isCheckMode, final Function2 $onCardClick, final Function2 $onCardLongClick, final Function1 $onThreePointClick, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final List items$iv = $list.getList();
        final Function2 key$iv = new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda11
            public final Object invoke(Object obj, Object obj2) {
                Object ListPage$lambda$0$0$0$0;
                ListPage$lambda$0$0$0$0 = WatchLaterPageComposeKt.ListPage$lambda$0$0$0$0(((Integer) obj).intValue(), (WatchLaterItem) obj2);
                return ListPage$lambda$0$0$0$0;
            }
        };
        $this$LazyColumn.items(items$iv.size(), new Function1<Integer, Object>() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$ListPage$lambda$0$0$0$$inlined$itemsIndexed$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return key$iv.invoke(Integer.valueOf(index), items$iv.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$ListPage$lambda$0$0$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                items$iv.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$ListPage$lambda$0$0$0$$inlined$itemsIndexed$default$3
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
                    $composer.startReplaceGroup(-1880809973);
                    ComposerKt.sourceInformation($composer, "CN(item):WatchLaterPageCompose.kt#ooxe70");
                    if (item.getCardType() == 0) {
                        $composer.startReplaceGroup(-1880759289);
                        ComposerKt.sourceInformation($composer, "459@17917L34,460@17995L38,454@17664L454");
                        boolean isChecked = item.isChecked();
                        Modifier animateItem$default = LazyItemScope.-CC.animateItem$default($this$items, Modifier.Companion, (FiniteAnimationSpec) null, (FiniteAnimationSpec) null, (FiniteAnimationSpec) null, 7, (Object) null);
                        boolean z = $isCheckMode;
                        ComposerKt.sourceInformationMarkerStart($composer, 1601906007, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                        boolean invalid$iv = $composer.changed($onCardClick) | $composer.changed($isCheckMode) | (((($changed2 & 896) ^ 384) > 256 && $composer.changedInstance(item)) || ($changed2 & 384) == 256);
                        Object it$iv = $composer.rememberedValue();
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            final Function2 function2 = $onCardClick;
                            final boolean z2 = $isCheckMode;
                            Object value$iv = (Function0) new Function0<Unit>() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$ListPage$1$1$1$2$1$1
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m1784invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: collision with other method in class */
                                public final void m1784invoke() {
                                    function2.invoke(Boolean.valueOf(z2), item);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        Function0 function0 = (Function0) it$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, 1601908507, "CC(remember):WatchLaterPageCompose.kt#9igjgp");
                        boolean invalid$iv2 = $composer.changed($onCardLongClick) | $composer.changed($isCheckMode) | (((($changed2 & 896) ^ 384) > 256 && $composer.changedInstance(item)) || ($changed2 & 384) == 256);
                        Object it$iv2 = $composer.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                            final Function2 function22 = $onCardLongClick;
                            final boolean z3 = $isCheckMode;
                            Object value$iv2 = (Function0) new Function0<Unit>() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$ListPage$1$1$1$2$2$1
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m1785invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: collision with other method in class */
                                public final void m1785invoke() {
                                    function22.invoke(Boolean.valueOf(z3), item);
                                }
                            };
                            $composer.updateRememberedValue(value$iv2);
                            it$iv2 = value$iv2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer2 = $composer;
                        WatchLaterCardKt.WatchLaterCard(animateItem$default, z, isChecked, item, function0, (Function0) it$iv2, $onThreePointClick, $composer2, ($changed2 << 3) & 7168, 0);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2 = $composer;
                        if (item.getCardType() == 1) {
                            $composer2.startReplaceGroup(-1880253555);
                            ComposerKt.sourceInformation($composer2, "464@18204L152");
                            WatchLaterCardKt.WatchLaterDividerCard(item.getTitle(), LazyItemScope.-CC.animateItem$default($this$items, Modifier.Companion, (FiniteAnimationSpec) null, (FiniteAnimationSpec) null, (FiniteAnimationSpec) null, 7, (Object) null), $composer2, 0, 0);
                        } else {
                            $composer2.startReplaceGroup(-1898297043);
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
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$WatchLaterPageComposeKt.INSTANCE.getLambda$1092728423$core_apinkDebug(), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ListPage$lambda$0$0$0$0(int i, WatchLaterItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.getItemId();
    }

    public static final void ErrorPage(final boolean networkActive, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function0, "onRetryClick");
        Composer $composer2 = $composer.startRestartGroup(124765463);
        ComposerKt.sourceInformation($composer2, "C(ErrorPage)N(networkActive,onRetryClick)488@18800L21,484@18674L646:WatchLaterPageCompose.kt#ooxe70");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(networkActive) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(124765463, $dirty2, -1, "tv.danmaku.bili.ui.watchlater.compose.ErrorPage (WatchLaterPageCompose.kt:483)");
            }
            Modifier modifier$iv = ScrollKt.verticalScroll$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(130), 7, (Object) null), ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
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
            ComposerKt.sourceInformationMarkerStart($composer2, -190497052, "C492@18920L229,491@18884L430:WatchLaterPageCompose.kt#ooxe70");
            WatchLaterWidgetKt.PageLoadingView(StringResources_androidKt.stringResource(!networkActive ? bili.resource.common.R.string.common_global_string_20 : bili.resource.common.R.string.common_global_string_188, $composer2, 0), com.bilibili.app.comm.baseres.R.drawable.ic_tips_error, true, function0, $composer2, (($dirty2 << 6) & 7168) | 384, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit ErrorPage$lambda$1;
                    ErrorPage$lambda$1 = WatchLaterPageComposeKt.ErrorPage$lambda$1(networkActive, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ErrorPage$lambda$1;
                }
            });
        }
    }

    public static final void EmptyPage(Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1879882450);
        ComposerKt.sourceInformation($composer2, "C(EmptyPage)511@19485L21,507@19359L443:WatchLaterPageCompose.kt#ooxe70");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1879882450, $changed, -1, "tv.danmaku.bili.ui.watchlater.compose.EmptyPage (WatchLaterPageCompose.kt:506)");
            }
            Modifier modifier$iv = ScrollKt.verticalScroll$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(130), 7, (Object) null), ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
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
            ComposerKt.sourceInformationMarkerStart($composer2, -1446677303, "C515@19606L81,514@19570L226:WatchLaterPageCompose.kt#ooxe70");
            WatchLaterWidgetKt.PageLoadingView(StringResources_androidKt.stringResource(bili.resource.favorites.R.string.favorites_global_string_230, $composer2, 0), com.bilibili.app.comm.baseres.R.drawable.ic_tips_empty, false, null, $composer2, 384, 8);
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda26
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
        Composer $composer2 = $composer.startRestartGroup(-1829796735);
        ComposerKt.sourceInformation($composer2, "C(LoadingPage)524@19842L227:WatchLaterPageCompose.kt#ooxe70");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1829796735, $changed, -1, "tv.danmaku.bili.ui.watchlater.compose.LoadingPage (WatchLaterPageCompose.kt:523)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(130), 7, (Object) null);
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
            ComposerKt.sourceInformationMarkerStart($composer2, -654393762, "C530@20045L6,530@20001L62:WatchLaterPageCompose.kt#ooxe70");
            ProgressIndicatorKt.CircularProgressIndicator-LxG7B9w((Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0L, 0, $composer2, 0, 29);
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterPageComposeKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoadingPage$lambda$1;
                    LoadingPage$lambda$1 = WatchLaterPageComposeKt.LoadingPage$lambda$1($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LoadingPage$lambda$1;
                }
            });
        }
    }
}