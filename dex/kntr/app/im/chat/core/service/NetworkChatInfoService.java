package kntr.app.im.chat.core.service;

import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* compiled from: NetworkServices.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/NetworkChatInfoService;", RoomRecommendViewModel.EMPTY_CURSOR, "load", "Lkotlin/Result;", "Lkntr/app/im/chat/core/model/ChatInfo;", "load-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NetworkChatInfoService {
    /* renamed from: load-IoAF18A  reason: not valid java name */
    Object mo1359loadIoAF18A(Continuation<? super Result<ChatInfo>> continuation);
}