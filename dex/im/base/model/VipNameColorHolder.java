package im.base.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VipNameColorHolder.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lim/base/model/VipNameColorHolder;", "", "dayColor", "", "nightColor", "<init>", "(II)V", "getDayColor", "()I", "getNightColor", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VipNameColorHolder {
    private final int dayColor;
    private final int nightColor;

    public VipNameColorHolder() {
        this(0, 0, 3, null);
    }

    public static /* synthetic */ VipNameColorHolder copy$default(VipNameColorHolder vipNameColorHolder, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = vipNameColorHolder.dayColor;
        }
        if ((i4 & 2) != 0) {
            i3 = vipNameColorHolder.nightColor;
        }
        return vipNameColorHolder.copy(i2, i3);
    }

    public final int component1() {
        return this.dayColor;
    }

    public final int component2() {
        return this.nightColor;
    }

    public final VipNameColorHolder copy(int i2, int i3) {
        return new VipNameColorHolder(i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VipNameColorHolder) {
            VipNameColorHolder vipNameColorHolder = (VipNameColorHolder) obj;
            return this.dayColor == vipNameColorHolder.dayColor && this.nightColor == vipNameColorHolder.nightColor;
        }
        return false;
    }

    public int hashCode() {
        return (this.dayColor * 31) + this.nightColor;
    }

    public String toString() {
        int i2 = this.dayColor;
        return "VipNameColorHolder(dayColor=" + i2 + ", nightColor=" + this.nightColor + ")";
    }

    public VipNameColorHolder(int dayColor, int nightColor) {
        this.dayColor = dayColor;
        this.nightColor = nightColor;
    }

    public /* synthetic */ VipNameColorHolder(int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? 0 : i3);
    }

    public final int getDayColor() {
        return this.dayColor;
    }

    public final int getNightColor() {
        return this.nightColor;
    }
}