package tv.danmaku.bili.videopage.common.widget.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.bean.BaseImageDataSubscriber;
import com.bilibili.lib.image2.bean.DrawableHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.magicasakura.widgets.TintImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ShareAnimView.kt */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0001,\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001fH\u0002J\"\u0010.\u001a\u00020(2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00102\u001a\u00020\u001fJ\b\u00103\u001a\u00020(H\u0014J\b\u00104\u001a\u00020(H\u0014J\u0006\u00105\u001a\u00020(J\u0006\u00106\u001a\u00020(J$\u00109\u001a\u00020(2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00102\u001a\u00020\u001fH\u0016J\u0012\u0010:\u001a\u00020(2\b\u0010;\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010<\u001a\u00020(2\b\u0010=\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010>\u001a\u00020(H\u0002J\b\u0010?\u001a\u00020(H\u0002J\u0012\u0010@\u001a\u00020(2\b\u0010A\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010B\u001a\u00020(H\u0002J\b\u0010C\u001a\u0004\u0018\u00010\u0018J\u0006\u0010D\u001a\u00020(J\b\u0010E\u001a\u00020(H\u0016J\u0018\u0010F\u001a\u00020(2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\nH\u0014J\b\u0010I\u001a\u00020\rH\u0016J\b\u0010J\u001a\u00020(H&R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/ShareAnimView;", "Lcom/bilibili/magicasakura/widgets/TintImageView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mActivate", "", "tmpBounds", "Landroid/graphics/Rect;", "tmpMatrix", "Landroid/graphics/Matrix;", "lockSize", "lockWith", "lockHeight", "mScaleOnceAnim", "Landroid/view/animation/ScaleAnimation;", "oldDrawable", "Landroid/graphics/drawable/Drawable;", "keepAnimation", "Landroid/animation/ValueAnimator;", "mAnimFlag", "mPrepare", "mIsStopActionDo", "mStopActionStart", "", "mDisplayTime", "mSceneChangedAnim", "Landroid/view/animation/Animation;", "getMSceneChangedAnim", "()Landroid/view/animation/Animation;", "mClickListener", "Landroid/view/View$OnClickListener;", "stopAnimation", "", "onTimingStopShareAnim", "shareAnimLeftTime", "mKeepAnimUpdateListener", "tv/danmaku/bili/videopage/common/widget/view/ShareAnimView$mKeepAnimUpdateListener$1", "Ltv/danmaku/bili/videopage/common/widget/view/ShareAnimView$mKeepAnimUpdateListener$1;", "shareIconChanged", "channel", "", "picture", "displayTime", "onAttachedToWindow", "onDetachedFromWindow", "tryStartKeepAnim", "tryStopKeepAnim", "mTimingStopShareAnimRunnable", "Ljava/lang/Runnable;", "updateIconByChannel", "doAnimStart", "menuDrawable", "prepareKeepAnim", "animIcon", "startKeepAnim", "stopKeepAnim", "replaceDrawable", "drawable", "giveBackDrawable", "getOldDrawable", "resetChannelIcon", "requestLayout", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "canAnimRunning", "onShareClicked", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class ShareAnimView extends TintImageView {
    private ValueAnimator keepAnimation;
    private int lockHeight;
    private boolean lockSize;
    private int lockWith;
    private boolean mActivate;
    private boolean mAnimFlag;
    private final View.OnClickListener mClickListener;
    private long mDisplayTime;
    private boolean mIsStopActionDo;
    private final ShareAnimView$mKeepAnimUpdateListener$1 mKeepAnimUpdateListener;
    private boolean mPrepare;
    private ScaleAnimation mScaleOnceAnim;
    private long mStopActionStart;
    private final Runnable mTimingStopShareAnimRunnable;
    private Drawable oldDrawable;
    private Rect tmpBounds;
    private final Matrix tmpMatrix;

    public abstract void onShareClicked();

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareAnimView(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareAnimView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v4, types: [tv.danmaku.bili.videopage.common.widget.view.ShareAnimView$mKeepAnimUpdateListener$1] */
    public ShareAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tmpMatrix = new Matrix();
        this.mClickListener = new View.OnClickListener() { // from class: tv.danmaku.bili.videopage.common.widget.view.ShareAnimView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShareAnimView.mClickListener$lambda$0(ShareAnimView.this, view2);
            }
        };
        super.setOnClickListener(this.mClickListener);
        this.mKeepAnimUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.videopage.common.widget.view.ShareAnimView$mKeepAnimUpdateListener$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                boolean z;
                boolean z2;
                Intrinsics.checkNotNullParameter(animation, "animation");
                z = ShareAnimView.this.mAnimFlag;
                if (z) {
                    Object animatedValue = animation.getAnimatedValue();
                    Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                    float value = ((Float) animatedValue).floatValue();
                    ShareAnimView.this.setScaleX(value);
                    ShareAnimView.this.setScaleY(value);
                }
                ShareAnimView shareAnimView = ShareAnimView.this;
                z2 = ShareAnimView.this.mAnimFlag;
                shareAnimView.mAnimFlag = !z2;
            }
        };
        this.mTimingStopShareAnimRunnable = new Runnable() { // from class: tv.danmaku.bili.videopage.common.widget.view.ShareAnimView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ShareAnimView.mTimingStopShareAnimRunnable$lambda$0(ShareAnimView.this);
            }
        };
    }

    private final Animation getMSceneChangedAnim() {
        if (this.mScaleOnceAnim == null) {
            this.mScaleOnceAnim = new ScaleAnimation(1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, 0.5f, 1, 0.5f);
            ScaleAnimation scaleAnimation = this.mScaleOnceAnim;
            Intrinsics.checkNotNull(scaleAnimation);
            scaleAnimation.setDuration(320L);
            ScaleAnimation scaleAnimation2 = this.mScaleOnceAnim;
            Intrinsics.checkNotNull(scaleAnimation2);
            scaleAnimation2.setRepeatCount(0);
        }
        ScaleAnimation scaleAnimation3 = this.mScaleOnceAnim;
        Intrinsics.checkNotNull(scaleAnimation3);
        return scaleAnimation3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mClickListener$lambda$0(ShareAnimView this$0, View it) {
        this$0.onShareClicked();
        this$0.stopAnimation();
    }

    private final void stopAnimation() {
        boolean state = this.mActivate;
        this.mActivate = false;
        if (state) {
            Animation animation = getAnimation();
            if (animation != null) {
                animation.cancel();
            }
            stopKeepAnim();
            getMSceneChangedAnim().setAnimationListener(new Animation.AnimationListener() { // from class: tv.danmaku.bili.videopage.common.widget.view.ShareAnimView$stopAnimation$1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    Drawable drawable;
                    if (animation2 != null) {
                        animation2.cancel();
                    }
                    ScaleAnimation b = new ScaleAnimation(0.85f, 1.0f, 0.85f, 1.0f, 1, 0.5f, 1, 0.5f);
                    b.setDuration(100L);
                    b.setRepeatCount(0);
                    drawable = ShareAnimView.this.oldDrawable;
                    if (drawable != null) {
                        ShareAnimView.this.giveBackDrawable();
                    }
                    ShareAnimView.this.startAnimation(b);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                }
            });
            startAnimation(getMSceneChangedAnim());
        }
    }

    private final void onTimingStopShareAnim(long shareAnimLeftTime) {
        if (!this.mPrepare) {
            return;
        }
        this.mIsStopActionDo = true;
        this.mStopActionStart = SystemClock.elapsedRealtime();
        this.mDisplayTime = 1000 * shareAnimLeftTime;
        HandlerThreads.postDelayed(0, this.mTimingStopShareAnimRunnable, this.mDisplayTime);
    }

    public final void shareIconChanged(String channel, String picture, long displayTime) {
        if (displayTime > 0 && channel != null && !TextUtils.equals(channel, "default")) {
            updateIconByChannel(channel, picture, displayTime);
        } else {
            resetChannelIcon();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAttachedToWindow() {
        this.mPrepare = true;
        super.onAttachedToWindow();
        if (this.mIsStopActionDo) {
            long lastDelayTime = this.mDisplayTime - (SystemClock.elapsedRealtime() - this.mStopActionStart);
            if (lastDelayTime > 0) {
                HandlerThreads.postDelayed(0, this.mTimingStopShareAnimRunnable, lastDelayTime);
            } else {
                HandlerThreads.post(0, this.mTimingStopShareAnimRunnable);
            }
        }
    }

    protected void onDetachedFromWindow() {
        this.mPrepare = false;
        super.onDetachedFromWindow();
        tryStopKeepAnim();
        HandlerThreads.remove(0, this.mTimingStopShareAnimRunnable);
    }

    public final void tryStartKeepAnim() {
        if (this.mActivate && this.keepAnimation != null) {
            startKeepAnim();
        }
    }

    public final void tryStopKeepAnim() {
        ScaleAnimation scaleAnimation = this.mScaleOnceAnim;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
        getMSceneChangedAnim().cancel();
        stopKeepAnim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mTimingStopShareAnimRunnable$lambda$0(ShareAnimView this$0) {
        this$0.stopAnimation();
        this$0.mIsStopActionDo = false;
    }

    public void updateIconByChannel(String channel, String picture, long displayTime) {
        if (displayTime <= 0 || channel == null) {
            return;
        }
        if ((channel.length() == 0) || TextUtils.equals(channel, "default")) {
            return;
        }
        if (picture != null && !TextUtils.isEmpty(picture)) {
            BiliImageLoader.INSTANCE.acquire((View) this).useOrigin().asDrawable().url(picture).submit().subscribe(new BaseImageDataSubscriber<DrawableHolder>() { // from class: tv.danmaku.bili.videopage.common.widget.view.ShareAnimView$updateIconByChannel$1
                protected void onNewResultImpl(ImageDataSource<DrawableHolder> imageDataSource) {
                    DrawableHolder drawableHolder;
                    Drawable it;
                    if (imageDataSource != null && (drawableHolder = (DrawableHolder) imageDataSource.getResult()) != null && (it = drawableHolder.get()) != null) {
                        ShareAnimView.this.doAnimStart(it);
                    }
                }

                protected void onFailureImpl(ImageDataSource<DrawableHolder> imageDataSource) {
                }
            });
        }
        onTimingStopShareAnim(displayTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doAnimStart(final Drawable menuDrawable) {
        if (menuDrawable != null) {
            boolean canRunnable = canAnimRunning();
            if (this.mActivate && this.keepAnimation != null && canRunnable) {
                startKeepAnim();
            } else if (canRunnable) {
                getMSceneChangedAnim().setAnimationListener(new Animation.AnimationListener() { // from class: tv.danmaku.bili.videopage.common.widget.view.ShareAnimView$doAnimStart$1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (animation != null) {
                            animation.cancel();
                        }
                        ShareAnimView.this.prepareKeepAnim(menuDrawable);
                        if (ShareAnimView.this.canAnimRunning()) {
                            ShareAnimView.this.startKeepAnim();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                resetChannelIcon();
                this.mActivate = true;
                startAnimation(getMSceneChangedAnim());
            } else {
                resetChannelIcon();
                this.mActivate = true;
                prepareKeepAnim(menuDrawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareKeepAnim(Drawable animIcon) {
        if (animIcon == null) {
            return;
        }
        stopKeepAnim();
        this.keepAnimation = null;
        ValueAnimator animator = ValueAnimator.ofFloat(0.85f, 1.0f, 0.85f);
        this.mAnimFlag = true;
        animator.setDuration(1840L);
        animator.setRepeatCount(-1);
        replaceDrawable(animIcon);
        this.keepAnimation = animator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startKeepAnim() {
        ValueAnimator valueAnimator = this.keepAnimation;
        boolean z = false;
        if (valueAnimator != null && !valueAnimator.isRunning()) {
            z = true;
        }
        if (z) {
            ValueAnimator valueAnimator2 = this.keepAnimation;
            if (valueAnimator2 != null) {
                valueAnimator2.removeUpdateListener(this.mKeepAnimUpdateListener);
            }
            ValueAnimator valueAnimator3 = this.keepAnimation;
            if (valueAnimator3 != null) {
                valueAnimator3.addUpdateListener(this.mKeepAnimUpdateListener);
            }
            ValueAnimator valueAnimator4 = this.keepAnimation;
            if (valueAnimator4 != null) {
                valueAnimator4.start();
            }
        }
    }

    private final void stopKeepAnim() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.keepAnimation;
        boolean z = false;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            z = true;
        }
        if (z && (valueAnimator = this.keepAnimation) != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator3 = this.keepAnimation;
        if (valueAnimator3 != null) {
            valueAnimator3.removeUpdateListener(this.mKeepAnimUpdateListener);
        }
    }

    private final void replaceDrawable(Drawable drawable) {
        if (drawable != null) {
            if (this.oldDrawable != null) {
                Drawable drawable2 = this.oldDrawable;
                Intrinsics.checkNotNull(drawable2);
                this.tmpBounds = new Rect(drawable2.getBounds());
            } else {
                Drawable dr = getDrawable();
                if (dr != null) {
                    this.oldDrawable = dr;
                    this.tmpBounds = new Rect(dr.getBounds());
                }
            }
        }
        this.lockWith = getWidth();
        this.lockHeight = getHeight();
        this.tmpMatrix.set(getImageMatrix());
        super.setImageDrawable(drawable);
        if (this.tmpBounds != null) {
            if (drawable != null) {
                Rect rect = this.tmpBounds;
                Intrinsics.checkNotNull(rect);
                drawable.setBounds(rect);
            }
            this.tmpBounds = null;
        }
        getImageMatrix().set(this.tmpMatrix);
        this.lockSize = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void giveBackDrawable() {
        if (this.oldDrawable != null) {
            Animation animation = getAnimation();
            if (animation != null) {
                animation.cancel();
            }
            stopKeepAnim();
            this.lockSize = false;
            setScaleX(1.0f);
            setScaleY(1.0f);
            super.setImageDrawable(this.oldDrawable);
        }
    }

    public final Drawable getOldDrawable() {
        return this.oldDrawable;
    }

    public final void resetChannelIcon() {
        this.lockSize = false;
        giveBackDrawable();
        this.mActivate = false;
    }

    public void requestLayout() {
        if (this.tmpBounds == null) {
            super.requestLayout();
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.lockSize) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.lockWith, 1073741824), View.MeasureSpec.makeMeasureSpec(this.lockHeight, 1073741824));
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public boolean canAnimRunning() {
        return this.mPrepare;
    }
}