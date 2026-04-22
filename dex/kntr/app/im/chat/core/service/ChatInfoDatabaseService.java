package kntr.app.im.chat.core.service;

import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: DatabaseServices.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/ChatInfoDatabaseService;", RoomRecommendViewModel.EMPTY_CURSOR, "load", "Lkntr/app/im/chat/core/model/ChatInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "add", RoomRecommendViewModel.EMPTY_CURSOR, "chatInfo", "(Lkntr/app/im/chat/core/model/ChatInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatInfoDatabaseService {
    Object add(ChatInfo chatInfo, Continuation<? super Unit> continuation);

    Object load(Continuation<? super ChatInfo> continuation);
}