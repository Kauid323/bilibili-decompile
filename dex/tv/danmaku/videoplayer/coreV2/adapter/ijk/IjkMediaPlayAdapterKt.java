package tv.danmaku.videoplayer.coreV2.adapter.ijk;

import com.bilibili.lib.dd.DeviceDecision;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IjkMediaPlayAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"hitExternalRenderFirstFrameDD", "", "getHitExternalRenderFirstFrameDD", "()Z", "playercore_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkMediaPlayAdapterKt {
    private static final boolean hitExternalRenderFirstFrameDD = DeviceDecision.INSTANCE.getBoolean("dd_player_856_external_render_first_frame", true);

    public static final boolean getHitExternalRenderFirstFrameDD() {
        return hitExternalRenderFirstFrameDD;
    }
}