package tv.danmaku.bili.ui.widget.wheel;

import android.graphics.Canvas;
import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WheelView.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/widget/wheel/LinesDivider;", "Ltv/danmaku/bili/ui/widget/wheel/DividerDrawer;", "dividerColor", "", "strokeWidth", "", "paddingLeft", "paddingRight", "<init>", "(IFII)V", "paintIndicator", "Landroid/graphics/Paint;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "left", "right", "top", "bottom", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LinesDivider implements DividerDrawer {
    private final int paddingLeft;
    private final int paddingRight;
    private final Paint paintIndicator;

    public LinesDivider(int dividerColor, float strokeWidth, int paddingLeft, int paddingRight) {
        this.paddingLeft = paddingLeft;
        this.paddingRight = paddingRight;
        Paint $this$paintIndicator_u24lambda_u240 = new Paint();
        $this$paintIndicator_u24lambda_u240.setColor(dividerColor);
        $this$paintIndicator_u24lambda_u240.setStrokeWidth(strokeWidth);
        $this$paintIndicator_u24lambda_u240.setAntiAlias(true);
        this.paintIndicator = $this$paintIndicator_u24lambda_u240;
    }

    public /* synthetic */ LinesDivider(int i, float f, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? 2.0f : f, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    @Override // tv.danmaku.bili.ui.widget.wheel.DividerDrawer
    public void draw(Canvas canvas, float left, float right, float top, float bottom) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float start = RangesKt.coerceIn(this.paddingLeft + left, left, right);
        float end = RangesKt.coerceIn(right - this.paddingRight, left, right);
        canvas.drawLine(start, top, end, top, this.paintIndicator);
        canvas.drawLine(start, bottom, end, bottom, this.paintIndicator);
    }
}