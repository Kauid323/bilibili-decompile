package kntr.app.tribee.publish.core.v2;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.tribee.publish.core.v2.model.TribeePublishContent;
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
import kotlin.jvm.functions.Function3;

/* compiled from: TribeePublishStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "action", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TitleChanged;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$handleInput$3", f = "TribeePublishStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TribeePublishStateMachine$handleInput$3 extends SuspendLambda implements Function3<TribeePublishAction.TitleChanged, State<TribeePublishContent>, Continuation<? super ChangedState<? extends TribeePublishState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeePublishStateMachine$handleInput$3(Continuation<? super TribeePublishStateMachine$handleInput$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeePublishAction.TitleChanged titleChanged, State<TribeePublishContent> state, Continuation<? super ChangedState<? extends TribeePublishState>> continuation) {
        TribeePublishStateMachine$handleInput$3 tribeePublishStateMachine$handleInput$3 = new TribeePublishStateMachine$handleInput$3(continuation);
        tribeePublishStateMachine$handleInput$3.L$0 = titleChanged;
        tribeePublishStateMachine$handleInput$3.L$1 = state;
        return tribeePublishStateMachine$handleInput$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final TribeePublishAction.TitleChanged action = (TribeePublishAction.TitleChanged) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$handleInput$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeePublishContent invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeePublishStateMachine$handleInput$3.invokeSuspend$lambda$0(TribeePublishAction.TitleChanged.this, (TribeePublishContent) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishContent invokeSuspend$lambda$0(TribeePublishAction.TitleChanged $action, TribeePublishContent $this$mutate) {
        CharSequence $this$filterNot$iv = $action.getString();
        CharSequence $this$filterNotTo$iv$iv = $this$filterNot$iv;
        Appendable destination$iv$iv = new StringBuilder();
        for (int i = 0; i < $this$filterNotTo$iv$iv.length(); i++) {
            char element$iv$iv = $this$filterNotTo$iv$iv.charAt(i);
            if (!(element$iv$iv == '\n')) {
                destination$iv$iv.append(element$iv$iv);
            }
        }
        return TribeePublishContent.copy$default($this$mutate, ((StringBuilder) destination$iv$iv).toString(), null, null, null, null, null, null, false, null, false, false, false, false, null, 16382, null);
    }
}