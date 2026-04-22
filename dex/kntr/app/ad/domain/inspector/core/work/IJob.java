package kntr.app.ad.domain.inspector.core.work;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: Job.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u000bH'J\u0014\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\rH'J\u0014\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\rH&J\u0014\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\rH'R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/IJob;", RoomRecommendViewModel.EMPTY_CURSOR, "dataFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lkntr/app/ad/domain/inspector/core/work/IJobData;", "getDataFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "data", "getData", "()Lkntr/app/ad/domain/inspector/core/work/IJobData;", "start", RoomRecommendViewModel.EMPTY_CURSOR, "success", RoomRecommendViewModel.EMPTY_CURSOR, "warning", "msg", "fail", "reason", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IJob {
    void fail(String str);

    IJobData getData();

    StateFlow<IJobData> getDataFlow();

    void start();

    void success(String str);

    void warning(String str);

    /* compiled from: Job.kt */
    /* renamed from: kntr.app.ad.domain.inspector.core.work.IJob$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static IJobData $default$getData(IJob _this) {
            return (IJobData) _this.getDataFlow().getValue();
        }

        public static /* synthetic */ void success$default(IJob iJob, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: success");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            iJob.success(str);
        }

        public static /* synthetic */ void warning$default(IJob iJob, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warning");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            iJob.warning(str);
        }

        public static /* synthetic */ void fail$default(IJob iJob, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            iJob.fail(str);
        }
    }

    /* compiled from: Job.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static IJobData getData(IJob $this) {
            return CC.$default$getData($this);
        }
    }
}