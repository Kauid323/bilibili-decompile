package kntr.app.im.chat.ui.module.invalidResource;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.InvalidResourceModule;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvalidResourceModuleContent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$InvalidResourceModuleContentKt {
    public static final ComposableSingletons$InvalidResourceModuleContentKt INSTANCE = new ComposableSingletons$InvalidResourceModuleContentKt();
    private static Function6<ChatMsgFrameScope, InvalidResourceModule, EntityMessage, Modifier, Composer, Integer, Unit> lambda$1783605373 = ComposableLambdaKt.composableLambdaInstance(1783605373, false, new Function6() { // from class: kntr.app.im.chat.ui.module.invalidResource.ComposableSingletons$InvalidResourceModuleContentKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            Unit lambda_1783605373$lambda$0;
            lambda_1783605373$lambda$0 = ComposableSingletons$InvalidResourceModuleContentKt.lambda_1783605373$lambda$0((ChatMsgFrameScope) obj, (InvalidResourceModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            return lambda_1783605373$lambda$0;
        }
    });

    public final Function6<ChatMsgFrameScope, InvalidResourceModule, EntityMessage, Modifier, Composer, Integer, Unit> getLambda$1783605373$ui_debug() {
        return lambda$1783605373;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1783605373$lambda$0(ChatMsgFrameScope chatMsgFrameScope, InvalidResourceModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)45@1913L117:InvalidResourceModuleContent.kt#wkzqmv");
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
                ComposerKt.traceEventStart(1783605373, $dirty, -1, "kntr.app.im.chat.ui.module.invalidResource.ComposableSingletons$InvalidResourceModuleContentKt.lambda$1783605373.<anonymous> (InvalidResourceModuleContent.kt:45)");
            }
            InvalidResourceModuleContentKt.InvalidResourceModuleContent(msgModule, modifier, $composer, (($dirty >> 3) & 14) | (($dirty >> 6) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}