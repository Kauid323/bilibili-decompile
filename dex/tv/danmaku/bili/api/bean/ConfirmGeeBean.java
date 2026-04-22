package tv.danmaku.bili.api.bean;

import com.alibaba.fastjson.annotation.JSONField;
import tv.danmaku.bili.cb.AuthResultCbHelper;

public class ConfirmGeeBean {
    @JSONField(name = AuthResultCbHelper.ARGS_STATE)
    public int state;
}