package kntr.app.digital.preview.viewmore;

import java.util.List;
import kntr.app.digital.preview.action.Action;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewMoreActionModule.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/app/digital/preview/viewmore/ViewMoreAction;", RoomRecommendViewModel.EMPTY_CURSOR, "items", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/viewmore/ViewMoreAction$Item;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Item", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ViewMoreAction {
    public static final int $stable = 8;
    private final List<Item> items;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewMoreAction copy$default(ViewMoreAction viewMoreAction, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = viewMoreAction.items;
        }
        return viewMoreAction.copy(list);
    }

    public final List<Item> component1() {
        return this.items;
    }

    public final ViewMoreAction copy(List<Item> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new ViewMoreAction(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ViewMoreAction) && Intrinsics.areEqual(this.items, ((ViewMoreAction) obj).items);
    }

    public int hashCode() {
        return this.items.hashCode();
    }

    public String toString() {
        return "ViewMoreAction(items=" + this.items + ")";
    }

    public ViewMoreAction(List<Item> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.items = list;
    }

    public final List<Item> getItems() {
        return this.items;
    }

    /* compiled from: ViewMoreActionModule.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\r\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/app/digital/preview/viewmore/ViewMoreAction$Item;", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "action", "Lkntr/app/digital/preview/action/Action;", "<init>", "(Ljava/lang/String;Lkntr/app/digital/preview/action/Action;)V", "getTitle", "()Ljava/lang/String;", "getAction", "()Lkntr/app/digital/preview/action/Action;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Item {
        public static final int $stable = 8;
        private final Action<?> action;
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Item copy$default(Item item, String str, Action action, int i, Object obj) {
            if ((i & 1) != 0) {
                str = item.title;
            }
            if ((i & 2) != 0) {
                action = item.action;
            }
            return item.copy(str, action);
        }

        public final String component1() {
            return this.title;
        }

        public final Action<?> component2() {
            return this.action;
        }

        public final Item copy(String str, Action<?> action) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(action, "action");
            return new Item(str, action);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Item) {
                Item item = (Item) obj;
                return Intrinsics.areEqual(this.title, item.title) && Intrinsics.areEqual(this.action, item.action);
            }
            return false;
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.action.hashCode();
        }

        public String toString() {
            String str = this.title;
            return "Item(title=" + str + ", action=" + this.action + ")";
        }

        public Item(String title, Action<?> action) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(action, "action");
            this.title = title;
            this.action = action;
        }

        public final String getTitle() {
            return this.title;
        }

        public final Action<?> getAction() {
            return this.action;
        }
    }
}