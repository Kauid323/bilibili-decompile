package kntr.app.im.chat.ui.module.notifyInteractive;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import javax.inject.Inject;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.NotifyInteractiveMsgModule;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilderKt;
import kntr.app.im.chat.ui.builder.ChatMsgModuleContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ChatMsgNotifyInteractiveModuleBuilder.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkntr/app/im/chat/ui/module/notifyInteractive/ChatMsgNotifyInteractiveModuleBuilder;", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/module/NotifyInteractiveMsgModule;", "chatActionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "<init>", "(Lkntr/app/im/chat/ui/ChatActionHandler;)V", "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "buildMsgModule", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgNotifyInteractiveModuleBuilder implements ChatMsgModuleBuilder<NotifyInteractiveMsgModule> {
    public static final int $stable = 0;
    private final KClass<NotifyInteractiveMsgModule> acceptClass;
    private final ChatActionHandler chatActionHandler;

    @Inject
    public ChatMsgNotifyInteractiveModuleBuilder(ChatActionHandler chatActionHandler) {
        Intrinsics.checkNotNullParameter(chatActionHandler, "chatActionHandler");
        this.chatActionHandler = chatActionHandler;
        this.acceptClass = Reflection.getOrCreateKotlinClass(NotifyInteractiveMsgModule.class);
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder
    public KClass<NotifyInteractiveMsgModule> getAcceptClass() {
        return this.acceptClass;
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder
    public ChatMsgModuleContent<NotifyInteractiveMsgModule> buildMsgModule() {
        return ChatMsgModuleBuilderKt.ChatMsgModuleContent(ComposableLambdaKt.composableLambdaInstance(1716233940, true, new Function6() { // from class: kntr.app.im.chat.ui.module.notifyInteractive.ChatMsgNotifyInteractiveModuleBuilder$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                Unit buildMsgModule$lambda$0;
                buildMsgModule$lambda$0 = ChatMsgNotifyInteractiveModuleBuilder.buildMsgModule$lambda$0(ChatMsgNotifyInteractiveModuleBuilder.this, (ChatMsgFrameScope) obj, (NotifyInteractiveMsgModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
                return buildMsgModule$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildMsgModule$lambda$0(final ChatMsgNotifyInteractiveModuleBuilder this$0, ChatMsgFrameScope chatMsgFrameScope, final NotifyInteractiveMsgModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)38@1700L24,42@1880L131,39@1741L289:ChatMsgNotifyInteractiveModuleBuilder.kt#2lymyz");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(msgModule) ? 32 : 16;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer.changed(modifier) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 9233) != 9232, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1716233940, $dirty2, -1, "kntr.app.im.chat.ui.module.notifyInteractive.ChatMsgNotifyInteractiveModuleBuilder.buildMsgModule.<anonymous> (ChatMsgNotifyInteractiveModuleBuilder.kt:38)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
                $composer.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 33382551, "CC(remember):ChatMsgNotifyInteractiveModuleBuilder.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(scope) | $composer.changed(this$0) | (($dirty2 & 112) == 32);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.module.notifyInteractive.ChatMsgNotifyInteractiveModuleBuilder$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit buildMsgModule$lambda$0$0$0;
                        buildMsgModule$lambda$0$0$0 = ChatMsgNotifyInteractiveModuleBuilder.buildMsgModule$lambda$0$0$0(scope, this$0, msgModule);
                        return buildMsgModule$lambda$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ChatMsgNotifyInteractiveModuleBuilderKt.NotifyInteractiveModule(msgModule, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), $composer, ($dirty2 >> 3) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildMsgModule$lambda$0$0$0(CoroutineScope $scope, ChatMsgNotifyInteractiveModuleBuilder this$0, NotifyInteractiveMsgModule $msgModule) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatMsgNotifyInteractiveModuleBuilder$buildMsgModule$1$1$1$1(this$0, $msgModule, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}