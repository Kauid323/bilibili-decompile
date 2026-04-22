package tv.danmaku.bili.moss.test.cases.unary.ticket;

import com.bilibili.lib.ticket.api.BiliTickets;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: TicketService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0001\u001a\b\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0003"}, d2 = {"testGetTicketSync", "", "testGetTicketAsync", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TicketServiceKt {
    public static final void testGetTicketSync() {
        BiliTickets.INSTANCE.getTicketSyncWRetry();
    }

    public static final void testGetTicketAsync() {
    }
}