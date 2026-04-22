package kntr.app.upcomingEpisode.list.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
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
import androidx.compose.foundation.lazy.LazyListItemInfo;
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
import androidx.compose.material3.BottomSheetScaffoldKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.watching.Res;
import bili.resource.watching.String0_commonMainKt;
import com.bapis.bilibili.community.interfacess.watch.v1.KArchiveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarCardType;
import com.bapis.bilibili.community.interfacess.watch.v1.KLiveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KOgvCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KRecommend;
import com.bapis.bilibili.community.interfacess.watch.v1.KReserveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KReserveRecommend;
import com.bapis.bilibili.community.interfacess.watch.v1.KThreeMoreInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KUpInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KWatchBizType;
import com.bilibili.compose.iconfont.BiliIconfontKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.handler.CalendarCardClickArea;
import kntr.app.upcomingEpisode.list.model.CalendarCard;
import kntr.app.upcomingEpisode.list.model.CardUiType;
import kntr.app.upcomingEpisode.list.utils.UpcomingEpisodeExtensionsKt;
import kntr.app.upcomingEpisode.list.utils.UpcomingEpisodeUtilsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.router.Router;
import kntr.common.compose.res.AnimatePainter;
import kntr.common.compose.res.RefreshAnimatePainterKt;
import kntr.common.router.RouterKt;
import kntr.common.router.UrisKt;
import kntr.common.trio.list.DefaultListModifierKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.common.compose.res.generated.resources.Drawable0_commonMainKt;
import srcs.common.compose.res.generated.resources.Res;

