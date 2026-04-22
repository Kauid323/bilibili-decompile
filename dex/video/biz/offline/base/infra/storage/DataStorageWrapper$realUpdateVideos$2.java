package video.biz.offline.base.infra.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.base.utils.Throttler;
import video.biz.offline.base.infra.storage.DataStorageWrapper;
import video.biz.offline.base.infra.storage.db.DBDataStorage;
import video.biz.offline.base.infra.storage.diskfile.FileDataStorage;
import video.biz.offline.base.infra.utils.OfflineLog;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataStorageWrapper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.storage.DataStorageWrapper$realUpdateVideos$2", f = "DataStorageWrapper.kt", i = {}, l = {531, 533}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DataStorageWrapper$realUpdateVideos$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<OfflineVideoEntity> $videos;
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
    public DataStorageWrapper$realUpdateVideos$2(List<OfflineVideoEntity> list, DataStorageWrapper dataStorageWrapper, Continuation<? super DataStorageWrapper$realUpdateVideos$2> continuation) {
        super(2, continuation);
        this.$videos = list;
        this.this$0 = dataStorageWrapper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataStorageWrapper$realUpdateVideos$2(this.$videos, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Throttler throttler;
        DataStorageWrapper.DataSource dataSource;
        FileDataStorage fileDataStorage;
        DBDataStorage dbDataStorage;
        DBDataStorage dbDataStorage2;
        FileDataStorage fileDataStorage2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LogKt.getVBLog().info("realUpdateVideos video " + this.$videos);
                Iterable $this$filter$iv = this.$videos;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    OfflineVideoEntity it = (OfflineVideoEntity) element$iv$iv;
                    if (Intrinsics.areEqual(it.getState(), OfflineVideoEntity.State.COMPLETED.INSTANCE)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                Iterable $this$map$iv = (List) destination$iv$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    OfflineVideoEntity it2 = (OfflineVideoEntity) item$iv$iv;
                    destination$iv$iv2.add(it2.getKey());
                }
                List it3 = (List) destination$iv$iv2;
                throttler = this.this$0.throttler;
                throttler.remove(it3);
                dataSource = this.this$0.dataSource;
                switch (WhenMappings.$EnumSwitchMapping$0[dataSource.ordinal()]) {
                    case 1:
                        fileDataStorage = this.this$0.getFileDataStorage();
                        fileDataStorage.updateVideo(this.$videos);
                        break;
                    case 2:
                        dbDataStorage = this.this$0.getDbDataStorage();
                        this.label = 1;
                        if (dbDataStorage.updateVideo(this.$videos, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 3:
                        dbDataStorage2 = this.this$0.getDbDataStorage();
                        this.label = 2;
                        if (dbDataStorage2.updateVideo(this.$videos, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        fileDataStorage2 = this.this$0.getFileDataStorage();
                        fileDataStorage2.updateVideo(this.$videos);
                        break;
                    default:
                        new OfflineLog().warn("DataStorageWrapper updateVideo dataSource is NONE");
                        break;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                fileDataStorage2 = this.this$0.getFileDataStorage();
                fileDataStorage2.updateVideo(this.$videos);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LogKt.getVBLog().debug("realUpdateVideos finish videos count " + this.$videos.size());
        return Unit.INSTANCE;
    }
}