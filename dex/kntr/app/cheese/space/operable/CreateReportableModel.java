package kntr.app.cheese.space.operable;

import com.bilibili.ogv.bpf.neuron.NeuronReport;
import com.bilibili.ogv.operation3.module.operable.OperableModel;
import java.util.Map;
import javax.inject.Inject;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreateReportableModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JC\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/cheese/space/operable/CreateReportableModel;", RoomRecommendViewModel.EMPTY_CURSOR, "neuronReport", "Lcom/bilibili/ogv/bpf/neuron/NeuronReport;", "<init>", "(Lcom/bilibili/ogv/bpf/neuron/NeuronReport;)V", "invoke", "Lcom/bilibili/ogv/operation3/module/operable/OperableModel;", "onClickEventId", RoomRecommendViewModel.EMPTY_CURSOR, "reportData", RoomRecommendViewModel.EMPTY_CURSOR, "onExposureEventId", "onClick", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateReportableModel {
    public static final int $stable = 8;
    private final NeuronReport neuronReport;

    @Inject
    public CreateReportableModel(NeuronReport neuronReport) {
        Intrinsics.checkNotNullParameter(neuronReport, "neuronReport");
        this.neuronReport = neuronReport;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OperableModel invoke$default(CreateReportableModel createReportableModel, String str, Map map, String str2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            function0 = null;
        }
        return createReportableModel.invoke(str, map, str2, function0);
    }

    public final OperableModel invoke(String onClickEventId, Map<String, String> map, String onExposureEventId, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(onClickEventId, "onClickEventId");
        Intrinsics.checkNotNullParameter(map, "reportData");
        return new CreateReportableModel$invoke$1(function0, onExposureEventId, this, onClickEventId, map);
    }
}