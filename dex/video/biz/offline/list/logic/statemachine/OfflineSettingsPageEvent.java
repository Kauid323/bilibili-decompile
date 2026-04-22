package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.model.StorageType;

/* compiled from: OfflineSettingsPageStore.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent;", "", "ToggleAutoResumptionSwitch", "ClickOfflineDiagnose", "ClickExternalSDDiagnose", "ChangeStorageType", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent$ChangeStorageType;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent$ClickExternalSDDiagnose;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent$ClickOfflineDiagnose;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent$ToggleAutoResumptionSwitch;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OfflineSettingsPageEvent {

    /* compiled from: OfflineSettingsPageStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent$ToggleAutoResumptionSwitch;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ToggleAutoResumptionSwitch implements OfflineSettingsPageEvent {
        public static final int $stable = 0;
        public static final ToggleAutoResumptionSwitch INSTANCE = new ToggleAutoResumptionSwitch();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ToggleAutoResumptionSwitch) {
                ToggleAutoResumptionSwitch toggleAutoResumptionSwitch = (ToggleAutoResumptionSwitch) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1530672347;
        }

        public String toString() {
            return "ToggleAutoResumptionSwitch";
        }

        private ToggleAutoResumptionSwitch() {
        }
    }

    /* compiled from: OfflineSettingsPageStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent$ClickOfflineDiagnose;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ClickOfflineDiagnose implements OfflineSettingsPageEvent {
        public static final int $stable = 0;
        public static final ClickOfflineDiagnose INSTANCE = new ClickOfflineDiagnose();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClickOfflineDiagnose) {
                ClickOfflineDiagnose clickOfflineDiagnose = (ClickOfflineDiagnose) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 417337873;
        }

        public String toString() {
            return "ClickOfflineDiagnose";
        }

        private ClickOfflineDiagnose() {
        }
    }

    /* compiled from: OfflineSettingsPageStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent$ClickExternalSDDiagnose;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ClickExternalSDDiagnose implements OfflineSettingsPageEvent {
        public static final int $stable = 0;
        public static final ClickExternalSDDiagnose INSTANCE = new ClickExternalSDDiagnose();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClickExternalSDDiagnose) {
                ClickExternalSDDiagnose clickExternalSDDiagnose = (ClickExternalSDDiagnose) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1720642070;
        }

        public String toString() {
            return "ClickExternalSDDiagnose";
        }

        private ClickExternalSDDiagnose() {
        }
    }

    /* compiled from: OfflineSettingsPageStore.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent$ChangeStorageType;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent;", "type", "Lvideo/biz/offline/base/model/model/StorageType;", "<init>", "(Lvideo/biz/offline/base/model/model/StorageType;)V", "getType", "()Lvideo/biz/offline/base/model/model/StorageType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ChangeStorageType implements OfflineSettingsPageEvent {
        public static final int $stable = 0;
        private final StorageType type;

        public static /* synthetic */ ChangeStorageType copy$default(ChangeStorageType changeStorageType, StorageType storageType, int i, Object obj) {
            if ((i & 1) != 0) {
                storageType = changeStorageType.type;
            }
            return changeStorageType.copy(storageType);
        }

        public final StorageType component1() {
            return this.type;
        }

        public final ChangeStorageType copy(StorageType storageType) {
            Intrinsics.checkNotNullParameter(storageType, "type");
            return new ChangeStorageType(storageType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ChangeStorageType) && this.type == ((ChangeStorageType) obj).type;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "ChangeStorageType(type=" + this.type + ")";
        }

        public ChangeStorageType(StorageType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public final StorageType getType() {
            return this.type;
        }
    }
}