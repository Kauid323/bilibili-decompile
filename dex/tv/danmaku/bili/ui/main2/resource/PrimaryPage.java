package tv.danmaku.bili.ui.main2.resource;

import android.text.TextUtils;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.drawableresolver.IDrawableResolver;
import java.util.List;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

public class PrimaryPage {
    public List<MainResourceManager.DialogItem> dialogItems;
    public int from;
    public IDrawableResolver icon;
    public String id;
    public boolean isPublish;
    public String normalIcon;
    public String reporterId;
    public String reporterPos;
    public String selectedIcon;
    public String title;
    public String url;

    public PrimaryPage() {
    }

    public PrimaryPage(String id, String name, IDrawableResolver icon, String url, int from, String reporterId) {
        this(id, name, icon, url, from);
        this.reporterId = reporterId;
    }

    public PrimaryPage(String id, String name, IDrawableResolver icon, String url, int from) {
        this.id = id;
        this.title = name;
        this.icon = icon;
        this.url = url;
        this.from = from;
    }

    public boolean checkParams() {
        return (TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.title) || TextUtils.isEmpty(this.url) || (this.icon == null && (TextUtils.isEmpty(this.normalIcon) || TextUtils.isEmpty(this.selectedIcon)))) ? false : true;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PrimaryPage that = (PrimaryPage) o;
        if ((!equalsIgnoreFrom() && this.from != that.from) || this.isPublish != that.isPublish) {
            return false;
        }
        if (this.id == null ? that.id != null : !this.id.equals(that.id)) {
            return false;
        }
        if (this.title == null ? that.title != null : !this.title.equals(that.title)) {
            return false;
        }
        if (this.url == null ? that.url != null : !this.url.equals(that.url)) {
            return false;
        }
        if (this.normalIcon == null ? that.normalIcon != null : !this.normalIcon.equals(that.normalIcon)) {
            return false;
        }
        if (this.selectedIcon == null ? that.selectedIcon != null : !this.selectedIcon.equals(that.selectedIcon)) {
            return false;
        }
        if (this.reporterId == null ? that.reporterId != null : !this.reporterId.equals(that.reporterId)) {
            return false;
        }
        if (this.reporterPos == null ? that.reporterPos != null : !this.reporterPos.equals(that.reporterPos)) {
            return false;
        }
        if (this.dialogItems != null) {
            return this.dialogItems.equals(that.dialogItems);
        }
        if (that.dialogItems == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = ((((((((((((this.id != null ? this.id.hashCode() : 0) * 31) + (this.title != null ? this.title.hashCode() : 0)) * 31) + (this.url != null ? this.url.hashCode() : 0)) * 31) + (this.normalIcon != null ? this.normalIcon.hashCode() : 0)) * 31) + (this.selectedIcon != null ? this.selectedIcon.hashCode() : 0)) * 31) + (this.reporterId != null ? this.reporterId.hashCode() : 0)) * 31) + (this.reporterPos != null ? this.reporterPos.hashCode() : 0);
        if (!equalsIgnoreFrom()) {
            result = (result * 31) + this.from;
        }
        return (((result * 31) + (this.dialogItems != null ? this.dialogItems.hashCode() : 0)) * 31) + (this.isPublish ? 1 : 0);
    }

    private boolean equalsIgnoreFrom() {
        return Boolean.TRUE.equals(ConfigManager.ab().get("home_primary_equals_ignore_from", true));
    }
}