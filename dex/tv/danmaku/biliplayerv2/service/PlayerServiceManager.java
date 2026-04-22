package tv.danmaku.biliplayerv2.service;

import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.injection.IPlayerServiceMembersInjector;
import tv.danmaku.biliplayerv2.playerimpl.IBiliPlayerImplService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerServiceManager.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 $2\u00020\u0001:\u0004$%&'B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J.\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\f0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0016J6\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\f0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0014\u0010\u0013\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001b\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\u001d\u0018\u00010\u001cH\u0016J\u0018\u0010\u001e\u001a\u00020\u00112\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u001dH\u0016J\u0018\u0010 \u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\u001d\u0018\u00010\u001cH\u0016J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ltv/danmaku/biliplayerv2/service/PlayerServiceManager;", "Ltv/danmaku/biliplayerv2/service/IPlayerServiceManager;", "mImpl", "<init>", "(Ltv/danmaku/biliplayerv2/service/PlayerServiceManager;)V", "mMembersInjector", "Ltv/danmaku/biliplayerv2/injection/IPlayerServiceMembersInjector;", "startService", "", "descriptor", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceDescriptor;", "bindService", "T", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "client", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "autoCreate", "", "unbindService", "stopService", "release", "collectShareParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "sharingBundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "attachByShared", "getAllStartedService", "", "Ljava/lang/Class;", "isCoreService", "clazz", "getCoreServicesList", "setMembersInjector", "injector", "getMembersInjector", "Companion", "ServiceDescriptor", "ServiceConfig", "Client", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class PlayerServiceManager implements IPlayerServiceManager {
    public static final Companion Companion = new Companion(null);
    private final PlayerServiceManager mImpl;
    private IPlayerServiceMembersInjector mMembersInjector = new IPlayerServiceMembersInjector() { // from class: tv.danmaku.biliplayerv2.service.PlayerServiceManager$mMembersInjector$1
        @Override // tv.danmaku.biliplayerv2.injection.IPlayerServiceMembersInjector
        public void injectMembers(Object any) {
            Intrinsics.checkNotNullParameter(any, "any");
        }
    };

    public PlayerServiceManager(PlayerServiceManager mImpl) {
        this.mImpl = mImpl;
    }

    /* compiled from: PlayerServiceManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Companion;", "", "<init>", "()V", "isCoreService", "", "clazz", "Ljava/lang/Class;", "isCoreService$biliplayerv2_debug", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isCoreService$biliplayerv2_debug(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "clazz");
            IBiliPlayerImplService implService = (IBiliPlayerImplService) BLRouter.INSTANCE.get(IBiliPlayerImplService.class, "default");
            if (implService == null) {
                return false;
            }
            return implService.isCoreService(cls);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public void startService(ServiceDescriptor<?> serviceDescriptor) {
        Intrinsics.checkNotNullParameter(serviceDescriptor, "descriptor");
        Class<? extends Object> clazz = serviceDescriptor.getClazz();
        Intrinsics.checkNotNull(clazz);
        if (isCoreService(clazz)) {
            throw new IllegalArgumentException("could not start core service");
        }
        PlayerServiceManager playerServiceManager = this.mImpl;
        if (playerServiceManager != null) {
            playerServiceManager.startService(serviceDescriptor);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public <T extends IPlayerService> void bindService(ServiceDescriptor<T> serviceDescriptor, Client<T> client) {
        Intrinsics.checkNotNullParameter(serviceDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(client, "client");
        PlayerServiceManager playerServiceManager = this.mImpl;
        if (playerServiceManager != null) {
            playerServiceManager.bindService(serviceDescriptor, client);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public <T extends IPlayerService> void bindService(ServiceDescriptor<T> serviceDescriptor, Client<T> client, boolean autoCreate) {
        Intrinsics.checkNotNullParameter(serviceDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(client, "client");
        PlayerServiceManager playerServiceManager = this.mImpl;
        if (playerServiceManager != null) {
            playerServiceManager.bindService(serviceDescriptor, client, autoCreate);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public void unbindService(ServiceDescriptor<?> serviceDescriptor, Client<?> client) {
        Intrinsics.checkNotNullParameter(serviceDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(client, "client");
        PlayerServiceManager playerServiceManager = this.mImpl;
        if (playerServiceManager != null) {
            playerServiceManager.unbindService(serviceDescriptor, client);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public void stopService(ServiceDescriptor<?> serviceDescriptor) {
        Intrinsics.checkNotNullParameter(serviceDescriptor, "descriptor");
        Class<? extends Object> clazz = serviceDescriptor.getClazz();
        Intrinsics.checkNotNull(clazz);
        if (isCoreService(clazz)) {
            throw new IllegalArgumentException("could not stop core service");
        }
        PlayerServiceManager playerServiceManager = this.mImpl;
        if (playerServiceManager != null) {
            playerServiceManager.stopService(serviceDescriptor);
        }
    }

    public void release() {
        PlayerServiceManager playerServiceManager = this.mImpl;
        if (playerServiceManager != null) {
            playerServiceManager.release();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public void collectShareParams(PlayerSharingType sharingType, PlayerSharingBundle sharingBundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(sharingBundle, "sharingBundle");
        PlayerServiceManager playerServiceManager = this.mImpl;
        if (playerServiceManager != null) {
            playerServiceManager.collectShareParams(sharingType, sharingBundle);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public void attachByShared(PlayerSharingType sharingType, PlayerSharingBundle sharingBundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        PlayerServiceManager playerServiceManager = this.mImpl;
        if (playerServiceManager != null) {
            playerServiceManager.attachByShared(sharingType, sharingBundle);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public List<Class<? extends IPlayerService>> getAllStartedService() {
        PlayerServiceManager playerServiceManager = this.mImpl;
        return EnhancedUnmodifiabilityKt.unmodifiable(playerServiceManager != null ? playerServiceManager.getAllStartedService() : null);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public boolean isCoreService(Class<? extends IPlayerService> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        PlayerServiceManager playerServiceManager = this.mImpl;
        if (playerServiceManager != null) {
            return playerServiceManager.isCoreService(cls);
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public List<Class<? extends IPlayerService>> getCoreServicesList() {
        PlayerServiceManager playerServiceManager = this.mImpl;
        return EnhancedUnmodifiabilityKt.unmodifiable(playerServiceManager != null ? playerServiceManager.getCoreServicesList() : null);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public void setMembersInjector(IPlayerServiceMembersInjector injector) {
        Intrinsics.checkNotNullParameter(injector, "injector");
        this.mMembersInjector = injector;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public IPlayerServiceMembersInjector getMembersInjector() {
        return this.mMembersInjector;
    }

    /* compiled from: PlayerServiceManager.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u0010*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\fH\u0016R2\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u00072\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceDescriptor;", "T", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "", "<init>", "()V", "value", "Ljava/lang/Class;", "clazz", "getClazz", "()Ljava/lang/Class;", "id", "", "getId", "()Ljava/lang/String;", "toString", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ServiceDescriptor<T extends IPlayerService> {
        public static final Companion Companion = new Companion(null);
        private Class<? extends T> clazz;

        public /* synthetic */ ServiceDescriptor(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: PlayerServiceManager.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\tH\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceDescriptor$Companion;", "", "<init>", "()V", "obtain", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceDescriptor;", "T", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "clazz", "Ljava/lang/Class;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final <T extends IPlayerService> ServiceDescriptor<T> obtain(Class<? extends T> cls) {
                Intrinsics.checkNotNullParameter(cls, "clazz");
                ServiceDescriptor descriptor = new ServiceDescriptor(null);
                descriptor.clazz = cls;
                return descriptor;
            }
        }

        private ServiceDescriptor() {
        }

        @JvmStatic
        public static final <T extends IPlayerService> ServiceDescriptor<T> obtain(Class<? extends T> cls) {
            return Companion.obtain(cls);
        }

        public final Class<? extends T> getClazz() {
            return this.clazz;
        }

        public final String getId() {
            Class<? extends T> cls = this.clazz;
            if (cls != null) {
                return cls.getName();
            }
            return null;
        }

        public String toString() {
            String id = getId();
            return id == null ? super.toString() : id;
        }
    }

    /* compiled from: PlayerServiceManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceConfig;", "", "<init>", "()V", "value", "", "isPersistent", "()Z", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ServiceConfig {
        public static final Companion Companion = new Companion(null);
        private boolean isPersistent;

        public /* synthetic */ ServiceConfig(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: PlayerServiceManager.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceConfig$Companion;", "", "<init>", "()V", "obtain", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceConfig;", "p", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ServiceConfig obtain(boolean p) {
                ServiceConfig c = new ServiceConfig(null);
                c.isPersistent = p;
                return c;
            }
        }

        private ServiceConfig() {
        }

        @JvmStatic
        public static final ServiceConfig obtain(boolean p) {
            return Companion.obtain(p);
        }

        public final boolean isPersistent() {
            return this.isPersistent;
        }
    }

    /* compiled from: PlayerServiceManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "T", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "", "<init>", "()V", "service", "getService", "()Ltv/danmaku/biliplayerv2/service/IPlayerService;", "setService", "(Ltv/danmaku/biliplayerv2/service/IPlayerService;)V", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "onPlayerServiceStop", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Client<T extends IPlayerService> {
        private T service;

        public final T getService() {
            return this.service;
        }

        public final void setService(T t) {
            this.service = t;
        }

        public void onPlayerServiceStop() {
            this.service = null;
        }
    }
}