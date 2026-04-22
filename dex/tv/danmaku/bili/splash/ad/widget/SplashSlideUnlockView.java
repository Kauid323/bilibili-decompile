package tv.danmaku.bili.splash.ad.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.comm.list.widget.utils.ViewAttachScopeKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.adsplash.R;
import tv.danmaku.bili.splash.ad.widget.SplashSlideUnlockView;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerKt;

/* compiled from: SplashSlideUnlockView.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001:B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$H\u0017J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\b\u0010'\u001a\u00020\u001dH\u0014J\u0018\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020!H\u0002J\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010,\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u0007J\u0010\u00100\u001a\u00020\u001d2\b\u00101\u001a\u0004\u0018\u00010.J\u0006\u00102\u001a\u00020\u0012J\u0006\u00103\u001a\u00020\u001dJ\u0006\u00104\u001a\u00020\u001dJ\u0014\u00107\u001a\u000208*\u0002082\u0006\u00109\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Ltv/danmaku/bili/splash/ad/widget/SplashSlideUnlockView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "slideBtn", "Landroid/widget/ImageView;", "slideText", "Ltv/danmaku/bili/splash/ad/widget/SplashShimmerTextView;", "btnSize", "downX", "lastX", "isOnSlide", "", "threshold", "isDone", "listener", "Ltv/danmaku/bili/splash/ad/widget/SplashSlideUnlockView$OnSlideClickListener;", "startAnimator", "Landroid/animation/ValueAnimator;", "textMargin", "gestureDetector", "Landroid/view/GestureDetector;", "initSize", "", "viewWidth", "viewHeight", "thresholdPercent", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "resetSlideBtnPosition", "cancelAnim", "onDetachedFromWindow", "isInSlideBtnArea", "x", "y", "setOnSlideListener", "showText", "content", "", "textColor", "showLogo", "filePath", "isSliding", "handleSlideEventWhenExit", "showAnim", "mRepeatJob", "Lkotlinx/coroutines/Job;", "tintDrawable", "Landroid/graphics/drawable/Drawable;", GarbJsBridgeCallHandlerKt.PURE_THEME, "OnSlideClickListener", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashSlideUnlockView extends RelativeLayout {
    public static final int $stable = 8;
    private int btnSize;
    private int downX;
    private GestureDetector gestureDetector;
    private boolean isDone;
    private boolean isOnSlide;
    private int lastX;
    private OnSlideClickListener listener;
    private Job mRepeatJob;
    private ImageView slideBtn;
    private SplashShimmerTextView slideText;
    private ValueAnimator startAnimator;
    private int textMargin;
    private int threshold;

    /* compiled from: SplashSlideUnlockView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/splash/ad/widget/SplashSlideUnlockView$OnSlideClickListener;", "", "onSlided", "", "isSuccess", "", "onClick", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface OnSlideClickListener {
        void onClick();

        void onSlided(boolean z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashSlideUnlockView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashSlideUnlockView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashSlideUnlockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: tv.danmaku.bili.splash.ad.widget.SplashSlideUnlockView$gestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e) {
                SplashSlideUnlockView.OnSlideClickListener onSlideClickListener;
                Intrinsics.checkNotNullParameter(e, "e");
                onSlideClickListener = SplashSlideUnlockView.this.listener;
                if (onSlideClickListener != null) {
                    onSlideClickListener.onClick();
                    return true;
                }
                return true;
            }
        });
        View.inflate(context, R.layout.bili_app_layout_splash_slide_unlock_btn_common, this);
        View findViewById = findViewById(R.id.splash_btn_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.slideBtn = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.splash_btn_guide);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.slideText = (SplashShimmerTextView) findViewById2;
    }

    public /* synthetic */ SplashSlideUnlockView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void initSize(int viewWidth, int viewHeight, float thresholdPercent) {
        int i;
        int padding = (int) (viewHeight * 0.07d);
        setPadding(padding, padding, padding, padding);
        this.btnSize = viewHeight - (padding * 2);
        ViewGroup.LayoutParams btnLp = this.slideBtn.getLayoutParams();
        btnLp.width = this.btnSize;
        btnLp.height = this.btnSize;
        this.slideBtn.setLayoutParams(btnLp);
        View textContainer = findViewById(R.id.guide_container);
        ViewGroup.LayoutParams layoutParams = textContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams textLp = (RelativeLayout.LayoutParams) layoutParams;
        this.textMargin = this.btnSize + ListExtentionsKt.toPx(10);
        textLp.leftMargin = this.textMargin;
        textContainer.setLayoutParams(textLp);
        this.slideText.setTextSize(0, viewHeight * 0.3f);
        if (thresholdPercent >= 1.0f || thresholdPercent <= 0.0f) {
            i = (viewWidth - (padding * 2)) - this.btnSize;
        } else {
            i = (int) (((viewWidth - (padding * 2)) - this.btnSize) * thresholdPercent);
        }
        this.threshold = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.gestureDetector.onTouchEvent(event);
        int containerWidth = getMeasuredWidth();
        switch (event.getAction()) {
            case 0:
                float distance = event.getRawX();
                this.downX = (int) distance;
                this.lastX = this.downX;
                this.isOnSlide = isInSlideBtnArea(event.getX(), event.getY());
                if (this.isOnSlide) {
                    cancelAnim();
                    break;
                }
                break;
            case 1:
                if (!this.isOnSlide) {
                    return super.onTouchEvent(event);
                }
                float distance2 = event.getRawX() - this.downX;
                if (distance2 > this.threshold) {
                    OnSlideClickListener onSlideClickListener = this.listener;
                    if (onSlideClickListener != null) {
                        onSlideClickListener.onSlided(true);
                    }
                    this.isDone = true;
                } else {
                    OnSlideClickListener onSlideClickListener2 = this.listener;
                    if (onSlideClickListener2 != null) {
                        onSlideClickListener2.onSlided(false);
                    }
                    resetSlideBtnPosition();
                }
                this.isOnSlide = false;
                this.downX = 0;
                this.lastX = 0;
                break;
            case 2:
                if (!this.isOnSlide) {
                    return super.onTouchEvent(event);
                }
                float distance3 = event.getRawX() - this.downX;
                ViewGroup.LayoutParams layoutParams = this.slideBtn.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) layoutParams;
                if (distance3 > 0.0f || lp.leftMargin > 0) {
                    float dx = event.getRawX() - this.lastX;
                    int result = Math.max(0, lp.leftMargin + ((int) dx));
                    if (this.btnSize + result + getPaddingLeft() + getPaddingRight() <= containerWidth) {
                        lp.leftMargin = result;
                        this.slideBtn.setLayoutParams(lp);
                    }
                    this.lastX = (int) event.getRawX();
                    if (this.slideBtn.getLeft() > this.slideText.getLeft() + this.textMargin) {
                        this.slideText.setMaskRectWidth(((this.slideBtn.getLeft() - this.slideText.getLeft()) - this.textMargin) + (this.btnSize / 2));
                        break;
                    } else {
                        this.slideText.setMaskRectWidth(0);
                        break;
                    }
                }
                break;
        }
        return true;
    }

    private final void resetSlideBtnPosition() {
        ViewGroup.LayoutParams layoutParams = this.slideBtn.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        final RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) layoutParams;
        int start = lp.leftMargin;
        ValueAnimator $this$resetSlideBtnPosition_u24lambda_u240 = ValueAnimator.ofInt(start, 0);
        $this$resetSlideBtnPosition_u24lambda_u240.setDuration(100L);
        $this$resetSlideBtnPosition_u24lambda_u240.setInterpolator(new AccelerateInterpolator());
        $this$resetSlideBtnPosition_u24lambda_u240.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.splash.ad.widget.SplashSlideUnlockView$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashSlideUnlockView.resetSlideBtnPosition$lambda$0$0(lp, this, valueAnimator);
            }
        });
        $this$resetSlideBtnPosition_u24lambda_u240.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.splash.ad.widget.SplashSlideUnlockView$resetSlideBtnPosition$1$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                SplashShimmerTextView splashShimmerTextView;
                Intrinsics.checkNotNullParameter(animation, "animation");
                splashShimmerTextView = SplashSlideUnlockView.this.slideText;
                splashShimmerTextView.setMaskRectWidth(0);
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
        $this$resetSlideBtnPosition_u24lambda_u240.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetSlideBtnPosition$lambda$0$0(RelativeLayout.LayoutParams $lp, SplashSlideUnlockView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        $lp.leftMargin = ((Integer) animatedValue).intValue();
        this$0.slideBtn.setLayoutParams($lp);
    }

    private final void cancelAnim() {
        Job job;
        ValueAnimator valueAnimator = this.startAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.startAnimator = null;
        Job job2 = this.mRepeatJob;
        boolean z = false;
        if (job2 != null && job2.isActive()) {
            z = true;
        }
        if (z && (job = this.mRepeatJob) != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.mRepeatJob = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnim();
    }

    private final boolean isInSlideBtnArea(float x, float y) {
        Rect rect = new Rect();
        this.slideBtn.getHitRect(rect);
        return rect.contains((int) x, (int) y) && !this.isDone;
    }

    public final void setOnSlideListener(OnSlideClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void showText(String content, int textColor) {
        SplashShimmerTextView $this$showText_u24lambda_u240 = this.slideText;
        $this$showText_u24lambda_u240.setText(content);
        $this$showText_u24lambda_u240.setTextColor(textColor);
        Drawable drawable = ContextCompat.getDrawable($this$showText_u24lambda_u240.getContext(), com.bilibili.app.comm.baseres.R.drawable.ic_arrow_white_without_padding_alpha);
        Drawable drawable2 = drawable != null ? tintDrawable(drawable, textColor) : null;
        if (drawable2 != null) {
            drawable2.setAlpha(BR.countdownTrackEnabled);
        }
        $this$showText_u24lambda_u240.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable2, null);
    }

    public final void showLogo(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return;
        }
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), (CoroutineStart) null, new SplashSlideUnlockView$showLogo$1(filePath, this, null), 2, (Object) null);
    }

    public final boolean isSliding() {
        return this.isOnSlide;
    }

    public final void handleSlideEventWhenExit() {
        if (!this.isOnSlide || this.isDone) {
            return;
        }
        if (this.lastX - this.downX > this.threshold) {
            OnSlideClickListener onSlideClickListener = this.listener;
            if (onSlideClickListener != null) {
                onSlideClickListener.onSlided(true);
                return;
            }
            return;
        }
        OnSlideClickListener onSlideClickListener2 = this.listener;
        if (onSlideClickListener2 != null) {
            onSlideClickListener2.onSlided(false);
        }
    }

    public final void showAnim() {
        post(new Runnable() { // from class: tv.danmaku.bili.splash.ad.widget.SplashSlideUnlockView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SplashSlideUnlockView.showAnim$lambda$0(SplashSlideUnlockView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAnim$lambda$0(final SplashSlideUnlockView this$0) {
        ViewGroup.LayoutParams layoutParams = this$0.slideBtn.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        final RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) layoutParams;
        this$0.startAnimator = ValueAnimator.ofInt(0, ListExtentionsKt.toPx(14), 0, ListExtentionsKt.toPx(5), 0);
        ValueAnimator it = this$0.startAnimator;
        if (it != null) {
            it.setDuration(960L);
            it.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.splash.ad.widget.SplashSlideUnlockView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SplashSlideUnlockView.showAnim$lambda$0$0$0(lp, this$0, valueAnimator);
                }
            });
            it.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.splash.ad.widget.SplashSlideUnlockView$showAnim$1$1$2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onAnimationEnd(animation);
                    SplashSlideUnlockView.this.mRepeatJob = BuildersKt.launch$default(ViewAttachScopeKt.getAttachScope(SplashSlideUnlockView.this), (CoroutineContext) null, (CoroutineStart) null, new SplashSlideUnlockView$showAnim$1$1$2$onAnimationEnd$1(SplashSlideUnlockView.this, null), 3, (Object) null);
                }
            });
            it.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAnim$lambda$0$0$0(RelativeLayout.LayoutParams $lp, SplashSlideUnlockView this$0, ValueAnimator anim) {
        Intrinsics.checkNotNullParameter(anim, "anim");
        Object animatedValue = anim.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        $lp.leftMargin = ((Integer) animatedValue).intValue();
        this$0.slideBtn.setLayoutParams($lp);
    }

    private final Drawable tintDrawable(Drawable $this$tintDrawable, int color) {
        Drawable wrapper = DrawableCompat.wrap($this$tintDrawable.mutate());
        DrawableCompat.setTint(wrapper, color);
        Intrinsics.checkNotNull(wrapper);
        return wrapper;
    }
}