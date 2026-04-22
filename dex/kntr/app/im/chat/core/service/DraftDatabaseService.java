package kntr.app.im.chat.core.service;

import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: DatabaseServices.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\b¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/DraftDatabaseService;", RoomRecommendViewModel.EMPTY_CURSOR, "add", RoomRecommendViewModel.EMPTY_CURSOR, "content", "Lkntr/app/im/chat/db/model/InputBoxContent;", "(Lkntr/app/im/chat/db/model/InputBoxContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "query", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DraftDatabaseService {
    Object add(InputBoxContent inputBoxContent, Continuation<? super Unit> continuation);

    Object query(Continuation<? super InputBoxContent> continuation);

    Object remove(Continuation<? super Unit> continuation);
}