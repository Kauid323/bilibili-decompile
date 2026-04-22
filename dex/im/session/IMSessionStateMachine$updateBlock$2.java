package im.session;

import com.bapis.bilibili.app.im.v1.KSessionId;
import im.base.IMLog;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionCardKt;
import im.session.model.IMSessionFilterKt;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "state", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$updateBlock$2", f = "IMSessionStateMachine.kt", i = {0, 0}, l = {547}, m = "invokeSuspend", n = {"event", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class IMSessionStateMachine$updateBlock$2 extends SuspendLambda implements Function3<KSessionId, IMState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$updateBlock$2(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$updateBlock$2> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(KSessionId kSessionId, IMState iMState, Continuation<? super Unit> continuation) {
        IMSessionStateMachine$updateBlock$2 iMSessionStateMachine$updateBlock$2 = new IMSessionStateMachine$updateBlock$2(this.this$0, continuation);
        iMSessionStateMachine$updateBlock$2.L$0 = kSessionId;
        iMSessionStateMachine$updateBlock$2.L$1 = iMState;
        return iMSessionStateMachine$updateBlock$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        String str2;
        KSessionId event = (KSessionId) this.L$0;
        IMState state = (IMState) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion companion = IMLog.Companion;
                str = this.this$0.sessionLogTag;
                companion.i(str, "收到来自EventHub的单点刷新请求 " + IMSessionCardKt.getStringId(event));
                Iterable $this$any$iv = state.getData().getSessions();
                boolean z = false;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator<T> it = $this$any$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            IMSessionCard it2 = (IMSessionCard) element$iv;
                            if (Intrinsics.areEqual(it2.getId(), event)) {
                                z = true;
                            }
                        }
                    }
                }
                if (z) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                    this.label = 1;
                    if (this.this$0.dispatch(new IMActionRefreshSession(event, IMSessionFilterKt.currentFilterType(state.getData().getFilters())), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    IMLog.Companion companion2 = IMLog.Companion;
                    str2 = this.this$0.sessionLogTag;
                    companion2.w(str2, "收到来自EventHub的单点刷新请求，但会话不存在 " + IMSessionCardKt.getStringId(event));
                    break;
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