package kntr.app.ad.domain.report.internal.cache;

import java.util.List;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: IReportStorageManager.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;", RoomRecommendViewModel.EMPTY_CURSOR, "saveOrUpdate", RoomRecommendViewModel.EMPTY_CURSOR, "record", "Lkntr/app/ad/domain/report/internal/ReportRecord;", "(Lkntr/app/ad/domain/report/internal/ReportRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "abandon", "load", RoomRecommendViewModel.EMPTY_CURSOR, "isFromStartUp", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IReportStorageManager {
    Object abandon(ReportRecord reportRecord, Continuation<? super Unit> continuation);

    Object load(boolean z, Continuation<? super List<ReportRecord>> continuation);

    Object saveOrUpdate(ReportRecord reportRecord, Continuation<? super Unit> continuation);
}