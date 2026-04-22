package tv.danmaku.bili.ui.videodownload.diagnosis;

import com.bilibili.lib.media.resolver.exception.ResolveJsonException;
import com.bilibili.lib.media.resolver.exception.ResolveMediaSourceException;
import com.bilibili.videodownloader.exceptions.ResolveFreeDataException;
import tv.danmaku.bili.services.videodownload.exception.ResolveBangumiException;
import tv.danmaku.ijk.media.player.IjkMediaPlayerTracker;

public final class DiagnosisTagHelper {
    static final String DIAGNOSIS_SUB_ERROR_TYPE_BANGUMI = "5";
    static final String DIAGNOSIS_SUB_ERROR_TYPE_DEFAULT = "1";
    static final String DIAGNOSIS_SUB_ERROR_TYPE_JSON = "4";
    static final String DIAGNOSIS_SUB_ERROR_TYPE_LOCAL = "2";
    static final String DIAGNOSIS_SUB_ERROR_TYPE_LUA = "3";
    static final String DIAGNOSIS_SUB_ERROR_TYPE_UNICOM = "6";
    private static final String DIAGNOSIS_TAG_INFO = "355";
    private static final String DIAGNOSIS_TAG_INFO_DOWNLOAD = "358";
    private static final String DIAGNOSIS_TAG_INFO_INCOMPLETE = "356";
    private static final String DIAGNOSIS_TAG_INFO_INCOMPLETED_DIR = "361";
    private static final String DIAGNOSIS_TAG_INFO_LACK_DIR = "359";
    private static final String DIAGNOSIS_TAG_INFO_READ_FILE_FAILED = "360";
    private static final String DIAGNOSIS_TAG_INFO_RESOLVE = "357";
    private static final int DIAGNOSIS_TYPE_DOWNLOADED = 2;
    private static final int DIAGNOSIS_TYPE_DOWNLOADING = 1;

    public static int getTagType(ResolveTask task) {
        return getTagType(task.mScanEntry);
    }

    public static int getTagType(ScanEntry scanEntry) {
        return scanEntry.isCompleted() ? 2 : 1;
    }

    public static String[] getSubErrorCodeAndInfo(Exception e) {
        String sub_error_type = "1";
        String sub_error_info = null;
        if (e instanceof ResolveFreeDataException) {
            sub_error_type = "6";
        } else if (e instanceof ResolveMediaSourceException) {
            int subCode = ((ResolveMediaSourceException) e).getCode();
            if (subCode == 0) {
                sub_error_type = "2";
            } else {
                sub_error_type = "3";
                sub_error_info = subCode + "";
            }
        } else if (e instanceof ResolveJsonException) {
            sub_error_type = "4";
            sub_error_info = ((ResolveJsonException) e).getCode() + "";
        } else if (e instanceof ResolveBangumiException) {
            sub_error_type = "5";
        }
        return new String[]{sub_error_type, sub_error_info};
    }

    public static String getTagId(int type, int errorCode) {
        if (type == 1) {
            switch (errorCode) {
                case 10:
                    return DIAGNOSIS_TAG_INFO_INCOMPLETE;
                case IjkMediaPlayerTracker.BLIJK_EV_HTTP_WILL_REBUILD /* 2001 */:
                    return DIAGNOSIS_TAG_INFO_RESOLVE;
                default:
                    return DIAGNOSIS_TAG_INFO_DOWNLOAD;
            }
        } else if (type == 2) {
            switch (errorCode) {
                case 1:
                case 4:
                case 5:
                    return DIAGNOSIS_TAG_INFO_INCOMPLETED_DIR;
                case 2:
                case 3:
                case 6:
                case 7:
                    return DIAGNOSIS_TAG_INFO_READ_FILE_FAILED;
                case 8:
                    return DIAGNOSIS_TAG_INFO_LACK_DIR;
                default:
                    return DIAGNOSIS_TAG_INFO;
            }
        } else {
            return DIAGNOSIS_TAG_INFO;
        }
    }
}