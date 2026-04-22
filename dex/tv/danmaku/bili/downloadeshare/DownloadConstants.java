package tv.danmaku.bili.downloadeshare;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: DownloadConstants.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/downloadeshare/DownloadConstants;", "", "<init>", "()V", "DOWNLOAD_PREF_NAME", "", "PREF_DOWNLOAD_SHARE_FIRST_TIME", "PREF_DOWNLOAD_DATE_AND_TIMES", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DownloadConstants {
    public static final String DOWNLOAD_PREF_NAME = "download_share";
    public static final DownloadConstants INSTANCE = new DownloadConstants();
    public static final String PREF_DOWNLOAD_DATE_AND_TIMES = "pref_download_network_date_and_times";
    public static final String PREF_DOWNLOAD_SHARE_FIRST_TIME = "pref_download_share_first_time";

    private DownloadConstants() {
    }
}