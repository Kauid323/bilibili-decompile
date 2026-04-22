package kntr.app.im.chat.di.module.common;

import com.bapis.bilibili.app.im.v1.KMsgFrame;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import java.util.Map;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.im.chat.core.di.ChatSerializationModule;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.core.model.UnknownFrame;
import kntr.app.im.chat.network.MsgFrameTransformer;
import kntr.app.im.chat.network.MsgFrameTransformers;
import kntr.app.im.chat.utils.UnknownFrameTransformer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;

/* compiled from: MsgFrameModuleSet.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f0\u0007H\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/di/module/common/MsgFrameTransformerModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "providesMsgFrameTransformer", "Lkntr/app/im/chat/network/MsgFrameTransformers;", "map", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/network/MsgFrameTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame$IFrame;", "Lkntr/app/im/chat/core/model/MsgFrame;", "Lkotlin/jvm/JvmSuppressWildcards;", "provideUnknownFrameSerializer", "Lkotlinx/serialization/modules/SerializersModule;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class MsgFrameTransformerModule {
    public static final int $stable = 0;
    public static final MsgFrameTransformerModule INSTANCE = new MsgFrameTransformerModule();

    private MsgFrameTransformerModule() {
    }

    @Provides
    @ChatScope
    public final MsgFrameTransformers providesMsgFrameTransformer(Map<String, MsgFrameTransformer<KMsgFrame.IFrame, MsgFrame>> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return new MsgFrameTransformers(map, new UnknownFrameTransformer());
    }

    @Provides
    @StringKey("UnknownFrame")
    @IntoMap
    @ChatSerializationModule
    public final SerializersModule provideUnknownFrameSerializer() {
        SerializersModuleBuilder builder$iv = new SerializersModuleBuilder();
        KClass baseClass$iv = Reflection.getOrCreateKotlinClass(MsgFrame.class);
        PolymorphicModuleBuilder builder$iv2 = new PolymorphicModuleBuilder(baseClass$iv, (KSerializer) null);
        KClass clazz$iv = Reflection.getOrCreateKotlinClass(UnknownFrame.class);
        builder$iv2.subclass(clazz$iv, UnknownFrame.INSTANCE.serializer());
        builder$iv2.buildTo(builder$iv);
        return builder$iv.build();
    }
}