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

/* compiled from: MigrationValidateHandler.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/MigrationValidateHandler;", "Lvideo/biz/offline/base/infra/migrate/IMigrateHandler;", "<init>", "()V", "step", "Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "getStep", "()Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "doHandle", "Lvideo/biz/offline/base/infra/migrate/MigrationResult;", "chain", "Lvideo/biz/offline/base/infra/migrate/MigrationChain;", "(Lvideo/biz/offline/base/infra/migrate/MigrationChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MigrationValidateHandler implements IMigrateHandler {
    public static final int $stable = 0;
    private final MigrationStep step = MigrationStep.VALIDATE;

    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    public MigrationStep getStep() {
        return this.step;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0132  */
    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doHandle(MigrationChain chain, Continuation<? super MigrationResult> continuation) {
        MigrationValidateHandler$doHandle$1 migrationValidateHandler$doHandle$1;
        OfflineVideoDao videoDao;
        Object all;
        AppDatabase db;
        List cachedVideos;
        boolean result;
        List dbVideos;
        boolean result2;
        OfflineVideoDao videoDao2;
        try {
            try {
                if (continuation instanceof MigrationValidateHandler$doHandle$1) {
                    migrationValidateHandler$doHandle$1 = (MigrationValidateHandler$doHandle$1) continuation;
                    if ((migrationValidateHandler$doHandle$1.label & Integer.MIN_VALUE) != 0) {
                        migrationValidateHandler$doHandle$1.label -= Integer.MIN_VALUE;
                        Object $result = migrationValidateHandler$doHandle$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (migrationValidateHandler$doHandle$1.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                new DataLog().info("MigrationValidateHandler start to validate.");
                                AppDatabase db2 = chain.getContext().getDb();
                                videoDao = db2.videoDao();
                                List cachedVideos2 = chain.getContext().getCachedVideos();
                                migrationValidateHandler$doHandle$1.L$0 = chain;
                                migrationValidateHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(db2);
                                migrationValidateHandler$doHandle$1.L$2 = videoDao;
                                migrationValidateHandler$doHandle$1.L$3 = cachedVideos2;
                                migrationValidateHandler$doHandle$1.label = 1;
                                all = videoDao.getAll(migrationValidateHandler$doHandle$1);
                                if (all != coroutine_suspended) {
                                    db = db2;
                                    cachedVideos = cachedVideos2;
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            case 1:
                                List<OfflineVideoEntity> list = (List) migrationValidateHandler$doHandle$1.L$3;
                                videoDao = (OfflineVideoDao) migrationValidateHandler$doHandle$1.L$2;
                                AppDatabase db3 = (AppDatabase) migrationValidateHandler$doHandle$1.L$1;
                                chain = (MigrationChain) migrationValidateHandler$doHandle$1.L$0;
                                ResultKt.throwOnFailure($result);
                                all = $result;
                                db = db3;
                                cachedVideos = list;
                                break;
                            case 2:
                                result2 = migrationValidateHandler$doHandle$1.Z$0;
                                dbVideos = (List) migrationValidateHandler$doHandle$1.L$4;
                                cachedVideos = (List) migrationValidateHandler$doHandle$1.L$3;
                                videoDao2 = (OfflineVideoDao) migrationValidateHandler$doHandle$1.L$2;
                                db = (AppDatabase) migrationValidateHandler$doHandle$1.L$1;
                                chain = (MigrationChain) migrationValidateHandler$doHandle$1.L$0;
                                ResultKt.throwOnFailure($result);
                                new DataLog().info("MigrationValidateHandler clear all records");
                                if (!result2) {
                                    MigrationException error = new MigrationException(DataErrorType.MIGRATION_END_NOT_SAME.getCode(), DataErrorType.MIGRATION_END_NOT_SAME.getTrackMsg());
                                    return new MigrationResult.Failure(error);
                                }
                                migrationValidateHandler$doHandle$1.L$0 = SpillingKt.nullOutSpilledVariable(chain);
                                migrationValidateHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(db);
                                migrationValidateHandler$doHandle$1.L$2 = SpillingKt.nullOutSpilledVariable(videoDao2);
                                migrationValidateHandler$doHandle$1.L$3 = SpillingKt.nullOutSpilledVariable(cachedVideos);
                                migrationValidateHandler$doHandle$1.L$4 = SpillingKt.nullOutSpilledVariable(dbVideos);
                                migrationValidateHandler$doHandle$1.Z$0 = result2;
                                migrationValidateHandler$doHandle$1.label = 3;
                                Object proceed = chain.proceed(migrationValidateHandler$doHandle$1);
                                return proceed == coroutine_suspended ? coroutine_suspended : proceed;
                            case 3:
                                boolean z = migrationValidateHandler$doHandle$1.Z$0;
                                List list2 = (List) migrationValidateHandler$doHandle$1.L$4;
                                List list3 = (List) migrationValidateHandler$doHandle$1.L$3;
                                OfflineVideoDao offlineVideoDao = (OfflineVideoDao) migrationValidateHandler$doHandle$1.L$2;
                                AppDatabase appDatabase = (AppDatabase) migrationValidateHandler$doHandle$1.L$1;
                                MigrationChain migrationChain = (MigrationChain) migrationValidateHandler$doHandle$1.L$0;
                                ResultKt.throwOnFailure($result);
                                return $result;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        List dbVideos2 = (List) all;
                        result = MigrationValidateHelperKt.validateVideos(cachedVideos, dbVideos2);
                        new DataLog().info("MigrationValidateHandler validate result: " + result);
                        if (result) {
                            migrationValidateHandler$doHandle$1.L$0 = chain;
                            migrationValidateHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(db);
                            migrationValidateHandler$doHandle$1.L$2 = SpillingKt.nullOutSpilledVariable(videoDao);
                            migrationValidateHandler$doHandle$1.L$3 = SpillingKt.nullOutSpilledVariable(cachedVideos);
                            migrationValidateHandler$doHandle$1.L$4 = SpillingKt.nullOutSpilledVariable(dbVideos2);
                            migrationValidateHandler$doHandle$1.Z$0 = result;
                            migrationValidateHandler$doHandle$1.label = 2;
                            if (videoDao.deleteAll(migrationValidateHandler$doHandle$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            OfflineVideoDao offlineVideoDao2 = videoDao;
                            dbVideos = dbVideos2;
                            result2 = result;
                            videoDao2 = offlineVideoDao2;
                            new DataLog().info("MigrationValidateHandler clear all records");
                            if (!result2) {
                            }
                        } else {
                            OfflineVideoDao offlineVideoDao3 = videoDao;
                            dbVideos = dbVideos2;
                            result2 = result;
                            videoDao2 = offlineVideoDao3;
                            if (!result2) {
                            }
                        }
                    }
                }
                List dbVideos22 = (List) all;
                result = MigrationValidateHelperKt.validateVideos(cachedVideos, dbVideos22);
                new DataLog().info("MigrationValidateHandler validate result: " + result);
                if (result) {
                }
            } catch (Throwable th) {
                e = th;
                new DataLog().error("MigrationValidateHandler get db video records failed: " + e);
                MigrationException error2 = new MigrationException(DataErrorType.MIGRATION_DB_READ_ERROR.getCode(), DataErrorType.MIGRATION_DB_READ_ERROR.getTrackMsg());
                return new MigrationResult.Failure(error2);
            }
            switch (migrationValidateHandler$doHandle$1.label) {
            }
        } catch (Throwable th2) {
            e = th2;
        }
        migrationValidateHandler$doHandle$1 = new MigrationValidateHandler$doHandle$1(this, continuation);
        Object $result2 = migrationValidateHandler$doHandle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}