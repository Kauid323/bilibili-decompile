package kntr.app.digital.backpack.topbackground;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TopBackgroundModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/backpack/topbackground/TopBackgroundModel;", RoomRecommendViewModel.EMPTY_CURSOR, "backgroundImage", RoomRecommendViewModel.EMPTY_CURSOR, "decomposedButton", "Lkntr/app/digital/backpack/topbackground/TopButtonModel;", "giftButton", "<init>", "(Ljava/lang/String;Lkntr/app/digital/backpack/topbackground/TopButtonModel;Lkntr/app/digital/backpack/topbackground/TopButtonModel;)V", "getBackgroundImage", "()Ljava/lang/String;", "getDecomposedButton", "()Lkntr/app/digital/backpack/topbackground/TopButtonModel;", "getGiftButton", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TopBackgroundModel {
    public static final int $stable = 0;
    private final String backgroundImage;
    private final TopButtonModel decomposedButton;
    private final TopButtonModel giftButton;

    public static /* synthetic */ TopBackgroundModel copy$default(TopBackgroundModel topBackgroundModel, String str, TopButtonModel topButtonModel, TopButtonModel topButtonModel2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = topBackgroundModel.backgroundImage;
        }
        if ((i & 2) != 0) {
            topButtonModel = topBackgroundModel.decomposedButton;
        }
        if ((i & 4) != 0) {
            topButtonModel2 = topBackgroundModel.giftButton;
        }
        return topBackgroundModel.copy(str, topButtonModel, topButtonModel2);
    }

    public final String component1() {
        return this.backgroundImage;
    }

    public final TopButtonModel component2() {
        return this.decomposedButton;
    }

    public final TopButtonModel component3() {
        return this.giftButton;
    }

    public final TopBackgroundModel copy(String str, TopButtonModel topButtonModel, TopButtonModel topButtonModel2) {
        Intrinsics.checkNotNullParameter(str, "backgroundImage");
        return new TopBackgroundModel(str, topButtonModel, topButtonModel2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TopBackgroundModel) {
            TopBackgroundModel topBackgroundModel = (TopBackgroundModel) obj;
            return Intrinsics.areEqual(this.backgroundImage, topBackgroundModel.backgroundImage) && Intrinsics.areEqual(this.decomposedButton, topBackgroundModel.decomposedButton) && Intrinsics.areEqual(this.giftButton, topBackgroundModel.giftButton);
        }
        return false;
    }

    public int hashCode() {
        return (((this.backgroundImage.hashCode() * 31) + (this.decomposedButton == null ? 0 : this.decomposedButton.hashCode())) * 31) + (this.giftButton != null ? this.giftButton.hashCode() : 0);
    }

    public String toString() {
        String str = this.backgroundImage;
        TopButtonModel topButtonModel = this.decomposedButton;
        return "TopBackgroundModel(backgroundImage=" + str + ", decomposedButton=" + topButtonModel + ", giftButton=" + this.giftButton + ")";
    }

    public TopBackgroundModel(String backgroundImage, TopButtonModel decomposedButton, TopButtonModel giftButton) {
        Intrinsics.checkNotNullParameter(backgroundImage, "backgroundImage");
        this.backgroundImage = backgroundImage;
        this.decomposedButton = decomposedButton;
        this.giftButton = giftButton;
    }

    public final String getBackgroundImage() {
        return this.backgroundImage;
    }

    public final TopButtonModel getDecomposedButton() {
        return this.decomposedButton;
    }

    public final TopButtonModel getGiftButton() {
        return this.giftButton;
    }
}