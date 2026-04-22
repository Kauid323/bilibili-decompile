package kntr.app.im.chat.network;

import dagger.internal.Factory;
import im.base.config.IMConfigSetting;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatLoopFetchService_Factory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/network/ChatLoopFetchService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/network/ChatLoopFetchService;", "settingProvider", "Ljavax/inject/Provider;", "Lim/base/config/IMConfigSetting;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatLoopFetchService_Factory implements Factory<ChatLoopFetchService> {
    public static final Companion Companion = new Companion(null);
    private final Provider<IMConfigSetting> settingProvider;

    public ChatLoopFetchService_Factory(Provider<IMConfigSetting> provider) {
        Intrinsics.checkNotNullParameter(provider, "settingProvider");
        this.settingProvider = provider;
    }

    public ChatLoopFetchService get() {
        Companion companion = Companion;
        IMConfigSetting iMConfigSetting = this.settingProvider.get();
        Intrinsics.checkNotNullExpressionValue(iMConfigSetting, "get(...)");
        return companion.newInstance(iMConfigSetting);
    }

    /* compiled from: ChatLoopFetchService_Factory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/network/ChatLoopFetchService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/network/ChatLoopFetchService_Factory;", "settingProvider", "Ljavax/inject/Provider;", "Lim/base/config/IMConfigSetting;", "newInstance", "Lkntr/app/im/chat/network/ChatLoopFetchService;", "setting", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChatLoopFetchService_Factory create(Provider<IMConfigSetting> provider) {
            Intrinsics.checkNotNullParameter(provider, "settingProvider");
            return new ChatLoopFetchService_Factory(provider);
        }

        @JvmStatic
        public final ChatLoopFetchService newInstance(IMConfigSetting setting) {
            Intrinsics.checkNotNullParameter(setting, "setting");
            return new ChatLoopFetchService(setting);
        }
    }

    @JvmStatic
    public static final ChatLoopFetchService_Factory create(Provider<IMConfigSetting> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final ChatLoopFetchService newInstance(IMConfigSetting setting) {
        return Companion.newInstance(setting);
    }
}