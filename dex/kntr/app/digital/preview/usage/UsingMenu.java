package kntr.app.digital.preview.usage;

import BottomSheetItemData$;
import kntr.app.digital.preview.action.Action;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UsingMenu.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\r\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\b\u0002\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lkntr/app/digital/preview/usage/UsingMenu;", RoomRecommendViewModel.EMPTY_CURSOR, "available", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "badge", "Lkntr/app/digital/preview/usage/Badge;", "action", "Lkntr/app/digital/preview/action/Action;", "<init>", "(ZLjava/lang/String;Lkntr/app/digital/preview/usage/Badge;Lkntr/app/digital/preview/action/Action;)V", "getAvailable", "()Z", "getTitle", "()Ljava/lang/String;", "getBadge", "()Lkntr/app/digital/preview/usage/Badge;", "getAction", "()Lkntr/app/digital/preview/action/Action;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UsingMenu {
    public static final int $stable = 8;
    private final Action<?> action;
    private final boolean available;
    private final Badge badge;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UsingMenu copy$default(UsingMenu usingMenu, boolean z, String str, Badge badge, Action action, int i, Object obj) {
        if ((i & 1) != 0) {
            z = usingMenu.available;
        }
        if ((i & 2) != 0) {
            str = usingMenu.title;
        }
        if ((i & 4) != 0) {
            badge = usingMenu.badge;
        }
        if ((i & 8) != 0) {
            action = usingMenu.action;
        }
        return usingMenu.copy(z, str, badge, action);
    }

    public final boolean component1() {
        return this.available;
    }

    public final String component2() {
        return this.title;
    }

    public final Badge component3() {
        return this.badge;
    }

    public final Action<?> component4() {
        return this.action;
    }

    public final UsingMenu copy(boolean z, String str, Badge badge, Action<?> action) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(action, "action");
        return new UsingMenu(z, str, badge, action);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UsingMenu) {
            UsingMenu usingMenu = (UsingMenu) obj;
            return this.available == usingMenu.available && Intrinsics.areEqual(this.title, usingMenu.title) && Intrinsics.areEqual(this.badge, usingMenu.badge) && Intrinsics.areEqual(this.action, usingMenu.action);
        }
        return false;
    }

    public int hashCode() {
        return (((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.available) * 31) + this.title.hashCode()) * 31) + (this.badge == null ? 0 : this.badge.hashCode())) * 31) + this.action.hashCode();
    }

    public String toString() {
        boolean z = this.available;
        String str = this.title;
        Badge badge = this.badge;
        return "UsingMenu(available=" + z + ", title=" + str + ", badge=" + badge + ", action=" + this.action + ")";
    }

    public UsingMenu(boolean available, String title, Badge badge, Action<?> action) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(action, "action");
        this.available = available;
        this.title = title;
        this.badge = badge;
        this.action = action;
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Badge getBadge() {
        return this.badge;
    }

    public final Action<?> getAction() {
        return this.action;
    }
}