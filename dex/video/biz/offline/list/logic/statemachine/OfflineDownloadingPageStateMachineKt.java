package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.error.OfflineError;
import video.biz.offline.base.model.error.OfflineErrorType;

/* compiled from: OfflineDownloadingPageStateMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"isFreeBandWidthError", "", "", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineDownloadingPageStateMachineKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isFreeBandWidthError(int $this$isFreeBandWidthError) {
        return OfflineError.INSTANCE.getErrorType($this$isFreeBandWidthError) == OfflineErrorType.BANDWIDTH_ERROR;
    }
}