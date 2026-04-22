package kntr.app.digital.preview.avatarchoose;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvatarChooseActionModule.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lkntr/app/digital/preview/avatarchoose/AvatarChooseAction;", RoomRecommendViewModel.EMPTY_CURSOR, "showDigital", RoomRecommendViewModel.EMPTY_CURSOR, "digitalText", RoomRecommendViewModel.EMPTY_CURSOR, "needReport", "<init>", "(ZLjava/lang/String;Z)V", "getShowDigital", "()Z", "getDigitalText", "()Ljava/lang/String;", "getNeedReport", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AvatarChooseAction {
    public static final int $stable = 0;
    private final String digitalText;
    private final boolean needReport;
    private final boolean showDigital;

    public static /* synthetic */ AvatarChooseAction copy$default(AvatarChooseAction avatarChooseAction, boolean z, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = avatarChooseAction.showDigital;
        }
        if ((i & 2) != 0) {
            str = avatarChooseAction.digitalText;
        }
        if ((i & 4) != 0) {
            z2 = avatarChooseAction.needReport;
        }
        return avatarChooseAction.copy(z, str, z2);
    }

    public final boolean component1() {
        return this.showDigital;
    }

    public final String component2() {
        return this.digitalText;
    }

    public final boolean component3() {
        return this.needReport;
    }

    public final AvatarChooseAction copy(boolean z, String str, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "digitalText");
        return new AvatarChooseAction(z, str, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AvatarChooseAction) {
            AvatarChooseAction avatarChooseAction = (AvatarChooseAction) obj;
            return this.showDigital == avatarChooseAction.showDigital && Intrinsics.areEqual(this.digitalText, avatarChooseAction.digitalText) && this.needReport == avatarChooseAction.needReport;
        }
        return false;
    }

    public int hashCode() {
        return (((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showDigital) * 31) + this.digitalText.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.needReport);
    }

    public String toString() {
        boolean z = this.showDigital;
        String str = this.digitalText;
        return "AvatarChooseAction(showDigital=" + z + ", digitalText=" + str + ", needReport=" + this.needReport + ")";
    }

    public AvatarChooseAction(boolean showDigital, String digitalText, boolean needReport) {
        Intrinsics.checkNotNullParameter(digitalText, "digitalText");
        this.showDigital = showDigital;
        this.digitalText = digitalText;
        this.needReport = needReport;
    }

    public final boolean getShowDigital() {
        return this.showDigital;
    }

    public final String getDigitalText() {
        return this.digitalText;
    }

    public final boolean getNeedReport() {
        return this.needReport;
    }
}