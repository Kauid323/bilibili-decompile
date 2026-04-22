package tv.danmaku.bili.update.internal.exception;

import android.content.Context;
import com.bilibili.app.updater.R;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.bili.update.internal.config.OnlineParams;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.videoplayer.coreV2.adapter.ijk.IjkMediaItem;

public class ErrorsCompat {
    private static final List<Integer> NEW_WORK_ERROR = new ArrayList();

    static {
        NEW_WORK_ERROR.add(500);
        NEW_WORK_ERROR.add(Integer.valueOf((int) IjkMediaItem.BLIJKPlayMode_VOD_STORY_CM_FREE));
        NEW_WORK_ERROR.add(Integer.valueOf((int) IjkMediaItem.BLIJKPlayMode_VOD_STORY_UNICOM_FREE));
        NEW_WORK_ERROR.add(603);
        NEW_WORK_ERROR.add(604);
        NEW_WORK_ERROR.add(400);
    }

    public static boolean isNetworkError(int code) {
        if (OnlineParams.isNewDownloaderEnable()) {
            return NEW_WORK_ERROR.contains(Integer.valueOf(code));
        }
        return Errors.isNetworkError(code);
    }

    public static String getErrorMsg(Context context, int code) {
        if (isNetworkError(code)) {
            return context.getResources().getString(R.string.update_network_exception);
        }
        if (OnlineParams.isNewDownloaderEnable()) {
            switch (code) {
                case 300:
                case 301:
                case 305:
                    return context.getResources().getString(R.string.update_apk_check_fail);
                case 302:
                case 303:
                case IjkMediaCodecInfo.RANK_LAST_CHANCE /* 600 */:
                    return context.getResources().getString(R.string.update_apk_file_operate_error);
                default:
                    return context.getResources().getString(R.string.update_download_fail);
            }
        }
        return Errors.getErrorMsg(context, code);
    }
}