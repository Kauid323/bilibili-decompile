package kntr.app.ad.ui.inspector.model;

import androidx.compose.ui.graphics.vector.ImageVector;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TabInfo.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lkntr/app/ad/ui/inspector/model/TabInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "index", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;I)V", "getTitle", "()Ljava/lang/String;", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getIndex", "()I", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TabInfo {
    public static final int $stable = 0;
    private final ImageVector icon;
    private final int index;
    private final String title;

    public static /* synthetic */ TabInfo copy$default(TabInfo tabInfo, String str, ImageVector imageVector, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tabInfo.title;
        }
        if ((i2 & 2) != 0) {
            imageVector = tabInfo.icon;
        }
        if ((i2 & 4) != 0) {
            i = tabInfo.index;
        }
        return tabInfo.copy(str, imageVector, i);
    }

    public final String component1() {
        return this.title;
    }

    public final ImageVector component2() {
        return this.icon;
    }

    public final int component3() {
        return this.index;
    }

    public final TabInfo copy(String str, ImageVector imageVector, int i) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(imageVector, "icon");
        return new TabInfo(str, imageVector, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TabInfo) {
            TabInfo tabInfo = (TabInfo) obj;
            return Intrinsics.areEqual(this.title, tabInfo.title) && Intrinsics.areEqual(this.icon, tabInfo.icon) && this.index == tabInfo.index;
        }
        return false;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.icon.hashCode()) * 31) + this.index;
    }

    public String toString() {
        String str = this.title;
        ImageVector imageVector = this.icon;
        return "TabInfo(title=" + str + ", icon=" + imageVector + ", index=" + this.index + ")";
    }

    public TabInfo(String title, ImageVector icon, int index) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.title = title;
        this.icon = icon;
        this.index = index;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ImageVector getIcon() {
        return this.icon;
    }

    public final int getIndex() {
        return this.index;
    }
}