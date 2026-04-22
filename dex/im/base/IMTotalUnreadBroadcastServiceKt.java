package im.base;

import com.bapis.bilibili.broadcast.message.im.KCommandMsg;
import com.bapis.bilibili.broadcast.message.im.KReqServerNotify;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMTotalUnreadBroadcastService.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isUpdateTotalUnreadCommand", "", "Lcom/bapis/bilibili/broadcast/message/im/KReqServerNotify;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMTotalUnreadBroadcastServiceKt {
    public static final boolean isUpdateTotalUnreadCommand(KReqServerNotify $this$isUpdateTotalUnreadCommand) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter($this$isUpdateTotalUnreadCommand, "<this>");
        Iterable $this$firstOrNull$iv = $this$isUpdateTotalUnreadCommand.getCommandMsgs();
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object element$iv = it.next();
            KCommandMsg it2 = (KCommandMsg) element$iv;
            Object command = it2.getCommand();
            if ((command instanceof KCommandMsg.KUpdateTotalUnreadCommand ? (KCommandMsg.KUpdateTotalUnreadCommand) command : null) != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                obj = element$iv;
                break;
            }
        }
        return obj != null;
    }
}