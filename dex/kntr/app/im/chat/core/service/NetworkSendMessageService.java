package kntr.app.im.chat.core.service;

import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* compiled from: NetworkServices.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/NetworkSendMessageService;", RoomRecommendViewModel.EMPTY_CURSOR, "send", "Lkotlin/Result;", "Lkntr/app/im/chat/core/model/EntityMessage;", "message", "send-gIAlu-s", "(Lkntr/app/im/chat/core/model/EntityMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NetworkSendMessageService {
    /* renamed from: send-gIAlu-s  reason: not valid java name */
    Object mo1362sendgIAlus(EntityMessage entityMessage, Continuation<? super Result<EntityMessage>> continuation);
}