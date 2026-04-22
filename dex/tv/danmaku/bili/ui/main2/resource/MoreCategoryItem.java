package tv.danmaku.bili.ui.main2.resource;

import android.text.TextUtils;
import tv.danmaku.bili.router.SearchRoutes;

public class MoreCategoryItem {
    public static final int NORMAL = 1;
    public static final int SEARCH = 2;
    public String icon;
    private int type;
    public String uri;

    public MoreCategoryItem(String uri, String icon) {
        this(uri, icon, 1);
    }

    public MoreCategoryItem(String uri, String icon, int type) {
        this.uri = uri;
        this.icon = icon;
        this.type = type;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof MoreCategoryItem) {
            return TextUtils.equals(this.uri, ((MoreCategoryItem) o).uri) && TextUtils.equals(this.icon, ((MoreCategoryItem) o).icon);
        }
        return false;
    }

    public int hashCode() {
        int result = this.uri == null ? 0 : this.uri.hashCode();
        return (result * 31) + (this.icon != null ? this.icon.hashCode() : 0);
    }

    public boolean isSearchIcon() {
        return this.type == 2 || SearchRoutes.URI_BILIBILI_SEARCH.equals(this.uri);
    }

    public boolean isNormal() {
        return this.type == 1;
    }
}