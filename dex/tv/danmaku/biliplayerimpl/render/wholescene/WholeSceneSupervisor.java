package tv.danmaku.biliplayerimpl.render.wholescene;

import com.bilibili.droid.WindowManagerHelper;
import com.bilibili.lib.media.util.PlayerCloudSetting;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.service.LifecycleObserver;
import tv.danmaku.biliplayerv2.service.LifecycleState;
import tv.danmaku.biliplayerv2.service.render.wholescene.WholeSceneModeChangeObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.render.core.IVideoRenderLayer;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.coreV2.adapter.CoordinateAxis;
import tv.danmaku.videoplayer.coreV2.adapter.ScreenOrientation;

/* compiled from: WholeSceneSupervisor.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\rJ\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0006\u0010\u0019\u001a\u00020\u000fJ\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\rH\u0002J\u0006\u0010\u001c\u001a\u00020\rJ\u0010\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u001f\u001a\u00020\rJ\u0006\u0010 \u001a\u00020\u000fJ\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\bJ\u000e\u0010$\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\bJ\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R2\u0010\u0006\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ltv/danmaku/biliplayerimpl/render/wholescene/WholeSceneSupervisor;", "Ltv/danmaku/biliplayerv2/service/LifecycleObserver;", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mWholeSceneModeChangeObservers", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "Ltv/danmaku/biliplayerv2/service/render/wholescene/WholeSceneModeChangeObserver;", "kotlin.jvm.PlatformType", "mVideoRenderLayer", "Ltv/danmaku/render/core/IVideoRenderLayer;", "mIsInWholeSceneMode", "", "init", "", "playerContainer", "enterWholeSceneMode", "fromUser", "onLifecycleChanged", "state", "Ltv/danmaku/biliplayerv2/service/LifecycleState;", "shouldAutoEnterWholeSceneMode", "setShouldAutoEnterWholeSceneMode", "value", "restoreFromShutDownByOthers", "switchRenderLayerToWholeSceneMode", "into", "supportWholeScene", "setVideoRenderLayer", "layer", "isInWholeSceneMode", "notifyScreenModeTypeChanged", "exitWholeSceneMode", "addWholeSceneModeChangeObserver", "observer", "removeWholeSceneModeChangObserver", "dispatchWholeSceneModeChange", "enter", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WholeSceneSupervisor implements LifecycleObserver {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "WholeSceneSupervisor";
    private boolean mIsInWholeSceneMode;
    private PlayerContainer mPlayerContainer;
    private IVideoRenderLayer mVideoRenderLayer;
    private final Collections.SafeIteratorList<WholeSceneModeChangeObserver> mWholeSceneModeChangeObservers = Collections.safeIteratorList(new LinkedList());

    /* compiled from: WholeSceneSupervisor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerimpl/render/wholescene/WholeSceneSupervisor$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void init(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    public final void enterWholeSceneMode(boolean fromUser) {
        if (isInWholeSceneMode()) {
            PlayerLog.i(TAG, "already in whole-scene mode");
        } else if (!supportWholeScene()) {
            PlayerLog.i(TAG, "videoRenderLayer:" + this.mVideoRenderLayer + " do not support whole-scene");
        } else {
            this.mIsInWholeSceneMode = true;
            switchRenderLayerToWholeSceneMode(true);
            dispatchWholeSceneModeChange(true);
            PlayerContainer playerContainer = this.mPlayerContainer;
            if (playerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer = null;
            }
            playerContainer.getActivityStateService().registerLifecycle(this, LifecycleState.ACTIVITY_STOP, LifecycleState.ACTIVITY_START);
            if (fromUser) {
                setShouldAutoEnterWholeSceneMode(true);
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.LifecycleObserver
    public void onLifecycleChanged(LifecycleState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == LifecycleState.ACTIVITY_STOP) {
            IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
            if (iVideoRenderLayer != null) {
                iVideoRenderLayer.closeSensorGyroscope();
            }
            this.mWholeSceneModeChangeObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.wholescene.WholeSceneSupervisor$$ExternalSyntheticLambda3
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((WholeSceneModeChangeObserver) obj).onWholeSceneReset();
                }
            });
        }
        if (state == LifecycleState.ACTIVITY_START) {
            IVideoRenderLayer iVideoRenderLayer2 = this.mVideoRenderLayer;
            if (iVideoRenderLayer2 != null) {
                iVideoRenderLayer2.openSensorGyroscope();
            }
            notifyScreenModeTypeChanged();
        }
    }

    public final boolean shouldAutoEnterWholeSceneMode() {
        return PlayerCloudSetting.INSTANCE.getSettingBooleanValue(PlayerCloudSetting.Setting.WholeScreen);
    }

    private final void setShouldAutoEnterWholeSceneMode(boolean value) {
        PlayerCloudSetting.setSettingBooleanValue$default(PlayerCloudSetting.INSTANCE, PlayerCloudSetting.Setting.WholeScreen, value, false, 4, (Object) null);
    }

    public final void restoreFromShutDownByOthers() {
        if (isInWholeSceneMode()) {
            this.mWholeSceneModeChangeObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.wholescene.WholeSceneSupervisor$$ExternalSyntheticLambda2
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((WholeSceneModeChangeObserver) obj).onWholeSceneReset();
                }
            });
            switchRenderLayerToWholeSceneMode(true);
        }
    }

    private final void switchRenderLayerToWholeSceneMode(boolean into) {
        if (into) {
            IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
            if (iVideoRenderLayer != null) {
                iVideoRenderLayer.enterWholeSceneMode();
            }
            notifyScreenModeTypeChanged();
            return;
        }
        IVideoRenderLayer iVideoRenderLayer2 = this.mVideoRenderLayer;
        if (iVideoRenderLayer2 != null) {
            iVideoRenderLayer2.exitWholeSceneMode();
        }
    }

    public final boolean supportWholeScene() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        if (playerContainer.getPlayerParams().getConfig().getWholeSceneEnable()) {
            PlayerContainer playerContainer3 = this.mPlayerContainer;
            if (playerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainer2 = playerContainer3;
            }
            if (playerContainer2.getPlayerSettingService().getCloudConfig().supportWholeScene()) {
                IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
                return iVideoRenderLayer != null && iVideoRenderLayer.supportWholeScene();
            }
            return false;
        }
        return false;
    }

    public final void setVideoRenderLayer(IVideoRenderLayer layer) {
        this.mVideoRenderLayer = layer;
    }

    public final boolean isInWholeSceneMode() {
        return this.mIsInWholeSceneMode;
    }

    public final void notifyScreenModeTypeChanged() {
        ScreenOrientation orientation;
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        boolean z = false;
        if (iVideoRenderLayer != null && iVideoRenderLayer.supportWholeScene()) {
            z = true;
        }
        if (!z || !isInWholeSceneMode()) {
            return;
        }
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        switch (WindowManagerHelper.getDefaultDisplay(playerContainer.getContext()).getRotation()) {
            case 1:
                orientation = ScreenOrientation.Left;
                break;
            case 2:
                orientation = ScreenOrientation.Down;
                break;
            case 3:
                orientation = ScreenOrientation.Right;
                break;
            default:
                orientation = ScreenOrientation.Up;
                break;
        }
        IVideoRenderLayer iVideoRenderLayer2 = this.mVideoRenderLayer;
        if (iVideoRenderLayer2 != null) {
            iVideoRenderLayer2.notifyScreenOrientation(orientation);
        }
        IVideoRenderLayer iVideoRenderLayer3 = this.mVideoRenderLayer;
        if (iVideoRenderLayer3 != null) {
            iVideoRenderLayer3.resetGyroscope(CoordinateAxis.AxisZ);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r1.supportWholeScene() == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void exitWholeSceneMode(boolean fromUser) {
        boolean z;
        if (!isInWholeSceneMode()) {
            PlayerLog.i(TAG, "it is not in whole-scene mode");
            return;
        }
        this.mIsInWholeSceneMode = false;
        IVideoRenderLayer iVideoRenderLayer = this.mVideoRenderLayer;
        if (iVideoRenderLayer != null) {
            z = true;
        }
        z = false;
        if (z) {
            switchRenderLayerToWholeSceneMode(false);
        }
        dispatchWholeSceneModeChange(false);
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getActivityStateService().unregisterLifecycle(this);
        if (fromUser) {
            setShouldAutoEnterWholeSceneMode(false);
        }
    }

    public final void addWholeSceneModeChangeObserver(WholeSceneModeChangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mWholeSceneModeChangeObservers.add(observer);
    }

    public final void removeWholeSceneModeChangObserver(WholeSceneModeChangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mWholeSceneModeChangeObservers.remove(observer);
    }

    private final void dispatchWholeSceneModeChange(boolean enter) {
        if (enter) {
            this.mWholeSceneModeChangeObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.wholescene.WholeSceneSupervisor$$ExternalSyntheticLambda0
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((WholeSceneModeChangeObserver) obj).onEnterWholeScene();
                }
            });
        } else {
            this.mWholeSceneModeChangeObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.render.wholescene.WholeSceneSupervisor$$ExternalSyntheticLambda1
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((WholeSceneModeChangeObserver) obj).onExitWholeScene();
                }
            });
        }
    }
}