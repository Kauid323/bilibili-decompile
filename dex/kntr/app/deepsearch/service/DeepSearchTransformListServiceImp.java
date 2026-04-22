package kntr.app.deepsearch.service;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import java.util.List;
import javax.inject.Inject;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataItem;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.base.model.biz.DeepSearchTransformListService;
import kntr.app.deepsearch.di.DeepSearchScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchTransformListServiceImp.kt */
@DeepSearchScope
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/deepsearch/service/DeepSearchTransformListServiceImp;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTransformListService;", "dataProcessService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;", "linkNodeService", "Lkntr/app/deepsearch/service/DeepSearchTextLinkNodeService;", "<init>", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;Lkntr/app/deepsearch/service/DeepSearchTextLinkNodeService;)V", "transform", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItem;", "pageData", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTransformListServiceImp implements DeepSearchTransformListService {
    public static final int $stable = 8;
    private final DeepSearchDataProcessService dataProcessService;
    private final DeepSearchTextLinkNodeService linkNodeService;

    @Inject
    public DeepSearchTransformListServiceImp(DeepSearchDataProcessService dataProcessService, DeepSearchTextLinkNodeService linkNodeService) {
        Intrinsics.checkNotNullParameter(dataProcessService, "dataProcessService");
        Intrinsics.checkNotNullParameter(linkNodeService, "linkNodeService");
        this.dataProcessService = dataProcessService;
        this.linkNodeService = linkNodeService;
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchTransformListService
    public List<DeepSearchDataItem> transform(DeepSearchPageData pageData) {
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        List $this$transform_u24lambda_u240 = CollectionsKt.createListBuilder();
        if (pageData.getContainerWidth() <= 0.0d) {
            $this$transform_u24lambda_u240.addAll(CollectionsKt.emptyList());
        } else {
            Iterable $this$forEachIndexed$iv = pageData.getList().getList();
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                KChatHistoryItem it = (KChatHistoryItem) item$iv;
                $this$transform_u24lambda_u240.addAll(DeepSearchTransformListServiceImpKt.access$handleContentList(pageData, this.dataProcessService, this.linkNodeService, it, index));
                index = index$iv;
            }
        }
        return CollectionsKt.build($this$transform_u24lambda_u240);
    }
}