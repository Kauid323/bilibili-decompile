package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import java.lang.reflect.Method;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class ForegroundConstraintLayout extends TintConstraintLayout {
    private static Method sMethodTransparent;
    private Rect mBoundsI;
    private Drawable mForeground;
    private boolean mForegroundBoundsChanged;
    private final Rect mOverlayBounds;
    private float mRadius;
    private Path mRoundRectPath;
    private final Rect mSelfBounds;

    public ForegroundConstraintLayout(Context context) {
        this(context, null);
    }

    public ForegroundConstraintLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ForegroundConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mSelfBounds = new Rect();
        this.mOverlayBounds = new Rect();
        TypedArray a = context.obtainStyledAttributes(attrs, com.bilibili.lib.widget.R.styleable.ForegroundConstraintLayout, defStyleAttr, 0);
        float radius = a.getDimension(com.bilibili.lib.widget.R.styleable.ForegroundConstraintLayout_fc_cornerRadius, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        setRadius(radius);
        this.mBoundsI = new Rect();
        Drawable d = a.getDrawable(com.bilibili.lib.widget.R.styleable.ForegroundConstraintLayout_fc_foreground);
        if (d != null) {
            setForeground(d);
        }
        int elevation = a.getDimensionPixelSize(com.bilibili.lib.widget.R.styleable.ForegroundConstraintLayout_fc_elevation, 0);
        if (elevation != 0) {
            setElevationCompat(elevation);
        }
        a.recycle();
    }

    private void onSetRadius() {
        boolean needClip = this.mRadius > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        setWillNotDraw(!needClip);
        if (needClip) {
            setClipToOutline(true);
            setOutlineProvider(newViewOutlineProvider());
            return;
        }
        setClipToOutline(false);
    }

    public void setRadius(float radius) {
        if (this.mRadius != radius) {
            this.mRadius = radius;
            onSetRadius();
        }
    }

    private ViewOutlineProvider newViewOutlineProvider() {
        return new ViewOutlineProvider() { // from class: tv.danmaku.bili.widget.ForegroundConstraintLayout.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), ForegroundConstraintLayout.this.mRadius);
            }
        };
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
        this.mRoundRectPath = null;
        this.mForegroundBoundsChanged = true;
    }

    public void draw(Canvas canvas) {
        drawRoundRect(canvas);
        super.draw(canvas);
        drawForeground(canvas);
    }

    private void drawRoundRect(Canvas canvas) {
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