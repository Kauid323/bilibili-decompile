package tv.danmaku.bili.services.videodownload.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.core.app.ServiceCompat;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.app.preferences.BiliPreferencesActivity;
import com.bilibili.commons.StringUtils;
import com.bilibili.infra.base.aop.PendingIntentCreateHook;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.notification.NotificationChannelHelper;
import com.bilibili.notification.NotificationManagerHelper;
import com.bilibili.videodownloader.model.VideoDownloadAVPageEntry;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.model.VideoDownloadSeasonEpEntry;
import com.bilibili.videodownloader.utils.log.LogHelper;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import shark.AndroidReferenceMatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.broadcast.NotificationReceiver;
import tv.danmaku.bili.preferences.DownloadStoragePrefHelper;
import tv.danmaku.bili.ui.videodownload.VideoDownloadListActivity;
import tv.danmaku.bili.ui.videodownload.utils.TransformHelper;
import tv.danmaku.bili.utils.NotificationHelper;

public class VideoDownloadNotificationHelper extends NotificationHelper {
    public static final int DOWNLOADING = 3;
    public static final int DOWNLOAD_COMPLETED = 2;
    public static final int DOWNLOAD_ERROR = 1;
    public static final String DOWNLOAD_STATE = "download_state";
    public static final int ID_NOTIFICATION_DOWNLOAD = 69632;
    public static final int ID_NOTIFICATION_ERROR_TIPS = 69904;
    public static final int ID_NOTIFICATION_NETWORK_METERED = 69888;
    private static final String TAG = "VideoDownloadNotificationHelper";
    private String currentDisplayKey;
    private AtomicInteger mIds;
    private ArrayMap<String, Integer> mNotificationKeys;
    private VideoDownloadEntryUIState mUiState;

