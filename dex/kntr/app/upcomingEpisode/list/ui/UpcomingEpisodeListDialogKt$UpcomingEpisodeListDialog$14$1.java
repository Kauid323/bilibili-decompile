package kntr.app.upcomingEpisode.list.ui;

import androidx.compose.runtime.MutableFloatState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.handler.CalendarType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.datetime.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpcomingEpisodeListDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeListDialogKt$UpcomingEpisodeListDialog$14$1", f = "UpcomingEpisodeListDialog.kt", i = {0, 0}, l = {109}, m = "invokeSuspend", n = {"waitTime", "elapsedTime"}, s = {"I$0", "J$0"}, v = 1)
public final class UpcomingEpisodeListDialogKt$UpcomingEpisodeListDialog$14$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CalendarType $calendarType;
    final /* synthetic */ float $maxHeightPx;
    final /* synthetic */ float $minHeightPx;
    final /* synthetic */ long $renderStartTime;
    final /* synthetic */ MutableFloatState $sheetHeightPx$delegate;
    int I$0;
    long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpcomingEpisodeListDialogKt$UpcomingEpisodeListDialog$14$1(long j, CalendarType calendarType, float f, float f2, MutableFloatState mutableFloatState, Continuation<? super UpcomingEpisodeListDialogKt$UpcomingEpisodeListDialog$14$1> continuation) {
        super(2, continuation);
        this.$renderStartTime = j;
        this.$calendarType = calendarType;
        this.$maxHeightPx = f;
        this.$minHeightPx = f2;
        this.$sheetHeightPx$delegate = mutableFloatState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpcomingEpisodeListDialogKt$UpcomingEpisodeListDialog$14$1(this.$renderStartTime, this.$calendarType, this.$maxHeightPx, this.$minHeightPx, this.$sheetHeightPx$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        long elapsedTime;
        float UpcomingEpisodeListDialog_yivurRs$lambda$16;
        float UpcomingEpisodeListDialog_yivurRs$lambda$162;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                long elapsedTime2 = Clock.System.INSTANCE.now().toEpochMilliseconds() - this.$renderStartTime;
                if (elapsedTime2 < 700) {
                    this.I$0 = 700;
                    this.J$0 = elapsedTime2;
                    this.label = 1;
                    if (DelayKt.delay(700 - elapsedTime2, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    elapsedTime = elapsedTime2;
                    break;
                }
                break;
            case 1:
                elapsedTime = this.J$0;
                int i = this.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.$calendarType == CalendarType.MONTH) {
            UpcomingEpisodeListDialog_yivurRs$lambda$162 = UpcomingEpisodeListDialogKt.UpcomingEpisodeListDialog_yivurRs$lambda$16(this.$sheetHeightPx$delegate);
            if (UpcomingEpisodeListDialog_yivurRs$lambda$162 == this.$maxHeightPx) {
                this.$sheetHeightPx$delegate.setFloatValue(this.$minHeightPx);
                return Unit.INSTANCE;
            }
        }
        if (this.$calendarType == CalendarType.WEEK) {
            UpcomingEpisodeListDialog_yivurRs$lambda$16 = UpcomingEpisodeListDialogKt.UpcomingEpisodeListDialog_yivurRs$lambda$16(this.$sheetHeightPx$delegate);
            if (UpcomingEpisodeListDialog_yivurRs$lambda$16 == this.$minHeightPx) {
                this.$sheetHeightPx$delegate.setFloatValue(this.$maxHeightPx);
            }
        }
        return Unit.INSTANCE;
    }
}