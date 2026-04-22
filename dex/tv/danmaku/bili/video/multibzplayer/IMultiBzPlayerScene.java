package tv.danmaku.bili.video.multibzplayer;

import java.util.List;
import kotlin.Metadata;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MultiBzPlayerScene.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J4\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\b0\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\rH&J\"\u0010\u000e\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\b0\u000bH&J0\u0010\u000f\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\b0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\rH&J \u0010\u0010\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\rH&J\b\u0010\u0011\u001a\u00020\u0012H&J\u0016\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000b0\u0014H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/video/multibzplayer/IMultiBzPlayerScene;", "", "startBusiness", "", LoginSceneProcessor.BIZ_KEY, "Ltv/danmaku/bili/video/multibzplayer/Business;", "stopBusiness", "startService", "T", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "serviceClass", "Ljava/lang/Class;", "client", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "stopService", "bindService", "unbindService", "getPlayerContainer", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "getCommonServices", "", "multibzplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IMultiBzPlayerScene {
    <T extends IPlayerService> void bindService(Class<? extends T> cls, PlayerServiceManager.Client<T> client);

    List<Class<? extends IPlayerService>> getCommonServices();

    IPlayerContainer getPlayerContainer();

    void startBusiness(Business business);

    <T extends IPlayerService> void startService(Class<? extends T> cls, PlayerServiceManager.Client<T> client);

    void stopBusiness(Business business);

    <T extends IPlayerService> void stopService(Class<? extends T> cls);

    <T extends IPlayerService> void unbindService(PlayerServiceManager.Client<T> client);

    /* compiled from: MultiBzPlayerScene.kt */
    /* renamed from: tv.danmaku.bili.video.multibzplayer.IMultiBzPlayerScene$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void startService$default(IMultiBzPlayerScene iMultiBzPlayerScene, Class cls, PlayerServiceManager.Client client, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startService");
            }
            if ((i & 2) != 0) {
                client = null;
            }
            iMultiBzPlayerScene.startService(cls, client);
        }
    }
}