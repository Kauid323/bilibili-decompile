package kntr.app.im.chat.ui.builder;

import im.base.IMLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.ui.di.DefaultChatMsgModuleBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* compiled from: ChatMsgModuleBuilder.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B8\u0012\u001d\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000eH\u0097\u0002R\u001c\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR+\u0010\r\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProviderImpl;", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;", "map", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/core/model/MsgModule;", "Lkotlin/jvm/JvmSuppressWildcards;", "defaultBuilder", "<init>", "(Ljava/util/Map;Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;)V", "getDefaultBuilder", "()Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "builderMap", "Lkotlin/reflect/KClass;", "get", "type", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgModuleBuilderProviderImpl implements ChatMsgModuleBuilderProvider {
    public static final int $stable = 0;
    private final Map<KClass<MsgModule>, ChatMsgModuleBuilder<MsgModule>> builderMap;
    private final ChatMsgModuleBuilder<? super MsgModule> defaultBuilder;

    public ChatMsgModuleBuilderProviderImpl(Map<String, ChatMsgModuleBuilder<MsgModule>> map, @DefaultChatMsgModuleBuilder ChatMsgModuleBuilder<? super MsgModule> chatMsgModuleBuilder) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(chatMsgModuleBuilder, "defaultBuilder");
        this.defaultBuilder = chatMsgModuleBuilder;
        IMLog.Companion.i("ChatMsgModuleUIBuilderProvider", "Registered ChatMsgModuleUI Builder provider: " + CollectionsKt.joinToString$default(map.entrySet(), "\n", "[", "]", 0, (CharSequence) null, new Function1() { // from class: kntr.app.im.chat.ui.builder.ChatMsgModuleBuilderProviderImpl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence _init_$lambda$0;
                _init_$lambda$0 = ChatMsgModuleBuilderProviderImpl._init_$lambda$0((Map.Entry) obj);
                return _init_$lambda$0;
            }
        }, 24, (Object) null));
        Iterable $this$associateBy$iv = map.values();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            ChatMsgModuleBuilder it = (ChatMsgModuleBuilder) element$iv$iv;
            destination$iv$iv.put(it.getAcceptClass(), element$iv$iv);
        }
        this.builderMap = destination$iv$iv;
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilderProvider
    public ChatMsgModuleBuilder<? super MsgModule> getDefaultBuilder() {
        return this.defaultBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence _init_$lambda$0(Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object key = it.getKey();
        return key + " -> " + Reflection.getOrCreateKotlinClass(it.getValue().getClass()).getSimpleName() + ",";
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilderProvider
    public ChatMsgModuleBuilder<MsgModule> get(KClass<? extends MsgModule> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        ChatMsgModuleBuilder result = this.builderMap.get(kClass);
        return result == null ? getDefaultBuilder() : result;
    }
}