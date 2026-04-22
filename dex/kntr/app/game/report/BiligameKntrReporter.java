package kntr.app.game.report;

import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* compiled from: Report.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H&J&\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H&J(\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/game/report/BiligameKntrReporter;", RoomRecommendViewModel.EMPTY_CURSOR, "reportClick", RoomRecommendViewModel.EMPTY_CURSOR, "eventId", RoomRecommendViewModel.EMPTY_CURSOR, "extended", RoomRecommendViewModel.EMPTY_CURSOR, "reportExposure", "reportSystem", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface BiligameKntrReporter {
    void reportClick(String str, Map<String, String> map);

    void reportExposure(String str, Map<String, String> map);

    void reportSystem(String str, Map<String, String> map);

    /* compiled from: Report.kt */
    /* renamed from: kntr.app.game.report.BiligameKntrReporter$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportClick$default(BiligameKntrReporter biligameKntrReporter, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportClick");
            }
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            biligameKntrReporter.reportClick(str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportExposure$default(BiligameKntrReporter biligameKntrReporter, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportExposure");
            }
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            biligameKntrReporter.reportExposure(str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportSystem$default(BiligameKntrReporter biligameKntrReporter, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportSystem");
            }
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            biligameKntrReporter.reportSystem(str, map);
        }
    }

    /* compiled from: Report.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
    }
}