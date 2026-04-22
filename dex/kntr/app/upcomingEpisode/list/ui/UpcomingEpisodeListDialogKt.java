package kntr.app.upcomingEpisode.list.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import com.bapis.bilibili.community.interfacess.watch.v1.KReserveRecommend;
import com.bapis.bilibili.community.interfacess.watch.v1.KUpInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KWatchBizType;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.handler.CalendarCardClickArea;
import kntr.app.upcomingEpisode.base.handler.CalendarType;
import kntr.app.upcomingEpisode.base.stateMachine.RequestFrom;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStatus;
import kntr.app.upcomingEpisode.list.utils.DraggableSheetNodeElement;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: UpcomingEpisodeListDialog.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u001aÀ\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00012S\b\u0002\u0010\u001d\u001aM\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030$¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00030\u001e2>\b\u0002\u0010&\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030$¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00030'2>\b\u0002\u0010)\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030$¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00030'2>\b\u0002\u0010+\u001a8\u0012\u0013\u0012\u00110,¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030$¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00030'28\b\u0002\u0010/\u001a2\u0012\u0013\u0012\u001100¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(1\u0012\u0013\u0012\u00110,¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00030'2>\b\u0002\u00102\u001a8\u0012\u0013\u0012\u00110,¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030$¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00030'2#\b\u0002\u00103\u001a\u001d\u0012\u0013\u0012\u00110,¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0003042/\b\u0002\u00105\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000106¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0003042D\b\u0002\u00108\u001a>\u0012\u0013\u0012\u001109¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(:\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000106¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00030'2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030$2#\b\u0002\u0010<\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u0003042\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00030$2#\b\u0002\u0010?\u001a\u001d\u0012\u0013\u0012\u00110@¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u000304H\u0007¢\u0006\u0004\bB\u0010C\u001ad\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020F2\u0006\u0010I\u001a\u00020F2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\u0003042!\u0010<\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u000304H\u0003¢\u0006\u0002\u0010K\u001an\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020F2\u0006\u0010\b\u001a\u00020\t2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\u0003042!\u0010<\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u000304H\u0003¢\u0006\u0004\bO\u0010P\u001a\\\u0010Q\u001a\u00020\u0005*\u00020\u00052\u0006\u0010R\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020F2\u0006\u0010S\u001a\u00020F2\u0006\u0010T\u001a\u00020F2\u0006\u0010I\u001a\u00020F2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\u0003042\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000304H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006U²\u0006\n\u0010V\u001a\u00020FX\u008a\u008e\u0002²\u0006\n\u0010W\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010N\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010X\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010Y\u001a\u00020FX\u008a\u0084\u0002²\u0006\n\u0010Z\u001a\u00020FX\u008a\u008e\u0002"}, d2 = {"TAG", "", UpcomingEpisodeListDialogKt.TAG, "", "modifier", "Landroidx/compose/ui/Modifier;", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "threshold", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxHeight", "paddingBottom", "calendarList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkntr/app/upcomingEpisode/list/model/CalendarCard;", "requestState", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestStatus;", "requestFrom", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;", "calendarType", "Lkntr/app/upcomingEpisode/base/handler/CalendarType;", "recommendData", "", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KRecommend;", "isCurrentDayToday", "", "landingAnchorBizType", "landingAnchorBizId", "onClickDeleteCalendarCard", "Lkotlin/Function3;", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KWatchBizType;", "Lkotlin/ParameterName;", "name", "bizType", "bizId", "Lkotlin/Function0;", "onDeleteSuccess", "onReservationClick", "Lkotlin/Function2;", "onReserveSuccess", "onCancelReservationClick", "onCancelReserveSuccess", "onRecommendReservationClick", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveRecommend;", "data", "onReservationSuccess", "onRecommendReservationAuthorClick", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KUpInfo;", "upInfo", "onCancelRecommendReservationClick", "onRecommendReservationCardShow", "Lkotlin/Function1;", "onCalendarCardShow", "", "map", "onClickCard", "Lkntr/app/upcomingEpisode/base/handler/CalendarCardClickArea;", "clickArea", "onClickRetry", "onCalendarTypeChange", "newType", "checkPointType", "onSizeChange", "", "newHeight", "UpcomingEpisodeListDialog-yivurRs", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;FFFFLandroidx/compose/runtime/snapshots/SnapshotStateList;Lkntr/app/upcomingEpisode/base/stateMachine/RequestStatus;Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;Lkntr/app/upcomingEpisode/base/handler/CalendarType;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;IIII)V", "DragHandleBar", "currentHeightPx", "", "minPx", "maxPx", "thresholdPx", "onHeightChange", "(FFFFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "rememberDragScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "isListAtTop", "rememberDragScrollConnection-WH-ejsw", "(ZFFFFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "draggableSheet", "isEnabled", "minHeightPx", "maxHeightPx", "main_debug", "sheetHeightPx", "animatedHeight", "latestIsListAtTop", "latestSheetHeightPx", "dragStartHeightPx"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpcomingEpisodeListDialogKt {
    private static final String TAG = "UpcomingEpisodeListDialog";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DragHandleBar$lambda$1(float f, float f2, float f3, float f4, Function1 function1, Function1 function12, int i, Composer composer, int i2) {
        DragHandleBar(f, f2, f3, f4, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$24(Modifier modifier, LazyListState lazyListState, float f, float f2, float f3, float f4, SnapshotStateList snapshotStateList, RequestStatus requestStatus, RequestFrom requestFrom, CalendarType calendarType, List list, boolean z, String str, String str2, Function3 function3, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function1 function1, Function1 function12, Function2 function26, Function0 function0, Function1 function13, Function0 function02, Function1 function14, int i, int i2, int i3, int i4, Composer composer, int i5) {
        m1257UpcomingEpisodeListDialogyivurRs(modifier, lazyListState, f, f2, f3, f4, snapshotStateList, requestStatus, requestFrom, calendarType, list, z, str, str2, function3, function2, function22, function23, function24, function25, function1, function12, function26, function0, function13, function02, function14, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$0$0(KWatchBizType kWatchBizType, String str, Function0 function0) {
        Intrinsics.checkNotNullParameter(kWatchBizType, "<unused var>");
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$1$0(String str, Function0 function0) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$2$0(String str, Function0 function0) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$3$0(KReserveRecommend kReserveRecommend, Function0 function0) {
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$4$0(KUpInfo kUpInfo, KReserveRecommend kReserveRecommend) {
        Intrinsics.checkNotNullParameter(kUpInfo, "<unused var>");
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$5$0(KReserveRecommend kReserveRecommend, Function0 function0) {
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$6$0(KReserveRecommend kReserveRecommend) {
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$7$0(Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$8$0(CalendarCardClickArea calendarCardClickArea, Map map) {
        Intrinsics.checkNotNullParameter(calendarCardClickArea, "<unused var>");
        Intrinsics.checkNotNullParameter(map, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$10$0(CalendarType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$12$0(int it) {
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -119
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    /* renamed from: UpcomingEpisodeListDialog-yivurRs  reason: not valid java name */
    public static final void m1257UpcomingEpisodeListDialogyivurRs(androidx.compose.ui.Modifier r128, androidx.compose.foundation.lazy.LazyListState r129, float r130, float r131, float r132, float r133, androidx.compose.runtime.snapshots.SnapshotStateList<kntr.app.upcomingEpisode.list.model.CalendarCard> r134, kntr.app.upcomingEpisode.base.stateMachine.RequestStatus r135, kntr.app.upcomingEpisode.base.stateMachine.RequestFrom r136, kntr.app.upcomingEpisode.base.handler.CalendarType r137, java.util.List<com.bapis.bilibili.community.interfacess.watch.v1.KRecommend> r138, boolean r139, java.lang.String r140, java.lang.String r141, kotlin.jvm.functions.Function3<? super com.bapis.bilibili.community.interfacess.watch.v1.KWatchBizType, ? super java.lang.String, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.Unit> r142, kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.Unit> r143, kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.Unit> r144, kotlin.jvm.functions.Function2<? super com.bapis.bilibili.community.interfacess.watch.v1.KReserveRecommend, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.Unit> r145, kotlin.jvm.functions.Function2<? super com.bapis.bilibili.community.interfacess.watch.v1.KUpInfo, ? super com.bapis.bilibili.community.interfacess.watch.v1.KReserveRecommend, kotlin.Unit> r146, kotlin.jvm.functions.Function2<? super com.bapis.bilibili.community.interfacess.watch.v1.KReserveRecommend, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.Unit> r147, kotlin.jvm.functions.Function1<? super com.bapis.bilibili.community.interfacess.watch.v1.KReserveRecommend, kotlin.Unit> r148, kotlin.jvm.functions.Function1<? super java.util.Map<java.lang.String, java.lang.String>, kotlin.Unit> r149, kotlin.jvm.functions.Function2<? super kntr.app.upcomingEpisode.base.handler.CalendarCardClickArea, ? super java.util.Map<java.lang.String, java.lang.String>, kotlin.Unit> r150, kotlin.jvm.functions.Function0<kotlin.Unit> r151, kotlin.jvm.functions.Function1<? super kntr.app.upcomingEpisode.base.handler.CalendarType, kotlin.Unit> r152, kotlin.jvm.functions.Function0<kotlin.Unit> r153, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r154, androidx.compose.runtime.Composer r155, int r156, int r157, int r158, int r159) {
        /*
            Method dump skipped, instructions count: 4309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListDialogKt.m1257UpcomingEpisodeListDialogyivurRs(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, float, float, float, float, androidx.compose.runtime.snapshots.SnapshotStateList, kntr.app.upcomingEpisode.base.stateMachine.RequestStatus, kntr.app.upcomingEpisode.base.stateMachine.RequestFrom, kntr.app.upcomingEpisode.base.handler.CalendarType, java.util.List, boolean, java.lang.String, java.lang.String, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float UpcomingEpisodeListDialog_yivurRs$lambda$16(MutableFloatState $sheetHeightPx$delegate) {
        FloatState $this$getValue$iv = (FloatState) $sheetHeightPx$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    private static final float UpcomingEpisodeListDialog_yivurRs$lambda$21(State<Dp> state) {
        Object thisObj$iv = state.getValue();
        return ((Dp) thisObj$iv).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$23$0$0(Function1 $onSizeChange, IntSize newSize) {
        $onSizeChange.invoke(Integer.valueOf((int) (4294967295L & newSize.unbox-impl())));
        return Unit.INSTANCE;
    }

    private static final boolean UpcomingEpisodeListDialog_yivurRs$lambda$23$1$1(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean UpcomingEpisodeListDialog_yivurRs$lambda$23$1$0$0(LazyListState $listState) {
        return $listState.getFirstVisibleItemIndex() == 0 && $listState.getFirstVisibleItemScrollOffset() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$23$1$2$0$0(MutableFloatState $sheetHeightPx$delegate, float it) {
        $sheetHeightPx$delegate.setFloatValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeListDialog_yivurRs$lambda$23$1$2$1$0(MutableFloatState $sheetHeightPx$delegate, float it) {
        $sheetHeightPx$delegate.setFloatValue(it);
        return Unit.INSTANCE;
    }

    private static final void DragHandleBar(final float currentHeightPx, final float minPx, final float maxPx, final float thresholdPx, final Function1<? super Float, Unit> function1, final Function1<? super CalendarType, Unit> function12, Composer $composer, final int $changed) {
        int $dirty;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1244413959);
        ComposerKt.sourceInformation($composer2, "C(DragHandleBar)N(currentHeightPx,minPx,maxPx,thresholdPx,onHeightChange,onCalendarTypeChange)212@10183L1065:UpcomingEpisodeListDialog.kt#kr57tx");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(currentHeightPx) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(minPx) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(maxPx) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(thresholdPx) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function12) ? 131072 : 65536;
        }
        if (!$composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1244413959, $dirty2, -1, "kntr.app.upcomingEpisode.list.ui.DragHandleBar (UpcomingEpisodeListDialog.kt:211)");
            }
            Modifier modifier$iv = draggableSheet(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), true, currentHeightPx, minPx, maxPx, thresholdPx, function1, function12);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            $dirty = $dirty2;
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
            int i2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$DragHandleBar_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -538477973, "C235@11077L6,227@10705L537:UpcomingEpisodeListDialog.kt#kr57tx");
            BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default($this$DragHandleBar_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getCenter()), 0.0f, Dp.constructor-impl(8), 0.0f, Dp.constructor-impl(12), 5, (Object) null), Dp.constructor-impl(30)), Dp.constructor-impl(3)), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBa0_s-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16))), $composer2, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListDialogKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit DragHandleBar$lambda$1;
                    DragHandleBar$lambda$1 = UpcomingEpisodeListDialogKt.DragHandleBar$lambda$1(currentHeightPx, minPx, maxPx, thresholdPx, function1, function12, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DragHandleBar$lambda$1;
                }
            });
        }
    }

    /* renamed from: rememberDragScrollConnection-WH-ejsw  reason: not valid java name */
    private static final NestedScrollConnection m1258rememberDragScrollConnectionWHejsw(boolean isListAtTop, final float currentHeightPx, float minPx, float maxPx, float f, final Function1<? super Float, Unit> function1, final Function1<? super CalendarType, Unit> function12, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1290270588, "C(rememberDragScrollConnection)N(isListAtTop,currentHeightPx,minPx,maxPx,threshold:c#ui.unit.Dp,onHeightChange,onCalendarTypeChange)253@11622L33,254@11687L37,255@11754L37,256@11832L7,257@11883L27,258@11932L27,259@11971L3724:UpcomingEpisodeListDialog.kt#kr57tx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1290270588, $changed, -1, "kntr.app.upcomingEpisode.list.ui.rememberDragScrollConnection (UpcomingEpisodeListDialog.kt:251)");
        }
        final State latestIsListAtTop$delegate = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(isListAtTop), $composer, $changed & 14);
        final State latestSheetHeightPx$delegate = SnapshotStateKt.rememberUpdatedState(Float.valueOf(currentHeightPx), $composer, ($changed >> 3) & 14);
        ComposerKt.sourceInformationMarkerStart($composer, -1295498015, "CC(remember):UpcomingEpisodeListDialog.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(-1.0f);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        final MutableFloatState dragStartHeightPx$delegate = (MutableFloatState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$rememberDragScrollConnection_WH_ejsw_u24lambda_u245 = (Density) consume;
        final float thresholdPx = $this$rememberDragScrollConnection_WH_ejsw_u24lambda_u245.toPx-0680j_4(f);
        final State minPxState = SnapshotStateKt.rememberUpdatedState(Float.valueOf(minPx), $composer, ($changed >> 6) & 14);
        final State maxPxState = SnapshotStateKt.rememberUpdatedState(Float.valueOf(maxPx), $composer, ($changed >> 9) & 14);
        ComposerKt.sourceInformationMarkerStart($composer, -1295487384, "CC(remember):UpcomingEpisodeListDialog.kt#9igjgp");
        Object value$iv2 = $composer.rememberedValue();
        if (value$iv2 == Composer.Companion.getEmpty()) {
            value$iv2 = new NestedScrollConnection() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListDialogKt$rememberDragScrollConnection$1$1
                private float accumulatedOffset;

                public final float getAccumulatedOffset() {
                    return this.accumulatedOffset;
                }

                public final void setAccumulatedOffset(float f2) {
                    this.accumulatedOffset = f2;
                }

                public final void consumeOffset(float dy) {
                    float rememberDragScrollConnection_WH_ejsw$lambda$1;
                    float rememberDragScrollConnection_WH_ejsw$lambda$12;
                    if (dy == 0.0f) {
                        return;
                    }
                    this.accumulatedOffset += dy;
                    rememberDragScrollConnection_WH_ejsw$lambda$1 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$1(latestSheetHeightPx$delegate);
                    float newHeight = RangesKt.coerceIn(rememberDragScrollConnection_WH_ejsw$lambda$1 - dy, ((Number) minPxState.getValue()).floatValue(), ((Number) maxPxState.getValue()).floatValue());
                    function1.invoke(Float.valueOf(newHeight));
                    ILogger kLog = KLog_androidKt.getKLog();
                    float f2 = this.accumulatedOffset;
                    rememberDragScrollConnection_WH_ejsw$lambda$12 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$1(latestSheetHeightPx$delegate);
                    kLog.i("UpcomingEpisodeListDialog", "consumeOffset, dy: " + dy + ", accumulatedOffset: " + f2 + ", latestSheetHeightPx: " + rememberDragScrollConnection_WH_ejsw$lambda$12 + ", newHeight: " + newHeight + ", minPxState: " + minPxState.getValue() + ", maxPxState: " + maxPxState.getValue());
                }

                /* JADX WARN: Code restructure failed: missing block: B:17:0x00ad, code lost:
                    if ((r5 == ((java.lang.Number) r2.getValue()).floatValue()) != false) goto L20;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:24:0x00cb, code lost:
                    if ((r2 == ((java.lang.Number) r1.getValue()).floatValue()) != false) goto L17;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:25:0x00cd, code lost:
                    consumeOffset(r9);
                    r10 = java.lang.Float.floatToRawIntBits(0.0f);
                    r12 = java.lang.Float.floatToRawIntBits(r9);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
                    return androidx.compose.ui.geometry.Offset.constructor-impl((r10 << 32) | (4294967295L & r12));
                 */
                /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public long m1262onPreScrollOzD1aCk(long j, int i) {
                    float rememberDragScrollConnection_WH_ejsw$lambda$3;
                    boolean rememberDragScrollConnection_WH_ejsw$lambda$0;
                    float rememberDragScrollConnection_WH_ejsw$lambda$32;
                    boolean rememberDragScrollConnection_WH_ejsw$lambda$02;
                    float rememberDragScrollConnection_WH_ejsw$lambda$1;
                    float rememberDragScrollConnection_WH_ejsw$lambda$12;
                    float rememberDragScrollConnection_WH_ejsw$lambda$13;
                    int bits$iv$iv$iv = (int) (j & 4294967295L);
                    float dy = Float.intBitsToFloat(bits$iv$iv$iv);
                    rememberDragScrollConnection_WH_ejsw$lambda$3 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$3(dragStartHeightPx$delegate);
                    if (rememberDragScrollConnection_WH_ejsw$lambda$3 == -1.0f) {
                        MutableFloatState mutableFloatState = dragStartHeightPx$delegate;
                        rememberDragScrollConnection_WH_ejsw$lambda$13 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$1(latestSheetHeightPx$delegate);
                        mutableFloatState.setFloatValue(rememberDragScrollConnection_WH_ejsw$lambda$13);
                    }
                    ILogger kLog = KLog_androidKt.getKLog();
                    rememberDragScrollConnection_WH_ejsw$lambda$0 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$0(latestIsListAtTop$delegate);
                    rememberDragScrollConnection_WH_ejsw$lambda$32 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$3(dragStartHeightPx$delegate);
                    kLog.i("UpcomingEpisodeListDialog", "onPreScroll, dy: " + dy + ", latestIsListAtTop: " + rememberDragScrollConnection_WH_ejsw$lambda$0 + ", dragStartHeightPx: " + rememberDragScrollConnection_WH_ejsw$lambda$32 + ", currentHeightPx: " + currentHeightPx);
                    rememberDragScrollConnection_WH_ejsw$lambda$02 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$0(latestIsListAtTop$delegate);
                    if (rememberDragScrollConnection_WH_ejsw$lambda$02) {
                        if (dy < 0.0f) {
                            rememberDragScrollConnection_WH_ejsw$lambda$12 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$1(latestSheetHeightPx$delegate);
                        }
                        if (dy > 0.0f) {
                            rememberDragScrollConnection_WH_ejsw$lambda$1 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$1(latestSheetHeightPx$delegate);
                        }
                        return Offset.Companion.getZero-F1C5BW0();
                    }
                    return Offset.Companion.getZero-F1C5BW0();
                }

                /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
                public long m1260onPostScrollDzOQY0M(long j, long j2, int i) {
                    boolean rememberDragScrollConnection_WH_ejsw$lambda$0;
                    boolean rememberDragScrollConnection_WH_ejsw$lambda$02;
                    int bits$iv$iv$iv = (int) (j2 & 4294967295L);
                    float dy = Float.intBitsToFloat(bits$iv$iv$iv);
                    ILogger kLog = KLog_androidKt.getKLog();
                    rememberDragScrollConnection_WH_ejsw$lambda$0 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$0(latestIsListAtTop$delegate);
                    kLog.i("UpcomingEpisodeListDialog", "onPostScroll, dy: " + dy + ", latestIsListAtTop: " + rememberDragScrollConnection_WH_ejsw$lambda$0);
                    rememberDragScrollConnection_WH_ejsw$lambda$02 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$0(latestIsListAtTop$delegate);
                    if (rememberDragScrollConnection_WH_ejsw$lambda$02) {
                        consumeOffset(dy);
                        long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                        long v2$iv$iv = Float.floatToRawIntBits(dy);
                        return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
                    }
                    return Offset.Companion.getZero-F1C5BW0();
                }

                /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
                public Object m1261onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
                    boolean rememberDragScrollConnection_WH_ejsw$lambda$0;
                    boolean rememberDragScrollConnection_WH_ejsw$lambda$02;
                    long j2;
                    ILogger kLog = KLog_androidKt.getKLog();
                    rememberDragScrollConnection_WH_ejsw$lambda$0 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$0(latestIsListAtTop$delegate);
                    kLog.i("UpcomingEpisodeListDialog", "onPreFling, latestIsListAtTop: " + rememberDragScrollConnection_WH_ejsw$lambda$0);
                    rememberDragScrollConnection_WH_ejsw$lambda$02 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$0(latestIsListAtTop$delegate);
                    if (rememberDragScrollConnection_WH_ejsw$lambda$02) {
                        j2 = j;
                    } else {
                        j2 = Velocity.Companion.getZero-9UxMQ8M();
                    }
                    return Velocity.box-impl(j2);
                }

                /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
                public Object m1259onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
                    float rememberDragScrollConnection_WH_ejsw$lambda$3;
                    boolean rememberDragScrollConnection_WH_ejsw$lambda$0;
                    float rememberDragScrollConnection_WH_ejsw$lambda$32;
                    boolean rememberDragScrollConnection_WH_ejsw$lambda$02;
                    long j3;
                    if (this.accumulatedOffset > thresholdPx) {
                        function1.invoke(minPxState.getValue());
                        function12.invoke(CalendarType.MONTH);
                    } else if (this.accumulatedOffset < (-thresholdPx)) {
                        function1.invoke(maxPxState.getValue());
                        function12.invoke(CalendarType.WEEK);
                    } else {
                        Function1<Float, Unit> function13 = function1;
                        rememberDragScrollConnection_WH_ejsw$lambda$3 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$3(dragStartHeightPx$delegate);
                        function13.invoke(Boxing.boxFloat(rememberDragScrollConnection_WH_ejsw$lambda$3));
                    }
                    ILogger kLog = KLog_androidKt.getKLog();
                    rememberDragScrollConnection_WH_ejsw$lambda$0 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$0(latestIsListAtTop$delegate);
                    float f2 = this.accumulatedOffset;
                    rememberDragScrollConnection_WH_ejsw$lambda$32 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$3(dragStartHeightPx$delegate);
                    kLog.i("UpcomingEpisodeListDialog", "onPostFling, latestIsListAtTop: " + rememberDragScrollConnection_WH_ejsw$lambda$0 + ", accumulatedOffset: " + f2 + ", dragStartHeightPx: " + rememberDragScrollConnection_WH_ejsw$lambda$32);
                    this.accumulatedOffset = 0.0f;
                    dragStartHeightPx$delegate.setFloatValue(-1.0f);
                    rememberDragScrollConnection_WH_ejsw$lambda$02 = UpcomingEpisodeListDialogKt.rememberDragScrollConnection_WH_ejsw$lambda$0(latestIsListAtTop$delegate);
                    if (rememberDragScrollConnection_WH_ejsw$lambda$02) {
                        j3 = j2;
                    } else {
                        j3 = Velocity.Companion.getZero-9UxMQ8M();
                    }
                    return Velocity.box-impl(j3);
                }
            };
            $composer.updateRememberedValue(value$iv2);
        }
        UpcomingEpisodeListDialogKt$rememberDragScrollConnection$1$1 upcomingEpisodeListDialogKt$rememberDragScrollConnection$1$1 = (UpcomingEpisodeListDialogKt$rememberDragScrollConnection$1$1) value$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return upcomingEpisodeListDialogKt$rememberDragScrollConnection$1$1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberDragScrollConnection_WH_ejsw$lambda$0(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float rememberDragScrollConnection_WH_ejsw$lambda$1(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float rememberDragScrollConnection_WH_ejsw$lambda$3(MutableFloatState $dragStartHeightPx$delegate) {
        FloatState $this$getValue$iv = (FloatState) $dragStartHeightPx$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    private static final Modifier draggableSheet(Modifier $this$draggableSheet, boolean isEnabled, float currentHeightPx, float minHeightPx, float maxHeightPx, float thresholdPx, Function1<? super Float, Unit> function1, Function1<? super CalendarType, Unit> function12) {
        return $this$draggableSheet.then(new DraggableSheetNodeElement(isEnabled, currentHeightPx, minHeightPx, maxHeightPx, thresholdPx, function1, function12));
    }
}