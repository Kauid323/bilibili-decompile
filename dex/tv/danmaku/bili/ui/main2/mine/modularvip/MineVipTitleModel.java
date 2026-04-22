package tv.danmaku.bili.ui.main2.mine.modularvip;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: MineVipModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0000H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipTitleModel;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/IMineVipEnumModel;", ReportUtilKt.POS_TITLE, "", "colorResource", "Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "jumpLink", "controlledByFrequency", "", "<init>", "(Ljava/lang/String;Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;Ljava/lang/String;Z)V", "getTitle", "()Ljava/lang/String;", "getColorResource", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "getJumpLink", "getControlledByFrequency", "()Z", "onRollback", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineVipTitleModel implements IMineVipEnumModel {
    public static final int $stable = 0;
    private final ColorResource colorResource;
    private final boolean controlledByFrequency;
    private final String jumpLink;
    private final String title;

    public MineVipTitleModel() {
        this(null, null, null, false, 15, null);
    }

    public static /* synthetic */ MineVipTitleModel copy$default(MineVipTitleModel mineVipTitleModel, String str, ColorResource colorResource, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mineVipTitleModel.title;
        }
        if ((i & 2) != 0) {
            colorResource = mineVipTitleModel.colorResource;
        }
        if ((i & 4) != 0) {
            str2 = mineVipTitleModel.jumpLink;
        }
        if ((i & 8) != 0) {
            z = mineVipTitleModel.controlledByFrequency;
        }
        return mineVipTitleModel.copy(str, colorResource, str2, z);
    }

    public final String component1() {
        return this.title;
    }

    public final ColorResource component2() {
        return this.colorResource;
    }

    public final String component3() {
        return this.jumpLink;
    }

    public final boolean component4() {
        return this.controlledByFrequency;
    }

    public final MineVipTitleModel copy(String str, ColorResource colorResource, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(colorResource, "colorResource");
        Intrinsics.checkNotNullParameter(str2, "jumpLink");
        return new MineVipTitleModel(str, colorResource, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MineVipTitleModel) {
            MineVipTitleModel mineVipTitleModel = (MineVipTitleModel) obj;
            return Intrinsics.areEqual(this.title, mineVipTitleModel.title) && Intrinsics.areEqual(this.colorResource, mineVipTitleModel.colorResource) && Intrinsics.areEqual(this.jumpLink, mineVipTitleModel.jumpLink) && this.controlledByFrequency == mineVipTitleModel.controlledByFrequency;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.colorResource.hashCode()) * 31) + this.jumpLink.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.controlledByFrequency);
    }

    public String toString() {
        String str = this.title;
        ColorResource colorResource = this.colorResource;
        String str2 = this.jumpLink;
        return "MineVipTitleModel(title=" + str + ", colorResource=" + colorResource + ", jumpLink=" + str2 + ", controlledByFrequency=" + this.controlledByFrequency + ")";
    }

    public MineVipTitleModel(String title, ColorResource colorResource, String jumpLink, boolean controlledByFrequency) {
        Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(colorResource, "colorResource");
        Intrinsics.checkNotNullParameter(jumpLink, "jumpLink");
        this.title = title;
        this.colorResource = colorResource;
        this.jumpLink = jumpLink;
        this.controlledByFrequency = controlledByFrequency;
    }

    public /* synthetic */ MineVipTitleModel(String str, ColorResource colorResource, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? MineVipModelKt.getFallbackTitleColor() : colorResource, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? false : z);
    }

    public final String getTitle() {
        return this.title;
    }

    public final ColorResource getColorResource() {
        return this.colorResource;
    }

    public final String getJumpLink() {
        return this.jumpLink;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.modularvip.IMineVipEnumModel
    public boolean getControlledByFrequency() {
        return this.controlledByFrequency;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.modularvip.IMineVipEnumModel
    public MineVipTitleModel onRollback() {
        return copy$default(this, null, MineVipModelKt.getFallbackTitleColor(), null, false, 5, null);
    }
}