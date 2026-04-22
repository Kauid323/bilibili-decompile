package tv.danmaku.bili.report.biz.dns.misaka.model;

import com.bilibili.lib.rpc.track.model.dns.DnsEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DnsMisakaModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\u00020\u0006*\u00020\fH\u0002¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/report/biz/dns/misaka/model/DnsMisakaModel;", "", "<init>", "()V", "adapt", "", "", "event", "Lcom/bilibili/lib/rpc/track/model/dns/DnsEvent;", "rate", "", "toIntString", "", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DnsMisakaModel {
    public static final DnsMisakaModel INSTANCE = new DnsMisakaModel();

    private DnsMisakaModel() {
    }

    public final Map<String, String> adapt(DnsEvent event, float rate) {
        Intrinsics.checkNotNullParameter(event, "event");
        String lowerCase = event.getEvent().toString().toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = event.getSource().toString().toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        List resolveIpsList = event.getResolveIpsList();
        Intrinsics.checkNotNullExpressionValue(resolveIpsList, "getResolveIpsList(...)");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("rate", String.valueOf(rate)), TuplesKt.to("event", lowerCase), TuplesKt.to("source", lowerCase2), TuplesKt.to("provider", event.getProvider()), TuplesKt.to("resolve_host", event.getResolveHost()), TuplesKt.to("resolve_fallback", INSTANCE.toIntString(event.getResolveFallback())), TuplesKt.to("resolve_hit", INSTANCE.toIntString(event.getResolveHit())), TuplesKt.to("resolve_ips", CollectionsKt.joinToString$default(resolveIpsList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)), TuplesKt.to("resolve_ttl", String.valueOf(event.getResolveTtl())), TuplesKt.to("resolve_expired", INSTANCE.toIntString(event.getResolveExpired())), TuplesKt.to("resolve_time_remaining", String.valueOf(event.getResolveTimeRemaining())), TuplesKt.to("resolve_tag", event.getResolveTag()), TuplesKt.to("fetch_error_code", String.valueOf(event.getFetchErrorCode())), TuplesKt.to("fetch_error_message", event.getFetchErrorMessage()), TuplesKt.to("process", event.getProcess()), TuplesKt.to("thread", event.getThread())});
    }

    private final String toIntString(boolean $this$toIntString) {
        if ($this$toIntString) {
            return "1";
        }
        return "0";
    }
}