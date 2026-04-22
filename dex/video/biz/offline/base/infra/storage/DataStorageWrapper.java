package video.biz.offline.base.infra.storage;

import java.util.List;
import java.util.Map;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.device.KDevice;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import video.base.log.LogKt;
import video.base.utils.DateKt;
import video.base.utils.Throttler;
import video.biz.offline.base.infra.storage.db.DBDataStorage;
import video.biz.offline.base.infra.storage.diskfile.FileDataStorage;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.base.infra.utils.ConfigKt;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.infra.utils.NeuronKt;
import video.biz.offline.base.infra.utils.OfflineNeuron;
import video.biz.offline.base.infra.utils.OfflineScopeKt;
import video.biz.offline.base.infra.utils.OfflineTrackType;
import video.biz.offline.base.model.entity.OfflineAuthUpdate;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.model.StorageInfoModel;

/* compiled from: DataStorageWrapper.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\u00020\u001cH\u0087@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001f\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ\b\u0010 \u001a\u00020\u001cH\u0002J\u000e\u0010!\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\"\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020%H\u0002J(\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0'2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(H\u0087@¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0'H\u0007J\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020)0(H\u0087@¢\u0006\u0002\u0010\u001dJ$\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0'2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0007J$\u00103\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0087@¢\u0006\u0002\u00104J$\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0'2\u0006\u00106\u001a\u0002002\u0006\u00101\u001a\u000202H\u0007J$\u00107\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u00106\u001a\u0002002\u0006\u00101\u001a\u000202H\u0087@¢\u0006\u0002\u00104J\u001c\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0'2\u0006\u00109\u001a\u000200H\u0007J\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u00109\u001a\u000200H\u0087@¢\u0006\u0002\u0010;J\u0018\u0010<\u001a\u0004\u0018\u00010)2\u0006\u0010=\u001a\u000202H\u0087@¢\u0006\u0002\u0010>J\"\u0010?\u001a\b\u0012\u0004\u0012\u00020)0(2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002020(H\u0087@¢\u0006\u0002\u0010+J.\u0010A\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020%2\b\b\u0002\u0010D\u001a\u00020EH\u0087@¢\u0006\u0002\u0010FJ\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020)0(H\u0087@¢\u0006\u0002\u0010\u001dJ\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020)0(H\u0087@¢\u0006\u0002\u0010\u001dJ\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u00101\u001a\u000202H\u0087@¢\u0006\u0002\u0010>J\u001c\u0010J\u001a\u00020\u001c2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002020(H\u0087@¢\u0006\u0002\u0010+J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00020L0(H\u0007J\u0016\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020)H\u0087@¢\u0006\u0002\u0010OJ\u0006\u0010P\u001a\u00020\u001cJ\u001c\u0010Q\u001a\u00020\u001c2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020S0(H\u0087@¢\u0006\u0002\u0010+J$\u0010T\u001a\u00020\u001c2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010U\u001a\u00020%H\u0087@¢\u0006\u0002\u0010VJ\u001c\u0010W\u001a\u00020\u001c2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(H\u0083@¢\u0006\u0002\u0010+R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lvideo/biz/offline/base/infra/storage/DataStorageWrapper;", "", "<init>", "()V", "writeDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getWriteDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "writeDispatcher$delegate", "Lkotlin/Lazy;", "fileDataStorage", "Lvideo/biz/offline/base/infra/storage/diskfile/FileDataStorage;", "getFileDataStorage", "()Lvideo/biz/offline/base/infra/storage/diskfile/FileDataStorage;", "fileDataStorage$delegate", "dbDataStorage", "Lvideo/biz/offline/base/infra/storage/db/DBDataStorage;", "getDbDataStorage", "()Lvideo/biz/offline/base/infra/storage/db/DBDataStorage;", "dbDataStorage$delegate", "value", "Lvideo/biz/offline/base/infra/storage/DataStorageWrapper$DataSource;", "dataSource", "setDataSource", "(Lvideo/biz/offline/base/infra/storage/DataStorageWrapper$DataSource;)V", "throttler", "Lvideo/base/utils/Throttler;", "init", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrate", "checkDataSource", "trackHitNew", "backup", "cleanInvalidSourceIfNeed", "cleanInvalidDBIfNeed", "migrationCompleted", "", "addVideos", "Lkotlinx/coroutines/flow/Flow;", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "videos", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllVideosFlow", "getAllVideos", "getVideosFlowByGroupId", "groupId", "", ChronosDanmakuSender.KEY_MARK_DANMAKU, "", "getVideosByGroupId", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosFlowByVideoId", "videoId", "getVideosByVideoId", "getVideosFlowByPageId", "pageId", "getVideosByPageId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoByKey", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosByKeys", "keys", "getUnDownloadVideos", "includePause", "includeError", "limit", "", "(ZZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadedVideos", "getDownloadingVideos", "search", "removeVideo", "getStorageInfo", "Lvideo/biz/offline/base/model/model/StorageInfoModel;", "checkIfNotInDB", "videoEntity", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetMigrate", "updateAuthCode", "list", "Lvideo/biz/offline/base/model/entity/OfflineAuthUpdate;", "updateVideos", "force", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "realUpdateVideos", "DataSource", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DataStorageWrapper {
    public static final int $stable = 8;
    private final Lazy writeDispatcher$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.storage.DataStorageWrapper$$ExternalSyntheticLambda0
        public final Object invoke() {
            CoroutineDispatcher writeDispatcher_delegate$lambda$0;
            writeDispatcher_delegate$lambda$0 = DataStorageWrapper.writeDispatcher_delegate$lambda$0();
            return writeDispatcher_delegate$lambda$0;
        }
    });
    private final Lazy fileDataStorage$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.storage.DataStorageWrapper$$ExternalSyntheticLambda1
        public final Object invoke() {
            FileDataStorage fileDataStorage_delegate$lambda$0;
            fileDataStorage_delegate$lambda$0 = DataStorageWrapper.fileDataStorage_delegate$lambda$0();
            return fileDataStorage_delegate$lambda$0;
        }
    });
    private final Lazy dbDataStorage$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.storage.DataStorageWrapper$$ExternalSyntheticLambda2
        public final Object invoke() {
            DBDataStorage dbDataStorage_delegate$lambda$0;
            dbDataStorage_delegate$lambda$0 = DataStorageWrapper.dbDataStorage_delegate$lambda$0();
            return dbDataStorage_delegate$lambda$0;
        }
    });
    private DataSource dataSource = DataSource.NONE;
    private final Throttler throttler = new Throttler(600, OfflineScopeKt.getStorageScope());

    /* compiled from: DataStorageWrapper.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lvideo/biz/offline/base/infra/storage/DataStorageWrapper$DataSource;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "FILE", "DB", "BOTH", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum DataSource {
        NONE,
        FILE,
        DB,
        BOTH;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<DataSource> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: DataStorageWrapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataSource.values().length];
            try {
                iArr[DataSource.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DataSource.DB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DataSource.BOTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DataSource.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final CoroutineDispatcher getWriteDispatcher() {
        return (CoroutineDispatcher) this.writeDispatcher$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineDispatcher writeDispatcher_delegate$lambda$0() {
        return CoroutineExJvmKt.getIoContext().limitedParallelism(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileDataStorage fileDataStorage_delegate$lambda$0() {
        return new FileDataStorage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileDataStorage getFileDataStorage() {
        return (FileDataStorage) this.fileDataStorage$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DBDataStorage dbDataStorage_delegate$lambda$0() {
        return new DBDataStorage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DBDataStorage getDbDataStorage() {
        return (DBDataStorage) this.dbDataStorage$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDataSource(DataSource value) {
        new DataLog().info("DataStorageWrapper dataSource changed: " + this.dataSource + " -> " + value);
        this.dataSource = value;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0069 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object init(Continuation<? super Unit> continuation) {
        DataStorageWrapper$init$1 dataStorageWrapper$init$1;
        if (continuation instanceof DataStorageWrapper$init$1) {
            dataStorageWrapper$init$1 = (DataStorageWrapper$init$1) continuation;
            if ((dataStorageWrapper$init$1.label & Integer.MIN_VALUE) != 0) {
                dataStorageWrapper$init$1.label -= Integer.MIN_VALUE;
                Object $result = dataStorageWrapper$init$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dataStorageWrapper$init$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        trackHitNew();
                        dataStorageWrapper$init$1.label = 1;
                        if (migrate(dataStorageWrapper$init$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dataStorageWrapper$init$1.label = 2;
                        if (checkDataSource(dataStorageWrapper$init$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dataStorageWrapper$init$1.label = 3;
                        if (backup(dataStorageWrapper$init$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dataStorageWrapper$init$1.label = 4;
                        if (cleanInvalidSourceIfNeed(dataStorageWrapper$init$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        cleanInvalidDBIfNeed();
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        dataStorageWrapper$init$1.label = 2;
                        if (checkDataSource(dataStorageWrapper$init$1) == coroutine_suspended) {
                        }
                        dataStorageWrapper$init$1.label = 3;
                        if (backup(dataStorageWrapper$init$1) == coroutine_suspended) {
                        }
                        dataStorageWrapper$init$1.label = 4;
                        if (cleanInvalidSourceIfNeed(dataStorageWrapper$init$1) == coroutine_suspended) {
                        }
                        cleanInvalidDBIfNeed();
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        dataStorageWrapper$init$1.label = 3;
                        if (backup(dataStorageWrapper$init$1) == coroutine_suspended) {
                        }
                        dataStorageWrapper$init$1.label = 4;
                        if (cleanInvalidSourceIfNeed(dataStorageWrapper$init$1) == coroutine_suspended) {
                        }
                        cleanInvalidDBIfNeed();
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        dataStorageWrapper$init$1.label = 4;
                        if (cleanInvalidSourceIfNeed(dataStorageWrapper$init$1) == coroutine_suspended) {
                        }
                        cleanInvalidDBIfNeed();
                        return Unit.INSTANCE;
                    case 4:
                        ResultKt.throwOnFailure($result);
                        cleanInvalidDBIfNeed();
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dataStorageWrapper$init$1 = new DataStorageWrapper$init$1(this, continuation);
        Object $result2 = dataStorageWrapper$init$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dataStorageWrapper$init$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object migrate(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(getWriteDispatcher(), new DataStorageWrapper$migrate$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|7|8|13|14|15))|25|6|7|8|13|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
        new video.biz.offline.base.infra.utils.DataLog().error("DataStorageWrapper checkDataSource error", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
        throw r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c A[Catch: Exception -> 0x0030, CancellationException -> 0x0032, TRY_ENTER, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x0032, Exception -> 0x0030, blocks: (B:12:0x002c, B:19:0x0039), top: B:28:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkDataSource(Continuation<? super Unit> continuation) {
        DataStorageWrapper$checkDataSource$1 dataStorageWrapper$checkDataSource$1;
        if (continuation instanceof DataStorageWrapper$checkDataSource$1) {
            dataStorageWrapper$checkDataSource$1 = (DataStorageWrapper$checkDataSource$1) continuation;
            if ((dataStorageWrapper$checkDataSource$1.label & Integer.MIN_VALUE) != 0) {
                dataStorageWrapper$checkDataSource$1.label -= Integer.MIN_VALUE;
                Object $result = dataStorageWrapper$checkDataSource$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dataStorageWrapper$checkDataSource$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        dataStorageWrapper$checkDataSource$1.label = 1;
                        if (getAllVideos(dataStorageWrapper$checkDataSource$1) == coroutine_suspended) {
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
        dataStorageWrapper$checkDataSource$1 = new DataStorageWrapper$checkDataSource$1(this, continuation);
        Object $result2 = dataStorageWrapper$checkDataSource$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dataStorageWrapper$checkDataSource$1.label) {
        }
        return Unit.INSTANCE;
    }

    private final void trackHitNew() {
        Map extra;
        if (migrationCompleted()) {
            extra = MapsKt.mapOf(new Pair[]{TuplesKt.to(NeuronKt.EXTRA_VALUE1, "1"), TuplesKt.to(NeuronKt.EXTRA_VALUE2, String.valueOf(Config.Companion.getDbMigrateTimes()))});
        } else {
            extra = MapsKt.emptyMap();
        }
        OfflineNeuron.Companion.trackT$default(OfflineNeuron.Companion, OfflineTrackType.HITKMPOFFLINE, extra, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object backup(Continuation<? super Unit> continuation) {
        Object supervisorScope = SupervisorKt.supervisorScope(new DataStorageWrapper$backup$2(this, null), continuation);
        return supervisorScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? supervisorScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cleanInvalidSourceIfNeed(Continuation<? super Unit> continuation) {
        DataStorageWrapper$cleanInvalidSourceIfNeed$1 dataStorageWrapper$cleanInvalidSourceIfNeed$1;
        long delayTime;
        if (continuation instanceof DataStorageWrapper$cleanInvalidSourceIfNeed$1) {
            dataStorageWrapper$cleanInvalidSourceIfNeed$1 = (DataStorageWrapper$cleanInvalidSourceIfNeed$1) continuation;
            if ((dataStorageWrapper$cleanInvalidSourceIfNeed$1.label & Integer.MIN_VALUE) != 0) {
                dataStorageWrapper$cleanInvalidSourceIfNeed$1.label -= Integer.MIN_VALUE;
                Object $result = dataStorageWrapper$cleanInvalidSourceIfNeed$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dataStorageWrapper$cleanInvalidSourceIfNeed$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String config = KConfig.INSTANCE.config(ConfigKt.FF_DELETE_INVALID_FILE_DELAY, "30");
                        delayTime = config != null ? Long.parseLong(config) : 30L;
                        dataStorageWrapper$cleanInvalidSourceIfNeed$1.J$0 = delayTime;
                        dataStorageWrapper$cleanInvalidSourceIfNeed$1.label = 1;
                        if (DelayKt.delay(delayTime, dataStorageWrapper$cleanInvalidSourceIfNeed$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dataStorageWrapper$cleanInvalidSourceIfNeed$1.J$0 = delayTime;
                        dataStorageWrapper$cleanInvalidSourceIfNeed$1.label = 2;
                        if (BuildersKt.withContext(getWriteDispatcher(), new DataStorageWrapper$cleanInvalidSourceIfNeed$2(this, null), dataStorageWrapper$cleanInvalidSourceIfNeed$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        delayTime = dataStorageWrapper$cleanInvalidSourceIfNeed$1.J$0;
                        ResultKt.throwOnFailure($result);
                        dataStorageWrapper$cleanInvalidSourceIfNeed$1.J$0 = delayTime;
                        dataStorageWrapper$cleanInvalidSourceIfNeed$1.label = 2;
                        if (BuildersKt.withContext(getWriteDispatcher(), new DataStorageWrapper$cleanInvalidSourceIfNeed$2(this, null), dataStorageWrapper$cleanInvalidSourceIfNeed$1) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        long j = dataStorageWrapper$cleanInvalidSourceIfNeed$1.J$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dataStorageWrapper$cleanInvalidSourceIfNeed$1 = new DataStorageWrapper$cleanInvalidSourceIfNeed$1(this, continuation);
        Object $result2 = dataStorageWrapper$cleanInvalidSourceIfNeed$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dataStorageWrapper$cleanInvalidSourceIfNeed$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cleanInvalidSourceIfNeed$canDeleteInvalidFile() {
        long currentTime = DateKt.getCurrentTimeMillis() / ((long) IjkMediaCodecInfo.RANK_MAX);
        String config$default = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, ConfigKt.FF_DELETE_INVALID_FILE_INTERVAL, (String) null, 2, (Object) null);
        Long timeInterval = config$default != null ? StringsKt.toLongOrNull(config$default) : null;
        long lastTime = Config.Companion.getLastDeleteInvalidTime();
        if (timeInterval != null && currentTime - lastTime > timeInterval.longValue()) {
            Config.Companion.setLastDeleteInvalidTime(currentTime);
            new DataLog().info("deleteInvalidFileMap hit delete, interval: " + timeInterval + ", lastTime: " + lastTime + ", currentTime: " + currentTime);
            return true;
        }
        new DataLog().info("deleteInvalidFileMap time not hit, interval: " + timeInterval + ", lastTime: " + lastTime + ", currentTime: " + currentTime);
        Map map = Config.Companion.getDeleteInvalidFileMap();
        if (map.isEmpty()) {
            new DataLog().info("deleteInvalidFileMap buvid map is empty");
            return false;
        }
        String buvid = KDevice.INSTANCE.getBuvid();
        new DataLog().info("deleteInvalidFileMap: buvid=" + buvid + ", local version=" + Config.Companion.getDeleteInvalidVersion() + ", map=" + map);
        Integer num = map.get(buvid);
        if (num != null) {
            int targetVersion = num.intValue();
            if (targetVersion > Config.Companion.getDeleteInvalidVersion()) {
                Config.Companion.setDeleteInvalidVersion(targetVersion);
                Config.Companion.setLastDeleteInvalidTime(currentTime);
                new DataLog().info("deleteInvalidFileMap hit delete, version: " + Config.Companion.getDeleteInvalidVersion());
                return true;
            }
            new DataLog().info("deleteInvalidFileMap cant delete invalid file");
            return false;
        }
        return false;
    }

    private final void cleanInvalidDBIfNeed() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean migrationCompleted() {
        return Config.Companion.getDbMigrateSuccessTimes() >= 3;
    }

    public final Object addVideos(List<OfflineVideoEntity> list, Continuation<? super Flow<? extends List<OfflineVideoEntity>>> continuation) {
        return BuildersKt.withContext(getWriteDispatcher(), new DataStorageWrapper$addVideos$2(this, list, null), continuation);
    }

    public final Flow<List<OfflineVideoEntity>> getAllVideosFlow() {
        return WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()] == 1 ? getFileDataStorage().getAllVideosFlow() : getDbDataStorage().getAllVideosFlow();
    }

    public final Object getAllVideos(Continuation<? super List<OfflineVideoEntity>> continuation) {
        return WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()] == 1 ? getFileDataStorage().getAllVideos() : getDbDataStorage().getAllVideos(continuation);
    }

    public final Flow<List<OfflineVideoEntity>> getVideosFlowByGroupId(long groupId, String keyword) {
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        switch (WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()]) {
            case 1:
                return getFileDataStorage().getVideosFlowByGroupId(groupId, keyword);
            case 2:
                return getDbDataStorage().getVideosFlowByGroupId(groupId, keyword);
            case 3:
                return getDbDataStorage().getVideosFlowByGroupId(groupId, keyword);
            default:
                return FlowKt.emptyFlow();
        }
    }

    public final Object getVideosByGroupId(long groupId, String keyword, Continuation<? super List<OfflineVideoEntity>> continuation) {
        return WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()] == 1 ? getFileDataStorage().getVideosByGroupId(groupId, keyword) : getDbDataStorage().getVideosByGroupId(groupId, keyword, continuation);
    }

    public final Flow<List<OfflineVideoEntity>> getVideosFlowByVideoId(long videoId, String keyword) {
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        return WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()] == 1 ? getFileDataStorage().getVideosFlowByVideoId(videoId, keyword) : getDbDataStorage().getVideosFlowByVideoId(videoId, keyword);
    }

    public final Object getVideosByVideoId(long videoId, String keyword, Continuation<? super List<OfflineVideoEntity>> continuation) {
        return WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()] == 1 ? getFileDataStorage().getVideosByVideoId(videoId, keyword) : getDbDataStorage().getVideosByVideoId(videoId, keyword, continuation);
    }

    public final Flow<List<OfflineVideoEntity>> getVideosFlowByPageId(long pageId) {
        return WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()] == 1 ? getFileDataStorage().getVideosFlowByPageId(pageId) : getDbDataStorage().getVideosFlowByPageId(pageId);
    }

    public final Object getVideosByPageId(long pageId, Continuation<? super List<OfflineVideoEntity>> continuation) {
        return WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()] == 1 ? getFileDataStorage().getVideosByPageId(pageId) : getDbDataStorage().getVideosByPageId(pageId, continuation);
    }

    public final Object getVideoByKey(String key, Continuation<? super OfflineVideoEntity> continuation) {
        return WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()] == 1 ? getFileDataStorage().getVideoByKey(key) : getDbDataStorage().getVideoByKey(key, continuation);
    }

    public final Object getVideosByKeys(List<String> list, Continuation<? super List<OfflineVideoEntity>> continuation) {
        return WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()] == 1 ? getFileDataStorage().getVideosByKeys(list) : getDbDataStorage().getVideosByKeys(list, continuation);
    }

    public static /* synthetic */ Object getUnDownloadVideos$default(DataStorageWrapper dataStorageWrapper, boolean z, boolean z2, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return dataStorageWrapper.getUnDownloadVideos(z, z2, i, continuation);
    }

    public final Object getUnDownloadVideos(boolean includePause, boolean includeError, int limit, Continuation<? super List<OfflineVideoEntity>> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()] == 1) {
            return getFileDataStorage().getUnDownloadVideos(includePause, includeError, limit);
        }
        return getDbDataStorage().getUnDownloadVideos(includePause, includeError, limit, continuation);
    }

    public final Object getDownloadedVideos(Continuation<? super List<OfflineVideoEntity>> continuation) {
        return WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()] == 1 ? getFileDataStorage().getDownloadedVideos() : getDbDataStorage().getDownloadedVideos(continuation);
    }

    public final Object getDownloadingVideos(Continuation<? super List<OfflineVideoEntity>> continuation) {
        return WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()] == 1 ? getFileDataStorage().getDownloadingVideos() : getDbDataStorage().getDownloadingVideos(continuation);
    }

    public final Object search(String keyword, Continuation<? super List<OfflineVideoEntity>> continuation) {
        return WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()] == 1 ? getFileDataStorage().search(keyword) : getDbDataStorage().search(keyword, continuation);
    }

    public final Object removeVideo(List<String> list, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(getWriteDispatcher(), new DataStorageWrapper$removeVideo$2(this, list, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final List<StorageInfoModel> getStorageInfo() {
        List it = StorageInfoImpl_androidKt.getStorageInfoList$default(false, 1, null);
        new DataLog().info("DataStorageWrapper getStorageInfo: " + it);
        return it;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkIfNotInDB(OfflineVideoEntity videoEntity, Continuation<? super Boolean> continuation) {
        DataStorageWrapper$checkIfNotInDB$1 dataStorageWrapper$checkIfNotInDB$1;
        Object videoByKey;
        if (continuation instanceof DataStorageWrapper$checkIfNotInDB$1) {
            dataStorageWrapper$checkIfNotInDB$1 = (DataStorageWrapper$checkIfNotInDB$1) continuation;
            if ((dataStorageWrapper$checkIfNotInDB$1.label & Integer.MIN_VALUE) != 0) {
                dataStorageWrapper$checkIfNotInDB$1.label -= Integer.MIN_VALUE;
                Object $result = dataStorageWrapper$checkIfNotInDB$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (dataStorageWrapper$checkIfNotInDB$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        switch (WhenMappings.$EnumSwitchMapping$0[this.dataSource.ordinal()]) {
                            case 1:
                            case 4:
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                            case 2:
                            case 3:
                                DBDataStorage dbDataStorage = getDbDataStorage();
                                String key = videoEntity.getKey();
                                dataStorageWrapper$checkIfNotInDB$1.L$0 = SpillingKt.nullOutSpilledVariable(videoEntity);
                                dataStorageWrapper$checkIfNotInDB$1.label = 1;
                                videoByKey = dbDataStorage.getVideoByKey(key, dataStorageWrapper$checkIfNotInDB$1);
                                if (videoByKey == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                if (videoByKey != null) {
                                    z = false;
                                    break;
                                }
                                break;
                        }
                    case 1:
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) dataStorageWrapper$checkIfNotInDB$1.L$0;
                        ResultKt.throwOnFailure($result);
                        videoByKey = $result;
                        if (videoByKey != null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxBoolean(z);
            }
        }
        dataStorageWrapper$checkIfNotInDB$1 = new DataStorageWrapper$checkIfNotInDB$1(this, continuation);
        Object $result2 = dataStorageWrapper$checkIfNotInDB$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (dataStorageWrapper$checkIfNotInDB$1.label) {
        }
        return Boxing.boxBoolean(z2);
    }

    public final void resetMigrate() {
        new DataLog().info("DataStorageWrapper resetMigrate count.");
        if (Config.Companion.getDbMigrateSuccessTimes() > 0) {
            OfflineNeuron.Companion.trackT$default(OfflineNeuron.Companion, OfflineTrackType.HITKMPOFFLINERESET, null, null, 6, null);
        }
        Config.Companion.setDbMigrateSuccessTimes(0);
    }

    public final Object updateAuthCode(List<OfflineAuthUpdate> list, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(getWriteDispatcher(), new DataStorageWrapper$updateAuthCode$2(list, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object updateVideos(List<OfflineVideoEntity> list, boolean force, Continuation<? super Unit> continuation) {
        LogKt.getVBLog().debug("updateVideos force: " + force + ", videos: " + list);
        if (list.isEmpty()) {
            return Unit.INSTANCE;
        }
        if (force) {
            Object realUpdateVideos = realUpdateVideos(list, continuation);
            return realUpdateVideos == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? realUpdateVideos : Unit.INSTANCE;
        }
        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) CollectionsKt.firstOrNull(list);
        String key = (offlineVideoEntity == null || (key = offlineVideoEntity.getKey()) == null) ? "updateVideos" : "updateVideos";
        this.throttler.throttle(key, new DataStorageWrapper$updateVideos$2(this, list, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object realUpdateVideos(List<OfflineVideoEntity> list, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(getWriteDispatcher(), new DataStorageWrapper$realUpdateVideos$2(list, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}