package kntr.app.im.chat.di.module.personal;

import com.bapis.bilibili.app.im.v1.KPrivateId;
import com.bapis.bilibili.app.im.v1.KSessionId;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import im.base.SessionIdConverter;
import im.base.model.SessionId;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.db.SessionIdDbConverter;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: PersonalSessionIdModule.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007¨\u0006\t"}, d2 = {"Lkntr/app/im/chat/di/module/personal/PersonalSessionConverterModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "bindPersonalIdDbConverter", "Lkntr/app/im/chat/db/SessionIdDbConverter;", "Lim/base/model/SessionId;", "bindPersonalIdConverter", "Lim/base/SessionIdConverter;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class PersonalSessionConverterModule {
    public static final int $stable = 0;
    public static final PersonalSessionConverterModule INSTANCE = new PersonalSessionConverterModule();

    private PersonalSessionConverterModule() {
    }

    @Provides
    @IntKey(1)
    @IntoMap
    public final SessionIdDbConverter<SessionId> bindPersonalIdDbConverter() {
        return new SessionIdDbConverter<PersonalChat>() { // from class: kntr.app.im.chat.di.module.personal.PersonalSessionConverterModule$bindPersonalIdDbConverter$1
            @Override // kntr.app.im.chat.db.SessionIdDbConverter
            public int getTypeInt() {
                return 1;
            }

            @Override // kntr.app.im.chat.db.SessionIdDbConverter
            public KClass<? extends PersonalChat> getType() {
                return Reflection.getOrCreateKotlinClass(PersonalChat.class);
            }

            @Override // kntr.app.im.chat.db.SessionIdDbConverter
            public SessionIdEntity convertToEntity(PersonalChat sessionId) {
                Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                return new SessionIdEntity(1, sessionId.getTalkerUid(), 0L, 0L, 12, null);
            }

            @Override // kntr.app.im.chat.db.SessionIdDbConverter
            public PersonalChat convertToSessionId(SessionIdEntity entity) {
                Intrinsics.checkNotNullParameter(entity, "entity");
                SessionIdEntity sessionIdEntity = entity.getSessionType() == getTypeInt() ? entity : null;
                if (sessionIdEntity != null) {
                    SessionIdEntity it = sessionIdEntity;
                    return new PersonalChat(it.getPrimaryId());
                }
                return null;
            }
        };
    }

    @Provides
    @IntKey(1)
    @IntoMap
    public final SessionIdConverter<SessionId> bindPersonalIdConverter() {
        return new SessionIdConverter<PersonalChat>() { // from class: kntr.app.im.chat.di.module.personal.PersonalSessionConverterModule$bindPersonalIdConverter$1
            public KClass<? extends KSessionId.IId> getKType() {
                return Reflection.getOrCreateKotlinClass(KSessionId.KPrivateId.class);
            }

            public KClass<? extends SessionId> getType() {
                return Reflection.getOrCreateKotlinClass(PersonalChat.class);
            }

            public PersonalChat convertToSessionId(KSessionId kSessionId) {
                Intrinsics.checkNotNullParameter(kSessionId, "kSessionId");
                KSessionId.KPrivateId id = kSessionId.getId();
                if (id instanceof KSessionId.KPrivateId) {
                    return new PersonalChat(id.getValue().getTalkerUid());
                }
                return null;
            }

            public KSessionId convertToKSessionId(PersonalChat id) {
                Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
                return new KSessionId(new KSessionId.KPrivateId(new KPrivateId(id.getTalkerUid())));
            }
        };
    }
}