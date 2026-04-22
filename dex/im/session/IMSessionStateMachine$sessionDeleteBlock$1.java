package im.session;

import com.bapis.bilibili.app.im.v1.KSessionId;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.tauth.AuthActivity;
import im.base.IMLog;
import im.session.model.IMSessionCardKt;
import im.session.model.IMSessionPageData;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/session/IMState;", AuthActivity.ACTION_KEY, "Lim/session/IMActionSessionDelete;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$sessionDeleteBlock$1", f = "IMSessionStateMachine.kt", i = {0, 0, 0}, l = {699}, m = "invokeSuspend", n = {AuthActivity.ACTION_KEY, "state", "id"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class IMSessionStateMachine$sessionDeleteBlock$1 extends SuspendLambda implements Function3<IMActionSessionDelete, State<IMState>, Continuation<? super ChangedState<? extends IMState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$sessionDeleteBlock$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$sessionDeleteBlock$1> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(IMActionSessionDelete iMActionSessionDelete, State<IMState> state, Continuation<? super ChangedState<IMState>> continuation) {
        IMSessionStateMachine$sessionDeleteBlock$1 iMSessionStateMachine$sessionDeleteBlock$1 = new IMSessionStateMachine$sessionDeleteBlock$1(this.this$0, continuation);
        iMSessionStateMachine$sessionDeleteBlock$1.L$0 = iMActionSessionDelete;
        iMSessionStateMachine$sessionDeleteBlock$1.L$1 = state;
        return iMSessionStateMachine$sessionDeleteBlock$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        String str2;
        String str3;
        KSessionId id;
        final IMActionSessionDelete action = (IMActionSessionDelete) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KSessionId id2 = action.getCard().getId();
                IMLog.Companion companion = IMLog.Companion;
                str = this.this$0.sessionLogTag;
                companion.i(str, "点击删除会话 " + IMSessionCardKt.getStringId(id2));
                KSessionId.IId id3 = id2.getId();
                if ((id3 instanceof KSessionId.KPrivateId) || (id3 instanceof KSessionId.KSystemId)) {
                    IMLog.Companion companion2 = IMLog.Companion;
                    str2 = this.this$0.sessionLogTag;
                    companion2.i(str2, "展示删除会话确认弹窗");
                    return state.mutate(new Function1() { // from class: im.session.IMSessionStateMachine$sessionDeleteBlock$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            IMState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = IMSessionStateMachine$sessionDeleteBlock$1.invokeSuspend$lambda$0(IMActionSessionDelete.this, (IMState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                }
                IMLog.Companion companion3 = IMLog.Companion;
                str3 = this.this$0.sessionLogTag;
                companion3.i(str3, "无需展示弹窗, 直接执行删除");
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(id2);
                this.label = 1;
                if (this.this$0.dispatch(new IMActionSessionDeletePerform(action.getCard()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                id = id2;
                break;
            case 1:
                id = (KSessionId) this.L$2;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.noChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMState invokeSuspend$lambda$0(IMActionSessionDelete $action, IMState $this$mutate) {
        IMState copy;
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.pageType : null, (r18 & 2) != 0 ? $this$mutate.data : IMSessionPageData.copy$default($this$mutate.getData(), null, null, null, null, null, null, null, null, $action.getCard(), null, false, 1791, null), (r18 & 4) != 0 ? $this$mutate.toast : null, (r18 & 8) != 0 ? $this$mutate.isLoggedIn : false, (r18 & 16) != 0 ? $this$mutate.type : null, (r18 & 32) != 0 ? $this$mutate.clickedSession : null, (r18 & 64) != 0 ? $this$mutate.firstLoad : false, (r18 & 128) != 0 ? $this$mutate.techTrack : null);
        return copy;
    }
}