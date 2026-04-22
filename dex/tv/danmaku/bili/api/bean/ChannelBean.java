package tv.danmaku.bili.api.bean;

import com.alibaba.fastjson.annotation.JSONField;
import tv.danmaku.bili.router.ChannelRoutes;

public class ChannelBean {
    @JSONField(name = "flag")
    public int flag;
    @JSONField(name = ChannelRoutes.CHANNEL_NAME)
    public String name;
}