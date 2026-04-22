package tv.danmaku.bili.ui.login;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import tv.danmaku.bili.BR;

public class ToastAnimationHelper {
    private static final int DURATION = 667;
    private static final int STEP_1_TIME = 267;
    private static final int STEP_2_TIME = 500;
    private static final int STEP_3_TIME = 667;

    public static void animate(final View view) {
        view.postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.login.ToastAnimationHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ToastAnimationHelper.lambda$animate$1(view);
            }
        }, 250L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$animate$1(final View view) {
        ValueAnimator va = ValueAnimator.ofInt(0, BR.typeList);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.login.ToastAnimationHelper$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ToastAnimationHelper.lambda$animate$0(view, valueAnimator);
            }
        });
        va.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.login.ToastAnimationHelper.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                view.setScaleX(0.0f);
                view.setScaleY(0.0f);
                view.setAlpha(1.0f);
                view.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ToastAnimationHelper.hideSelf(view);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
        va.setDuration(667L);
        va.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$animate$0(View view, ValueAnimator animation) {
        float scale;
        int value = ((Integer) animation.getAnimatedValue()).intValue();
        if (value < 267) {
            scale = (float) ((value * 0.449d) / 100.0d);
        } else if (value < 500) {
            scale = (float) (((value * (-0.1287d)) + 154.3776d) / 100.0d);
        } else {
            scale = (float) (((value * 0.05988d) + 60.06d) / 100.0d);
        }
        view.setScaleX(scale);
        view.setScaleY(scale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hideSelf(final View view) {
        final Runnable runnable = new Runnable() { // from class: tv.danmaku.bili.ui.login.ToastAnimationHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ToastAnimationHelper.lambda$hideSelf$2(view);
            }
        };
        view.postDelayed(runnable, 1500L);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.ui.login.ToastAnimationHelper.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                view.removeCallbacks(runnable);
                view.removeOnAttachStateChangeListener(this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$hideSelf$2(View view) {
        ObjectAnimator oa = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        oa.setDuration(200L);
        oa.start();
    }
}