package kntr.app.cheese.space.operable;

import com.bilibili.ogv.bpf.neuron.NeuronReport;
import com.bilibili.ogv.operation3.module.navigable.Navigable;
import com.bilibili.ogv.operation3.module.operable.OperableModel;
import com.bilibili.ogv.operation3.module.report.Reportable;
import javax.inject.Inject;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Response;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CreateOperableModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/cheese/space/operable/CreateOperableModel;", RoomRecommendViewModel.EMPTY_CURSOR, "neuronReport", "Lcom/bilibili/ogv/bpf/neuron/NeuronReport;", "<init>", "(Lcom/bilibili/ogv/bpf/neuron/NeuronReport;)V", "invoke", "Lcom/bilibili/ogv/operation3/module/operable/OperableModel;", "router", "Lkntr/base/router/Router;", "target", "onClick", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateOperableModel {
    public static final int $stable = 8;
    private final NeuronReport neuronReport;

    @Inject
    public CreateOperableModel(NeuronReport neuronReport) {
        Intrinsics.checkNotNullParameter(neuronReport, "neuronReport");
        this.neuronReport = neuronReport;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OperableModel invoke$default(CreateOperableModel createOperableModel, Router router, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        return createOperableModel.invoke(router, obj, function0);
    }

    public final OperableModel invoke(final Router router, Object target, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(target, "target");
        Function0 finalOnClick = null;
        Navigable navigable = target instanceof Navigable ? (Navigable) target : null;
        Reportable reportable = target instanceof Reportable ? (Reportable) target : null;
        if (function0 == null) {
            final String url = navigable != null ? navigable.getUrl() : null;
            String str = url;
            if (!(str == null || StringsKt.isBlank(str))) {
                finalOnClick = new Function0() { // from class: kntr.app.cheese.space.operable.CreateOperableModel$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Response invoke$lambda$0$0;
                        invoke$lambda$0$0 = CreateOperableModel.invoke$lambda$0$0(router, url);
                        return invoke$lambda$0$0;
                    }
                };
            }
        } else {
            finalOnClick = function0;
        }
        return new CreateOperableModel$invoke$1(finalOnClick, reportable, this);
    }

    public static final Response invoke$lambda$0$0(Router $router, String $url) {
        return $router.launch(UrisKt.toUri($url));
    }
}