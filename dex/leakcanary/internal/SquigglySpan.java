package leakcanary.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.SpannableStringBuilder;
import android.text.style.ReplacementSpan;
import android.text.style.UnderlineSpan;
import com.squareup.leakcanary.core.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.navigation.ViewsKt;

/* compiled from: SquigglySpan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JP\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J2\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lleakcanary/internal/SquigglySpan;", "Landroid/text/style/ReplacementSpan;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "amplitude", "", "halfStrokeWidth", "halfWaveHeight", "path", "Landroid/graphics/Path;", "periodDegrees", "referenceColor", "", "squigglyPaint", "Landroid/graphics/Paint;", "width", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "top", "y", "bottom", "paint", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class SquigglySpan extends ReplacementSpan {
    public static final Companion Companion = new Companion(null);
    private final float amplitude;
    private final float halfStrokeWidth;
    private final float halfWaveHeight;
    private final Path path;
    private final float periodDegrees;
    private final int referenceColor;
    private final Paint squigglyPaint;
    private int width;

    public SquigglySpan(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.squigglyPaint = new Paint(1);
        Resources resources = context.getResources();
        this.squigglyPaint.setStyle(Paint.Style.STROKE);
        this.squigglyPaint.setColor(ViewsKt.getColorCompat(context, R.color.leak_canary_leak));
        float strokeWidth = resources.getDimensionPixelSize(R.dimen.leak_canary_squiggly_span_stroke_width);
        this.squigglyPaint.setStrokeWidth(strokeWidth);
        float f = 2;
        this.halfStrokeWidth = strokeWidth / f;
        this.amplitude = resources.getDimensionPixelSize(R.dimen.leak_canary_squiggly_span_amplitude);
        this.periodDegrees = resources.getDimensionPixelSize(R.dimen.leak_canary_squiggly_span_period_degrees);
        this.path = new Path();
        float waveHeight = (this.amplitude * f) + strokeWidth;
        this.halfWaveHeight = waveHeight / f;
        this.referenceColor = ViewsKt.getColorCompat(context, R.color.leak_canary_reference);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkParameterIsNotNull(paint, "paint");
        Intrinsics.checkParameterIsNotNull(text, "text");
        this.width = (int) paint.measureText(text, start, end);
        return this.width;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Intrinsics.checkParameterIsNotNull(text, "text");
        Intrinsics.checkParameterIsNotNull(paint, "paint");
        Companion.squigglyHorizontalPath(this.path, x + this.halfStrokeWidth, (x + this.width) - this.halfStrokeWidth, bottom - this.halfWaveHeight, this.amplitude, this.periodDegrees);
        canvas.drawPath(this.path, this.squigglyPaint);
        paint.setColor(this.referenceColor);
        canvas.drawText(text, start, end, x, y, paint);
    }

    /* compiled from: SquigglySpan.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ8\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002¨\u0006\u0012"}, d2 = {"Lleakcanary/internal/SquigglySpan$Companion;", "", "()V", "replaceUnderlineSpans", "", "builder", "Landroid/text/SpannableStringBuilder;", "context", "Landroid/content/Context;", "squigglyHorizontalPath", "path", "Landroid/graphics/Path;", "left", "", "right", "centerY", "amplitude", "periodDegrees", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final void replaceUnderlineSpans(SpannableStringBuilder builder, Context context) {
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            Intrinsics.checkParameterIsNotNull(context, "context");
            UnderlineSpan[] underlineSpans = (UnderlineSpan[]) builder.getSpans(0, builder.length(), UnderlineSpan.class);
            for (UnderlineSpan span : underlineSpans) {
                int start = builder.getSpanStart(span);
                int end = builder.getSpanEnd(span);
                builder.removeSpan(span);
                builder.setSpan(new SquigglySpan(context), start, end, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void squigglyHorizontalPath(Path path, float left, float right, float centerY, float amplitude, float periodDegrees) {
            path.reset();
            path.moveTo(left, centerY);
            float period = (float) (6.283185307179586d / periodDegrees);
            for (float x = 0.0f; x <= right - left; x += 1.0f) {
                float y = (float) ((amplitude * Math.sin(40 + (period * x))) + centerY);
                path.lineTo(left + x, y);
            }
        }
    }
}