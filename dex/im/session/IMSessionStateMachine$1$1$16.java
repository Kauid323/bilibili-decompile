package im.session;

import com.tencent.smtt.sdk.TbsListener;
import im.base.IMLog;
import kntr.base.account.AccountState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "accountState", "Lkntr/base/account/AccountState;", "<unused var>", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$16", f = "IMSessionStateMachine.kt", i = {0}, l = {TbsListener.ErrorCode.ERROR_TBSCORE_SHARE_DIR}, m = "invokeSuspend", n = {"accountState"}, s = {"L$0"}, v = 1)
public final class IMSessionStateMachine$1$1$16 extends SuspendLambda implements Function3<AccountState, IMState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$1$1$16(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$1$1$16> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(AccountState accountState, IMState iMState, Continuation<? super Unit> continuation) {
        IMSessionStateMachine$1$1$16 iMSessionStateMachine$1$1$16 = new IMSessionStateMachine$1$1$16(this.this$0, continuation);
        iMSessionStateMachine$1$1$16.L$0 = accountState;
        return iMSessionStateMachine$1$1$16.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        IMActionLogin iMActionLogin;
        AccountState accountState = (AccountState) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion companion = IMLog.Companion;
                str = this.this$0.sessionLogTag;
                companion.i(str, "登录态发生变化.新状态: " + Reflection.getOrCreateKotlinClass(accountState.getClass()).getSimpleName());
                IMSessionStateMachine iMSessionStateMachine = this.this$0;
                if (accountState instanceof AccountState.Idle) {
                    iMActionLogin = IMActionLogout.INSTANCE;
                } else if (!(accountState instanceof AccountState.Logged)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    iMActionLogin = IMActionLogin.INSTANCE;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(accountState);
                this.label = 1;
                if (iMSessionStateMachine.dispatch(iMActionLogin, (Continuation) this) == coroutine_suspended) {
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