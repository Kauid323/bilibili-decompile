package kntr.common.photonic.aphro.core;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AphroState.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB'\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001f"}, d2 = {"Lkntr/common/photonic/aphro/core/AspectRadioLimit;", "", "min", "", "max", "toastOnTooSmall", "", "toastOnTooLarge", "<init>", "(FFLjava/lang/String;Ljava/lang/String;)V", "toastOnExceeded", "(FFLjava/lang/String;)V", "getMin", "()F", "getMax", "getToastOnTooSmall", "()Ljava/lang/String;", "getToastOnTooLarge", "isInLimit", "", "radio", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AspectRadioLimit {
    public static final int $stable = 0;
    private final float max;
    private final float min;
    private final String toastOnTooLarge;
    private final String toastOnTooSmall;

    public AspectRadioLimit() {
        this(0.0f, 0.0f, null, null, 15, null);
    }

    public static /* synthetic */ AspectRadioLimit copy$default(AspectRadioLimit aspectRadioLimit, float f, float f2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = aspectRadioLimit.min;
        }
        if ((i & 2) != 0) {
            f2 = aspectRadioLimit.max;
        }
        if ((i & 4) != 0) {
            str = aspectRadioLimit.toastOnTooSmall;
        }
        if ((i & 8) != 0) {
            str2 = aspectRadioLimit.toastOnTooLarge;
        }
        return aspectRadioLimit.copy(f, f2, str, str2);
    }

    public final float component1() {
        return this.min;
    }

    public final float component2() {
        return this.max;
    }

    public final String component3() {
        return this.toastOnTooSmall;
    }

    public final String component4() {
        return this.toastOnTooLarge;
    }

    public final AspectRadioLimit copy(float f, float f2, String str, String str2) {
        return new AspectRadioLimit(f, f2, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AspectRadioLimit) {
            AspectRadioLimit aspectRadioLimit = (AspectRadioLimit) obj;
            return Float.compare(this.min, aspectRadioLimit.min) == 0 && Float.compare(this.max, aspectRadioLimit.max) == 0 && Intrinsics.areEqual(this.toastOnTooSmall, aspectRadioLimit.toastOnTooSmall) && Intrinsics.areEqual(this.toastOnTooLarge, aspectRadioLimit.toastOnTooLarge);
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.min) * 31) + Float.floatToIntBits(this.max)) * 31) + (this.toastOnTooSmall == null ? 0 : this.toastOnTooSmall.hashCode())) * 31) + (this.toastOnTooLarge != null ? this.toastOnTooLarge.hashCode() : 0);
    }

    public String toString() {
        float f = this.min;
        float f2 = this.max;
        String str = this.toastOnTooSmall;
        return "AspectRadioLimit(min=" + f + ", max=" + f2 + ", toastOnTooSmall=" + str + ", toastOnTooLarge=" + this.toastOnTooLarge + ")";
    }

    public AspectRadioLimit(float min, float max, String toastOnTooSmall, String toastOnTooLarge) {
        this.min = min;
        this.max = max;
        this.toastOnTooSmall = toastOnTooSmall;
        this.toastOnTooLarge = toastOnTooLarge;
        if (!(this.min >= 0.0f)) {
            throw new IllegalArgumentException("AspectRadioLimit: min must be >= 0.0f".toString());
        }
        if (!(this.max >= this.min)) {
            throw new IllegalArgumentException("AspectRadioLimit: max must be >= min".toString());
        }
    }

    public /* synthetic */ AspectRadioLimit(float f, float f2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? Float.MAX_VALUE : f2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
    }

    public final float getMin() {
        return this.min;
    }

    public final float getMax() {
        return this.max;
    }

    public final String getToastOnTooSmall() {
        return this.toastOnTooSmall;
    }

    public final String getToastOnTooLarge() {
        return this.toastOnTooLarge;
    }

    public /* synthetic */ AspectRadioLimit(float f, float f2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? Float.MAX_VALUE : f2, str);
    }

    public AspectRadioLimit(float min, float max, String toastOnExceeded) {
        this(min, max, toastOnExceeded, toastOnExceeded);
    }

    public final boolean isInLimit(float radio) {
        return radio <= this.max && this.min <= radio;
    }
}