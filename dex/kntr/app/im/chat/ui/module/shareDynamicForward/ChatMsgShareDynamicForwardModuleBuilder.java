package kntr.app.im.chat.ui.module.shareDynamicForward;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import javax.inject.Inject;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.ShareDynamicForwardMsgModule;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilderKt;
import kntr.app.im.chat.ui.builder.ChatMsgModuleContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ChatMsgShareDynamicForwardModuleBuilder.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkntr/app/im/chat/ui/module/shareDynamicForward/ChatMsgShareDynamicForwardModuleBuilder;", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/module/ShareDynamicForwardMsgModule;", "chatActionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "<init>", "(Lkntr/app/im/chat/ui/ChatActionHandler;)V", "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "buildMsgModule", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgShareDynamicForwardModuleBuilder implements ChatMsgModuleBuilder<ShareDynamicForwardMsgModule> {
    public static final int $stable = 0;
    private final KClass<ShareDynamicForwardMsgModule> acceptClass;
    private final ChatActionHandler chatActionHandler;

    @Inject
    public ChatMsgShareDynamicForwardModuleBuilder(ChatActionHandler chatActionHandler) {
        Intrinsics.checkNotNullParameter(chatActionHandler, "chatActionHandler");
        this.chatActionHandler = chatActionHandler;
        this.acceptClass = Reflection.getOrCreateKotlinClass(ShareDynamicForwardMsgModule.class);
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder
    public KClass<ShareDynamicForwardMsgModule> getAcceptClass() {
        return this.acceptClass;
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder
    public ChatMsgModuleContent<ShareDynamicForwardMsgModule> buildMsgModule() {
        return ChatMsgModuleBuilderKt.ChatMsgModuleContent(ComposableLambdaKt.composableLambdaInstance(-1634531284, true, new Function6() { // from class: kntr.app.im.chat.ui.module.shareDynamicForward.ChatMsgShareDynamicForwardModuleBuilder$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                Unit buildMsgModule$lambda$0;
                buildMsgModule$lambda$0 = ChatMsgShareDynamicForwardModuleBuilder.buildMsgModule$lambda$0(ChatMsgShareDynamicForwardModuleBuilder.this, (ChatMsgFrameScope) obj, (ShareDynamicForwardMsgModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
                return buildMsgModule$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildMsgModule$lambda$0(ChatMsgShareDynamicForwardModuleBuilder this$0, ChatMsgFrameScope chatMsgFrameScope, ShareDynamicForwardMsgModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)42@2084L180:ChatMsgShareDynamicForwardModuleBuilder.kt#ntb87d");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(chatMsgFrameScope) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(msgModule) ? 32 : 16;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer.changed(modifier) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 9235) != 9234, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1634531284, $dirty2, -1, "kntr.app.im.chat.ui.module.shareDynamicForward.ChatMsgShareDynamicForwardModuleBuilder.buildMsgModule.<anonymous> (ChatMsgShareDynamicForwardModuleBuilder.kt:42)");
            }
            ChatMsgShareDynamicForwardModuleBuilderKt.ShareDynamicForwardModule(chatMsgFrameScope, msgModule, this$0.chatActionHandler, modifier, $composer, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}