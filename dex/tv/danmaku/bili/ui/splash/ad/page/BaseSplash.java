package tv.danmaku.bili.ui.splash.ad.page;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.adcommon.basic.Motion;
import com.bilibili.adcommon.data.AdReportInfo;
import com.bilibili.adcommon.data.IAdReportInfo;
import com.bilibili.adcommon.data.model.WxProgramInfo;
import com.bilibili.adcommon.utils.GsonKtKt;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.gripper.api.ad.core.debug.AdDebugPlugin;
import com.bilibili.gripper.api.ad.core.debug.DebugMarkStyle;
import com.bilibili.gripper.api.ad.core.debug.IInspector;
import com.bilibili.gripper.api.ad.core.player.report.IPlayerReportTracker;
import com.bilibili.gripper.api.ad.core.report.SimpleAdReportPreset;
import com.bilibili.gripper.api.ad.core.report.UIExtraParams;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.PlayerEvent;
import com.bilibili.lib.homepage.splash.actions.RealBannerRectUpdateAction;
import com.bilibili.lib.homepage.splash.globalactions.SplashCreativeIdUpdateAction;
import com.bilibili.lib.homepage.splash.model.SplashState;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.moduleservice.splash.SplashCoreService;
import com.bilibili.search.DefaultWordItem;
import java.util.List;
import java.util.concurrent.Callable;
import kntr.app.ad.common.model.AdSlot;
import kotlin.jvm.functions.Function0;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.splash.ad.player.SplashAlphaPlayer;
import tv.danmaku.bili.splash.ad.state.actions.DoSplashLinkageAnimationAction;
import tv.danmaku.bili.splash.ad.state.actions.SplashJumpClickEvent;
import tv.danmaku.bili.splash.ad.state.actions.SplashRealReadyAction;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.SplashHelper;
import tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper;
import tv.danmaku.bili.ui.splash.ad.button.model.ButtonClickData;
import tv.danmaku.bili.ui.splash.ad.button.model.LiveReserveTriggerType;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener;
import tv.danmaku.bili.ui.splash.ad.component.DanmakuComponentKt;
import tv.danmaku.bili.ui.splash.ad.component.StateObserverComponentKt;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.ui.splash.ad.page.ISplash;
import tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageInteractListener;
import tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageViewHelperKt;
import tv.danmaku.bili.ui.splash.ad.util.SplashLiveReserveHelper;
import tv.danmaku.bili.ui.splash.common.search.SplashSearchServiceImpl;
import tv.danmaku.bili.ui.splash.common.search.SplashSearchServiceImplKt;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.bili.ui.splash.utils.SplashUtilsKt;
import tv.danmaku.bili.ui.splash.utils.UiUtils;
import tv.danmaku.bili.ui.splash.widget.DeliverySlideEventFrameLayout;
import tv.danmaku.bili.ui.splash.widget.MotionEventListener;
import tv.danmaku.bili.ui.splash.widget.SplashContainerView;
import tv.danmaku.bili.ui.splash.widget.SplashInteractView;
import tv.danmaku.bili.update.utils.StringsKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public abstract class BaseSplash extends BaseFragment implements ISplash, Handler.Callback, SplashInteractView.InteractListener {
    private static final long COUNTDOWN_INTERVAL = 1000;
    private static final int MSG_COUNTDOWN = 1;
    static final int MSG_EXIT = 2;
    private static final String TAG = "[Splash]BaseSplash";
    protected int mBottomLogoHeight;
    protected DeliverySlideEventFrameLayout mButtonContainer;
    private boolean mClickJump;
    protected boolean mExecuteAnim;
    protected SplashContainerView mRootContainer;
    protected FrameLayout mSecondPageContainer;
    protected Splash mSplash;
    protected SplashCoreService mSplashCoreService;
    private String mSplashId;
    protected SplashInteractView mSplashInteractView;
    public SplashViewModel mSplashViewModel;
    protected long mStartTimeMIll;
    public long mViewCreateTime;
    public IPlayerReportTracker playerReporter;
    private final Handler mHandler = new Handler(this);
    protected boolean mSplashExited = false;
    private boolean mIsReady = false;
    public boolean mIsSecondPageTriggered = false;
    private final SplashButtonHelper mButtonHelper = new SplashButtonHelper();
    private Runnable mDelayReadyRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.page.BaseSplash$$ExternalSyntheticLambda4
        @Override // java.lang.Runnable
        public final void run() {
            BaseSplash.this.m1522lambda$new$0$tvdanmakubiliuisplashadpageBaseSplash();
        }
    };
    private final View.OnAttachStateChangeListener mAttachListener = new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.BaseSplash.1
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            BLog.i(BaseSplash.TAG, "onViewAttachedToWindow");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            v.removeOnAttachStateChangeListener(BaseSplash.this.mAttachListener);
            BLog.i(BaseSplash.TAG, "onViewDetachedFromWindow");
            if (SplashConfigKt.getPerformDestroyViewOnDetach()) {
                BaseSplash.this.handleDestroyView();
            }
        }
    };

    protected abstract boolean isFullscreenSplash();

    protected abstract void onTimerTick(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$tv-danmaku-bili-ui-splash-ad-page-BaseSplash  reason: not valid java name */
    public /* synthetic */ void m1522lambda$new$0$tvdanmakubiliuisplashadpageBaseSplash() {
        BLog.i(TAG, "mDelayReadyRunnable run");
        onSplashReady();
        if (SplashUtilsKt.isDebug()) {
            ToastHelper.showToast(requireContext(), "闪屏视频准备超时，MaxTime" + SplashConfigKt.getSplashMaxPrepareTime() + "ms", 0);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BLog.i(TAG, "onCreateView " + this);
        return inflater.inflate(R.layout.bili_app_fragment_splash, container, false);
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        this.mViewCreateTime = System.currentTimeMillis();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.mSplashViewModel = new ViewModelProvider(activity).get(SplashViewModel.class);
        }
        if (this.mSplash == null) {
            BLog.i(TAG, "onViewCreated mSplash is null show failed " + this);
            exitSplash(false);
            return;
        }
        BLog.i(TAG, "onViewCreated show splash success: id = " + this.mSplash.id + " ad_cb =  " + this.mSplash.adCb + " " + this.mSplash.videoUrl + " " + this.mSplash.imageUrl);
        StateObserverComponentKt.observerOnViewCreated(this);
        this.mSplashCoreService = (SplashCoreService) BLRouter.INSTANCE.get(SplashCoreService.class, "default");
        this.mBottomLogoHeight = getResources().getDisplayMetrics().heightPixels / 8;
        setBottomHeight();
        initViews();
        showContent();
        showLogoView();
        showADAndWifiLabel();
        showSkipButton();
        showJumpView();
        DanmakuComponentKt.initDanmakuView(this);
        this.mButtonContainer = (DeliverySlideEventFrameLayout) view2.findViewById(R.id.splash_button_container);
        showGuideButton(this.mButtonContainer);
        this.mSecondPageContainer = (FrameLayout) view2.findViewById(R.id.splash_second_page_container);
        this.mRootContainer = (SplashContainerView) view2.findViewById(R.id.root_container);
        initSplashInteract();
        this.mRootContainer.setOnClickEventListener(new SplashContainerView.OnClickEventListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.BaseSplash$$ExternalSyntheticLambda7
            @Override // tv.danmaku.bili.ui.splash.widget.SplashContainerView.OnClickEventListener
            public final void onClick(float f, float f2) {
                BaseSplash.this.m1525lambda$onViewCreated$2$tvdanmakubiliuisplashadpageBaseSplash(f, f2);
            }
        });
        view2.addOnAttachStateChangeListener(this.mAttachListener);
        BLog.i(TAG, "onViewCreated need prepared " + needPrepare());
        if (!needPrepare()) {
            if (this.mSplashViewModel != null) {
                this.mSplashViewModel.update(new SplashRealReadyAction("from_view_create"));
            }
            onSplashReady();
        } else {
            long maxPrepareTime = this.mSplash.cardType == 152 ? SplashConfigKt.getBannerSplashMaxPrepareTimeMs() : SplashConfigKt.getSplashMaxPrepareTime();
            HandlerThreads.postDelayed(0, this.mDelayReadyRunnable, maxPrepareTime);
        }
        setAdInspector();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onViewCreated$2$tv-danmaku-bili-ui-splash-ad-page-BaseSplash  reason: not valid java name */
    public /* synthetic */ void m1525lambda$onViewCreated$2$tvdanmakubiliuisplashadpageBaseSplash(final float x, final float y) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (Float.isNaN(x) || Float.isNaN(y)) {
            BLog.e(TAG, "Click position isNaN.");
            return;
        }
        final boolean hasButton = (this.mSplash.splashGuideButton == null || this.mSplash.splashGuideButton.isEmpty()) ? false : true;
        BLog.i(TAG, "OnClickEvent: x: " + x + " y: " + y);
        this.mRootContainer.post(new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.page.BaseSplash$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                BaseSplash.this.m1524lambda$onViewCreated$1$tvdanmakubiliuisplashadpageBaseSplash(x, y, hasButton);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onViewCreated$1$tv-danmaku-bili-ui-splash-ad-page-BaseSplash  reason: not valid java name */
    public /* synthetic */ void m1524lambda$onViewCreated$1$tvdanmakubiliuisplashadpageBaseSplash(float x, float y, boolean hasButton) {
        int containerWidth = this.mRootContainer.getWidth();
        int containerHeight = this.mRootContainer.getHeight();
        if (containerWidth == 0 || containerHeight == 0) {
            BLog.e(TAG, "Container dimension is not valid.");
        } else {
            SplashAdHelper.adSplashClickPositionReport(this.mSplash, containerWidth, containerHeight, x, y, hasButton);
        }
    }

    public void onSplashReady() {
        BLog.i(TAG, "onSplashReady");
        if (this.mDelayReadyRunnable != null) {
            HandlerThreads.remove(0, this.mDelayReadyRunnable);
            this.mDelayReadyRunnable = null;
        }
        if (this.mIsReady) {
            return;
        }
        this.mIsReady = true;
        if (this.mSplash.isHotSplash) {
            SplashAdHelper.adReportSplashExposed(this.mSplash, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_HOT);
            if (SplashConfigKt.getEnableHotLaunchRequestList() && !SplashConfigKt.getEnableHotLaunchBehaviorRequestList()) {
                SplashHelper.updateSplash(SplashConfigKt.getHotSplashDelayRefreshListTimeMs(), BusinessSplashDefineKt.SPLASH_OPEN_EVENT_HOT);
            }
        } else {
            SplashAdHelper.adReportSplashExposed(this.mSplash, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_COLD);
        }
        SplashViewModel.Companion.update(new SplashCreativeIdUpdateAction(this.mSplash.splashCreativeId));
        if (this.mSplash.isRealTimeSplash) {
            SplashAdHelper.reportRealtimeMatShow(this.mSplash);
            SplashCustomReporterKt.reportRealtimeMatShow(this.mSplash);
        }
        SplashCustomReporterKt.reportSplashExpose(this.mSplash);
        increaseShowCount();
        this.mStartTimeMIll = SystemClock.elapsedRealtime();
        this.mHandler.post(new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.page.BaseSplash$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                BaseSplash.this.m1523lambda$onSplashReady$3$tvdanmakubiliuisplashadpageBaseSplash();
            }
        });
        ISplash.SplashHost activity = getActivity();
        if (activity instanceof ISplash.SplashHost) {
            activity.onADSplashReady();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onSplashReady$3$tv-danmaku-bili-ui-splash-ad-page-BaseSplash  reason: not valid java name */
    public /* synthetic */ void m1523lambda$onSplashReady$3$tvdanmakubiliuisplashadpageBaseSplash() {
        startContDown(this.mSplash.duration * 1000);
    }

    public void onSoundButtonClicked() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onTriggerSecondPage(SplashActionType actionType) {
        this.mIsSecondPageTriggered = true;
        stopCountDown();
        this.mSplashInteractView.setVisibility(8);
        onTriggerSecondPageEggVideo();
        SecondPageViewHelperKt.showSecondPage(this.mSecondPageContainer, this.mSplash, this, actionType, getSecondPageEggVideoPlayer(), new SecondPageInteractListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.BaseSplash.2
            @Override // tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageInteractListener
            public void onSecondPageEggVideoComplete() {
                BaseSplash.this.handlePageJump(true, "4", null);
            }

            @Override // tv.danmaku.bili.ui.splash.widget.SplashInteractView.InteractListener
            public void onInteractLayerClicked() {
                if (BaseSplash.this.mSplash.secondPage != null && BaseSplash.this.mSplash.secondPage.getInteractStyle() == 1 && !BaseSplash.this.mSplash.secondPage.getLocalSecondPageButtonDegraded()) {
                    BaseSplash.this.handlePageJump(true, "1", LiveReserveTriggerType.CLICK);
                }
            }

            @Override // tv.danmaku.bili.ui.splash.widget.SplashInteractView.InteractListener
            public void onScroll(float length, int angle) {
                if (length <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN || BaseSplash.this.mSplash.secondPage == null || BaseSplash.this.mSplash.secondPage.getInteractStyle() != 2) {
                    return;
                }
                int triggerDistance = BaseSplash.this.mSplash.secondPage.getSecondSlideDistance();
                BLog.i(BaseSplash.TAG, "onScroll, length = " + UiUtils.px2dp(length) + ", angle = " + angle + ", length limit = " + triggerDistance + ", angle limit = " + BaseSplash.this.mSplash.interactAngle);
                SplashAdHelper.reportSplashInteract(BaseSplash.this.mSplash, UiUtils.px2dp(length), triggerDistance, angle, BaseSplash.this.mSplash.interactAngle);
                boolean isValidAngle = BaseSplash.this.mSplash.interactAngle <= 0 || angle <= BaseSplash.this.mSplash.interactAngle;
                if (length <= UiUtils.dp2Px(triggerDistance) || !isValidAngle) {
                    SplashAdHelper.adSplashSlideFail(BaseSplash.this.mSplash, "splash_second");
                } else {
                    BaseSplash.this.handlePageJump(true, "3", LiveReserveTriggerType.SLIDE);
                }
            }

            @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
            public void onClick(Splash splash, SplashGuideButton splashGuideButton) {
                Intent intent = BaseSplash.this.buildThirdIntent(splashGuideButton.getSchema(), splashGuideButton.getSchemaPackageName());
                SplashAdHelper.reportSecondPageVideoJump(BaseSplash.this.mSplash, "0");
                BaseSplash.this.onJumpClick(intent, splashGuideButton.getSchema(), splashGuideButton.getJumpUrl(), false, SplashActionType.BUTTON, false, String.valueOf(splashGuideButton.getId()), null);
            }

            @Override // tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageInteractListener
            public void onSoundClicked() {
                BaseSplash.this.onSoundButtonClicked();
            }

            @Override // tv.danmaku.bili.ui.splash.ad.secondpage.SecondPageInteractListener
            public void onCloseClicked() {
                SplashAdHelper.reportSecondPageVideoClose(BaseSplash.this.mSplash);
                BaseSplash.this.exitSplash(false);
            }
        });
        SplashAdHelper.reportSecondPageVideoShowSuccess(this.mSplash);
    }

    private void showGuideButton(ViewGroup container) {
        this.mButtonHelper.injectSplashButton(container, this.mSplash, this, new SplashButtonClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.BaseSplash.3
            @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
            public void onShake(SplashGuideButton splashGuideButton) {
                Intent intent = BaseSplash.this.buildThirdIntent(splashGuideButton.getSchema(), splashGuideButton.getSchemaPackageName());
                BaseSplash.this.onJumpClick(intent, splashGuideButton.getSchema(), splashGuideButton.getJumpUrl(), true, SplashActionType.SHAKE, true, String.valueOf(splashGuideButton.getId()), null);
            }

            @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
            public void onClick(Splash splash, SplashGuideButton splashGuideButton) {
                Intent intent = BaseSplash.this.buildThirdIntent(splashGuideButton.getSchema(), splashGuideButton.getSchemaPackageName());
                BaseSplash.this.onJumpClick(intent, splashGuideButton.getSchema(), splashGuideButton.getJumpUrl(), true, SplashActionType.BUTTON, true, String.valueOf(splashGuideButton.getId()), null);
                SplashAdHelper.adSplashButtonUIClick(splash, splashGuideButton);
            }

            @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
            public void onClickV2(ButtonClickData clickData) {
                Intent intent = BaseSplash.this.buildThirdIntent(clickData.getSplashButton().getSchema(), clickData.getSplashButton().getSchemaPackageName());
                String schemeUrl = !TextUtils.isEmpty(clickData.getSplashButton().getSchema()) ? clickData.getSplashButton().getSchema() : BaseSplash.this.mSplash.appLink;
                String jumpUrl = !TextUtils.isEmpty(clickData.getSplashButton().getJumpUrl()) ? clickData.getSplashButton().getJumpUrl() : BaseSplash.this.mSplash.jumpUrl;
                BaseSplash.this.onJumpClick(intent, schemeUrl, jumpUrl, true, clickData.getActionType(), true, String.valueOf(clickData.getSplashButton().getId()), clickData);
                SplashAdHelper.adSplashButtonUIClick(BaseSplash.this.mSplash, clickData.getSplashButton());
            }

            @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
            public void onSlide(SplashGuideButton splashGuideButton) {
                Intent intent = BaseSplash.this.buildThirdIntent(splashGuideButton.getSchema(), splashGuideButton.getSchemaPackageName());
                BaseSplash.this.onJumpClick(intent, splashGuideButton.getSchema(), splashGuideButton.getJumpUrl(), true, SplashActionType.SLIDE, true, String.valueOf(splashGuideButton.getId()), null);
            }

            @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
            public void onRotate(SplashGuideButton splashGuideButton) {
                Intent intent = BaseSplash.this.buildThirdIntent(splashGuideButton.getSchema(), splashGuideButton.getSchemaPackageName());
                BaseSplash.this.onJumpClick(intent, splashGuideButton.getSchema(), splashGuideButton.getJumpUrl(), true, SplashActionType.ROTATE, true, String.valueOf(splashGuideButton.getId()), null);
            }

            @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
            public void onRunning(SplashGuideButton splashGuideButton, boolean triggerFromThreshold) {
                Intent intent = BaseSplash.this.buildThirdIntent(splashGuideButton.getSchema(), splashGuideButton.getSchemaPackageName());
                SplashActionType type = SplashActionType.ROTATE_BALL;
                if (triggerFromThreshold) {
                    type = SplashActionType.ROTATE_BALL_THRESHOLD;
                }
                BaseSplash.this.onJumpClick(intent, splashGuideButton.getSchema(), splashGuideButton.getJumpUrl(), true, type, true, String.valueOf(splashGuideButton.getId()), null);
            }

            @Override // tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener
            public void onElementClick() {
                SplashAdHelper.reportSplashClickableEggClick(BaseSplash.this.mSplash, BaseSplash.this.calculateSplashRealDuration());
                Intent intent = BaseSplash.this.buildThirdIntent(BaseSplash.this.mSplash.appLink, BaseSplash.this.mSplash.appPkg);
                BaseSplash.this.onJumpClick(intent, BaseSplash.this.mSplash.appLink, BaseSplash.this.mSplash.jumpUrl, true, SplashActionType.CLICKABLE_EGG, true);
            }
        });
    }

    private void initSplashInteract() {
        View view2 = getView();
        if (view2 == null) {
            return;
        }
        this.mSplashInteractView = (SplashInteractView) view2.findViewById(R.id.splash_interact_view);
        if (this.mSplash.isInteractSupport()) {
            handleOutsideArea(this.mSplashInteractView);
            this.mSplashInteractView.setVisibility(0);
            this.mSplashInteractView.setOnInteractListener(this);
            this.mButtonContainer.setInteractEnable(true);
            this.mButtonContainer.setEventListener(new MotionEventListener() { // from class: tv.danmaku.bili.ui.splash.ad.page.BaseSplash$$ExternalSyntheticLambda0
                @Override // tv.danmaku.bili.ui.splash.widget.MotionEventListener
                public final void onTouchEvent(MotionEvent motionEvent) {
                    BaseSplash.this.m1521lambda$initSplashInteract$4$tvdanmakubiliuisplashadpageBaseSplash(motionEvent);
                }
            });
        } else {
            this.mButtonContainer.setInteractEnable(false);
            this.mSplashInteractView.setVisibility(8);
        }
        BLog.d(TAG, "initSplashInteract cardType = " + this.mSplash.cardType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initSplashInteract$4$tv-danmaku-bili-ui-splash-ad-page-BaseSplash  reason: not valid java name */
    public /* synthetic */ void m1521lambda$initSplashInteract$4$tvdanmakubiliuisplashadpageBaseSplash(MotionEvent ev) {
        MotionEvent newEv = MotionEvent.obtain(ev);
        ViewGroup.MarginLayoutParams lps = (ViewGroup.MarginLayoutParams) this.mSplashInteractView.getLayoutParams();
        newEv.offsetLocation(-lps.leftMargin, -lps.topMargin);
        this.mSplashInteractView.deliverySlideEvent(newEv);
        newEv.recycle();
    }

    private void handleOutsideArea(SplashInteractView splashInteractView) {
        ViewGroup.MarginLayoutParams lps = (ViewGroup.MarginLayoutParams) splashInteractView.getLayoutParams();
        int height = getResources().getDisplayMetrics().heightPixels;
        int width = getResources().getDisplayMetrics().widthPixels;
        JSONObject jsonObject = JSON.parseObject((String) ConfigManager.config().get("splash.interact_outside_area", ""));
        float left = SplashUtilsKt.getFloatValue(jsonObject, "left", 4.0f);
        float right = SplashUtilsKt.getFloatValue(jsonObject, "right", 4.0f);
        float top = SplashUtilsKt.getFloatValue(jsonObject, "top", 5.0f);
        float bottom = SplashUtilsKt.getFloatValue(jsonObject, "bottom", 8.0f);
        lps.topMargin = (int) (height * 0.01d * top);
        if (isFullscreenSplash()) {
            lps.bottomMargin = (int) (height * 0.01d * bottom);
        } else {
            lps.bottomMargin = ((int) (height * 0.01d * bottom)) + (getResources().getDisplayMetrics().heightPixels / 8);
        }
        lps.leftMargin = (int) (width * 0.01d * left);
        lps.rightMargin = (int) (width * 0.01d * right);
        BLog.d(TAG, "outsideArea margin left = " + left + " , right = " + right + " , top = " + top + " , bottom = " + bottom);
    }

    private void increaseShowCount() {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.splash.ad.page.BaseSplash$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BaseSplash.this.m1520lambda$increaseShowCount$5$tvdanmakubiliuisplashadpageBaseSplash();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$increaseShowCount$5$tv-danmaku-bili-ui-splash-ad-page-BaseSplash  reason: not valid java name */
    public /* synthetic */ Void m1520lambda$increaseShowCount$5$tvdanmakubiliuisplashadpageBaseSplash() throws Exception {
        SplashHelper.increaseSplashShowCount(this.mSplash);
        return null;
    }

    @Override // tv.danmaku.bili.ui.splash.widget.SplashInteractView.InteractListener
    public void onScroll(float length, int angle) {
        handleInteractEvent(length, angle);
    }

    @Override // tv.danmaku.bili.ui.splash.widget.SplashInteractView.InteractListener
    public void onInteractLayerClicked() {
        SplashAdHelper.adSplashOutsideClick(this.mSplash);
        if (!this.mSplash.isSplashClickable()) {
            return;
        }
        Intent intent = buildThirdIntent(this.mSplash.appLink, this.mSplash.appPkg);
        onJumpClickWithFrom(intent, this.mSplash.appLink, SplashActionType.UNDEFINE);
    }

    private boolean handleInteractEvent(float length, int angle) {
        BLog.i(TAG, "handleInteractEvent, length = " + UiUtils.px2dp(length) + ", angle = " + angle + ", length limit = " + this.mSplash.interactDistance + ", angle limit = " + this.mSplash.interactAngle);
        if (this.mSplash.isInteractSupport() && length > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            SplashAdHelper.reportSplashInteract(this.mSplash, UiUtils.px2dp(length), this.mSplash.interactDistance, angle, this.mSplash.interactAngle);
            boolean isValidAngle = this.mSplash.interactAngle <= 0 || angle <= this.mSplash.interactAngle;
            if (length >= UiUtils.dp2Px(this.mSplash.interactDistance) && isValidAngle) {
                if (!this.mIsSecondPageTriggered) {
                    long showTimeBeforeClick = calculateSplashRealDuration();
                    SplashAdHelper.adReportSplashClicked(this.mSplash, true, "ad_splash_slide", showTimeBeforeClick);
                    SplashCustomReporterKt.reportSplashClick(this.mSplash, this.mSplash.jumpUrl, "0", "splash_slide", "", showTimeBeforeClick);
                }
                if (canShowSecondPage()) {
                    onTriggerSecondPage(SplashActionType.SLIDE);
                    return false;
                }
                handlePageJump(false, null, LiveReserveTriggerType.SLIDE);
                return true;
            }
            SplashAdHelper.adSplashSlideFail(this.mSplash, null);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean canShowSecondPage() {
        return (this.mIsSecondPageTriggered || this.mSplash.secondPage == null || this.mSplash.secondPageShowStyle != 1) ? false : true;
    }

    public void handlePageJump(boolean isSecondPage, String secondPageJumpReason, LiveReserveTriggerType type) {
        if (isSecondPage) {
            SplashAdHelper.reportSecondPageVideoJump(this.mSplash, secondPageJumpReason);
        }
        if (type != null) {
            SplashLiveReserveHelper.handleLiveBooking(getContext(), this.mSplash, type.getValue());
        }
        if (this.mSplashViewModel != null) {
            this.mSplashViewModel.update(new SplashJumpClickEvent("handlePageJump"));
        }
        if (SplashAdHelper.handleAdJump(getActivity(), this.mSplash, this.mSplash.interactUrl, this.mSplash.jumpUrl, null, null, null)) {
            exitSplash(true);
            return;
        }
        Intent intent = buildThirdIntent(this.mSplash.appLink, this.mSplash.appPkg);
        onJumpClickWithoutReport(intent, this.mSplash.appLink);
    }

    private float getInteractCalculatePath() {
        return this.mSplashInteractView.calculatePath();
    }

    private int getSlideAngle() {
        if (this.mSplashInteractView != null) {
            return this.mSplashInteractView.calculateSlideAngle();
        }
        return -1;
    }

    public void onDestroyView() {
        BLog.i(TAG, "onDestroyView " + this);
        super.onDestroyView();
        if (!SplashConfigKt.getPerformDestroyViewOnDetach()) {
            handleDestroyView();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleDestroyView() {
        stopCountDown();
        if (this.mSplashViewModel != null && this.mSplash != null) {
            SplashViewModel.SplashExitInfo exitInfo = (SplashViewModel.SplashExitInfo) this.mSplashViewModel.getSplashExit().getValue();
            if (exitInfo == null) {
                exitInfo = new SplashViewModel.SplashExitInfo();
            }
            exitInfo.exitWithJump = this.mClickJump;
            exitInfo.exitSplashId = this.mSplashId;
            exitInfo.exitWithAnim = this.mExecuteAnim;
            exitInfo.isTopView = this.mSplash.isTopView();
            exitInfo.setAnimState(2);
            this.mSplashViewModel.getSplashExit().postValue(exitInfo);
            this.mSplashViewModel.update(new RealBannerRectUpdateAction((Rect) null));
            BLog.i(TAG, "notify splash exit info " + this);
        }
        SplashCustomReporterKt.reportSplashDuration(this.mSplash);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 1:
                this.mHandler.removeMessages(1);
                long leftTime = msg.obj == null ? 0L : ((Long) msg.obj).longValue();
                onTimerTick(leftTime);
                startContDown(leftTime);
                break;
            case 2:
                this.mSplashExited = true;
                this.mHandler.removeMessages(2);
                if (this.mSplashCoreService != null) {
                    this.mSplashCoreService.setSplashDurationSession(calculateSplashRealDuration());
                }
                if (this.mSplash.isInteractSupport()) {
                    boolean triggerJump = handleInteractEvent(getInteractCalculatePath(), getSlideAngle());
                    if (triggerJump) {
                        return true;
                    }
                }
                handleSlideEvent();
                handleRunningBall();
                exitSplashByCountDown();
                break;
        }
        return true;
    }

    private void handleRunningBall() {
        this.mButtonHelper.handleRunningBall();
    }

    private void handleSlideEvent() {
        this.mButtonHelper.handleSlideEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startContDown(long leftTimeMillis) {
        long delayTime;
        long leftTimeMillis2 = leftTimeMillis - 1000;
        Message message = Message.obtain();
        if (leftTimeMillis2 < 0) {
            message.what = 2;
            message.obj = null;
            delayTime = 0;
        } else {
            message.what = 1;
            message.obj = Long.valueOf(leftTimeMillis2);
            delayTime = 1000;
        }
        this.mHandler.sendMessageDelayed(message, delayTime);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopCountDown() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void exitSplash(boolean jumped) {
        exitSplash(null, null, jumped);
    }

    protected void exitSplash(Splash splash, String jumpUrl, boolean jumped) {
        BLog.i(TAG, "exitSplash, jumped = " + jumped);
        if (jumped) {
            Rect rect = getSearchLinkageRect();
            if (rect != null) {
                setQueryItem(this.mSplash, true);
            }
        }
        setJumpAnimation();
        if (splash != null && TextUtils.isEmpty(jumpUrl)) {
            return;
        }
        stopCountDown();
        if (splash == null) {
            this.mClickJump = false;
            this.mSplashId = null;
        } else {
            this.mClickJump = true;
            this.mSplashId = String.valueOf(splash.id);
        }
        if (this.mSplashViewModel != null) {
            this.mSplashViewModel.update(new PlayerEvent.OnStop("exitSplash"));
            if (jumped) {
                this.mSplashViewModel.update(new SplashJumpClickEvent("exitSplash"));
            }
        }
        reportVideoPlay(calculateSplashRealDuration());
        ISplash.SplashHost activity = getActivity();
        if (activity instanceof ISplash.SplashHost) {
            activity.exitSplash(splash, jumpUrl, jumped);
        }
    }

    private void setJumpAnimation() {
        FragmentActivity activity;
        if (this.mIsSecondPageTriggered && this.mSplash.secondPage != null && this.mSplash.secondPage.getInteractStyle() == 2 && (activity = getActivity()) != null) {
            activity.overridePendingTransition(R.anim.act_bottom_enter, R.anim.act_bottom_exit);
        }
    }

    protected void exitSplash(Splash splash, String jumpUrl) {
        exitSplash(splash, jumpUrl, splash != null);
    }

    public Intent buildThirdIntent(String url, String pkgName) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        String appLinkRpl = GAdCoreKt.getGAdReport().replaceDirect(url, this.mSplash != null ? this.mSplash.getAdInfo().getReportInfo() : null, (Motion) null);
        return getThirdAppIntent(getContext(), pkgName, appLinkRpl);
    }

    private Intent getThirdAppIntent(Context context, String pkgName, String uri) {
        PackageManager packageManager;
        if (context == null || TextUtils.isEmpty(pkgName) || TextUtils.isEmpty(uri) || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage(pkgName);
        intent.setData(Uri.parse(uri));
        intent.addFlags(268435456);
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, 65536);
        if (list.isEmpty()) {
            return null;
        }
        return intent;
    }

    protected void onJumpClick(Intent intent, String schema, String jumpUrl, boolean withFrom, SplashActionType type, boolean reportClick, String buttonId, ButtonClickData clickData) {
        BLog.i(TAG, "onJumpClick intent:" + intent + " jumpUrl:" + jumpUrl + " withFrom:" + withFrom + " SplashActionType:" + type + " buttonId:" + buttonId);
        if (reportClick) {
            long showTimeBeforeClick = calculateSplashRealDuration();
            SplashCustomReporterKt.reportSplashClick(this.mSplash, jumpUrl, buttonId, type.name(), intent != null ? intent.getDataString() : "", showTimeBeforeClick);
            Integer cardIndex = clickData != null ? clickData.getCardIndex() : null;
            SplashAdHelper.adReportSplashClicked(this.mSplash, withFrom, type, buttonId, showTimeBeforeClick, cardIndex);
        }
        if (!canShowSecondPage()) {
            SplashLiveReserveHelper.handleLiveBooking(getContext(), this.mSplash, type.toLiveReserveTriggerTypeValue().getValue());
            if (!openThirdApp(schema, String.valueOf(this.mSplash.id), jumpUrl, clickData)) {
                exitSplash(this.mSplash, jumpUrl);
                return;
            }
            BLog.i(TAG, "openThirdApp， success");
            Rect rect = getSearchLinkageRect();
            if (rect != null) {
                setQueryItem(this.mSplash, true);
                return;
            }
            return;
        }
        onTriggerSecondPage(type);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onJumpClick(Intent intent, String schema) {
        onJumpClick(intent, schema, this.mSplash.jumpUrl, false, SplashActionType.UNDEFINE, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onJumpClickWithFrom(Intent intent, String schema, SplashActionType type) {
        onJumpClick(intent, schema, this.mSplash.jumpUrl, true, type, true);
    }

    protected void onJumpClickWithoutReport(Intent intent, String schema) {
        onJumpClick(intent, schema, this.mSplash.jumpUrl, false, SplashActionType.UNDEFINE, false);
    }

    protected void onJumpClick(Intent intent, String schema, String jumpUrl, boolean withFrom, SplashActionType type, boolean reportClick) {
        onJumpClick(intent, schema, jumpUrl, withFrom, type, reportClick, null, null);
    }

    protected boolean openThirdApp(String schemaUrl, String splashId, String jumpUrl, ButtonClickData clickData) {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mClickJump = true;
        this.mSplashId = splashId;
        BLog.i(TAG, "openThirdApp, url = " + schemaUrl);
        String prioritySchemaUrl = null;
        String priorityJumpUrl = null;
        WxProgramInfo wxProgramInfo = null;
        if (clickData != null) {
            priorityJumpUrl = clickData.getPriorityJumpUrl();
            prioritySchemaUrl = clickData.getPrioritySchemaUrl();
            wxProgramInfo = clickData.getWxProgramInfo();
        }
        boolean success = SplashAdHelper.handleAdJump(getContext(), this.mSplash, schemaUrl, jumpUrl, prioritySchemaUrl, priorityJumpUrl, wxProgramInfo);
        if (this.mSplashViewModel != null) {
            this.mSplashViewModel.update(new SplashJumpClickEvent("open third app"));
        }
        if (success) {
            ISplash.SplashHost activity = getActivity();
            if (activity instanceof ISplash.SplashHost) {
                reportVideoPlay(calculateSplashRealDuration());
                activity.closeSplash();
            }
        }
        return success;
    }

    private void exitSplashByCountDown() {
        if (this.mSplashViewModel != null) {
            this.mSplashViewModel.update(new DoSplashLinkageAnimationAction("countdown"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Rect getLinkageTargetRect() {
        Rect rect;
        Splash splash = this.mSplash;
        boolean typeValid = (getActivity() == null || this.mSplashViewModel == null || splash == null || (!splash.isTopView() && !splash.isSearchLinkage())) ? false : true;
        if (!typeValid) {
            return null;
        }
        if (splash.isTopView()) {
            if (!String.valueOf(splash.id).equals(((SplashState) this.mSplashViewModel.getState().getValue()).getRealShowTopViewId()) || (rect = ((SplashState) this.mSplashViewModel.getState().getValue()).getRealBannerRect()) == null || rect.width() <= 0 || rect.height() <= 0) {
                return null;
            }
            return rect;
        }
        return getSearchLinkageRect();
    }

    private Rect getSearchLinkageRect() {
        Splash splash = this.mSplash;
        if (splash == null || !splash.isSearchLinkage()) {
            return null;
        }
        SplashSearchServiceImpl impl = SplashSearchServiceImplKt.getSplashSearchServiceImpl();
        if (impl == null || impl.isBrandShow()) {
            SplashAdHelper.reportSplashDefaultWordExpose(this.mSplash, 1);
            return null;
        }
        Rect rect = (Rect) this.mSplashViewModel.getSearchBarRect().getValue();
        if (rect == null || rect.width() <= 0 || rect.height() <= 0) {
            SplashAdHelper.reportSplashDefaultWordExpose(this.mSplash, 2);
            return null;
        }
        return rect;
    }

    public void setQueryItem(Splash splash, boolean jumped) {
        SplashSearchServiceImpl impl = SplashSearchServiceImplKt.getSplashSearchServiceImpl();
        if (splash == null || !splash.isSearchLinkage() || impl == null) {
            return;
        }
        if (impl.isBrandShow()) {
            BLog.i(TAG, "setQueryItem, brand show, cancel default keyword display");
            return;
        }
        BLog.i(TAG, "setQueryItem, id = " + splash.id + ", keyword = " + splash.keyword);
        DefaultWordItem wordItem = new DefaultWordItem();
        wordItem.setQuery(splash.keyword);
        wordItem.setId(splash.id);
        int defaultWordType = 2;
        if (jumped) {
            defaultWordType = 3;
        }
        wordItem.setDefaultWordType(defaultWordType);
        impl.getDefaultWordItem().setValue(wordItem);
        impl.refreshDefaultWord().setValue(true);
        impl.keepOnceRefreshLiveData().setValue(Boolean.valueOf(jumped));
        SplashAdHelper.reportSplashDefaultWordExpose(this.mSplash, 0);
    }

    public void onDetach() {
        super.onDetach();
        BLog.i(TAG, "onDetach");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doTransformAnimation(Rect rect) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float calculateExposeTimeWhenSkip() {
        return ((float) (SystemClock.elapsedRealtime() - this.mStartTimeMIll)) / 1000.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long calculateSplashRealDuration() {
        return SystemClock.elapsedRealtime() - this.mStartTimeMIll;
    }

    public void setSplash(Splash splash) {
        this.mSplash = splash;
    }

    public Splash getSplash() {
        return this.mSplash;
    }

    protected void reportVideoPlay(long duration) {
        if (this.mSplash != null && this.mSplash.isVideo() && this.mSplash.adCb != null) {
            UIExtraParams uiExtraParams = new UIExtraParams().SHOW_TIME(duration);
            GAdCoreKt.getGAdReport().uiEvent("splash_video_play", new SimpleAdReportPreset(this.mSplash.adCb, ""), uiExtraParams);
        }
    }

    public boolean needPrepare() {
        return (this.mSplash == null || !this.mSplash.needPrepare() || this.mIsReady) ? false : true;
    }

    public void onTriggerSecondPageEggVideo() {
    }

    public SplashAlphaPlayer getSecondPageEggVideoPlayer() {
        return null;
    }

    private void setAdInspector() {
        Object obj;
        if (this.mSplash == null) {
            return;
        }
        final IInspector.AdData adData = new IInspector.AdData(this.mSplash.adCb != null ? this.mSplash.adCb : "", this.mSplash.jumpTip, this.mSplash.extra != null ? String.valueOf(this.mSplash.extra.get("sales_type")) : null, (Integer) null, String.valueOf(this.mSplash.splashCreativeId), this.mSplash.extra != null ? String.valueOf(this.mSplash.extra.get("track_id")) : null);
        adData.setRawAction(new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.BaseSplash$$ExternalSyntheticLambda1
            public final Object invoke() {
                return BaseSplash.this.m1526lambda$setAdInspector$6$tvdanmakubiliuisplashadpageBaseSplash();
            }
        });
        GAdCoreKt.getGAdDebug().getInspector().addInspectorInfo(new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.BaseSplash$$ExternalSyntheticLambda2
            public final Object invoke() {
                return BaseSplash.lambda$setAdInspector$7(adData);
            }
        });
        IInspector.IJob job = GAdCoreKt.getGAdDebug().getInspector().getDrawingStage(this.mSplash.adCb).addAsyncJob("卡片渲染");
        job.start();
        final AdReportInfo build = new AdReportInfo.Builder(true).adcb(this.mSplash.adCb).build();
        for (AdDebugPlugin plugin : GAdCoreKt.getGAdDebug().getPlugins()) {
            ConstraintLayout constraintLayout = this.mRootContainer;
            Function0 function0 = new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.page.BaseSplash$$ExternalSyntheticLambda3
                public final Object invoke() {
                    return BaseSplash.lambda$setAdInspector$8(build);
                }
            };
            String simpleName = getClass().getSimpleName();
            StringBuilder append = new StringBuilder().append("sales_type:");
            if (this.mSplash.extra != null) {
                obj = this.mSplash.extra.get("sales_type");
            } else {
                obj = StringsKt.NULL_STRING;
            }
            plugin.hook(constraintLayout, build, function0, new DebugMarkStyle(1, simpleName, append.append(obj).append(",\ncreative_id:").append(this.mSplash.splashCreativeId).toString()), AdSlot.SPALSH);
        }
        job.success((String) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setAdInspector$6$tv-danmaku-bili-ui-splash-ad-page-BaseSplash  reason: not valid java name */
    public /* synthetic */ String m1526lambda$setAdInspector$6$tvdanmakubiliuisplashadpageBaseSplash() {
        return GsonKtKt.getJsonString(this.mSplash);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ IInspector.InspectorInfo lambda$setAdInspector$7(IInspector.AdData adData) {
        return new IInspector.InspectorInfo(AdSlot.SPALSH, adData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$setAdInspector$8(IAdReportInfo mockReportInfo) {
        return mockReportInfo;
    }
}