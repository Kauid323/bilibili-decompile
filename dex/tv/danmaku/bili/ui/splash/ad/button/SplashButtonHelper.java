package tv.danmaku.bili.ui.splash.ad.button;

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
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
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
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.button.card.SplashButtonWebpBrandCardKt;
import tv.danmaku.bili.ui.splash.ad.button.model.DegradeType;
import tv.danmaku.bili.ui.splash.ad.button.model.GuideButtonViewInfo;
import tv.danmaku.bili.ui.splash.ad.button.model.GuideButtonViewListInfo;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener;
import tv.danmaku.bili.ui.splash.ad.button.sensor.SplashRotateSensorHelperKt;
import tv.danmaku.bili.ui.splash.ad.button.widget.SafeLottieAnimationView;
import tv.danmaku.bili.ui.splash.ad.button.widget.SafeLottieCompositionFactory;
import tv.danmaku.bili.ui.splash.ad.chronos.SplashChronosHelper;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.ui.splash.ad.model.SplashGuideButtonKt;
import tv.danmaku.bili.ui.splash.ad.model.SplashSecondPageInfo;
import tv.danmaku.bili.ui.splash.ad.page.BaseSplash;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelper;
import tv.danmaku.bili.ui.splash.utils.SplashUtilsKt;
import tv.danmaku.bili.ui.splash.utils.UiUtils;
import tv.danmaku.bili.ui.splash.utils.sensor.SplashSensorDebugKt;
import tv.danmaku.bili.ui.splash.utils.sensor.SplashSensorUtilsKt;
import tv.danmaku.bili.ui.splash.widget.DeliverySlideEventFrameLayout;
import tv.danmaku.bili.ui.splash.widget.SplashInteractView;
import tv.danmaku.bili.ui.splash.widget.SplashRunningBallView;
import tv.danmaku.bili.ui.splash.widget.SplashSlideUnlockView;
import tv.danmaku.bili.videopage.common.performance.PerformanceConstants;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashButtonHelper.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J=\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001cJ\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u000fH\u0002JN\u0010 \u001a*\u0012\u0004\u0012\u00020\"\u0012 \u0012\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#j\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%`&0!2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020%0(2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0019H\u0002Ji\u0010)\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010+\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#j\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%`&2\u0006\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b0J\u0018\u00101\u001a\u00020\r2\u0006\u00102\u001a\u0002032\u0006\u0010+\u001a\u00020%H\u0002J\u0012\u00104\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u000103H\u0002J\u0012\u00105\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u000103H\u0002J8\u00106\u001a\u00020/*\u00020/2\u0006\u00107\u001a\u00020%2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#j\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%`&H\u0002J4\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020%2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#j\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%`&H\u0002J4\u00108\u001a\u00020/2\u0006\u00107\u001a\u00020%2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#j\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%`&H\u0002J4\u00109\u001a\u00020/2\u0006\u00107\u001a\u00020%2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#j\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%`&H\u0002J\"\u0010:\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010;\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010<\u001a\u00020=2\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010+\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J0\u0010>\u001a\u0002032\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010?\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010@\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0002J*\u0010A\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010+\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0003J*\u0010B\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010C\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\"\u0010D\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010;\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J*\u0010E\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010+\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0003J2\u0010F\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010+\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003J\u0016\u0010G\u001a\u00020/2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010+\u001a\u00020%J\"\u0010H\u001a\u00020/2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010+\u001a\u00020%2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0005H\u0002J\u0018\u0010N\u001a\u00020L2\u0006\u0010M\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005H\u0002J\u0006\u0010P\u001a\u00020\rJ\u0006\u0010Q\u001a\u00020\rJ\u001b\u0010R\u001a\u00020/*\u00020/2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\r0TH\u0082\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U²\u0006\n\u0010V\u001a\u00020WX\u008a\u0084\u0002"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/button/SplashButtonHelper;", "", "<init>", "()V", "mScreenWidth", "", "mScreenHeight", "mSlideBtnList", "", "Ltv/danmaku/bili/ui/splash/widget/SplashSlideUnlockView;", "mRunningBallList", "Ltv/danmaku/bili/ui/splash/widget/SplashRunningBallView;", "injectSplashButton", "", "rootContainer", "Landroid/view/ViewGroup;", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "baseSplash", "Ltv/danmaku/bili/ui/splash/ad/page/BaseSplash;", "listener", "Ltv/danmaku/bili/ui/splash/ad/button/model/SplashButtonClickListener;", "generateSecondPageButtonList", "Ltv/danmaku/bili/ui/splash/ad/button/model/GuideButtonViewListInfo;", "ctx", "Landroid/content/Context;", "parentWidth", "parentHeight", "generateSecondPageButtonList$splash_debug", "updateDeviceSize", "context", "container", "checkButtonResState", "Lkotlin/Pair;", "Ltv/danmaku/bili/ui/splash/ad/button/model/DegradeType;", "Ljava/util/HashMap;", "", "Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;", "Lkotlin/collections/HashMap;", "buttons", "", "generateView", "Ltv/danmaku/bili/ui/splash/ad/button/model/GuideButtonViewInfo;", "splashGuideButton", "validMap", "degradeType", "isSecondPage", "", "generateView$splash_debug", "expandClickArea", "view", "Landroid/view/View;", "disableInteractiveView", "disableButtonAreaSlide", "checkSelfAndRelatedValid", "button", "checkSelfValid", "checkRelatedValid", "genCountdownView", "buttonData", "genNonClickableTextView", "Landroid/widget/TextView;", "genTextView", "guideButton", "reportButtonDegrade", "genImageView", "genTwistView", "splashButton", "genRunningBallView", "genShakeView", "genSlideView", "checkJumpPermission", "checkSchemaListJumpPermission", PerformanceConstants.EXTRA_KEY_SCHEMA, "", "genTextViewBg", "Landroid/graphics/drawable/Drawable;", "bgColor", "genSlideViewBg", "borderColor", "handleSlideEvent", "handleRunningBall", "runInFalse", "action", "Lkotlin/Function0;", "splash_debug", "deviceSize", "Landroid/graphics/Point;"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashButtonHelper {
    public static final int $stable = 8;
    private List<SplashRunningBallView> mRunningBallList;
    private int mScreenHeight;
    private int mScreenWidth;
    private List<SplashSlideUnlockView> mSlideBtnList;

    public final void injectSplashButton(final ViewGroup rootContainer, final Splash splash, final BaseSplash baseSplash, final SplashButtonClickListener listener) {
        final Context context;
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(baseSplash, "baseSplash");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final List buttons = splash.splashGuideButton;
        if (buttons == null || rootContainer == null || (context = rootContainer.getContext()) == null) {
            return;
        }
        this.mSlideBtnList = new ArrayList();
        this.mRunningBallList = new ArrayList();
        final ViewTreeObserver observer = rootContainer.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$injectSplashButton$1
            /* JADX WARN: Incorrect condition in loop: B:8:0x0060 */
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
                pair = this.checkButtonResState(buttons, baseSplash, context);
                DegradeType degradeType = (DegradeType) pair.getFirst();
                HashMap validMap = (HashMap) pair.getSecond();
                Iterable $this$forEach$iv = buttons;
                SplashButtonHelper splashButtonHelper = this;
                Context context2 = context;
                Splash splash2 = splash;
                BaseSplash baseSplash2 = baseSplash;
                SplashButtonClickListener splashButtonClickListener = listener;
                ViewGroup viewGroup = rootContainer;
                Iterator<T> it = $this$forEach$iv.iterator();
                boolean disableOutsideInteractiveView = false;
                while (disableOutsideInteractiveView) {
                    Object element$iv = it.next();
                    SplashGuideButton it2 = (SplashGuideButton) element$iv;
                    Intrinsics.checkNotNull(it2);
                    Pair pair2 = pair;
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    ViewGroup viewGroup2 = viewGroup;
                    SplashButtonClickListener splashButtonClickListener2 = splashButtonClickListener;
                    BaseSplash baseSplash3 = baseSplash2;
                    Splash splash3 = splash2;
                    GuideButtonViewInfo viewInfo = splashButtonHelper.generateView$splash_debug(context2, it2, splash2, baseSplash2, validMap, degradeType, false, splashButtonClickListener2);
                    disableOutsideInteractiveView = disableOutsideInteractiveView || viewInfo.getDisableOutsideInteractiveView();
                    View v = viewInfo.getView();
                    if (v != null) {
                        viewGroup2.addView(v);
                        if (v.isClickable()) {
                            splashButtonHelper.expandClickArea(v, it2);
                        }
                    }
                    viewGroup = viewGroup2;
                    splash2 = splash3;
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
    public final GuideButtonViewListInfo generateSecondPageButtonList$splash_debug(Context context, int parentWidth, int parentHeight, Splash splash, BaseSplash baseSplash, SplashButtonClickListener listener) {
        List buttons;
        Context ctx = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(baseSplash, "baseSplash");
        Intrinsics.checkNotNullParameter(listener, "listener");
        SplashSecondPageInfo splashSecondPageInfo = splash.secondPage;
        if (splashSecondPageInfo == null || (buttons = splashSecondPageInfo.getSecondPageButtons()) == null) {
            return new GuideButtonViewListInfo(CollectionsKt.emptyList(), false);
        }
        this.mSlideBtnList = new ArrayList();
        this.mRunningBallList = new ArrayList();
        this.mScreenWidth = parentWidth;
        this.mScreenHeight = parentHeight;
        Pair pair = checkButtonResState(buttons, baseSplash, ctx);
        DegradeType degradeType = (DegradeType) pair.getFirst();
        HashMap validMap = (HashMap) pair.getSecond();
        List buttonViewList = new ArrayList();
        List $this$filter$iv = buttons;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (SplashGuideButtonKt.isValidSecondPageButtonType((SplashGuideButton) element$iv$iv)) {
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
            GuideButtonViewInfo viewInfo = generateView$splash_debug(ctx, it2, splash, baseSplash, validMap, degradeType, true, listener);
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
    public final void updateDeviceSize(Context context, ViewGroup container) {
        final Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Lazy deviceSize$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda1
            public final Object invoke() {
                Point displayRealSize;
                displayRealSize = WindowManagerHelper.getDisplayRealSize(context2);
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
    public final Pair<DegradeType, HashMap<Long, SplashGuideButton>> checkButtonResState(List<SplashGuideButton> list, BaseSplash baseSplash, Context context) {
        Iterable buttons = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Object degradeType = DegradeType.INVALID_RES;
        HashMap validMap = new HashMap();
        Iterable $this$forEach$iv = buttons;
        for (Object element$iv : $this$forEach$iv) {
            SplashGuideButton it = (SplashGuideButton) element$iv;
            if (!it.hitSlideStyle() && !it.hitImageStyle(checkJumpPermission(baseSplash, it)) && !it.hitTextViewStyle() && !it.hitNoInteractLottieView(checkJumpPermission(baseSplash, it)) && !it.hitCountDownStyle(checkJumpPermission(baseSplash, it)) && !SplashGuideButtonKt.getHitCountdownStyleV2(it)) {
                if (it.hitShakeStyle(checkJumpPermission(baseSplash, it))) {
                    boolean $this$runInFalse$iv = SplashSensorUtilsKt.hasAccSensorAndEnable(context2);
                    if (!$this$runInFalse$iv) {
                        degradeType = DegradeType.DEVICE_SENSOR_VALID;
                    }
                    if ($this$runInFalse$iv) {
                        boolean $this$runInFalse$iv2 = SplashSensorUtilsKt.sensorSwitchEnable(context2);
                        if (!$this$runInFalse$iv2) {
                            degradeType = DegradeType.SENSOR_DISABLE;
                        }
                        if ($this$runInFalse$iv2) {
                        }
                    }
                }
                boolean $this$runInFalse$iv3 = true;
                if (it.hitTwistStyle(checkJumpPermission(baseSplash, it))) {
                    boolean $this$runInFalse$iv4 = SplashSensorUtilsKt.hasGyroscopeSensorAndEnable(context2) && SplashSensorUtilsKt.hasAccSensorAndEnable(context2);
                    if (!$this$runInFalse$iv4) {
                        degradeType = DegradeType.DEVICE_SENSOR_VALID;
                    }
                    if ($this$runInFalse$iv4) {
                        boolean $this$runInFalse$iv5 = SplashSensorUtilsKt.sensorSwitchEnable(context2);
                        if (!$this$runInFalse$iv5) {
                            degradeType = DegradeType.SENSOR_DISABLE;
                        }
                        if ($this$runInFalse$iv5) {
                        }
                    }
                }
                if (SplashGuideButtonKt.getHitBrandRotateCardStyle(it)) {
                    boolean $this$runInFalse$iv6 = SplashSensorUtilsKt.hasGyroscopeSensorAndEnable(context2) && SplashSensorUtilsKt.hasAccSensorAndEnable(context2);
                    if (!$this$runInFalse$iv6) {
                        degradeType = DegradeType.DEVICE_SENSOR_VALID;
                    }
                    if ($this$runInFalse$iv6) {
                        boolean $this$runInFalse$iv7 = SplashSensorUtilsKt.sensorSwitchEnable(context2);
                        if (!$this$runInFalse$iv7) {
                            degradeType = DegradeType.SENSOR_DISABLE;
                        }
                        if ($this$runInFalse$iv7) {
                        }
                    }
                }
                if (!SplashGuideButtonKt.getHitShopCardClickStyle(it)) {
                    if (SplashGuideButtonKt.getHitShopCardTwistStyle(it)) {
                        boolean $this$runInFalse$iv8 = SplashSensorUtilsKt.hasGyroscopeSensorAndEnable(context2) && SplashSensorUtilsKt.hasAccSensorAndEnable(context2);
                        if (!$this$runInFalse$iv8) {
                            degradeType = DegradeType.DEVICE_SENSOR_VALID;
                        }
                        if ($this$runInFalse$iv8) {
                            boolean $this$runInFalse$iv9 = SplashSensorUtilsKt.sensorSwitchEnable(context2);
                            if (!$this$runInFalse$iv9) {
                                degradeType = DegradeType.SENSOR_DISABLE;
                            }
                            if ($this$runInFalse$iv9) {
                            }
                        }
                    }
                    if (it.hitRunningBallStyle()) {
                        boolean $this$runInFalse$iv10 = SplashSensorUtilsKt.hasGyroscopeSensorAndEnable(context2);
                        if (!$this$runInFalse$iv10) {
                            degradeType = DegradeType.DEVICE_SENSOR_VALID;
                        }
                        if ($this$runInFalse$iv10) {
                            boolean $this$runInFalse$iv11 = SplashSensorUtilsKt.sensorSwitchEnable(context2);
                            if (!$this$runInFalse$iv11) {
                                degradeType = DegradeType.SENSOR_DISABLE;
                            }
                            if ($this$runInFalse$iv11) {
                            }
                        }
                    }
                    if (it.hitWebpTwistStyle(checkJumpPermission(baseSplash, it))) {
                        $this$runInFalse$iv3 = (SplashSensorUtilsKt.hasGyroscopeSensorAndEnable(context2) && SplashSensorUtilsKt.hasAccSensorAndEnable(context2)) ? false : false;
                        if (!$this$runInFalse$iv3) {
                            degradeType = DegradeType.DEVICE_SENSOR_VALID;
                        }
                        if ($this$runInFalse$iv3) {
                            boolean $this$runInFalse$iv12 = SplashSensorUtilsKt.sensorSwitchEnable(context2);
                            if (!$this$runInFalse$iv12) {
                                degradeType = DegradeType.SENSOR_DISABLE;
                            }
                            if ($this$runInFalse$iv12) {
                            }
                        }
                    }
                    if (it.hitWebpSlideStyle(checkJumpPermission(baseSplash, it))) {
                    }
                }
            }
            validMap.put(Long.valueOf(it.getId()), it);
        }
        BLog.i("[Splash]SplashButtonHelper", "check valid button size = " + validMap.size() + " , " + degradeType + " , " + validMap.keySet());
        return new Pair<>(degradeType, validMap);
    }

    public final GuideButtonViewInfo generateView$splash_debug(Context context, SplashGuideButton splashGuideButton, Splash splash, BaseSplash baseSplash, HashMap<Long, SplashGuideButton> hashMap, DegradeType degradeType, boolean isSecondPage, SplashButtonClickListener listener) {
        boolean disableOutsideInteractiveView;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(baseSplash, "baseSplash");
        Intrinsics.checkNotNullParameter(hashMap, "validMap");
        Intrinsics.checkNotNullParameter(degradeType, "degradeType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        boolean disableOutsideInteractiveView2 = false;
        BLog.i("[Splash]SplashButtonHelper", "generateView:" + splashGuideButton.getInteractStyle());
        if (splashGuideButton.hitImageCheckStyleOnly()) {
            if (checkSelfAndRelatedValid(splashGuideButton, hashMap)) {
                r3 = genImageView(context2, splashGuideButton, splash, listener);
                disableOutsideInteractiveView = false;
            } else if (!checkRelatedValid(splashGuideButton, hashMap)) {
                disableOutsideInteractiveView = false;
            } else {
                String actualUsedImageUrl = splashGuideButton.getActualUsedImageUrl();
                if (actualUsedImageUrl == null || StringsKt.isBlank(actualUsedImageUrl)) {
                    r1 = true;
                }
                if (!r1) {
                    if (splashGuideButton.getDisableOtherInteractWhenDowngrade()) {
                        disableOutsideInteractiveView2 = true;
                    }
                    reportButtonDegrade(splash, degradeType, isSecondPage);
                }
                r3 = genTextView(context2, splashGuideButton, splash, baseSplash, listener);
                disableOutsideInteractiveView = disableOutsideInteractiveView2;
            }
        } else if (checkSelfAndRelatedValid(splashGuideButton.hitSlideCheckStyleOnly(), splashGuideButton, hashMap)) {
            r3 = genSlideView(context2, splashGuideButton, splash, baseSplash, listener);
            disableOutsideInteractiveView = false;
        } else if (splashGuideButton.hitTextViewStyle()) {
            r3 = checkSelfAndRelatedValid(splashGuideButton, hashMap) ? genNonClickableTextView(context2, splashGuideButton, baseSplash) : null;
            disableOutsideInteractiveView = false;
        } else if (checkSelfAndRelatedValid(splashGuideButton.hitShakeCheckStyleOnly(), splashGuideButton, hashMap)) {
            r3 = genShakeView(context2, splashGuideButton, splash, listener);
            disableOutsideInteractiveView = false;
        } else if (checkSelfAndRelatedValid(splashGuideButton.hitNoInteractViewCheckStyleOnly(), splashGuideButton, hashMap)) {
            r3 = SplashButtonFactoryKt.createGuideButtonViewByMaterialType(context2, splash, splashGuideButton, this.mScreenWidth, this.mScreenHeight, listener);
            disableOutsideInteractiveView = false;
        } else if (checkSelfAndRelatedValid(splashGuideButton.hitTwistStyleOnly(), splashGuideButton, hashMap)) {
            r3 = genTwistView(context2, splashGuideButton, splash, listener);
            disableOutsideInteractiveView = false;
        } else if (checkSelfAndRelatedValid(splashGuideButton.hitRunningBallStyleOnly(), splashGuideButton, hashMap)) {
            r3 = genRunningBallView(context2, splashGuideButton, listener);
            disableOutsideInteractiveView = false;
        } else if (checkSelfAndRelatedValid(SplashGuideButtonKt.getHitBrandRotateCardStyle(splashGuideButton), splashGuideButton, hashMap)) {
            r3 = SplashButtonFactoryKt.createSplashButtonByInteractStyle(context2, this.mScreenWidth, this.mScreenHeight, splashGuideButton, splash, listener);
            disableOutsideInteractiveView = false;
        } else {
            if (checkSelfAndRelatedValid(SplashGuideButtonKt.getHitShopCardClickStyle(splashGuideButton) || SplashGuideButtonKt.getHitShopCardTwistStyle(splashGuideButton), splashGuideButton, hashMap)) {
                disableButtonAreaSlide(baseSplash.getView());
                r3 = SplashButtonFactoryKt.createSplashButtonByInteractStyle(context2, this.mScreenWidth, this.mScreenHeight, splashGuideButton, splash, listener);
                disableOutsideInteractiveView = false;
            } else if (SplashGuideButtonKt.getHitCountdownStyleV2(splashGuideButton)) {
                if (!checkSelfAndRelatedValid(splashGuideButton, hashMap)) {
                    disableOutsideInteractiveView = false;
                } else {
                    r3 = SplashButtonFactoryKt.createSplashButtonByInteractStyle(context2, this.mScreenWidth, this.mScreenHeight, splashGuideButton, splash, listener);
                    disableOutsideInteractiveView = false;
                }
            } else if (splashGuideButton.hitCountDownStyleCheckStyleOnly()) {
                if (!checkSelfAndRelatedValid(splashGuideButton, hashMap)) {
                    disableOutsideInteractiveView = false;
                } else {
                    r3 = genCountdownView(context2, splashGuideButton, baseSplash);
                    disableOutsideInteractiveView = false;
                }
            } else {
                if (checkSelfAndRelatedValid(SplashGuideButtonKt.getHitWebpTwistStyle(splashGuideButton) || SplashGuideButtonKt.getHitWebpSlideStyle(splashGuideButton), splashGuideButton, hashMap)) {
                    r3 = SplashButtonWebpBrandCardKt.createWebpButtonByInteractStyle(context2, this.mScreenWidth, this.mScreenHeight, splashGuideButton, splash, listener, splashGuideButton.getInteractStyle() == 17, checkJumpPermission(baseSplash, splashGuideButton));
                    disableOutsideInteractiveView = false;
                } else {
                    if (splashGuideButton.getDisableOtherInteractWhenDowngrade()) {
                        disableOutsideInteractiveView2 = true;
                    }
                    reportButtonDegrade(splash, degradeType, isSecondPage);
                    r3 = genTextView(context2, splashGuideButton, splash, baseSplash, listener);
                    disableOutsideInteractiveView = disableOutsideInteractiveView2;
                }
            }
        }
        View view2 = r3;
        return new GuideButtonViewInfo(view2, disableOutsideInteractiveView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void expandClickArea(final View view2, SplashGuideButton splashGuideButton) {
        final float expandRatio = splashGuideButton.getExpandRatioPercent();
        if (expandRatio <= 1.0f) {
            return;
        }
        view2.post(new Runnable() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                SplashButtonHelper.expandClickArea$lambda$0(view2, expandRatio);
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
        int left = (int) Math.max((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, hitRect.left - ((expandedWidth - width) / 2.0f));
        int right = left + expandedWidth;
        int top = (int) Math.max((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, hitRect.top - ((expandHeight - height) / 2.0f));
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
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        if (buttonData.isCountDownValid()) {
            View contentView = LayoutInflater.from(context2).inflate(R.layout.bili_app_layout_splash_countdown_view, (ViewGroup) null, false);
            Intrinsics.checkNotNullExpressionValue(contentView, "inflate(...)");
            View findViewById = contentView.findViewById(R.id.countdown_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            TextView titleView = (TextView) findViewById;
            View findViewById2 = contentView.findViewById(R.id.countdown);
            TextView $this$genCountdownView_u24lambda_u240 = (TextView) findViewById2;
            $this$genCountdownView_u24lambda_u240.setShadowLayer(ScreenUtil.dip2px(context2, 2.0f), DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, ScreenUtil.dip2px(context2, 1.0f), ContextCompat.getColor(context2, com.bilibili.app.comm.baseres.R.color.black_alpha65));
            Intrinsics.checkNotNullExpressionValue(findViewById2, "apply(...)");
            TextView countdownView = (TextView) findViewById2;
            contentView.setClickable(false);
            int viewWidth = (int) (this.mScreenWidth * buttonData.getWidthPercent());
            int viewHeight = (int) (this.mScreenHeight * 0.07f);
            float viewCenterX = this.mScreenWidth * buttonData.getXPercent();
            float viewCenterY = this.mScreenHeight * buttonData.getYPercent();
            FrameLayout.LayoutParams contentLayoutParams = new FrameLayout.LayoutParams(viewWidth, viewHeight);
            contentView.setX(viewCenterX - (viewWidth / 2));
            contentView.setY(viewCenterY - (viewHeight / 2));
            float mTextSize = viewHeight * buttonData.getFontRatio();
            titleView.setText(buttonData.getGuideInstructions());
            titleView.setTextSize(0, mTextSize);
            countdownView.setTextSize(0, mTextSize);
            titleView.setTextColor(buttonData.getTextColor());
            countdownView.setTextColor(buttonData.getTextColor());
            contentView.setLayoutParams(contentLayoutParams);
            BaseSplash baseSplash2 = ListExtentionsKt.isViewAlive((Fragment) baseSplash) ? baseSplash : null;
            if (baseSplash2 != null && (viewLifecycleOwner = baseSplash2.getViewLifecycleOwner()) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner)) != null) {
                BuildersKt.launch$default(lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new SplashButtonHelper$genCountdownView$2(baseSplash, contentView, countdownView, context2, buttonData, null), 3, (Object) null);
            }
            return contentView;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TextView genNonClickableTextView(Context context, SplashGuideButton splashGuideButton, BaseSplash baseSplash) {
        String schemaTitle;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        int viewWidth = (int) (this.mScreenWidth * splashGuideButton.getWidthPercent());
        int viewHeight = (int) (this.mScreenHeight * splashGuideButton.getHeightPercent());
        float viewCenterX = this.mScreenWidth * splashGuideButton.getXPercent();
        float viewCenterY = this.mScreenHeight * splashGuideButton.getYPercent();
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
                if (checkSchemaListJumpPermission(baseSplash, splashGuideButton, it2)) {
                    str = next;
                    break;
                }
            }
            str = str;
        }
        String schemaAdjustableFind = str;
        TextView $this$genNonClickableTextView_u24lambda_u241 = new TextView(context2);
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
        $this$genNonClickableTextView_u24lambda_u241.setTextColor(splashGuideButton.getTextColor());
        $this$genNonClickableTextView_u24lambda_u241.setGravity(17);
        $this$genNonClickableTextView_u24lambda_u241.setClickable(false);
        $this$genNonClickableTextView_u24lambda_u241.setEllipsize(TextUtils.TruncateAt.END);
        $this$genNonClickableTextView_u24lambda_u241.setSingleLine(true);
        if (splashGuideButton.getTextColor() != -10394003) {
            $this$genNonClickableTextView_u24lambda_u241.setShadowLayer(ListExtentionsKt.toPx(2), DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, ListExtentionsKt.toPx(1), ContextCompat.getColor(context2, com.bilibili.app.comm.baseres.R.color.black_alpha50));
        }
        TextPaint paint = $this$genNonClickableTextView_u24lambda_u241.getPaint();
        if (paint != null) {
            paint.setTypeface(Typeface.create($this$genNonClickableTextView_u24lambda_u241.getTypeface(), 1));
        }
        return $this$genNonClickableTextView_u24lambda_u241;
    }

    private final View genTextView(Context context, final SplashGuideButton guideButton, final Splash splash, BaseSplash baseSplash, final SplashButtonClickListener listener) {
        int i;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        boolean isJumpThirdPartApp = checkJumpPermission(baseSplash, guideButton);
        int viewWidth = (int) (this.mScreenWidth * guideButton.getWidthPercent());
        int viewHeight = (int) (this.mScreenHeight * 0.07f);
        float textSize = viewHeight * 0.3f;
        float subTextSize = viewHeight * 0.23f;
        float viewCenterX = this.mScreenWidth * guideButton.getXPercent();
        float viewCenterY = this.mScreenHeight * guideButton.getYPercent();
        View rootView = LayoutInflater.from(context2).inflate(R.layout.bili_app_splash_guide_button_layout, (ViewGroup) null, false);
        rootView.setBackground(genTextViewBg(SplashGuideButton.getBgColor$default(guideButton, context2, 0, 2, null)));
        rootView.setLayoutParams(new ViewGroup.LayoutParams(viewWidth, viewHeight));
        rootView.setX(viewCenterX - (viewWidth / 2));
        rootView.setY(viewCenterY - (viewHeight / 2));
        int padding = (int) (viewHeight * 0.4f);
        rootView.setPadding(padding, 0, padding, 0);
        rootView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SplashButtonClickListener.this.onClick(splash, guideButton);
            }
        });
        ImageView iconView = (ImageView) rootView.findViewById(R.id.guide_icon);
        TextView titleTextView = (TextView) rootView.findViewById(R.id.guide_text);
        TextView subTextView = (TextView) rootView.findViewById(R.id.secondary_guide_text);
        titleTextView.setText(isJumpThirdPartApp ? guideButton.getSchemaTitle() : guideButton.getGuideInstructions());
        titleTextView.setTextColor(guideButton.getTextColor());
        titleTextView.setTextSize(0, textSize);
        titleTextView.setCompoundDrawablePadding(0);
        String subTitle = guideButton.getSecondaryGuideInstructions();
        String str = subTitle;
        if (str == null || StringsKt.isBlank(str)) {
            subTextView.setVisibility(8);
        } else {
            subTextView.setText(subTitle);
            subTextView.setTextColor(guideButton.getSubTextColor());
            subTextView.setTextSize(0, subTextSize);
            subTextView.setVisibility(0);
        }
        if (isJumpThirdPartApp && subTextView.getVisibility() != 0) {
            Drawable it = ContextCompat.getDrawable(context2, com.bilibili.app.comm.baseres.R.drawable.ic_arrow_white_without_padding_alpha);
            iconView.setImageDrawable(it != null ? UiUtils.INSTANCE.tintDrawable(it, guideButton.getTextColor()) : null);
            i = 0;
        } else {
            i = 8;
        }
        iconView.setVisibility(i);
        Intrinsics.checkNotNull(rootView);
        return rootView;
    }

    private final void reportButtonDegrade(Splash splash, DegradeType degradeType, boolean isSecondPage) {
        SplashAdHelper.adSplashButtonLottieDegradeEvent(splash, degradeType, isSecondPage);
    }

    private final View genImageView(Context context, final SplashGuideButton splashGuideButton, final Splash splash, final SplashButtonClickListener listener) {
        File file;
        boolean isButtonGuideEnable;
        final float viewCenterY;
        final int viewHeight;
        SafeLottieAnimationView guideImage;
        SafeLottieAnimationView image;
        final Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        if (splashGuideButton.getGuideMaterialType() != 0) {
            return null;
        }
        final View rootView = LayoutInflater.from(context2).inflate(R.layout.bili_app_layout_splash_image_button, (ViewGroup) null);
        final SafeLottieAnimationView image2 = (SafeLottieAnimationView) rootView.findViewById(R.id.splash_button_image);
        final SafeLottieAnimationView guideImage2 = (SafeLottieAnimationView) rootView.findViewById(R.id.splash_button_guide);
        final int viewWidth = (int) (this.mScreenWidth * splashGuideButton.getWidthPercent());
        final int viewHeight2 = (int) (this.mScreenHeight * splashGuideButton.getHeightPercent());
        float viewCenterX = this.mScreenWidth * splashGuideButton.getXPercent();
        final float viewCenterY2 = this.mScreenHeight * splashGuideButton.getYPercent();
        rootView.setLayoutParams(new ViewGroup.LayoutParams(viewWidth, -2));
        rootView.setX(viewCenterX - (viewWidth / 2));
        rootView.setY(viewCenterY2 - (viewHeight2 / 2));
        String imageUrl = splashGuideButton.getActualUsedImageUrl();
        String imageHash = splashGuideButton.getActualUsedImageHash();
        BLog.i("[Splash]SplashButtonHelper", "genShakeView actual used image url = " + imageUrl);
        if (TextUtils.isEmpty(imageUrl) || (file = BusinessSplashResHelper.fetchResourceFileByHash(imageHash)) == null) {
            return null;
        }
        ViewGroup.LayoutParams lp = image2.getLayoutParams();
        lp.width = viewWidth;
        lp.height = viewHeight2;
        image2.setLayoutParams(lp);
        Intrinsics.checkNotNull(image2);
        SplashButtonHelperKt.stopWhenDetach(image2);
        Intrinsics.checkNotNull(guideImage2);
        SplashButtonHelperKt.stopWhenDetach(guideImage2);
        SafeLottieCompositionFactory.INSTANCE.safeLoadPlayLottie(splash, image2, new FileInputStream(file), imageUrl, new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit genImageView$lambda$0;
                genImageView$lambda$0 = SplashButtonHelper.genImageView$lambda$0(SafeLottieAnimationView.this, (LottieComposition) obj);
                return genImageView$lambda$0;
            }
        });
        isButtonGuideEnable = SplashButtonHelperKt.isButtonGuideEnable(context2, 1);
        if (!isButtonGuideEnable) {
            viewCenterY = viewCenterY2;
            viewHeight = viewHeight2;
            guideImage = guideImage2;
            image = image2;
        } else if (TextUtils.isEmpty(splashGuideButton.getGuideImageUrl())) {
            viewCenterY = viewCenterY2;
            viewHeight = viewHeight2;
            guideImage = guideImage2;
            image = image2;
        } else {
            File guideResFile = BusinessSplashResHelper.fetchResourceFileByHash(splashGuideButton.getGuideImageMD5());
            if (guideResFile == null) {
                viewCenterY = viewCenterY2;
                viewHeight = viewHeight2;
                guideImage = guideImage2;
                image = image2;
            } else {
                String guideImageUrl = splashGuideButton.getGuideImageUrl();
                guideImage = guideImage2;
                image = image2;
                Function1<? super LottieComposition, Unit> function1 = new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        Unit genImageView$lambda$1$0;
                        genImageView$lambda$1$0 = SplashButtonHelper.genImageView$lambda$1$0(SafeLottieAnimationView.this, context2, viewWidth, rootView, viewCenterY2, viewHeight2, (LottieComposition) obj);
                        return genImageView$lambda$1$0;
                    }
                };
                viewHeight = viewHeight2;
                viewCenterY = viewCenterY2;
                SafeLottieCompositionFactory.INSTANCE.safeLoadPlayLottie(splash, guideImage, new FileInputStream(guideResFile), guideImageUrl, function1);
            }
        }
        rootView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SplashButtonClickListener.this.onClick(splash, splashGuideButton);
            }
        });
        final SafeLottieAnimationView guideImage3 = guideImage;
        image.setOnTouchListener(new View.OnTouchListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda10
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean genImageView$lambda$3;
                genImageView$lambda$3 = SplashButtonHelper.genImageView$lambda$3(SafeLottieAnimationView.this, rootView, viewCenterY, viewHeight, view2, motionEvent);
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
        $guideImage.addAnimatorListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$genImageView$2$1$1$1
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
    public static final boolean genImageView$lambda$3(SafeLottieAnimationView $guideImage, View $rootView, float $viewCenterY, int $viewHeight, View view2, MotionEvent motionEvent) {
        $guideImage.setVisibility(8);
        $rootView.setY($viewCenterY - ($viewHeight / 2));
        return false;
    }

    private final View genTwistView(Context context, SplashGuideButton splashButton, Splash splash, SplashButtonClickListener listener) {
        View image;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        View rootView = SplashButtonFactoryKt.createGuideButtonViewByMaterialType(context2, splash, splashButton, this.mScreenWidth, this.mScreenHeight, listener);
        if (rootView == null || (image = ListExtentionsKt.getChildOrNull(rootView, 0)) == null) {
            return null;
        }
        SplashRotateSensorHelperKt.addRotateSensor(context2, rootView, image, splashButton, splash, listener);
        return rootView;
    }

    private final View genRunningBallView(Context context, final SplashGuideButton buttonData, final SplashButtonClickListener listener) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        File fetchResourceFileByHash = BusinessSplashResHelper.fetchResourceFileByHash(buttonData.getLogoImageMD5());
        String logoFilePath = fetchResourceFileByHash != null ? fetchResourceFileByHash.getPath() : null;
        String str = logoFilePath;
        if (str == null || str.length() == 0) {
            return null;
        }
        View inflate = LayoutInflater.from(context2).inflate(R.layout.bili_app_layout_splash_runningball_view, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type tv.danmaku.bili.ui.splash.widget.SplashRunningBallView");
        final SplashRunningBallView runningBallView = (SplashRunningBallView) inflate;
        runningBallView.setClickable(false);
        runningBallView.setBgColor(buttonData.getBgColor(context2, ContextCompat.getColor(context2, com.bilibili.app.comm.baseres.R.color.black_alpha40)));
        runningBallView.setStrokeColor(buttonData.getBorderColor(ContextCompat.getColor(context2, com.bilibili.app.comm.baseres.R.color.white_alpha40)));
        runningBallView.setHoleBgColor(SplashGuideButton.getSlideHoleBgColor$default(buttonData, 0, 1, null));
        runningBallView.setHoleStrokeColor(SplashGuideButton.getSlideHoleBorderColor$default(buttonData, 0, 1, null));
        runningBallView.setMaxAngle(Math.toRadians(buttonData.getTwistAngle()));
        runningBallView.setBallFile(logoFilePath);
        runningBallView.setThresholdPercent(buttonData.getThresholdPercent());
        Float valueOf = Float.valueOf(buttonData.getWidthPercent());
        float it = valueOf.floatValue();
        if (!(it > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN)) {
            valueOf = null;
        }
        float viewWidthPercent = valueOf != null ? valueOf.floatValue() : 0.64f;
        Float valueOf2 = Float.valueOf(buttonData.getHeightPercent());
        float it2 = valueOf2.floatValue();
        Float f = it2 > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? valueOf2 : null;
        float viewHeightPercent = f != null ? f.floatValue() : 0.065f;
        int viewWidth = (int) (this.mScreenWidth * viewWidthPercent);
        int viewHeight = (int) (this.mScreenHeight * viewHeightPercent);
        float viewCenterX = this.mScreenWidth * buttonData.getXPercent();
        float viewCenterY = this.mScreenHeight * buttonData.getYPercent();
        runningBallView.setLayoutParams(new FrameLayout.LayoutParams(viewWidth, viewHeight));
        runningBallView.setX(viewCenterX - (viewWidth / 2));
        runningBallView.setY(viewCenterY - (viewHeight / 2));
        final SensorSet sensorSet = new SensorSet();
        if (Math.abs(buttonData.getTwistAngle()) >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            ISensor rotateDegreeSensor = new RotateDegreeSensor(context2);
            rotateDegreeSensor.addListener(new RotateDegreeSensor.RotateListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda0
                public final void onDegreeChanged(float[] fArr) {
                    SplashButtonHelper.genRunningBallView$lambda$3(SplashRunningBallView.this, fArr);
                }
            });
            sensorSet.addSensor(rotateDegreeSensor);
        }
        if (!sensorSet.isEmpty()) {
            runningBallView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$genRunningBallView$3
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
        runningBallView.setOnReachedAction(new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit genRunningBallView$lambda$4;
                genRunningBallView$lambda$4 = SplashButtonHelper.genRunningBallView$lambda$4(sensorSet, listener, buttonData, ((Boolean) obj).booleanValue());
                return genRunningBallView$lambda$4;
            }
        });
        if (SplashUtilsKt.isDebug()) {
            SplashSensorDebugKt.addRunningBallDebugView(runningBallView, sensorSet);
        }
        List<SplashRunningBallView> list = this.mRunningBallList;
        if (list != null) {
            list.add(runningBallView);
        }
        return runningBallView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void genRunningBallView$lambda$3(SplashRunningBallView $runningBallView, float[] degreesDelta) {
        Intrinsics.checkNotNullParameter(degreesDelta, "degreesDelta");
        $runningBallView.setAngle(SplashRunningBallView.Companion.adjustRadian(degreesDelta));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit genRunningBallView$lambda$4(SensorSet $sensorSet, SplashButtonClickListener $listener, SplashGuideButton $buttonData, boolean triggerFromThreshold) {
        $sensorSet.stop();
        $listener.onRunning($buttonData, triggerFromThreshold);
        return Unit.INSTANCE;
    }

    private final View genShakeView(Context context, final SplashGuideButton splashGuideButton, final Splash splash, final SplashButtonClickListener listener) {
        View image;
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        View rootView = SplashButtonFactoryKt.createGuideButtonViewByMaterialType(context2, splash, splashGuideButton, this.mScreenWidth, this.mScreenHeight, listener);
        if (rootView == null || (image = ListExtentionsKt.getChildOrNull(rootView, 0)) == null) {
            return null;
        }
        final AcceleratorSensor accSensor = new AcceleratorSensor(context2);
        rootView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$genShakeView$1
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
        accSensor.addListener(new AcceleratorSensor.SpeedChangedListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda2
            public final void onSpeedChanged(float f) {
                SplashButtonHelper.genShakeView$lambda$0(accSensor, listener, splashGuideButton, f);
            }
        });
        if (splashGuideButton.hitShakeClickCheckStyleOnly()) {
            image.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SplashButtonClickListener.this.onClick(splash, splashGuideButton);
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

    private final View genSlideView(Context context, final SplashGuideButton splashGuideButton, final Splash splash, BaseSplash baseSplash, final SplashButtonClickListener listener) {
        boolean isButtonGuideEnable;
        final float viewCenterY;
        final int viewHeight;
        final SafeLottieAnimationView guideView;
        final Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        File fetchResourceFileByHash = BusinessSplashResHelper.fetchResourceFileByHash(splashGuideButton.getLogoImageMD5());
        String logoFilePath = fetchResourceFileByHash != null ? fetchResourceFileByHash.getPath() : null;
        String str = logoFilePath;
        if (str == null || str.length() == 0) {
            return null;
        }
        boolean isJumpThirdPartApp = checkJumpPermission(baseSplash, splashGuideButton);
        final View rootView = LayoutInflater.from(context2).inflate(R.layout.bili_app_layout_splash_slide_view, (ViewGroup) null);
        SplashSlideUnlockView slideView = (SplashSlideUnlockView) rootView.findViewById(R.id.slide_view);
        final SafeLottieAnimationView guideView2 = (SafeLottieAnimationView) rootView.findViewById(R.id.splash_slide_guide);
        guideView2.setSafeMode(true);
        Intrinsics.checkNotNull(guideView2);
        SplashButtonHelperKt.stopWhenDetach(guideView2);
        final int viewWidth = (int) (this.mScreenWidth * 0.7d);
        int viewHeight2 = (int) (this.mScreenHeight * 0.07d);
        float viewCenterX = this.mScreenWidth * splashGuideButton.getXPercent();
        float viewCenterY2 = this.mScreenHeight * splashGuideButton.getYPercent();
        rootView.setLayoutParams(new ViewGroup.LayoutParams(viewWidth, -2));
        rootView.setX(viewCenterX - (viewWidth / 2));
        rootView.setY(viewCenterY2 - (viewHeight2 / 2));
        ViewGroup.LayoutParams slideLp = slideView.getLayoutParams();
        slideLp.width = viewWidth;
        slideLp.height = viewHeight2;
        slideView.setLayoutParams(slideLp);
        slideView.setBackground(genSlideViewBg(SplashGuideButton.getBgColor$default(splashGuideButton, context2, 0, 2, null), SplashGuideButton.getBorderColor$default(splashGuideButton, 0, 1, null)));
        slideView.initSize(viewWidth, viewHeight2, splashGuideButton.getThresholdPercent());
        String text = isJumpThirdPartApp ? splashGuideButton.getSchemaTitleNew() : splashGuideButton.getGuideInstructionsNew();
        slideView.showText(text, splashGuideButton.getTextColor());
        slideView.showLogo(logoFilePath);
        slideView.showAnim();
        slideView.setOnSlideListener(new SplashSlideUnlockView.OnSlideClickListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$genSlideView$1
            @Override // tv.danmaku.bili.ui.splash.widget.SplashSlideUnlockView.OnSlideClickListener
            public void onSlided(boolean isSuccess) {
                if (isSuccess) {
                    SplashButtonClickListener.this.onSlide(splashGuideButton);
                } else {
                    SplashAdHelper.INSTANCE.adSplashSlideFailed(splash);
                }
            }

            @Override // tv.danmaku.bili.ui.splash.widget.SplashSlideUnlockView.OnSlideClickListener
            public void onClick() {
                if (splashGuideButton.getInteractStyle() == 2) {
                    SplashButtonClickListener.this.onClick(splash, splashGuideButton);
                }
            }
        });
        isButtonGuideEnable = SplashButtonHelperKt.isButtonGuideEnable(context2, 2);
        if (!isButtonGuideEnable) {
            viewCenterY = viewCenterY2;
            viewHeight = viewHeight2;
            guideView = guideView2;
        } else if (TextUtils.isEmpty(splashGuideButton.getGuideImageUrl())) {
            viewCenterY = viewCenterY2;
            viewHeight = viewHeight2;
            guideView = guideView2;
        } else if (TextUtils.isEmpty(splashGuideButton.getGuideImageMD5())) {
            viewCenterY = viewCenterY2;
            viewHeight = viewHeight2;
            guideView = guideView2;
        } else {
            File guideResFile = BusinessSplashResHelper.fetchResourceFileByHash(splashGuideButton.getGuideImageMD5());
            if (guideResFile == null) {
                viewCenterY = viewCenterY2;
                viewHeight = viewHeight2;
                guideView = guideView2;
            } else {
                String guideImageUrl = splashGuideButton.getGuideImageUrl();
                viewCenterY = viewCenterY2;
                viewHeight = viewHeight2;
                Function1<? super LottieComposition, Unit> function1 = new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj) {
                        Unit genSlideView$lambda$0$0;
                        genSlideView$lambda$0$0 = SplashButtonHelper.genSlideView$lambda$0$0(SafeLottieAnimationView.this, context2, viewWidth, rootView, viewCenterY, viewHeight, (LottieComposition) obj);
                        return genSlideView$lambda$0$0;
                    }
                };
                guideView = guideView2;
                SafeLottieCompositionFactory.INSTANCE.safeLoadPlayLottie(splash, guideView, new FileInputStream(guideResFile), guideImageUrl, function1);
            }
        }
        final float viewCenterY3 = viewCenterY;
        final int viewHeight3 = viewHeight;
        slideView.setOnTouchListener(new View.OnTouchListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$$ExternalSyntheticLambda12
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean genSlideView$lambda$1;
                genSlideView$lambda$1 = SplashButtonHelper.genSlideView$lambda$1(SafeLottieAnimationView.this, rootView, viewCenterY3, viewHeight3, view2, motionEvent);
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
        $guideView.addAnimatorListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper$genSlideView$2$1$1$1
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
    public static final boolean genSlideView$lambda$1(SafeLottieAnimationView $guideView, View $rootView, float $viewCenterY, int $viewHeight, View view2, MotionEvent motionEvent) {
        $guideView.setVisibility(8);
        $rootView.setY($viewCenterY - ($viewHeight / 2));
        return false;
    }

    public final boolean checkJumpPermission(BaseSplash baseSplash, SplashGuideButton splashGuideButton) {
        Intrinsics.checkNotNullParameter(baseSplash, "baseSplash");
        Intrinsics.checkNotNullParameter(splashGuideButton, "splashGuideButton");
        return StringUtil.isNotBlank(splashGuideButton.getSchema()) && StringUtil.isNotBlank(splashGuideButton.getSchemaPackageName()) && baseSplash.buildThirdIntent(splashGuideButton.getSchema(), splashGuideButton.getSchemaPackageName()) != null;
    }

    private final boolean checkSchemaListJumpPermission(BaseSplash baseSplash, SplashGuideButton splashGuideButton, String schema) {
        return StringUtil.isNotBlank(schema) && StringUtil.isNotBlank(splashGuideButton.getSchemaPackageName()) && baseSplash.buildThirdIntent(schema, splashGuideButton.getSchemaPackageName()) != null;
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
        List<SplashRunningBallView> list = this.mRunningBallList;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterable iterable = this.mRunningBallList;
        if (iterable != null) {
            Iterable $this$forEach$iv = iterable;
            for (Object element$iv : $this$forEach$iv) {
                SplashRunningBallView it = (SplashRunningBallView) element$iv;
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
        List<SplashRunningBallView> list2 = this.mRunningBallList;
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