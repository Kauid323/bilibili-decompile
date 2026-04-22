package tv.danmaku.bili.ui.appeal;

import com.alibaba.fastjson.annotation.JSONField;

public class BiliVideoAppeal {
    @JSONField(name = "allow_add")
    public boolean allowAdd;
    @JSONField(name = "desc")
    public String desc;
    @JSONField(name = "reason")
    public String reason;
    @JSONField(name = "type")
    public String type;
}