package kntr.app.game.gamebind;

import com.bilibili.biligame.kntr.common.api.BiligameApiException;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.game.base.viewmodel.PageState;
import kntr.app.game.gamebind.AuthorizeEvent;
import kntr.app.game.gamebind.GameBindEvent;
import kntr.app.game.gamebind.bean.AuthorizeInfo;
import kntr.base.udf.StoreMachine;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameAuthorizeViewModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/base/viewmodel/PageState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/game/base/viewmodel/PageState$Loading;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.gamebind.GameAuthorizeViewModel$machine$1$1$1", f = "GameAuthorizeViewModel.kt", i = {0, 1, 1, 2, 2, 3, 3}, l = {52, 54, 55, 63}, m = "invokeSuspend", n = {"state", "state", "authorizeInfo", "state", "authorizeInfo", "state", "e"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class GameAuthorizeViewModel$machine$1$1$1 extends SuspendLambda implements Function2<State<PageState.Loading>, Continuation<? super ChangedState<? extends PageState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GameAuthorizeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameAuthorizeViewModel$machine$1$1$1(GameAuthorizeViewModel gameAuthorizeViewModel, Continuation<? super GameAuthorizeViewModel$machine$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = gameAuthorizeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> gameAuthorizeViewModel$machine$1$1$1 = new GameAuthorizeViewModel$machine$1$1$1(this.this$0, continuation);
        gameAuthorizeViewModel$machine$1$1$1.L$0 = obj;
        return gameAuthorizeViewModel$machine$1$1$1;
    }

    public final Object invoke(State<PageState.Loading> state, Continuation<? super ChangedState<? extends PageState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0052 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:8:0x0022, B:28:0x008a, B:11:0x002a, B:25:0x006d, B:12:0x002e, B:20:0x004a, B:22:0x0052, B:29:0x0094, B:17:0x0039), top: B:47:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094 A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #0 {all -> 0x0033, blocks: (B:8:0x0022, B:28:0x008a, B:11:0x002a, B:25:0x006d, B:12:0x002e, B:20:0x004a, B:22:0x0052, B:29:0x0094, B:17:0x0039), top: B:47:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        StoreMachine storeMachine;
        Throwable e;
        Object startLoad;
        final AuthorizeInfo authorizeInfo;
        StoreMachine storeMachine2;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th) {
            if (!(th instanceof BiligameApiException)) {
                final GameAuthorizeViewModel gameAuthorizeViewModel = this.this$0;
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$machine$1$1$1$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        PageState.Error invokeSuspend$lambda$4;
                        invokeSuspend$lambda$4 = GameAuthorizeViewModel$machine$1$1$1.invokeSuspend$lambda$4(GameAuthorizeViewModel.this, (PageState.Loading) obj);
                        return invokeSuspend$lambda$4;
                    }
                });
            } else if (th.getCode() != -8004 && th.getCode() != -8009) {
                final GameAuthorizeViewModel gameAuthorizeViewModel2 = this.this$0;
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$machine$1$1$1$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        PageState.Error invokeSuspend$lambda$3;
                        invokeSuspend$lambda$3 = GameAuthorizeViewModel$machine$1$1$1.invokeSuspend$lambda$3(th, gameAuthorizeViewModel2, (PageState.Loading) obj);
                        return invokeSuspend$lambda$3;
                    }
                });
            } else {
                storeMachine = this.this$0.actionMachine;
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(th);
                this.label = 4;
                if (storeMachine.dispatch(AuthorizeEvent.NotifyNoRoleInfo.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                e = th;
            }
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = state;
                this.label = 1;
                startLoad = this.this$0.startLoad((Continuation) this);
                if (startLoad == coroutine_suspended) {
                    return coroutine_suspended;
                }
                authorizeInfo = (AuthorizeInfo) startLoad;
                if (authorizeInfo.getBind()) {
                    return state.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$machine$1$1$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            PageState.Content invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = GameAuthorizeViewModel$machine$1$1$1.invokeSuspend$lambda$1(AuthorizeInfo.this, (PageState.Loading) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(authorizeInfo);
                this.label = 2;
                if (GameBindEventStore.INSTANCE.post(GameBindEvent.Bind.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                storeMachine2 = this.this$0.actionMachine;
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(authorizeInfo);
                this.label = 3;
                if (storeMachine2.dispatch(AuthorizeEvent.Bound.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$machine$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        PageState.Empty invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = GameAuthorizeViewModel$machine$1$1$1.invokeSuspend$lambda$0((PageState.Loading) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                startLoad = $result;
                authorizeInfo = (AuthorizeInfo) startLoad;
                if (authorizeInfo.getBind()) {
                }
                break;
            case 2:
                authorizeInfo = (AuthorizeInfo) this.L$1;
                ResultKt.throwOnFailure($result);
                storeMachine2 = this.this$0.actionMachine;
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(authorizeInfo);
                this.label = 3;
                if (storeMachine2.dispatch(AuthorizeEvent.Bound.INSTANCE, (Continuation) this) == coroutine_suspended) {
                }
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$machine$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        PageState.Empty invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = GameAuthorizeViewModel$machine$1$1$1.invokeSuspend$lambda$0((PageState.Loading) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            case 3:
                AuthorizeInfo authorizeInfo2 = (AuthorizeInfo) this.L$1;
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$machine$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        PageState.Empty invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = GameAuthorizeViewModel$machine$1$1$1.invokeSuspend$lambda$0((PageState.Loading) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            case 4:
                e = (Throwable) this.L$1;
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.GameAuthorizeViewModel$machine$1$1$1$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        PageState.Empty invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = GameAuthorizeViewModel$machine$1$1$1.invokeSuspend$lambda$2((PageState.Loading) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Empty invokeSuspend$lambda$0(PageState.Loading $this$override) {
        return PageState.Empty.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Content invokeSuspend$lambda$1(AuthorizeInfo $authorizeInfo, PageState.Loading $this$override) {
        return new PageState.Content($authorizeInfo, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Empty invokeSuspend$lambda$2(PageState.Loading $this$override) {
        return PageState.Empty.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Error invokeSuspend$lambda$3(Throwable $e, GameAuthorizeViewModel this$0, PageState.Loading $this$override) {
        String mapCodeToMessage;
        int code = ((BiligameApiException) $e).getCode();
        mapCodeToMessage = this$0.mapCodeToMessage(((BiligameApiException) $e).getCode(), $e.getMessage());
        return new PageState.Error(code, mapCodeToMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Error invokeSuspend$lambda$4(GameAuthorizeViewModel this$0, PageState.Loading $this$override) {
        return new PageState.Error(-1, GameAuthorizeViewModel.mapCodeToMessage$default(this$0, -1, null, 2, null));
    }
}