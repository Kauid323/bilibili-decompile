package kntr.common.ouro.core.plugin.textStyle;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroColor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroTextStyleAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/common/ouro/core/plugin/textStyle/OuroChangeForegroundColor;", "Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyleAction;", "color", "Lkntr/common/ouro/core/model/mark/OuroColor;", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroColor;)V", "getColor", "()Lkntr/common/ouro/core/model/mark/OuroColor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroChangeForegroundColor implements OuroTextStyleAction {
    private final OuroColor color;

    public static /* synthetic */ OuroChangeForegroundColor copy$default(OuroChangeForegroundColor ouroChangeForegroundColor, OuroColor ouroColor, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroColor = ouroChangeForegroundColor.color;
        }
        return ouroChangeForegroundColor.copy(ouroColor);
    }

    public final OuroColor component1() {
        return this.color;
    }

    public final OuroChangeForegroundColor copy(OuroColor ouroColor) {
        Intrinsics.checkNotNullParameter(ouroColor, "color");
        return new OuroChangeForegroundColor(ouroColor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OuroChangeForegroundColor) && Intrinsics.areEqual(this.color, ((OuroChangeForegroundColor) obj).color);
    }

    public int hashCode() {
        return this.color.hashCode();
    }

    public String toString() {
        return "OuroChangeForegroundColor(color=" + this.color + ")";
    }

    public OuroChangeForegroundColor(OuroColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.color = color;
    }

    public final OuroColor getColor() {
        return this.color;
    }
}