package kntr.common.behavior.prediction.event;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.IPlatformNeuron;
import kntr.common.behavior.prediction.IBehaviorData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: IBPNeuronEventHandler.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/common/behavior/prediction/event/IBPNeuronEventHandler;", "", "name", "", "getName", "()Ljava/lang/String;", "handle", "Lkntr/common/behavior/prediction/IBehaviorData;", "event", "Lkntr/base/neuron/IPlatformNeuron$Event;", "(Lkntr/base/neuron/IPlatformNeuron$Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IBPNeuronEventHandler {
    String getName();

    Object handle(IPlatformNeuron.Event event, Continuation<? super IBehaviorData> continuation);
}