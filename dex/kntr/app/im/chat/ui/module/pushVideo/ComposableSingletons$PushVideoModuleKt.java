package kntr.app.im.chat.ui.module.pushVideo;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.PushVideoMsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushVideoModule.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$PushVideoModuleKt {
    public static final ComposableSingletons$PushVideoModuleKt INSTANCE = new ComposableSingletons$PushVideoModuleKt();

    /* renamed from: lambda$-673103602  reason: not valid java name */
    private static Function6<ChatMsgFrameScope, PushVideoMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> f43lambda$673103602 = ComposableLambdaKt.composableLambdaInstance(-673103602, false, new Function6() { // from class: kntr.app.im.chat.ui.module.pushVideo.ComposableSingletons$PushVideoModuleKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            Unit lambda__673103602$lambda$0;
            lambda__673103602$lambda$0 = ComposableSingletons$PushVideoModuleKt.lambda__673103602$lambda$0((ChatMsgFrameScope) obj, (PushVideoMsgModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            return lambda__673103602$lambda$0;
        }
    });

    /* renamed from: getLambda$-673103602$ui_debug  reason: not valid java name */
    public final Function6<ChatMsgFrameScope, PushVideoMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> m1847getLambda$673103602$ui_debug() {
        return f43lambda$673103602;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__673103602$lambda$0(ChatMsgFrameScope chatMsgFrameScope, PushVideoMsgModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)40@1778L115:PushVideoModule.kt#vk5uod");
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
                ComposerKt.traceEventStart(-673103602, $dirty, -1, "kntr.app.im.chat.ui.module.pushVideo.ComposableSingletons$PushVideoModuleKt.lambda$-673103602.<anonymous> (PushVideoModule.kt:40)");
            }
            PushVideoModuleKt.PushVideoModule(chatMsgFrameScope, msgModule, modifier, $composer, ($dirty & 14) | ($dirty & 112) | (($dirty >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}