package kntr.common.photonic.aphro.core;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AphroState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lkntr/common/photonic/aphro/core/AssetItemState;", "", "asset", "Lkntr/common/photonic/Asset;", "selectIndex", "", "<init>", "(Lkntr/common/photonic/Asset;I)V", "getAsset", "()Lkntr/common/photonic/Asset;", "getSelectIndex", "()I", "selected", "", "getSelected", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetItemState {
    public static final int $stable = 8;
    private final Asset asset;
    private final int selectIndex;

    public static /* synthetic */ AssetItemState copy$default(AssetItemState assetItemState, Asset asset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            asset = assetItemState.asset;
        }
        if ((i2 & 2) != 0) {
            i = assetItemState.selectIndex;
        }
        return assetItemState.copy(asset, i);
    }

    public final Asset component1() {
        return this.asset;
    }

    public final int component2() {
        return this.selectIndex;
    }

    public final AssetItemState copy(Asset asset, int i) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        return new AssetItemState(asset, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AssetItemState) {
            AssetItemState assetItemState = (AssetItemState) obj;
            return Intrinsics.areEqual(this.asset, assetItemState.asset) && this.selectIndex == assetItemState.selectIndex;
        }
        return false;
    }

    public int hashCode() {
        return (this.asset.hashCode() * 31) + this.selectIndex;
    }

    public String toString() {
        Asset asset = this.asset;
        return "AssetItemState(asset=" + asset + ", selectIndex=" + this.selectIndex + ")";
    }

    public AssetItemState(Asset asset, int selectIndex) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        this.asset = asset;
        this.selectIndex = selectIndex;
    }

    public final Asset getAsset() {
        return this.asset;
    }

    public final int getSelectIndex() {
        return this.selectIndex;
    }

    public final boolean getSelected() {
        return this.selectIndex >= 0;
    }
}