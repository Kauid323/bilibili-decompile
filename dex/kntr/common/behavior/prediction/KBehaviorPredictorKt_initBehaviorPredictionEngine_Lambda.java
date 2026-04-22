package kntr.common.behavior.prediction;

import com.bilibili.lib.gripper.api.internal.ProducerBase;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u000e\u0010\u0007\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lkntr/common/behavior/prediction/KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "", "compatJavaParam", "<init>", "(Lkotlin/Unit;)V", "create", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda extends ProducerBase<Unit> {
    public KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda(Unit compatJavaParam) {
    }

    public KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda create() {
        return new KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invokeProducer(Continuation<? super Unit> continuation) {
        KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1 kBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1;
        if (continuation instanceof KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1) {
            kBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1 = (KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1) continuation;
            if ((kBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1.label & Integer.MIN_VALUE) != 0) {
                kBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1.label -= Integer.MIN_VALUE;
                Object $result = kBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        kBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1.label = 1;
                        if (KBehaviorPredictorKt.initBehaviorPredictionEngine(kBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        kBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1 = new KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1(this, continuation);
        Object $result2 = kBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1.label) {
        }
        return Unit.INSTANCE;
    }
}