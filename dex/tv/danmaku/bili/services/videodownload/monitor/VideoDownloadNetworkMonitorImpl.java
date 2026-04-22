package tv.danmaku.bili.services.videodownload.monitor;

import android.content.Context;
import bili.resource.homepage.R;
import com.bilibili.base.connectivity.Connectivity;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.videodownloader.ui.VideoDownloadWarningDialog;
import com.bilibili.videodownloader.utils.monitor.VideoDownloadNetworkMonitor;
import tv.danmaku.bili.services.videodownload.utils.FreeDataMediaDownloadHelper;
import tv.danmaku.bili.services.videodownload.utils.VideoDownloadNetworkHelper;

public class VideoDownloadNetworkMonitorImpl implements VideoDownloadNetworkMonitor {
    public String getSafeNetworkName(Context context) {
        return VideoDownloadNetworkHelper.getActiveNetworkMetered(context).getName();
    }

    public int getCurrentNetworkType(Context context) {
        return ConnectivityMonitor.getInstance().getNetworkWithoutCache();
    }

    public boolean needStopByNetworkChanged(Context context) {
        if (FreeDataMediaDownloadHelper.isMediaSupportFreeData(context)) {
            VideoDownloadNetworkHelper.notifyNetworkWarning(context, R.string.homepage_global_string_369);
            return true;
        }
        VideoDownloadWarningDialog.NetWorkWarningType type = VideoDownloadNetworkHelper.getActiveNetworkMetered(context);
        if ((VideoDownloadNetworkHelper.isMeteredWifi(type) && !VideoDownloadNetworkHelper.isSafeWifiNetWork(context, type.getName())) || VideoDownloadNetworkHelper.isMobileData(type)) {
            VideoDownloadNetworkHelper.notifyNetworkWarning(context, VideoDownloadNetworkHelper.isMeteredWifi(type) ? bili.resource.playerbaseres.R.string.playerbaseres_global_string_445 : R.string.homepage_global_string_360);
            return true;
        }
        return false;
    }

    public boolean isNetworkSafe(Context context, String networkName) {
        return VideoDownloadNetworkHelper.isActiveNetworkSafe(context, networkName);
    }

    public boolean isNetworkConnected(Context context) {
        return Connectivity.isConnected(Connectivity.getActiveNetworkInfo(context.getApplicationContext()));
    }

    public boolean isNetworkConnectingOrConnected(Context context) {
        return Connectivity.isConnectedOrConnecting(Connectivity.getActiveNetworkInfo(context.getApplicationContext()));
    }
}