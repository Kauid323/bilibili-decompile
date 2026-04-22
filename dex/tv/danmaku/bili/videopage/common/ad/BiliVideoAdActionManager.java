package tv.danmaku.bili.videopage.common.ad;

import android.content.Context;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.playerbizcommon.biliad.AdPanelInfo;
import com.bilibili.playerbizcommon.biliad.BiliAdDanmakuViewModelv2;

public class BiliVideoAdActionManager {
    public static void hideAdPanel(Context context) {
        AdPanelInfo adPanelInfo = new AdPanelInfo();
        BiliAdDanmakuViewModelv2.hideAdPanel(ContextUtilKt.requireActivity(context), adPanelInfo);
    }

    public static void showAdPanel(Context context, int from) {
        AdPanelInfo adPanelInfo = new AdPanelInfo();
        BiliAdDanmakuViewModelv2.showAdPanel(ContextUtilKt.requireActivity(context), adPanelInfo);
    }
}