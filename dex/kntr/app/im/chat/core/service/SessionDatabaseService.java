package kntr.app.im.chat.core.service;

import im.base.model.SessionId;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: DatabaseServices.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/SessionDatabaseService;", RoomRecommendViewModel.EMPTY_CURSOR, "initSession", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", "Lim/base/model/SessionId;", "(Lim/base/model/SessionId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SessionDatabaseService {
    Object initSession(SessionId sessionId, Continuation<? super Unit> continuation);
}