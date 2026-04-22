package im.session;

import com.bapis.bilibili.app.im.v1.KSessionId;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.smtt.sdk.TbsListener;
import im.base.IMLog;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionCardKt;
import im.session.model.IMSessionFilterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", "<unused var>", "Lim/session/IMActionPageRedisplay;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$sessionClickBlock$2", f = "IMSessionStateMachine.kt", i = {0, 0, 1, 1}, l = {519, 528}, m = "invokeSuspend", n = {"state", "session", "state", "session"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class IMSessionStateMachine$sessionClickBlock$2 extends SuspendLambda implements Function3<IMActionPageRedisplay, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$sessionClickBlock$2(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$sessionClickBlock$2> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(IMActionPageRedisplay iMActionPageRedisplay, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$sessionClickBlock$2 iMSessionStateMachine$sessionClickBlock$2 = new IMSessionStateMachine$sessionClickBlock$2(this.this$0, continuation);
        iMSessionStateMachine$sessionClickBlock$2.L$0 = state;
        return iMSessionStateMachine$sessionClickBlock$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0102 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        IMSessionCard session;
        String str;
        String str2;
        KSessionId id;
        String str3;
        Object markSessionAsRead;
        KSessionId id2;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str4 = null;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                session = ((IMState) state.getSnapshot()).getClickedSession();
                IMLog.Companion companion = IMLog.Companion;
                str = this.this$0.sessionLogTag;
                companion.i(str, "页面回退. 检查是否要刷新所点击的会话 " + ((session == null || (id = session.getId()) == null) ? null : IMSessionCardKt.getStringId(id)));
                if (session != null) {
                    IMLog.Companion companion2 = IMLog.Companion;
                    str2 = this.this$0.sessionLogTag;
                    companion2.i(str2, "页面回退. 刷新所点击的会话 " + IMSessionCardKt.getStringId(session.getId()));
                    this.L$0 = state;
                    this.L$1 = session;
                    this.label = 1;
                    if (this.this$0.dispatch(new IMActionRefreshSession(session.getId(), IMSessionFilterKt.currentFilterType(((IMState) state.getSnapshot()).getData().getFilters())), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                IMLog.Companion companion3 = IMLog.Companion;
                str3 = this.this$0.sessionLogTag;
                if (session != null && (id2 = session.getId()) != null) {
                    str4 = IMSessionCardKt.getStringId(id2);
                }
                companion3.i(str3, "页面回退. 将所点击的会话标记为已读 " + str4);
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(session);
                this.label = 2;
                markSessionAsRead = this.this$0.markSessionAsRead((IMState) state.getSnapshot(), session, (Continuation) this);
                if (markSessionAsRead != coroutine_suspended) {
                    return coroutine_suspended;
                }
                final IMState read = (IMState) markSessionAsRead;
                return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$sessionClickBlock$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMState copy$default;
                        IMState iMState = (IMState) obj;
                        copy$default = IMState.copy$default(IMState.this, null, null, null, false, null, null, false, null, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, null);
                        return copy$default;
                    }
                });
            case 1:
                session = (IMSessionCard) this.L$1;
                ResultKt.throwOnFailure($result);
                IMLog.Companion companion32 = IMLog.Companion;
                str3 = this.this$0.sessionLogTag;
                if (session != null) {
                    str4 = IMSessionCardKt.getStringId(id2);
                    break;
                }
                companion32.i(str3, "页面回退. 将所点击的会话标记为已读 " + str4);
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(session);
                this.label = 2;
                markSessionAsRead = this.this$0.markSessionAsRead((IMState) state.getSnapshot(), session, (Continuation) this);
                if (markSessionAsRead != coroutine_suspended) {
                }
                break;
            case 2:
                IMSessionCard iMSessionCard = (IMSessionCard) this.L$1;
                ResultKt.throwOnFailure($result);
                markSessionAsRead = $result;
                final IMState read2 = (IMState) markSessionAsRead;
                return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$sessionClickBlock$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMState copy$default;
                        IMState iMState = (IMState) obj;
                        copy$default = IMState.copy$default(IMState.this, null, null, null, false, null, null, false, null, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, null);
                        return copy$default;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}