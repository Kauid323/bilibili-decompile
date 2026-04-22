package video.biz.offline.base.infra.storage;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.utils.Throttler;
import video.biz.offline.base.infra.storage.DataStorageWrapper;
import video.biz.offline.base.infra.storage.db.DBDataStorage;
import video.biz.offline.base.infra.storage.diskfile.DiskFileImpl_androidKt;
import video.biz.offline.base.infra.storage.diskfile.FileDataStorage;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.infra.utils.OfflineLog;
import video.biz.offline.base.infra.utils.OfflineScopeKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataStorageWrapper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.storage.DataStorageWrapper$removeVideo$2", f = "DataStorageWrapper.kt", i = {}, l = {426, 429}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DataStorageWrapper$removeVideo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ List<String> $keys;
    int label;
    final /* synthetic */ DataStorageWrapper this$0;

    /* compiled from: DataStorageWrapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataStorageWrapper.DataSource.values().length];
            try {
                iArr[DataStorageWrapper.DataSource.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DataStorageWrapper.DataSource.DB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DataStorageWrapper.DataSource.BOTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStorageWrapper$removeVideo$2(DataStorageWrapper dataStorageWrapper, List<String> list, Continuation<? super DataStorageWrapper$removeVideo$2> continuation) {
        super(2, continuation);
        this.this$0 = dataStorageWrapper;
        this.$keys = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataStorageWrapper$removeVideo$2(this.this$0, this.$keys, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Throttler throttler;
        DataStorageWrapper.DataSource dataSource;
        FileDataStorage fileDataStorage;
        List removeVideo;
        DBDataStorage dbDataStorage;
        Object removeVideo2;
        FileDataStorage fileDataStorage2;
        DBDataStorage dbDataStorage2;
        Object removeVideo3;
        DataStorageWrapper.DataSource dataSource2;
        FileDataStorage fileDataStorage3;
        List removeDramas;
        FileDataStorage fileDataStorage4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                throttler = this.this$0.throttler;
                throttler.remove(this.$keys);
                dataSource = this.this$0.dataSource;
                switch (WhenMappings.$EnumSwitchMapping$0[dataSource.ordinal()]) {
                    case 1:
                        fileDataStorage = this.this$0.getFileDataStorage();
                        removeVideo = fileDataStorage.removeVideo(this.$keys);
                        break;
                    case 2:
                        dbDataStorage = this.this$0.getDbDataStorage();
                        this.label = 1;
                        removeVideo2 = dbDataStorage.removeVideo(this.$keys, (Continuation) this);
                        if (removeVideo2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        removeVideo = (List) removeVideo2;
                        break;
                    case 3:
                        fileDataStorage2 = this.this$0.getFileDataStorage();
                        fileDataStorage2.removeVideo(this.$keys);
                        dbDataStorage2 = this.this$0.getDbDataStorage();
                        this.label = 2;
                        removeVideo3 = dbDataStorage2.removeVideo(this.$keys, (Continuation) this);
                        if (removeVideo3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        removeVideo = (List) removeVideo3;
                        break;
                    default:
                        new OfflineLog().warn("DataStorageWrapper removeVideo dataSource is NONE");
                        removeVideo = CollectionsKt.emptyList();
                        break;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                removeVideo2 = $result;
                removeVideo = (List) removeVideo2;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                removeVideo3 = $result;
                removeVideo = (List) removeVideo3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List removeVideos = removeVideo;
        dataSource2 = this.this$0.dataSource;
        switch (WhenMappings.$EnumSwitchMapping$0[dataSource2.ordinal()]) {
            case 1:
                fileDataStorage3 = this.this$0.getFileDataStorage();
                removeDramas = fileDataStorage3.removeDramas(removeVideos);
                break;
            case 2:
            default:
                new OfflineLog().warn("DataStorageWrapper removeDrama dataSource is NONE");
                removeDramas = CollectionsKt.emptyList();
                break;
            case 3:
                fileDataStorage4 = this.this$0.getFileDataStorage();
                removeDramas = fileDataStorage4.removeDramas(removeVideos);
                break;
        }
        new DataLog().info("DataStorageWrapper removeVideos: " + removeVideos + " removeDramas: " + removeDramas);
        return BuildersKt.launch$default(OfflineScopeKt.getStorageScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(removeVideos, removeDramas, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataStorageWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.base.infra.storage.DataStorageWrapper$removeVideo$2$1", f = "DataStorageWrapper.kt", i = {}, l = {451, 452}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.base.infra.storage.DataStorageWrapper$removeVideo$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<DramaGroupModel> $removeDramas;
        final /* synthetic */ List<OfflineVideoEntity> $removeVideos;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<OfflineVideoEntity> list, List<DramaGroupModel> list2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$removeVideos = list;
            this.$removeDramas = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$removeVideos, this.$removeDramas, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0039 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (DiskFileImpl_androidKt.removeLocalVideoResource(this.$removeVideos, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.label = 2;
                    if (DiskFileImpl_androidKt.removeLocalDramaResource(this.$removeDramas, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    this.label = 2;
                    if (DiskFileImpl_androidKt.removeLocalDramaResource(this.$removeDramas, (Continuation) this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}