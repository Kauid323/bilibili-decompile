package kntr.app.im.chat.stateMachine.builder;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import im.base.model.SessionId;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.service.MessageSendService;
import kntr.app.im.chat.sticker.service.StickerManagerService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Sticker.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aG\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0000R\u00020\u0002R\u00020\u0004R\u00020\u0006j\u0006\u0010\u0003\u001a\u00020\u0002j\u0006\u0010\u0005\u001a\u00020\u0004j\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"bindSticker", RoomRecommendViewModel.EMPTY_CURSOR, "Lim/base/model/SessionId;", "sessionId", "Lkntr/app/im/chat/sticker/service/StickerManagerService;", "stickerService", "Lkntr/app/im/chat/core/service/MessageSendService;", "sendMessageService", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/im/chat/core/model/ChatPageData;", "Lkntr/app/im/chat/core/model/ChatAction;", "(Lim/base/model/SessionId;Lkntr/app/im/chat/sticker/service/StickerManagerService;Lkntr/app/im/chat/core/service/MessageSendService;Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;)V", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StickerKt {
    public static final void bindSticker(SessionId sessionId, StickerManagerService stickerService, MessageSendService sendMessageService, InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(stickerService, "stickerService");
        Intrinsics.checkNotNullParameter(sendMessageService, "sendMessageService");
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new StickerKt$bindSticker$1(stickerService, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ChatAction.SaveSticker.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new StickerKt$bindSticker$2(sendMessageService, sessionId, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.onActionEffect(Reflection.getOrCreateKotlinClass(ChatAction.SendSingleAsset.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv3 = new StickerKt$bindSticker$3(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(ChatAction.ShowStickerEditPage.class), executionPolicy$iv3, handler$iv3);
    }
}