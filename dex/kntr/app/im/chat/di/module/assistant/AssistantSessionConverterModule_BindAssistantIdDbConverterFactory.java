package kntr.app.im.chat.di.module.assistant;

import dagger.internal.Factory;
import im.base.model.SessionId;
import kntr.app.im.chat.db.SessionIdDbConverter;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AssistantSessionConverterModule_BindAssistantIdDbConverterFactory.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\b"}, d2 = {"Lkntr/app/im/chat/di/module/assistant/AssistantSessionConverterModule_BindAssistantIdDbConverterFactory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/db/SessionIdDbConverter;", "Lim/base/model/SessionId;", "<init>", "()V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssistantSessionConverterModule_BindAssistantIdDbConverterFactory implements Factory<SessionIdDbConverter<SessionId>> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final AssistantSessionConverterModule_BindAssistantIdDbConverterFactory INSTANCE = new AssistantSessionConverterModule_BindAssistantIdDbConverterFactory();

    public SessionIdDbConverter<SessionId> get() {
        return Companion.bindAssistantIdDbConverter();
    }

    /* compiled from: AssistantSessionConverterModule_BindAssistantIdDbConverterFactory.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/di/module/assistant/AssistantSessionConverterModule_BindAssistantIdDbConverterFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "INSTANCE", "Lkntr/app/im/chat/di/module/assistant/AssistantSessionConverterModule_BindAssistantIdDbConverterFactory;", "create", "bindAssistantIdDbConverter", "Lkntr/app/im/chat/db/SessionIdDbConverter;", "Lim/base/model/SessionId;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AssistantSessionConverterModule_BindAssistantIdDbConverterFactory create() {
            return AssistantSessionConverterModule_BindAssistantIdDbConverterFactory.INSTANCE;
        }

        @JvmStatic
        public final SessionIdDbConverter<SessionId> bindAssistantIdDbConverter() {
            return AssistantSessionConverterModule.INSTANCE.bindAssistantIdDbConverter();
        }
    }

    @JvmStatic
    public static final AssistantSessionConverterModule_BindAssistantIdDbConverterFactory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final SessionIdDbConverter<SessionId> bindAssistantIdDbConverter() {
        return Companion.bindAssistantIdDbConverter();
    }
}