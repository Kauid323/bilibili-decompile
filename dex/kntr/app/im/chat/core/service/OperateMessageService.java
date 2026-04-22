package kntr.app.im.chat.core.service;

import java.util.List;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: OperateMessageService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H¦@¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0007H¦@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/OperateMessageService;", RoomRecommendViewModel.EMPTY_CURSOR, "deleteMessage", "Lkotlin/Result;", RoomRecommendViewModel.EMPTY_CURSOR, "messageIds", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MessageId;", "deleteMessage-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recallMessage", "messageId", "recallMessage-gIAlu-s", "(Lkntr/app/im/chat/core/model/MessageId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OperateMessageService {
    /* renamed from: deleteMessage-gIAlu-s  reason: not valid java name */
    Object mo1364deleteMessagegIAlus(List<MessageId> list, Continuation<? super Result<Unit>> continuation);

    /* renamed from: recallMessage-gIAlu-s  reason: not valid java name */
    Object mo1365recallMessagegIAlus(MessageId messageId, Continuation<? super Result<Unit>> continuation);
}