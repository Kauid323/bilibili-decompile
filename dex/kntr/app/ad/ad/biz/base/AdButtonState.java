package kntr.app.ad.ad.biz.base;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseAdUiState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lkntr/app/ad/ad/biz/base/AdButtonState;", RoomRecommendViewModel.EMPTY_CURSOR, "showButton", RoomRecommendViewModel.EMPTY_CURSOR, "type", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ZILjava/lang/String;)V", "getShowButton", "()Z", "getType", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdButtonState {
    public static final int $stable = 0;
    private final boolean showButton;
    private final String text;
    private final int type;

    public AdButtonState() {
        this(false, 0, null, 7, null);
    }

    public static /* synthetic */ AdButtonState copy$default(AdButtonState adButtonState, boolean z, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = adButtonState.showButton;
        }
        if ((i2 & 2) != 0) {
            i = adButtonState.type;
        }
        if ((i2 & 4) != 0) {
            str = adButtonState.text;
        }
        return adButtonState.copy(z, i, str);
    }

    public final boolean component1() {
        return this.showButton;
    }

    public final int component2() {
        return this.type;
    }

    public final String component3() {
        return this.text;
    }

    public final AdButtonState copy(boolean z, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new AdButtonState(z, i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdButtonState) {
            AdButtonState adButtonState = (AdButtonState) obj;
            return this.showButton == adButtonState.showButton && this.type == adButtonState.type && Intrinsics.areEqual(this.text, adButtonState.text);
        }
        return false;
    }

    public int hashCode() {
        return (((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showButton) * 31) + this.type) * 31) + this.text.hashCode();
    }

    public String toString() {
        boolean z = this.showButton;
        int i = this.type;
        return "AdButtonState(showButton=" + z + ", type=" + i + ", text=" + this.text + ")";
    }

    public AdButtonState(boolean showButton, int type, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.showButton = showButton;
        this.type = type;
        this.text = text;
    }

    public /* synthetic */ AdButtonState(boolean z, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str);
    }

    public final boolean getShowButton() {
        return this.showButton;
    }

    public final int getType() {
        return this.type;
    }

    public final String getText() {
        return this.text;
    }
}