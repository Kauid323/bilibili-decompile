package tv.danmaku.bili.ui.personinfo.api;

import com.alibaba.fastjson.annotation.JSONField;

public class PersonInfoModifyNameBean {
    @JSONField(deserialize = false, serialize = false)
    public String originName;
    @JSONField(name = "name")
    public String successName;
}