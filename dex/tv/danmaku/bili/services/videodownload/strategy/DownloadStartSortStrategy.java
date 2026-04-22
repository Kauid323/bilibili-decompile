package tv.danmaku.bili.services.videodownload.strategy;

import com.bilibili.videodownloader.utils.strategy.IDownloadStartSortStrategy;
import com.bilibili.videodownloader.utils.strategy.order.GroupComparable;
import tv.danmaku.bili.services.videodownload.strategy.order.GroupCompareCreatingTime;

public class DownloadStartSortStrategy implements IDownloadStartSortStrategy {
    public Class<? extends GroupComparable> getDownloadStartSortClass() {
        return GroupCompareCreatingTime.class;
    }
}