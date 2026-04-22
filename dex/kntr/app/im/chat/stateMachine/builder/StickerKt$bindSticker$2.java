package kntr.app.im.chat.stateMachine.builder;

import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import im.base.IMLog;
import im.base.model.SessionId;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.service.MessageSendService;
import kntr.app.im.chat.core.service.MessageSendServiceKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
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
/* compiled from: Sticker.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "action", "Lkntr/app/im/chat/core/model/ChatAction$SendSingleAsset;", "stateSnapshot", "Lkntr/app/im/chat/core/model/ChatPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.StickerKt$bindSticker$2", f = "Sticker.kt", i = {0, 0, 0}, l = {61}, m = "invokeSuspend", n = {"action", "stateSnapshot", ReportBuildInParam.MID}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class StickerKt$bindSticker$2 extends SuspendLambda implements Function3<ChatAction.SendSingleAsset, ChatPageData, Continuation<? super Unit>, Object> {
    final /* synthetic */ MessageSendService $sendMessageService;
    final /* synthetic */ SessionId $sessionId;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerKt$bindSticker$2(MessageSendService messageSendService, SessionId sessionId, Continuation<? super StickerKt$bindSticker$2> continuation) {
        super(3, continuation);
        this.$sendMessageService = messageSendService;
        this.$sessionId = sessionId;
    }

    public final Object invoke(ChatAction.SendSingleAsset sendSingleAsset, ChatPageData chatPageData, Continuation<? super Unit> continuation) {
        StickerKt$bindSticker$2 stickerKt$bindSticker$2 = new StickerKt$bindSticker$2(this.$sendMessageService, this.$sessionId, continuation);
        stickerKt$bindSticker$2.L$0 = sendSingleAsset;
        stickerKt$bindSticker$2.L$1 = chatPageData;
        return stickerKt$bindSticker$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Long mid;
        ChatAction.SendSingleAsset action = (ChatAction.SendSingleAsset) this.L$0;
        ChatPageData stateSnapshot = (ChatPageData) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Long mid2 = Boxing.boxLong(stateSnapshot.getHostMid());
                long it = mid2.longValue();
                if (!(it > 0)) {
                    mid2 = null;
                }
                if (mid2 == null) {
                    IMLog.Companion.w("Chat", "未登录，发送表情失败");
                    break;
                } else {
                    KEntityMsgType kEntityMsgType = (KEntityMsgType) (action.getFromCamera() ? KEntityMsgType.ENTITY_MSG_TYPE_PICTURE.INSTANCE : KEntityMsgType.ENTITY_MSG_TYPE_CUSTOM_STICKER.INSTANCE);
                    Asset sticker = action.getSticker();
                    KUserPlaceholder kUserPlaceholder = new KUserPlaceholder(mid2.longValue());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(stateSnapshot);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(mid2);
                    this.label = 1;
                    if (MessageSendServiceKt.send(this.$sendMessageService, this.$sessionId, sticker, kEntityMsgType, kUserPlaceholder, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mid = mid2;
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