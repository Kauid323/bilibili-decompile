package video.biz.offline.base.facade.notification;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineNotificationHelper.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"ID_NOTIFICATION_DOWNLOADING", "", "ROUTE_URI_DOWNLOAD_LIST", "", "MINE_URI", "INTENT_HANDLER_ACTIVITY", "CHANNEL_ID_DEFAULT", "CHANNEL_HD_ID_DEFAULT", "facade_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineNotificationHelperKt {
    public static final String CHANNEL_HD_ID_DEFAULT = "bili_hd_channel_default";
    public static final String CHANNEL_ID_DEFAULT = "bili_channel_default";
    public static final int ID_NOTIFICATION_DOWNLOADING = 69632;
    public static final String INTENT_HANDLER_ACTIVITY = "tv.danmaku.bili.ui.intent.IntentHandlerActivity";
    public static final String MINE_URI = "bilibili://home?tab_name=%E6%88%91%E7%9A%84&mine_type=mine_offline_frag";
    public static final String ROUTE_URI_DOWNLOAD_LIST = "bilibili://offline/cache/home";
}