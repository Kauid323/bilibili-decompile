package tv.danmaku.bili.ui.splash.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashShimmerTextView.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0014J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Ltv/danmaku/bili/ui/splash/widget/SplashShimmerTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mTextViewWidth", "mPaint", "Landroid/graphics/Paint;", "mLinearGradient", "Landroid/graphics/LinearGradient;", "mMatrix", "Landroid/graphics/Matrix;", "mTranslateX", "mMaskPaint", "mMaskRect", "Landroid/graphics/Rect;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setMaskRectWidth", "width", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashShimmerTextView extends AppCompatTextView {
    public static final int $stable = 8;
    private LinearGradient mLinearGradient;
    private Paint mMaskPaint;
    private Rect mMaskRect;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mTextViewWidth;
    private int mTranslateX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashShimmerTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashShimmerTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SplashShimmerTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        this.mMatrix = new Matrix();
        this.mMaskPaint = new Paint();
        this.mMaskRect = new Rect();
    }

    public /* synthetic */ SplashShimmerTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (this.mTextViewWidth == 0) {
            this.mTextViewWidth = getMeasuredWidth();
            if (this.mTextViewWidth <= 0) {
                return;
            }
            this.mPaint = getPaint();
            this.mLinearGradient = new LinearGradient((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, getMeasuredHeight(), this.mTextViewWidth, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, new int[]{1358954495, -1, 1358954495}, new float[]{DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
            Paint paint = this.mPaint;
            Intrinsics.checkNotNull(paint);
            paint.setShader(this.mLinearGradient);
            this.mMaskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            this.mMaskPaint.setColor(0);
            this.mMaskPaint.setStyle(Paint.Style.FILL);
            this.mMaskRect.set(0, 0, 0, getMeasuredHeight());
        }
    }

    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int sc = canvas.saveLayer(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, getMeasuredWidth(), getMeasuredHeight(), null, 31);
        super.onDraw(canvas);
        this.mTranslateX += this.mTextViewWidth / 10;
        if (this.mTranslateX > this.mTextViewWidth * 2) {
            this.mTranslateX = -this.mTextViewWidth;
        }
        this.mMatrix.setTranslate(this.mTranslateX, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        LinearGradient linearGradient = this.mLinearGradient;
        Intrinsics.checkNotNull(linearGradient);
        linearGradient.setLocalMatrix(this.mMatrix);
        if (this.mMaskRect.width() > 0) {
            canvas.drawRect(this.mMaskRect, this.mMaskPaint);
        }
        canvas.restoreToCount(sc);
        postInvalidateDelayed(20L);
    }

    public final void setMaskRectWidth(int width) {
        this.mMaskRect.right = width;
    }
}