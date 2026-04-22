package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.GravityCompat;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ForegroundLinearLayout.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 32\u00020\u0001:\u00013B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000bH\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\b\u0010\u001a\u001a\u00020\u0015H\u0017J0\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J(\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0002J\u0012\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0018\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,H\u0003J\u0018\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0017R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00078CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00064"}, d2 = {"Ltv/danmaku/bili/widget/ForegroundLinearLayout;", "Lcom/bilibili/magicasakura/widgets/TintLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mForeground", "Landroid/graphics/drawable/Drawable;", "mForegroundBoundsChanged", "", "mSelfBounds", "Landroid/graphics/Rect;", "mOverlayBounds", "layoutDirectionCompat", "getLayoutDirectionCompat", "()I", "setForeground", "", "drawable", "verifyDrawable", "who", "drawableStateChanged", "jumpDrawablesToCurrentState", "onLayout", "changed", "l", "t", "r", "b", "onSizeChanged", "w", "h", "oldw", "oldh", "draw", "canvas", "Landroid/graphics/Canvas;", "drawForeground", "gatherTransparentRegion", "region", "Landroid/graphics/Region;", "applyDrawableToTransparentRegionCompat", "dr", "drawableHotspotChanged", "x", "", "y", "Companion", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ForegroundLinearLayout extends TintLinearLayout {
    public static final Companion Companion = new Companion(null);
    private static Method sMethodTransparent;
    private Drawable mForeground;
    private boolean mForegroundBoundsChanged;
    private final Rect mOverlayBounds;
    private final Rect mSelfBounds;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForegroundLinearLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForegroundLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSelfBounds = new Rect();
        this.mOverlayBounds = new Rect();
        TypedArray a = context.obtainStyledAttributes(attrs, com.bilibili.lib.widget.R.styleable.ForegroundLayout, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(a, "obtainStyledAttributes(...)");
        Drawable d = a.getDrawable(com.bilibili.lib.widget.R.styleable.ForegroundLayout_android_foreground);
        if (d != null) {
            setForeground(d);
        }
        a.recycle();
    }

    public /* synthetic */ ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final int getLayoutDirectionCompat() {
        try {
            return getLayoutDirection();
        } catch (NoSuchMethodError e) {
            return 0;
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.mForeground != drawable) {
            if (this.mForeground != null) {
                Drawable drawable2 = this.mForeground;
                Intrinsics.checkNotNull(drawable2);
                drawable2.setCallback(null);
                unscheduleDrawable(this.mForeground);
            }
            this.mForeground = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback((Drawable.Callback) this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        return super.verifyDrawable(who) || who == this.mForeground;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mForeground != null) {
            Drawable drawable = this.mForeground;
            Intrinsics.checkNotNull(drawable);
            if (drawable.isStateful()) {
                Drawable drawable2 = this.mForeground;
                Intrinsics.checkNotNull(drawable2);
                drawable2.setState(getDrawableState());
            }
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mForeground != null) {
            Drawable drawable = this.mForeground;
            Intrinsics.checkNotNull(drawable);
            drawable.jumpToCurrentState();
        }
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.mForegroundBoundsChanged = true;
        super.onLayout(changed, l, t, r, b);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mForegroundBoundsChanged = true;
    }

    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        drawForeground(canvas);
    }

    private final void drawForeground(Canvas canvas) {
        if (this.mForeground != null) {
            Drawable foreground = this.mForeground;
            if (this.mForegroundBoundsChanged) {
                this.mForegroundBoundsChanged = false;
                Rect selfBounds = this.mSelfBounds;
                Rect overlayBounds = this.mOverlayBounds;
                int w = getRight() - getLeft();
                int h = getBottom() - getTop();
                selfBounds.set(0, 0, w, h);
                int layoutDirection = getLayoutDirectionCompat();
                Intrinsics.checkNotNull(foreground);
                GravityCompat.apply(119, foreground.getIntrinsicWidth(), foreground.getIntrinsicHeight(), selfBounds, overlayBounds, layoutDirection);
                foreground.setBounds(overlayBounds);
            }
            Intrinsics.checkNotNull(foreground);
            foreground.draw(canvas);
        }
    }

    public boolean gatherTransparentRegion(Region region) {
        boolean opaque = super.gatherTransparentRegion(region);
        return opaque;
    }

    private final void applyDrawableToTransparentRegionCompat(Drawable dr, Region region) {
        try {
            if (sMethodTransparent == null) {
                sMethodTransparent = View.class.getDeclaredMethod("applyDrawableToTransparentRegion", Drawable.class, Region.class);
            }
            Method method = sMethodTransparent;
            Intrinsics.checkNotNull(method);
            method.invoke(this, dr, region);
        } catch (Exception e) {
        }
    }

    public void drawableHotspotChanged(float x, float y) {
        super.drawableHotspotChanged(x, y);
        if (this.mForeground != null) {
            Drawable drawable = this.mForeground;
            Intrinsics.checkNotNull(drawable);
            drawable.setHotspot(x, y);
        }
    }

    /* compiled from: ForegroundLinearLayout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/widget/ForegroundLinearLayout$Companion;", "", "<init>", "()V", "sMethodTransparent", "Ljava/lang/reflect/Method;", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}