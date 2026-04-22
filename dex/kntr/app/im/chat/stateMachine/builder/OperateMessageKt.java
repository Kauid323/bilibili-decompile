package kntr.app.im.chat.stateMachine.builder;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import im.base.IMToast;
import im.base.model.SessionId;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.core.service.MessageSendService;
import kntr.app.im.chat.core.service.OperateMessageService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.datetime.Instant;

/* compiled from: OperateMessage.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u0001H\u0000R\u00020\u0002R\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0006\u0010\u0003\u001a\u00020\u0002j\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\b\u001aG\u0010\t\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0000R\u00020\nR\u00020\fR\u00020\u000ej\u0006\u0010\u000b\u001a\u00020\nj\u0006\u0010\r\u001a\u00020\fj\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010\u001a.\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012*\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"bindResendMessage", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/service/MessageSendService;", "sendMessageService", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/im/chat/core/model/ChatPageData;", "Lkntr/app/im/chat/core/model/ChatAction;", "builder", "(Lkntr/app/im/chat/core/service/MessageSendService;Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;)V", "bindOperateMessage", "Lkntr/app/im/chat/core/service/OperateMessageService;", "operateMessageService", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "messageDatabaseService", "Lim/base/model/SessionId;", "sessionId", "(Lkntr/app/im/chat/core/service/OperateMessageService;Lkntr/app/im/chat/core/service/MessageDatabaseService;Lim/base/model/SessionId;Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;)V", "recallMessage", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lcom/freeletics/flowredux/dsl/State;", "msgId", "Lkntr/app/im/chat/core/model/MessageId;", "(Lcom/freeletics/flowredux/dsl/State;Lkntr/app/im/chat/core/service/OperateMessageService;Lkntr/app/im/chat/core/model/MessageId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OperateMessageKt {
    public static final void bindResendMessage(MessageSendService sendMessageService, InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(sendMessageService, "sendMessageService");
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "builder");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new OperateMessageKt$bindResendMessage$1(sendMessageService, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(ChatAction.ResendMessage.class), executionPolicy$iv, handler$iv);
    }

    public static final void bindOperateMessage(OperateMessageService operateMessageService, MessageDatabaseService messageDatabaseService, SessionId sessionId, InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(operateMessageService, "operateMessageService");
        Intrinsics.checkNotNullParameter(messageDatabaseService, "messageDatabaseService");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.OperateMessageKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean bindOperateMessage$lambda$0;
                bindOperateMessage$lambda$0 = OperateMessageKt.bindOperateMessage$lambda$0((ChatPageData) obj);
                return Boolean.valueOf(bindOperateMessage$lambda$0);
            }
        }, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.OperateMessageKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit bindOperateMessage$lambda$1;
                bindOperateMessage$lambda$1 = OperateMessageKt.bindOperateMessage$lambda$1((ConditionBuilderBlock) obj);
                return bindOperateMessage$lambda$1;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new OperateMessageKt$bindOperateMessage$3(operateMessageService, messageDatabaseService, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ChatAction.DeleteMessageConfirm.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new OperateMessageKt$bindOperateMessage$4(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(ChatAction.DeleteMessageCancel.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv3 = new OperateMessageKt$bindOperateMessage$5(operateMessageService, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(ChatAction.RecallMessage.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv4 = new OperateMessageKt$bindOperateMessage$6(operateMessageService, sessionId, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(ChatAction.RecallMessageWithSeq.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock $this$iv5 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv5 = new OperateMessageKt$bindOperateMessage$7(null);
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv5.on(Reflection.getOrCreateKotlinClass(ChatAction.ReportMessage.class), executionPolicy$iv5, handler$iv5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindOperateMessage$lambda$0(ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDeletingMsg() == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindOperateMessage$lambda$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$condition;
        Function3 handler$iv = new OperateMessageKt$bindOperateMessage$2$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ChatAction.DeleteMessage.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object recallMessage(State<ChatPageData> state, OperateMessageService operateMessageService, MessageId msgId, Continuation<? super ChangedState<ChatPageData>> continuation) {
        Continuation<? super Result<Unit>> operateMessageKt$recallMessage$1;
        Object mo1365recallMessagegIAlus;
        MessageId msgId2;
        State<ChatPageData> state2;
        OperateMessageService operateMessageService2;
        Throwable it;
        Object create$default;
        State<ChatPageData> state3;
        OperateMessageService operateMessageService3;
        MessageId msgId3;
        if (continuation instanceof OperateMessageKt$recallMessage$1) {
            operateMessageKt$recallMessage$1 = (OperateMessageKt$recallMessage$1) continuation;
            if ((operateMessageKt$recallMessage$1.label & Integer.MIN_VALUE) != 0) {
                operateMessageKt$recallMessage$1.label -= Integer.MIN_VALUE;
                Object $result = operateMessageKt$recallMessage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (operateMessageKt$recallMessage$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMLog.Companion.i("OperateMessage", "撤回消息 " + msgId);
                        operateMessageKt$recallMessage$1.L$0 = state;
                        operateMessageKt$recallMessage$1.L$1 = SpillingKt.nullOutSpilledVariable(operateMessageService);
                        operateMessageKt$recallMessage$1.L$2 = msgId;
                        operateMessageKt$recallMessage$1.label = 1;
                        mo1365recallMessagegIAlus = operateMessageService.mo1365recallMessagegIAlus(msgId, operateMessageKt$recallMessage$1);
                        if (mo1365recallMessagegIAlus == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        msgId2 = msgId;
                        state2 = state;
                        operateMessageService2 = operateMessageService;
                        it = Result.exceptionOrNull-impl(mo1365recallMessagegIAlus);
                        if (it != null) {
                            Unit unit = (Unit) mo1365recallMessagegIAlus;
                            IMLog.Companion.i("OperateMessage", "撤回消息成功 " + msgId2);
                            return state2.noChange();
                        }
                        IMLog.Companion.e("OperateMessage", "撤回消息失败 " + msgId2, it);
                        IMToast.Companion companion = IMToast.Companion;
                        operateMessageKt$recallMessage$1.L$0 = state2;
                        operateMessageKt$recallMessage$1.L$1 = SpillingKt.nullOutSpilledVariable(operateMessageService2);
                        operateMessageKt$recallMessage$1.L$2 = SpillingKt.nullOutSpilledVariable(msgId2);
                        operateMessageKt$recallMessage$1.L$3 = SpillingKt.nullOutSpilledVariable(it);
                        operateMessageKt$recallMessage$1.I$0 = 0;
                        operateMessageKt$recallMessage$1.label = 2;
                        create$default = IMToast.Companion.create$default(companion, it, (String) null, (Instant) null, (Function2) null, operateMessageKt$recallMessage$1, 14, (Object) null);
                        if (create$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        state3 = state2;
                        operateMessageService3 = operateMessageService2;
                        msgId3 = msgId2;
                        final IMToast imToast = (IMToast) create$default;
                        return state3.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.OperateMessageKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                ChatPageData recallMessage$lambda$1$0;
                                recallMessage$lambda$1$0 = OperateMessageKt.recallMessage$lambda$1$0(imToast, (ChatPageData) obj);
                                return recallMessage$lambda$1$0;
                            }
                        });
                    case 1:
                        MessageId msgId4 = (MessageId) operateMessageKt$recallMessage$1.L$2;
                        ResultKt.throwOnFailure($result);
                        mo1365recallMessagegIAlus = ((Result) $result).unbox-impl();
                        msgId2 = msgId4;
                        operateMessageService2 = (OperateMessageService) operateMessageKt$recallMessage$1.L$1;
                        state2 = (State) operateMessageKt$recallMessage$1.L$0;
                        it = Result.exceptionOrNull-impl(mo1365recallMessagegIAlus);
                        if (it != null) {
                        }
                        break;
                    case 2:
                        int i = operateMessageKt$recallMessage$1.I$0;
                        Throwable th = (Throwable) operateMessageKt$recallMessage$1.L$3;
                        msgId3 = (MessageId) operateMessageKt$recallMessage$1.L$2;
                        operateMessageService3 = (OperateMessageService) operateMessageKt$recallMessage$1.L$1;
                        state3 = (State) operateMessageKt$recallMessage$1.L$0;
                        ResultKt.throwOnFailure($result);
                        create$default = $result;
                        final IMToast imToast2 = (IMToast) create$default;
                        return state3.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.OperateMessageKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                ChatPageData recallMessage$lambda$1$0;
                                recallMessage$lambda$1$0 = OperateMessageKt.recallMessage$lambda$1$0(imToast2, (ChatPageData) obj);
                                return recallMessage$lambda$1$0;
                            }
                        });
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        operateMessageKt$recallMessage$1 = new OperateMessageKt$recallMessage$1(continuation);
        Object $result2 = operateMessageKt$recallMessage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (operateMessageKt$recallMessage$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData recallMessage$lambda$1$0(final IMToast $imToast, ChatPageData $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return (ChatPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.OperateMessageKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit recallMessage$lambda$1$0$0;
                recallMessage$lambda$1$0$0 = OperateMessageKt.recallMessage$lambda$1$0$0($imToast, (CopyScope) obj);
                return recallMessage$lambda$1$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit recallMessage$lambda$1$0$0(IMToast $imToast, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        InitLoadKt.updateToast($this$copy, $imToast);
        return Unit.INSTANCE;
    }
}