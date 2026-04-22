package kntr.common.behavior.prediction;

import com.bilibili.lib.gripper.api.PreTrigger;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.behavior.prediction.impl.BehaviorPredictionEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: KBehaviorPredictor.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0001\u001a\u000e\u0010\u0002\u001a\u00020\u0003H\u0081@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"provideBehaviorPredictor", "Lkntr/common/behavior/prediction/BehaviorPredictionService;", "initBehaviorPredictionEngine", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "behavior-prediction_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KBehaviorPredictorKt {
    public static final BehaviorPredictionService provideBehaviorPredictor() {
        return new BehaviorPredictionEngine();
    }

    @PreTrigger(awaitComplete = true, trigger = "OnMainIdle")
    public static final Object initBehaviorPredictionEngine(Continuation<? super Unit> continuation) {
        KBehaviorPredictor.INSTANCE.start();
        return Unit.INSTANCE;
    }
}