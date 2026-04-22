package kntr.app.upcomingEpisode.calendar.utils;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ScrollIndicatorState;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import j$.time.DayOfWeek;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.model.CalendarInfo;
import kntr.app.upcomingEpisode.calendar.model.Month;
import kntr.app.upcomingEpisode.calendar.model.MonthDataKt;
import kntr.app.upcomingEpisode.calendar.model.YearMonth;
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

/* compiled from: BiliMonthCalendarState.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 W2\u00020\u0001:\u0001WB7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010>\u001a\u00020?H\u0002J\u0016\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020\u0003H\u0087@¢\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020?2\u0006\u0010A\u001a\u00020\u0003H\u0087@¢\u0006\u0002\u0010BJ\u0017\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010A\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010FJ\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020KH\u0016J?\u0010M\u001a\u00020?2\u0006\u0010N\u001a\u00020O2'\u0010P\u001a#\b\u0001\u0012\u0004\u0012\u00020R\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0S\u0012\u0006\u0012\u0004\u0018\u00010T0Q¢\u0006\u0002\bUH\u0096@¢\u0006\u0002\u0010VR+\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R+\u0010\u0018\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R3\u0010\u001e\u001a\u00060\u0006j\u0002`\u00072\n\u0010\r\u001a\u00060\u0006j\u0002`\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0014\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R,\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\n\u0010\u0015\u001a\u00060\u0006j\u0002`\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001b\u0010\b\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u0011\u0010+\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010-\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0014\u0010/\u001a\u000200X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R+\u00104\u001a\u0002032\u0006\u0010\r\u001a\u0002038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010\u0014\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020&0;X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0014\u0010G\u001a\u00020H8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010I¨\u0006X"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/utils/BiliMonthCalendarState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "startMonth", "Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "endMonth", "firstDayOfWeek", "Ljava/time/DayOfWeek;", "Lkotlinx/datetime/DayOfWeek;", "firstVisibleMonth", "visibleItemState", "Lkntr/app/upcomingEpisode/calendar/utils/VisibleItemState;", "<init>", "(Lkntr/app/upcomingEpisode/calendar/model/YearMonth;Lkntr/app/upcomingEpisode/calendar/model/YearMonth;Ljava/time/DayOfWeek;Lkntr/app/upcomingEpisode/calendar/model/YearMonth;Lkntr/app/upcomingEpisode/calendar/utils/VisibleItemState;)V", "<set-?>", "_startMonth", "get_startMonth", "()Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "set_startMonth", "(Lkntr/app/upcomingEpisode/calendar/model/YearMonth;)V", "_startMonth$delegate", "Landroidx/compose/runtime/MutableState;", "value", "getStartMonth", "setStartMonth", "_endMonth", "get_endMonth", "set_endMonth", "_endMonth$delegate", "getEndMonth", "setEndMonth", "_firstDayOfWeek", "get_firstDayOfWeek", "()Ljava/time/DayOfWeek;", "set_firstDayOfWeek", "(Ljava/time/DayOfWeek;)V", "_firstDayOfWeek$delegate", "getFirstDayOfWeek", "setFirstDayOfWeek", "Lkntr/app/upcomingEpisode/calendar/model/Month;", "getFirstVisibleMonth", "()Lkntr/app/upcomingEpisode/calendar/model/Month;", "firstVisibleMonth$delegate", "Landroidx/compose/runtime/State;", "firstMonth", "getFirstMonth", "lastMonth", "getLastMonth", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "getListState$main_debug", "()Landroidx/compose/foundation/lazy/LazyListState;", "Lkntr/app/upcomingEpisode/calendar/model/CalendarInfo;", "calendarInfo", "getCalendarInfo$main_debug", "()Lkntr/app/upcomingEpisode/calendar/model/CalendarInfo;", "setCalendarInfo$main_debug", "(Lkntr/app/upcomingEpisode/calendar/model/CalendarInfo;)V", "calendarInfo$delegate", "store", "Lkntr/app/upcomingEpisode/calendar/utils/BiliCalendarDataStore;", "getStore$main_debug", "()Lkntr/app/upcomingEpisode/calendar/utils/BiliCalendarDataStore;", "monthDataChanged", "", "scrollToMonth", "month", "(Lkntr/app/upcomingEpisode/calendar/model/YearMonth;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateScrollToMonth", "getScrollIndex", "", "(Lkntr/app/upcomingEpisode/calendar/model/YearMonth;)Ljava/lang/Integer;", "isScrollInProgress", "", "()Z", "dispatchRawDelta", "", "delta", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliMonthCalendarState implements ScrollableState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final Saver<BiliMonthCalendarState, Object> Saver = ListSaverKt.listSaver(new Function2() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliMonthCalendarState$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            List Saver$lambda$0;
            Saver$lambda$0 = BiliMonthCalendarState.Saver$lambda$0((SaverScope) obj, (BiliMonthCalendarState) obj2);
            return Saver$lambda$0;
        }
    }, new Function1() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliMonthCalendarState$$ExternalSyntheticLambda3
        public final Object invoke(Object obj) {
            BiliMonthCalendarState Saver$lambda$1;
            Saver$lambda$1 = BiliMonthCalendarState.Saver$lambda$1((List) obj);
            return Saver$lambda$1;
        }
    });
    private static final String TAG = "BiliMonthCalendarState";
    private final MutableState _endMonth$delegate;
    private final MutableState _firstDayOfWeek$delegate;
    private final MutableState _startMonth$delegate;
    private final MutableState calendarInfo$delegate;
    private final Month firstMonth;
    private final State firstVisibleMonth$delegate;
    private final Month lastMonth;
    private final LazyListState listState;
    private final BiliCalendarDataStore<Month> store;

    public BiliMonthCalendarState(YearMonth startMonth, YearMonth endMonth, DayOfWeek firstDayOfWeek, YearMonth firstVisibleMonth, VisibleItemState visibleItemState) {
        int intValue;
        Intrinsics.checkNotNullParameter(startMonth, "startMonth");
        Intrinsics.checkNotNullParameter(endMonth, "endMonth");
        Intrinsics.checkNotNullParameter(firstDayOfWeek, "firstDayOfWeek");
        Intrinsics.checkNotNullParameter(firstVisibleMonth, "firstVisibleMonth");
        this._startMonth$delegate = SnapshotStateKt.mutableStateOf$default(startMonth, (SnapshotMutationPolicy) null, 2, (Object) null);
        this._endMonth$delegate = SnapshotStateKt.mutableStateOf$default(endMonth, (SnapshotMutationPolicy) null, 2, (Object) null);
        this._firstDayOfWeek$delegate = SnapshotStateKt.mutableStateOf$default(firstDayOfWeek, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.firstVisibleMonth$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliMonthCalendarState$$ExternalSyntheticLambda0
            public final Object invoke() {
                Month firstVisibleMonth_delegate$lambda$0;
                firstVisibleMonth_delegate$lambda$0 = BiliMonthCalendarState.firstVisibleMonth_delegate$lambda$0(BiliMonthCalendarState.this);
                return firstVisibleMonth_delegate$lambda$0;
            }
        });
        this.firstMonth = MonthDataKt.getCalendarMonthData(getStartMonth(), 0, getFirstDayOfWeek()).getCalendarMonth();
        this.lastMonth = MonthDataKt.getCalendarMonthData(getEndMonth(), 0, getFirstDayOfWeek()).getCalendarMonth();
        if (visibleItemState != null) {
            intValue = visibleItemState.getFirstVisibleItemIndex();
        } else {
            Integer scrollIndex = getScrollIndex(firstVisibleMonth);
            intValue = scrollIndex != null ? scrollIndex.intValue() : 0;
        }
        this.listState = new LazyListState(intValue, visibleItemState != null ? visibleItemState.getFirstVisibleItemScrollOffset() : 0);
        this.calendarInfo$delegate = SnapshotStateKt.mutableStateOf$default(new CalendarInfo(0, null, 2, null), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.store = new BiliCalendarDataStore<>(null, new Function1() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliMonthCalendarState$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Month store$lambda$0;
                store$lambda$0 = BiliMonthCalendarState.store$lambda$0(BiliMonthCalendarState.this, ((Integer) obj).intValue());
                return store$lambda$0;
            }
        }, 1, null);
        monthDataChanged();
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

    private final YearMonth get_startMonth() {
        State $this$getValue$iv = this._startMonth$delegate;
        return (YearMonth) $this$getValue$iv.getValue();
    }

    private final void set_startMonth(YearMonth yearMonth) {
        MutableState $this$setValue$iv = this._startMonth$delegate;
        $this$setValue$iv.setValue(yearMonth);
    }

    public final YearMonth getStartMonth() {
        return get_startMonth();
    }

    public final void setStartMonth(YearMonth value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(value, getStartMonth())) {
            set_startMonth(value);
            monthDataChanged();
        }
    }

    private final YearMonth get_endMonth() {
        State $this$getValue$iv = this._endMonth$delegate;
        return (YearMonth) $this$getValue$iv.getValue();
    }

    private final void set_endMonth(YearMonth yearMonth) {
        MutableState $this$setValue$iv = this._endMonth$delegate;
        $this$setValue$iv.setValue(yearMonth);
    }

    public final YearMonth getEndMonth() {
        return get_endMonth();
    }

    public final void setEndMonth(YearMonth value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(value, getEndMonth())) {
            set_endMonth(value);
            monthDataChanged();
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
        if (value != getFirstDayOfWeek()) {
            set_firstDayOfWeek(value);
            monthDataChanged();
        }
    }

    public final Month getFirstVisibleMonth() {
        State $this$getValue$iv = this.firstVisibleMonth$delegate;
        return (Month) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Month firstVisibleMonth_delegate$lambda$0(BiliMonthCalendarState this$0) {
        return this$0.store.get(Integer.valueOf(this$0.listState.getFirstVisibleItemIndex()));
    }

    public final Month getFirstMonth() {
        return this.firstMonth;
    }

    public final Month getLastMonth() {
        return this.lastMonth;
    }

    public final LazyListState getListState$main_debug() {
        return this.listState;
    }

    public final CalendarInfo getCalendarInfo$main_debug() {
        State $this$getValue$iv = this.calendarInfo$delegate;
        return (CalendarInfo) $this$getValue$iv.getValue();
    }

    public final void setCalendarInfo$main_debug(CalendarInfo calendarInfo) {
        Intrinsics.checkNotNullParameter(calendarInfo, "<set-?>");
        MutableState $this$setValue$iv = this.calendarInfo$delegate;
        $this$setValue$iv.setValue(calendarInfo);
    }

    public final BiliCalendarDataStore<Month> getStore$main_debug() {
        return this.store;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Month store$lambda$0(BiliMonthCalendarState this$0, int offset) {
        return MonthDataKt.getCalendarMonthData(this$0.getStartMonth(), offset, this$0.getFirstDayOfWeek()).getCalendarMonth();
    }

    private final void monthDataChanged() {
        this.store.clear();
        BiliCalendarUtilsKt.checkRange(getStartMonth(), getEndMonth());
        setCalendarInfo$main_debug(new CalendarInfo(MonthDataKt.getMonthIndicesCount(getStartMonth(), getEndMonth()), getFirstDayOfWeek()));
    }

    public final Object scrollToMonth(YearMonth month, Continuation<? super Unit> continuation) {
        LazyListState lazyListState = this.listState;
        Integer scrollIndex = getScrollIndex(month);
        if (scrollIndex != null) {
            Object scrollToItem$default = LazyListState.scrollToItem$default(lazyListState, scrollIndex.intValue(), 0, continuation, 2, (Object) null);
            return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final Object animateScrollToMonth(YearMonth month, Continuation<? super Unit> continuation) {
        LazyListState lazyListState = this.listState;
        Integer scrollIndex = getScrollIndex(month);
        if (scrollIndex != null) {
            Object animateScrollToItem$default = LazyListState.animateScrollToItem$default(lazyListState, scrollIndex.intValue(), 0, continuation, 2, (Object) null);
            return animateScrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem$default : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final Integer getScrollIndex(YearMonth month) {
        YearMonth startMonth = getStartMonth();
        boolean z = false;
        if (month.compareTo(getEndMonth()) <= 0 && month.compareTo(startMonth) >= 0) {
            z = true;
        }
        if (!z) {
            KLog_androidKt.getKLog().i(TAG, "Attempting to scroll out of range: " + month);
            return null;
        }
        return Integer.valueOf(MonthDataKt.getMonthIndex(getStartMonth(), month));
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

    /* compiled from: BiliMonthCalendarState.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/utils/BiliMonthCalendarState$Companion;", "", "<init>", "()V", "TAG", "", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Lkntr/app/upcomingEpisode/calendar/utils/BiliMonthCalendarState;", "getSaver$main_debug", "()Landroidx/compose/runtime/saveable/Saver;", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<BiliMonthCalendarState, Object> getSaver$main_debug() {
            return BiliMonthCalendarState.Saver;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Saver$lambda$0(SaverScope $this$listSaver, BiliMonthCalendarState it) {
        Intrinsics.checkNotNullParameter($this$listSaver, "$this$listSaver");
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.listOf(new Object[]{DateFormatExtentionsKt.toIso8601String(it.getStartMonth()), DateFormatExtentionsKt.toIso8601String(it.getEndMonth()), DateFormatExtentionsKt.toIso8601String(it.getFirstVisibleMonth().getYearMonth()), Integer.valueOf(DayOfWeekKt.getIsoDayNumber(it.getFirstDayOfWeek())), Integer.valueOf(it.listState.getFirstVisibleItemIndex()), Integer.valueOf(it.listState.getFirstVisibleItemScrollOffset())});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BiliMonthCalendarState Saver$lambda$1(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object obj = it.get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        YearMonth fromIso8601YearMonth = DateFormatExtentionsKt.fromIso8601YearMonth((String) obj);
        Object obj2 = it.get(1);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
        YearMonth fromIso8601YearMonth2 = DateFormatExtentionsKt.fromIso8601YearMonth((String) obj2);
        Object obj3 = it.get(2);
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
        YearMonth fromIso8601YearMonth3 = DateFormatExtentionsKt.fromIso8601YearMonth((String) obj3);
        Object obj4 = it.get(3);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
        DayOfWeek DayOfWeek = DayOfWeekKt.DayOfWeek(((Integer) obj4).intValue());
        Object obj5 = it.get(4);
        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj5).intValue();
        Object obj6 = it.get(5);
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Int");
        return new BiliMonthCalendarState(fromIso8601YearMonth, fromIso8601YearMonth2, DayOfWeek, fromIso8601YearMonth3, new VisibleItemState(intValue, ((Integer) obj6).intValue()));
    }
}