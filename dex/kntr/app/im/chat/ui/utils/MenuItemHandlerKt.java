package kntr.app.im.chat.ui.utils;

import com.bapis.bilibili.app.im.v1.KMsgMenuContent;
import com.bapis.bilibili.app.im.v1.KMsgMenuItem;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: MenuItemHandler.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"menuItemClicked", RoomRecommendViewModel.EMPTY_CURSOR, "item", "Lcom/bapis/bilibili/app/im/v1/KMsgMenuItem;", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "(Lcom/bapis/bilibili/app/im/v1/KMsgMenuItem;Lkntr/app/im/chat/core/model/EntityMessage;Lkntr/app/im/chat/ui/ChatActionHandler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MenuItemHandlerKt {
    public static final Object menuItemClicked(KMsgMenuItem item, EntityMessage message, ChatActionHandler actionHandler, Continuation<? super Unit> continuation) {
        KMsgMenuContent content;
        KMsgMenuContent.KCopy content2 = (item == null || (content = item.getContent()) == null) ? null : content.getItem();
        if (content2 instanceof KMsgMenuContent.KCopy) {
            Object invoke = actionHandler.invoke(new ChatAction.CopyTextIntoClipBoard(content2.getValue().getContent()), continuation);
            return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
        } else if (content2 instanceof KMsgMenuContent.KDelete) {
            Object invoke2 = actionHandler.invoke(new ChatAction.DeleteMessage(message), continuation);
            return invoke2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke2 : Unit.INSTANCE;
        } else if (content2 instanceof KMsgMenuContent.KRecall) {
            Object invoke3 = actionHandler.invoke(new ChatAction.RecallMessage(message), continuation);
            return invoke3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke3 : Unit.INSTANCE;
        } else if (content2 instanceof KMsgMenuContent.KSaveSticker) {
            Object invoke4 = actionHandler.invoke(new ChatAction.SaveSticker(content2.getValue().getPicture()), continuation);
            return invoke4 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke4 : Unit.INSTANCE;
        } else if (content2 instanceof KMsgMenuContent.KReport) {
            Object invoke5 = actionHandler.invoke(new ChatAction.ReportMessage(message.getMsgId(), content2.getValue().getUrl()), continuation);
            return invoke5 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke5 : Unit.INSTANCE;
        } else {
            return Unit.INSTANCE;
        }
    }
}