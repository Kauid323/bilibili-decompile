package kntr.app.ad.domain.report.vendor.mma;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kntr.app.ad.domain.inspector.AdInspectorManager;
import kntr.app.ad.domain.inspector.core.work.IJob;
import kntr.app.ad.domain.macrosubst.AdMacroSubst;
import kntr.app.ad.domain.report.internal.RecordType;
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
import kntr.app.ad.protocol.IMotion;
import kntr.app.ad.protocol.report.IReportMMA;
import kntr.app.ad.protocol.report.IReportable;
import kntr.app.ad.protocol.report.SubmitType;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: MMAReporter.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ@\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0016JJ\u0010\u0016\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\u0019\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0016JJ\u0010\u001a\u001a\u00020\r*\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkntr/app/ad/domain/report/vendor/mma/MMAReporter;", "Lkntr/app/ad/domain/report/vendor/BaseReporter;", "Lkntr/app/ad/protocol/report/IReportMMA;", "uploader", "Lkntr/app/ad/domain/report/internal/upload/IReportUploader;", "storageManager", "Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;", "<init>", "(Lkntr/app/ad/domain/report/internal/upload/IReportUploader;Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;)V", "sReportedSet", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "exposed", RoomRecommendViewModel.EMPTY_CURSOR, "adInfo", "Lkntr/app/ad/protocol/report/IReportable;", "urls", RoomRecommendViewModel.EMPTY_CURSOR, "isUnique", RoomRecommendViewModel.EMPTY_CURSOR, "uniqueKey", "submitActionFrom", "click", "motion", "Lkntr/app/ad/protocol/IMotion;", "event", "innerReport", "url", "inspectorListener", "Lkntr/app/ad/domain/report/internal/inspector/IInspectorListener;", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MMAReporter extends BaseReporter implements IReportMMA {
    private final Set<String> sReportedSet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MMAReporter(IReportUploader uploader, IReportStorageManager storageManager) {
        super(uploader, storageManager);
        Intrinsics.checkNotNullParameter(uploader, "uploader");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.sReportedSet = new LinkedHashSet();
    }

    @Override // kntr.app.ad.protocol.report.IReportMMA
    public void exposed(IReportable adInfo, List<String> list, boolean isUnique, String uniqueKey, String submitActionFrom) {
        if (adInfo == null || list == null) {
            return;
        }
        List<String> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            innerReport(adInfo, it, null, isUnique, uniqueKey, new ImpressionJobListener(adInfo.getAdCb(), "曝光三方上报"), submitActionFrom);
        }
    }

    @Override // kntr.app.ad.protocol.report.IReportMMA
    public void click(IReportable adInfo, List<String> list, IMotion motion, boolean isUnique, String uniqueKey, String submitActionFrom) {
        if (adInfo == null || list == null) {
            return;
        }
        List<String> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            innerReport(adInfo, it, motion, isUnique, uniqueKey, new InteractingJobListener(adInfo.getAdCb(), "点击三方上报"), submitActionFrom);
        }
    }

    @Override // kntr.app.ad.protocol.report.IReportMMA
    public void event(IReportable adInfo, List<String> list, boolean isUnique, String uniqueKey) {
        if (adInfo == null || list == null) {
            return;
        }
        List<String> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            innerReport$default(this, adInfo, it, null, isUnique, uniqueKey, null, null, 48, null);
        }
    }

    static /* synthetic */ void innerReport$default(MMAReporter mMAReporter, IReportable iReportable, String str, IMotion iMotion, boolean z, String str2, IInspectorListener iInspectorListener, String str3, int i, Object obj) {
        IInspectorListener iInspectorListener2;
        String str4;
        if ((i & 16) == 0) {
            iInspectorListener2 = iInspectorListener;
        } else {
            iInspectorListener2 = null;
        }
        if ((i & 32) == 0) {
            str4 = str3;
        } else {
            str4 = null;
        }
        mMAReporter.innerReport(iReportable, str, iMotion, z, str2, iInspectorListener2, str4);
    }

    private final void innerReport(final IReportable $this$innerReport, final String url, final IMotion motion, boolean isUnique, String uniqueKey, final IInspectorListener inspectorListener, final String submitActionFrom) {
        String str = url;
        if ((str == null || StringsKt.isBlank(str)) || !$this$innerReport.isAdLoc()) {
            return;
        }
        if (isUnique) {
            String key = $this$innerReport.getRequestId() + "," + $this$innerReport.getCreativeId() + "," + $this$innerReport.getSourceId() + "," + url + "," + uniqueKey;
            if (this.sReportedSet.contains(key)) {
                return;
            }
            this.sReportedSet.add(key);
        }
        ReportBottle $this$innerReport_u24lambda_u240 = new ReportBottle($this$innerReport);
        final ReportRecord $this$innerReport_u24lambda_u240_u240 = new ReportRecord();
        $this$innerReport_u24lambda_u240_u240.setBaseInfo($this$innerReport_u24lambda_u240.getBuildIn());
        $this$innerReport_u24lambda_u240_u240.setAdInfo($this$innerReport_u24lambda_u240.getPreset());
        $this$innerReport_u24lambda_u240_u240.setExtraInfo(new Function1() { // from class: kntr.app.ad.domain.report.vendor.mma.MMAReporter$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit innerReport$lambda$0$0$0;
                innerReport$lambda$0$0$0 = MMAReporter.innerReport$lambda$0$0$0(url, $this$innerReport_u24lambda_u240_u240, $this$innerReport, motion, submitActionFrom, (ReportExtraHandler) obj);
                return innerReport$lambda$0$0$0;
            }
        });
        $this$innerReport_u24lambda_u240_u240.setType(RecordType.MMA);
        final Ref.ObjectRef job = new Ref.ObjectRef();
        handleReport($this$innerReport_u24lambda_u240_u240, new Function1() { // from class: kntr.app.ad.domain.report.vendor.mma.MMAReporter$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit innerReport$lambda$1$0;
                innerReport$lambda$1$0 = MMAReporter.innerReport$lambda$1$0(job, url, $this$innerReport, (String) obj);
                return innerReport$lambda$1$0;
            }
        }, new Function0() { // from class: kntr.app.ad.domain.report.vendor.mma.MMAReporter$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit innerReport$lambda$1$1;
                innerReport$lambda$1$1 = MMAReporter.innerReport$lambda$1$1(job, inspectorListener);
                return innerReport$lambda$1$1;
            }
        }, new Function2() { // from class: kntr.app.ad.domain.report.vendor.mma.MMAReporter$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                Unit innerReport$lambda$1$2;
                innerReport$lambda$1$2 = MMAReporter.innerReport$lambda$1$2(job, inspectorListener, ((Integer) obj).intValue(), (String) obj2);
                return innerReport$lambda$1$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit innerReport$lambda$0$0$0(String $url, ReportRecord $this_apply, IReportable $this_innerReport, IMotion $motion, String $submitActionFrom, ReportExtraHandler reportExtraHandler) {
        boolean z;
        Intrinsics.checkNotNullParameter(reportExtraHandler, "<this>");
        reportExtraHandler.put("url", AdMacroSubst.Companion.process($url, $this_innerReport, $this_apply.getTs(), $motion));
        if ($submitActionFrom != null) {
            if (!($submitActionFrom.length() == 0)) {
                z = true;
                if (z) {
                    reportExtraHandler.put(ReportBuildInParam.SUBMIT_ACTION_FROM, $submitActionFrom);
                }
                if (SubmitType.INSTANCE.mapToType($submitActionFrom).length() > 0) {
                    reportExtraHandler.put(ReportBuildInParam.SUBMIT_TYPE, SubmitType.INSTANCE.mapToType($submitActionFrom));
                }
                return Unit.INSTANCE;
            }
        }
        z = false;
        if (z) {
        }
        if (SubmitType.INSTANCE.mapToType($submitActionFrom).length() > 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit innerReport$lambda$1$0(Ref.ObjectRef $job, String $url, IReportable $this_innerReport, String it) {
        IJob it2 = AdInspectorManager.INSTANCE.addMMAReportJob($url, $this_innerReport.getAdCb(), false);
        it2.start();
        $job.element = it2;
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