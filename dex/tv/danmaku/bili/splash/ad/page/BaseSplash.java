package tv.danmaku.bili.splash.ad.page;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.homepage.splash.IAdSplashHost;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.PlayerEvent;
import com.bilibili.lib.homepage.splash.actions.RealBannerRectUpdateAction;
import com.bilibili.lib.homepage.splash.globalactions.SplashCreativeIdUpdateAction;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.moduleservice.splash.SplashCoreService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.adsplash.databinding.BiliAppAdSplashFragmentBinding;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.splash.ad.business.livereserve.LiveReserveTriggerType;
import tv.danmaku.bili.splash.ad.business.livereserve.LiveReserveTriggerTypeKt;
import tv.danmaku.bili.splash.ad.business.livereserve.SplashLiveReserveHelper;
import tv.danmaku.bili.splash.ad.button.SplashButtonHelper;
import tv.danmaku.bili.splash.ad.button.model.ButtonClickData;
import tv.danmaku.bili.splash.ad.button.model.SplashActionType;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.splash.ad.core.SplashUpdateComponentKt;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.page.component.ActionComponentKt;
import tv.danmaku.bili.splash.ad.page.component.ComponentHolder;
import tv.danmaku.bili.splash.ad.page.component.CountdownComponentKt;
import tv.danmaku.bili.splash.ad.page.component.FullScreenSlideComponentKt;
import tv.danmaku.bili.splash.ad.page.component.LinkageAnimationComponentKt;
import tv.danmaku.bili.splash.ad.page.component.StateObserverComponentKt;
import tv.danmaku.bili.splash.ad.page.component.StatisticComponentKt;
import tv.danmaku.bili.splash.ad.page.component.TopViewTransitionComponentKt;
import tv.danmaku.bili.splash.ad.page.component.ViewInitComponentKt;
import tv.danmaku.bili.splash.ad.page.secondpage.SecondPageComponentKt;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.state.actions.DoSplashLinkageAnimationAction;
import tv.danmaku.bili.splash.ad.state.actions.SplashJumpClickEvent;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.splash.ad.utils.SplashUtilsKt;
import tv.danmaku.bili.splash.ad.widget.OnClickTouchListener;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: BaseSplash.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b!\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0016JR\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020,2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020,2\b\u00107\u001a\u0004\u0018\u0001012\b\u00108\u001a\u0004\u0018\u000109H\u0016J$\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020,2\b\u0010<\u001a\u0004\u0018\u0001012\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020$H\u0016J\b\u0010@\u001a\u00020$H\u0016J-\u0010A\u001a\u00020$2#\u0010B\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020$0CH\u0016J$\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020,2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u00102\u001a\u0004\u0018\u000101H\u0016J\b\u0010I\u001a\u00020$H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006J"}, d2 = {"Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "Lcom/bilibili/lib/ui/BaseFragment;", "Ltv/danmaku/bili/splash/ad/page/ISplashEvent;", "<init>", "()V", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "getSplash$adsplash_debug", "()Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "setSplash$adsplash_debug", "(Ltv/danmaku/bili/splash/ad/model/SplashOrder;)V", "binding", "Ltv/danmaku/bili/adsplash/databinding/BiliAppAdSplashFragmentBinding;", "getBinding$adsplash_debug", "()Ltv/danmaku/bili/adsplash/databinding/BiliAppAdSplashFragmentBinding;", "setBinding$adsplash_debug", "(Ltv/danmaku/bili/adsplash/databinding/BiliAppAdSplashFragmentBinding;)V", "componentHolder", "Ltv/danmaku/bili/splash/ad/page/component/ComponentHolder;", "getComponentHolder$adsplash_debug", "()Ltv/danmaku/bili/splash/ad/page/component/ComponentHolder;", "viewModel", "Lcom/bilibili/lib/homepage/splash/SplashViewModel;", "getViewModel$adsplash_debug", "()Lcom/bilibili/lib/homepage/splash/SplashViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showMainMaterial", "onSkipClick", "setFullScreenClickListener", "touchContainer", "onSplashReady", "realReady", "", "onJumpClick", "intent", "Landroid/content/Intent;", "schema", "", "jumpUrl", "withFrom", "actionType", "Ltv/danmaku/bili/splash/ad/button/model/SplashActionType;", "reportClick", "buttonId", "clickData", "Ltv/danmaku/bili/splash/ad/button/model/ButtonClickData;", "onPageJump", "isSecondPage", "secondPageJumpReason", "liveReserveTriggerType", "Ltv/danmaku/bili/splash/ad/business/livereserve/LiveReserveTriggerType;", "onCountdownEnd", "stopCountdown", "asyncGetLinkageTransformView", AuthResultCbHelper.ARGS_CALLBACK, "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "transformView", "exitSplash", "jumped", "onDestroyView", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class BaseSplash extends BaseFragment implements ISplashEvent {
    public static final int $stable = 8;
    public BiliAppAdSplashFragmentBinding binding;
    private final Lazy viewModel$delegate;
    private SplashOrder splash = new SplashOrder(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, 0, 0, null, null, null, null, 0, null, null, 0, 0, null, 0, null, null, false, false, null, false, null, 0, 0, 0.0f, 0, 0, 0, null, null, 0, false, false, 0, null, 0, 0, null, null, null, null, null, 0, null, null, false, null, 0, null, null, 0, false, 0, false, -1, -1, 15, null);
    private final ComponentHolder componentHolder = new ComponentHolder();

    public BaseSplash() {
        final Fragment $this$activityViewModels_u24default$iv = (Fragment) this;
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$activityViewModels_u24default$iv, Reflection.getOrCreateKotlinClass(SplashViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.splash.ad.page.BaseSplash$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1410invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.splash.ad.page.BaseSplash$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1411invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.splash.ad.page.BaseSplash$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1412invoke() {
                return $this$activityViewModels_u24default$iv.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    public final SplashOrder getSplash$adsplash_debug() {
        return this.splash;
    }

    public final void setSplash$adsplash_debug(SplashOrder splashOrder) {
        Intrinsics.checkNotNullParameter(splashOrder, "<set-?>");
        this.splash = splashOrder;
    }

    public final BiliAppAdSplashFragmentBinding getBinding$adsplash_debug() {
        BiliAppAdSplashFragmentBinding biliAppAdSplashFragmentBinding = this.binding;
        if (biliAppAdSplashFragmentBinding != null) {
            return biliAppAdSplashFragmentBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding$adsplash_debug(BiliAppAdSplashFragmentBinding biliAppAdSplashFragmentBinding) {
        Intrinsics.checkNotNullParameter(biliAppAdSplashFragmentBinding, "<set-?>");
        this.binding = biliAppAdSplashFragmentBinding;
    }

    public final ComponentHolder getComponentHolder$adsplash_debug() {
        return this.componentHolder;
    }

    public final SplashViewModel getViewModel$adsplash_debug() {
        return (SplashViewModel) this.viewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        BiliAppAdSplashFragmentBinding inflate = BiliAppAdSplashFragmentBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding$adsplash_debug(inflate);
        return (View) getBinding$adsplash_debug().getRoot();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.componentHolder.setViewCreateTimeMs(System.currentTimeMillis());
        if (getActivity() == null || savedInstanceState != null) {
            ISplashEvent.CC.exitSplash$default(this, false, null, null, 6, null);
            return;
        }
        long id = this.splash.getId();
        String videoUrl = this.splash.getVideoUrl();
        BLog.i("[Splash]BaseSplash", "onViewCreated id = " + id + ", videoUrl = " + videoUrl + ", imageUrl = " + this.splash.getImageUrl());
        StateObserverComponentKt.observerOnViewCreated(this);
        ViewInitComponentKt.initView(this);
    }

    public void showMainMaterial() {
        ViewInitComponentKt.displayMainImage(this, getBinding$adsplash_debug().splashView);
    }

    public void onSkipClick() {
        BLog.i("[Splash]BaseSplash", "showSkipButton, skip clicked");
        ISplashEvent.CC.exitSplash$default(this, false, null, null, 6, null);
    }

    public final void setFullScreenClickListener(View touchContainer) {
        Context context;
        if (touchContainer == null || (context = getContext()) == null) {
            return;
        }
        touchContainer.setOnTouchListener(new OnClickTouchListener(context, new Function0() { // from class: tv.danmaku.bili.splash.ad.page.BaseSplash$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit fullScreenClickListener$lambda$0;
                fullScreenClickListener$lambda$0 = BaseSplash.setFullScreenClickListener$lambda$0(BaseSplash.this);
                return fullScreenClickListener$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setFullScreenClickListener$lambda$0(BaseSplash this$0) {
        if (this$0.componentHolder.isShowAnimator()) {
            return Unit.INSTANCE;
        }
        SplashAdHelper.INSTANCE.adSplashOutsideClick$adsplash_debug(this$0.splash);
        if (ExtSplashOrderKt.isSplashClickable(this$0.splash)) {
            ISplashEvent.CC.onJumpClick$default(this$0, SplashUtilsKt.buildThirdIntent(this$0.splash, this$0.splash.getAppLink(), this$0.splash.getAppPkg()), this$0.splash.getAppLink(), null, true, null, true, null, null, BR.firstButtonCharSequence, null);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public void onSplashReady(boolean realReady) {
        BLog.i("[Splash]BaseSplash", "onSplashReady， realReady = " + realReady + ", viewLive = " + ListExtentionsKt.isViewAlive((Fragment) this));
        if (!ListExtentionsKt.isViewAlive((Fragment) this)) {
            return;
        }
        TopViewTransitionComponentKt.initTopViewTransitionComponent(this);
        this.componentHolder.setPrepareJob(null);
        if (this.componentHolder.isReady()) {
            return;
        }
        this.componentHolder.setReady(true);
        if (this.splash.getRuntimeExtra().isHotSplash()) {
            SplashAdHelper.adReportSplashExposed$adsplash_debug$default(SplashAdHelper.INSTANCE, this.splash, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_HOT, null, 4, null);
            if (SplashConfigKt.getEnableHotLaunchRequestList() && !SplashConfigKt.getEnableHotLaunchBehaviorRequestList()) {
                SplashUpdateComponentKt.updateSplash(SplashConfigKt.getHotSplashDelayRefreshListTimeMs(), BusinessSplashDefineKt.SPLASH_OPEN_EVENT_HOT);
            }
        } else {
            SplashAdHelper.adReportSplashExposed$adsplash_debug$default(SplashAdHelper.INSTANCE, this.splash, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_COLD, null, 4, null);
        }
        SplashViewModel.Companion.update(new SplashCreativeIdUpdateAction(this.splash.getSplashCreativeId()));
        if (this.splash.isRealTimeSplash()) {
            SplashAdHelper.INSTANCE.reportRealtimeMatShow$adsplash_debug(this.splash);
            SplashCustomReporterKt.reportRealtimeMatShow(this.splash);
        }
        SplashCustomReporterKt.reportSplashExpose(this.splash);
        SplashUpdateComponentKt.increaseSplashShowCount(this.splash);
        this.componentHolder.setSplashStartTimeMs(SystemClock.elapsedRealtime());
        CountdownComponentKt.startCountDown(this);
        FragmentActivity activity = getActivity();
        IAdSplashHost iAdSplashHost = activity instanceof IAdSplashHost ? (IAdSplashHost) activity : null;
        if (iAdSplashHost != null) {
            iAdSplashHost.onADSplashReady();
        }
    }

    @Override // tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void onJumpClick(Intent intent, String schema, String jumpUrl, boolean withFrom, SplashActionType actionType, boolean reportClick, String buttonId, ButtonClickData clickData) {
        ButtonClickData buttonClickData;
        SplashActionType splashActionType;
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        BLog.i("[Splash]BaseSplash", "onJumpClick intent:" + intent + " jumpUrl:" + jumpUrl + " withFrom:" + withFrom + " SplashActionType:" + actionType + " buttonId:" + buttonId);
        if (!reportClick) {
            buttonClickData = clickData;
            splashActionType = actionType;
        } else {
            long showTimeBeforeClick = StatisticComponentKt.calculateSplashRealDuration(this);
            SplashCustomReporterKt.reportSplashClick(this.splash, jumpUrl, buttonId, actionType.name(), intent != null ? intent.getDataString() : "", showTimeBeforeClick);
            SplashAdHelper splashAdHelper = SplashAdHelper.INSTANCE;
            SplashOrder splashOrder = this.splash;
            buttonClickData = clickData;
            splashActionType = actionType;
            splashAdHelper.adReportSplashClicked$adsplash_debug(splashOrder, withFrom, actionType, buttonId, showTimeBeforeClick, clickData != null ? clickData.getCardIndex() : null);
        }
        if (SecondPageComponentKt.canShowSecondPage(this)) {
            SecondPageComponentKt.onTriggerSecondPage(this, splashActionType);
            return;
        }
        SplashLiveReserveHelper.handleLiveBooking$default(SplashLiveReserveHelper.INSTANCE, getContext(), this.splash, LiveReserveTriggerTypeKt.getToLiveReserveTriggerType(actionType).getValue(), false, null, 24, null);
        stopCountdown();
        if (ActionComponentKt.openThirdApp(this, schema, String.valueOf(this.splash.getId()), jumpUrl, buttonClickData)) {
            Rect rect = LinkageAnimationComponentKt.getSearchLinkageRect(this);
            if (rect != null) {
                LinkageAnimationComponentKt.setQueryItem(this, true);
                return;
            }
            return;
        }
        exitSplash(true, this.splash, jumpUrl);
    }

    @Override // tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void onPageJump(boolean isSecondPage, String secondPageJumpReason, LiveReserveTriggerType liveReserveTriggerType) {
        boolean handleAdJump;
        if (liveReserveTriggerType != null) {
            SplashLiveReserveHelper.handleLiveBooking$default(SplashLiveReserveHelper.INSTANCE, getContext(), this.splash, liveReserveTriggerType.getValue(), false, null, 24, null);
        }
        if (isSecondPage && secondPageJumpReason != null) {
            SplashAdHelper.INSTANCE.reportSecondPageVideoJump$adsplash_debug(this.splash, secondPageJumpReason);
        }
        getViewModel$adsplash_debug().update(new SplashJumpClickEvent("onPageJump"));
        handleAdJump = SplashAdHelper.INSTANCE.handleAdJump(getActivity(), this.splash, (r18 & 4) != 0 ? "" : this.splash.getInteractUrl(), (r18 & 8) != 0 ? "" : this.splash.getJumpUrl(), (r18 & 16) != 0 ? "" : null, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
        if (!handleAdJump) {
            Intent intent = SplashUtilsKt.buildThirdIntent(this.splash, this.splash.getAppLink(), this.splash.getAppPkg());
            ISplashEvent.CC.onJumpClick$default(this, intent, this.splash.getAppLink(), this.splash.getJumpUrl(), false, null, false, null, null, BR.guestPureEnjoyMsgList, null);
            return;
        }
        ISplashEvent.CC.exitSplash$default(this, true, null, null, 6, null);
    }

    public void onCountdownEnd() {
        SplashCoreService splashCoreService = this.componentHolder.getSplashCoreService();
        if (splashCoreService != null) {
            splashCoreService.setSplashDurationSession(StatisticComponentKt.calculateSplashRealDuration(this));
        }
        if (ExtSplashOrderKt.isInteractSupport(this.splash)) {
            boolean triggerJump = FullScreenSlideComponentKt.handleInteractEvent(this, getBinding$adsplash_debug().splashInteractView.calculatePath(), getBinding$adsplash_debug().splashInteractView.calculateSlideAngle());
            if (triggerJump) {
                return;
            }
        }
        SplashButtonHelper $this$onCountdownEnd_u24lambda_u240 = this.componentHolder.getButtonHelper();
        $this$onCountdownEnd_u24lambda_u240.handleSlideEvent();
        $this$onCountdownEnd_u24lambda_u240.handleRunningBall();
        getViewModel$adsplash_debug().update(new PlayerEvent.OnStop("countdown"));
        getViewModel$adsplash_debug().update(new DoSplashLinkageAnimationAction("countdown"));
    }

    @Override // tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void stopCountdown() {
        CountdownComponentKt.doStopCountdown(this);
    }

    public void asyncGetLinkageTransformView(Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, AuthResultCbHelper.ARGS_CALLBACK);
        function1.invoke(LinkageAnimationComponentKt.getLinkageAnimationTransformView(this));
    }

    @Override // tv.danmaku.bili.splash.ad.page.ISplashEvent
    public void exitSplash(boolean jumped, SplashOrder splash, String jumpUrl) {
        boolean z;
        BLog.i("[Splash]BaseSplash", "exitSplash, jumped = " + jumped);
        if (jumped) {
            Rect rect = LinkageAnimationComponentKt.getSearchLinkageRect(this);
            if (rect != null) {
                LinkageAnimationComponentKt.setQueryItem(this, true);
            }
        }
        ActionComponentKt.setJumpAnimation(this);
        if (splash != null) {
            String str = jumpUrl;
            if (str == null || StringsKt.isBlank(str)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
        }
        stopCountdown();
        if (splash != null) {
            this.componentHolder.setClickJump(true);
            this.componentHolder.setSplashId(String.valueOf(splash.getId()));
        } else {
            this.componentHolder.setClickJump(false);
            this.componentHolder.setSplashId(null);
        }
        getViewModel$adsplash_debug().update(new PlayerEvent.OnStop((String) null, 1, (DefaultConstructorMarker) null));
        if (jumped) {
            getViewModel$adsplash_debug().update(new SplashJumpClickEvent("exitSplash"));
        }
        ActionComponentKt.reportVideoPlay(this);
        FragmentActivity activity = getActivity();
        IAdSplashHost iAdSplashHost = activity instanceof IAdSplashHost ? (IAdSplashHost) activity : null;
        if (iAdSplashHost != null) {
            iAdSplashHost.exitSplash(splash, jumpUrl, jumped);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (SplashConfigKt.getPerformDestroyViewOnDetach()) {
            stopCountdown();
            SplashViewModel.SplashExitInfo exitInfo = (SplashViewModel.SplashExitInfo) getViewModel$adsplash_debug().getSplashExit().getValue();
            if (exitInfo == null) {
                exitInfo = new SplashViewModel.SplashExitInfo();
            }
            SplashViewModel.SplashExitInfo $this$onDestroyView_u24lambda_u240 = exitInfo;
            $this$onDestroyView_u24lambda_u240.exitWithJump = this.componentHolder.getClickJump();
            $this$onDestroyView_u24lambda_u240.exitSplashId = this.componentHolder.getSplashId();
            $this$onDestroyView_u24lambda_u240.exitWithAnim = this.componentHolder.getExecuteAnim();
            $this$onDestroyView_u24lambda_u240.isTopView = ExtSplashOrderKt.isTopView(this.splash);
            $this$onDestroyView_u24lambda_u240.setAnimState(2);
            getViewModel$adsplash_debug().getSplashExit().postValue(exitInfo);
            getViewModel$adsplash_debug().update(new RealBannerRectUpdateAction((Rect) null));
            SplashCustomReporterKt.reportSplashDuration(this.splash);
            BLog.i("[Splash]BaseSplash", "handleDestroyView");
        }
    }
}