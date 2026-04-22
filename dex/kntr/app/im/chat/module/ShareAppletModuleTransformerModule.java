package kntr.app.im.chat.module;

import com.bapis.bilibili.app.im.v1.KMsgModule;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import kntr.app.im.chat.core.di.ChatSerializationModule;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.network.MsgModuleTransformer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;

/* compiled from: ShareAppletModuleTransformer.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007J\b\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/module/ShareAppletModuleTransformerModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideShareAppletModuleTransformer", "Lkntr/app/im/chat/network/MsgModuleTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgModule$IModule;", "Lkntr/app/im/chat/core/model/MsgModule;", "provideShareAppletModuleSerializer", "Lkotlinx/serialization/modules/SerializersModule;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ShareAppletModuleTransformerModule {
    public static final int $stable = 0;
    public static final ShareAppletModuleTransformerModule INSTANCE = new ShareAppletModuleTransformerModule();

    private ShareAppletModuleTransformerModule() {
    }

    @Provides
    @IntoMap
    @StringKey("KShareAppletModule")
    public final MsgModuleTransformer<KMsgModule.IModule, MsgModule> provideShareAppletModuleTransformer() {
        return new ShareAppletModuleTransformer();
    }

    @Provides
    @StringKey("KShareAppletModule")
    @IntoMap
    @ChatSerializationModule
    public final SerializersModule provideShareAppletModuleSerializer() {
        SerializersModuleBuilder builder$iv = new SerializersModuleBuilder();
        KClass baseClass$iv = Reflection.getOrCreateKotlinClass(MsgModule.class);
        PolymorphicModuleBuilder builder$iv2 = new PolymorphicModuleBuilder(baseClass$iv, (KSerializer) null);
        KClass clazz$iv = Reflection.getOrCreateKotlinClass(ShareAppletMsgModule.class);
        builder$iv2.subclass(clazz$iv, ShareAppletMsgModule.Companion.serializer());
        builder$iv2.buildTo(builder$iv);
        return builder$iv.build();
    }
}