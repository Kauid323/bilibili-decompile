package kntr.app.ad.domain.report.vendor.ui;

import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.ad.domain.inspector.AdInspectorManager;
import kntr.app.ad.domain.inspector.core.work.IJob;
import kntr.app.ad.domain.report.internal.RecordType;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.domain.report.internal.ReportExtraHandler;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.ad.domain.report.internal.cache.IReportStorageManager;
import kntr.app.ad.domain.report.internal.upload.IReportUploader;
import kntr.app.ad.domain.report.vendor.BaseReporter;
import kntr.app.ad.domain.report.vendor.ReportBottle;
import kntr.app.ad.protocol.report.IReportExtraHandler;
import kntr.app.ad.protocol.report.IReportUI;
import kntr.app.ad.protocol.report.IReportable;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: UIReporter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJG\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0019\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0016JC\u0010\u0017\u001a\u00020\r*\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0019\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/app/ad/domain/report/vendor/ui/UIReporter;", "Lkntr/app/ad/domain/report/vendor/BaseReporter;", "Lkntr/app/ad/protocol/report/IReportUI;", "uploader", "Lkntr/app/ad/domain/report/internal/upload/IReportUploader;", "storageManager", "Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;", "<init>", "(Lkntr/app/ad/domain/report/internal/upload/IReportUploader;Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;)V", "sReportedSet", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "event", RoomRecommendViewModel.EMPTY_CURSOR, "reportable", "Lkntr/app/ad/protocol/report/IReportable;", "isUnique", RoomRecommendViewModel.EMPTY_CURSOR, "uniqueKey", "extraHandler", "Lkotlin/Function1;", "Lkntr/app/ad/protocol/report/IReportExtraHandler;", "Lkotlin/ExtensionFunctionType;", "innerReport", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UIReporter extends BaseReporter implements IReportUI {
    private final Set<String> sReportedSet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UIReporter(IReportUploader uploader, IReportStorageManager storageManager) {
        super(uploader, storageManager);
        Intrinsics.checkNotNullParameter(uploader, "uploader");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.sReportedSet = new LinkedHashSet();
    }

    @Override // kntr.app.ad.protocol.report.IReportUI
    public void event(String event, IReportable reportable, boolean isUnique, String uniqueKey, Function1<? super IReportExtraHandler, Unit> function1) {
        Intrinsics.checkNotNullParameter(event, "event");
        innerReport(reportable, event, isUnique, uniqueKey, function1);
    }

    private final void innerReport(final IReportable $this$innerReport, final String event, boolean isUnique, String uniqueKey, final Function1<? super IReportExtraHandler, Unit> function1) {
        if (isUnique) {
            String key = event + "," + ($this$innerReport != null ? $this$innerReport.getRequestId() : null) + "," + ($this$innerReport != null ? Long.valueOf($this$innerReport.getCreativeId()) : null) + "," + ($this$innerReport != null ? Long.valueOf($this$innerReport.getSourceId()) : null) + "," + uniqueKey;
            if (this.sReportedSet.contains(key)) {
                return;
            }
            this.sReportedSet.add(key);
        }
        ReportBottle $this$innerReport_u24lambda_u240 = new ReportBottle($this$innerReport);
        ReportRecord $this$innerReport_u24lambda_u240_u240 = new ReportRecord();
        $this$innerReport_u24lambda_u240_u240.setBaseInfo($this$innerReport_u24lambda_u240.getBuildIn());
        $this$innerReport_u24lambda_u240_u240.setAdInfo($this$innerReport_u24lambda_u240.getPreset());
        $this$innerReport_u24lambda_u240_u240.setExtraInfo(new Function1() { // from class: kntr.app.ad.domain.report.vendor.ui.UIReporter$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit innerReport$lambda$0$0$0;
                innerReport$lambda$0$0$0 = UIReporter.innerReport$lambda$0$0$0(event, function1, (ReportExtraHandler) obj);
                return innerReport$lambda$0$0$0;
            }
        });
        $this$innerReport_u24lambda_u240_u240.setType(RecordType.UI);
        final Ref.ObjectRef job = new Ref.ObjectRef();
        handleReport($this$innerReport_u24lambda_u240_u240, new Function1() { // from class: kntr.app.ad.domain.report.vendor.ui.UIReporter$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit innerReport$lambda$1$0;
                innerReport$lambda$1$0 = UIReporter.innerReport$lambda$1$0(job, $this$innerReport, (String) obj);
                return innerReport$lambda$1$0;
            }
        }, new Function0() { // from class: kntr.app.ad.domain.report.vendor.ui.UIReporter$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit innerReport$lambda$1$1;
                innerReport$lambda$1$1 = UIReporter.innerReport$lambda$1$1(job);
                return innerReport$lambda$1$1;
            }
        }, new Function2() { // from class: kntr.app.ad.domain.report.vendor.ui.UIReporter$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                Unit innerReport$lambda$1$2;
                innerReport$lambda$1$2 = UIReporter.innerReport$lambda$1$2(job, ((Integer) obj).intValue(), (String) obj2);
                return innerReport$lambda$1$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit innerReport$lambda$0$0$0(String $event, Function1 $extraHandler, ReportExtraHandler reportExtraHandler) {
        Intrinsics.checkNotNullParameter(reportExtraHandler, "<this>");
        reportExtraHandler.put("event", $event);
        reportExtraHandler.put(ReportBuildInParam.IS_SDK_V3, "1");
        if ($extraHandler != null) {
            $extraHandler.invoke(reportExtraHandler);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit innerReport$lambda$1$0(Ref.ObjectRef $job, IReportable $this_innerReport, String raw) {
        IJob it = AdInspectorManager.INSTANCE.addUIReportJob(raw, $this_innerReport != null ? $this_innerReport.getAdCb() : null, false);
        it.start();
        $job.element = it;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit innerReport$lambda$1$1(Ref.ObjectRef $job) {
        IJob iJob = (IJob) $job.element;
        if (iJob != null) {
            IJob.CC.success$default(iJob, null, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit innerReport$lambda$1$2(Ref.ObjectRef $job, int code, String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        IJob iJob = (IJob) $job.element;
        if (iJob != null) {
            IJob.CC.fail$default(iJob, null, 1, null);
        }
        return Unit.INSTANCE;
    }
}