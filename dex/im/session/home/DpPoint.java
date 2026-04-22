package im.session.home;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: QuickLinkBubble.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0019"}, d2 = {"Lim/session/home/DpPoint;", "", "x", "Landroidx/compose/ui/unit/Dp;", "y", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getX-D9Ej5fM", "()F", "F", "getY-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "copy", "copy-YgX7TsA", "(FF)Lim/session/home/DpPoint;", "equals", "", "other", "hashCode", "", "toString", "", "session-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DpPoint {
    public static final int $stable = 0;
    private final float x;
    private final float y;

    public /* synthetic */ DpPoint(float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f2, f3);
    }

    /* renamed from: copy-YgX7TsA$default  reason: not valid java name */
    public static /* synthetic */ DpPoint m3306copyYgX7TsA$default(DpPoint dpPoint, float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = dpPoint.x;
        }
        if ((i2 & 2) != 0) {
            f3 = dpPoint.y;
        }
        return dpPoint.m3309copyYgX7TsA(f2, f3);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m3307component1D9Ej5fM() {
        return this.x;
    }

    /* renamed from: component2-D9Ej5fM  reason: not valid java name */
    public final float m3308component2D9Ej5fM() {
        return this.y;
    }

    /* renamed from: copy-YgX7TsA  reason: not valid java name */
    public final DpPoint m3309copyYgX7TsA(float f2, float f3) {
        return new DpPoint(f2, f3, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DpPoint) {
            DpPoint dpPoint = (DpPoint) obj;
            return Dp.equals-impl0(this.x, dpPoint.x) && Dp.equals-impl0(this.y, dpPoint.y);
        }
        return false;
    }

    public int hashCode() {
        return (Dp.hashCode-impl(this.x) * 31) + Dp.hashCode-impl(this.y);
    }

    public String toString() {
        String str = Dp.toString-impl(this.x);
        return "DpPoint(x=" + str + ", y=" + Dp.toString-impl(this.y) + ")";
    }

    private DpPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /* renamed from: getX-D9Ej5fM  reason: not valid java name */
    public final float m3310getXD9Ej5fM() {
        return this.x;
    }

    /* renamed from: getY-D9Ej5fM  reason: not valid java name */
    public final float m3311getYD9Ej5fM() {
        return this.y;
    }
}