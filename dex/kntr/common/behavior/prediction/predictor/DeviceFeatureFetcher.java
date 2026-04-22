package kntr.common.behavior.prediction.predictor;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.utils.CoroutineExKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: VideoQualityPredictor.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lkntr/common/behavior/prediction/predictor/DeviceFeatureFetcher;", "", "<init>", "()V", "fetch", "", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class DeviceFeatureFetcher {
    public final void fetch() {
        BuildersKt.launch$default(CoroutineExKt.createIOScope(), (CoroutineContext) null, (CoroutineStart) null, new DeviceFeatureFetcher$fetch$1(null), 3, (Object) null);
    }
}