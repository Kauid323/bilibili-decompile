package im.session;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.tauth.AuthActivity;
import im.base.IMToast;
import im.session.model.IMSessionCard;
import im.session.service.IMClearUnreadService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.datetime.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", AuthActivity.ACTION_KEY, "Lim/session/IMActionClearSessionUnread;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$32$1", f = "IMSessionStateMachine.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {480, 482, 485}, m = "invokeSuspend", n = {AuthActivity.ACTION_KEY, "state", AuthActivity.ACTION_KEY, "state", "it", "$i$a$-fold-IMSessionStateMachine$1$1$32$1$1", AuthActivity.ACTION_KEY, "state", "it", "$i$a$-fold-IMSessionStateMachine$1$1$32$1$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class IMSessionStateMachine$1$1$32$1 extends SuspendLambda implements Function3<IMActionClearSessionUnread, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$1$1$32$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$1$1$32$1> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(IMActionClearSessionUnread iMActionClearSessionUnread, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$1$1$32$1 iMSessionStateMachine$1$1$32$1 = new IMSessionStateMachine$1$1$32$1(this.this$0, continuation);
        iMSessionStateMachine$1$1$32$1.L$0 = iMActionClearSessionUnread;
        iMSessionStateMachine$1$1$32$1.L$1 = state;
        return iMSessionStateMachine$1$1$32$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        IMClearUnreadService iMClearUnreadService;
        KSessionPageType kSessionPageType;
        Object m3342clearSessionUnread0E7RQCE;
        Throwable it;
        Object create;
        Object markSessionAsRead;
        IMActionClearSessionUnread action = (IMActionClearSessionUnread) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                iMClearUnreadService = this.this$0.clearUnreadService;
                kSessionPageType = this.this$0.pageType;
                this.L$0 = action;
                this.L$1 = state;
                this.label = 1;
                m3342clearSessionUnread0E7RQCE = iMClearUnreadService.m3342clearSessionUnread0E7RQCE(kSessionPageType, action.getCard(), (Continuation) this);
                if (m3342clearSessionUnread0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                IMSessionStateMachine iMSessionStateMachine = this.this$0;
                it = Result.exceptionOrNull-impl(m3342clearSessionUnread0E7RQCE);
                if (it != null) {
                    IMSessionCard card = action.getCard();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                    this.L$2 = SpillingKt.nullOutSpilledVariable((Unit) m3342clearSessionUnread0E7RQCE);
                    this.I$0 = 0;
                    this.label = 2;
                    markSessionAsRead = iMSessionStateMachine.markSessionAsRead((State<IMState>) state, card, (Continuation<? super ChangedState<IMState>>) this);
                    return markSessionAsRead == coroutine_suspended ? coroutine_suspended : (ChangedState) markSessionAsRead;
                }
                IMToast.Companion companion = IMToast.Companion;
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(it);
                this.I$0 = 0;
                this.label = 3;
                create = companion.create(it, (r12 & 2) != 0 ? "" : null, (r12 & 4) != 0 ? Clock.System.INSTANCE.now() : null, (r12 & 8) != 0 ? null : null, this);
                if (create == coroutine_suspended) {
                    return coroutine_suspended;
                }
                final IMToast imToast = (IMToast) create;
                return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$1$1$32$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMState invokeSuspend$lambda$1$0;
                        invokeSuspend$lambda$1$0 = IMSessionStateMachine$1$1$32$1.invokeSuspend$lambda$1$0(IMToast.this, (IMState) obj);
                        return invokeSuspend$lambda$1$0;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                m3342clearSessionUnread0E7RQCE = ((Result) $result).unbox-impl();
                IMSessionStateMachine iMSessionStateMachine2 = this.this$0;
                it = Result.exceptionOrNull-impl(m3342clearSessionUnread0E7RQCE);
                if (it != null) {
                }
                break;
            case 2:
                int i2 = this.I$0;
                Unit unit = (Unit) this.L$2;
                ResultKt.throwOnFailure($result);
                markSessionAsRead = $result;
            case 3:
                int i3 = this.I$0;
                Throwable th = (Throwable) this.L$2;
                ResultKt.throwOnFailure($result);
                create = $result;
                final IMToast imToast2 = (IMToast) create;
                return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$1$1$32$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMState invokeSuspend$lambda$1$0;
                        invokeSuspend$lambda$1$0 = IMSessionStateMachine$1$1$32$1.invokeSuspend$lambda$1$0(IMToast.this, (IMState) obj);
                        return invokeSuspend$lambda$1$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState invokeSuspend$lambda$1$0(IMToast $imToast, IMState $this$mutate) {
        IMState copy;
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : null, (r18 & 4) != 0 ? $this$mutate.toast : $imToast, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }
}