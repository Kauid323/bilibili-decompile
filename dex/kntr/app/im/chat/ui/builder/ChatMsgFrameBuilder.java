package kntr.app.im.chat.ui.builder;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: ChatMsgFrameBuilder.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH'¢\u0006\u0002\u0010\u000fR\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilder;", "F", "Lkntr/app/im/chat/core/model/MsgFrame;", RoomRecommendViewModel.EMPTY_CURSOR, "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "msgFrame", "msgContent", "Lkntr/app/im/chat/core/model/EntityMessage;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/core/model/MsgFrame;Lkntr/app/im/chat/core/model/EntityMessage;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatMsgFrameBuilder<F extends MsgFrame> {
    void Content(F f, EntityMessage entityMessage, Modifier modifier, Composer composer, int i);

    KClass<F> getAcceptClass();

    /* compiled from: ChatMsgFrameBuilder.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ComposeDefaultImpls {
        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit Content_default$lambda$0(MsgFrame msgFrame, EntityMessage entityMessage, Modifier modifier, ChatMsgFrameBuilder chatMsgFrameBuilder, int i, int i2, Composer composer, int i3) {
            Content$default(msgFrame, entityMessage, modifier, chatMsgFrameBuilder, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void Content$default(final F f, final EntityMessage msgContent, Modifier modifier, final ChatMsgFrameBuilder<F> chatMsgFrameBuilder, Composer $composer, final int $changed, final int i) {
            Modifier modifier2;
            int $dirty;
            Modifier modifier3;
            ScopeUpdateScope endRestartGroup;
            Intrinsics.checkNotNullParameter(f, "msgFrame");
            Intrinsics.checkNotNullParameter(msgContent, "msgContent");
            Intrinsics.checkNotNullParameter(chatMsgFrameBuilder, "$this$");
            Composer $composer2 = $composer.startRestartGroup(-1946320251);
            ComposerKt.sourceInformation($composer2, "C(Content$default)N(msgFrame,msgContent,modifier):ChatMsgFrameBuilder.kt#fhhntl");
            int $dirty2 = $changed;
            if (($changed & 6) == 0) {
                $dirty2 |= ($changed & 8) == 0 ? $composer2.changed(f) : $composer2.changedInstance(f) ? 4 : 2;
            }
            if (($changed & 48) == 0) {
                $dirty2 |= $composer2.changed(msgContent) ? 32 : 16;
            }
            int i2 = i & 4;
            if (i2 != 0) {
                $dirty2 |= 384;
            } else if (($changed & 384) == 0) {
                modifier2 = modifier;
                $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
                if (($changed & 3072) == 0) {
                    $dirty2 |= $composer2.changed(chatMsgFrameBuilder) ? 2048 : 1024;
                }
                $dirty = $dirty2;
                if ($composer2.shouldExecute(($dirty & 1171) == 1170, $dirty & 1)) {
                    $composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                } else {
                    Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1946320251, $dirty, -1, "kntr.app.im.chat.ui.builder.ChatMsgFrameBuilder.ComposeDefaultImpls.Content$default (ChatMsgFrameBuilder.kt:-1)");
                    }
                    chatMsgFrameBuilder.Content(f, msgContent, modifier4, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                }
                endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup == null) {
                    final Modifier modifier5 = modifier3;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.builder.ChatMsgFrameBuilder$ComposeDefaultImpls$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit Content_default$lambda$0;
                            Content_default$lambda$0 = ChatMsgFrameBuilder.ComposeDefaultImpls.Content_default$lambda$0(MsgFrame.this, msgContent, modifier5, chatMsgFrameBuilder, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
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
            $dirty = $dirty2;
            if ($composer2.shouldExecute(($dirty & 1171) == 1170, $dirty & 1)) {
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
    }
}