package kntr.app.tribee.consume.viewmodel;

import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "accountState", "Lkntr/base/account/AccountState;", "inputState", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$1", f = "TribeeHomeStateMachine.kt", i = {0}, l = {194}, m = "invokeSuspend", n = {"accountState"}, s = {"L$0"}, v = 1)
public final class TribeeHomeStateMachine$1$2$1 extends SuspendLambda implements Function3<AccountState, TribeeHomeContentState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomeStateMachine$1$2$1(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$1$2$1> continuation) {
        super(3, continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Object invoke(AccountState accountState, TribeeHomeContentState tribeeHomeContentState, Continuation<? super Unit> continuation) {
        TribeeHomeStateMachine$1$2$1 tribeeHomeStateMachine$1$2$1 = new TribeeHomeStateMachine$1$2$1(this.this$0, continuation);
        tribeeHomeStateMachine$1$2$1.L$0 = accountState;
        return tribeeHomeStateMachine$1$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AccountState accountState = (AccountState) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().i("TribeeHomeStateMachine", "登录态发生变化.新状态: " + Reflection.getOrCreateKotlinClass(accountState.getClass()).getSimpleName());
                this.L$0 = SpillingKt.nullOutSpilledVariable(accountState);
                this.label = 1;
                if (this.this$0.dispatch(new TribeeHomeStateAction.Refresh(false, 1, null), (Continuation) this) == coroutine_suspended) {
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