    private static PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(Context context, int requestCode, Intent intent, int flags) {
        PendingIntentCreateHook.setPackageIfAbsent(context, intent, flags);
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
            } catch (IllegalArgumentException e) {
                return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(33554432 | flags).intValue());
            }
        }
        return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
    }

    protected VideoDownloadNotificationHelper(Context context, NotificationCompat.Builder builder) {
        super(context, builder);
        this.mUiState = new VideoDownloadEntryUIState();
        this.mNotificationKeys = new ArrayMap<>();
        this.mIds = new AtomicInteger(ID_NOTIFICATION_DOWNLOAD);
    }

    public static VideoDownloadNotificationHelper initHelper(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, NotificationChannelHelper.getDefaultChannelId(context)).setSmallIcon(R.drawable.ic_notify_msg).setWhen(System.currentTimeMillis());
        return new VideoDownloadNotificationHelper(context, builder);
    }

    public static void notifyEntryForForeground(Service service, VideoDownloadEntry entry) {
        PendingIntent intent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(service, 0, new Intent(), 67108864);
        try {
            Notification notification = new NotificationCompat.Builder(service, NotificationChannelHelper.getDefaultChannelId(service)).setContentTitle(entry.mTitle).setContentText(service.getString(entry.isRemoving() ? bili.resource.favorites.R.string.favorites_global_string_156 : bili.resource.downloads.R.string.downloads_global_string_102)).setSmallIcon(R.drawable.ic_notify_msg).setWhen(System.currentTimeMillis()).setContentIntent(intent).build();
            int type = 1;
            if (Build.VERSION.SDK_INT >= 35) {
                type = 8193;
            }
            ServiceCompat.startForeground(service, (int) ID_NOTIFICATION_DOWNLOAD, notification, type);
            BLog.i(TAG, "startForeground successfully");
        } catch (NullPointerException e) {
            BLog.e("Build notification error!", e);
        } catch (Exception e2) {
            BLog.e("startForeground error!", e2);
        }
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

    public static void notifyDownloadErrorPrompter(Context context, int errorCode) {
        String content = "";
        switch (errorCode) {
            case 2:
            case 11:
                content = context.getString(bili.resource.downloads.R.string.downloads_global_string_35);
                break;
        }
        Intent downloadSettingIntent = BiliPreferencesActivity.createIntent(context, DownloadStoragePrefHelper.DownloadPrefFragment.class.getName(), context.getString(bili.resource.settings.R.string.settings_global_string_1));
        downloadSettingIntent.putExtra(DOWNLOAD_STATE, 1);
        PendingIntent intent = getBroadcastIntent(context, downloadSettingIntent);
        String title = context.getString(bili.resource.downloads.R.string.downloads_global_string_111);
        try {
            Notification notification = new NotificationCompat.Builder(context, NotificationChannelHelper.getDefaultChannelId(context)).setContentTitle(title).setContentText(content).setTicker(title).setAutoCancel(true).setSmallIcon(R.drawable.ic_notify_msg).setWhen(System.currentTimeMillis()).setContentIntent(intent).build();
            NotificationManager manager = NotificationManagerHelper.getNotificationManager(context);
            if (manager != null) {
                manager.notify(ID_NOTIFICATION_ERROR_TIPS, notification);
                reportNotificationShow(1);
            }
        } catch (NullPointerException e) {
            BLog.w("Build notification error!", e);
        }
    }

    private static PendingIntent getDownloadListIntent(Context context) {
        Intent intent = VideoDownloadListActivity.createIntent(context);
        intent.putExtra(DOWNLOAD_STATE, 3);
        return getBroadcastIntent(context, intent);
    }

    public void notifyDownloadState(VideoDownloadEntry entry) {
        int id;
        boolean indeterminate;
        boolean ongoing;
        boolean autoCancel;
        PendingIntent intent;
        NotificationManager manager;
        if (entry.isInQueue()) {
            return;
        }
        synchronized (this) {
            if (!entry.needStop() && !entry.isDeleteFailed()) {
                if (!entry.mCanPlayed) {
                    this.mNotificationKeys.put(entry.getKey(), Integer.valueOf((int) ID_NOTIFICATION_DOWNLOAD));
                }
                if (this.currentDisplayKey == null || this.currentDisplayKey.equals(entry.getKey()) || entry.mCanPlayed) {
                    this.mUiState.refresh(this.mContext, entry);
                    int progress = 0;
                    PendingIntent intent2 = null;
                    String title = getNotificationTitle(entry);
                    if (this.mUiState.mNeedShowProgressBar) {
                        int progress2 = this.mUiState.mProgressPercentage;
                        boolean indeterminate2 = this.mUiState.mIsProgressBarIndeterminate;
                        if (StringUtils.containsIgnoreCase(Build.MODEL, AndroidReferenceMatchers.VIVO)) {
                            try {
                                this.mBuilder.setSmallIcon(17301633);
                            } catch (Exception e) {
                                this.mBuilder.setSmallIcon(R.drawable.ic_notify_msg);
                            }
                        }
                        progress = progress2;
                        id = 69632;
                        indeterminate = indeterminate2;
                        ongoing = true;
                        autoCancel = false;
                    } else if (!entry.mCanPlayed) {
                        id = 69632;
                        indeterminate = false;
                        ongoing = false;
                        autoCancel = true;
                    } else {
                        Integer old = (Integer) this.mNotificationKeys.get(entry.getKey());
                        if (old != null && old.intValue() == 69632) {
                            intent2 = getPendingIntent(entry);
                            int id2 = this.mIds.incrementAndGet();
                            if (StringUtils.containsIgnoreCase(Build.MODEL, AndroidReferenceMatchers.VIVO)) {
                                try {
                                    this.mBuilder.setSmallIcon(17301634);
                                } catch (Exception e2) {
                                    this.mBuilder.setSmallIcon(R.drawable.ic_notify_msg);
                                }
                            }
                            if (this.currentDisplayKey != null && this.currentDisplayKey.equals(entry.getKey())) {
                                this.currentDisplayKey = null;
                            }
                            id = id2;
                            indeterminate = false;
                            ongoing = false;
                            autoCancel = true;
                            progress = 0;
                        } else {
                            return;
                        }
                    }
                    this.mBuilder.setWhen(System.currentTimeMillis());
                    if (intent2 != null) {
                        intent = intent2;
                    } else {
                        intent = getDownloadListIntent(this.mContext);
                    }
                    int max = (progress > 0 || indeterminate) ? 100 : 0;
                    LogHelper.i(TAG, "notify helper [%d]Entry state changed:%s %d / %d %b %s, autoCancel: %b, ongoing: %b, notify title: %s", new Object[]{Integer.valueOf(id), entry.getSimpleName(), Integer.valueOf(progress), Integer.valueOf(max), Boolean.valueOf(indeterminate), this.mUiState.mStateOrProgress, Boolean.valueOf(autoCancel), Boolean.valueOf(ongoing), TextUtils.isEmpty(this.mUiState.mDownloadCompletedTitle) ? title : this.mUiState.mDownloadCompletedTitle});
                    this.mNotificationKeys.put(entry.getKey(), Integer.valueOf(id));
                    notify(id, autoCancel, ongoing, TextUtils.isEmpty(this.mUiState.mDownloadCompletedTitle) ? title : this.mUiState.mDownloadCompletedTitle, this.mUiState.mStateOrProgress, max, progress, indeterminate, intent);
                    if (id == 69632) {
                        this.currentDisplayKey = entry.getKey();
                    } else {
                        reportNotificationShow(2);
                    }
                    if (progress == 100 && (manager = NotificationManagerHelper.getNotificationManager(this.mContext)) != null) {
                        manager.cancel(ID_NOTIFICATION_DOWNLOAD);
                        return;
                    }
                    return;
                }
                return;
            }
            int indexOfKey = this.mNotificationKeys.indexOfKey(entry.getKey());
            if (indexOfKey >= 0) {
                int id3 = ((Integer) this.mNotificationKeys.valueAt(indexOfKey)).intValue();
                this.mNotificationKeys.removeAt(indexOfKey);
                cancelNotify(id3);
            }
            if (this.currentDisplayKey != null && this.currentDisplayKey.equals(entry.getKey())) {
                this.currentDisplayKey = null;
            }
        }
    }

    private String getNotificationTitle(VideoDownloadEntry entry) {
        if (entry instanceof VideoDownloadAVPageEntry) {
            VideoDownloadAVPageEntry avEntry = (VideoDownloadAVPageEntry) entry;
            StringBuilder builder = new StringBuilder();
            if (TextUtils.isEmpty(avEntry.mTitle)) {
                builder.append("av" + avEntry.mAvid);
            } else {
                builder.append(avEntry.mTitle);
            }
            if (!TextUtils.isEmpty(avEntry.mPageData.title)) {
                builder.append(" / ");
                builder.append(avEntry.mPageData.title);
            }
            return builder.toString();
        } else if (entry instanceof VideoDownloadSeasonEpEntry) {
            VideoDownloadSeasonEpEntry seEntry = (VideoDownloadSeasonEpEntry) entry;
            return seEntry.mTitle + " / " + TransformHelper.getReadableIndexTitle(seEntry);
        } else {
            return null;
        }
    }

    private PendingIntent getPendingIntent(VideoDownloadEntry entry) {
        return getVideoPageListIntent(this.mContext, entry.getAvid());
    }

    private static PendingIntent getBroadcastIntent(Context context, Intent intent) {
        if (intent == null) {
            return null;
        }
        Intent broadCast = new Intent(NotificationReceiver.notifyAction(context));
        broadCast.setClass(context, NotificationReceiver.class);
        broadCast.putExtra(NotificationReceiver.EXTRAS_INTENT, intent);
        try {
            return __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(context, UUID.randomUUID().hashCode(), broadCast, 134217728);
        } catch (Exception e) {
            BLog.e(TAG, e);
            return null;
        }
    }

    private PendingIntent getVideoPageListIntent(Context context, long avid) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra(DOWNLOAD_STATE, 2);
        intent.setData(Uri.parse("bilibili://video/" + avid));
        intent.setPackage(context.getPackageName());
        return getBroadcastIntent(context, intent);
    }

    public static void reportNotificationShow(int value) {
        HashMap<String, String> params = new HashMap<>();
        params.put("save_id", String.valueOf(value));
        Neurons.reportExposure(false, "push.push-message.push-message.0.show", params);
    }
}