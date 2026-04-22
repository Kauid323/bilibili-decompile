package kntr.app.im.chat.core.service;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: NetworkServices.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/ChatFetchEventService;", RoomRecommendViewModel.EMPTY_CURSOR, "fetchMessageFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/im/chat/core/service/FetchEventType;", "getFetchMessageFlow$annotations", "()V", "getFetchMessageFlow", "()Lkotlinx/coroutines/flow/Flow;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatFetchEventService {

    /* compiled from: NetworkServices.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getFetchMessageFlow$annotations() {
        }
    }

    Flow<FetchEventType> getFetchMessageFlow();
}