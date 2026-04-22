package tv.danmaku.biliplayerimpl;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.injection.PlayerServiceInjector;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: PlayerServiceManagerImpl.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0002)*B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J.\u0010\u0017\u001a\u00020\u000e\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0016J6\u0010\u0017\u001a\u00020\u000e\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001b2\u0006\u0010\u001c\u001a\u00020\fH\u0016J \u0010\u001d\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0016J\u0014\u0010\u001e\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\u0016\u0010 \u001a\u0004\u0018\u00010\t2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002J\u0014\u0010!\u001a\u00020\u00192\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002J\u0014\u0010\"\u001a\u00020\f2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002J\u0018\u0010#\u001a\u00020\f2\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190%H\u0016J\u0016\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00190%0'H\u0016J\u0016\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00190%0'H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Ltv/danmaku/biliplayerimpl/PlayerServiceManagerImpl;", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager;", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "<init>", "(Ltv/danmaku/biliplayerv2/PlayerContainer;)V", "mServiceRecordsById", "Ljava/util/LinkedHashMap;", "", "Ltv/danmaku/biliplayerimpl/PlayerServiceManagerImpl$PlayerServiceRecord;", "Lkotlin/collections/LinkedHashMap;", "mHandlingRelease", "", "startService", "", "descriptor", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceDescriptor;", "collectShareParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "sharingBundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "attachByShared", "bindService", "T", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "client", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "autoCreate", "unbindService", "stopService", "release", "findServiceRecord", "createPlayerService", "isPlayerServiceStarted", "isCoreService", "clazz", "Ljava/lang/Class;", "getAllStartedService", "", "getCoreServicesList", "Companion", "PlayerServiceRecord", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerServiceManagerImpl extends PlayerServiceManager {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "PlayerServiceManager";
    private boolean mHandlingRelease;
    private final PlayerContainer mPlayerContainer;
    private final LinkedHashMap<String, PlayerServiceRecord> mServiceRecordsById;

    /* compiled from: PlayerServiceManagerImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerimpl/PlayerServiceManagerImpl$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerServiceManagerImpl(PlayerContainer mPlayerContainer) {
        super(null);
        Intrinsics.checkNotNullParameter(mPlayerContainer, "mPlayerContainer");
        this.mPlayerContainer = mPlayerContainer;
        this.mServiceRecordsById = new LinkedHashMap<>(16);
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerServiceManager, tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public void startService(PlayerServiceManager.ServiceDescriptor<?> serviceDescriptor) {
        Intrinsics.checkNotNullParameter(serviceDescriptor, "descriptor");
        if (BuildConfig.DEBUG) {
            PlayerLog.i(TAG, "start service: {descriptor=" + serviceDescriptor + "}");
        }
        if (this.mHandlingRelease) {
            if (BuildConfig.DEBUG) {
                PlayerLog.i(TAG, "handling release now, do nothing!!!");
            }
        } else if (findServiceRecord(serviceDescriptor) != null) {
            if (BuildConfig.DEBUG) {
                PlayerLog.i(TAG, "service is already started, do nothing");
            }
        } else {
            IPlayerService service = createPlayerService(serviceDescriptor);
            PlayerServiceManager.ServiceConfig config = service.serviceConfig();
            PlayerServiceRecord record = new PlayerServiceRecord();
            record.setCoreService(CorePlayerServicesConfig.INSTANCE.isCoreService(service));
            record.setPersistent(config.isPersistent() || record.isCoreService());
            record.setInstance(service);
            String id = serviceDescriptor.getId();
            Intrinsics.checkNotNull(id);
            this.mServiceRecordsById.put(id, record);
            record.getPlayerServiceInjector().injectPlayerServices(service, this.mPlayerContainer);
            IPlayerService playerServiceRecord = record.getInstance();
            Intrinsics.checkNotNull(playerServiceRecord);
            playerServiceRecord.onStart(this.mPlayerContainer.getPlayerParams().getSharingBundle());
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerServiceManager, tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public void collectShareParams(PlayerSharingType sharingType, PlayerSharingBundle sharingBundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(sharingBundle, "sharingBundle");
        if (this.mHandlingRelease) {
            PlayerLog.i(TAG, "handling release now, do nothing!!!");
            return;
        }
        Map $this$forEach$iv = this.mServiceRecordsById;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            IPlayerService playerServiceRecord = element$iv.getValue().getInstance();
            if (playerServiceRecord != null) {
                playerServiceRecord.onCollectSharedParams(sharingType, sharingBundle);
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerServiceManager, tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public void attachByShared(PlayerSharingType sharingType, PlayerSharingBundle sharingBundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        if (this.mHandlingRelease) {
            PlayerLog.i(TAG, "handling release now, do nothing!!!");
            return;
        }
        Map $this$forEach$iv = this.mServiceRecordsById;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            IPlayerService playerServiceRecord = element$iv.getValue().getInstance();
            if (playerServiceRecord != null) {
                playerServiceRecord.onAttachByShared(sharingType, sharingBundle);
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerServiceManager, tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public <T extends IPlayerService> void bindService(PlayerServiceManager.ServiceDescriptor<T> serviceDescriptor, PlayerServiceManager.Client<T> client) {
        Intrinsics.checkNotNullParameter(serviceDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(client, "client");
        bindService(serviceDescriptor, client, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.biliplayerv2.service.PlayerServiceManager, tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public <T extends IPlayerService> void bindService(PlayerServiceManager.ServiceDescriptor<T> serviceDescriptor, PlayerServiceManager.Client<T> client, boolean autoCreate) {
        Intrinsics.checkNotNullParameter(serviceDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(client, "client");
        if (BuildConfig.DEBUG) {
            PlayerLog.i(TAG, "bind service: {descriptor=" + serviceDescriptor + "}");
        }
        if (this.mHandlingRelease) {
            if (BuildConfig.DEBUG) {
                PlayerLog.i(TAG, "handling release now, do nothing!!!");
                return;
            }
            return;
        }
        PlayerServiceRecord record = null;
        if (isPlayerServiceStarted(serviceDescriptor)) {
            record = findServiceRecord(serviceDescriptor);
        } else if (autoCreate) {
            if (BuildConfig.DEBUG) {
                PlayerLog.i(TAG, "service do not created, create it first");
            }
            startService(serviceDescriptor);
        } else {
            PlayerLog.e(TAG, "service do not created, and autoCreate is false, bind failed");
            return;
        }
        if (record == null) {
            record = findServiceRecord(serviceDescriptor);
        }
        Intrinsics.checkNotNull(record);
        if (!record.getClients().contains(client)) {
            record.getClients().add(client);
        }
        client.setService(record.getInstance());
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerServiceManager, tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public void unbindService(PlayerServiceManager.ServiceDescriptor<?> serviceDescriptor, PlayerServiceManager.Client<?> client) {
        Intrinsics.checkNotNullParameter(serviceDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(client, "client");
        if (BuildConfig.DEBUG) {
            PlayerLog.i(TAG, "unbind service: {descriptor=" + serviceDescriptor + "}");
        }
        if (this.mHandlingRelease) {
            if (BuildConfig.DEBUG) {
                PlayerLog.i(TAG, "handling release now, do nothing!!!");
                return;
            }
            return;
        }
        PlayerServiceRecord record = findServiceRecord(serviceDescriptor);
        if (record == null) {
            PlayerLog.w(TAG, "unbind, but service(" + serviceDescriptor + ") is not started");
            return;
        }
        record.getClients().remove(client);
        if (record.getClients().isEmpty() && !record.isPersistent()) {
            stopService(serviceDescriptor);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerServiceManager, tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public void stopService(PlayerServiceManager.ServiceDescriptor<?> serviceDescriptor) {
        Intrinsics.checkNotNullParameter(serviceDescriptor, "descriptor");
        if (BuildConfig.DEBUG) {
            PlayerLog.i(TAG, "stop service: {descriptor=" + serviceDescriptor + "}");
        }
        if (this.mHandlingRelease) {
            if (BuildConfig.DEBUG) {
                PlayerLog.i(TAG, "handling release now, do nothing!!!");
                return;
            }
            return;
        }
        PlayerServiceRecord record = findServiceRecord(serviceDescriptor);
        if (record == null) {
            PlayerLog.w(TAG, "stop, but service(" + serviceDescriptor + ") is not started");
            return;
        }
        Iterable $this$forEach$iv = record.getClients();
        for (Object element$iv : $this$forEach$iv) {
            PlayerServiceManager.Client it = (PlayerServiceManager.Client) element$iv;
            it.onPlayerServiceStop();
        }
        IPlayerService service = record.getInstance();
        if (service != null) {
            service.onStop();
            record.getPlayerServiceInjector().release();
        }
        TypeIntrinsics.asMutableMap(this.mServiceRecordsById).remove(serviceDescriptor.getId());
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerServiceManager
    public void release() {
        this.mHandlingRelease = true;
        ArrayList services = new ArrayList(this.mServiceRecordsById.entrySet());
        for (int index = services.size() - 1; -1 < index; index--) {
            IPlayerService playerServiceRecord = ((PlayerServiceRecord) ((Map.Entry) services.get(index)).getValue()).getInstance();
            if (playerServiceRecord != null) {
                playerServiceRecord.onStop();
            }
        }
        this.mServiceRecordsById.clear();
        this.mHandlingRelease = false;
    }

    private final PlayerServiceRecord findServiceRecord(PlayerServiceManager.ServiceDescriptor<?> serviceDescriptor) {
        LinkedHashMap<String, PlayerServiceRecord> linkedHashMap = this.mServiceRecordsById;
        String id = serviceDescriptor.getId();
        Intrinsics.checkNotNull(id);
        return linkedHashMap.get(id);
    }

    private final IPlayerService createPlayerService(PlayerServiceManager.ServiceDescriptor<?> serviceDescriptor) {
        try {
            Class<? extends Object> clazz = serviceDescriptor.getClazz();
            Intrinsics.checkNotNull(clazz);
            Constructor c = clazz.getConstructor(new Class[0]);
            IPlayerService instance = (IPlayerService) c.newInstance(new Object[0]);
            instance.bindPlayerContainer(this.mPlayerContainer);
            Intrinsics.checkNotNull(instance);
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("create service error", e);
        }
    }

    private final boolean isPlayerServiceStarted(PlayerServiceManager.ServiceDescriptor<?> serviceDescriptor) {
        return this.mServiceRecordsById.containsKey(serviceDescriptor.getId());
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerServiceManager, tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public boolean isCoreService(Class<? extends IPlayerService> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return CorePlayerServicesConfig.INSTANCE.getSCorePlayerServices().contains(cls);
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerServiceManager, tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public List<Class<? extends IPlayerService>> getAllStartedService() {
        List list = new ArrayList();
        Iterable values = this.mServiceRecordsById.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterable $this$forEach$iv = values;
        for (Object element$iv : $this$forEach$iv) {
            PlayerServiceRecord it = (PlayerServiceRecord) element$iv;
            IPlayerService it1 = it.getInstance();
            if (it1 != null) {
                list.add(it1.getClass());
            }
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(list);
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerServiceManager, tv.danmaku.biliplayerv2.service.IPlayerServiceManager
    public List<Class<? extends IPlayerService>> getCoreServicesList() {
        return EnhancedUnmodifiabilityKt.unmodifiable(CorePlayerServicesConfig.INSTANCE.getSCorePlayerServices());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayerServiceManagerImpl.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R$\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Ltv/danmaku/biliplayerimpl/PlayerServiceManagerImpl$PlayerServiceRecord;", "", "<init>", "()V", "playerServiceInjector", "Ltv/danmaku/biliplayerv2/injection/PlayerServiceInjector;", "getPlayerServiceInjector", "()Ltv/danmaku/biliplayerv2/injection/PlayerServiceInjector;", "instance", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "getInstance", "()Ltv/danmaku/biliplayerv2/service/IPlayerService;", "setInstance", "(Ltv/danmaku/biliplayerv2/service/IPlayerService;)V", "isCoreService", "", "()Z", "setCoreService", "(Z)V", "isPersistent", "setPersistent", "clients", "", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$Client;", "getClients", "()Ljava/util/List;", "setClients", "(Ljava/util/List;)V", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class PlayerServiceRecord {
        private IPlayerService instance;
        private boolean isCoreService;
        private boolean isPersistent;
        private final PlayerServiceInjector playerServiceInjector = new PlayerServiceInjector();
        private List<PlayerServiceManager.Client<?>> clients = new ArrayList(2);

        public final PlayerServiceInjector getPlayerServiceInjector() {
            return this.playerServiceInjector;
        }

        public final IPlayerService getInstance() {
            return this.instance;
        }

        public final void setInstance(IPlayerService iPlayerService) {
            this.instance = iPlayerService;
        }

        public final boolean isCoreService() {
            return this.isCoreService;
        }

        public final void setCoreService(boolean z) {
            this.isCoreService = z;
        }

        public final boolean isPersistent() {
            return this.isPersistent;
        }

        public final void setPersistent(boolean z) {
            this.isPersistent = z;
        }

        public final List<PlayerServiceManager.Client<?>> getClients() {
            return this.clients;
        }

        public final void setClients(List<PlayerServiceManager.Client<?>> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.clients = list;
        }
    }
}