package tv.danmaku.biliplayerimpl.toast.left;

import android.animation.Animator;
import android.animation.ValueAnimator;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IChangeAnimatorImpl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/IChangeAnimatorImpl;", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "getValueAnimator", "()Landroid/animation/ValueAnimator;", "duration", "", "getDuration", "()J", "onAnimationUpdate", "", "animation", "onAnimationStart", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IChangeAnimatorImpl {
    long getDuration();

    ValueAnimator getValueAnimator();

    void onAnimationEnd(Animator animator);

    void onAnimationStart(Animator animator);

    void onAnimationUpdate(ValueAnimator valueAnimator);
}