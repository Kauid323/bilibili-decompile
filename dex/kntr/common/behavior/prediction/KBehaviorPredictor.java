package kntr.common.behavior.prediction;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: KBehaviorPredictor.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0097\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0097\u0001¨\u0006\r"}, d2 = {"Lkntr/common/behavior/prediction/KBehaviorPredictor;", "Lkntr/common/behavior/prediction/BehaviorPredictionService;", "<init>", "()V", "predict", "Lkntr/common/behavior/prediction/IPredictionResult;", "context", "Lkntr/common/behavior/prediction/IPredictionContext;", "start", "", "update", "data", "Lkntr/common/behavior/prediction/IBehaviorData;", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KBehaviorPredictor implements BehaviorPredictionService {
    public static final KBehaviorPredictor INSTANCE = new KBehaviorPredictor();
    private final /* synthetic */ BehaviorPredictionService $$delegate_0;

    @Override // kntr.common.behavior.prediction.BehaviorPredictionService
    public IPredictionResult predict(IPredictionContext iPredictionContext) {
        Intrinsics.checkNotNullParameter(iPredictionContext, "context");
        return this.$$delegate_0.predict(iPredictionContext);
    }

    @Override // kntr.common.behavior.prediction.BehaviorPredictionService
    public void start() {
        this.$$delegate_0.start();
    }

    @Override // kntr.common.behavior.prediction.BehaviorPredictionService
    public void update(IBehaviorData iBehaviorData) {
        Intrinsics.checkNotNullParameter(iBehaviorData, "data");
        this.$$delegate_0.update(iBehaviorData);
    }

    private KBehaviorPredictor() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        this.$$delegate_0 = ((BehaviorPredictionEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(BehaviorPredictionEntryPoint.class))).getPredictor();
    }
}