package kntr.app.ad.domain.report.internal.scheduler;

import kntr.app.ad.domain.report.internal.ReportConfig;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: UploadScheduler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.report.internal.scheduler.UploadScheduler$startScheduling$1", f = "UploadScheduler.kt", i = {}, l = {38, 39}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class UploadScheduler$startScheduling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UploadScheduler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadScheduler$startScheduling$1(UploadScheduler uploadScheduler, Continuation<? super UploadScheduler$startScheduling$1> continuation) {
        super(2, continuation);
        this.this$0 = uploadScheduler;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UploadScheduler$startScheduling$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ReportConfig reportConfig;
        UploadRunnable uploadRunnable;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Duration.Companion companion = Duration.Companion;
                reportConfig = this.this$0.config;
                this.label = 1;
                if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration(reportConfig.getRETRY_SCHEDULE_DELAY_TIME(), DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                uploadRunnable = this.this$0.runnable;
                this.label = 2;
                if (uploadRunnable.run$report_debug((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                uploadRunnable = this.this$0.runnable;
                this.label = 2;
                if (uploadRunnable.run$report_debug((Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}