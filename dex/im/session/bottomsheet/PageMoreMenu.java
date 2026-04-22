package im.session.bottomsheet;

import im.session.model.IMThreeDotItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetHolder.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lim/session/bottomsheet/PageMoreMenu;", "Lim/session/bottomsheet/BottomSheetHolder;", "threeDotItems", "", "Lim/session/model/IMThreeDotItem;", "<init>", "(Ljava/util/List;)V", "getThreeDotItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "session-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PageMoreMenu implements BottomSheetHolder {
    public static final int $stable = 0;
    private final List<IMThreeDotItem> threeDotItems;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageMoreMenu copy$default(PageMoreMenu pageMoreMenu, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = pageMoreMenu.threeDotItems;
        }
        return pageMoreMenu.copy(list);
    }

    public final List<IMThreeDotItem> component1() {
        return this.threeDotItems;
    }

    public final PageMoreMenu copy(List<IMThreeDotItem> list) {
        Intrinsics.checkNotNullParameter(list, "threeDotItems");
        return new PageMoreMenu(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PageMoreMenu) && Intrinsics.areEqual(this.threeDotItems, ((PageMoreMenu) obj).threeDotItems);
    }

    public int hashCode() {
        return this.threeDotItems.hashCode();
    }

    public String toString() {
        return "PageMoreMenu(threeDotItems=" + this.threeDotItems + ")";
    }

    public PageMoreMenu(List<IMThreeDotItem> list) {
        Intrinsics.checkNotNullParameter(list, "threeDotItems");
        this.threeDotItems = list;
    }

    public final List<IMThreeDotItem> getThreeDotItems() {
        return this.threeDotItems;
    }
}