package video.biz.offline.base.facade.protocol;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineAuthUpdate;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.model.ResolveParam;
import video.biz.offline.base.model.model.StorageInfoModel;

/* compiled from: IDataStorage.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH§@¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH'J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\tH§@¢\u0006\u0002\u0010\u000fJ&\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H'J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H§@¢\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H'J&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0016J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u001b\u001a\u00020\u0012H'J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u001b\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010 J\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\tH§@¢\u0006\u0002\u0010\fJ\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\tH§@¢\u0006\u0002\u0010\u000fJ\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\tH§@¢\u0006\u0002\u0010\u000fJ$\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H§@¢\u0006\u0002\u0010(J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0013\u001a\u00020\u0014H§@¢\u0006\u0002\u0010 J\u001c\u0010*\u001a\u00020+2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\tH§@¢\u0006\u0002\u0010\fJ\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\tH&J\b\u0010.\u001a\u00020+H'J\u001c\u0010/\u001a\u00020+2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\tH§@¢\u0006\u0002\u0010\f¨\u00062À\u0006\u0003"}, d2 = {"Lvideo/biz/offline/base/facade/protocol/IDataStorage;", "", "checkIfNotInDB", "", "videoEntity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addVideos", "Lkotlinx/coroutines/flow/Flow;", "", "params", "Lvideo/biz/offline/base/model/model/ResolveParam;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllVideosFlow", "getAllVideos", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosFlowByGroupId", "groupId", "", ChronosDanmakuSender.KEY_MARK_DANMAKU, "", "getVideosByGroupId", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosFlowByVideoId", "videoId", "getVideosByVideoId", "getVideosFlowByPageId", "pageId", "getVideosByPageId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoByKey", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosByKeys", "keys", "getDownloadedVideos", "getDownloadingVideos", "getUnDownloadVideos", "includePause", "includeError", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "removeVideo", "", "getStorageInfo", "Lvideo/biz/offline/base/model/model/StorageInfoModel;", "resetMigrate", "updateAuthCode", "list", "Lvideo/biz/offline/base/model/entity/OfflineAuthUpdate;", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IDataStorage {
    Object addVideos(List<ResolveParam> list, Continuation<? super Flow<? extends List<OfflineVideoEntity>>> continuation);

    Object checkIfNotInDB(OfflineVideoEntity offlineVideoEntity, Continuation<? super Boolean> continuation);

    Object getAllVideos(Continuation<? super List<OfflineVideoEntity>> continuation);

    Flow<List<OfflineVideoEntity>> getAllVideosFlow();

    Object getDownloadedVideos(Continuation<? super List<OfflineVideoEntity>> continuation);

    Object getDownloadingVideos(Continuation<? super List<OfflineVideoEntity>> continuation);

    List<StorageInfoModel> getStorageInfo();

    Object getUnDownloadVideos(boolean z, boolean z2, Continuation<? super List<OfflineVideoEntity>> continuation);

    Object getVideoByKey(String str, Continuation<? super OfflineVideoEntity> continuation);

    Object getVideosByGroupId(long j, String str, Continuation<? super List<OfflineVideoEntity>> continuation);

    Object getVideosByKeys(List<String> list, Continuation<? super List<OfflineVideoEntity>> continuation);

    Object getVideosByPageId(long j, Continuation<? super List<OfflineVideoEntity>> continuation);

    Object getVideosByVideoId(long j, String str, Continuation<? super List<OfflineVideoEntity>> continuation);

    Flow<List<OfflineVideoEntity>> getVideosFlowByGroupId(long j, String str);

    Flow<List<OfflineVideoEntity>> getVideosFlowByPageId(long j);

    Flow<List<OfflineVideoEntity>> getVideosFlowByVideoId(long j, String str);

    Object removeVideo(List<String> list, Continuation<? super Unit> continuation);

    void resetMigrate();

    Object search(String str, Continuation<? super List<OfflineVideoEntity>> continuation);

    Object updateAuthCode(List<OfflineAuthUpdate> list, Continuation<? super Unit> continuation);

    /* compiled from: IDataStorage.kt */
    /* renamed from: video.biz.offline.base.facade.protocol.IDataStorage$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Flow getVideosFlowByGroupId$default(IDataStorage iDataStorage, long j, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = "";
                }
                return iDataStorage.getVideosFlowByGroupId(j, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVideosFlowByGroupId");
        }

        public static /* synthetic */ Object getVideosByGroupId$default(IDataStorage iDataStorage, long j, String str, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = "";
                }
                return iDataStorage.getVideosByGroupId(j, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVideosByGroupId");
        }

        public static /* synthetic */ Flow getVideosFlowByVideoId$default(IDataStorage iDataStorage, long j, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = "";
                }
                return iDataStorage.getVideosFlowByVideoId(j, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVideosFlowByVideoId");
        }

        public static /* synthetic */ Object getVideosByVideoId$default(IDataStorage iDataStorage, long j, String str, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = "";
                }
                return iDataStorage.getVideosByVideoId(j, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVideosByVideoId");
        }
    }

    /* compiled from: IDataStorage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DefaultImpls {
    }
}