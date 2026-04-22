package tv.danmaku.bili.downloadeshare.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bilibili.downloadsharecommon.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.downloadeshare.utils.DownloadShareHelper;

/* compiled from: RectangleProgressView.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\nJ0\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0014J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(H\u0014R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Ltv/danmaku/bili/downloadeshare/view/RectangleProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mProgressColor", "mProgress", "mProgressPaint", "Landroid/graphics/Paint;", "strokeWidth", "", "getStrokeWidth", "()F", "mCanvasBounds", "Landroid/graphics/RectF;", "getMCanvasBounds", "()Landroid/graphics/RectF;", "setMCanvasBounds", "(Landroid/graphics/RectF;)V", "mProgressCanvasBounds", "mRectangleRadiusValue", "setProgress", "", "progress", "onLayout", "changed", "", "left", "top", "right", "bottom", "onDraw", "canvas", "Landroid/graphics/Canvas;", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RectangleProgressView extends View {
    private RectF mCanvasBounds;
    private int mProgress;
    private final RectF mProgressCanvasBounds;
    private int mProgressColor;
    private Paint mProgressPaint;
    private final float mRectangleRadiusValue;
    private final float strokeWidth;

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final RectF getMCanvasBounds() {
        return this.mCanvasBounds;
    }

    public final void setMCanvasBounds(RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.mCanvasBounds = rectF;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RectangleProgressView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RectangleProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RectangleProgressView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this.strokeWidth = DownloadShareHelper.INSTANCE.dp2px(getContext(), 3.0f);
        this.mCanvasBounds = new RectF();
        this.mProgressCanvasBounds = new RectF();
        this.mRectangleRadiusValue = DownloadShareHelper.INSTANCE.dp2px(getContext(), 4.0f);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RectangleProgressView, defStyle, 0);
        Intrinsics.checkNotNullExpressionValue(a, "obtainStyledAttributes(...)");
        this.mProgressColor = a.getColor(R.styleable.RectangleProgressView_rectangleProgressColor, ContextCompat.getColor(context, 17170443));
        a.recycle();
    }

    public final void setProgress(int progress) {
        this.mProgress = progress;
        invalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.mCanvasBounds.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mProgressCanvasBounds.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mCanvasBounds.right = (this.mProgress / 100.0f) * getWidth();
        if (this.mProgress > 0) {
            if (this.mProgressPaint == null) {
                this.mProgressPaint = new Paint(1);
                Paint paint = this.mProgressPaint;
                if (paint != null) {
                    paint.setColor(this.mProgressColor);
                }
                Paint paint2 = this.mProgressPaint;
                if (paint2 != null) {
                    paint2.setStrokeWidth(this.strokeWidth);
                }
            }
            this.mCanvasBounds.right = (this.mProgress / 100.0f) * getWidth();
            RectF rectF = this.mCanvasBounds;
            float f = this.mRectangleRadiusValue;
            float f2 = this.mRectangleRadiusValue;
            Paint paint3 = this.mProgressPaint;
            Intrinsics.checkNotNull(paint3);
            canvas.drawRoundRect(rectF, f, f2, paint3);
        }
    }
}