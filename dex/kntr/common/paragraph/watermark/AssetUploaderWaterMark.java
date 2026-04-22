package kntr.common.paragraph.watermark;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetUploaderWaterMark.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/common/paragraph/watermark/AssetUploaderWaterMark;", "", "enable", "", "position", "Lkntr/common/paragraph/watermark/WaterMarkPosition;", "<init>", "(ZLkntr/common/paragraph/watermark/WaterMarkPosition;)V", "getEnable", "()Z", "getPosition", "()Lkntr/common/paragraph/watermark/WaterMarkPosition;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "watermark_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetUploaderWaterMark {
    private final boolean enable;
    private final WaterMarkPosition position;

    public static /* synthetic */ AssetUploaderWaterMark copy$default(AssetUploaderWaterMark assetUploaderWaterMark, boolean z, WaterMarkPosition waterMarkPosition, int i, Object obj) {
        if ((i & 1) != 0) {
            z = assetUploaderWaterMark.enable;
        }
        if ((i & 2) != 0) {
            waterMarkPosition = assetUploaderWaterMark.position;
        }
        return assetUploaderWaterMark.copy(z, waterMarkPosition);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final WaterMarkPosition component2() {
        return this.position;
    }

    public final AssetUploaderWaterMark copy(boolean z, WaterMarkPosition waterMarkPosition) {
        Intrinsics.checkNotNullParameter(waterMarkPosition, "position");
        return new AssetUploaderWaterMark(z, waterMarkPosition);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AssetUploaderWaterMark) {
            AssetUploaderWaterMark assetUploaderWaterMark = (AssetUploaderWaterMark) obj;
            return this.enable == assetUploaderWaterMark.enable && this.position == assetUploaderWaterMark.position;
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enable) * 31) + this.position.hashCode();
    }

    public String toString() {
        boolean z = this.enable;
        return "AssetUploaderWaterMark(enable=" + z + ", position=" + this.position + ")";
    }

    public AssetUploaderWaterMark(boolean enable, WaterMarkPosition position) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.enable = enable;
        this.position = position;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final WaterMarkPosition getPosition() {
        return this.position;
    }
}