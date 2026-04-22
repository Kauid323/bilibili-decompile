package kntr.app.im.chat.ui.module.autoReply;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.AutoReplyMsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutoReplyModule.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$AutoReplyModuleKt {
    public static final ComposableSingletons$AutoReplyModuleKt INSTANCE = new ComposableSingletons$AutoReplyModuleKt();
    private static Function6<ChatMsgFrameScope, AutoReplyMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> lambda$500384991 = ComposableLambdaKt.composableLambdaInstance(500384991, false, new Function6() { // from class: kntr.app.im.chat.ui.module.autoReply.ComposableSingletons$AutoReplyModuleKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            Unit lambda_500384991$lambda$0;
            lambda_500384991$lambda$0 = ComposableSingletons$AutoReplyModuleKt.lambda_500384991$lambda$0((ChatMsgFrameScope) obj, (AutoReplyMsgModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            return lambda_500384991$lambda$0;
        }
    });

    public final Function6<ChatMsgFrameScope, AutoReplyMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> getLambda$500384991$ui_debug() {
        return lambda$500384991;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_500384991$lambda$0(ChatMsgFrameScope chatMsgFrameScope, AutoReplyMsgModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)38@1540L56:AutoReplyModule.kt#8kab1p");
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
                ComposerKt.traceEventStart(500384991, $dirty, -1, "kntr.app.im.chat.ui.module.autoReply.ComposableSingletons$AutoReplyModuleKt.lambda$500384991.<anonymous> (AutoReplyModule.kt:38)");
            }
            AutoReplyModuleKt.AutoReplyModule(msgModule, modifier, $composer, (($dirty >> 3) & 14) | (($dirty >> 6) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}