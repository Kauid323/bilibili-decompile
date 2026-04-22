package kntr.common.ouro.ui.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.compose.ui.unit.Density;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.ui.utils.ListOrderStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListItemSpan.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016Jp\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkntr/common/ouro/ui/span/ListItemSpan;", "Landroid/text/style/LeadingMarginSpan;", "style", "Lkntr/common/ouro/ui/utils/ListOrderStyle;", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Lkntr/common/ouro/ui/utils/ListOrderStyle;Landroidx/compose/ui/unit/Density;)V", "getLeadingMargin", "", "first", "", "drawLeadingMargin", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "x", "dir", "top", "baseline", "bottom", "text", "", "start", "end", "layout", "Landroid/text/Layout;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ListItemSpan implements LeadingMarginSpan {
    public static final int $stable = 8;
    private final Density density;
    private final ListOrderStyle style;

    public ListItemSpan(ListOrderStyle style, Density density) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        this.style = style;
        this.density = density;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return 0;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        if (text == null) {
            return;
        }
        ParaSpacingHelpSpan paraSpacingHelpSpan = ParaSpacingHelpSpanKt.getParaSpacingHelpSpanInListItemSpan(text, start, end);
        if (canvas == null || paint == null || !first || paraSpacingHelpSpan != null) {
            return;
        }
        Density $this$drawLeadingMargin_u24lambda_u240 = this.density;
        int offset = (int) Math.ceil($this$drawLeadingMargin_u24lambda_u240.toPx-0680j_4(this.style.mo2129getOffsetXD9Ej5fM()));
        int originalColor = paint.getColor();
        Paint.Style originalStyle = paint.getStyle();
        float originalStrokeWidth = paint.getStrokeWidth();
        ListOrderStyle listOrderStyle = this.style;
        if (listOrderStyle instanceof ListOrderStyle.Ordered) {
            float cy = baseline;
            float cx = x + offset;
            canvas.drawText(((ListOrderStyle.Ordered) this.style).getText().getText(), cx, cy, paint);
        } else if (!(listOrderStyle instanceof ListOrderStyle.Unordered)) {
            throw new NoWhenBranchMatchedException();
        } else {
            int level = ((ListOrderStyle.Unordered) this.style).getLevel();
            float side = this.density.getDensity() * 6;
            float f = 1;
            float strokeWidth = this.density.getDensity() * f;
            float cornerRadius = this.density.getDensity() * f;
            float leftOffset = this.density.getDensity() * 4;
            switch (level % 3) {
                case 0:
                    float f2 = 2;
                    float radius = side / f2;
                    float cx2 = x + offset + radius + leftOffset;
                    float cy2 = (top + bottom) / f2;
                    paint.setStrokeWidth(strokeWidth);
                    paint.setStyle(Paint.Style.STROKE);
                    canvas.drawCircle(cx2, cy2, radius, paint);
                    break;
                case 1:
                    float f3 = 2;
                    float radius2 = side / f3;
                    float cx3 = x + offset + radius2 + leftOffset;
                    float cy3 = (top + bottom) / f3;
                    canvas.drawCircle(cx3, cy3, radius2, paint);
                    break;
                case 2:
                    float rectLeft = x + offset + leftOffset;
                    float rectRight = rectLeft + side;
                    float f4 = 2;
                    float rectTop = ((top + bottom) / f4) + (side / f4);
                    float rectBottom = rectTop - side;
                    canvas.drawRoundRect(rectLeft, rectTop, rectRight, rectBottom, cornerRadius, cornerRadius, paint);
                    break;
                default:
                    float f5 = 2;
                    float radius3 = side / f5;
                    float cx4 = x + offset + radius3 + leftOffset;
                    float cy4 = (top + bottom) / f5;
                    canvas.drawCircle(cx4, cy4, radius3, paint);
                    break;
            }
        }
        paint.setColor(originalColor);
        paint.setStrokeWidth(originalStrokeWidth);
        paint.setStyle(originalStyle);
    }
}