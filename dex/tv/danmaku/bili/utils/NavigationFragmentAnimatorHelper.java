package tv.danmaku.bili.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bilibili.lib.theme.R;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.magicasakura.utils.ThemeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NavigationFragmentAnimatorHelper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u000fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/utils/NavigationFragmentAnimatorHelper;", "", "<init>", "()V", "mBubbleView", "Landroid/widget/TextView;", "mFansIncBubbleAnimatorSet", "Landroid/animation/AnimatorSet;", "increaseFansForH5", "", "getIncreaseFansForH5", "()I", "setIncreaseFansForH5", "(I)V", "bindViews", "", "bubbleView", "startBubbleAnimator", "showTime", "", "cancelBubbleAnimator", "onResetIncreaseFans", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NavigationFragmentAnimatorHelper {
    public static final int $stable = 8;
    private int increaseFansForH5;
    private TextView mBubbleView;
    private AnimatorSet mFansIncBubbleAnimatorSet;

    public final int getIncreaseFansForH5() {
        return this.increaseFansForH5;
    }

    public final void setIncreaseFansForH5(int i) {
        this.increaseFansForH5 = i;
    }

    public final void bindViews(TextView bubbleView) {
        Intrinsics.checkNotNullParameter(bubbleView, "bubbleView");
        this.mBubbleView = bubbleView;
    }

    public final void startBubbleAnimator(long showTime) {
        int textColor;
        int backgroundColor;
        final TextView bubbleView = this.mBubbleView;
        if (bubbleView == null) {
            return;
        }
        Context context = bubbleView.getContext();
        Intrinsics.checkNotNull(context);
        Garb garb = GarbManager.getGarbWithNightMode(context);
        if (garb.isPure()) {
            if (garb.isWhite() || garb.isNight()) {
                textColor = ContextCompat.getColor(context, R.color.Wh0_u);
                backgroundColor = ContextCompat.getColor(context, R.color.Pi5);
            } else {
                textColor = ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_secondary);
                backgroundColor = ContextCompat.getColor(context, R.color.Wh0_u);
            }
        } else if (garb.isDarkMode()) {
            textColor = ContextCompat.getColor(context, R.color.Wh0_u);
            backgroundColor = ContextCompat.getColor(context, R.color.Pi5);
        } else {
            textColor = ContextCompat.getColor(context, R.color.Pi5);
            backgroundColor = ContextCompat.getColor(context, R.color.Wh0_u);
        }
        bubbleView.setTextColor(textColor);
        Drawable background = bubbleView.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        Drawable mutate = gradientDrawable.mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable1 = (GradientDrawable) mutate;
        gradientDrawable1.setColor(backgroundColor);
        bubbleView.setBackground(gradientDrawable1);
        this.mFansIncBubbleAnimatorSet = new AnimatorSet();
        ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f).setDuration(600L);
        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.utils.NavigationFragmentAnimatorHelper$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NavigationFragmentAnimatorHelper.startBubbleAnimator$lambda$0(bubbleView, valueAnimator);
            }
        });
        valueAnimator1.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.utils.NavigationFragmentAnimatorHelper$startBubbleAnimator$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationStart(animation);
                bubbleView.setVisibility(0);
            }
        });
        ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN).setDuration(600L);
        valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.utils.NavigationFragmentAnimatorHelper$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NavigationFragmentAnimatorHelper.startBubbleAnimator$lambda$1(bubbleView, valueAnimator);
            }
        });
        valueAnimator2.setStartDelay(showTime <= 0 ? 3800L : showTime);
        AnimatorSet animatorSet = this.mFansIncBubbleAnimatorSet;
        if (animatorSet != null) {
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.utils.NavigationFragmentAnimatorHelper$startBubbleAnimator$4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onAnimationEnd(animation);
                    bubbleView.setVisibility(4);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onAnimationCancel(animation);
                    bubbleView.setVisibility(4);
                }
            });
        }
        AnimatorSet animatorSet2 = this.mFansIncBubbleAnimatorSet;
        if (animatorSet2 != null) {
            animatorSet2.playSequentially(valueAnimator1, valueAnimator2);
        }
        AnimatorSet animatorSet3 = this.mFansIncBubbleAnimatorSet;
        if (animatorSet3 != null) {
            animatorSet3.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startBubbleAnimator$lambda$0(TextView $bubbleView, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float value = ((Float) animatedValue).floatValue();
        $bubbleView.setAlpha(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startBubbleAnimator$lambda$1(TextView $bubbleView, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float value = ((Float) animatedValue).floatValue();
        $bubbleView.setAlpha(value);
    }

    public final void cancelBubbleAnimator() {
        AnimatorSet animatorSet;
        AnimatorSet animatorSet2 = this.mFansIncBubbleAnimatorSet;
        boolean z = false;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            z = true;
        }
        if (!z || (animatorSet = this.mFansIncBubbleAnimatorSet) == null) {
            return;
        }
        animatorSet.cancel();
    }

    public final void onResetIncreaseFans() {
        this.increaseFansForH5 = 0;
    }
}