package kntr.common.paragraph.input;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RichTextAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/common/paragraph/input/StartAsset;", "Lkntr/common/paragraph/input/RichTextAction;", "asset", "Lkntr/common/photonic/Asset;", "useOrigin", "", "<init>", "(Lkntr/common/photonic/Asset;Z)V", "getAsset", "()Lkntr/common/photonic/Asset;", "getUseOrigin", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class StartAsset implements RichTextAction {
    private final Asset asset;
    private final boolean useOrigin;

    public static /* synthetic */ StartAsset copy$default(StartAsset startAsset, Asset asset, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            asset = startAsset.asset;
        }
        if ((i & 2) != 0) {
            z = startAsset.useOrigin;
        }
        return startAsset.copy(asset, z);
    }

    public final Asset component1() {
        return this.asset;
    }

    public final boolean component2() {
        return this.useOrigin;
    }

    public final StartAsset copy(Asset asset, boolean z) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        return new StartAsset(asset, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StartAsset) {
            StartAsset startAsset = (StartAsset) obj;
            return Intrinsics.areEqual(this.asset, startAsset.asset) && this.useOrigin == startAsset.useOrigin;
        }
        return false;
    }

    public int hashCode() {
        return (this.asset.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useOrigin);
    }

    public String toString() {
        Asset asset = this.asset;
        return "StartAsset(asset=" + asset + ", useOrigin=" + this.useOrigin + ")";
    }

    public StartAsset(Asset asset, boolean useOrigin) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        this.asset = asset;
        this.useOrigin = useOrigin;
    }

    public final Asset getAsset() {
        return this.asset;
    }

    public final boolean getUseOrigin() {
        return this.useOrigin;
    }
}