package tv.danmaku.bili.services.videodownload.utils;

import android.content.Context;
import android.text.TextUtils;
import bili.resource.downloads.R;
import com.bilibili.commons.RandomUtils;
import com.bilibili.droid.DisplaySizeHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.playerbizcommon.utils.PlayerSettingHelper;
import com.bilibili.videodownloader.model.VideoDownloadAVPageEntry;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.utils.log.LogHelper;
import tv.danmaku.bili.services.videodownload.WrapperErrorCode;
import tv.danmaku.bili.ui.offline.OfflineUtil;

public class VideoDownloadEntryUIState {
    private static final String TAG = VideoDownloadEntryUIState.class.getSimpleName();
    public boolean isUnicom;
    public boolean mCanStart;
    public String mDownloadCompletedTitle;
    public boolean mIsProgressBarIndeterminate;
    public boolean mNeedShowProgressBar;
    public String mProgress;
    public int mProgressPercentage;
    public String mState;
    public String mStateOrProgress;
    public String mSpeed = "";
    public String mLastSpeed = "";
    private StringBuilder mStringBuilder = new StringBuilder();

    public void refresh(Context context, VideoDownloadEntry entry) {
        boolean z = false;
        this.mCanStart = false;
        this.mProgress = "";
        this.mNeedShowProgressBar = false;
        this.mProgressPercentage = 0;
        this.mIsProgressBarIndeterminate = false;
        this.mLastSpeed = this.mSpeed;
        this.mSpeed = "";
        this.isUnicom = false;
        this.mDownloadCompletedTitle = "";
        if (entry == null) {
            this.mCanStart = true;
            this.mState = "";
            this.mStateOrProgress = this.mState;
            return;
        }
        this.mProgressPercentage = entry.getProgressPercentage();
        if (entry.isRemoved()) {
            this.mCanStart = true;
            this.mState = context.getString(R.string.downloads_global_string_3);
            this.mStateOrProgress = this.mState;
        } else if (entry.isRemoving()) {
            this.mState = context.getString(bili.resource.favorites.R.string.favorites_global_string_156);
            this.mStateOrProgress = this.mState;
            this.mNeedShowProgressBar = true;
            this.mIsProgressBarIndeterminate = true;
        } else if (entry.isDeleteFailed()) {
            this.mCanStart = true;
            this.mState = context.getString(bili.resource.common.R.string.common_global_string_52);
            this.mStateOrProgress = this.mState;
        } else if (entry.isCompleted()) {
            this.mState = context.getString(bili.resource.common.R.string.common_global_string_173);
            this.mProgress = getProgress(this.mStringBuilder, context, entry);
            if (entry instanceof VideoDownloadAVPageEntry) {
                VideoDownloadAVPageEntry avPageEntry = (VideoDownloadAVPageEntry) entry;
                if (avPageEntry.mPageData != null && !TextUtils.isEmpty(avPageEntry.mPageData.downloadSubtitle) && !TextUtils.isEmpty(avPageEntry.mPageData.downloadTitle)) {
                    this.mStateOrProgress = avPageEntry.mPageData.downloadSubtitle;
                    this.mDownloadCompletedTitle = avPageEntry.mPageData.downloadTitle;
                    return;
                }
                this.mStateOrProgress = getCombinedProgress(this.mStringBuilder, entry, this.mState);
                return;
            }
            this.mStateOrProgress = getCombinedProgress(this.mStringBuilder, entry, this.mState);
        } else if (entry.isStopped()) {
            this.mCanStart = true;
            this.mState = context.getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_1345);
            this.mStateOrProgress = getCombinedStoppedState(this.mStringBuilder, context, entry, this.mState);
        } else if (entry.isStopping()) {
            this.mState = context.getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_606);
            this.mStateOrProgress = getCombinedProgress(this.mStringBuilder, entry, this.mState);
            this.mNeedShowProgressBar = true;
            this.mIsProgressBarIndeterminate = true;
        } else if (entry.isDownloading()) {
            this.mState = context.getString(R.string.downloads_global_string_102);
            if (10010 == entry.mExpectedNetworkType) {
                z = true;
            }
            this.isUnicom = z;
            this.mProgress = getProgress(this.mStringBuilder, context, entry);
            this.mStateOrProgress = this.mProgress;
            this.mNeedShowProgressBar = true;
            this.mIsProgressBarIndeterminate = entry.isProgressIndeterminate();
            this.mSpeed = getSpeed(this.mStringBuilder, entry.mSpeed, this.mLastSpeed);
        } else if (entry.isPreparing()) {
            this.mState = context.getString(R.string.downloads_global_string_68);
            this.mStateOrProgress = getCombinedProgress(this.mStringBuilder, entry, this.mState);
            this.mNeedShowProgressBar = true;
            this.mIsProgressBarIndeterminate = true;
        } else if (entry.isInQueue()) {
            this.mState = context.getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_544);
            this.mStateOrProgress = getCombinedProgress(this.mStringBuilder, entry, this.mState);
        } else {
            this.mCanStart = true;
            this.mState = "";
            this.mStateOrProgress = this.mState;
        }
    }

    public static boolean isFullHDQuality(int quality) {
        return PlayerSettingHelper.INSTANCE.isVipQuality(quality, (String) null);
    }

    private static String getCombinedProgress(StringBuilder sb, VideoDownloadEntry entry, String state) {
        sb.setLength(0);
        if (entry.mDownloadedBytes >= 0) {
            sb.append(DisplaySizeHelper.byteCountToDisplaySize(entry.mDownloadedBytes));
            sb.append(" / ");
        }
        sb.append(state);
        return sb.toString();
    }

    private static String getSpeed(StringBuilder sb, long speed, String lastSpeed) {
        float f;
        float f2;
        sb.setLength(0);
        if (speed < 0) {
            sb.append(DisplaySizeHelper.byteCountToDisplaySize(0L));
        } else {
            sb.append(DisplaySizeHelper.byteCountToDisplaySize(speed));
        }
        sb.append("/s");
        String currentSpeed = sb.toString();
        if (!TextUtils.equals(currentSpeed, "0B/s") && TextUtils.equals(currentSpeed, lastSpeed)) {
            float f3 = (float) speed;
            if (RandomUtils.nextInt(1, 3) == 1) {
                f = 0.85f;
                f2 = 0.95f;
            } else {
                f = 1.05f;
                f2 = 1.15f;
            }
            return getSpeed(sb, f3 * RandomUtils.nextFloat(f, f2), "");
        }
        return currentSpeed;
    }

    private static String getProgress(StringBuilder sb, Context context, VideoDownloadEntry entry) {
        sb.setLength(0);
        if (entry.mDownloadedBytes >= 0) {
            sb.append(DisplaySizeHelper.byteCountToDisplaySize(entry.mDownloadedBytes));
        } else {
            sb.append("?");
        }
        sb.append(" / ");
        if (entry.mTotalBytes > 0) {
            sb.append(DisplaySizeHelper.byteCountToDisplaySize(entry.mTotalBytes));
        } else if (entry.mGuessedTotalBytes > 0) {
            sb.append(DisplaySizeHelper.byteCountToDisplaySize(entry.mGuessedTotalBytes));
        } else {
            sb.append("?");
        }
        return sb.toString();
    }

    public static String getCombinedStoppedState(StringBuilder sb, Context context, VideoDownloadEntry entry, String state) {
        if (context == null || entry == null || entry.mLastErrorCode == 0) {
            return state == null ? "" : state;
        }
        if (isFullHDQuality(entry.mPreferredVideoQuality) && !BiliAccounts.get(context).isTokenValid()) {
            entry.mLastErrorCode = WrapperErrorCode.FHD_QUALITY_NOT_LOGIN;
        }
        return getErrInfo(sb, context, entry);
    }

    private static String getErrInfo(StringBuilder sb, Context context, VideoDownloadEntry entry) {
        if (entry == null || entry.mLastErrorCode == 0) {
            return "";
        }
        LogHelper.w(TAG, "UI PageState entry error code: %d", new Object[]{Integer.valueOf(entry.mLastErrorCode)});
        sb.setLength(0);
        sb.append(context.getString(bili.resource.common.R.string.common_global_string_34));
        sb.append(":");
        sb.append(OfflineUtil.code2Msg(context, entry));
        return sb.toString();
    }
}