package kntr.app.im.chat.db;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DatabaseService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/db/DatabaseServiceImpl;", "Lkntr/app/im/chat/db/DatabaseService;", "dbProvider", "Lkntr/app/im/chat/db/ChatDatabaseProvider;", "<init>", "(Lkntr/app/im/chat/db/ChatDatabaseProvider;)V", "db", "Lkntr/app/im/chat/db/ChatDatabase;", "getDb", "()Lkntr/app/im/chat/db/ChatDatabase;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DatabaseServiceImpl implements DatabaseService {
    private final ChatDatabaseProvider dbProvider;

    @Inject
    public DatabaseServiceImpl(ChatDatabaseProvider dbProvider) {
        Intrinsics.checkNotNullParameter(dbProvider, "dbProvider");
        this.dbProvider = dbProvider;
    }

    @Override // kntr.app.im.chat.db.DatabaseService
    public ChatDatabase getDb() {
        return this.dbProvider.getChatDatabaseForCurrentUser();
    }
}