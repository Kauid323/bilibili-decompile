package kntr.app.digital.preview.report;

import com.bilibili.ogv.bpf.neuron.NeuronReportKt;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001c\b\u0007\u0012\u0011\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rJ*\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\r2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rH\u0002J\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\rR\u0019\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/digital/preview/report/ReportService;", RoomRecommendViewModel.EMPTY_CURSOR, "fillCommonReportParamsSet", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/report/FillCommonReportParams;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "(Ljava/util/Set;)V", "report", RoomRecommendViewModel.EMPTY_CURSOR, "eventId", RoomRecommendViewModel.EMPTY_CURSOR, "map", RoomRecommendViewModel.EMPTY_CURSOR, "generateReportMap", "getCommonParams", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReportService {
    public static final int $stable = 8;
    private final Set<FillCommonReportParams> fillCommonReportParamsSet;

    @Inject
    public ReportService(Set<FillCommonReportParams> set) {
        Intrinsics.checkNotNullParameter(set, "fillCommonReportParamsSet");
        this.fillCommonReportParamsSet = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void report$default(ReportService reportService, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        reportService.report(str, map);
    }

    public final void report(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        NeuronReportKt.getNeuronReport().invoke(eventId, generateReportMap(map));
    }

    private final Map<String, String> generateReportMap(Map<String, String> map) {
        Map $this$generateReportMap_u24lambda_u240 = MapsKt.createMapBuilder();
        Iterable $this$forEach$iv = this.fillCommonReportParamsSet;
        for (Object element$iv : $this$forEach$iv) {
            FillCommonReportParams it = (FillCommonReportParams) element$iv;
            it.invoke($this$generateReportMap_u24lambda_u240);
        }
        if (map != null) {
            $this$generateReportMap_u24lambda_u240.putAll(map);
        }
        return MapsKt.build($this$generateReportMap_u24lambda_u240);
    }

    public final Map<String, String> getCommonParams() {
        return generateReportMap(null);
    }
}