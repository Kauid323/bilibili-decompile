package tv.danmaku.bili.appwidget.hotword.data;

import com.alibaba.fastjson.annotation.JSONField;

public class WidgetButtonData {
    @JSONField(name = "icon")
    public String icon;
    @JSONField(name = "text")
    public String text;
    @JSONField(name = "url")
    public String url;

    public WidgetButtonData() {
    }

    public WidgetButtonData(String text, String icon, String url) {
        this.text = text;
        this.icon = icon;
        this.url = url;
    }
}