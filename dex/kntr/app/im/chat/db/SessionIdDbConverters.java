package kntr.app.im.chat.db;

import im.base.IMLog;
import im.base.model.SessionId;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* compiled from: SessionIdDbConverter.kt */
@Singleton
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B(\b\u0007\u0012\u001d\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rR%\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/im/chat/db/SessionIdDbConverters;", RoomRecommendViewModel.EMPTY_CURSOR, "converterMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/db/SessionIdDbConverter;", "Lim/base/model/SessionId;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "(Ljava/util/Map;)V", "typeMap", "Lkotlin/reflect/KClass;", "convertToEntity", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "sessionId", "convertToSessionId", "entity", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SessionIdDbConverters {
    private final Map<Integer, SessionIdDbConverter<SessionId>> converterMap;
    private final Map<KClass<? extends SessionId>, SessionIdDbConverter<SessionId>> typeMap;

    @Inject
    public SessionIdDbConverters(Map<Integer, SessionIdDbConverter<SessionId>> map) {
        Intrinsics.checkNotNullParameter(map, "converterMap");
        this.converterMap = map;
        Iterable $this$associateBy$iv = this.converterMap.values();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            SessionIdDbConverter it = (SessionIdDbConverter) element$iv$iv;
            destination$iv$iv.put(it.getType(), element$iv$iv);
        }
        this.typeMap = destination$iv$iv;
        IMLog.Companion.i("DBSessionIdTransformer", "Registered DB SessionId transformer: " + CollectionsKt.joinToString$default(this.typeMap.entrySet(), "\n", "[", "]", 0, (CharSequence) null, new Function1() { // from class: kntr.app.im.chat.db.SessionIdDbConverters$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence _init_$lambda$0;
                _init_$lambda$0 = SessionIdDbConverters._init_$lambda$0((Map.Entry) obj);
                return _init_$lambda$0;
            }
        }, 24, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence _init_$lambda$0(Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String simpleName = ((KClass) it.getKey()).getSimpleName();
        return simpleName + " -> " + Reflection.getOrCreateKotlinClass(it.getValue().getClass()).getSimpleName() + ",";
    }

    public final SessionIdEntity convertToEntity(SessionId sessionId) {
        SessionIdEntity convertToEntity;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        SessionIdDbConverter converter = this.typeMap.get(Reflection.getOrCreateKotlinClass(sessionId.getClass()));
        return (converter == null || (convertToEntity = converter.convertToEntity(sessionId)) == null) ? new SessionIdEntity(0, 0L, 0L, 0L, 15, null) : convertToEntity;
    }

    public final SessionId convertToSessionId(SessionIdEntity entity) {
        SessionId convertToSessionId;
        Intrinsics.checkNotNullParameter(entity, "entity");
        SessionIdDbConverter converter = this.converterMap.get(Integer.valueOf(entity.getSessionType()));
        return (converter == null || (convertToSessionId = converter.convertToSessionId(entity)) == null) ? SessionId.Unknown.INSTANCE : convertToSessionId;
    }
}