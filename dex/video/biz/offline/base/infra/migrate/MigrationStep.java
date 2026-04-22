package video.biz.offline.base.infra.migrate;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IMigrateHandler.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "MONITOR", "TIMEOUT", "RETRY", "PRE_CHECK", "DRAMA", "VIDEO", "VALIDATE", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum MigrationStep {
    IDLE,
    MONITOR,
    TIMEOUT,
    RETRY,
    PRE_CHECK,
    DRAMA,
    VIDEO,
    VALIDATE;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<MigrationStep> getEntries() {
        return $ENTRIES;
    }
}