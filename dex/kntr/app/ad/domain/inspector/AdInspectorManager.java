package kntr.app.ad.domain.inspector;

import kntr.app.ad.common.model.AdSlot;
import kntr.app.ad.domain.inspector.core.StateManager;
import kntr.app.ad.domain.inspector.core.work.AdExtraJob;
import kntr.app.ad.domain.inspector.core.work.ApiJob;
import kntr.app.ad.domain.inspector.core.work.EmptyJob;
import kntr.app.ad.domain.inspector.core.work.EmptyStage;
import kntr.app.ad.domain.inspector.core.work.FeeReportJob;
import kntr.app.ad.domain.inspector.core.work.IJob;
import kntr.app.ad.domain.inspector.core.work.IStage;
import kntr.app.ad.domain.inspector.core.work.MMAReportJob;
import kntr.app.ad.domain.inspector.core.work.Pipeline;
import kntr.app.ad.domain.inspector.core.work.PrintJobData;
import kntr.app.ad.domain.inspector.core.work.PrintType;
import kntr.app.ad.domain.inspector.core.work.UIReportJob;
import kntr.app.ad.domain.inspector.model.InspectorInfo;
import kntr.app.ad.domain.inspector.model.StageType;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: AdInspectorManager.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\n\u001a\u00020\t2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J,\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J$\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u0007H\u0007J$\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u0007H\u0007J$\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u0007H\u0007J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010 \u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0007J\u0016\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013J\u0016\u0010$\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013J\u0016\u0010%\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkntr/app/ad/domain/inspector/AdInspectorManager;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "enable", RoomRecommendViewModel.EMPTY_CURSOR, "init", RoomRecommendViewModel.EMPTY_CURSOR, "addInspector", "action", "Lkotlin/Function0;", "Lkntr/app/ad/domain/inspector/model/InspectorInfo;", "addAdExtraJob", "Lkntr/app/ad/domain/inspector/core/work/IJob;", "slot", "Lkntr/app/ad/common/model/AdSlot;", "desc", RoomRecommendViewModel.EMPTY_CURSOR, "addRequestJob", "url", "requestBody", "addFeeReportJob", "adId", "isRetry", "addUIReportJob", "addMMAReportJob", "getPreparationStage", "Lkntr/app/ad/domain/inspector/core/work/IStage;", "getDrawingStage", "getImpressionStage", "getInteractingStage", "printI", "tag", "msg", "printE", "printW", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdInspectorManager {
    private static boolean enable;
    public static final AdInspectorManager INSTANCE = new AdInspectorManager();
    private static final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    public static final int $stable = 8;

    private AdInspectorManager() {
    }

    public final void init(boolean enable2) {
        enable = enable2;
    }

    public final void addInspector(Function0<InspectorInfo> function0) {
        InspectorInfo it;
        Intrinsics.checkNotNullParameter(function0, "action");
        if (enable && (it = (InspectorInfo) function0.invoke()) != null) {
            StateManager.INSTANCE.addInspectorInfo(it);
        }
    }

    public final IJob addAdExtraJob(AdSlot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return addAdExtraJob(slot, RoomRecommendViewModel.EMPTY_CURSOR);
    }

    public final IJob addAdExtraJob(AdSlot slot, String desc) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        if (enable) {
            AdExtraJob job = new AdExtraJob(slot, desc);
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AdInspectorManager$addAdExtraJob$1$1(job, null), 3, (Object) null);
            StateManager.INSTANCE.addRequestJobData(job.getData());
            return job;
        }
        return EmptyJob.INSTANCE;
    }

    public final IJob addRequestJob(AdSlot slot, String url, String desc, String requestBody) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        if (enable) {
            ApiJob job = new ApiJob(slot, url, requestBody, desc);
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AdInspectorManager$addRequestJob$1$1(job, null), 3, (Object) null);
            StateManager.INSTANCE.addRequestJobData(job.getData());
            return job;
        }
        return EmptyJob.INSTANCE;
    }

    public final IJob addFeeReportJob(String requestBody, String adId, boolean isRetry) {
        if (enable && !isRetry) {
            FeeReportJob job = new FeeReportJob(requestBody, isRetry, adId);
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AdInspectorManager$addFeeReportJob$1$1(job, null), 3, (Object) null);
            StateManager.INSTANCE.addReportJobData(job.getData());
            return job;
        }
        return EmptyJob.INSTANCE;
    }

    public final IJob addUIReportJob(String requestBody, String adId, boolean isRetry) {
        if (enable && !isRetry) {
            UIReportJob job = new UIReportJob(requestBody, isRetry, adId);
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AdInspectorManager$addUIReportJob$1$1(job, null), 3, (Object) null);
            StateManager.INSTANCE.addReportJobData(job.getData());
            return job;
        }
        return EmptyJob.INSTANCE;
    }

    public final IJob addMMAReportJob(String url, String adId, boolean isRetry) {
        if (enable && !isRetry) {
            MMAReportJob job = new MMAReportJob(url, isRetry, adId);
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AdInspectorManager$addMMAReportJob$1$1(job, null), 3, (Object) null);
            StateManager.INSTANCE.addReportJobData(job.getData());
            return job;
        }
        return EmptyJob.INSTANCE;
    }

    public final IStage getPreparationStage(String adId) {
        Pipeline pipeline;
        IStage stage;
        if (enable) {
            InspectorInfo inspector = StateManager.INSTANCE.getInspector(adId);
            if (inspector != null && (pipeline = inspector.getPipeline()) != null && (stage = pipeline.getStage(StageType.PREPARATION)) != null) {
                return stage;
            }
            return EmptyStage.INSTANCE;
        }
        return EmptyStage.INSTANCE;
    }

    public final IStage getDrawingStage(String adId) {
        Pipeline pipeline;
        IStage stage;
        if (enable) {
            InspectorInfo inspector = StateManager.INSTANCE.getInspector(adId);
            return (inspector == null || (pipeline = inspector.getPipeline()) == null || (stage = pipeline.getStage(StageType.DRAWING)) == null) ? EmptyStage.INSTANCE : stage;
        }
        return EmptyStage.INSTANCE;
    }

    public final IStage getImpressionStage(String adId) {
        Pipeline pipeline;
        IStage stage;
        if (enable) {
            InspectorInfo inspector = StateManager.INSTANCE.getInspector(adId);
            if (inspector != null && (pipeline = inspector.getPipeline()) != null && (stage = pipeline.getStage(StageType.IMPRESSION)) != null) {
                return stage;
            }
            return EmptyStage.INSTANCE;
        }
        return EmptyStage.INSTANCE;
    }

    public final IStage getInteractingStage(String adId) {
        Pipeline pipeline;
        IStage stage;
        if (enable) {
            InspectorInfo inspector = StateManager.INSTANCE.getInspector(adId);
            if (inspector != null && (pipeline = inspector.getPipeline()) != null && (stage = pipeline.getStage(StageType.INTERACTING)) != null) {
                return stage;
            }
            return EmptyStage.INSTANCE;
        }
        return EmptyStage.INSTANCE;
    }

    public final void printI(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (enable) {
            StateManager.INSTANCE.addPrintJobData(PrintJobData.Companion.createJobData(PrintType.INFO, tag, msg));
        }
    }

    public final void printE(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (enable) {
            StateManager.INSTANCE.addPrintJobData(PrintJobData.Companion.createJobData(PrintType.ERROR, tag, msg));
        }
    }

    public final void printW(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (enable) {
            StateManager.INSTANCE.addPrintJobData(PrintJobData.Companion.createJobData(PrintType.WARNING, tag, msg));
        }
    }
}