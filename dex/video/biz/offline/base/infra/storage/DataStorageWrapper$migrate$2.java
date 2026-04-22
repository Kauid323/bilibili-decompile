package video.biz.offline.base.infra.storage;

import java.util.List;
import kntr.base.config.KConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayableParams;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import video.biz.offline.base.infra.migrate.Builder;
import video.biz.offline.base.infra.migrate.MigrationResult;
import video.biz.offline.base.infra.storage.DataStorageWrapper;
import video.biz.offline.base.infra.storage.db.DBDataStorage;
import video.biz.offline.base.infra.storage.diskfile.FileDataStorage;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.base.infra.utils.ConfigKt;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.model.error.DataErrorType;
import video.biz.offline.base.model.error.MigrationException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataStorageWrapper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.storage.DataStorageWrapper$migrate$2", f = "DataStorageWrapper.kt", i = {}, l = {87, AuthorSpaceHeaderPlayableParams.AUTHOR_SPACE_HEADER_PLAYER_REPORT_AUTO_PLAY, IjkMediaMeta.FF_PROFILE_H264_HIGH_10}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DataStorageWrapper$migrate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DataStorageWrapper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStorageWrapper$migrate$2(DataStorageWrapper dataStorageWrapper, Continuation<? super DataStorageWrapper$migrate$2> continuation) {
        super(2, continuation);
        this.this$0 = dataStorageWrapper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataStorageWrapper$migrate$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        boolean migrationCompleted;
        FileDataStorage fileDataStorage;
        DataStorageWrapper.DataSource dataSource;
        FileDataStorage fileDataStorage2;
        FileDataStorage fileDataStorage3;
        Object proceed;
        MigrationResult migrationResult;
        boolean migrationCompleted2;
        DataStorageWrapper.DataSource dataSource2;
        DataStorageWrapper.DataSource dataSource3;
        DBDataStorage dbDataStorage;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                new DataLog().info("DataStorageWrapper init");
                this.label = 1;
                if (ConfigKt.checkForceMigrate(new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                migrationCompleted = this.this$0.migrationCompleted();
                if (!migrationCompleted) {
                    this.this$0.setDataSource(Config.Companion.getDeprecateFileStorage() ? DataStorageWrapper.DataSource.DB : DataStorageWrapper.DataSource.BOTH);
                    DataLog dataLog = new DataLog();
                    dataSource = this.this$0.dataSource;
                    dataLog.info("DataStorageWrapper init use " + dataSource);
                    return Unit.INSTANCE;
                }
                fileDataStorage = this.this$0.getFileDataStorage();
                this.label = 2;
                if (fileDataStorage.loadLocalVideos((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Builder addDefaultHandlers = new Builder().addDefaultHandlers();
                fileDataStorage2 = this.this$0.getFileDataStorage();
                Builder addCachedVideos = addDefaultHandlers.addCachedVideos(fileDataStorage2.getAllVideos());
                fileDataStorage3 = this.this$0.getFileDataStorage();
                this.label = 3;
                proceed = addCachedVideos.addDramaMap(CollectionsKt.toList(fileDataStorage3.getDramaMap().values())).setRetryTimes(3).setTimeoutStrategy(new Function1() { // from class: video.biz.offline.base.infra.storage.DataStorageWrapper$migrate$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Duration invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DataStorageWrapper$migrate$2.invokeSuspend$lambda$0(((Integer) obj).intValue());
                        return invokeSuspend$lambda$0;
                    }
                }).build().proceed((Continuation) this);
                if (proceed == coroutine_suspended) {
                    return coroutine_suspended;
                }
                migrationResult = (MigrationResult) proceed;
                DataStorageWrapper dataStorageWrapper = this.this$0;
                if (migrationResult instanceof MigrationResult.Failure) {
                    if (((MigrationResult.Failure) migrationResult).getError() instanceof MigrationException) {
                        List dbErrorCodes = CollectionsKt.listOf(new Integer[]{Boxing.boxInt(DataErrorType.MIGRATION_DB_READ_ERROR.getCode()), Boxing.boxInt(DataErrorType.MIGRATION_DB_WRITE_ERROR.getCode())});
                        boolean ffEnable = KConfig.INSTANCE.ff(ConfigKt.FF_DELETE_DB_IF_ERROR, true);
                        if (dbErrorCodes.contains(Boxing.boxInt(((MigrationException) ((MigrationResult.Failure) migrationResult).getError()).getCode())) && ffEnable) {
                            dbDataStorage = this.this$0.getDbDataStorage();
                            dbDataStorage.resetDB$infra_debug();
                        }
                    }
                    dataSource2 = DataStorageWrapper.DataSource.FILE;
                } else {
                    Config.Companion.setDbMigrateSuccessTimes(Config.Companion.getDbMigrateSuccessTimes() + 1);
                    new DataLog().info("DataStorageWrapper dbMigrateSuccessTimes: " + Config.Companion.getDbMigrateSuccessTimes());
                    migrationCompleted2 = this.this$0.migrationCompleted();
                    dataSource2 = (migrationCompleted2 && Config.Companion.getDeprecateFileStorage()) ? DataStorageWrapper.DataSource.DB : DataStorageWrapper.DataSource.BOTH;
                }
                dataStorageWrapper.setDataSource(dataSource2);
                DataLog dataLog2 = new DataLog();
                dataSource3 = this.this$0.dataSource;
                dataLog2.info("DataStorageWrapper migrated use " + dataSource3);
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                migrationCompleted = this.this$0.migrationCompleted();
                if (!migrationCompleted) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                Builder addDefaultHandlers2 = new Builder().addDefaultHandlers();
                fileDataStorage2 = this.this$0.getFileDataStorage();
                Builder addCachedVideos2 = addDefaultHandlers2.addCachedVideos(fileDataStorage2.getAllVideos());
                fileDataStorage3 = this.this$0.getFileDataStorage();
                this.label = 3;
                proceed = addCachedVideos2.addDramaMap(CollectionsKt.toList(fileDataStorage3.getDramaMap().values())).setRetryTimes(3).setTimeoutStrategy(new Function1() { // from class: video.biz.offline.base.infra.storage.DataStorageWrapper$migrate$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Duration invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DataStorageWrapper$migrate$2.invokeSuspend$lambda$0(((Integer) obj).intValue());
                        return invokeSuspend$lambda$0;
                    }
                }).build().proceed((Continuation) this);
                if (proceed == coroutine_suspended) {
                }
                migrationResult = (MigrationResult) proceed;
                DataStorageWrapper dataStorageWrapper2 = this.this$0;
                if (migrationResult instanceof MigrationResult.Failure) {
                }
                dataStorageWrapper2.setDataSource(dataSource2);
                DataLog dataLog22 = new DataLog();
                dataSource3 = this.this$0.dataSource;
                dataLog22.info("DataStorageWrapper migrated use " + dataSource3);
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                proceed = $result;
                migrationResult = (MigrationResult) proceed;
                DataStorageWrapper dataStorageWrapper22 = this.this$0;
                if (migrationResult instanceof MigrationResult.Failure) {
                }
                dataStorageWrapper22.setDataSource(dataSource2);
                DataLog dataLog222 = new DataLog();
                dataSource3 = this.this$0.dataSource;
                dataLog222.info("DataStorageWrapper migrated use " + dataSource3);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataStorageWrapper.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.base.infra.storage.DataStorageWrapper$migrate$2$1", f = "DataStorageWrapper.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.base.infra.storage.DataStorageWrapper$migrate$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DataStorageWrapper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DataStorageWrapper dataStorageWrapper, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.this$0 = dataStorageWrapper;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            DBDataStorage dbDataStorage;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    new DataLog().info("DataStorageWrapper force migrate");
                    this.this$0.resetMigrate();
                    dbDataStorage = this.this$0.getDbDataStorage();
                    this.label = 1;
                    if (dbDataStorage.clearDBRecords$infra_debug((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Duration invokeSuspend$lambda$0(int it) {
        Duration.Companion companion = Duration.Companion;
        return Duration.box-impl(DurationKt.toDuration(10, DurationUnit.SECONDS));
    }
}