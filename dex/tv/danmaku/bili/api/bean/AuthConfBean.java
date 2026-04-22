package tv.danmaku.bili.api.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class AuthConfBean {
    public boolean degrade;
    @JSONField(name = "liveness_type")
    public String livenessType;
}