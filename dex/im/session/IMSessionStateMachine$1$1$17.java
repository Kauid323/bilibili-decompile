package im.session;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import im.session.RequestStatus;
import im.session.model.IMSessionPageData;
import im.session.track.IMSessionLoadTimeTrack;
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
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", "<unused var>", "Lim/session/IMActionLogout;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$1$1$17", f = "IMSessionStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionStateMachine$1$1$17 extends SuspendLambda implements Function3<IMActionLogout, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$1$1$17(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$1$1$17> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(IMActionLogout iMActionLogout, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$1$1$17 iMSessionStateMachine$1$1$17 = new IMSessionStateMachine$1$1$17(this.this$0, continuation);
        iMSessionStateMachine$1$1$17.L$0 = state;
        return iMSessionStateMachine$1$1$17.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion companion = IMLog.Companion;
                str = this.this$0.sessionLogTag;
                companion.i(str, "账号登出 on<IMActionLogout>");
                return state.override(new Function1() { // from class: im.session.IMSessionStateMachine$1$1$17$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = IMSessionStateMachine$1$1$17.invokeSuspend$lambda$0((IMState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState invokeSuspend$lambda$0(IMState $this$override) {
        IMSessionLoadTimeTrack copy;
        IMState copy2;
        RequestStatus.Idle idle = RequestStatus.Idle.INSTANCE;
        IMSessionPageData iMSessionPageData = new IMSessionPageData(null, null, null, null, null, null, null, null, null, null, false, 2047, null);
        copy = r16.copy((r20 & 1) != 0 ? r16.pageType : null, (r20 & 2) != 0 ? r16.start : null, (r20 & 4) != 0 ? r16.cacheLoad : null, (r20 & 8) != 0 ? r16.mossLoad : null, (r20 & 16) != 0 ? r16.cacheViewReady : null, (r20 & 32) != 0 ? r16.mossViewReady : null, (r20 & 64) != 0 ? r16.startFromNotLogin : true, (r20 & 128) != 0 ? r16.firstCacheError : null, (r20 & 256) != 0 ? $this$override.getTechTrack$session_debug().firstMossError : null);
        copy2 = $this$override.copy((r18 & 1) != 0 ? $this$override.pageType : null, (r18 & 2) != 0 ? $this$override.data : iMSessionPageData, (r18 & 4) != 0 ? $this$override.toast : null, (r18 & 8) != 0 ? $this$override.isLoggedIn : false, (r18 & 16) != 0 ? $this$override.type : idle, (r18 & 32) != 0 ? $this$override.clickedSession : null, (r18 & 64) != 0 ? $this$override.firstLoad : false, (r18 & 128) != 0 ? $this$override.techTrack : copy);
        return copy2;
    }
}