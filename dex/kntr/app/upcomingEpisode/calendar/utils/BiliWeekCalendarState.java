package kntr.app.upcomingEpisode.calendar.utils;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ScrollIndicatorState;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import j$.time.DayOfWeek;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.model.Week;
import kntr.app.upcomingEpisode.calendar.model.WeekDataKt;
import kntr.app.upcomingEpisode.calendar.model.WeekDateRange;
import kntr.app.upcomingEpisode.calendar.model.WeekDay;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DayOfWeekKt;
import kotlinx.datetime.LocalDate;

/* compiled from: BiliWeekCalendarState.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0001\\B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010D\u001a\u00020EH\u0002J\u0016\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u0003H\u0087@¢\u0006\u0002\u0010HJ\u0016\u0010I\u001a\u00020E2\u0006\u0010G\u001a\u00020\u0003H\u0087@¢\u0006\u0002\u0010HJ\u0010\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020NH\u0016J?\u0010P\u001a\u00020E2\u0006\u0010Q\u001a\u00020R2'\u0010S\u001a#\b\u0001\u0012\u0004\u0012\u00020U\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0V\u0012\u0006\u0012\u0004\u0018\u00010W0T¢\u0006\u0002\bXH\u0096@¢\u0006\u0002\u0010YJ\u0017\u0010Z\u001a\u0004\u0018\u0001082\u0006\u0010G\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010[R+\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u0015\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R+\u0010\u0019\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R+\u0010 \u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0014\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012R3\u0010&\u001a\u00060\u0007j\u0002`\b2\n\u0010\r\u001a\u00060\u0007j\u0002`\b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0014\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R,\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\n\u0010\u001d\u001a\u00060\u0007j\u0002`\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001b\u0010.\u001a\u00020/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020/05X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R+\u00109\u001a\u0002082\u0006\u0010\r\u001a\u0002088@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020AX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0014\u0010J\u001a\u00020K8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010L¨\u0006]"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/utils/BiliWeekCalendarState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "startDate", "Lkotlinx/datetime/LocalDate;", "endDate", "firstVisibleWeekDate", "firstDayOfWeek", "Ljava/time/DayOfWeek;", "Lkotlinx/datetime/DayOfWeek;", "visibleItemState", "Lkntr/app/upcomingEpisode/calendar/utils/VisibleItemState;", "<init>", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDate;Ljava/time/DayOfWeek;Lkntr/app/upcomingEpisode/calendar/utils/VisibleItemState;)V", "<set-?>", "startDateAdjusted", "getStartDateAdjusted", "()Lkotlinx/datetime/LocalDate;", "setStartDateAdjusted", "(Lkotlinx/datetime/LocalDate;)V", "startDateAdjusted$delegate", "Landroidx/compose/runtime/MutableState;", "endDateAdjusted", "getEndDateAdjusted", "setEndDateAdjusted", "endDateAdjusted$delegate", "_startDate", "get_startDate", "set_startDate", "_startDate$delegate", "value", "getStartDate", "setStartDate", "_endDate", "get_endDate", "set_endDate", "_endDate$delegate", "getEndDate", "setEndDate", "_firstDayOfWeek", "get_firstDayOfWeek", "()Ljava/time/DayOfWeek;", "set_firstDayOfWeek", "(Ljava/time/DayOfWeek;)V", "_firstDayOfWeek$delegate", "getFirstDayOfWeek", "setFirstDayOfWeek", "firstVisibleWeek", "Lkntr/app/upcomingEpisode/calendar/model/Week;", "getFirstVisibleWeek", "()Lkntr/app/upcomingEpisode/calendar/model/Week;", "firstVisibleWeek$delegate", "Landroidx/compose/runtime/State;", "store", "Lkntr/app/upcomingEpisode/calendar/utils/BiliCalendarDataStore;", "getStore$main_debug", "()Lkntr/app/upcomingEpisode/calendar/utils/BiliCalendarDataStore;", "", "totalWeekCounts", "getTotalWeekCounts$main_debug", "()I", "setTotalWeekCounts$main_debug", "(I)V", "totalWeekCounts$delegate", "Landroidx/compose/runtime/MutableIntState;", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "getListState$main_debug", "()Landroidx/compose/foundation/lazy/LazyListState;", "adjustDateRange", "", "scrollToWeek", "date", "(Lkotlinx/datetime/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateScrollToWeek", "isScrollInProgress", "", "()Z", "dispatchRawDelta", "", "delta", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScrollIndex", "(Lkotlinx/datetime/LocalDate;)Ljava/lang/Integer;", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliWeekCalendarState implements ScrollableState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final Saver<BiliWeekCalendarState, Object> Saver = ListSaverKt.listSaver(new Function2() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliWeekCalendarState$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            List Saver$lambda$0;
            Saver$lambda$0 = BiliWeekCalendarState.Saver$lambda$0((SaverScope) obj, (BiliWeekCalendarState) obj2);
            return Saver$lambda$0;
        }
    }, new Function1() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliWeekCalendarState$$ExternalSyntheticLambda3
        public final Object invoke(Object obj) {
            BiliWeekCalendarState Saver$lambda$1;
            Saver$lambda$1 = BiliWeekCalendarState.Saver$lambda$1((List) obj);
            return Saver$lambda$1;
        }
    });
    private static final String TAG = "BiliWeekCalendarState";
    private final MutableState _endDate$delegate;
    private final MutableState _firstDayOfWeek$delegate;
    private final MutableState _startDate$delegate;
    private final MutableState endDateAdjusted$delegate;
    private final State firstVisibleWeek$delegate;
    private final LazyListState listState;
    private final MutableState startDateAdjusted$delegate;
    private final BiliCalendarDataStore<Week> store;
    private final MutableIntState totalWeekCounts$delegate;

    public BiliWeekCalendarState(LocalDate startDate, LocalDate endDate, LocalDate firstVisibleWeekDate, DayOfWeek firstDayOfWeek, VisibleItemState visibleItemState) {
        VisibleItemState visibleItemState2;
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Intrinsics.checkNotNullParameter(firstVisibleWeekDate, "firstVisibleWeekDate");
        Intrinsics.checkNotNullParameter(firstDayOfWeek, "firstDayOfWeek");
        this.startDateAdjusted$delegate = SnapshotStateKt.mutableStateOf$default(startDate, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.endDateAdjusted$delegate = SnapshotStateKt.mutableStateOf$default(endDate, (SnapshotMutationPolicy) null, 2, (Object) null);
        this._startDate$delegate = SnapshotStateKt.mutableStateOf$default(startDate, (SnapshotMutationPolicy) null, 2, (Object) null);
        this._endDate$delegate = SnapshotStateKt.mutableStateOf$default(endDate, (SnapshotMutationPolicy) null, 2, (Object) null);
        this._firstDayOfWeek$delegate = SnapshotStateKt.mutableStateOf$default(firstDayOfWeek, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.firstVisibleWeek$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliWeekCalendarState$$ExternalSyntheticLambda0
            public final Object invoke() {
                Week firstVisibleWeek_delegate$lambda$0;
                firstVisibleWeek_delegate$lambda$0 = BiliWeekCalendarState.firstVisibleWeek_delegate$lambda$0(BiliWeekCalendarState.this);
                return firstVisibleWeek_delegate$lambda$0;
            }
        });
        this.store = new BiliCalendarDataStore<>(null, new Function1() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliWeekCalendarState$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Week store$lambda$0;
                store$lambda$0 = BiliWeekCalendarState.store$lambda$0(BiliWeekCalendarState.this, ((Integer) obj).intValue());
                return store$lambda$0;
            }
        }, 1, null);
        this.totalWeekCounts$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        BiliWeekCalendarState $this$listState_u24lambda_u240 = this;
        $this$listState_u24lambda_u240.adjustDateRange();
        if (visibleItemState == null) {
            Integer scrollIndex = $this$listState_u24lambda_u240.getScrollIndex(firstVisibleWeekDate);
            visibleItemState2 = new VisibleItemState(scrollIndex != null ? scrollIndex.intValue() : 0, 0, 2, null);
        } else {
            visibleItemState2 = visibleItemState;
        }
        VisibleItemState item = visibleItemState2;
        this.listState = new LazyListState(item.getFirstVisibleItemIndex(), item.getFirstVisibleItemScrollOffset());
    }

    public /* bridge */ boolean getCanScrollBackward() {
        return ScrollableState.-CC.$default$getCanScrollBackward(this);
    }

    public /* bridge */ boolean getCanScrollForward() {
        return ScrollableState.-CC.$default$getCanScrollForward(this);
    }

    public /* bridge */ boolean getLastScrolledBackward() {
        return ScrollableState.-CC.$default$getLastScrolledBackward(this);
    }

    public /* bridge */ boolean getLastScrolledForward() {
        return ScrollableState.-CC.$default$getLastScrolledForward(this);
    }

    public /* bridge */ ScrollIndicatorState getScrollIndicatorState() {
        return ScrollableState.-CC.$default$getScrollIndicatorState(this);
    }

    private final LocalDate getStartDateAdjusted() {
        State $this$getValue$iv = this.startDateAdjusted$delegate;
        return (LocalDate) $this$getValue$iv.getValue();
    }

    private final void setStartDateAdjusted(LocalDate localDate) {
        MutableState $this$setValue$iv = this.startDateAdjusted$delegate;
        $this$setValue$iv.setValue(localDate);
    }

    private final LocalDate getEndDateAdjusted() {
        State $this$getValue$iv = this.endDateAdjusted$delegate;
        return (LocalDate) $this$getValue$iv.getValue();
    }

    private final void setEndDateAdjusted(LocalDate localDate) {
        MutableState $this$setValue$iv = this.endDateAdjusted$delegate;
        $this$setValue$iv.setValue(localDate);
    }

    private final LocalDate get_startDate() {
        State $this$getValue$iv = this._startDate$delegate;
        return (LocalDate) $this$getValue$iv.getValue();
    }

    private final void set_startDate(LocalDate localDate) {
        MutableState $this$setValue$iv = this._startDate$delegate;
        $this$setValue$iv.setValue(localDate);
    }

    public final LocalDate getStartDate() {
        return get_startDate();
    }

    public final void setStartDate(LocalDate value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(value, get_startDate())) {
            set_startDate(value);
            adjustDateRange();
        }
    }

    private final LocalDate get_endDate() {
        State $this$getValue$iv = this._endDate$delegate;
        return (LocalDate) $this$getValue$iv.getValue();
    }

    private final void set_endDate(LocalDate localDate) {
        MutableState $this$setValue$iv = this._endDate$delegate;
        $this$setValue$iv.setValue(localDate);
    }

    public final LocalDate getEndDate() {
        return get_endDate();
    }

    public final void setEndDate(LocalDate value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(value, get_endDate())) {
            set_endDate(value);
            adjustDateRange();
        }
    }

    private final DayOfWeek get_firstDayOfWeek() {
        State $this$getValue$iv = this._firstDayOfWeek$delegate;
        return (DayOfWeek) $this$getValue$iv.getValue();
    }

    private final void set_firstDayOfWeek(DayOfWeek dayOfWeek) {
        MutableState $this$setValue$iv = this._firstDayOfWeek$delegate;
        $this$setValue$iv.setValue(dayOfWeek);
    }

    public final DayOfWeek getFirstDayOfWeek() {
        return get_firstDayOfWeek();
    }

    public final void setFirstDayOfWeek(DayOfWeek value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value != get_firstDayOfWeek()) {
            set_firstDayOfWeek(value);
            adjustDateRange();
        }
    }

    public final Week getFirstVisibleWeek() {
        State $this$getValue$iv = this.firstVisibleWeek$delegate;
        return (Week) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Week firstVisibleWeek_delegate$lambda$0(BiliWeekCalendarState this$0) {
        return this$0.store.get(Integer.valueOf(this$0.listState.getFirstVisibleItemIndex()));
    }

    public final BiliCalendarDataStore<Week> getStore$main_debug() {
        return this.store;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Week store$lambda$0(BiliWeekCalendarState this$0, int offset) {
        return WeekDataKt.getWeekCalendarData(this$0.getStartDateAdjusted(), offset, this$0.getStartDate(), this$0.getEndDate()).getWeek();
    }

    public final int getTotalWeekCounts$main_debug() {
        IntState $this$getValue$iv = this.totalWeekCounts$delegate;
        return $this$getValue$iv.getIntValue();
    }

    public final void setTotalWeekCounts$main_debug(int i) {
        MutableIntState $this$setValue$iv = this.totalWeekCounts$delegate;
        $this$setValue$iv.setIntValue(i);
    }

    public final LazyListState getListState$main_debug() {
        return this.listState;
    }

    private final void adjustDateRange() {
        BiliCalendarUtilsKt.checkRange(getStartDate(), getEndDate());
        WeekDateRange adjustedRange = WeekDataKt.getWeekCalendarAdjustedRange(getStartDate(), getEndDate(), getFirstDayOfWeek());
        setStartDateAdjusted(adjustedRange.getStartDateAdjusted());
        setEndDateAdjusted(adjustedRange.getEndDateAdjusted());
        this.store.clear();
        setTotalWeekCounts$main_debug(WeekDataKt.getWeekCalendarTotalWeekCounts(getStartDateAdjusted(), getEndDateAdjusted()));
    }

    public final Object scrollToWeek(LocalDate date, Continuation<? super Unit> continuation) {
        LazyListState lazyListState = this.listState;
        Integer scrollIndex = getScrollIndex(date);
        if (scrollIndex != null) {
            Object scrollToItem$default = LazyListState.scrollToItem$default(lazyListState, scrollIndex.intValue(), 0, continuation, 2, (Object) null);
            return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final Object animateScrollToWeek(LocalDate date, Continuation<? super Unit> continuation) {
        LazyListState lazyListState = this.listState;
        Integer scrollIndex = getScrollIndex(date);
        if (scrollIndex != null) {
            Object animateScrollToItem$default = LazyListState.animateScrollToItem$default(lazyListState, scrollIndex.intValue(), 0, continuation, 2, (Object) null);
            return animateScrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem$default : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public boolean isScrollInProgress() {
        return this.listState.isScrollInProgress();
    }

    public float dispatchRawDelta(float delta) {
        return this.listState.dispatchRawDelta(delta);
    }

    public Object scroll(MutatePriority scrollPriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll = this.listState.scroll(scrollPriority, function2, continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    private final Integer getScrollIndex(LocalDate date) {
        LocalDate startDateAdjusted = getStartDateAdjusted();
        boolean z = false;
        if (((Comparable) date).compareTo(getEndDateAdjusted()) <= 0 && ((Comparable) date).compareTo(startDateAdjusted) >= 0) {
            z = true;
        }
        if (!z) {
            ILogger kLog = KLog_androidKt.getKLog();
            LocalDate startDateAdjusted2 = getStartDateAdjusted();
            kLog.i(TAG, "Attempting to scroll out of range: " + date + "， startDateAdjusted: " + startDateAdjusted2 + ", endDateAdjusted: " + getEndDateAdjusted());
            return null;
        }
        return Integer.valueOf(WeekDataKt.getWeekCalendarWeekCounts(getStartDateAdjusted(), date));
    }

    /* compiled from: BiliWeekCalendarState.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/utils/BiliWeekCalendarState$Companion;", "", "<init>", "()V", "TAG", "", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Lkntr/app/upcomingEpisode/calendar/utils/BiliWeekCalendarState;", "getSaver$main_debug", "()Landroidx/compose/runtime/saveable/Saver;", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<BiliWeekCalendarState, Object> getSaver$main_debug() {
            return BiliWeekCalendarState.Saver;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Saver$lambda$0(SaverScope $this$listSaver, BiliWeekCalendarState it) {
        Intrinsics.checkNotNullParameter($this$listSaver, "$this$listSaver");
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.listOf(new Object[]{DateFormatExtentionsKt.toIso8601String(it.getStartDate()), DateFormatExtentionsKt.toIso8601String(it.getEndDate()), DateFormatExtentionsKt.toIso8601String(((WeekDay) CollectionsKt.first(it.getFirstVisibleWeek().getDays())).getDate()), Integer.valueOf(DayOfWeekKt.getIsoDayNumber(it.getFirstDayOfWeek())), Integer.valueOf(it.listState.getFirstVisibleItemIndex()), Integer.valueOf(it.listState.getFirstVisibleItemScrollOffset())});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BiliWeekCalendarState Saver$lambda$1(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object obj = it.get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        LocalDate fromIso8601LocalDate = DateFormatExtentionsKt.fromIso8601LocalDate((String) obj);
        Object obj2 = it.get(1);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
        LocalDate fromIso8601LocalDate2 = DateFormatExtentionsKt.fromIso8601LocalDate((String) obj2);
        Object obj3 = it.get(2);
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
        LocalDate fromIso8601LocalDate3 = DateFormatExtentionsKt.fromIso8601LocalDate((String) obj3);
        Object obj4 = it.get(3);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
        DayOfWeek DayOfWeek = DayOfWeekKt.DayOfWeek(((Integer) obj4).intValue());
        Object obj5 = it.get(4);
        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj5).intValue();
        Object obj6 = it.get(5);
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Int");
        return new BiliWeekCalendarState(fromIso8601LocalDate, fromIso8601LocalDate2, fromIso8601LocalDate3, DayOfWeek, new VisibleItemState(intValue, ((Integer) obj6).intValue()));
    }
}