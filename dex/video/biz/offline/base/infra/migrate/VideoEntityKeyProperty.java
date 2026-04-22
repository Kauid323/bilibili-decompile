package video.biz.offline.base.infra.migrate;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MigrationValidateHelper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/VideoEntityKeyProperty;", "", "key", "", "<init>", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoEntityKeyProperty {
    public static final int $stable = 0;
    private final String key;

    public static /* synthetic */ VideoEntityKeyProperty copy$default(VideoEntityKeyProperty videoEntityKeyProperty, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoEntityKeyProperty.key;
        }
        return videoEntityKeyProperty.copy(str);
    }

    public final String component1() {
        return this.key;
    }

    public final VideoEntityKeyProperty copy(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return new VideoEntityKeyProperty(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VideoEntityKeyProperty) && Intrinsics.areEqual(this.key, ((VideoEntityKeyProperty) obj).key);
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return "VideoEntityKeyProperty(key=" + this.key + ")";
    }

    public VideoEntityKeyProperty(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
    }

    public final String getKey() {
        return this.key;
    }
}