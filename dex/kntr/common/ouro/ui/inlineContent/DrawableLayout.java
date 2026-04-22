package kntr.common.ouro.ui.inlineContent;

import androidx.compose.ui.geometry.Rect;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.ui.utils.DrawableStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawableLayout.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lkntr/common/ouro/ui/inlineContent/DrawableLayout;", "", "drawableStyle", "Lkntr/common/ouro/ui/utils/DrawableStyle;", "charBoundingBox", "Landroidx/compose/ui/geometry/Rect;", "lineBottom", "", "<init>", "(Lkntr/common/ouro/ui/utils/DrawableStyle;Landroidx/compose/ui/geometry/Rect;F)V", "getDrawableStyle", "()Lkntr/common/ouro/ui/utils/DrawableStyle;", "getCharBoundingBox", "()Landroidx/compose/ui/geometry/Rect;", "getLineBottom", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DrawableLayout {
    public static final int $stable = 0;
    private final Rect charBoundingBox;
    private final DrawableStyle drawableStyle;
    private final float lineBottom;

    public static /* synthetic */ DrawableLayout copy$default(DrawableLayout drawableLayout, DrawableStyle drawableStyle, Rect rect, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            drawableStyle = drawableLayout.drawableStyle;
        }
        if ((i & 2) != 0) {
            rect = drawableLayout.charBoundingBox;
        }
        if ((i & 4) != 0) {
            f = drawableLayout.lineBottom;
        }
        return drawableLayout.copy(drawableStyle, rect, f);
    }

    public final DrawableStyle component1() {
        return this.drawableStyle;
    }

    public final Rect component2() {
        return this.charBoundingBox;
    }

    public final float component3() {
        return this.lineBottom;
    }

    public final DrawableLayout copy(DrawableStyle drawableStyle, Rect rect, float f) {
        Intrinsics.checkNotNullParameter(drawableStyle, "drawableStyle");
        Intrinsics.checkNotNullParameter(rect, "charBoundingBox");
        return new DrawableLayout(drawableStyle, rect, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrawableLayout) {
            DrawableLayout drawableLayout = (DrawableLayout) obj;
            return Intrinsics.areEqual(this.drawableStyle, drawableLayout.drawableStyle) && Intrinsics.areEqual(this.charBoundingBox, drawableLayout.charBoundingBox) && Float.compare(this.lineBottom, drawableLayout.lineBottom) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((this.drawableStyle.hashCode() * 31) + this.charBoundingBox.hashCode()) * 31) + Float.floatToIntBits(this.lineBottom);
    }

    public String toString() {
        DrawableStyle drawableStyle = this.drawableStyle;
        Rect rect = this.charBoundingBox;
        return "DrawableLayout(drawableStyle=" + drawableStyle + ", charBoundingBox=" + rect + ", lineBottom=" + this.lineBottom + ")";
    }

    public DrawableLayout(DrawableStyle drawableStyle, Rect charBoundingBox, float lineBottom) {
        Intrinsics.checkNotNullParameter(drawableStyle, "drawableStyle");
        Intrinsics.checkNotNullParameter(charBoundingBox, "charBoundingBox");
        this.drawableStyle = drawableStyle;
        this.charBoundingBox = charBoundingBox;
        this.lineBottom = lineBottom;
    }

    public final DrawableStyle getDrawableStyle() {
        return this.drawableStyle;
    }

    public final Rect getCharBoundingBox() {
        return this.charBoundingBox;
    }

    public final float getLineBottom() {
        return this.lineBottom;
    }
}