package kntr.app.im.chat.di.module.common;

import com.bapis.bilibili.app.im.v1.KMsgModule;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.network.MsgModuleTransformer;
import kntr.app.im.chat.network.MsgModuleTransformers;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MsgModuleTransformerModule_ProvideModuleTransformerFactory.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB-\u0012$\u0010\u0003\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u00050\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R,\u0010\u0003\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/im/chat/di/module/common/MsgModuleTransformerModule_ProvideModuleTransformerFactory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/network/MsgModuleTransformers;", "mapProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/network/MsgModuleTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgModule$IModule;", "Lkntr/app/im/chat/core/model/MsgModule;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MsgModuleTransformerModule_ProvideModuleTransformerFactory implements Factory<MsgModuleTransformers> {
    private final Provider<Map<String, MsgModuleTransformer<KMsgModule.IModule, MsgModule>>> mapProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public MsgModuleTransformerModule_ProvideModuleTransformerFactory(Provider<Map<String, MsgModuleTransformer<KMsgModule.IModule, MsgModule>>> provider) {
        Intrinsics.checkNotNullParameter(provider, "mapProvider");
        this.mapProvider = provider;
    }

    public MsgModuleTransformers get() {
        Companion companion = Companion;
        Map<String, MsgModuleTransformer<KMsgModule.IModule, MsgModule>> map = this.mapProvider.get();
        Intrinsics.checkNotNullExpressionValue(map, "get(...)");
        return companion.provideModuleTransformer(map);
    }

    /* compiled from: MsgModuleTransformerModule_ProvideModuleTransformerFactory.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052$\u0010\u0006\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\b0\u0007H\u0007J(\u0010\r\u001a\u00020\u000e2\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\bH\u0007¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/di/module/common/MsgModuleTransformerModule_ProvideModuleTransformerFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/di/module/common/MsgModuleTransformerModule_ProvideModuleTransformerFactory;", "mapProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/network/MsgModuleTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgModule$IModule;", "Lkntr/app/im/chat/core/model/MsgModule;", "provideModuleTransformer", "Lkntr/app/im/chat/network/MsgModuleTransformers;", "map", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MsgModuleTransformerModule_ProvideModuleTransformerFactory create(Provider<Map<String, MsgModuleTransformer<KMsgModule.IModule, MsgModule>>> provider) {
            Intrinsics.checkNotNullParameter(provider, "mapProvider");
            return new MsgModuleTransformerModule_ProvideModuleTransformerFactory(provider);
        }

        @JvmStatic
        public final MsgModuleTransformers provideModuleTransformer(Map<String, ? extends MsgModuleTransformer<KMsgModule.IModule, MsgModule>> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            return MsgModuleTransformerModule.INSTANCE.provideModuleTransformer(map);
        }
    }

    @JvmStatic
    public static final MsgModuleTransformerModule_ProvideModuleTransformerFactory create(Provider<Map<String, MsgModuleTransformer<KMsgModule.IModule, MsgModule>>> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final MsgModuleTransformers provideModuleTransformer(Map<String, ? extends MsgModuleTransformer<KMsgModule.IModule, MsgModule>> map) {
        return Companion.provideModuleTransformer(map);
    }
}