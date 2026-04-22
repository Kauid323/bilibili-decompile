package kntr.app.im.chat.ui.module.shareVideo;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.ShareVideoMsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareVideoModule.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ShareVideoModuleKt {
    public static final ComposableSingletons$ShareVideoModuleKt INSTANCE = new ComposableSingletons$ShareVideoModuleKt();
    private static Function6<ChatMsgFrameScope, ShareVideoMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> lambda$1251098684 = ComposableLambdaKt.composableLambdaInstance(1251098684, false, new Function6() { // from class: kntr.app.im.chat.ui.module.shareVideo.ComposableSingletons$ShareVideoModuleKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            Unit lambda_1251098684$lambda$0;
            lambda_1251098684$lambda$0 = ComposableSingletons$ShareVideoModuleKt.lambda_1251098684$lambda$0((ChatMsgFrameScope) obj, (ShareVideoMsgModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            return lambda_1251098684$lambda$0;
        }
    });

    public final Function6<ChatMsgFrameScope, ShareVideoMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> getLambda$1251098684$ui_debug() {
        return lambda$1251098684;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1251098684$lambda$0(ChatMsgFrameScope chatMsgFrameScope, ShareVideoMsgModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)43@1923L116:ShareVideoModule.kt#tp1gdm");
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
                ComposerKt.traceEventStart(1251098684, $dirty, -1, "kntr.app.im.chat.ui.module.shareVideo.ComposableSingletons$ShareVideoModuleKt.lambda$1251098684.<anonymous> (ShareVideoModule.kt:43)");
            }
            ShareVideoModuleKt.ShareVideoModule(chatMsgFrameScope, msgModule, modifier, $composer, ($dirty & 14) | ($dirty & 112) | (($dirty >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}