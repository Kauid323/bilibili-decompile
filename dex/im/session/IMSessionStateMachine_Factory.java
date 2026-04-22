package im.session;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import dagger.internal.Factory;
import im.session.service.IMClearSessionService;
import im.session.service.IMClearUnreadService;
import im.session.service.IMGroupAssistantFetcherService;
import im.session.service.IMSessionBroadcastService;
import im.session.service.IMSessionCardEventService;
import im.session.service.IMSessionDataSourceServiceLike;
import im.session.service.IMSessionInteractiveService;
import im.session.service.IMSessionListCacheService;
import im.session.service.IMSessionUpdateService;
import im.session.service.IMSummaryCacheService;
import javax.inject.Provider;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fBµ\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0004\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004\u0012\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0004\u0012\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lim/session/IMSessionStateMachine_Factory;", "Ldagger/internal/Factory;", "Lim/session/IMSessionStateMachine;", "pageTypeProvider", "Ljavax/inject/Provider;", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "broadcastServiceProvider", "Lim/session/service/IMSessionBroadcastService;", "dataSourceServiceProvider", "Lim/session/service/IMSessionDataSourceServiceLike;", "updateServiceProvider", "Lim/session/service/IMSessionUpdateService;", "sessionEventServiceProvider", "Lim/session/service/IMSessionCardEventService;", "clearUnreadServiceProvider", "Lim/session/service/IMClearUnreadService;", "clearSessionServiceProvider", "Lim/session/service/IMClearSessionService;", "interactiveServiceProvider", "Lim/session/service/IMSessionInteractiveService;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "summaryServiceProvider", "Lim/session/service/IMSummaryCacheService;", "cacheServiceProvider", "Lim/session/service/IMSessionListCacheService;", "groupAssistantFetcherServiceProvider", "Lim/session/service/IMGroupAssistantFetcherService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionStateMachine_Factory implements Factory<IMSessionStateMachine> {
    public static final Companion Companion = new Companion(null);
    private final Provider<KAccountStore> accountStoreProvider;
    private final Provider<IMSessionBroadcastService> broadcastServiceProvider;
    private final Provider<IMSessionListCacheService> cacheServiceProvider;
    private final Provider<IMClearSessionService> clearSessionServiceProvider;
    private final Provider<IMClearUnreadService> clearUnreadServiceProvider;
    private final Provider<IMSessionDataSourceServiceLike> dataSourceServiceProvider;
    private final Provider<IMGroupAssistantFetcherService> groupAssistantFetcherServiceProvider;
    private final Provider<IMSessionInteractiveService> interactiveServiceProvider;
    private final Provider<KSessionPageType> pageTypeProvider;
    private final Provider<IMSessionCardEventService> sessionEventServiceProvider;
    private final Provider<IMSummaryCacheService> summaryServiceProvider;
    private final Provider<IMSessionUpdateService> updateServiceProvider;

    public IMSessionStateMachine_Factory(Provider<KSessionPageType> provider, Provider<IMSessionBroadcastService> provider2, Provider<IMSessionDataSourceServiceLike> provider3, Provider<IMSessionUpdateService> provider4, Provider<IMSessionCardEventService> provider5, Provider<IMClearUnreadService> provider6, Provider<IMClearSessionService> provider7, Provider<IMSessionInteractiveService> provider8, Provider<KAccountStore> provider9, Provider<IMSummaryCacheService> provider10, Provider<IMSessionListCacheService> provider11, Provider<IMGroupAssistantFetcherService> provider12) {
        Intrinsics.checkNotNullParameter(provider, "pageTypeProvider");
        Intrinsics.checkNotNullParameter(provider2, "broadcastServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "dataSourceServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "updateServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "sessionEventServiceProvider");
        Intrinsics.checkNotNullParameter(provider6, "clearUnreadServiceProvider");
        Intrinsics.checkNotNullParameter(provider7, "clearSessionServiceProvider");
        Intrinsics.checkNotNullParameter(provider8, "interactiveServiceProvider");
        Intrinsics.checkNotNullParameter(provider9, "accountStoreProvider");
        Intrinsics.checkNotNullParameter(provider10, "summaryServiceProvider");
        Intrinsics.checkNotNullParameter(provider11, "cacheServiceProvider");
        Intrinsics.checkNotNullParameter(provider12, "groupAssistantFetcherServiceProvider");
        this.pageTypeProvider = provider;
        this.broadcastServiceProvider = provider2;
        this.dataSourceServiceProvider = provider3;
        this.updateServiceProvider = provider4;
        this.sessionEventServiceProvider = provider5;
        this.clearUnreadServiceProvider = provider6;
        this.clearSessionServiceProvider = provider7;
        this.interactiveServiceProvider = provider8;
        this.accountStoreProvider = provider9;
        this.summaryServiceProvider = provider10;
        this.cacheServiceProvider = provider11;
        this.groupAssistantFetcherServiceProvider = provider12;
    }

    /* renamed from: get */
    public IMSessionStateMachine m3239get() {
        Companion companion = Companion;
        Object obj = this.pageTypeProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.broadcastServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.dataSourceServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        Object obj4 = this.updateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
        Object obj5 = this.sessionEventServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj5, "get(...)");
        Object obj6 = this.clearUnreadServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj6, "get(...)");
        Object obj7 = this.clearSessionServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj7, "get(...)");
        Object obj8 = this.accountStoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj8, "get(...)");
        Object obj9 = this.summaryServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj9, "get(...)");
        return companion.newInstance((KSessionPageType) obj, (IMSessionBroadcastService) obj2, (IMSessionDataSourceServiceLike) obj3, (IMSessionUpdateService) obj4, (IMSessionCardEventService) obj5, (IMClearUnreadService) obj6, (IMClearSessionService) obj7, (IMSessionInteractiveService) this.interactiveServiceProvider.get(), (KAccountStore) obj8, (IMSummaryCacheService) obj9, (IMSessionListCacheService) this.cacheServiceProvider.get(), (IMGroupAssistantFetcherService) this.groupAssistantFetcherServiceProvider.get());
    }

    /* compiled from: IMSessionStateMachine_Factory.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J¶\u0001\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00072\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0007H\u0007Jn\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010\u00162\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010\u001c2\b\u0010,\u001a\u0004\u0018\u00010\u001eH\u0007¨\u0006-"}, d2 = {"Lim/session/IMSessionStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lim/session/IMSessionStateMachine_Factory;", "pageTypeProvider", "Ljavax/inject/Provider;", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "broadcastServiceProvider", "Lim/session/service/IMSessionBroadcastService;", "dataSourceServiceProvider", "Lim/session/service/IMSessionDataSourceServiceLike;", "updateServiceProvider", "Lim/session/service/IMSessionUpdateService;", "sessionEventServiceProvider", "Lim/session/service/IMSessionCardEventService;", "clearUnreadServiceProvider", "Lim/session/service/IMClearUnreadService;", "clearSessionServiceProvider", "Lim/session/service/IMClearSessionService;", "interactiveServiceProvider", "Lim/session/service/IMSessionInteractiveService;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "summaryServiceProvider", "Lim/session/service/IMSummaryCacheService;", "cacheServiceProvider", "Lim/session/service/IMSessionListCacheService;", "groupAssistantFetcherServiceProvider", "Lim/session/service/IMGroupAssistantFetcherService;", "newInstance", "Lim/session/IMSessionStateMachine;", "pageType", "broadcastService", "dataSourceService", "updateService", "sessionEventService", "clearUnreadService", "clearSessionService", "interactiveService", "accountStore", "summaryService", "cacheService", "groupAssistantFetcherService", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IMSessionStateMachine_Factory create(Provider<KSessionPageType> provider, Provider<IMSessionBroadcastService> provider2, Provider<IMSessionDataSourceServiceLike> provider3, Provider<IMSessionUpdateService> provider4, Provider<IMSessionCardEventService> provider5, Provider<IMClearUnreadService> provider6, Provider<IMClearSessionService> provider7, Provider<IMSessionInteractiveService> provider8, Provider<KAccountStore> provider9, Provider<IMSummaryCacheService> provider10, Provider<IMSessionListCacheService> provider11, Provider<IMGroupAssistantFetcherService> provider12) {
            Intrinsics.checkNotNullParameter(provider, "pageTypeProvider");
            Intrinsics.checkNotNullParameter(provider2, "broadcastServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "dataSourceServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "updateServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "sessionEventServiceProvider");
            Intrinsics.checkNotNullParameter(provider6, "clearUnreadServiceProvider");
            Intrinsics.checkNotNullParameter(provider7, "clearSessionServiceProvider");
            Intrinsics.checkNotNullParameter(provider8, "interactiveServiceProvider");
            Intrinsics.checkNotNullParameter(provider9, "accountStoreProvider");
            Intrinsics.checkNotNullParameter(provider10, "summaryServiceProvider");
            Intrinsics.checkNotNullParameter(provider11, "cacheServiceProvider");
            Intrinsics.checkNotNullParameter(provider12, "groupAssistantFetcherServiceProvider");
            return new IMSessionStateMachine_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
        }

        @JvmStatic
        public final IMSessionStateMachine newInstance(KSessionPageType pageType, IMSessionBroadcastService broadcastService, IMSessionDataSourceServiceLike dataSourceService, IMSessionUpdateService updateService, IMSessionCardEventService sessionEventService, IMClearUnreadService clearUnreadService, IMClearSessionService clearSessionService, IMSessionInteractiveService interactiveService, KAccountStore accountStore, IMSummaryCacheService summaryService, IMSessionListCacheService cacheService, IMGroupAssistantFetcherService groupAssistantFetcherService) {
            Intrinsics.checkNotNullParameter(pageType, "pageType");
            Intrinsics.checkNotNullParameter(broadcastService, "broadcastService");
            Intrinsics.checkNotNullParameter(dataSourceService, "dataSourceService");
            Intrinsics.checkNotNullParameter(updateService, "updateService");
            Intrinsics.checkNotNullParameter(sessionEventService, "sessionEventService");
            Intrinsics.checkNotNullParameter(clearUnreadService, "clearUnreadService");
            Intrinsics.checkNotNullParameter(clearSessionService, "clearSessionService");
            Intrinsics.checkNotNullParameter(accountStore, "accountStore");
            Intrinsics.checkNotNullParameter(summaryService, "summaryService");
            return new IMSessionStateMachine(pageType, broadcastService, dataSourceService, updateService, sessionEventService, clearUnreadService, clearSessionService, interactiveService, accountStore, summaryService, cacheService, groupAssistantFetcherService);
        }
    }

    @JvmStatic
    public static final IMSessionStateMachine_Factory create(Provider<KSessionPageType> provider, Provider<IMSessionBroadcastService> provider2, Provider<IMSessionDataSourceServiceLike> provider3, Provider<IMSessionUpdateService> provider4, Provider<IMSessionCardEventService> provider5, Provider<IMClearUnreadService> provider6, Provider<IMClearSessionService> provider7, Provider<IMSessionInteractiveService> provider8, Provider<KAccountStore> provider9, Provider<IMSummaryCacheService> provider10, Provider<IMSessionListCacheService> provider11, Provider<IMGroupAssistantFetcherService> provider12) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    @JvmStatic
    public static final IMSessionStateMachine newInstance(KSessionPageType pageType, IMSessionBroadcastService broadcastService, IMSessionDataSourceServiceLike dataSourceService, IMSessionUpdateService updateService, IMSessionCardEventService sessionEventService, IMClearUnreadService clearUnreadService, IMClearSessionService clearSessionService, IMSessionInteractiveService interactiveService, KAccountStore accountStore, IMSummaryCacheService summaryService, IMSessionListCacheService cacheService, IMGroupAssistantFetcherService groupAssistantFetcherService) {
        return Companion.newInstance(pageType, broadcastService, dataSourceService, updateService, sessionEventService, clearUnreadService, clearSessionService, interactiveService, accountStore, summaryService, cacheService, groupAssistantFetcherService);
    }
}