package kntr.app.im.chat.ui.builder;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMsgModuleBuilder.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0082\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032e\u0010\u0004\u001aa\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0002¢\u0006\u0002\b\u0011¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"ChatMsgModuleContent", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent;", "M", "Lkntr/app/im/chat/core/model/MsgModule;", "content", "Lkotlin/Function4;", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;", "Lkotlin/ParameterName;", "name", "module", "Lkntr/app/im/chat/core/model/EntityMessage;", "message", "Landroidx/compose/ui/Modifier;", "modifier", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ContextFunctionTypeParams;", "count", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function6;)Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgModuleBuilderKt {
    public static final <M extends MsgModule> ChatMsgModuleContent<M> ChatMsgModuleContent(Function6<? super ChatMsgFrameScope, ? super M, ? super EntityMessage, ? super Modifier, ? super Composer, ? super Integer, Unit> function6) {
        Intrinsics.checkNotNullParameter(function6, "content");
        return new ChatMsgModuleContentImpl(function6);
    }
}