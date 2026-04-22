package kntr.app.im.chat.ui.builder;

import im.base.IMLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.ui.di.DefaultChatMsgFrameBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* compiled from: ChatMsgFrameBuilder.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B@\u0012\u001d\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u00052\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0012H\u0097\u0002R\u001c\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0011\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0012\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilderProviderImpl;", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilderProvider;", "map", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilder;", "Lkntr/app/im/chat/core/model/MsgFrame;", "Lkotlin/jvm/JvmSuppressWildcards;", "defaultBuilder", "timeLabelBuilder", "Lkntr/app/im/chat/ui/builder/ChatTimeLabelBuilder;", "<init>", "(Ljava/util/Map;Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilder;Lkntr/app/im/chat/ui/builder/ChatTimeLabelBuilder;)V", "getDefaultBuilder", "()Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilder;", "getTimeLabelBuilder", "()Lkntr/app/im/chat/ui/builder/ChatTimeLabelBuilder;", "typeMap", "Lkotlin/reflect/KClass;", "get", "type", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgFrameBuilderProviderImpl implements ChatMsgFrameBuilderProvider {
    public static final int $stable = 0;
    private final ChatMsgFrameBuilder<? super MsgFrame> defaultBuilder;
    private final ChatTimeLabelBuilder timeLabelBuilder;
    private final Map<KClass<MsgFrame>, ChatMsgFrameBuilder<MsgFrame>> typeMap;

    public ChatMsgFrameBuilderProviderImpl(Map<String, ChatMsgFrameBuilder<MsgFrame>> map, @DefaultChatMsgFrameBuilder ChatMsgFrameBuilder<? super MsgFrame> chatMsgFrameBuilder, ChatTimeLabelBuilder timeLabelBuilder) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(chatMsgFrameBuilder, "defaultBuilder");
        Intrinsics.checkNotNullParameter(timeLabelBuilder, "timeLabelBuilder");
        this.defaultBuilder = chatMsgFrameBuilder;
        this.timeLabelBuilder = timeLabelBuilder;
        Iterable $this$associateBy$iv = map.values();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            ChatMsgFrameBuilder it = (ChatMsgFrameBuilder) element$iv$iv;
            destination$iv$iv.put(it.getAcceptClass(), element$iv$iv);
        }
        this.typeMap = destination$iv$iv;
        IMLog.Companion.i("ChatMsgFrameUIBuilderProvider", "Registered ChatMsg Frame UI Builder provider: " + CollectionsKt.joinToString$default(this.typeMap.values(), "\n", "[", "]", 0, (CharSequence) null, new Function1() { // from class: kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderProviderImpl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence _init_$lambda$0;
                _init_$lambda$0 = ChatMsgFrameBuilderProviderImpl._init_$lambda$0((ChatMsgFrameBuilder) obj);
                return _init_$lambda$0;
            }
        }, 24, (Object) null));
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderProvider
    public ChatMsgFrameBuilder<? super MsgFrame> getDefaultBuilder() {
        return this.defaultBuilder;
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderProvider
    public ChatTimeLabelBuilder getTimeLabelBuilder() {
        return this.timeLabelBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence _init_$lambda$0(ChatMsgFrameBuilder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String simpleName = it.getAcceptClass().getSimpleName();
        return simpleName + " -> " + Reflection.getOrCreateKotlinClass(it.getClass()).getSimpleName() + ",";
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderProvider
    public ChatMsgFrameBuilder<? super MsgFrame> get(KClass<? extends MsgFrame> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        ChatMsgFrameBuilder result = this.typeMap.get(kClass);
        return result == null ? getDefaultBuilder() : result;
    }
}