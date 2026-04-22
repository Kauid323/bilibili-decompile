package kntr.app.im.chat.stateMachine.builder;

import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bapis.bilibili.app.im.v1.KChatHintMessages;
import com.bapis.bilibili.broadcast.message.im.KCommandMsg;
import im.base.model.SessionId;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.model.MessageKt;
import kntr.app.im.chat.core.model.MessageSequence;
import kntr.app.im.chat.core.service.MessageDatabaseService;
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
/* compiled from: PushSettingHint.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "data", "Lcom/bapis/bilibili/broadcast/message/im/KCommandMsg$KChatPushSettingChangedCommand;", "state", "Lkntr/app/im/chat/core/model/ChatPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.PushSettingHintKt$bindPushSettingHint$2", f = "PushSettingHint.kt", i = {0, 0, 0, 0, 0, 0}, l = {60}, m = "invokeSuspend", n = {"data", "state", "hintMessages", "paragraph", "seqToBuild", "message"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
public final class PushSettingHintKt$bindPushSettingHint$2 extends SuspendLambda implements Function3<KCommandMsg.KChatPushSettingChangedCommand, ChatPageData, Continuation<? super Unit>, Object> {
    final /* synthetic */ MessageDatabaseService $messageDatabaseService;
    final /* synthetic */ SessionId $sessionId;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushSettingHintKt$bindPushSettingHint$2(SessionId sessionId, MessageDatabaseService messageDatabaseService, Continuation<? super PushSettingHintKt$bindPushSettingHint$2> continuation) {
        super(3, continuation);
        this.$sessionId = sessionId;
        this.$messageDatabaseService = messageDatabaseService;
    }

    public final Object invoke(KCommandMsg.KChatPushSettingChangedCommand kChatPushSettingChangedCommand, ChatPageData chatPageData, Continuation<? super Unit> continuation) {
        PushSettingHintKt$bindPushSettingHint$2 pushSettingHintKt$bindPushSettingHint$2 = new PushSettingHintKt$bindPushSettingHint$2(this.$sessionId, this.$messageDatabaseService, continuation);
        pushSettingHintKt$bindPushSettingHint$2.L$0 = kChatPushSettingChangedCommand;
        pushSettingHintKt$bindPushSettingHint$2.L$1 = chatPageData;
        return pushSettingHintKt$bindPushSettingHint$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        KParagraph paragraph;
        EntityMessage message;
        KParagraph paragraph2;
        MessageId msgId;
        KChatHintMessages hintMessages;
        KCommandMsg.KChatPushSettingChangedCommand data = (KCommandMsg.KChatPushSettingChangedCommand) this.L$0;
        ChatPageData state = (ChatPageData) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ChatInfo chatInfo = state.getChatInfo();
                MessageSequence messageSequence = null;
                KChatHintMessages.KPushSettingChangedMessage hintMessages2 = (chatInfo == null || (hintMessages = chatInfo.getHintMessages()) == null) ? null : hintMessages.getPushSettingChangedMessage();
                if (data.getValue().getSetting()) {
                    if (hintMessages2 != null) {
                        paragraph = hintMessages2.getEnabled();
                        if (paragraph != null) {
                            EntityMessage lastMessage = state.getLastMessage();
                            if (lastMessage != null && (msgId = lastMessage.getMsgId()) != null) {
                                messageSequence = msgId.getSequence();
                            }
                            MessageSequence seqToBuild = MessageKt.nextSendSequence(messageSequence);
                            message = PushSettingHintKt.buildSettingMessage(paragraph, this.$sessionId, seqToBuild);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(data);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(hintMessages2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(paragraph);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(seqToBuild);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(message);
                            this.label = 1;
                            if (this.$messageDatabaseService.add(message, (Continuation) this) != coroutine_suspended) {
                                paragraph2 = paragraph;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        }
                    }
                    paragraph = null;
                    if (paragraph != null) {
                    }
                } else {
                    if (hintMessages2 != null) {
                        paragraph = hintMessages2.getDisabled();
                        if (paragraph != null) {
                        }
                    }
                    paragraph = null;
                    if (paragraph != null) {
                    }
                }
                break;
            case 1:
                EntityMessage entityMessage = (EntityMessage) this.L$5;
                MessageSequence messageSequence2 = (MessageSequence) this.L$4;
                paragraph2 = (KParagraph) this.L$3;
                KChatHintMessages.KPushSettingChangedMessage kPushSettingChangedMessage = (KChatHintMessages.KPushSettingChangedMessage) this.L$2;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}