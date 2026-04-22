package tv.danmaku.bili.ui.main2.basic.story;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.app.comm.comment2.helper.EmotionAlignHelperKt;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.playerbizcommon.utils.BezierInterpolator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: HomeStoryEntranceAnimation.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a,\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a\u0018\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\b\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a\f\u0010\u001c\u001a\u00020\u0007*\u00020\u0003H\u0000\"!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\"!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0015\"\u000e\u0010\u001d\u001a\u00020\u001eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020 X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020 X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020 X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"showEntrance", "", "avatar", "Landroid/view/View;", "rectContainer", "Landroid/view/ViewGroup;", "withAnimation", "", "delay", "", "showAvatar", "startShowAvatarAnimation", "startShowEntranceAnimation", "getBezierInterpolator", "Lcom/bilibili/playerbizcommon/utils/BezierInterpolator;", "clearPendingAnimations", "clearRunningAnimations", "pendingExecuteAnimations", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/Runnable;", "getPendingExecuteAnimations", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "pendingExecuteAnimations$delegate", "Lkotlin/Lazy;", "runningAnimations", "Landroid/animation/Animator;", "getRunningAnimations", "runningAnimations$delegate", "canShowAnimation", "TAG", "", "FINAL_SCALE_FACTOR", "", "FINAL_TRANS_X", "FINAL_TRANS_Y", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeStoryEntranceAnimationKt {
    private static final float FINAL_SCALE_FACTOR = 1.4f;
    private static final float FINAL_TRANS_X = 21.0f;
    private static final float FINAL_TRANS_Y = -14.0f;
    private static final String TAG = "[TopLeft]HomeStoryEntrance";
    private static final Lazy pendingExecuteAnimations$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            CopyOnWriteArrayList pendingExecuteAnimations_delegate$lambda$0;
            pendingExecuteAnimations_delegate$lambda$0 = HomeStoryEntranceAnimationKt.pendingExecuteAnimations_delegate$lambda$0();
            return pendingExecuteAnimations_delegate$lambda$0;
        }
    });
    private static final Lazy runningAnimations$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            CopyOnWriteArrayList runningAnimations_delegate$lambda$0;
            runningAnimations_delegate$lambda$0 = HomeStoryEntranceAnimationKt.runningAnimations_delegate$lambda$0();
            return runningAnimations_delegate$lambda$0;
        }
    });

    public static final void showAvatar(View view, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(view, "avatar");
        Intrinsics.checkNotNullParameter(viewGroup, "rectContainer");
        showAvatar$default(view, viewGroup, false, 0L, 12, null);
    }

    public static final void showAvatar(View view, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(view, "avatar");
        Intrinsics.checkNotNullParameter(viewGroup, "rectContainer");
        showAvatar$default(view, viewGroup, z, 0L, 8, null);
    }

    public static final void showEntrance(View view, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(view, "avatar");
        Intrinsics.checkNotNullParameter(viewGroup, "rectContainer");
        showEntrance$default(view, viewGroup, false, 0L, 12, null);
    }

    public static final void showEntrance(View view, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(view, "avatar");
        Intrinsics.checkNotNullParameter(viewGroup, "rectContainer");
        showEntrance$default(view, viewGroup, z, 0L, 8, null);
    }

    public static /* synthetic */ void showEntrance$default(View view, ViewGroup viewGroup, boolean z, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            j = 0;
        }
        showEntrance(view, viewGroup, z, j);
    }

    public static final void showEntrance(final View avatar, final ViewGroup rectContainer, boolean withAnimation, long delay) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(rectContainer, "rectContainer");
        BLog.i(TAG, "showEntrance withAnimation:" + withAnimation + " delay:" + delay);
        if (!withAnimation) {
            View background = rectContainer.getChildAt(0);
            View foreground = rectContainer.getChildAt(1);
            foreground.setTranslationX(EmotionAlignHelperKt.toPx((float) FINAL_TRANS_X));
            foreground.setTranslationY(EmotionAlignHelperKt.toPx((float) FINAL_TRANS_Y));
            foreground.setScaleX(FINAL_SCALE_FACTOR);
            foreground.setScaleY(FINAL_SCALE_FACTOR);
            background.setAlpha(0.0f);
            avatar.setAlpha(0.0f);
        } else if (delay <= 0) {
            startShowEntranceAnimation(avatar, rectContainer);
        } else {
            HandlerThreads.postDelayed(0, new AnimationRunnable() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$showEntrance$1
                @Override // tv.danmaku.bili.ui.main2.basic.story.AnimationRunnable
                public void runAnim() {
                    HomeStoryEntranceAnimationKt.startShowEntranceAnimation(avatar, rectContainer);
                }
            }, delay);
        }
    }

    public static /* synthetic */ void showAvatar$default(View view, ViewGroup viewGroup, boolean z, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            j = 0;
        }
        showAvatar(view, viewGroup, z, j);
    }

    public static final void showAvatar(final View avatar, final ViewGroup rectContainer, boolean withAnimation, long delay) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(rectContainer, "rectContainer");
        BLog.i(TAG, "showAvatar withAnimation:" + withAnimation + " delay:" + delay);
        if (!withAnimation) {
            View background = rectContainer.getChildAt(0);
            View foreground = rectContainer.getChildAt(1);
            foreground.setTranslationX(0.0f);
            foreground.setTranslationY(0.0f);
            foreground.setScaleX(1.0f);
            foreground.setScaleY(1.0f);
            avatar.setAlpha(1.0f);
            avatar.setScaleX(1.0f);
            avatar.setScaleY(1.0f);
            background.setAlpha(1.0f);
        } else if (delay <= 0) {
            startShowAvatarAnimation(avatar, rectContainer);
        } else {
            HandlerThreads.postDelayed(0, new AnimationRunnable() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$showAvatar$1
                @Override // tv.danmaku.bili.ui.main2.basic.story.AnimationRunnable
                public void runAnim() {
                    HomeStoryEntranceAnimationKt.startShowAvatarAnimation(avatar, rectContainer);
                }
            }, delay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowAvatarAnimation(final View avatar, ViewGroup rectContainer) {
        if (!canShowAnimation(avatar) || !canShowAnimation(rectContainer)) {
            showAvatar$default(avatar, rectContainer, false, 0L, 8, null);
            return;
        }
        final View background = rectContainer.getChildAt(0);
        final View foreground = rectContainer.getChildAt(1);
        BLog.i(TAG, "startShowAvatarAnimation");
        final AnimatorSet animatorSet = new AnimatorSet();
        Path path = new Path();
        path.moveTo(FINAL_TRANS_X, FINAL_TRANS_Y);
        path.quadTo(FINAL_TRANS_X, 0.0f, 0.0f, 0.0f);
        final PathMeasure pathMeasure = new PathMeasure(path, false);
        final float length = pathMeasure.getLength();
        final float[] location = new float[2];
        ValueAnimator iconTransScaleAnimator = ValueAnimator.ofFloat(0.0f, length);
        iconTransScaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeStoryEntranceAnimationKt.startShowAvatarAnimation$lambda$0(length, pathMeasure, location, foreground, valueAnimator);
            }
        });
        iconTransScaleAnimator.setInterpolator((TimeInterpolator) getBezierInterpolator());
        iconTransScaleAnimator.setDuration(500L);
        ValueAnimator iconBgAlphaAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        iconBgAlphaAnimator.setDuration(50L);
        iconBgAlphaAnimator.setStartDelay(100L);
        iconBgAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeStoryEntranceAnimationKt.startShowAvatarAnimation$lambda$1(background, valueAnimator);
            }
        });
        ValueAnimator avatarSizeAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        avatarSizeAnimator.setDuration(400L);
        avatarSizeAnimator.setStartDelay(90L);
        avatarSizeAnimator.setInterpolator((TimeInterpolator) getBezierInterpolator());
        avatarSizeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeStoryEntranceAnimationKt.startShowAvatarAnimation$lambda$2(avatar, valueAnimator);
            }
        });
        ValueAnimator avatarAlphaAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        avatarAlphaAnimator.setDuration(50L);
        avatarAlphaAnimator.setStartDelay(100L);
        avatarAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$$ExternalSyntheticLambda5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeStoryEntranceAnimationKt.startShowAvatarAnimation$lambda$3(avatar, valueAnimator);
            }
        });
        animatorSet.playTogether(iconTransScaleAnimator, iconBgAlphaAnimator, avatarSizeAnimator, avatarAlphaAnimator);
        animatorSet.start();
        getRunningAnimations().add(animatorSet);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$startShowAvatarAnimation$5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                CopyOnWriteArrayList runningAnimations;
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationCancel(animation);
                runningAnimations = HomeStoryEntranceAnimationKt.getRunningAnimations();
                runningAnimations.remove(animatorSet);
                resetAvatar();
                BLog.i("[TopLeft]HomeStoryEntrance", "startShowAvatarAnimation onAnimationCancel");
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                CopyOnWriteArrayList runningAnimations;
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                runningAnimations = HomeStoryEntranceAnimationKt.getRunningAnimations();
                runningAnimations.remove(animatorSet);
                resetAvatar();
                BLog.i("[TopLeft]HomeStoryEntrance", "startShowAvatarAnimation onAnimationEnd");
            }

            private final void resetAvatar() {
                avatar.setScaleX(1.0f);
                avatar.setScaleY(1.0f);
                avatar.setAlpha(1.0f);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowAvatarAnimation$lambda$0(float $length, PathMeasure $pathMeasure, float[] $location, View $foreground, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float distance = ((Float) animatedValue).floatValue();
        float percent = distance / $length;
        $pathMeasure.getPosTan(distance, $location, null);
        $foreground.setTranslationX(EmotionAlignHelperKt.toPx($location[0]));
        $foreground.setTranslationY(EmotionAlignHelperKt.toPx($location[1]));
        $foreground.setScaleX(FINAL_SCALE_FACTOR - (percent * 0.39999998f));
        $foreground.setScaleY(FINAL_SCALE_FACTOR - (0.39999998f * percent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowAvatarAnimation$lambda$1(View $background, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float alpha = ((Float) animatedValue).floatValue();
        $background.setAlpha(alpha);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowAvatarAnimation$lambda$2(View $avatar, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float size = ((Float) animatedValue).floatValue();
        $avatar.setScaleX(size);
        $avatar.setScaleY(size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowAvatarAnimation$lambda$3(View $avatar, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float alpha = ((Float) animatedValue).floatValue();
        $avatar.setAlpha(alpha);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowEntranceAnimation(final View avatar, ViewGroup rectContainer) {
        if (!canShowAnimation(avatar) || !canShowAnimation(rectContainer)) {
            showEntrance$default(avatar, rectContainer, false, 0L, 8, null);
            return;
        }
        final View background = rectContainer.getChildAt(0);
        final View foreground = rectContainer.getChildAt(1);
        BLog.i(TAG, "startShowEntranceAnimation");
        final AnimatorSet animatorSet = new AnimatorSet();
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(FINAL_TRANS_X, 0.0f, FINAL_TRANS_X, FINAL_TRANS_Y);
        final PathMeasure pathMeasure = new PathMeasure(path, false);
        final float length = pathMeasure.getLength();
        final float[] arr = new float[2];
        ValueAnimator iconTransScaleAnimator = ValueAnimator.ofFloat(0.0f, length);
        iconTransScaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$$ExternalSyntheticLambda6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeStoryEntranceAnimationKt.startShowEntranceAnimation$lambda$0(length, pathMeasure, arr, foreground, valueAnimator);
            }
        });
        iconTransScaleAnimator.setInterpolator((TimeInterpolator) getBezierInterpolator());
        iconTransScaleAnimator.setDuration(500L);
        iconTransScaleAnimator.setStartDelay(30L);
        ValueAnimator iconBgAlphaAnimator = ValueAnimator.ofFloat(1.0f, 0.0f);
        iconBgAlphaAnimator.setDuration(100L);
        iconBgAlphaAnimator.setStartDelay(100L);
        iconBgAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$$ExternalSyntheticLambda7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeStoryEntranceAnimationKt.startShowEntranceAnimation$lambda$1(background, valueAnimator);
            }
        });
        ValueAnimator avatarSizeAnimator = ValueAnimator.ofFloat(1.0f, 0.0f);
        avatarSizeAnimator.setDuration(400L);
        avatarSizeAnimator.setInterpolator((TimeInterpolator) getBezierInterpolator());
        avatarSizeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$$ExternalSyntheticLambda8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeStoryEntranceAnimationKt.startShowEntranceAnimation$lambda$2(avatar, valueAnimator);
            }
        });
        ValueAnimator avatarAlphaAnimator = ValueAnimator.ofFloat(1.0f, 0.0f);
        avatarAlphaAnimator.setDuration(50L);
        avatarAlphaAnimator.setStartDelay(100L);
        avatarAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$$ExternalSyntheticLambda9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeStoryEntranceAnimationKt.startShowEntranceAnimation$lambda$3(avatar, valueAnimator);
            }
        });
        animatorSet.playTogether(iconTransScaleAnimator, iconBgAlphaAnimator, avatarSizeAnimator, avatarAlphaAnimator);
        animatorSet.start();
        getRunningAnimations().add(animatorSet);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt$startShowEntranceAnimation$5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                CopyOnWriteArrayList runningAnimations;
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationCancel(animation);
                runningAnimations = HomeStoryEntranceAnimationKt.getRunningAnimations();
                runningAnimations.remove(animatorSet);
                BLog.i("[TopLeft]HomeStoryEntrance", "startShowEntranceAnimation onAnimationCancel");
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                CopyOnWriteArrayList runningAnimations;
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                runningAnimations = HomeStoryEntranceAnimationKt.getRunningAnimations();
                runningAnimations.remove(animatorSet);
                BLog.i("[TopLeft]HomeStoryEntrance", "startShowEntranceAnimation onAnimationEnd");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowEntranceAnimation$lambda$0(float $length, PathMeasure $pathMeasure, float[] $arr, View $foreground, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float distance = ((Float) animatedValue).floatValue();
        float percent = distance / $length;
        $pathMeasure.getPosTan(distance, $arr, null);
        $foreground.setTranslationX(EmotionAlignHelperKt.toPx($arr[0]));
        $foreground.setTranslationY(EmotionAlignHelperKt.toPx($arr[1]));
        float f = 1;
        $foreground.setScaleX((percent * 0.39999998f) + f);
        $foreground.setScaleY(f + (0.39999998f * percent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowEntranceAnimation$lambda$1(View $background, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float alpha = ((Float) animatedValue).floatValue();
        $background.setAlpha(alpha);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowEntranceAnimation$lambda$2(View $avatar, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float size = ((Float) animatedValue).floatValue();
        $avatar.setScaleX(size);
        $avatar.setScaleY(size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowEntranceAnimation$lambda$3(View $avatar, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float alpha = ((Float) animatedValue).floatValue();
        $avatar.setAlpha(alpha);
    }

    private static final BezierInterpolator getBezierInterpolator() {
        return new BezierInterpolator(0.3f, 0.0f, 0.0f, 1.0f);
    }

    public static final void clearPendingAnimations() {
        Iterable $this$forEach$iv = getPendingExecuteAnimations();
        for (Object element$iv : $this$forEach$iv) {
            Runnable it = (Runnable) element$iv;
            HandlerThreads.remove(0, it);
        }
        getPendingExecuteAnimations().clear();
    }

    public static final void clearRunningAnimations() {
        Iterable $this$forEach$iv = getRunningAnimations();
        for (Object element$iv : $this$forEach$iv) {
            Animator it = (Animator) element$iv;
            it.end();
        }
        getRunningAnimations().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CopyOnWriteArrayList<Runnable> getPendingExecuteAnimations() {
        return (CopyOnWriteArrayList) pendingExecuteAnimations$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CopyOnWriteArrayList pendingExecuteAnimations_delegate$lambda$0() {
        return new CopyOnWriteArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CopyOnWriteArrayList<Animator> getRunningAnimations() {
        return (CopyOnWriteArrayList) runningAnimations$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CopyOnWriteArrayList runningAnimations_delegate$lambda$0() {
        return new CopyOnWriteArrayList();
    }

    public static final boolean canShowAnimation(View $this$canShowAnimation) {
        Intrinsics.checkNotNullParameter($this$canShowAnimation, "<this>");
        return $this$canShowAnimation.isAttachedToWindow() && $this$canShowAnimation.getLocalVisibleRect(new Rect());
    }
}