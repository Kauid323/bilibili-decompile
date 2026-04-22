package tv.danmaku.bili.services.videodownload.strategy;

import android.content.Context;
import com.bilibili.api.BiliConfig;
import com.bilibili.videodownloader.exceptions.DownloadException;
import com.bilibili.videodownloader.utils.strategy.IDanmakuDownloadStrategy;
import tv.danmaku.biliplayerv2.service.interact.helper.InteractDownloadHelper;

public class DanmakuDownloadStrategy implements IDanmakuDownloadStrategy {
    private static final String TAG = "DanmakuDownloadStrategyImpl";
    private Context mContext;

    public DanmakuDownloadStrategy(Context context) {
        this.mContext = context;
    }

    public String getDanmakuDownloadUrl(String cid, int expectedNetwork) throws DownloadException {
        return InteractDownloadHelper.INSTANCE.getOldDanmakuUrlFromCid(this.mContext, Long.parseLong(cid));
    }

    public String getDanmakuDownloadUA() {
        return BiliConfig.getAppDefaultUA();
    }
}