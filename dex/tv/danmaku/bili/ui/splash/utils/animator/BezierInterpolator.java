package tv.danmaku.bili.ui.splash.utils.animator;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BezierInterpolator.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/splash/utils/animator/BezierInterpolator;", "Landroid/view/animation/Interpolator;", "x1", "", "y1", "x2", "y2", "<init>", "(FFFF)V", "mLastI", "", "mControlPoint1", "Landroid/graphics/PointF;", "mControlPoint2", "getInterpolation", "input", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BezierInterpolator implements Interpolator {
    public static final int $stable = 8;
    private final PointF mControlPoint1 = new PointF();
    private final PointF mControlPoint2 = new PointF();
    private int mLastI;

    public BezierInterpolator(float x1, float y1, float x2, float y2) {
        this.mControlPoint1.x = x1;
        this.mControlPoint1.y = y1;
        this.mControlPoint2.x = x2;
        this.mControlPoint2.y = y2;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        float t = input;
        int i = this.mLastI;
        while (true) {
            if (i >= 4096) {
                break;
            }
            t = (i * 1.0f) / 4096;
            double x = BezierInterpolatorKt.cubicCurves(t, 0.0d, this.mControlPoint1.x, this.mControlPoint2.x, 1.0d);
            if (x < input) {
                i++;
            } else {
                this.mLastI = i;
                break;
            }
        }
        double value = BezierInterpolatorKt.cubicCurves(t, 0.0d, this.mControlPoint1.y, this.mControlPoint2.y, 1.0d);
        if (value > 0.999d) {
            value = 1.0d;
            this.mLastI = 0;
        }
        return (float) value;
    }
}