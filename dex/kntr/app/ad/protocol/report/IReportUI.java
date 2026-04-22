package kntr.app.ad.protocol.report;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: IReportUI.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JO\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u001b\b\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0002\b\rH'¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/protocol/report/IReportUI;", RoomRecommendViewModel.EMPTY_CURSOR, "event", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "reportable", "Lkntr/app/ad/protocol/report/IReportable;", "isUnique", RoomRecommendViewModel.EMPTY_CURSOR, "uniqueKey", "extraHandler", "Lkotlin/Function1;", "Lkntr/app/ad/protocol/report/IReportExtraHandler;", "Lkotlin/ExtensionFunctionType;", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IReportUI {
    void event(String str, IReportable iReportable, boolean z, String str2, Function1<? super IReportExtraHandler, Unit> function1);

    /* compiled from: IReportUI.kt */
    /* renamed from: kntr.app.ad.protocol.report.IReportUI$-CC */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void event$default(IReportUI iReportUI, String str, IReportable iReportable, boolean z, String str2, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: event");
            }
            iReportUI.event(str, (i & 2) != 0 ? null : iReportable, (i & 4) != 0 ? false : z, (i & 8) != 0 ? str : str2, (i & 16) != 0 ? null : function1);
        }
    }

    /* compiled from: IReportUI.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
    }
}