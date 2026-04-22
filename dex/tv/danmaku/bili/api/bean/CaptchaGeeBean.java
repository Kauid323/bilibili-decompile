package tv.danmaku.bili.api.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class CaptchaGeeBean {
    @JSONField(name = "remote")
    public int remote;
    @JSONField(name = "url")
    public String url;
}