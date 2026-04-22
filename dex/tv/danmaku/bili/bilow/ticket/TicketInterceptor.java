package tv.danmaku.bili.bilow.ticket;

import com.bilibili.lib.okhttp.track.tag.RpcTag;
import com.bilibili.lib.okhttp.track.utils.TagUtilsKt;
import com.bilibili.lib.rpc.ticket.Ticket;
import com.bilibili.lib.rpc.track.model.RpcExtra;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: TicketInterceptor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/bilow/ticket/TicketInterceptor;", "Lokhttp3/Interceptor;", "ticket", "Lcom/bilibili/lib/rpc/ticket/Ticket;", "<init>", "(Lcom/bilibili/lib/rpc/ticket/Ticket;)V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TicketInterceptor implements Interceptor {
    private final Ticket ticket;

    public TicketInterceptor(Ticket ticket) {
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        this.ticket = ticket;
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String host = request.url().host();
        String path = request.url().encodedPath();
        Ticket ticket = this.ticket;
        Intrinsics.checkNotNull(host);
        Intrinsics.checkNotNull(path);
        String xticket = ticket.onTicketReq(host, path);
        RpcTag rpcTag = TagUtilsKt.getRpcTag(request.tag());
        RpcExtra extra = rpcTag != null ? rpcTag.getExtra() : null;
        if (extra != null) {
            extra.setXBiliTicket(xticket);
        } else {
            BLog.ifmt("okhttp.ticket", "can not add xticket = %s", xticket);
        }
        Response proceed = chain.proceed(request.newBuilder().header("x-bili-ticket", xticket).build());
        Intrinsics.checkNotNullExpressionValue(proceed, "proceed(...)");
        return proceed;
    }
}