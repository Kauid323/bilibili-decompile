package tv.danmaku.bili.ui.splash.ad.button;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.LottieComposition;
import com.bilibili.commonanim.elementanim.widget.BezierElementAnimationContainerView;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.image2.view.IGenericProperties;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.button.card.SplashButtonTwistBrandCardKt;
import tv.danmaku.bili.ui.splash.ad.button.card.SplashCountdownV2CardKt;
import tv.danmaku.bili.ui.splash.ad.button.card.SplashShopButtonCardKt;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonMaterialType;
import tv.danmaku.bili.ui.splash.ad.button.widget.SafeLottieAnimationView;
import tv.danmaku.bili.ui.splash.ad.button.widget.SafeLottieCompositionFactory;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.ui.splash.ad.config.LowerPhoneConfigKt;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.ui.splash.ad.model.BezierAnimationElement;
import tv.danmaku.bili.ui.splash.ad.model.BezierAnimationElementKt;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashElementAnimation;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper;
import tv.danmaku.bili.ui.splash.ad.util.SplashStateStorageHelperKt;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashButtonFactory.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u001a:\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a2\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a:\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a8\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a:\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"createSplashButtonByInteractStyle", "Landroid/view/View;", "context", "Landroid/content/Context;", "screenWidth", "", "screenHeight", "buttonData", "Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "listener", "Ltv/danmaku/bili/ui/splash/ad/button/model/SplashButtonClickListener;", "createSplashElementAnimationView", "createGuideButtonViewByMaterialType", "createDynamicImageView", "createLottieView", "TAG", "", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashButtonFactoryKt {
    private static final String TAG = "[Splash]SplashButtonFactory";

    public static final View createSplashButtonByInteractStyle(Context context, int screenWidth, int screenHeight, SplashGuideButton buttonData, Splash splash, SplashButtonClickListener listener) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(buttonData, "buttonData");
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(listener, "listener");
        switch (buttonData.getInteractStyle()) {
            case 12:
            case 13:
                return SplashButtonTwistBrandCardKt.createSplashButtonTwistBrandCard(context2, screenWidth, screenHeight, buttonData, splash, listener);
            case 14:
                return SplashCountdownV2CardKt.createSplashCountdownV2Card(context2, screenWidth, screenHeight, buttonData);
            case 21:
            case 22:
                return SplashShopButtonCardKt.createSplashShopButtonCard(context2, screenWidth, screenHeight, buttonData, splash, listener);
            default:
                return null;
        }
    }

    public static final View createSplashElementAnimationView(Context context, int screenWidth, int screenHeight, Splash splash, final SplashButtonClickListener listener) {
        Iterable it;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(listener, "listener");
        SplashElementAnimation splashElementAnimation = splash.elementAnimation;
        View view2 = null;
        if (splashElementAnimation != null && (it = splashElementAnimation.getAnimationList()) != null) {
            if (((Collection) it).isEmpty()) {
                it = null;
            }
            if (it != null) {
                Iterable list = it;
                if (LowerPhoneConfigKt.isInLowerPerformancePhoneList() && !splash.isHotSplash) {
                    SplashAdHelper.INSTANCE.reportSplashClickableEggShowFailed$splash_debug(splash, "2");
                    return null;
                }
                View bezierElementAnimationContainerView = new BezierElementAnimationContainerView(context2, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
                Function0 clk = new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonFactoryKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit createSplashElementAnimationView$lambda$1$0;
                        createSplashElementAnimationView$lambda$1$0 = SplashButtonFactoryKt.createSplashElementAnimationView$lambda$1$0(SplashButtonClickListener.this);
                        return createSplashElementAnimationView$lambda$1$0;
                    }
                };
                Iterable $this$map$iv = list;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    destination$iv$iv.add(BezierAnimationElementKt.getToElement((BezierAnimationElement) item$iv$iv));
                }
                boolean success = BezierElementAnimationContainerView.initAnimation$default(bezierElementAnimationContainerView, (List) destination$iv$iv, screenWidth, screenHeight, SplashConfigKt.getSplashSurpriseRainClickable() ? clk : null, (Function1) null, 16, (Object) null);
                if (success) {
                    SplashAdHelper.INSTANCE.reportSplashClickableEggShow$splash_debug(splash);
                    if (bezierElementAnimationContainerView.isClickGuideShowed()) {
                        SplashStateStorageHelperKt.setClickGuideShowCountOfElementAnimation(SplashStateStorageHelperKt.getClickGuideShowCountOfElementAnimation() + 1);
                    }
                    view2 = bezierElementAnimationContainerView;
                } else {
                    SplashAdHelper.reportSplashClickableEggShowFailed$splash_debug$default(SplashAdHelper.INSTANCE, splash, null, 2, null);
                }
                return view2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createSplashElementAnimationView$lambda$1$0(SplashButtonClickListener $listener) {
        $listener.onElementClick();
        return Unit.INSTANCE;
    }

    public static final View createGuideButtonViewByMaterialType(Context context, Splash splash, SplashGuideButton buttonData, int screenWidth, int screenHeight, SplashButtonClickListener listener) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(buttonData, "buttonData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        int guideMaterialType = buttonData.getGuideMaterialType();
        if (guideMaterialType == SplashButtonMaterialType.LOTTIE.getType()) {
            return createLottieView(context2, splash, buttonData, screenWidth, screenHeight, listener);
        }
        if (guideMaterialType == SplashButtonMaterialType.IMAGE.getType()) {
            return createDynamicImageView(context2, splash, buttonData, screenWidth, screenHeight, listener);
        }
        return null;
    }

    private static final View createDynamicImageView(Context context, final Splash splash, final SplashGuideButton buttonData, int screenWidth, int screenHeight, final SplashButtonClickListener listener) {
        final Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        int viewWidth = (int) (screenWidth * buttonData.getWidthPercent());
        int viewHeight = (int) (screenHeight * buttonData.getHeightPercent());
        float viewCenterX = screenWidth * buttonData.getXPercent();
        float viewCenterY = screenHeight * buttonData.getYPercent();
        FrameLayout rootView = new FrameLayout(context2);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(viewWidth, viewHeight);
        rootView.setX(viewCenterX - (viewWidth / 2));
        rootView.setY(viewCenterY - (viewHeight / 2));
        rootView.setLayoutParams(layoutParams);
        final BiliImageView dynamicImageView = new BiliImageView(context2);
        IGenericProperties genericProperties = dynamicImageView.getGenericProperties();
        ScaleType scaleType = ScaleType.FIT_CENTER;
        Intrinsics.checkNotNullExpressionValue(scaleType, "FIT_CENTER");
        genericProperties.setActualImageScaleType(scaleType);
        dynamicImageView.setLayoutParams(new ViewGroup.LayoutParams(viewWidth, viewHeight));
        rootView.addView((View) dynamicImageView);
        dynamicImageView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonFactoryKt$createDynamicImageView$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                String filePath;
                Object obj;
                Intrinsics.checkNotNullParameter(v, "v");
                File fetchResourceFileByHash = BusinessSplashResHelper.fetchResourceFileByHash(SplashGuideButton.this.getActualUsedImageHash());
                if (fetchResourceFileByHash == null || (filePath = fetchResourceFileByHash.getAbsolutePath()) == null) {
                    return;
                }
                Context context3 = context2;
                BiliImageView biliImageView = dynamicImageView;
                try {
                    Result.Companion companion = Result.Companion;
                    SplashButtonFactoryKt$createDynamicImageView$1 splashButtonFactoryKt$createDynamicImageView$1 = this;
                    ImageRequestBuilder.enableAutoPlayAnimation$default(BiliImageLoader.INSTANCE.with(context3), true, false, 2, (Object) null).animationPlayEndlessLoop(true).url(BusinessSplashDefine.FILE_URI_PREFIX + filePath).into(biliImageView);
                    obj = Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                SplashGuideButton splashGuideButton = SplashGuideButton.this;
                Splash splash2 = splash;
                if (Result.exceptionOrNull-impl(obj) != null) {
                    BLog.i("[Splash]SplashButtonFactory", "createDynamicImageView, load image error, resource = " + splashGuideButton.getActualUsedImageHash());
                    String actualUsedImageUrl = splashGuideButton.getActualUsedImageUrl();
                    if (actualUsedImageUrl == null) {
                        actualUsedImageUrl = "";
                    }
                    SplashCustomReporterKt.reportResourceLoadException(splash2, actualUsedImageUrl, 1);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
            }
        });
        if (buttonData.getExtInteractStyle() == 1) {
            rootView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonFactoryKt$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SplashButtonClickListener.this.onClick(splash, buttonData);
                }
            });
        }
        return rootView;
    }

    private static final View createLottieView(Context context, final Splash splash, final SplashGuideButton buttonData, int screenWidth, int screenHeight, final SplashButtonClickListener listener) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        final int viewWidth = (int) (screenWidth * buttonData.getWidthPercent());
        final int viewHeight = (int) (screenHeight * buttonData.getHeightPercent());
        float viewCenterX = screenWidth * buttonData.getXPercent();
        float viewCenterY = screenHeight * buttonData.getYPercent();
        FrameLayout $this$createLottieView_u24lambda_u240 = new FrameLayout(context2);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(viewWidth, viewHeight);
        $this$createLottieView_u24lambda_u240.setX(viewCenterX - (viewWidth / 2));
        $this$createLottieView_u24lambda_u240.setY(viewCenterY - (viewHeight / 2));
        $this$createLottieView_u24lambda_u240.setLayoutParams(layoutParams);
        final SafeLottieAnimationView $this$createLottieView_u24lambda_u241 = new SafeLottieAnimationView(context2, null, 0, 6, null);
        $this$createLottieView_u24lambda_u241.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams $this$createLottieView_u24lambda_u241_u240 = new FrameLayout.LayoutParams(-2, -2);
        $this$createLottieView_u24lambda_u241_u240.gravity = 17;
        $this$createLottieView_u24lambda_u241.setLayoutParams($this$createLottieView_u24lambda_u241_u240);
        $this$createLottieView_u24lambda_u240.addView((View) $this$createLottieView_u24lambda_u241);
        SplashButtonHelperKt.stopWhenDetach($this$createLottieView_u24lambda_u241);
        String imageUrl = buttonData.getActualUsedImageUrl();
        File file = BusinessSplashResHelper.fetchResourceFileByHash(buttonData.getActualUsedImageHash());
        if (file == null) {
            return null;
        }
        SafeLottieCompositionFactory.INSTANCE.safeLoadPlayLottie(splash, $this$createLottieView_u24lambda_u241, new FileInputStream(file), imageUrl, new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonFactoryKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit createLottieView$lambda$2;
                createLottieView$lambda$2 = SplashButtonFactoryKt.createLottieView$lambda$2(SafeLottieAnimationView.this, viewHeight, viewWidth, (LottieComposition) obj);
                return createLottieView$lambda$2;
            }
        });
        if (buttonData.getExtInteractStyle() == 1) {
            $this$createLottieView_u24lambda_u240.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonFactoryKt$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SplashButtonClickListener.this.onClick(splash, buttonData);
                }
            });
        }
        return $this$createLottieView_u24lambda_u240;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createLottieView$lambda$2(SafeLottieAnimationView $lottieAnimationView, int $viewHeight, int $viewWidth, LottieComposition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Rect $this$createLottieView_u24lambda_u242_u240 = it.getBounds();
        int realWidth = $viewHeight >= $viewWidth ? $viewWidth : (int) (($this$createLottieView_u24lambda_u242_u240.width() / $this$createLottieView_u24lambda_u242_u240.height()) * $viewHeight);
        int realHeight = $viewHeight >= $viewWidth ? (int) (($this$createLottieView_u24lambda_u242_u240.height() / $this$createLottieView_u24lambda_u242_u240.width()) * $viewWidth) : $viewHeight;
        ViewGroup.LayoutParams $this$createLottieView_u24lambda_u242_u240_u240 = $lottieAnimationView.getLayoutParams();
        $this$createLottieView_u24lambda_u242_u240_u240.width = realWidth;
        $this$createLottieView_u24lambda_u242_u240_u240.height = realHeight;
        $lottieAnimationView.setLayoutParams($this$createLottieView_u24lambda_u242_u240_u240);
        $lottieAnimationView.setComposition(it);
        $lottieAnimationView.playAnimation();
        return Unit.INSTANCE;
    }
}