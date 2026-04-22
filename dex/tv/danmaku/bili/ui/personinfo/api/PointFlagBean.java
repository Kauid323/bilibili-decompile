package tv.danmaku.bili.ui.personinfo.api;

import com.alibaba.fastjson.annotation.JSONField;

public class PointFlagBean {
    @JSONField(name = "flag")
    public FlagBean flagBean;
    @JSONField(name = "link")
    public LinkBean linkBean;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class FlagBean {
        @JSONField(name = "medal")
        public boolean medal;
        @JSONField(name = "pendant")
        public boolean pendant;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class LinkBean {
        @JSONField(name = "medal_link")
        public String medal_link;
        @JSONField(name = "pendant_link")
        public String pendant_link;
    }
}