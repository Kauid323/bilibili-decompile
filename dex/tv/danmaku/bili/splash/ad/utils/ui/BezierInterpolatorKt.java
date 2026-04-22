package tv.danmaku.bili.splash.ad.utils.ui;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: BezierInterpolator.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\u001a0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"ACCURACY", "", "cubicCurves", "", "t", "value0", "value1", "value2", "value3", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BezierInterpolatorKt {
    private static final int ACCURACY = 4096;

    public static final /* synthetic */ double access$cubicCurves(double t, double value0, double value1, double value2, double value3) {
        return cubicCurves(t, value0, value1, value2, value3);
    }

    public static final double cubicCurves(double t, double value0, double value1, double value2, double value3) {
        double u = 1 - t;
        double tt = t * t;
        double uu = u * u;
        double uuu = uu * u;
        double ttt = tt * t;
        double value = uuu * value0;
        double d = 3;
        return value + (d * uu * t * value1) + (d * u * tt * value2) + (ttt * value3);
    }
}