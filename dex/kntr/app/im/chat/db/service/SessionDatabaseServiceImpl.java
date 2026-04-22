package kntr.app.im.chat.db.service;

import im.base.model.SessionId;
import javax.inject.Inject;
import kntr.app.im.chat.core.service.SessionDatabaseService;
import kntr.app.im.chat.db.DatabaseService;
import kntr.app.im.chat.db.SessionIdDbConverters;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionDatabaseServiceImpl.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/im/chat/db/service/SessionDatabaseServiceImpl;", "Lkntr/app/im/chat/core/service/SessionDatabaseService;", "databaseService", "Lkntr/app/im/chat/db/DatabaseService;", "sessionIdDbConverters", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "<init>", "(Lkntr/app/im/chat/db/DatabaseService;Lkntr/app/im/chat/db/SessionIdDbConverters;)V", "initSession", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", "Lim/base/model/SessionId;", "(Lim/base/model/SessionId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SessionDatabaseServiceImpl implements SessionDatabaseService {
    private final DatabaseService databaseService;
    private final SessionIdDbConverters sessionIdDbConverters;

    @Inject
    public SessionDatabaseServiceImpl(DatabaseService databaseService, SessionIdDbConverters sessionIdDbConverters) {
        Intrinsics.checkNotNullParameter(databaseService, "databaseService");
        Intrinsics.checkNotNullParameter(sessionIdDbConverters, "sessionIdDbConverters");
        this.databaseService = databaseService;
        this.sessionIdDbConverters = sessionIdDbConverters;
    }

    @Override // kntr.app.im.chat.core.service.SessionDatabaseService
    public Object initSession(SessionId sessionId, Continuation<? super Unit> continuation) {
        Object insert = this.databaseService.getDb().sessionIdDao().insert(this.sessionIdDbConverters.convertToEntity(sessionId), continuation);
        return insert == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? insert : Unit.INSTANCE;
    }
}