package kntr.app.im.chat.core;

import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IMChatStateMachine.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/IMChatStateMachine;", RoomRecommendViewModel.EMPTY_CURSOR, "state", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/im/chat/core/model/ChatPageData;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "dispatch", RoomRecommendViewModel.EMPTY_CURSOR, "action", "Lkntr/app/im/chat/core/model/ChatAction;", "(Lkntr/app/im/chat/core/model/ChatAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMChatStateMachine {
    Object dispatch(ChatAction chatAction, Continuation<? super Unit> continuation);

    Flow<ChatPageData> getState();
}