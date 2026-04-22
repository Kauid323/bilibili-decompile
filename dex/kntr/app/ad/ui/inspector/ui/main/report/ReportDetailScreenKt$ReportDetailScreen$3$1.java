package kntr.app.ad.ui.inspector.ui.main.report;

import androidx.compose.runtime.MutableState;
import kntr.app.ad.domain.inspector.core.work.ReportJobData;
import kntr.app.ad.domain.inspector.core.work.ReportType;
import kntr.app.ad.ui.inspector.ui.main.report.viewmodel.ReportDetailViewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReportDetailScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ui.inspector.ui.main.report.ReportDetailScreenKt$ReportDetailScreen$3$1", f = "ReportDetailScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ReportDetailScreenKt$ReportDetailScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $eventType$delegate;
    final /* synthetic */ ReportJobData $reportJobData;
    final /* synthetic */ ReportDetailViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportDetailScreenKt$ReportDetailScreen$3$1(ReportJobData reportJobData, ReportDetailViewModel reportDetailViewModel, MutableState<String> mutableState, Continuation<? super ReportDetailScreenKt$ReportDetailScreen$3$1> continuation) {
        super(2, continuation);
        this.$reportJobData = reportJobData;
        this.$viewModel = reportDetailViewModel;
        this.$eventType$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReportDetailScreenKt$ReportDetailScreen$3$1(this.$reportJobData, this.$viewModel, this.$eventType$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$reportJobData.getReportType() == ReportType.FEE || this.$reportJobData.getReportType() == ReportType.UI) {
                    this.$eventType$delegate.setValue(this.$viewModel.extractEventFromJson(this.$reportJobData.getRequestBody()));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}