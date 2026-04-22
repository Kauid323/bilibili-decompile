package tv.danmaku.bili.ui.videodownload.utils;

import android.content.Context;
import android.text.TextUtils;
import bili.resource.homepage.R;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.StringUtil;
import com.bilibili.videodownloader.model.VideoDownloadSeasonEpEntry;

public class TransformHelper {
    public static String getReadableIndexTitle(VideoDownloadSeasonEpEntry epEntry) {
        if (epEntry == null) {
            return null;
        }
        String index = epEntry.mEpisode.index;
        if (TextUtils.isEmpty(index)) {
            return epEntry.mEpisode.title;
        }
        if (index != null && BiliContext.application() != null) {
            if ("-1".equals(index)) {
                return BiliContext.application().getResources().getString(R.string.homepage_global_string_301);
            }
            return StringUtil.isNumeric(index) ? String.format(BiliContext.application().getResources().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_232), index) : index;
        }
        return "";
    }

    public static String getBangumiTagDesc(Context context, int seasonType) {
        int tagStrId = bili.resource.playerbaseres.R.string.playerbaseres_global_string_575;
        switch (seasonType) {
            case 2:
                tagStrId = bili.resource.following.R.string.following_global_string_304;
                break;
            case 3:
                tagStrId = bili.resource.playerbaseres.R.string.playerbaseres_global_string_1062;
                break;
            case 5:
                tagStrId = bili.resource.playerbaseres.R.string.playerbaseres_global_string_985;
                break;
        }
        return context.getResources().getString(tagStrId);
    }
}