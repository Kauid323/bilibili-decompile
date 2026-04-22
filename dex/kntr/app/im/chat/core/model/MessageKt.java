package kntr.app.im.chat.core.model;

import kotlin.Metadata;

/* compiled from: Message.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¨\u0006\u0002"}, d2 = {"nextSendSequence", "Lkntr/app/im/chat/core/model/MessageSequence;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MessageKt {
    public static final MessageSequence nextSendSequence(MessageSequence $this$nextSendSequence) {
        return MessageSequence.nextSendSequence$default($this$nextSendSequence == null ? MessageSequence.Companion.getEmpty() : $this$nextSendSequence, 0L, 1, null);
    }
}