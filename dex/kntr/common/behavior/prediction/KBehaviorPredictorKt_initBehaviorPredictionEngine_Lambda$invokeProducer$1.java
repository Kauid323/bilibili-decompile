package kntr.common.behavior.prediction;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.behavior.prediction.KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda", f = "KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda.kt", i = {}, l = {13}, m = "invokeProducer", n = {}, s = {}, v = 1)
public final class KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1(KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda kBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda, Continuation<? super KBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda$invokeProducer$1> continuation) {
        super(continuation);
        this.this$0 = kBehaviorPredictorKt_initBehaviorPredictionEngine_Lambda;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invokeProducer((Continuation) this);
    }
}