package tv.danmaku.bili.api.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class ApplyStatusBean {
    public static final int STATUS_APPLYING = 0;
    public static final int STATUS_NONE = 3;
    public static final int STATUS_OVERRIDE = 4;
    public static final int STATUS_OVERRIDE_CONFIRM = 5;
    public static final int STATUS_PASSED = 1;
    public static final int STATUS_REJECT = 2;
    @JSONField(name = "card")
    public String card;
    @JSONField(name = "card_type")
    public int cardType;
    @JSONField(name = "lock_original")
    public boolean lock;
    @JSONField(name = "realname")
    public String realname;
    @JSONField(name = "remark")
    public String remark;
    @JSONField(name = "status")
    public int status;
}