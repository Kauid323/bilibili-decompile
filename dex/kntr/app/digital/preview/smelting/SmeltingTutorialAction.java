package kntr.app.digital.preview.smelting;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SmeltingTutorialAction.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkntr/app/digital/preview/smelting/SmeltingTutorialAction;", RoomRecommendViewModel.EMPTY_CURSOR, "link", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SmeltingTutorialAction {
    public static final int $stable = 0;
    private final String link;

    public SmeltingTutorialAction() {
        this(null, 1, null);
    }

    public static /* synthetic */ SmeltingTutorialAction copy$default(SmeltingTutorialAction smeltingTutorialAction, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = smeltingTutorialAction.link;
        }
        return smeltingTutorialAction.copy(str);
    }

    public final String component1() {
        return this.link;
    }

    public final SmeltingTutorialAction copy(String str) {
        Intrinsics.checkNotNullParameter(str, "link");
        return new SmeltingTutorialAction(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SmeltingTutorialAction) && Intrinsics.areEqual(this.link, ((SmeltingTutorialAction) obj).link);
    }

    public int hashCode() {
        return this.link.hashCode();
    }

    public String toString() {
        return "SmeltingTutorialAction(link=" + this.link + ")";
    }

    public SmeltingTutorialAction(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        this.link = link;
    }

    public /* synthetic */ SmeltingTutorialAction(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str);
    }

    public final String getLink() {
        return this.link;
    }
}