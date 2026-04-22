package tv.danmaku.bili.widget.avatar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.Tintable;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

public class LivingAvatarAnimationView extends View implements Tintable {
    private static final float BEGIN_ALPHA = 0.6f;
    private ValueAnimator.AnimatorUpdateListener alphaUpdateListener;
    private Runnable animationRunnable;
    private Animator.AnimatorListener animatorListener;
    private boolean isRepeat;
    private int mAlpha;
    private AnimatorSet mAnimation;
    private int mBeginRadius;
    private int mCustomPaintColor;
    private int mCx;
    private int mCy;
    private int mEndRadius;
    private Paint mPaint;
    private int mRadius;
    private int mStrokeWidth;
    private OnAnimationStartListener onAnimationStartListener;
    private ValueAnimator.AnimatorUpdateListener strokeUpdateListener;
    private ValueAnimator.AnimatorUpdateListener widthUpdateListener;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnAnimationStartListener {
        void onStart();
    }

    public void update(int strokeWidth, int beginRadius, int endRadius) {
        this.mStrokeWidth = strokeWidth;
        this.mBeginRadius = beginRadius;
        this.mEndRadius = endRadius;
    }

    public void tint() {
        if (this.mCustomPaintColor != 0) {
            this.mPaint.setColor(this.mCustomPaintColor);
        } else {
            this.mPaint.setColor(ThemeUtils.getColorById(getContext(), R.color.daynight_color_theme_pink));
        }
    }

