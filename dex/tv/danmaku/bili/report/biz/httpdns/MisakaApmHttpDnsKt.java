package tv.danmaku.bili.report.biz.httpdns;

import com.alibaba.fastjson.JSON;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.httpdns.DNSRecord;
import com.bilibili.lib.httpdns.HttpDNSApiQualityReporter;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.httpdns.AppHttpDnsProvider;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;

/* compiled from: MisakaApmHttpDns.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0005H\u0002\u001a\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002\u001a\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"MISAKA_APM_LOGID_HTTP_DNS", "", "report", "", "event", "Lcom/bilibili/lib/httpdns/HttpDNSApiQualityReporter$Event;", "asMaps", "", "", "getThrowableString", "t", "", "getResult", "Lkotlin/Pair;", "records", "", "Lcom/bilibili/lib/httpdns/DNSRecord;", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MisakaApmHttpDnsKt {
    private static final long MISAKA_APM_LOGID_HTTP_DNS = 100006;

    public static final void report(HttpDNSApiQualityReporter.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Map data = asMaps(event);
        Boolean bool = (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "ff_misaka_httpdns", (Object) null, 2, (Object) null);
        final boolean enable = bool != null ? bool.booleanValue() : true;
        Neurons.trackT$default(false, "ops.misaka.app-httpdns", data, 0, new Function0() { // from class: tv.danmaku.bili.report.biz.httpdns.MisakaApmHttpDnsKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean report$lambda$0;
                report$lambda$0 = MisakaApmHttpDnsKt.report$lambda$0(enable);
                return Boolean.valueOf(report$lambda$0);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean report$lambda$0(boolean $enable) {
        return $enable;
    }

    private static final Map<String, String> asMaps(HttpDNSApiQualityReporter.Event $this$asMaps) {
        HashMap map = new HashMap();
        map.put("http_code", String.valueOf($this$asMaps.httpCode));
        map.put("error_message", getThrowableString($this$asMaps.throwable));
        map.put("cost_time", String.valueOf($this$asMaps.timeCost));
        HashMap hashMap = map;
        String str = $this$asMaps.httpDnsIp;
        if (str == null) {
            str = "";
        }
        hashMap.put("http_dns_ip", str);
        List list = $this$asMaps.records;
        Intrinsics.checkNotNullExpressionValue(list, "records");
        Pair<String, String> result = getResult(list);
        String provider = (String) result.component1();
        String result2 = (String) result.component2();
        map.put(AppHttpDnsProvider.EXTRA_KEY_DNS, result2);
        map.put("http_dns_provider", provider);
        if ($this$asMaps.records.size() > 0) {
            HashMap hashMap2 = map;
            String str2 = ((DNSRecord) $this$asMaps.records.get(0)).host;
            if (str2 == null) {
                str2 = "";
            }
            hashMap2.put(ReportEvent.Tag.HOST, str2);
            if (((DNSRecord) $this$asMaps.records.get(0)).ips != null && ((DNSRecord) $this$asMaps.records.get(0)).ips.size() > 0) {
                HashMap hashMap3 = map;
                String str3 = (String) ((DNSRecord) $this$asMaps.records.get(0)).ips.get(0);
                hashMap3.put("target_ip", str3 != null ? str3 : "");
            }
        }
        return map;
    }

    private static final String getThrowableString(Throwable t) {
        if (t != null) {
            String name = t.getClass().getName();
            return name + t.getMessage();
        }
        return "";
    }

    private static final Pair<String, String> getResult(List<? extends DNSRecord> list) {
        if (list.size() > 0) {
            return new Pair<>(list.get(0).provider, JSON.toJSONString(list));
        }
        return new Pair<>("", "");
    }
}