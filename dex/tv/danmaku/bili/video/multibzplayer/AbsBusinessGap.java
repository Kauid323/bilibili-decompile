package tv.danmaku.bili.video.multibzplayer;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AbsBusinessGap.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000fJ\b\u0010\u0010\u001a\u00020\rH&J\r\u0010\u0011\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0012J\u0014\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00150\u0014J\b\u0010\u0017\u001a\u00020\rH&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/video/multibzplayer/AbsBusinessGap;", "", "<init>", "()V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "getMPlayerContainer", "()Ltv/danmaku/biliplayerv2/IPlayerContainer;", "setMPlayerContainer", "(Ltv/danmaku/biliplayerv2/IPlayerContainer;)V", "mScene", "Ltv/danmaku/bili/video/multibzplayer/IMultiBzPlayerScene;", "start", "", LoginSceneProcessor.SCENE_KEY, "start$multibzplayer_debug", "onStart", "stop", "stop$multibzplayer_debug", "getCommonServices", "", "Ljava/lang/Class;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "onStop", "multibzplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class AbsBusinessGap {
    private IPlayerContainer mPlayerContainer;
    private IMultiBzPlayerScene mScene;

    public abstract void onStart();

    public abstract void onStop();

    protected final IPlayerContainer getMPlayerContainer() {
        return this.mPlayerContainer;
    }

    protected final void setMPlayerContainer(IPlayerContainer iPlayerContainer) {
        this.mPlayerContainer = iPlayerContainer;
    }

    public final void start$multibzplayer_debug(IMultiBzPlayerScene scene) {
        Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
        this.mScene = scene;
        this.mPlayerContainer = scene.getPlayerContainer();
        onStart();
    }

    public final void stop$multibzplayer_debug() {
        onStop();
        this.mPlayerContainer = null;
    }

    public final List<Class<? extends IPlayerService>> getCommonServices() {
        IMultiBzPlayerScene iMultiBzPlayerScene = this.mScene;
        if (iMultiBzPlayerScene == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScene");
            iMultiBzPlayerScene = null;
        }
        return iMultiBzPlayerScene.getCommonServices();
    }
}