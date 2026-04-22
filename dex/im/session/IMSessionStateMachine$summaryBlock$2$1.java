package im.session;

import im.base.IMLog;
import im.session.model.IMSessionCardKt;
import im.session.service.ConversationSummaryHolder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "update", "Lim/session/service/ConversationSummaryHolder;", "<unused var>", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionStateMachine$summaryBlock$2$1", f = "IMSessionStateMachine.kt", i = {0}, l = {785}, m = "invokeSuspend", n = {"update"}, s = {"L$0"}, v = 1)
public final class IMSessionStateMachine$summaryBlock$2$1 extends SuspendLambda implements Function3<ConversationSummaryHolder, IMState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IMSessionStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionStateMachine$summaryBlock$2$1(IMSessionStateMachine iMSessionStateMachine, Continuation<? super IMSessionStateMachine$summaryBlock$2$1> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionStateMachine;
    }

    public final Object invoke(ConversationSummaryHolder conversationSummaryHolder, IMState iMState, Continuation<? super Unit> continuation) {
        IMSessionStateMachine$summaryBlock$2$1 iMSessionStateMachine$summaryBlock$2$1 = new IMSessionStateMachine$summaryBlock$2$1(this.this$0, continuation);
        iMSessionStateMachine$summaryBlock$2$1.L$0 = conversationSummaryHolder;
        return iMSessionStateMachine$summaryBlock$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        ConversationSummaryHolder update = (ConversationSummaryHolder) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion companion = IMLog.Companion;
                str = this.this$0.sessionLogTag;
                companion.i(str, "会话 " + IMSessionCardKt.getStringId(update.getSessionId()) + " 的草稿更新, 更新消息摘要");
                this.L$0 = SpillingKt.nullOutSpilledVariable(update);
                this.label = 1;
                if (this.this$0.dispatch(new IMUpdateSummary(update.getSessionId(), update.getDraftSummary()), (Continuation) this) == coroutine_suspended) {
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