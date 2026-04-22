package kntr.app.im.chat.db.service;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.im.chat.db.DatabaseService;
import kntr.app.im.chat.db.SessionIdDbConverters;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: MessageDatabaseServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/db/service/MessageDatabaseServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/db/service/MessageDatabaseServiceImpl;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "jsonProvider", "Lkotlinx/serialization/json/Json;", "databaseServiceProvider", "Lkntr/app/im/chat/db/DatabaseService;", "sessionIdDbConvertersProvider", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessageDatabaseServiceImpl_Factory implements Factory<MessageDatabaseServiceImpl> {
    public static final Companion Companion = new Companion(null);
    private final Provider<DatabaseService> databaseServiceProvider;
    private final Provider<Json> jsonProvider;
    private final Provider<SessionIdDbConverters> sessionIdDbConvertersProvider;
    private final Provider<SessionIdEntity> sessionIdProvider;

    public MessageDatabaseServiceImpl_Factory(Provider<SessionIdEntity> provider, Provider<Json> provider2, Provider<DatabaseService> provider3, Provider<SessionIdDbConverters> provider4) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "jsonProvider");
        Intrinsics.checkNotNullParameter(provider3, "databaseServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "sessionIdDbConvertersProvider");
        this.sessionIdProvider = provider;
        this.jsonProvider = provider2;
        this.databaseServiceProvider = provider3;
        this.sessionIdDbConvertersProvider = provider4;
    }

    public MessageDatabaseServiceImpl get() {
        Companion companion = Companion;
        SessionIdEntity sessionIdEntity = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionIdEntity, "get(...)");
        Json json = this.jsonProvider.get();
        Intrinsics.checkNotNullExpressionValue(json, "get(...)");
        DatabaseService databaseService = this.databaseServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(databaseService, "get(...)");
        SessionIdDbConverters sessionIdDbConverters = this.sessionIdDbConvertersProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionIdDbConverters, "get(...)");
        return companion.newInstance(sessionIdEntity, json, databaseService, sessionIdDbConverters);
    }

    /* compiled from: MessageDatabaseServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/db/service/MessageDatabaseServiceImpl_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/db/service/MessageDatabaseServiceImpl_Factory;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "jsonProvider", "Lkotlinx/serialization/json/Json;", "databaseServiceProvider", "Lkntr/app/im/chat/db/DatabaseService;", "sessionIdDbConvertersProvider", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "newInstance", "Lkntr/app/im/chat/db/service/MessageDatabaseServiceImpl;", "sessionId", "json", "databaseService", "sessionIdDbConverters", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MessageDatabaseServiceImpl_Factory create(Provider<SessionIdEntity> provider, Provider<Json> provider2, Provider<DatabaseService> provider3, Provider<SessionIdDbConverters> provider4) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "jsonProvider");
            Intrinsics.checkNotNullParameter(provider3, "databaseServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "sessionIdDbConvertersProvider");
            return new MessageDatabaseServiceImpl_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final MessageDatabaseServiceImpl newInstance(SessionIdEntity sessionId, Json json, DatabaseService databaseService, SessionIdDbConverters sessionIdDbConverters) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(databaseService, "databaseService");
            Intrinsics.checkNotNullParameter(sessionIdDbConverters, "sessionIdDbConverters");
            return new MessageDatabaseServiceImpl(sessionId, json, databaseService, sessionIdDbConverters);
        }
    }

    @JvmStatic
    public static final MessageDatabaseServiceImpl_Factory create(Provider<SessionIdEntity> provider, Provider<Json> provider2, Provider<DatabaseService> provider3, Provider<SessionIdDbConverters> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final MessageDatabaseServiceImpl newInstance(SessionIdEntity sessionId, Json json, DatabaseService databaseService, SessionIdDbConverters sessionIdDbConverters) {
        return Companion.newInstance(sessionId, json, databaseService, sessionIdDbConverters);
    }
}