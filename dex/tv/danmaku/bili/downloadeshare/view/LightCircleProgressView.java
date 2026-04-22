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

/* compiled from: LightCircleProgressView.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nJ0\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0014J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Ltv/danmaku/bili/downloadeshare/view/LightCircleProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCircleRadius", "", "mCircleColor", "mProgressRadius", "mProgressColor", "mProgress", "mPaint", "Landroid/graphics/Paint;", "mProgressPaint", "strokeWidth", "getStrokeWidth", "()F", "mCanvasBounds", "Landroid/graphics/RectF;", "getMCanvasBounds", "()Landroid/graphics/RectF;", "setMCanvasBounds", "(Landroid/graphics/RectF;)V", "setProgress", "", "progress", "onLayout", "changed", "", "left", "top", "right", "bottom", "onDraw", "canvas", "Landroid/graphics/Canvas;", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LightCircleProgressView extends View {
    private RectF mCanvasBounds;
    private int mCircleColor;
    private float mCircleRadius;
    private Paint mPaint;
    private int mProgress;
    private int mProgressColor;
    private Paint mProgressPaint;
    private float mProgressRadius;
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
    public LightCircleProgressView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LightCircleProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightCircleProgressView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this.strokeWidth = DownloadShareHelper.INSTANCE.dp2px(getContext(), 3.0f);
        this.mCanvasBounds = new RectF();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LightCircleProgressView, defStyle, 0);
        Intrinsics.checkNotNullExpressionValue(a, "obtainStyledAttributes(...)");
        this.mCircleRadius = a.getDimensionPixelOffset(R.styleable.LightCircleProgressView_lightCircleRadius, (int) DownloadShareHelper.INSTANCE.dp2px(context, 23.5f));
        this.mCircleColor = a.getColor(R.styleable.LightCircleProgressView_lightCircleColor, ContextCompat.getColor(context, R.color.Wh0_alpha10));
        this.mProgressRadius = a.getDimensionPixelOffset(R.styleable.LightCircleProgressView_lightProgressRadius, (int) DownloadShareHelper.INSTANCE.dp2px(context, 23.5f));
        this.mProgressColor = a.getColor(R.styleable.LightCircleProgressView_lightProgressColor, ContextCompat.getColor(context, 17170443));
        a.recycle();
    }

    public final void setProgress(int progress) {
        this.mProgress = progress;
        invalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.mCanvasBounds.left = (getWidth() / 2) - this.mProgressRadius;
        this.mCanvasBounds.top = (getHeight() / 2) - this.mProgressRadius;
        this.mCanvasBounds.right = (getWidth() / 2) + this.mProgressRadius;
        this.mCanvasBounds.bottom = (getHeight() / 2) + this.mProgressRadius;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mCircleRadius >= this.mProgressRadius && this.mCircleRadius > 0.0f) {
            if (this.mPaint == null) {
                this.mPaint = new Paint(1);
                Paint paint = this.mPaint;
                if (paint != null) {
                    paint.setStyle(Paint.Style.STROKE);
                }
                Paint paint2 = this.mPaint;
                if (paint2 != null) {
                    paint2.setStrokeWidth(this.strokeWidth);
                }
                Paint paint3 = this.mPaint;
                if (paint3 != null) {
                    paint3.setColor(this.mCircleColor);
                }
            }
            float f = this.mCircleRadius;
            Paint paint4 = this.mPaint;
            Intrinsics.checkNotNull(paint4);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, f, paint4);
        }
        if (this.mProgressRadius > 0.0f && this.mProgress > 0) {
            if (this.mProgressPaint == null) {
                this.mProgressPaint = new Paint(1);
                Paint paint5 = this.mProgressPaint;
                if (paint5 != null) {
                    paint5.setStyle(Paint.Style.STROKE);
                }
                Paint paint6 = this.mProgressPaint;
                if (paint6 != null) {
                    paint6.setColor(this.mProgressColor);
                }
                Paint paint7 = this.mProgressPaint;
                if (paint7 != null) {
                    paint7.setStrokeWidth(this.strokeWidth);
                }
            }
            Paint paint8 = this.mProgressPaint;
            Intrinsics.checkNotNull(paint8);
            canvas.drawArc(this.mCanvasBounds, -90.0f, this.mProgress * 3.6f, false, paint8);
        }
    }
}