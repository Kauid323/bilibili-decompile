package kntr.app.deepsearch.base.model.biz;

import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: DeepSearchService.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H&J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H&J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0014\u001a\u00020\tH&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;", RoomRecommendViewModel.EMPTY_CURSOR, "getCacheLayout", "Lkntr/app/deepsearch/base/model/biz/TextLayout;", "idModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;", "getAtomicIndex", RoomRecommendViewModel.EMPTY_CURSOR, "cacheCurrentReqQueryId", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "isCurrentReqQueryId", RoomRecommendViewModel.EMPTY_CURSOR, "saveLayout", "paragraph", "Lcom/bapis/bilibili/app/dynamic/v2/KModuleParagraph;", "textLayout", "updateLayout", "isSameParagraph", "cleanLayoutCache", "cacheAbnormalQuery", "removeAbnormalQuery", "isContainAbnormalQueryId", "cacheEndQuery", "isContainEndQueryId", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DeepSearchDataProcessService {
    void cacheAbnormalQuery(String str);

    void cacheCurrentReqQueryId(String str);

    void cacheEndQuery(String str);

    void cleanLayoutCache();

    int getAtomicIndex();

    TextLayout getCacheLayout(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier);

    boolean isContainAbnormalQueryId(String str);

    boolean isContainEndQueryId(String str);

    boolean isCurrentReqQueryId(String str);

    boolean isSameParagraph(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, KModuleParagraph kModuleParagraph);

    void removeAbnormalQuery(String str);

    void saveLayout(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, KModuleParagraph kModuleParagraph, TextLayout textLayout);

    void updateLayout(DeepSearchDataItemIdentifier deepSearchDataItemIdentifier, TextLayout textLayout);
}