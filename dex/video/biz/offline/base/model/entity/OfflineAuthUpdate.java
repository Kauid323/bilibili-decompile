package video.biz.offline.base.model.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineAuthUpdate.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lvideo/biz/offline/base/model/entity/OfflineAuthUpdate;", "", "key", "", "code", "", "<init>", "(Ljava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getCode", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineAuthUpdate {
    public static final int $stable = 0;
    private final int code;
    private final String key;

    public static /* synthetic */ OfflineAuthUpdate copy$default(OfflineAuthUpdate offlineAuthUpdate, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = offlineAuthUpdate.key;
        }
        if ((i2 & 2) != 0) {
            i = offlineAuthUpdate.code;
        }
        return offlineAuthUpdate.copy(str, i);
    }

    public final String component1() {
        return this.key;
    }

    public final int component2() {
        return this.code;
    }

    public final OfflineAuthUpdate copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        return new OfflineAuthUpdate(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfflineAuthUpdate) {
            OfflineAuthUpdate offlineAuthUpdate = (OfflineAuthUpdate) obj;
            return Intrinsics.areEqual(this.key, offlineAuthUpdate.key) && this.code == offlineAuthUpdate.code;
        }
        return false;
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + this.code;
    }

    public String toString() {
        String str = this.key;
        return "OfflineAuthUpdate(key=" + str + ", code=" + this.code + ")";
    }

    public OfflineAuthUpdate(String key, int code) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.code = code;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getCode() {
        return this.code;
    }
}