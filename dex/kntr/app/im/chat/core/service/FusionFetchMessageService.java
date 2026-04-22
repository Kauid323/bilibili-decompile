package kntr.app.im.chat.core.service;

import java.util.List;
import kntr.app.im.chat.core.FetchMessageDirection;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: FusionFetchMessageService.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H¦@¢\u0006\u0002\u0010\u0012R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/FusionFetchMessageService;", RoomRecommendViewModel.EMPTY_CURSOR, "dataFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/im/chat/core/model/FetchMessagesData;", "getDataFlow$annotations", "()V", "getDataFlow", "()Lkotlinx/coroutines/flow/Flow;", "load", RoomRecommendViewModel.EMPTY_CURSOR, "direction", "Lkntr/app/im/chat/core/FetchMessageDirection;", "(Lkntr/app/im/chat/core/FetchMessageDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMessages", "messages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MessageId;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FusionFetchMessageService {

    /* compiled from: FusionFetchMessageService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getDataFlow$annotations() {
        }
    }

    Flow<FetchMessagesData> getDataFlow();

    Object load(FetchMessageDirection fetchMessageDirection, Continuation<? super Unit> continuation);

    Object updateMessages(List<MessageId> list, Continuation<? super Unit> continuation);
}