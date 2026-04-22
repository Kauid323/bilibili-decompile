package kntr.app.im.chat.core.service;

import java.util.List;
import java.util.Map;
import kntr.app.im.chat.core.RequestMessagesPolicy;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.FetchMessagesResult;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* compiled from: NetworkServices.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H¦@¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/NetworkFetchMessageService;", RoomRecommendViewModel.EMPTY_CURSOR, "load", "Lkotlin/Result;", "Lkntr/app/im/chat/core/model/FetchMessagesResult;", "beginSequenceNumber", RoomRecommendViewModel.EMPTY_CURSOR, "policy", "Lkntr/app/im/chat/core/RequestMessagesPolicy;", "load-0E7RQCE", "(JLkntr/app/im/chat/core/RequestMessagesPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messageDetail", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MessageId;", "Lkntr/app/im/chat/core/model/EntityMessage;", "ids", RoomRecommendViewModel.EMPTY_CURSOR, "messageDetail-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NetworkFetchMessageService {
    /* renamed from: load-0E7RQCE  reason: not valid java name */
    Object mo1360load0E7RQCE(long j2, RequestMessagesPolicy requestMessagesPolicy, Continuation<? super Result<FetchMessagesResult>> continuation);

    /* renamed from: messageDetail-gIAlu-s  reason: not valid java name */
    Object mo1361messageDetailgIAlus(List<MessageId> list, Continuation<? super Result<? extends Map<MessageId, EntityMessage>>> continuation);
}