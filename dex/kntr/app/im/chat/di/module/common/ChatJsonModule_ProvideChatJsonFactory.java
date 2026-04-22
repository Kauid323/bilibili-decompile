package kntr.app.im.chat.di.module.common;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: ChatJsonModule_ProvideChatJsonFactory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB!\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/di/module/common/ChatJsonModule_ProvideChatJsonFactory;", "Ldagger/internal/Factory;", "Lkotlinx/serialization/json/Json;", "moduleMapProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/modules/SerializersModule;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatJsonModule_ProvideChatJsonFactory implements Factory<Json> {
    private final Provider<Map<String, SerializersModule>> moduleMapProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ChatJsonModule_ProvideChatJsonFactory(Provider<Map<String, SerializersModule>> provider) {
        Intrinsics.checkNotNullParameter(provider, "moduleMapProvider");
        this.moduleMapProvider = provider;
    }

    public Json get() {
        Companion companion = Companion;
        Map<String, SerializersModule> map = this.moduleMapProvider.get();
        Intrinsics.checkNotNullExpressionValue(map, "get(...)");
        return companion.provideChatJson(map);
    }

    /* compiled from: ChatJsonModule_ProvideChatJsonFactory.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007H\u0007J\u001c\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0007¨\u0006\u000e"}, d2 = {"Lkntr/app/im/chat/di/module/common/ChatJsonModule_ProvideChatJsonFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/di/module/common/ChatJsonModule_ProvideChatJsonFactory;", "moduleMapProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/modules/SerializersModule;", "provideChatJson", "Lkotlinx/serialization/json/Json;", "moduleMap", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChatJsonModule_ProvideChatJsonFactory create(Provider<Map<String, SerializersModule>> provider) {
            Intrinsics.checkNotNullParameter(provider, "moduleMapProvider");
            return new ChatJsonModule_ProvideChatJsonFactory(provider);
        }

        @JvmStatic
        public final Json provideChatJson(Map<String, ? extends SerializersModule> map) {
            Intrinsics.checkNotNullParameter(map, "moduleMap");
            return ChatJsonModule.INSTANCE.provideChatJson(map);
        }
    }

    @JvmStatic
    public static final ChatJsonModule_ProvideChatJsonFactory create(Provider<Map<String, SerializersModule>> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final Json provideChatJson(Map<String, ? extends SerializersModule> map) {
        return Companion.provideChatJson(map);
    }
}