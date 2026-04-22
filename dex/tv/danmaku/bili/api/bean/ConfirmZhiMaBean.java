package tv.danmaku.bili.api.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class ConfirmZhiMaBean {
    @JSONField(name = "passed")
    public int passed;
    @JSONField(name = "reason")
    public String reason;
}