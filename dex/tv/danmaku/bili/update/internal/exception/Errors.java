package tv.danmaku.bili.update.internal.exception;

import android.content.Context;
import com.bilibili.app.updater.R;

public class Errors {
    public static final int ERROR_APK_ID_FAIL = 2012;
    public static final int ERROR_DOWNLOAD_CANCELLED = 1201;
    public static final int ERROR_DOWNLOAD_SIZE_UNKNOWN = 1104;
    public static final int ERROR_FILE_ERROR = 1001;
    public static final int ERROR_HTTP_RESPONSE_ERROR = 1102;
    public static final int ERROR_INTERNAL = 1302;
    public static final int ERROR_MALFORMED_URI = 1105;
    public static final int ERROR_MD5_INVALID = 1202;
    public static final int ERROR_MERGE_INVALID = 2032;
    public static final int ERROR_OLD_APK_FAIL = 2011;
    public static final int ERROR_PATCH_FAIL = 2031;
    public static final int ERROR_PATCH_INVALID = 2021;
    public static final int ERROR_REDIRECTS = 1103;
    public static final int ERROR_RETRIES = 1106;
    public static final int ERROR_UNHANDLED_HTTP_CODE = 1101;
    public static final int ERROR_VERIFY_FAILED = 1107;
    public static final int ERROR_WTF = 1301;

    public static boolean isNetworkError(int code) {
        return code >= 1101 && code <= 1106;
    }

    @Deprecated
    public static void report(int code, String msg, String version) {
    }

    public static String getErrorMsg(Context context, int code) {
        String msg = context.getResources().getString(R.string.update_download_fail);
        switch (code) {
            case 1001:
                msg = context.getResources().getString(R.string.update_apk_file_operate_error);
                break;
            case ERROR_VERIFY_FAILED /* 1107 */:
                msg = context.getResources().getString(R.string.update_apk_check_fail);
                break;
        }
        if (isNetworkError(code)) {
            String msg2 = context.getResources().getString(R.string.update_network_exception);
            return msg2;
        }
        return msg;
    }
}