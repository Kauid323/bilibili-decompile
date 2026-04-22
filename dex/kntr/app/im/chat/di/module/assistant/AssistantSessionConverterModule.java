package kntr.app.im.chat.di.module.assistant;

import com.bapis.bilibili.app.im.v1.KAssistantId;
import com.bapis.bilibili.app.im.v1.KAssistantType;
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

/* compiled from: AssistantSessionIdModule.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007¨\u0006\t"}, d2 = {"Lkntr/app/im/chat/di/module/assistant/AssistantSessionConverterModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "bindAssistantIdDbConverter", "Lkntr/app/im/chat/db/SessionIdDbConverter;", "Lim/base/model/SessionId;", "bindAssistantIdConverter", "Lim/base/SessionIdConverter;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class AssistantSessionConverterModule {
    public static final int $stable = 0;
    public static final AssistantSessionConverterModule INSTANCE = new AssistantSessionConverterModule();

    private AssistantSessionConverterModule() {
    }

    @Provides
    @IntKey(7)
    @IntoMap
    public final SessionIdDbConverter<SessionId> bindAssistantIdDbConverter() {
        return new SessionIdDbConverter<Assistant>() { // from class: kntr.app.im.chat.di.module.assistant.AssistantSessionConverterModule$bindAssistantIdDbConverter$1
            @Override // kntr.app.im.chat.db.SessionIdDbConverter
            public int getTypeInt() {
                return 7;
            }

            @Override // kntr.app.im.chat.db.SessionIdDbConverter
            public KClass<? extends Assistant> getType() {
                return Reflection.getOrCreateKotlinClass(Assistant.class);
            }

            @Override // kntr.app.im.chat.db.SessionIdDbConverter
            public SessionIdEntity convertToEntity(Assistant sessionId) {
                Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                return new SessionIdEntity(getTypeInt(), sessionId.getType().getValue(), sessionId.getAssistantId(), 0L, 8, null);
            }

            @Override // kntr.app.im.chat.db.SessionIdDbConverter
            public Assistant convertToSessionId(SessionIdEntity entity) {
                Intrinsics.checkNotNullParameter(entity, "entity");
                if ((entity.getSessionType() == getTypeInt() ? entity : null) != null) {
                    return new Assistant(KAssistantType.Companion.fromValue((int) entity.getPrimaryId()), entity.getSecondaryId());
                }
                return null;
            }
        };
    }

    @Provides
    @IntKey(7)
    @IntoMap
    public final SessionIdConverter<SessionId> bindAssistantIdConverter() {
        return new SessionIdConverter<Assistant>() { // from class: kntr.app.im.chat.di.module.assistant.AssistantSessionConverterModule$bindAssistantIdConverter$1
            public KClass<? extends KSessionId.IId> getKType() {
                return Reflection.getOrCreateKotlinClass(KSessionId.KAssistantId.class);
            }

            public KClass<? extends Assistant> getType() {
                return Reflection.getOrCreateKotlinClass(Assistant.class);
            }

            public Assistant convertToSessionId(KSessionId kSessionId) {
                Intrinsics.checkNotNullParameter(kSessionId, "kSessionId");
                KSessionId.KAssistantId id = kSessionId.getId();
                if (id instanceof KSessionId.KAssistantId) {
                    return new Assistant(id.getValue().getType(), id.getValue().getTalkerUid());
                }
                return null;
            }

            public KSessionId convertToKSessionId(Assistant id) {
                Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
                return new KSessionId(new KSessionId.KAssistantId(new KAssistantId(id.getAssistantId(), id.getType())));
            }
        };
    }
}