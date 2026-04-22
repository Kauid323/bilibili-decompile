package tv.danmaku.biliplayerv2.service.resolve;

import com.bilibili.lib.media.resource.ExtraInfo;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.neuron.util.SamplesKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: CommonResolveTasks.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toErrInfo", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$ErrorInfo;", "Lcom/bilibili/lib/media/resource/ExtraInfo$DownloadedResolveErrLimit;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CommonResolveTasksKt {
    public static final AbsMediaResourceResolveTask.ErrorInfo toErrInfo(ExtraInfo.DownloadedResolveErrLimit $this$toErrInfo) {
        AbsMediaResourceResolveTask.ActionType actionType;
        Intrinsics.checkNotNullParameter($this$toErrInfo, "<this>");
        Neurons.trackCustom$default("offline.resolve.error", 1, 0, $this$toErrInfo.getErrCode(), 0, 0, (String) null, (Map) null, new Function0() { // from class: tv.danmaku.biliplayerv2.service.resolve.CommonResolveTasksKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean errInfo$lambda$0;
                errInfo$lambda$0 = CommonResolveTasksKt.toErrInfo$lambda$0();
                return Boolean.valueOf(errInfo$lambda$0);
            }
        }, (int) IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, (Object) null);
        AbsMediaResourceResolveTask.ErrorInfo $this$toErrInfo_u24lambda_u241 = new AbsMediaResourceResolveTask.ErrorInfo();
        String hintMessage = $this$toErrInfo.hintMessage();
        if (hintMessage == null) {
            hintMessage = "";
        }
        $this$toErrInfo_u24lambda_u241.setHint(hintMessage);
        String buttonMessage = $this$toErrInfo.buttonMessage();
        if (buttonMessage == null) {
            buttonMessage = "";
        }
        $this$toErrInfo_u24lambda_u241.setActionMsg(buttonMessage);
        String url = $this$toErrInfo.url();
        $this$toErrInfo_u24lambda_u241.setActionUrl(url != null ? url : "");
        switch ($this$toErrInfo.getActionType()) {
            case 1:
                actionType = AbsMediaResourceResolveTask.ActionType.RETURN;
                break;
            case 2:
                actionType = AbsMediaResourceResolveTask.ActionType.RELOAD;
                break;
            case 3:
                actionType = AbsMediaResourceResolveTask.ActionType.REDIRECT;
                break;
            default:
                actionType = AbsMediaResourceResolveTask.ActionType.RELOAD;
                break;
        }
        $this$toErrInfo_u24lambda_u241.setActionType(actionType);
        return $this$toErrInfo_u24lambda_u241;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean toErrInfo$lambda$0() {
        return SamplesKt.sample(100);
    }
}