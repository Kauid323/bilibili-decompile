package kntr.app.im.chat.di.module.common;

import dagger.Module;
import dagger.Provides;
import im.base.JsonKt;
import java.util.Map;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.im.chat.core.di.ChatSerializationModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;

/* compiled from: ChatJsonModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\u0019\b\u0001\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\t\u0012\u00070\t¢\u0006\u0002\b\n0\u0007H\u0007¨\u0006\u000b"}, d2 = {"Lkntr/app/im/chat/di/module/common/ChatJsonModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideChatJson", "Lkotlinx/serialization/json/Json;", "moduleMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/modules/SerializersModule;", "Lkotlin/jvm/JvmSuppressWildcards;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ChatJsonModule {
    public static final int $stable = 0;
    public static final ChatJsonModule INSTANCE = new ChatJsonModule();

    private ChatJsonModule() {
    }

    @Provides
    @ChatScope
    public final Json provideChatJson(@ChatSerializationModule final Map<String, SerializersModule> map) {
        Intrinsics.checkNotNullParameter(map, "moduleMap");
        return JsonKt.buildBaseChatJson(new Function1() { // from class: kntr.app.im.chat.di.module.common.ChatJsonModule$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit provideChatJson$lambda$0;
                provideChatJson$lambda$0 = ChatJsonModule.provideChatJson$lambda$0(map, (JsonBuilder) obj);
                return provideChatJson$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit provideChatJson$lambda$0(Map $moduleMap, JsonBuilder $this$buildBaseChatJson) {
        Intrinsics.checkNotNullParameter($this$buildBaseChatJson, "$this$buildBaseChatJson");
        SerializersModuleBuilder builder$iv = new SerializersModuleBuilder();
        Iterable $this$forEach$iv = $moduleMap.values();
        for (Object element$iv : $this$forEach$iv) {
            SerializersModule module = (SerializersModule) element$iv;
            builder$iv.include(module);
        }
        $this$buildBaseChatJson.setSerializersModule(builder$iv.build());
        return Unit.INSTANCE;
    }
}