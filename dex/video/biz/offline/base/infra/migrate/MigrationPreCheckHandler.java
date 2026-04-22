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
import video.biz.offline.base.model.error.DataErrorType;
import video.biz.offline.base.model.error.MigrationException;

/* compiled from: MigrationPreCheckHandler.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/MigrationPreCheckHandler;", "Lvideo/biz/offline/base/infra/migrate/IMigrateHandler;", "<init>", "()V", "step", "Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "getStep", "()Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "doHandle", "Lvideo/biz/offline/base/infra/migrate/MigrationResult;", "chain", "Lvideo/biz/offline/base/infra/migrate/MigrationChain;", "(Lvideo/biz/offline/base/infra/migrate/MigrationChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MigrationPreCheckHandler implements IMigrateHandler {
    public static final int $stable = 0;
    private final MigrationStep step = MigrationStep.PRE_CHECK;

    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    public MigrationStep getStep() {
        return this.step;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0127 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0128  */
    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doHandle(MigrationChain chain, Continuation<? super MigrationResult> continuation) {
        MigrationPreCheckHandler$doHandle$1 migrationPreCheckHandler$doHandle$1;
        Object all;
        OfflineVideoDao videoDao;
        MigrationContext context;
        AppDatabase db;
        List dbVideoRecords;
        MigrationContext context2;
        List dbVideoRecords2;
        try {
            if (continuation instanceof MigrationPreCheckHandler$doHandle$1) {
                migrationPreCheckHandler$doHandle$1 = (MigrationPreCheckHandler$doHandle$1) continuation;
                if ((migrationPreCheckHandler$doHandle$1.label & Integer.MIN_VALUE) != 0) {
                    migrationPreCheckHandler$doHandle$1.label -= Integer.MIN_VALUE;
                    Object $result = migrationPreCheckHandler$doHandle$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (migrationPreCheckHandler$doHandle$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            new DataLog().info("MigrationPreCheckHandler start pre-check.");
                            MigrationContext context3 = chain.getContext();
                            AppDatabase db2 = context3.getDb();
                            OfflineVideoDao videoDao2 = db2.videoDao();
                            migrationPreCheckHandler$doHandle$1.L$0 = chain;
                            migrationPreCheckHandler$doHandle$1.L$1 = context3;
                            migrationPreCheckHandler$doHandle$1.L$2 = SpillingKt.nullOutSpilledVariable(db2);
                            migrationPreCheckHandler$doHandle$1.L$3 = videoDao2;
                            migrationPreCheckHandler$doHandle$1.label = 1;
                            all = videoDao2.getAll(migrationPreCheckHandler$doHandle$1);
                            if (all == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            videoDao = videoDao2;
                            context = context3;
                            db = db2;
                            try {
                                dbVideoRecords = (List) all;
                                if (!MigrationValidateHelperKt.validateVideos(context.getCachedVideos(), dbVideoRecords)) {
                                    new DataLog().info("DB and cached data are consistent, migration succeed.");
                                    return MigrationResult.Success.INSTANCE;
                                }
                                new DataLog().info("DB and cached videos are inconsistent, clear all records and retry.");
                                try {
                                    migrationPreCheckHandler$doHandle$1.L$0 = chain;
                                    migrationPreCheckHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(context);
                                    migrationPreCheckHandler$doHandle$1.L$2 = SpillingKt.nullOutSpilledVariable(db);
                                    migrationPreCheckHandler$doHandle$1.L$3 = SpillingKt.nullOutSpilledVariable(videoDao);
                                    migrationPreCheckHandler$doHandle$1.L$4 = SpillingKt.nullOutSpilledVariable(dbVideoRecords);
                                    migrationPreCheckHandler$doHandle$1.label = 2;
                                    if (videoDao.deleteAll(migrationPreCheckHandler$doHandle$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    context2 = context;
                                    dbVideoRecords2 = dbVideoRecords;
                                    migrationPreCheckHandler$doHandle$1.L$0 = SpillingKt.nullOutSpilledVariable(chain);
                                    migrationPreCheckHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(context2);
                                    migrationPreCheckHandler$doHandle$1.L$2 = SpillingKt.nullOutSpilledVariable(db);
                                    migrationPreCheckHandler$doHandle$1.L$3 = SpillingKt.nullOutSpilledVariable(videoDao);
                                    migrationPreCheckHandler$doHandle$1.L$4 = SpillingKt.nullOutSpilledVariable(dbVideoRecords2);
                                    migrationPreCheckHandler$doHandle$1.label = 3;
                                    Object proceed = chain.proceed(migrationPreCheckHandler$doHandle$1);
                                    return proceed != coroutine_suspended ? coroutine_suspended : proceed;
                                } catch (Throwable th) {
                                    e = th;
                                    new DataLog().error("MigrationPreCheckHandler clean db failed: " + e);
                                    MigrationException error = new MigrationException(DataErrorType.MIGRATION_DB_WRITE_ERROR.getCode(), DataErrorType.MIGRATION_DB_WRITE_ERROR.getTrackMsg());
                                    return new MigrationResult.Failure(error);
                                }
                            } catch (Throwable th2) {
                                e = th2;
                                new DataLog().error("MigrationPreCheckHandler get db video records failed: " + e);
                                MigrationException error2 = new MigrationException(DataErrorType.MIGRATION_DB_READ_ERROR.getCode(), DataErrorType.MIGRATION_DB_READ_ERROR.getTrackMsg());
                                return new MigrationResult.Failure(error2);
                            }
                        case 1:
                            OfflineVideoDao videoDao3 = (OfflineVideoDao) migrationPreCheckHandler$doHandle$1.L$3;
                            AppDatabase db3 = (AppDatabase) migrationPreCheckHandler$doHandle$1.L$2;
                            MigrationContext context4 = (MigrationContext) migrationPreCheckHandler$doHandle$1.L$1;
                            chain = (MigrationChain) migrationPreCheckHandler$doHandle$1.L$0;
                            ResultKt.throwOnFailure($result);
                            all = $result;
                            videoDao = videoDao3;
                            context = context4;
                            db = db3;
                            dbVideoRecords = (List) all;
                            if (!MigrationValidateHelperKt.validateVideos(context.getCachedVideos(), dbVideoRecords)) {
                            }
                            break;
                        case 2:
                            dbVideoRecords2 = (List) migrationPreCheckHandler$doHandle$1.L$4;
                            videoDao = (OfflineVideoDao) migrationPreCheckHandler$doHandle$1.L$3;
                            db = (AppDatabase) migrationPreCheckHandler$doHandle$1.L$2;
                            context2 = (MigrationContext) migrationPreCheckHandler$doHandle$1.L$1;
                            chain = (MigrationChain) migrationPreCheckHandler$doHandle$1.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                migrationPreCheckHandler$doHandle$1.L$0 = SpillingKt.nullOutSpilledVariable(chain);
                                migrationPreCheckHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(context2);
                                migrationPreCheckHandler$doHandle$1.L$2 = SpillingKt.nullOutSpilledVariable(db);
                                migrationPreCheckHandler$doHandle$1.L$3 = SpillingKt.nullOutSpilledVariable(videoDao);
                                migrationPreCheckHandler$doHandle$1.L$4 = SpillingKt.nullOutSpilledVariable(dbVideoRecords2);
                                migrationPreCheckHandler$doHandle$1.label = 3;
                                Object proceed2 = chain.proceed(migrationPreCheckHandler$doHandle$1);
                                if (proceed2 != coroutine_suspended) {
                                }
                            } catch (Throwable th3) {
                                e = th3;
                                new DataLog().error("MigrationPreCheckHandler clean db failed: " + e);
                                MigrationException error3 = new MigrationException(DataErrorType.MIGRATION_DB_WRITE_ERROR.getCode(), DataErrorType.MIGRATION_DB_WRITE_ERROR.getTrackMsg());
                                return new MigrationResult.Failure(error3);
                            }
                            break;
                        case 3:
                            List list = (List) migrationPreCheckHandler$doHandle$1.L$4;
                            OfflineVideoDao offlineVideoDao = (OfflineVideoDao) migrationPreCheckHandler$doHandle$1.L$3;
                            AppDatabase appDatabase = (AppDatabase) migrationPreCheckHandler$doHandle$1.L$2;
                            MigrationContext migrationContext = (MigrationContext) migrationPreCheckHandler$doHandle$1.L$1;
                            MigrationChain migrationChain = (MigrationChain) migrationPreCheckHandler$doHandle$1.L$0;
                            ResultKt.throwOnFailure($result);
                            return $result;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (migrationPreCheckHandler$doHandle$1.label) {
            }
        } catch (Throwable th4) {
            e = th4;
        }
        migrationPreCheckHandler$doHandle$1 = new MigrationPreCheckHandler$doHandle$1(this, continuation);
        Object $result2 = migrationPreCheckHandler$doHandle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}