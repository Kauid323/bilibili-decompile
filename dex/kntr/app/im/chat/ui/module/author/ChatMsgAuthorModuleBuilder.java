package kntr.app.im.chat.ui.module.author;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import javax.inject.Inject;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.AuthorMsgModule;
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

/* compiled from: ChatMsgAuthorModuleBuilder.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkntr/app/im/chat/ui/module/author/ChatMsgAuthorModuleBuilder;", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/module/AuthorMsgModule;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "<init>", "(Lkntr/app/im/chat/ui/ChatActionHandler;)V", "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "buildMsgModule", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgAuthorModuleBuilder implements ChatMsgModuleBuilder<AuthorMsgModule> {
    public static final int $stable = 0;
    private final KClass<AuthorMsgModule> acceptClass;
    private final ChatActionHandler actionHandler;

    @Inject
    public ChatMsgAuthorModuleBuilder(ChatActionHandler actionHandler) {
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        this.actionHandler = actionHandler;
        this.acceptClass = Reflection.getOrCreateKotlinClass(AuthorMsgModule.class);
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder
    public KClass<AuthorMsgModule> getAcceptClass() {
        return this.acceptClass;
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder
    public ChatMsgModuleContent<AuthorMsgModule> buildMsgModule() {
        return ChatMsgModuleBuilderKt.ChatMsgModuleContent(ComposableLambdaKt.composableLambdaInstance(-1808402280, true, new Function6() { // from class: kntr.app.im.chat.ui.module.author.ChatMsgAuthorModuleBuilder$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                Unit buildMsgModule$lambda$0;
                buildMsgModule$lambda$0 = ChatMsgAuthorModuleBuilder.buildMsgModule$lambda$0(ChatMsgAuthorModuleBuilder.this, (ChatMsgFrameScope) obj, (AuthorMsgModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
                return buildMsgModule$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildMsgModule$lambda$0(ChatMsgAuthorModuleBuilder this$0, ChatMsgFrameScope chatMsgFrameScope, AuthorMsgModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)41@1760L59:ChatMsgAuthorModuleBuilder.kt#j14mqv");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(msgModule) ? 32 : 16;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer.changed(modifier) ? 2048 : 1024;
        }
        if (!$composer.shouldExecute(($dirty & 9233) != 9232, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1808402280, $dirty, -1, "kntr.app.im.chat.ui.module.author.ChatMsgAuthorModuleBuilder.buildMsgModule.<anonymous> (ChatMsgAuthorModuleBuilder.kt:41)");
            }
            ChatMsgAuthorModuleBuilderKt.AuthorModule(msgModule, this$0.actionHandler, modifier, $composer, (($dirty >> 3) & 14) | (($dirty >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}