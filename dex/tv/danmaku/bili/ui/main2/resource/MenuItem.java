package tv.danmaku.bili.ui.main2.resource;

import android.text.TextUtils;
import com.bilibili.lib.drawableresolver.IDrawableResolver;

public class MenuItem {
    public String animatorIconUrl;
    public int count;
    public int from;
    public IDrawableResolver icon;
    public String iconUrl;
    public String id;
    public String lottieJsonUrl;
    public String reporterId;
    public String reporterPos;
    public String title;
    public int type;
    public String url;

    public MenuItem() {
    }

    public MenuItem(String id, String name, IDrawableResolver icon, String url, int from) {
        this.id = id;
        this.title = name;
        this.icon = icon;
        this.url = url;
        this.from = from;
    }

    public MenuItem(String id, String name, IDrawableResolver icon, String url, int from, int type, int count) {
        this.id = id;
        this.title = name;
        this.icon = icon;
        this.url = url;
        this.from = from;
        this.type = type;
        this.count = count;
    }

    public boolean checkParams() {
        return (TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.url) || (this.icon == null && TextUtils.isEmpty(this.iconUrl))) ? false : true;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MenuItem menuItem = (MenuItem) o;
        if (this.id == null ? menuItem.id != null : !this.id.equals(menuItem.id)) {
            return false;
        }
        if (this.title == null ? menuItem.title != null : !this.title.equals(menuItem.title)) {
            return false;
        }
        if (this.url == null ? menuItem.url != null : !this.url.equals(menuItem.url)) {
            return false;
        }
        if (this.iconUrl == null ? menuItem.iconUrl != null : !this.iconUrl.equals(menuItem.iconUrl)) {
            return false;
        }
        if (this.reporterId == null ? menuItem.reporterId != null : !this.reporterId.equals(menuItem.reporterId)) {
            return false;
        }
        if (this.reporterPos == null ? menuItem.reporterPos != null : !this.reporterPos.equals(menuItem.reporterPos)) {
            return false;
        }
        if (this.animatorIconUrl == null ? menuItem.animatorIconUrl != null : !this.animatorIconUrl.equals(menuItem.animatorIconUrl)) {
            return false;
        }
        if (this.lottieJsonUrl == null ? menuItem.lottieJsonUrl != null : !this.lottieJsonUrl.equals(menuItem.lottieJsonUrl)) {
            return false;
        }
        if (this.type == menuItem.type && this.count == menuItem.count) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = this.id != null ? this.id.hashCode() : 0;
        return (((((((((((((((((((result * 31) + (this.title != null ? this.title.hashCode() : 0)) * 31) + (this.url != null ? this.url.hashCode() : 0)) * 31) + (this.iconUrl != null ? this.iconUrl.hashCode() : 0)) * 31) + (this.reporterId != null ? this.reporterId.hashCode() : 0)) * 31) + (this.reporterPos != null ? this.reporterPos.hashCode() : 0)) * 31) + this.from) * 31) + this.type) * 31) + this.count) * 31) + (this.animatorIconUrl != null ? this.animatorIconUrl.hashCode() : 0)) * 31) + (this.lottieJsonUrl != null ? this.lottieJsonUrl.hashCode() : 0);
    }
}