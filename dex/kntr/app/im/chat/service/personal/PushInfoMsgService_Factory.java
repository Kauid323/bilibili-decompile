package kntr.app.im.chat.service.personal;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.db.DatabaseService;
import kntr.app.im.chat.db.SessionIdDbConverters;
import kntr.app.im.chat.di.module.personal.PersonalChat;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushInfoMsgService_Factory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/service/personal/PushInfoMsgService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/service/personal/PushInfoMsgService;", "dbConvertersProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "databaseServiceProvider", "Lkntr/app/im/chat/db/DatabaseService;", "sessionIdProvider", "Lkntr/app/im/chat/di/module/personal/PersonalChat;", "messageDatabaseServiceProvider", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PushInfoMsgService_Factory implements Factory<PushInfoMsgService> {
    private final Provider<DatabaseService> databaseServiceProvider;
    private final Provider<SessionIdDbConverters> dbConvertersProvider;
    private final Provider<MessageDatabaseService> messageDatabaseServiceProvider;
    private final Provider<PersonalChat> sessionIdProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public PushInfoMsgService_Factory(Provider<SessionIdDbConverters> provider, Provider<DatabaseService> provider2, Provider<PersonalChat> provider3, Provider<MessageDatabaseService> provider4) {
        Intrinsics.checkNotNullParameter(provider, "dbConvertersProvider");
        Intrinsics.checkNotNullParameter(provider2, "databaseServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider4, "messageDatabaseServiceProvider");
        this.dbConvertersProvider = provider;
        this.databaseServiceProvider = provider2;
        this.sessionIdProvider = provider3;
        this.messageDatabaseServiceProvider = provider4;
    }

    public PushInfoMsgService get() {
        Companion companion = Companion;
        SessionIdDbConverters sessionIdDbConverters = this.dbConvertersProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionIdDbConverters, "get(...)");
        DatabaseService databaseService = this.databaseServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(databaseService, "get(...)");
        PersonalChat personalChat = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(personalChat, "get(...)");
        MessageDatabaseService messageDatabaseService = this.messageDatabaseServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(messageDatabaseService, "get(...)");
        return companion.newInstance(sessionIdDbConverters, databaseService, personalChat, messageDatabaseService);
    }

    /* compiled from: PushInfoMsgService_Factory.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/service/personal/PushInfoMsgService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/service/personal/PushInfoMsgService_Factory;", "dbConvertersProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "databaseServiceProvider", "Lkntr/app/im/chat/db/DatabaseService;", "sessionIdProvider", "Lkntr/app/im/chat/di/module/personal/PersonalChat;", "messageDatabaseServiceProvider", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "newInstance", "Lkntr/app/im/chat/service/personal/PushInfoMsgService;", "dbConverters", "databaseService", "sessionId", "messageDatabaseService", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PushInfoMsgService_Factory create(Provider<SessionIdDbConverters> provider, Provider<DatabaseService> provider2, Provider<PersonalChat> provider3, Provider<MessageDatabaseService> provider4) {
            Intrinsics.checkNotNullParameter(provider, "dbConvertersProvider");
            Intrinsics.checkNotNullParameter(provider2, "databaseServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider4, "messageDatabaseServiceProvider");
            return new PushInfoMsgService_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final PushInfoMsgService newInstance(SessionIdDbConverters dbConverters, DatabaseService databaseService, PersonalChat sessionId, MessageDatabaseService messageDatabaseService) {
            Intrinsics.checkNotNullParameter(dbConverters, "dbConverters");
            Intrinsics.checkNotNullParameter(databaseService, "databaseService");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(messageDatabaseService, "messageDatabaseService");
            return new PushInfoMsgService(dbConverters, databaseService, sessionId, messageDatabaseService);
        }
    }

    @JvmStatic
    public static final PushInfoMsgService_Factory create(Provider<SessionIdDbConverters> provider, Provider<DatabaseService> provider2, Provider<PersonalChat> provider3, Provider<MessageDatabaseService> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final PushInfoMsgService newInstance(SessionIdDbConverters dbConverters, DatabaseService databaseService, PersonalChat sessionId, MessageDatabaseService messageDatabaseService) {
        return Companion.newInstance(dbConverters, databaseService, sessionId, messageDatabaseService);
    }
}