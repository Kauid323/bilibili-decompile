package tv.danmaku.bili.splash.ad.button;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.airbnb.lottie.LottieComposition;
import com.bilibili.app.comm.list.common.sensor.AcceleratorSensor;
import com.bilibili.app.comm.list.common.sensor.ISensor;
import com.bilibili.app.comm.list.common.sensor.RotateDegreeSensor;
import com.bilibili.app.comm.list.common.sensor.SensorSet;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.droid.StringUtil;
import com.bilibili.droid.WindowManagerHelper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.adsplash.R;
import tv.danmaku.bili.splash.ad.button.card.SplashButtonWebpBrandCardKt;
import tv.danmaku.bili.splash.ad.button.model.DegradeType;
import tv.danmaku.bili.splash.ad.button.model.GuideButtonViewInfo;
import tv.danmaku.bili.splash.ad.button.model.GuideButtonViewListInfo;
import tv.danmaku.bili.splash.ad.button.model.SplashButtonClickListener;
import tv.danmaku.bili.splash.ad.button.sensor.SplashRotateSensorHelperKt;
import tv.danmaku.bili.splash.ad.button.widget.SafeLottieCompositionFactory;
import tv.danmaku.bili.splash.ad.chronos.SplashChronosHelper;
import tv.danmaku.bili.splash.ad.model.ExtSplashGuideButtonKt;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashSecondPageInfo;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelper;
import tv.danmaku.bili.splash.ad.utils.SplashUtilsKt;
import tv.danmaku.bili.splash.ad.utils.UiUtilsKt;
import tv.danmaku.bili.splash.ad.utils.sensor.SplashSensorDebugKt;
import tv.danmaku.bili.splash.ad.utils.sensor.SplashSensorUtilsKt;
import tv.danmaku.bili.splash.ad.widget.DeliverySlideEventFrameLayout;
import tv.danmaku.bili.splash.ad.widget.SafeLottieAnimationView;
import tv.danmaku.bili.splash.ad.widget.SplashInteractView;
import tv.danmaku.bili.splash.ad.widget.SplashRunningBallViewV2;
import tv.danmaku.bili.splash.ad.widget.SplashSlideUnlockView;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashButtonHelper.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J=\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u001dJ\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0011H\u0002JF\u0010!\u001a*\u0012\u0004\u0012\u00020#\u0012 \u0012\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$j\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&`'0\"2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020&0)2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002Ji\u0010*\u001a\u00020+2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\"\u0010-\u001a\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$j\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&`'2\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u0002002\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b1J\u0018\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u0002042\u0006\u0010,\u001a\u00020&H\u0002J\u0012\u00105\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u000104H\u0002J\u0012\u00106\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u000104H\u0002J8\u00107\u001a\u000200*\u0002002\u0006\u00108\u001a\u00020&2\"\u0010-\u001a\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$j\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&`'H\u0002J4\u00107\u001a\u0002002\u0006\u00108\u001a\u00020&2\"\u0010-\u001a\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$j\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&`'H\u0002J4\u00109\u001a\u0002002\u0006\u00108\u001a\u00020&2\"\u0010-\u001a\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$j\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&`'H\u0002J4\u0010:\u001a\u0002002\u0006\u00108\u001a\u00020&2\"\u0010-\u001a\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$j\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&`'H\u0002J\"\u0010;\u001a\u0004\u0018\u0001042\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010=\u001a\u00020>2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020&H\u0002J \u0010?\u001a\u0002042\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010A\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u000200H\u0002J*\u0010B\u001a\u0004\u0018\u0001042\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J*\u0010C\u001a\u0004\u0018\u0001042\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010E\u001a\u0004\u0018\u0001042\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J*\u0010F\u001a\u0004\u0018\u0001042\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J*\u0010G\u001a\u0004\u0018\u0001042\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\u0010\u0010H\u001a\u0002002\u0006\u0010,\u001a\u00020&H\u0002J\u001a\u0010I\u001a\u0002002\u0006\u0010,\u001a\u00020&2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\u0010\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0005H\u0002J\u0018\u0010O\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u0005H\u0002J\u0006\u0010Q\u001a\u00020\u000fJ\u0006\u0010R\u001a\u00020\u000fJ\u001b\u0010S\u001a\u000200*\u0002002\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u000f0UH\u0082\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V²\u0006\n\u0010W\u001a\u00020XX\u008a\u0084\u0002"}, d2 = {"Ltv/danmaku/bili/splash/ad/button/SplashButtonHelper;", "", "<init>", "()V", "mScreenWidth", "", "mScreenHeight", "mSlideBtnList", "", "Ltv/danmaku/bili/splash/ad/widget/SplashSlideUnlockView;", "mRunningBallList", "Ltv/danmaku/bili/splash/ad/widget/SplashRunningBallViewV2;", "mSplash", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "injectSplashButton", "", "rootContainer", "Landroid/view/ViewGroup;", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "baseSplash", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "listener", "Ltv/danmaku/bili/splash/ad/button/model/SplashButtonClickListener;", "generateSecondPageButtonList", "Ltv/danmaku/bili/splash/ad/button/model/GuideButtonViewListInfo;", "ctx", "Landroid/content/Context;", "parentWidth", "parentHeight", "generateSecondPageButtonList$adsplash_debug", "updateDeviceSize", "context", "container", "checkButtonResState", "Lkotlin/Pair;", "Ltv/danmaku/bili/splash/ad/button/model/DegradeType;", "Ljava/util/HashMap;", "", "Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", "Lkotlin/collections/HashMap;", "buttons", "", "generateView", "Ltv/danmaku/bili/splash/ad/button/model/GuideButtonViewInfo;", "splashGuideButton", "validMap", "degradeType", "isSecondPage", "", "generateView$adsplash_debug", "expandClickArea", "view", "Landroid/view/View;", "disableInteractiveView", "disableButtonAreaSlide", "checkSelfAndRelatedValid", "button", "checkSelfValid", "checkRelatedValid", "genCountdownView", "buttonData", "genNonClickableTextView", "Landroid/widget/TextView;", "genTextView", "guideButton", "reportButtonDegrade", "genImageView", "genTwistView", "splashButton", "genRunningBallView", "genShakeView", "genSlideView", "checkJumpPermission", "checkSchemaListJumpPermission", "schema", "", "genTextViewBg", "Landroid/graphics/drawable/Drawable;", "bgColor", "genSlideViewBg", "borderColor", "handleSlideEvent", "handleRunningBall", "runInFalse", "action", "Lkotlin/Function0;", "adsplash_debug", "deviceSize", "Landroid/graphics/Point;"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashButtonHelper {
    public static final int $stable = 8;
    private List<SplashRunningBallViewV2> mRunningBallList;
    private int mScreenHeight;
    private int mScreenWidth;
    private List<SplashSlideUnlockView> mSlideBtnList;
    private SplashOrder mSplash;

    public final void injectSplashButton(final ViewGroup rootContainer, final SplashOrder splash, final BaseSplash baseSplash, final SplashButtonClickListener listener) {
        final Context context;
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Intrinsics.checkNotNullParameter(baseSplash, "baseSplash");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final List buttons = splash.getSplashGuideButton();
        if (buttons == null || rootContainer == null || (context = rootContainer.getContext()) == null) {
            return;
        }
        this.mSplash = splash;
        this.mSlideBtnList = new ArrayList();
        this.mRunningBallList = new ArrayList();
        final ViewTreeObserver observer = rootContainer.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$injectSplashButton$1
            /* JADX WARN: Incorrect condition in loop: B:8:0x005e */
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onGlobalLayout() {
                Pair pair;
                int i;
                int i2;
                if (observer.isAlive()) {
                    observer.removeOnGlobalLayoutListener(this);
                } else {
                    rootContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                this.updateDeviceSize(context, rootContainer);
                pair = this.checkButtonResState(buttons, context);
                DegradeType degradeType = (DegradeType) pair.getFirst();
                HashMap validMap = (HashMap) pair.getSecond();
                Iterable $this$forEach$iv = buttons;
                SplashButtonHelper splashButtonHelper = this;
                Context context2 = context;
                SplashOrder splashOrder = splash;
                BaseSplash baseSplash2 = baseSplash;
                SplashButtonClickListener splashButtonClickListener = listener;
                ViewGroup viewGroup = rootContainer;
                Iterator<T> it = $this$forEach$iv.iterator();
                boolean disableOutsideInteractiveView = false;
                while (disableOutsideInteractiveView) {
                    Object element$iv = it.next();
                    SplashGuideButton it2 = (SplashGuideButton) element$iv;
                    Pair pair2 = pair;
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    ViewGroup viewGroup2 = viewGroup;
                    SplashButtonClickListener splashButtonClickListener2 = splashButtonClickListener;
                    BaseSplash baseSplash3 = baseSplash2;
                    SplashOrder splashOrder2 = splashOrder;
                    GuideButtonViewInfo viewInfo = splashButtonHelper.generateView$adsplash_debug(context2, it2, splashOrder, baseSplash2, validMap, degradeType, false, splashButtonClickListener2);
                    disableOutsideInteractiveView = disableOutsideInteractiveView || viewInfo.getDisableOutsideInteractiveView();
                    View v = viewInfo.getView();
                    if (v != null) {
                        viewGroup2.addView(v);
                        if (v.isClickable()) {
                            splashButtonHelper.expandClickArea(v, it2);
                        }
                    }
                    viewGroup = viewGroup2;
                    splashOrder = splashOrder2;
                    pair = pair2;
                    $this$forEach$iv = $this$forEach$iv2;
                    splashButtonClickListener = splashButtonClickListener2;
                    baseSplash2 = baseSplash3;
                }
                if (disableOutsideInteractiveView) {
                    BLog.w("[Splash]SplashButtonHelper", "downgrade happened, ready to disable outside interactive view");
                    this.disableInteractiveView(baseSplash.getView());
                }
                Context context3 = context;
                i = this.mScreenWidth;
                i2 = this.mScreenHeight;
                View v2 = SplashButtonFactoryKt.createSplashElementAnimationView(context3, i, i2, splash, listener);
                if (v2 != null) {
                    rootContainer.addView(v2, 0);
                }
                if (SplashChronosHelper.INSTANCE.getFawkesChronosSplashEnabled()) {
                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(baseSplash), (CoroutineContext) null, (CoroutineStart) null, new SplashButtonHelper$injectSplashButton$1$onGlobalLayout$3(context, splash, rootContainer, null), 3, (Object) null);
                }
            }
        });
    }

    /* JADX WARN: Incorrect condition in loop: B:15:0x00a3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final GuideButtonViewListInfo generateSecondPageButtonList$adsplash_debug(Context ctx, int parentWidth, int parentHeight, SplashOrder splash, BaseSplash baseSplash, SplashButtonClickListener listener) {
        List buttons;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Intrinsics.checkNotNullParameter(baseSplash, "baseSplash");
        Intrinsics.checkNotNullParameter(listener, "listener");
        SplashSecondPageInfo secondPage = splash.getSecondPage();
        if (secondPage == null || (buttons = secondPage.getSecondPageButtons()) == null) {
            return new GuideButtonViewListInfo(CollectionsKt.emptyList(), false);
        }
        this.mSlideBtnList = new ArrayList();
        this.mRunningBallList = new ArrayList();
        this.mScreenWidth = parentWidth;
        this.mScreenHeight = parentHeight;
        Pair pair = checkButtonResState(buttons, ctx);
        DegradeType degradeType = (DegradeType) pair.getFirst();
        HashMap validMap = (HashMap) pair.getSecond();
        List buttonViewList = new ArrayList();
        List $this$filter$iv = buttons;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (ExtSplashGuideButtonKt.isValidSecondPageButtonType((SplashGuideButton) element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        Iterator it = $this$forEach$iv.iterator();
        boolean disableOutsideInteractiveView = false;
        while (disableOutsideInteractiveView) {
            Object element$iv = it.next();
            SplashGuideButton it2 = (SplashGuideButton) element$iv;
            boolean disableOutsideInteractiveView2 = disableOutsideInteractiveView;
            List buttonViewList2 = buttonViewList;
            GuideButtonViewInfo viewInfo = generateView$adsplash_debug(ctx, it2, splash, baseSplash, validMap, degradeType, true, listener);
            disableOutsideInteractiveView = disableOutsideInteractiveView2 || viewInfo.getDisableOutsideInteractiveView();
            View v = viewInfo.getView();
            if (v != null) {
                buttonViewList2.add(v);
                if (v.isClickable()) {
                    expandClickArea(v, it2);
                }
            }
            buttonViewList = buttonViewList2;
        }
        return new GuideButtonViewListInfo(buttonViewList, disableOutsideInteractiveView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDeviceSize(final Context context, ViewGroup container) {
        Lazy deviceSize$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda2
            public final Object invoke() {
                Point displayRealSize;
                displayRealSize = WindowManagerHelper.getDisplayRealSize(context);
                return displayRealSize;
            }
        });
        Integer valueOf = Integer.valueOf(container.getMeasuredWidth());
        int it = valueOf.intValue();
        int it2 = it > 0 ? 1 : 0;
        if (it2 == 0) {
            valueOf = null;
        }
        this.mScreenWidth = valueOf != null ? valueOf.intValue() : updateDeviceSize$lambda$1(deviceSize$delegate).x;
        Integer valueOf2 = Integer.valueOf(container.getMeasuredHeight());
        int it3 = valueOf2.intValue();
        Integer num = it3 > 0 ? valueOf2 : null;
        this.mScreenHeight = num != null ? num.intValue() : updateDeviceSize$lambda$1(deviceSize$delegate).y;
    }

    private static final Point updateDeviceSize$lambda$1(Lazy<? extends Point> lazy) {
        Object value = lazy.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Point) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<DegradeType, HashMap<Long, SplashGuideButton>> checkButtonResState(List<SplashGuideButton> list, Context context) {
        Object degradeType = DegradeType.INVALID_RES;
        HashMap validMap = new HashMap();
        List<SplashGuideButton> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            SplashGuideButton it = (SplashGuideButton) element$iv;
            if (!ExtSplashGuideButtonKt.getHitSlideStyle(it) && !ExtSplashGuideButtonKt.hitImageStyle(it, checkJumpPermission(it)) && !ExtSplashGuideButtonKt.getHitTextViewStyle(it) && !ExtSplashGuideButtonKt.hitNoInteractLottieView(it, checkJumpPermission(it)) && !ExtSplashGuideButtonKt.hitCountDownStyle(it, checkJumpPermission(it)) && !ExtSplashGuideButtonKt.getHitCountdownStyleV2(it)) {
                if (ExtSplashGuideButtonKt.hitShakeStyle(it, checkJumpPermission(it))) {
                    boolean $this$runInFalse$iv = SplashSensorUtilsKt.hasAccSensorAndEnable(context);
                    if (!$this$runInFalse$iv) {
                        degradeType = DegradeType.DEVICE_SENSOR_VALID;
                    }
                    if ($this$runInFalse$iv) {
                        boolean $this$runInFalse$iv2 = SplashSensorUtilsKt.sensorSwitchEnable(context);
                        if (!$this$runInFalse$iv2) {
                            degradeType = DegradeType.SENSOR_DISABLE;
                        }
                        if ($this$runInFalse$iv2) {
                        }
                    }
                }
                boolean z = true;
                if (ExtSplashGuideButtonKt.hitTwistStyle(it, checkJumpPermission(it))) {
                    boolean $this$runInFalse$iv3 = SplashSensorUtilsKt.hasGyroscopeSensorAndEnable(context) && SplashSensorUtilsKt.hasAccSensorAndEnable(context);
                    if (!$this$runInFalse$iv3) {
                        degradeType = DegradeType.DEVICE_SENSOR_VALID;
                    }
                    if ($this$runInFalse$iv3) {
                        boolean $this$runInFalse$iv4 = SplashSensorUtilsKt.sensorSwitchEnable(context);
                        if (!$this$runInFalse$iv4) {
                            degradeType = DegradeType.SENSOR_DISABLE;
                        }
                        if ($this$runInFalse$iv4) {
                        }
                    }
                }
                if (ExtSplashGuideButtonKt.getHitBrandRotateCardStyle(it)) {
                    boolean $this$runInFalse$iv5 = SplashSensorUtilsKt.hasGyroscopeSensorAndEnable(context) && SplashSensorUtilsKt.hasAccSensorAndEnable(context);
                    if (!$this$runInFalse$iv5) {
                        degradeType = DegradeType.DEVICE_SENSOR_VALID;
                    }
                    if ($this$runInFalse$iv5) {
                        boolean $this$runInFalse$iv6 = SplashSensorUtilsKt.sensorSwitchEnable(context);
                        if (!$this$runInFalse$iv6) {
                            degradeType = DegradeType.SENSOR_DISABLE;
                        }
                        if ($this$runInFalse$iv6) {
                        }
                    }
                }
                if (!ExtSplashGuideButtonKt.getHitShopCardClickStyle(it)) {
                    if (ExtSplashGuideButtonKt.getHitShopCardTwistStyle(it)) {
                        boolean $this$runInFalse$iv7 = SplashSensorUtilsKt.hasGyroscopeSensorAndEnable(context) && SplashSensorUtilsKt.hasAccSensorAndEnable(context);
                        if (!$this$runInFalse$iv7) {
                            degradeType = DegradeType.DEVICE_SENSOR_VALID;
                        }
                        if ($this$runInFalse$iv7) {
                            boolean $this$runInFalse$iv8 = SplashSensorUtilsKt.sensorSwitchEnable(context);
                            if (!$this$runInFalse$iv8) {
                                degradeType = DegradeType.SENSOR_DISABLE;
                            }
                            if ($this$runInFalse$iv8) {
                            }
                        }
                    }
                    if (ExtSplashGuideButtonKt.getHitRunningBallStyle(it)) {
                        boolean $this$runInFalse$iv9 = SplashSensorUtilsKt.hasGyroscopeSensorAndEnable(context);
                        if (!$this$runInFalse$iv9) {
                            degradeType = DegradeType.DEVICE_SENSOR_VALID;
                        }
                        if ($this$runInFalse$iv9) {
                            boolean $this$runInFalse$iv10 = SplashSensorUtilsKt.sensorSwitchEnable(context);
                            if (!$this$runInFalse$iv10) {
                                degradeType = DegradeType.SENSOR_DISABLE;
                            }
                            if ($this$runInFalse$iv10) {
                            }
                        }
                    }
                    if (ExtSplashGuideButtonKt.hitWebpTwistStyle(it, checkJumpPermission(it))) {
                        boolean $this$runInFalse$iv11 = (SplashSensorUtilsKt.hasGyroscopeSensorAndEnable(context) && SplashSensorUtilsKt.hasAccSensorAndEnable(context)) ? false : false;
                        if (!$this$runInFalse$iv11) {
                            degradeType = DegradeType.DEVICE_SENSOR_VALID;
                        }
                        if ($this$runInFalse$iv11) {
                            boolean $this$runInFalse$iv12 = SplashSensorUtilsKt.sensorSwitchEnable(context);
                            if (!$this$runInFalse$iv12) {
                                degradeType = DegradeType.SENSOR_DISABLE;
                            }
                            if ($this$runInFalse$iv12) {
                            }
                        }
                    }
                    if (ExtSplashGuideButtonKt.hitWebpSlideStyle(it, checkJumpPermission(it))) {
                    }
                }
            }
            validMap.put(Long.valueOf(it.getId()), it);
        }
        BLog.i("[Splash]SplashButtonHelper", "check valid button size = " + validMap.size() + " , " + degradeType + " , " + validMap.keySet());
        return new Pair<>(degradeType, validMap);
    }

    public final GuideButtonViewInfo generateView$adsplash_debug(Context context, SplashGuideButton splashGuideButton, SplashOrder splash, BaseSplash baseSplash, HashMap<Long, SplashGuideButton> hashMap, DegradeType degradeType, boolean isSecondPage, SplashButtonClickListener listener) {
        boolean disableOutsideInteractiveView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Intrinsics.checkNotNullParameter(baseSplash, "baseSplash");
        Intrinsics.checkNotNullParameter(hashMap, "validMap");
        Intrinsics.checkNotNullParameter(degradeType, "degradeType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        boolean disableOutsideInteractiveView2 = false;
        BLog.i("[Splash]SplashButtonHelper", "generateView:" + splashGuideButton.getInteractStyle());
        boolean z = false;
        if (ExtSplashGuideButtonKt.getHitImageCheckStyleOnly(splashGuideButton)) {
            if (checkSelfAndRelatedValid(splashGuideButton, hashMap)) {
                r4 = genImageView(context, splashGuideButton, splash, listener);
                disableOutsideInteractiveView = false;
            } else if (!checkRelatedValid(splashGuideButton, hashMap)) {
                disableOutsideInteractiveView = false;
            } else {
                String actualUsedImageUrl = splashGuideButton.getActualUsedImageUrl();
                if (actualUsedImageUrl == null || StringsKt.isBlank(actualUsedImageUrl)) {
                    z = true;
                }
                if (!z) {
                    if (ExtSplashGuideButtonKt.getDisableOtherInteractWhenDowngrade(splashGuideButton)) {
                        disableOutsideInteractiveView2 = true;
                    }
                    reportButtonDegrade(splash, degradeType, isSecondPage);
                }
                r4 = genTextView(context, splashGuideButton, listener);
                disableOutsideInteractiveView = disableOutsideInteractiveView2;
            }
        } else if (checkSelfAndRelatedValid(ExtSplashGuideButtonKt.getHitSlideCheckStyleOnly(splashGuideButton), splashGuideButton, hashMap)) {
            r4 = genSlideView(context, splashGuideButton, splash, listener);
            disableOutsideInteractiveView = false;
        } else if (ExtSplashGuideButtonKt.getHitTextViewStyle(splashGuideButton)) {
            r4 = checkSelfAndRelatedValid(splashGuideButton, hashMap) ? genNonClickableTextView(context, splashGuideButton) : null;
            disableOutsideInteractiveView = false;
        } else if (checkSelfAndRelatedValid(ExtSplashGuideButtonKt.getHitShakeCheckStyleOnly(splashGuideButton), splashGuideButton, hashMap)) {
            r4 = genShakeView(context, splashGuideButton, splash, listener);
            disableOutsideInteractiveView = false;
        } else if (checkSelfAndRelatedValid(ExtSplashGuideButtonKt.getHitNoInteractViewCheckStyleOnly(splashGuideButton), splashGuideButton, hashMap)) {
            r4 = SplashButtonFactoryKt.createGuideButtonViewByMaterialType(context, splash, splashGuideButton, this.mScreenWidth, this.mScreenHeight, listener);
            disableOutsideInteractiveView = false;
        } else if (checkSelfAndRelatedValid(ExtSplashGuideButtonKt.getHitTwistStyleOnly(splashGuideButton), splashGuideButton, hashMap)) {
            r4 = genTwistView(context, splashGuideButton, splash, listener);
            disableOutsideInteractiveView = false;
        } else if (checkSelfAndRelatedValid(ExtSplashGuideButtonKt.getHitRunningBallStyleOnly(splashGuideButton), splashGuideButton, hashMap)) {
            r4 = genRunningBallView(context, splashGuideButton, listener);
            disableOutsideInteractiveView = false;
        } else if (checkSelfAndRelatedValid(ExtSplashGuideButtonKt.getHitBrandRotateCardStyle(splashGuideButton), splashGuideButton, hashMap)) {
            r4 = SplashButtonFactoryKt.createSplashButtonByInteractStyle(context, this.mScreenWidth, this.mScreenHeight, splashGuideButton, splash, listener);
            disableOutsideInteractiveView = false;
        } else if (ExtSplashGuideButtonKt.getHitCountdownStyleV2(splashGuideButton)) {
            if (!checkSelfAndRelatedValid(splashGuideButton, hashMap)) {
                disableOutsideInteractiveView = false;
            } else {
                r4 = SplashButtonFactoryKt.createSplashButtonByInteractStyle(context, this.mScreenWidth, this.mScreenHeight, splashGuideButton, splash, listener);
                disableOutsideInteractiveView = false;
            }
        } else if (ExtSplashGuideButtonKt.getHitCountDownStyleCheckStyleOnly(splashGuideButton)) {
            if (!checkSelfAndRelatedValid(splashGuideButton, hashMap)) {
                disableOutsideInteractiveView = false;
            } else {
                r4 = genCountdownView(context, splashGuideButton, baseSplash);
                disableOutsideInteractiveView = false;
            }
        } else {
            if (checkSelfAndRelatedValid(ExtSplashGuideButtonKt.getHitWebpTwistStyle(splashGuideButton) || ExtSplashGuideButtonKt.getHitWebpSlideStyle(splashGuideButton), splashGuideButton, hashMap)) {
                r4 = SplashButtonWebpBrandCardKt.createWebpButtonByInteractStyle(context, this.mScreenWidth, this.mScreenHeight, splashGuideButton, splash, listener, splashGuideButton.getInteractStyle() == 17, checkJumpPermission(splashGuideButton));
                disableOutsideInteractiveView = false;
            } else {
                if (ExtSplashGuideButtonKt.getHitShopCardClickStyle(splashGuideButton) || ExtSplashGuideButtonKt.getHitShopCardTwistStyle(splashGuideButton)) {
                    z = true;
                }
                if (checkSelfAndRelatedValid(z, splashGuideButton, hashMap)) {
                    disableButtonAreaSlide(baseSplash.getView());
                    r4 = SplashButtonFactoryKt.createSplashButtonByInteractStyle(context, this.mScreenWidth, this.mScreenHeight, splashGuideButton, splash, listener);
                    disableOutsideInteractiveView = false;
                } else {
                    if (ExtSplashGuideButtonKt.getDisableOtherInteractWhenDowngrade(splashGuideButton)) {
                        disableOutsideInteractiveView2 = true;
                    }
                    reportButtonDegrade(splash, degradeType, isSecondPage);
                    r4 = genTextView(context, splashGuideButton, listener);
                    disableOutsideInteractiveView = disableOutsideInteractiveView2;
                }
            }
        }
        View view = r4;
        return new GuideButtonViewInfo(view, disableOutsideInteractiveView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void expandClickArea(final View view, SplashGuideButton splashGuideButton) {
        final float expandRatio = ExtSplashGuideButtonKt.getGetExpandRatioPercent(splashGuideButton);
        if (expandRatio <= 1.0f) {
            return;
        }
        view.post(new Runnable() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                SplashButtonHelper.expandClickArea$lambda$0(view, expandRatio);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void expandClickArea$lambda$0(View $view, float $expandRatio) {
        Rect hitRect = new Rect();
        $view.getHitRect(hitRect);
        int width = hitRect.width();
        int height = hitRect.height();
        if (width <= 0 || height <= 0) {
            return;
        }
        int expandedWidth = (int) (width * $expandRatio);
        int expandHeight = (int) (height * $expandRatio);
        int left = (int) Math.max(0.0f, hitRect.left - ((expandedWidth - width) / 2.0f));
        int right = left + expandedWidth;
        int top = (int) Math.max(0.0f, hitRect.top - ((expandHeight - height) / 2.0f));
        int bottom = top + expandHeight;
        Rect rect = new Rect(left, top, right, bottom);
        ViewParent parent = $view.getParent();
        View parent2 = parent instanceof View ? (View) parent : null;
        if (parent2 != null) {
            parent2.setTouchDelegate(new TouchDelegate(rect, $view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableInteractiveView(View container) {
        if (container instanceof ViewGroup) {
            int childCount = ((ViewGroup) container).getChildCount();
            for (int i = 0; i < childCount; i++) {
                int childIndex = i;
                View child = ((ViewGroup) container).getChildAt(childIndex);
                if (child instanceof SplashInteractView) {
                    BLog.w("[Splash]SplashButtonHelper", "disableInteractiveView :" + child);
                    ((SplashInteractView) child).setInteractEnable(false);
                }
                if (child instanceof DeliverySlideEventFrameLayout) {
                    ((DeliverySlideEventFrameLayout) child).setInteractEnable(false);
                }
                disableInteractiveView(child);
            }
        }
    }

    private final void disableButtonAreaSlide(View container) {
        if (container instanceof ViewGroup) {
            int childCount = ((ViewGroup) container).getChildCount();
            for (int i = 0; i < childCount; i++) {
                int childIndex = i;
                View child = ((ViewGroup) container).getChildAt(childIndex);
                if (child instanceof DeliverySlideEventFrameLayout) {
                    ((DeliverySlideEventFrameLayout) child).setInteractEnable(false);
                }
                disableInteractiveView(child);
            }
        }
    }

    private final boolean checkSelfAndRelatedValid(boolean $this$checkSelfAndRelatedValid, SplashGuideButton button, HashMap<Long, SplashGuideButton> hashMap) {
        if (!$this$checkSelfAndRelatedValid) {
            return false;
        }
        return checkSelfAndRelatedValid(button, hashMap);
    }

    private final boolean checkSelfAndRelatedValid(SplashGuideButton button, HashMap<Long, SplashGuideButton> hashMap) {
        return checkSelfValid(button, hashMap) && checkRelatedValid(button, hashMap);
    }

    private final boolean checkSelfValid(SplashGuideButton button, HashMap<Long, SplashGuideButton> hashMap) {
        return hashMap.containsKey(Long.valueOf(button.getId()));
    }

    private final boolean checkRelatedValid(SplashGuideButton button, HashMap<Long, SplashGuideButton> hashMap) {
        Iterable relatedIds = button.getRelatedIds();
        if (relatedIds == null) {
            return true;
        }
        Iterable $this$forEach$iv = relatedIds;
        for (Object element$iv : $this$forEach$iv) {
            long it = ((Number) element$iv).longValue();
            if (!hashMap.containsKey(Long.valueOf(it))) {
                return false;
            }
        }
        return true;
    }

    private final View genCountdownView(Context context, SplashGuideButton buttonData, BaseSplash baseSplash) {
        LifecycleOwner viewLifecycleOwner;
        CoroutineScope lifecycleScope;
        if (ExtSplashGuideButtonKt.isCountDownValid(buttonData)) {
            View contentView = LayoutInflater.from(context).inflate(R.layout.bili_app_layout_splash_countdown_view_2, (ViewGroup) null, false);
            Intrinsics.checkNotNullExpressionValue(contentView, "inflate(...)");
            View findViewById = contentView.findViewById(R.id.countdown_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            TextView titleView = (TextView) findViewById;
            View findViewById2 = contentView.findViewById(R.id.countdown);
            TextView $this$genCountdownView_u24lambda_u240 = (TextView) findViewById2;
            $this$genCountdownView_u24lambda_u240.setShadowLayer(ScreenUtil.dip2px(context, 2.0f), 0.0f, ScreenUtil.dip2px(context, 1.0f), ContextCompat.getColor(context, com.bilibili.app.comm.baseres.R.color.black_alpha65));
            Intrinsics.checkNotNullExpressionValue(findViewById2, "apply(...)");
            TextView countdownView = (TextView) findViewById2;
            contentView.setClickable(false);
            int viewWidth = (int) (this.mScreenWidth * ExtSplashGuideButtonKt.getGetWidthPercent(buttonData));
            int viewHeight = (int) (this.mScreenHeight * 0.07f);
            float viewCenterX = this.mScreenWidth * ExtSplashGuideButtonKt.getGetXPercent(buttonData);
            float viewCenterY = this.mScreenHeight * ExtSplashGuideButtonKt.getGetYPercent(buttonData);
            FrameLayout.LayoutParams contentLayoutParams = new FrameLayout.LayoutParams(viewWidth, viewHeight);
            contentView.setX(viewCenterX - (viewWidth / 2));
            contentView.setY(viewCenterY - (viewHeight / 2));
            float mTextSize = viewHeight * buttonData.getFontRatio();
            titleView.setText(buttonData.getGuideInstructions());
            titleView.setTextSize(0, mTextSize);
            countdownView.setTextSize(0, mTextSize);
            titleView.setTextColor(ExtSplashGuideButtonKt.getGetTextColor(buttonData));
            countdownView.setTextColor(ExtSplashGuideButtonKt.getGetTextColor(buttonData));
            contentView.setLayoutParams(contentLayoutParams);
            BaseSplash baseSplash2 = ListExtentionsKt.isViewAlive((Fragment) baseSplash) ? baseSplash : null;
            if (baseSplash2 != null && (viewLifecycleOwner = baseSplash2.getViewLifecycleOwner()) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner)) != null) {
                BuildersKt.launch$default(lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new SplashButtonHelper$genCountdownView$2(baseSplash, contentView, countdownView, context, buttonData, null), 3, (Object) null);
            }
            return contentView;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TextView genNonClickableTextView(Context context, SplashGuideButton splashGuideButton) {
        String schemaTitle;
        int viewWidth = (int) (this.mScreenWidth * ExtSplashGuideButtonKt.getGetWidthPercent(splashGuideButton));
        int viewHeight = (int) (this.mScreenHeight * ExtSplashGuideButtonKt.getGetHeightPercent(splashGuideButton));
        float viewCenterX = this.mScreenWidth * ExtSplashGuideButtonKt.getGetXPercent(splashGuideButton);
        float viewCenterY = this.mScreenHeight * ExtSplashGuideButtonKt.getGetYPercent(splashGuideButton);
        float mTextSize = viewHeight * splashGuideButton.getFontRatio();
        List<String> schemaList = splashGuideButton.getSchemaList();
        String str = null;
        if (schemaList != null) {
            Iterator<T> it = schemaList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String it2 = (String) next;
                if (checkSchemaListJumpPermission(splashGuideButton, it2)) {
                    str = next;
                    break;
                }
            }
            str = str;
        }
        String schemaAdjustableFind = str;
        TextView $this$genNonClickableTextView_u24lambda_u241 = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(viewWidth, viewHeight);
        $this$genNonClickableTextView_u24lambda_u241.setX(viewCenterX - (viewWidth / 2));
        $this$genNonClickableTextView_u24lambda_u241.setY(viewCenterY - (viewHeight / 2));
        $this$genNonClickableTextView_u24lambda_u241.setLayoutParams(layoutParams);
        String str2 = schemaAdjustableFind;
        if (str2 == null || StringsKt.isBlank(str2)) {
            schemaTitle = splashGuideButton.getGuideInstructions();
        } else {
            schemaTitle = splashGuideButton.getSchemaTitle();
        }
        $this$genNonClickableTextView_u24lambda_u241.setText(schemaTitle);
        $this$genNonClickableTextView_u24lambda_u241.setTextSize(0, mTextSize);
        $this$genNonClickableTextView_u24lambda_u241.setTextColor(ExtSplashGuideButtonKt.getGetTextColor(splashGuideButton));
        $this$genNonClickableTextView_u24lambda_u241.setGravity(17);
        $this$genNonClickableTextView_u24lambda_u241.setClickable(false);
        $this$genNonClickableTextView_u24lambda_u241.setEllipsize(TextUtils.TruncateAt.END);
        $this$genNonClickableTextView_u24lambda_u241.setSingleLine(true);
        if (ExtSplashGuideButtonKt.getGetTextColor(splashGuideButton) != -10394003) {
            $this$genNonClickableTextView_u24lambda_u241.setShadowLayer(ListExtentionsKt.toPx(2), 0.0f, ListExtentionsKt.toPx(1), ContextCompat.getColor(context, com.bilibili.app.comm.baseres.R.color.black_alpha50));
        }
        TextPaint paint = $this$genNonClickableTextView_u24lambda_u241.getPaint();
        if (paint != null) {
            paint.setTypeface(Typeface.create($this$genNonClickableTextView_u24lambda_u241.getTypeface(), 1));
        }
        return $this$genNonClickableTextView_u24lambda_u241;
    }

    private final View genTextView(Context context, final SplashGuideButton guideButton, final SplashButtonClickListener listener) {
        int i;
        boolean isJumpThirdPartApp = checkJumpPermission(guideButton);
        int viewWidth = (int) (this.mScreenWidth * ExtSplashGuideButtonKt.getGetWidthPercent(guideButton));
        int viewHeight = (int) (this.mScreenHeight * 0.07f);
        float textSize = viewHeight * 0.3f;
        float subTextSize = viewHeight * 0.23f;
        float viewCenterX = this.mScreenWidth * ExtSplashGuideButtonKt.getGetXPercent(guideButton);
        float viewCenterY = this.mScreenHeight * ExtSplashGuideButtonKt.getGetYPercent(guideButton);
        View rootView = LayoutInflater.from(context).inflate(R.layout.bili_app_splash_guide_button_layout_2, (ViewGroup) null, false);
        rootView.setBackground(genTextViewBg(ExtSplashGuideButtonKt.getBgColor$default(guideButton, context, 0, 2, null)));
        rootView.setLayoutParams(new ViewGroup.LayoutParams(viewWidth, viewHeight));
        rootView.setX(viewCenterX - (viewWidth / 2));
        rootView.setY(viewCenterY - (viewHeight / 2));
        int padding = (int) (viewHeight * 0.4f);
        rootView.setPadding(padding, 0, padding, 0);
        rootView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashButtonClickListener.this.onClick(guideButton);
            }
        });
        ImageView iconView = (ImageView) rootView.findViewById(R.id.guide_icon);
        TextView titleTextView = (TextView) rootView.findViewById(R.id.guide_text);
        TextView subTextView = (TextView) rootView.findViewById(R.id.secondary_guide_text);
        titleTextView.setText(isJumpThirdPartApp ? guideButton.getSchemaTitle() : guideButton.getGuideInstructions());
        titleTextView.setTextColor(ExtSplashGuideButtonKt.getGetTextColor(guideButton));
        titleTextView.setTextSize(0, textSize);
        titleTextView.setCompoundDrawablePadding(0);
        String subTitle = guideButton.getSecondaryGuideInstructions();
        String str = subTitle;
        if (str == null || StringsKt.isBlank(str)) {
            subTextView.setVisibility(8);
        } else {
            subTextView.setText(subTitle);
            subTextView.setTextColor(ExtSplashGuideButtonKt.getGetSubTextColor(guideButton));
            subTextView.setTextSize(0, subTextSize);
            subTextView.setVisibility(0);
        }
        if (isJumpThirdPartApp && subTextView.getVisibility() != 0) {
            Drawable it = ContextCompat.getDrawable(context, com.bilibili.app.comm.baseres.R.drawable.ic_arrow_white_without_padding_alpha);
            Drawable drawable = it != null ? UiUtilsKt.tintDrawable(it, ExtSplashGuideButtonKt.getGetTextColor(guideButton)) : null;
            iconView.setImageDrawable(drawable);
            i = 0;
        } else {
            i = 8;
        }
        iconView.setVisibility(i);
        Intrinsics.checkNotNull(rootView);
        return rootView;
    }

    private final void reportButtonDegrade(SplashOrder splash, DegradeType degradeType, boolean isSecondPage) {
        SplashAdHelper.INSTANCE.adSplashButtonLottieDegradeEvent$adsplash_debug(splash, degradeType, isSecondPage);
    }

    private final View genImageView(final Context context, final SplashGuideButton splashGuideButton, SplashOrder splash, final SplashButtonClickListener listener) {
        File file;
        boolean isButtonGuideEnable;
        File guideResFile;
        if (splashGuideButton.getGuideMaterialType() != 0) {
            return null;
        }
        final View rootView = LayoutInflater.from(context).inflate(R.layout.bili_app_layout_splash_image_button_2, (ViewGroup) null);
        final SafeLottieAnimationView image = (SafeLottieAnimationView) rootView.findViewById(R.id.splash_button_image);
        final SafeLottieAnimationView guideImage = (SafeLottieAnimationView) rootView.findViewById(R.id.splash_button_guide);
        final int viewWidth = (int) (this.mScreenWidth * ExtSplashGuideButtonKt.getGetWidthPercent(splashGuideButton));
        final int viewHeight = (int) (this.mScreenHeight * ExtSplashGuideButtonKt.getGetHeightPercent(splashGuideButton));
        float viewCenterX = this.mScreenWidth * ExtSplashGuideButtonKt.getGetXPercent(splashGuideButton);
        final float viewCenterY = this.mScreenHeight * ExtSplashGuideButtonKt.getGetYPercent(splashGuideButton);
        rootView.setLayoutParams(new ViewGroup.LayoutParams(viewWidth, -2));
        rootView.setX(viewCenterX - (viewWidth / 2));
        rootView.setY(viewCenterY - (viewHeight / 2));
        String imageUrl = splashGuideButton.getActualUsedImageUrl();
        String imageHash = splashGuideButton.getActualUsedImageHash();
        BLog.i("[Splash]SplashButtonHelper", "genShakeView actual used image url = " + imageUrl);
        String str = imageUrl;
        boolean z = false;
        if ((str == null || StringsKt.isBlank(str)) || (file = BusinessSplashResHelper.INSTANCE.fetchResourceFileByHash(imageHash)) == null) {
            return null;
        }
        ViewGroup.LayoutParams lp = image.getLayoutParams();
        lp.width = viewWidth;
        lp.height = viewHeight;
        image.setLayoutParams(lp);
        SafeLottieCompositionFactory safeLottieCompositionFactory = SafeLottieCompositionFactory.INSTANCE;
        Intrinsics.checkNotNull(image);
        safeLottieCompositionFactory.safeLoadPlayLottie(splash, image, new FileInputStream(file), imageUrl, new Function1() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit genImageView$lambda$0;
                genImageView$lambda$0 = SplashButtonHelper.genImageView$lambda$0(SafeLottieAnimationView.this, (LottieComposition) obj);
                return genImageView$lambda$0;
            }
        });
        isButtonGuideEnable = SplashButtonHelperKt.isButtonGuideEnable(context, 1);
        if (isButtonGuideEnable) {
            String guideImageUrl = splashGuideButton.getGuideImageUrl();
            if (guideImageUrl == null || StringsKt.isBlank(guideImageUrl)) {
                z = true;
            }
            if (!z && (guideResFile = BusinessSplashResHelper.INSTANCE.fetchResourceFileByHash(splashGuideButton.getGuideImageMD5())) != null) {
                SafeLottieCompositionFactory safeLottieCompositionFactory2 = SafeLottieCompositionFactory.INSTANCE;
                Intrinsics.checkNotNull(guideImage);
                safeLottieCompositionFactory2.safeLoadPlayLottie(splash, guideImage, new FileInputStream(guideResFile), splashGuideButton.getGuideImageUrl(), new Function1() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit genImageView$lambda$1$0;
                        genImageView$lambda$1$0 = SplashButtonHelper.genImageView$lambda$1$0(SafeLottieAnimationView.this, context, viewWidth, rootView, viewCenterY, viewHeight, (LottieComposition) obj);
                        return genImageView$lambda$1$0;
                    }
                });
            }
        }
        rootView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashButtonClickListener.this.onClick(splashGuideButton);
            }
        });
        image.setOnTouchListener(new View.OnTouchListener() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean genImageView$lambda$3;
                genImageView$lambda$3 = SplashButtonHelper.genImageView$lambda$3(SafeLottieAnimationView.this, rootView, viewCenterY, viewHeight, view, motionEvent);
                return genImageView$lambda$3;
            }
        });
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit genImageView$lambda$0(SafeLottieAnimationView $image, LottieComposition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $image.setComposition(it);
        $image.playAnimation();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit genImageView$lambda$1$0(final SafeLottieAnimationView $guideImage, Context $context, int $viewWidth, final View $rootView, final float $viewCenterY, final int $viewHeight, LottieComposition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $guideImage.setVisibility(0);
        $guideImage.setComposition(it);
        int imageWidth = it.getBounds().width();
        int imageHeight = it.getBounds().height();
        if (imageWidth > 0 && imageHeight > 0) {
            ViewGroup.LayoutParams guideLp = $guideImage.getLayoutParams();
            guideLp.width = $viewWidth;
            guideLp.height = (int) ($viewWidth * (imageHeight / imageWidth));
            $guideImage.setLayoutParams(guideLp);
            $rootView.setY($viewCenterY - (guideLp.height / 2));
        }
        $guideImage.playAnimation();
        $guideImage.addAnimatorListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$genImageView$2$1$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SafeLottieAnimationView.this.setVisibility(8);
                $rootView.setY($viewCenterY - ($viewHeight / 2));
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
        SplashButtonHelperKt.increaseGuideShowTimes($context, 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean genImageView$lambda$3(SafeLottieAnimationView $guideImage, View $rootView, float $viewCenterY, int $viewHeight, View view, MotionEvent motionEvent) {
        $guideImage.setVisibility(8);
        $rootView.setY($viewCenterY - ($viewHeight / 2));
        return false;
    }

    private final View genTwistView(Context context, SplashGuideButton splashButton, SplashOrder splash, SplashButtonClickListener listener) {
        View image;
        View rootView = SplashButtonFactoryKt.createGuideButtonViewByMaterialType(context, splash, splashButton, this.mScreenWidth, this.mScreenHeight, listener);
        if (rootView == null || (image = ListExtentionsKt.getChildOrNull(rootView, 0)) == null) {
            return null;
        }
        SplashRotateSensorHelperKt.addRotateSensor(context, rootView, image, splashButton, splash, listener);
        return rootView;
    }

    private final View genRunningBallView(Context context, final SplashGuideButton buttonData, final SplashButtonClickListener listener) {
        File fetchResourceFileByHash = BusinessSplashResHelper.INSTANCE.fetchResourceFileByHash(buttonData.getLogoImageMD5());
        String logoFilePath = fetchResourceFileByHash != null ? fetchResourceFileByHash.getPath() : null;
        String str = logoFilePath;
        if (str == null || str.length() == 0) {
            return null;
        }
        final SplashRunningBallViewV2 runningBallView = SplashRunningBallViewV2.Companion.buildSplashRunningBallView(context);
        runningBallView.setClickable(false);
        runningBallView.setBgColor(ExtSplashGuideButtonKt.getBgColor(buttonData, context, ContextCompat.getColor(context, com.bilibili.app.comm.baseres.R.color.black_alpha40)));
        runningBallView.setStrokeColor(ExtSplashGuideButtonKt.getBorderColor(buttonData, ContextCompat.getColor(context, com.bilibili.app.comm.baseres.R.color.white_alpha40)));
        runningBallView.setHoleBgColor(ExtSplashGuideButtonKt.getGetSlideHoleBgColor(buttonData));
        runningBallView.setHoleStrokeColor(ExtSplashGuideButtonKt.getGetSlideHoleBorderColor(buttonData));
        runningBallView.setMaxAngle(Math.toRadians(buttonData.getTwistAngle()));
        runningBallView.setBallFile(logoFilePath);
        runningBallView.setThresholdPercent(ExtSplashGuideButtonKt.getGetThresholdPercent(buttonData));
        Float valueOf = Float.valueOf(ExtSplashGuideButtonKt.getGetWidthPercent(buttonData));
        float it = valueOf.floatValue();
        if (!(it > 0.0f)) {
            valueOf = null;
        }
        float viewWidthPercent = valueOf != null ? valueOf.floatValue() : 0.64f;
        Float valueOf2 = Float.valueOf(ExtSplashGuideButtonKt.getGetHeightPercent(buttonData));
        float it2 = valueOf2.floatValue();
        Float f = it2 > 0.0f ? valueOf2 : null;
        float viewHeightPercent = f != null ? f.floatValue() : 0.065f;
        int viewWidth = (int) (this.mScreenWidth * viewWidthPercent);
        int viewHeight = (int) (this.mScreenHeight * viewHeightPercent);
        float viewCenterX = this.mScreenWidth * ExtSplashGuideButtonKt.getGetXPercent(buttonData);
        float viewCenterY = this.mScreenHeight * ExtSplashGuideButtonKt.getGetYPercent(buttonData);
        runningBallView.setLayoutParams(new FrameLayout.LayoutParams(viewWidth, viewHeight));
        runningBallView.setX(viewCenterX - (viewWidth / 2));
        runningBallView.setY(viewCenterY - (viewHeight / 2));
        final SensorSet sensorSet = new SensorSet();
        if (Math.abs(buttonData.getTwistAngle()) >= 0.0f) {
            ISensor rotateDegreeSensor = new RotateDegreeSensor(context);
            rotateDegreeSensor.addListener(new RotateDegreeSensor.RotateListener() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda7
                public final void onDegreeChanged(float[] fArr) {
                    SplashButtonHelper.genRunningBallView$lambda$3(SplashRunningBallViewV2.this, fArr);
                }
            });
            sensorSet.addSensor(rotateDegreeSensor);
        }
        if (!sensorSet.isEmpty()) {
            runningBallView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$genRunningBallView$3
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    sensorSet.start(0);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    sensorSet.stop();
                }
            });
        }
        runningBallView.setOnReachedAction(new Function1() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit genRunningBallView$lambda$4;
                genRunningBallView$lambda$4 = SplashButtonHelper.genRunningBallView$lambda$4(sensorSet, listener, buttonData, ((Boolean) obj).booleanValue());
                return genRunningBallView$lambda$4;
            }
        });
        if (SplashUtilsKt.isDebug()) {
            SplashSensorDebugKt.addRunningBallDebugView(runningBallView, sensorSet);
        }
        List<SplashRunningBallViewV2> list = this.mRunningBallList;
        if (list != null) {
            list.add(runningBallView);
        }
        return runningBallView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void genRunningBallView$lambda$3(SplashRunningBallViewV2 $runningBallView, float[] degreesDelta) {
        Intrinsics.checkNotNullParameter(degreesDelta, "degreesDelta");
        $runningBallView.setAngle(SplashRunningBallViewV2.Companion.adjustRadian(degreesDelta));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit genRunningBallView$lambda$4(SensorSet $sensorSet, SplashButtonClickListener $listener, SplashGuideButton $buttonData, boolean triggerFromThreshold) {
        $sensorSet.stop();
        $listener.onRunning($buttonData, triggerFromThreshold);
        return Unit.INSTANCE;
    }

    private final View genShakeView(Context context, final SplashGuideButton splashGuideButton, SplashOrder splash, final SplashButtonClickListener listener) {
        View image;
        View rootView = SplashButtonFactoryKt.createGuideButtonViewByMaterialType(context, splash, splashGuideButton, this.mScreenWidth, this.mScreenHeight, listener);
        if (rootView == null || (image = ListExtentionsKt.getChildOrNull(rootView, 0)) == null) {
            return null;
        }
        final AcceleratorSensor accSensor = new AcceleratorSensor(context);
        rootView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$genShakeView$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                ISensor.-CC.start$default(accSensor, 0, 1, (Object) null);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                accSensor.stop();
            }
        });
        accSensor.addListener(new AcceleratorSensor.SpeedChangedListener() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda10
            public final void onSpeedChanged(float f) {
                SplashButtonHelper.genShakeView$lambda$0(accSensor, listener, splashGuideButton, f);
            }
        });
        if (ExtSplashGuideButtonKt.getHitShakeClickCheckStyleOnly(splashGuideButton)) {
            image.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SplashButtonClickListener.this.onClick(splashGuideButton);
                }
            });
        }
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void genShakeView$lambda$0(AcceleratorSensor $accSensor, SplashButtonClickListener $listener, SplashGuideButton $splashGuideButton, float speed) {
        if (speed >= SplashSensorUtilsKt.getACCELERATE_SPEED_THRESHOLD()) {
            $accSensor.stop();
            $listener.onShake($splashGuideButton);
        }
    }

    private final View genSlideView(final Context context, final SplashGuideButton splashGuideButton, final SplashOrder splash, final SplashButtonClickListener listener) {
        boolean isButtonGuideEnable;
        float viewCenterY;
        int viewHeight;
        final SafeLottieAnimationView guideView;
        File fetchResourceFileByHash = BusinessSplashResHelper.INSTANCE.fetchResourceFileByHash(splashGuideButton.getLogoImageMD5());
        String logoFilePath = fetchResourceFileByHash != null ? fetchResourceFileByHash.getPath() : null;
        String str = logoFilePath;
        boolean z = false;
        if (str == null || str.length() == 0) {
            return null;
        }
        boolean isJumpThirdPartApp = checkJumpPermission(splashGuideButton);
        final View rootView = LayoutInflater.from(context).inflate(R.layout.bili_app_layout_splash_slide_view_2, (ViewGroup) null);
        SplashSlideUnlockView slideView = (SplashSlideUnlockView) rootView.findViewById(R.id.slide_view);
        SafeLottieAnimationView guideView2 = (SafeLottieAnimationView) rootView.findViewById(R.id.splash_slide_guide);
        guideView2.setSafeMode(true);
        final int viewWidth = (int) (this.mScreenWidth * 0.7d);
        final int viewHeight2 = (int) (this.mScreenHeight * 0.07d);
        float viewCenterX = this.mScreenWidth * ExtSplashGuideButtonKt.getGetXPercent(splashGuideButton);
        final float viewCenterY2 = this.mScreenHeight * ExtSplashGuideButtonKt.getGetYPercent(splashGuideButton);
        rootView.setLayoutParams(new ViewGroup.LayoutParams(viewWidth, -2));
        rootView.setX(viewCenterX - (viewWidth / 2));
        rootView.setY(viewCenterY2 - (viewHeight2 / 2));
        ViewGroup.LayoutParams slideLp = slideView.getLayoutParams();
        slideLp.width = viewWidth;
        slideLp.height = viewHeight2;
        slideView.setLayoutParams(slideLp);
        slideView.setBackground(genSlideViewBg(ExtSplashGuideButtonKt.getBgColor$default(splashGuideButton, context, 0, 2, null), ExtSplashGuideButtonKt.getBorderColor$default(splashGuideButton, 0, 1, null)));
        slideView.initSize(viewWidth, viewHeight2, ExtSplashGuideButtonKt.getGetThresholdPercent(splashGuideButton));
        String text = isJumpThirdPartApp ? splashGuideButton.getSchemaTitleNew() : splashGuideButton.getGuideInstructionsNew();
        slideView.showText(text, ExtSplashGuideButtonKt.getGetTextColor(splashGuideButton));
        slideView.showLogo(logoFilePath);
        slideView.showAnim();
        slideView.setOnSlideListener(new SplashSlideUnlockView.OnSlideClickListener() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$genSlideView$1
            @Override // tv.danmaku.bili.splash.ad.widget.SplashSlideUnlockView.OnSlideClickListener
            public void onSlided(boolean isSuccess) {
                if (isSuccess) {
                    SplashButtonClickListener.this.onSlide(splashGuideButton);
                } else {
                    SplashAdHelper.INSTANCE.adSplashSlideFailed(splash);
                }
            }

            @Override // tv.danmaku.bili.splash.ad.widget.SplashSlideUnlockView.OnSlideClickListener
            public void onClick() {
                if (splashGuideButton.getInteractStyle() == 2) {
                    SplashButtonClickListener.this.onClick(splashGuideButton);
                }
            }
        });
        isButtonGuideEnable = SplashButtonHelperKt.isButtonGuideEnable(context, 2);
        if (!isButtonGuideEnable) {
            viewCenterY = viewCenterY2;
            viewHeight = viewHeight2;
            guideView = guideView2;
        } else {
            String guideImageUrl = splashGuideButton.getGuideImageUrl();
            if (!(guideImageUrl == null || StringsKt.isBlank(guideImageUrl))) {
                String guideImageMD5 = splashGuideButton.getGuideImageMD5();
                if (guideImageMD5 == null || StringsKt.isBlank(guideImageMD5)) {
                    z = true;
                }
                if (!z) {
                    File guideResFile = BusinessSplashResHelper.INSTANCE.fetchResourceFileByHash(splashGuideButton.getGuideImageMD5());
                    if (guideResFile == null) {
                        viewCenterY = viewCenterY2;
                        viewHeight = viewHeight2;
                        guideView = guideView2;
                    } else {
                        SafeLottieCompositionFactory safeLottieCompositionFactory = SafeLottieCompositionFactory.INSTANCE;
                        Intrinsics.checkNotNull(guideView2);
                        guideView = guideView2;
                        viewCenterY = viewCenterY2;
                        viewHeight = viewHeight2;
                        safeLottieCompositionFactory.safeLoadPlayLottie(splash, guideView, new FileInputStream(guideResFile), splashGuideButton.getGuideImageUrl(), new Function1() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda12
                            public final Object invoke(Object obj) {
                                Unit genSlideView$lambda$0$0;
                                genSlideView$lambda$0$0 = SplashButtonHelper.genSlideView$lambda$0$0(SafeLottieAnimationView.this, context, viewWidth, rootView, viewCenterY2, viewHeight2, (LottieComposition) obj);
                                return genSlideView$lambda$0$0;
                            }
                        });
                    }
                }
            }
            viewCenterY = viewCenterY2;
            viewHeight = viewHeight2;
            guideView = guideView2;
        }
        final float viewCenterY3 = viewCenterY;
        final int viewHeight3 = viewHeight;
        slideView.setOnTouchListener(new View.OnTouchListener() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean genSlideView$lambda$1;
                genSlideView$lambda$1 = SplashButtonHelper.genSlideView$lambda$1(SafeLottieAnimationView.this, rootView, viewCenterY3, viewHeight3, view, motionEvent);
                return genSlideView$lambda$1;
            }
        });
        List<SplashSlideUnlockView> list = this.mSlideBtnList;
        if (list != null) {
            Intrinsics.checkNotNull(slideView);
            list.add(slideView);
        }
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit genSlideView$lambda$0$0(final SafeLottieAnimationView $guideView, Context $context, int $viewWidth, final View $rootView, final float $viewCenterY, final int $viewHeight, LottieComposition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $guideView.setVisibility(0);
        $guideView.setComposition(it);
        int imageWidth = it.getBounds().width();
        int imageHeight = it.getBounds().height();
        if (imageWidth > 0 && imageHeight > 0) {
            ViewGroup.LayoutParams guideLp = $guideView.getLayoutParams();
            guideLp.width = $viewWidth;
            guideLp.height = (int) ($viewWidth * (imageHeight / imageWidth));
            $guideView.setLayoutParams(guideLp);
            $rootView.setY($viewCenterY - (guideLp.height / 2));
        }
        $guideView.playAnimation();
        $guideView.addAnimatorListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.splash.ad.button.SplashButtonHelper$genSlideView$2$1$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SafeLottieAnimationView.this.setVisibility(8);
                $rootView.setY($viewCenterY - ($viewHeight / 2));
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
        SplashButtonHelperKt.increaseGuideShowTimes($context, 2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean genSlideView$lambda$1(SafeLottieAnimationView $guideView, View $rootView, float $viewCenterY, int $viewHeight, View view, MotionEvent motionEvent) {
        $guideView.setVisibility(8);
        $rootView.setY($viewCenterY - ($viewHeight / 2));
        return false;
    }

    private final boolean checkJumpPermission(SplashGuideButton splashGuideButton) {
        return SplashUtilsKt.buildThirdIntent(this.mSplash, splashGuideButton.getSchema(), splashGuideButton.getSchemaPackageName()) != null;
    }

    private final boolean checkSchemaListJumpPermission(SplashGuideButton splashGuideButton, String schema) {
        return StringUtil.isNotBlank(schema) && StringUtil.isNotBlank(splashGuideButton.getSchemaPackageName()) && SplashUtilsKt.buildThirdIntent(this.mSplash, schema, splashGuideButton.getSchemaPackageName()) != null;
    }

    private final Drawable genTextViewBg(int bgColor) {
        GradientDrawable $this$genTextViewBg_u24lambda_u240 = new GradientDrawable();
        $this$genTextViewBg_u24lambda_u240.setCornerRadius(100000.0f);
        $this$genTextViewBg_u24lambda_u240.setColor(bgColor);
        return $this$genTextViewBg_u24lambda_u240;
    }

    private final Drawable genSlideViewBg(int bgColor, int borderColor) {
        GradientDrawable $this$genSlideViewBg_u24lambda_u240 = new GradientDrawable();
        $this$genSlideViewBg_u24lambda_u240.setCornerRadius(100000.0f);
        $this$genSlideViewBg_u24lambda_u240.setColor(bgColor);
        $this$genSlideViewBg_u24lambda_u240.setShape(0);
        $this$genSlideViewBg_u24lambda_u240.setStroke(1, borderColor);
        return $this$genSlideViewBg_u24lambda_u240;
    }

    public final void handleSlideEvent() {
        List<SplashSlideUnlockView> list = this.mSlideBtnList;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterable iterable = this.mSlideBtnList;
        if (iterable != null) {
            Iterable $this$forEach$iv = iterable;
            for (Object element$iv : $this$forEach$iv) {
                SplashSlideUnlockView it = (SplashSlideUnlockView) element$iv;
                if (it.isSliding()) {
                    it.handleSlideEventWhenExit();
                    return;
                }
            }
        }
        List<SplashSlideUnlockView> list2 = this.mSlideBtnList;
        if (list2 != null) {
            list2.clear();
        }
        this.mSlideBtnList = null;
    }

    public final void handleRunningBall() {
        List<SplashRunningBallViewV2> list = this.mRunningBallList;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterable iterable = this.mRunningBallList;
        if (iterable != null) {
            Iterable $this$forEach$iv = iterable;
            for (Object element$iv : $this$forEach$iv) {
                SplashRunningBallViewV2 it = (SplashRunningBallViewV2) element$iv;
                if (it.hasReachedThreshold()) {
                    Function1<Boolean, Unit> onReachedAction = it.getOnReachedAction();
                    if (onReachedAction != null) {
                        onReachedAction.invoke(true);
                        return;
                    }
                    return;
                }
            }
        }
        List<SplashRunningBallViewV2> list2 = this.mRunningBallList;
        if (list2 != null) {
            list2.clear();
        }
        this.mRunningBallList = null;
    }

    private final boolean runInFalse(boolean $this$runInFalse, Function0<Unit> function0) {
        if (!$this$runInFalse) {
            function0.invoke();
        }
        return $this$runInFalse;
    }
}