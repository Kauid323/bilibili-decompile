package kntr.app.im.chat.service.sender;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.EntityMessageLensKt;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.model.MessageSequence;
import kntr.app.im.chat.core.model.SendStatus;
import kntr.app.im.chat.utils.UUIDKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* compiled from: MessageSender.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"rebuildMessage", "Lkntr/app/im/chat/core/model/EntityMessage;", "oldValue", "sequence", "Lkntr/app/im/chat/core/model/MessageSequence;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MessageSenderKt {
    public static final EntityMessage rebuildMessage(final EntityMessage oldValue, final MessageSequence sequence) {
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        return (EntityMessage) CopyScopeKt.copy(oldValue, new Function1() { // from class: kntr.app.im.chat.service.sender.MessageSenderKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit rebuildMessage$lambda$0;
                rebuildMessage$lambda$0 = MessageSenderKt.rebuildMessage$lambda$0(EntityMessage.this, sequence, (CopyScope) obj);
                return rebuildMessage$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rebuildMessage$lambda$0(EntityMessage $oldValue, MessageSequence $sequence, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(EntityMessageLensKt.getMsgId(EntityMessage.Companion), new MessageId($oldValue.getMsgId().getSessionId(), $oldValue.getMsgId().getMsgKey(), $sequence));
        $this$copy.set(EntityMessageLensKt.getToken(EntityMessage.Companion), UUIDKt.generateUUID());
        $this$copy.set(EntityMessageLensKt.getTimestamp(EntityMessage.Companion), Clock.System.INSTANCE.now());
        $this$copy.set(EntityMessageLensKt.getSendStatus(EntityMessage.Companion), SendStatus.Sending);
        return Unit.INSTANCE;
    }
}