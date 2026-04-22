package tv.danmaku.bili.services.videodownload.utils;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import bili.resource.others.R;
import com.bilibili.base.connectivity.Connectivity;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.fd_service.FreeDataConfig;
import com.bilibili.infra.base.aop.PendingIntentCreateHook;
import com.bilibili.notification.NotificationChannelHelper;
import com.bilibili.notification.NotificationManagerHelper;
import com.bilibili.videodownloader.pref.VideoDownloadPrefs;
import com.bilibili.videodownloader.ui.VideoDownloadWarningDialog;
import java.util.Locale;
import java.util.UUID;
import tv.danmaku.android.ConnectivityManagerHelper;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.broadcast.NotificationReceiver;
import tv.danmaku.bili.splash.ad.utils.NetworkUtilsKt;
import tv.danmaku.bili.ui.videodownload.VideoDownloadListActivity;

public class VideoDownloadNetworkHelper {
    private static final String KEY_SAFE_WIFI_METERED_NETWORK = "bili_safe_wifi_network";
    public static final String SAFE_DATA_METERED_NETWORK_NAME = "bili_safe_mobile_network_0f26185990023e8b";
    private static final String TAG = VideoDownloadNetworkHelper.class.getSimpleName();
    private static final int WARNING_DATA_NETWORK = 1;
    private static final int WARNING_NONE = 3;
    private static final int WARNING_WIFI_NETWORK = 2;

    public static boolean isMeteredWifi(VideoDownloadWarningDialog.NetWorkWarningType type) {
        return type != null && type.getType() == 2;
    }

    public static boolean isMobileData(VideoDownloadWarningDialog.NetWorkWarningType type) {
        return type != null && type.getType() == 1;
    }

    public static boolean showNetWorkWarningDialogIfNeed(Context context, FragmentManager fm, boolean isThirdFrom, VideoDownloadWarningDialog.ContinueListener listener) {
        VideoDownloadWarningDialog.NetWorkWarningType type = getActiveNetworkMetered(context);
        if (type.getType() == 2) {
            if (!isSafeWifiNetWork(context, type.getName())) {
                showNetWorkWarningDialog(context, fm, type, getWarningTitleId(type), getWarningContentId(isThirdFrom, type), getWarningNeutralId(context, isThirdFrom), listener);
                return true;
            }
            return false;
        } else if (type.getType() == 1) {
            if (!FreeDataMediaDownloadHelper.isMediaSupportFreeData(context) || isThirdFrom) {
                showNetWorkWarningDialog(context, fm, type, getWarningTitleId(type), getWarningContentId(isThirdFrom, type), getWarningNeutralId(context, isThirdFrom), listener);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public static boolean isNetWorkAllowAutoDownload(Context context, boolean isThirdFrom) {
        if (ConnectivityMonitor.getInstance().isNetworkActive()) {
            VideoDownloadWarningDialog.NetWorkWarningType type = getActiveNetworkMetered(context);
            if (type.getType() == 3) {
                return true;
            }
            if (type.getType() == 2) {
                return isSafeWifiNetWork(context, type.getName());
            }
            return type.getType() == 1 && FreeDataMediaDownloadHelper.isMediaSupportFreeData(context) && !isThirdFrom;
        }
        return false;
    }

    private static int getWarningNeutralId(Context context, boolean isFromThird) {
        if (!FreeDataMediaDownloadHelper.isMediaSupportFreeData(context) && !isFromThird) {
            return R.string.others_global_string_252;
        }
        return 0;
    }

    private static PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(Context context, int requestCode, Intent intent, int flags) {
        PendingIntentCreateHook.setPackageIfAbsent(context, intent, flags);
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
            } catch (IllegalArgumentException e) {
                return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(33554432 | flags).intValue());
            }
        }
        return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
    }

    private static int getWarningContentId(boolean isThirdFrom, VideoDownloadWarningDialog.NetWorkWarningType networkType) {
        if (isMeteredWifi(networkType)) {
            return bili.resource.playerbaseres.R.string.playerbaseres_global_string_445;
        }
        return isThirdFrom ? bili.resource.playerbaseres.R.string.playerbaseres_global_string_914 : bili.resource.playerbaseres.R.string.playerbaseres_global_string_1037;
    }

    private static int getWarningTitleId(VideoDownloadWarningDialog.NetWorkWarningType networkType) {
        if (isMeteredWifi(networkType)) {
            return bili.resource.playerbaseres.R.string.playerbaseres_global_string_19;
        }
        return bili.resource.share.R.string.share_global_string_3;
    }

