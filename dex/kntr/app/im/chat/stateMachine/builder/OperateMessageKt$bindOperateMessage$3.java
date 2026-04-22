package kntr.app.im.chat.stateMachine.builder;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import im.base.IMToast;
import java.util.List;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.core.service.OperateMessageService;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.datetime.Instant;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OperateMessage.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "action", "Lkntr/app/im/chat/core/model/ChatAction$DeleteMessageConfirm;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.OperateMessageKt$bindOperateMessage$3", f = "OperateMessage.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {60, 63, 67}, m = "invokeSuspend", n = {"action", "state", "messageIds", "action", "state", "messageIds", "it", "$i$a$-fold-OperateMessageKt$bindOperateMessage$3$1", "action", "state", "messageIds", "it", "$i$a$-fold-OperateMessageKt$bindOperateMessage$3$2"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
public final class OperateMessageKt$bindOperateMessage$3 extends SuspendLambda implements Function3<ChatAction.DeleteMessageConfirm, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    final /* synthetic */ MessageDatabaseService $messageDatabaseService;
    final /* synthetic */ OperateMessageService $operateMessageService;
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperateMessageKt$bindOperateMessage$3(OperateMessageService operateMessageService, MessageDatabaseService messageDatabaseService, Continuation<? super OperateMessageKt$bindOperateMessage$3> continuation) {
        super(3, continuation);
        this.$operateMessageService = operateMessageService;
        this.$messageDatabaseService = messageDatabaseService;
    }

    public final Object invoke(ChatAction.DeleteMessageConfirm deleteMessageConfirm, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        OperateMessageKt$bindOperateMessage$3 operateMessageKt$bindOperateMessage$3 = new OperateMessageKt$bindOperateMessage$3(this.$operateMessageService, this.$messageDatabaseService, continuation);
        operateMessageKt$bindOperateMessage$3.L$0 = deleteMessageConfirm;
        operateMessageKt$bindOperateMessage$3.L$1 = state;
        return operateMessageKt$bindOperateMessage$3.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object mo1364deleteMessagegIAlus;
        List<MessageId> list;
        Throwable it;
        Object create$default;
        ChatAction.DeleteMessageConfirm action = (ChatAction.DeleteMessageConfirm) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                List<MessageId> listOf = CollectionsKt.listOf(action.getMessage().getMsgId());
                IMLog.Companion.i("OperateMessage", "删除消息 " + action.getMessage().getMsgId());
                this.L$0 = action;
                this.L$1 = state;
                this.L$2 = listOf;
                this.label = 1;
                mo1364deleteMessagegIAlus = this.$operateMessageService.mo1364deleteMessagegIAlus(listOf, (Continuation) this);
                if (mo1364deleteMessagegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = listOf;
                MessageDatabaseService messageDatabaseService = this.$messageDatabaseService;
                it = Result.exceptionOrNull-impl(mo1364deleteMessagegIAlus);
                if (it != null) {
                    IMLog.Companion.i("OperateMessage", "删除消息成功 " + action.getMessage().getMsgId());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(list);
                    this.L$3 = SpillingKt.nullOutSpilledVariable((Unit) mo1364deleteMessagegIAlus);
                    this.I$0 = 0;
                    this.label = 2;
                    return messageDatabaseService.batchSoftDeleteMessages(list, this) == coroutine_suspended ? coroutine_suspended : state.noChange();
                }
                IMLog.Companion.e("OperateMessage", "删除消息失败 " + action.getMessage().getMsgId(), it);
                IMToast.Companion companion = IMToast.Companion;
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(list);
                this.L$3 = SpillingKt.nullOutSpilledVariable(it);
                this.I$0 = 0;
                this.label = 3;
                create$default = IMToast.Companion.create$default(companion, it, (String) null, (Instant) null, (Function2) null, this, 14, (Object) null);
                if (create$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                final IMToast imToast = (IMToast) create$default;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.OperateMessageKt$bindOperateMessage$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        ChatPageData invokeSuspend$lambda$1$0;
                        invokeSuspend$lambda$1$0 = OperateMessageKt$bindOperateMessage$3.invokeSuspend$lambda$1$0(imToast, (ChatPageData) obj);
                        return invokeSuspend$lambda$1$0;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                mo1364deleteMessagegIAlus = ((Result) $result).unbox-impl();
                list = (List) this.L$2;
                MessageDatabaseService messageDatabaseService2 = this.$messageDatabaseService;
                it = Result.exceptionOrNull-impl(mo1364deleteMessagegIAlus);
                if (it != null) {
                }
                break;
            case 2:
                int i = this.I$0;
                Unit unit = (Unit) this.L$3;
                List list2 = (List) this.L$2;
                ResultKt.throwOnFailure($result);
            case 3:
                int i2 = this.I$0;
                Throwable th = (Throwable) this.L$3;
                List list3 = (List) this.L$2;
                ResultKt.throwOnFailure($result);
                create$default = $result;
                final IMToast imToast2 = (IMToast) create$default;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.OperateMessageKt$bindOperateMessage$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        ChatPageData invokeSuspend$lambda$1$0;
                        invokeSuspend$lambda$1$0 = OperateMessageKt$bindOperateMessage$3.invokeSuspend$lambda$1$0(imToast2, (ChatPageData) obj);
                        return invokeSuspend$lambda$1$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$1$0(final IMToast $imToast, ChatPageData $this$mutate) {
        return (ChatPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.OperateMessageKt$bindOperateMessage$3$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$0$0;
                invokeSuspend$lambda$1$0$0 = OperateMessageKt$bindOperateMessage$3.invokeSuspend$lambda$1$0$0($imToast, (CopyScope) obj);
                return invokeSuspend$lambda$1$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$0$0(IMToast $imToast, CopyScope $this$copy) {
        InitLoadKt.updateToast($this$copy, $imToast);
        return Unit.INSTANCE;
    }
}