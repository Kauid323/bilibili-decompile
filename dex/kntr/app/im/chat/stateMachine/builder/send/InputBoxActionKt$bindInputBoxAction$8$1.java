package kntr.app.im.chat.stateMachine.builder.send;

import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMLog;
import im.base.model.SessionId;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.ChatPageDataLensKt;
import kntr.app.im.chat.core.model.InputBoxSelectState;
import kntr.app.im.chat.core.model.InputContent;
import kntr.app.im.chat.core.model.InputContentLensKt;
import kntr.app.im.chat.core.service.DraftDatabaseService;
import kntr.app.im.chat.core.service.MessageSendService;
import kntr.app.im.chat.db.model.InputBoxContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputBoxAction.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "<unused var>", "Lkntr/app/im/chat/core/model/ChatAction$SendMessage;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$bindInputBoxAction$8$1", f = "InputBoxAction.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {88, 96}, m = "invokeSuspend", n = {"state", "snapshot", "content", ReportBuildInParam.MID, "state", "snapshot", "content", ReportBuildInParam.MID}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class InputBoxActionKt$bindInputBoxAction$8$1 extends SuspendLambda implements Function3<ChatAction.SendMessage, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    final /* synthetic */ DraftDatabaseService $draftService;
    final /* synthetic */ MessageSendService $sendMessageService;
    final /* synthetic */ SessionId $sessionId;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBoxActionKt$bindInputBoxAction$8$1(MessageSendService messageSendService, SessionId sessionId, DraftDatabaseService draftDatabaseService, Continuation<? super InputBoxActionKt$bindInputBoxAction$8$1> continuation) {
        super(3, continuation);
        this.$sendMessageService = messageSendService;
        this.$sessionId = sessionId;
        this.$draftService = draftDatabaseService;
    }

    public final Object invoke(ChatAction.SendMessage sendMessage, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        InputBoxActionKt$bindInputBoxAction$8$1 inputBoxActionKt$bindInputBoxAction$8$1 = new InputBoxActionKt$bindInputBoxAction$8$1(this.$sendMessageService, this.$sessionId, this.$draftService, continuation);
        inputBoxActionKt$bindInputBoxAction$8$1.L$0 = state;
        return inputBoxActionKt$bindInputBoxAction$8$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ChatPageData snapshot;
        InputContent content;
        Long mid;
        Long mid2;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ChatPageData snapshot2 = (ChatPageData) state.getSnapshot();
                InputContent content2 = snapshot2.getInputContent();
                Long boxLong = Boxing.boxLong(snapshot2.getHostMid());
                long it = boxLong.longValue();
                if (!(it > 0)) {
                    boxLong = null;
                }
                Long mid3 = boxLong;
                if (mid3 == null) {
                    IMLog.Companion.w("InputBox", "未登录，发送消息失败");
                    return state.noChange();
                }
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(snapshot2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(content2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(mid3);
                this.label = 1;
                if (this.$sendMessageService.send(this.$sessionId, content2, (KEntityMsgType) KEntityMsgType.ENTITY_MSG_TYPE_PICTURE.INSTANCE, new KUserPlaceholder(mid3.longValue()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                snapshot = snapshot2;
                content = content2;
                mid = mid3;
                IMLog.Companion.i("InputBox", "发送消息，清空输入框");
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(snapshot);
                this.L$2 = SpillingKt.nullOutSpilledVariable(content);
                this.L$3 = SpillingKt.nullOutSpilledVariable(mid);
                this.label = 2;
                if (this.$draftService.remove((Continuation) this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                mid2 = mid;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$bindInputBoxAction$8$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        ChatPageData invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = InputBoxActionKt$bindInputBoxAction$8$1.invokeSuspend$lambda$1((ChatPageData) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            case 1:
                mid = (Long) this.L$3;
                content = (InputContent) this.L$2;
                snapshot = (ChatPageData) this.L$1;
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i("InputBox", "发送消息，清空输入框");
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(snapshot);
                this.L$2 = SpillingKt.nullOutSpilledVariable(content);
                this.L$3 = SpillingKt.nullOutSpilledVariable(mid);
                this.label = 2;
                if (this.$draftService.remove((Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                mid2 = (Long) this.L$3;
                InputContent inputContent = (InputContent) this.L$2;
                ChatPageData chatPageData = (ChatPageData) this.L$1;
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$bindInputBoxAction$8$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        ChatPageData invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = InputBoxActionKt$bindInputBoxAction$8$1.invokeSuspend$lambda$1((ChatPageData) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$1(ChatPageData $this$mutate) {
        return (ChatPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$bindInputBoxAction$8$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$0;
                invokeSuspend$lambda$1$0 = InputBoxActionKt$bindInputBoxAction$8$1.invokeSuspend$lambda$1$0((CopyScope) obj);
                return invokeSuspend$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$0(CopyScope $this$copy) {
        $this$copy.set(ChatPageDataLensKt.getInputContent(ChatPageData.Companion), new InputContent(new InputBoxContent(null, 0, 0, null, 15, null), CollectionsKt.emptyList(), false, ((Number) $this$copy.get(InputContentLensKt.getContentVersion(ChatPageDataLensKt.getInputContent(ChatPageData.Companion)))).intValue() + 1, 4, null));
        $this$copy.set(ChatPageDataLensKt.getInputBoxSelectState(ChatPageData.Companion), InputBoxSelectState.Idle.INSTANCE);
        return Unit.INSTANCE;
    }
}