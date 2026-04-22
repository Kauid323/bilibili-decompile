package im.session.summary;

import dagger.Module;
import dagger.Provides;
import im.base.JsonKt;
import im.base.SessionIdConverters;
import im.session.base.IMBffSessionDraftService;
import im.session.base.IMConversationDraftService;
import kntr.app.im.chat.db.ChatDatabaseProvider;
import kntr.app.im.chat.db.SessionIdDbConverters;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMChatDatabaseDraftService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lim/session/summary/IMSessionDraftServiceModule;", "", "<init>", "()V", "provideBffSessionDraftService", "Lim/session/base/IMConversationDraftService;", "dbProvider", "Lkntr/app/im/chat/db/ChatDatabaseProvider;", "accountStore", "Lkntr/base/account/KAccountStore;", "sessionIdConverters", "Lim/base/SessionIdConverters;", "sessionIdDbConverters", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "session-room_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class IMSessionDraftServiceModule {
    public static final IMSessionDraftServiceModule INSTANCE = new IMSessionDraftServiceModule();

    private IMSessionDraftServiceModule() {
    }

    @Provides
    @IMBffSessionDraftService
    public final IMConversationDraftService provideBffSessionDraftService(ChatDatabaseProvider dbProvider, KAccountStore accountStore, SessionIdConverters sessionIdConverters, SessionIdDbConverters sessionIdDbConverters) {
        Intrinsics.checkNotNullParameter(dbProvider, "dbProvider");
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        Intrinsics.checkNotNullParameter(sessionIdConverters, "sessionIdConverters");
        Intrinsics.checkNotNullParameter(sessionIdDbConverters, "sessionIdDbConverters");
        return new IMChatDatabaseDraftService(dbProvider, accountStore, JsonKt.getBaseChatJson(), sessionIdConverters, sessionIdDbConverters);
    }
}