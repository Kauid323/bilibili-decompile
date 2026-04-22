package tv.danmaku.bili.ui.tag.api;

import com.alibaba.fastjson.annotation.JSONField;

public class Tagv2 {
    @JSONField(name = "is_atten")
    public int attention;
    @JSONField(name = "count")
    public AttenCount count;
    @JSONField(name = "tag_id")
    public int tagId;
    @JSONField(name = "tag_name")
    public String tagName;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class AttenCount {
        @JSONField(name = "atten")
        public int atten;
        @JSONField(name = "use")
        public int use;
        @JSONField(name = "view")

        /* renamed from: view  reason: collision with root package name */
        public int f24view;
    }

    @JSONField(deserialize = false, serialize = false)
    public void setAttention(boolean atten) {
        this.attention = atten ? 1 : 0;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isAttention() {
        return this.attention == 1;
    }

    public int getAttentionCount() {
        if (this.count == null) {
            return 0;
        }
        return this.count.atten;
    }

    public void setAttentionCount(int count) {
        if (this.count != null) {
            this.count.atten = count;
        }
    }
}