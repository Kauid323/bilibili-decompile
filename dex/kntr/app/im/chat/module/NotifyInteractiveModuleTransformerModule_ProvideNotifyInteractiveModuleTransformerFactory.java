package kntr.app.im.chat.module;

import com.bapis.bilibili.app.im.v1.KMsgModule;
import dagger.internal.Factory;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.network.MsgModuleTransformer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NotifyInteractiveModuleTransformerModule_ProvideNotifyInteractiveModuleTransformerFactory.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \b2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¨\u0006\t"}, d2 = {"Lkntr/app/im/chat/module/NotifyInteractiveModuleTransformerModule_ProvideNotifyInteractiveModuleTransformerFactory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/network/MsgModuleTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgModule$IModule;", "Lkntr/app/im/chat/core/model/MsgModule;", "<init>", "()V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotifyInteractiveModuleTransformerModule_ProvideNotifyInteractiveModuleTransformerFactory implements Factory<MsgModuleTransformer<KMsgModule.IModule, MsgModule>> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final NotifyInteractiveModuleTransformerModule_ProvideNotifyInteractiveModuleTransformerFactory INSTANCE = new NotifyInteractiveModuleTransformerModule_ProvideNotifyInteractiveModuleTransformerFactory();

    public MsgModuleTransformer<KMsgModule.IModule, MsgModule> get() {
        return Companion.provideNotifyInteractiveModuleTransformer();
    }

    /* compiled from: NotifyInteractiveModuleTransformerModule_ProvideNotifyInteractiveModuleTransformerFactory.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/im/chat/module/NotifyInteractiveModuleTransformerModule_ProvideNotifyInteractiveModuleTransformerFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "INSTANCE", "Lkntr/app/im/chat/module/NotifyInteractiveModuleTransformerModule_ProvideNotifyInteractiveModuleTransformerFactory;", "create", "provideNotifyInteractiveModuleTransformer", "Lkntr/app/im/chat/network/MsgModuleTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgModule$IModule;", "Lkntr/app/im/chat/core/model/MsgModule;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NotifyInteractiveModuleTransformerModule_ProvideNotifyInteractiveModuleTransformerFactory create() {
            return NotifyInteractiveModuleTransformerModule_ProvideNotifyInteractiveModuleTransformerFactory.INSTANCE;
        }

        @JvmStatic
        public final MsgModuleTransformer<KMsgModule.IModule, MsgModule> provideNotifyInteractiveModuleTransformer() {
            return NotifyInteractiveModuleTransformerModule.INSTANCE.provideNotifyInteractiveModuleTransformer();
        }
    }

    @JvmStatic
    public static final NotifyInteractiveModuleTransformerModule_ProvideNotifyInteractiveModuleTransformerFactory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final MsgModuleTransformer<KMsgModule.IModule, MsgModule> provideNotifyInteractiveModuleTransformer() {
        return Companion.provideNotifyInteractiveModuleTransformer();
    }
}