/* compiled from: UpcomingEpisodeList.kt */
@Metadata(d1 = {"\u0000¶\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\u001aÔ\u0005\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2S\b\u0002\u0010\u001c\u001aM\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050#¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00050\u001d2>\b\u0002\u0010%\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050#¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00050&2>\b\u0002\u0010(\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050#¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00050&2/\b\u0002\u0010*\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010,¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00050+2D\b\u0002\u0010.\u001a>\u0012\u0013\u0012\u00110/¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(0\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010,¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00050&2\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050#2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050#2>\b\u0002\u00104\u001a8\u0012\u0013\u0012\u001105¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(6\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050#¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00050&28\b\u0002\u00108\u001a2\u0012\u0013\u0012\u001109¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(:\u0012\u0013\u0012\u001105¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u00050&2>\b\u0002\u0010;\u001a8\u0012\u0013\u0012\u001105¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(6\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050#¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00050&2#\b\u0002\u0010<\u001a\u001d\u0012\u0013\u0012\u001105¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u00050+H\u0007¢\u0006\u0004\b=\u0010>\u001a¨\u0005\u0010?\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050#2Q\u0010\u001c\u001aM\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050#¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00050\u001d2<\u0010%\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050#¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00050&2<\u0010(\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050#¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00050&2-\u0010*\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010,¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00050+2B\u0010.\u001a>\u0012\u0013\u0012\u00110/¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(0\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010,¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00050&2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050#2>\b\u0002\u00104\u001a8\u0012\u0013\u0012\u001105¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(6\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050#¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00050&28\b\u0002\u00108\u001a2\u0012\u0013\u0012\u001109¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(:\u0012\u0013\u0012\u001105¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u00050&2>\b\u0002\u0010;\u001a8\u0012\u0013\u0012\u001105¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(6\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050#¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00050&2#\b\u0002\u0010<\u001a\u001d\u0012\u0013\u0012\u001105¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u00050+H\u0007¢\u0006\u0002\u0010@\u001a?\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010G\u001a;\u0010H\u001a\u00020\u0005*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020K2\u0006\u0010F\u001a\u00020\u00142\u0006\u0010N\u001a\u00020OH\u0002¢\u0006\u0004\bP\u0010Q\u001a\u0093\u0001\u0010R\u001a\u00020\u0005*\u00020I2\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020K2\u0006\u0010J\u001a\u00020K2\u0006\u0010S\u001a\u00020K2\u0006\u0010T\u001a\u00020O2\u0006\u0010U\u001a\u00020O2\u0006\u0010V\u001a\u00020K2\u0006\u0010D\u001a\u00020\u00142\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010W\u001a\u00020O2\u0006\u0010X\u001a\u00020O2\u0006\u0010Y\u001a\u00020K2\u0006\u0010Z\u001a\u00020K2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010N\u001a\u00020OH\u0002¢\u0006\u0004\b[\u0010\\\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006]²\u0006\n\u0010^\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010_\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010`\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010a\u001a\u00020bX\u008a\u0084\u0002"}, d2 = {"tag", "", "getTag", "()Ljava/lang/String;", "UpcomingEpisodeList", "", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "connection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "modifier", "Landroidx/compose/ui/Modifier;", "calendarList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkntr/app/upcomingEpisode/list/model/CalendarCard;", "paddingBottom", "Landroidx/compose/ui/unit/Dp;", "pageCount", "", "isCurrentDayToday", "", "landingAnchorBizType", "landingAnchorBizId", "statusType", "Lkntr/app/upcomingEpisode/list/ui/UpcomingEpisodeListBaseStatusType;", "recommendData", "", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KRecommend;", "onClickDeleteCalendarCard", "Lkotlin/Function3;", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;", "Lkotlin/ParameterName;", "name", "bizType", "bizId", "Lkotlin/Function0;", "onDeleteSuccess", "onReservationClick", "Lkotlin/Function2;", "onReserveSuccess", "onCancelReservationClick", "onCancelReserveSuccess", "onCalendarCardShow", "Lkotlin/Function1;", "", "reportMap", "onClickCard", "Lkntr/app/upcomingEpisode/base/handler/CalendarCardClickArea;", "clickArea", "map", "checkPointType", "onClickRetry", "onRecommendReservationClick", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveRecommend;", "data", "onReservationSuccess", "onRecommendReservationAuthorClick", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KUpInfo;", "upInfo", "onCancelRecommendReservationClick", "onRecommendReservationCardShow", "UpcomingEpisodeList-beLaquY", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/snapshots/SnapshotStateList;FIZLjava/lang/String;Ljava/lang/String;Lkntr/app/upcomingEpisode/list/ui/UpcomingEpisodeListBaseStatusType;Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;IIII)V", "TimeAxisWithCardsLayout", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/runtime/snapshots/SnapshotStateList;ZLjava/lang/String;Ljava/lang/String;Lkntr/app/upcomingEpisode/list/ui/UpcomingEpisodeListBaseStatusType;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "TimeAxisItem", "cardUiType", "Lkntr/app/upcomingEpisode/list/model/CardUiType;", "isFirstItem", "isLatestUpcomingEp", "isLastItem", "(Lkntr/app/upcomingEpisode/list/model/CardUiType;ZZZZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "drawTimeAxisLine", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "strokeWidth", "", "axisX", "axisY", "lineColor", "Landroidx/compose/ui/graphics/Color;", "drawTimeAxisLine-kKL39v8", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFZJ)V", "drawDotAndConnectors", "dotRadius", "dotColor", "strokeColor", "lineLength", "latestUpcomingMarkColor", "latestUpcomingMarkStrokeColor", "latestUpcomingMarkCornerRadius", "latestUpcomingMarkStrokeWidth", "drawDotAndConnectors-0w1AfAo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFJJFZLkntr/app/upcomingEpisode/list/model/CardUiType;ZJJFFZJ)V", "main_debug", "lastClickCard", "latestUpcomingEpIndex", "shouldScrollToAnchorContent", "visibleItemsIndices", "Lkotlin/ranges/IntRange;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpcomingEpisodeListKt {
    private static final String tag = "UpcomingEpisodeListBaseStatus";

    /* compiled from: UpcomingEpisodeList.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UpcomingEpisodeListBaseStatusType.values().length];
            try {
                iArr[UpcomingEpisodeListBaseStatusType.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[UpcomingEpisodeListBaseStatusType.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[UpcomingEpisodeListBaseStatusType.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeAxisItem$lambda$1(CardUiType cardUiType, boolean z, boolean z2, boolean z3, boolean z4, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TimeAxisItem(cardUiType, z, z2, z3, z4, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeAxisWithCardsLayout$lambda$21(NestedScrollConnection nestedScrollConnection, SnapshotStateList snapshotStateList, boolean z, String str, String str2, UpcomingEpisodeListBaseStatusType upcomingEpisodeListBaseStatusType, List list, Function0 function0, Function3 function3, Function2 function2, Function2 function22, Function1 function1, Function2 function23, Modifier modifier, LazyListState lazyListState, Function0 function02, Function2 function24, Function2 function25, Function2 function26, Function1 function12, int i, int i2, int i3, Composer composer, int i4) {
        TimeAxisWithCardsLayout(nestedScrollConnection, snapshotStateList, z, str, str2, upcomingEpisodeListBaseStatusType, list, function0, function3, function2, function22, function1, function23, modifier, lazyListState, function02, function24, function25, function26, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeList_beLaquY$lambda$13(LazyListState lazyListState, NestedScrollConnection nestedScrollConnection, Modifier modifier, SnapshotStateList snapshotStateList, float f, int i, boolean z, String str, String str2, UpcomingEpisodeListBaseStatusType upcomingEpisodeListBaseStatusType, List list, Function3 function3, Function2 function2, Function2 function22, Function1 function1, Function2 function23, Function0 function0, Function0 function02, Function2 function24, Function2 function25, Function2 function26, Function1 function12, int i2, int i3, int i4, int i5, Composer composer, int i6) {
        m1272UpcomingEpisodeListbeLaquY(lazyListState, nestedScrollConnection, modifier, snapshotStateList, f, i, z, str, str2, upcomingEpisodeListBaseStatusType, list, function3, function2, function22, function1, function23, function0, function02, function24, function25, function26, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    public static final String getTag() {
        return tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeList_beLaquY$lambda$0$0(KWatchBizType kWatchBizType, String str, Function0 function0) {
        Intrinsics.checkNotNullParameter(kWatchBizType, "<unused var>");
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeList_beLaquY$lambda$1$0(String str, Function0 function0) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeList_beLaquY$lambda$2$0(String str, Function0 function0) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeList_beLaquY$lambda$3$0(Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeList_beLaquY$lambda$4$0(CalendarCardClickArea calendarCardClickArea, Map map) {
        Intrinsics.checkNotNullParameter(calendarCardClickArea, "<unused var>");
        Intrinsics.checkNotNullParameter(map, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeList_beLaquY$lambda$7$0(KReserveRecommend kReserveRecommend, Function0 function0) {
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeList_beLaquY$lambda$8$0(KUpInfo kUpInfo, KReserveRecommend kReserveRecommend) {
        Intrinsics.checkNotNullParameter(kUpInfo, "<unused var>");
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeList_beLaquY$lambda$9$0(KReserveRecommend kReserveRecommend, Function0 function0) {
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeList_beLaquY$lambda$10$0(KReserveRecommend kReserveRecommend) {
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v34 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* renamed from: UpcomingEpisodeList-beLaquY  reason: not valid java name */
    public static final void m1272UpcomingEpisodeListbeLaquY(final LazyListState listState, final NestedScrollConnection connection, Modifier modifier, SnapshotStateList<CalendarCard> snapshotStateList, float f, int pageCount, boolean isCurrentDayToday, String landingAnchorBizType, String landingAnchorBizId, UpcomingEpisodeListBaseStatusType statusType, List<KRecommend> list, Function3<? super KWatchBizType, ? super String, ? super Function0<Unit>, Unit> function3, Function2<? super String, ? super Function0<Unit>, Unit> function2, Function2<? super String, ? super Function0<Unit>, Unit> function22, Function1<? super Map<String, String>, Unit> function1, Function2<? super CalendarCardClickArea, ? super Map<String, String>, Unit> function23, Function0<Unit> function0, Function0<Unit> function02, Function2<? super KReserveRecommend, ? super Function0<Unit>, Unit> function24, Function2<? super KUpInfo, ? super KReserveRecommend, Unit> function25, Function2<? super KReserveRecommend, ? super Function0<Unit>, Unit> function26, Function1<? super KReserveRecommend, Unit> function12, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        int i2;
        Composer $composer2;
        Modifier modifier2;
        SnapshotStateList calendarList;
        float f2;
        int pageCount2;
        boolean isCurrentDayToday2;
        String landingAnchorBizType2;
        String landingAnchorBizId2;
        UpcomingEpisodeListBaseStatusType statusType2;
        List recommendData;
        Function3 onClickDeleteCalendarCard;
        Function2 onReservationClick;
        Function2 onCancelReservationClick;
        Function1 onCalendarCardShow;
        Function2 onRecommendReservationAuthorClick;
        Function0 checkPointType;
        Function0 onClickRetry;
        Function2 onRecommendReservationClick;
        Function2 onRecommendReservationAuthorClick2;
        Function2 onCancelRecommendReservationClick;
        Function1 onRecommendReservationCardShow;
        SnapshotStateList calendarList2;
        int $dirty;
        float f3;
        final int pageCount3;
        float f4;
        Function3 onClickDeleteCalendarCard2;
        Function3 onClickDeleteCalendarCard3;
        Function2 onReservationClick2;
        Function2 onReservationClick3;
        Function2 onCancelReservationClick2;
        Function2 onCancelReservationClick3;
        Function1 onCalendarCardShow2;
        Function1 onCalendarCardShow3;
        Function2 onClickCard;
        Function2 onClickCard2;
        Function0 checkPointType2;
        Function0 checkPointType3;
        Function0 onClickRetry2;
        Function0 onClickRetry3;
        Function2 onRecommendReservationClick2;
        Function2 onRecommendReservationClick3;
        Function2 onRecommendReservationAuthorClick3;
        Function2 onRecommendReservationAuthorClick4;
        Function2 onCancelRecommendReservationClick2;
        int $dirty2;
        Function3 onClickDeleteCalendarCard4;
        float f5;
        Function2 onReservationClick4;
        Function2 onCancelReservationClick4;
        Function1 onCalendarCardShow4;
        Function2 onClickCard3;
        Function0 checkPointType4;
        Function0 onClickRetry4;
        Function2 onRecommendReservationClick4;
        Function2 onRecommendReservationAuthorClick5;
        Function2 onCancelRecommendReservationClick3;
        Function1 onRecommendReservationCardShow2;
        SnapshotStateList calendarList3;
        String landingAnchorBizId3;
        UpcomingEpisodeListBaseStatusType statusType3;
        List recommendData2;
        String landingAnchorBizType3;
        boolean isCurrentDayToday3;
        Object value$iv;
        int i3;
        Intrinsics.checkNotNullParameter(listState, "listState");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Composer $composer3 = $composer.startRestartGroup(-19963602);
        ComposerKt.sourceInformation($composer3, "C(UpcomingEpisodeList)N(listState,connection,modifier,calendarList,paddingBottom:c#ui.unit.Dp,pageCount,isCurrentDayToday,landingAnchorBizType,landingAnchorBizId,statusType,recommendData,onClickDeleteCalendarCard,onReservationClick,onCancelReservationClick,onCalendarCardShow,onClickCard,checkPointType,onClickRetry,onRecommendReservationClick,onRecommendReservationAuthorClick,onCancelRecommendReservationClick,onRecommendReservationCardShow)135@6752L13,135@6733L32,136@6788L21,140@6894L1298,137@6814L1378:UpcomingEpisodeList.kt#kr57tx");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        int $dirty22 = $changed2;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(listState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changedInstance(connection) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0 && $composer3.changed(snapshotStateList)) {
                i3 = 2048;
                $dirty3 |= i3;
            }
            i3 = 1024;
            $dirty3 |= i3;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty3 |= $composer3.changed(f) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty3 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty3 |= $composer3.changed(pageCount) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer3.changed(isCurrentDayToday) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer3.changed(landingAnchorBizType) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty3 |= $composer3.changed(landingAnchorBizId) ? 67108864 : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty3 |= $composer3.changed(statusType == null ? -1 : statusType.ordinal()) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(list) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changedInstance(function3) ? 32 : 16;
        }
        int i13 = i & 4096;
        if (i13 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changedInstance(function2) ? 256 : 128;
        }
        int i14 = i & 8192;
        if (i14 != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer3.changedInstance(function22) ? 2048 : 1024;
        }
        int i15 = i & 16384;
        if (i15 != 0) {
            $dirty1 |= 24576;
            i2 = i15;
        } else {
            i2 = i15;
            if (($changed1 & 24576) == 0) {
                $dirty1 |= $composer3.changedInstance(function1) ? 16384 : 8192;
            }
        }
        int i16 = i & 32768;
        if (i16 != 0) {
            $dirty1 |= 196608;
        } else if (($changed1 & 196608) == 0) {
            $dirty1 |= $composer3.changedInstance(function23) ? 131072 : 65536;
        }
        int i17 = i & 65536;
        if (i17 != 0) {
            $dirty1 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty1 |= $composer3.changedInstance(function0) ? 1048576 : 524288;
        }
        int i18 = i & 131072;
        if (i18 != 0) {
            $dirty1 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty1 |= $composer3.changedInstance(function02) ? 8388608 : 4194304;
        }
        int i19 = i & 262144;
        if (i19 != 0) {
            $dirty1 |= 100663296;
        } else if (($changed1 & 100663296) == 0) {
            $dirty1 |= $composer3.changedInstance(function24) ? 67108864 : 33554432;
        }
        int i20 = i & 524288;
        if (i20 != 0) {
            $dirty1 |= 805306368;
        } else if (($changed1 & 805306368) == 0) {
            $dirty1 |= $composer3.changedInstance(function25) ? 536870912 : 268435456;
        }
        int i21 = i & 1048576;
        if (i21 != 0) {
            $dirty22 |= 6;
        } else if (($changed2 & 6) == 0) {
            $dirty22 |= $composer3.changedInstance(function26) ? 4 : 2;
        }
        int i22 = i & 2097152;
        if (i22 != 0) {
            $dirty22 |= 48;
        } else if (($changed2 & 48) == 0) {
            $dirty22 |= $composer3.changedInstance(function12) ? 32 : 16;
        }
        if ($composer3.shouldExecute(((306783379 & $dirty3) == 306783378 && (306783379 & $dirty1) == 306783378 && ($dirty22 & 19) == 18) ? false : true, $dirty3 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "122@5790L14,123@5886L11,124@5991L11,125@6071L2,126@6163L11,127@6209L2,128@6244L2,129@6351L11,130@6456L11,131@6578L11,132@6663L8");
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier;
                if ((i & 8) != 0) {
                    calendarList2 = SnapshotStateKt.mutableStateListOf();
                    $dirty3 &= -7169;
                } else {
                    calendarList2 = snapshotStateList;
                }
                if (i5 != 0) {
                    $dirty = $dirty3;
                    f3 = Dp.constructor-impl(0);
                } else {
                    $dirty = $dirty3;
                    f3 = f;
                }
                pageCount3 = i6 != 0 ? 1 : pageCount;
                boolean isCurrentDayToday4 = i7 != 0 ? true : isCurrentDayToday;
                String landingAnchorBizType4 = i8 != 0 ? null : landingAnchorBizType;
                String landingAnchorBizId4 = i9 != 0 ? null : landingAnchorBizId;
                UpcomingEpisodeListBaseStatusType statusType4 = i10 != 0 ? UpcomingEpisodeListBaseStatusType.NULL : statusType;
                List recommendData3 = i11 != 0 ? CollectionsKt.emptyList() : list;
                if (i12 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -2005131012, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    f4 = f3;
                    Object it$iv = $composer3.rememberedValue();
                    modifier2 = modifier3;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        value$iv = new Function3() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda21
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit UpcomingEpisodeList_beLaquY$lambda$0$0;
                                UpcomingEpisodeList_beLaquY$lambda$0$0 = UpcomingEpisodeListKt.UpcomingEpisodeList_beLaquY$lambda$0$0((KWatchBizType) obj, (String) obj2, (Function0) obj3);
                                return UpcomingEpisodeList_beLaquY$lambda$0$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    onClickDeleteCalendarCard2 = (Function3) value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    f4 = f3;
                    modifier2 = modifier3;
                    onClickDeleteCalendarCard2 = function3;
                }
                if (i13 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -2005127943, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    onClickDeleteCalendarCard3 = onClickDeleteCalendarCard2;
                    Object it$iv2 = $composer3.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda26
                            public final Object invoke(Object obj, Object obj2) {
                                Unit UpcomingEpisodeList_beLaquY$lambda$1$0;
                                UpcomingEpisodeList_beLaquY$lambda$1$0 = UpcomingEpisodeListKt.UpcomingEpisodeList_beLaquY$lambda$1$0((String) obj, (Function0) obj2);
                                return UpcomingEpisodeList_beLaquY$lambda$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    onReservationClick2 = (Function2) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    onClickDeleteCalendarCard3 = onClickDeleteCalendarCard2;
                    onReservationClick2 = function2;
                }
                if (i14 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -2005124583, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    Object it$iv3 = $composer3.rememberedValue();
                    onReservationClick3 = onReservationClick2;
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda27
                            public final Object invoke(Object obj, Object obj2) {
                                Unit UpcomingEpisodeList_beLaquY$lambda$2$0;
                                UpcomingEpisodeList_beLaquY$lambda$2$0 = UpcomingEpisodeListKt.UpcomingEpisodeList_beLaquY$lambda$2$0((String) obj, (Function0) obj2);
                                return UpcomingEpisodeList_beLaquY$lambda$2$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    onCancelReservationClick2 = it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    onReservationClick3 = onReservationClick2;
                    onCancelReservationClick2 = function22;
                }
                if (i2 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -2005122032, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    Object it$iv4 = $composer3.rememberedValue();
                    onCancelReservationClick3 = onCancelReservationClick2;
                    if (it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = new Function1() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                Unit UpcomingEpisodeList_beLaquY$lambda$3$0;
                                UpcomingEpisodeList_beLaquY$lambda$3$0 = UpcomingEpisodeListKt.UpcomingEpisodeList_beLaquY$lambda$3$0((Map) obj);
                                return UpcomingEpisodeList_beLaquY$lambda$3$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv4);
                        it$iv4 = value$iv4;
                    }
                    onCalendarCardShow2 = it$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    onCancelReservationClick3 = onCancelReservationClick2;
                    onCalendarCardShow2 = function1;
                }
                if (i16 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -2005119079, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    Object it$iv5 = $composer3.rememberedValue();
                    onCalendarCardShow3 = onCalendarCardShow2;
                    if (it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj, Object obj2) {
                                Unit UpcomingEpisodeList_beLaquY$lambda$4$0;
                                UpcomingEpisodeList_beLaquY$lambda$4$0 = UpcomingEpisodeListKt.UpcomingEpisodeList_beLaquY$lambda$4$0((CalendarCardClickArea) obj, (Map) obj2);
                                return UpcomingEpisodeList_beLaquY$lambda$4$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv5 = value$iv5;
                    }
                    onClickCard = it$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    onCalendarCardShow3 = onCalendarCardShow2;
                    onClickCard = function23;
                }
                if (i17 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -2005117616, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    Object it$iv6 = $composer3.rememberedValue();
                    onClickCard2 = onClickCard;
                    if (it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv6);
                        it$iv6 = value$iv6;
                    }
                    checkPointType2 = it$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    onClickCard2 = onClickCard;
                    checkPointType2 = function0;
                }
                if (i18 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -2005116496, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    Object it$iv7 = $composer3.rememberedValue();
                    checkPointType3 = checkPointType2;
                    if (it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv7 = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv7);
                        it$iv7 = value$iv7;
                    }
                    onClickRetry2 = it$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    checkPointType3 = checkPointType2;
                    onClickRetry2 = function02;
                }
                if (i19 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -2005113063, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    Object it$iv8 = $composer3.rememberedValue();
                    onClickRetry3 = onClickRetry2;
                    if (it$iv8 == Composer.Companion.getEmpty()) {
                        Object value$iv8 = new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj, Object obj2) {
                                Unit UpcomingEpisodeList_beLaquY$lambda$7$0;
                                UpcomingEpisodeList_beLaquY$lambda$7$0 = UpcomingEpisodeListKt.UpcomingEpisodeList_beLaquY$lambda$7$0((KReserveRecommend) obj, (Function0) obj2);
                                return UpcomingEpisodeList_beLaquY$lambda$7$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                        it$iv8 = value$iv8;
                    }
                    onRecommendReservationClick2 = it$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    onClickRetry3 = onClickRetry2;
                    onRecommendReservationClick2 = function24;
                }
                if (i20 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -2005109703, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    Object it$iv9 = $composer3.rememberedValue();
                    onRecommendReservationClick3 = onRecommendReservationClick2;
                    if (it$iv9 == Composer.Companion.getEmpty()) {
                        Object value$iv9 = new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj, Object obj2) {
                                Unit UpcomingEpisodeList_beLaquY$lambda$8$0;
                                UpcomingEpisodeList_beLaquY$lambda$8$0 = UpcomingEpisodeListKt.UpcomingEpisodeList_beLaquY$lambda$8$0((KUpInfo) obj, (KReserveRecommend) obj2);
                                return UpcomingEpisodeList_beLaquY$lambda$8$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                        it$iv9 = value$iv9;
                    }
                    onRecommendReservationAuthorClick3 = it$iv9;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    onRecommendReservationClick3 = onRecommendReservationClick2;
                    onRecommendReservationAuthorClick3 = function25;
                }
                if (i21 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -2005105799, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    Object it$iv10 = $composer3.rememberedValue();
                    onRecommendReservationAuthorClick4 = onRecommendReservationAuthorClick3;
                    if (it$iv10 == Composer.Companion.getEmpty()) {
                        Object value$iv10 = new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj, Object obj2) {
                                Unit UpcomingEpisodeList_beLaquY$lambda$9$0;
                                UpcomingEpisodeList_beLaquY$lambda$9$0 = UpcomingEpisodeListKt.UpcomingEpisodeList_beLaquY$lambda$9$0((KReserveRecommend) obj, (Function0) obj2);
                                return UpcomingEpisodeList_beLaquY$lambda$9$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv10);
                        it$iv10 = value$iv10;
                    }
                    onCancelRecommendReservationClick2 = it$iv10;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    onRecommendReservationAuthorClick4 = onRecommendReservationAuthorClick3;
                    onCancelRecommendReservationClick2 = function26;
                }
                if (i22 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -2005103082, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    Object it$iv11 = $composer3.rememberedValue();
                    Function2 onCancelRecommendReservationClick4 = onCancelRecommendReservationClick2;
                    if (it$iv11 == Composer.Companion.getEmpty()) {
                        Object value$iv11 = new Function1() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda22
                            public final Object invoke(Object obj) {
                                Unit UpcomingEpisodeList_beLaquY$lambda$10$0;
                                UpcomingEpisodeList_beLaquY$lambda$10$0 = UpcomingEpisodeListKt.UpcomingEpisodeList_beLaquY$lambda$10$0((KReserveRecommend) obj);
                                return UpcomingEpisodeList_beLaquY$lambda$10$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv11);
                        it$iv11 = value$iv11;
                    }
                    Function1 onRecommendReservationCardShow3 = it$iv11;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $dirty2 = $dirty;
                    onClickDeleteCalendarCard4 = onClickDeleteCalendarCard3;
                    f5 = f4;
                    onReservationClick4 = onReservationClick3;
                    onCancelReservationClick4 = onCancelReservationClick3;
                    onCalendarCardShow4 = onCalendarCardShow3;
                    onClickCard3 = onClickCard2;
                    checkPointType4 = checkPointType3;
                    onClickRetry4 = onClickRetry3;
                    onRecommendReservationClick4 = onRecommendReservationClick3;
                    onRecommendReservationAuthorClick5 = onRecommendReservationAuthorClick4;
                    onCancelRecommendReservationClick3 = onCancelRecommendReservationClick4;
                    onRecommendReservationCardShow2 = onRecommendReservationCardShow3;
                    calendarList3 = calendarList2;
                    landingAnchorBizId3 = landingAnchorBizId4;
                    statusType3 = statusType4;
                    recommendData2 = recommendData3;
                    landingAnchorBizType3 = landingAnchorBizType4;
                    isCurrentDayToday3 = isCurrentDayToday4;
                } else {
                    $dirty2 = $dirty;
                    onClickDeleteCalendarCard4 = onClickDeleteCalendarCard3;
                    f5 = f4;
                    onReservationClick4 = onReservationClick3;
                    onCancelReservationClick4 = onCancelReservationClick3;
                    onCalendarCardShow4 = onCalendarCardShow3;
                    onClickCard3 = onClickCard2;
                    checkPointType4 = checkPointType3;
                    onClickRetry4 = onClickRetry3;
                    onRecommendReservationClick4 = onRecommendReservationClick3;
                    onRecommendReservationAuthorClick5 = onRecommendReservationAuthorClick4;
                    onCancelRecommendReservationClick3 = onCancelRecommendReservationClick2;
                    onRecommendReservationCardShow2 = function12;
                    calendarList3 = calendarList2;
                    landingAnchorBizId3 = landingAnchorBizId4;
                    statusType3 = statusType4;
                    recommendData2 = recommendData3;
                    landingAnchorBizType3 = landingAnchorBizType4;
                    isCurrentDayToday3 = isCurrentDayToday4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                modifier2 = modifier;
                calendarList3 = snapshotStateList;
                f5 = f;
                pageCount3 = pageCount;
                isCurrentDayToday3 = isCurrentDayToday;
                landingAnchorBizType3 = landingAnchorBizType;
                landingAnchorBizId3 = landingAnchorBizId;
                statusType3 = statusType;
                recommendData2 = list;
                onClickDeleteCalendarCard4 = function3;
                onReservationClick4 = function2;
                onCancelReservationClick4 = function22;
                onCalendarCardShow4 = function1;
                onClickCard3 = function23;
                checkPointType4 = function0;
                onClickRetry4 = function02;
                onRecommendReservationClick4 = function24;
                onRecommendReservationAuthorClick5 = function25;
                onCancelRecommendReservationClick3 = function26;
                onRecommendReservationCardShow2 = function12;
                $dirty2 = $dirty3;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-19963602, $dirty2, $dirty1, "kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeList (UpcomingEpisodeList.kt:133)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -2005100229, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
            boolean invalid$iv = (458752 & $dirty2) == 131072;
            Object it$iv12 = $composer3.rememberedValue();
            if (invalid$iv || it$iv12 == Composer.Companion.getEmpty()) {
                Object value$iv12 = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda23
                    public final Object invoke() {
                        int UpcomingEpisodeList_beLaquY$lambda$11$0;
                        UpcomingEpisodeList_beLaquY$lambda$11$0 = UpcomingEpisodeListKt.UpcomingEpisodeList_beLaquY$lambda$11$0(pageCount3);
                        return Integer.valueOf(UpcomingEpisodeList_beLaquY$lambda$11$0);
                    }
                };
                $composer3.updateRememberedValue(value$iv12);
                it$iv12 = value$iv12;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            PagerState pagerState = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) it$iv12, $composer3, 0, 3);
            final ScrollState scrollState = ScrollKt.rememberScrollState(0, $composer3, 0, 1);
            final float f6 = f5;
            final SnapshotStateList snapshotStateList2 = calendarList3;
            final boolean z = isCurrentDayToday3;
            final String str = landingAnchorBizType3;
            final String str2 = landingAnchorBizId3;
            final UpcomingEpisodeListBaseStatusType upcomingEpisodeListBaseStatusType = statusType3;
            final List list2 = recommendData2;
            final Function0 function03 = onClickRetry4;
            final Function3 function32 = onClickDeleteCalendarCard4;
            final Function2 function27 = onReservationClick4;
            final Function2 function28 = onCancelReservationClick4;
            int $dirty4 = $dirty2;
            final Function1 function13 = onCalendarCardShow4;
            pageCount2 = pageCount3;
            final Function2 function29 = onClickCard3;
            final Function0 function04 = checkPointType4;
            final Function2 function210 = onRecommendReservationClick4;
            final Function2 function211 = onRecommendReservationAuthorClick5;
            final Function2 function212 = onCancelRecommendReservationClick3;
            final Function1 function14 = onRecommendReservationCardShow2;
            Function4 function4 = new Function4() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda24
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit UpcomingEpisodeList_beLaquY$lambda$12;
                    UpcomingEpisodeList_beLaquY$lambda$12 = UpcomingEpisodeListKt.UpcomingEpisodeList_beLaquY$lambda$12(scrollState, f6, connection, snapshotStateList2, z, str, str2, upcomingEpisodeListBaseStatusType, list2, function03, function32, function27, function28, function13, function29, listState, function04, function210, function211, function212, function14, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    return UpcomingEpisodeList_beLaquY$lambda$12;
                }
            };
            $composer2 = $composer3;
            PagerKt.HorizontalPager--8jOkeI(pagerState, modifier2, (PaddingValues) null, (PageSize) null, 0, 0.0f, (Alignment.Vertical) null, (TargetedFlingBehavior) null, false, false, (Function1) null, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(882481391, true, function4, $composer2, 54), $composer2, ($dirty4 >> 3) & 112, 24576, 16380);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            calendarList = calendarList3;
            onRecommendReservationClick = onRecommendReservationClick4;
            onRecommendReservationAuthorClick2 = onRecommendReservationAuthorClick5;
            onCancelRecommendReservationClick = onCancelRecommendReservationClick3;
            onCalendarCardShow = onCalendarCardShow4;
            onRecommendReservationAuthorClick = onClickCard3;
            checkPointType = checkPointType4;
            onRecommendReservationCardShow = onRecommendReservationCardShow2;
            recommendData = recommendData2;
            onClickDeleteCalendarCard = onClickDeleteCalendarCard4;
            onReservationClick = onReservationClick4;
            onClickRetry = onClickRetry4;
            isCurrentDayToday2 = isCurrentDayToday3;
            landingAnchorBizType2 = landingAnchorBizType3;
            landingAnchorBizId2 = landingAnchorBizId3;
            onCancelReservationClick = onCancelReservationClick4;
            statusType2 = statusType3;
            f2 = f5;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            calendarList = snapshotStateList;
            f2 = f;
            pageCount2 = pageCount;
            isCurrentDayToday2 = isCurrentDayToday;
            landingAnchorBizType2 = landingAnchorBizType;
            landingAnchorBizId2 = landingAnchorBizId;
            statusType2 = statusType;
            recommendData = list;
            onClickDeleteCalendarCard = function3;
            onReservationClick = function2;
            onCancelReservationClick = function22;
            onCalendarCardShow = function1;
            onRecommendReservationAuthorClick = function23;
            checkPointType = function0;
            onClickRetry = function02;
            onRecommendReservationClick = function24;
            onRecommendReservationAuthorClick2 = function25;
            onCancelRecommendReservationClick = function26;
            onRecommendReservationCardShow = function12;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final SnapshotStateList snapshotStateList3 = calendarList;
            final float f7 = f2;
            final int i23 = pageCount2;
            final boolean z2 = isCurrentDayToday2;
            final String str3 = landingAnchorBizType2;
            final String str4 = landingAnchorBizId2;
            final UpcomingEpisodeListBaseStatusType upcomingEpisodeListBaseStatusType2 = statusType2;
            final List list3 = recommendData;
            final Function3 function33 = onClickDeleteCalendarCard;
            final Function2 function213 = onReservationClick;
            final Function2 function214 = onCancelReservationClick;
            final Function1 function15 = onCalendarCardShow;
            final Function2 function215 = onRecommendReservationAuthorClick;
            final Function0 function05 = checkPointType;
            final Function0 function06 = onClickRetry;
            final Function2 function216 = onRecommendReservationClick;
            final Function2 function217 = onRecommendReservationAuthorClick2;
            final Function2 function218 = onCancelRecommendReservationClick;
            final Function1 function16 = onRecommendReservationCardShow;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda25
                public final Object invoke(Object obj, Object obj2) {
                    Unit UpcomingEpisodeList_beLaquY$lambda$13;
                    UpcomingEpisodeList_beLaquY$lambda$13 = UpcomingEpisodeListKt.UpcomingEpisodeList_beLaquY$lambda$13(listState, connection, modifier4, snapshotStateList3, f7, i23, z2, str3, str4, upcomingEpisodeListBaseStatusType2, list3, function33, function213, function214, function15, function215, function05, function06, function216, function217, function218, function16, $changed, $changed1, $changed2, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UpcomingEpisodeList_beLaquY$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int UpcomingEpisodeList_beLaquY$lambda$11$0(int $pageCount) {
        return $pageCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeList_beLaquY$lambda$12(ScrollState $scrollState, float f, NestedScrollConnection $connection, SnapshotStateList $calendarList, boolean $isCurrentDayToday, String $landingAnchorBizType, String $landingAnchorBizId, UpcomingEpisodeListBaseStatusType $statusType, List $recommendData, Function0 $onClickRetry, Function3 $onClickDeleteCalendarCard, Function2 $onReservationClick, Function2 $onCancelReservationClick, Function1 $onCalendarCardShow, Function2 $onClickCard, LazyListState $listState, Function0 $checkPointType, Function2 $onRecommendReservationClick, Function2 $onRecommendReservationAuthorClick, Function2 $onCancelRecommendReservationClick, Function1 $onRecommendReservationCardShow, PagerScope $this$HorizontalPager, int pageIndex, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation($composer, "CN(pageIndex)144@7011L45,141@6917L1269:UpcomingEpisodeList.kt#kr57tx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(882481391, $changed, -1, "kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeList.<anonymous> (UpcomingEpisodeList.kt:141)");
        }
        TimeAxisWithCardsLayout($connection, $calendarList, $isCurrentDayToday, $landingAnchorBizType, $landingAnchorBizId, $statusType, $recommendData, $onClickRetry, $onClickDeleteCalendarCard, $onReservationClick, $onCancelReservationClick, $onCalendarCardShow, $onClickCard, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(DefaultListModifierKt.defaultVerticalScrollableEffects(Modifier.Companion, (ScrollableState) $scrollState, $composer, 6), 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, f, 7, (Object) null), $listState, $checkPointType, $onRecommendReservationClick, $onRecommendReservationAuthorClick, $onCancelRecommendReservationClick, $onRecommendReservationCardShow, $composer, 0, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeAxisWithCardsLayout$lambda$1$0(KReserveRecommend kReserveRecommend, Function0 function0) {
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeAxisWithCardsLayout$lambda$2$0(KUpInfo kUpInfo, KReserveRecommend kReserveRecommend) {
        Intrinsics.checkNotNullParameter(kUpInfo, "<unused var>");
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeAxisWithCardsLayout$lambda$3$0(KReserveRecommend kReserveRecommend, Function0 function0) {
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeAxisWithCardsLayout$lambda$4$0(KReserveRecommend kReserveRecommend) {
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:260:0x057d, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x062c, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x0752, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x0969, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L271;
     */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0815 A[LOOP:0: B:348:0x07d8->B:359:0x0815, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0879  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0887 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:434:0x082b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TimeAxisWithCardsLayout(final NestedScrollConnection connection, final SnapshotStateList<CalendarCard> snapshotStateList, final boolean isCurrentDayToday, final String landingAnchorBizType, final String landingAnchorBizId, final UpcomingEpisodeListBaseStatusType statusType, final List<KRecommend> list, final Function0<Unit> function0, final Function3<? super KWatchBizType, ? super String, ? super Function0<Unit>, Unit> function3, final Function2<? super String, ? super Function0<Unit>, Unit> function2, final Function2<? super String, ? super Function0<Unit>, Unit> function22, final Function1<? super Map<String, String>, Unit> function1, final Function2<? super CalendarCardClickArea, ? super Map<String, String>, Unit> function23, Modifier modifier, LazyListState listState, Function0<Unit> function02, Function2<? super KReserveRecommend, ? super Function0<Unit>, Unit> function24, Function2<? super KUpInfo, ? super KReserveRecommend, Unit> function25, Function2<? super KReserveRecommend, ? super Function0<Unit>, Unit> function26, Function1<? super KReserveRecommend, Unit> function12, Composer $composer, final int $changed, final int $changed1, final int i) {
        int $dirty;
        Modifier modifier2;
        LazyListState listState2;
        final Function0 checkPointType;
        final Function2 onRecommendReservationClick;
        final Function2 onRecommendReservationAuthorClick;
        Function2 onCancelRecommendReservationClick;
        Function1<? super KReserveRecommend, Unit> function13;
        final LazyListState listState3;
        Modifier modifier3;
        Function0 checkPointType2;
        Function0 checkPointType3;
        Function2 onRecommendReservationClick2;
        Function2 onRecommendReservationClick3;
        Function2 onRecommendReservationAuthorClick2;
        Function2 onRecommendReservationAuthorClick3;
        Function2 onCancelRecommendReservationClick2;
        Function0 checkPointType4;
        Function2 onRecommendReservationClick4;
        int $dirty1;
        Modifier modifier4;
        Function2 onRecommendReservationAuthorClick4;
        Object value$iv;
        Pair pair;
        String stringResource;
        LazyListState listState4;
        String buttonText;
        List items;
        KThreeMoreInfo.KThreeMoreItem kThreeMoreItem;
        List items2;
        KThreeMoreInfo.KThreeMoreItem kThreeMoreItem2;
        boolean z;
        boolean invalid$iv;
        Object it$iv;
        Object value$iv2;
        State visibleItemsIndices$delegate;
        boolean z2;
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(snapshotStateList, "calendarList");
        Intrinsics.checkNotNullParameter(statusType, "statusType");
        Intrinsics.checkNotNullParameter(list, "recommendData");
        Intrinsics.checkNotNullParameter(function0, "onClickRetry");
        Intrinsics.checkNotNullParameter(function3, "onClickDeleteCalendarCard");
        Intrinsics.checkNotNullParameter(function2, "onReservationClick");
        Intrinsics.checkNotNullParameter(function22, "onCancelReservationClick");
        Intrinsics.checkNotNullParameter(function1, "onCalendarCardShow");
        Intrinsics.checkNotNullParameter(function23, "onClickCard");
        Composer $composer2 = $composer.startRestartGroup(-1340349217);
        ComposerKt.sourceInformation($composer2, "C(TimeAxisWithCardsLayout)N(connection,calendarList,isCurrentDayToday,landingAnchorBizType,landingAnchorBizId,statusType,recommendData,onClickRetry,onClickDeleteCalendarCard,onReservationClick,onCancelReservationClick,onCalendarCardShow,onClickCard,modifier,listState,checkPointType,onRecommendReservationClick,onRecommendReservationAuthorClick,onCancelRecommendReservationClick,onRecommendReservationCardShow)215@10293L23,218@10409L126,222@10552L24,223@10616L43,224@10693L83,225@10806L7,226@10853L33,228@10919L312,238@11254L37,245@11434L13810,240@11306L13938,547@26290L205,531@25774L352,528@25678L824:UpcomingEpisodeList.kt#kr57tx");
        int $dirty2 = $changed;
        int $dirty12 = $changed1;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(connection) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(snapshotStateList) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(isCurrentDayToday) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(landingAnchorBizType) ? 2048 : 1024;
        }
        int i2 = 8192;
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changed(landingAnchorBizId) ? 16384 : 8192;
        }
        if (($changed & 196608) == 0) {
            $dirty2 |= $composer2.changed(statusType.ordinal()) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changedInstance(list) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 67108864 : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty12 |= $composer2.changedInstance(function22) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty12 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            $dirty12 |= $composer2.changedInstance(function23) ? 256 : 128;
        }
        int $dirty13 = $dirty12;
        int i3 = i & 8192;
        if (i3 != 0) {
            $dirty13 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty13 |= $composer2.changed(modifier) ? 2048 : 1024;
        }
        if (($changed1 & 24576) == 0) {
            if ((i & 16384) == 0 && $composer2.changed(listState)) {
                i2 = 16384;
            }
            $dirty13 |= i2;
        }
        int i4 = i & 32768;
        if (i4 != 0) {
            $dirty13 |= 196608;
        } else if (($changed1 & 196608) == 0) {
            $dirty13 |= $composer2.changedInstance(function02) ? 131072 : 65536;
        }
        int i5 = i & 65536;
        if (i5 != 0) {
            $dirty13 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty13 |= $composer2.changedInstance(function24) ? 1048576 : 524288;
        }
        int i6 = i & 131072;
        if (i6 != 0) {
            $dirty13 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty13 |= $composer2.changedInstance(function25) ? 8388608 : 4194304;
        }
        int i7 = i & 262144;
        if (i7 != 0) {
            $dirty13 |= 100663296;
        } else if (($changed1 & 100663296) == 0) {
            $dirty13 |= $composer2.changedInstance(function26) ? 67108864 : 33554432;
        }
        int i8 = i & 524288;
        if (i8 != 0) {
            $dirty13 |= 805306368;
        } else if (($changed1 & 805306368) == 0) {
            $dirty13 |= $composer2.changedInstance(function12) ? 536870912 : 268435456;
        }
        if ($composer2.shouldExecute((($dirty2 & 306783379) == 306783378 && (306783379 & $dirty13) == 306783378) ? false : true, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "187@9084L23,188@9142L2,189@9249L11,190@9354L11,191@9476L11,192@9561L8");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier modifier5 = i3 != 0 ? (Modifier) Modifier.Companion : modifier;
                if ((i & 16384) != 0) {
                    listState3 = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
                    $dirty13 &= -57345;
                } else {
                    listState3 = listState;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 414619873, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    modifier3 = modifier5;
                    Object it$iv2 = $composer2.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        value$iv = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda9
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv2;
                    }
                    checkPointType2 = (Function0) value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    modifier3 = modifier5;
                    checkPointType2 = function02;
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 414623306, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    checkPointType3 = checkPointType2;
                    Object it$iv3 = $composer2.rememberedValue();
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda11
                            public final Object invoke(Object obj, Object obj2) {
                                Unit TimeAxisWithCardsLayout$lambda$1$0;
                                TimeAxisWithCardsLayout$lambda$1$0 = UpcomingEpisodeListKt.TimeAxisWithCardsLayout$lambda$1$0((KReserveRecommend) obj, (Function0) obj2);
                                return TimeAxisWithCardsLayout$lambda$1$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    onRecommendReservationClick2 = (Function2) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    checkPointType3 = checkPointType2;
                    onRecommendReservationClick2 = function24;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 414626666, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    onRecommendReservationClick3 = onRecommendReservationClick2;
                    Object it$iv4 = $composer2.rememberedValue();
                    if (it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda12
                            public final Object invoke(Object obj, Object obj2) {
                                Unit TimeAxisWithCardsLayout$lambda$2$0;
                                TimeAxisWithCardsLayout$lambda$2$0 = UpcomingEpisodeListKt.TimeAxisWithCardsLayout$lambda$2$0((KUpInfo) obj, (KReserveRecommend) obj2);
                                return TimeAxisWithCardsLayout$lambda$2$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv4);
                        it$iv4 = value$iv4;
                    }
                    onRecommendReservationAuthorClick2 = (Function2) it$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    onRecommendReservationClick3 = onRecommendReservationClick2;
                    onRecommendReservationAuthorClick2 = function25;
                }
                if (i7 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 414630570, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    onRecommendReservationAuthorClick3 = onRecommendReservationAuthorClick2;
                    Object it$iv5 = $composer2.rememberedValue();
                    if (it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda13
                            public final Object invoke(Object obj, Object obj2) {
                                Unit TimeAxisWithCardsLayout$lambda$3$0;
                                TimeAxisWithCardsLayout$lambda$3$0 = UpcomingEpisodeListKt.TimeAxisWithCardsLayout$lambda$3$0((KReserveRecommend) obj, (Function0) obj2);
                                return TimeAxisWithCardsLayout$lambda$3$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv5);
                        it$iv5 = value$iv5;
                    }
                    onCancelRecommendReservationClick2 = (Function2) it$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    onRecommendReservationAuthorClick3 = onRecommendReservationAuthorClick2;
                    onCancelRecommendReservationClick2 = function26;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 414633287, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    Function2 onCancelRecommendReservationClick3 = onCancelRecommendReservationClick2;
                    Object it$iv6 = $composer2.rememberedValue();
                    if (it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function1() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda14
                            public final Object invoke(Object obj) {
                                Unit TimeAxisWithCardsLayout$lambda$4$0;
                                TimeAxisWithCardsLayout$lambda$4$0 = UpcomingEpisodeListKt.TimeAxisWithCardsLayout$lambda$4$0((KReserveRecommend) obj);
                                return TimeAxisWithCardsLayout$lambda$4$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv6);
                        it$iv6 = value$iv6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    checkPointType4 = checkPointType3;
                    onRecommendReservationClick4 = onRecommendReservationClick3;
                    onCancelRecommendReservationClick = onCancelRecommendReservationClick3;
                    function13 = (Function1) it$iv6;
                    $dirty1 = $dirty13;
                    modifier4 = modifier3;
                    onRecommendReservationAuthorClick4 = onRecommendReservationAuthorClick3;
                } else {
                    checkPointType4 = checkPointType3;
                    onRecommendReservationClick4 = onRecommendReservationClick3;
                    onCancelRecommendReservationClick = onCancelRecommendReservationClick2;
                    function13 = function12;
                    $dirty1 = $dirty13;
                    modifier4 = modifier3;
                    onRecommendReservationAuthorClick4 = onRecommendReservationAuthorClick3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16384) != 0) {
                    $dirty13 &= -57345;
                }
                modifier4 = modifier;
                listState3 = listState;
                checkPointType4 = function02;
                onRecommendReservationClick4 = function24;
                onCancelRecommendReservationClick = function26;
                function13 = function12;
                $dirty1 = $dirty13;
                onRecommendReservationAuthorClick4 = function25;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1340349217, $dirty2, $dirty1, "kntr.app.upcomingEpisode.list.ui.TimeAxisWithCardsLayout (UpcomingEpisodeList.kt:193)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[statusType.ordinal()]) {
                case 1:
                    pair = new Pair(String0_commonMainKt.getWatching_global_string_33(Res.string.INSTANCE), null);
                    break;
                case 2:
                    pair = new Pair(String0_commonMainKt.getWatching_global_string_30(Res.string.INSTANCE), null);
                    break;
                case 3:
                    pair = new Pair(String0_commonMainKt.getWatching_global_string_31(Res.string.INSTANCE), String0_commonMainKt.getWatching_global_string_32(Res.string.INSTANCE));
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            StringResource textRes = (StringResource) pair.component1();
            StringResource buttonTextRes = (StringResource) pair.component2();
            checkPointType = checkPointType4;
            final String statusText = StringResourcesKt.stringResource(textRes, $composer2, 0);
            if (buttonTextRes == null) {
                $composer2.startReplaceGroup(-30483768);
                $composer2.endReplaceGroup();
                stringResource = null;
            } else {
                $composer2.startReplaceGroup(-30483767);
                ComposerKt.sourceInformation($composer2, "*216@10359L18");
                stringResource = StringResourcesKt.stringResource(buttonTextRes, $composer2, 0);
                $composer2.endReplaceGroup();
            }
            final String buttonText2 = stringResource;
            final SheetState sheetState = BottomSheetScaffoldKt.rememberStandardBottomSheetState(SheetValue.Hidden, (Function1) null, false, $composer2, 390, 2);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            onRecommendReservationClick = onRecommendReservationClick4;
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            onRecommendReservationAuthorClick = onRecommendReservationAuthorClick4;
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 414667082, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
            Object it$iv7 = $composer2.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv7 = SnapshotStateKt.mutableStateOf$default(new CalendarCard(null, null, 0L, null, null, null, null, null, null, null, null, false, null, null, null, null, null, 131071, null), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            final MutableState lastClickCard$delegate = (MutableState) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 414669586, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 112) == 32;
            Object it$iv8 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv8 = SnapshotIntStateKt.mutableIntStateOf(UpcomingEpisodeExtensionsKt.getLatestUpcomingIndex((List) snapshotStateList));
            $composer2.updateRememberedValue(value$iv8);
            it$iv8 = value$iv8;
            final MutableIntState latestUpcomingEpIndex$delegate = (MutableIntState) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Router router = (Router) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 414674656, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
            Object value$iv9 = $composer2.rememberedValue();
            if (value$iv9 == Composer.Companion.getEmpty()) {
                value$iv9 = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv9);
            }
            MutableState shouldScrollToAnchorContent$delegate = (MutableState) value$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 414677047, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
            boolean invalid$iv3 = (((57344 & $dirty1) ^ 24576) > 16384 && $composer2.changed(listState3)) || ($dirty1 & 24576) == 16384;
            Object it$iv9 = $composer2.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv10 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda15
                public final Object invoke() {
                    IntRange TimeAxisWithCardsLayout$lambda$14$0;
                    TimeAxisWithCardsLayout$lambda$14$0 = UpcomingEpisodeListKt.TimeAxisWithCardsLayout$lambda$14$0(listState3);
                    return TimeAxisWithCardsLayout$lambda$14$0;
                }
            });
            $composer2.updateRememberedValue(value$iv10);
            it$iv9 = value$iv10;
            final State visibleItemsIndices$delegate2 = (State) it$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 414687492, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
            Object it$iv10 = $composer2.rememberedValue();
            if (it$iv10 == Composer.Companion.getEmpty()) {
                Object value$iv11 = SnapshotStateKt.mutableStateSetOf();
                $composer2.updateRememberedValue(value$iv11);
                it$iv10 = value$iv11;
            }
            final SnapshotStateSet reportedSet = (SnapshotStateSet) it$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyListState listState5 = listState3;
            Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifier4, connection, (NestedScrollDispatcher) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 414707025, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
            modifier2 = modifier4;
            boolean invalid$iv4 = (($dirty1 & 112) == 32) | (($dirty2 & 112) == 32) | $composer2.changed(visibleItemsIndices$delegate2) | $composer2.changed(latestUpcomingEpIndex$delegate) | (($dirty2 & 896) == 256) | (($dirty1 & 896) == 256) | $composer2.changedInstance(router) | $composer2.changedInstance(scope) | $composer2.changed(sheetState) | ((1879048192 & $dirty2) == 536870912) | (($dirty1 & 14) == 4) | ((458752 & $dirty2) == 131072) | $composer2.changed(statusText) | ((29360128 & $dirty2) == 8388608) | $composer2.changed(buttonText2) | $composer2.changedInstance(list) | ((1879048192 & $dirty1) == 536870912) | ((29360128 & $dirty1) == 8388608) | ((3670016 & $dirty1) == 1048576) | ((234881024 & $dirty1) == 67108864);
            Object it$iv11 = $composer2.rememberedValue();
            if (invalid$iv4) {
            }
            final Function1<? super KReserveRecommend, Unit> function14 = function13;
            final Function2 function27 = onCancelRecommendReservationClick;
            Object value$iv12 = new Function1() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj) {
                    Unit TimeAxisWithCardsLayout$lambda$17$0;
                    TimeAxisWithCardsLayout$lambda$17$0 = UpcomingEpisodeListKt.TimeAxisWithCardsLayout$lambda$17$0(snapshotStateList, list, function1, isCurrentDayToday, visibleItemsIndices$delegate2, latestUpcomingEpIndex$delegate, function23, router, scope, sheetState, function2, function22, lastClickCard$delegate, statusType, statusText, function0, buttonText2, reportedSet, function14, onRecommendReservationAuthorClick, onRecommendReservationClick, function27, (LazyListScope) obj);
                    return TimeAxisWithCardsLayout$lambda$17$0;
                }
            };
            $composer2.updateRememberedValue(value$iv12);
            it$iv11 = value$iv12;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(nestedScroll$default, listState5, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv11, $composer2, ($dirty1 >> 9) & 112, 508);
            if (TimeAxisWithCardsLayout$lambda$12(shouldScrollToAnchorContent$delegate)) {
                $composer2.startReplaceGroup(-15662884);
                ComposerKt.sourceInformation($composer2, "");
                MutableState shouldScrollToAnchorContent$delegate2 = shouldScrollToAnchorContent$delegate;
                TimeAxisWithCardsLayout$lambda$13(shouldScrollToAnchorContent$delegate2, false);
                List $this$indexOfFirst$iv = (List) snapshotStateList;
                int index$iv = 0;
                Iterator it = $this$indexOfFirst$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object item$iv = it.next();
                        CalendarCard it2 = (CalendarCard) item$iv;
                        MutableState shouldScrollToAnchorContent$delegate3 = shouldScrollToAnchorContent$delegate2;
                        MutableIntState latestUpcomingEpIndex$delegate2 = latestUpcomingEpIndex$delegate;
                        if (Intrinsics.areEqual(landingAnchorBizId, it2.getBizId())) {
                            visibleItemsIndices$delegate = visibleItemsIndices$delegate2;
                            if (Intrinsics.areEqual(landingAnchorBizType, UpcomingEpisodeExtensionsKt.toAnchorBizTypeString(it2.getBizType()))) {
                                z2 = true;
                                if (z2) {
                                    index$iv++;
                                    latestUpcomingEpIndex$delegate = latestUpcomingEpIndex$delegate2;
                                    visibleItemsIndices$delegate2 = visibleItemsIndices$delegate;
                                    shouldScrollToAnchorContent$delegate2 = shouldScrollToAnchorContent$delegate3;
                                }
                            }
                        } else {
                            visibleItemsIndices$delegate = visibleItemsIndices$delegate2;
                        }
                        z2 = false;
                        if (z2) {
                        }
                    } else {
                        index$iv = -1;
                    }
                }
                int targetIndex = index$iv;
                if (targetIndex != -1) {
                    $composer2.startReplaceGroup(-15407444);
                    ComposerKt.sourceInformation($composer2, "523@25583L74,523@25562L95");
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, 415146057, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                    if (((57344 & $dirty1) ^ 24576) > 16384) {
                        listState4 = listState5;
                        if ($composer2.changed(listState4)) {
                            z = true;
                            invalid$iv = z | $composer2.changed(targetIndex);
                            it$iv = $composer2.rememberedValue();
                            if (invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                                value$iv2 = it$iv;
                                buttonText = null;
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                EffectsKt.LaunchedEffect(unit, (Function2) value$iv2, $composer2, 6);
                            }
                            buttonText = null;
                            value$iv2 = (Function2) new UpcomingEpisodeListKt$TimeAxisWithCardsLayout$7$1(listState4, targetIndex, null);
                            $composer2.updateRememberedValue(value$iv2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            EffectsKt.LaunchedEffect(unit, (Function2) value$iv2, $composer2, 6);
                        }
                    } else {
                        listState4 = listState5;
                    }
                    if (($dirty1 & 24576) != 16384) {
                        z = false;
                        invalid$iv = z | $composer2.changed(targetIndex);
                        it$iv = $composer2.rememberedValue();
                        if (invalid$iv) {
                            value$iv2 = it$iv;
                            buttonText = null;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            EffectsKt.LaunchedEffect(unit, (Function2) value$iv2, $composer2, 6);
                        }
                        buttonText = null;
                        value$iv2 = (Function2) new UpcomingEpisodeListKt$TimeAxisWithCardsLayout$7$1(listState4, targetIndex, null);
                        $composer2.updateRememberedValue(value$iv2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(unit, (Function2) value$iv2, $composer2, 6);
                    }
                    z = true;
                    invalid$iv = z | $composer2.changed(targetIndex);
                    it$iv = $composer2.rememberedValue();
                    if (invalid$iv) {
                    }
                    buttonText = null;
                    value$iv2 = (Function2) new UpcomingEpisodeListKt$TimeAxisWithCardsLayout$7$1(listState4, targetIndex, null);
                    $composer2.updateRememberedValue(value$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(unit, (Function2) value$iv2, $composer2, 6);
                } else {
                    listState4 = listState5;
                    buttonText = null;
                    $composer2.startReplaceGroup(-40755741);
                }
                $composer2.endReplaceGroup();
            } else {
                listState4 = listState5;
                buttonText = null;
                $composer2.startReplaceGroup(-40755741);
            }
            $composer2.endReplaceGroup();
            KThreeMoreInfo threeMoreInfo = TimeAxisWithCardsLayout$lambda$7(lastClickCard$delegate).getThreeMoreInfo();
            String text = (threeMoreInfo == null || (items2 = threeMoreInfo.getItems()) == null || (kThreeMoreItem2 = (KThreeMoreInfo.KThreeMoreItem) CollectionsKt.firstOrNull(items2)) == null) ? buttonText : kThreeMoreItem2.getText();
            KThreeMoreInfo threeMoreInfo2 = TimeAxisWithCardsLayout$lambda$7(lastClickCard$delegate).getThreeMoreInfo();
            if (threeMoreInfo2 != null && (items = threeMoreInfo2.getItems()) != null && (kThreeMoreItem = (KThreeMoreInfo.KThreeMoreItem) CollectionsKt.firstOrNull(items)) != null) {
                buttonText = kThreeMoreItem.getIcon();
            }
            if (buttonText == null) {
                buttonText = "";
            }
            Painter rememberIconFontPainter = BiliIconfontKt.rememberIconFontPainter(buttonText, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 415152447, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
            boolean invalid$iv5 = ((234881024 & $dirty2) == 67108864) | ((458752 & $dirty1) == 131072) | (($dirty1 & 896) == 256) | $composer2.changedInstance(scope) | $composer2.changed(sheetState);
            Object it$iv12 = $composer2.rememberedValue();
            if (invalid$iv5) {
                $dirty = $dirty2;
            } else {
                $dirty = $dirty2;
            }
            Object value$iv13 = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda17
                public final Object invoke() {
                    Unit TimeAxisWithCardsLayout$lambda$20$0;
                    TimeAxisWithCardsLayout$lambda$20$0 = UpcomingEpisodeListKt.TimeAxisWithCardsLayout$lambda$20$0(function3, function23, scope, lastClickCard$delegate, checkPointType, sheetState);
                    return TimeAxisWithCardsLayout$lambda$20$0;
                }
            };
            $composer2.updateRememberedValue(value$iv13);
            it$iv12 = value$iv13;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ThreePointDialogKt.ThreePointDialog(null, sheetState, text, rememberIconFontPainter, (Function0) it$iv12, $composer2, Painter.$stable << 9, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            listState2 = listState4;
        } else {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            listState2 = listState;
            checkPointType = function02;
            onRecommendReservationClick = function24;
            onRecommendReservationAuthorClick = function25;
            onCancelRecommendReservationClick = function26;
            function13 = function12;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final LazyListState lazyListState = listState2;
            final Function0 function03 = checkPointType;
            final Function2 function28 = onRecommendReservationClick;
            final Function2 function29 = onRecommendReservationAuthorClick;
            final Function2 function210 = onCancelRecommendReservationClick;
            final Function1<? super KReserveRecommend, Unit> function15 = function13;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit TimeAxisWithCardsLayout$lambda$21;
                    TimeAxisWithCardsLayout$lambda$21 = UpcomingEpisodeListKt.TimeAxisWithCardsLayout$lambda$21(connection, snapshotStateList, isCurrentDayToday, landingAnchorBizType, landingAnchorBizId, statusType, list, function0, function3, function2, function22, function1, function23, modifier6, lazyListState, function03, function28, function29, function210, function15, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TimeAxisWithCardsLayout$lambda$21;
                }
            });
        }
    }

    private static final CalendarCard TimeAxisWithCardsLayout$lambda$7(MutableState<CalendarCard> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (CalendarCard) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int TimeAxisWithCardsLayout$lambda$10(MutableIntState $latestUpcomingEpIndex$delegate) {
        IntState $this$getValue$iv = (IntState) $latestUpcomingEpIndex$delegate;
        return $this$getValue$iv.getIntValue();
    }

    private static final boolean TimeAxisWithCardsLayout$lambda$12(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void TimeAxisWithCardsLayout$lambda$13(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRange TimeAxisWithCardsLayout$lambda$15(State<IntRange> state) {
        Object thisObj$iv = state.getValue();
        return (IntRange) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRange TimeAxisWithCardsLayout$lambda$14$0(LazyListState $listState) {
        List visibleItems = $listState.getLayoutInfo().getVisibleItemsInfo();
        if (!visibleItems.isEmpty()) {
            return new IntRange(((LazyListItemInfo) CollectionsKt.first(visibleItems)).getIndex(), ((LazyListItemInfo) CollectionsKt.last(visibleItems)).getIndex());
        }
        return IntRange.Companion.getEMPTY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeAxisWithCardsLayout$lambda$17$0(final SnapshotStateList $calendarList, final List $recommendData, final Function1 $onCalendarCardShow, final boolean $isCurrentDayToday, final State $visibleItemsIndices$delegate, final MutableIntState $latestUpcomingEpIndex$delegate, final Function2 $onClickCard, final Router $router, final CoroutineScope $scope, final SheetState $sheetState, final Function2 $onReservationClick, final Function2 $onCancelReservationClick, final MutableState $lastClickCard$delegate, final UpcomingEpisodeListBaseStatusType $statusType, final String $statusText, final Function0 $onClickRetry, final String $buttonText, final SnapshotStateSet $reportedSet, final Function1 $onRecommendReservationCardShow, final Function2 $onRecommendReservationAuthorClick, final Function2 $onRecommendReservationClick, final Function2 $onCancelRecommendReservationClick, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final List items$iv = (List) $calendarList;
        final Function2 key$iv = new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2) {
                Object TimeAxisWithCardsLayout$lambda$17$0$0;
                TimeAxisWithCardsLayout$lambda$17$0$0 = UpcomingEpisodeListKt.TimeAxisWithCardsLayout$lambda$17$0$0(((Integer) obj).intValue(), (CalendarCard) obj2);
                return TimeAxisWithCardsLayout$lambda$17$0$0;
            }
        };
        $this$LazyColumn.items(items$iv.size(), new Function1<Integer, Object>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$lambda$17$0$$inlined$itemsIndexed$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return key$iv.invoke(Integer.valueOf(index), items$iv.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$lambda$17$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                items$iv.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$lambda$17$0$$inlined$itemsIndexed$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:100:0x0567 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:96:0x0559  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Composer $composer2;
                Function0 factory$iv$iv$iv;
                IntRange TimeAxisWithCardsLayout$lambda$15;
                boolean z;
                int TimeAxisWithCardsLayout$lambda$10;
                FontWeight fontWeight;
                long j;
                Function0 factory$iv$iv$iv2;
                Composer $composer3;
                Composer $composer$iv;
                Composer $composer$iv2;
                Composer $composer4;
                Composer $composer5;
                Composer $composer6;
                Composer $composer7;
                Composer $composer8;
                int $changed$iv;
                Object value$iv;
                boolean invalid$iv;
                Object it$iv;
                boolean invalid$iv2;
                boolean invalid$iv3;
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
                    final CalendarCard calendar = (CalendarCard) items$iv.get(it);
                    $composer.startReplaceGroup(-708392477);
                    ComposerKt.sourceInformation($composer, "CN(index,calendar)*252@11674L28,254@11783L45:UpcomingEpisodeList.kt#kr57tx");
                    CardUiType cardUiType = UpcomingEpisodeUtilsKt.rememberCardUiType(calendar, false, $composer, ($changed2 >> 6) & 14, 2);
                    calendar.getCardUiType().setValue(cardUiType);
                    CardUiType timeUiType = UpcomingEpisodeUtilsKt.rememberCardUiType(calendar, true, $composer, (($changed2 >> 6) & 14) | 48, 0);
                    if (((Boolean) calendar.getShouldCardShow().getValue()).booleanValue()) {
                        $composer.startReplaceGroup(-708182019);
                        ComposerKt.sourceInformation($composer, "256@11894L7663");
                        Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(136));
                        ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        int $changed$iv$iv = (6 << 3) & 112;
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
                        ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        int i2 = ((6 >> 6) & 112) | 6;
                        RowScope $this$TimeAxisWithCardsLayout_u24lambda_u2417_u240_u241_u240 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer, -1600810891, "C266@12319L420,275@12788L928,295@13737L147,300@13905L5465,392@19391L148:UpcomingEpisodeList.kt#kr57tx");
                        TimeAxisWithCardsLayout$lambda$15 = UpcomingEpisodeListKt.TimeAxisWithCardsLayout$lambda$15($visibleItemsIndices$delegate);
                        if (!(it <= TimeAxisWithCardsLayout$lambda$15.getLast() && TimeAxisWithCardsLayout$lambda$15.getFirst() <= it) || calendar.getHasReportCardShow()) {
                            z = true;
                        } else {
                            $onCalendarCardShow.invoke(calendar.getReport());
                            z = true;
                            calendar.setHasReportCardShow(true);
                        }
                        boolean z2 = it == 0 ? z : false;
                        Modifier modifier = SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24));
                        TimeAxisWithCardsLayout$lambda$10 = UpcomingEpisodeListKt.TimeAxisWithCardsLayout$lambda$10($latestUpcomingEpIndex$delegate);
                        UpcomingEpisodeListKt.TimeAxisItem(cardUiType, z2, TimeAxisWithCardsLayout$lambda$10 == it, it == CollectionsKt.getLastIndex($calendarList), $isCurrentDayToday, modifier, $composer, 196608, 0);
                        String convertTimestampToString = UpcomingEpisodeExtensionsKt.convertTimestampToString(calendar.getAnchorTime());
                        if (timeUiType == CardUiType.TYPE_HIGHLIGHT) {
                            fontWeight = new FontWeight(500);
                        } else {
                            fontWeight = new FontWeight(300);
                        }
                        if (timeUiType == CardUiType.TYPE_HIGHLIGHT) {
                            $composer.startReplaceGroup(-1021439044);
                            ComposerKt.sourceInformation($composer, "285@13297L6");
                            j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU();
                        } else {
                            $composer.startReplaceGroup(-1021438148);
                            ComposerKt.sourceInformation($composer, "285@13325L6");
                            j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU();
                        }
                        $composer.endReplaceGroup();
                        TextKt.Text-Nvy7gAk(convertTimestampToString, PaddingKt.padding-qDBjuR0$default($this$TimeAxisWithCardsLayout_u24lambda_u2417_u240_u241_u240.align(SizeKt.wrapContentSize$default(Modifier.Companion, (Alignment) null, false, 3, (Object) null), Alignment.Companion.getTop()), 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null), j, (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, fontWeight, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(17), 0, false, 1, 0, (Function1) null, (TextStyle) null, $composer, 24576, 24624, 243624);
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
                        Modifier modifier$iv2 = $this$TimeAxisWithCardsLayout_u24lambda_u2417_u240_u241_u240.align(RowScope.-CC.weight$default($this$TimeAxisWithCardsLayout_u24lambda_u2417_u240_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Alignment.Companion.getCenterVertically());
                        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i4 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, 340498076, "C:UpcomingEpisodeList.kt#kr57tx");
                        KCalendarCardType calendarCardType = calendar.getCalendarCardType();
                        if (Intrinsics.areEqual(calendarCardType, KCalendarCardType.CALENDAR_CARD_TYPE_ARCHIVE.INSTANCE)) {
                            $composer3 = $composer;
                            $composer$iv = $composer;
                            $composer$iv2 = $composer;
                            $composer4 = $composer;
                            $composer5 = $composer;
                        } else if (Intrinsics.areEqual(calendarCardType, KCalendarCardType.CALENDAR_CARD_TYPE_LIVE.INSTANCE)) {
                            $composer3 = $composer;
                            $composer$iv = $composer;
                            $composer$iv2 = $composer;
                            $composer4 = $composer;
                            $composer5 = $composer;
                        } else {
                            if (Intrinsics.areEqual(calendarCardType, KCalendarCardType.CALENDAR_CARD_TYPE_RESERVE.INSTANCE)) {
                                $composer.startReplaceGroup(342413720);
                                ComposerKt.sourceInformation($composer, "342@16490L235,346@16784L490,354@17339L634,338@16176L1913");
                                KUpInfo upInfo = calendar.getUpInfo();
                                KReserveCardInfo reserveCardInfo = calendar.getReserveCardInfo();
                                long longValue = ((Number) calendar.getReservedCount().getValue()).longValue();
                                boolean booleanValue = ((Boolean) calendar.getHasCardReserved().getValue()).booleanValue();
                                ComposerKt.sourceInformationMarkerStart($composer, -1928608676, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                                boolean invalid$iv4 = $composer.changed($onClickCard) | $composer.changedInstance(calendar) | $composer.changedInstance($router);
                                Object it$iv2 = $composer.rememberedValue();
                                if (!invalid$iv4 && it$iv2 != Composer.Companion.getEmpty()) {
                                    Function0 function0 = (Function0) it$iv2;
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerStart($composer, -1928599013, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                                    invalid$iv2 = $composer.changed($onReservationClick) | $composer.changedInstance(calendar) | $composer.changed($onClickCard);
                                    Object it$iv3 = $composer.rememberedValue();
                                    if (!invalid$iv2 && it$iv3 != Composer.Companion.getEmpty()) {
                                        Function0 function02 = (Function0) it$iv3;
                                        ComposerKt.sourceInformationMarkerEnd($composer);
                                        ComposerKt.sourceInformationMarkerStart($composer, -1928581109, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                                        invalid$iv3 = $composer.changed($onCancelReservationClick) | $composer.changedInstance(calendar) | $composer.changed($onClickCard);
                                        Object it$iv4 = $composer.rememberedValue();
                                        if (!invalid$iv3 && it$iv4 != Composer.Companion.getEmpty()) {
                                            ComposerKt.sourceInformationMarkerEnd($composer);
                                            UpcomingEpisodeReservationCardKt.UpcomingEpisodeReservationCard(upInfo, reserveCardInfo, null, longValue, booleanValue, function0, function02, (Function0) it$iv4, $composer, 0, 4);
                                            $composer.endReplaceGroup();
                                            $composer3 = $composer;
                                            $composer$iv = $composer;
                                            $composer$iv2 = $composer;
                                            $composer4 = $composer;
                                            $composer6 = $composer;
                                        }
                                        final Function2 function2 = $onCancelReservationClick;
                                        final Function2 function22 = $onClickCard;
                                        Object value$iv2 = (Function0) new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$6$1
                                            public /* bridge */ /* synthetic */ Object invoke() {
                                                m1281invoke();
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke  reason: collision with other method in class */
                                            public final void m1281invoke() {
                                                Function2<String, Function0<Unit>, Unit> function23 = function2;
                                                String bizId = calendar.getBizId();
                                                final CalendarCard calendarCard = calendar;
                                                function23.invoke(bizId, new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$6$1.1
                                                    public /* bridge */ /* synthetic */ Object invoke() {
                                                        m1282invoke();
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke  reason: collision with other method in class */
                                                    public final void m1282invoke() {
                                                        CalendarCard.this.getHasCardReserved().setValue(Boolean.valueOf(!((Boolean) CalendarCard.this.getHasCardReserved().getValue()).booleanValue()));
                                                        MutableState<Long> reservedCount = CalendarCard.this.getReservedCount();
                                                        reservedCount.setValue(Long.valueOf(((Number) reservedCount.getValue()).longValue() - 1));
                                                    }
                                                });
                                                function22.invoke(CalendarCardClickArea.CANCEL_RESERVE, calendar.getReport());
                                            }
                                        };
                                        $composer.updateRememberedValue(value$iv2);
                                        it$iv4 = value$iv2;
                                        ComposerKt.sourceInformationMarkerEnd($composer);
                                        UpcomingEpisodeReservationCardKt.UpcomingEpisodeReservationCard(upInfo, reserveCardInfo, null, longValue, booleanValue, function0, function02, (Function0) it$iv4, $composer, 0, 4);
                                        $composer.endReplaceGroup();
                                        $composer3 = $composer;
                                        $composer$iv = $composer;
                                        $composer$iv2 = $composer;
                                        $composer4 = $composer;
                                        $composer6 = $composer;
                                    }
                                    final Function2 function23 = $onReservationClick;
                                    final Function2 function24 = $onClickCard;
                                    Object value$iv3 = (Function0) new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$5$1
                                        public /* bridge */ /* synthetic */ Object invoke() {
                                            m1279invoke();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: collision with other method in class */
                                        public final void m1279invoke() {
                                            Function2<String, Function0<Unit>, Unit> function25 = function23;
                                            String bizId = calendar.getBizId();
                                            final CalendarCard calendarCard = calendar;
                                            function25.invoke(bizId, new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$5$1.1
                                                public /* bridge */ /* synthetic */ Object invoke() {
                                                    m1280invoke();
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: collision with other method in class */
                                                public final void m1280invoke() {
                                                    CalendarCard.this.getHasCardReserved().setValue(Boolean.valueOf(!((Boolean) CalendarCard.this.getHasCardReserved().getValue()).booleanValue()));
                                                    MutableState<Long> reservedCount = CalendarCard.this.getReservedCount();
                                                    reservedCount.setValue(Long.valueOf(((Number) reservedCount.getValue()).longValue() + 1));
                                                }
                                            });
                                            function24.invoke(CalendarCardClickArea.RESERVE, calendar.getReport());
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv3);
                                    it$iv3 = value$iv3;
                                    Function0 function022 = (Function0) it$iv3;
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerStart($composer, -1928581109, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                                    invalid$iv3 = $composer.changed($onCancelReservationClick) | $composer.changedInstance(calendar) | $composer.changed($onClickCard);
                                    Object it$iv42 = $composer.rememberedValue();
                                    if (!invalid$iv3) {
                                        ComposerKt.sourceInformationMarkerEnd($composer);
                                        UpcomingEpisodeReservationCardKt.UpcomingEpisodeReservationCard(upInfo, reserveCardInfo, null, longValue, booleanValue, function0, function022, (Function0) it$iv42, $composer, 0, 4);
                                        $composer.endReplaceGroup();
                                        $composer3 = $composer;
                                        $composer$iv = $composer;
                                        $composer$iv2 = $composer;
                                        $composer4 = $composer;
                                        $composer6 = $composer;
                                    }
                                    final Function2<? super String, ? super Function0<Unit>, Unit> function25 = $onCancelReservationClick;
                                    final Function2<? super CalendarCardClickArea, ? super Map<String, String>, Unit> function222 = $onClickCard;
                                    Object value$iv22 = (Function0) new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$6$1
                                        public /* bridge */ /* synthetic */ Object invoke() {
                                            m1281invoke();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: collision with other method in class */
                                        public final void m1281invoke() {
                                            Function2<String, Function0<Unit>, Unit> function232 = function25;
                                            String bizId = calendar.getBizId();
                                            final CalendarCard calendarCard = calendar;
                                            function232.invoke(bizId, new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$6$1.1
                                                public /* bridge */ /* synthetic */ Object invoke() {
                                                    m1282invoke();
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: collision with other method in class */
                                                public final void m1282invoke() {
                                                    CalendarCard.this.getHasCardReserved().setValue(Boolean.valueOf(!((Boolean) CalendarCard.this.getHasCardReserved().getValue()).booleanValue()));
                                                    MutableState<Long> reservedCount = CalendarCard.this.getReservedCount();
                                                    reservedCount.setValue(Long.valueOf(((Number) reservedCount.getValue()).longValue() - 1));
                                                }
                                            });
                                            function222.invoke(CalendarCardClickArea.CANCEL_RESERVE, calendar.getReport());
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv22);
                                    it$iv42 = value$iv22;
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    UpcomingEpisodeReservationCardKt.UpcomingEpisodeReservationCard(upInfo, reserveCardInfo, null, longValue, booleanValue, function0, function022, (Function0) it$iv42, $composer, 0, 4);
                                    $composer.endReplaceGroup();
                                    $composer3 = $composer;
                                    $composer$iv = $composer;
                                    $composer$iv2 = $composer;
                                    $composer4 = $composer;
                                    $composer6 = $composer;
                                }
                                final Function2 function26 = $onClickCard;
                                final Router router = $router;
                                Object value$iv4 = (Function0) new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$4$1
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m1278invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: collision with other method in class */
                                    public final void m1278invoke() {
                                        function26.invoke(CalendarCardClickArea.UP_INFO, calendar.getReport());
                                        Router router2 = router;
                                        KUpInfo upInfo2 = calendar.getUpInfo();
                                        router2.launch(UrisKt.toUri((upInfo2 == null || (r1 = upInfo2.getJumpUrl()) == null) ? "" : ""));
                                    }
                                };
                                $composer.updateRememberedValue(value$iv4);
                                it$iv2 = value$iv4;
                                Function0 function03 = (Function0) it$iv2;
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerStart($composer, -1928599013, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                                invalid$iv2 = $composer.changed($onReservationClick) | $composer.changedInstance(calendar) | $composer.changed($onClickCard);
                                Object it$iv32 = $composer.rememberedValue();
                                if (!invalid$iv2) {
                                    Function0 function0222 = (Function0) it$iv32;
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerStart($composer, -1928581109, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                                    invalid$iv3 = $composer.changed($onCancelReservationClick) | $composer.changedInstance(calendar) | $composer.changed($onClickCard);
                                    Object it$iv422 = $composer.rememberedValue();
                                    if (!invalid$iv3) {
                                    }
                                    final Function2<? super String, ? super Function0<Unit>, Unit> function252 = $onCancelReservationClick;
                                    final Function2<? super CalendarCardClickArea, ? super Map<String, String>, Unit> function2222 = $onClickCard;
                                    Object value$iv222 = (Function0) new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$6$1
                                        public /* bridge */ /* synthetic */ Object invoke() {
                                            m1281invoke();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: collision with other method in class */
                                        public final void m1281invoke() {
                                            Function2<String, Function0<Unit>, Unit> function232 = function252;
                                            String bizId = calendar.getBizId();
                                            final CalendarCard calendarCard = calendar;
                                            function232.invoke(bizId, new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$6$1.1
                                                public /* bridge */ /* synthetic */ Object invoke() {
                                                    m1282invoke();
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: collision with other method in class */
                                                public final void m1282invoke() {
                                                    CalendarCard.this.getHasCardReserved().setValue(Boolean.valueOf(!((Boolean) CalendarCard.this.getHasCardReserved().getValue()).booleanValue()));
                                                    MutableState<Long> reservedCount = CalendarCard.this.getReservedCount();
                                                    reservedCount.setValue(Long.valueOf(((Number) reservedCount.getValue()).longValue() - 1));
                                                }
                                            });
                                            function2222.invoke(CalendarCardClickArea.CANCEL_RESERVE, calendar.getReport());
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv222);
                                    it$iv422 = value$iv222;
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    UpcomingEpisodeReservationCardKt.UpcomingEpisodeReservationCard(upInfo, reserveCardInfo, null, longValue, booleanValue, function03, function0222, (Function0) it$iv422, $composer, 0, 4);
                                    $composer.endReplaceGroup();
                                    $composer3 = $composer;
                                    $composer$iv = $composer;
                                    $composer$iv2 = $composer;
                                    $composer4 = $composer;
                                    $composer6 = $composer;
                                }
                                final Function2<? super String, ? super Function0<Unit>, Unit> function232 = $onReservationClick;
                                final Function2<? super CalendarCardClickArea, ? super Map<String, String>, Unit> function242 = $onClickCard;
                                Object value$iv32 = (Function0) new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$5$1
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m1279invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: collision with other method in class */
                                    public final void m1279invoke() {
                                        Function2<String, Function0<Unit>, Unit> function253 = function232;
                                        String bizId = calendar.getBizId();
                                        final CalendarCard calendarCard = calendar;
                                        function253.invoke(bizId, new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$5$1.1
                                            public /* bridge */ /* synthetic */ Object invoke() {
                                                m1280invoke();
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke  reason: collision with other method in class */
                                            public final void m1280invoke() {
                                                CalendarCard.this.getHasCardReserved().setValue(Boolean.valueOf(!((Boolean) CalendarCard.this.getHasCardReserved().getValue()).booleanValue()));
                                                MutableState<Long> reservedCount = CalendarCard.this.getReservedCount();
                                                reservedCount.setValue(Long.valueOf(((Number) reservedCount.getValue()).longValue() + 1));
                                            }
                                        });
                                        function242.invoke(CalendarCardClickArea.RESERVE, calendar.getReport());
                                    }
                                };
                                $composer.updateRememberedValue(value$iv32);
                                it$iv32 = value$iv32;
                                Function0 function02222 = (Function0) it$iv32;
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerStart($composer, -1928581109, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                                invalid$iv3 = $composer.changed($onCancelReservationClick) | $composer.changedInstance(calendar) | $composer.changed($onClickCard);
                                Object it$iv4222 = $composer.rememberedValue();
                                if (!invalid$iv3) {
                                }
                                final Function2<? super String, ? super Function0<Unit>, Unit> function2522 = $onCancelReservationClick;
                                final Function2<? super CalendarCardClickArea, ? super Map<String, String>, Unit> function22222 = $onClickCard;
                                Object value$iv2222 = (Function0) new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$6$1
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m1281invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: collision with other method in class */
                                    public final void m1281invoke() {
                                        Function2<String, Function0<Unit>, Unit> function2322 = function2522;
                                        String bizId = calendar.getBizId();
                                        final CalendarCard calendarCard = calendar;
                                        function2322.invoke(bizId, new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$6$1.1
                                            public /* bridge */ /* synthetic */ Object invoke() {
                                                m1282invoke();
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke  reason: collision with other method in class */
                                            public final void m1282invoke() {
                                                CalendarCard.this.getHasCardReserved().setValue(Boolean.valueOf(!((Boolean) CalendarCard.this.getHasCardReserved().getValue()).booleanValue()));
                                                MutableState<Long> reservedCount = CalendarCard.this.getReservedCount();
                                                reservedCount.setValue(Long.valueOf(((Number) reservedCount.getValue()).longValue() - 1));
                                            }
                                        });
                                        function22222.invoke(CalendarCardClickArea.CANCEL_RESERVE, calendar.getReport());
                                    }
                                };
                                $composer.updateRememberedValue(value$iv2222);
                                it$iv4222 = value$iv2222;
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                UpcomingEpisodeReservationCardKt.UpcomingEpisodeReservationCard(upInfo, reserveCardInfo, null, longValue, booleanValue, function03, function02222, (Function0) it$iv4222, $composer, 0, 4);
                                $composer.endReplaceGroup();
                                $composer3 = $composer;
                                $composer$iv = $composer;
                                $composer$iv2 = $composer;
                                $composer4 = $composer;
                                $composer6 = $composer;
                            } else if (Intrinsics.areEqual(calendarCardType, KCalendarCardType.CALENDAR_CARD_TYPE_OGV.INSTANCE)) {
                                $composer.startReplaceGroup(344389040);
                                ComposerKt.sourceInformation($composer, "373@18421L368,380@18841L376,370@18227L1025");
                                Modifier modifier2 = Modifier.Companion;
                                ComposerKt.sourceInformationMarkerStart($composer, -1928546751, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                                boolean invalid$iv5 = $composer.changedInstance($scope) | $composer.changedInstance(calendar) | $composer.changed($onClickCard) | $composer.changed($sheetState);
                                Object it$iv5 = $composer.rememberedValue();
                                if (!invalid$iv5 && it$iv5 != Composer.Companion.getEmpty()) {
                                    $composer7 = $composer;
                                    $composer$iv = $composer;
                                    $changed$iv = it;
                                    $composer$iv2 = $composer;
                                    $composer4 = $composer;
                                    value$iv = it$iv5;
                                    $composer8 = $composer;
                                    Function0 function04 = (Function0) value$iv;
                                    ComposerKt.sourceInformationMarkerEnd($composer7);
                                    Composer $composer9 = $composer7;
                                    ComposerKt.sourceInformationMarkerStart($composer9, -1928533303, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                                    invalid$iv = $composer9.changed($onClickCard) | $composer9.changedInstance(calendar) | $composer9.changedInstance($router);
                                    it$iv = $composer9.rememberedValue();
                                    if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                                        final Function2 function27 = $onClickCard;
                                        final Router router2 = $router;
                                        Object value$iv5 = (Function0) new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$8$1
                                            public /* bridge */ /* synthetic */ Object invoke() {
                                                m1284invoke();
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke  reason: collision with other method in class */
                                            public final void m1284invoke() {
                                                function27.invoke(CalendarCardClickArea.CARD, calendar.getReport());
                                                calendar.getHasCardClicked().setValue(true);
                                                KOgvCardInfo ogvCardInfo = calendar.getOgvCardInfo();
                                                String jumpUrl = ogvCardInfo != null ? ogvCardInfo.getJumpUrl() : null;
                                                router2.launch(UrisKt.toUri(jumpUrl == null ? "" : jumpUrl));
                                            }
                                        };
                                        $composer9.updateRememberedValue(value$iv5);
                                        it$iv = value$iv5;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer9);
                                    $composer3 = $composer9;
                                    UpcomingEpisodeListOgvCardKt.UpcomingEpisodeListOgvCard(calendar, modifier2, function04, (Function0) it$iv, $composer9, (($changed2 >> 6) & 14) | 48, 0);
                                    $composer3.endReplaceGroup();
                                    $composer6 = $composer8;
                                }
                                final CoroutineScope coroutineScope = $scope;
                                final Function2 function28 = $onClickCard;
                                final SheetState sheetState = $sheetState;
                                final MutableState mutableState = $lastClickCard$delegate;
                                $composer7 = $composer;
                                $composer$iv = $composer;
                                $composer4 = $composer;
                                $composer$iv2 = $composer;
                                $composer8 = $composer;
                                $changed$iv = it;
                                value$iv = (Function0) new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$7$1

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* compiled from: UpcomingEpisodeList.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                    @DebugMetadata(c = "kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$7$1$1", f = "UpcomingEpisodeList.kt", i = {}, l = {378}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                                    /* renamed from: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$7$1$1  reason: invalid class name */
                                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ CalendarCard $calendar;
                                        final /* synthetic */ MutableState<CalendarCard> $lastClickCard$delegate;
                                        final /* synthetic */ Function2<CalendarCardClickArea, Map<String, String>, Unit> $onClickCard;
                                        final /* synthetic */ SheetState $sheetState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        AnonymousClass1(CalendarCard calendarCard, Function2<? super CalendarCardClickArea, ? super Map<String, String>, Unit> function2, SheetState sheetState, MutableState<CalendarCard> mutableState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$calendar = calendarCard;
                                            this.$onClickCard = function2;
                                            this.$sheetState = sheetState;
                                            this.$lastClickCard$delegate = mutableState;
                                        }

                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$calendar, this.$onClickCard, this.$sheetState, this.$lastClickCard$delegate, continuation);
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                        }

                                        public final Object invokeSuspend(Object $result) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (this.label) {
                                                case 0:
                                                    ResultKt.throwOnFailure($result);
                                                    this.$lastClickCard$delegate.setValue(this.$calendar);
                                                    this.$onClickCard.invoke(CalendarCardClickArea.MORE, this.$calendar.getReport());
                                                    this.label = 1;
                                                    if (this.$sheetState.show((Continuation) this) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    break;
                                                case 1:
                                                    ResultKt.throwOnFailure($result);
                                                    break;
                                                default:
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m1283invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: collision with other method in class */
                                    public final void m1283invoke() {
                                        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(calendar, function28, sheetState, mutableState, null), 3, (Object) null);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                                Function0 function042 = (Function0) value$iv;
                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                Composer $composer92 = $composer7;
                                ComposerKt.sourceInformationMarkerStart($composer92, -1928533303, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                                invalid$iv = $composer92.changed($onClickCard) | $composer92.changedInstance(calendar) | $composer92.changedInstance($router);
                                it$iv = $composer92.rememberedValue();
                                if (!invalid$iv) {
                                }
                                final Function2<? super CalendarCardClickArea, ? super Map<String, String>, Unit> function272 = $onClickCard;
                                final Router router22 = $router;
                                Object value$iv52 = (Function0) new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$8$1
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m1284invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: collision with other method in class */
                                    public final void m1284invoke() {
                                        function272.invoke(CalendarCardClickArea.CARD, calendar.getReport());
                                        calendar.getHasCardClicked().setValue(true);
                                        KOgvCardInfo ogvCardInfo = calendar.getOgvCardInfo();
                                        String jumpUrl = ogvCardInfo != null ? ogvCardInfo.getJumpUrl() : null;
                                        router22.launch(UrisKt.toUri(jumpUrl == null ? "" : jumpUrl));
                                    }
                                };
                                $composer92.updateRememberedValue(value$iv52);
                                it$iv = value$iv52;
                                ComposerKt.sourceInformationMarkerEnd($composer92);
                                $composer3 = $composer92;
                                UpcomingEpisodeListOgvCardKt.UpcomingEpisodeListOgvCard(calendar, modifier2, function042, (Function0) it$iv, $composer92, (($changed2 >> 6) & 14) | 48, 0);
                                $composer3.endReplaceGroup();
                                $composer6 = $composer8;
                            } else {
                                $composer3 = $composer;
                                $composer$iv = $composer;
                                $composer$iv2 = $composer;
                                $composer4 = $composer;
                                $composer3.startReplaceGroup(345473327);
                                $composer3.endReplaceGroup();
                                $composer6 = $composer;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            Composer $composer10 = $composer4;
                            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer10, 6);
                            ComposerKt.sourceInformationMarkerEnd($composer10);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                            $composer6.endReplaceGroup();
                            $composer2 = $composer6;
                        }
                        $composer3.startReplaceGroup(340576009);
                        ComposerKt.sourceInformation($composer3, "319@15021L235,312@14593L368,323@15308L691,308@14330L1704");
                        Modifier modifier3 = Modifier.Companion;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1928655684, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                        boolean invalid$iv6 = $composer3.changed($onClickCard) | $composer3.changedInstance(calendar) | $composer3.changedInstance($router);
                        Composer $this$cache$iv = $composer3;
                        Object it$iv6 = $this$cache$iv.rememberedValue();
                        if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                            final Function2 function29 = $onClickCard;
                            final Router router3 = $router;
                            Object value$iv6 = (Function0) new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$1$1
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m1275invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: collision with other method in class */
                                public final void m1275invoke() {
                                    function29.invoke(CalendarCardClickArea.UP_INFO, calendar.getReport());
                                    Router router4 = router3;
                                    KUpInfo upInfo2 = calendar.getUpInfo();
                                    router4.launch(UrisKt.toUri((upInfo2 == null || (r1 = upInfo2.getJumpUrl()) == null) ? "" : ""));
                                }
                            };
                            $this$cache$iv.updateRememberedValue(value$iv6);
                            it$iv6 = value$iv6;
                        }
                        Function0 function05 = (Function0) it$iv6;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, -1928669247, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                        boolean invalid$iv7 = $composer3.changedInstance($scope) | $composer3.changedInstance(calendar) | $composer3.changed($onClickCard) | $composer3.changed($sheetState);
                        Composer $this$cache$iv2 = $composer3;
                        Object value$iv7 = $this$cache$iv2.rememberedValue();
                        if (invalid$iv7 || value$iv7 == Composer.Companion.getEmpty()) {
                            final CoroutineScope coroutineScope2 = $scope;
                            final Function2 function210 = $onClickCard;
                            final SheetState sheetState2 = $sheetState;
                            final MutableState mutableState2 = $lastClickCard$delegate;
                            $composer6 = $composer5;
                            value$iv7 = new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$2$1

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* compiled from: UpcomingEpisodeList.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                @DebugMetadata(c = "kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$2$1$1", f = "UpcomingEpisodeList.kt", i = {}, l = {317}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                                /* renamed from: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$2$1$1  reason: invalid class name */
                                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ CalendarCard $calendar;
                                    final /* synthetic */ MutableState<CalendarCard> $lastClickCard$delegate;
                                    final /* synthetic */ Function2<CalendarCardClickArea, Map<String, String>, Unit> $onClickCard;
                                    final /* synthetic */ SheetState $sheetState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    AnonymousClass1(CalendarCard calendarCard, Function2<? super CalendarCardClickArea, ? super Map<String, String>, Unit> function2, SheetState sheetState, MutableState<CalendarCard> mutableState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$calendar = calendarCard;
                                        this.$onClickCard = function2;
                                        this.$sheetState = sheetState;
                                        this.$lastClickCard$delegate = mutableState;
                                    }

                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$calendar, this.$onClickCard, this.$sheetState, this.$lastClickCard$delegate, continuation);
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                    }

                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                this.$lastClickCard$delegate.setValue(this.$calendar);
                                                this.$onClickCard.invoke(CalendarCardClickArea.MORE, this.$calendar.getReport());
                                                this.label = 1;
                                                if (this.$sheetState.show((Continuation) this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                break;
                                            case 1:
                                                ResultKt.throwOnFailure($result);
                                                break;
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m1276invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: collision with other method in class */
                                public final void m1276invoke() {
                                    BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(calendar, function210, sheetState2, mutableState2, null), 3, (Object) null);
                                }
                            };
                            $this$cache$iv2.updateRememberedValue(value$iv7);
                        } else {
                            $composer6 = $composer5;
                        }
                        Function0 function06 = (Function0) value$iv7;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, -1928646044, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
                        boolean invalid$iv8 = $composer3.changed($onClickCard) | $composer3.changedInstance(calendar) | $composer3.changedInstance($router);
                        Composer $this$cache$iv3 = $composer3;
                        Object it$iv7 = $this$cache$iv3.rememberedValue();
                        if (invalid$iv8 || it$iv7 == Composer.Companion.getEmpty()) {
                            final Function2 function211 = $onClickCard;
                            final Router router4 = $router;
                            Object value$iv8 = (Function0) new Function0<Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$6$1$2$1$1$3$1
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m1277invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: collision with other method in class */
                                public final void m1277invoke() {
                                    function211.invoke(CalendarCardClickArea.CARD, calendar.getReport());
                                    calendar.getHasCardClicked().setValue(true);
                                    String str = null;
                                    if (UpcomingEpisodeExtensionsKt.isUgc(calendar.getCalendarCardType())) {
                                        KArchiveCardInfo archiveCardInfo = calendar.getArchiveCardInfo();
                                        if (archiveCardInfo != null) {
                                            str = archiveCardInfo.getJumpUrl();
                                        }
                                    } else {
                                        KLiveCardInfo liveCardInfo = calendar.getLiveCardInfo();
                                        if (liveCardInfo != null) {
                                            str = liveCardInfo.getJumpUrl();
                                        }
                                    }
                                    String jumpUrl = str;
                                    router4.launch(UrisKt.toUri(jumpUrl == null ? "" : jumpUrl));
                                }
                            };
                            $this$cache$iv3.updateRememberedValue(value$iv8);
                            it$iv7 = value$iv8;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        UpcomingEpisodeListCommonVideoCardKt.UpcomingEpisodeListCommonVideoCard(calendar, cardUiType, modifier3, function05, function06, (Function0) it$iv7, $composer3, (($changed2 >> 6) & 14) | 384, 0);
                        $composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Composer $composer102 = $composer4;
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer102, 6);
                        ComposerKt.sourceInformationMarkerEnd($composer102);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        $composer6.endReplaceGroup();
                        $composer2 = $composer6;
                    } else {
                        $composer2 = $composer;
                        $composer2.startReplaceGroup(-720202548);
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
        if ($calendarList.isEmpty()) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-298160721, true, new Function3() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TimeAxisWithCardsLayout$lambda$17$0$2;
                    TimeAxisWithCardsLayout$lambda$17$0$2 = UpcomingEpisodeListKt.TimeAxisWithCardsLayout$lambda$17$0$2(UpcomingEpisodeListBaseStatusType.this, $statusText, $onClickRetry, $recommendData, $buttonText, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TimeAxisWithCardsLayout$lambda$17$0$2;
                }
            }), 3, (Object) null);
            $this$LazyColumn.items($recommendData.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$lambda$17$0$$inlined$itemsIndexed$default$5
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke(((Number) p1).intValue());
                }

                public final Object invoke(int index) {
                    $recommendData.get(index);
                    return null;
                }
            }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$TimeAxisWithCardsLayout$lambda$17$0$$inlined$itemsIndexed$default$6
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
                    int i = ($dirty & 14) | ($dirty & 112);
                    KRecommend item = (KRecommend) $recommendData.get(it);
                    $composer.startReplaceGroup(1085968252);
                    ComposerKt.sourceInformation($composer, "CN(index,item):UpcomingEpisodeList.kt#kr57tx");
                    KReserveRecommend it2 = item.getReserveRecommend();
                    if (it2 == null) {
                        $composer.startReplaceGroup(1085990353);
                        $composer.endReplaceGroup();
                        $composer2 = $composer;
                    } else {
                        $composer.startReplaceGroup(1085990354);
                        ComposerKt.sourceInformation($composer, "*505@24769L427");
                        if (!$reportedSet.contains(Integer.valueOf(it))) {
                            $reportedSet.add(Integer.valueOf(it));
                            Function1 function1 = $onRecommendReservationCardShow;
                            KReserveRecommend reserveRecommend = item.getReserveRecommend();
                            if (reserveRecommend == null) {
                                reserveRecommend = new KReserveRecommend((String) null, 0L, 0L, 0L, 0L, 0L, (Map) null, 127, (DefaultConstructorMarker) null);
                            }
                            function1.invoke(reserveRecommend);
                        }
                        $composer2 = $composer;
                        UpcomingEpisodeRecommendReservationCardKt.UpcomingEpisodeRecommendReservationCard(item.getUpInfo(), it2, null, $onRecommendReservationAuthorClick, $onRecommendReservationClick, $onCancelRecommendReservationClick, $composer, 0, 4);
                        $composer2.endReplaceGroup();
                    }
                    $composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TimeAxisWithCardsLayout$lambda$17$0$0(int i, CalendarCard item) {
        Intrinsics.checkNotNullParameter(item, "item");
        String bizId = item.getBizId();
        String anchorBizTypeString = UpcomingEpisodeExtensionsKt.toAnchorBizTypeString(item.getBizType());
        return bizId + anchorBizTypeString + item.getAnchorTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeAxisWithCardsLayout$lambda$17$0$2(UpcomingEpisodeListBaseStatusType $statusType, String $statusText, Function0 $onClickRetry, List $recommendData, String $buttonText, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C402@19655L4758:UpcomingEpisodeList.kt#kr57tx");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-298160721, $changed, -1, "kntr.app.upcomingEpisode.list.ui.TimeAxisWithCardsLayout.<anonymous>.<anonymous>.<anonymous> (UpcomingEpisodeList.kt:402)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ColumnScope $this$TimeAxisWithCardsLayout_u24lambda_u2417_u240_u242_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1505395427, "C405@19748L48,444@21689L47,452@22098L9,453@22155L6,445@21757L433:UpcomingEpisodeList.kt#kr57tx");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(80)), $composer, 6);
            switch (WhenMappings.$EnumSwitchMapping$0[$statusType.ordinal()]) {
                case 1:
                    $composer.startReplaceGroup(1505421342);
                    ComposerKt.sourceInformation($composer, "409@19982L45,408@19933L467");
                    ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_status_empty(Res.drawable.INSTANCE), $composer, 0), $statusText, $this$TimeAxisWithCardsLayout_u24lambda_u2417_u240_u242_u240.align(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), Dp.constructor-impl(140)), Alignment.Companion.getCenterHorizontally()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                    $composer.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                    break;
                case 2:
                    $composer.startReplaceGroup(1506011644);
                    ComposerKt.sourceInformation($composer, "420@20541L31,421@20601L427");
                    AnimatePainter loading = RefreshAnimatePainterKt.rememberRefreshAnimatePainter(false, $composer, 0, 1);
                    ImageKt.Image(loading, $statusText, $this$TimeAxisWithCardsLayout_u24lambda_u2417_u240_u242_u240.align(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), Dp.constructor-impl(60)), Alignment.Companion.getCenterHorizontally()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, AnimatePainter.$stable, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                    $composer.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                    break;
                case 3:
                    $composer.startReplaceGroup(1506631582);
                    ComposerKt.sourceInformation($composer, "434@21202L45,433@21153L467");
                    ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_status_error(Res.drawable.INSTANCE), $composer, 0), $statusText, $this$TimeAxisWithCardsLayout_u24lambda_u2417_u240_u242_u240.align(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), Dp.constructor-impl(140)), Alignment.Companion.getCenterHorizontally()), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                    $composer.endReplaceGroup();
                    Unit unit3 = Unit.INSTANCE;
                    break;
                default:
                    $composer.startReplaceGroup(1434033876);
                    $composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer, 6);
            TextKt.Text-Nvy7gAk($statusText, $this$TimeAxisWithCardsLayout_u24lambda_u2417_u240_u242_u240.align(SizeKt.wrapContentSize$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(10), 7, (Object) null), (Alignment) null, false, 3, (Object) null), Alignment.Companion.getCenterHorizontally()), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 0, 131064);
            if ($statusType == UpcomingEpisodeListBaseStatusType.ERROR) {
                $composer.startReplaceGroup(1507826167);
                ComposerKt.sourceInformation($composer, "457@22328L47,464@22693L6,458@22400L1210");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer, 6);
                Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default($this$TimeAxisWithCardsLayout_u24lambda_u2417_u240_u242_u240.align(PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(30)), Dp.constructor-impl(96)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15))), Dp.constructor-impl(10), Dp.constructor-impl(5)), Alignment.Companion.getCenterHorizontally()), false, (String) null, (Role) null, (MutableInteractionSource) null, $onClickRetry, 15, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
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
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i4 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1656314172, "C476@23409L9,477@23474L6,473@23225L359:UpcomingEpisodeList.kt#kr57tx");
                TextKt.Text-Nvy7gAk($buttonText == null ? "" : $buttonText, SizeKt.wrapContentSize$default(Modifier.Companion, (Alignment) null, false, 3, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 48, 0, 130040);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
            } else {
                $composer.startReplaceGroup(1485660361);
            }
            $composer.endReplaceGroup();
            if ($recommendData.isEmpty()) {
                $composer.startReplaceGroup(1485660361);
            } else {
                $composer.startReplaceGroup(1509178883);
                ComposerKt.sourceInformation($composer, "488@23960L6,483@23711L287,491@24064L60,492@24172L6,493@24232L9,490@24023L350");
                SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_34(Res.string.INSTANCE), $composer, 0), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(10), 4, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 48, 0, 131064);
            }
            $composer.endReplaceGroup();
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
    public static final Unit TimeAxisWithCardsLayout$lambda$20$0(Function3 $onClickDeleteCalendarCard, Function2 $onClickCard, CoroutineScope $scope, final MutableState $lastClickCard$delegate, final Function0 $checkPointType, SheetState $sheetState) {
        $onClickDeleteCalendarCard.invoke(TimeAxisWithCardsLayout$lambda$7($lastClickCard$delegate).getBizType(), TimeAxisWithCardsLayout$lambda$7($lastClickCard$delegate).getBizId(), new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda19
            public final Object invoke() {
                Unit TimeAxisWithCardsLayout$lambda$20$0$0;
                TimeAxisWithCardsLayout$lambda$20$0$0 = UpcomingEpisodeListKt.TimeAxisWithCardsLayout$lambda$20$0$0($checkPointType, $lastClickCard$delegate);
                return TimeAxisWithCardsLayout$lambda$20$0$0;
            }
        });
        $onClickCard.invoke(CalendarCardClickArea.REMOVE, TimeAxisWithCardsLayout$lambda$7($lastClickCard$delegate).getReport());
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new UpcomingEpisodeListKt$TimeAxisWithCardsLayout$8$1$2($sheetState, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeAxisWithCardsLayout$lambda$20$0$0(Function0 $checkPointType, MutableState $lastClickCard$delegate) {
        TimeAxisWithCardsLayout$lambda$7($lastClickCard$delegate).getShouldCardShow().setValue(false);
        $checkPointType.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimeAxisItem(final CardUiType cardUiType, final boolean isFirstItem, final boolean isLatestUpcomingEp, final boolean isLastItem, final boolean isCurrentDayToday, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        float f;
        long j;
        Composer $composer3;
        Modifier modifier5;
        Composer $composer$iv$iv$iv;
        Composer $composer4 = $composer.startRestartGroup(1936458102);
        ComposerKt.sourceInformation($composer4, "C(TimeAxisItem)N(cardUiType,isFirstItem,isLatestUpcomingEp,isLastItem,isCurrentDayToday,modifier)566@26731L1993:UpcomingEpisodeList.kt#kr57tx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(cardUiType.ordinal()) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(isFirstItem) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(isLatestUpcomingEp) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(isLastItem) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer4.changed(isCurrentDayToday) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        if ($composer4.shouldExecute(($dirty & 74899) != 74898, $dirty & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1936458102, $dirty, -1, "kntr.app.upcomingEpisode.list.ui.TimeAxisItem (UpcomingEpisodeList.kt:565)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(modifier4, Dp.constructor-impl(136));
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            int $dirty2 = $dirty;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -1121372978, "C587@27353L6,589@27451L6,590@27503L6,592@27590L1128,592@27548L1170:UpcomingEpisodeList.kt#kr57tx");
            final float strokeWidth = Dp.constructor-impl(1);
            final float axisX = Dp.constructor-impl(14);
            final float axisY = Dp.constructor-impl((float) 20.5d);
            if (cardUiType != CardUiType.TYPE_HIGHLIGHT) {
                $composer$iv = $composer4;
                f = Dp.constructor-impl(2);
            } else {
                $composer$iv = $composer4;
                f = Dp.constructor-impl(4);
            }
            final float dotRadius = f;
            final float latestUpcomingMarkCornerRadius = Dp.constructor-impl(4);
            if (cardUiType == CardUiType.TYPE_HIGHLIGHT) {
                $composer4.startReplaceGroup(-1121065769);
                ComposerKt.sourceInformation($composer4, "583@27220L6");
                j = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer4.endReplaceGroup();
            } else {
                $composer4.startReplaceGroup(-1121001289);
                ComposerKt.sourceInformation($composer4, "585@27285L6");
                j = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_weak-0d7_KjU();
                $composer4.endReplaceGroup();
            }
            final long dotColor = j;
            final long strokeColor = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1_float-0d7_KjU();
            final float lineLength = Dp.constructor-impl((float) 20.5d);
            final long latestUpcomingMarkColor = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU();
            modifier3 = modifier4;
            final long lineColor = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getLine_regular-0d7_KjU();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, -1144528264, "CC(remember):UpcomingEpisodeList.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 7168) == 2048) | $composer4.changed(lineColor) | $composer4.changed(dotRadius) | $composer4.changed(dotColor) | $composer4.changed(strokeColor) | (($dirty2 & 112) == 32) | (($dirty2 & 14) == 4) | (($dirty2 & 896) == 256) | $composer4.changed(latestUpcomingMarkColor) | ((57344 & $dirty2) == 16384);
            Object value$iv = $composer4.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                $composer3 = $composer4;
                modifier5 = fillMaxSize$default;
                $composer$iv$iv$iv = $composer4;
                $composer2 = $composer4;
                value$iv = new Function1() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        Unit TimeAxisItem$lambda$0$0$0;
                        TimeAxisItem$lambda$0$0$0 = UpcomingEpisodeListKt.TimeAxisItem$lambda$0$0$0(strokeWidth, axisX, axisY, isLastItem, lineColor, dotRadius, dotColor, strokeColor, lineLength, isFirstItem, cardUiType, isLatestUpcomingEp, latestUpcomingMarkColor, latestUpcomingMarkCornerRadius, isCurrentDayToday, (DrawScope) obj);
                        return TimeAxisItem$lambda$0$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv);
            } else {
                $composer3 = $composer4;
                $composer2 = $composer4;
                modifier5 = fillMaxSize$default;
                $composer$iv$iv$iv = $composer4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Composer $composer5 = $composer3;
            CanvasKt.Canvas(modifier5, (Function1) value$iv, $composer5, 6);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit TimeAxisItem$lambda$1;
                    TimeAxisItem$lambda$1 = UpcomingEpisodeListKt.TimeAxisItem$lambda$1(CardUiType.this, isFirstItem, isLatestUpcomingEp, isLastItem, isCurrentDayToday, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TimeAxisItem$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeAxisItem$lambda$0$0$0(float $strokeWidth, float $axisX, float $axisY, boolean $isLastItem, long $lineColor, float $dotRadius, long $dotColor, long $strokeColor, float $lineLength, boolean $isFirstItem, CardUiType $cardUiType, boolean $isLatestUpcomingEp, long $latestUpcomingMarkColor, float $latestUpcomingMarkCornerRadius, boolean $isCurrentDayToday, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        m1274drawTimeAxisLinekKL39v8($this$Canvas, $this$Canvas.toPx-0680j_4($strokeWidth), $this$Canvas.toPx-0680j_4($axisX), $this$Canvas.toPx-0680j_4($axisY), $isLastItem, $lineColor);
        m1273drawDotAndConnectors0w1AfAo($this$Canvas, $this$Canvas.toPx-0680j_4($axisX), $this$Canvas.toPx-0680j_4($axisY), $this$Canvas.toPx-0680j_4($strokeWidth), $this$Canvas.toPx-0680j_4($dotRadius), $dotColor, $strokeColor, $this$Canvas.toPx-0680j_4($lineLength), $isFirstItem, $cardUiType, $isLatestUpcomingEp, $latestUpcomingMarkColor, $strokeColor, $this$Canvas.toPx-0680j_4($latestUpcomingMarkCornerRadius), $this$Canvas.toPx-0680j_4($strokeWidth), $isCurrentDayToday, $lineColor);
        return Unit.INSTANCE;
    }

    /* renamed from: drawTimeAxisLine-kKL39v8  reason: not valid java name */
    private static final void m1274drawTimeAxisLinekKL39v8(DrawScope $this$drawTimeAxisLine_u2dkKL39v8, float strokeWidth, float axisX, float axisY, boolean isLastItem, long j) {
        if (isLastItem) {
            return;
        }
        long v1$iv$iv = Float.floatToRawIntBits(axisX);
        long v2$iv$iv = Float.floatToRawIntBits(axisY);
        long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv = (int) ($this$drawTimeAxisLine_u2dkKL39v8.getSize-NH-jbRc() & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv);
        long v1$iv$iv2 = Float.floatToRawIntBits(axisX);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv);
        DrawScope.-CC.drawLine-NGM6Ib0$default($this$drawTimeAxisLine_u2dkKL39v8, j, j2, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), strokeWidth, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
    }

    /* renamed from: drawDotAndConnectors-0w1AfAo  reason: not valid java name */
    private static final void m1273drawDotAndConnectors0w1AfAo(DrawScope $this$drawDotAndConnectors_u2d0w1AfAo, float axisX, float axisY, float strokeWidth, float dotRadius, long j, long j2, float lineLength, boolean isFirstItem, CardUiType cardUiType, boolean isLatestUpcomingEp, long j3, long j4, float latestUpcomingMarkCornerRadius, float latestUpcomingMarkStrokeWidth, boolean isCurrentDayToday, long j5) {
        if (!isFirstItem) {
            long v1$iv$iv = Float.floatToRawIntBits(axisX);
            long v2$iv$iv = Float.floatToRawIntBits(axisY);
            long j6 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
            float y$iv = axisY - lineLength;
            long v1$iv$iv2 = Float.floatToRawIntBits(axisX);
            long v2$iv$iv2 = Float.floatToRawIntBits(y$iv);
            DrawScope.-CC.drawLine-NGM6Ib0$default($this$drawDotAndConnectors_u2d0w1AfAo, j5, j6, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), strokeWidth, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
        }
        if (isCurrentDayToday && isLatestUpcomingEp) {
            float markWidth = $this$drawDotAndConnectors_u2d0w1AfAo.toPx-0680j_4(Dp.constructor-impl(18));
            float markHeight = $this$drawDotAndConnectors_u2d0w1AfAo.toPx-0680j_4(Dp.constructor-impl(8));
            float f = 2;
            float startPositionY = axisY - (markHeight / f);
            Path path = AndroidPath_androidKt.Path();
            path.moveTo(0.0f, startPositionY);
            path.lineTo(markWidth - latestUpcomingMarkCornerRadius, startPositionY);
            path.arcTo(new Rect(markWidth - (f * latestUpcomingMarkCornerRadius), startPositionY, markWidth, (f * latestUpcomingMarkCornerRadius) + startPositionY), -90.0f, 90.0f, false);
            path.lineTo(markWidth, (startPositionY + markHeight) - latestUpcomingMarkCornerRadius);
            path.arcTo(new Rect(markWidth - (f * latestUpcomingMarkCornerRadius), (startPositionY + markHeight) - (f * latestUpcomingMarkCornerRadius), markWidth, startPositionY + markHeight), 0.0f, 90.0f, false);
            path.lineTo(latestUpcomingMarkCornerRadius, startPositionY + markHeight);
            path.lineTo(0.0f, startPositionY + markHeight);
            path.close();
            DrawScope.-CC.drawPath-LG529CI$default($this$drawDotAndConnectors_u2d0w1AfAo, path, j3, 0.0f, Fill.INSTANCE, (ColorFilter) null, 0, 52, (Object) null);
            DrawScope.-CC.drawPath-LG529CI$default($this$drawDotAndConnectors_u2d0w1AfAo, path, j4, 0.0f, new Stroke(latestUpcomingMarkStrokeWidth, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 52, (Object) null);
            return;
        }
        long v1$iv$iv3 = Float.floatToRawIntBits(axisX);
        long v2$iv$iv3 = Float.floatToRawIntBits(axisY);
        DrawScope.-CC.drawCircle-VaOC9Bg$default($this$drawDotAndConnectors_u2d0w1AfAo, j, dotRadius, Offset.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv3 & 4294967295L)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, (int) BackoffConfigKt.MAX_DELAY_SECONDS, (Object) null);
        if (cardUiType != CardUiType.TYPE_HIGHLIGHT) {
            return;
        }
        long v1$iv$iv4 = Float.floatToRawIntBits(axisX);
        long v2$iv$iv4 = Float.floatToRawIntBits(axisY);
        DrawScope.-CC.drawCircle-VaOC9Bg$default($this$drawDotAndConnectors_u2d0w1AfAo, j2, dotRadius, Offset.constructor-impl((v1$iv$iv4 << 32) | (v2$iv$iv4 & 4294967295L)), 0.0f, new Stroke($this$drawDotAndConnectors_u2d0w1AfAo.toPx-0680j_4(Dp.constructor-impl(1)), 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 104, (Object) null);
    }
}