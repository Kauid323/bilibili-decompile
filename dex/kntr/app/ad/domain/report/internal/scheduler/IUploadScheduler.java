package kntr.app.ad.domain.report.internal.scheduler;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IUploadScheduler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/report/internal/scheduler/IUploadScheduler;", RoomRecommendViewModel.EMPTY_CURSOR, "startScheduling", RoomRecommendViewModel.EMPTY_CURSOR, "isFromStartUp", RoomRecommendViewModel.EMPTY_CURSOR, "stopScheduling", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IUploadScheduler {
    void startScheduling(boolean z);

    void stopScheduling();

    /* compiled from: IUploadScheduler.kt */
    /* renamed from: kntr.app.ad.domain.report.internal.scheduler.IUploadScheduler$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void startScheduling$default(IUploadScheduler iUploadScheduler, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startScheduling");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            iUploadScheduler.startScheduling(z);
        }
    }

    /* compiled from: IUploadScheduler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
    }
}