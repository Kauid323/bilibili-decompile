package tv.danmaku.bili.ui.favorites.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: RoundBackgroundColorSpan.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ2\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016JP\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Ltv/danmaku/bili/ui/favorites/widget/RoundBackgroundColorSpan;", "Landroid/text/style/ReplacementSpan;", "fontSize", "", "radius", "textColor", "", "bgColor", "mStyle", "horizontalPadding", "verticalPadding", "leftSpace", "rightSpace", "<init>", "(FFIIIFFFF)V", "mSize", "getSize", "paint", "Landroid/graphics/Paint;", "text", "", "start", "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", "top", "y", "bottom", "getCustomTextPaint", "Landroid/text/TextPaint;", "srcPaint", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RoundBackgroundColorSpan extends ReplacementSpan {
    public static final int STYLE_FILL = 0;
    public static final int STYLE_STROKE = 1;
    private final int bgColor;
    private final float fontSize;
    private final float horizontalPadding;
    private final float leftSpace;
    private float mSize;
    private final int mStyle;
    private final float radius;
    private final float rightSpace;
    private final int textColor;
    private final float verticalPadding;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public RoundBackgroundColorSpan(float fontSize, float radius, int textColor, int bgColor, int mStyle, float horizontalPadding, float verticalPadding, float leftSpace, float rightSpace) {
        this.fontSize = fontSize;
        this.radius = radius;
        this.textColor = textColor;
        this.bgColor = bgColor;
        this.mStyle = mStyle;
        this.horizontalPadding = horizontalPadding;
        this.verticalPadding = verticalPadding;
        this.leftSpace = leftSpace;
        this.rightSpace = rightSpace;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RoundBackgroundColorSpan(float f, float f2, int i, int i2, int i3, float f3, float f4, float f5, float f6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, i, i2, i3, f3, f4, r11, r12);
        float f7;
        float f8;
        if ((i4 & BR.cover) == 0) {
            f7 = f5;
        } else {
            f7 = 0.0f;
        }
        if ((i4 & BR.hallEnterHotText) == 0) {
            f8 = f6;
        } else {
            f8 = 0.0f;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        Paint newPaint = getCustomTextPaint(paint);
        this.mSize = newPaint.measureText(text, start, end) + this.leftSpace + this.rightSpace + (this.horizontalPadding * 2);
        return (int) this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint newPaint = getCustomTextPaint(paint);
        Paint.FontMetrics fm = newPaint.getFontMetrics();
        int originColor = paint.getColor();
        paint.setColor(this.bgColor);
        int center = (top + bottom) / 2;
        float tagFontHeight = fm.bottom - fm.top;
        float f = 2;
        float tagTop = center - (tagFontHeight / f);
        float baseline = tagTop - fm.top;
        RectF rect = new RectF(x + this.leftSpace, tagTop - this.verticalPadding, x + this.leftSpace + ((int) newPaint.measureText(text, start, end)) + (this.horizontalPadding * f), tagTop + tagFontHeight + this.verticalPadding);
        if (this.mStyle == 1) {
            paint.setColor(this.textColor);
            paint.setStyle(Paint.Style.STROKE);
        } else {
            paint.setColor(this.bgColor);
            paint.setStyle(Paint.Style.FILL);
        }
        canvas.drawRoundRect(rect, this.radius, this.radius, paint);
        newPaint.setAntiAlias(true);
        newPaint.setColor(this.textColor);
        canvas.drawText(text, start, end, x + this.leftSpace + this.horizontalPadding, baseline, newPaint);
        paint.setColor(originColor);
    }

    private final TextPaint getCustomTextPaint(Paint srcPaint) {
        TextPaint textPaint = new TextPaint(srcPaint);
        textPaint.setTextSize(this.fontSize);
        return textPaint;
    }

    /* compiled from: RoundBackgroundColorSpan.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/favorites/widget/RoundBackgroundColorSpan$Companion;", "", "<init>", "()V", "STYLE_FILL", "", "STYLE_STROKE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}