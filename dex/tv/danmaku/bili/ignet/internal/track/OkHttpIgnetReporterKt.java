package tv.danmaku.bili.ignet.internal.track;

import com.bilibili.gripper.api.network.GNetQuality;
import com.bilibili.gripper.api.riskcontrol.GRiskControl;
import com.bilibili.lib.ighttp.IgHttpReporter;
import com.bilibili.lib.rpc.aurora.AuroraRoute;
import com.bilibili.lib.rpc.flowcontrol.FlowControl;
import com.bilibili.lib.rpc.gaia.Gaia;
import com.bilibili.lib.rpc.report.HttpReporter;
import com.bilibili.lib.rpc.ticket.Ticket;
import com.bilibili.lib.ticket.api.BiliTickets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.aurora.api.zone.AuroraZone;
import tv.danmaku.bili.bilow.gaia.GaiaImpl;
import tv.danmaku.bili.flowcontrol.api.FlowControls;
import tv.danmaku.bili.report.biz.api.consume.OkHttpReporter;

/* compiled from: OkHttpIgnetReporter.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"TAG", "", "trackRepoter", "Lcom/bilibili/lib/ighttp/IgHttpReporter;", "reporter", "Lcom/bilibili/lib/rpc/report/HttpReporter;", "netQuality", "Lcom/bilibili/gripper/api/network/GNetQuality;", "flowControl", "Lcom/bilibili/lib/rpc/flowcontrol/FlowControl;", "auroraRoute", "Lcom/bilibili/lib/rpc/aurora/AuroraRoute;", "ticket", "Lcom/bilibili/lib/rpc/ticket/Ticket;", "gaia", "Lcom/bilibili/lib/rpc/gaia/Gaia;", "okhttpIgnetRepoter", "riskControl", "Lcom/bilibili/gripper/api/riskcontrol/GRiskControl;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OkHttpIgnetReporterKt {
    private static final String TAG = "okhttp.ignet.track";

    public static final IgHttpReporter trackRepoter(HttpReporter reporter, GNetQuality netQuality, FlowControl flowControl, AuroraRoute auroraRoute, Ticket ticket, Gaia gaia) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(flowControl, "flowControl");
        Intrinsics.checkNotNullParameter(auroraRoute, "auroraRoute");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(gaia, "gaia");
        return new OkHttpIgnetReporter(reporter, netQuality, flowControl, auroraRoute, ticket, gaia);
    }

    public static final IgHttpReporter okhttpIgnetRepoter(GRiskControl riskControl, GNetQuality netQuality) {
        return trackRepoter(new OkHttpReporter(), netQuality, FlowControls.INSTANCE, AuroraZone.INSTANCE, BiliTickets.INSTANCE, new GaiaImpl(riskControl));
    }
}