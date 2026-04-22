package tv.danmaku.bili.widget.fab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import androidx.appcompat.widget.AppCompatTextView;

public class Label extends AppCompatTextView {
    private static final Xfermode PORTER_DUFF_CLEAR = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    private Drawable mBackgroundDrawable;
    private int mColorNormal;
    private int mColorPressed;
    private int mColorRipple;
    private int mCornerRadius;
    private FloatingActionButton mFab;
    private GestureDetector mGestureDetector;
    private boolean mHandleVisibilityChanges;
    private Animation mHideAnimation;
    private int mRawHeight;
    private int mRawWidth;
    private int mShadowColor;
    private int mShadowRadius;
    private int mShadowXOffset;
    private int mShadowYOffset;
    private Animation mShowAnimation;
    private boolean mShowShadow;
    private boolean mUsingStyle;

    public Label(Context context) {
        super(context);
        this.mShowShadow = true;
        this.mHandleVisibilityChanges = true;
        init(context);
    }

    public Label(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mShowShadow = true;
        this.mHandleVisibilityChanges = true;
        init(context);
    }

    public Label(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mShowShadow = true;
        this.mHandleVisibilityChanges = true;
        init(context);
    }

    private void init(Context context) {
        this.mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: tv.danmaku.bili.widget.fab.Label.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                Label.this.onActionDown();
                if (Label.this.mFab != null) {
                    Label.this.mFab.onActionDown();
                }
                return super.onDown(e);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e) {
                Label.this.onActionUp();
                if (Label.this.mFab != null) {
                    Label.this.mFab.onActionUp();
                }
                return super.onSingleTapUp(e);
            }
        });
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(calculateMeasuredWidth(), calculateMeasuredHeight());
    }

    private int calculateMeasuredWidth() {
        if (this.mRawWidth == 0) {
            this.mRawWidth = getMeasuredWidth();
        }
        return getMeasuredWidth() + calculateShadowWidth();
    }

    private int calculateMeasuredHeight() {
        if (this.mRawHeight == 0) {
            this.mRawHeight = getMeasuredHeight();
        }
        return getMeasuredHeight() + calculateShadowHeight();
    }

    int calculateShadowWidth() {
        if (this.mShowShadow) {
            return this.mShadowRadius + Math.abs(this.mShadowXOffset);
        }
        return 0;
    }

    int calculateShadowHeight() {
        if (this.mShowShadow) {
            return this.mShadowRadius + Math.abs(this.mShadowYOffset);
        }
        return 0;
    }

    void updateBackground() {
        LayerDrawable layerDrawable;
        if (this.mShowShadow) {
            LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{new Shadow(), createFillDrawable()});
            int leftInset = this.mShadowRadius + Math.abs(this.mShadowXOffset);
            int topInset = this.mShadowRadius + Math.abs(this.mShadowYOffset);
            int rightInset = this.mShadowRadius + Math.abs(this.mShadowXOffset);
            int bottomInset = this.mShadowRadius + Math.abs(this.mShadowYOffset);
            layerDrawable2.setLayerInset(1, leftInset, topInset, rightInset, bottomInset);
            layerDrawable = layerDrawable2;
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{createFillDrawable()});
        }
        setBackgroundCompat(layerDrawable);
    }

    private Drawable createFillDrawable() {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{16842919}, createRectDrawable(this.mColorPressed));
        drawable.addState(new int[0], createRectDrawable(this.mColorNormal));
        RippleDrawable ripple = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{this.mColorRipple}), drawable, null);
        setOutlineProvider(new ViewOutlineProvider() { // from class: tv.danmaku.bili.widget.fab.Label.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setOval(0, 0, view2.getWidth(), view2.getHeight());
            }
        });
        setClipToOutline(true);
        this.mBackgroundDrawable = ripple;
        return ripple;
    }

    private Drawable createRectDrawable(int color) {
        RoundRectShape shape = new RoundRectShape(new float[]{this.mCornerRadius, this.mCornerRadius, this.mCornerRadius, this.mCornerRadius, this.mCornerRadius, this.mCornerRadius, this.mCornerRadius, this.mCornerRadius}, null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable(shape);
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

    private void setShadow(FloatingActionButton fab) {
        this.mShadowColor = fab.getShadowColor();
        this.mShadowRadius = fab.getShadowRadius();
        this.mShadowXOffset = fab.getShadowXOffset();
        this.mShadowYOffset = fab.getShadowYOffset();
        this.mShowShadow = fab.hasShadow();
    }

    private void setBackgroundCompat(Drawable drawable) {
        setBackground(drawable);
    }

    private void playShowAnimation() {
        if (this.mShowAnimation != null) {
            if (this.mHideAnimation != null) {
                this.mHideAnimation.cancel();
            }
            startAnimation(this.mShowAnimation);
        }
    }

    private void playHideAnimation() {
        if (this.mHideAnimation != null) {
            if (this.mShowAnimation != null) {
                this.mShowAnimation.cancel();
            }
            startAnimation(this.mHideAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActionDown() {
        if (this.mUsingStyle) {
            this.mBackgroundDrawable = getBackground();
        }
        if (this.mBackgroundDrawable instanceof StateListDrawable) {
            StateListDrawable drawable = (StateListDrawable) this.mBackgroundDrawable;
            drawable.setState(new int[]{16842919});
        } else if (this.mBackgroundDrawable instanceof RippleDrawable) {
            RippleDrawable ripple = (RippleDrawable) this.mBackgroundDrawable;
            ripple.setState(new int[]{16842910, 16842919});
            ripple.setHotspot(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
            ripple.setVisible(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActionUp() {
        if (this.mUsingStyle) {
            this.mBackgroundDrawable = getBackground();
        }
        if (this.mBackgroundDrawable instanceof StateListDrawable) {
            StateListDrawable drawable = (StateListDrawable) this.mBackgroundDrawable;
            drawable.setState(new int[0]);
        } else if (this.mBackgroundDrawable instanceof RippleDrawable) {
            RippleDrawable ripple = (RippleDrawable) this.mBackgroundDrawable;
            ripple.setState(new int[0]);
            ripple.setHotspot(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
            ripple.setVisible(true, true);
        }
    }

    void setFab(FloatingActionButton fab) {
        this.mFab = fab;
        setShadow(fab);
    }

    void setShowShadow(boolean show) {
        this.mShowShadow = show;
    }

    void setCornerRadius(int cornerRadius) {
        this.mCornerRadius = cornerRadius;
    }

    void setColors(int colorNormal, int colorPressed, int colorRipple) {
        this.mColorNormal = colorNormal;
        this.mColorPressed = colorPressed;
        this.mColorRipple = colorRipple;
    }

    void show(boolean animate) {
        if (animate) {
            playShowAnimation();
        }
        setVisibility(0);
    }

    void hide(boolean animate) {
        if (animate) {
            playHideAnimation();
        }
        setVisibility(4);
    }

    void setShowAnimation(Animation showAnimation) {
        this.mShowAnimation = showAnimation;
    }

    void setHideAnimation(Animation hideAnimation) {
        this.mHideAnimation = hideAnimation;
    }

    void setUsingStyle(boolean usingStyle) {
        this.mUsingStyle = usingStyle;
    }

    void setHandleVisibilityChanges(boolean handle) {
        this.mHandleVisibilityChanges = handle;
    }

    boolean isHandleVisibilityChanges() {
        return this.mHandleVisibilityChanges;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.mFab == null || this.mFab.getOnClickListener() == null || !this.mFab.isEnabled()) {
            return super.onTouchEvent(event);
        }
        int action = event.getAction();
        switch (action) {
            case 1:
                onActionUp();
                this.mFab.onActionUp();
                break;
        }
        this.mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private final class Shadow extends Drawable {
        private Paint mErase;
        private Paint mPaint;

        private Shadow() {
            this.mPaint = new Paint(1);
            this.mErase = new Paint(1);
            init();
        }

        private void init() {
            Label.this.setLayerType(1, null);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(Label.this.mColorNormal);
            this.mErase.setXfermode(Label.PORTER_DUFF_CLEAR);
            if (!Label.this.isInEditMode()) {
                this.mPaint.setShadowLayer(Label.this.mShadowRadius, Label.this.mShadowXOffset, Label.this.mShadowYOffset, Label.this.mShadowColor);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            RectF shadowRect = new RectF(Label.this.mShadowRadius + Math.abs(Label.this.mShadowXOffset), Label.this.mShadowRadius + Math.abs(Label.this.mShadowYOffset), Label.this.mRawWidth, Label.this.mRawHeight);
            canvas.drawRoundRect(shadowRect, Label.this.mCornerRadius, Label.this.mCornerRadius, this.mPaint);
            canvas.drawRoundRect(shadowRect, Label.this.mCornerRadius, Label.this.mCornerRadius, this.mErase);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter cf) {
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }
    }
}