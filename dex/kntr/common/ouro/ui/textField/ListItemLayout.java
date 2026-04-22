package kntr.common.ouro.ui.textField;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.ui.utils.ListOrderStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroComposeTextField.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/common/ouro/ui/textField/ListItemLayout;", "", "style", "Lkntr/common/ouro/ui/utils/ListOrderStyle;", "line", "", "<init>", "(Lkntr/common/ouro/ui/utils/ListOrderStyle;I)V", "getStyle", "()Lkntr/common/ouro/ui/utils/ListOrderStyle;", "getLine", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ListItemLayout {
    public static final int $stable = 8;
    private final int line;
    private final ListOrderStyle style;

    public static /* synthetic */ ListItemLayout copy$default(ListItemLayout listItemLayout, ListOrderStyle listOrderStyle, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            listOrderStyle = listItemLayout.style;
        }
        if ((i2 & 2) != 0) {
            i = listItemLayout.line;
        }
        return listItemLayout.copy(listOrderStyle, i);
    }

    public final ListOrderStyle component1() {
        return this.style;
    }

    public final int component2() {
        return this.line;
    }

    public final ListItemLayout copy(ListOrderStyle listOrderStyle, int i) {
        Intrinsics.checkNotNullParameter(listOrderStyle, "style");
        return new ListItemLayout(listOrderStyle, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ListItemLayout) {
            ListItemLayout listItemLayout = (ListItemLayout) obj;
            return Intrinsics.areEqual(this.style, listItemLayout.style) && this.line == listItemLayout.line;
        }
        return false;
    }

    public int hashCode() {
        return (this.style.hashCode() * 31) + this.line;
    }

    public String toString() {
        ListOrderStyle listOrderStyle = this.style;
        return "ListItemLayout(style=" + listOrderStyle + ", line=" + this.line + ")";
    }

    public ListItemLayout(ListOrderStyle style, int line) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.style = style;
        this.line = line;
    }

    public final ListOrderStyle getStyle() {
        return this.style;
    }

    public final int getLine() {
        return this.line;
    }
}