package tv.danmaku.bili.ui.main2.mine.modularvip;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MineVipModel.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0018\u001a\u00020\u0000H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonModel;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/IMineVipEnumModel;", "backgroundColorResource", "Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "style", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonStyle;", "buttonText", "", "buttonTextColorResource", "jumpLink", "controlledByFrequency", "", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonStyle;Ljava/lang/String;Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;Ljava/lang/String;Z)V", "getBackgroundColorResource", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "getStyle", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonStyle;", "getButtonText", "()Ljava/lang/String;", "getButtonTextColorResource", "getJumpLink", "getControlledByFrequency", "()Z", "onRollback", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineVipButtonModel implements IMineVipEnumModel {
    public static final int $stable = 0;
    private final ColorResource backgroundColorResource;
    private final String buttonText;
    private final ColorResource buttonTextColorResource;
    private final boolean controlledByFrequency;
    private final String jumpLink;
    private final MineVipButtonStyle style;

    public MineVipButtonModel() {
        this(null, null, null, null, null, false, 63, null);
    }

    public static /* synthetic */ MineVipButtonModel copy$default(MineVipButtonModel mineVipButtonModel, ColorResource colorResource, MineVipButtonStyle mineVipButtonStyle, String str, ColorResource colorResource2, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            colorResource = mineVipButtonModel.backgroundColorResource;
        }
        if ((i & 2) != 0) {
            mineVipButtonStyle = mineVipButtonModel.style;
        }
        MineVipButtonStyle mineVipButtonStyle2 = mineVipButtonStyle;
        if ((i & 4) != 0) {
            str = mineVipButtonModel.buttonText;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            colorResource2 = mineVipButtonModel.buttonTextColorResource;
        }
        ColorResource colorResource3 = colorResource2;
        if ((i & 16) != 0) {
            str2 = mineVipButtonModel.jumpLink;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            z = mineVipButtonModel.controlledByFrequency;
        }
        return mineVipButtonModel.copy(colorResource, mineVipButtonStyle2, str3, colorResource3, str4, z);
    }

    public final ColorResource component1() {
        return this.backgroundColorResource;
    }

    public final MineVipButtonStyle component2() {
        return this.style;
    }

    public final String component3() {
        return this.buttonText;
    }

    public final ColorResource component4() {
        return this.buttonTextColorResource;
    }

    public final String component5() {
        return this.jumpLink;
    }

    public final boolean component6() {
        return this.controlledByFrequency;
    }

    public final MineVipButtonModel copy(ColorResource colorResource, MineVipButtonStyle mineVipButtonStyle, String str, ColorResource colorResource2, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(colorResource, "backgroundColorResource");
        Intrinsics.checkNotNullParameter(mineVipButtonStyle, "style");
        Intrinsics.checkNotNullParameter(str, "buttonText");
        Intrinsics.checkNotNullParameter(colorResource2, "buttonTextColorResource");
        Intrinsics.checkNotNullParameter(str2, "jumpLink");
        return new MineVipButtonModel(colorResource, mineVipButtonStyle, str, colorResource2, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MineVipButtonModel) {
            MineVipButtonModel mineVipButtonModel = (MineVipButtonModel) obj;
            return Intrinsics.areEqual(this.backgroundColorResource, mineVipButtonModel.backgroundColorResource) && this.style == mineVipButtonModel.style && Intrinsics.areEqual(this.buttonText, mineVipButtonModel.buttonText) && Intrinsics.areEqual(this.buttonTextColorResource, mineVipButtonModel.buttonTextColorResource) && Intrinsics.areEqual(this.jumpLink, mineVipButtonModel.jumpLink) && this.controlledByFrequency == mineVipButtonModel.controlledByFrequency;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.backgroundColorResource.hashCode() * 31) + this.style.hashCode()) * 31) + this.buttonText.hashCode()) * 31) + this.buttonTextColorResource.hashCode()) * 31) + this.jumpLink.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.controlledByFrequency);
    }

    public String toString() {
        ColorResource colorResource = this.backgroundColorResource;
        MineVipButtonStyle mineVipButtonStyle = this.style;
        String str = this.buttonText;
        ColorResource colorResource2 = this.buttonTextColorResource;
        String str2 = this.jumpLink;
        return "MineVipButtonModel(backgroundColorResource=" + colorResource + ", style=" + mineVipButtonStyle + ", buttonText=" + str + ", buttonTextColorResource=" + colorResource2 + ", jumpLink=" + str2 + ", controlledByFrequency=" + this.controlledByFrequency + ")";
    }

    public MineVipButtonModel(ColorResource backgroundColorResource, MineVipButtonStyle style, String buttonText, ColorResource buttonTextColorResource, String jumpLink, boolean controlledByFrequency) {
        Intrinsics.checkNotNullParameter(backgroundColorResource, "backgroundColorResource");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(buttonTextColorResource, "buttonTextColorResource");
        Intrinsics.checkNotNullParameter(jumpLink, "jumpLink");
        this.backgroundColorResource = backgroundColorResource;
        this.style = style;
        this.buttonText = buttonText;
        this.buttonTextColorResource = buttonTextColorResource;
        this.jumpLink = jumpLink;
        this.controlledByFrequency = controlledByFrequency;
    }

    public /* synthetic */ MineVipButtonModel(ColorResource colorResource, MineVipButtonStyle mineVipButtonStyle, String str, ColorResource colorResource2, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MineVipModelKt.getFallbackButtonSolidColor() : colorResource, (i & 2) != 0 ? MineVipButtonStyle.FILL : mineVipButtonStyle, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? MineVipModelKt.getFallbackButtonTextColor() : colorResource2, (i & 16) == 0 ? str2 : "", (i & 32) != 0 ? false : z);
    }

    public final ColorResource getBackgroundColorResource() {
        return this.backgroundColorResource;
    }

    public final MineVipButtonStyle getStyle() {
        return this.style;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final ColorResource getButtonTextColorResource() {
        return this.buttonTextColorResource;
    }

    public final String getJumpLink() {
        return this.jumpLink;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.modularvip.IMineVipEnumModel
    public boolean getControlledByFrequency() {
        return this.controlledByFrequency;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.modularvip.IMineVipEnumModel
    public MineVipButtonModel onRollback() {
        return copy$default(this, MineVipModelKt.getFallbackButtonSolidColor(), MineVipButtonStyle.FILL, null, MineVipModelKt.getFallbackButtonTextColor(), null, false, 20, null);
    }
}