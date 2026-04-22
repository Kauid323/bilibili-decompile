package leakcanary.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.squareup.leakcanary.core.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.navigation.ViewsKt;

/* compiled from: DisplayLeakConnectorView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0016H\u0014J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lleakcanary/internal/DisplayLeakConnectorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cache", "Landroid/graphics/Bitmap;", "circleY", "", "classNamePaint", "Landroid/graphics/Paint;", "clearPaint", "leakPaint", "referencePaint", "strokeSize", "type", "Lleakcanary/internal/DisplayLeakConnectorView$Type;", "drawArrowHead", "", "cacheCanvas", "Landroid/graphics/Canvas;", "paint", "drawGcRoot", "drawInstanceCircle", "drawItems", "arrowHeadPaint", "nextArrowPaint", "drawNextArrowLine", "drawStartLine", "onDraw", "canvas", "setType", "Companion", "Type", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class DisplayLeakConnectorView extends View {
    private Bitmap cache;
    private final float circleY;
    private final Paint classNamePaint;
    private final Paint clearPaint;
    private final Paint leakPaint;
    private final Paint referencePaint;
    private final float strokeSize;
    private Type type;
    public static final Companion Companion = new Companion(null);
    private static final float SQRT_TWO = (float) Math.sqrt(2.0d);
    private static final PorterDuffXfermode CLEAR_XFER_MODE = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    /* compiled from: DisplayLeakConnectorView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lleakcanary/internal/DisplayLeakConnectorView$Type;", "", "(Ljava/lang/String;I)V", "GC_ROOT", "START", "START_LAST_REACHABLE", "NODE_UNKNOWN", "NODE_FIRST_UNREACHABLE", "NODE_UNREACHABLE", "NODE_REACHABLE", "NODE_LAST_REACHABLE", "END", "END_FIRST_UNREACHABLE", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum Type {
        GC_ROOT,
        START,
        START_LAST_REACHABLE,
        NODE_UNKNOWN,
        NODE_FIRST_UNREACHABLE,
        NODE_UNREACHABLE,
        NODE_REACHABLE,
        NODE_LAST_REACHABLE,
        END,
        END_FIRST_UNREACHABLE
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayLeakConnectorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        Resources resources = getResources();
        this.type = Type.NODE_UNKNOWN;
        this.circleY = resources.getDimensionPixelSize(R.dimen.leak_canary_connector_center_y);
        this.strokeSize = resources.getDimensionPixelSize(R.dimen.leak_canary_connector_stroke_size);
        this.classNamePaint = new Paint(1);
        this.classNamePaint.setColor(ViewsKt.getColorCompat(context, R.color.leak_canary_class_name));
        this.classNamePaint.setStrokeWidth(this.strokeSize);
        this.leakPaint = new Paint(1);
        this.leakPaint.setColor(ViewsKt.getColorCompat(context, R.color.leak_canary_leak));
        this.leakPaint.setStyle(Paint.Style.STROKE);
        this.leakPaint.setStrokeWidth(this.strokeSize);
        float pathLines = resources.getDimensionPixelSize(R.dimen.leak_canary_connector_leak_dash_line);
        float pathGaps = resources.getDimensionPixelSize(R.dimen.leak_canary_connector_leak_dash_gap);
        this.leakPaint.setPathEffect(new DashPathEffect(new float[]{pathLines, pathGaps}, 0.0f));
        this.clearPaint = new Paint(1);
        this.clearPaint.setColor(0);
        this.clearPaint.setXfermode(CLEAR_XFER_MODE);
        this.referencePaint = new Paint(1);
        this.referencePaint.setColor(ViewsKt.getColorCompat(context, R.color.leak_canary_reference));
        this.referencePaint.setStrokeWidth(this.strokeSize);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r2.getHeight() != r1) goto L13;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        if (this.cache != null) {
            Bitmap bitmap = this.cache;
            if (bitmap == null) {
                Intrinsics.throwNpe();
            }
            if (bitmap.getWidth() == width) {
                Bitmap bitmap2 = this.cache;
                if (bitmap2 == null) {
                    Intrinsics.throwNpe();
                }
            }
            Bitmap bitmap3 = this.cache;
            if (bitmap3 == null) {
                Intrinsics.throwNpe();
            }
            bitmap3.recycle();
            this.cache = null;
        }
        if (this.cache == null) {
            this.cache = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Bitmap bitmap4 = this.cache;
            if (bitmap4 == null) {
                Intrinsics.throwNpe();
            }
            Canvas cacheCanvas = new Canvas(bitmap4);
            Type type = this.type;
            if (type != null) {
                switch (type) {
                    case NODE_UNKNOWN:
                        drawItems(cacheCanvas, this.leakPaint, this.leakPaint);
                        break;
                    case NODE_UNREACHABLE:
                    case NODE_REACHABLE:
                        drawItems(cacheCanvas, this.referencePaint, this.referencePaint);
                        break;
                    case NODE_FIRST_UNREACHABLE:
                        drawItems(cacheCanvas, this.leakPaint, this.referencePaint);
                        break;
                    case NODE_LAST_REACHABLE:
                        drawItems(cacheCanvas, this.referencePaint, this.leakPaint);
                        break;
                    case START:
                        drawStartLine(cacheCanvas);
                        drawItems(cacheCanvas, null, this.referencePaint);
                        break;
                    case START_LAST_REACHABLE:
                        drawStartLine(cacheCanvas);
                        drawItems(cacheCanvas, null, this.leakPaint);
                        break;
                    case END:
                        drawItems(cacheCanvas, this.referencePaint, null);
                        break;
                    case END_FIRST_UNREACHABLE:
                        drawItems(cacheCanvas, this.leakPaint, null);
                        break;
                    case GC_ROOT:
                        drawGcRoot(cacheCanvas);
                        break;
                }
            }
            StringBuilder append = new StringBuilder().append("Unknown type ");
            Type type2 = this.type;
            if (type2 == null) {
                Intrinsics.throwNpe();
            }
            throw new UnsupportedOperationException(append.append(type2).toString());
        }
        Bitmap bitmap5 = this.cache;
        if (bitmap5 == null) {
            Intrinsics.throwNpe();
        }
        canvas.drawBitmap(bitmap5, 0.0f, 0.0f, (Paint) null);
    }

    private final void drawStartLine(Canvas cacheCanvas) {
        int width = getMeasuredWidth();
        float halfWidth = width / 2.0f;
        cacheCanvas.drawLine(halfWidth, 0.0f, halfWidth, this.circleY, this.classNamePaint);
    }

    private final void drawGcRoot(Canvas cacheCanvas) {
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        float halfWidth = width / 2.0f;
        cacheCanvas.drawLine(halfWidth, 0.0f, halfWidth, height, this.classNamePaint);
    }

    private final void drawItems(Canvas cacheCanvas, Paint arrowHeadPaint, Paint nextArrowPaint) {
        if (arrowHeadPaint != null) {
            drawArrowHead(cacheCanvas, arrowHeadPaint);
        }
        if (nextArrowPaint != null) {
            drawNextArrowLine(cacheCanvas, nextArrowPaint);
        }
        drawInstanceCircle(cacheCanvas);
    }

    private final void drawArrowHead(Canvas cacheCanvas, Paint paint) {
        int width = getMeasuredWidth();
        float halfWidth = width / 2.0f;
        float circleRadius = width / 3.0f;
        float f = 2;
        float arrowHeight = (halfWidth / f) * SQRT_TWO;
        float halfStrokeSize = this.strokeSize / f;
        float translateY = ((this.circleY - arrowHeight) - (circleRadius * f)) - this.strokeSize;
        float lineYEnd = (this.circleY - circleRadius) - (this.strokeSize / f);
        cacheCanvas.drawLine(halfWidth, 0.0f, halfWidth, lineYEnd, paint);
        cacheCanvas.translate(halfWidth, translateY);
        cacheCanvas.rotate(45.0f);
        cacheCanvas.drawLine(0.0f, halfWidth, halfWidth + halfStrokeSize, halfWidth, paint);
        cacheCanvas.drawLine(halfWidth, 0.0f, halfWidth, halfWidth, paint);
        cacheCanvas.rotate(-45.0f);
        cacheCanvas.translate(-halfWidth, -translateY);
    }

    private final void drawNextArrowLine(Canvas cacheCanvas, Paint paint) {
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();
        float centerX = width / 2.0f;
        cacheCanvas.drawLine(centerX, this.circleY, centerX, height, paint);
    }

    private final void drawInstanceCircle(Canvas cacheCanvas) {
        int width = getMeasuredWidth();
        float circleX = width / 2.0f;
        float circleRadius = width / 3.0f;
        cacheCanvas.drawCircle(circleX, this.circleY, circleRadius, this.classNamePaint);
    }

    public final void setType(Type type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        if (type != this.type) {
            this.type = type;
            if (this.cache != null) {
                Bitmap bitmap = this.cache;
                if (bitmap == null) {
                    Intrinsics.throwNpe();
                }
                bitmap.recycle();
                this.cache = null;
            }
            invalidate();
        }
    }

    /* compiled from: DisplayLeakConnectorView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lleakcanary/internal/DisplayLeakConnectorView$Companion;", "", "()V", "CLEAR_XFER_MODE", "Landroid/graphics/PorterDuffXfermode;", "SQRT_TWO", "", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}