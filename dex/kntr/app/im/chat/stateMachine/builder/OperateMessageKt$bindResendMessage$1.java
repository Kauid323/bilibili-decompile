package kntr.app.im.chat.stateMachine.builder;

import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import im.base.IMLog;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.service.MessageSendService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OperateMessage.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "action", "Lkntr/app/im/chat/core/model/ChatAction$ResendMessage;", "stateSnapshot", "Lkntr/app/im/chat/core/model/ChatPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.OperateMessageKt$bindResendMessage$1", f = "OperateMessage.kt", i = {0, 0, 0}, l = {33}, m = "invokeSuspend", n = {"action", "stateSnapshot", ReportBuildInParam.MID}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class OperateMessageKt$bindResendMessage$1 extends SuspendLambda implements Function3<ChatAction.ResendMessage, ChatPageData, Continuation<? super Unit>, Object> {
    final /* synthetic */ MessageSendService $sendMessageService;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperateMessageKt$bindResendMessage$1(MessageSendService messageSendService, Continuation<? super OperateMessageKt$bindResendMessage$1> continuation) {
        super(3, continuation);
        this.$sendMessageService = messageSendService;
    }

    public final Object invoke(ChatAction.ResendMessage resendMessage, ChatPageData chatPageData, Continuation<? super Unit> continuation) {
        OperateMessageKt$bindResendMessage$1 operateMessageKt$bindResendMessage$1 = new OperateMessageKt$bindResendMessage$1(this.$sendMessageService, continuation);
        operateMessageKt$bindResendMessage$1.L$0 = resendMessage;
        operateMessageKt$bindResendMessage$1.L$1 = chatPageData;
        return operateMessageKt$bindResendMessage$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Long mid;
        ChatAction.ResendMessage action = (ChatAction.ResendMessage) this.L$0;
        ChatPageData stateSnapshot = (ChatPageData) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i("OperateMessage", "重试发送消息 " + action.getMessage().getMsgId());
                Long mid2 = Boxing.boxLong(stateSnapshot.getHostMid());
                long it = mid2.longValue();
                if (!(it > 0)) {
                    mid2 = null;
                }
                if (mid2 != null) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(stateSnapshot);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(mid2);
                    this.label = 1;
                    if (this.$sendMessageService.resend(action.getMessage(), new KUserPlaceholder(mid2.longValue()), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mid = mid2;
                    break;
                } else {
                    IMLog.Companion.w("OperateMessage", "未登录，重试发送消息失败");
                    break;
                }
            case 1:
                mid = (Long) this.L$2;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}