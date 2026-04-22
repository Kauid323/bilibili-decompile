package kntr.app.im.chat.ui.module.notifyGame;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.NotifyGameModule;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMsgNotifyGameModuleBuilder.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ChatMsgNotifyGameModuleBuilderKt {
    public static final ComposableSingletons$ChatMsgNotifyGameModuleBuilderKt INSTANCE = new ComposableSingletons$ChatMsgNotifyGameModuleBuilderKt();

    /* renamed from: lambda$-509918059  reason: not valid java name */
    private static Function6<ChatMsgFrameScope, NotifyGameModule, EntityMessage, Modifier, Composer, Integer, Unit> f37lambda$509918059 = ComposableLambdaKt.composableLambdaInstance(-509918059, false, new Function6() { // from class: kntr.app.im.chat.ui.module.notifyGame.ComposableSingletons$ChatMsgNotifyGameModuleBuilderKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            Unit lambda__509918059$lambda$0;
            lambda__509918059$lambda$0 = ComposableSingletons$ChatMsgNotifyGameModuleBuilderKt.lambda__509918059$lambda$0((ChatMsgFrameScope) obj, (NotifyGameModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            return lambda__509918059$lambda$0;
        }
    });

    /* renamed from: getLambda$-509918059$ui_debug  reason: not valid java name */
    public final Function6<ChatMsgFrameScope, NotifyGameModule, EntityMessage, Modifier, Composer, Integer, Unit> m1794getLambda$509918059$ui_debug() {
        return f37lambda$509918059;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__509918059$lambda$0(ChatMsgFrameScope chatMsgFrameScope, NotifyGameModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)53@2288L110:ChatMsgNotifyGameModuleBuilder.kt#uw7zdj");
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
                ComposerKt.traceEventStart(-509918059, $dirty, -1, "kntr.app.im.chat.ui.module.notifyGame.ComposableSingletons$ChatMsgNotifyGameModuleBuilderKt.lambda$-509918059.<anonymous> (ChatMsgNotifyGameModuleBuilder.kt:53)");
            }
            ChatMsgNotifyGameModuleBuilderKt.NotifyGameModule(msgModule.getValue(), modifier, $composer, ($dirty >> 6) & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}