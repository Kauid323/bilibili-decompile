package kntr.app.im.chat.stateMachine.builder;

import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.broadcast.message.im.KCommandMsg;
import im.base.IMLog;
import im.base.SessionIdConverters;
import im.base.model.SessionId;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.service.FusionChatInfoService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
/* compiled from: ChatInfoLoad.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "command", "Lcom/bapis/bilibili/broadcast/message/im/KCommandMsg$KUpdateChatInfoCommand;", "<unused var>", "Lkntr/app/im/chat/core/model/ChatPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.ChatInfoLoadKt$bindChatInfoLoading$2", f = "ChatInfoLoad.kt", i = {0, 0}, l = {45}, m = "invokeSuspend", n = {"command", "kId"}, s = {"L$0", "L$1"}, v = 1)
public final class ChatInfoLoadKt$bindChatInfoLoading$2 extends SuspendLambda implements Function3<KCommandMsg.KUpdateChatInfoCommand, ChatPageData, Continuation<? super Unit>, Object> {
    final /* synthetic */ FusionChatInfoService $chatInfoService;
    final /* synthetic */ SessionId $sessionId;
    final /* synthetic */ SessionIdConverters $sessionIdConverters;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInfoLoadKt$bindChatInfoLoading$2(SessionIdConverters sessionIdConverters, SessionId sessionId, FusionChatInfoService fusionChatInfoService, Continuation<? super ChatInfoLoadKt$bindChatInfoLoading$2> continuation) {
        super(3, continuation);
        this.$sessionIdConverters = sessionIdConverters;
        this.$sessionId = sessionId;
        this.$chatInfoService = fusionChatInfoService;
    }

    public final Object invoke(KCommandMsg.KUpdateChatInfoCommand kUpdateChatInfoCommand, ChatPageData chatPageData, Continuation<? super Unit> continuation) {
        ChatInfoLoadKt$bindChatInfoLoading$2 chatInfoLoadKt$bindChatInfoLoading$2 = new ChatInfoLoadKt$bindChatInfoLoading$2(this.$sessionIdConverters, this.$sessionId, this.$chatInfoService, continuation);
        chatInfoLoadKt$bindChatInfoLoading$2.L$0 = kUpdateChatInfoCommand;
        return chatInfoLoadKt$bindChatInfoLoading$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        KSessionId kId;
        KCommandMsg.KUpdateChatInfoCommand command = (KCommandMsg.KUpdateChatInfoCommand) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i("Chat", "收到更新ChatInfo的命令 " + command);
                KSessionId kId2 = command.getValue().getSessionId();
                if (kId2 != null && this.$sessionIdConverters.convertToSessionId(kId2).checkSameId(this.$sessionId)) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(command);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(kId2);
                    this.label = 1;
                    if (this.$chatInfoService.load(true, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    kId = kId2;
                    break;
                }
                break;
            case 1:
                kId = (KSessionId) this.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}