package tv.danmaku.bili.videopage.common.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.Log;
import android.util.TypedValue;
import android.view.animation.LinearInterpolator;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.airbnb.lottie.LottieAnimationView;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.lib.coroutineextension.CoroutineExtensionKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LiveAvatarStore.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0017!\u0018\u0000 <2\u00020\u0001:\u0002<=B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\rH\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u000fH\u0016J\b\u0010-\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u001dH\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002J\u0010\u00104\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u00105\u001a\u00020\u001dH\u0002J\b\u00106\u001a\u00020\u001dH\u0002J\b\u00107\u001a\u00020\u001dH\u0002J\b\u00108\u001a\u00020\u001dH\u0002J\u0013\u00109\u001a\u0004\u0018\u00010:*\u00020\u0003H\u0000¢\u0006\u0002\b;R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/LiveAvatarStore;", "Ltv/danmaku/bili/videopage/common/widget/IStore;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "config", "Ltv/danmaku/bili/videopage/common/widget/LiveAvatarStore$Config;", "getConfig", "()Ltv/danmaku/bili/videopage/common/widget/LiveAvatarStore$Config;", "circleViews", "", "Ljava/lang/ref/WeakReference;", "Ltv/danmaku/bili/videopage/common/widget/CircleView;", "lottieViews", "Lcom/airbnb/lottie/LottieAnimationView;", "isAnimating", "", "mFirstAnimationJob", "Lkotlinx/coroutines/Job;", "mSecondAnimationJob", "mWaitJob", "outerAnimatorListener", "tv/danmaku/bili/videopage/common/widget/LiveAvatarStore$outerAnimatorListener$1", "Ltv/danmaku/bili/videopage/common/widget/LiveAvatarStore$outerAnimatorListener$1;", "innerAnimatorSet", "Landroid/animation/AnimatorSet;", "dispatchInnerAnimation", "Lkotlin/Function0;", "", "outerAnimatorSet", "dispatchOuterAnimation", "lifecycleObserver", "tv/danmaku/bili/videopage/common/widget/LiveAvatarStore$lifecycleObserver$1", "Ltv/danmaku/bili/videopage/common/widget/LiveAvatarStore$lifecycleObserver$1;", "innerWidthUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "outerWidthUpdateListener", "innerAlphaUpdateListener", "outerAlphaUpdateListener", "innerStrokeUpdateListener", "outerStrokeUpdateListener", "addCircleView", "view", "addLottieViews", "start", "stop", "getLottieFrame", "", "stopAllLottieAnimation", "resetInner", "resetOuter", "init", "replay", "startInternal", "stopInternal", "invalidate", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "lifecycle$videopagecommon_apinkDebug", "Companion", "Config", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LiveAvatarStore implements IStore {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "LiveAvatarStore";
    private final List<WeakReference<CircleView>> circleViews;
    private final Config config;
    private final Context context;
    private final Function0<Unit> dispatchInnerAnimation;
    private final Function0<Unit> dispatchOuterAnimation;
    private final ValueAnimator.AnimatorUpdateListener innerAlphaUpdateListener;
    private AnimatorSet innerAnimatorSet;
    private final ValueAnimator.AnimatorUpdateListener innerStrokeUpdateListener;
    private final ValueAnimator.AnimatorUpdateListener innerWidthUpdateListener;
    private boolean isAnimating;
    private final LiveAvatarStore$lifecycleObserver$1 lifecycleObserver;
    private final List<WeakReference<LottieAnimationView>> lottieViews;
    private Job mFirstAnimationJob;
    private Job mSecondAnimationJob;
    private Job mWaitJob;
    private final ValueAnimator.AnimatorUpdateListener outerAlphaUpdateListener;
    private final LiveAvatarStore$outerAnimatorListener$1 outerAnimatorListener;
    private AnimatorSet outerAnimatorSet;
    private final ValueAnimator.AnimatorUpdateListener outerStrokeUpdateListener;
    private final ValueAnimator.AnimatorUpdateListener outerWidthUpdateListener;

    /* JADX WARN: Type inference failed for: r0v10, types: [tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$lifecycleObserver$1] */
    public LiveAvatarStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.config = new Config();
        init(this.context);
        this.circleViews = new ArrayList();
        this.lottieViews = new ArrayList();
        this.outerAnimatorListener = new LiveAvatarStore$outerAnimatorListener$1(this);
        this.dispatchInnerAnimation = new Function0() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit dispatchInnerAnimation$lambda$0;
                dispatchInnerAnimation$lambda$0 = LiveAvatarStore.dispatchInnerAnimation$lambda$0(LiveAvatarStore.this);
                return dispatchInnerAnimation$lambda$0;
            }
        };
        this.dispatchOuterAnimation = new Function0() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit dispatchOuterAnimation$lambda$0;
                dispatchOuterAnimation$lambda$0 = LiveAvatarStore.dispatchOuterAnimation$lambda$0(LiveAvatarStore.this);
                return dispatchOuterAnimation$lambda$0;
            }
        };
        this.lifecycleObserver = new LifecycleObserver() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$lifecycleObserver$1
            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public final void onResume() {
                Log.d(LiveAvatarStore.TAG, "==== call onResume ====");
                LiveAvatarStore.this.startInternal();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public final void onPause() {
                Log.d(LiveAvatarStore.TAG, "==== call onPause ====");
                LiveAvatarStore.this.stopInternal();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                AnimatorSet animatorSet;
                AnimatorSet animatorSet2;
                Log.d(LiveAvatarStore.TAG, "==== call onDestroy ====");
                animatorSet = LiveAvatarStore.this.innerAnimatorSet;
                if (animatorSet != null) {
                    animatorSet.removeAllListeners();
                }
                animatorSet2 = LiveAvatarStore.this.outerAnimatorSet;
                if (animatorSet2 != null) {
                    animatorSet2.removeAllListeners();
                }
                LiveAvatarStore.this.stopInternal();
            }
        };
        this.innerWidthUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveAvatarStore.innerWidthUpdateListener$lambda$0(LiveAvatarStore.this, valueAnimator);
            }
        };
        this.outerWidthUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$$ExternalSyntheticLambda5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveAvatarStore.outerWidthUpdateListener$lambda$0(LiveAvatarStore.this, valueAnimator);
            }
        };
        this.innerAlphaUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$$ExternalSyntheticLambda6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveAvatarStore.innerAlphaUpdateListener$lambda$0(LiveAvatarStore.this, valueAnimator);
            }
        };
        this.outerAlphaUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$$ExternalSyntheticLambda7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveAvatarStore.outerAlphaUpdateListener$lambda$0(LiveAvatarStore.this, valueAnimator);
            }
        };
        this.innerStrokeUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$$ExternalSyntheticLambda8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveAvatarStore.innerStrokeUpdateListener$lambda$0(LiveAvatarStore.this, valueAnimator);
            }
        };
        this.outerStrokeUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$$ExternalSyntheticLambda9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveAvatarStore.outerStrokeUpdateListener$lambda$0(LiveAvatarStore.this, valueAnimator);
            }
        };
    }

    public final Config getConfig() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchInnerAnimation$lambda$0(LiveAvatarStore this$0) {
        this$0.resetInner();
        if (this$0.innerAnimatorSet == null) {
            ValueAnimator innerWidthAnimator = ValueAnimator.ofInt(Companion.dp2Px(this$0.config.getBeginRadiusInDp()), Companion.dp2Px(this$0.config.getEndInnerRadiusInDp()));
            innerWidthAnimator.addUpdateListener(this$0.innerWidthUpdateListener);
            ValueAnimator alphaAnimator = ValueAnimator.ofInt(this$0.config.getBeginAlpha(), 0);
            alphaAnimator.addUpdateListener(this$0.innerAlphaUpdateListener);
            ValueAnimator strokeAnimator = ValueAnimator.ofFloat(this$0.config.getBeginInnerStrokeWidth(), this$0.config.getEndInnerStrokeWidth());
            strokeAnimator.addUpdateListener(this$0.innerStrokeUpdateListener);
            this$0.innerAnimatorSet = new AnimatorSet();
            AnimatorSet animatorSet = this$0.innerAnimatorSet;
            if (animatorSet != null) {
                animatorSet.setDuration(1000L);
            }
            AnimatorSet animatorSet2 = this$0.innerAnimatorSet;
            if (animatorSet2 != null) {
                animatorSet2.setInterpolator(new LinearInterpolator());
            }
            AnimatorSet animatorSet3 = this$0.innerAnimatorSet;
            if (animatorSet3 != null) {
                animatorSet3.playTogether(innerWidthAnimator, alphaAnimator, strokeAnimator);
            }
        }
        AnimatorSet animatorSet4 = this$0.innerAnimatorSet;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
        AnimatorSet animatorSet5 = this$0.innerAnimatorSet;
        if (animatorSet5 != null) {
            animatorSet5.start();
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchOuterAnimation$lambda$0(LiveAvatarStore this$0) {
        this$0.resetOuter();
        if (this$0.outerAnimatorSet == null) {
            ValueAnimator outerWidthAnimator = ValueAnimator.ofInt(Companion.dp2Px(this$0.config.getBeginRadiusInDp()), Companion.dp2Px(this$0.config.getEndOuterRadiusInDp()));
            outerWidthAnimator.addUpdateListener(this$0.outerWidthUpdateListener);
            ValueAnimator alphaAnimator = ValueAnimator.ofInt(this$0.config.getBeginAlpha(), 0);
            alphaAnimator.addUpdateListener(this$0.outerAlphaUpdateListener);
            ValueAnimator strokeAnimator = ValueAnimator.ofFloat(this$0.config.getBeginOuterStrokeWidth(), this$0.config.getEndOuterStrokeWidth());
            strokeAnimator.addUpdateListener(this$0.outerStrokeUpdateListener);
            this$0.outerAnimatorSet = new AnimatorSet();
            AnimatorSet animatorSet = this$0.outerAnimatorSet;
            if (animatorSet != null) {
                animatorSet.setDuration(1000L);
            }
            AnimatorSet animatorSet2 = this$0.outerAnimatorSet;
            if (animatorSet2 != null) {
                animatorSet2.addListener(this$0.outerAnimatorListener);
            }
            AnimatorSet animatorSet3 = this$0.outerAnimatorSet;
            if (animatorSet3 != null) {
                animatorSet3.setInterpolator(new LinearInterpolator());
            }
            AnimatorSet animatorSet4 = this$0.outerAnimatorSet;
            if (animatorSet4 != null) {
                animatorSet4.playTogether(outerWidthAnimator, alphaAnimator, strokeAnimator);
            }
        }
        AnimatorSet animatorSet5 = this$0.outerAnimatorSet;
        if (animatorSet5 != null) {
            animatorSet5.cancel();
        }
        AnimatorSet animatorSet6 = this$0.outerAnimatorSet;
        if (animatorSet6 != null) {
            animatorSet6.start();
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void innerWidthUpdateListener$lambda$0(LiveAvatarStore this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Config config = this$0.config;
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        config.setRadiusInner(((Integer) animatedValue).intValue());
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void outerWidthUpdateListener$lambda$0(LiveAvatarStore this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Config config = this$0.config;
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        config.setRadiusOuter(((Integer) animatedValue).intValue());
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void innerAlphaUpdateListener$lambda$0(LiveAvatarStore this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Paint paintInner = this$0.config.getPaintInner();
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        paintInner.setAlpha(((Integer) animatedValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void outerAlphaUpdateListener$lambda$0(LiveAvatarStore this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Paint paintOuter = this$0.config.getPaintOuter();
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        paintOuter.setAlpha(((Integer) animatedValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void innerStrokeUpdateListener$lambda$0(LiveAvatarStore this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Paint paintInner = this$0.config.getPaintInner();
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        paintInner.setStrokeWidth(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void outerStrokeUpdateListener$lambda$0(LiveAvatarStore this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Paint paintInner = this$0.config.getPaintInner();
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        paintInner.setStrokeWidth(((Float) animatedValue).floatValue());
    }

    @Override // tv.danmaku.bili.videopage.common.widget.IStore
    public void addCircleView(CircleView view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.circleViews.add(new WeakReference<>(view2));
        view2.onAdded(this.config);
    }

    @Override // tv.danmaku.bili.videopage.common.widget.IStore
    public void addLottieViews(LottieAnimationView view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.lottieViews.add(new WeakReference<>(view2));
        if (this.isAnimating && !view2.isAnimating()) {
            view2.setFrame(getLottieFrame());
            view2.resumeAnimation();
        }
    }

    @Override // tv.danmaku.bili.videopage.common.widget.IStore
    public void start() {
        startInternal();
        Lifecycle lifecycle$videopagecommon_apinkDebug = lifecycle$videopagecommon_apinkDebug(this.context);
        if (lifecycle$videopagecommon_apinkDebug != null) {
            lifecycle$videopagecommon_apinkDebug.removeObserver(this.lifecycleObserver);
        }
        Lifecycle lifecycle$videopagecommon_apinkDebug2 = lifecycle$videopagecommon_apinkDebug(this.context);
        if (lifecycle$videopagecommon_apinkDebug2 != null) {
            lifecycle$videopagecommon_apinkDebug2.addObserver(this.lifecycleObserver);
        }
    }

    @Override // tv.danmaku.bili.videopage.common.widget.IStore
    public void stop() {
        stopInternal();
    }

    private final int getLottieFrame() {
        boolean z;
        LottieAnimationView lottie;
        Iterable $this$forEach$iv = this.lottieViews;
        Iterator<T> it = $this$forEach$iv.iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return 0;
            }
            Object element$iv = it.next();
            WeakReference it2 = (WeakReference) element$iv;
            lottie = (LottieAnimationView) it2.get();
            if (lottie != null && lottie.isAnimating()) {
                z = true;
                continue;
            }
        } while (!z);
        return lottie.getFrame();
    }

    private final void stopAllLottieAnimation() {
        Iterator iterator = this.lottieViews.iterator();
        while (iterator.hasNext()) {
            LottieAnimationView lottie = iterator.next().get();
            if (lottie == null) {
                iterator.remove();
            } else {
                lottie.setFrame(0);
                lottie.cancelAnimation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetInner() {
        this.config.setRadiusInner(0);
        this.config.getPaintInner().setAlpha(this.config.getAlphaInner());
        this.config.getPaintInner().setColor(this.config.getColor());
        this.config.getPaintInner().setStrokeWidth(this.config.getBeginInnerStrokeWidth());
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetOuter() {
        this.config.setRadiusOuter(0);
        this.config.getPaintOuter().setAlpha(this.config.getAlphaOuter());
        this.config.getPaintOuter().setColor(this.config.getColor());
        this.config.getPaintOuter().setStrokeWidth(this.config.getBeginOuterStrokeWidth());
        invalidate();
    }

    private final void init(Context context) {
        this.config.onTint(context);
        this.config.setRadiusStatic(Companion.dp2Px(this.config.getBeginRadiusInDp()));
        this.config.getPaintInner().setStrokeWidth(this.config.getBeginInnerStrokeWidth());
        this.config.getPaintInner().setAlpha(this.config.getAlphaInner());
        this.config.getPaintInner().setAntiAlias(true);
        this.config.getPaintInner().setStyle(Paint.Style.STROKE);
        this.config.getPaintOuter().setStrokeWidth(this.config.getBeginOuterStrokeWidth());
        this.config.getPaintOuter().setAlpha(this.config.getAlphaOuter());
        this.config.getPaintOuter().setAntiAlias(true);
        this.config.getPaintOuter().setStyle(Paint.Style.STROKE);
        this.config.getPaintStatic().setStrokeWidth(this.config.getStaticStrokeWidth());
        this.config.getPaintStatic().setAlpha(this.config.getPaintInner().getAlpha());
        this.config.getPaintStatic().setAntiAlias(this.config.getPaintInner().isAntiAlias());
        this.config.getPaintStatic().setStyle(this.config.getPaintInner().getStyle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void replay() {
        Job job = this.mFirstAnimationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.mSecondAnimationJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.mFirstAnimationJob = CoroutineExtensionKt.setTimeOut$default((CoroutineDispatcher) null, this.config.getDelayInner(), new Function0() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit replay$lambda$0;
                replay$lambda$0 = LiveAvatarStore.replay$lambda$0(LiveAvatarStore.this);
                return replay$lambda$0;
            }
        }, 1, (Object) null);
        this.mSecondAnimationJob = CoroutineExtensionKt.setTimeOut$default((CoroutineDispatcher) null, this.config.getDelayOuter(), new Function0() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit replay$lambda$1;
                replay$lambda$1 = LiveAvatarStore.replay$lambda$1(LiveAvatarStore.this);
                return replay$lambda$1;
            }
        }, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit replay$lambda$0(LiveAvatarStore this$0) {
        this$0.dispatchInnerAnimation.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit replay$lambda$1(LiveAvatarStore this$0) {
        this$0.dispatchOuterAnimation.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startInternal() {
        if (!this.isAnimating) {
            Log.d(TAG, "call startInternal");
            this.isAnimating = true;
            Job job = this.mFirstAnimationJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job job2 = this.mSecondAnimationJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            this.mFirstAnimationJob = CoroutineExtensionKt.setTimeOut$default((CoroutineDispatcher) null, this.config.getDelayInner(), new Function0() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit startInternal$lambda$0;
                    startInternal$lambda$0 = LiveAvatarStore.startInternal$lambda$0(LiveAvatarStore.this);
                    return startInternal$lambda$0;
                }
            }, 1, (Object) null);
            this.mSecondAnimationJob = CoroutineExtensionKt.setTimeOut$default((CoroutineDispatcher) null, this.config.getDelayOuter(), new Function0() { // from class: tv.danmaku.bili.videopage.common.widget.LiveAvatarStore$$ExternalSyntheticLambda11
                public final Object invoke() {
                    Unit startInternal$lambda$1;
                    startInternal$lambda$1 = LiveAvatarStore.startInternal$lambda$1(LiveAvatarStore.this);
                    return startInternal$lambda$1;
                }
            }, 1, (Object) null);
            Iterator iterator = this.lottieViews.iterator();
            while (iterator.hasNext()) {
                LottieAnimationView lottie = iterator.next().get();
                if (lottie != null) {
                    lottie.loop(true);
                }
                if (lottie == null) {
                    iterator.remove();
                } else {
                    lottie.playAnimation();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startInternal$lambda$0(LiveAvatarStore this$0) {
        this$0.dispatchInnerAnimation.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startInternal$lambda$1(LiveAvatarStore this$0) {
        this$0.dispatchOuterAnimation.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopInternal() {
        if (this.isAnimating) {
            Log.d(TAG, "call stopInternal");
            Job job = this.mFirstAnimationJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job job2 = this.mSecondAnimationJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            Job job3 = this.mWaitJob;
            if (job3 != null) {
                Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
            }
            AnimatorSet animatorSet = this.innerAnimatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.outerAnimatorSet;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            stopAllLottieAnimation();
            this.isAnimating = false;
        }
    }

    private final void invalidate() {
        Iterable $this$forEach$iv = this.circleViews;
        for (Object element$iv : $this$forEach$iv) {
            WeakReference it = (WeakReference) element$iv;
            CircleView circleView = (CircleView) it.get();
            if (circleView != null) {
                circleView.invalidate(this.config);
            }
        }
        if (this.lottieViews.size() > 0) {
            LottieAnimationView lottieAnimationView = this.lottieViews.get(0).get();
            int frame = lottieAnimationView != null ? lottieAnimationView.getFrame() : 0;
            Iterable $this$forEach$iv2 = this.lottieViews;
            for (Object element$iv2 : $this$forEach$iv2) {
                WeakReference it2 = (WeakReference) element$iv2;
                LottieAnimationView lottieView = (LottieAnimationView) it2.get();
                if (lottieView != null && !lottieView.isAnimating()) {
                    lottieView.setFrame(frame);
                    lottieView.resumeAnimation();
                }
            }
        }
    }

    /* compiled from: LiveAvatarStore.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/LiveAvatarStore$Companion;", "", "<init>", "()V", "TAG", "", "dp2Px", "", "dp", "", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int dp2Px(float dp) {
            return (int) TypedValue.applyDimension(1, dp, Resources.getSystem().getDisplayMetrics());
        }
    }

    public final Lifecycle lifecycle$videopagecommon_apinkDebug(Context $this$lifecycle) {
        Intrinsics.checkNotNullParameter($this$lifecycle, "<this>");
        ContextWrapper c = $this$lifecycle instanceof ContextWrapper ? (ContextWrapper) $this$lifecycle : null;
        while (c != null) {
            if (c instanceof LifecycleOwner) {
                return ((LifecycleOwner) c).getLifecycle();
            }
            Context baseContext = c.getBaseContext();
            c = baseContext instanceof ContextWrapper ? (ContextWrapper) baseContext : null;
        }
        return null;
    }

    /* compiled from: LiveAvatarStore.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FR\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u001bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010 \u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0014\u0010\"\u001a\u00020#X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020#X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020#X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001a\u00103\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\u001a\u00106\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001d\"\u0004\b<\u00109R\u001a\u0010=\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001d\"\u0004\b?\u00109R\u001a\u0010@\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001d\"\u0004\bB\u00109¨\u0006G"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/LiveAvatarStore$Config;", "", "<init>", "()V", "staticStrokeWidth", "", "getStaticStrokeWidth", "()F", "beginInnerStrokeWidth", "getBeginInnerStrokeWidth", "endInnerStrokeWidth", "getEndInnerStrokeWidth", "beginOuterStrokeWidth", "getBeginOuterStrokeWidth", "endOuterStrokeWidth", "getEndOuterStrokeWidth", "beginRadiusInDp", "getBeginRadiusInDp", "setBeginRadiusInDp", "(F)V", "endInnerRadiusInDp", "getEndInnerRadiusInDp", "setEndInnerRadiusInDp", "endOuterRadiusInDp", "getEndOuterRadiusInDp", "setEndOuterRadiusInDp", "beginAlpha", "", "getBeginAlpha", "()I", "alphaInner", "getAlphaInner", "alphaOuter", "getAlphaOuter", "delayInner", "", "getDelayInner", "()J", "delayOuter", "getDelayOuter", "delayWait", "getDelayWait", "paintInner", "Landroid/graphics/Paint;", "getPaintInner", "()Landroid/graphics/Paint;", "setPaintInner", "(Landroid/graphics/Paint;)V", "paintOuter", "getPaintOuter", "setPaintOuter", "paintStatic", "getPaintStatic", "setPaintStatic", "radiusOuter", "getRadiusOuter", "setRadiusOuter", "(I)V", "radiusInner", "getRadiusInner", "setRadiusInner", "radiusStatic", "getRadiusStatic", "setRadiusStatic", "color", "getColor", "setColor", "onTint", "", "context", "Landroid/content/Context;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Config {
        private int color;
        private int radiusInner;
        private int radiusOuter;
        private int radiusStatic;
        private final float staticStrokeWidth = 1.3f;
        private final float beginInnerStrokeWidth = 1.3f;
        private final float endInnerStrokeWidth = 0.66f;
        private final float beginOuterStrokeWidth = 1.3f;
        private final float endOuterStrokeWidth = 0.66f;
        private float beginRadiusInDp = 17.0f;
        private float endInnerRadiusInDp = 29.0f;
        private float endOuterRadiusInDp = 29.0f;
        private final int beginAlpha = 255;
        private final int alphaInner = this.beginAlpha;
        private final int alphaOuter = this.beginAlpha;
        private final long delayInner = 500;
        private final long delayOuter = 1000;
        private final long delayWait = PlayerToastConfig.DURATION_3;
        private Paint paintInner = new Paint();
        private Paint paintOuter = new Paint();
        private Paint paintStatic = new Paint();

        public final float getStaticStrokeWidth() {
            return this.staticStrokeWidth;
        }

        public final float getBeginInnerStrokeWidth() {
            return this.beginInnerStrokeWidth;
        }

        public final float getEndInnerStrokeWidth() {
            return this.endInnerStrokeWidth;
        }

        public final float getBeginOuterStrokeWidth() {
            return this.beginOuterStrokeWidth;
        }

        public final float getEndOuterStrokeWidth() {
            return this.endOuterStrokeWidth;
        }

        public final float getBeginRadiusInDp() {
            return this.beginRadiusInDp;
        }

        public final void setBeginRadiusInDp(float f) {
            this.beginRadiusInDp = f;
        }

        public final float getEndInnerRadiusInDp() {
            return this.endInnerRadiusInDp;
        }

        public final void setEndInnerRadiusInDp(float f) {
            this.endInnerRadiusInDp = f;
        }

        public final float getEndOuterRadiusInDp() {
            return this.endOuterRadiusInDp;
        }

        public final void setEndOuterRadiusInDp(float f) {
            this.endOuterRadiusInDp = f;
        }

        public final int getBeginAlpha() {
            return this.beginAlpha;
        }

        public final int getAlphaInner() {
            return this.alphaInner;
        }

        public final int getAlphaOuter() {
            return this.alphaOuter;
        }

        public final long getDelayInner() {
            return this.delayInner;
        }

        public final long getDelayOuter() {
            return this.delayOuter;
        }

        public final long getDelayWait() {
            return this.delayWait;
        }

        public final Paint getPaintInner() {
            return this.paintInner;
        }

        public final void setPaintInner(Paint paint) {
            Intrinsics.checkNotNullParameter(paint, "<set-?>");
            this.paintInner = paint;
        }

        public final Paint getPaintOuter() {
            return this.paintOuter;
        }

        public final void setPaintOuter(Paint paint) {
            Intrinsics.checkNotNullParameter(paint, "<set-?>");
            this.paintOuter = paint;
        }

        public final Paint getPaintStatic() {
            return this.paintStatic;
        }

        public final void setPaintStatic(Paint paint) {
            Intrinsics.checkNotNullParameter(paint, "<set-?>");
            this.paintStatic = paint;
        }

        public final int getRadiusOuter() {
            return this.radiusOuter;
        }

        public final void setRadiusOuter(int i) {
            this.radiusOuter = i;
        }

        public final int getRadiusInner() {
            return this.radiusInner;
        }

        public final void setRadiusInner(int i) {
            this.radiusInner = i;
        }

        public final int getRadiusStatic() {
            return this.radiusStatic;
        }

        public final void setRadiusStatic(int i) {
            this.radiusStatic = i;
        }

        public final int getColor() {
            return this.color;
        }

        public final void setColor(int i) {
            this.color = i;
        }

        public final void onTint(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.color = context.getResources().getColor(R.color.daynight_color_theme_pink);
            this.paintInner.setColor(this.color);
            this.paintOuter.setColor(this.color);
            this.paintStatic.setColor(this.color);
        }
    }
}