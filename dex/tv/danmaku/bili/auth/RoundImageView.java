package tv.danmaku.bili.auth;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import com.bilibili.app.accountui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: RoundImageView.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J(\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Ltv/danmaku/bili/auth/RoundImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCornerRadius", "", "mBitmapPaint", "Landroid/graphics/Paint;", "mMatrix", "Landroid/graphics/Matrix;", "mBitmapShader", "Landroid/graphics/BitmapShader;", "mWidth", "mRoundRect", "Landroid/graphics/RectF;", "mRoundPath", "Landroid/graphics/Path;", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setRoundPath", "setUpShader", "drawableToBitamp", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "dp2px", "dpVal", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RoundImageView extends ImageView {
    public static final int $stable = 8;
    private Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private float mCornerRadius;
    private Matrix mMatrix;
    private Path mRoundPath;
    private RectF mRoundRect;
    private int mWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBitmapPaint = new Paint();
        this.mMatrix = new Matrix();
        this.mRoundRect = new RectF();
        this.mRoundPath = new Path();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AuthRoundImageView, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(a, "obtainStyledAttributes(...)");
        this.mCornerRadius = a.getDimension(R.styleable.AuthRoundImageView_auth_corner_radius, dp2px(10));
        a.recycle();
        init();
    }

    public /* synthetic */ RoundImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void init() {
        this.mBitmapPaint.setAntiAlias(true);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mRoundRect.set(0.0f, 0.0f, w, h);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getDrawable() == null) {
            return;
        }
        setUpShader();
        setRoundPath();
        canvas.drawPath(this.mRoundPath, this.mBitmapPaint);
    }

    private final void setRoundPath() {
        this.mRoundPath.reset();
        this.mRoundPath.addRoundRect(this.mRoundRect, new float[]{this.mCornerRadius, this.mCornerRadius, this.mCornerRadius, this.mCornerRadius, this.mCornerRadius, this.mCornerRadius, this.mCornerRadius, this.mCornerRadius}, Path.Direction.CW);
    }

    private final void setUpShader() {
        Bitmap bmp;
        Drawable drawable = getDrawable();
        if (drawable == null || (bmp = drawableToBitamp(drawable)) == null) {
            return;
        }
        this.mBitmapShader = new BitmapShader(bmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        float scale = 1.0f;
        if (bmp.getWidth() != getWidth() || bmp.getHeight() != getHeight()) {
            scale = Math.max((getWidth() * 1.0f) / bmp.getWidth(), (getHeight() * 1.0f) / bmp.getHeight());
            float f = 2;
            float dx = ((bmp.getWidth() * scale) - getWidth()) / f;
            float dy = ((bmp.getHeight() * scale) - getHeight()) / f;
            this.mMatrix.setTranslate(-dx, -dy);
        }
        this.mMatrix.preScale(scale, scale);
        BitmapShader bitmapShader = this.mBitmapShader;
        Intrinsics.checkNotNull(bitmapShader);
        bitmapShader.setLocalMatrix(this.mMatrix);
        BitmapShader bitmapShader2 = this.mBitmapShader;
        Intrinsics.checkNotNull(bitmapShader2);
        bitmapShader2.setLocalMatrix(this.mMatrix);
        this.mBitmapPaint.setShader(this.mBitmapShader);
    }

    private final Bitmap drawableToBitamp(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

    private final int dp2px(int dpVal) {
        return (int) TypedValue.applyDimension(1, dpVal, getResources().getDisplayMetrics());
    }
}