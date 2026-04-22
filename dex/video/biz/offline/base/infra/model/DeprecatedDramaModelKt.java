package video.biz.offline.base.infra.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;
import video.biz.offline.base.infra.storage.diskfile.model.DramaItemModel;

/* compiled from: DeprecatedDramaModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005¨\u0006\u0006"}, d2 = {"toDeprecatedDramaModel", "Lvideo/biz/offline/base/infra/model/DeprecatedDramaModel;", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel;", "toDeprecatedDramaItemModel", "Lvideo/biz/offline/base/infra/model/DeprecatedDramaItemModel;", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaItemModel;", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DeprecatedDramaModelKt {
    public static final DeprecatedDramaModel toDeprecatedDramaModel(DramaGroupModel $this$toDeprecatedDramaModel) {
        Intrinsics.checkNotNullParameter($this$toDeprecatedDramaModel, "<this>");
        long id = $this$toDeprecatedDramaModel.getId();
        String title = $this$toDeprecatedDramaModel.getTitle();
        Iterable $this$map$iv = $this$toDeprecatedDramaModel.getItems();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            DramaItemModel it = (DramaItemModel) item$iv$iv;
            destination$iv$iv.add(toDeprecatedDramaItemModel(it));
        }
        return new DeprecatedDramaModel(id, title, (List) destination$iv$iv);
    }

    public static final DeprecatedDramaItemModel toDeprecatedDramaItemModel(DramaItemModel $this$toDeprecatedDramaItemModel) {
        Intrinsics.checkNotNullParameter($this$toDeprecatedDramaItemModel, "<this>");
        return new DeprecatedDramaItemModel($this$toDeprecatedDramaItemModel.getAid(), $this$toDeprecatedDramaItemModel.getIdx(), $this$toDeprecatedDramaItemModel.getSection(), $this$toDeprecatedDramaItemModel.getTitle());
    }
}