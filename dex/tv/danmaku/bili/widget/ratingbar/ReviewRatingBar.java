package tv.danmaku.bili.widget.ratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bilibili.lib.widget.R;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class ReviewRatingBar extends LinearLayout {
    private static final int FILL_MODE_FULL = 2;
    private static final int FILL_MODE_HALF = 1;
    public static final int MODE_CLICK = 1;
    public static final int MODE_TOUCH = 0;
    private boolean isTouchable;
    private List<Runnable> mAnimRunnables;
    private Runnable mAppendRunnable;
    private Drawable mEmptyDrawable;
    private int mEmptyTint;
    private int mFillMode;
    private Drawable mFilledDrawable;
    private int mFilledTint;
    private int mLastCallbackIndex;
    private float mLastEventX;
    private int mLastIndex;
    private int mMode;
    private OnRatingChangeListener mOnRatingChangeListener;
    private float mRating;
    private int mRatingCount;
    private int mRatingPadding;
    private List<RatingView> mRatingViews;
    private int mScoreSeg;
    private int mSize;

    public ReviewRatingBar(Context context) {
        this(context, null);
    }

    public ReviewRatingBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ReviewRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mRatingViews = new ArrayList();
        this.mMode = 0;
        this.mAnimRunnables = new ArrayList();
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOrientation(0);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WidgetReviewRatingBar);
        try {
            this.mRatingCount = typedArray.getInt(R.styleable.WidgetReviewRatingBar_ratingCount, 5);
            this.mRatingCount = this.mRatingCount >= 0 ? this.mRatingCount : 5;
            this.mEmptyDrawable = typedArray.getDrawable(R.styleable.WidgetReviewRatingBar_emptyDrawable);
            this.mEmptyDrawable = this.mEmptyDrawable == null ? context.getResources().getDrawable(com.bilibili.app.comm.baseres.R.drawable.ic_empty_star) : this.mEmptyDrawable;
            this.mFilledDrawable = typedArray.getDrawable(R.styleable.WidgetReviewRatingBar_filledDrawable);
            this.mFilledDrawable = this.mFilledDrawable == null ? context.getResources().getDrawable(com.bilibili.app.comm.baseres.R.drawable.ic_filled_star) : this.mFilledDrawable;
            this.mRatingPadding = typedArray.getDimensionPixelOffset(R.styleable.WidgetReviewRatingBar_ratingPadding, (int) TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics()));
            this.isTouchable = typedArray.getBoolean(R.styleable.WidgetReviewRatingBar_touchable, false);
            this.mScoreSeg = typedArray.getInt(R.styleable.WidgetReviewRatingBar_scoreSeg, 2);
            this.mEmptyTint = typedArray.getResourceId(R.styleable.WidgetReviewRatingBar_emptyTint, R.color.daynight_color_image_tint_gray);
            this.mFilledTint = typedArray.getResourceId(R.styleable.WidgetReviewRatingBar_filledTint, com.bilibili.app.comm.baseres.R.color.daynight_color_charge_dark);
            this.mSize = typedArray.getDimensionPixelOffset(R.styleable.WidgetReviewRatingBar_ratingSize, (int) TypedValue.applyDimension(1, 36.0f, context.getResources().getDisplayMetrics()));
            this.mFillMode = typedArray.getInt(R.styleable.WidgetReviewRatingBar_fillModeWidge, 2);
            typedArray.recycle();
            addRatingView(context);
        } catch (Throwable th) {
            typedArray.recycle();
            throw th;
        }
    }

    public void updateRatingCount(int ratingCount) {
        if (ratingCount > 0 && this.mRatingCount != ratingCount) {
            this.mRatingCount = ratingCount;
            removeAllViews();
            addRatingView(getContext());
        }
    }

    private void addRatingView(Context context) {
        this.mRatingViews.clear();
        for (int i = 0; i < this.mRatingCount; i++) {
            RatingView partialView = new RatingView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i == 0) {
                layoutParams.setMargins(0, 0, this.mRatingPadding / 2, 0);
            } else if (i == this.mRatingCount - 1) {
                layoutParams.setMargins(this.mRatingPadding / 2, 0, 0, 0);
            } else {
                layoutParams.setMargins(this.mRatingPadding / 2, 0, this.mRatingPadding / 2, 0);
            }
            partialView.setLayoutParams(layoutParams);
            partialView.setFilledDrawable(this.mFilledDrawable, this.mFilledTint);
            partialView.setEmptyDrawable(this.mEmptyDrawable, this.mEmptyTint);
            partialView.setSize(this.mSize);
            this.mRatingViews.add(partialView);
            addView(partialView);
        }
    }

    protected void fillRatingBar(float rating, boolean withAnim) {
        int delay = 0;
        float star = Math.round(rating) / this.mScoreSeg;
        int indexOfFill = (int) star;
        float f = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        if (star % 1.0f > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            f = 0.5f;
        }
        final float percentage = f;
        for (int i = 0; i < this.mRatingViews.size(); i++) {
            final RatingView partialView = this.mRatingViews.get(i);
            final int finalI = i;
            if (i == indexOfFill) {
                if (withAnim) {
                    Runnable runnable = new Runnable() { // from class: tv.danmaku.bili.widget.ratingbar.ReviewRatingBar$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ReviewRatingBar.this.m2116lambda$fillRatingBar$0$tvdanmakubiliwidgetratingbarReviewRatingBar(partialView, percentage, finalI);
                        }
                    };
                    delay += 10;
                    getHandler().postDelayed(runnable, delay);
                    this.mAnimRunnables.add(runnable);
                } else {
                    partialView.setPartialFilled(percentage);
                }
            } else if (i > indexOfFill) {
                if (withAnim) {
                    Runnable runnable2 = new Runnable() { // from class: tv.danmaku.bili.widget.ratingbar.ReviewRatingBar$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ReviewRatingBar.this.m2117lambda$fillRatingBar$1$tvdanmakubiliwidgetratingbarReviewRatingBar(partialView);
                        }
                    };
                    delay += 10;
                    getHandler().postDelayed(runnable2, delay);
                    this.mAnimRunnables.add(runnable2);
                } else {
                    partialView.setEmpty();
                }
            } else if (withAnim) {
                Runnable runnable3 = new Runnable() { // from class: tv.danmaku.bili.widget.ratingbar.ReviewRatingBar$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReviewRatingBar.this.m2118lambda$fillRatingBar$2$tvdanmakubiliwidgetratingbarReviewRatingBar(partialView, finalI);
                    }
                };
                delay += 10;
                getHandler().postDelayed(runnable3, delay);
                this.mAnimRunnables.add(runnable3);
            } else {
                partialView.setFilled();
            }
        }
        if (this.mOnRatingChangeListener != null) {
            this.mOnRatingChangeListener.onRatingChange(indexOfFill, rating, this.mLastCallbackIndex);
            this.mLastCallbackIndex = indexOfFill;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$fillRatingBar$0$tv-danmaku-bili-widget-ratingbar-ReviewRatingBar  reason: not valid java name */
    public /* synthetic */ void m2116lambda$fillRatingBar$0$tvdanmakubiliwidgetratingbarReviewRatingBar(RatingView partialView, float percentage, int finalI) {
        partialView.setPartialFilled(percentage);
        if (percentage > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && finalI > this.mLastIndex) {
            Animation scaleUp = AnimationUtils.loadAnimation(getContext(), R.anim.rating_scale_up);
            Animation scaleDown = AnimationUtils.loadAnimation(getContext(), R.anim.rating_scale_down);
            partialView.startAnimation(scaleUp);
            partialView.startAnimation(scaleDown);
        }
        this.mAnimRunnables.remove(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$fillRatingBar$1$tv-danmaku-bili-widget-ratingbar-ReviewRatingBar  reason: not valid java name */
    public /* synthetic */ void m2117lambda$fillRatingBar$1$tvdanmakubiliwidgetratingbarReviewRatingBar(RatingView partialView) {
        partialView.setEmpty();
        this.mAnimRunnables.remove(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$fillRatingBar$2$tv-danmaku-bili-widget-ratingbar-ReviewRatingBar  reason: not valid java name */
    public /* synthetic */ void m2118lambda$fillRatingBar$2$tvdanmakubiliwidgetratingbarReviewRatingBar(RatingView partialView, int finalI) {
        partialView.setFilled();
        if (finalI >= this.mLastIndex) {
            Animation scaleUp = AnimationUtils.loadAnimation(getContext(), R.anim.rating_scale_up);
            Animation scaleDown = AnimationUtils.loadAnimation(getContext(), R.anim.rating_scale_down);
            partialView.startAnimation(scaleUp);
            partialView.startAnimation(scaleDown);
        }
        this.mAnimRunnables.remove(this);
    }

    public void fillStar(float param) {
        setRating(this.mScoreSeg * param);
    }

    public void setRating(float rating) {
        setRating(rating, false);
    }

    private void setRating(final float rating, final boolean withAnim) {
        if (!ViewCompat.isAttachedToWindow(this)) {
            this.mAppendRunnable = new Runnable() { // from class: tv.danmaku.bili.widget.ratingbar.ReviewRatingBar.1
                @Override // java.lang.Runnable
                public void run() {
                    ReviewRatingBar.this.mLastIndex = (int) Math.ceil(ReviewRatingBar.this.mRating / ReviewRatingBar.this.mScoreSeg);
                    ReviewRatingBar reviewRatingBar = ReviewRatingBar.this;
                    float f = rating;
                    float f2 = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                    if (f > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                        f2 = rating;
                    }
                    reviewRatingBar.mRating = f2;
                    ReviewRatingBar.this.fillRatingBar(ReviewRatingBar.this.mRating, withAnim);
                }
            };
            return;
        }
        this.mLastIndex = (int) Math.ceil(this.mRating / this.mScoreSeg);
        float f = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        if (rating > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            f = rating;
        }
        this.mRating = f;
        this.mLastCallbackIndex = -1;
        fillRatingBar(this.mRating, withAnim);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mAppendRunnable != null) {
            this.mAppendRunnable.run();
            this.mAppendRunnable = null;
        }
    }

    public void setOnRatingChangeListener(OnRatingChangeListener onRatingChangeListener) {
        this.mOnRatingChangeListener = onRatingChangeListener;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.isTouchable || super.onInterceptTouchEvent(ev);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        switch (event.getAction()) {
            case 0:
                this.mLastCallbackIndex = -1;
                requestFocus();
                if (this.mMode == 0) {
                    requestFocusFromTouch();
                    handleMoveEvent(eventX);
                    break;
                } else {
                    this.mLastEventX = eventX;
                    break;
                }
            case 1:
            case 3:
                if (this.mMode == 1) {
                    handleMoveEvent(this.mLastEventX);
                    this.mLastEventX = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                }
                return true;
            case 2:
                if (this.mMode == 0) {
                    handleMoveEvent(eventX);
                    break;
                }
                break;
        }
        return true;
    }

    private void handleMoveEvent(float eventX) {
        if (!this.isTouchable) {
            return;
        }
        if (this.mOnRatingChangeListener != null && !this.mOnRatingChangeListener.usable()) {
            this.mOnRatingChangeListener.notifyDisable();
            return;
        }
        float score = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        for (int i = 0; i < this.mRatingViews.size(); i++) {
            RatingView ratingView = this.mRatingViews.get(i);
            if (this.mFillMode == 2) {
                if (eventX > ratingView.getLeft()) {
                    score += this.mScoreSeg;
                }
            } else if (this.mFillMode == 1) {
                if (eventX > ratingView.getLeft() + (ratingView.getWidth() / 2)) {
                    score += this.mScoreSeg;
                } else if (eventX > ratingView.getLeft()) {
                    score += this.mScoreSeg / 2;
                }
            }
        }
        int i2 = this.mFillMode;
        if (i2 == 2) {
            score = score == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? this.mScoreSeg : score;
        } else if (this.mFillMode == 1) {
            score = score == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? this.mScoreSeg / 2 : score;
        }
        if (this.mRating != score || this.mLastCallbackIndex < 0) {
            setRating(score, true);
        }
    }

    private void clearAnim() {
        while (this.mAnimRunnables.size() > 0) {
            getHandler().removeCallbacks(this.mAnimRunnables.remove(0));
        }
        for (int i = 0; i < this.mRatingViews.size(); i++) {
            RatingView partialView = this.mRatingViews.get(i);
            if (partialView.getAnimation() != null) {
                partialView.clearAnimation();
            }
        }
    }

    public void setRatingForce(float rating) {
        clearAnim();
        setRating(rating, false);
    }

    public void setMode(int mode) {
        this.mMode = mode;
    }

    public void setTouchable(boolean enable) {
        this.isTouchable = enable;
    }

    public boolean isTouchable() {
        return this.isTouchable;
    }

    public float getRating() {
        return this.mRating;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnRatingChangeListener {
        void notifyDisable();

        void onRatingChange(int i, float f, int i2);

        boolean usable();

        /* renamed from: tv.danmaku.bili.widget.ratingbar.ReviewRatingBar$OnRatingChangeListener$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
            public static boolean $default$usable(OnRatingChangeListener _this) {
                return true;
            }

            public static void $default$notifyDisable(OnRatingChangeListener _this) {
            }
        }
    }
}