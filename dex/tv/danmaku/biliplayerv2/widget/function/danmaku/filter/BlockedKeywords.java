package tv.danmaku.biliplayerv2.widget.function.danmaku.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BaseKeywordItem;

public class BlockedKeywords<T extends BaseKeywordItem> {
    @JSONField(name = "create_time")
    public long mCreateTime;
    @JSONField(name = "valid")
    public long mExpiredTime;
    @JSONField(name = "rule")
    public List<T> mKeywordItems;
    @JSONField(name = "toast")
    public String mToast;

    public String toString() {
        try {
            return JSON.toJSONString(this);
        } catch (Exception e) {
            return "";
        }
    }
}