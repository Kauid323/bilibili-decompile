package im.session;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMToast;
import im.session.model.IMSessionPageData;
import im.session.service.IMClearSessionService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", "<unused var>", "Lim/session/IMActionClearAllSessions;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$clearSessionListBlock$1", f = "IMSessionStateMachine.kt", i = {0, 1, 1, 2, 2}, l = {620, 622, 627}, m = "invokeSuspend", n = {"state", "state", "result", "state", "result"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class IMSessionStateMachine$clearSessionListBlock$1 extends SuspendLambda implements Function3<IMActionClearAllSessions, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$clearSessionListBlock$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$clearSessionListBlock$1> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(IMActionClearAllSessions iMActionClearAllSessions, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$clearSessionListBlock$1 iMSessionStateMachine$clearSessionListBlock$1 = new IMSessionStateMachine$clearSessionListBlock$1(this.this$0, continuation);
        iMSessionStateMachine$clearSessionListBlock$1.L$0 = state;
        return iMSessionStateMachine$clearSessionListBlock$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        IMClearSessionService iMClearSessionService;
        KSessionPageType kSessionPageType;
        Object result;
        Object result2;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                iMClearSessionService = this.this$0.clearSessionService;
                kSessionPageType = this.this$0.pageType;
                this.L$0 = state;
                this.label = 1;
                result = iMClearSessionService.m3340clearSessiongIAlus$session_debug(kSessionPageType, (Continuation) this);
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (!Result.isSuccess-impl(result)) {
                    this.L$0 = state;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(result);
                    this.label = 2;
                    return this.this$0.dispatch(new IMActionClearAllSessionsSucceed(((IMState) state.getSnapshot()).getData().getSessions()), (Continuation) this) == coroutine_suspended ? coroutine_suspended : state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$clearSessionListBlock$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            IMState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = IMSessionStateMachine$clearSessionListBlock$1.invokeSuspend$lambda$0((IMState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                }
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(result);
                this.label = 3;
                result2 = IMToast.Companion.create(Result.exceptionOrNull-impl(result), (r12 & 2) != 0 ? "" : null, (r12 & 4) != 0 ? Clock.System.INSTANCE.now() : null, (r12 & 8) != 0 ? null : null, (Continuation) this);
                if (result2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                final IMToast imToast = (IMToast) result2;
                return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$clearSessionListBlock$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        IMState invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = IMSessionStateMachine$clearSessionListBlock$1.invokeSuspend$lambda$1(IMToast.this, (IMState) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                result = ((Result) $result).unbox-impl();
                if (!Result.isSuccess-impl(result)) {
                }
                break;
            case 2:
                Object result3 = this.L$1;
                ResultKt.throwOnFailure($result);
            case 3:
                Object obj = this.L$1;
                ResultKt.throwOnFailure($result);
                result2 = $result;
                final IMToast imToast2 = (IMToast) result2;
                return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$clearSessionListBlock$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        IMState invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = IMSessionStateMachine$clearSessionListBlock$1.invokeSuspend$lambda$1(IMToast.this, (IMState) obj2);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState invokeSuspend$lambda$0(IMState $this$mutate) {
        IMState copy;
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : IMSessionPageData.copy$default($this$mutate.getData(), null, null, null, null, CollectionsKt.emptyList(), null, null, null, null, null, false, 2031, null), (r18 & 4) != 0 ? $this$mutate.toast : null, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState invokeSuspend$lambda$1(IMToast $imToast, IMState $this$mutate) {
        IMState copy;
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : null, (r18 & 4) != 0 ? $this$mutate.toast : $imToast, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }
}