    public static boolean showNetWorkWarningDanmakuDialogIfNeed(Context context, FragmentManager fm, VideoDownloadWarningDialog.ContinueListener listener) {
        VideoDownloadWarningDialog.NetWorkWarningType networkType = getActiveNetworkMetered(context);
        if (networkType.getType() == 2) {
            if (!isSafeWifiNetWork(context, networkType.getName())) {
                showNetWorkWarningDialog(context, fm, networkType, getWarningTitleId(networkType), getWarningDanmakuContentId(), 0, listener);
                return true;
            }
            return false;
        } else if (networkType.getType() == 1 && !FreeDataMediaDownloadHelper.isDanmakuSupportFreeData(context)) {
            showNetWorkWarningDialog(context, fm, networkType, getWarningTitleId(networkType), getWarningDanmakuContentId(), 0, listener);
            return true;
        } else {
            return false;
        }
    }

    private static int getWarningDanmakuContentId() {
        return bili.resource.downloads.R.string.downloads_global_string_120;
    }

    private static void showNetWorkWarningDialog(Context context, FragmentManager fm, VideoDownloadWarningDialog.NetWorkWarningType type, int titleId, int contentId, int neutralId, VideoDownloadWarningDialog.ContinueListener listener) {
        Fragment originFragment = fm.findFragmentByTag(VideoDownloadWarningDialog.TAG);
        if (originFragment == null) {
            VideoDownloadWarningDialog dialog = new VideoDownloadWarningDialog();
            dialog.init(type, titleId, contentId, neutralId, context);
            dialog.setCancelable(false);
            dialog.setContinueListener(listener);
            dialog.show(fm, VideoDownloadWarningDialog.TAG);
            FreeDataConfig.getReporter().reportPageShow(3, "", "", "");
        }
    }

    public static void notifyNetworkWarning(Context context, int contentId) {
        Intent broadCast = new Intent(NotificationReceiver.notifyAction(context));
        broadCast.setPackage(context.getPackageName());
        broadCast.putExtra(NotificationReceiver.EXTRAS_INTENT, VideoDownloadListActivity.createIntent(context));
        PendingIntent intent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(context, UUID.randomUUID().hashCode(), broadCast, 201326592);
        String title = context.getResources().getString(com.bilibili.videodownloader.R.string.network_warning_title);
        String content = context.getResources().getString(contentId);
        try {
            Notification notification = new NotificationCompat.Builder(context, NotificationChannelHelper.getDefaultChannelId(context)).setAutoCancel(true).setContentTitle(title).setTicker(title).setContentText(content).setSmallIcon(com.bilibili.app.comm.baseres.R.drawable.ic_notify_msg).setWhen(System.currentTimeMillis()).setContentIntent(intent).setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle(title).bigText(content)).build();
            NotificationManagerHelper.notify(context, (int) VideoDownloadNotificationHelper.ID_NOTIFICATION_NETWORK_METERED, notification);
        } catch (NullPointerException e) {
            BLog.w("Build notification error!", e);
        }
    }

    public static void saveSafeWifiNetWork(Context context, String networkName) {
        VideoDownloadPrefs.INSTANCE.saveSafeWifiNetWork(networkName == null ? "" : networkName);
    }

    public static boolean isSafeWifiNetWork(Context context, String networkName) {
        return VideoDownloadPrefs.INSTANCE.isSafeWifiNetwork(networkName == null ? "" : networkName);
    }

    public static VideoDownloadWarningDialog.NetWorkWarningType getActiveNetworkMetered(Context context) {
        VideoDownloadWarningDialog.NetWorkWarningType type = new VideoDownloadWarningDialog.NetWorkWarningType(3);
        boolean isActiveMetered = ConnectivityManagerHelper.isActiveNetworkMetered(context);
        if (isActiveMetered) {
            NetworkInfo networkInfo = Connectivity.getActiveNetworkInfo(context);
            if (networkInfo == null) {
                return type;
            }
            String typeName = networkInfo.getTypeName().toLowerCase(Locale.US);
            if (!TextUtils.isEmpty(typeName) && typeName.equals(NetworkUtilsKt.NETWORK_TYPE_WIFI)) {
                type.setName(networkInfo.getExtraInfo());
                type.setType(2);
                return type;
            }
            type.setName(SAFE_DATA_METERED_NETWORK_NAME);
            type.setType(1);
            return type;
        }
        return type;
    }

    public static boolean isActiveNetworkSafe(Context context, String safeNetworkName) {
        VideoDownloadWarningDialog.NetWorkWarningType type = getActiveNetworkMetered(context);
        return type.getType() == 3 || type.getName().equals(safeNetworkName) || (type.getType() == 2 && isSafeWifiNetWork(context, type.getName()));
    }

    public static String getActiveNetworkName(Context context) {
        NetworkInfo networkInfo = Connectivity.getActiveNetworkInfo(context);
        if (networkInfo == null) {
            return null;
        }
        return networkInfo.getExtraInfo();
    }

    public static void clear(Context context) {
        VideoDownloadPrefs.INSTANCE.clearSafeWifiNetwork();
    }
}