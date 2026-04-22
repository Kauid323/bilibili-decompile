package kntr.app.digital.backpack.navigation;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/app/digital/backpack/navigation/NavigationModel;", RoomRecommendViewModel.EMPTY_CURSOR, "uFace", RoomRecommendViewModel.EMPTY_CURSOR, "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUFace", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationModel {
    public static final int $stable = 0;
    private final String title;
    private final String uFace;

    public static /* synthetic */ NavigationModel copy$default(NavigationModel navigationModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = navigationModel.uFace;
        }
        if ((i & 2) != 0) {
            str2 = navigationModel.title;
        }
        return navigationModel.copy(str, str2);
    }

    public final String component1() {
        return this.uFace;
    }

    public final String component2() {
        return this.title;
    }

    public final NavigationModel copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "uFace");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new NavigationModel(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NavigationModel) {
            NavigationModel navigationModel = (NavigationModel) obj;
            return Intrinsics.areEqual(this.uFace, navigationModel.uFace) && Intrinsics.areEqual(this.title, navigationModel.title);
        }
        return false;
    }

    public int hashCode() {
        return (this.uFace.hashCode() * 31) + this.title.hashCode();
    }

    public String toString() {
        String str = this.uFace;
        return "NavigationModel(uFace=" + str + ", title=" + this.title + ")";
    }

    public NavigationModel(String uFace, String title) {
        Intrinsics.checkNotNullParameter(uFace, "uFace");
        Intrinsics.checkNotNullParameter(title, "title");
        this.uFace = uFace;
        this.title = title;
    }

    public final String getUFace() {
        return this.uFace;
    }

    public final String getTitle() {
        return this.title;
    }
}