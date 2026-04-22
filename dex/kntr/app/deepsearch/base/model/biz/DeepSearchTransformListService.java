package kntr.app.deepsearch.base.model.biz;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: DeepSearchService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchTransformListService;", RoomRecommendViewModel.EMPTY_CURSOR, "transform", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItem;", "pageData", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DeepSearchTransformListService {
    List<DeepSearchDataItem> transform(DeepSearchPageData deepSearchPageData);
}