package tv.danmaku.biliplayerv2.widget.function.danmaku.filter;

import com.alibaba.fastjson.annotation.JSONField;

public class GlobalBlockedKeywords extends BlockedKeywords<GlobalKeywordItem> {
    @JSONField(name = "ver")
    public long mVersion;
}