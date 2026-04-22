package video.biz.offline.list.logic;

import java.util.List;
import kntr.base.reachability.KReachabilityKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import tv.danmaku.android.util.AppBuildConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.DeviceDecisionHelper_androidKt;
import video.biz.offline.base.infra.utils.DownloadStoragePreference;
import video.biz.offline.base.model.model.StorageType;
import video.biz.offline.list.logic.model.OfflinePageOperation;
import video.biz.offline.list.logic.model.OfflineSettingOperation;

/* compiled from: SupportedOptions.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001\u001a\u0006\u0010\u0007\u001a\u00020\u0004\u001a\u0006\u0010\b\u001a\u00020\u0004\u001a\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"getSupportedHeaderOptions", "", "Lvideo/biz/offline/list/logic/model/OfflinePageOperation;", "isEmpty", "", "getSupportedSettingOptions", "Lvideo/biz/offline/list/logic/model/OfflineSettingOperation;", "isPrimaryPath", "isNetworkConnect", "hideExternalSdcard", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SupportedOptions_androidKt {
    public static final List<OfflinePageOperation> getSupportedHeaderOptions(boolean isEmpty) {
        List $this$getSupportedHeaderOptions_u24lambda_u240 = CollectionsKt.createListBuilder();
        boolean isHD = AppBuildConfig.Companion.isHDApp();
        if (isHD) {
            if (!isEmpty) {
                $this$getSupportedHeaderOptions_u24lambda_u240.add(OfflinePageOperation.EDIT_ICON);
            }
        } else {
            $this$getSupportedHeaderOptions_u24lambda_u240.add(OfflinePageOperation.SEARCH_ICON);
            $this$getSupportedHeaderOptions_u24lambda_u240.add(OfflinePageOperation.SETTING_ICON);
            if (!isEmpty) {
                $this$getSupportedHeaderOptions_u24lambda_u240.add(OfflinePageOperation.EDIT_ICON);
            }
        }
        return CollectionsKt.build($this$getSupportedHeaderOptions_u24lambda_u240);
    }

    public static final List<OfflineSettingOperation> getSupportedSettingOptions() {
        List $this$getSupportedSettingOptions_u24lambda_u240 = CollectionsKt.createListBuilder();
        boolean isHD = AppBuildConfig.Companion.isHDApp();
        if (isHD) {
            $this$getSupportedSettingOptions_u24lambda_u240.add(OfflineSettingOperation.AUTO_DOWNLOAD);
        } else {
            $this$getSupportedSettingOptions_u24lambda_u240.add(OfflineSettingOperation.STORAGE_SELECT);
            $this$getSupportedSettingOptions_u24lambda_u240.add(OfflineSettingOperation.AUTO_DOWNLOAD);
            $this$getSupportedSettingOptions_u24lambda_u240.add(OfflineSettingOperation.OFFLINE_DIAGNOSIS);
            $this$getSupportedSettingOptions_u24lambda_u240.add(OfflineSettingOperation.STORAGE_TEST);
        }
        return CollectionsKt.build($this$getSupportedSettingOptions_u24lambda_u240);
    }

    public static final boolean isPrimaryPath() {
        return DownloadStoragePreference.INSTANCE.getPreferredStorageType() == StorageType.PRIMARY;
    }

    public static final boolean isNetworkConnect() {
        return KReachabilityKt.getKReachability().isReachable();
    }

    public static final boolean hideExternalSdcard() {
        return DeviceDecisionHelper_androidKt.checkIfHideExternalSdcard();
    }
}