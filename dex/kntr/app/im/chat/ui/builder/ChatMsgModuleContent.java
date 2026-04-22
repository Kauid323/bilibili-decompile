package kntr.app.im.chat.ui.builder;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgModuleContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMsgModuleBuilder.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u000e*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u000eJ3\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH'R\u00020\u0006j\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\r¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent;", "M", "Lkntr/app/im/chat/core/model/MsgModule;", RoomRecommendViewModel.EMPTY_CURSOR, "Content", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;", "frameScope", "module", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;Lkntr/app/im/chat/core/model/MsgModule;Lkntr/app/im/chat/core/model/EntityMessage;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatMsgModuleContent<M extends MsgModule> {
    public static final Companion Companion = Companion.$$INSTANCE;

    void Content(ChatMsgFrameScope chatMsgFrameScope, M m, EntityMessage entityMessage, Modifier modifier, Composer composer, int i);

    /* compiled from: ChatMsgModuleBuilder.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ComposeDefaultImpls {
        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit Content_default$lambda$0(MsgModule msgModule, EntityMessage entityMessage, Modifier modifier, ChatMsgModuleContent chatMsgModuleContent, ChatMsgFrameScope chatMsgFrameScope, int i, int i2, Composer composer, int i3) {
            Content$default(msgModule, entityMessage, modifier, chatMsgModuleContent, chatMsgFrameScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00f5  */
        /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void Content$default(final M m, final EntityMessage message, Modifier modifier, final ChatMsgModuleContent<M> chatMsgModuleContent, final ChatMsgFrameScope frameScope, Composer $composer, final int $changed, final int i) {
            Modifier modifier2;
            int $dirty;
            Modifier modifier3;
            ScopeUpdateScope endRestartGroup;
            Intrinsics.checkNotNullParameter(m, "module");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(chatMsgModuleContent, "$this$");
            Intrinsics.checkNotNullParameter(frameScope, "frameScope");
            Composer $composer2 = $composer.startRestartGroup(-402068088);
            ComposerKt.sourceInformation($composer2, "C(Content$default)N(module,message,modifier,frameScope):ChatMsgModuleBuilder.kt#fhhntl");
            int $dirty2 = $changed;
            if (($changed & 6) == 0) {
                $dirty2 |= ($changed & 8) == 0 ? $composer2.changed(m) : $composer2.changedInstance(m) ? 4 : 2;
            }
            if (($changed & 48) == 0) {
                $dirty2 |= $composer2.changed(message) ? 32 : 16;
            }
            int i2 = i & 4;
            if (i2 != 0) {
                $dirty2 |= 384;
            } else if (($changed & 384) == 0) {
                modifier2 = modifier;
                $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
                if (($changed & 3072) == 0) {
                    $dirty2 |= $composer2.changed(chatMsgModuleContent) ? 2048 : 1024;
                }
                if (($changed & 24576) == 0) {
                    $dirty2 |= $composer2.changed(frameScope) ? 16384 : 8192;
                }
                $dirty = $dirty2;
                if ($composer2.shouldExecute(($dirty & 9363) == 9362, $dirty & 1)) {
                    $composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                } else {
                    Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-402068088, $dirty, -1, "kntr.app.im.chat.ui.builder.ChatMsgModuleContent.ComposeDefaultImpls.Content$default (ChatMsgModuleBuilder.kt:-1)");
                    }
                    chatMsgModuleContent.Content(frameScope, m, message, modifier4, $composer2, (($dirty >> 12) & 14) | (($dirty << 3) & 112) | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (57344 & ($dirty << 3)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                }
                endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup == null) {
                    final Modifier modifier5 = modifier3;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.builder.ChatMsgModuleContent$ComposeDefaultImpls$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit Content_default$lambda$0;
                            Content_default$lambda$0 = ChatMsgModuleContent.ComposeDefaultImpls.Content_default$lambda$0(MsgModule.this, message, modifier5, chatMsgModuleContent, frameScope, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return Content_default$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            modifier2 = modifier;
            if (($changed & 3072) == 0) {
            }
            if (($changed & 24576) == 0) {
            }
            $dirty = $dirty2;
            if ($composer2.shouldExecute(($dirty & 9363) == 9362, $dirty & 1)) {
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
    }

    /* compiled from: ChatMsgModuleBuilder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Empty", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent;", "Lkntr/app/im/chat/core/model/MsgModule;", "getEmpty", "()Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ChatMsgModuleContent<MsgModule> Empty = ChatMsgModuleBuilderKt.ChatMsgModuleContent(ComposableSingletons$ChatMsgModuleBuilderKt.INSTANCE.getLambda$165464496$ui_debug());

        private Companion() {
        }

        public final ChatMsgModuleContent<MsgModule> getEmpty() {
            return Empty;
        }
    }
}