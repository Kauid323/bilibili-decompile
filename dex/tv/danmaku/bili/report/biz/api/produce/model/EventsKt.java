package tv.danmaku.bili.report.biz.api.produce.model;

import com.bilibili.lib.rpc.track.model.BizEvent;
import com.bilibili.lib.rpc.track.model.NetworkEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: Events.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0005¨\u0006\t"}, d2 = {"isValid", "", "Lcom/bilibili/lib/rpc/track/model/NetworkEvent;", "getHttpMessage", "", "Lcom/bilibili/lib/rpc/track/model/BizEvent;", "isError", "willTrack", "isBizEnd", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EventsKt {
    public static final boolean isValid(NetworkEvent $this$isValid) {
        Intrinsics.checkNotNullParameter($this$isValid, "<this>");
        String host = $this$isValid.getHost();
        Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
        if (!StringsKt.isBlank(host)) {
            String scheme = $this$isValid.getScheme();
            Intrinsics.checkNotNullExpressionValue(scheme, "getScheme(...)");
            if (!StringsKt.isBlank(scheme)) {
                return true;
            }
        }
        return false;
    }

    public static final String getHttpMessage(NetworkEvent $this$getHttpMessage) {
        Intrinsics.checkNotNullParameter($this$getHttpMessage, "<this>");
        String netExceptionMessage = $this$getHttpMessage.getNetExceptionMessage();
        Intrinsics.checkNotNullExpressionValue(netExceptionMessage, "getNetExceptionMessage(...)");
        if (StringsKt.isBlank(netExceptionMessage)) {
            return "";
        }
        return "connect error " + $this$getHttpMessage.getNetExceptionMessage() + "=";
    }

    public static final boolean isValid(BizEvent $this$isValid) {
        Intrinsics.checkNotNullParameter($this$isValid, "<this>");
        String host = $this$isValid.getHost();
        Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
        if (!StringsKt.isBlank(host)) {
            String scheme = $this$isValid.getScheme();
            Intrinsics.checkNotNullExpressionValue(scheme, "getScheme(...)");
            if (!StringsKt.isBlank(scheme)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isError(BizEvent $this$isError) {
        Intrinsics.checkNotNullParameter($this$isError, "<this>");
        return !$this$isError.getRpcSuccess();
    }

    public static final boolean willTrack(BizEvent $this$willTrack) {
        Intrinsics.checkNotNullParameter($this$willTrack, "<this>");
        if ($this$willTrack.getBizCode() == 0) {
            String bizExceptionName = $this$willTrack.getBizExceptionName();
            Intrinsics.checkNotNullExpressionValue(bizExceptionName, "getBizExceptionName(...)");
            if (StringsKt.isBlank(bizExceptionName)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isBizEnd(BizEvent $this$isBizEnd) {
        Intrinsics.checkNotNullParameter($this$isBizEnd, "<this>");
        return $this$isBizEnd.getBizEnd();
    }
}