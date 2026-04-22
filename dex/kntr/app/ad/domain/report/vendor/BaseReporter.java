package kntr.app.ad.domain.report.vendor;

import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.ad.domain.report.internal.ReportUtilKt;
import kntr.app.ad.domain.report.internal.cache.IReportStorageManager;
import kntr.app.ad.domain.report.internal.upload.IReportUploader;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: BaseReporter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b \u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JT\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012H\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/app/ad/domain/report/vendor/BaseReporter;", RoomRecommendViewModel.EMPTY_CURSOR, "uploader", "Lkntr/app/ad/domain/report/internal/upload/IReportUploader;", "storageManager", "Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;", "<init>", "(Lkntr/app/ad/domain/report/internal/upload/IReportUploader;Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;)V", "handleReport", RoomRecommendViewModel.EMPTY_CURSOR, "record", "Lkntr/app/ad/domain/report/internal/ReportRecord;", "startAction", "Lkotlin/Function1;", RoomRecommendViewModel.EMPTY_CURSOR, "successAction", "Lkotlin/Function0;", "failureAction", "Lkotlin/Function2;", RoomRecommendViewModel.EMPTY_CURSOR, "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BaseReporter {
    private final IReportStorageManager storageManager;
    private final IReportUploader uploader;

    public BaseReporter(IReportUploader uploader, IReportStorageManager storageManager) {
        Intrinsics.checkNotNullParameter(uploader, "uploader");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.uploader = uploader;
        this.storageManager = storageManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void handleReport(ReportRecord record, Function1<? super String, Unit> function1, Function0<Unit> function0, Function2<? super Integer, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(record, "record");
        BuildersKt.launch$default(ReportUtilKt.getReportScope(), (CoroutineContext) null, (CoroutineStart) null, new BaseReporter$handleReport$1(this, record, function1, function0, function2, null), 3, (Object) null);
    }
}