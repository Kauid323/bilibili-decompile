package im.session.summary;

import dagger.internal.Factory;
import im.base.SessionIdConverters;
import im.session.base.IMConversationDraftService;
import javax.inject.Provider;
import kntr.app.im.chat.db.ChatDatabaseProvider;
import kntr.app.im.chat.db.SessionIdDbConverters;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionDraftServiceModule_ProvideBffSessionDraftServiceFactory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lim/session/summary/IMSessionDraftServiceModule_ProvideBffSessionDraftServiceFactory;", "Ldagger/internal/Factory;", "Lim/session/base/IMConversationDraftService;", "dbProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/db/ChatDatabaseProvider;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "sessionIdConvertersProvider", "Lim/base/SessionIdConverters;", "sessionIdDbConvertersProvider", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "session-room_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionDraftServiceModule_ProvideBffSessionDraftServiceFactory implements Factory<IMConversationDraftService> {
    public static final Companion Companion = new Companion(null);
    private final Provider<KAccountStore> accountStoreProvider;
    private final Provider<ChatDatabaseProvider> dbProvider;
    private final Provider<SessionIdConverters> sessionIdConvertersProvider;
    private final Provider<SessionIdDbConverters> sessionIdDbConvertersProvider;

    public IMSessionDraftServiceModule_ProvideBffSessionDraftServiceFactory(Provider<ChatDatabaseProvider> provider, Provider<KAccountStore> provider2, Provider<SessionIdConverters> provider3, Provider<SessionIdDbConverters> provider4) {
        Intrinsics.checkNotNullParameter(provider, "dbProvider");
        Intrinsics.checkNotNullParameter(provider2, "accountStoreProvider");
        Intrinsics.checkNotNullParameter(provider3, "sessionIdConvertersProvider");
        Intrinsics.checkNotNullParameter(provider4, "sessionIdDbConvertersProvider");
        this.dbProvider = provider;
        this.accountStoreProvider = provider2;
        this.sessionIdConvertersProvider = provider3;
        this.sessionIdDbConvertersProvider = provider4;
    }

    /* renamed from: get */
    public IMConversationDraftService m3374get() {
        Companion companion = Companion;
        Object obj = this.dbProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.accountStoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.sessionIdConvertersProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        Object obj4 = this.sessionIdDbConvertersProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
        return companion.provideBffSessionDraftService((ChatDatabaseProvider) obj, (KAccountStore) obj2, (SessionIdConverters) obj3, (SessionIdDbConverters) obj4);
    }

    /* compiled from: IMSessionDraftServiceModule_ProvideBffSessionDraftServiceFactory.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000eH\u0007¨\u0006\u0014"}, d2 = {"Lim/session/summary/IMSessionDraftServiceModule_ProvideBffSessionDraftServiceFactory$Companion;", "", "<init>", "()V", "create", "Lim/session/summary/IMSessionDraftServiceModule_ProvideBffSessionDraftServiceFactory;", "dbProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/db/ChatDatabaseProvider;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "sessionIdConvertersProvider", "Lim/base/SessionIdConverters;", "sessionIdDbConvertersProvider", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "provideBffSessionDraftService", "Lim/session/base/IMConversationDraftService;", "accountStore", "sessionIdConverters", "sessionIdDbConverters", "session-room_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IMSessionDraftServiceModule_ProvideBffSessionDraftServiceFactory create(Provider<ChatDatabaseProvider> provider, Provider<KAccountStore> provider2, Provider<SessionIdConverters> provider3, Provider<SessionIdDbConverters> provider4) {
            Intrinsics.checkNotNullParameter(provider, "dbProvider");
            Intrinsics.checkNotNullParameter(provider2, "accountStoreProvider");
            Intrinsics.checkNotNullParameter(provider3, "sessionIdConvertersProvider");
            Intrinsics.checkNotNullParameter(provider4, "sessionIdDbConvertersProvider");
            return new IMSessionDraftServiceModule_ProvideBffSessionDraftServiceFactory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final IMConversationDraftService provideBffSessionDraftService(ChatDatabaseProvider dbProvider, KAccountStore accountStore, SessionIdConverters sessionIdConverters, SessionIdDbConverters sessionIdDbConverters) {
            Intrinsics.checkNotNullParameter(dbProvider, "dbProvider");
            Intrinsics.checkNotNullParameter(accountStore, "accountStore");
            Intrinsics.checkNotNullParameter(sessionIdConverters, "sessionIdConverters");
            Intrinsics.checkNotNullParameter(sessionIdDbConverters, "sessionIdDbConverters");
            return IMSessionDraftServiceModule.INSTANCE.provideBffSessionDraftService(dbProvider, accountStore, sessionIdConverters, sessionIdDbConverters);
        }
    }

    @JvmStatic
    public static final IMSessionDraftServiceModule_ProvideBffSessionDraftServiceFactory create(Provider<ChatDatabaseProvider> provider, Provider<KAccountStore> provider2, Provider<SessionIdConverters> provider3, Provider<SessionIdDbConverters> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final IMConversationDraftService provideBffSessionDraftService(ChatDatabaseProvider dbProvider, KAccountStore accountStore, SessionIdConverters sessionIdConverters, SessionIdDbConverters sessionIdDbConverters) {
        return Companion.provideBffSessionDraftService(dbProvider, accountStore, sessionIdConverters, sessionIdDbConverters);
    }
}