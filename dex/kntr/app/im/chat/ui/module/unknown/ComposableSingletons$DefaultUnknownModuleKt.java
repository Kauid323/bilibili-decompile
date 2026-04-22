package kntr.app.im.chat.ui.module.unknown;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultUnknownModule.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$DefaultUnknownModuleKt {
    public static final ComposableSingletons$DefaultUnknownModuleKt INSTANCE = new ComposableSingletons$DefaultUnknownModuleKt();

    /* renamed from: lambda$-901536149  reason: not valid java name */
    private static Function6<ChatMsgFrameScope, MsgModule.UnknownModule, EntityMessage, Modifier, Composer, Integer, Unit> f47lambda$901536149 = ComposableLambdaKt.composableLambdaInstance(-901536149, false, new Function6() { // from class: kntr.app.im.chat.ui.module.unknown.ComposableSingletons$DefaultUnknownModuleKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            Unit lambda__901536149$lambda$0;
            lambda__901536149$lambda$0 = ComposableSingletons$DefaultUnknownModuleKt.lambda__901536149$lambda$0((ChatMsgFrameScope) obj, (MsgModule.UnknownModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            return lambda__901536149$lambda$0;
        }
    });

    /* renamed from: getLambda$-901536149$ui_debug  reason: not valid java name */
    public final Function6<ChatMsgFrameScope, MsgModule.UnknownModule, EntityMessage, Modifier, Composer, Integer, Unit> m1878getLambda$901536149$ui_debug() {
        return f47lambda$901536149;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__901536149$lambda$0(ChatMsgFrameScope chatMsgFrameScope, MsgModule.UnknownModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)48@1992L72:DefaultUnknownModule.kt#fqrcqs");
        int $dirty = $changed;
        if (($changed & 3072) == 0) {
            $dirty |= $composer.changed(modifier) ? 2048 : 1024;
        }
        if (!$composer.shouldExecute(($dirty & 9217) != 9216, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-901536149, $dirty, -1, "kntr.app.im.chat.ui.module.unknown.ComposableSingletons$DefaultUnknownModuleKt.lambda$-901536149.<anonymous> (DefaultUnknownModule.kt:48)");
            }
            DefaultUnknownModuleKt.UnknownModuleContent(modifier, $composer, ($dirty >> 9) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}