package kntr.common.ouro.core.plugin.textStyle;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroBackgroundColorMark;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.model.mark.OuroForegroundColorMark;
import kntr.common.ouro.core.model.mark.OuroItalicMark;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroMediumMark;
import kntr.common.ouro.core.model.mark.OuroSemiBoldMark;
import kntr.common.ouro.core.model.mark.OuroStrikethroughMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.mark.OuroUnderlineMark;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroTextStyleState.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u001d"}, d2 = {"Lkntr/common/ouro/core/plugin/textStyle/OuroTextStyle;", "", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroMarks;)V", "getMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "isBold", "", "()Z", "isItalic", "isUnderline", "isStrikethrough", "foregroundColor", "Lkntr/common/ouro/core/model/mark/OuroColor;", "getForegroundColor", "()Lkntr/common/ouro/core/model/mark/OuroColor;", "backgroundColor", "getBackgroundColor", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroTextStyle {
    private final OuroMarks<OuroTextMark> marks;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroTextStyle copy$default(OuroTextStyle ouroTextStyle, OuroMarks ouroMarks, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroMarks = ouroTextStyle.marks;
        }
        return ouroTextStyle.copy(ouroMarks);
    }

    public final OuroMarks<OuroTextMark> component1() {
        return this.marks;
    }

    public final OuroTextStyle copy(OuroMarks<OuroTextMark> ouroMarks) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        return new OuroTextStyle(ouroMarks);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OuroTextStyle) && Intrinsics.areEqual(this.marks, ((OuroTextStyle) obj).marks);
    }

    public int hashCode() {
        return this.marks.hashCode();
    }

    public String toString() {
        return "OuroTextStyle(marks=" + this.marks + ")";
    }

    public OuroTextStyle(OuroMarks<OuroTextMark> ouroMarks) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        this.marks = ouroMarks;
    }

    public final OuroMarks<OuroTextMark> getMarks() {
        return this.marks;
    }

    public final boolean isBold() {
        return this.marks.contains((Object) OuroMediumMark.INSTANCE) || this.marks.contains((Object) OuroSemiBoldMark.INSTANCE);
    }

    public final boolean isItalic() {
        return this.marks.contains((OuroMark.Key<?>) OuroItalicMark.Key.INSTANCE);
    }

    public final boolean isUnderline() {
        return this.marks.contains((OuroMark.Key<?>) OuroUnderlineMark.Key.INSTANCE);
    }

    public final boolean isStrikethrough() {
        return this.marks.contains((OuroMark.Key<?>) OuroStrikethroughMark.Key.INSTANCE);
    }

    public final OuroColor getForegroundColor() {
        OuroForegroundColorMark ouroForegroundColorMark = (OuroForegroundColorMark) this.marks.get(OuroForegroundColorMark.Key.INSTANCE);
        if (ouroForegroundColorMark != null) {
            return ouroForegroundColorMark.getColor();
        }
        return null;
    }

    public final OuroColor getBackgroundColor() {
        OuroBackgroundColorMark ouroBackgroundColorMark = (OuroBackgroundColorMark) this.marks.get(OuroBackgroundColorMark.Key.INSTANCE);
        if (ouroBackgroundColorMark != null) {
            return ouroBackgroundColorMark.getColor();
        }
        return null;
    }
}