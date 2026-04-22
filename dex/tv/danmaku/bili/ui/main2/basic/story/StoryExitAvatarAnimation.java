package tv.danmaku.bili.ui.main2.basic.story;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: StoryExitAvatarAnimation.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/story/StoryExitAvatarAnimation;", "", "avatarView", "Landroid/view/View;", "rectContainer", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/View;Landroid/view/ViewGroup;)V", "firstOffset", "", "secondOffset", "mShakeAnimation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "startAnimation", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StoryExitAvatarAnimation {
    public static final int $stable = 8;
    private final View avatarView;
    private final float firstOffset;
    private final ValueAnimator mShakeAnimation;
    private final ViewGroup rectContainer;
    private final float secondOffset;

    public StoryExitAvatarAnimation(View avatarView, ViewGroup rectContainer) {
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        Intrinsics.checkNotNullParameter(rectContainer, "rectContainer");
        this.avatarView = avatarView;
        this.rectContainer = rectContainer;
        this.firstOffset = ListExtentionsKt.toPx(8);
        this.secondOffset = ListExtentionsKt.toPx(4);
        this.mShakeAnimation = ValueAnimator.ofFloat(-this.firstOffset, this.firstOffset, -this.secondOffset, this.secondOffset / 2, 0.0f);
    }

    public final void startAnimation() {
        this.mShakeAnimation.setDuration(300L);
        this.mShakeAnimation.setInterpolator(new LinearInterpolator());
        final View avatar = this.rectContainer.getChildAt(1);
        final float mStartTranslationY = avatar.getTranslationY();
        this.mShakeAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.basic.story.StoryExitAvatarAnimation$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                StoryExitAvatarAnimation.startAnimation$lambda$0(avatar, mStartTranslationY, valueAnimator);
            }
        });
        this.mShakeAnimation.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.main2.basic.story.StoryExitAvatarAnimation$startAnimation$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                View view;
                ViewGroup viewGroup;
                Intrinsics.checkNotNullParameter(animation, "animation");
                view = StoryExitAvatarAnimation.this.avatarView;
                viewGroup = StoryExitAvatarAnimation.this.rectContainer;
                HomeStoryEntranceAnimationKt.showAvatar(view, viewGroup, true, 2500L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        this.mShakeAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$0(View $avatar, float $mStartTranslationY, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float offset = ((Float) animatedValue).floatValue();
        $avatar.setTranslationY($mStartTranslationY + offset);
    }
}