package video.biz.offline.list.logic;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.model.ReserveInfo;
import video.interfacee.bridge.ogv.KOGVBridgeKt;

/* compiled from: ReserveInfoImpl.android.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"getReserveInfo", "Lvideo/biz/offline/base/model/model/ReserveInfo;", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ReserveInfoImpl_androidKt {
    public static final ReserveInfo getReserveInfo() {
        return new ReserveInfo(KOGVBridgeKt.getKOGVBridge().hasReserve(), "activity://bangumi/reserve-list");
    }
}