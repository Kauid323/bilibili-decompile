package tv.danmaku.biliplayerv2.service.network;

import android.net.NetworkInfo;
import com.bilibili.base.BiliContext;
import com.bilibili.base.connectivity.Connectivity;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerNetworkMonitor.kt */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayerv2/service/network/PlayerNetworkMonitor;", "", "<init>", "()V", "mNetworkInfo", "Landroid/net/NetworkInfo;", "mOnNetworkChangedListener", "tv/danmaku/biliplayerv2/service/network/PlayerNetworkMonitor$mOnNetworkChangedListener$1", "Ltv/danmaku/biliplayerv2/service/network/PlayerNetworkMonitor$mOnNetworkChangedListener$1;", "start", "", "stop", "isWifiActive", "", "isMobileActive", "isNetworkActive", "getNetworkState", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerNetworkMonitor {
    private NetworkInfo mNetworkInfo;
    private final PlayerNetworkMonitor$mOnNetworkChangedListener$1 mOnNetworkChangedListener = new ConnectivityMonitor.OnNetworkChangedListener() { // from class: tv.danmaku.biliplayerv2.service.network.PlayerNetworkMonitor$mOnNetworkChangedListener$1
        public void onChanged(int net) {
        }

        public void onChanged(int newNet, int preNet, NetworkInfo details) {
            PlayerNetworkMonitor.this.mNetworkInfo = details;
        }
    };

    public final void start() {
        this.mNetworkInfo = Connectivity.getActiveNetworkInfo(BiliContext.application());
        ConnectivityMonitor.getInstance().register(this.mOnNetworkChangedListener);
    }

    public final void stop() {
        ConnectivityMonitor.getInstance().unregister(this.mOnNetworkChangedListener);
    }

    public final boolean isWifiActive() {
        return Connectivity.isConnectedWifi(this.mNetworkInfo);
    }

    public final boolean isMobileActive() {
        return Connectivity.isConnectedMobile(this.mNetworkInfo);
    }

    public final boolean isNetworkActive() {
        return Connectivity.isConnected(this.mNetworkInfo);
    }

    public final int getNetworkState() {
        if (isNetworkActive()) {
            if (isWifiActive()) {
                return 1;
            }
            return 2;
        }
        return -1;
    }
}