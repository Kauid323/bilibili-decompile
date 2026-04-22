package tv.danmaku.bili.services.videodownload.interceptor;

import android.content.Context;
import android.text.TextUtils;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.droid.StringFormatter;
import com.bilibili.lib.media.resolver.exception.ResolveException;
import com.bilibili.lib.media.resource.DashMediaIndex;
import com.bilibili.videodownloader.exceptions.ResolveFreeDataException;
import com.bilibili.videodownloader.model.VideoDownloadAVPageEntry;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.model.VideoDownloadSeasonEpEntry;
import com.bilibili.videodownloader.resolver.playurl.IDashFreeDataResolver;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.services.videodownload.WrapperErrorCode;
import tv.danmaku.bili.services.videodownload.utils.FreeDataMediaDownloadHelper;

class FreeDataDashResolver implements IDashFreeDataResolver {
    private static final String TAG = "FreeDataDashResolver";
    private boolean mIsSupportFreeData;

    public FreeDataDashResolver(boolean isSupportFreeData) {
        this.mIsSupportFreeData = isSupportFreeData;
    }

    public DashMediaIndex resolve(Context context, VideoDownloadEntry entry, DashMediaIndex dashMedia) throws ResolveException {
        int expectedNetwork = entry.mExpectedNetworkType;
        String from = getFrom(entry);
        if ((expectedNetwork != 2 && expectedNetwork != 10010) || ConnectivityMonitor.getInstance().getNetworkWithoutCache() != 2 || !this.mIsSupportFreeData) {
            BLog.w(TAG, StringFormatter.format("cancel transform dash media url", new Object[0]));
            return dashMedia;
        } else if (FreeDataMediaDownloadHelper.isThirdFrom(from)) {
            if (expectedNetwork == 10010) {
                throw new ResolveFreeDataException("error_unicom_unsupport_third for dash", WrapperErrorCode.UNICON_RESOLVE_UNSUPPORT_THIRD);
            }
            return dashMedia;
        } else if (!FreeDataMediaDownloadHelper.isMediaSupportFreeData(context)) {
            if (expectedNetwork == 10010) {
                throw new ResolveFreeDataException("error_unicom_condition_not_mathch for dash", WrapperErrorCode.UNICON_RESOLVE_CONDITION_NOT_MATHCED);
            }
            return dashMedia;
        } else {
            processDashMedia(context, dashMedia);
            return dashMedia;
        }
    }

    private String getFrom(VideoDownloadEntry entry) {
        if (entry instanceof VideoDownloadAVPageEntry) {
            VideoDownloadAVPageEntry avPageEntry = (VideoDownloadAVPageEntry) entry;
            return avPageEntry.mPageData.from;
        }
        VideoDownloadSeasonEpEntry epEntry = (VideoDownloadSeasonEpEntry) entry;
        if (TextUtils.isEmpty(epEntry.mEpisode.from)) {
            return epEntry.mSource == null ? "" : epEntry.mSource.from;
        }
        return epEntry.mEpisode.from;
    }

    private void processDashMedia(Context context, DashMediaIndex index) throws ResolveFreeDataException {
        String processedUrl = FreeDataMediaDownloadHelper.transformVideoUrl(context, index.baseUrl);
        if (TextUtils.isEmpty(processedUrl)) {
            BLog.e(TAG, "process dash url failed:" + index.baseUrl);
        } else {
            index.baseUrl = processedUrl;
        }
        List<String> backups = index.getBackupUrl();
        if (backups != null && !backups.isEmpty()) {
            List<String> newBackups = new ArrayList<>();
            for (String back : backups) {
                if (!TextUtils.isEmpty(back)) {
                    String processedBackupUrl = FreeDataMediaDownloadHelper.transformVideoUrl(context, back);
                    if (!TextUtils.isEmpty(processedBackupUrl)) {
                        newBackups.add(processedBackupUrl);
                    }
                }
            }
            index.setBackupUrl(newBackups);
        }
    }
}