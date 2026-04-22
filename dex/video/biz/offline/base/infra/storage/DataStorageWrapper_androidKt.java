package video.biz.offline.base.infra.storage;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.EntryWriterKt;

/* compiled from: DataStorageWrapper.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"cleanInvalidSource", "", "keys", "", "", "snapshotTime", "", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DataStorageWrapper_androidKt {
    public static final boolean cleanInvalidSource(Set<String> set, long snapshotTime) {
        Intrinsics.checkNotNullParameter(set, "keys");
        return EntryWriterKt.checkAndCleanInvalidSource(set, snapshotTime);
    }
}