package tv.danmaku.bili.ui.main2.mine.modularvip;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MineVipModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0000H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipSubtitleModel;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/IMineVipEnumModel;", "subtitle", "", "colorResource", "Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "controlledByFrequency", "", "<init>", "(Ljava/lang/String;Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;Z)V", "getSubtitle", "()Ljava/lang/String;", "getColorResource", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "getControlledByFrequency", "()Z", "onRollback", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineVipSubtitleModel implements IMineVipEnumModel {
    public static final int $stable = 0;
    private final ColorResource colorResource;
    private final boolean controlledByFrequency;
    private final String subtitle;

    public MineVipSubtitleModel() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ MineVipSubtitleModel copy$default(MineVipSubtitleModel mineVipSubtitleModel, String str, ColorResource colorResource, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mineVipSubtitleModel.subtitle;
        }
        if ((i & 2) != 0) {
            colorResource = mineVipSubtitleModel.colorResource;
        }
        if ((i & 4) != 0) {
            z = mineVipSubtitleModel.controlledByFrequency;
        }
        return mineVipSubtitleModel.copy(str, colorResource, z);
    }

    public final String component1() {
        return this.subtitle;
    }

    public final ColorResource component2() {
        return this.colorResource;
    }

    public final boolean component3() {
        return this.controlledByFrequency;
    }

    public final MineVipSubtitleModel copy(String str, ColorResource colorResource, boolean z) {
        Intrinsics.checkNotNullParameter(str, "subtitle");
        Intrinsics.checkNotNullParameter(colorResource, "colorResource");
        return new MineVipSubtitleModel(str, colorResource, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MineVipSubtitleModel) {
            MineVipSubtitleModel mineVipSubtitleModel = (MineVipSubtitleModel) obj;
            return Intrinsics.areEqual(this.subtitle, mineVipSubtitleModel.subtitle) && Intrinsics.areEqual(this.colorResource, mineVipSubtitleModel.colorResource) && this.controlledByFrequency == mineVipSubtitleModel.controlledByFrequency;
        }
        return false;
    }

    public int hashCode() {
        return (((this.subtitle.hashCode() * 31) + this.colorResource.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.controlledByFrequency);
    }

    public String toString() {
        String str = this.subtitle;
        ColorResource colorResource = this.colorResource;
        return "MineVipSubtitleModel(subtitle=" + str + ", colorResource=" + colorResource + ", controlledByFrequency=" + this.controlledByFrequency + ")";
    }

    public MineVipSubtitleModel(String subtitle, ColorResource colorResource, boolean controlledByFrequency) {
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(colorResource, "colorResource");
        this.subtitle = subtitle;
        this.colorResource = colorResource;
        this.controlledByFrequency = controlledByFrequency;
    }

    public /* synthetic */ MineVipSubtitleModel(String str, ColorResource colorResource, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? MineVipModelKt.getFallbackSubtitleColor() : colorResource, (i & 4) != 0 ? false : z);
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final ColorResource getColorResource() {
        return this.colorResource;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.modularvip.IMineVipEnumModel
    public boolean getControlledByFrequency() {
        return this.controlledByFrequency;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.modularvip.IMineVipEnumModel
    public MineVipSubtitleModel onRollback() {
        return copy$default(this, null, MineVipModelKt.getFallbackSubtitleColor(), false, 1, null);
    }
}