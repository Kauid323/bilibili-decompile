package tv.danmaku.bili.api.bean;

import com.alibaba.fastjson.annotation.JSONField;
import tv.danmaku.bili.ui.login.LoginReporterV2;

public class ChangeRealnamePersonBean {
    @JSONField(name = LoginReporterV2.Show.SIGNUP_KEY_CODE)
    public int code;
}