package kntr.app.im.chat.ui.page;

import dagger.internal.Factory;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CommonMsgModuleSet_BindDefaultChatMsgModuleBuilderFactory.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u0002H\u0016¨\u0006\b"}, d2 = {"Lkntr/app/im/chat/ui/page/CommonMsgModuleSet_BindDefaultChatMsgModuleBuilderFactory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/core/model/MsgModule;", "<init>", "()V", "get", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommonMsgModuleSet_BindDefaultChatMsgModuleBuilderFactory implements Factory<ChatMsgModuleBuilder<? super MsgModule>> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final CommonMsgModuleSet_BindDefaultChatMsgModuleBuilderFactory INSTANCE = new CommonMsgModuleSet_BindDefaultChatMsgModuleBuilderFactory();

    public ChatMsgModuleBuilder<? super MsgModule> get() {
        return Companion.bindDefaultChatMsgModuleBuilder();
    }

    /* compiled from: CommonMsgModuleSet_BindDefaultChatMsgModuleBuilderFactory.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00020\t0\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/ui/page/CommonMsgModuleSet_BindDefaultChatMsgModuleBuilderFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "INSTANCE", "Lkntr/app/im/chat/ui/page/CommonMsgModuleSet_BindDefaultChatMsgModuleBuilderFactory;", "create", "bindDefaultChatMsgModuleBuilder", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/core/model/MsgModule;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CommonMsgModuleSet_BindDefaultChatMsgModuleBuilderFactory create() {
            return CommonMsgModuleSet_BindDefaultChatMsgModuleBuilderFactory.INSTANCE;
        }

        @JvmStatic
        public final ChatMsgModuleBuilder<? super MsgModule> bindDefaultChatMsgModuleBuilder() {
            return CommonMsgModuleSet.INSTANCE.bindDefaultChatMsgModuleBuilder();
        }
    }

    @JvmStatic
    public static final CommonMsgModuleSet_BindDefaultChatMsgModuleBuilderFactory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final ChatMsgModuleBuilder<? super MsgModule> bindDefaultChatMsgModuleBuilder() {
        return Companion.bindDefaultChatMsgModuleBuilder();
    }
}