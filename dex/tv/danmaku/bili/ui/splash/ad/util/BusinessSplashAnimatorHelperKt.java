package tv.danmaku.bili.ui.splash.ad.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.utils.animator.BezierInterpolator;
import tv.danmaku.bili.ui.splash.widget.SplashImageView;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BusinessSplashAnimatorHelper.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n\u001a2\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n\u001a&\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n\u001a2\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n\u001a,\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u001e\u0010\u0012\u001a\u00020\u0013*\u00020\b2\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\u001c\u0010\u0016\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¨\u0006\u001b"}, d2 = {"doBusinessSplashSearchBarLinkageAnimation", "", "transformView", "Landroid/widget/ImageView;", "rect", "Landroid/graphics/Rect;", "alphaViews", "", "Landroid/view/View;", "listener", "Landroid/animation/Animator$AnimatorListener;", "doTopViewScaleAnimation", "targetRect", "doKeepRadioScaleAnimate", "containerView", "bannerRect", "doTvCloseSplashAnimate", "doBgDisappearAnimation", "toLinkageRectParam", "Ltv/danmaku/bili/ui/splash/ad/util/LinkageRectParam;", "radius", "", "transform", "Landroid/view/ViewGroup$MarginLayoutParams;", "displayParam", "v", "", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BusinessSplashAnimatorHelperKt {
    public static final void doBusinessSplashSearchBarLinkageAnimation(final ImageView transformView, Rect rect, List<? extends View> list, Animator.AnimatorListener listener) {
        Iterable filterNotNull;
        List alphaViews = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(transformView, "transformView");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final LinkageRectParam displayParam = toLinkageRectParam(transformView, rect, rect.height() / 2);
        if (alphaViews != null && (filterNotNull = CollectionsKt.filterNotNull(alphaViews)) != null) {
            Iterable $this$forEach$iv = filterNotNull;
            for (Object element$iv : $this$forEach$iv) {
                View it = (View) element$iv;
                it.setAlpha(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            }
        }
        ValueAnimator alphaAni = ValueAnimator.ofFloat(1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        alphaAni.setDuration(625L);
        alphaAni.setStartDelay(625L);
        alphaAni.setInterpolator(new BezierInterpolator(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0.58f, 1.0f));
        alphaAni.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.splash.ad.util.BusinessSplashAnimatorHelperKt$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BusinessSplashAnimatorHelperKt.doBusinessSplashSearchBarLinkageAnimation$lambda$1$0(transformView, valueAnimator);
            }
        });
        ValueAnimator cornerAni = ValueAnimator.ofFloat(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        cornerAni.setDuration(750L);
        cornerAni.setInterpolator(new BezierInterpolator(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0.58f, 1.0f));
        cornerAni.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.splash.ad.util.BusinessSplashAnimatorHelperKt$$ExternalSyntheticLambda5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BusinessSplashAnimatorHelperKt.doBusinessSplashSearchBarLinkageAnimation$lambda$2$0(transformView, displayParam, valueAnimator);
            }
        });
        ValueAnimator $this$doBusinessSplashSearchBarLinkageAnimation_u24lambda_u243 = ValueAnimator.ofFloat(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        $this$doBusinessSplashSearchBarLinkageAnimation_u24lambda_u243.setDuration(750L);
        $this$doBusinessSplashSearchBarLinkageAnimation_u24lambda_u243.setInterpolator(new BezierInterpolator(0.4f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0.74f, 1.0f));
        $this$doBusinessSplashSearchBarLinkageAnimation_u24lambda_u243.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.splash.ad.util.BusinessSplashAnimatorHelperKt$$ExternalSyntheticLambda6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BusinessSplashAnimatorHelperKt.doBusinessSplashSearchBarLinkageAnimation$lambda$3$0(transformView, displayParam, valueAnimator);
            }
        });
        AnimatorSet $this$doBusinessSplashSearchBarLinkageAnimation_u24lambda_u244 = new AnimatorSet();
        $this$doBusinessSplashSearchBarLinkageAnimation_u24lambda_u244.playTogether(alphaAni, cornerAni, $this$doBusinessSplashSearchBarLinkageAnimation_u24lambda_u243);
        $this$doBusinessSplashSearchBarLinkageAnimation_u24lambda_u244.addListener(listener);
        $this$doBusinessSplashSearchBarLinkageAnimation_u24lambda_u244.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doBusinessSplashSearchBarLinkageAnimation$lambda$1$0(ImageView $transformView, ValueAnimator ani) {
        Intrinsics.checkNotNullParameter(ani, "ani");
        Object animatedValue = ani.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float v = ((Float) animatedValue).floatValue();
        $transformView.setAlpha(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doBusinessSplashSearchBarLinkageAnimation$lambda$2$0(ImageView $transformView, LinkageRectParam $displayParam, ValueAnimator ani) {
        Intrinsics.checkNotNullParameter(ani, "ani");
        Object animatedValue = ani.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float v = ((Float) animatedValue).floatValue();
        SplashImageView splashImageView = $transformView instanceof SplashImageView ? (SplashImageView) $transformView : null;
        if (splashImageView != null) {
            splashImageView.setRadius($displayParam.getTargetRadius() * v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doBusinessSplashSearchBarLinkageAnimation$lambda$3$0(ImageView $transformView, LinkageRectParam $displayParam, ValueAnimator ani) {
        Intrinsics.checkNotNullParameter(ani, "ani");
        Object animatedValue = ani.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float v = ((Float) animatedValue).floatValue();
        ViewGroup.LayoutParams layoutParams = $transformView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams lp = transform((ViewGroup.MarginLayoutParams) layoutParams, $displayParam, v);
        $transformView.setLayoutParams(lp);
    }

    public static /* synthetic */ void doTopViewScaleAnimation$default(ImageView imageView, Rect rect, List list, Animator.AnimatorListener animatorListener, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        doTopViewScaleAnimation(imageView, rect, list, animatorListener);
    }

    public static final void doTopViewScaleAnimation(final ImageView transformView, Rect targetRect, List<? extends View> list, Animator.AnimatorListener listener) {
        final List alphaViews = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(transformView, "transformView");
        Intrinsics.checkNotNullParameter(targetRect, "targetRect");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final LinkageRectParam displayParam = toLinkageRectParam$default(transformView, targetRect, 0, 2, null);
        SplashImageView splashImageView = transformView instanceof SplashImageView ? (SplashImageView) transformView : null;
        if (splashImageView != null) {
            splashImageView.setRadius(ListExtentionsKt.toPx(4));
        }
        transformView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ValueAnimator scaleAnimator = ValueAnimator.ofFloat(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        scaleAnimator.setDuration(500L);
        scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.splash.ad.util.BusinessSplashAnimatorHelperKt$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BusinessSplashAnimatorHelperKt.doTopViewScaleAnimation$lambda$0$0(transformView, displayParam, valueAnimator);
            }
        });
        ValueAnimator alphaAnimator = ObjectAnimator.ofFloat(1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        alphaAnimator.setDuration(500L);
        alphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.splash.ad.util.BusinessSplashAnimatorHelperKt$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BusinessSplashAnimatorHelperKt.doTopViewScaleAnimation$lambda$1$0(alphaViews, valueAnimator);
            }
        });
        ObjectAnimator $this$doTopViewScaleAnimation_u24lambda_u242 = ObjectAnimator.ofFloat(transformView, View.ALPHA, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        $this$doTopViewScaleAnimation_u24lambda_u242.setDuration(500L);
        $this$doTopViewScaleAnimation_u24lambda_u242.setStartDelay(250L);
        Intrinsics.checkNotNullExpressionValue($this$doTopViewScaleAnimation_u24lambda_u242, "apply(...)");
        ObjectAnimator transformViewAlpha = $this$doTopViewScaleAnimation_u24lambda_u242;
        AnimatorSet $this$doTopViewScaleAnimation_u24lambda_u243 = new AnimatorSet();
        $this$doTopViewScaleAnimation_u24lambda_u243.setStartDelay(250L);
        $this$doTopViewScaleAnimation_u24lambda_u243.setInterpolator(new DecelerateInterpolator());
        $this$doTopViewScaleAnimation_u24lambda_u243.playTogether(scaleAnimator, alphaAnimator, transformViewAlpha);
        $this$doTopViewScaleAnimation_u24lambda_u243.addListener(listener);
        $this$doTopViewScaleAnimation_u24lambda_u243.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doTopViewScaleAnimation$lambda$0$0(ImageView $transformView, LinkageRectParam $displayParam, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float v = ((Float) animatedValue).floatValue();
        ViewGroup.LayoutParams layoutParams = $transformView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams lp = transform((ViewGroup.MarginLayoutParams) layoutParams, $displayParam, v);
        $transformView.setLayoutParams(lp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doTopViewScaleAnimation$lambda$1$0(List $alphaViews, ValueAnimator animation) {
        Iterable filterNotNull;
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float alpha = ((Float) animatedValue).floatValue();
        if ($alphaViews == null || (filterNotNull = CollectionsKt.filterNotNull($alphaViews)) == null) {
            return;
        }
        Iterable $this$forEach$iv = filterNotNull;
        for (Object element$iv : $this$forEach$iv) {
            View it = (View) element$iv;
            it.setAlpha(alpha);
        }
    }

    public static final void doKeepRadioScaleAnimate(final View containerView, final View transformView, Rect bannerRect, Animator.AnimatorListener listener) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(transformView, "transformView");
        Intrinsics.checkNotNullParameter(bannerRect, "bannerRect");
        Intrinsics.checkNotNullParameter(listener, "listener");
        int startWidth = transformView.getWidth();
        int startHeight = transformView.getHeight();
        float radio = startWidth / startHeight;
        int targetHeight = bannerRect.height();
        float targetWidth = targetHeight * radio;
        float targetLeftMargin = bannerRect.centerX() - (targetWidth / 2);
        Rect targetRect = new Rect((int) targetLeftMargin, bannerRect.top, (int) (containerView.getWidth() - targetLeftMargin), bannerRect.bottom);
        final LinkageRectParam displayParam = toLinkageRectParam$default(transformView, targetRect, 0, 2, null);
        ValueAnimator $this$doKeepRadioScaleAnimate_u24lambda_u240 = ValueAnimator.ofFloat(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        $this$doKeepRadioScaleAnimate_u24lambda_u240.setInterpolator(new BezierInterpolator(0.42f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0.58f, 1.0f));
        $this$doKeepRadioScaleAnimate_u24lambda_u240.setDuration(500L);
        $this$doKeepRadioScaleAnimate_u24lambda_u240.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.splash.ad.util.BusinessSplashAnimatorHelperKt$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BusinessSplashAnimatorHelperKt.doKeepRadioScaleAnimate$lambda$0$0(transformView, displayParam, valueAnimator);
            }
        });
        ValueAnimator alphaAnimator = ValueAnimator.ofFloat(1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        alphaAnimator.setInterpolator(new LinearInterpolator());
        alphaAnimator.setDuration(250L);
        alphaAnimator.setStartDelay(250L);
        alphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.splash.ad.util.BusinessSplashAnimatorHelperKt$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BusinessSplashAnimatorHelperKt.doKeepRadioScaleAnimate$lambda$1$0(containerView, valueAnimator);
            }
        });
        AnimatorSet $this$doKeepRadioScaleAnimate_u24lambda_u242 = new AnimatorSet();
        $this$doKeepRadioScaleAnimate_u24lambda_u242.playTogether($this$doKeepRadioScaleAnimate_u24lambda_u240, alphaAnimator);
        $this$doKeepRadioScaleAnimate_u24lambda_u242.addListener(listener);
        $this$doKeepRadioScaleAnimate_u24lambda_u242.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doKeepRadioScaleAnimate$lambda$0$0(View $transformView, LinkageRectParam $displayParam, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float v = ((Float) animatedValue).floatValue();
        ViewGroup.LayoutParams layoutParams = $transformView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams lp = transform((ViewGroup.MarginLayoutParams) layoutParams, $displayParam, v);
        $transformView.setLayoutParams(lp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doKeepRadioScaleAnimate$lambda$1$0(View $containerView, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        $containerView.setAlpha(((Float) animatedValue).floatValue());
    }

    public static /* synthetic */ void doTvCloseSplashAnimate$default(View view2, Rect rect, List list, Animator.AnimatorListener animatorListener, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        doTvCloseSplashAnimate(view2, rect, list, animatorListener);
    }

    public static final void doTvCloseSplashAnimate(final View transformView, Rect targetRect, List<? extends View> list, Animator.AnimatorListener listener) {
        Iterable alphaViews = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(transformView, "transformView");
        Intrinsics.checkNotNullParameter(targetRect, "targetRect");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (alphaViews != null) {
            Iterable $this$forEach$iv = alphaViews;
            for (Object element$iv : $this$forEach$iv) {
                View it = (View) element$iv;
                if (it != null) {
                    it.setAlpha(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                }
            }
        }
        Rect centerLineRect = new Rect(targetRect.left, targetRect.top + (targetRect.height() / 2), targetRect.right, targetRect.bottom - (targetRect.height() / 2));
        final LinkageRectParam displayParam = toLinkageRectParam$default(transformView, centerLineRect, 0, 2, null);
        ValueAnimator scaleAnimator = ValueAnimator.ofFloat(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        scaleAnimator.setDuration(650L);
        scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.splash.ad.util.BusinessSplashAnimatorHelperKt$$ExternalSyntheticLambda7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BusinessSplashAnimatorHelperKt.doTvCloseSplashAnimate$lambda$1$0(transformView, displayParam, valueAnimator);
            }
        });
        ValueAnimator transformMaskColor = ValueAnimator.ofInt(0, 255);
        transformMaskColor.setDuration(150L);
        transformMaskColor.setStartDelay(500L);
        transformMaskColor.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.splash.ad.util.BusinessSplashAnimatorHelperKt$$ExternalSyntheticLambda8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BusinessSplashAnimatorHelperKt.doTvCloseSplashAnimate$lambda$2$0(transformView, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(transformMaskColor, "apply(...)");
        AnimatorSet $this$doTvCloseSplashAnimate_u24lambda_u243 = new AnimatorSet();
        $this$doTvCloseSplashAnimate_u24lambda_u243.setStartDelay(0L);
        $this$doTvCloseSplashAnimate_u24lambda_u243.setInterpolator(new DecelerateInterpolator());
        $this$doTvCloseSplashAnimate_u24lambda_u243.playTogether(scaleAnimator, transformMaskColor);
        $this$doTvCloseSplashAnimate_u24lambda_u243.addListener(listener);
        $this$doTvCloseSplashAnimate_u24lambda_u243.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doTvCloseSplashAnimate$lambda$1$0(View $transformView, LinkageRectParam $displayParam, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float v = ((Float) animatedValue).floatValue();
        ViewGroup.LayoutParams layoutParams = $transformView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams lp = transform((ViewGroup.MarginLayoutParams) layoutParams, $displayParam, v);
        $transformView.setLayoutParams(lp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doTvCloseSplashAnimate$lambda$2$0(View $transformView, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int alpha = ((Integer) animatedValue).intValue();
        ImageView imageView = $transformView instanceof ImageView ? (ImageView) $transformView : null;
        if (imageView != null) {
            imageView.setColorFilter(Color.argb(alpha, 255, 255, 255));
        }
    }

    public static /* synthetic */ void doBgDisappearAnimation$default(View view2, List list, Animator.AnimatorListener animatorListener, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        doBgDisappearAnimation(view2, list, animatorListener);
    }

    public static final void doBgDisappearAnimation(View transformView, List<? extends View> list, Animator.AnimatorListener listener) {
        Iterable alphaViews = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(transformView, "transformView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (alphaViews != null) {
            Iterable $this$forEach$iv = alphaViews;
            for (Object element$iv : $this$forEach$iv) {
                View it = (View) element$iv;
                if (it != null) {
                    it.setAlpha(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                }
            }
        }
        transformView.animate().alpha(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN).setDuration(500L).setListener(listener).start();
    }

    static /* synthetic */ LinkageRectParam toLinkageRectParam$default(View view2, Rect rect, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return toLinkageRectParam(view2, rect, i);
    }

    private static final LinkageRectParam toLinkageRectParam(View $this$toLinkageRectParam, Rect targetRect, int radius) {
        return new LinkageRectParam($this$toLinkageRectParam.getWidth(), $this$toLinkageRectParam.getHeight(), targetRect.width(), targetRect.height(), targetRect.left, $this$toLinkageRectParam.getWidth() - targetRect.right, targetRect.top, $this$toLinkageRectParam.getHeight() - targetRect.bottom, radius);
    }

    private static final ViewGroup.MarginLayoutParams transform(ViewGroup.MarginLayoutParams $this$transform, LinkageRectParam displayParam, float v) {
        $this$transform.width = displayParam.getOriginWidth() - ((int) ((displayParam.getOriginWidth() - displayParam.getTargetWidth()) * v));
        $this$transform.height = displayParam.getOriginHeight() - ((int) ((displayParam.getOriginHeight() - displayParam.getTargetHeight()) * v));
        $this$transform.leftMargin = (int) (displayParam.getTargetLeftMargin() * v);
        $this$transform.rightMargin = (int) (displayParam.getTargetRightMargin() * v);
        $this$transform.topMargin = (int) (displayParam.getTargetTopMargin() * v);
        $this$transform.bottomMargin = (int) (displayParam.getTargetBottomMargin() * v);
        return $this$transform;
    }
}