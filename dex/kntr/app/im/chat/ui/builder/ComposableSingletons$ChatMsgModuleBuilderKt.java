package kntr.app.im.chat.ui.builder;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MsgModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMsgModuleBuilder.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ChatMsgModuleBuilderKt {
    public static final ComposableSingletons$ChatMsgModuleBuilderKt INSTANCE = new ComposableSingletons$ChatMsgModuleBuilderKt();
    private static Function6<ChatMsgFrameScope, MsgModule, EntityMessage, Modifier, Composer, Integer, Unit> lambda$165464496 = ComposableLambdaKt.composableLambdaInstance(165464496, false, new Function6() { // from class: kntr.app.im.chat.ui.builder.ComposableSingletons$ChatMsgModuleBuilderKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            Unit lambda_165464496$lambda$0;
            lambda_165464496$lambda$0 = ComposableSingletons$ChatMsgModuleBuilderKt.lambda_165464496$lambda$0((ChatMsgFrameScope) obj, (MsgModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            return lambda_165464496$lambda$0;
        }
    });

    public final Function6<ChatMsgFrameScope, MsgModule, EntityMessage, Modifier, Composer, Integer, Unit> getLambda$165464496$ui_debug() {
        return lambda$165464496;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_165464496$lambda$0(ChatMsgFrameScope chatMsgFrameScope, MsgModule msgModule, EntityMessage entityMessage, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "$unused$var$");
        Intrinsics.checkNotNullParameter(entityMessage, "$unused$var$");
        Intrinsics.checkNotNullParameter(modifier, "$unused$var$");
        ComposerKt.sourceInformation($composer, "C:ChatMsgModuleBuilder.kt#fhhntl");
        if ($composer.shouldExecute(($changed & 8193) != 8192, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(165464496, $changed, -1, "kntr.app.im.chat.ui.builder.ComposableSingletons$ChatMsgModuleBuilderKt.lambda$165464496.<anonymous> (ChatMsgModuleBuilder.kt:34)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}