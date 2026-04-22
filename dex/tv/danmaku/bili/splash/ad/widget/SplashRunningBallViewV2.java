package tv.danmaku.bili.splash.ad.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.adsplash.R;

/* compiled from: SplashRunningBallViewV2.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u0000 d2\u00020\u0001:\u0001dB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010N\u001a\u0002042\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010O\u001a\u00020\u0007H\u0002J(\u0010P\u001a\u0002042\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u0007H\u0014J\u0010\u0010U\u001a\u0002042\u0006\u0010V\u001a\u00020WH\u0014J\u0010\u0010X\u001a\u0002042\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010Y\u001a\u0002042\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010Z\u001a\u0002042\u0006\u0010V\u001a\u00020WH\u0002J\u0018\u0010[\u001a\u0002042\u0006\u0010\\\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u000bH\u0002J\u000e\u0010_\u001a\u0002042\u0006\u0010`\u001a\u00020\u000bJ\u0006\u0010a\u001a\u000203J\u0018\u0010b\u001a\u0002032\u0006\u0010M\u001a\u00020L2\u0006\u0010;\u001a\u00020\u000bH\u0002J\u0018\u0010c\u001a\u0002042\u0006\u0010M\u001a\u00020L2\u0006\u0010;\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010,\u001a\u0004\u0018\u00010+2\b\u0010*\u001a\u0004\u0018\u00010+@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R(\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bA\u0010BR\u001b\u0010E\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010D\u001a\u0004\bF\u0010BR\u001b\u0010H\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010D\u001a\u0004\bI\u0010BR\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Ltv/danmaku/bili/splash/ad/widget/SplashRunningBallViewV2;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerRadius", "", "strokeWidth", "holeStrokeWidth", "ballMarginPercent", "bgColor", "getBgColor", "()I", "setBgColor", "(I)V", "strokeColor", "getStrokeColor", "setStrokeColor", "holeBgColor", "getHoleBgColor", "setHoleBgColor", "holeStrokeColor", "getHoleStrokeColor", "setHoleStrokeColor", "maxAngle", "", "getMaxAngle", "()D", "setMaxAngle", "(D)V", "thresholdPercent", "getThresholdPercent", "()F", "setThresholdPercent", "(F)V", "ballBitmap", "Landroid/graphics/Bitmap;", "value", "", "ballFile", "getBallFile", "()Ljava/lang/String;", "setBallFile", "(Ljava/lang/String;)V", "onReachedAction", "Lkotlin/Function1;", "", "", "getOnReachedAction", "()Lkotlin/jvm/functions/Function1;", "setOnReachedAction", "(Lkotlin/jvm/functions/Function1;)V", "ballGap", "ballRadius", "limitRadius", "bgRectF", "Landroid/graphics/RectF;", "ballRectF", "bgPaint", "Landroid/graphics/Paint;", "getBgPaint", "()Landroid/graphics/Paint;", "bgPaint$delegate", "Lkotlin/Lazy;", "holePaint", "getHolePaint", "holePaint$delegate", "mBallPaint", "getMBallPaint", "mBallPaint$delegate", "centerPoint", "Landroid/graphics/PointF;", "ballPoint", "init", "defStyle", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawBg", "drawHole", "drawBall", "convertCoordinate", "rollAngle", "radius", "hasReached", "setAngle", "angle", "hasReachedThreshold", "outLimit", "onCirclePoint", "Companion", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashRunningBallViewV2 extends View {
    private Bitmap ballBitmap;
    private String ballFile;
    private float ballGap;
    private float ballMarginPercent;
    private final PointF ballPoint;
    private float ballRadius;
    private final RectF ballRectF;
    private int bgColor;
    private final Lazy bgPaint$delegate;
    private final RectF bgRectF;
    private final PointF centerPoint;
    private float cornerRadius;
    private boolean hasReached;
    private int holeBgColor;
    private final Lazy holePaint$delegate;
    private int holeStrokeColor;
    private float holeStrokeWidth;
    private float limitRadius;
    private final Lazy mBallPaint$delegate;
    private double maxAngle;
    private Function1<? super Boolean, Unit> onReachedAction;
    private int strokeColor;
    private float strokeWidth;
    private float thresholdPercent;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashRunningBallViewV2(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashRunningBallViewV2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashRunningBallViewV2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxAngle = Math.toRadians(15.0d);
        this.bgRectF = new RectF();
        this.ballRectF = new RectF();
        this.bgPaint$delegate = ListExtentionsKt.lazyUnsafe(new Function0() { // from class: tv.danmaku.bili.splash.ad.widget.SplashRunningBallViewV2$$ExternalSyntheticLambda0
            public final Object invoke() {
                Paint bgPaint_delegate$lambda$0;
                bgPaint_delegate$lambda$0 = SplashRunningBallViewV2.bgPaint_delegate$lambda$0(SplashRunningBallViewV2.this);
                return bgPaint_delegate$lambda$0;
            }
        });
        this.holePaint$delegate = ListExtentionsKt.lazyUnsafe(new Function0() { // from class: tv.danmaku.bili.splash.ad.widget.SplashRunningBallViewV2$$ExternalSyntheticLambda1
            public final Object invoke() {
                Paint holePaint_delegate$lambda$0;
                holePaint_delegate$lambda$0 = SplashRunningBallViewV2.holePaint_delegate$lambda$0(SplashRunningBallViewV2.this);
                return holePaint_delegate$lambda$0;
            }
        });
        this.mBallPaint$delegate = ListExtentionsKt.lazyUnsafe(new Function0() { // from class: tv.danmaku.bili.splash.ad.widget.SplashRunningBallViewV2$$ExternalSyntheticLambda2
            public final Object invoke() {
                Paint mBallPaint_delegate$lambda$0;
                mBallPaint_delegate$lambda$0 = SplashRunningBallViewV2.mBallPaint_delegate$lambda$0();
                return mBallPaint_delegate$lambda$0;
            }
        });
        this.centerPoint = new PointF();
        this.ballPoint = new PointF();
        init(attrs, defStyleAttr);
    }

    public /* synthetic */ SplashRunningBallViewV2(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(int i) {
        this.bgColor = i;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final void setStrokeColor(int i) {
        this.strokeColor = i;
    }

    public final int getHoleBgColor() {
        return this.holeBgColor;
    }

    public final void setHoleBgColor(int i) {
        this.holeBgColor = i;
    }

    public final int getHoleStrokeColor() {
        return this.holeStrokeColor;
    }

    public final void setHoleStrokeColor(int i) {
        this.holeStrokeColor = i;
    }

    public final double getMaxAngle() {
        return this.maxAngle;
    }

    public final void setMaxAngle(double d) {
        this.maxAngle = d;
    }

    public final float getThresholdPercent() {
        return this.thresholdPercent;
    }

    public final void setThresholdPercent(float f) {
        this.thresholdPercent = f;
    }

    public final String getBallFile() {
        return this.ballFile;
    }

    public final void setBallFile(String value) {
        Bitmap it;
        Bitmap it2;
        this.ballFile = value;
        if (value == null || (it2 = BitmapFactory.decodeFile(value)) == null) {
            it = null;
        } else {
            it = Companion.makeRoundCorner(it2, this.cornerRadius);
        }
        this.ballBitmap = it;
        invalidate();
    }

    public final Function1<Boolean, Unit> getOnReachedAction() {
        return this.onReachedAction;
    }

    public final void setOnReachedAction(Function1<? super Boolean, Unit> function1) {
        this.onReachedAction = function1;
    }

    private final Paint getBgPaint() {
        return (Paint) this.bgPaint$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint bgPaint_delegate$lambda$0(SplashRunningBallViewV2 this$0) {
        Paint $this$bgPaint_delegate_u24lambda_u240_u240 = new Paint();
        $this$bgPaint_delegate_u24lambda_u240_u240.setAntiAlias(true);
        $this$bgPaint_delegate_u24lambda_u240_u240.setStrokeWidth(this$0.strokeWidth);
        return $this$bgPaint_delegate_u24lambda_u240_u240;
    }

    private final Paint getHolePaint() {
        return (Paint) this.holePaint$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint holePaint_delegate$lambda$0(SplashRunningBallViewV2 this$0) {
        Paint $this$holePaint_delegate_u24lambda_u240_u240 = new Paint();
        $this$holePaint_delegate_u24lambda_u240_u240.setAntiAlias(true);
        $this$holePaint_delegate_u24lambda_u240_u240.setStrokeWidth(this$0.holeStrokeWidth);
        return $this$holePaint_delegate_u24lambda_u240_u240;
    }

    private final Paint getMBallPaint() {
        return (Paint) this.mBallPaint$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint mBallPaint_delegate$lambda$0() {
        Paint $this$mBallPaint_delegate_u24lambda_u240_u240 = new Paint();
        $this$mBallPaint_delegate_u24lambda_u240_u240.setAntiAlias(true);
        return $this$mBallPaint_delegate_u24lambda_u240_u240;
    }

    private final void init(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SplashRunningBallViewV2, defStyle, 0);
        Intrinsics.checkNotNullExpressionValue(a, "obtainStyledAttributes(...)");
        this.cornerRadius = a.getDimension(R.styleable.SplashRunningBallViewV2_cornerRadius, this.cornerRadius);
        this.bgColor = a.getColor(R.styleable.SplashRunningBallViewV2_bgColor, this.bgColor);
        this.strokeColor = a.getColor(R.styleable.SplashRunningBallViewV2_strokeColor, this.strokeColor);
        this.strokeWidth = a.getDimension(R.styleable.SplashRunningBallViewV2_strokeWidth, this.strokeWidth);
        this.holeBgColor = a.getColor(R.styleable.SplashRunningBallViewV2_holeBgColor, this.holeBgColor);
        this.holeStrokeColor = a.getColor(R.styleable.SplashRunningBallViewV2_holeStrokeColor, this.holeStrokeColor);
        this.holeStrokeWidth = a.getDimension(R.styleable.SplashRunningBallViewV2_holeStrokeWidth, this.holeStrokeWidth);
        this.ballMarginPercent = a.getFloat(R.styleable.SplashRunningBallViewV2_ballMarginPercent, this.ballMarginPercent);
        a.recycle();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        float x = w / 2.0f;
        float y = h / 2.0f;
        this.centerPoint.set(x, y);
        this.ballPoint.set(x, y);
        this.bgRectF.set(this.strokeWidth / 2.0f, this.strokeWidth / 2.0f, w - (this.strokeWidth / 2.0f), h - (this.strokeWidth / 2.0f));
        this.ballGap = (float) Math.floor(h * this.ballMarginPercent);
        this.ballRadius = (h - (this.ballGap * 2)) / 2.0f;
        this.limitRadius = (((w / 2.0f) - this.strokeWidth) - this.ballGap) - this.ballRadius;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawBg(canvas);
        drawHole(canvas);
        drawBall(canvas);
    }

    private final void drawBg(Canvas canvas) {
        getBgPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        getBgPaint().setColor(this.bgColor);
        canvas.drawRoundRect(this.bgRectF, this.cornerRadius, this.cornerRadius, getBgPaint());
        getBgPaint().setStyle(Paint.Style.STROKE);
        getBgPaint().setColor(this.strokeColor);
        canvas.drawRoundRect(this.bgRectF, this.cornerRadius, this.cornerRadius, getBgPaint());
    }

    private final void drawHole(Canvas canvas) {
        float x = this.strokeWidth + this.ballGap + this.ballRadius;
        float dx = this.centerPoint.x - x;
        getHolePaint().setStyle(Paint.Style.FILL_AND_STROKE);
        getHolePaint().setColor(this.holeBgColor);
        canvas.drawCircle(this.centerPoint.x - dx, this.centerPoint.y, this.ballRadius, getHolePaint());
        canvas.drawCircle(this.centerPoint.x + dx, this.centerPoint.y, this.ballRadius, getHolePaint());
        getHolePaint().setStyle(Paint.Style.STROKE);
        getHolePaint().setColor(this.holeStrokeColor);
        PathEffect effects = new DashPathEffect(new float[]{10.0f, 10.0f}, 1.0f);
        getHolePaint().setPathEffect(effects);
        canvas.drawCircle(this.centerPoint.x - dx, this.centerPoint.y, this.ballRadius, getHolePaint());
        canvas.drawCircle(this.centerPoint.x + dx, this.centerPoint.y, this.ballRadius, getHolePaint());
    }

    private final void drawBall(Canvas canvas) {
        if (this.ballBitmap == null) {
            return;
        }
        canvas.save();
        float radian = (this.ballPoint.x - this.centerPoint.x) / this.ballRadius;
        float degrees = (float) Math.toDegrees(radian);
        canvas.rotate(degrees, this.ballPoint.x, this.ballPoint.y);
        this.ballRectF.set((this.ballPoint.x - this.ballRadius) - this.holeStrokeWidth, (this.ballPoint.y - this.ballRadius) - this.holeStrokeWidth, this.ballPoint.x + this.ballRadius + this.holeStrokeWidth, this.ballPoint.y + this.ballRadius + this.holeStrokeWidth);
        Bitmap bitmap = this.ballBitmap;
        Intrinsics.checkNotNull(bitmap);
        canvas.drawBitmap(bitmap, (Rect) null, this.ballRectF, getMBallPaint());
        canvas.restore();
    }

    private final void convertCoordinate(float rollAngle, float radius) {
        double scale = radius / this.maxAngle;
        float dx = -((float) (rollAngle * scale));
        float x = this.centerPoint.x - dx;
        float y = this.centerPoint.y;
        this.ballPoint.x = x;
        this.ballPoint.y = y;
    }

    public final void setAngle(float angle) {
        if (this.hasReached) {
            return;
        }
        convertCoordinate(angle, this.limitRadius);
        if (outLimit(this.ballPoint, this.limitRadius)) {
            onCirclePoint(this.ballPoint, this.limitRadius);
            Function1<? super Boolean, Unit> function1 = this.onReachedAction;
            if (function1 != null) {
                function1.invoke(false);
            }
            this.hasReached = true;
        }
        invalidate();
    }

    public final boolean hasReachedThreshold() {
        if (this.thresholdPercent > 0.0f) {
            if (this.thresholdPercent > 1.0f) {
                this.thresholdPercent = 1.0f;
            }
            return Math.abs(this.ballPoint.x - this.centerPoint.x) >= this.limitRadius * this.thresholdPercent;
        }
        return false;
    }

    private final boolean outLimit(PointF ballPoint, float limitRadius) {
        return Math.abs(ballPoint.x - this.centerPoint.x) > limitRadius;
    }

    private final void onCirclePoint(PointF ballPoint, float limitRadius) {
        if (ballPoint.x > this.centerPoint.x) {
            ballPoint.x = this.centerPoint.x + limitRadius;
        } else {
            ballPoint.x = this.centerPoint.x - limitRadius;
        }
    }

    /* compiled from: SplashRunningBallViewV2.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\tH\u0002¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/splash/ad/widget/SplashRunningBallViewV2$Companion;", "", "<init>", "()V", "buildSplashRunningBallView", "Ltv/danmaku/bili/splash/ad/widget/SplashRunningBallViewV2;", "context", "Landroid/content/Context;", "adjustRadian", "", "degrees", "", "makeRoundCorner", "Landroid/graphics/Bitmap;", "bitmap", "px", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SplashRunningBallViewV2 buildSplashRunningBallView(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            View inflate = LayoutInflater.from(context).inflate(R.layout.bili_app_layout_splash_runningball_view_common, (ViewGroup) null, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type tv.danmaku.bili.splash.ad.widget.SplashRunningBallViewV2");
            return (SplashRunningBallViewV2) inflate;
        }

        public final float adjustRadian(float[] degrees) {
            double v;
            float b;
            Intrinsics.checkNotNullParameter(degrees, "degrees");
            double y = -degrees[1];
            double z = degrees[2];
            if (y * z > 0.0d) {
                double d = 2;
                v = Math.sqrt(Math.pow(y, d) + Math.pow(z, d));
            } else {
                v = Math.abs(y + z);
            }
            if (y + z > 0.0d) {
                b = 1.0f;
            } else {
                b = -1.0f;
            }
            return (float) (b * v);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bitmap makeRoundCorner(Bitmap bitmap, float px) {
            if (bitmap == null) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap.Config config$iv = Bitmap.Config.ARGB_8888;
            Bitmap output = Bitmap.createBitmap(width, height, config$iv);
            Canvas canvas = new Canvas(output);
            Rect rect = new Rect(0, 0, width, height);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-16777216);
            canvas.drawRoundRect(new RectF(rect), px, px, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            paint.setXfermode(null);
            return output;
        }
    }
}