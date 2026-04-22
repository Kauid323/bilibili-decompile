package tv.danmaku.bili.ui.offline.api;

import com.alibaba.fastjson.annotation.JSONField;

public class EpPlayable {
    public long epid;
    @JSONField(name = "is_playable")
    public int isPlayable = 1;
}