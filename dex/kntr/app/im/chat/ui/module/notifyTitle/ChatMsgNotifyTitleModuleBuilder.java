package kntr.app.im.chat.ui.module.notifyTitle;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import javax.inject.Inject;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.NotifyTitleMsgModule;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilderKt;
import kntr.app.im.chat.ui.builder.ChatMsgModuleContent;
import kntr.app.im.chat.ui.utils.ChatPageController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ChatMsgNotifyTitleModuleBuilder.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/ui/module/notifyTitle/ChatMsgNotifyTitleModuleBuilder;", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/module/NotifyTitleMsgModule;", "pageController", "Lkntr/app/im/chat/ui/utils/ChatPageController;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "<init>", "(Lkntr/app/im/chat/ui/utils/ChatPageController;Lkntr/app/im/chat/ui/ChatActionHandler;)V", "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "buildMsgModule", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgNotifyTitleModuleBuilder implements ChatMsgModuleBuilder<NotifyTitleMsgModule> {
    public static final int $stable = 0;
    private final KClass<NotifyTitleMsgModule> acceptClass;
    private final ChatActionHandler actionHandler;
    private final ChatPageController pageController;

    @Inject
    public ChatMsgNotifyTitleModuleBuilder(ChatPageController pageController, ChatActionHandler actionHandler) {
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        this.pageController = pageController;
        this.actionHandler = actionHandler;
        this.acceptClass = Reflection.getOrCreateKotlinClass(NotifyTitleMsgModule.class);
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder
    public KClass<NotifyTitleMsgModule> getAcceptClass() {
        return this.acceptClass;
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder
    public ChatMsgModuleContent<NotifyTitleMsgModule> buildMsgModule() {
        return ChatMsgModuleBuilderKt.ChatMsgModuleContent(ComposableLambdaKt.composableLambdaInstance(-1867104896, true, new Function6() { // from class: kntr.app.im.chat.ui.module.notifyTitle.ChatMsgNotifyTitleModuleBuilder$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                Unit buildMsgModule$lambda$0;
                buildMsgModule$lambda$0 = ChatMsgNotifyTitleModuleBuilder.buildMsgModule$lambda$0(ChatMsgNotifyTitleModuleBuilder.this, (ChatMsgFrameScope) obj, (NotifyTitleMsgModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
                return buildMsgModule$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildMsgModule$lambda$0(ChatMsgNotifyTitleModuleBuilder this$0, ChatMsgFrameScope chatMsgFrameScope, NotifyTitleMsgModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)45@2055L260:ChatMsgNotifyTitleModuleBuilder.kt#y545xb");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(msgModule) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer.changed(message) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer.changed(modifier) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 9361) != 9360, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1867104896, $dirty2, -1, "kntr.app.im.chat.ui.module.notifyTitle.ChatMsgNotifyTitleModuleBuilder.buildMsgModule.<anonymous> (ChatMsgNotifyTitleModuleBuilder.kt:45)");
            }
            ChatMsgNotifyTitleModuleBuilderKt.NotifyTitleModule(message, msgModule, this$0.actionHandler, this$0.pageController, modifier, $composer, (($dirty2 >> 6) & 14) | ($dirty2 & 112) | (($dirty2 << 3) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}