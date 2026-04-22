package kntr.app.im.chat.ui.module.pushAdditionalMsg;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.PushAdditionalMsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushAdditionalMsgModule.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$PushAdditionalMsgModuleKt {
    public static final ComposableSingletons$PushAdditionalMsgModuleKt INSTANCE = new ComposableSingletons$PushAdditionalMsgModuleKt();

    /* renamed from: lambda$-1185732065  reason: not valid java name */
    private static Function6<ChatMsgFrameScope, PushAdditionalMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> f42lambda$1185732065 = ComposableLambdaKt.composableLambdaInstance(-1185732065, false, new Function6() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.ComposableSingletons$PushAdditionalMsgModuleKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            Unit lambda__1185732065$lambda$0;
            lambda__1185732065$lambda$0 = ComposableSingletons$PushAdditionalMsgModuleKt.lambda__1185732065$lambda$0((ChatMsgFrameScope) obj, (PushAdditionalMsgModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            return lambda__1185732065$lambda$0;
        }
    });

    /* renamed from: getLambda$-1185732065$ui_debug  reason: not valid java name */
    public final Function6<ChatMsgFrameScope, PushAdditionalMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> m1819getLambda$1185732065$ui_debug() {
        return f42lambda$1185732065;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1185732065$lambda$0(ChatMsgFrameScope chatMsgFrameScope, PushAdditionalMsgModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)58@2899L123:PushAdditionalMsgModule.kt#po4coe");
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
        if (!$composer.shouldExecute(($dirty & 9235) != 9234, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1185732065, $dirty, -1, "kntr.app.im.chat.ui.module.pushAdditionalMsg.ComposableSingletons$PushAdditionalMsgModuleKt.lambda$-1185732065.<anonymous> (PushAdditionalMsgModule.kt:58)");
            }
            PushAdditionalMsgModuleKt.PushAdditionalMsgModule(chatMsgFrameScope, msgModule, modifier, $composer, ($dirty & 14) | ($dirty & 112) | (($dirty >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}