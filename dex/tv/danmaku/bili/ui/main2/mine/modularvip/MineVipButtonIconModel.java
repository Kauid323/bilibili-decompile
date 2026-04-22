package tv.danmaku.bili.ui.main2.mine.modularvip;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MineVipModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0000H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonIconModel;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/IMineVipEnumModel;", "type", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonIconType;", "url", "", "controlledByFrequency", "", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonIconType;Ljava/lang/String;Z)V", "getType", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonIconType;", "getUrl", "()Ljava/lang/String;", "getControlledByFrequency", "()Z", "onRollback", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineVipButtonIconModel implements IMineVipEnumModel {
    public static final int $stable = 0;
    private final boolean controlledByFrequency;
    private final MineVipButtonIconType type;
    private final String url;

    public MineVipButtonIconModel() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ MineVipButtonIconModel copy$default(MineVipButtonIconModel mineVipButtonIconModel, MineVipButtonIconType mineVipButtonIconType, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            mineVipButtonIconType = mineVipButtonIconModel.type;
        }
        if ((i & 2) != 0) {
            str = mineVipButtonIconModel.url;
        }
        if ((i & 4) != 0) {
            z = mineVipButtonIconModel.controlledByFrequency;
        }
        return mineVipButtonIconModel.copy(mineVipButtonIconType, str, z);
    }

    public final MineVipButtonIconType component1() {
        return this.type;
    }

    public final String component2() {
        return this.url;
    }

    public final boolean component3() {
        return this.controlledByFrequency;
    }

    public final MineVipButtonIconModel copy(MineVipButtonIconType mineVipButtonIconType, String str, boolean z) {
        Intrinsics.checkNotNullParameter(mineVipButtonIconType, "type");
        Intrinsics.checkNotNullParameter(str, "url");
        return new MineVipButtonIconModel(mineVipButtonIconType, str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MineVipButtonIconModel) {
            MineVipButtonIconModel mineVipButtonIconModel = (MineVipButtonIconModel) obj;
            return this.type == mineVipButtonIconModel.type && Intrinsics.areEqual(this.url, mineVipButtonIconModel.url) && this.controlledByFrequency == mineVipButtonIconModel.controlledByFrequency;
        }
        return false;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.url.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.controlledByFrequency);
    }

    public String toString() {
        MineVipButtonIconType mineVipButtonIconType = this.type;
        String str = this.url;
        return "MineVipButtonIconModel(type=" + mineVipButtonIconType + ", url=" + str + ", controlledByFrequency=" + this.controlledByFrequency + ")";
    }

    public MineVipButtonIconModel(MineVipButtonIconType type, String url, boolean controlledByFrequency) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(url, "url");
        this.type = type;
        this.url = url;
        this.controlledByFrequency = controlledByFrequency;
    }

    public /* synthetic */ MineVipButtonIconModel(MineVipButtonIconType mineVipButtonIconType, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MineVipButtonIconType.NONE : mineVipButtonIconType, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? false : z);
    }

    public final MineVipButtonIconType getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.modularvip.IMineVipEnumModel
    public boolean getControlledByFrequency() {
        return this.controlledByFrequency;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.modularvip.IMineVipEnumModel
    public MineVipButtonIconModel onRollback() {
        return copy(MineVipButtonIconType.NONE, "", false);
    }
}