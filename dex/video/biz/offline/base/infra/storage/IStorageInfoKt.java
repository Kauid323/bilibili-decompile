package video.biz.offline.base.infra.storage;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.model.model.StorageInfoModel;

/* compiled from: IStorageInfo.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002¨\u0006\u0003"}, d2 = {"currentStorageInfo", "Lvideo/biz/offline/base/model/model/StorageInfoModel;", "", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IStorageInfoKt {
    public static final StorageInfoModel currentStorageInfo(List<StorageInfoModel> list) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            StorageInfoModel it2 = (StorageInfoModel) obj;
            if (it2.getStorageType() == StorageInfoImpl_androidKt.getPreferredStorageType()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        StorageInfoModel preferred = (StorageInfoModel) obj;
        if (preferred != null) {
            return preferred;
        }
        StorageInfoModel storageInfoModel = (StorageInfoModel) CollectionsKt.firstOrNull(list);
        LogKt.getVBLog().info("failed to find preferred storage type, using default: " + storageInfoModel);
        return storageInfoModel;
    }
}