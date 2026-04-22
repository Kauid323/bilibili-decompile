package tv.danmaku.bili.services.videodownload.strategy.order;

import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.utils.strategy.order.GroupComparable;

public class GroupCompareCreatingTime implements GroupComparable {
    private long mCreatedTimestamp;

    public void update(VideoDownloadEntry entry) {
        long entryTime = entry.mTimeCreated;
        if (this.mCreatedTimestamp == 0 || this.mCreatedTimestamp > entryTime) {
            this.mCreatedTimestamp = entryTime;
        }
    }

    public int compare(GroupComparable order) {
        long value = getCompareValue() - order.getCompareValue();
        if (value == 0) {
            return 0;
        }
        return value > 0 ? -1 : 1;
    }

    public long getCompareValue() {
        return this.mCreatedTimestamp;
    }
}