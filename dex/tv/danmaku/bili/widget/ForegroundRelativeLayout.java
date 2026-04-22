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
import androidx.core.view.ViewCompat;
import com.bilibili.magicasakura.widgets.TintRelativeLayout;
import java.lang.reflect.Method;

public class ForegroundRelativeLayout extends TintRelativeLayout {
    private static Method sMethodTransparent;
    private Drawable mForeground;
    private boolean mForegroundBoundsChanged;
    private final Rect mOverlayBounds;
    private final Rect mSelfBounds;

    public ForegroundRelativeLayout(Context context) {
        this(context, null);
    }

    public ForegroundRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ForegroundRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mSelfBounds = new Rect();
        this.mOverlayBounds = new Rect();
        TypedArray a = context.obtainStyledAttributes(attrs, com.bilibili.lib.widget.R.styleable.ForegroundRelativeLayout, defStyle, 0);
        Drawable d = a.getDrawable(com.bilibili.lib.widget.R.styleable.ForegroundRelativeLayout_android_foreground);
        if (d != null) {
            setForeground(d);
        }
        int elevation = a.getDimensionPixelSize(com.bilibili.lib.widget.R.styleable.ForegroundRelativeLayout_elevation, 0);
        if (elevation != 0) {
            setElevationCompat(elevation);
        }
        a.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setElevationCompat(float elevation) {
        ViewCompat.setElevation(this, elevation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setForeground(Drawable drawable) {
        if (this.mForeground != drawable) {
            if (this.mForeground != null) {
                this.mForeground.setCallback(null);
                unscheduleDrawable(this.mForeground);
            }
            this.mForeground = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
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
        return super.verifyDrawable(who) || who == this.mForeground;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mForeground != null && this.mForeground.isStateful()) {
            this.mForeground.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mForeground != null) {
            this.mForeground.jumpToCurrentState();
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
        super.draw(canvas);
        drawForeground(canvas);
    }

    private void drawForeground(Canvas canvas) {
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
                GravityCompat.apply(119, foreground.getIntrinsicWidth(), foreground.getIntrinsicHeight(), selfBounds, overlayBounds, layoutDirection);
                foreground.setBounds(overlayBounds);
            }
            foreground.draw(canvas);
        }
    }

    public int getLayoutDirectionCompat() {
        try {
            return getLayoutDirection();
        } catch (NoSuchMethodError e) {
            return 0;
        }
    }

    public boolean gatherTransparentRegion(Region region) {
        boolean opaque = super.gatherTransparentRegion(region);
        return opaque;
    }

    private void applyDrawableToTransparentRegionCompat(Drawable dr, Region region) {
        try {
            if (sMethodTransparent == null) {
                sMethodTransparent = View.class.getDeclaredMethod("applyDrawableToTransparentRegion", Drawable.class, Region.class);
            }
            sMethodTransparent.invoke(this, dr, region);
        } catch (Exception e) {
        }
    }

    public void drawableHotspotChanged(float x, float y) {
        super.drawableHotspotChanged(x, y);
        if (this.mForeground != null) {
            this.mForeground.setHotspot(x, y);
        }
    }
}