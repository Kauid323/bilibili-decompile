package im.session;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.tauth.AuthActivity;
import im.base.IMLog;
import im.base.IMToast;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionCardKt;
import im.session.service.IMSessionCardEventService;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.datetime.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", AuthActivity.ACTION_KEY, "Lim/session/IMActionSessionDeletePerform;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$sessionDeleteBlock$4", f = "IMSessionStateMachine.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {731, 735, 749}, m = "invokeSuspend", n = {AuthActivity.ACTION_KEY, "state", "session", AuthActivity.ACTION_KEY, "state", "session", "it", "$i$a$-fold-IMSessionStateMachine$sessionDeleteBlock$4$1", AuthActivity.ACTION_KEY, "state", "session", "it", "$i$a$-fold-IMSessionStateMachine$sessionDeleteBlock$4$2"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
public final class IMSessionStateMachine$sessionDeleteBlock$4 extends SuspendLambda implements Function3<IMActionSessionDeletePerform, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$sessionDeleteBlock$4(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$sessionDeleteBlock$4> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(IMActionSessionDeletePerform iMActionSessionDeletePerform, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$sessionDeleteBlock$4 iMSessionStateMachine$sessionDeleteBlock$4 = new IMSessionStateMachine$sessionDeleteBlock$4(this.this$0, continuation);
        iMSessionStateMachine$sessionDeleteBlock$4.L$0 = iMActionSessionDeletePerform;
        iMSessionStateMachine$sessionDeleteBlock$4.L$1 = state;
        return iMSessionStateMachine$sessionDeleteBlock$4.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        String str;
        IMSessionCardEventService iMSessionCardEventService;
        Object m3352deletegIAlus;
        IMSessionCard session;
        Throwable th;
        Object create;
        String str2;
        final IMSessionCard session2;
        IMActionSessionDeletePerform action = (IMActionSessionDeletePerform) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMSessionCard session3 = action.getCard();
                IMLog.Companion companion = IMLog.Companion;
                str = this.this$0.sessionLogTag;
                companion.i(str, "执行删除会话 " + IMSessionCardKt.getStringId(session3.getId()));
                iMSessionCardEventService = this.this$0.sessionEventService;
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = session3;
                this.label = 1;
                m3352deletegIAlus = iMSessionCardEventService.m3352deletegIAlus(session3, (Continuation) this);
                if (m3352deletegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                session = session3;
                IMSessionStateMachine iMSessionStateMachine = this.this$0;
                th = Result.exceptionOrNull-impl(m3352deletegIAlus);
                if (th == null) {
                    IMToast.Companion companion2 = IMToast.Companion;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(session);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(th);
                    this.I$0 = 0;
                    this.label = 3;
                    create = companion2.create(th, (r12 & 2) != 0 ? "" : null, (r12 & 4) != 0 ? Clock.System.INSTANCE.now() : null, (r12 & 8) != 0 ? null : null, this);
                    if (create == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    final IMToast imToast = (IMToast) create;
                    return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$sessionDeleteBlock$4$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            IMState invokeSuspend$lambda$1$0;
                            invokeSuspend$lambda$1$0 = IMSessionStateMachine$sessionDeleteBlock$4.invokeSuspend$lambda$1$0(IMToast.this, (IMState) obj);
                            return invokeSuspend$lambda$1$0;
                        }
                    });
                }
                Unit it = (Unit) m3352deletegIAlus;
                IMLog.Companion companion3 = IMLog.Companion;
                str2 = iMSessionStateMachine.sessionLogTag;
                companion3.i(str2, "删除会话成功 " + IMSessionCardKt.getStringId(session.getId()));
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = session;
                this.L$3 = SpillingKt.nullOutSpilledVariable(it);
                this.I$0 = 0;
                this.label = 2;
                if (CoroutineScopeKt.coroutineScope(new IMSessionStateMachine$sessionDeleteBlock$4$1$1(iMSessionStateMachine, session, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                session2 = session;
                return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$sessionDeleteBlock$4$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMState invokeSuspend$lambda$0$0;
                        invokeSuspend$lambda$0$0 = IMSessionStateMachine$sessionDeleteBlock$4.invokeSuspend$lambda$0$0(IMSessionCard.this, (IMState) obj);
                        return invokeSuspend$lambda$0$0;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                m3352deletegIAlus = ((Result) $result).unbox-impl();
                session = (IMSessionCard) this.L$2;
                IMSessionStateMachine iMSessionStateMachine2 = this.this$0;
                th = Result.exceptionOrNull-impl(m3352deletegIAlus);
                if (th == null) {
                }
                break;
            case 2:
                int i2 = this.I$0;
                Unit unit = (Unit) this.L$3;
                session2 = (IMSessionCard) this.L$2;
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$sessionDeleteBlock$4$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMState invokeSuspend$lambda$0$0;
                        invokeSuspend$lambda$0$0 = IMSessionStateMachine$sessionDeleteBlock$4.invokeSuspend$lambda$0$0(IMSessionCard.this, (IMState) obj);
                        return invokeSuspend$lambda$0$0;
                    }
                });
            case 3:
                int i3 = this.I$0;
                Throwable th2 = (Throwable) this.L$3;
                IMSessionCard iMSessionCard = (IMSessionCard) this.L$2;
                ResultKt.throwOnFailure($result);
                create = $result;
                final IMToast imToast2 = (IMToast) create;
                return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$sessionDeleteBlock$4$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        IMState invokeSuspend$lambda$1$0;
                        invokeSuspend$lambda$1$0 = IMSessionStateMachine$sessionDeleteBlock$4.invokeSuspend$lambda$1$0(IMToast.this, (IMState) obj);
                        return invokeSuspend$lambda$1$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState invokeSuspend$lambda$0$0(IMSessionCard $session, IMState $this$mutate) {
        IMState copy;
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : $this$mutate.getData().delete$session_debug($session), (r18 & 4) != 0 ? $this$mutate.toast : null, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState invokeSuspend$lambda$1$0(IMToast $imToast, IMState $this$mutate) {
        IMState copy;
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : null, (r18 & 4) != 0 ? $this$mutate.toast : $imToast, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }
}