package kntr.app.ad.domain.report.internal.upload;

import java.util.List;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: IReportUploader.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001Jh\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eH¦@¢\u0006\u0002\u0010\u0010J$\u0010\u0002\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u0006\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/report/internal/upload/IReportUploader;", RoomRecommendViewModel.EMPTY_CURSOR, "upload", RoomRecommendViewModel.EMPTY_CURSOR, "record", "Lkntr/app/ad/domain/report/internal/ReportRecord;", "needRetry", "startAction", "Lkotlin/Function1;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "successAction", "Lkotlin/Function0;", "failureAction", "Lkotlin/Function2;", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/ad/domain/report/internal/ReportRecord;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "records", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IReportUploader {
    Object upload(List<ReportRecord> list, boolean z, Continuation<? super Boolean> continuation);

    Object upload(ReportRecord reportRecord, boolean z, Function1<? super String, Unit> function1, Function0<Unit> function0, Function2<? super Integer, ? super String, Unit> function2, Continuation<? super Boolean> continuation);

    /* compiled from: IReportUploader.kt */
    /* renamed from: kntr.app.ad.domain.report.internal.upload.IReportUploader$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object upload$default(IReportUploader iReportUploader, ReportRecord reportRecord, boolean z, Function1 function1, Function0 function0, Function2 function2, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                return iReportUploader.upload(reportRecord, z, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : function0, (i & 16) != 0 ? null : function2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upload");
        }
    }

    /* compiled from: IReportUploader.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
    }
}