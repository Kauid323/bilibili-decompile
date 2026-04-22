package kntr.app.deepsearch.base.model.biz;

import com.bapis.bilibili.app.dynamic.v2.KLinkNode;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: DeepSearchPageData.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/LinkNodeData;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "linkNode", "Lcom/bapis/bilibili/app/dynamic/v2/KLinkNode;", "getLinkNode", "()Lcom/bapis/bilibili/app/dynamic/v2/KLinkNode;", "idModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;", "getIdModel", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LinkNodeData {
    private final DeepSearchDataItemIdentifier idModel;
    private final KLinkNode linkNode;

    public final KLinkNode getLinkNode() {
        return this.linkNode;
    }

    public final DeepSearchDataItemIdentifier getIdModel() {
        return this.idModel;
    }
}