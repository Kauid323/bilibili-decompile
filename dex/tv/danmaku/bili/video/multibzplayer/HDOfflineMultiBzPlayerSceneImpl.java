package tv.danmaku.bili.video.multibzplayer;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.base.util.ContextUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.PlayerConfiguration;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.video.playerservice.BLPlayerService;

/* compiled from: HDOfflineMultiBzPlayerScene.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/video/multibzplayer/HDOfflineMultiBzPlayerSceneImpl;", "Ltv/danmaku/bili/video/multibzplayer/MultiBzPlayerSceneImpl;", "<init>", "()V", "initialize", "", "context", "Landroid/content/Context;", "service", "Ltv/danmaku/video/playerservice/BLPlayerService;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "multibzplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class HDOfflineMultiBzPlayerSceneImpl extends MultiBzPlayerSceneImpl {
    @Override // tv.danmaku.bili.video.multibzplayer.MultiBzPlayerSceneImpl, tv.danmaku.video.playerservice.BLPlayerScene
    public void initialize(Context context, BLPlayerService service, LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(service, "service");
        setMBLPlayerService(service);
        setMContext(context);
        PlayerParamsV2 playerParams = new PlayerParamsV2();
        PlayerConfiguration config = new PlayerConfiguration();
        config.setMLoadingDelayTime(800L);
        config.setUpdateVideoRenderViewPortEnable(true);
        config.setWholeSceneEnable(true);
        config.setDisallowParentIntercept(true);
        config.setControlContainerLazyMode(true);
        Activity findActivityOrNull = ContextUtilKt.findActivityOrNull(context);
        Integer curOrientation = findActivityOrNull != null ? Integer.valueOf(findActivityOrNull.getRequestedOrientation()) : null;
        if ((curOrientation != null && curOrientation.intValue() == 0) || (curOrientation != null && curOrientation.intValue() == 8)) {
            config.setInitialControlContainerType(ControlContainerType.LANDSCAPE_FULLSCREEN);
        } else {
            config.setInitialControlContainerType(ControlContainerType.HALF_SCREEN);
        }
        playerParams.setConfig(config);
        setMPlayerContainer(new IPlayerContainer.Builder().setContext(context).setPlayerParams(playerParams).setControlContainerConfig(MultiBzPlayerSceneImpl.Companion.getSEmptyControlContainerConfig$multibzplayer_debug()).build());
        if (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) {
            return;
        }
        lifecycle.addObserver((LifecycleObserver) this);
    }
}