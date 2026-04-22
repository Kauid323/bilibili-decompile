package kntr.app.tribee.consume.widget;

import androidx.compose.ui.unit.Dp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FlexibleScrollableTabRow.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\t¨\u0006\u0016"}, d2 = {"Lkntr/app/tribee/consume/widget/TabPosition;", "", "left", "Landroidx/compose/ui/unit/Dp;", "width", "contentWidth", "<init>", "(FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM", "()F", "F", "getWidth-D9Ej5fM", "getContentWidth-D9Ej5fM", "right", "getRight-D9Ej5fM", "equals", "", "other", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TabPosition {
    public static final int $stable = 0;
    private final float contentWidth;
    private final float left;
    private final float width;

    public /* synthetic */ TabPosition(float f, float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3);
    }

    private TabPosition(float left, float width, float contentWidth) {
        this.left = left;
        this.width = width;
        this.contentWidth = contentWidth;
    }

    /* renamed from: getLeft-D9Ej5fM  reason: not valid java name */
    public final float m786getLeftD9Ej5fM() {
        return this.left;
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m788getWidthD9Ej5fM() {
        return this.width;
    }

    /* renamed from: getContentWidth-D9Ej5fM  reason: not valid java name */
    public final float m785getContentWidthD9Ej5fM() {
        return this.contentWidth;
    }

    /* renamed from: getRight-D9Ej5fM  reason: not valid java name */
    public final float m787getRightD9Ej5fM() {
        return Dp.constructor-impl(this.left + this.width);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TabPosition) && Dp.equals-impl0(this.left, ((TabPosition) other).left) && Dp.equals-impl0(this.width, ((TabPosition) other).width) && Dp.equals-impl0(this.contentWidth, ((TabPosition) other).contentWidth);
    }

    public int hashCode() {
        int result = Dp.hashCode-impl(this.left);
        return (((result * 31) + Dp.hashCode-impl(this.width)) * 31) + Dp.hashCode-impl(this.contentWidth);
    }

    public String toString() {
        String str = Dp.toString-impl(this.left);
        String str2 = Dp.toString-impl(m787getRightD9Ej5fM());
        String str3 = Dp.toString-impl(this.width);
        return "TabPosition(left=" + str + ", right=" + str2 + ", width=" + str3 + ", contentWidth=" + Dp.toString-impl(this.contentWidth) + ")";
    }
}