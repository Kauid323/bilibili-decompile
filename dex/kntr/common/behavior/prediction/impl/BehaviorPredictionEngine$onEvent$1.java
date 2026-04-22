package kntr.common.behavior.prediction.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BehaviorPredictionEngine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.behavior.prediction.impl.BehaviorPredictionEngine", f = "BehaviorPredictionEngine.kt", i = {0, 0, 0, 0, 0, 0}, l = {87}, m = "onEvent", n = {"event", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-BehaviorPredictionEngine$onEvent$2"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1"}, v = 1)
public final class BehaviorPredictionEngine$onEvent$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BehaviorPredictionEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BehaviorPredictionEngine$onEvent$1(BehaviorPredictionEngine behaviorPredictionEngine, Continuation<? super BehaviorPredictionEngine$onEvent$1> continuation) {
        super(continuation);
        this.this$0 = behaviorPredictionEngine;
    }

    public final Object invokeSuspend(Object obj) {
        Object onEvent;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        onEvent = this.this$0.onEvent(null, (Continuation) this);
        return onEvent;
    }
}