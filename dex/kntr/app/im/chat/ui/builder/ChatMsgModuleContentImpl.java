package kntr.app.im.chat.ui.builder;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMsgModuleBuilder.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003Bn\u0012e\u0010\u0004\u001aa\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0002¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0017R\u00020\u0006j\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0002\u0010\u0017Ro\u0010\u0004\u001aa\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0002¢\u0006\u0002\b\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u0018"}, d2 = {"Lkntr/app/im/chat/ui/builder/ChatMsgModuleContentImpl;", "M", "Lkntr/app/im/chat/core/model/MsgModule;", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent;", "content", "Lkotlin/Function4;", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;", "Lkotlin/ParameterName;", "name", "module", "Lkntr/app/im/chat/core/model/EntityMessage;", "message", "Landroidx/compose/ui/Modifier;", "modifier", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ContextFunctionTypeParams;", "count", "Landroidx/compose/runtime/Composable;", "<init>", "(Lkotlin/jvm/functions/Function6;)V", "Lkotlin/jvm/functions/Function6;", "Content", "frameScope", "(Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;Lkntr/app/im/chat/core/model/MsgModule;Lkntr/app/im/chat/core/model/EntityMessage;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgModuleContentImpl<M extends MsgModule> implements ChatMsgModuleContent<M> {
    public static final int $stable = 0;
    private final Function6<ChatMsgFrameScope, M, EntityMessage, Modifier, Composer, Integer, Unit> content;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatMsgModuleContentImpl(Function6<? super ChatMsgFrameScope, ? super M, ? super EntityMessage, ? super Modifier, ? super Composer, ? super Integer, Unit> function6) {
        Intrinsics.checkNotNullParameter(function6, "content");
        this.content = function6;
    }

    @Override // kntr.app.im.chat.ui.builder.ChatMsgModuleContent
    public void Content(ChatMsgFrameScope frameScope, M m, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(frameScope, "frameScope");
        Intrinsics.checkNotNullParameter(m, "module");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        $composer.startReplaceGroup(663936518);
        ComposerKt.sourceInformation($composer, "C(Content)N(frameScope,module,message,modifier)99@3076L34:ChatMsgModuleBuilder.kt#fhhntl");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(663936518, $changed, -1, "kntr.app.im.chat.ui.builder.ChatMsgModuleContentImpl.Content (ChatMsgModuleBuilder.kt:98)");
        }
        this.content.invoke(frameScope, m, message, modifier, $composer, Integer.valueOf(($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
    }
}