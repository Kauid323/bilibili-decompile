package video.biz.offline.base.infra.utils;

import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.model.StorageType;
import video.interfacee.bridge.settings.KDownloadSettingsKt;

/* compiled from: StorageHelper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lvideo/biz/offline/base/infra/utils/DownloadStoragePreference;", "", "<init>", "()V", "getPreferredStorageType", "Lvideo/biz/offline/base/model/model/StorageType;", "setPreferredStorageType", "", "type", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DownloadStoragePreference {
    public static final int $stable = 0;
    public static final DownloadStoragePreference INSTANCE = new DownloadStoragePreference();

    /* compiled from: StorageHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StorageType.values().length];
            try {
                iArr[StorageType.SECONDARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private DownloadStoragePreference() {
    }

    public final StorageType getPreferredStorageType() {
        String preferredStorageType = KDownloadSettingsKt.getKDownloadSettings().getPreferredStorageType(FoundationAlias.getFapp());
        if (Intrinsics.areEqual(preferredStorageType, "1")) {
            return StorageType.PRIMARY;
        }
        if (Intrinsics.areEqual(preferredStorageType, "2")) {
            if (DeviceDecisionHelper_androidKt.checkIfHideExternalSdcard()) {
                return StorageType.PRIMARY;
            }
            return StorageType.SECONDARY;
        }
        return StorageType.PRIMARY;
    }

    public final void setPreferredStorageType(StorageType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        KDownloadSettingsKt.getKDownloadSettings().setPreferredStorageType(FoundationAlias.getFapp(), WhenMappings.$EnumSwitchMapping$0[type.ordinal()] == 1 ? "2" : "1");
    }
}