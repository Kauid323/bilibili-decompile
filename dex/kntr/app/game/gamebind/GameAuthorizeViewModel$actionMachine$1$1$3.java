package kntr.app.game.gamebind;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.game.gamebind.AuthorizeAction;
import kntr.app.game.gamebind.AuthorizeEvent;
import kntr.app.game.gamebind.GameBindEvent;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/gamebind/AuthorizeAction;", "<unused var>", "Lkntr/app/game/gamebind/AuthorizeEvent$CheckBind;", "action", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$3", f = "GameAuthorizeViewModel.kt", i = {0, 1, 1}, l = {127, 132}, m = "invokeSuspend", n = {"action", "action", "bindSuccess"}, s = {"L$0", "L$0", "I$0"}, v = 1)
public final class GameAuthorizeViewModel$actionMachine$1$1$3 extends SuspendLambda implements Function3<AuthorizeEvent.CheckBind, State<AuthorizeAction>, Continuation<? super ChangedState<? extends AuthorizeAction>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GameAuthorizeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameAuthorizeViewModel$actionMachine$1$1$3(GameAuthorizeViewModel gameAuthorizeViewModel, Continuation<? super GameAuthorizeViewModel$actionMachine$1$1$3> continuation) {
        super(3, continuation);
        this.this$0 = gameAuthorizeViewModel;
    }

    public final Object invoke(AuthorizeEvent.CheckBind checkBind, State<AuthorizeAction> state, Continuation<? super ChangedState<? extends AuthorizeAction>> continuation) {
        GameAuthorizeViewModel$actionMachine$1$1$3 gameAuthorizeViewModel$actionMachine$1$1$3 = new GameAuthorizeViewModel$actionMachine$1$1$3(this.this$0, continuation);
        gameAuthorizeViewModel$actionMachine$1$1$3.L$0 = state;
        return gameAuthorizeViewModel$actionMachine$1$1$3.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int i;
        int i2;
        Object checkBind;
        State action = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th) {
            i = 0;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = action;
                this.label = 1;
                checkBind = this.this$0.checkBind((Continuation) this);
                if (checkBind == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = ((Boolean) checkBind).booleanValue();
                if (i == 0) {
                    this.L$0 = action;
                    this.I$0 = i;
                    this.label = 2;
                    if (GameBindEventStore.INSTANCE.post(GameBindEvent.Bind.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i2 = i;
                    final GameAuthorizeViewModel gameAuthorizeViewModel = this.this$0;
                    return action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$3$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            AuthorizeAction.Close invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = GameAuthorizeViewModel$actionMachine$1$1$3.invokeSuspend$lambda$0(GameAuthorizeViewModel.this, (AuthorizeAction) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                }
                return action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$3$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        AuthorizeAction.Close invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = GameAuthorizeViewModel$actionMachine$1$1$3.invokeSuspend$lambda$1((AuthorizeAction) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                checkBind = $result;
                i = ((Boolean) checkBind).booleanValue();
                if (i == 0) {
                }
                break;
            case 2:
                i2 = this.I$0;
                ResultKt.throwOnFailure($result);
                final GameAuthorizeViewModel gameAuthorizeViewModel2 = this.this$0;
                return action.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$actionMachine$1$1$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        AuthorizeAction.Close invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = GameAuthorizeViewModel$actionMachine$1$1$3.invokeSuspend$lambda$0(GameAuthorizeViewModel.this, (AuthorizeAction) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthorizeAction.Close invokeSuspend$lambda$0(GameAuthorizeViewModel this$0, AuthorizeAction $this$override) {
        String bindSuccessToast;
        bindSuccessToast = this$0.bindSuccessToast();
        return new AuthorizeAction.Close(bindSuccessToast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthorizeAction.Close invokeSuspend$lambda$1(AuthorizeAction $this$override) {
        return new AuthorizeAction.Close(null, 1, null);
    }
}