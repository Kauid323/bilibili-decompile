package video.biz.offline.base.infra.storage;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.storage.DataStorageWrapper;
import video.biz.offline.base.infra.storage.db.DBDataStorage;
import video.biz.offline.base.infra.storage.diskfile.FileDataStorage;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataStorageWrapper.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.storage.DataStorageWrapper$addVideos$2", f = "DataStorageWrapper.kt", i = {}, l = {271, 276}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DataStorageWrapper$addVideos$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Flow<? extends List<? extends OfflineVideoEntity>>>, Object> {
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
    public DataStorageWrapper$addVideos$2(DataStorageWrapper dataStorageWrapper, List<OfflineVideoEntity> list, Continuation<? super DataStorageWrapper$addVideos$2> continuation) {
        super(2, continuation);
        this.this$0 = dataStorageWrapper;
        this.$videos = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataStorageWrapper$addVideos$2(this.this$0, this.$videos, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Flow<? extends List<OfflineVideoEntity>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DataStorageWrapper.DataSource dataSource;
        FileDataStorage fileDataStorage;
        DBDataStorage dbDataStorage;
        Object addVideos;
        FileDataStorage fileDataStorage2;
        DBDataStorage dbDataStorage2;
        Object addVideos2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                dataSource = this.this$0.dataSource;
                switch (WhenMappings.$EnumSwitchMapping$0[dataSource.ordinal()]) {
                    case 1:
                        fileDataStorage = this.this$0.getFileDataStorage();
                        return fileDataStorage.addVideos(this.$videos);
                    case 2:
                        dbDataStorage = this.this$0.getDbDataStorage();
                        this.label = 1;
                        addVideos = dbDataStorage.addVideos(this.$videos, (Continuation) this);
                        if (addVideos == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return (Flow) addVideos;
                    case 3:
                        fileDataStorage2 = this.this$0.getFileDataStorage();
                        fileDataStorage2.addVideos(this.$videos);
                        dbDataStorage2 = this.this$0.getDbDataStorage();
                        this.label = 2;
                        addVideos2 = dbDataStorage2.addVideos(this.$videos, (Continuation) this);
                        if (addVideos2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return (Flow) addVideos2;
                    default:
                        return FlowKt.emptyFlow();
                }
            case 1:
                ResultKt.throwOnFailure($result);
                addVideos = $result;
                return (Flow) addVideos;
            case 2:
                ResultKt.throwOnFailure($result);
                addVideos2 = $result;
                return (Flow) addVideos2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}