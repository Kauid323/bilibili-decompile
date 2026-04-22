package tv.danmaku.bili.splash.ad.page.secondpage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.OneShotPreDrawListener;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.business.livereserve.LiveReserveTriggerType;
import tv.danmaku.bili.splash.ad.business.livereserve.LiveReserveTriggerTypeKt;
import tv.danmaku.bili.splash.ad.business.livereserve.SplashLiveReserveHelper;
import tv.danmaku.bili.splash.ad.button.model.GuideButtonViewListInfo;
import tv.danmaku.bili.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashSecondPageInfo;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.page.FullVideoSplash;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.page.component.LinkageAnimationComponentKt;
import tv.danmaku.bili.splash.ad.player.SplashAlphaPlayer;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelperKt;
import tv.danmaku.bili.splash.ad.utils.SplashUtilsKt;
import tv.danmaku.bili.splash.ad.utils.UiUtilsKt;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutHelperKt;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutUtilsKt;
import tv.danmaku.bili.splash.ad.widget.SplashContainerView;
import tv.danmaku.bili.splash.ad.widget.SplashInteractView;
import tv.danmaku.bili.splash.ad.widget.SplashSecondEggVideoView;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: SecondPageComponent.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0004H\u0000\u001a(\u0010\t\u001a\u00020\u0003*\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a(\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0000\u001a(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002\u001a<\u0010\u001c\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002\u001a<\u0010 \u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002\u001aJ\u0010\"\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000\u001a\f\u0010#\u001a\u00020\b*\u00020\u0004H\u0000\u001a\f\u0010$\u001a\u00020\u0003*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"TAG", "", "onTriggerSecondPage", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "actionType", "Ltv/danmaku/bili/splash/ad/button/model/SplashActionType;", "canShowSecondPage", "", "showSecondPage", "rootContainer", "Landroid/view/ViewGroup;", "secondEggVideoView", "Ltv/danmaku/bili/splash/ad/player/SplashAlphaPlayer;", "firstPageElementDisappear", "viewList", "", "Landroid/view/View;", "onEnd", "Lkotlin/Function0;", "addInteractLayer", "Ltv/danmaku/bili/splash/ad/widget/SplashInteractView;", "ctx", "Landroid/content/Context;", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "listener", "Ltv/danmaku/bili/splash/ad/page/secondpage/SecondPageInteractListener;", "addBasicLayer", "width", "", "height", "addButtonLayer", "container", "addSecondPageEasterEggVideoLayer", "canShowSecondPageForSecondPageEggVideo", "preloadSecondPageEggVideo", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SecondPageComponentKt {
    private static final String TAG = "[Splash]SecondPageComponent";

    public static final void onTriggerSecondPage(BaseSplash $this$onTriggerSecondPage, SplashActionType actionType) {
        IjkMediaPlayer player$adsplash_debug;
        Intrinsics.checkNotNullParameter($this$onTriggerSecondPage, "<this>");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        if ($this$onTriggerSecondPage instanceof FullVideoSplash) {
            if ($this$onTriggerSecondPage.getComponentHolder$adsplash_debug().getSecondPageEggVideoPlayer() != null && (player$adsplash_debug = ((FullVideoSplash) $this$onTriggerSecondPage).getPlayer$adsplash_debug()) != null) {
                player$adsplash_debug.pause();
            }
            ((FullVideoSplash) $this$onTriggerSecondPage).setSecondPageVolume();
        }
        firstPageElementDisappear$default(LinkageAnimationComponentKt.getLinkageAnimationAlphaView($this$onTriggerSecondPage), null, 2, null);
        $this$onTriggerSecondPage.getComponentHolder$adsplash_debug().setSecondPageTriggered(true);
        $this$onTriggerSecondPage.stopCountdown();
        $this$onTriggerSecondPage.getBinding$adsplash_debug().splashInteractView.setVisibility(8);
        showSecondPage($this$onTriggerSecondPage, $this$onTriggerSecondPage.getBinding$adsplash_debug().splashSecondPageContainer, $this$onTriggerSecondPage.getComponentHolder$adsplash_debug().getSecondPageEggVideoPlayer(), actionType);
        SplashAdHelper.INSTANCE.reportSecondPageVideoShowSuccess$adsplash_debug($this$onTriggerSecondPage.getSplash$adsplash_debug());
    }

    public static final boolean canShowSecondPage(BaseSplash $this$canShowSecondPage) {
        Intrinsics.checkNotNullParameter($this$canShowSecondPage, "<this>");
        return !$this$canShowSecondPage.getComponentHolder$adsplash_debug().isSecondPageTriggered() && ($this$canShowSecondPage.getSplash$adsplash_debug().getSecondPageShowStyle() == 1 || canShowSecondPageForSecondPageEggVideo($this$canShowSecondPage));
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt$showSecondPage$listener$1] */
    public static final void showSecondPage(final BaseSplash $this$showSecondPage, final ViewGroup rootContainer, final SplashAlphaPlayer secondEggVideoView, final SplashActionType actionType) {
        final Context ctx;
        Intrinsics.checkNotNullParameter($this$showSecondPage, "<this>");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        final Function0 handleSoundClick = new Function0() { // from class: tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt$$ExternalSyntheticLambda5
            public final Object invoke() {
                Unit showSecondPage$lambda$0;
                showSecondPage$lambda$0 = SecondPageComponentKt.showSecondPage$lambda$0(BaseSplash.this);
                return showSecondPage$lambda$0;
            }
        };
        final ?? r7 = new SecondPageInteractListener() { // from class: tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt$showSecondPage$listener$1
            @Override // tv.danmaku.bili.splash.ad.page.secondpage.SecondPageInteractListener
            public void onCloseClicked() {
                SplashAdHelper.INSTANCE.reportSecondPageVideoClose$adsplash_debug(BaseSplash.this.getSplash$adsplash_debug());
                ISplashEvent.CC.exitSplash$default(BaseSplash.this, false, null, null, 6, null);
            }

            @Override // tv.danmaku.bili.splash.ad.page.secondpage.SecondPageInteractListener
            public void onSoundClicked() {
                handleSoundClick.invoke();
            }

            @Override // tv.danmaku.bili.splash.ad.page.secondpage.SecondPageInteractListener
            public void onSecondPageEggVideoComplete() {
                ISplashEvent.CC.onPageJump$default(BaseSplash.this, true, "4", null, 4, null);
            }

            @Override // tv.danmaku.bili.splash.ad.button.model.SplashButtonClickListener
            public void onClick(SplashGuideButton splashGuideButton) {
                Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
                Intent intent = SplashUtilsKt.buildThirdIntent(BaseSplash.this.getSplash$adsplash_debug(), splashGuideButton.getSchema(), splashGuideButton.getSchemaPackageName());
                SplashAdHelper.INSTANCE.reportSecondPageVideoJump$adsplash_debug(BaseSplash.this.getSplash$adsplash_debug(), "0");
                ISplashEvent.CC.onJumpClick$default(BaseSplash.this, intent, splashGuideButton.getSchema(), splashGuideButton.getJumpUrl(), false, SplashActionType.BUTTON, false, String.valueOf(splashGuideButton.getId()), null, BR.displayingBanner, null);
            }

            @Override // tv.danmaku.bili.splash.ad.widget.SplashInteractView.InteractListener
            public void onScroll(float length, int angle) {
                SplashSecondPageInfo secondPage;
                if (length <= 0.0f || BaseSplash.this.getSplash$adsplash_debug().getSecondPage() == null) {
                    return;
                }
                SplashSecondPageInfo secondPage2 = BaseSplash.this.getSplash$adsplash_debug().getSecondPage();
                boolean isValidAngle = false;
                if (!(secondPage2 != null && secondPage2.getInteractStyle() == 2) || (secondPage = BaseSplash.this.getSplash$adsplash_debug().getSecondPage()) == null) {
                    return;
                }
                int triggerDistance = secondPage.getSecondSlideDistance();
                BLog.i("[Splash]SecondPageComponent", "onScroll, length = " + UiUtilsKt.getPxToDp(length) + ", angle = " + angle + ", length limit = " + triggerDistance + ", angle limit = " + BaseSplash.this.getSplash$adsplash_debug().getInteractAngle());
                SplashAdHelper.INSTANCE.reportSplashInteract$adsplash_debug(BaseSplash.this.getSplash$adsplash_debug(), UiUtilsKt.getPxToDp(length), triggerDistance, angle, BaseSplash.this.getSplash$adsplash_debug().getInteractAngle());
                if (BaseSplash.this.getSplash$adsplash_debug().getInteractAngle() <= 0 || angle <= BaseSplash.this.getSplash$adsplash_debug().getInteractAngle()) {
                    isValidAngle = true;
                }
                if (length <= ListExtentionsKt.toPx(triggerDistance) || !isValidAngle) {
                    SplashAdHelper.INSTANCE.adSplashSlideFail$adsplash_debug(BaseSplash.this.getSplash$adsplash_debug(), "splash_second");
                } else {
                    BaseSplash.this.onPageJump(true, "3", BaseSplash.this.getSplash$adsplash_debug().getSecondPageShowStyle() == 3 ? null : LiveReserveTriggerType.SLIDE);
                }
            }

            @Override // tv.danmaku.bili.splash.ad.widget.SplashInteractView.InteractListener
            public void onInteractLayerClicked() {
                SplashSecondPageInfo secondPage = BaseSplash.this.getSplash$adsplash_debug().getSecondPage();
                boolean z = false;
                if (secondPage != null && secondPage.getInteractStyle() == 1) {
                    z = true;
                }
                if (z && !BaseSplash.this.getSplash$adsplash_debug().getRuntimeExtra().getLocalSecondPageButtonDegraded()) {
                    BaseSplash.this.onPageJump(true, "1", BaseSplash.this.getSplash$adsplash_debug().getSecondPageShowStyle() == 3 ? null : LiveReserveTriggerType.CLICK);
                }
            }
        };
        if (rootContainer != null && (ctx = rootContainer.getContext()) != null) {
            rootContainer.setVisibility(0);
            final ViewGroup $this$doOnPreDraw$iv = rootContainer;
            OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt$showSecondPage$lambda$1$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    SplashInteractView interactView;
                    View view = $this$doOnPreDraw$iv;
                    int width = rootContainer.getWidth();
                    int height = rootContainer.getHeight();
                    rootContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt$showSecondPage$1$1$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View it) {
                        }
                    });
                    if ($this$showSecondPage.getSplash$adsplash_debug().getSecondPageShowStyle() != 3) {
                        interactView = SecondPageComponentKt.addInteractLayer(ctx, rootContainer, $this$showSecondPage.getSplash$adsplash_debug(), r7);
                        SecondPageComponentKt.addButtonLayer($this$showSecondPage, ctx, interactView, width, height, $this$showSecondPage.getSplash$adsplash_debug(), r7);
                        SecondPageComponentKt.addBasicLayer($this$showSecondPage, ctx, rootContainer, width, height, $this$showSecondPage.getSplash$adsplash_debug(), r7);
                        return;
                    }
                    SecondPageComponentKt.addSecondPageEasterEggVideoLayer(ctx, rootContainer, width, height, $this$showSecondPage.getSplash$adsplash_debug(), actionType, secondEggVideoView, r7);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showSecondPage$lambda$0(BaseSplash $this_showSecondPage) {
        FullVideoSplash fullVideoSplash = $this_showSecondPage instanceof FullVideoSplash ? (FullVideoSplash) $this_showSecondPage : null;
        if (fullVideoSplash != null) {
            fullVideoSplash.onSoundButtonClicked();
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void firstPageElementDisappear$default(List list, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        firstPageElementDisappear(list, function0);
    }

    public static final void firstPageElementDisappear(final List<? extends View> list, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(list, "viewList");
        Intrinsics.checkNotNullParameter(function0, "onEnd");
        ValueAnimator alphaAnimator = ObjectAnimator.ofFloat(1.0f, 0.0f);
        alphaAnimator.setDuration(200L);
        alphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt$$ExternalSyntheticLambda6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SecondPageComponentKt.firstPageElementDisappear$lambda$1(list, valueAnimator);
            }
        });
        Intrinsics.checkNotNull(alphaAnimator);
        ValueAnimator $this$addListener_u24default$iv = alphaAnimator;
        $this$addListener_u24default$iv.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt$firstPageElementDisappear$$inlined$addListener$default$1
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
    public static final SplashInteractView addInteractLayer(Context ctx, ViewGroup rootContainer, SplashOrder splash, SecondPageInteractListener listener) {
        SplashSecondPageInfo secondPage = splash.getSecondPage();
        Integer interactStyle = secondPage != null ? Integer.valueOf(secondPage.getInteractStyle()) : null;
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
    public static final void addBasicLayer(BaseSplash $this$addBasicLayer, final Context ctx, ViewGroup rootContainer, int width, int height, SplashOrder splash, final SecondPageInteractListener listener) {
        ImageView closeView = SecondPageViewFactoryKt.generateCloseBtn(ctx, new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPageInteractListener.this.onCloseClicked();
            }
        });
        rootContainer.addView(closeView);
        SplashSecondPageInfo secondPage = splash.getSecondPage();
        boolean z = false;
        if (secondPage != null && secondPage.getShowSoundButton()) {
            z = true;
        }
        if (!z) {
            return;
        }
        final Ref.BooleanRef openSound = new Ref.BooleanRef();
        openSound.element = $this$addBasicLayer.getComponentHolder$adsplash_debug().getOpenSound();
        final ImageView soundBtn = SecondPageViewFactoryKt.generateSoundBtn(ctx, width, height, openSound.element);
        soundBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPageComponentKt.addBasicLayer$lambda$1(openSound, soundBtn, ctx, listener, view);
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
    public static final void addButtonLayer(BaseSplash $this$addButtonLayer, Context ctx, SplashInteractView container, int width, int height, SplashOrder splash, SecondPageInteractListener listener) {
        GuideButtonViewListInfo btnList = SecondPageViewFactoryKt.generateGuideButtonList(ctx, width, height, $this$addButtonLayer, splash, listener);
        Iterable $this$forEach$iv = btnList.getViewList();
        for (Object element$iv : $this$forEach$iv) {
            View v = (View) element$iv;
            container.addView(v);
        }
        if (btnList.getDisableOutsideInteractiveView()) {
            container.setInteractEnable(false);
            splash.getRuntimeExtra().setLocalSecondPageButtonDegraded(true);
        }
    }

    public static final void addSecondPageEasterEggVideoLayer(Context ctx, ViewGroup rootContainer, int width, int height, SplashOrder splash, SplashActionType actionType, SplashAlphaPlayer secondEggVideoView, final SecondPageInteractListener listener) {
        List<SplashGuideButton> emptyList;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(rootContainer, "rootContainer");
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final Ref.ObjectRef successBooking = new Ref.ObjectRef();
        SplashSecondEggVideoView $this$addSecondPageEasterEggVideoLayer_u24lambda_u240 = new SplashSecondEggVideoView(ctx, null, 0, 6, null);
        $this$addSecondPageEasterEggVideoLayer_u24lambda_u240.setLayoutParams(SplashLayoutHelperKt.createPinkHdCompatFullscreenVideoLayoutParams(rootContainer, splash));
        int containerWidth = $this$addSecondPageEasterEggVideoLayer_u24lambda_u240.getLayoutParams().width > 0 ? $this$addSecondPageEasterEggVideoLayer_u24lambda_u240.getLayoutParams().width : width;
        SplashSecondPageInfo secondPage = splash.getSecondPage();
        if (secondPage == null || (emptyList = secondPage.getSecondPageButtons()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        $this$addSecondPageEasterEggVideoLayer_u24lambda_u240.setButtons(emptyList, containerWidth, height);
        $this$addSecondPageEasterEggVideoLayer_u24lambda_u240.setSplashSecondPageEggVideoPlayer(splash, secondEggVideoView);
        $this$addSecondPageEasterEggVideoLayer_u24lambda_u240.setCompleteListener(new Function0() { // from class: tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit addSecondPageEasterEggVideoLayer$lambda$0$0;
                addSecondPageEasterEggVideoLayer$lambda$0$0 = SecondPageComponentKt.addSecondPageEasterEggVideoLayer$lambda$0$0(successBooking, listener);
                return addSecondPageEasterEggVideoLayer$lambda$0$0;
            }
        });
        rootContainer.addView($this$addSecondPageEasterEggVideoLayer_u24lambda_u240);
        SplashLiveReserveHelper.INSTANCE.handleLiveBooking(ctx, splash, LiveReserveTriggerTypeKt.getToLiveReserveTriggerType(actionType).getValue(), false, new Function1() { // from class: tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit addSecondPageEasterEggVideoLayer$lambda$1;
                addSecondPageEasterEggVideoLayer$lambda$1 = SecondPageComponentKt.addSecondPageEasterEggVideoLayer$lambda$1(successBooking, ((Boolean) obj).booleanValue());
                return addSecondPageEasterEggVideoLayer$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addSecondPageEasterEggVideoLayer$lambda$0$0(Ref.ObjectRef $successBooking, SecondPageInteractListener $listener) {
        Boolean bool = (Boolean) $successBooking.element;
        if (bool != null) {
            boolean success = bool.booleanValue();
            ToastHelper.showToast(BiliContext.application(), success ? "预约成功" : "预约失败", 0, 17);
        }
        $listener.onSecondPageEggVideoComplete();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addSecondPageEasterEggVideoLayer$lambda$1(Ref.ObjectRef $successBooking, boolean success) {
        $successBooking.element = Boolean.valueOf(success);
        return Unit.INSTANCE;
    }

    public static final boolean canShowSecondPageForSecondPageEggVideo(BaseSplash $this$canShowSecondPageForSecondPageEggVideo) {
        Intrinsics.checkNotNullParameter($this$canShowSecondPageForSecondPageEggVideo, "<this>");
        if (ExtSplashOrderKt.getHasSecondPageEggVideo($this$canShowSecondPageForSecondPageEggVideo.getSplash$adsplash_debug()) && $this$canShowSecondPageForSecondPageEggVideo.getComponentHolder$adsplash_debug().getSecondPageEggVideoPlayer() == null) {
            SplashAdHelper.INSTANCE.reportSplashSecondPageEggShowFail($this$canShowSecondPageForSecondPageEggVideo.getSplash$adsplash_debug(), 1);
            return false;
        }
        return ExtSplashOrderKt.getHasSecondPageEggVideo($this$canShowSecondPageForSecondPageEggVideo.getSplash$adsplash_debug());
    }

    public static final void preloadSecondPageEggVideo(BaseSplash $this$preloadSecondPageEggVideo) {
        Context ctx;
        Intrinsics.checkNotNullParameter($this$preloadSecondPageEggVideo, "<this>");
        if (($this$preloadSecondPageEggVideo.getSplash$adsplash_debug().getCardType() == 39 || $this$preloadSecondPageEggVideo.getSplash$adsplash_debug().getCardType() == 14) && ExtSplashOrderKt.getHasSecondPageEggVideo($this$preloadSecondPageEggVideo.getSplash$adsplash_debug())) {
            SplashSecondPageInfo secondPage = $this$preloadSecondPageEggVideo.getSplash$adsplash_debug().getSecondPage();
            File file = BusinessSplashResHelperKt.fetchResourceFileByHash(secondPage != null ? secondPage.getSecondVideoHash() : null);
            if (file == null || (ctx = $this$preloadSecondPageEggVideo.getContext()) == null) {
                return;
            }
            $this$preloadSecondPageEggVideo.getComponentHolder$adsplash_debug().setSecondPageEggVideoPlayer(new SplashAlphaPlayer(ctx, null, 0, BusinessSplashDefine.FILE_URI_PREFIX + file.getAbsolutePath(), null, null, null, null, 192, null));
            SplashAlphaPlayer secondPageEggVideoPlayer = $this$preloadSecondPageEggVideo.getComponentHolder$adsplash_debug().getSecondPageEggVideoPlayer();
            if (secondPageEggVideoPlayer != null) {
                SplashContainerView root = $this$preloadSecondPageEggVideo.getBinding$adsplash_debug().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                secondPageEggVideoPlayer.setLayoutParams(SplashLayoutUtilsKt.createMatchParentLayoutParams((ViewGroup) root));
            }
        }
    }
}