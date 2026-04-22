package tv.danmaku.bili.videopage.common.watchlater.api;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;

public class WatchLaterList {
    @JSONField(name = "count")
    public int count;
    @JSONField(name = "list")
    public ArrayList<WatchLaterItem> watchLaterItems;
}