    public LivingAvatarAnimationView(Context context) {
        super(context);
        this.mAlpha = 153;
        this.mStrokeWidth = 0;
        this.mBeginRadius = 0;
        this.mEndRadius = 0;
        this.mCustomPaintColor = 0;
        this.animationRunnable = new Runnable() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                LivingAvatarAnimationView.this.reset();
                LivingAvatarAnimationView.this.invalidate();
                ValueAnimator widthAnimator = ValueAnimator.ofInt(LivingAvatarAnimationView.this.mRadius, LivingAvatarAnimationView.this.mEndRadius);
                widthAnimator.addUpdateListener(LivingAvatarAnimationView.this.widthUpdateListener);
                ValueAnimator alphaAnimator = ValueAnimator.ofFloat(LivingAvatarAnimationView.BEGIN_ALPHA, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                alphaAnimator.addUpdateListener(LivingAvatarAnimationView.this.alphaUpdateListener);
                ValueAnimator strokeAnimator = ValueAnimator.ofFloat(LivingAvatarAnimationView.this.mStrokeWidth, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                strokeAnimator.addUpdateListener(LivingAvatarAnimationView.this.strokeUpdateListener);
                LivingAvatarAnimationView.this.mAnimation = new AnimatorSet();
                LivingAvatarAnimationView.this.mAnimation.playTogether(widthAnimator, alphaAnimator, strokeAnimator);
                LivingAvatarAnimationView.this.mAnimation.setDuration(1000L);
                LivingAvatarAnimationView.this.mAnimation.addListener(LivingAvatarAnimationView.this.animatorListener);
                LivingAvatarAnimationView.this.mAnimation.setInterpolator(new LinearInterpolator());
                LivingAvatarAnimationView.this.mAnimation.start();
            }
        };
        this.animatorListener = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                if (LivingAvatarAnimationView.this.onAnimationStartListener != null) {
                    LivingAvatarAnimationView.this.onAnimationStartListener.onStart();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (LivingAvatarAnimationView.this.isRepeat) {
                    LivingAvatarAnimationView.this.postDelayed(LivingAvatarAnimationView.this.animationRunnable, PlayerToastConfig.DURATION_3);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        };
        this.widthUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                LivingAvatarAnimationView.this.mRadius = ((Integer) animation.getAnimatedValue()).intValue();
            }
        };
        this.alphaUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                int alpha = (int) (((Float) animation.getAnimatedValue()).floatValue() * 255.0f);
                LivingAvatarAnimationView.this.mPaint.setAlpha(alpha);
            }
        };
        this.strokeUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                LivingAvatarAnimationView.this.mPaint.setStrokeWidth(((Float) animation.getAnimatedValue()).floatValue());
                LivingAvatarAnimationView.this.invalidate();
            }
        };
        init(context);
    }

    public LivingAvatarAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mAlpha = 153;
        this.mStrokeWidth = 0;
        this.mBeginRadius = 0;
        this.mEndRadius = 0;
        this.mCustomPaintColor = 0;
        this.animationRunnable = new Runnable() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                LivingAvatarAnimationView.this.reset();
                LivingAvatarAnimationView.this.invalidate();
                ValueAnimator widthAnimator = ValueAnimator.ofInt(LivingAvatarAnimationView.this.mRadius, LivingAvatarAnimationView.this.mEndRadius);
                widthAnimator.addUpdateListener(LivingAvatarAnimationView.this.widthUpdateListener);
                ValueAnimator alphaAnimator = ValueAnimator.ofFloat(LivingAvatarAnimationView.BEGIN_ALPHA, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                alphaAnimator.addUpdateListener(LivingAvatarAnimationView.this.alphaUpdateListener);
                ValueAnimator strokeAnimator = ValueAnimator.ofFloat(LivingAvatarAnimationView.this.mStrokeWidth, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                strokeAnimator.addUpdateListener(LivingAvatarAnimationView.this.strokeUpdateListener);
                LivingAvatarAnimationView.this.mAnimation = new AnimatorSet();
                LivingAvatarAnimationView.this.mAnimation.playTogether(widthAnimator, alphaAnimator, strokeAnimator);
                LivingAvatarAnimationView.this.mAnimation.setDuration(1000L);
                LivingAvatarAnimationView.this.mAnimation.addListener(LivingAvatarAnimationView.this.animatorListener);
                LivingAvatarAnimationView.this.mAnimation.setInterpolator(new LinearInterpolator());
                LivingAvatarAnimationView.this.mAnimation.start();
            }
        };
        this.animatorListener = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                if (LivingAvatarAnimationView.this.onAnimationStartListener != null) {
                    LivingAvatarAnimationView.this.onAnimationStartListener.onStart();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (LivingAvatarAnimationView.this.isRepeat) {
                    LivingAvatarAnimationView.this.postDelayed(LivingAvatarAnimationView.this.animationRunnable, PlayerToastConfig.DURATION_3);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        };
        this.widthUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                LivingAvatarAnimationView.this.mRadius = ((Integer) animation.getAnimatedValue()).intValue();
            }
        };
        this.alphaUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                int alpha = (int) (((Float) animation.getAnimatedValue()).floatValue() * 255.0f);
                LivingAvatarAnimationView.this.mPaint.setAlpha(alpha);
            }
        };
        this.strokeUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                LivingAvatarAnimationView.this.mPaint.setStrokeWidth(((Float) animation.getAnimatedValue()).floatValue());
                LivingAvatarAnimationView.this.invalidate();
            }
        };
        init(context);
    }

    public LivingAvatarAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mAlpha = 153;
        this.mStrokeWidth = 0;
        this.mBeginRadius = 0;
        this.mEndRadius = 0;
        this.mCustomPaintColor = 0;
        this.animationRunnable = new Runnable() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                LivingAvatarAnimationView.this.reset();
                LivingAvatarAnimationView.this.invalidate();
                ValueAnimator widthAnimator = ValueAnimator.ofInt(LivingAvatarAnimationView.this.mRadius, LivingAvatarAnimationView.this.mEndRadius);
                widthAnimator.addUpdateListener(LivingAvatarAnimationView.this.widthUpdateListener);
                ValueAnimator alphaAnimator = ValueAnimator.ofFloat(LivingAvatarAnimationView.BEGIN_ALPHA, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                alphaAnimator.addUpdateListener(LivingAvatarAnimationView.this.alphaUpdateListener);
                ValueAnimator strokeAnimator = ValueAnimator.ofFloat(LivingAvatarAnimationView.this.mStrokeWidth, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                strokeAnimator.addUpdateListener(LivingAvatarAnimationView.this.strokeUpdateListener);
                LivingAvatarAnimationView.this.mAnimation = new AnimatorSet();
                LivingAvatarAnimationView.this.mAnimation.playTogether(widthAnimator, alphaAnimator, strokeAnimator);
                LivingAvatarAnimationView.this.mAnimation.setDuration(1000L);
                LivingAvatarAnimationView.this.mAnimation.addListener(LivingAvatarAnimationView.this.animatorListener);
                LivingAvatarAnimationView.this.mAnimation.setInterpolator(new LinearInterpolator());
                LivingAvatarAnimationView.this.mAnimation.start();
            }
        };
        this.animatorListener = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                if (LivingAvatarAnimationView.this.onAnimationStartListener != null) {
                    LivingAvatarAnimationView.this.onAnimationStartListener.onStart();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (LivingAvatarAnimationView.this.isRepeat) {
                    LivingAvatarAnimationView.this.postDelayed(LivingAvatarAnimationView.this.animationRunnable, PlayerToastConfig.DURATION_3);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        };
        this.widthUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                LivingAvatarAnimationView.this.mRadius = ((Integer) animation.getAnimatedValue()).intValue();
            }
        };
        this.alphaUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                int alpha = (int) (((Float) animation.getAnimatedValue()).floatValue() * 255.0f);
                LivingAvatarAnimationView.this.mPaint.setAlpha(alpha);
            }
        };
        this.strokeUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                LivingAvatarAnimationView.this.mPaint.setStrokeWidth(((Float) animation.getAnimatedValue()).floatValue());
                LivingAvatarAnimationView.this.invalidate();
            }
        };
        init(context);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.mCx, this.mCy, this.mRadius, this.mPaint);
    }

    public void setRepeat(boolean repeat) {
        this.isRepeat = repeat;
    }

    public void setOnAnimationStartListener(OnAnimationStartListener onAnimationStartListener) {
        this.onAnimationStartListener = onAnimationStartListener;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mCx = w / 2;
        this.mCy = h / 2;
    }

    public void startAnimation() {
        if (this.mAnimation != null && this.mAnimation.isRunning()) {
            return;
        }
        removeCallbacks(this.animationRunnable);
        post(this.animationRunnable);
    }

    public void startAnimation(long delay) {
        if (this.mAnimation != null && this.mAnimation.isRunning()) {
            return;
        }
        removeCallbacks(this.animationRunnable);
        postDelayed(this.animationRunnable, delay);
    }

    public void stopAnimation() {
        if (this.mAnimation != null) {
            this.mAnimation.cancel();
        }
        removeCallbacks(this.animationRunnable);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.mRadius = this.mBeginRadius;
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint.setAlpha(this.mAlpha);
    }

    private void init(Context context) {
        this.mPaint = new Paint();
        this.mPaint.setColor(ThemeUtils.getColorById(getContext(), R.color.daynight_color_theme_pink));
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPaint.setAlpha(this.mAlpha);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
    }

    public void setCustomPaintColor(int customPaintColor) {
        this.mCustomPaintColor = customPaintColor;
        this.mPaint.setColor(customPaintColor);
    }
}