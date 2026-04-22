package tv.danmaku.bili.ui.main2.mine.modularvip;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MineVipModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0000H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipBackgroundModel;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/IMineVipEnumModel;", "layerColorResource", "Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "image", "", "controlledByFrequency", "", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;Ljava/lang/String;Z)V", "getLayerColorResource", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "getImage", "()Ljava/lang/String;", "getControlledByFrequency", "()Z", "onRollback", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineVipBackgroundModel implements IMineVipEnumModel {
    public static final int $stable = 0;
    private final boolean controlledByFrequency;
    private final String image;
    private final ColorResource layerColorResource;

    public MineVipBackgroundModel() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ MineVipBackgroundModel copy$default(MineVipBackgroundModel mineVipBackgroundModel, ColorResource colorResource, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            colorResource = mineVipBackgroundModel.layerColorResource;
        }
        if ((i & 2) != 0) {
            str = mineVipBackgroundModel.image;
        }
        if ((i & 4) != 0) {
            z = mineVipBackgroundModel.controlledByFrequency;
        }
        return mineVipBackgroundModel.copy(colorResource, str, z);
    }

    public final ColorResource component1() {
        return this.layerColorResource;
    }

    public final String component2() {
        return this.image;
    }

    public final boolean component3() {
        return this.controlledByFrequency;
    }

    public final MineVipBackgroundModel copy(ColorResource colorResource, String str, boolean z) {
        Intrinsics.checkNotNullParameter(colorResource, "layerColorResource");
        Intrinsics.checkNotNullParameter(str, "image");
        return new MineVipBackgroundModel(colorResource, str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MineVipBackgroundModel) {
            MineVipBackgroundModel mineVipBackgroundModel = (MineVipBackgroundModel) obj;
            return Intrinsics.areEqual(this.layerColorResource, mineVipBackgroundModel.layerColorResource) && Intrinsics.areEqual(this.image, mineVipBackgroundModel.image) && this.controlledByFrequency == mineVipBackgroundModel.controlledByFrequency;
        }
        return false;
    }

    public int hashCode() {
        return (((this.layerColorResource.hashCode() * 31) + this.image.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.controlledByFrequency);
    }

    public String toString() {
        ColorResource colorResource = this.layerColorResource;
        String str = this.image;
        return "MineVipBackgroundModel(layerColorResource=" + colorResource + ", image=" + str + ", controlledByFrequency=" + this.controlledByFrequency + ")";
    }

    public MineVipBackgroundModel(ColorResource layerColorResource, String image, boolean controlledByFrequency) {
        Intrinsics.checkNotNullParameter(layerColorResource, "layerColorResource");
        Intrinsics.checkNotNullParameter(image, "image");
        this.layerColorResource = layerColorResource;
        this.image = image;
        this.controlledByFrequency = controlledByFrequency;
    }

    public /* synthetic */ MineVipBackgroundModel(ColorResource colorResource, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MineVipModelKt.getFallbackBackgroundColor() : colorResource, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? false : z);
    }

    public final ColorResource getLayerColorResource() {
        return this.layerColorResource;
    }

    public final String getImage() {
        return this.image;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.modularvip.IMineVipEnumModel
    public boolean getControlledByFrequency() {
        return this.controlledByFrequency;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.modularvip.IMineVipEnumModel
    public MineVipBackgroundModel onRollback() {
        return copy(MineVipModelKt.getFallbackBackgroundColor(), "", false);
    }
}