package tv.danmaku.bili.splash.ad.page.component;

import android.animation.Animator;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.RealBannerRectUpdateAction;
import com.bilibili.lib.homepage.splash.actions.TopViewAnimationEndAction;
import com.bilibili.lib.homepage.splash.model.SplashState;
import com.bilibili.search.DefaultWordItem;
import com.bilibili.search.SplashSearchService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashTopViewType;
import tv.danmaku.bili.splash.ad.page.BannerSplash;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.page.FullImageSplash;
import tv.danmaku.bili.splash.ad.page.FullVideoSplash;
import tv.danmaku.bili.splash.ad.page.HalfImageSplash;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.page.PortVideoSplash;
import tv.danmaku.bili.splash.ad.player.SplashAlphaPlayer;
import tv.danmaku.bili.splash.ad.player.SplashBannerPlayer;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.utils.ui.BusinessSplashAnimatorHelperKt;
import tv.danmaku.bili.splash.ad.widget.DeliverySlideEventFrameLayout;
import tv.danmaku.bili.splash.ad.widget.SplashContainerView;
import tv.danmaku.bili.splash.ad.widget.SplashImageView;
import tv.danmaku.bili.splash.ad.widget.SplashInteractView;

/* compiled from: LinkageAnimationComponent.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u0002H\u0000\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\u0006*\u00020\u0002H\u0000\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0002H\u0000\u001a\u0014\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f*\u00020\u0002H\u0000\u001a\f\u0010\u0011\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0001*\u00020\u0002H\u0002\"\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"observerSplashLinkageAnimationState", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "tryDoExitSplashLinkageAnimation", "doLinkageTransform", "rect", "Landroid/graphics/Rect;", "getLinkageTargetRect", "getSearchLinkageRect", "setQueryItem", "jumped", "", "getLinkageAnimationTransformView", "Ltv/danmaku/bili/splash/ad/widget/SplashImageView;", "getLinkageAnimationAlphaView", "", "Landroid/view/View;", "prepareLinkageAnimationView", "doLaunchDanmakuExitAnimate", "TAG", "", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LinkageAnimationComponentKt {
    private static final String TAG = "[Splash]LinkageComponent";

    public static final void observerSplashLinkageAnimationState(BaseSplash $this$observerSplashLinkageAnimationState) {
        Intrinsics.checkNotNullParameter($this$observerSplashLinkageAnimationState, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$observerSplashLinkageAnimationState), (CoroutineContext) null, (CoroutineStart) null, new LinkageAnimationComponentKt$observerSplashLinkageAnimationState$1($this$observerSplashLinkageAnimationState, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryDoExitSplashLinkageAnimation(BaseSplash $this$tryDoExitSplashLinkageAnimation) {
        Rect rect = getLinkageTargetRect($this$tryDoExitSplashLinkageAnimation);
        BLog.i(TAG, "tryDoExitSplashLinkageAnimation, rect = " + rect);
        if (rect == null) {
            ISplashEvent.CC.exitSplash$default($this$tryDoExitSplashLinkageAnimation, false, null, null, 6, null);
            return;
        }
        setQueryItem($this$tryDoExitSplashLinkageAnimation, false);
        SplashViewModel.SplashExitInfo exitInfo = (SplashViewModel.SplashExitInfo) $this$tryDoExitSplashLinkageAnimation.getViewModel$adsplash_debug().getSplashExit().getValue();
        if (exitInfo == null) {
            exitInfo = new SplashViewModel.SplashExitInfo();
        }
        exitInfo.setAnimState(1);
        $this$tryDoExitSplashLinkageAnimation.getViewModel$adsplash_debug().getSplashExit().setValue(exitInfo);
        $this$tryDoExitSplashLinkageAnimation.getViewModel$adsplash_debug().update(new RealBannerRectUpdateAction((Rect) null));
        $this$tryDoExitSplashLinkageAnimation.getComponentHolder$adsplash_debug().setExecuteAnim(true);
        if (!$this$tryDoExitSplashLinkageAnimation.getSplash$adsplash_debug().getRuntimeExtra().isEggVideoPlayed()) {
            $this$tryDoExitSplashLinkageAnimation.getBinding$adsplash_debug().rootContainer.setBackground(new ColorDrawable(0));
        }
        prepareLinkageAnimationView($this$tryDoExitSplashLinkageAnimation);
        doLinkageTransform($this$tryDoExitSplashLinkageAnimation, rect);
    }

    private static final void doLinkageTransform(final BaseSplash $this$doLinkageTransform, final Rect rect) {
        final Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: tv.danmaku.bili.splash.ad.page.component.LinkageAnimationComponentKt$doLinkageTransform$animatorListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BLog.i("[Splash]LinkageComponent", "[Splash]mLinkageAnimatorListener, onAnimationStart");
                BaseSplash.this.getComponentHolder$adsplash_debug().setShowAnimator(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BLog.i("[Splash]LinkageComponent", "[Splash]mLinkageAnimatorListener, onAnimationEnd");
                BaseSplash.this.getComponentHolder$adsplash_debug().setShowAnimator(false);
                BaseSplash.this.getViewModel$adsplash_debug().update(new TopViewAnimationEndAction());
                ISplashEvent.CC.exitSplash$default(BaseSplash.this, false, null, null, 6, null);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        };
        final SplashImageView transformView = getLinkageAnimationTransformView($this$doLinkageTransform);
        final Function0 transformAction = new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.LinkageAnimationComponentKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit doLinkageTransform$lambda$0;
                doLinkageTransform$lambda$0 = LinkageAnimationComponentKt.doLinkageTransform$lambda$0(BaseSplash.this, transformView, rect, animatorListener);
                return doLinkageTransform$lambda$0;
            }
        };
        if (transformView.getWidth() > 0 && transformView.getHeight() > 0) {
            transformAction.invoke();
            return;
        }
        BLog.e(TAG, "[Splash]doLinkageTransform, transformView not ready, next post");
        transformView.post(new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.component.LinkageAnimationComponentKt$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                transformAction.invoke();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLinkageTransform$lambda$0(final BaseSplash $this_doLinkageTransform, SplashImageView $transformView, final Rect $rect, final Animator.AnimatorListener $animatorListener) {
        try {
            BLog.i(TAG, "[Splash]doLinkageTransform, transformAction invoke");
            if ($this_doLinkageTransform.getSplash$adsplash_debug().getTopViewType() == SplashTopViewType.LAUNCH_DANMAKU.getType()) {
                doLaunchDanmakuExitAnimate($this_doLinkageTransform);
            } else if (ExtSplashOrderKt.isSearchLinkage($this_doLinkageTransform.getSplash$adsplash_debug())) {
                BusinessSplashAnimatorHelperKt.doBusinessSplashSearchBarLinkageAnimation((ImageView) $transformView, $rect, getLinkageAnimationAlphaView($this_doLinkageTransform), $animatorListener);
            } else if ($this_doLinkageTransform.getSplash$adsplash_debug().getRuntimeExtra().isEggVideoPlayed()) {
                SplashContainerView splashContainerView = $this_doLinkageTransform.getBinding$adsplash_debug().rootContainer;
                Intrinsics.checkNotNullExpressionValue(splashContainerView, "rootContainer");
                BusinessSplashAnimatorHelperKt.doKeepRadioScaleAnimate((View) splashContainerView, (View) $transformView, $rect, $animatorListener);
            } else if ($this_doLinkageTransform.getSplash$adsplash_debug().getTopViewType() == SplashTopViewType.TV_CLOSE.getType()) {
                $this_doLinkageTransform.asyncGetLinkageTransformView(new Function1() { // from class: tv.danmaku.bili.splash.ad.page.component.LinkageAnimationComponentKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        Unit doLinkageTransform$lambda$0$0;
                        doLinkageTransform$lambda$0$0 = LinkageAnimationComponentKt.doLinkageTransform$lambda$0$0(BaseSplash.this, $rect, $animatorListener, (View) obj);
                        return doLinkageTransform$lambda$0$0;
                    }
                });
            } else if ($this_doLinkageTransform.getSplash$adsplash_debug().getTopViewType() == SplashTopViewType.BG_DISAPPEAR.getType()) {
                BusinessSplashAnimatorHelperKt.doBgDisappearAnimation((View) $transformView, getLinkageAnimationAlphaView($this_doLinkageTransform), $animatorListener);
            } else if ($this_doLinkageTransform.getSplash$adsplash_debug().getTopViewType() == SplashTopViewType.NONE.getType()) {
                ISplashEvent.CC.exitSplash$default($this_doLinkageTransform, false, null, null, 6, null);
            } else {
                BusinessSplashAnimatorHelperKt.doTopViewScaleAnimation((ImageView) $transformView, $rect, getLinkageAnimationAlphaView($this_doLinkageTransform), $animatorListener);
            }
        } catch (Exception e) {
            ISplashEvent.CC.exitSplash$default($this_doLinkageTransform, false, null, null, 6, null);
            CrashReporter.INSTANCE.postCaughtException(e);
            BLog.e(TAG, "do TopView anim error");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLinkageTransform$lambda$0$0(BaseSplash $this_doLinkageTransform, Rect $rect, Animator.AnimatorListener $animatorListener, View view) {
        if (view != null) {
            BusinessSplashAnimatorHelperKt.doTvCloseSplashAnimate(view, $rect, getLinkageAnimationAlphaView($this_doLinkageTransform), $animatorListener);
        }
        if (view == null) {
            ISplashEvent.CC.exitSplash$default($this_doLinkageTransform, false, null, null, 6, null);
        }
        return Unit.INSTANCE;
    }

    public static final Rect getLinkageTargetRect(BaseSplash $this$getLinkageTargetRect) {
        Intrinsics.checkNotNullParameter($this$getLinkageTargetRect, "<this>");
        Rect rect = null;
        if (ExtSplashOrderKt.isTopView($this$getLinkageTargetRect.getSplash$adsplash_debug()) || ExtSplashOrderKt.isSearchLinkage($this$getLinkageTargetRect.getSplash$adsplash_debug())) {
            if (ExtSplashOrderKt.isTopView($this$getLinkageTargetRect.getSplash$adsplash_debug()) && Intrinsics.areEqual(String.valueOf($this$getLinkageTargetRect.getSplash$adsplash_debug().getId()), ((SplashState) $this$getLinkageTargetRect.getViewModel$adsplash_debug().getState().getValue()).getRealShowTopViewId())) {
                Rect it = ((SplashState) $this$getLinkageTargetRect.getViewModel$adsplash_debug().getState().getValue()).getRealBannerRect();
                if (it != null) {
                    if (it.width() > 0 && it.height() > 0) {
                        rect = it;
                    }
                }
                if (rect != null) {
                    return rect;
                }
                SplashAdHelper.INSTANCE.reportSplashDefaultWordExpose$adsplash_debug($this$getLinkageTargetRect.getSplash$adsplash_debug(), 1);
                return rect;
            } else if (ExtSplashOrderKt.isSearchLinkage($this$getLinkageTargetRect.getSplash$adsplash_debug())) {
                return getSearchLinkageRect($this$getLinkageTargetRect);
            } else {
                return null;
            }
        }
        return null;
    }

    public static final Rect getSearchLinkageRect(BaseSplash $this$getSearchLinkageRect) {
        Intrinsics.checkNotNullParameter($this$getSearchLinkageRect, "<this>");
        Rect rect = null;
        if (ExtSplashOrderKt.isSearchLinkage($this$getSearchLinkageRect.getSplash$adsplash_debug())) {
            SplashSearchService splashSearchService = (SplashSearchService) BLRouter.INSTANCE.get(SplashSearchService.class, "SPLASH_SEARCH_SERVICE");
            boolean z = true;
            boolean isBrandShow = splashSearchService != null ? splashSearchService.isBrandSplashShow() : true;
            if (isBrandShow) {
                return null;
            }
            Rect it = (Rect) $this$getSearchLinkageRect.getViewModel$adsplash_debug().getSearchBarRect().getValue();
            if (it != null) {
                if ((it.width() <= 0 || it.height() <= 0) ? false : false) {
                    rect = it;
                }
            }
            if (rect == null) {
                SplashAdHelper.INSTANCE.reportSplashDefaultWordExpose$adsplash_debug($this$getSearchLinkageRect.getSplash$adsplash_debug(), 2);
            }
            return rect;
        }
        return null;
    }

    public static final void setQueryItem(BaseSplash $this$setQueryItem, boolean jumped) {
        Intrinsics.checkNotNullParameter($this$setQueryItem, "<this>");
        SplashSearchService searchService = (SplashSearchService) BLRouter.INSTANCE.get(SplashSearchService.class, "SPLASH_SEARCH_SERVICE");
        if (searchService == null || !ExtSplashOrderKt.isSearchLinkage($this$setQueryItem.getSplash$adsplash_debug()) || searchService.isBrandSplashShow()) {
            return;
        }
        DefaultWordItem wordItem = new DefaultWordItem();
        wordItem.setQuery($this$setQueryItem.getSplash$adsplash_debug().getKeyword());
        wordItem.setId($this$setQueryItem.getSplash$adsplash_debug().getId());
        wordItem.setDefaultWordType(jumped ? 3 : 2);
        searchService.getDefaultWordItem().setValue(wordItem);
        searchService.refreshDefaultWord().setValue(true);
        searchService.keepOnceRefreshLiveData().setValue(Boolean.valueOf(jumped));
        SplashAdHelper.INSTANCE.reportSplashDefaultWordExpose$adsplash_debug($this$setQueryItem.getSplash$adsplash_debug(), 0);
    }

    public static final SplashImageView getLinkageAnimationTransformView(BaseSplash $this$getLinkageAnimationTransformView) {
        Intrinsics.checkNotNullParameter($this$getLinkageAnimationTransformView, "<this>");
        SplashImageView splashImageView = $this$getLinkageAnimationTransformView.getBinding$adsplash_debug().splashView;
        Intrinsics.checkNotNullExpressionValue(splashImageView, "splashView");
        return splashImageView;
    }

    public static final List<View> getLinkageAnimationAlphaView(BaseSplash $this$getLinkageAnimationAlphaView) {
        Intrinsics.checkNotNullParameter($this$getLinkageAnimationAlphaView, "<this>");
        if (ExtSplashOrderKt.getHasSecondPageEggVideo($this$getLinkageAnimationAlphaView.getSplash$adsplash_debug())) {
            DeliverySlideEventFrameLayout deliverySlideEventFrameLayout = $this$getLinkageAnimationAlphaView.getBinding$adsplash_debug().splashButtonContainer;
            Intrinsics.checkNotNullExpressionValue(deliverySlideEventFrameLayout, "splashButtonContainer");
            SplashInteractView splashInteractView = $this$getLinkageAnimationAlphaView.getBinding$adsplash_debug().splashInteractView;
            Intrinsics.checkNotNullExpressionValue(splashInteractView, "splashInteractView");
            return CollectionsKt.listOf(new FrameLayout[]{deliverySlideEventFrameLayout, splashInteractView});
        }
        List viewList = CollectionsKt.mutableListOf(new View[]{ExperimentViewComponentKt.getCountdownView($this$getLinkageAnimationAlphaView), ExperimentViewComponentKt.getAdLabelView($this$getLinkageAnimationAlphaView), $this$getLinkageAnimationAlphaView.getBinding$adsplash_debug().logo, $this$getLinkageAnimationAlphaView.getBinding$adsplash_debug().splashButtonContainer, $this$getLinkageAnimationAlphaView.getBinding$adsplash_debug().splashInteractView, $this$getLinkageAnimationAlphaView.getBinding$adsplash_debug().logoLayout});
        if ($this$getLinkageAnimationAlphaView instanceof FullVideoSplash) {
            if ($this$getLinkageAnimationAlphaView.getSplash$adsplash_debug().getRuntimeExtra().isEggVideoPlayed() || $this$getLinkageAnimationAlphaView.getComponentHolder$adsplash_debug().getTopViewTransitionCanPlay()) {
                viewList.add(((FullVideoSplash) $this$getLinkageAnimationAlphaView).getVideoContainerView$adsplash_debug());
            }
        } else if ($this$getLinkageAnimationAlphaView instanceof HalfImageSplash) {
            viewList.add($this$getLinkageAnimationAlphaView.getComponentHolder$adsplash_debug().getHalfCustomButtonLayer());
        } else if (($this$getLinkageAnimationAlphaView instanceof BannerSplash) && $this$getLinkageAnimationAlphaView.getSplash$adsplash_debug().getTopViewType() == SplashTopViewType.TV_CLOSE.getType()) {
            SplashBannerPlayer bannerPlayer = ((BannerSplash) $this$getLinkageAnimationAlphaView).getBannerPlayer();
            viewList.add(bannerPlayer != null ? bannerPlayer.getContainer() : null);
        }
        return viewList;
    }

    private static final void prepareLinkageAnimationView(BaseSplash $this$prepareLinkageAnimationView) {
        SplashAlphaPlayer eggPlayer;
        final TextureView videoContainer;
        final TextureView videoContainer2;
        SplashAlphaPlayer eggPlayer2;
        final TextureView videoContainer3;
        ViewGroup.LayoutParams $this$prepareLinkageAnimationView_u24lambda_u240 = null;
        if ($this$prepareLinkageAnimationView instanceof FullImageSplash) {
            if (!$this$prepareLinkageAnimationView.getSplash$adsplash_debug().getRuntimeExtra().isEggVideoPlayed() || (eggPlayer2 = $this$prepareLinkageAnimationView.getComponentHolder$adsplash_debug().getEggPlayer()) == null || (videoContainer3 = eggPlayer2.getTextureView()) == null) {
                return;
            }
            SplashImageView splashView = $this$prepareLinkageAnimationView.getBinding$adsplash_debug().splashView;
            Intrinsics.checkNotNullExpressionValue(splashView, "splashView");
            ViewGroup.LayoutParams layoutParams = splashView.getLayoutParams();
            if (layoutParams != null) {
                $this$prepareLinkageAnimationView_u24lambda_u240 = layoutParams;
                $this$prepareLinkageAnimationView_u24lambda_u240.height = videoContainer3.getLayoutParams().height;
            }
            splashView.setLayoutParams($this$prepareLinkageAnimationView_u24lambda_u240);
            splashView.setImageBitmap(videoContainer3.getBitmap());
            splashView.setVisibility(0);
            splashView.post(new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.component.LinkageAnimationComponentKt$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    videoContainer3.setVisibility(8);
                }
            });
        } else if ($this$prepareLinkageAnimationView instanceof FullVideoSplash) {
            if ($this$prepareLinkageAnimationView.getSplash$adsplash_debug().getRuntimeExtra().isEggVideoPlayed() && $this$prepareLinkageAnimationView.getComponentHolder$adsplash_debug().getEggPlayer() != null) {
                SplashAlphaPlayer eggPlayer3 = $this$prepareLinkageAnimationView.getComponentHolder$adsplash_debug().getEggPlayer();
                videoContainer2 = eggPlayer3 != null ? eggPlayer3.getTextureView() : null;
            } else {
                videoContainer2 = ((FullVideoSplash) $this$prepareLinkageAnimationView).getVideoContainerView$adsplash_debug();
            }
            if (videoContainer2 == null) {
                return;
            }
            SplashImageView splashView2 = $this$prepareLinkageAnimationView.getBinding$adsplash_debug().splashView;
            Intrinsics.checkNotNullExpressionValue(splashView2, "splashView");
            ViewGroup.LayoutParams layoutParams2 = splashView2.getLayoutParams();
            if (layoutParams2 != null) {
                $this$prepareLinkageAnimationView_u24lambda_u240 = layoutParams2;
                $this$prepareLinkageAnimationView_u24lambda_u240.height = videoContainer2.getHeight();
            }
            splashView2.setLayoutParams($this$prepareLinkageAnimationView_u24lambda_u240);
            splashView2.setImageBitmap(videoContainer2.getBitmap());
            splashView2.setVisibility(0);
            splashView2.post(new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.component.LinkageAnimationComponentKt$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    videoContainer2.setVisibility(8);
                }
            });
        } else if ($this$prepareLinkageAnimationView instanceof PortVideoSplash) {
            final TextureView videoContainer4 = ((PortVideoSplash) $this$prepareLinkageAnimationView).getVideoContainerView$adsplash_debug();
            if (videoContainer4 == null) {
                return;
            }
            SplashImageView splashView3 = $this$prepareLinkageAnimationView.getBinding$adsplash_debug().splashView;
            Intrinsics.checkNotNullExpressionValue(splashView3, "splashView");
            ViewGroup.LayoutParams layoutParams3 = splashView3.getLayoutParams();
            if (layoutParams3 != null) {
                $this$prepareLinkageAnimationView_u24lambda_u240 = layoutParams3;
                $this$prepareLinkageAnimationView_u24lambda_u240.height = videoContainer4.getLayoutParams().height;
            }
            splashView3.setLayoutParams($this$prepareLinkageAnimationView_u24lambda_u240);
            splashView3.setImageBitmap(videoContainer4.getBitmap());
            splashView3.setVisibility(0);
            splashView3.post(new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.component.LinkageAnimationComponentKt$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    videoContainer4.setVisibility(8);
                }
            });
        } else if (!($this$prepareLinkageAnimationView instanceof HalfImageSplash) || !$this$prepareLinkageAnimationView.getSplash$adsplash_debug().getRuntimeExtra().isEggVideoPlayed() || (eggPlayer = $this$prepareLinkageAnimationView.getComponentHolder$adsplash_debug().getEggPlayer()) == null || (videoContainer = eggPlayer.getTextureView()) == null) {
        } else {
            SplashImageView splashView4 = $this$prepareLinkageAnimationView.getBinding$adsplash_debug().splashView;
            Intrinsics.checkNotNullExpressionValue(splashView4, "splashView");
            ViewGroup.LayoutParams layoutParams4 = splashView4.getLayoutParams();
            if (layoutParams4 != null) {
                $this$prepareLinkageAnimationView_u24lambda_u240 = layoutParams4;
                $this$prepareLinkageAnimationView_u24lambda_u240.height = videoContainer.getLayoutParams().height;
            }
            splashView4.setLayoutParams($this$prepareLinkageAnimationView_u24lambda_u240);
            splashView4.setImageBitmap(videoContainer.getBitmap());
            splashView4.setVisibility(0);
            splashView4.post(new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.component.LinkageAnimationComponentKt$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    videoContainer.setVisibility(8);
                }
            });
        }
    }

    private static final void doLaunchDanmakuExitAnimate(BaseSplash $this$doLaunchDanmakuExitAnimate) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $this$doLaunchDanmakuExitAnimate), (CoroutineContext) null, (CoroutineStart) null, new LinkageAnimationComponentKt$doLaunchDanmakuExitAnimate$1($this$doLaunchDanmakuExitAnimate, null), 3, (Object) null);
    }
}