package kntr.app.ad.protocol.report;

import java.util.List;
import kntr.app.ad.protocol.IMotion;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IReportMMA.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bH'JR\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bH'J<\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bH'¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lkntr/app/ad/protocol/report/IReportMMA;", RoomRecommendViewModel.EMPTY_CURSOR, "exposed", RoomRecommendViewModel.EMPTY_CURSOR, "adInfo", "Lkntr/app/ad/protocol/report/IReportable;", "urls", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "isUnique", RoomRecommendViewModel.EMPTY_CURSOR, "uniqueKey", "submitActionFrom", "click", "motion", "Lkntr/app/ad/protocol/IMotion;", "event", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IReportMMA {
    void click(IReportable iReportable, List<String> list, IMotion iMotion, boolean z, String str, String str2);

    void event(IReportable iReportable, List<String> list, boolean z, String str);

    void exposed(IReportable iReportable, List<String> list, boolean z, String str, String str2);

    /* compiled from: IReportMMA.kt */
    /* renamed from: kntr.app.ad.protocol.report.IReportMMA$-CC */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void exposed$default(IReportMMA iReportMMA, IReportable iReportable, List list, boolean z, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposed");
            }
            iReportMMA.exposed(iReportable, list, (i & 4) != 0 ? true : z, (i & 8) != 0 ? "show" : str, (i & 16) != 0 ? SubmitActionFrom.MMA_KEY_SHOW_URLS : str2);
        }

        public static /* synthetic */ void click$default(IReportMMA iReportMMA, IReportable iReportable, List list, IMotion iMotion, boolean z, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: click");
            }
            iReportMMA.click(iReportable, list, (i & 4) != 0 ? null : iMotion, (i & 8) != 0 ? false : z, (i & 16) != 0 ? "click" : str, (i & 32) != 0 ? SubmitActionFrom.MMA_KEY_CLICK_URLS : str2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void event$default(IReportMMA iReportMMA, IReportable iReportable, List list, boolean z, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: event");
            }
            if ((i & 2) != 0) {
                list = null;
            }
            if ((i & 4) != 0) {
                z = true;
            }
            if ((i & 8) != 0) {
                str = null;
            }
            iReportMMA.event(iReportable, list, z, str);
        }
    }

    /* compiled from: IReportMMA.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
    }
}