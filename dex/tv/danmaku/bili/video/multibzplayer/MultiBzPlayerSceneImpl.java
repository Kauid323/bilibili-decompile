package tv.danmaku.bili.video.multibzplayer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.playerbizcommon.gesture.GestureService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.AppBuildConfig;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.PlayerConfiguration;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.lock.DisablePlayLock;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.video.playerservice.BLPlayerScene;
import tv.danmaku.video.playerservice.BLPlayerService;
import video.biz.offline.list.logic.tree.VideoFile;

/* compiled from: MultiBzPlayerScene.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001SB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010'J\"\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u00132\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u001bH\u0016J\u0010\u00101\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u001bH\u0016J\b\u00106\u001a\u00020)H\u0016J\u0010\u00107\u001a\u00020)2\u0006\u00108\u001a\u00020\u001bH\u0002J\u0010\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\u001dH\u0016J\u0010\u0010;\u001a\u00020)2\u0006\u0010:\u001a\u00020\u001dH\u0016J\b\u0010<\u001a\u00020)H\u0002J&\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020?2\u0014\u0010@\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020$0#0AH\u0002J2\u0010B\u001a\u00020)\"\b\b\u0000\u0010C*\u00020$2\u000e\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u0002HC0#2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u0002HC\u0018\u00010FH\u0016J\"\u0010G\u001a\u00020)\"\b\b\u0000\u0010C*\u00020$2\u000e\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u0002HC0#H\u0016J0\u0010H\u001a\u00020)\"\b\b\u0000\u0010C*\u00020$2\u000e\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u0002HC0#2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002HC0FH\u0016J \u0010I\u001a\u00020)\"\b\b\u0000\u0010C*\u00020$2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002HC0FH\u0016J\b\u0010J\u001a\u00020\u0007H\u0016J\u0016\u0010K\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020$0#0AH\u0016J\u0010\u0010L\u001a\u00020)2\u0006\u0010M\u001a\u00020/H\u0016J\u0010\u0010N\u001a\u00020)2\u0006\u0010M\u001a\u00020/H\u0016J\u0010\u0010O\u001a\u00020)2\u0006\u0010M\u001a\u00020/H\u0016J\u0010\u0010P\u001a\u00020)2\u0006\u0010M\u001a\u00020/H\u0016J\u0010\u0010Q\u001a\u00020)2\u0006\u0010M\u001a\u00020/H\u0016J\u0010\u0010R\u001a\u00020)2\u0006\u0010M\u001a\u00020/H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010!\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020$0#0\"j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020$0#`%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Ltv/danmaku/bili/video/multibzplayer/MultiBzPlayerSceneImpl;", "Ltv/danmaku/bili/video/multibzplayer/IMultiBzPlayerScene;", "Ltv/danmaku/video/playerservice/BLPlayerScene;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "getMPlayerContainer", "()Ltv/danmaku/biliplayerv2/IPlayerContainer;", "setMPlayerContainer", "(Ltv/danmaku/biliplayerv2/IPlayerContainer;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mBLPlayerService", "Ltv/danmaku/video/playerservice/BLPlayerService;", "getMBLPlayerService", "()Ltv/danmaku/video/playerservice/BLPlayerService;", "setMBLPlayerService", "(Ltv/danmaku/video/playerservice/BLPlayerService;)V", "mPlayerPanel", "Landroid/view/View;", "mIsReady", "", "mPendingStartBusiness", "Ltv/danmaku/bili/video/multibzplayer/Business;", "mCurrentBusiness", "mDisablePlayLock", "Ltv/danmaku/biliplayerv2/service/lock/DisablePlayLock;", "mStartedServices", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "Lkotlin/collections/ArrayList;", "mPlayerSharingBundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "setPlayerSharingBundle", "", "playerSharingBundle", "initialize", "context", "service", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isActive", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "release", "setPlayable", "enable", "startBusiness", LoginSceneProcessor.BIZ_KEY, "stopBusiness", "checkBusinessService", "resolveIllegalServices", "errorMessage", "", "illegalServiceList", "", "startService", "T", "serviceClass", "client", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "stopService", "bindService", "unbindService", "getPlayerContainer", "getCommonServices", "onCreate", "owner", "onStart", "onResume", "onPause", "onStop", "onDestroy", "Companion", "multibzplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class MultiBzPlayerSceneImpl implements IMultiBzPlayerScene, BLPlayerScene, DefaultLifecycleObserver {
    private static final String TAG = "MultiBzPlayerSceneImpl";
    protected BLPlayerService mBLPlayerService;
    protected Context mContext;
    private Business mCurrentBusiness;
    private DisablePlayLock mDisablePlayLock;
    private boolean mIsReady;
    private Business mPendingStartBusiness;
    protected IPlayerContainer mPlayerContainer;
    private View mPlayerPanel;
    private PlayerSharingBundle mPlayerSharingBundle;
    private final ArrayList<Class<? extends IPlayerService>> mStartedServices = new ArrayList<>();
    public static final Companion Companion = new Companion(null);
    private static final Map<ControlContainerType, ControlContainerConfig> sEmptyControlContainerConfig = MapsKt.emptyMap();
    private static final ViewGroup.LayoutParams sPlayerLayoutParams = new ViewGroup.LayoutParams(-1, -1);

    /* compiled from: MultiBzPlayerScene.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/video/multibzplayer/MultiBzPlayerSceneImpl$Companion;", "", "<init>", "()V", "TAG", "", "sEmptyControlContainerConfig", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "getSEmptyControlContainerConfig$multibzplayer_debug", "()Ljava/util/Map;", "sPlayerLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "multibzplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<ControlContainerType, ControlContainerConfig> getSEmptyControlContainerConfig$multibzplayer_debug() {
            return MultiBzPlayerSceneImpl.sEmptyControlContainerConfig;
        }
    }

    protected final IPlayerContainer getMPlayerContainer() {
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            return iPlayerContainer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMPlayerContainer(IPlayerContainer iPlayerContainer) {
        Intrinsics.checkNotNullParameter(iPlayerContainer, "<set-?>");
        this.mPlayerContainer = iPlayerContainer;
    }

    protected final Context getMContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    protected final BLPlayerService getMBLPlayerService() {
        BLPlayerService bLPlayerService = this.mBLPlayerService;
        if (bLPlayerService != null) {
            return bLPlayerService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBLPlayerService");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMBLPlayerService(BLPlayerService bLPlayerService) {
        Intrinsics.checkNotNullParameter(bLPlayerService, "<set-?>");
        this.mBLPlayerService = bLPlayerService;
    }

    public final void setPlayerSharingBundle(PlayerSharingBundle playerSharingBundle) {
        this.mPlayerSharingBundle = playerSharingBundle;
    }

    public void initialize(Context context, BLPlayerService service, LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(service, "service");
        setMBLPlayerService(service);
        setMContext(context);
        PlayerParamsV2 playerParams = new PlayerParamsV2();
        PlayerSharingBundle it = this.mPlayerSharingBundle;
        if (it != null) {
            playerParams.setSharingBundle(it);
        }
        PlayerConfiguration config = new PlayerConfiguration();
        config.setMLoadingDelayTime(800L);
        config.setUpdateVideoRenderViewPortEnable(true);
        config.setWholeSceneEnable(true);
        config.setDisallowParentIntercept(true);
        if (AppBuildConfig.Companion.isHDApp()) {
            config.setControlContainerLazyMode(true);
        }
        Activity findActivityOrNull = ContextUtilKt.findActivityOrNull(context);
        Integer curOrientation = findActivityOrNull != null ? Integer.valueOf(findActivityOrNull.getRequestedOrientation()) : null;
        if ((curOrientation != null && curOrientation.intValue() == 0) || (curOrientation != null && curOrientation.intValue() == 8)) {
            config.setInitialControlContainerType(ControlContainerType.LANDSCAPE_FULLSCREEN);
        } else {
            config.setInitialControlContainerType(ControlContainerType.HALF_SCREEN);
        }
        playerParams.setConfig(config);
        setMPlayerContainer(new IPlayerContainer.Builder().setContext(context).setPlayerParams(playerParams).setControlContainerConfig(sEmptyControlContainerConfig).build());
        if (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) {
            return;
        }
        lifecycle.addObserver((LifecycleObserver) this);
    }

    @Override // tv.danmaku.video.playerservice.BLPlayerScene
    public boolean isActive() {
        return true;
    }

    @Override // tv.danmaku.video.playerservice.BLPlayerScene
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        getMPlayerContainer().onConfigurationChanged(newConfig);
    }

    @Override // tv.danmaku.video.playerservice.BLPlayerScene
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
    }

    @Override // tv.danmaku.video.playerservice.BLPlayerScene
    public void release() {
    }

    private final void setPlayable(boolean enable) {
        if (enable) {
            DisablePlayLock it = this.mDisablePlayLock;
            if (it != null) {
                getMPlayerContainer().getPlayerCoreService().releaseDisablePlayLock(it);
            }
            this.mDisablePlayLock = null;
        } else if (this.mDisablePlayLock == null) {
            this.mDisablePlayLock = getMPlayerContainer().getPlayerCoreService().acquireDisablePlayLock(TAG);
        }
    }

    @Override // tv.danmaku.bili.video.multibzplayer.IMultiBzPlayerScene
    public void startBusiness(Business business) {
        Intrinsics.checkNotNullParameter(business, LoginSceneProcessor.BIZ_KEY);
        if (!this.mIsReady || Intrinsics.areEqual(this.mCurrentBusiness, business)) {
            return;
        }
        getMPlayerContainer().getFunctionWidgetService().hideAllWidget();
        getMPlayerContainer().getToastService().removeAllToast();
        Business current = this.mCurrentBusiness;
        if (current != null) {
            stopBusiness(current);
        }
        checkBusinessService();
        setPlayable(true);
        this.mCurrentBusiness = business;
        ViewGroup container = business.getContainer();
        View view2 = this.mPlayerPanel;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerPanel");
            view2 = null;
        }
        container.addView(view2, sPlayerLayoutParams);
        business.getGap().start$multibzplayer_debug(this);
    }

    @Override // tv.danmaku.bili.video.multibzplayer.IMultiBzPlayerScene
    public void stopBusiness(Business business) {
        Intrinsics.checkNotNullParameter(business, LoginSceneProcessor.BIZ_KEY);
        if (!this.mIsReady) {
            return;
        }
        setPlayable(false);
        Business current = this.mCurrentBusiness;
        View view2 = null;
        this.mCurrentBusiness = null;
        if (current != null) {
            ViewGroup container = current.getContainer();
            View view3 = this.mPlayerPanel;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerPanel");
            } else {
                view2 = view3;
            }
            container.removeView(view2);
            current.getGap().stop$multibzplayer_debug();
        }
        getMPlayerContainer().getPlayerCoreService().stop();
        getMPlayerContainer().getPlayerCoreService().setMiniPlayerAvailable(true);
    }

    private final void checkBusinessService() {
        List allStartedServiceList = getMPlayerContainer().getPlayerServiceManager().getAllStartedService();
        if (allStartedServiceList == null) {
            throw new IllegalStateException("No service is started");
        }
        List illegalServiceList = new ArrayList();
        List $this$forEach$iv = allStartedServiceList;
        for (Object element$iv : $this$forEach$iv) {
            Class it = (Class) element$iv;
            if (!getMPlayerContainer().getPlayerServiceManager().isCoreService(it) && !getCommonServices().contains(it)) {
                illegalServiceList.add(it);
            }
        }
        resolveIllegalServices("Business services are not stopped!", illegalServiceList);
        illegalServiceList.clear();
        Iterable $this$forEach$iv2 = getCommonServices();
        for (Object element$iv2 : $this$forEach$iv2) {
            Class it2 = (Class) element$iv2;
            if (!allStartedServiceList.contains(it2)) {
                illegalServiceList.add(it2);
            }
        }
        resolveIllegalServices("Common services should not be stopped!", illegalServiceList);
        illegalServiceList.clear();
        Iterable coreServicesList = getMPlayerContainer().getPlayerServiceManager().getCoreServicesList();
        if (coreServicesList != null) {
            Iterable $this$forEach$iv3 = coreServicesList;
            for (Object element$iv3 : $this$forEach$iv3) {
                Class it3 = (Class) element$iv3;
                if (!allStartedServiceList.contains(it3)) {
                    illegalServiceList.add(it3);
                }
            }
        }
        resolveIllegalServices("Core services should not be stopped!", illegalServiceList);
        illegalServiceList.clear();
    }

    private final void resolveIllegalServices(String errorMessage, List<? extends Class<? extends IPlayerService>> list) {
        StringBuilder logStringBuilder = new StringBuilder();
        logStringBuilder.append(errorMessage);
        if (!list.isEmpty()) {
            List<? extends Class<? extends IPlayerService>> $this$forEach$iv = list;
            for (Object element$iv : $this$forEach$iv) {
                Class it = (Class) element$iv;
                logStringBuilder.append(VideoFile.TREE_END + it);
            }
            BLog.e(TAG, logStringBuilder.toString());
            StringsKt.clear(logStringBuilder);
        }
    }

    @Override // tv.danmaku.bili.video.multibzplayer.IMultiBzPlayerScene
    public <T extends IPlayerService> void startService(Class<? extends T> cls, PlayerServiceManager.Client<T> client) {
        Intrinsics.checkNotNullParameter(cls, "serviceClass");
        this.mStartedServices.add(cls);
        if (client != null) {
            getMPlayerContainer().getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(cls), client);
        } else {
            getMPlayerContainer().getPlayerServiceManager().startService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(cls));
        }
    }

    @Override // tv.danmaku.bili.video.multibzplayer.IMultiBzPlayerScene
    public <T extends IPlayerService> void stopService(Class<? extends T> cls) {
        Intrinsics.checkNotNullParameter(cls, "serviceClass");
        this.mStartedServices.remove(cls);
        getMPlayerContainer().getPlayerServiceManager().stopService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(cls));
    }

    @Override // tv.danmaku.bili.video.multibzplayer.IMultiBzPlayerScene
    public <T extends IPlayerService> void bindService(Class<? extends T> cls, PlayerServiceManager.Client<T> client) {
        Intrinsics.checkNotNullParameter(cls, "serviceClass");
        Intrinsics.checkNotNullParameter(client, "client");
        getMPlayerContainer().getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(cls), client, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.bili.video.multibzplayer.IMultiBzPlayerScene
    public <T extends IPlayerService> void unbindService(PlayerServiceManager.Client<T> client) {
        Class clazz;
        Intrinsics.checkNotNullParameter(client, "client");
        T service = client.getService();
        if (service == null || (clazz = service.getClass()) == null) {
            return;
        }
        getMPlayerContainer().getPlayerServiceManager().unbindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(clazz), client);
    }

    @Override // tv.danmaku.bili.video.multibzplayer.IMultiBzPlayerScene
    public IPlayerContainer getPlayerContainer() {
        return getMPlayerContainer();
    }

    @Override // tv.danmaku.bili.video.multibzplayer.IMultiBzPlayerScene
    public List<Class<? extends IPlayerService>> getCommonServices() {
        return this.mStartedServices;
    }

    public void onCreate(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        getMPlayerContainer().onCreate(null);
        IPlayerContainer mPlayerContainer = getMPlayerContainer();
        LayoutInflater from = LayoutInflater.from(getMContext());
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        this.mPlayerPanel = mPlayerContainer.onCreateView(from, null, null);
        IPlayerContainer mPlayerContainer2 = getMPlayerContainer();
        View view2 = this.mPlayerPanel;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerPanel");
            view2 = null;
        }
        mPlayerContainer2.onViewCreated(view2, null);
        PlayerServiceManager.Client mGestureClient = new PlayerServiceManager.Client();
        getMPlayerContainer().getPlayerServiceManager().bindService(PlayerServiceManager.ServiceDescriptor.Companion.obtain(GestureService.class), mGestureClient);
        GestureService service = mGestureClient.getService();
        if (service != null) {
            service.setResizeGestureEnable(true);
        }
        this.mIsReady = true;
        Business pendingStartBusiness = this.mPendingStartBusiness;
        this.mPendingStartBusiness = null;
        if (pendingStartBusiness != null) {
            startBusiness(pendingStartBusiness);
        }
    }

    public void onStart(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        getMPlayerContainer().onStart();
    }

    public void onResume(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        getMPlayerContainer().onResume();
    }

    public void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        getMPlayerContainer().onPause();
    }

    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        getMPlayerContainer().onStop();
    }

    public void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        getMPlayerContainer().onDestroyView();
        getMPlayerContainer().onDestroy();
    }
}