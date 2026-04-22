package video.interfacee.bridge.freeBandwidth;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IFreeBandwidth.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lvideo/interfacee/bridge/freeBandwidth/IFreeBandwidth;", "", "isFreeBandwidthActive", "", "transformUrl", "Lvideo/interfacee/bridge/freeBandwidth/BandwidthResult;", "url", "", "isVideo", "httpMethod", "bridge_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IFreeBandwidth {
    boolean isFreeBandwidthActive();

    BandwidthResult transformUrl(String str, boolean z, String str2);
}