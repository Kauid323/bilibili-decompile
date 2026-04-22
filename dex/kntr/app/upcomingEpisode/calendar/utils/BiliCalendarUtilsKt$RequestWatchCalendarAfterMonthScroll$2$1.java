package kntr.app.upcomingEpisode.calendar.utils;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarTimeRange;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.model.Day;
import kntr.app.upcomingEpisode.calendar.model.Month;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.datetime.LocalDate;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliCalendarUtils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$RequestWatchCalendarAfterMonthScroll$2$1", f = "BiliCalendarUtils.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BiliCalendarUtilsKt$RequestWatchCalendarAfterMonthScroll$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $latestHasRequestWatchCalendar;
    final /* synthetic */ State<Function1<KCalendarTimeRange, Unit>> $latestOnMonthScroll$delegate;
    final /* synthetic */ State<SnapshotStateSet<LocalDate>> $latestPageSet;
    final /* synthetic */ BiliMonthCalendarState $monthState;
    final /* synthetic */ MutableState<Month> $visibleMonth;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliCalendarUtilsKt$RequestWatchCalendarAfterMonthScroll$2$1(BiliMonthCalendarState biliMonthCalendarState, MutableState<Month> mutableState, State<Boolean> state, State<SnapshotStateSet<LocalDate>> state2, State<? extends Function1<? super KCalendarTimeRange, Unit>> state3, Continuation<? super BiliCalendarUtilsKt$RequestWatchCalendarAfterMonthScroll$2$1> continuation) {
        super(2, continuation);
        this.$monthState = biliMonthCalendarState;
        this.$visibleMonth = mutableState;
        this.$latestHasRequestWatchCalendar = state;
        this.$latestPageSet = state2;
        this.$latestOnMonthScroll$delegate = state3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliCalendarUtilsKt$RequestWatchCalendarAfterMonthScroll$2$1(this.$monthState, this.$visibleMonth, this.$latestHasRequestWatchCalendar, this.$latestPageSet, this.$latestOnMonthScroll$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final BiliMonthCalendarState biliMonthCalendarState = this.$monthState;
                final Flow $this$filter$iv = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$RequestWatchCalendarAfterMonthScroll$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean isScrollInProgress;
                        isScrollInProgress = BiliMonthCalendarState.this.isScrollInProgress();
                        return Boolean.valueOf(isScrollInProgress);
                    }
                });
                this.label = 1;
                if (FlowKt.collectLatest(new Flow<Boolean>() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$RequestWatchCalendarAfterMonthScroll$2$1$invokeSuspend$$inlined$filter$1
                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$filter$iv.collect(new AnonymousClass2(collector), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* renamed from: kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$RequestWatchCalendarAfterMonthScroll$2$1$invokeSuspend$$inlined$filter$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @DebugMetadata(c = "kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$RequestWatchCalendarAfterMonthScroll$2$1$invokeSuspend$$inlined$filter$1$2", f = "BiliCalendarUtils.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                        /* renamed from: kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$RequestWatchCalendarAfterMonthScroll$2$1$invokeSuspend$$inlined$filter$1$2$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, (Continuation) this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                        /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object value, Continuation $completion) {
                            Continuation $continuation;
                            if ($completion instanceof AnonymousClass1) {
                                $continuation = (AnonymousClass1) $completion;
                                if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                    $continuation.label -= Integer.MIN_VALUE;
                                    Object $result = $continuation.result;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch ($continuation.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                            AnonymousClass1 anonymousClass1 = $continuation;
                                            boolean scrolling = ((Boolean) value).booleanValue();
                                            if (!scrolling) {
                                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$filter_u24lambda_u240);
                                                $continuation.I$0 = 0;
                                                $continuation.label = 1;
                                                if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                                    break;
                                                } else {
                                                    return coroutine_suspended;
                                                }
                                            }
                                            break;
                                        case 1:
                                            int i = $continuation.I$0;
                                            FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                            Object obj = $continuation.L$2;
                                            AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                            Object value2 = $continuation.L$0;
                                            ResultKt.throwOnFailure($result);
                                            break;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            $continuation = new AnonymousClass1($completion);
                            Object $result2 = $continuation.result;
                            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }, new AnonymousClass3(this.$monthState, this.$visibleMonth, this.$latestHasRequestWatchCalendar, this.$latestPageSet, this.$latestOnMonthScroll$delegate, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BiliCalendarUtils.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$RequestWatchCalendarAfterMonthScroll$2$1$3", f = "BiliCalendarUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$RequestWatchCalendarAfterMonthScroll$2$1$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<Boolean> $latestHasRequestWatchCalendar;
        final /* synthetic */ State<Function1<KCalendarTimeRange, Unit>> $latestOnMonthScroll$delegate;
        final /* synthetic */ State<SnapshotStateSet<LocalDate>> $latestPageSet;
        final /* synthetic */ BiliMonthCalendarState $monthState;
        final /* synthetic */ MutableState<Month> $visibleMonth;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(BiliMonthCalendarState biliMonthCalendarState, MutableState<Month> mutableState, State<Boolean> state, State<SnapshotStateSet<LocalDate>> state2, State<? extends Function1<? super KCalendarTimeRange, Unit>> state3, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$monthState = biliMonthCalendarState;
            this.$visibleMonth = mutableState;
            this.$latestHasRequestWatchCalendar = state;
            this.$latestPageSet = state2;
            this.$latestOnMonthScroll$delegate = state3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$monthState, this.$visibleMonth, this.$latestHasRequestWatchCalendar, this.$latestPageSet, this.$latestOnMonthScroll$delegate, continuation);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
            return create(Boolean.valueOf(z), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Function1 RequestWatchCalendarAfterMonthScroll$lambda$2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    LocalDate beginDate = ((Day) CollectionsKt.first((List) CollectionsKt.first(this.$monthState.getFirstVisibleMonth().getWeekDays()))).getDate();
                    if (!Intrinsics.areEqual(this.$visibleMonth.getValue(), this.$monthState.getFirstVisibleMonth()) && ((Boolean) this.$latestHasRequestWatchCalendar.getValue()).booleanValue() && !((SnapshotStateSet) this.$latestPageSet.getValue()).contains(beginDate)) {
                        LocalDate endDate = ((Day) CollectionsKt.last((List) CollectionsKt.last(this.$monthState.getFirstVisibleMonth().getWeekDays()))).getDate();
                        RequestWatchCalendarAfterMonthScroll$lambda$2 = BiliCalendarUtilsKt.RequestWatchCalendarAfterMonthScroll$lambda$2(this.$latestOnMonthScroll$delegate);
                        RequestWatchCalendarAfterMonthScroll$lambda$2.invoke(new KCalendarTimeRange(BiliCalendarExtensionsKt.toTimestampSeconds(beginDate), BiliCalendarExtensionsKt.toEndOfDayTimestampSeconds(endDate)));
                        ILogger kLog = KLog_androidKt.getKLog();
                        Month firstVisibleMonth = this.$monthState.getFirstVisibleMonth();
                        kLog.i("BiliCalendarUtils", "RequestWatchCalendarAfterMonthScroll. beginDate: " + beginDate + ", endDate: " + endDate + ", curVisibleMonth: " + firstVisibleMonth + ", preVisibleMonth: " + this.$visibleMonth.getValue());
                        this.$visibleMonth.setValue(this.$monthState.getFirstVisibleMonth());
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}