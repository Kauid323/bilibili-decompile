package tv.danmaku.bili.ui.splash.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashImageView.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J(\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Ltv/danmaku/bili/ui/splash/widget/SplashImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRadius", "", "mBoundsI", "Landroid/graphics/Rect;", "mRoundRectPath", "Landroid/graphics/Path;", "init", "", "onSetRadius", "setRadius", "radius", "newViewOutlineProvider", "Landroid/view/ViewOutlineProvider;", "draw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashImageView extends AppCompatImageView {
    public static final int $stable = 8;
    private Rect mBoundsI;
    private float mRadius;
    private Path mRoundRectPath;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SplashImageView(Context context) {
        super(context);
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        init();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SplashImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        init();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SplashImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        init();
    }

    private final void init() {
        this.mBoundsI = new Rect();
    }

    private final void onSetRadius() {
        boolean needClip = this.mRadius > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        setWillNotDraw(!needClip);
        if (needClip) {
            setClipToOutline(true);
            setOutlineProvider(newViewOutlineProvider());
            return;
        }
        setClipToOutline(false);
    }

    public final void setRadius(float radius) {
        if (!(this.mRadius == radius)) {
            this.mRadius = radius;
            onSetRadius();
        }
    }

    private final ViewOutlineProvider newViewOutlineProvider() {
        return new ViewOutlineProvider() { // from class: tv.danmaku.bili.ui.splash.widget.SplashImageView$newViewOutlineProvider$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                float f;
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                int width = view2.getWidth();
                int height = view2.getHeight();
                f = SplashImageView.this.mRadius;
                outline.setRoundRect(0, 0, width, height, f);
            }
        };
    }

    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mRoundRectPath == null) {
            if (!(this.mRadius == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN)) {
                Path clipPath = new Path();
                Rect rect = this.mBoundsI;
                Intrinsics.checkNotNull(rect);
                rect.set(0, 0, getWidth(), getHeight());
                RectF rectF = new RectF(this.mBoundsI);
                clipPath.addRoundRect(rectF, this.mRadius, this.mRadius, Path.Direction.CW);
                this.mRoundRectPath = clipPath;
            }
        }
        if (this.mRoundRectPath != null) {
            Path path = this.mRoundRectPath;
            Intrinsics.checkNotNull(path);
            canvas.clipPath(path);
        }
        super.draw(canvas);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mRoundRectPath = null;
    }
}