package kntr.app.digital.preview.viewall;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewAllActionModule.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/app/digital/preview/viewall/ViewAllAction;", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "link", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getLink", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ViewAllAction {
    public static final int $stable = 0;
    private final String link;
    private final String title;

    public static /* synthetic */ ViewAllAction copy$default(ViewAllAction viewAllAction, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = viewAllAction.title;
        }
        if ((i & 2) != 0) {
            str2 = viewAllAction.link;
        }
        return viewAllAction.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.link;
    }

    public final ViewAllAction copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "link");
        return new ViewAllAction(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ViewAllAction) {
            ViewAllAction viewAllAction = (ViewAllAction) obj;
            return Intrinsics.areEqual(this.title, viewAllAction.title) && Intrinsics.areEqual(this.link, viewAllAction.link);
        }
        return false;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.link.hashCode();
    }

    public String toString() {
        String str = this.title;
        return "ViewAllAction(title=" + str + ", link=" + this.link + ")";
    }

    public ViewAllAction(String title, String link) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(link, "link");
        this.title = title;
        this.link = link;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getLink() {
        return this.link;
    }
}