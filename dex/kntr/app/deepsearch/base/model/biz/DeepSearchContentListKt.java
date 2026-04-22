package kntr.app.deepsearch.base.model.biz;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchContentList.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"isShowSessionEndTimeLine", RoomRecommendViewModel.EMPTY_CURSOR, "sessionEndModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;", "item", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchContentListKt {
    public static final boolean isShowSessionEndTimeLine(DeepSearchSessionEndModel sessionEndModel, KChatHistoryItem item) {
        Intrinsics.checkNotNullParameter(sessionEndModel, "sessionEndModel");
        Intrinsics.checkNotNullParameter(item, "item");
        String sessionId = sessionEndModel.getSessionId();
        KDeepSearchResponse content = item.getContent();
        if (Intrinsics.areEqual(sessionId, content != null ? content.getSessionId() : null) && Intrinsics.areEqual(sessionEndModel.getQuery(), item.getQuery())) {
            String queryId = sessionEndModel.getQueryId();
            KDeepSearchResponse content2 = item.getContent();
            if (Intrinsics.areEqual(queryId, content2 != null ? content2.getQueryId() : null)) {
                return true;
            }
        }
        return false;
    }
}