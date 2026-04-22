package video.biz.offline.base.infra.storage;

import com.bilibili.lib.foundation.FoundationAlias;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.infra.utils.DownloadStoragePreference;
import video.biz.offline.base.infra.utils.StorageHelperKt;
import video.biz.offline.base.model.model.StorageInfoModel;
import video.biz.offline.base.model.model.StorageType;

/* compiled from: StorageInfoImpl.android.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006\u001a\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"getStorageInfoList", "", "Lvideo/biz/offline/base/model/model/StorageInfoModel;", "calculateUsedSpace", "", "getPreferredStorageType", "Lvideo/biz/offline/base/model/model/StorageType;", "setStoragePreference", "", "type", "pathInPrimaryStorage", "path", "", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class StorageInfoImpl_androidKt {
    public static /* synthetic */ List getStorageInfoList$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return getStorageInfoList(z);
    }

    public static final List<StorageInfoModel> getStorageInfoList(boolean calculateUsedSpace) {
        List infoList = new ArrayList();
        File primaryPath = StorageHelperKt.getPrimaryDirectoryFile(FoundationAlias.getFapp());
        StorageInfoModel primaryStorage = StorageHelperKt.getPrimaryStorage();
        if (primaryPath != null && primaryStorage != null) {
            primaryStorage.setStorageType(StorageType.PRIMARY);
            if (calculateUsedSpace) {
                primaryStorage.setUsedSpace(StorageHelperKt.dirSize(primaryPath));
            }
            infoList.add(primaryStorage);
        }
        File secondaryPath = StorageHelperKt.getSecondaryDirectoryFile(FoundationAlias.getFapp());
        StorageInfoModel secondaryStorage = StorageHelperKt.getSecondaryStorage(FoundationAlias.getFapp());
        if (secondaryPath != null && secondaryStorage != null) {
            secondaryStorage.setStorageType(StorageType.SECONDARY);
            if (calculateUsedSpace) {
                secondaryStorage.setUsedSpace(StorageHelperKt.dirSize(secondaryPath));
            }
            infoList.add(secondaryStorage);
        }
        return infoList;
    }

    public static final StorageType getPreferredStorageType() {
        StorageType it = DownloadStoragePreference.INSTANCE.getPreferredStorageType();
        new DataLog().info("getPreferredStorageType: " + it);
        return it;
    }

    public static final void setStoragePreference(StorageType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        new DataLog().info("setStoragePreference: " + type);
        DownloadStoragePreference.INSTANCE.setPreferredStorageType(type);
    }

    public static final boolean pathInPrimaryStorage(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        String primaryPath = StorageHelperKt.getPrimaryPath();
        if (primaryPath == null) {
            return true;
        }
        return StringsKt.startsWith$default(path, primaryPath, false, 2, (Object) null);
    }
}