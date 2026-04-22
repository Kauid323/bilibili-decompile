package tv.danmaku.bili.services.videodownload.monitor;

import android.content.Context;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.ProcessUtils;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.playerbizcommonv2.service.audio.DolbyReporter;
import com.bilibili.playerbizcommonv2.service.audio.DolbyType;
import com.bilibili.playerbizcommonv2.service.audio.VideoType;
import com.bilibili.videodownloader.downloader.connection.VideoDownloadResponse;
import com.bilibili.videodownloader.model.VideoDownloadAVPageEntry;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.model.VideoDownloadSeasonEpEntry;
import com.bilibili.videodownloader.service.VideoDownloadService;
import com.bilibili.videodownloader.utils.log.LogHelper;
import com.bilibili.videodownloader.utils.monitor.VideoDownloadReportMonitor;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.VideoDownloadTracer;
import tv.danmaku.bili.services.videodownload.WrapperErrorCode;
import tv.danmaku.bili.services.videodownload.utils.VideoDownloadEntryUIState;

public class VideoDownloadReportMonitorImpl implements VideoDownloadReportMonitor {
    private static final long DAY_1 = 86400000;

    public void reportDownloadVideoAmount(Context context, ArrayList<VideoDownloadEntry<?>> entries, long spendTime) {
        int averageAmount;
        if (!ProcessUtils.isMainProcess()) {
            long timeMill = TimeUnit.NANOSECONDS.toMillis(spendTime);
            if (timeMill >= 20000) {
                String tag = VideoDownloadService.class.getSimpleName();
                BLog.wfmt(tag, "Slowly entire offline entry scan, count: %s, time: %sms", Integer.valueOf(entries.size()), String.valueOf(timeMill));
            }
            try {
                BiliGlobalPreferenceHelper spHelper = BiliGlobalPreferenceHelper.getInstance(context);
                long lastReportTime = spHelper.optLong("last_app_download_videoamount_time", 0L);
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastReportTime > DAY_1 && spendTime > 0) {
                    long averageTime = spendTime / 1000;
                    try {
                        int amount = entries.size();
                        if (amount > 10) {
                            if (amount < 50) {
                                averageAmount = 10;
                            } else if (amount < 100) {
                                averageAmount = 50;
                            } else if (amount < 200) {
                                averageAmount = 100;
                            } else if (amount < 300) {
                                averageAmount = 200;
                            } else if (amount < 400) {
                                averageAmount = 300;
                            } else if (amount < 500) {
                                averageAmount = BR.officialImageDrawable;
                            } else if (amount < 1000) {
                                averageAmount = BR.rightBtnBackDrawable;
                            } else if (amount < 2000) {
                                averageAmount = 1000;
                            } else {
                                averageAmount = 2000;
                            }
                            averageTime = (int) ((((float) averageTime) / amount) * averageAmount);
                        }
                        long spendTime2 = averageTime / 1000;
                        try {
                            long averageTime2 = averageTime / 1000;
                            spHelper.edit().putLong("last_app_download_videoamount_time", currentTime).apply();
                            try {
                                LogHelper.i("VideoDownload", "scan list:%d, num: %d, average_time: %d", new Object[]{Long.valueOf(spendTime2), Integer.valueOf(amount), Long.valueOf(averageTime2)});
                            } catch (Exception e) {
                            }
                        } catch (Exception e2) {
                        }
                    } catch (Exception e3) {
                    }
                }
            } catch (Exception e4) {
            }
        }
    }

    public void reportDownloadSuccess(Context context, VideoDownloadEntry entry) {
        VideoDownloadTracer.reportDownloadSuccessFlowTracer(context, entry);
    }

    public void reportDownloadFailed(Context context, VideoDownloadEntry entry) {
        VideoDownloadTracer.reportDownloadFailedFlowTracer(context, entry);
        int errorCode = entry.mLastErrorCode;
        if (errorCode == 0 && !hasDownloadPrivilege(context, entry)) {
            int errorCode2 = WrapperErrorCode.FHD_QUALITY_NOT_LOGIN;
        }
    }

    public void reportConnectQuality(Context context, VideoDownloadResponse response, VideoDownloadEntry entry, String url, int id, int downloadErrCode, String md5) {
        VideoDownloadTracer.reportConnectQualityTracer(context, response, entry, url, id, downloadErrCode, md5);
    }

    public void reportDownloadPerformance(int taskCount, long initializeTime) {
        VideoDownloadTracer.reportDownloadPerformance(taskCount, initializeTime);
    }

    public void reportNewTask(Context context, VideoDownloadEntry entry) {
    }

    private long getPageId(VideoDownloadEntry entry) {
        if (entry instanceof VideoDownloadAVPageEntry) {
            long id = ((VideoDownloadAVPageEntry) entry).mPageData.cid;
            return id;
        }
        long id2 = ((VideoDownloadSeasonEpEntry) entry).mEpisode.id;
        return id2;
    }

    private boolean hasDownloadPrivilege(Context context, VideoDownloadEntry entry) {
        if (VideoDownloadEntryUIState.isFullHDQuality(entry.mPreferredVideoQuality)) {
            BiliAccounts account = BiliAccounts.get(context);
            if (!account.isTokenValid() || !BiliAccountInfo.get().isEffectiveVip()) {
                return false;
            }
            return true;
        }
        return true;
    }

    public void reportDolby(final VideoDownloadEntry entry) {
        HandlerThreads.getHandler(1).post(new Runnable() { // from class: tv.danmaku.bili.services.videodownload.monitor.VideoDownloadReportMonitorImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VideoDownloadReportMonitorImpl.lambda$reportDolby$0(entry);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$reportDolby$0(VideoDownloadEntry entry) {
        if (entry instanceof VideoDownloadAVPageEntry) {
            DolbyReporter.INSTANCE.report(entry.getAvid(), entry.getCid(), DolbyType.VIDEO, VideoType.UGC, "cache");
        } else if (entry instanceof VideoDownloadSeasonEpEntry) {
            DolbyReporter.INSTANCE.report(entry.getAvid(), entry.getCid(), DolbyType.VIDEO, VideoType.PGC, "cache");
        }
    }

    public void reportLoadEntriesPerformance(int taskCount, long initializeTime, int type) {
        VideoDownloadTracer.reportDownloadLoadEntryPerformance(taskCount, initializeTime, type);
    }
}