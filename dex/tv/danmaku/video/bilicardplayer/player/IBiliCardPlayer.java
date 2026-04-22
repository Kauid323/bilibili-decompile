package tv.danmaku.video.bilicardplayer.player;

import android.content.Context;
import android.content.res.Configuration;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.playerbizcommon.features.hardware.IHardwareDelegate;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.video.bilicardplayer.ICardPlayerContext;

/* compiled from: IBiliCardPlayer.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0014H&J\u0012\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\tH&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0014H&J&\u0010\u001a\u001a\u00020\u00032\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001dH&J\u0012\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"H&J\b\u0010#\u001a\u00020\u0014H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0014H&J4\u0010)\u001a\u00020\u0003\"\b\b\u0000\u0010**\u00020+2\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u0002H*0-2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u00010/H&J\u0018\u00100\u001a\u00020\u00032\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0-H&J:\u00101\u001a\u00020\u0003\"\b\b\u0000\u0010**\u00020+2\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u0002H*0-2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H*0/2\b\b\u0002\u00102\u001a\u00020\u0014H&J \u00103\u001a\u00020\u0003\"\b\b\u0000\u0010**\u00020+2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H*0/H&J\u0010\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u000206H&J\b\u00107\u001a\u00020\u0014H&J\u0018\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u0014H&J\b\u0010;\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006<À\u0006\u0001"}, d2 = {"Ltv/danmaku/video/bilicardplayer/player/IBiliCardPlayer;", "", "initialize", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "context", "Landroid/content/Context;", "sharedId", "", "extraConfiguration", "Ltv/danmaku/video/bilicardplayer/player/PlayerExtraConfiguration;", "getCardPlayerContext", "Ltv/danmaku/video/bilicardplayer/ICardPlayerContext;", "attachToTask", "cardPlayTask", "Ltv/danmaku/video/bilicardplayer/player/ICardPlayTask;", "detachFromTask", "detachTask", "changeContainer", "", "play", "index", "show", "setMute", "isMute", "setControlContainerConfig", "config", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "initializeType", "setHardwareDelegate", "delegate", "Lcom/bilibili/playerbizcommon/features/hardware/IHardwareDelegate;", "performBackPressed", "performConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "performMultiWindowModeChanged", "isInMultiWindowMode", "startService", "T", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "clazz", "Ljava/lang/Class;", "client", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "stopService", "bindService", "autoCreate", "unbindService", "listenPlayerReady", "observer", "Ltv/danmaku/video/bilicardplayer/player/CardPlayerReadyObserver;", "isReady", "prepareForShare", "keepRender", "needMute", "release", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IBiliCardPlayer {
    void attachToTask(ICardPlayTask iCardPlayTask);

    <T extends IPlayerService> void bindService(Class<? extends T> cls, PlayerServiceManager.Client<T> client, boolean z);

    ICardPlayTask detachFromTask(ICardPlayTask iCardPlayTask, boolean z);

    ICardPlayerContext getCardPlayerContext();

    void initialize(LifecycleOwner lifecycleOwner, Context context, int i, PlayerExtraConfiguration playerExtraConfiguration);

    boolean isReady();

    void listenPlayerReady(CardPlayerReadyObserver cardPlayerReadyObserver);

    boolean performBackPressed();

    void performConfigurationChanged(Configuration configuration);

    void performMultiWindowModeChanged(boolean z);

    void play(int i);

    int prepareForShare(boolean z, boolean z2);

    void release();

    void setControlContainerConfig(Map<ControlContainerType, ControlContainerConfig> map, ControlContainerType controlContainerType);

    void setHardwareDelegate(IHardwareDelegate iHardwareDelegate);

    void setMute(boolean z);

    void show();

    <T extends IPlayerService> void startService(Class<? extends T> cls, PlayerServiceManager.Client<T> client);

    void stopService(Class<? extends IPlayerService> cls);

    <T extends IPlayerService> void unbindService(PlayerServiceManager.Client<T> client);

    /* compiled from: IBiliCardPlayer.kt */
    /* renamed from: tv.danmaku.video.bilicardplayer.player.IBiliCardPlayer$-CC */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void initialize$default(IBiliCardPlayer iBiliCardPlayer, LifecycleOwner lifecycleOwner, Context context, int i, PlayerExtraConfiguration playerExtraConfiguration, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initialize");
            }
            if ((i2 & 1) != 0) {
                lifecycleOwner = null;
            }
            if ((i2 & 4) != 0) {
                i = -1;
            }
            iBiliCardPlayer.initialize(lifecycleOwner, context, i, playerExtraConfiguration);
        }

        public static /* synthetic */ ICardPlayTask detachFromTask$default(IBiliCardPlayer iBiliCardPlayer, ICardPlayTask iCardPlayTask, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                return iBiliCardPlayer.detachFromTask(iCardPlayTask, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: detachFromTask");
        }

        public static /* synthetic */ void play$default(IBiliCardPlayer iBiliCardPlayer, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: play");
            }
            if ((i2 & 1) != 0) {
                i = 0;
            }
            iBiliCardPlayer.play(i);
        }

        public static /* synthetic */ void setControlContainerConfig$default(IBiliCardPlayer iBiliCardPlayer, Map map, ControlContainerType controlContainerType, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setControlContainerConfig");
            }
            if ((i & 2) != 0) {
                controlContainerType = ControlContainerType.INITIAL;
            }
            iBiliCardPlayer.setControlContainerConfig(map, controlContainerType);
        }

        public static /* synthetic */ void startService$default(IBiliCardPlayer iBiliCardPlayer, Class cls, PlayerServiceManager.Client client, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startService");
            }
            if ((i & 2) != 0) {
                client = null;
            }
            iBiliCardPlayer.startService(cls, client);
        }

        public static /* synthetic */ void bindService$default(IBiliCardPlayer iBiliCardPlayer, Class cls, PlayerServiceManager.Client client, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindService");
            }
            if ((i & 4) != 0) {
                z = false;
            }
            iBiliCardPlayer.bindService(cls, client, z);
        }
    }
}