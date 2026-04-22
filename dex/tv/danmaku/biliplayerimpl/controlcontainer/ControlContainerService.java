package tv.danmaku.biliplayerimpl.controlcontainer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.biliplayerimpl.AbsCorePlayerService;
import tv.danmaku.biliplayerimpl.PlayerContainerImpl;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.panel.BuiltInLayer;
import tv.danmaku.biliplayerv2.panel.IPanelContainer;
import tv.danmaku.biliplayerv2.service.ControlContainerObserver;
import tv.danmaku.biliplayerv2.service.ControlContainerVisibleObserver;
import tv.danmaku.biliplayerv2.service.ControlEditHandler;
import tv.danmaku.biliplayerv2.service.ControlWidgetChangedObserver;
import tv.danmaku.biliplayerv2.service.IControlContainerService;
import tv.danmaku.biliplayerv2.service.IRenderStartObserver;
import tv.danmaku.biliplayerv2.service.ScreenOrientationDelegate;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.service.setting.ICloudConfigObserver;
import tv.danmaku.biliplayerv2.widget.IControlWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.media.ijk.IjkMediaScreenHelperKt;

/* compiled from: ControlContainerService.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002$'\b\u0000\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0001mB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0006H\u0016J\u0018\u00101\u001a\u00020/2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u0014H\u0016J\b\u0010<\u001a\u00020\u0016H\u0016J\b\u0010=\u001a\u00020\u0016H\u0016J\b\u0010>\u001a\u00020/H\u0016J\b\u0010?\u001a\u00020/H\u0016J\b\u0010@\u001a\u00020/H\u0016J\b\u0010A\u001a\u00020/H\u0016J\b\u0010B\u001a\u00020/H\u0002J\u0010\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020EH\u0016J\u0018\u0010F\u001a\u00020/2\u0006\u0010D\u001a\u00020E2\u0006\u0010G\u001a\u00020-H\u0016J\b\u0010H\u001a\u00020EH\u0016J\b\u0010I\u001a\u00020\u0016H\u0016J\u0018\u0010J\u001a\u00020/2\u0006\u0010;\u001a\u00020-2\u0006\u0010K\u001a\u00020\u0016H\u0016J\u0012\u0010L\u001a\u00020/2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010O\u001a\u00020\u0016H\u0016J\u0018\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u0014H\u0016J\b\u0010R\u001a\u00020\u0016H\u0016J\u0010\u0010S\u001a\u00020/2\u0006\u0010T\u001a\u00020\u000bH\u0016J\u0010\u0010U\u001a\u00020/2\u0006\u0010T\u001a\u00020\u000bH\u0016J\u0010\u0010V\u001a\u00020/2\u0006\u0010T\u001a\u00020\u000eH\u0016J\u0010\u0010W\u001a\u00020/2\u0006\u0010T\u001a\u00020\u000eH\u0016J\u0012\u0010X\u001a\u00020/2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u0010Y\u001a\u00020/H\u0016J\u0012\u0010Z\u001a\u00020/2\b\u0010T\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010[\u001a\u00020/2\u0006\u0010;\u001a\u00020\u0014H\u0016J\b\u0010\\\u001a\u00020\u0016H\u0016J\u0010\u0010]\u001a\u00020/2\u0006\u0010T\u001a\u00020\u0010H\u0016J\u0010\u0010^\u001a\u00020/2\u0006\u0010T\u001a\u00020\u0010H\u0016J\u001c\u0010_\u001a\u00020/2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020b0aH\u0016J\b\u0010c\u001a\u00020/H\u0002J\u0012\u0010d\u001a\u00020/2\b\u0010e\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010f\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010g\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u00142\u0006\u0010h\u001a\u00020-2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020k0jH\u0016J\u0010\u0010l\u001a\u00020/2\u0006\u0010;\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000e0\u000e \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000f\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00100\u0010 \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(¨\u0006n"}, d2 = {"Ltv/danmaku/biliplayerimpl/controlcontainer/ControlContainerService;", "Ltv/danmaku/biliplayerv2/service/IControlContainerService;", "Ltv/danmaku/biliplayerimpl/AbsCorePlayerService;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerimpl/PlayerContainerImpl;", "mControlContainer", "Ltv/danmaku/biliplayerimpl/controlcontainer/IControlContainer;", "mObserverList", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "Ltv/danmaku/biliplayerv2/service/ControlContainerObserver;", "kotlin.jvm.PlatformType", "mVisibleObserverList", "Ltv/danmaku/biliplayerv2/service/ControlContainerVisibleObserver;", "mWidgetChangedObserverList", "Ltv/danmaku/biliplayerv2/service/ControlWidgetChangedObserver;", "mEditHandler", "Ltv/danmaku/biliplayerv2/service/ControlEditHandler;", "mCurrentControllerContainer", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "mControllerEnable", "", "mControlViewChanged", "mIsLazyMode", "mPendingLazyInitCallFromRenderStart", "isShowingBeforeImmersive", "mScreenOrientationDelegate", "Ltv/danmaku/biliplayerv2/service/ScreenOrientationDelegate;", "mInheritsVisibility", "getMInheritsVisibility", "()Z", "mIsAlive", "mHideTask", "Ljava/lang/Runnable;", "mCloudConfigListener", "tv/danmaku/biliplayerimpl/controlcontainer/ControlContainerService$mCloudConfigListener$1", "Ltv/danmaku/biliplayerimpl/controlcontainer/ControlContainerService$mCloudConfigListener$1;", "mRenderStartObserver", "tv/danmaku/biliplayerimpl/controlcontainer/ControlContainerService$mRenderStartObserver$1", "Ltv/danmaku/biliplayerimpl/controlcontainer/ControlContainerService$mRenderStartObserver$1;", "getScreenModeType", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "getState", "getBottomSubtitleBlock", "", "bindPlayerContainer", "", "playerContainer", "onCollectSharedParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "createView", "Landroid/view/View;", "context", "Landroid/content/Context;", "switchTo", "type", "isShowing", "isAlwaysShowing", "show", "addHideTask", "removeHideTask", "hide", "hideInternal", "setControlAlpha", "alpha", "", "setControlWidgetAlpha", "widgetId", "getControlAlpha", "isImmersive", "setImmersive", "immersive", "setBackground", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, "Landroid/graphics/drawable/Drawable;", "onBackPressed", "setControllerEnable", "enable", "isControllerEnable", "registerState", "observer", "unregisterState", "registerControlContainerVisible", "unregisterControlContainerVisible", "onStart", "onStop", "setEditHandler", "editController", "supportEdit", "registerWidgetChangedObserver", "unregisterWidgetChangedObserver", "setControlContainerConfig", "config", "", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "ensureControlContainer", "setScreenOrientationDelegate", "delegate", "getScreenOrientationDelegate", "insertSlotWidgets", "slotContainerId", "slotWidgets", "", "Ltv/danmaku/biliplayerv2/widget/IControlWidget;", "reportSwitch", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ControlContainerService extends AbsCorePlayerService implements IControlContainerService {
    public static final Companion Companion = new Companion(null);
    private static final long SHOW_DURATION = 5000;
    private static final String TAG = "ControlContainerService";
    private boolean isShowingBeforeImmersive;
    private IControlContainer mControlContainer;
    private boolean mControlViewChanged;
    private ControlEditHandler mEditHandler;
    private boolean mIsAlive;
    private boolean mIsLazyMode;
    private boolean mPendingLazyInitCallFromRenderStart;
    private PlayerContainerImpl mPlayerContainer;
    private ScreenOrientationDelegate mScreenOrientationDelegate;
    private final Collections.SafeIteratorList<ControlContainerObserver> mObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<ControlContainerVisibleObserver> mVisibleObserverList = Collections.safeIteratorList(new LinkedList());
    private final Collections.SafeIteratorList<ControlWidgetChangedObserver> mWidgetChangedObserverList = Collections.safeIteratorList(new LinkedList());
    private ControlContainerType mCurrentControllerContainer = ControlContainerType.INITIAL;
    private boolean mControllerEnable = true;
    private final Runnable mHideTask = new Runnable() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainerService$$ExternalSyntheticLambda3
        @Override // java.lang.Runnable
        public final void run() {
            ControlContainerService.this.hide();
        }
    };
    private final ControlContainerService$mCloudConfigListener$1 mCloudConfigListener = new ICloudConfigObserver() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainerService$mCloudConfigListener$1
        @Override // tv.danmaku.biliplayerv2.service.setting.ICloudConfigObserver
        public void onCloudConfigChanged() {
            ControlContainerService.this.mControlViewChanged = true;
        }
    };
    private final ControlContainerService$mRenderStartObserver$1 mRenderStartObserver = new IRenderStartObserver() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainerService$mRenderStartObserver$1
        @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
        public /* synthetic */ void onAudioRenderStart() {
            IRenderStartObserver.CC.$default$onAudioRenderStart(this);
        }

        @Override // tv.danmaku.biliplayerv2.service.IRenderStartObserver
        public void onVideoRenderStart() {
            boolean z;
            z = ControlContainerService.this.mIsLazyMode;
            if (z) {
                lazyInitControlContainer();
            } else {
                ControlContainerService.this.hide();
            }
        }

        private final void lazyInitControlContainer() {
            ControlContainerType controlContainerType;
            IControlContainer it;
            controlContainerType = ControlContainerService.this.mCurrentControllerContainer;
            if (controlContainerType == ControlContainerType.INITIAL) {
                ControlContainerService.this.mPendingLazyInitCallFromRenderStart = true;
                return;
            }
            it = ControlContainerService.this.mControlContainer;
            if (it != null) {
                ControlContainerService controlContainerService = ControlContainerService.this;
                boolean result = it.initCurrentControlContainerStandalone();
                if (result) {
                    controlContainerService.hide();
                }
            }
        }
    };

    /* compiled from: ControlContainerService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ControlContainerType.values().length];
            try {
                iArr[ControlContainerType.LANDSCAPE_FULLSCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ControlContainerType.VERTICAL_FULLSCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: ControlContainerService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerimpl/controlcontainer/ControlContainerService$Companion;", "", "<init>", "()V", "SHOW_DURATION", "", "TAG", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean getMInheritsVisibility() {
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        return playerContainerImpl.getPlayerParams().getConfig().getControlContainerInheritsVisibility();
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public ScreenModeType getScreenModeType() {
        ScreenModeType currentControlContainerScreenType;
        IControlContainer iControlContainer = this.mControlContainer;
        return (iControlContainer == null || (currentControlContainerScreenType = iControlContainer.getCurrentControlContainerScreenType()) == null) ? ScreenModeType.THUMB : currentControlContainerScreenType;
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public ControlContainerType getState() {
        return this.mCurrentControllerContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public int getBottomSubtitleBlock() {
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            return iControlContainer.getBottomSubtitleBlock();
        }
        return 0;
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService
    public void bindPlayerContainer(PlayerContainerImpl playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        this.mIsLazyMode = playerContainerImpl.getPlayerParams().getConfig().getControlContainerLazyMode();
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        hide();
    }

    @Override // tv.danmaku.biliplayerv2.service.IWithViewPlayerService
    public View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ControlContainer controlContainer = new ControlContainer(context);
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        controlContainer.bindPlayerContainer(playerContainerImpl);
        this.mControlContainer = controlContainer;
        return controlContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public boolean switchTo(final ControlContainerType type) {
        boolean shouldCreateInstance;
        final boolean targetFullScreen;
        Intrinsics.checkNotNullParameter(type, "type");
        if (!this.mIsAlive) {
            PlayerLog.e(TAG, "control service is not alive, but want to show");
            return false;
        }
        boolean isCurrentShowing = isShowing();
        if (this.mIsLazyMode) {
            if (this.mPendingLazyInitCallFromRenderStart) {
                this.mPendingLazyInitCallFromRenderStart = false;
                shouldCreateInstance = true;
            } else {
                shouldCreateInstance = this.mCurrentControllerContainer != ControlContainerType.INITIAL;
            }
        } else {
            shouldCreateInstance = true;
        }
        PlayerContainerImpl playerContainerImpl = null;
        if (this.mControllerEnable) {
            if (getMInheritsVisibility()) {
                boolean targetFullScreen2 = type == ControlContainerType.LANDSCAPE_FULLSCREEN || type == ControlContainerType.VERTICAL_FULLSCREEN;
                boolean currentHalf = this.mCurrentControllerContainer == ControlContainerType.HALF_SCREEN;
                PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
                if (playerContainerImpl2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainerImpl2 = null;
                }
                boolean hideControlInFullScreen = playerContainerImpl2.getPlayerParams().getConfig().getHideControlInFullScreen();
                if (hideControlInFullScreen && targetFullScreen2 && currentHalf) {
                    targetFullScreen = false;
                } else {
                    targetFullScreen = isCurrentShowing;
                }
            } else {
                targetFullScreen = true;
            }
        } else {
            targetFullScreen = false;
        }
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        IPanelContainer panelContainer = playerContainerImpl3.getPanelContainer();
        Map<ControlContainerType, ControlContainerConfig> controlContainerConfig = panelContainer != null ? panelContainer.getControlContainerConfig() : null;
        if (!(controlContainerConfig == null || controlContainerConfig.isEmpty())) {
            ensureControlContainer();
        }
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            boolean success = iControlContainer.switchTo(type, shouldCreateInstance, targetFullScreen);
            if (success) {
                reportSwitch(type);
                PlayerLog.e(TAG, "control service switch " + this.mCurrentControllerContainer + " to " + type);
                this.mCurrentControllerContainer = type;
                IControlContainer iControlContainer2 = this.mControlContainer;
                Intrinsics.checkNotNull(iControlContainer2);
                final ScreenModeType screenType = iControlContainer2.getCurrentControlContainerScreenType();
                this.mObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainerService$$ExternalSyntheticLambda6
                    @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                    public final void run(Object obj) {
                        ((ControlContainerObserver) obj).onControlContainerChanged(ControlContainerType.this, screenType);
                    }
                });
                this.mVisibleObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainerService$$ExternalSyntheticLambda7
                    @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                    public final void run(Object obj) {
                        ((ControlContainerVisibleObserver) obj).onControlContainerVisibleChanged(targetFullScreen);
                    }
                });
                if (targetFullScreen) {
                    removeHideTask();
                    addHideTask();
                }
                PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
                if (playerContainerImpl4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainerImpl4 = null;
                }
                playerContainerImpl4.getToastService().notifyScreenModeTypeChanged(screenType);
                PlayerContainerImpl playerContainerImpl5 = this.mPlayerContainer;
                if (playerContainerImpl5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainerImpl5 = null;
                }
                playerContainerImpl5.getFunctionWidgetService().notifyControllerTypeChanged();
                PlayerContainerImpl playerContainerImpl6 = this.mPlayerContainer;
                if (playerContainerImpl6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                    playerContainerImpl6 = null;
                }
                playerContainerImpl6.getRenderContainerService().notifyScreenModeTypeChanged(screenType);
                PlayerContainerImpl playerContainerImpl7 = this.mPlayerContainer;
                if (playerContainerImpl7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    playerContainerImpl = playerContainerImpl7;
                }
                playerContainerImpl.getReporterService().notifyScreenModeTypeChanged(screenType);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public boolean isShowing() {
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            return iControlContainer.isShowing();
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public boolean isAlwaysShowing() {
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            return iControlContainer.isAlwaysShowing();
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void show() {
        if (!this.mControllerEnable) {
            return;
        }
        if (!this.mIsAlive) {
            PlayerLog.i(TAG, "control service is not alive, but want to show");
        }
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            iControlContainer.show();
        }
        if (this.mControlViewChanged) {
            this.mWidgetChangedObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainerService$$ExternalSyntheticLambda4
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((ControlWidgetChangedObserver) obj).onControllerWidgetChanged();
                }
            });
            this.mControlViewChanged = false;
        }
        this.mVisibleObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainerService$$ExternalSyntheticLambda5
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((ControlContainerVisibleObserver) obj).onControlContainerVisibleChanged(true);
            }
        });
        removeHideTask();
        addHideTask();
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void addHideTask() {
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        PlayerContainerImpl playerContainerImpl2 = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        if (!playerContainerImpl.getPlayerParams().getConfig().getControlContainerShowForever()) {
            PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
            if (playerContainerImpl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainerImpl2 = playerContainerImpl3;
            }
            long showDuration = playerContainerImpl2.getPlayerParams().getConfig().getControlContainerShowDuration();
            HandlerThreads.remove(0, this.mHideTask);
            HandlerThreads.postDelayed(0, this.mHideTask, showDuration);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void removeHideTask() {
        HandlerThreads.remove(0, this.mHideTask);
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void hide() {
        if (!isAlwaysShowing()) {
            if (!isShowing()) {
                return;
            }
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            if (playerContainerImpl.getPlayerParams().getConfig().getControlContainerShowForever()) {
                return;
            }
        }
        hideInternal();
    }

    private final void hideInternal() {
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            iControlContainer.hide();
        }
        this.mVisibleObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainerService$$ExternalSyntheticLambda8
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((ControlContainerVisibleObserver) obj).onControlContainerVisibleChanged(false);
            }
        });
        removeHideTask();
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void setControlAlpha(float alpha) {
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            iControlContainer.setControlAlpha(alpha);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void setControlWidgetAlpha(float alpha, int widgetId) {
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            iControlContainer.setControlWidgetAlpha(alpha, widgetId);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public float getControlAlpha() {
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            return iControlContainer.getControlAlpha();
        }
        return 1.0f;
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public boolean isImmersive() {
        IControlContainer iControlContainer = this.mControlContainer;
        return iControlContainer != null && iControlContainer.isImmersive();
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void setImmersive(final int type, boolean immersive) {
        ControlContainerConfig currentControlContainerConfig;
        Function1<Integer, Boolean> hideControlAfterImmersive;
        if (immersive == isImmersive()) {
            return;
        }
        if (!this.mIsAlive) {
            PlayerLog.i(TAG, "control service is not alive, but want to show");
        }
        if (immersive) {
            this.isShowingBeforeImmersive = isShowing();
            removeHideTask();
            IControlContainer iControlContainer = this.mControlContainer;
            if (iControlContainer != null) {
                iControlContainer.setImmersive(type, true);
            }
            IControlContainer iControlContainer2 = this.mControlContainer;
            if (iControlContainer2 != null) {
                iControlContainer2.show();
            }
            this.mVisibleObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainerService$$ExternalSyntheticLambda0
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((ControlContainerVisibleObserver) obj).onControlContainerImmersiveChanged(type, true);
                }
            });
            return;
        }
        IControlContainer iControlContainer3 = this.mControlContainer;
        boolean z = false;
        if (iControlContainer3 != null) {
            iControlContainer3.setImmersive(type, false);
        }
        IControlContainer iControlContainer4 = this.mControlContainer;
        if (iControlContainer4 != null && (currentControlContainerConfig = iControlContainer4.getCurrentControlContainerConfig()) != null && (hideControlAfterImmersive = currentControlContainerConfig.getHideControlAfterImmersive()) != null) {
            z = ((Boolean) hideControlAfterImmersive.invoke(Integer.valueOf(type))).booleanValue();
        }
        boolean hideControlAfterImmersive2 = z;
        if (!this.isShowingBeforeImmersive || hideControlAfterImmersive2) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            if (!playerContainerImpl.getPlayerParams().getConfig().getControlContainerShowForever()) {
                if (this.isShowingBeforeImmersive) {
                    this.mVisibleObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainerService$$ExternalSyntheticLambda1
                        @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                        public final void run(Object obj) {
                            ((ControlContainerVisibleObserver) obj).onControlContainerVisibleChanged(false);
                        }
                    });
                }
                IControlContainer iControlContainer5 = this.mControlContainer;
                if (iControlContainer5 != null) {
                    iControlContainer5.hide();
                }
                this.mVisibleObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainerService$$ExternalSyntheticLambda2
                    @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                    public final void run(Object obj) {
                        ((ControlContainerVisibleObserver) obj).onControlContainerImmersiveChanged(type, false);
                    }
                });
            }
        }
        IControlContainer iControlContainer6 = this.mControlContainer;
        if (iControlContainer6 != null) {
            iControlContainer6.show();
        }
        addHideTask();
        this.mVisibleObserverList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.controlcontainer.ControlContainerService$$ExternalSyntheticLambda2
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((ControlContainerVisibleObserver) obj).onControlContainerImmersiveChanged(type, false);
            }
        });
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void setBackground(Drawable background) {
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            iControlContainer.setBackground(background);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public boolean onBackPressed() {
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void setControllerEnable(boolean enable, ControlContainerType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type == ControlContainerType.NONE) {
            this.mControllerEnable = enable;
            if (!enable) {
                hide();
                return;
            }
            return;
        }
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            iControlContainer.setControllerEnable(enable, type);
        }
        if (type == this.mCurrentControllerContainer) {
            hide();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public boolean isControllerEnable() {
        if (this.mControllerEnable) {
            IControlContainer iControlContainer = this.mControlContainer;
            if (iControlContainer != null ? iControlContainer.getControllerEnable(this.mCurrentControllerContainer) : true) {
                return true;
            }
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void registerState(ControlContainerObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mObserverList.contains(observer)) {
            this.mObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void unregisterState(ControlContainerObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void registerControlContainerVisible(ControlContainerVisibleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mVisibleObserverList.contains(observer)) {
            this.mVisibleObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void unregisterControlContainerVisible(ControlContainerVisibleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mVisibleObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        this.mIsAlive = true;
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        PlayerContainerImpl playerContainerImpl2 = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        playerContainerImpl.getPlayerCoreService().addRenderStartObserver(this.mRenderStartObserver);
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl3 = null;
        }
        playerContainerImpl3.getPlayerSettingService().addCloudConfigObserver(this.mCloudConfigListener);
        PlayerContainerImpl playerContainerImpl4 = this.mPlayerContainer;
        if (playerContainerImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainerImpl2 = playerContainerImpl4;
        }
        playerContainerImpl2.getReporterService().notifyScreenModeTypeChanged(getScreenModeType());
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        this.mIsAlive = false;
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            iControlContainer.release();
        }
        Collections.SafeIteratorList<ControlContainerObserver> safeIteratorList = this.mObserverList;
        Intrinsics.checkNotNullExpressionValue(safeIteratorList, "mObserverList");
        if (!safeIteratorList.isEmpty()) {
            this.mObserverList.clear();
        }
        Collections.SafeIteratorList<ControlContainerVisibleObserver> safeIteratorList2 = this.mVisibleObserverList;
        Intrinsics.checkNotNullExpressionValue(safeIteratorList2, "mVisibleObserverList");
        if (!safeIteratorList2.isEmpty()) {
            this.mVisibleObserverList.clear();
        }
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        PlayerContainerImpl playerContainerImpl2 = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        playerContainerImpl.getPlayerCoreService().removeRenderStartObserver(this.mRenderStartObserver);
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainerImpl2 = playerContainerImpl3;
        }
        playerContainerImpl2.getPlayerSettingService().removeCloudConfigObserver(this.mCloudConfigListener);
        removeHideTask();
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void setEditHandler(ControlEditHandler observer) {
        this.mEditHandler = observer;
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void editController(ControlContainerType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        ControlEditHandler controlEditHandler = this.mEditHandler;
        if (controlEditHandler != null) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            controlEditHandler.editController(playerContainerImpl.getFunctionWidgetService(), type);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public boolean supportEdit() {
        return this.mEditHandler != null;
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void registerWidgetChangedObserver(ControlWidgetChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mWidgetChangedObserverList.contains(observer)) {
            this.mWidgetChangedObserverList.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void unregisterWidgetChangedObserver(ControlWidgetChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mWidgetChangedObserverList.remove(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void setControlContainerConfig(Map<ControlContainerType, ControlContainerConfig> map) {
        Map config = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(config, "config");
        ensureControlContainer();
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            iControlContainer.setControlContainerConfig(config);
        }
    }

    private final void ensureControlContainer() {
        if (this.mControlContainer == null) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            IPanelContainer panelContainer = playerContainerImpl.getPanelContainer();
            if (panelContainer != null) {
                panelContainer.ensureBuiltInLayer(BuiltInLayer.LayerControl, this);
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public void setScreenOrientationDelegate(ScreenOrientationDelegate delegate) {
        this.mScreenOrientationDelegate = delegate;
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public ScreenOrientationDelegate getScreenOrientationDelegate() {
        return this.mScreenOrientationDelegate;
    }

    @Override // tv.danmaku.biliplayerv2.service.IControlContainerService
    public boolean insertSlotWidgets(ControlContainerType type, int slotContainerId, List<? extends IControlWidget> list) {
        List slotWidgets = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(slotWidgets, "slotWidgets");
        IControlContainer iControlContainer = this.mControlContainer;
        if (iControlContainer != null) {
            return iControlContainer.insertSlotWidgets(type, slotContainerId, slotWidgets);
        }
        return false;
    }

    private final void reportSwitch(ControlContainerType type) {
        if (type == this.mCurrentControllerContainer || this.mCurrentControllerContainer == ControlContainerType.INITIAL) {
            PlayerLog.i(TAG, "reportSwitch: type is same as current controller container, no need to report");
            return;
        }
        PlayerContainerImpl playerContainerImpl = null;
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
            case 2:
                PlayerContainerImpl playerContainerImpl2 = this.mPlayerContainer;
                if (playerContainerImpl2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    playerContainerImpl = playerContainerImpl2;
                }
                playerContainerImpl.getReporterService().report(new NeuronsEvents.Switch(NeuronsEvents.Switch.Type.HALF_FULL_SCREEN, "screen_long_edge", String.valueOf(IjkMediaScreenHelperKt.getIjkMediaScreenLongEdge()), "screen_short_edge", String.valueOf(IjkMediaScreenHelperKt.getIjkMediaScreenShortEdge())));
                return;
            default:
                PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
                if (playerContainerImpl3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                } else {
                    playerContainerImpl = playerContainerImpl3;
                }
                playerContainerImpl.getReporterService().report(new NeuronsEvents.Switch(NeuronsEvents.Switch.Type.FULL_HALF_SCREEN, "screen_long_edge", String.valueOf(IjkMediaScreenHelperKt.getIjkMediaScreenLongEdge()), "screen_short_edge", String.valueOf(IjkMediaScreenHelperKt.getIjkMediaScreenShortEdge())));
                return;
        }
    }
}