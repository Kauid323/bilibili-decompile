package tv.danmaku.biliplayerimpl.report.heartbeat;

import android.app.Application;
import com.alibaba.fastjson.JSON;
import com.bilibili.base.BiliContext;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.ids.Ids;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.pvtracker.PageViewTracker;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: HeartBeatCacheManager.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartBeatCacheManager;", "", "<init>", "()V", "TAG", "", "FILE_TYPE", "UTF_8", "mReportList", "Ljava/util/HashMap;", "Ltv/danmaku/biliplayerimpl/report/heartbeat/ReportContext;", "Lkotlin/collections/HashMap;", "mLogDir", "Ljava/io/File;", "readCacheFileFromDisk", "", "retryFailedReportContext", "getHeartbeatParams", "Ltv/danmaku/biliplayerimpl/report/heartbeat/HeartbeatParams;", "reportContext", "mRetryReportRunnable", "Ljava/lang/Runnable;", "saveCacheFile", "removeCacheFile", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class HeartBeatCacheManager {
    public static final String FILE_TYPE = "heartbeat_report";
    private static final String TAG = "HeartBeatCacheManager";
    private static final String UTF_8 = "UTF-8";
    private static File mLogDir;
    public static final HeartBeatCacheManager INSTANCE = new HeartBeatCacheManager();
    private static final HashMap<String, ReportContext> mReportList = new HashMap<>();
    private static final Runnable mRetryReportRunnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartBeatCacheManager$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            HeartBeatCacheManager.mRetryReportRunnable$lambda$0();
        }
    };

    private HeartBeatCacheManager() {
    }

    private static final ReportContext readCacheFileFromDisk$deserializationFromFile(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            String result = FileUtils.readFileToString(file, UTF_8);
            if (result == null) {
                return null;
            }
            return (ReportContext) JSON.parseObject(result, ReportContext.class);
        } catch (Exception e) {
            file.delete();
            BLog.e(TAG, "cache file parse failed");
            return null;
        }
    }

    public final void readCacheFileFromDisk() {
        HandlerThreads.post(2, new Runnable() { // from class: tv.danmaku.biliplayerimpl.report.heartbeat.HeartBeatCacheManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                HeartBeatCacheManager.readCacheFileFromDisk$lambda$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void readCacheFileFromDisk$lambda$0() {
        File[] fileList;
        String hash;
        if (mLogDir == null) {
            Application application = BiliContext.application();
            mLogDir = application != null ? application.getExternalFilesDir(FILE_TYPE) : null;
        }
        if (mLogDir != null) {
            File file = mLogDir;
            Intrinsics.checkNotNull(file);
            if (file.exists()) {
                File file2 = mLogDir;
                Intrinsics.checkNotNull(file2);
                if (file2.isDirectory()) {
                    File file3 = mLogDir;
                    Intrinsics.checkNotNull(file3);
                    file3.mkdirs();
                } else {
                    File file4 = mLogDir;
                    Intrinsics.checkNotNull(file4);
                    file4.delete();
                    File file5 = mLogDir;
                    Intrinsics.checkNotNull(file5);
                    file5.mkdirs();
                }
                File $this$readCacheFileFromDisk_u24lambda_u240_u240 = mLogDir;
                if ($this$readCacheFileFromDisk_u24lambda_u240_u240 != null && $this$readCacheFileFromDisk_u24lambda_u240_u240.isDirectory() && (fileList = $this$readCacheFileFromDisk_u24lambda_u240_u240.listFiles()) != null) {
                    for (File file6 : fileList) {
                        ReportContext reportContext = readCacheFileFromDisk$deserializationFromFile(file6);
                        if (reportContext != null && (hash = reportContext.getMHash()) != null) {
                            mReportList.put(hash, reportContext);
                        }
                    }
                    return;
                }
                return;
            }
        }
        BLog.w(TAG, "get cache directory failed");
    }

    public final void retryFailedReportContext() {
        HandlerThreads.post(2, mRetryReportRunnable);
    }

    private final HeartbeatParams getHeartbeatParams(ReportContext reportContext) {
        long mServerTime = reportContext.getMServerTime();
        String mSession = reportContext.getMSession();
        long mMid = reportContext.getMMid();
        long mAid = reportContext.getMAid();
        long mCid = reportContext.getMCid();
        String mSid = reportContext.getMSid();
        long mEpid = reportContext.getMEpid();
        String mType = reportContext.getMType();
        int mSubType = reportContext.getMSubType();
        int mQuality = reportContext.getMQuality();
        long mTotalTime = reportContext.getMTotalTime();
        long mPausedTime = reportContext.getMPausedTime();
        long mPlayedTime = reportContext.getMPlayedTime();
        long mVideoDuration = reportContext.getMVideoDuration();
        String mPlayType = reportContext.getMPlayType();
        int mNetworkType = reportContext.getMNetworkType();
        long mLastProcessTime = reportContext.getMLastProcessTime();
        long mMaxPlayProgressTime = reportContext.getMMaxPlayProgressTime();
        int mJumpFrom = reportContext.getMJumpFrom();
        String mFromSpmid = reportContext.getMFromSpmid();
        String mSpmid = reportContext.getMSpmid();
        String mEpStatus = reportContext.getMEpStatus();
        String mPlayStatus = reportContext.getMPlayStatus();
        String mUserStatus = reportContext.getMUserStatus();
        long mActualPlayedTime = reportContext.getMActualPlayedTime();
        int mAutoPlay = reportContext.getMAutoPlay();
        long mListPlayTime = reportContext.getMListPlayTime();
        long mMiniPlayTime = reportContext.getMMiniPlayTime();
        String mPlayMode = reportContext.getMPlayMode();
        String mLanguage = reportContext.getMLanguage();
        String mPerferType = reportContext.getMPerferType();
        String mTrackId = reportContext.getMTrackId();
        String oaid = Ids.INSTANCE.getOaid();
        String currentPolarisActionId = PageViewTracker.getInstance().currentPolarisActionId();
        if (currentPolarisActionId == null) {
            currentPolarisActionId = "";
        }
        return new HeartbeatParams(mServerTime, mSession, mMid, mAid, mCid, mSid, mEpid, mType, mSubType, mQuality, mTotalTime, mPausedTime, mPlayedTime, mVideoDuration, mPlayType, mNetworkType, mLastProcessTime, mMaxPlayProgressTime, mJumpFrom, mFromSpmid, mSpmid, mEpStatus, mPlayStatus, mUserStatus, mActualPlayedTime, mAutoPlay, mListPlayTime, mMiniPlayTime, mPlayMode, mLanguage, mPerferType, mTrackId, oaid, currentPolarisActionId, reportContext.getMIsAutoQn(), reportContext.getMExtraParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRetryReportRunnable$lambda$0() {
        GeneralResponse body;
        if (mReportList.isEmpty() || !ConnectivityMonitor.getInstance().isNetworkActive()) {
            return;
        }
        Iterator iterator = mReportList.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ReportContext> entry = iterator.next();
            if (entry.getValue().getMAid() <= 0) {
                INSTANCE.removeCacheFile(entry.getValue());
                iterator.remove();
            } else {
                try {
                    body = (GeneralResponse) ((HeartbeatApi) ServiceGenerator.createService(HeartbeatApi.class)).reportV2(INSTANCE.getHeartbeatParams(entry.getValue())).execute().body();
                } catch (Exception e) {
                    body = null;
                }
                boolean z = true;
                if (body != null && body.isSuccess()) {
                    BLog.i("try report heartbeat end avid:" + entry.getValue().getMAid() + " cid:" + entry.getValue().getMCid() + "  playmode:" + entry.getValue().getMPlayMode());
                    INSTANCE.removeCacheFile(entry.getValue());
                    iterator.remove();
                } else {
                    if (body == null || body.code != -400) {
                        z = false;
                    }
                    if (z) {
                        INSTANCE.removeCacheFile(entry.getValue());
                        iterator.remove();
                    }
                    BLog.i("try report heartbeat end avid:" + entry.getValue().getMAid() + " cid:" + entry.getValue().getMCid() + " fail}");
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:3:0x0009, B:5:0x0018, B:11:0x0024, B:13:0x002f, B:14:0x0032), top: B:19:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void saveCacheFile(ReportContext reportContext) {
        boolean z;
        Intrinsics.checkNotNullParameter(reportContext, "reportContext");
        try {
            BLog.i(TAG, "try to save report info");
            String path = reportContext.getCacheFilePath();
            String str = path;
            if (str != null && str.length() != 0) {
                z = false;
                if (z) {
                    File file = new File(path);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    String content = JSON.toJSONString(reportContext);
                    FileUtils.writeStringToFile(file, content, UTF_8);
                    return;
                }
                return;
            }
            z = true;
            if (z) {
            }
        } catch (Exception e) {
            BLog.e(TAG, "write memory to disk failed");
        }
    }

    public final void removeCacheFile(ReportContext reportContext) {
        Intrinsics.checkNotNullParameter(reportContext, "reportContext");
        String path = reportContext.getCacheFilePath();
        String str = path;
        if (str == null || str.length() == 0) {
            return;
        }
        File cacheFile = new File(path);
        if (cacheFile.exists()) {
            cacheFile.delete();
        }
    }
}