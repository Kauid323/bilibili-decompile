package tv.danmaku.bili.ui.main2.mine;

import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;

public class MinePage {
    public long mId;
    public MenuGroup.Item mMenuItem;
    public IMinePageInfo mPageInfo;
    public String mUrl;

    public MinePage(long id, String url, MenuGroup.Item menuItem, IMinePageInfo pageInfo) {
        this.mId = id;
        this.mUrl = url;
        this.mMenuItem = menuItem;
        this.mPageInfo = pageInfo;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MinePage that = (MinePage) o;
        if (this.mId == that.mId) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Long.valueOf(this.mId).hashCode();
    }
}