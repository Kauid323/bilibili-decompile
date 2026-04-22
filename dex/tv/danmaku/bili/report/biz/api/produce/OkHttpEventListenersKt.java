package tv.danmaku.bili.report.biz.api.produce;

import com.bilibili.lib.okhttp.track.OkHttpEventListener;
import com.bilibili.lib.rpc.aurora.AuroraRoute;
import com.bilibili.lib.rpc.flowcontrol.FlowControl;
import com.bilibili.lib.rpc.gaia.Gaia;
import com.bilibili.lib.rpc.report.HttpReporter;
import com.bilibili.lib.rpc.ticket.Ticket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.EventListener;
import tv.danmaku.bili.BR;

/* compiled from: OkHttpEventListeners.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"factory", "Lokhttp3/EventListener$Factory;", "consumer", "Lcom/bilibili/lib/rpc/report/HttpReporter;", "flowControl", "Lcom/bilibili/lib/rpc/flowcontrol/FlowControl;", "auroraRoute", "Lcom/bilibili/lib/rpc/aurora/AuroraRoute;", "ticket", "Lcom/bilibili/lib/rpc/ticket/Ticket;", "gaia", "Lcom/bilibili/lib/rpc/gaia/Gaia;", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OkHttpEventListenersKt {
    public static final EventListener.Factory factory(final HttpReporter consumer, final FlowControl flowControl, final AuroraRoute auroraRoute, final Ticket ticket, final Gaia gaia) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(flowControl, "flowControl");
        Intrinsics.checkNotNullParameter(auroraRoute, "auroraRoute");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(gaia, "gaia");
        return new EventListener.Factory() { // from class: tv.danmaku.bili.report.biz.api.produce.OkHttpEventListenersKt$$ExternalSyntheticLambda0
            public final EventListener create(Call call) {
                EventListener factory$lambda$0;
                factory$lambda$0 = OkHttpEventListenersKt.factory$lambda$0(consumer, flowControl, auroraRoute, ticket, gaia, call);
                return factory$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventListener factory$lambda$0(HttpReporter $consumer, FlowControl $flowControl, AuroraRoute $auroraRoute, Ticket $ticket, Gaia $gaia, Call call) {
        return new OkHttpEventListener($consumer, $flowControl, $auroraRoute, $ticket, $gaia);
    }
}