package kntr.common.behavior.prediction;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: BehaviorPrediction.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH'¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/common/behavior/prediction/BehaviorPredictionService;", "", "start", "", "update", "data", "Lkntr/common/behavior/prediction/IBehaviorData;", "predict", "Lkntr/common/behavior/prediction/IPredictionResult;", "context", "Lkntr/common/behavior/prediction/IPredictionContext;", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface BehaviorPredictionService {
    IPredictionResult predict(IPredictionContext iPredictionContext);

    void start();

    void update(IBehaviorData iBehaviorData);
}