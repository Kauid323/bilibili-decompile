package tv.danmaku.bili.ui.widget.wheel;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WheelView.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/widget/wheel/RectangleDivider;", "Ltv/danmaku/bili/ui/widget/wheel/DividerDrawer;", "solidColor", "", "alpha", "radii", "", "paddingLeft", "paddingRight", "<init>", "(II[FII)V", "getRadii", "()[F", "path", "Landroid/graphics/Path;", "paintIndicator", "Landroid/graphics/Paint;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "left", "", "right", "top", "bottom", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RectangleDivider implements DividerDrawer {
    private final int paddingLeft;
    private final int paddingRight;
    private final Paint paintIndicator;
    private final Path path;
    private final float[] radii;

    public RectangleDivider(int solidColor, int alpha, float[] radii, int paddingLeft, int paddingRight) {
        Intrinsics.checkNotNullParameter(radii, "radii");
        this.radii = radii;
        this.paddingLeft = paddingLeft;
        this.paddingRight = paddingRight;
        this.path = new Path();
        Paint $this$paintIndicator_u24lambda_u240 = new Paint();
        $this$paintIndicator_u24lambda_u240.setColor(solidColor);
        $this$paintIndicator_u24lambda_u240.setAlpha(alpha);
        $this$paintIndicator_u24lambda_u240.setAntiAlias(true);
        this.paintIndicator = $this$paintIndicator_u24lambda_u240;
    }

    public /* synthetic */ RectangleDivider(int i, int i2, float[] fArr, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i5 & 4) != 0 ? new float[]{DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN} : fArr, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? 0 : i4);
    }

    public final float[] getRadii() {
        return this.radii;
    }

    @Override // tv.danmaku.bili.ui.widget.wheel.DividerDrawer
    public void draw(Canvas canvas, float left, float right, float top, float bottom) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float start = RangesKt.coerceIn(this.paddingLeft + left, left, right);
        float end = RangesKt.coerceIn(right - this.paddingRight, left, right);
        this.path.reset();
        this.path.addRoundRect(start, top, end, bottom, this.radii, Path.Direction.CW);
        canvas.drawPath(this.path, this.paintIndicator);
    }
}