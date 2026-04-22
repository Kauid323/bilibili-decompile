package kntr.app.im.chat.service.personal;

import com.bapis.bilibili.app.im.v1.KSessionId;
import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.im.chat.core.service.FusionChatInfoService;
import kntr.app.im.chat.di.module.personal.PersonalChat;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/im/chat/service/personal/ConversationServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/service/personal/ConversationServiceImpl;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/di/module/personal/PersonalChat;", "kSessionIdProvider", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "chatInfoServiceProvider", "Lkntr/app/im/chat/core/service/FusionChatInfoService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationServiceImpl_Factory implements Factory<ConversationServiceImpl> {
    private final Provider<FusionChatInfoService> chatInfoServiceProvider;
    private final Provider<KSessionId> kSessionIdProvider;
    private final Provider<PersonalChat> sessionIdProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ConversationServiceImpl_Factory(Provider<PersonalChat> provider, Provider<KSessionId> provider2, Provider<FusionChatInfoService> provider3) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "kSessionIdProvider");
        Intrinsics.checkNotNullParameter(provider3, "chatInfoServiceProvider");
        this.sessionIdProvider = provider;
        this.kSessionIdProvider = provider2;
        this.chatInfoServiceProvider = provider3;
    }

    public ConversationServiceImpl get() {
        Companion companion = Companion;
        PersonalChat personalChat = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(personalChat, "get(...)");
        KSessionId kSessionId = this.kSessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(kSessionId, "get(...)");
        FusionChatInfoService fusionChatInfoService = this.chatInfoServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(fusionChatInfoService, "get(...)");
        return companion.newInstance(personalChat, kSessionId, fusionChatInfoService);
    }

    /* compiled from: ConversationServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/service/personal/ConversationServiceImpl_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/service/personal/ConversationServiceImpl_Factory;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/di/module/personal/PersonalChat;", "kSessionIdProvider", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "chatInfoServiceProvider", "Lkntr/app/im/chat/core/service/FusionChatInfoService;", "newInstance", "Lkntr/app/im/chat/service/personal/ConversationServiceImpl;", "sessionId", "kSessionId", "chatInfoService", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ConversationServiceImpl_Factory create(Provider<PersonalChat> provider, Provider<KSessionId> provider2, Provider<FusionChatInfoService> provider3) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "kSessionIdProvider");
            Intrinsics.checkNotNullParameter(provider3, "chatInfoServiceProvider");
            return new ConversationServiceImpl_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final ConversationServiceImpl newInstance(PersonalChat sessionId, KSessionId kSessionId, FusionChatInfoService chatInfoService) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(kSessionId, "kSessionId");
            Intrinsics.checkNotNullParameter(chatInfoService, "chatInfoService");
            return new ConversationServiceImpl(sessionId, kSessionId, chatInfoService);
        }
    }

    @JvmStatic
    public static final ConversationServiceImpl_Factory create(Provider<PersonalChat> provider, Provider<KSessionId> provider2, Provider<FusionChatInfoService> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final ConversationServiceImpl newInstance(PersonalChat sessionId, KSessionId kSessionId, FusionChatInfoService chatInfoService) {
        return Companion.newInstance(sessionId, kSessionId, chatInfoService);
    }
}