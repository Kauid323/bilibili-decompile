package tv.danmaku.bili.videopage.common.segment;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.lib.theme.R;
import com.bilibili.lib.ui.helper.NotchCompat;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.playerbizcommon.features.hardware.HardwareService;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.videopage.foundation.IActivityHost;
import tv.danmaku.bili.videopage.foundation.IFragmentHost;
import tv.danmaku.bili.videopage.foundation.IHost;
import tv.danmaku.bili.videopage.foundation.ISegment;
import tv.danmaku.bili.videopage.foundation.event.ActivityLifecycleStateEventObserver;
import tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventDispatcher;
import tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventObserver;
import tv.danmaku.biliplayerv2.NewPlayerUtilsKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: WindowStateManageSegment.kt */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u001a\u0018\u0000 N2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\u001d2\u000e\u0010\"\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001H\u0016J\b\u0010#\u001a\u00020\u001dH\u0002J\u0016\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\rJ\u0006\u0010-\u001a\u00020\u000fJ\b\u0010.\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\b\u00100\u001a\u00020\u001dH\u0002J\b\u00101\u001a\u00020\u001dH\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\u001a\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0010\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u0011H\u0002J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u0011H\u0002J\u0006\u0010>\u001a\u00020\u001dJ\u0006\u0010?\u001a\u00020\u001dJ\u0010\u0010@\u001a\u00020\u001d2\u0006\u0010A\u001a\u000207H\u0002J\u0018\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u00112\u0006\u0010A\u001a\u000207H\u0002J\u0018\u0010=\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u00112\u0006\u0010A\u001a\u000207H\u0002J\n\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u000e\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u000fJ\u000e\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u0011J\u0006\u0010H\u001a\u00020\u001dJ\u0006\u0010I\u001a\u00020\u001dJ\u0006\u0010J\u001a\u00020\u000fJ\u0006\u0010K\u001a\u00020\u0011J\u0006\u0010L\u001a\u00020\u0011J\u0006\u0010M\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\u00020\u000f8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006O"}, d2 = {"Ltv/danmaku/bili/videopage/common/segment/WindowStateManageSegment;", "Ltv/danmaku/bili/videopage/foundation/ISegment;", "Ltv/danmaku/bili/videopage/foundation/IHost;", "Ltv/danmaku/bili/videopage/common/segment/WindowStateParamsParser;", "<init>", "()V", "mHost", "mActivityEventDispatcher", "Ltv/danmaku/bili/videopage/foundation/event/ILifecycleStateEventDispatcher;", "mParamsParser", "mOrientationChangeProcessor", "Ltv/danmaku/bili/videopage/common/segment/OrientationChangeProcessor;", "mStatusBarDrawHeightObserver", "Lcom/bilibili/playerbizcommon/features/hardware/HardwareService$IStatusBarDrawHeightObserver;", "mWindowAttached", "", "mStatusBarPlayerHeight", "", "mStatusBarDrawHeight", "mScreenRatio", "", "mScreenOrientation", "mIsDisplayCutout", "getMIsDisplayCutout", "()Z", "mActivityLifecycleStateEventObserver", "tv/danmaku/bili/videopage/common/segment/WindowStateManageSegment$mActivityLifecycleStateEventObserver$1", "Ltv/danmaku/bili/videopage/common/segment/WindowStateManageSegment$mActivityLifecycleStateEventObserver$1;", "onAttach", "", "host", "paramsParser", "onDetach", "onBindDependency", "segment", "init", "addGravityEnableDispatcher", "dispatcher", "Ltv/danmaku/bili/videopage/common/segment/GravityEnableDispatcher;", "from", "", "removeGravityEnableDispatcher", "registerStatusBarDrawHeight", "observer", "unregisterStatusBarDrawHeight", "isDisplayCutout", "checkUIWhenContextOnStart", "processWindowAttached", "processWindowDetached", "handleFoldableWindowStateChanged", "handleWindowStateChanged", "pinBelowStatusBar", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "immersiveStatusBar", "window", "Landroid/view/Window;", "addSystemUiFlag", "flag", "removeSystemUiFlag", "enterImmersiveFullscreen", "exitImmersiveFullscreen", "removeShade", "decorView", "getActivity", "Landroidx/fragment/app/FragmentActivity;", "setOnlyHorizontalRotationEnable", "enable", "switchScreenOrientation", "orientation", "switchToSuitablePortriat", "switchToSuitableLandscape", "performBackPressed", "getCutoutHardwareHeight", "getStatusBarDrawHeight", "getStatusBarPlayerHeight", "Companion", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WindowStateManageSegment implements ISegment<IHost, WindowStateParamsParser> {
    public static final Companion Companion = new Companion(null);
    private static final String SHADE_TAG = "shade_tag";
    private static final String TAG = "WindowStateManageSegment";
    private ILifecycleStateEventDispatcher mActivityEventDispatcher;
    private final WindowStateManageSegment$mActivityLifecycleStateEventObserver$1 mActivityLifecycleStateEventObserver = new ActivityLifecycleStateEventObserver() { // from class: tv.danmaku.bili.videopage.common.segment.WindowStateManageSegment$mActivityLifecycleStateEventObserver$1
        @Override // tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventObserver
        public /* synthetic */ void onCreate() {
            ILifecycleStateEventObserver.CC.$default$onCreate(this);
        }

        @Override // tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventObserver
        public /* synthetic */ void onDestroy() {
            ILifecycleStateEventObserver.CC.$default$onDestroy(this);
        }

        @Override // tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventObserver
        public /* synthetic */ boolean onKeyEvent(KeyEvent keyEvent) {
            return ILifecycleStateEventObserver.CC.$default$onKeyEvent(this, keyEvent);
        }

        @Override // tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventObserver
        public /* synthetic */ void onMultiWindowModeChanged(boolean z) {
            ILifecycleStateEventObserver.CC.$default$onMultiWindowModeChanged(this, z);
        }

        @Override // tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventObserver
        public /* synthetic */ void onPause() {
            ILifecycleStateEventObserver.CC.$default$onPause(this);
        }

        @Override // tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventObserver
        public /* synthetic */ void onResume() {
            ILifecycleStateEventObserver.CC.$default$onResume(this);
        }

        @Override // tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventObserver
        public /* synthetic */ void onStop() {
            ILifecycleStateEventObserver.CC.$default$onStop(this);
        }

        @Override // tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventObserver
        public void onStart() {
            WindowStateManageSegment.this.checkUIWhenContextOnStart();
        }

        @Override // tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventObserver
        public void onWindowFocusChanged(boolean hasFocus) {
            OrientationChangeProcessor orientationChangeProcessor;
            OrientationChangeProcessor orientationChangeProcessor2;
            if (hasFocus) {
                orientationChangeProcessor2 = WindowStateManageSegment.this.mOrientationChangeProcessor;
                if (orientationChangeProcessor2 != null) {
                    orientationChangeProcessor2.startGravitySensor$videopagecommon_apinkDebug();
                }
                BLog.i("WindowStateManageSegment", "window has focus, try to enable gravity sensor");
                return;
            }
            orientationChangeProcessor = WindowStateManageSegment.this.mOrientationChangeProcessor;
            if (orientationChangeProcessor != null) {
                orientationChangeProcessor.stopGravitySensor$videopagecommon_apinkDebug();
            }
            BLog.i("WindowStateManageSegment", "window loss focus, try to disable gravity sensor");
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
            r2 = r7.this$0.getActivity();
         */
        @Override // tv.danmaku.bili.videopage.foundation.event.ILifecycleStateEventObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onConfigurationChanged(Configuration newConfig) {
            OrientationChangeProcessor orientationChangeProcessor;
            float f;
            FragmentActivity activity;
            final Window it;
            int i;
            BLog.i("WindowStateManageSegment", "onConfigurationChanged:" + newConfig);
            if (newConfig == null) {
                return;
            }
            orientationChangeProcessor = WindowStateManageSegment.this.mOrientationChangeProcessor;
            if (orientationChangeProcessor != null) {
                orientationChangeProcessor.onConfigurationChanged$videopagecommon_apinkDebug(newConfig);
            }
            if (newConfig.screenHeightDp > 0) {
                float ratio = newConfig.screenWidthDp / newConfig.screenHeightDp;
                f = WindowStateManageSegment.this.mScreenRatio;
                if (!(f == ratio)) {
                    i = WindowStateManageSegment.this.mScreenOrientation;
                    if (i == newConfig.orientation) {
                    }
                }
                if (newConfig.orientation == 1 && activity != null && (it = activity.getWindow()) != null) {
                    final WindowStateManageSegment windowStateManageSegment = WindowStateManageSegment.this;
                    it.getDecorView().getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: tv.danmaku.bili.videopage.common.segment.WindowStateManageSegment$mActivityLifecycleStateEventObserver$1$onConfigurationChanged$1$1
                        @Override // android.view.ViewTreeObserver.OnPreDrawListener
                        public boolean onPreDraw() {
                            WindowStateManageSegment.this.handleFoldableWindowStateChanged();
                            it.getDecorView().getViewTreeObserver().removeOnPreDrawListener(this);
                            return true;
                        }
                    });
                }
                WindowStateManageSegment.this.mScreenRatio = ratio;
                WindowStateManageSegment.this.mScreenOrientation = newConfig.orientation;
            }
        }
    };
    private IHost mHost;
    private boolean mIsDisplayCutout;
    private OrientationChangeProcessor mOrientationChangeProcessor;
    private WindowStateParamsParser mParamsParser;
    private int mScreenOrientation;
    private float mScreenRatio;
    private int mStatusBarDrawHeight;
    private HardwareService.IStatusBarDrawHeightObserver mStatusBarDrawHeightObserver;
    private int mStatusBarPlayerHeight;
    private boolean mWindowAttached;

    private final boolean getMIsDisplayCutout() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return false;
        }
        return NotchCompat.hasDisplayCutoutHardware(activity.getWindow());
    }

    @Override // tv.danmaku.bili.videopage.foundation.ISegment
    public void onAttach(IHost host, WindowStateParamsParser paramsParser) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(paramsParser, "paramsParser");
        this.mHost = host;
        this.mParamsParser = paramsParser;
        init();
        ILifecycleStateEventDispatcher iLifecycleStateEventDispatcher = this.mActivityEventDispatcher;
        if (iLifecycleStateEventDispatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityEventDispatcher");
            iLifecycleStateEventDispatcher = null;
        }
        iLifecycleStateEventDispatcher.addEventObserver(this.mActivityLifecycleStateEventObserver);
    }

    @Override // tv.danmaku.bili.videopage.foundation.ISegment
    public void onDetach() {
        ILifecycleStateEventDispatcher iLifecycleStateEventDispatcher = this.mActivityEventDispatcher;
        if (iLifecycleStateEventDispatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityEventDispatcher");
            iLifecycleStateEventDispatcher = null;
        }
        iLifecycleStateEventDispatcher.removeEventObserver(this.mActivityLifecycleStateEventObserver);
        OrientationChangeProcessor orientationChangeProcessor = this.mOrientationChangeProcessor;
        if (orientationChangeProcessor != null) {
            orientationChangeProcessor.stop$videopagecommon_apinkDebug();
        }
    }

    @Override // tv.danmaku.bili.videopage.foundation.ISegment
    public void onBindDependency(ISegment<?, ?> iSegment) {
        Intrinsics.checkNotNullParameter(iSegment, "segment");
        if (iSegment instanceof ILifecycleStateEventDispatcher) {
            this.mActivityEventDispatcher = (ILifecycleStateEventDispatcher) iSegment;
        }
    }

    private final void init() {
        BLog.i(TAG, "Init WindowStateManageSegment.");
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            BLog.e(TAG, "Illage state!!! can't get activity???");
            return;
        }
        this.mOrientationChangeProcessor = new OrientationChangeProcessor(activity);
        OrientationChangeProcessor orientationChangeProcessor = this.mOrientationChangeProcessor;
        if (orientationChangeProcessor != null) {
            orientationChangeProcessor.start$videopagecommon_apinkDebug();
        }
        if (ViewCompat.isAttachedToWindow(activity.getWindow().getDecorView())) {
            processWindowAttached();
        } else {
            activity.getWindow().getDecorView().getViewTreeObserver().addOnWindowAttachListener(new ViewTreeObserver.OnWindowAttachListener() { // from class: tv.danmaku.bili.videopage.common.segment.WindowStateManageSegment$init$1
                @Override // android.view.ViewTreeObserver.OnWindowAttachListener
                public void onWindowAttached() {
                    WindowStateManageSegment.this.processWindowAttached();
                }

                @Override // android.view.ViewTreeObserver.OnWindowAttachListener
                public void onWindowDetached() {
                    activity.getWindow().getDecorView().getViewTreeObserver().removeOnWindowAttachListener(this);
                    WindowStateManageSegment.this.processWindowDetached();
                }
            });
        }
    }

    public final void addGravityEnableDispatcher(GravityEnableDispatcher dispatcher, String from) {
        HashMap<GravityEnableDispatcher, String> gravityEnableDispatcherList$videopagecommon_apinkDebug;
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(from, "from");
        OrientationChangeProcessor orientationChangeProcessor = this.mOrientationChangeProcessor;
        if (orientationChangeProcessor == null || (gravityEnableDispatcherList$videopagecommon_apinkDebug = orientationChangeProcessor.getGravityEnableDispatcherList$videopagecommon_apinkDebug()) == null) {
            return;
        }
        gravityEnableDispatcherList$videopagecommon_apinkDebug.put(dispatcher, from);
    }

    public final void removeGravityEnableDispatcher(GravityEnableDispatcher dispatcher) {
        HashMap<GravityEnableDispatcher, String> gravityEnableDispatcherList$videopagecommon_apinkDebug;
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        OrientationChangeProcessor orientationChangeProcessor = this.mOrientationChangeProcessor;
        if (orientationChangeProcessor == null || (gravityEnableDispatcherList$videopagecommon_apinkDebug = orientationChangeProcessor.getGravityEnableDispatcherList$videopagecommon_apinkDebug()) == null) {
            return;
        }
        gravityEnableDispatcherList$videopagecommon_apinkDebug.remove(dispatcher);
    }

    public final void registerStatusBarDrawHeight(HardwareService.IStatusBarDrawHeightObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mStatusBarDrawHeightObserver = observer;
    }

    public final void unregisterStatusBarDrawHeight(HardwareService.IStatusBarDrawHeightObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mStatusBarDrawHeightObserver = null;
    }

    public final boolean isDisplayCutout() {
        return getMIsDisplayCutout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkUIWhenContextOnStart() {
        Window window;
        Context activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        removeShade(decorView);
        if (Build.VERSION.SDK_INT >= 26) {
            if (MultipleThemeUtils.isNightTheme(activity)) {
                removeSystemUiFlag(16, decorView);
            } else {
                addSystemUiFlag(16, decorView);
            }
            window.setNavigationBarColor(ContextCompat.getColor(activity, R.color.Wh0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processWindowAttached() {
        BLog.i(TAG, "onWindowAttached");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        BLog.i(TAG, "is cutout:" + getMIsDisplayCutout());
        this.mWindowAttached = true;
        Configuration config = activity.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(config, "getConfiguration(...)");
        this.mScreenRatio = config.screenHeightDp > 0 ? config.screenWidthDp / config.screenHeightDp : DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        this.mScreenOrientation = config.orientation;
        handleWindowStateChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processWindowDetached() {
        BLog.i(TAG, "onWindowDetached");
        this.mWindowAttached = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFoldableWindowStateChanged() {
        FragmentActivity activity = getActivity();
        if (activity == null || !this.mWindowAttached) {
            return;
        }
        Window window = activity.getWindow();
        NotchCompat.onWindowConfigChanged(window);
        if (getMIsDisplayCutout()) {
            NotchCompat.blockDisplayCutout(window);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(-16777216);
            return;
        }
        NotchCompat.resetDisplayCutout(window);
        window.clearFlags(Integer.MIN_VALUE);
        Intrinsics.checkNotNull(window);
        immersiveStatusBar(window);
        Context context = (Context) activity;
        WindowStateParamsParser windowStateParamsParser = this.mParamsParser;
        if (windowStateParamsParser == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParamsParser");
            windowStateParamsParser = null;
        }
        pinBelowStatusBar(context, windowStateParamsParser.getToolbar());
    }

    private final void handleWindowStateChanged() {
        FragmentActivity activity;
        if (this.mWindowAttached && (activity = getActivity()) != null) {
            Window window = activity.getWindow();
            if (getMIsDisplayCutout()) {
                NotchCompat.blockDisplayCutout(window);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(-16777216);
                return;
            }
            Intrinsics.checkNotNull(window);
            immersiveStatusBar(window);
            Context context = (Context) activity;
            WindowStateParamsParser windowStateParamsParser = this.mParamsParser;
            if (windowStateParamsParser == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParamsParser");
                windowStateParamsParser = null;
            }
            pinBelowStatusBar(context, windowStateParamsParser.getToolbar());
        }
    }

    private final void pinBelowStatusBar(Context context, View view2) {
        if (view2 == null) {
            return;
        }
        int statusBarHeight = StatusBarCompat.getStatusBarHeight(context);
        if (statusBarHeight > 0) {
            int topMargin = statusBarHeight - NewPlayerUtilsKt.toPx(8.0f);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams toolbarParams = (ViewGroup.MarginLayoutParams) layoutParams;
            toolbarParams.topMargin = topMargin;
            this.mStatusBarDrawHeight = topMargin;
            this.mStatusBarPlayerHeight = statusBarHeight;
        } else {
            this.mStatusBarDrawHeight = 0;
            this.mStatusBarPlayerHeight = 0;
        }
        HardwareService.IStatusBarDrawHeightObserver iStatusBarDrawHeightObserver = this.mStatusBarDrawHeightObserver;
        if (iStatusBarDrawHeightObserver != null) {
            iStatusBarDrawHeightObserver.onStatusBarDrawHeightChanged(this.mStatusBarDrawHeight);
        }
    }

    private final void immersiveStatusBar(Window window) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1024 | IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN);
    }

    private final void addSystemUiFlag(int flag) {
        Window window;
        View decorView;
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        int newflag = decorView.getSystemUiVisibility() | flag;
        decorView.setSystemUiVisibility(newflag);
    }

    private final void removeSystemUiFlag(int flag) {
        Window window;
        View decorView;
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        int newflag = decorView.getSystemUiVisibility() & (~flag);
        decorView.setSystemUiVisibility(newflag);
    }

    public final void enterImmersiveFullscreen() {
        if (!getMIsDisplayCutout()) {
            removeSystemUiFlag(0);
            addSystemUiFlag(4);
        }
    }

    public final void exitImmersiveFullscreen() {
        if (!getMIsDisplayCutout()) {
            addSystemUiFlag(0);
            removeSystemUiFlag(4);
        }
    }

    private final void removeShade(View decorView) {
        View tagView;
        if ((decorView instanceof ViewGroup) && (tagView = decorView.findViewWithTag(SHADE_TAG)) != null) {
            ((ViewGroup) decorView).removeView(tagView);
        }
    }

    private final void addSystemUiFlag(int flag, View decorView) {
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | flag);
    }

    private final void removeSystemUiFlag(int flag, View decorView) {
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (~flag));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentActivity getActivity() {
        IHost host = this.mHost;
        if (host == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHost");
            host = null;
        }
        if (host instanceof IActivityHost) {
            return ((IActivityHost) host).getActivity();
        }
        if (host instanceof IFragmentHost) {
            return ((IFragmentHost) host).getFragment().getActivity();
        }
        return null;
    }

    public final void setOnlyHorizontalRotationEnable(boolean enable) {
        OrientationChangeProcessor orientationChangeProcessor = this.mOrientationChangeProcessor;
        if (orientationChangeProcessor != null) {
            orientationChangeProcessor.setOnlyHorizontalRotationEnable$videopagecommon_apinkDebug(enable);
        }
        BLog.i(TAG, "Only horizontal rotate enable: " + enable);
    }

    public final void switchScreenOrientation(int orientation) {
        OrientationChangeProcessor orientationChangeProcessor = this.mOrientationChangeProcessor;
        if (orientationChangeProcessor != null) {
            orientationChangeProcessor.switchScreenOrientation$videopagecommon_apinkDebug(orientation);
        }
    }

    public final void switchToSuitablePortriat() {
        OrientationChangeProcessor orientationChangeProcessor = this.mOrientationChangeProcessor;
        if (orientationChangeProcessor != null) {
            orientationChangeProcessor.switchToSuitablePortriat$videopagecommon_apinkDebug();
        }
    }

    public final void switchToSuitableLandscape() {
        OrientationChangeProcessor orientationChangeProcessor = this.mOrientationChangeProcessor;
        if (orientationChangeProcessor != null) {
            orientationChangeProcessor.switchToSuitableLandscape$videopagecommon_apinkDebug();
        }
    }

    public final boolean performBackPressed() {
        OrientationChangeProcessor orientationChangeProcessor = this.mOrientationChangeProcessor;
        if (orientationChangeProcessor != null) {
            return orientationChangeProcessor.onBackPressed$videopagecommon_apinkDebug();
        }
        return false;
    }

    public final int getCutoutHardwareHeight() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return 0;
        }
        int height = 0;
        if (NotchCompat.hasDisplayCutoutHardware(window)) {
            List<Rect> notchList = NotchCompat.getDisplayCutoutSizeHardware(window);
            Intrinsics.checkNotNullExpressionValue(notchList, "getDisplayCutoutSizeHardware(...)");
            if (notchList.isEmpty()) {
                return 0;
            }
            for (Rect r : notchList) {
                if (r.top == 0) {
                    height = Math.max(height, r.bottom);
                }
            }
            BLog.i(TAG, "Cutout hardware height: " + height);
            return height;
        }
        return 0;
    }

    public final int getStatusBarDrawHeight() {
        return this.mStatusBarDrawHeight;
    }

    public final int getStatusBarPlayerHeight() {
        return this.mStatusBarPlayerHeight;
    }

    /* compiled from: WindowStateManageSegment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/videopage/common/segment/WindowStateManageSegment$Companion;", "", "<init>", "()V", "TAG", "", "SHADE_TAG", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}