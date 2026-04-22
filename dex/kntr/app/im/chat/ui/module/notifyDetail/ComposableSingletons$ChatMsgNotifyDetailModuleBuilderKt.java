package kntr.app.im.chat.ui.module.notifyDetail;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.NotifyDetailMsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMsgNotifyDetailModuleBuilder.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ChatMsgNotifyDetailModuleBuilderKt {
    public static final ComposableSingletons$ChatMsgNotifyDetailModuleBuilderKt INSTANCE = new ComposableSingletons$ChatMsgNotifyDetailModuleBuilderKt();

    /* renamed from: lambda$-857829418  reason: not valid java name */
    private static Function6<ChatMsgFrameScope, NotifyDetailMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> f36lambda$857829418 = ComposableLambdaKt.composableLambdaInstance(-857829418, false, new Function6() { // from class: kntr.app.im.chat.ui.module.notifyDetail.ComposableSingletons$ChatMsgNotifyDetailModuleBuilderKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            Unit lambda__857829418$lambda$0;
            lambda__857829418$lambda$0 = ComposableSingletons$ChatMsgNotifyDetailModuleBuilderKt.lambda__857829418$lambda$0((ChatMsgFrameScope) obj, (NotifyDetailMsgModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            return lambda__857829418$lambda$0;
        }
    });

    /* renamed from: getLambda$-857829418$ui_debug  reason: not valid java name */
    public final Function6<ChatMsgFrameScope, NotifyDetailMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> m1791getLambda$857829418$ui_debug() {
        return f36lambda$857829418;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__857829418$lambda$0(ChatMsgFrameScope chatMsgFrameScope, NotifyDetailMsgModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)40@1790L118:ChatMsgNotifyDetailModuleBuilder.kt#ktmpk");
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
                ComposerKt.traceEventStart(-857829418, $dirty, -1, "kntr.app.im.chat.ui.module.notifyDetail.ComposableSingletons$ChatMsgNotifyDetailModuleBuilderKt.lambda$-857829418.<anonymous> (ChatMsgNotifyDetailModuleBuilder.kt:40)");
            }
            ChatMsgNotifyDetailModuleBuilderKt.NotifyDetailModule(msgModule, modifier, $composer, (($dirty >> 3) & 14) | (($dirty >> 6) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}