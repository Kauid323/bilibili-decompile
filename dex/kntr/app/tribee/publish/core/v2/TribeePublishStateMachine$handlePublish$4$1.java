package kntr.app.tribee.publish.core.v2;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.publish.core.v2.model.TribeePublishContent;
import kntr.app.tribee.publish.core.v2.model.TribeePublishFailed;
import kntr.app.tribee.publish.core.v2.model.TribeePublishState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePublishStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishFailed;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$handlePublish$4$1", f = "TribeePublishStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePublishStateMachine$handlePublish$4$1 extends SuspendLambda implements Function2<State<TribeePublishFailed>, Continuation<? super ChangedState<? extends TribeePublishState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeePublishStateMachine$handlePublish$4$1(Continuation<? super TribeePublishStateMachine$handlePublish$4$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeePublishStateMachine$handlePublish$4$1 = new TribeePublishStateMachine$handlePublish$4$1(continuation);
        tribeePublishStateMachine$handlePublish$4$1.L$0 = obj;
        return tribeePublishStateMachine$handlePublish$4$1;
    }

    public final Object invoke(State<TribeePublishFailed> state, Continuation<? super ChangedState<? extends TribeePublishState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$handlePublish$4$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeePublishContent content;
                        content = ((TribeePublishFailed) obj).getContent();
                        return content;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}