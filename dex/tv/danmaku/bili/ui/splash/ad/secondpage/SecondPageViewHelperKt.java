package tv.danmaku.bili.ui.splash.ad.secondpage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.OneShotPreDrawListener;
import com.bilibili.droid.ToastHelper;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tv.danmaku.bili.splash.ad.player.SplashAlphaPlayer;
import tv.danmaku.bili.ui.splash.ad.button.model.GuideButtonViewListInfo;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.ui.splash.ad.model.SplashSecondPageInfo;
import tv.danmaku.bili.ui.splash.ad.page.BaseSplash;
import tv.danmaku.bili.ui.splash.ad.util.SplashLiveReserveHelper;
import tv.danmaku.bili.ui.splash.widget.SplashInteractView;
import tv.danmaku.bili.ui.splash.widget.SplashSecondEggVideoView;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SecondPageViewHelper.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a:\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r\u001a&\u0010\u000e\u001a\u00020\u00012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013\u001a(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002\u001a8\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002\u001a@\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002\u001aJ\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u001f"}, d2 = {"showSecondPage", "", "rootContainer", "Landroid/view/ViewGroup;", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "baseSplash", "Ltv/danmaku/bili/ui/splash/ad/page/BaseSplash;", "actionType", "Ltv/danmaku/bili/ui/splash/ad/button/model/SplashActionType;", "secondEggVideoView", "Ltv/danmaku/bili/splash/ad/player/SplashAlphaPlayer;", "listener", "Ltv/danmaku/bili/ui/splash/ad/secondpage/SecondPageInteractListener;", "firstPageElementDisappear", "viewList", "", "Landroid/view/View;", "onEnd", "Lkotlin/Function0;", "addInteractLayer", "Ltv/danmaku/bili/ui/splash/widget/SplashInteractView;", "ctx", "Landroid/content/Context;", "addBasicLayer", "width", "", "height", "addButtonLayer", "container", "addSecondPageEasterEggVideoLayer", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SecondPageViewHelperKt {
    public static final void showSecondPage(final ViewGroup rootContainer, final Splash splash, final BaseSplash baseSplash, final SplashActionType actionType, final SplashAlphaPlayer secondEggVideoView, final SecondPageInteractListener listener) {
        final Context ctx;
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(baseSplash, "baseSplash");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (rootContainer != null && (ctx = rootContainer.getContext()) != null) {
            rootContainer.setVisibility(0);
            final ViewGroup $this$doOnPreDraw$iv = rootContainer;
            OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageViewHelperKt$showSecondPage$lambda$0$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    SplashInteractView interactView;
                    View view2 = $this$doOnPreDraw$iv;
                    int width = rootContainer.getWidth();
                    int height = rootContainer.getHeight();
                    rootContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageViewHelperKt$showSecondPage$1$1$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View it) {
                        }
                    });
                    if (splash.secondPageShowStyle == 3) {
                        SecondPageViewHelperKt.addSecondPageEasterEggVideoLayer(ctx, rootContainer, width, height, splash, actionType, secondEggVideoView, listener);
                        return;
                    }
                    interactView = SecondPageViewHelperKt.addInteractLayer(ctx, rootContainer, splash, listener);
                    SecondPageViewHelperKt.addButtonLayer(ctx, interactView, width, height, baseSplash, splash, listener);
                    SecondPageViewHelperKt.addBasicLayer(ctx, rootContainer, width, height, splash, listener);
                }
            });
        }
    }

    public static /* synthetic */ void firstPageElementDisappear$default(List list, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageViewHelperKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        firstPageElementDisappear(list, function0);
    }

    public static final void firstPageElementDisappear(List<? extends View> list, final Function0<Unit> function0) {
        final List viewList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(viewList, "viewList");
        Intrinsics.checkNotNullParameter(function0, "onEnd");
        ValueAnimator alphaAnimator = ObjectAnimator.ofFloat(1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        alphaAnimator.setDuration(200L);
        alphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageViewHelperKt$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SecondPageViewHelperKt.firstPageElementDisappear$lambda$1(viewList, valueAnimator);
            }
        });
        Intrinsics.checkNotNull(alphaAnimator);
        ValueAnimator $this$addListener_u24default$iv = alphaAnimator;
        $this$addListener_u24default$iv.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageViewHelperKt$firstPageElementDisappear$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                function0.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        alphaAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void firstPageElementDisappear$lambda$1(List $viewList, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float alpha = ((Float) animatedValue).floatValue();
        Iterable $this$forEach$iv = CollectionsKt.filterNotNull($viewList);
        for (Object element$iv : $this$forEach$iv) {
            View it = (View) element$iv;
            it.setAlpha(alpha);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SplashInteractView addInteractLayer(Context context, ViewGroup rootContainer, Splash splash, SecondPageInteractListener listener) {
        Context ctx = EnhancedUnmodifiabilityKt.unmodifiable(context);
        SplashSecondPageInfo splashSecondPageInfo = splash.secondPage;
        Integer interactStyle = splashSecondPageInfo != null ? Integer.valueOf(splashSecondPageInfo.getInteractStyle()) : null;
        boolean enableInteract = false;
        boolean clickOnly = interactStyle != null && interactStyle.intValue() == 1;
        if ((interactStyle != null && interactStyle.intValue() == 1) || (interactStyle != null && interactStyle.intValue() == 2)) {
            enableInteract = true;
        }
        SplashInteractView interactView = SecondPageViewFactoryKt.generateInteractView(ctx, enableInteract, clickOnly);
        interactView.setOnInteractListener(listener);
        rootContainer.addView(interactView);
        return interactView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r1.getShowSoundButton() == true) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void addBasicLayer(Context context, ViewGroup rootContainer, int width, int height, Splash splash, final SecondPageInteractListener listener) {
        boolean z;
        final Context ctx = EnhancedUnmodifiabilityKt.unmodifiable(context);
        ImageView closeView = SecondPageViewFactoryKt.generateCloseBtn(ctx, new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageViewHelperKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SecondPageInteractListener.this.onCloseClicked();
            }
        });
        rootContainer.addView(closeView);
        SplashSecondPageInfo splashSecondPageInfo = splash.secondPage;
        if (splashSecondPageInfo != null) {
            z = true;
        }
        z = false;
        if (!z) {
            return;
        }
        final Ref.BooleanRef openSound = new Ref.BooleanRef();
        SplashSecondPageInfo splashSecondPageInfo2 = splash.secondPage;
        openSound.element = splashSecondPageInfo2 != null ? splashSecondPageInfo2.getOpenSound() : false;
        final ImageView soundBtn = SecondPageViewFactoryKt.generateSoundBtn(ctx, width, height, openSound.element);
        soundBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageViewHelperKt$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SecondPageViewHelperKt.addBasicLayer$lambda$1(openSound, soundBtn, ctx, listener, view2);
            }
        });
        rootContainer.addView(soundBtn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addBasicLayer$lambda$1(Ref.BooleanRef $openSound, ImageView $soundBtn, Context $ctx, SecondPageInteractListener $listener, View it) {
        $openSound.element = !$openSound.element;
        $soundBtn.setImageBitmap(SecondPageViewFactoryKt.generateSoundIcon($ctx, $openSound.element));
        $listener.onSoundClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addButtonLayer(Context context, SplashInteractView container, int width, int height, BaseSplash baseSplash, Splash splash, SecondPageInteractListener listener) {
        Context ctx = EnhancedUnmodifiabilityKt.unmodifiable(context);
        GuideButtonViewListInfo btnList = SecondPageViewFactoryKt.generateGuideButtonList(ctx, width, height, baseSplash, splash, listener);
        Iterable $this$forEach$iv = btnList.getViewList();
        for (Object element$iv : $this$forEach$iv) {
            View v = (View) element$iv;
            container.addView(v);
        }
        if (btnList.getDisableOutsideInteractiveView()) {
            container.setInteractEnable(false);
            SplashSecondPageInfo splashSecondPageInfo = splash.secondPage;
            if (splashSecondPageInfo != null) {
                splashSecondPageInfo.setLocalSecondPageButtonDegraded(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addSecondPageEasterEggVideoLayer(Context context, ViewGroup rootContainer, int width, int height, Splash splash, SplashActionType actionType, SplashAlphaPlayer secondEggVideoView, final SecondPageInteractListener listener) {
        List<SplashGuideButton> emptyList;
        Context ctx = EnhancedUnmodifiabilityKt.unmodifiable(context);
        final Ref.ObjectRef successBooking = new Ref.ObjectRef();
        final SplashSecondEggVideoView $this$addSecondPageEasterEggVideoLayer_u24lambda_u240 = new SplashSecondEggVideoView(ctx, null, 0, 6, null);
        $this$addSecondPageEasterEggVideoLayer_u24lambda_u240.setActionListener(new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageViewHelperKt$$ExternalSyntheticLambda4
            public final Object invoke() {
                Unit addSecondPageEasterEggVideoLayer$lambda$0$0;
                addSecondPageEasterEggVideoLayer$lambda$0$0 = SecondPageViewHelperKt.addSecondPageEasterEggVideoLayer$lambda$0$0(successBooking, listener, $this$addSecondPageEasterEggVideoLayer_u24lambda_u240);
                return addSecondPageEasterEggVideoLayer$lambda$0$0;
            }
        });
        $this$addSecondPageEasterEggVideoLayer_u24lambda_u240.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        SplashSecondPageInfo splashSecondPageInfo = splash.secondPage;
        if (splashSecondPageInfo == null || (emptyList = splashSecondPageInfo.getSecondPageButtons()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        $this$addSecondPageEasterEggVideoLayer_u24lambda_u240.setButtons(emptyList, width, height);
        $this$addSecondPageEasterEggVideoLayer_u24lambda_u240.setSplashSecondPageEggVideoPlayer(splash, secondEggVideoView);
        rootContainer.addView($this$addSecondPageEasterEggVideoLayer_u24lambda_u240);
        SplashLiveReserveHelper.handleLiveBooking(ctx, splash, actionType.toLiveReserveTriggerTypeValue().getValue(), false, new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageViewHelperKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit addSecondPageEasterEggVideoLayer$lambda$1;
                addSecondPageEasterEggVideoLayer$lambda$1 = SecondPageViewHelperKt.addSecondPageEasterEggVideoLayer$lambda$1(successBooking, ((Boolean) obj).booleanValue());
                return addSecondPageEasterEggVideoLayer$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addSecondPageEasterEggVideoLayer$lambda$0$0(Ref.ObjectRef $successBooking, SecondPageInteractListener $listener, SplashSecondEggVideoView $this_apply) {
        Boolean bool = (Boolean) $successBooking.element;
        if (bool != null) {
            boolean success = bool.booleanValue();
            ToastHelper.showToast($this_apply.getContext(), success ? "预约成功" : "预约失败", 0, 17);
        }
        $listener.onSecondPageEggVideoComplete();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addSecondPageEasterEggVideoLayer$lambda$1(Ref.ObjectRef $successBooking, boolean success) {
        $successBooking.element = Boolean.valueOf(success);
        return Unit.INSTANCE;
    }
}