package kntr.app.ad.domain.report.vendor.fee;

import java.util.List;
import kntr.app.ad.domain.report.internal.ReportAlarmKt;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.ad.domain.report.internal.ReportUtilKt;
import kntr.app.ad.domain.report.internal.RepoterTrackKt;
import kntr.app.ad.domain.report.internal.upload.ReportUploader;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeReportUploader.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0016\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010H\u0096@¢\u0006\u0002\u0010\u0012J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00142\u0006\u0010\b\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkntr/app/ad/domain/report/vendor/fee/FeeReportUploader;", "Lkntr/app/ad/domain/report/internal/upload/ReportUploader;", "<init>", "()V", "upload", RoomRecommendViewModel.EMPTY_CURSOR, "record", "Lkntr/app/ad/domain/report/internal/ReportRecord;", "needRetry", "startAction", "Lkotlin/Function1;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "successAction", "Lkotlin/Function0;", "failureAction", "Lkotlin/Function2;", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/ad/domain/report/internal/ReportRecord;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "records", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FeeReportUploader extends ReportUploader {
    @Override // kntr.app.ad.domain.report.internal.upload.IReportUploader
    public Object upload(final ReportRecord record, final boolean needRetry, Function1<? super String, Unit> function1, final Function0<Unit> function0, final Function2<? super Integer, ? super String, Unit> function2, Continuation<? super Boolean> continuation) {
        Function1 ktorRequest = buildRequest(ReportUtilKt.getReportConfig().getFeeUrl(), CollectionsKt.listOf(record), function1);
        return commit$report_debug(ktorRequest, new Function0() { // from class: kntr.app.ad.domain.report.vendor.fee.FeeReportUploader$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit upload$lambda$0;
                upload$lambda$0 = FeeReportUploader.upload$lambda$0(needRetry, function0, record);
                return upload$lambda$0;
            }
        }, new Function2() { // from class: kntr.app.ad.domain.report.vendor.fee.FeeReportUploader$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                Unit upload$lambda$1;
                upload$lambda$1 = FeeReportUploader.upload$lambda$1(needRetry, function2, record, ((Integer) obj).intValue(), (String) obj2);
                return upload$lambda$1;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upload$lambda$0(boolean $needRetry, Function0 $successAction, ReportRecord $record) {
        if ($needRetry) {
            FeeReportFeature.INSTANCE.startSchedulingRetryTask(false);
            if ($successAction != null) {
                $successAction.invoke();
            }
        }
        RepoterTrackKt.trackSuccess($record);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upload$lambda$1(boolean $needRetry, Function2 $failureAction, ReportRecord $record, int code, String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if ($needRetry && $failureAction != null) {
            $failureAction.invoke(Integer.valueOf(code), msg);
        }
        $record.setCode(Integer.valueOf(code));
        $record.setMsg(msg);
        ReportAlarmKt.alarmFailed($record);
        RepoterTrackKt.trackFail($record);
        return Unit.INSTANCE;
    }

    @Override // kntr.app.ad.domain.report.internal.upload.ReportUploader, kntr.app.ad.domain.report.internal.upload.IReportUploader
    public Object upload(final List<ReportRecord> list, boolean needRetry, Continuation<? super Boolean> continuation) {
        Function1 ktorRequest = ReportUploader.buildRequest$default(this, ReportUtilKt.getReportConfig().getFeeUrl(), list, null, 4, null);
        return commit$report_debug(ktorRequest, new Function0() { // from class: kntr.app.ad.domain.report.vendor.fee.FeeReportUploader$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit upload$lambda$2;
                upload$lambda$2 = FeeReportUploader.upload$lambda$2(list);
                return upload$lambda$2;
            }
        }, new Function2() { // from class: kntr.app.ad.domain.report.vendor.fee.FeeReportUploader$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit upload$lambda$3;
                upload$lambda$3 = FeeReportUploader.upload$lambda$3(list, ((Integer) obj).intValue(), (String) obj2);
                return upload$lambda$3;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upload$lambda$2(List $records) {
        List $this$forEach$iv = $records;
        for (Object element$iv : $this$forEach$iv) {
            ReportRecord it = (ReportRecord) element$iv;
            RepoterTrackKt.trackSuccess(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upload$lambda$3(List $records, int code, String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        List $this$forEach$iv = $records;
        for (Object element$iv : $this$forEach$iv) {
            ReportRecord it = (ReportRecord) element$iv;
            it.setCode(Integer.valueOf(code));
            it.setMsg(msg);
            ReportAlarmKt.alarmFailed(it);
            RepoterTrackKt.trackFail(it);
        }
        return Unit.INSTANCE;
    }
}