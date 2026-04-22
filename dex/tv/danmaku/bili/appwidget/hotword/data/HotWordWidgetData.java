package tv.danmaku.bili.appwidget.hotword.data;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

public class HotWordWidgetData {
    @JSONField(name = "widget_button")
    public List<WidgetButtonData> buttons;
    @JSONField(name = "hot_word")
    public String hotWord;
    @JSONField(name = "search_jump_link")
    public String searchJumpLink;
    @JSONField(name = "user_info")
    public WidgetUserInfo userInfo;
}