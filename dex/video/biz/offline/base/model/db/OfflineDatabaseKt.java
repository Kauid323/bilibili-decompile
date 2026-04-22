package video.biz.offline.base.model.db;

import androidx.room.RoomDatabase;
import androidx.sqlite.driver.bundled.BundledSQLiteDriver;
import kntr.base.config.KConfig;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;

/* compiled from: OfflineDatabase.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"DB_FILE", "", "offlineDB", "Lvideo/biz/offline/base/model/db/AppDatabase;", "getOfflineDB", "()Lvideo/biz/offline/base/model/db/AppDatabase;", "offlineDB$delegate", "Lkotlin/Lazy;", "parallelismFixFallback", "", "getParallelismFixFallback", "()Z", "parallelismFixFallback$delegate", "model_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineDatabaseKt {
    public static final String DB_FILE = "offlineVideo.db";
    private static final Lazy offlineDB$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.model.db.OfflineDatabaseKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            AppDatabase offlineDB_delegate$lambda$0;
            offlineDB_delegate$lambda$0 = OfflineDatabaseKt.offlineDB_delegate$lambda$0();
            return offlineDB_delegate$lambda$0;
        }
    });
    private static final Lazy parallelismFixFallback$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.model.db.OfflineDatabaseKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            boolean parallelismFixFallback_delegate$lambda$0;
            parallelismFixFallback_delegate$lambda$0 = OfflineDatabaseKt.parallelismFixFallback_delegate$lambda$0();
            return Boolean.valueOf(parallelismFixFallback_delegate$lambda$0);
        }
    });

    public static final AppDatabase getOfflineDB() {
        return (AppDatabase) offlineDB$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppDatabase offlineDB_delegate$lambda$0() {
        CoroutineDispatcher limitedParallelism;
        RoomDatabase.Builder driver = OfflineDatabase_androidKt.getDatabaseBuilder().fallbackToDestructiveMigrationOnDowngrade(true).setDriver(new BundledSQLiteDriver());
        if (getParallelismFixFallback()) {
            limitedParallelism = CoroutineExJvmKt.getIoContext();
        } else {
            limitedParallelism = CoroutineExJvmKt.getIoContext().limitedParallelism(5);
        }
        return (AppDatabase) driver.setQueryCoroutineContext((CoroutineContext) limitedParallelism).build();
    }

    public static final boolean getParallelismFixFallback() {
        return ((Boolean) parallelismFixFallback$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parallelismFixFallback_delegate$lambda$0() {
        boolean it = KConfig.INSTANCE.ff("ff_offline_parallelism_fix_fallback", false);
        LogKt.getVBLog().info("ff_offline_parallelism_fix_fallback=" + it);
        return it;
    }
}