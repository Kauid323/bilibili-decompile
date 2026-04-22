package tv.danmaku.bili.ui.splash.ad.model;

import android.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BezierParam.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a\"\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0000\u001a\u000e\u0010\n\u001a\u00020\u0006*\u0004\u0018\u00010\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u000b\u001a\u00020\b*\u0004\u0018\u00010\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"toParam", "Lcom/bilibili/commonanim/elementanim/model/BezierParam;", "Ltv/danmaku/bili/ui/splash/ad/model/BezierParam;", "getToParam", "(Ltv/danmaku/bili/ui/splash/ad/model/BezierParam;)Lcom/bilibili/commonanim/elementanim/model/BezierParam;", "toPath", "Landroid/graphics/Path;", "scaleX", "", "scaleY", "toScalePath", "orZero", "getOrZero", "(Ljava/lang/Float;)F", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BezierParamKt {
    public static final com.bilibili.commonanim.elementanim.model.BezierParam getToParam(BezierParam $this$toParam) {
        Intrinsics.checkNotNullParameter($this$toParam, "<this>");
        return new com.bilibili.commonanim.elementanim.model.BezierParam(BezierPointKt.getToPoint($this$toParam.getStart()), BezierPointKt.getToPoint($this$toParam.getEnd()), BezierPointKt.getToPoint($this$toParam.getControl1()), BezierPointKt.getToPoint($this$toParam.getControl2()));
    }

    public static /* synthetic */ Path toPath$default(BezierParam bezierParam, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        return toPath(bezierParam, f, f2);
    }

    public static final Path toPath(BezierParam $this$toPath, float scaleX, float scaleY) {
        if ($this$toPath == null) {
            return new Path();
        }
        Path $this$toPath_u24lambda_u240 = new Path();
        BezierPoint start = $this$toPath.getStart();
        float orZero = getOrZero(start != null ? Float.valueOf(start.getX()) : null) * scaleX;
        BezierPoint start2 = $this$toPath.getStart();
        $this$toPath_u24lambda_u240.moveTo(orZero, getOrZero(start2 != null ? Float.valueOf(start2.getY()) : null) * scaleY);
        BezierPoint control1 = $this$toPath.getControl1();
        float orZero2 = getOrZero(control1 != null ? Float.valueOf(control1.getX()) : null) * scaleX;
        BezierPoint control12 = $this$toPath.getControl1();
        float orZero3 = getOrZero(control12 != null ? Float.valueOf(control12.getY()) : null) * scaleY;
        BezierPoint control2 = $this$toPath.getControl2();
        float orZero4 = getOrZero(control2 != null ? Float.valueOf(control2.getX()) : null) * scaleX;
        BezierPoint control22 = $this$toPath.getControl2();
        float orZero5 = getOrZero(control22 != null ? Float.valueOf(control22.getY()) : null) * scaleY;
        BezierPoint end = $this$toPath.getEnd();
        float orZero6 = getOrZero(end != null ? Float.valueOf(end.getX()) : null) * scaleX;
        BezierPoint end2 = $this$toPath.getEnd();
        $this$toPath_u24lambda_u240.cubicTo(orZero2, orZero3, orZero4, orZero5, orZero6, getOrZero(end2 != null ? Float.valueOf(end2.getY()) : null) * scaleY);
        return $this$toPath_u24lambda_u240;
    }

    public static final Path toScalePath(BezierParam $this$toScalePath) {
        if ($this$toScalePath == null) {
            return new Path();
        }
        Path $this$toScalePath_u24lambda_u240 = new Path();
        BezierPoint start = $this$toScalePath.getStart();
        float orZero = getOrZero(start != null ? Float.valueOf(start.getY()) : null);
        BezierPoint start2 = $this$toScalePath.getStart();
        $this$toScalePath_u24lambda_u240.moveTo(orZero, getOrZero(start2 != null ? Float.valueOf(start2.getY()) : null));
        BezierPoint control1 = $this$toScalePath.getControl1();
        float orZero2 = getOrZero(control1 != null ? Float.valueOf(control1.getY()) : null);
        BezierPoint control12 = $this$toScalePath.getControl1();
        float orZero3 = getOrZero(control12 != null ? Float.valueOf(control12.getY()) : null);
        BezierPoint control2 = $this$toScalePath.getControl2();
        float orZero4 = getOrZero(control2 != null ? Float.valueOf(control2.getY()) : null);
        BezierPoint control22 = $this$toScalePath.getControl2();
        float orZero5 = getOrZero(control22 != null ? Float.valueOf(control22.getY()) : null);
        BezierPoint end = $this$toScalePath.getEnd();
        float orZero6 = getOrZero(end != null ? Float.valueOf(end.getY()) : null);
        BezierPoint end2 = $this$toScalePath.getEnd();
        $this$toScalePath_u24lambda_u240.cubicTo(orZero2, orZero3, orZero4, orZero5, orZero6, getOrZero(end2 != null ? Float.valueOf(end2.getY()) : null));
        return $this$toScalePath_u24lambda_u240;
    }

    public static final float getOrZero(Float $this$orZero) {
        return $this$orZero != null ? $this$orZero.floatValue() : DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
    }
}