package kntr.app.im.chat.core.service;

import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: MessageGroupingService.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/MessageGroupingService;", RoomRecommendViewModel.EMPTY_CURSOR, "isInSameGroup", RoomRecommendViewModel.EMPTY_CURSOR, "last", "Lkntr/app/im/chat/core/model/EntityMessage;", "next", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MessageGroupingService {
    boolean isInSameGroup(EntityMessage entityMessage, EntityMessage entityMessage2);
}