package video.biz.offline.base.model.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.utils.VBNumberExtKt;

/* compiled from: StorageInfoModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J;\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010,\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u0011\u0010 \u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b!\u0010\u0011R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u00061"}, d2 = {"Lvideo/biz/offline/base/model/model/StorageInfoModel;", "", "storageType", "Lvideo/biz/offline/base/model/model/StorageType;", "storagePath", "", "totalSpace", "", "availableSpace", "usedSpace", "<init>", "(Lvideo/biz/offline/base/model/model/StorageType;Ljava/lang/String;JJJ)V", "getStorageType", "()Lvideo/biz/offline/base/model/model/StorageType;", "setStorageType", "(Lvideo/biz/offline/base/model/model/StorageType;)V", "getStoragePath", "()Ljava/lang/String;", "setStoragePath", "(Ljava/lang/String;)V", "getTotalSpace", "()J", "setTotalSpace", "(J)V", "getAvailableSpace", "setAvailableSpace", "getUsedSpace", "setUsedSpace", "usedSpaceDesc", "getUsedSpaceDesc", "availableSpaceDesc", "getAvailableSpaceDesc", "totalSpaceDesc", "getTotalSpaceDesc", "showStorageUsage", "", "getShowStorageUsage", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class StorageInfoModel {
    public static final int $stable = 8;
    private long availableSpace;
    private String storagePath;
    private StorageType storageType;
    private long totalSpace;
    private long usedSpace;

    public StorageInfoModel() {
        this(null, null, 0L, 0L, 0L, 31, null);
    }

    public final StorageType component1() {
        return this.storageType;
    }

    public final String component2() {
        return this.storagePath;
    }

    public final long component3() {
        return this.totalSpace;
    }

    public final long component4() {
        return this.availableSpace;
    }

    public final long component5() {
        return this.usedSpace;
    }

    public final StorageInfoModel copy(StorageType storageType, String str, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(storageType, "storageType");
        Intrinsics.checkNotNullParameter(str, "storagePath");
        return new StorageInfoModel(storageType, str, j, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StorageInfoModel) {
            StorageInfoModel storageInfoModel = (StorageInfoModel) obj;
            return this.storageType == storageInfoModel.storageType && Intrinsics.areEqual(this.storagePath, storageInfoModel.storagePath) && this.totalSpace == storageInfoModel.totalSpace && this.availableSpace == storageInfoModel.availableSpace && this.usedSpace == storageInfoModel.usedSpace;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.storageType.hashCode() * 31) + this.storagePath.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.totalSpace)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.availableSpace)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.usedSpace);
    }

    public String toString() {
        StorageType storageType = this.storageType;
        String str = this.storagePath;
        long j = this.totalSpace;
        long j2 = this.availableSpace;
        return "StorageInfoModel(storageType=" + storageType + ", storagePath=" + str + ", totalSpace=" + j + ", availableSpace=" + j2 + ", usedSpace=" + this.usedSpace + ")";
    }

    public StorageInfoModel(StorageType storageType, String storagePath, long totalSpace, long availableSpace, long usedSpace) {
        Intrinsics.checkNotNullParameter(storageType, "storageType");
        Intrinsics.checkNotNullParameter(storagePath, "storagePath");
        this.storageType = storageType;
        this.storagePath = storagePath;
        this.totalSpace = totalSpace;
        this.availableSpace = availableSpace;
        this.usedSpace = usedSpace;
    }

    public /* synthetic */ StorageInfoModel(StorageType storageType, String str, long j, long j2, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StorageType.PRIMARY : storageType, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? 0L : j2, (i & 16) == 0 ? j3 : 0L);
    }

    public final StorageType getStorageType() {
        return this.storageType;
    }

    public final void setStorageType(StorageType storageType) {
        Intrinsics.checkNotNullParameter(storageType, "<set-?>");
        this.storageType = storageType;
    }

    public final String getStoragePath() {
        return this.storagePath;
    }

    public final void setStoragePath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.storagePath = str;
    }

    public final long getTotalSpace() {
        return this.totalSpace;
    }

    public final void setTotalSpace(long j) {
        this.totalSpace = j;
    }

    public final long getAvailableSpace() {
        return this.availableSpace;
    }

    public final void setAvailableSpace(long j) {
        this.availableSpace = j;
    }

    public final long getUsedSpace() {
        return this.usedSpace;
    }

    public final void setUsedSpace(long j) {
        this.usedSpace = j;
    }

    public final String getUsedSpaceDesc() {
        return VBNumberExtKt.toFileSize(this.usedSpace);
    }

    public final String getAvailableSpaceDesc() {
        return VBNumberExtKt.toFileSize(this.availableSpace);
    }

    public final String getTotalSpaceDesc() {
        return VBNumberExtKt.toFileSize(this.totalSpace);
    }

    public final boolean getShowStorageUsage() {
        return this.usedSpace > 0;
    }
}