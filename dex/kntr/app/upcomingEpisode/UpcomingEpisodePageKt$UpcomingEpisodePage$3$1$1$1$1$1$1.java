package kntr.app.upcomingEpisode;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import kntr.app.upcomingEpisode.calendar.utils.BiliCalendarExtensionsKt;
import kntr.app.upcomingEpisode.calendar.utils.BiliMonthCalendarState;
import kntr.app.upcomingEpisode.calendar.utils.BiliWeekCalendarState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.datetime.LocalDate;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpcomingEpisodePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.UpcomingEpisodePageKt$UpcomingEpisodePage$3$1$1$1$1$1$1", f = "UpcomingEpisodePage.kt", i = {}, l = {258, 260, 262}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class UpcomingEpisodePageKt$UpcomingEpisodePage$3$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasBackground;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ BiliMonthCalendarState $monthState;
    final /* synthetic */ MutableState<LocalDate> $selection$delegate;
    final /* synthetic */ BiliWeekCalendarState $weekState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpcomingEpisodePageKt$UpcomingEpisodePage$3$1$1$1$1$1$1(BiliWeekCalendarState biliWeekCalendarState, boolean z, BiliMonthCalendarState biliMonthCalendarState, LazyListState lazyListState, MutableState<LocalDate> mutableState, Continuation<? super UpcomingEpisodePageKt$UpcomingEpisodePage$3$1$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$weekState = biliWeekCalendarState;
        this.$hasBackground = z;
        this.$monthState = biliMonthCalendarState;
        this.$listState = lazyListState;
        this.$selection$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpcomingEpisodePageKt$UpcomingEpisodePage$3$1$1$1$1$1$1(this.$weekState, this.$hasBackground, this.$monthState, this.$listState, this.$selection$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        LocalDate UpcomingEpisodePage$lambda$12;
        LocalDate UpcomingEpisodePage$lambda$122;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BiliWeekCalendarState biliWeekCalendarState = this.$weekState;
                UpcomingEpisodePage$lambda$12 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$12(this.$selection$delegate);
                this.label = 1;
                if (biliWeekCalendarState.animateScrollToWeek(UpcomingEpisodePage$lambda$12, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (!this.$hasBackground) {
                    BiliMonthCalendarState biliMonthCalendarState = this.$monthState;
                    UpcomingEpisodePage$lambda$122 = UpcomingEpisodePageKt.UpcomingEpisodePage$lambda$12(this.$selection$delegate);
                    this.label = 2;
                    if (biliMonthCalendarState.animateScrollToMonth(BiliCalendarExtensionsKt.getYearMonth(UpcomingEpisodePage$lambda$122), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.label = 3;
                if (LazyListState.scrollToItem$default(this.$listState, 0, 0, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                if (!this.$hasBackground) {
                }
                this.label = 3;
                if (LazyListState.scrollToItem$default(this.$listState, 0, 0, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                this.label = 3;
                if (LazyListState.scrollToItem$default(this.$listState, 0, 0, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}