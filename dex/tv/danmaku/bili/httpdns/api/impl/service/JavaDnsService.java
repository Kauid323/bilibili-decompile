package tv.danmaku.bili.httpdns.api.impl.service;

import android.app.Application;
import com.bilibili.gripper.api.network.GHttpDnsProvider;
import com.bilibili.netdiagnose.diagnose.service.DNSService;
import dagger.hilt.EntryPoints;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.httpdns.AppHttpDnsProvider;

/* compiled from: DnsService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b\u0018\u00010\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/httpdns/api/impl/service/JavaDnsService;", "Lcom/bilibili/netdiagnose/diagnose/service/DNSService;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "getApp", "()Landroid/app/Application;", AppHttpDnsProvider.FUNC_GET_DNS, "", "", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Named("JavaDns")
public final class JavaDnsService implements DNSService {
    public static final int $stable = 8;
    private final Application app;

    public JavaDnsService(Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
    }

    public final Application getApp() {
        return this.app;
    }

    public Map<String, List<String>> getDns() {
        GHttpDnsProvider dns = ((GHttpDnsProvider.Fetcher) EntryPoints.get(this.app, GHttpDnsProvider.Fetcher.class)).getSelectedDns();
        return dns.getCacheSnapshot();
    }
}