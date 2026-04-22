package video.biz.offline.base.infra.migrate;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.migrate.MigrationResult;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.model.dao.OfflineVideoDao;
import video.biz.offline.base.model.db.AppDatabase;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.error.DataErrorType;
import video.biz.offline.base.model.error.MigrationException;

/* compiled from: MigrationVideoHandler.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/MigrationVideoHandler;", "Lvideo/biz/offline/base/infra/migrate/IMigrateHandler;", "<init>", "()V", "step", "Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "getStep", "()Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "doHandle", "Lvideo/biz/offline/base/infra/migrate/MigrationResult;", "chain", "Lvideo/biz/offline/base/infra/migrate/MigrationChain;", "(Lvideo/biz/offline/base/infra/migrate/MigrationChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MigrationVideoHandler implements IMigrateHandler {
    public static final int $stable = 0;
    private final MigrationStep step = MigrationStep.VIDEO;

    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    public MigrationStep getStep() {
        return this.step;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0142 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0190  */
    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doHandle(MigrationChain chain, Continuation<? super MigrationResult> continuation) {
        MigrationVideoHandler$doHandle$1 migrationVideoHandler$doHandle$1;
        Object all;
        OfflineVideoDao entityDao;
        AppDatabase db;
        List<OfflineVideoEntity> list;
        List dbEntities;
        AppDatabase db2;
        List dbEntities2;
        try {
            try {
                if (continuation instanceof MigrationVideoHandler$doHandle$1) {
                    migrationVideoHandler$doHandle$1 = (MigrationVideoHandler$doHandle$1) continuation;
                    if ((migrationVideoHandler$doHandle$1.label & Integer.MIN_VALUE) != 0) {
                        migrationVideoHandler$doHandle$1.label -= Integer.MIN_VALUE;
                        Object $result = migrationVideoHandler$doHandle$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (migrationVideoHandler$doHandle$1.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                AppDatabase db3 = chain.getContext().getDb();
                                List<OfflineVideoEntity> cachedVideos = chain.getContext().getCachedVideos();
                                new DataLog().info("MigrationVideoHandler start to migrate video data size:" + cachedVideos.size() + " videos: " + cachedVideos);
                                OfflineVideoDao entityDao2 = db3.videoDao();
                                migrationVideoHandler$doHandle$1.L$0 = chain;
                                migrationVideoHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(db3);
                                migrationVideoHandler$doHandle$1.L$2 = cachedVideos;
                                migrationVideoHandler$doHandle$1.L$3 = entityDao2;
                                migrationVideoHandler$doHandle$1.label = 1;
                                all = entityDao2.getAll(migrationVideoHandler$doHandle$1);
                                if (all == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                entityDao = entityDao2;
                                db = db3;
                                list = cachedVideos;
                                try {
                                    dbEntities = (List) all;
                                    if (dbEntities.isEmpty()) {
                                        migrationVideoHandler$doHandle$1.L$0 = chain;
                                        migrationVideoHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(db);
                                        migrationVideoHandler$doHandle$1.L$2 = list;
                                        migrationVideoHandler$doHandle$1.L$3 = entityDao;
                                        migrationVideoHandler$doHandle$1.L$4 = SpillingKt.nullOutSpilledVariable(dbEntities);
                                        migrationVideoHandler$doHandle$1.label = 2;
                                        if (entityDao.deleteAll(migrationVideoHandler$doHandle$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        db2 = db;
                                        dbEntities2 = dbEntities;
                                    } else {
                                        db2 = db;
                                        dbEntities2 = dbEntities;
                                    }
                                    migrationVideoHandler$doHandle$1.L$0 = chain;
                                    migrationVideoHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(db2);
                                    migrationVideoHandler$doHandle$1.L$2 = list;
                                    migrationVideoHandler$doHandle$1.L$3 = SpillingKt.nullOutSpilledVariable(entityDao);
                                    migrationVideoHandler$doHandle$1.L$4 = SpillingKt.nullOutSpilledVariable(dbEntities2);
                                    migrationVideoHandler$doHandle$1.label = 3;
                                    if (entityDao.insert(list, migrationVideoHandler$doHandle$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    new DataLog().info("MigrationVideoHandler write [" + list.size() + "] videos to database.");
                                    migrationVideoHandler$doHandle$1.L$0 = SpillingKt.nullOutSpilledVariable(chain);
                                    migrationVideoHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(db2);
                                    migrationVideoHandler$doHandle$1.L$2 = SpillingKt.nullOutSpilledVariable(list);
                                    migrationVideoHandler$doHandle$1.L$3 = SpillingKt.nullOutSpilledVariable(entityDao);
                                    migrationVideoHandler$doHandle$1.L$4 = SpillingKt.nullOutSpilledVariable(dbEntities2);
                                    migrationVideoHandler$doHandle$1.label = 4;
                                    Object proceed = chain.proceed(migrationVideoHandler$doHandle$1);
                                    return proceed != coroutine_suspended ? coroutine_suspended : proceed;
                                } catch (Throwable th) {
                                    e = th;
                                    new DataLog().error("MigrationVideoHandler get db video records failed: " + e);
                                    MigrationException error = new MigrationException(DataErrorType.MIGRATION_DB_READ_ERROR.getCode(), DataErrorType.MIGRATION_DB_READ_ERROR.getTrackMsg());
                                    return new MigrationResult.Failure(error);
                                }
                            case 1:
                                OfflineVideoDao entityDao3 = (OfflineVideoDao) migrationVideoHandler$doHandle$1.L$3;
                                List<OfflineVideoEntity> list2 = (List) migrationVideoHandler$doHandle$1.L$2;
                                AppDatabase db4 = (AppDatabase) migrationVideoHandler$doHandle$1.L$1;
                                chain = (MigrationChain) migrationVideoHandler$doHandle$1.L$0;
                                ResultKt.throwOnFailure($result);
                                all = $result;
                                entityDao = entityDao3;
                                db = db4;
                                list = list2;
                                dbEntities = (List) all;
                                if (dbEntities.isEmpty()) {
                                }
                                migrationVideoHandler$doHandle$1.L$0 = chain;
                                migrationVideoHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(db2);
                                migrationVideoHandler$doHandle$1.L$2 = list;
                                migrationVideoHandler$doHandle$1.L$3 = SpillingKt.nullOutSpilledVariable(entityDao);
                                migrationVideoHandler$doHandle$1.L$4 = SpillingKt.nullOutSpilledVariable(dbEntities2);
                                migrationVideoHandler$doHandle$1.label = 3;
                                if (entityDao.insert(list, migrationVideoHandler$doHandle$1) == coroutine_suspended) {
                                }
                                new DataLog().info("MigrationVideoHandler write [" + list.size() + "] videos to database.");
                                migrationVideoHandler$doHandle$1.L$0 = SpillingKt.nullOutSpilledVariable(chain);
                                migrationVideoHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(db2);
                                migrationVideoHandler$doHandle$1.L$2 = SpillingKt.nullOutSpilledVariable(list);
                                migrationVideoHandler$doHandle$1.L$3 = SpillingKt.nullOutSpilledVariable(entityDao);
                                migrationVideoHandler$doHandle$1.L$4 = SpillingKt.nullOutSpilledVariable(dbEntities2);
                                migrationVideoHandler$doHandle$1.label = 4;
                                Object proceed2 = chain.proceed(migrationVideoHandler$doHandle$1);
                                if (proceed2 != coroutine_suspended) {
                                }
                                break;
                            case 2:
                                dbEntities2 = (List) migrationVideoHandler$doHandle$1.L$4;
                                entityDao = (OfflineVideoDao) migrationVideoHandler$doHandle$1.L$3;
                                list = (List) migrationVideoHandler$doHandle$1.L$2;
                                db2 = (AppDatabase) migrationVideoHandler$doHandle$1.L$1;
                                chain = (MigrationChain) migrationVideoHandler$doHandle$1.L$0;
                                ResultKt.throwOnFailure($result);
                                migrationVideoHandler$doHandle$1.L$0 = chain;
                                migrationVideoHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(db2);
                                migrationVideoHandler$doHandle$1.L$2 = list;
                                migrationVideoHandler$doHandle$1.L$3 = SpillingKt.nullOutSpilledVariable(entityDao);
                                migrationVideoHandler$doHandle$1.L$4 = SpillingKt.nullOutSpilledVariable(dbEntities2);
                                migrationVideoHandler$doHandle$1.label = 3;
                                if (entityDao.insert(list, migrationVideoHandler$doHandle$1) == coroutine_suspended) {
                                }
                                new DataLog().info("MigrationVideoHandler write [" + list.size() + "] videos to database.");
                                migrationVideoHandler$doHandle$1.L$0 = SpillingKt.nullOutSpilledVariable(chain);
                                migrationVideoHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(db2);
                                migrationVideoHandler$doHandle$1.L$2 = SpillingKt.nullOutSpilledVariable(list);
                                migrationVideoHandler$doHandle$1.L$3 = SpillingKt.nullOutSpilledVariable(entityDao);
                                migrationVideoHandler$doHandle$1.L$4 = SpillingKt.nullOutSpilledVariable(dbEntities2);
                                migrationVideoHandler$doHandle$1.label = 4;
                                Object proceed22 = chain.proceed(migrationVideoHandler$doHandle$1);
                                if (proceed22 != coroutine_suspended) {
                                }
                                break;
                            case 3:
                                dbEntities2 = (List) migrationVideoHandler$doHandle$1.L$4;
                                entityDao = (OfflineVideoDao) migrationVideoHandler$doHandle$1.L$3;
                                list = (List) migrationVideoHandler$doHandle$1.L$2;
                                db2 = (AppDatabase) migrationVideoHandler$doHandle$1.L$1;
                                chain = (MigrationChain) migrationVideoHandler$doHandle$1.L$0;
                                ResultKt.throwOnFailure($result);
                                new DataLog().info("MigrationVideoHandler write [" + list.size() + "] videos to database.");
                                migrationVideoHandler$doHandle$1.L$0 = SpillingKt.nullOutSpilledVariable(chain);
                                migrationVideoHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(db2);
                                migrationVideoHandler$doHandle$1.L$2 = SpillingKt.nullOutSpilledVariable(list);
                                migrationVideoHandler$doHandle$1.L$3 = SpillingKt.nullOutSpilledVariable(entityDao);
                                migrationVideoHandler$doHandle$1.L$4 = SpillingKt.nullOutSpilledVariable(dbEntities2);
                                migrationVideoHandler$doHandle$1.label = 4;
                                Object proceed222 = chain.proceed(migrationVideoHandler$doHandle$1);
                                if (proceed222 != coroutine_suspended) {
                                }
                                break;
                            case 4:
                                List list3 = (List) migrationVideoHandler$doHandle$1.L$4;
                                OfflineVideoDao offlineVideoDao = (OfflineVideoDao) migrationVideoHandler$doHandle$1.L$3;
                                List list4 = (List) migrationVideoHandler$doHandle$1.L$2;
                                AppDatabase appDatabase = (AppDatabase) migrationVideoHandler$doHandle$1.L$1;
                                MigrationChain migrationChain = (MigrationChain) migrationVideoHandler$doHandle$1.L$0;
                                ResultKt.throwOnFailure($result);
                                return $result;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                switch (migrationVideoHandler$doHandle$1.label) {
                }
            } catch (Throwable e) {
                new DataLog().error("MigrationVideoHandler write db video [" + list.size() + "]  failed: " + e);
                MigrationException error2 = new MigrationException(DataErrorType.MIGRATION_DB_WRITE_ERROR.getCode(), DataErrorType.MIGRATION_DB_WRITE_ERROR.getTrackMsg());
                return new MigrationResult.Failure(error2);
            }
        } catch (Throwable th2) {
            e = th2;
        }
        migrationVideoHandler$doHandle$1 = new MigrationVideoHandler$doHandle$1(this, continuation);
        Object $result2 = migrationVideoHandler$doHandle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}