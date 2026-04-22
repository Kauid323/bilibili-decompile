package video.biz.offline.base.infra.storage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.download.PauseType;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.error.DownloadErrorType;

/* compiled from: DataStorageWrapper.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"videoPauseState", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "type", "Lvideo/biz/offline/base/infra/download/PauseType;", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DataStorageWrapperKt {

    /* compiled from: DataStorageWrapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PauseType.values().length];
            try {
                iArr[PauseType.PAUSE_NETWORK_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PauseType.PAUSE_NOT_WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PauseType.PAUSE_LOGOUT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ OfflineVideoEntity.State videoPauseState$default(OfflineVideoEntity offlineVideoEntity, PauseType pauseType, int i, Object obj) {
        if ((i & 1) != 0) {
            pauseType = null;
        }
        return videoPauseState(offlineVideoEntity, pauseType);
    }

    public static final OfflineVideoEntity.State videoPauseState(OfflineVideoEntity $this$videoPauseState, PauseType type) {
        Intrinsics.checkNotNullParameter($this$videoPauseState, "<this>");
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return new OfflineVideoEntity.State.ERROR(DownloadErrorType.NETWORK_DISCONNECT.getErrorCode());
            case 2:
                return new OfflineVideoEntity.State.ERROR(DownloadErrorType.NOT_WIFI.getErrorCode());
            case 3:
                return new OfflineVideoEntity.State.ERROR(DownloadErrorType.LOGOUT.getErrorCode());
            default:
                return new OfflineVideoEntity.State.PAUSED($this$videoPauseState.getDownloadedSize(), $this$videoPauseState.getTotalSize());
        }
    }
}