package tv.danmaku.bili.ui.main2.resource;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import j$.util.Objects;
import java.util.List;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

public class SecondaryPage implements IHomeTab {
    public boolean defaultSelected;
    @JSONField(deserialize = false, serialize = false)
    private long expiredAt;
    public MainResourceManager.Extension extension;
    public int from;
    public String id;
    @JSONField(deserialize = false, serialize = false)
    private int pos;
    public String reporterId;
    public String reporterPos;
    public String title;
    public List<MainResourceManager.TopTabBubble> topTabBubble;
    public MainResourceManager.TopTabClickAnim topTabClickAnim;
    public String url;

    public SecondaryPage() {
    }

    public SecondaryPage(String id, String name, String url, int from, String reporterId) {
        this.id = id;
        this.title = name;
        this.url = url;
        this.from = from;
        this.reporterId = reporterId;
    }

    public boolean checkParams() {
        return (TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.title) || TextUtils.isEmpty(this.url)) ? false : true;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SecondaryPage that = (SecondaryPage) o;
        if (this.defaultSelected != that.defaultSelected || this.from != that.from || !Objects.equals(this.id, that.id) || !Objects.equals(this.title, that.title) || !Objects.equals(this.url, that.url) || !Objects.equals(this.reporterId, that.reporterId)) {
            return false;
        }
        return Objects.equals(this.reporterPos, that.reporterPos);
    }

    public int hashCode() {
        int result = this.id != null ? this.id.hashCode() : 0;
        return (((((((((((result * 31) + (this.title != null ? this.title.hashCode() : 0)) * 31) + (this.url != null ? this.url.hashCode() : 0)) * 31) + (this.defaultSelected ? 1 : 0)) * 31) + (this.reporterId != null ? this.reporterId.hashCode() : 0)) * 31) + (this.reporterPos != null ? this.reporterPos.hashCode() : 0)) * 31) + this.from;
    }

    public String toString() {
        return "SecondaryPage{id='" + this.id + "', title='" + this.title + "', url='" + this.url + "', defaultSelected=" + this.defaultSelected + ", reporterId='" + this.reporterId + "', expiredAt=" + this.expiredAt + '}';
    }

    @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
    @JSONField(deserialize = false, serialize = false)
    public String getReporterId() {
        return this.reporterId;
    }

    @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
    @JSONField(deserialize = false, serialize = false)
    public void setReporterId(String s) {
        this.reporterId = s;
    }

    @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
    @JSONField(deserialize = false, serialize = false)
    public boolean getDefaultSelected() {
        return this.defaultSelected;
    }

    @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
    @JSONField(deserialize = false, serialize = false)
    public void setDefaultSelected(boolean b) {
        this.defaultSelected = b;
    }

    @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
    @JSONField(deserialize = false, serialize = false)
    public int getPos() {
        return this.pos;
    }

    @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
    @JSONField(deserialize = false, serialize = false)
    public void setPos(int i) {
        this.pos = i;
    }

    @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
    @JSONField(deserialize = false, serialize = false)
    public long getExpiredAt() {
        return this.expiredAt;
    }

    @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
    @JSONField(deserialize = false, serialize = false)
    public void setExpiredAt(long l) {
        this.expiredAt = l;
    }

    @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
    @JSONField(deserialize = false, serialize = false)
    public String getUri() {
        return this.url;
    }

    @Override // tv.danmaku.bili.ui.main2.resource.IHomeTab
    @JSONField(deserialize = false, serialize = false)
    public void setUri(String s) {
        this.url = s;
    }
}