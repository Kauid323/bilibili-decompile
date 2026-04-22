package kntr.app.im.chat.module.localPicture;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import kntr.app.im.chat.core.di.ChatSerializationModule;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;

/* compiled from: LocalPictureSerializerModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/module/localPicture/LocalPictureSerializerModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideLocalPictureModuleSerializer", "Lkotlinx/serialization/modules/SerializersModule;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class LocalPictureSerializerModule {
    public static final int $stable = 0;
    public static final LocalPictureSerializerModule INSTANCE = new LocalPictureSerializerModule();

    private LocalPictureSerializerModule() {
    }

    @Provides
    @StringKey("KLocalPictureModule")
    @IntoMap
    @ChatSerializationModule
    public final SerializersModule provideLocalPictureModuleSerializer() {
        SerializersModuleBuilder builder$iv = new SerializersModuleBuilder();
        KClass baseClass$iv = Reflection.getOrCreateKotlinClass(MsgModule.class);
        PolymorphicModuleBuilder builder$iv2 = new PolymorphicModuleBuilder(baseClass$iv, (KSerializer) null);
        KClass clazz$iv = Reflection.getOrCreateKotlinClass(LocalPictureModule.class);
        builder$iv2.subclass(clazz$iv, LocalPictureModule.Companion.serializer());
        builder$iv2.buildTo(builder$iv);
        return builder$iv.build();
    }
}