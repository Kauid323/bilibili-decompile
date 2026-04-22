package kntr.app.im.chat.module;

import dagger.internal.Factory;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: ShareDynamicForwardModuleTransformerModule_ProvideShareDynamicForwardModuleSerializerFactory.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/module/ShareDynamicForwardModuleTransformerModule_ProvideShareDynamicForwardModuleSerializerFactory;", "Ldagger/internal/Factory;", "Lkotlinx/serialization/modules/SerializersModule;", "<init>", "()V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShareDynamicForwardModuleTransformerModule_ProvideShareDynamicForwardModuleSerializerFactory implements Factory<SerializersModule> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final ShareDynamicForwardModuleTransformerModule_ProvideShareDynamicForwardModuleSerializerFactory INSTANCE = new ShareDynamicForwardModuleTransformerModule_ProvideShareDynamicForwardModuleSerializerFactory();

    public SerializersModule get() {
        return Companion.provideShareDynamicForwardModuleSerializer();
    }

    /* compiled from: ShareDynamicForwardModuleTransformerModule_ProvideShareDynamicForwardModuleSerializerFactory.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/app/im/chat/module/ShareDynamicForwardModuleTransformerModule_ProvideShareDynamicForwardModuleSerializerFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "INSTANCE", "Lkntr/app/im/chat/module/ShareDynamicForwardModuleTransformerModule_ProvideShareDynamicForwardModuleSerializerFactory;", "create", "provideShareDynamicForwardModuleSerializer", "Lkotlinx/serialization/modules/SerializersModule;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ShareDynamicForwardModuleTransformerModule_ProvideShareDynamicForwardModuleSerializerFactory create() {
            return ShareDynamicForwardModuleTransformerModule_ProvideShareDynamicForwardModuleSerializerFactory.INSTANCE;
        }

        @JvmStatic
        public final SerializersModule provideShareDynamicForwardModuleSerializer() {
            return ShareDynamicForwardModuleTransformerModule.INSTANCE.provideShareDynamicForwardModuleSerializer();
        }
    }

    @JvmStatic
    public static final ShareDynamicForwardModuleTransformerModule_ProvideShareDynamicForwardModuleSerializerFactory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final SerializersModule provideShareDynamicForwardModuleSerializer() {
        return Companion.provideShareDynamicForwardModuleSerializer();
    }
}