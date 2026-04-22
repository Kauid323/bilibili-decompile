package video.biz.offline.base.infra.download;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OperationPool.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"canAutoNext", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "getCanAutoNext", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;)Z", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OperationPoolKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r2.getStateValue() != 1) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean getCanAutoNext(OfflineVideoEntity $this$canAutoNext) {
        boolean z = $this$canAutoNext.getStateValue() != 5;
        boolean stateCan = z;
        return stateCan;
    }
}