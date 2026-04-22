package kntr.app.cheese.space.operable;

import com.bilibili.framework.exposure.core.ExposureEntry;
import com.bilibili.ogv.bpf.neuron.NeuronReport;
import com.bilibili.ogv.operation3.module.exposure.ExposureEntryFactory;
import com.bilibili.ogv.operation3.module.operable.OperableModel;
import com.bilibili.ogv.operation3.module.report.Reportable;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: CreateOperableModel.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"kntr/app/cheese/space/operable/CreateOperableModel$invoke$1", "Lcom/bilibili/ogv/operation3/module/operable/OperableModel;", "onClick", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "getOnClick", "()Lkotlin/jvm/functions/Function0;", "exposureEntry", "Lcom/bilibili/framework/exposure/core/ExposureEntry;", "getExposureEntry", "()Lcom/bilibili/framework/exposure/core/ExposureEntry;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateOperableModel$invoke$1 implements OperableModel {
    private final ExposureEntry exposureEntry;
    private final Function0<Unit> onClick;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreateOperableModel$invoke$1(final Function0<? extends Object> function0, final Reportable $reportable, final CreateOperableModel $receiver) {
        Function0<Unit> function02;
        final String eventId;
        ExposureEntry exposureEntry = null;
        if (function0 == null) {
            function02 = null;
        } else {
            function02 = new Function0() { // from class: kntr.app.cheese.space.operable.CreateOperableModel$invoke$1$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit onClick$lambda$0;
                    onClick$lambda$0 = CreateOperableModel$invoke$1.onClick$lambda$0(function0, $reportable, $receiver);
                    return onClick$lambda$0;
                }
            };
        }
        this.onClick = function02;
        if ($reportable != null && (eventId = $reportable.getExposureEventId()) != null) {
            exposureEntry = ExposureEntryFactory.INSTANCE.newExposureEntry(new Function0() { // from class: kntr.app.cheese.space.operable.CreateOperableModel$invoke$1$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit exposureEntry$lambda$1$0;
                    exposureEntry$lambda$1$0 = CreateOperableModel$invoke$1.exposureEntry$lambda$1$0(CreateOperableModel.this, eventId, $reportable);
                    return exposureEntry$lambda$1$0;
                }
            });
        }
        this.exposureEntry = exposureEntry;
    }

    public Function0<Unit> getOnClick() {
        return this.onClick;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$0(Function0 $finalOnClick, Reportable $reportable, CreateOperableModel this$0) {
        String eventId;
        NeuronReport neuronReport;
        $finalOnClick.invoke();
        if ($reportable != null && (eventId = $reportable.getClickEventId()) != null) {
            neuronReport = this$0.neuronReport;
            neuronReport.invoke(eventId, $reportable.getReport());
        }
        return Unit.INSTANCE;
    }

    public ExposureEntry getExposureEntry() {
        return this.exposureEntry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exposureEntry$lambda$1$0(CreateOperableModel this$0, String $eventId, Reportable $reportable) {
        NeuronReport neuronReport;
        neuronReport = this$0.neuronReport;
        neuronReport.invoke($eventId, $reportable.getReport());
        return Unit.INSTANCE;
    }
}