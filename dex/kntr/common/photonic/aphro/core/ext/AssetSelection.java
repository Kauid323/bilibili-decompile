package kntr.common.photonic.aphro.core.ext;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreviewSelectionNotifier.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lkntr/common/photonic/aphro/core/ext/AssetSelection;", "", "assetUri", "", "selected", "", "<init>", "(Ljava/lang/String;Z)V", "getAssetUri", "()Ljava/lang/String;", "getSelected", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetSelection {
    public static final int $stable = 0;
    private final String assetUri;
    private final boolean selected;

    public static /* synthetic */ AssetSelection copy$default(AssetSelection assetSelection, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = assetSelection.assetUri;
        }
        if ((i & 2) != 0) {
            z = assetSelection.selected;
        }
        return assetSelection.copy(str, z);
    }

    public final String component1() {
        return this.assetUri;
    }

    public final boolean component2() {
        return this.selected;
    }

    public final AssetSelection copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "assetUri");
        return new AssetSelection(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AssetSelection) {
            AssetSelection assetSelection = (AssetSelection) obj;
            return Intrinsics.areEqual(this.assetUri, assetSelection.assetUri) && this.selected == assetSelection.selected;
        }
        return false;
    }

    public int hashCode() {
        return (this.assetUri.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.selected);
    }

    public String toString() {
        String str = this.assetUri;
        return "AssetSelection(assetUri=" + str + ", selected=" + this.selected + ")";
    }

    public AssetSelection(String assetUri, boolean selected) {
        Intrinsics.checkNotNullParameter(assetUri, "assetUri");
        this.assetUri = assetUri;
        this.selected = selected;
    }

    public final String getAssetUri() {
        return this.assetUri;
    }

    public final boolean getSelected() {
        return this.selected;
    }
}