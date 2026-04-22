package kntr.app.im.chat.ui.builder;

import java.util.Map;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.ui.neuron.CardReporter;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMsgFrameBuilder.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"ChatMsgFrameScope", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "msgType", RoomRecommendViewModel.EMPTY_CURSOR, "entityMessage", "Lkntr/app/im/chat/core/model/EntityMessage;", "chatReporter", "Lkntr/app/im/chat/ui/neuron/ChatReporter;", "ChatMsgFrameScope-kHDZbjc", "(FLjava/lang/String;Lkntr/app/im/chat/core/model/EntityMessage;Lkntr/app/im/chat/ui/neuron/ChatReporter;)Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgFrameBuilderKt {
    /* renamed from: ChatMsgFrameScope-kHDZbjc  reason: not valid java name */
    public static final ChatMsgFrameScope m1725ChatMsgFrameScopekHDZbjc(float f, final String msgType, final EntityMessage entityMessage, final ChatReporter chatReporter) {
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(entityMessage, "entityMessage");
        return new MaxWidthChatMsgFrameScopeImpl(f, new CardReporter() { // from class: kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderKt$ChatMsgFrameScope$1
            @Override // kntr.app.im.chat.ui.neuron.CardReporter
            public void reportMsgClick(Map<String, String> map) {
                Intrinsics.checkNotNullParameter(map, "cardEventMap");
                ChatReporter chatReporter2 = ChatReporter.this;
                if (chatReporter2 != null) {
                    chatReporter2.reportMsgClick(msgType, MapsKt.plus(entityMessage.getTraceParams(), map));
                }
            }
        }, null);
    }
}