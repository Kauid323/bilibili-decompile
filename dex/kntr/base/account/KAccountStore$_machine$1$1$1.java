package kntr.base.account;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.account.adapter.AccountAdapterEvent;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KAccountStore.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/base/account/AccountState;", "value", "Lkntr/base/account/adapter/AccountAdapterEvent;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.account.KAccountStore$_machine$1$1$1", f = "KAccountStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KAccountStore$_machine$1$1$1 extends SuspendLambda implements Function3<AccountAdapterEvent, State<AccountState>, Continuation<? super ChangedState<? extends AccountState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KAccountStore$_machine$1$1$1(Continuation<? super KAccountStore$_machine$1$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(AccountAdapterEvent accountAdapterEvent, State<AccountState> state, Continuation<? super ChangedState<? extends AccountState>> continuation) {
        KAccountStore$_machine$1$1$1 kAccountStore$_machine$1$1$1 = new KAccountStore$_machine$1$1$1(continuation);
        kAccountStore$_machine$1$1$1.L$0 = accountAdapterEvent;
        kAccountStore$_machine$1$1$1.L$1 = state;
        return kAccountStore$_machine$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final AccountState.Idle result;
        AccountAdapterEvent value = (AccountAdapterEvent) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (value instanceof AccountAdapterEvent.OnLogin) {
                    result = new AccountState.Logged(((AccountAdapterEvent.OnLogin) value).getUserInfo());
                } else if (value instanceof AccountAdapterEvent.OnUpdate) {
                    result = new AccountState.Logged(((AccountAdapterEvent.OnUpdate) value).getUserInfo());
                } else if (!(value instanceof AccountAdapterEvent.OnLogout)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    result = AccountState.Idle.INSTANCE;
                }
                KLog_androidKt.getKLog().i("KAccountStore", "Account state: " + result);
                return state.mutate(new Function1() { // from class: kntr.base.account.KAccountStore$_machine$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        AccountState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = KAccountStore$_machine$1$1$1.invokeSuspend$lambda$0(AccountState.this, (AccountState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountState invokeSuspend$lambda$0(AccountState $result, AccountState $this$mutate) {
        return $result;
    }
}