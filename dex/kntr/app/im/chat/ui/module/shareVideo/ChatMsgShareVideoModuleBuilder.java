package kntr.app.im.chat.ui.module.shareVideo;

import kntr.app.im.chat.module.ShareVideoMsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilderKt;
import kntr.app.im.chat.ui.builder.ChatMsgModuleContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ShareVideoModule.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkntr/app/im/chat/ui/module/shareVideo/ChatMsgShareVideoModuleBuilder;", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/module/ShareVideoMsgModule;", "<init>", "()V", "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "buildMsgModule", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgShareVideoModuleBuilder implements ChatMsgModuleBuilder<ShareVideoMsgModule> {
    public static final int $stable = 0;
    private final KClass<ShareVideoMsgModule> acceptClass = Reflection.getOrCreateKotlinClass(ShareVideoMsgModule.class);

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder
    public KClass<ShareVideoMsgModule> getAcceptClass() {
        return this.acceptClass;
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder
    public ChatMsgModuleContent<ShareVideoMsgModule> buildMsgModule() {
        return ChatMsgModuleBuilderKt.ChatMsgModuleContent(ComposableSingletons$ShareVideoModuleKt.INSTANCE.getLambda$1251098684$ui_debug());
    }
}