package kntr.app.game.gamebind;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.game.gamebind.AuthorizeAction;
import kntr.app.game.gamebind.AuthorizeEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameAuthorizeViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/gamebind/AuthorizeAction;", "<unused var>", "Lkntr/app/game/gamebind/AuthorizeEvent$Close;", "action", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$2", f = "GameAuthorizeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class GameAuthorizeViewModel$actionMachine$1$1$2 extends SuspendLambda implements Function3<AuthorizeEvent.Close, State<AuthorizeAction>, Continuation<? super ChangedState<? extends AuthorizeAction>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GameAuthorizeViewModel$actionMachine$1$1$2(Continuation<? super GameAuthorizeViewModel$actionMachine$1$1$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(AuthorizeEvent.Close close, State<AuthorizeAction> state, Continuation<? super ChangedState<? extends AuthorizeAction>> continuation) {
        GameAuthorizeViewModel$actionMachine$1$1$2 gameAuthorizeViewModel$actionMachine$1$1$2 = new GameAuthorizeViewModel$actionMachine$1$1$2(continuation);
        gameAuthorizeViewModel$actionMachine$1$1$2.L$0 = state;
        return gameAuthorizeViewModel$actionMachine$1$1$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State action = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        AuthorizeAction.Close invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = GameAuthorizeViewModel$actionMachine$1$1$2.invokeSuspend$lambda$0((AuthorizeAction) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthorizeAction.Close invokeSuspend$lambda$0(AuthorizeAction $this$override) {
        return new AuthorizeAction.Close(null, 1, null);
    }
}