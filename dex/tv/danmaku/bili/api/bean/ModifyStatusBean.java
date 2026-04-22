package tv.danmaku.bili.api.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;

public class ModifyStatusBean {
    @JSONField(name = "reasons")
    public ArrayList<String> reasons;
    @JSONField(name = "order_status")
    public int status;
}