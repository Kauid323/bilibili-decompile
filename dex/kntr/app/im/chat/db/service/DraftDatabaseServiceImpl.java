package kntr.app.im.chat.db.service;

import javax.inject.Inject;
import kntr.app.im.chat.core.service.DraftDatabaseService;
import kntr.app.im.chat.db.DatabaseService;
import kntr.app.im.chat.db.dao.DraftDao;
import kntr.app.im.chat.db.entity.DraftEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: DraftDatabaseServiceImpl.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/app/im/chat/db/service/DraftDatabaseServiceImpl;", "Lkntr/app/im/chat/core/service/DraftDatabaseService;", "json", "Lkotlinx/serialization/json/Json;", "session", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "databaseService", "Lkntr/app/im/chat/db/DatabaseService;", "<init>", "(Lkotlinx/serialization/json/Json;Lkntr/app/im/chat/db/entity/SessionIdEntity;Lkntr/app/im/chat/db/DatabaseService;)V", "draftDao", "Lkntr/app/im/chat/db/dao/DraftDao;", "add", RoomRecommendViewModel.EMPTY_CURSOR, "content", "Lkntr/app/im/chat/db/model/InputBoxContent;", "(Lkntr/app/im/chat/db/model/InputBoxContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "query", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DraftDatabaseServiceImpl implements DraftDatabaseService {
    private final DraftDao draftDao;
    private final Json json;
    private final SessionIdEntity session;

    @Inject
    public DraftDatabaseServiceImpl(Json json, SessionIdEntity session, DatabaseService databaseService) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(databaseService, "databaseService");
        this.json = json;
        this.session = session;
        this.draftDao = databaseService.getDb().draftDao();
    }

    @Override // kntr.app.im.chat.core.service.DraftDatabaseService
    public Object add(InputBoxContent content, Continuation<? super Unit> continuation) {
        Object upsert = this.draftDao.upsert(DraftEntity.Companion.build(this.json, this.session, content), continuation);
        return upsert == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? upsert : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d A[ORIG_RETURN, RETURN] */
    @Override // kntr.app.im.chat.core.service.DraftDatabaseService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object query(Continuation<? super InputBoxContent> continuation) {
        DraftDatabaseServiceImpl$query$1 draftDatabaseServiceImpl$query$1;
        Object query;
        DraftEntity draftEntity;
        if (continuation instanceof DraftDatabaseServiceImpl$query$1) {
            draftDatabaseServiceImpl$query$1 = (DraftDatabaseServiceImpl$query$1) continuation;
            if ((draftDatabaseServiceImpl$query$1.label & Integer.MIN_VALUE) != 0) {
                draftDatabaseServiceImpl$query$1.label -= Integer.MIN_VALUE;
                Object $result = draftDatabaseServiceImpl$query$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (draftDatabaseServiceImpl$query$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        DraftDao draftDao = this.draftDao;
                        SessionIdEntity sessionIdEntity = this.session;
                        draftDatabaseServiceImpl$query$1.label = 1;
                        query = draftDao.query(sessionIdEntity, draftDatabaseServiceImpl$query$1);
                        if (query == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        query = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                draftEntity = (DraftEntity) query;
                if (draftEntity == null) {
                    return draftEntity.getContent(this.json);
                }
                return null;
            }
        }
        draftDatabaseServiceImpl$query$1 = new DraftDatabaseServiceImpl$query$1(this, continuation);
        Object $result2 = draftDatabaseServiceImpl$query$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (draftDatabaseServiceImpl$query$1.label) {
        }
        draftEntity = (DraftEntity) query;
        if (draftEntity == null) {
        }
    }

    @Override // kntr.app.im.chat.core.service.DraftDatabaseService
    public Object remove(Continuation<? super Unit> continuation) {
        Object deleteDraft = this.draftDao.deleteDraft(this.session, continuation);
        return deleteDraft == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteDraft : Unit.INSTANCE;
    }
}