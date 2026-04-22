package tv.danmaku.bili.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.playerbizcommon.utils.BezierInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SwitchTextView.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001b\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/widget/SwitchTextView;", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "Landroid/view/animation/Animation$AnimationListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleInt", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPendingText", "", "mExitAnimation", "Landroid/view/animation/AnimationSet;", "mEnterAnimation", "buildExitAnim", "durationTime", "", "buildEnterAnim", "setTextWithAnimation", "", "str", "onAnimationStart", "animation", "Landroid/view/animation/Animation;", "onAnimationEnd", "onAnimationRepeat", "onDetachedFromWindow", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SwitchTextView extends TintTextView implements Animation.AnimationListener {
    public static final int $stable = 8;
    private AnimationSet mEnterAnimation;
    private AnimationSet mExitAnimation;
    private CharSequence mPendingText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchTextView(Context context, AttributeSet attrs, int defStyleInt) {
        super(context, attrs, defStyleInt);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SwitchTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final AnimationSet buildExitAnim(long durationTime) {
        AnimationSet $this$buildExitAnim_u24lambda_u240 = new AnimationSet(true);
        Animation exitAlphaAnimation = new AlphaAnimation(1.0f, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        $this$buildExitAnim_u24lambda_u240.setInterpolator((Interpolator) new BezierInterpolator(0.39f, 0.575f, 0.565f, 1.0f));
        $this$buildExitAnim_u24lambda_u240.setDuration(durationTime);
        $this$buildExitAnim_u24lambda_u240.addAnimation(exitAlphaAnimation);
        $this$buildExitAnim_u24lambda_u240.setAnimationListener(this);
        return $this$buildExitAnim_u24lambda_u240;
    }

    private final AnimationSet buildEnterAnim(long durationTime) {
        AnimationSet $this$buildEnterAnim_u24lambda_u240 = new AnimationSet(true);
        Animation enterAlphaAnimation = new AlphaAnimation((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        $this$buildEnterAnim_u24lambda_u240.setInterpolator((Interpolator) new BezierInterpolator(0.39f, 0.575f, 0.565f, 1.0f));
        $this$buildEnterAnim_u24lambda_u240.setDuration(durationTime);
        $this$buildEnterAnim_u24lambda_u240.addAnimation(enterAlphaAnimation);
        $this$buildEnterAnim_u24lambda_u240.setAnimationListener(this);
        return $this$buildEnterAnim_u24lambda_u240;
    }

    public final void setTextWithAnimation(CharSequence str, long durationTime) {
        if (this.mPendingText != null) {
            setText(this.mPendingText);
        }
        this.mPendingText = str;
        AnimationSet animationSet = this.mExitAnimation;
        if (animationSet != null) {
            animationSet.cancel();
        }
        AnimationSet animationSet2 = this.mEnterAnimation;
        if (animationSet2 != null) {
            animationSet2.cancel();
        }
        clearAnimation();
        long j = 2;
        AnimationSet anim = buildExitAnim(durationTime / j);
        this.mEnterAnimation = buildEnterAnim(durationTime / j);
        startAnimation(anim);
        this.mExitAnimation = anim;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (Intrinsics.areEqual(animation, this.mExitAnimation)) {
            setText(this.mPendingText);
            this.mPendingText = null;
            startAnimation(this.mEnterAnimation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
        if (this.mPendingText != null) {
            setText(this.mPendingText);
            this.mPendingText = null;
        }
    }
}