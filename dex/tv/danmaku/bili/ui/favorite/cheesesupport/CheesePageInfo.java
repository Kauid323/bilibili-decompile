package tv.danmaku.bili.ui.favorite.cheesesupport;

import com.alibaba.fastjson.annotation.JSONField;

public class CheesePageInfo {
    @JSONField(name = "next")
    public boolean hasNextPage;
    @JSONField(name = "num")
    public int num;
    @JSONField(name = "size")
    public int size;
    @JSONField(name = "total")
    public int total;
}