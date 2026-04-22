package kntr.app.im.chat.core.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: Message.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/model/Message;", RoomRecommendViewModel.EMPTY_CURSOR, "msgId", "Lkntr/app/im/chat/core/model/MessageId;", "getMsgId", "()Lkntr/app/im/chat/core/model/MessageId;", "Lkntr/app/im/chat/core/model/EntityMessage;", "Lkntr/app/im/chat/core/model/GhostMessage;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Message {
    MessageId getMsgId();
}