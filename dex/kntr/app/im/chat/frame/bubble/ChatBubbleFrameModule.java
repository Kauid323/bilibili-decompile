package kntr.app.im.chat.frame.bubble;

import com.bapis.bilibili.app.im.v1.KMsgFrame;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import kntr.app.im.chat.core.di.ChatSerializationModule;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.network.MsgFrameTransformer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;

/* compiled from: ChatBubbleFrameModule.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/frame/bubble/ChatBubbleFrameModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "bindChatBubbleFrameBuilder", "Lkntr/app/im/chat/network/MsgFrameTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame$IFrame;", "Lkntr/app/im/chat/core/model/MsgFrame;", "impl", "Lkntr/app/im/chat/frame/bubble/ChatBubbleFrameTransformer;", "bindChatBubbleFrameSerializer", "Lkotlinx/serialization/modules/SerializersModule;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ChatBubbleFrameModule {
    public static final int $stable = 0;
    public static final ChatBubbleFrameModule INSTANCE = new ChatBubbleFrameModule();

    private ChatBubbleFrameModule() {
    }

    @Provides
    @IntoMap
    @StringKey("KChatBubbleFrame")
    public final MsgFrameTransformer<KMsgFrame.IFrame, MsgFrame> bindChatBubbleFrameBuilder(ChatBubbleFrameTransformer impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        return impl;
    }

    @Provides
    @StringKey("KChatBubbleFrame")
    @IntoMap
    @ChatSerializationModule
    public final SerializersModule bindChatBubbleFrameSerializer() {
        SerializersModuleBuilder builder$iv = new SerializersModuleBuilder();
        KClass baseClass$iv = Reflection.getOrCreateKotlinClass(MsgFrame.class);
        PolymorphicModuleBuilder builder$iv2 = new PolymorphicModuleBuilder(baseClass$iv, (KSerializer) null);
        KClass clazz$iv = Reflection.getOrCreateKotlinClass(ChatBubbleFrame.class);
        builder$iv2.subclass(clazz$iv, ChatBubbleFrame.Companion.serializer());
        builder$iv2.buildTo(builder$iv);
        return builder$iv.build();
    }
}