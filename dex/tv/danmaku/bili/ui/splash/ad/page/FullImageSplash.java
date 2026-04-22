package tv.danmaku.bili.ui.splash.ad.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.homepage.MainImageExtension;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.bean.DecodedImageHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageDataSubscriber;
import com.bilibili.lib.image2.bean.StaticBitmapImageHolder;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.ui.util.StatusBarCompat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.splash.ad.player.SplashAlphaPlayer;
import tv.danmaku.bili.splash.ad.state.actions.SplashSkipClickEvent;
import tv.danmaku.bili.ui.splash.OnClickTouchListener;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageViewHelperKt;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelperKt;
import tv.danmaku.bili.ui.splash.ad.util.SplashLayoutHelperKt;
import tv.danmaku.bili.ui.splash.utils.UiUtils;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class FullImageSplash extends BaseSplash {
    private static final String TAG = "FullImageSplash";
    private SpannableString countdownSS;
    protected View eggCountdownView;
    protected SplashAlphaPlayer eggPlayer;
    protected TextView mAdLabel;
    protected TextView mCountDown;
    private ForegroundColorSpan mCountdownTextColorSpan;
    protected boolean mIsShowAnimator;
    protected View mLabelLayout;
    protected View mLogoLayout;
    protected BiliImageView mLogoView;
    protected ConstraintLayout mRootView;
    protected ImageView mSplashView;
    protected SplashAlphaPlayer secondPageEggPlayer;
    private SpannableString skipSS;
    public SplashAlphaPlayer topViewTransitionPlayer;
    private boolean mSkipBtnClicked = false;
    protected boolean isEggPlayFinished = false;
    public boolean topViewTransitionCanPlay = false;
    protected final Runnable mPreloadSecondPageEggVideoRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.page.FullImageSplash$$ExternalSyntheticLambda2
        @Override // java.lang.Runnable
        public final void run() {
            FullImageSplash.this.m1527lambda$new$0$tvdanmakubiliuisplashadpageFullImageSplash();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$tv-danmaku-bili-ui-splash-ad-page-FullImageSplash  reason: not valid java name */
    public /* synthetic */ void m1527lambda$new$0$tvdanmakubiliuisplashadpageFullImageSplash() {
        if (this.mSplash.hasSecondPageEggVideo() && getView() != null && this.mSplash.secondPage != null && getContext() != null) {
            String videoHash = this.mSplash.secondPage.getSecondVideoHash();
            File file = BusinessSplashResHelper.fetchResourceFileByHash(videoHash);
            Context context = getContext();
            if (file == null || context == null) {
                return;
            }
            this.secondPageEggPlayer = new SplashAlphaPlayer(context, (AttributeSet) null, 0, BusinessSplashDefine.FILE_URI_PREFIX + file.getAbsolutePath(), (Function0) null, (Function0) null);
            this.secondPageEggPlayer.setLayoutParams(SplashLayoutHelperKt.createMatchParentLayoutParams((ViewGroup) getView()));
        }
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void initViews() {
        View view2 = getView();
        if (view2 == null) {
            return;
        }
        this.mSplashView = (ImageView) view2.findViewById(R.id.splash_view);
        if (this.mSplash.isSkipDefault() || this.mSplash.isSkipSizeExp()) {
            this.mCountDown = (TextView) view2.findViewById(R.id.count_down);
            this.mAdLabel = (TextView) view2.findViewById(R.id.label_ad);
        } else {
            this.mCountDown = (TextView) view2.findViewById(R.id.count_down2);
            if (isFullscreenSplash()) {
                this.mAdLabel = (TextView) view2.findViewById(R.id.label_ad3);
            } else {
                this.mAdLabel = (TextView) view2.findViewById(R.id.label_ad2);
            }
        }
        this.mLogoView = view2.findViewById(R.id.logo);
        this.mRootView = view2.findViewById(R.id.root_container);
        ConstraintSet set = new ConstraintSet();
        set.clone(this.mRootView);
        set.setGuidelineBegin(R.id.guideline, StatusBarCompat.getStatusBarHeight(view2.getContext()) + UiUtils.dp2Px(24));
        set.applyTo(this.mRootView);
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    protected void onTimerTick(long leftTimeMillis) {
        if (this.mCountDown != null && this.skipSS != null && this.mCountdownTextColorSpan != null) {
            this.countdownSS = new SpannableString(String.valueOf(leftTimeMillis / 1000));
            this.countdownSS.setSpan(this.mCountdownTextColorSpan, 0, this.countdownSS.length(), 33);
            SpannableStringBuilder content = new SpannableStringBuilder();
            content.append((CharSequence) this.skipSS).append((CharSequence) " ").append((CharSequence) this.countdownSS);
            this.mCountDown.setText(content);
        }
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void setBottomHeight() {
        View view2 = getView();
        if (view2 == null) {
            return;
        }
        this.mLogoLayout = view2.findViewById(R.id.logo_layout);
        this.mLogoLayout.setBackgroundColor(getLogoLayoutBgColor());
        ViewGroup.LayoutParams layoutParams = this.mLogoLayout.getLayoutParams();
        layoutParams.height = this.mBottomLogoHeight;
        this.mLogoLayout.setLayoutParams(layoutParams);
        this.mLogoLayout.setClickable(!isFullscreenSplash());
    }

    public void showContent() {
        if (TextUtils.isEmpty(this.mSplash.imageUrl)) {
            return;
        }
        if (this.mSplash.isRealTimeSplash && !this.mSplash.imageUrl.startsWith(BusinessSplashDefine.FILE_URI_PREFIX) && this.mSplash.realTimeSplashBitmap != null) {
            BLog.i(TAG, "show real time splash bmp");
            this.mSplashView.setImageBitmap(this.mSplash.realTimeSplashBitmap);
        } else if (this.mSplash.imageUrl.startsWith(BusinessSplashDefine.FILE_URI_PREFIX)) {
            String pathname = this.mSplash.imageUrl.substring(BusinessSplashDefine.FILE_URI_PREFIX.length());
            try {
                Bitmap bitmap = BitmapFactory.decodeFile(pathname);
                this.mSplashView.setImageBitmap(bitmap);
            } catch (Throwable t) {
                FileUtils.deleteQuietly(new File(pathname));
                CrashReporter.INSTANCE.postCaughtException(t);
                BLog.e("Splash", "load splash error");
            }
        } else {
            BiliImageLoader.INSTANCE.acquire(this.mSplashView).with(this.mSplashView).asDecodedImage().url(this.mSplash.imageUrl).submit().subscribe(new ImageDataSubscriber<DecodedImageHolder<?>>() { // from class: tv.danmaku.bili.ui.splash.ad.page.FullImageSplash.1
                public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource) {
                    ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource);
                }

                public void onResult(ImageDataSource<DecodedImageHolder<?>> imageDataSource) {
                    if (imageDataSource != null && imageDataSource.getResult() != null && (((DecodedImageHolder) imageDataSource.getResult()).get() instanceof StaticBitmapImageHolder)) {
                        Bitmap bitmap2 = ((StaticBitmapImageHolder) ((DecodedImageHolder) imageDataSource.getResult()).get()).get();
                        FullImageSplash.this.mSplashView.setImageBitmap(bitmap2);
                    }
                }

                public void onFailure(ImageDataSource<DecodedImageHolder<?>> imageDataSource) {
                }

                public void onCancellation(ImageDataSource<DecodedImageHolder<?>> dataSource) {
                }
            });
        }
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void showADAndWifiLabel() {
        View view2 = getView();
        if (view2 == null) {
            return;
        }
        if (this.mSplash.isSkipDefault() || this.mSplash.isSkipSizeExp()) {
            this.mLabelLayout = view2.findViewById(R.id.label_layout);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mLabelLayout.getLayoutParams();
            marginLayoutParams.topMargin = StatusBarCompat.getStatusBarHeight(view2.getContext()) + UiUtils.dp2Px(this.mSplash.isSkipDefault() ? 12 : 16);
            this.mLabelLayout.setLayoutParams(marginLayoutParams);
        } else if (isFullscreenSplash()) {
            this.mLabelLayout = view2.findViewById(R.id.label_layout3);
        } else {
            this.mLabelLayout = view2.findViewById(R.id.label_layout2);
        }
        if (this.mSplash.cmMark == 1) {
            this.mAdLabel.setVisibility(0);
            this.mAdLabel.setText(bili.resource.homepage.R.string.homepage_global_string_385);
            return;
        }
        this.mAdLabel.setVisibility(8);
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void showSkipButton() {
        double scale;
        int buttonHeight;
        int countDownTextSize;
        FragmentActivity activity = getActivity();
        if (activity == null || getView() == null || this.mCountDown == null) {
            return;
        }
        if (this.mSplash.skip == 1) {
            this.mCountDown.setVisibility(0);
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) this.mCountDown.getLayoutParams();
            if (this.mSplash.isSkipDefault()) {
                buttonHeight = (int) (this.mBottomLogoHeight * (isFullscreenSplash() ? 0.446f : 0.43f));
            } else {
                if (this.mSplash.skipButtonHeightRatio < 0.035d) {
                    scale = 0.035d;
                } else if (this.mSplash.skipButtonHeightRatio > 0.056d) {
                    scale = 0.056d;
                } else {
                    scale = this.mSplash.skipButtonHeightRatio;
                }
                buttonHeight = (int) (getResources().getDisplayMetrics().heightPixels * scale);
            }
            layoutParams.height = buttonHeight;
            layoutParams.width = layoutParams.height * 2;
            this.mCountDown.setLayoutParams(layoutParams);
            GradientDrawable bgDrawable = (GradientDrawable) ContextCompat.getDrawable(activity, getSkipButtonBg());
            if (bgDrawable != null) {
                GradientDrawable drawableMutate = (GradientDrawable) bgDrawable.mutate();
                drawableMutate.setCornerRadius(buttonHeight / 2.0f);
                this.mCountDown.setBackground(drawableMutate);
            }
            if (this.mSplash.isSkipDefault()) {
                countDownTextSize = (int) (buttonHeight * (isFullscreenSplash() ? 0.35d : 0.4d));
            } else {
                countDownTextSize = (int) (buttonHeight * 0.43d);
            }
            this.mCountDown.setTextSize(0, countDownTextSize);
            BLog.i(TAG, "showSkipButton, countDownTextSize = " + countDownTextSize + ", isFullscreenSplash = " + isFullscreenSplash() + " , and count down height = " + this.mCountDown.getHeight() + ", layout param height = " + layoutParams.height);
            if (this.mCountDown.getParent() instanceof View) {
                this.mCountDown.post(new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.page.FullImageSplash$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        FullImageSplash.this.m1529lambda$showSkipButton$1$tvdanmakubiliuisplashadpageFullImageSplash();
                    }
                });
            }
            this.mCountDown.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.FullImageSplash$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FullImageSplash.this.m1530lambda$showSkipButton$2$tvdanmakubiliuisplashadpageFullImageSplash(view2);
                }
            });
            ForegroundColorSpan skipTextColorSpan = new ForegroundColorSpan(getSkipTextColor());
            this.skipSS = new SpannableString(activity.getString(bili.resource.common.R.string.common_global_string_144));
            this.skipSS.setSpan(skipTextColorSpan, 0, this.skipSS.length(), 33);
            this.mCountdownTextColorSpan = new ForegroundColorSpan(ContextCompat.getColor(activity, getSkipNumberColorRes()));
            this.countdownSS = new SpannableString(String.valueOf(this.mSplash.duration));
            this.countdownSS.setSpan(this.mCountdownTextColorSpan, 0, this.countdownSS.length(), 33);
            SpannableStringBuilder content = new SpannableStringBuilder();
            content.append((CharSequence) this.skipSS).append((CharSequence) " ").append((CharSequence) this.countdownSS);
            this.mCountDown.setText(content);
            BLog.i(TAG, "count down text = " + ((Object) content));
            return;
        }
        this.mCountDown.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showSkipButton$1$tv-danmaku-bili-ui-splash-ad-page-FullImageSplash  reason: not valid java name */
    public /* synthetic */ void m1529lambda$showSkipButton$1$tvdanmakubiliuisplashadpageFullImageSplash() {
        if (!activityDie() && this.mCountDown != null && this.mSplash.isSkipDefault()) {
            Resources resources = this.mCountDown.getResources();
            int leftRightDimen = UiUtils.dp2Px(12);
            int topBottomDimen = UiUtils.dp2Px(resources == null ? UiUtils.dp2Px(10) : resources.getDimension(R.dimen.splash_skip_click_top_bottom));
            Rect rect = new Rect(this.mCountDown.getLeft() - leftRightDimen, this.mCountDown.getTop() - topBottomDimen, this.mCountDown.getRight() + leftRightDimen, this.mCountDown.getBottom() + topBottomDimen);
            TouchDelegate touchDelegate = new TouchDelegate(rect, this.mCountDown);
            View view2 = (View) this.mCountDown.getParent();
            if (view2 != null) {
                view2.setTouchDelegate(touchDelegate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showSkipButton$2$tv-danmaku-bili-ui-splash-ad-page-FullImageSplash  reason: not valid java name */
    public /* synthetic */ void m1530lambda$showSkipButton$2$tvdanmakubiliuisplashadpageFullImageSplash(View v) {
        if (this.mSplashViewModel != null) {
            this.mSplashViewModel.update(new SplashSkipClickEvent(""));
        }
        if (!this.mSkipBtnClicked && !this.mSplashExited) {
            this.mSkipBtnClicked = true;
            if (this.mSplashCoreService != null) {
                this.mSplashCoreService.setSplashDurationSession(calculateSplashRealDuration());
            }
        }
        SplashCustomReporterKt.reportSkipClick(this.mSplash);
        SplashAdHelper.adSplashSkip(this.mSplash, calculateExposeTimeWhenSkip());
        if (this.mSplash != null && this.mSplash.isSearchLinkage()) {
            SplashAdHelper.reportSplashDefaultWordExpose(this.mSplash, 3);
        }
        onSkipClick();
    }

    protected void onSkipClick() {
        exitSplash(false);
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void showLogoView() {
        if (this.mLogoView == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = this.mLogoView.getLayoutParams();
        layoutParams.horizontalBias = isFullscreenSplash() ? DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN : 0.5f;
        layoutParams.height = (int) (this.mBottomLogoHeight * (isFullscreenSplash() ? 0.56d : 0.6d));
        layoutParams.width = layoutParams.height * 2;
        this.mLogoView.setLayoutParams(layoutParams);
        String logoResUri = BusinessSplashResHelperKt.md5ToFileUri(this.mSplash.logoHash);
        if (logoResUri == null) {
            logoResUri = this.mSplash.logoUrl;
        }
        if (TextUtils.isEmpty(logoResUri)) {
            this.mLogoView.setImageResource(isFullscreenSplash() ? R.drawable.ic_logo_full_default : R.drawable.ic_logo_default);
        } else {
            BiliImageLoader.INSTANCE.with(this.mLogoView.getContext()).url(logoResUri).thumbnailUrlTransformStrategy(MainImageExtension.getThumbnailUrlTransformStrategy(false)).failureImageResId(isFullscreenSplash() ? R.drawable.ic_logo_full_default : R.drawable.ic_logo_default).into(this.mLogoView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void startContDown(long leftTimeMillis) {
        if (leftTimeMillis < 1 && (AlphaEggLayerComponentKt.interceptExitEvent(this) || TopViewTransitionComponentKt.triggerTopViewTransition(this))) {
            return;
        }
        super.startContDown(leftTimeMillis);
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    protected boolean isFullscreenSplash() {
        return true;
    }

    protected int getSkipButtonBg() {
        return R.drawable.shape_roundrect_black40_r20;
    }

    protected int getSkipTextColor() {
        return -1;
    }

    protected int getSkipNumberColorRes() {
        return 17170443;
    }

    protected int getLogoLayoutBgColor() {
        return 0;
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.ISplash
    public void showJumpView() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.mSplashView.setOnTouchListener(new OnClickTouchListener(context, new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.FullImageSplash$$ExternalSyntheticLambda5
            public final Object invoke() {
                return FullImageSplash.this.m1528lambda$showJumpView$3$tvdanmakubiliuisplashadpageFullImageSplash();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showJumpView$3$tv-danmaku-bili-ui-splash-ad-page-FullImageSplash  reason: not valid java name */
    public /* synthetic */ Unit m1528lambda$showJumpView$3$tvdanmakubiliuisplashadpageFullImageSplash() {
        if (this.mIsShowAnimator) {
            return null;
        }
        SplashAdHelper.adSplashOutsideClick(this.mSplash);
        if (this.mSplash.isSplashClickable()) {
            onJumpClick(buildThirdIntent(this.mSplash.appLink, this.mSplash.appPkg), this.mSplash.appLink);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void doTransformAnimation(Rect rect) {
        AlphaEggLayerComponentKt.doLinkageTransform(this, rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doBeforeAnimation() {
        if (this.mSplash.isEggVideoPlayed && this.eggPlayer != null) {
            setLastFrame(this.eggPlayer.getTextureView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<View> getAlphaView() {
        List<View> alphaViews = new ArrayList<>();
        if (this.mSplash.isSecondPageEggVideo()) {
            alphaViews.add(this.mButtonContainer);
            alphaViews.add(this.mSplashInteractView);
        } else {
            alphaViews.add(this.mCountDown);
            alphaViews.add(this.mAdLabel);
            alphaViews.add(this.mLogoView);
            alphaViews.add(this.mButtonContainer);
            alphaViews.add(this.mSplashInteractView);
        }
        return alphaViews;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$onTriggerSecondPage$4() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void onTriggerSecondPage(SplashActionType actionType) {
        SecondPageViewHelperKt.firstPageElementDisappear(getAlphaView(), new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.FullImageSplash$$ExternalSyntheticLambda1
            public final Object invoke() {
                return FullImageSplash.lambda$onTriggerSecondPage$4();
            }
        });
        super.onTriggerSecondPage(actionType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageView getTransformView() {
        return this.mSplashView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asyncGetTransformView(TakeSnapshotCallback calllback) {
        calllback.onTake(getTransformView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLastFrame(final TextureView textureView) {
        ViewGroup.LayoutParams layoutParams = this.mSplashView.getLayoutParams();
        layoutParams.height = textureView.getLayoutParams().height;
        this.mSplashView.setLayoutParams(layoutParams);
        this.mSplashView.setImageBitmap(textureView.getBitmap());
        this.mSplashView.setVisibility(0);
        this.mSplashView.post(new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.page.FullImageSplash$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                textureView.setVisibility(8);
            }
        });
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public SplashAlphaPlayer getSecondPageEggVideoPlayer() {
        return this.secondPageEggPlayer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public boolean canShowSecondPage() {
        return super.canShowSecondPage() || (this.mSplash.secondPageShowStyle == 3 && canShowSecondPageForSecondPageEggVideo());
    }

    private boolean canShowSecondPageForSecondPageEggVideo() {
        boolean isSecondPageEggVideo = this.mSplash.secondPageShowStyle == 3;
        if (isSecondPageEggVideo && this.secondPageEggPlayer == null) {
            SplashAdHelper.INSTANCE.reportSplashSecondPageEggShowFail(this.mSplash, 1);
            return false;
        }
        return isSecondPageEggVideo;
    }

    @Override // tv.danmaku.bili.ui.splash.ad.page.BaseSplash
    public void onSplashReady() {
        super.onSplashReady();
        HandlerThreads.post(0, this.mPreloadSecondPageEggVideoRunnable);
    }
}