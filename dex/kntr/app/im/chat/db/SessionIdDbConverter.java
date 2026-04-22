package kntr.app.im.chat.db;

import im.base.model.SessionId;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* compiled from: SessionIdDbConverter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0017\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\rH&¢\u0006\u0002\u0010\u0012R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/db/SessionIdDbConverter;", "ID", "Lim/base/model/SessionId;", RoomRecommendViewModel.EMPTY_CURSOR, "typeInt", RoomRecommendViewModel.EMPTY_CURSOR, "getTypeInt", "()I", "type", "Lkotlin/reflect/KClass;", "getType", "()Lkotlin/reflect/KClass;", "convertToEntity", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "sessionId", "(Lim/base/model/SessionId;)Lkntr/app/im/chat/db/entity/SessionIdEntity;", "convertToSessionId", "entity", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;)Lim/base/model/SessionId;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SessionIdDbConverter<ID extends SessionId> {
    SessionIdEntity convertToEntity(ID id);

    ID convertToSessionId(SessionIdEntity sessionIdEntity);

    KClass<? extends ID> getType();

    int getTypeInt();
}