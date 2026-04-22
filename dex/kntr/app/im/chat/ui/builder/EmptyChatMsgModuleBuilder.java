package kntr.app.im.chat.ui.builder;

import javax.inject.Singleton;
import kntr.app.im.chat.core.model.MsgModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ChatMsgModuleBuilder.kt */
@Singleton
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkntr/app/im/chat/ui/builder/EmptyChatMsgModuleBuilder;", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/core/model/MsgModule;", "<init>", "()V", "buildMsgModule", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent;", "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EmptyChatMsgModuleBuilder implements ChatMsgModuleBuilder<MsgModule> {
    public static final int $stable = 0;

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder
    public ChatMsgModuleContent<MsgModule> buildMsgModule() {
        ChatMsgModuleContent<MsgModule> empty = ChatMsgModuleContent.Companion.getEmpty();
        Intrinsics.checkNotNull(empty, "null cannot be cast to non-null type kntr.app.im.chat.ui.builder.ChatMsgModuleContent<kntr.app.im.chat.core.model.MsgModule>");
        return empty;
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder
    public KClass<MsgModule> getAcceptClass() {
        return Reflection.getOrCreateKotlinClass(MsgModule.class);
    }
}