package kntr.common.ouro.ui.span;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroBackgroundColorSpan.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lkntr/common/ouro/ui/span/OuroBackgroundColorSpan;", "", "color", "", "heightDp", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Float;)V", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeightDp", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Float;)Lkntr/common/ouro/ui/span/OuroBackgroundColorSpan;", "equals", "", "other", "hashCode", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroBackgroundColorSpan {
    public static final int $stable = 0;
    private final Integer color;
    private final Float heightDp;

    public static /* synthetic */ OuroBackgroundColorSpan copy$default(OuroBackgroundColorSpan ouroBackgroundColorSpan, Integer num, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            num = ouroBackgroundColorSpan.color;
        }
        if ((i & 2) != 0) {
            f = ouroBackgroundColorSpan.heightDp;
        }
        return ouroBackgroundColorSpan.copy(num, f);
    }

    public final Integer component1() {
        return this.color;
    }

    public final Float component2() {
        return this.heightDp;
    }

    public final OuroBackgroundColorSpan copy(Integer num, Float f) {
        return new OuroBackgroundColorSpan(num, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroBackgroundColorSpan) {
            OuroBackgroundColorSpan ouroBackgroundColorSpan = (OuroBackgroundColorSpan) obj;
            return Intrinsics.areEqual(this.color, ouroBackgroundColorSpan.color) && Intrinsics.areEqual(this.heightDp, ouroBackgroundColorSpan.heightDp);
        }
        return false;
    }

    public int hashCode() {
        return ((this.color == null ? 0 : this.color.hashCode()) * 31) + (this.heightDp != null ? this.heightDp.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.color;
        return "OuroBackgroundColorSpan(color=" + num + ", heightDp=" + this.heightDp + ")";
    }

    public OuroBackgroundColorSpan(Integer color, Float heightDp) {
        this.color = color;
        this.heightDp = heightDp;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final Float getHeightDp() {
        return this.heightDp;
    }
}