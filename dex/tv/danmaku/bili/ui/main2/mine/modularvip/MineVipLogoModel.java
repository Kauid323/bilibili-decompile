package tv.danmaku.bili.ui.main2.mine.modularvip;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MineVipModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0000H\u0016J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipLogoModel;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/IMineVipEnumModel;", "imageResource", "Ltv/danmaku/bili/ui/main2/mine/modularvip/ImageResource;", "controlledByFrequency", "", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/modularvip/ImageResource;Z)V", "getImageResource", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/ImageResource;", "getControlledByFrequency", "()Z", "onRollback", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineVipLogoModel implements IMineVipEnumModel {
    public static final int $stable = 0;
    private final boolean controlledByFrequency;
    private final ImageResource imageResource;

    public MineVipLogoModel() {
        this(null, false, 3, null);
    }

    public static /* synthetic */ MineVipLogoModel copy$default(MineVipLogoModel mineVipLogoModel, ImageResource imageResource, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            imageResource = mineVipLogoModel.imageResource;
        }
        if ((i & 2) != 0) {
            z = mineVipLogoModel.controlledByFrequency;
        }
        return mineVipLogoModel.copy(imageResource, z);
    }

    public final ImageResource component1() {
        return this.imageResource;
    }

    public final boolean component2() {
        return this.controlledByFrequency;
    }

    public final MineVipLogoModel copy(ImageResource imageResource, boolean z) {
        return new MineVipLogoModel(imageResource, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MineVipLogoModel) {
            MineVipLogoModel mineVipLogoModel = (MineVipLogoModel) obj;
            return Intrinsics.areEqual(this.imageResource, mineVipLogoModel.imageResource) && this.controlledByFrequency == mineVipLogoModel.controlledByFrequency;
        }
        return false;
    }

    public int hashCode() {
        return ((this.imageResource == null ? 0 : this.imageResource.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.controlledByFrequency);
    }

    public String toString() {
        ImageResource imageResource = this.imageResource;
        return "MineVipLogoModel(imageResource=" + imageResource + ", controlledByFrequency=" + this.controlledByFrequency + ")";
    }

    public MineVipLogoModel(ImageResource imageResource, boolean controlledByFrequency) {
        this.imageResource = imageResource;
        this.controlledByFrequency = controlledByFrequency;
    }

    public /* synthetic */ MineVipLogoModel(ImageResource imageResource, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : imageResource, (i & 2) != 0 ? false : z);
    }

    public final ImageResource getImageResource() {
        return this.imageResource;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.modularvip.IMineVipEnumModel
    public boolean getControlledByFrequency() {
        return this.controlledByFrequency;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.modularvip.IMineVipEnumModel
    public MineVipLogoModel onRollback() {
        return copy(null, false);
    }
}