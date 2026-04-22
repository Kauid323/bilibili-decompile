package kntr.app.deepsearch.base.model.biz;

import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.flow.Flow;

/* compiled from: DeepSearchService.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchBroadcastService;", RoomRecommendViewModel.EMPTY_CURSOR, "deepSearchFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KDeepSearchResponse;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DeepSearchBroadcastService {
    Flow<Result<KDeepSearchResponse>> deepSearchFlow();
}