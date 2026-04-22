package video.biz.offline.list.logic.statemachine;

import BottomSheetItemData$;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.storage.StorageInfoImpl_androidKt;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.base.model.model.StorageInfoModel;
import video.biz.offline.base.model.model.StorageType;

/* compiled from: OfflineSettingsPageStore.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState;", "", "Loading", "Ready", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState$Loading;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState$Ready;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OfflineSettingsPageState {

    /* compiled from: OfflineSettingsPageStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState$Loading;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Loading implements OfflineSettingsPageState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Loading) {
                Loading loading = (Loading) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1057667781;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
        }
    }

    /* compiled from: OfflineSettingsPageStore.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState$Ready;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState;", "isAutoResumption", "", "storageType", "Lvideo/biz/offline/base/model/model/StorageType;", "storageInfoList", "", "Lvideo/biz/offline/base/model/model/StorageInfoModel;", "<init>", "(ZLvideo/biz/offline/base/model/model/StorageType;Ljava/util/List;)V", "()Z", "getStorageType", "()Lvideo/biz/offline/base/model/model/StorageType;", "getStorageInfoList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Ready implements OfflineSettingsPageState {
        public static final int $stable = 8;
        private final boolean isAutoResumption;
        private final List<StorageInfoModel> storageInfoList;
        private final StorageType storageType;

        public Ready() {
            this(false, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Ready copy$default(Ready ready, boolean z, StorageType storageType, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                z = ready.isAutoResumption;
            }
            if ((i & 2) != 0) {
                storageType = ready.storageType;
            }
            if ((i & 4) != 0) {
                list = ready.storageInfoList;
            }
            return ready.copy(z, storageType, list);
        }

        public final boolean component1() {
            return this.isAutoResumption;
        }

        public final StorageType component2() {
            return this.storageType;
        }

        public final List<StorageInfoModel> component3() {
            return this.storageInfoList;
        }

        public final Ready copy(boolean z, StorageType storageType, List<StorageInfoModel> list) {
            Intrinsics.checkNotNullParameter(storageType, "storageType");
            Intrinsics.checkNotNullParameter(list, "storageInfoList");
            return new Ready(z, storageType, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Ready) {
                Ready ready = (Ready) obj;
                return this.isAutoResumption == ready.isAutoResumption && this.storageType == ready.storageType && Intrinsics.areEqual(this.storageInfoList, ready.storageInfoList);
            }
            return false;
        }

        public int hashCode() {
            return (((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAutoResumption) * 31) + this.storageType.hashCode()) * 31) + this.storageInfoList.hashCode();
        }

        public String toString() {
            boolean z = this.isAutoResumption;
            StorageType storageType = this.storageType;
            return "Ready(isAutoResumption=" + z + ", storageType=" + storageType + ", storageInfoList=" + this.storageInfoList + ")";
        }

        public Ready(boolean isAutoResumption, StorageType storageType, List<StorageInfoModel> list) {
            Intrinsics.checkNotNullParameter(storageType, "storageType");
            Intrinsics.checkNotNullParameter(list, "storageInfoList");
            this.isAutoResumption = isAutoResumption;
            this.storageType = storageType;
            this.storageInfoList = list;
        }

        public /* synthetic */ Ready(boolean z, StorageType storageType, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Config.Companion.getAutoResumption() : z, (i & 2) != 0 ? StorageInfoImpl_androidKt.getPreferredStorageType() : storageType, (i & 4) != 0 ? StorageInfoImpl_androidKt.getStorageInfoList(false) : list);
        }

        public final boolean isAutoResumption() {
            return this.isAutoResumption;
        }

        public final StorageType getStorageType() {
            return this.storageType;
        }

        public final List<StorageInfoModel> getStorageInfoList() {
            return this.storageInfoList;
        }
    }
}