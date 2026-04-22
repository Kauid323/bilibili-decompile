package kntr.common.behavior.prediction.predictor;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.behavior.prediction.BehaviorPredictionService;
import kntr.common.behavior.prediction.IPredictionContext;
import kotlin.Metadata;

/* compiled from: IBehaviorPredictor.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/common/behavior/prediction/predictor/IBehaviorPredictor;", "Lkntr/common/behavior/prediction/BehaviorPredictionService;", "name", "", "getName", "()Ljava/lang/String;", "canPredict", "", "context", "Lkntr/common/behavior/prediction/IPredictionContext;", "Companion", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IBehaviorPredictor extends BehaviorPredictionService {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String PREDICTOR_VIDEO_QUALITY = "video-quality";

    boolean canPredict(IPredictionContext iPredictionContext);

    String getName();

    /* compiled from: IBehaviorPredictor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/common/behavior/prediction/predictor/IBehaviorPredictor$Companion;", "", "<init>", "()V", "PREDICTOR_VIDEO_QUALITY", "", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String PREDICTOR_VIDEO_QUALITY = "video-quality";

        private Companion() {
        }
    }
}