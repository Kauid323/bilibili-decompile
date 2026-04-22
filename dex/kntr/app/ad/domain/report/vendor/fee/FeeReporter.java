package kntr.app.ad.domain.report.vendor.fee;

import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.ad.domain.inspector.AdInspectorManager;
import kntr.app.ad.domain.inspector.core.work.IJob;
import kntr.app.ad.domain.report.internal.RecordType;
import kntr.app.ad.domain.report.internal.ReportBuildInEvent;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.domain.report.internal.ReportExtraHandler;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.ad.domain.report.internal.cache.IReportStorageManager;
import kntr.app.ad.domain.report.internal.inspector.IInspectorListener;
import kntr.app.ad.domain.report.internal.inspector.ImpressionJobListener;
import kntr.app.ad.domain.report.internal.inspector.InteractingJobListener;
import kntr.app.ad.domain.report.internal.upload.IReportUploader;
import kntr.app.ad.domain.report.vendor.BaseReporter;
import kntr.app.ad.domain.report.vendor.ReportBottle;
import kntr.app.ad.protocol.report.IReportExtraHandler;
import kntr.app.ad.protocol.report.IReportFee;
import kntr.app.ad.protocol.report.IReportable;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: FeeReporter.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0019\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0016J?\u0010\u0017\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0019\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0016J?\u0010\u0018\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0019\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0016J?\u0010\u0019\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0019\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0016J?\u0010\u001a\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0019\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0016JG\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0019\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0016JM\u0010\u001c\u001a\u00020\r*\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0019\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014¢\u0006\u0002\b\u00162\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkntr/app/ad/domain/report/vendor/fee/FeeReporter;", "Lkntr/app/ad/domain/report/vendor/BaseReporter;", "Lkntr/app/ad/protocol/report/IReportFee;", "uploader", "Lkntr/app/ad/domain/report/internal/upload/IReportUploader;", "storageManager", "Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;", "<init>", "(Lkntr/app/ad/domain/report/internal/upload/IReportUploader;Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;)V", "sReportedSet", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "exposed", RoomRecommendViewModel.EMPTY_CURSOR, "reportable", "Lkntr/app/ad/protocol/report/IReportable;", "isUnique", RoomRecommendViewModel.EMPTY_CURSOR, "uniqueKey", "extraHandler", "Lkotlin/Function1;", "Lkntr/app/ad/protocol/report/IReportExtraHandler;", "Lkotlin/ExtensionFunctionType;", "strictExposed", "click", "buttonClick", ReportBuildInEvent.CLOSE, "event", "innerReport", "inspectorListener", "Lkntr/app/ad/domain/report/internal/inspector/IInspectorListener;", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FeeReporter extends BaseReporter implements IReportFee {
    private final Set<String> sReportedSet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeeReporter(IReportUploader uploader, IReportStorageManager storageManager) {
        super(uploader, storageManager);
        Intrinsics.checkNotNullParameter(uploader, "uploader");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.sReportedSet = new LinkedHashSet();
    }

    @Override // kntr.app.ad.protocol.report.IReportFee
    public void exposed(IReportable reportable, boolean isUnique, String uniqueKey, Function1<? super IReportExtraHandler, Unit> function1) {
        if (reportable != null) {
            innerReport(reportable, "show", isUnique, uniqueKey, function1, new ImpressionJobListener(reportable.getAdCb(), "曝光上报"));
        }
    }

    @Override // kntr.app.ad.protocol.report.IReportFee
    public void strictExposed(IReportable reportable, boolean isUnique, String uniqueKey, Function1<? super IReportExtraHandler, Unit> function1) {
        if (reportable != null) {
            innerReport(reportable, ReportBuildInEvent.STRICT_SHOW, isUnique, uniqueKey, function1, new ImpressionJobListener(reportable.getAdCb(), "严格曝光上报"));
        }
    }

    @Override // kntr.app.ad.protocol.report.IReportFee
    public void click(IReportable reportable, boolean isUnique, String uniqueKey, Function1<? super IReportExtraHandler, Unit> function1) {
        if (reportable != null) {
            innerReport(reportable, "click", isUnique, uniqueKey, function1, new InteractingJobListener(reportable.getAdCb(), "点击计费上报"));
        }
    }

    @Override // kntr.app.ad.protocol.report.IReportFee
    public void buttonClick(IReportable reportable, boolean isUnique, String uniqueKey, Function1<? super IReportExtraHandler, Unit> function1) {
        if (reportable != null) {
            innerReport(reportable, ReportBuildInEvent.BUTTON_CLICK, isUnique, uniqueKey, function1, new InteractingJobListener(reportable.getAdCb(), "按钮点击计费上报"));
        }
    }

    @Override // kntr.app.ad.protocol.report.IReportFee
    public void close(IReportable reportable, boolean isUnique, String uniqueKey, Function1<? super IReportExtraHandler, Unit> function1) {
        if (reportable != null) {
            innerReport$default(this, reportable, ReportBuildInEvent.CLOSE, isUnique, uniqueKey, function1, null, 16, null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // kntr.app.ad.protocol.report.IReportFee
    public void event(String event, IReportable reportable, boolean isUnique, String uniqueKey, Function1<? super IReportExtraHandler, Unit> function1) {
        IInspectorListener inspectorListener;
        Intrinsics.checkNotNullParameter(event, "event");
        switch (event.hashCode()) {
            case 3529469:
                if (event.equals("show")) {
                    inspectorListener = new ImpressionJobListener(reportable != null ? reportable.getAdCb() : null, "曝光上报");
                    break;
                }
                inspectorListener = null;
                break;
            case 94750088:
                if (event.equals("click")) {
                    inspectorListener = new InteractingJobListener(reportable != null ? reportable.getAdCb() : null, "点击计费上报");
                    break;
                }
                inspectorListener = null;
                break;
            case 1277338171:
                if (event.equals(ReportBuildInEvent.BUTTON_CLICK)) {
                    inspectorListener = new InteractingJobListener(reportable != null ? reportable.getAdCb() : null, "按钮点击计费上报");
                    break;
                }
                inspectorListener = null;
                break;
            case 1984170675:
                if (event.equals(ReportBuildInEvent.STRICT_SHOW)) {
                    inspectorListener = new ImpressionJobListener(reportable != null ? reportable.getAdCb() : null, "严格曝光上报");
                    break;
                }
                inspectorListener = null;
                break;
            default:
                inspectorListener = null;
                break;
        }
        if (reportable != null) {
            innerReport(reportable, event, isUnique, uniqueKey, function1, inspectorListener);
        }
    }

    static /* synthetic */ void innerReport$default(FeeReporter feeReporter, IReportable iReportable, String str, boolean z, String str2, Function1 function1, IInspectorListener iInspectorListener, int i, Object obj) {
        IInspectorListener iInspectorListener2;
        if ((i & 16) == 0) {
            iInspectorListener2 = iInspectorListener;
        } else {
            iInspectorListener2 = null;
        }
        feeReporter.innerReport(iReportable, str, z, str2, function1, iInspectorListener2);
    }

    private final void innerReport(final IReportable $this$innerReport, final String event, boolean isUnique, String uniqueKey, final Function1<? super IReportExtraHandler, Unit> function1, final IInspectorListener inspectorListener) {
        if (!$this$innerReport.isAdLoc()) {
            return;
        }
        if (isUnique) {
            String key = event + "," + $this$innerReport.getRequestId() + "," + $this$innerReport.getCreativeId() + "," + $this$innerReport.getSourceId() + "," + uniqueKey;
            if (this.sReportedSet.contains(key)) {
                return;
            }
            this.sReportedSet.add(key);
        }
        ReportBottle $this$innerReport_u24lambda_u240 = new ReportBottle($this$innerReport);
        ReportRecord $this$innerReport_u24lambda_u240_u240 = new ReportRecord();
        $this$innerReport_u24lambda_u240_u240.setBaseInfo($this$innerReport_u24lambda_u240.getBuildIn());
        $this$innerReport_u24lambda_u240_u240.setAdInfo($this$innerReport_u24lambda_u240.getPreset());
        $this$innerReport_u24lambda_u240_u240.setExtraInfo(new Function1() { // from class: kntr.app.ad.domain.report.vendor.fee.FeeReporter$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit innerReport$lambda$0$0$0;
                innerReport$lambda$0$0$0 = FeeReporter.innerReport$lambda$0$0$0(event, function1, (ReportExtraHandler) obj);
                return innerReport$lambda$0$0$0;
            }
        });
        $this$innerReport_u24lambda_u240_u240.setType(RecordType.FEE);
        final Ref.ObjectRef job = new Ref.ObjectRef();
        handleReport($this$innerReport_u24lambda_u240_u240, new Function1() { // from class: kntr.app.ad.domain.report.vendor.fee.FeeReporter$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit innerReport$lambda$1$0;
                innerReport$lambda$1$0 = FeeReporter.innerReport$lambda$1$0(job, $this$innerReport, (String) obj);
                return innerReport$lambda$1$0;
            }
        }, new Function0() { // from class: kntr.app.ad.domain.report.vendor.fee.FeeReporter$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit innerReport$lambda$1$1;
                innerReport$lambda$1$1 = FeeReporter.innerReport$lambda$1$1(job, inspectorListener);
                return innerReport$lambda$1$1;
            }
        }, new Function2() { // from class: kntr.app.ad.domain.report.vendor.fee.FeeReporter$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                Unit innerReport$lambda$1$2;
                innerReport$lambda$1$2 = FeeReporter.innerReport$lambda$1$2(job, inspectorListener, ((Integer) obj).intValue(), (String) obj2);
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
        IJob it = AdInspectorManager.INSTANCE.addFeeReportJob(raw, $this_innerReport.getAdCb(), false);
        it.start();
        $job.element = it;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit innerReport$lambda$1$1(Ref.ObjectRef $job, IInspectorListener $inspectorListener) {
        IJob iJob = (IJob) $job.element;
        if (iJob != null) {
            IJob.CC.success$default(iJob, null, 1, null);
        }
        if ($inspectorListener != null) {
            $inspectorListener.reportSuccess();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit innerReport$lambda$1$2(Ref.ObjectRef $job, IInspectorListener $inspectorListener, int code, String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        IJob iJob = (IJob) $job.element;
        if (iJob != null) {
            IJob.CC.fail$default(iJob, null, 1, null);
        }
        if ($inspectorListener != null) {
            $inspectorListener.reportError(code, msg);
        }
        return Unit.INSTANCE;
    }
}