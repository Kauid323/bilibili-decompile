package im.direct.notification.interactive;

import com.bapis.bilibili.im.gateway.interfaces.v1.KCommonMsgCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: INAction.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"logString", "", "Lim/direct/notification/interactive/INAction;", "interactive_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class INActionKt {
    public static final String logString(INAction $this$logString) {
        Intrinsics.checkNotNullParameter($this$logString, "<this>");
        String className = Reflection.getOrCreateKotlinClass($this$logString.getClass()).getSimpleName();
        if (className == null) {
            className = "";
        }
        if ($this$logString instanceof INActionLike) {
            KCommonMsgCard common2 = ((INActionLike) $this$logString).getCard().getCommon();
            return className + " id=" + (common2 != null ? Long.valueOf(common2.getId()) : null);
        } else if ($this$logString instanceof INActionThank) {
            KCommonMsgCard common3 = ((INActionThank) $this$logString).getCard().getCommon();
            return className + " id=" + (common3 != null ? Long.valueOf(common3.getId()) : null);
        } else if ($this$logString instanceof INActionDelete) {
            KCommonMsgCard common4 = ((INActionDelete) $this$logString).getCard().getCommon();
            return className + " id=" + (common4 != null ? Long.valueOf(common4.getId()) : null);
        } else if ($this$logString instanceof INActionMuteMsg) {
            KCommonMsgCard common5 = ((INActionMuteMsg) $this$logString).getCard().getCommon();
            return className + " id=" + (common5 != null ? Long.valueOf(common5.getId()) : null);
        } else if ($this$logString instanceof INActionClickCard) {
            KCommonMsgCard common6 = ((INActionClickCard) $this$logString).getCard().getCommon();
            return className + " id=" + (common6 != null ? Long.valueOf(common6.getId()) : null);
        } else if ($this$logString instanceof INActionChangeFilter) {
            return className + " filter=" + ((INActionChangeFilter) $this$logString).getFilter().getTitle();
        } else {
            return className;
        }
    }
}