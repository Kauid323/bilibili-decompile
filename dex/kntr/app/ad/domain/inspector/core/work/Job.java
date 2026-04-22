package kntr.app.ad.domain.inspector.core.work;

import kntr.app.ad.domain.inspector.core.util.DateTimeUtils;
import kntr.app.ad.domain.inspector.core.work.IJobData;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: Job.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b!\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0016J\r\u0010\u001b\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00028\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0002\u0010\u001eR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/Job;", "T", "Lkntr/app/ad/domain/inspector/core/work/IJobData;", "Lkntr/app/ad/domain/inspector/core/work/IJob;", "initialData", "<init>", "(Lkntr/app/ad/domain/inspector/core/work/IJobData;)V", "_dataFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "dataFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getDataFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "data", "getData", "()Lkntr/app/ad/domain/inspector/core/work/IJobData;", "updateData", RoomRecommendViewModel.EMPTY_CURSOR, "block", "Lkotlin/Function1;", "start", "success", RoomRecommendViewModel.EMPTY_CURSOR, "warning", "msg", "fail", "reason", "createUpdatedData", "handleSuccessData", "newData", "(Lkntr/app/ad/domain/inspector/core/work/IJobData;Ljava/lang/String;)V", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class Job<T extends IJobData> implements IJob {
    public static final int $stable = 8;
    private final MutableStateFlow<T> _dataFlow;
    private final StateFlow<T> dataFlow;

    protected abstract T createUpdatedData();

    public Job(T t) {
        Intrinsics.checkNotNullParameter(t, "initialData");
        this._dataFlow = StateFlowKt.MutableStateFlow(t);
        this.dataFlow = FlowKt.asStateFlow(this._dataFlow);
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJob
    public StateFlow<T> getDataFlow() {
        return this.dataFlow;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJob
    public T getData() {
        return (T) this._dataFlow.getValue();
    }

    private final void updateData(Function1<? super T, Unit> function1) {
        MutableStateFlow<T> mutableStateFlow = this._dataFlow;
        T createUpdatedData = createUpdatedData();
        function1.invoke(createUpdatedData);
        mutableStateFlow.setValue(createUpdatedData);
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJob
    public void start() {
        updateData(new Function1() { // from class: kntr.app.ad.domain.inspector.core.work.Job$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit start$lambda$0;
                start$lambda$0 = Job.start$lambda$0((IJobData) obj);
                return start$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit start$lambda$0(IJobData jobData) {
        Intrinsics.checkNotNullParameter(jobData, "jobData");
        jobData.setStatus(Status.RUNNING);
        jobData.setStartTime(Long.valueOf(DateTimeUtils.INSTANCE.currentTimeMillis()));
        return Unit.INSTANCE;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJob
    public void success(final String data) {
        updateData(new Function1() { // from class: kntr.app.ad.domain.inspector.core.work.Job$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit success$lambda$0;
                success$lambda$0 = Job.success$lambda$0(Job.this, data, (IJobData) obj);
                return success$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit success$lambda$0(Job this$0, String $data, IJobData jobData) {
        Intrinsics.checkNotNullParameter(jobData, "jobData");
        jobData.setStatus(Status.SUCCESS);
        jobData.setEndTime(Long.valueOf(DateTimeUtils.INSTANCE.currentTimeMillis()));
        this$0.handleSuccessData(jobData, $data);
        return Unit.INSTANCE;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJob
    public void warning(String msg) {
        updateData(new Function1() { // from class: kntr.app.ad.domain.inspector.core.work.Job$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit warning$lambda$0;
                warning$lambda$0 = Job.warning$lambda$0((IJobData) obj);
                return warning$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit warning$lambda$0(IJobData jobData) {
        Intrinsics.checkNotNullParameter(jobData, "jobData");
        jobData.setStatus(Status.WARNING);
        jobData.setEndTime(Long.valueOf(DateTimeUtils.INSTANCE.currentTimeMillis()));
        return Unit.INSTANCE;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJob
    public void fail(String reason) {
        updateData(new Function1() { // from class: kntr.app.ad.domain.inspector.core.work.Job$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit fail$lambda$0;
                fail$lambda$0 = Job.fail$lambda$0((IJobData) obj);
                return fail$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fail$lambda$0(IJobData jobData) {
        Intrinsics.checkNotNullParameter(jobData, "jobData");
        jobData.setStatus(Status.FAILED);
        jobData.setEndTime(Long.valueOf(DateTimeUtils.INSTANCE.currentTimeMillis()));
        return Unit.INSTANCE;
    }

    protected void handleSuccessData(T t, String data) {
        Intrinsics.checkNotNullParameter(t, "newData");
    }
}