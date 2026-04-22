package kntr.app.im.chat.ui.module.shareArticle;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.ShareArticleMsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMsgShareArticleModuleBuilder.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ChatMsgShareArticleModuleBuilderKt {
    public static final ComposableSingletons$ChatMsgShareArticleModuleBuilderKt INSTANCE = new ComposableSingletons$ChatMsgShareArticleModuleBuilderKt();

    /* renamed from: lambda$-940223184  reason: not valid java name */
    private static Function6<ChatMsgFrameScope, ShareArticleMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> f45lambda$940223184 = ComposableLambdaKt.composableLambdaInstance(-940223184, false, new Function6() { // from class: kntr.app.im.chat.ui.module.shareArticle.ComposableSingletons$ChatMsgShareArticleModuleBuilderKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            Unit lambda__940223184$lambda$0;
            lambda__940223184$lambda$0 = ComposableSingletons$ChatMsgShareArticleModuleBuilderKt.lambda__940223184$lambda$0((ChatMsgFrameScope) obj, (ShareArticleMsgModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            return lambda__940223184$lambda$0;
        }
    });

    /* renamed from: getLambda$-940223184$ui_debug  reason: not valid java name */
    public final Function6<ChatMsgFrameScope, ShareArticleMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> m1856getLambda$940223184$ui_debug() {
        return f45lambda$940223184;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__940223184$lambda$0(ChatMsgFrameScope chatMsgFrameScope, ShareArticleMsgModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)34@1576L118:ChatMsgShareArticleModuleBuilder.kt#yg257p");
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
                ComposerKt.traceEventStart(-940223184, $dirty, -1, "kntr.app.im.chat.ui.module.shareArticle.ComposableSingletons$ChatMsgShareArticleModuleBuilderKt.lambda$-940223184.<anonymous> (ChatMsgShareArticleModuleBuilder.kt:34)");
            }
            ChatMsgShareArticleModuleBuilderKt.ShareArticleModule(msgModule, modifier, $composer, (($dirty >> 3) & 14) | (($dirty >> 6) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}