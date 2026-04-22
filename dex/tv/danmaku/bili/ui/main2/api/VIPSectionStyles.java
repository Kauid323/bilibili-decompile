package tv.danmaku.bili.ui.main2.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.lib.ui.garb.Garb;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.utils.GarbExtensionsKt;
import tv.danmaku.bili.utils.GarbStyle;

/* compiled from: VIPSectionData.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u001bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006*"}, d2 = {"Ltv/danmaku/bili/ui/main2/api/VIPSectionStyles;", "", "dayNDress", "Ltv/danmaku/bili/ui/main2/api/VIPSectionStyle;", "nightNDress", "dayDressLight", "dayDressDark", "nightDressLight", "nightDressDark", "<init>", "(Ltv/danmaku/bili/ui/main2/api/VIPSectionStyle;Ltv/danmaku/bili/ui/main2/api/VIPSectionStyle;Ltv/danmaku/bili/ui/main2/api/VIPSectionStyle;Ltv/danmaku/bili/ui/main2/api/VIPSectionStyle;Ltv/danmaku/bili/ui/main2/api/VIPSectionStyle;Ltv/danmaku/bili/ui/main2/api/VIPSectionStyle;)V", "getDayNDress", "()Ltv/danmaku/bili/ui/main2/api/VIPSectionStyle;", "setDayNDress", "(Ltv/danmaku/bili/ui/main2/api/VIPSectionStyle;)V", "getNightNDress", "setNightNDress", "getDayDressLight", "setDayDressLight", "getDayDressDark", "setDayDressDark", "getNightDressLight", "setNightDressLight", "getNightDressDark", "setNightDressDark", "getStyleByGarb", "garb", "Lcom/bilibili/lib/ui/garb/Garb;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class VIPSectionStyles {
    public static final int $stable = 8;
    @JSONField(name = "DAY_DRESS_DARK")
    private VIPSectionStyle dayDressDark;
    @JSONField(name = "DAY_DRESS_LIGHT")
    private VIPSectionStyle dayDressLight;
    @JSONField(name = "DAY_N_DRESS")
    private VIPSectionStyle dayNDress;
    @JSONField(name = "NIGHT_DRESS_DARK")
    private VIPSectionStyle nightDressDark;
    @JSONField(name = "NIGHT_DRESS_LIGHT")
    private VIPSectionStyle nightDressLight;
    @JSONField(name = "NIGHT_N_DRESS")
    private VIPSectionStyle nightNDress;

    /* compiled from: VIPSectionData.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GarbStyle.Mine.values().length];
            try {
                iArr[GarbStyle.Mine.PURE_WHITE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[GarbStyle.Mine.COLORFUL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[GarbStyle.Mine.NIGHT_NO_DRESS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[GarbStyle.Mine.DAY_DRESS_LIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[GarbStyle.Mine.DAY_DRESS_DARK.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[GarbStyle.Mine.NIGHT_DRESS_LIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[GarbStyle.Mine.NIGHT_DRESS_DARK.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public VIPSectionStyles() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ VIPSectionStyles copy$default(VIPSectionStyles vIPSectionStyles, VIPSectionStyle vIPSectionStyle, VIPSectionStyle vIPSectionStyle2, VIPSectionStyle vIPSectionStyle3, VIPSectionStyle vIPSectionStyle4, VIPSectionStyle vIPSectionStyle5, VIPSectionStyle vIPSectionStyle6, int i, Object obj) {
        if ((i & 1) != 0) {
            vIPSectionStyle = vIPSectionStyles.dayNDress;
        }
        if ((i & 2) != 0) {
            vIPSectionStyle2 = vIPSectionStyles.nightNDress;
        }
        VIPSectionStyle vIPSectionStyle7 = vIPSectionStyle2;
        if ((i & 4) != 0) {
            vIPSectionStyle3 = vIPSectionStyles.dayDressLight;
        }
        VIPSectionStyle vIPSectionStyle8 = vIPSectionStyle3;
        if ((i & 8) != 0) {
            vIPSectionStyle4 = vIPSectionStyles.dayDressDark;
        }
        VIPSectionStyle vIPSectionStyle9 = vIPSectionStyle4;
        if ((i & 16) != 0) {
            vIPSectionStyle5 = vIPSectionStyles.nightDressLight;
        }
        VIPSectionStyle vIPSectionStyle10 = vIPSectionStyle5;
        if ((i & 32) != 0) {
            vIPSectionStyle6 = vIPSectionStyles.nightDressDark;
        }
        return vIPSectionStyles.copy(vIPSectionStyle, vIPSectionStyle7, vIPSectionStyle8, vIPSectionStyle9, vIPSectionStyle10, vIPSectionStyle6);
    }

    public final VIPSectionStyle component1() {
        return this.dayNDress;
    }

    public final VIPSectionStyle component2() {
        return this.nightNDress;
    }

    public final VIPSectionStyle component3() {
        return this.dayDressLight;
    }

    public final VIPSectionStyle component4() {
        return this.dayDressDark;
    }

    public final VIPSectionStyle component5() {
        return this.nightDressLight;
    }

    public final VIPSectionStyle component6() {
        return this.nightDressDark;
    }

    public final VIPSectionStyles copy(VIPSectionStyle vIPSectionStyle, VIPSectionStyle vIPSectionStyle2, VIPSectionStyle vIPSectionStyle3, VIPSectionStyle vIPSectionStyle4, VIPSectionStyle vIPSectionStyle5, VIPSectionStyle vIPSectionStyle6) {
        return new VIPSectionStyles(vIPSectionStyle, vIPSectionStyle2, vIPSectionStyle3, vIPSectionStyle4, vIPSectionStyle5, vIPSectionStyle6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VIPSectionStyles) {
            VIPSectionStyles vIPSectionStyles = (VIPSectionStyles) obj;
            return Intrinsics.areEqual(this.dayNDress, vIPSectionStyles.dayNDress) && Intrinsics.areEqual(this.nightNDress, vIPSectionStyles.nightNDress) && Intrinsics.areEqual(this.dayDressLight, vIPSectionStyles.dayDressLight) && Intrinsics.areEqual(this.dayDressDark, vIPSectionStyles.dayDressDark) && Intrinsics.areEqual(this.nightDressLight, vIPSectionStyles.nightDressLight) && Intrinsics.areEqual(this.nightDressDark, vIPSectionStyles.nightDressDark);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.dayNDress == null ? 0 : this.dayNDress.hashCode()) * 31) + (this.nightNDress == null ? 0 : this.nightNDress.hashCode())) * 31) + (this.dayDressLight == null ? 0 : this.dayDressLight.hashCode())) * 31) + (this.dayDressDark == null ? 0 : this.dayDressDark.hashCode())) * 31) + (this.nightDressLight == null ? 0 : this.nightDressLight.hashCode())) * 31) + (this.nightDressDark != null ? this.nightDressDark.hashCode() : 0);
    }

    public String toString() {
        VIPSectionStyle vIPSectionStyle = this.dayNDress;
        VIPSectionStyle vIPSectionStyle2 = this.nightNDress;
        VIPSectionStyle vIPSectionStyle3 = this.dayDressLight;
        VIPSectionStyle vIPSectionStyle4 = this.dayDressDark;
        VIPSectionStyle vIPSectionStyle5 = this.nightDressLight;
        return "VIPSectionStyles(dayNDress=" + vIPSectionStyle + ", nightNDress=" + vIPSectionStyle2 + ", dayDressLight=" + vIPSectionStyle3 + ", dayDressDark=" + vIPSectionStyle4 + ", nightDressLight=" + vIPSectionStyle5 + ", nightDressDark=" + this.nightDressDark + ")";
    }

    public VIPSectionStyles(VIPSectionStyle dayNDress, VIPSectionStyle nightNDress, VIPSectionStyle dayDressLight, VIPSectionStyle dayDressDark, VIPSectionStyle nightDressLight, VIPSectionStyle nightDressDark) {
        this.dayNDress = dayNDress;
        this.nightNDress = nightNDress;
        this.dayDressLight = dayDressLight;
        this.dayDressDark = dayDressDark;
        this.nightDressLight = nightDressLight;
        this.nightDressDark = nightDressDark;
    }

    public /* synthetic */ VIPSectionStyles(VIPSectionStyle vIPSectionStyle, VIPSectionStyle vIPSectionStyle2, VIPSectionStyle vIPSectionStyle3, VIPSectionStyle vIPSectionStyle4, VIPSectionStyle vIPSectionStyle5, VIPSectionStyle vIPSectionStyle6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : vIPSectionStyle, (i & 2) != 0 ? null : vIPSectionStyle2, (i & 4) != 0 ? null : vIPSectionStyle3, (i & 8) != 0 ? null : vIPSectionStyle4, (i & 16) != 0 ? null : vIPSectionStyle5, (i & 32) != 0 ? null : vIPSectionStyle6);
    }

    public final VIPSectionStyle getDayNDress() {
        return this.dayNDress;
    }

    public final void setDayNDress(VIPSectionStyle vIPSectionStyle) {
        this.dayNDress = vIPSectionStyle;
    }

    public final VIPSectionStyle getNightNDress() {
        return this.nightNDress;
    }

    public final void setNightNDress(VIPSectionStyle vIPSectionStyle) {
        this.nightNDress = vIPSectionStyle;
    }

    public final VIPSectionStyle getDayDressLight() {
        return this.dayDressLight;
    }

    public final void setDayDressLight(VIPSectionStyle vIPSectionStyle) {
        this.dayDressLight = vIPSectionStyle;
    }

    public final VIPSectionStyle getDayDressDark() {
        return this.dayDressDark;
    }

    public final void setDayDressDark(VIPSectionStyle vIPSectionStyle) {
        this.dayDressDark = vIPSectionStyle;
    }

    public final VIPSectionStyle getNightDressLight() {
        return this.nightDressLight;
    }

    public final void setNightDressLight(VIPSectionStyle vIPSectionStyle) {
        this.nightDressLight = vIPSectionStyle;
    }

    public final VIPSectionStyle getNightDressDark() {
        return this.nightDressDark;
    }

    public final void setNightDressDark(VIPSectionStyle vIPSectionStyle) {
        this.nightDressDark = vIPSectionStyle;
    }

    public final VIPSectionStyle getStyleByGarb(Garb garb) {
        Intrinsics.checkNotNullParameter(garb, "garb");
        switch (WhenMappings.$EnumSwitchMapping$0[GarbExtensionsKt.getMineStyle(garb).ordinal()]) {
            case 1:
                return this.dayNDress;
            case 2:
                return this.dayNDress;
            case 3:
                return this.nightNDress;
            case 4:
                return this.dayDressLight;
            case 5:
                return this.dayDressDark;
            case 6:
                return this.nightDressLight;
            case 7:
                return this.nightDressDark;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}