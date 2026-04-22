package tv.danmaku.biliplayerv2.service;

import java.util.List;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.injection.IPlayerServiceMembersInjector;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerServiceManager.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J.\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH&J6\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH&J\u0014\u0010\u000e\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u001a\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0018\u0010\u0015\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0017\u0018\u00010\u0016H&J\u0018\u0010\u0018\u001a\u00020\f2\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0017H&J\u0018\u0010\u001a\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0017\u0018\u00010\u0016H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001dH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IPlayerServiceManager;", "", "startService", "", "descriptor", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceDescriptor;", "bindService", "T", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "client", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "autoCreate", "", "unbindService", "stopService", "collectShareParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "sharingBundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "attachByShared", "getAllStartedService", "", "Ljava/lang/Class;", "isCoreService", "clazz", "getCoreServicesList", "setMembersInjector", "injector", "Ltv/danmaku/biliplayerv2/injection/IPlayerServiceMembersInjector;", "getMembersInjector", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IPlayerServiceManager {
    void attachByShared(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle);

    <T extends IPlayerService> void bindService(PlayerServiceManager.ServiceDescriptor<T> serviceDescriptor, PlayerServiceManager.Client<T> client);

    <T extends IPlayerService> void bindService(PlayerServiceManager.ServiceDescriptor<T> serviceDescriptor, PlayerServiceManager.Client<T> client, boolean z);

    void collectShareParams(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle);

    List<Class<? extends IPlayerService>> getAllStartedService();

    List<Class<? extends IPlayerService>> getCoreServicesList();

    IPlayerServiceMembersInjector getMembersInjector();

    boolean isCoreService(Class<? extends IPlayerService> cls);

    void setMembersInjector(IPlayerServiceMembersInjector iPlayerServiceMembersInjector);

    void startService(PlayerServiceManager.ServiceDescriptor<?> serviceDescriptor);

    void stopService(PlayerServiceManager.ServiceDescriptor<?> serviceDescriptor);

    void unbindService(PlayerServiceManager.ServiceDescriptor<?> serviceDescriptor, PlayerServiceManager.Client<?> client);
}