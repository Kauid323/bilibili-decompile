package tv.danmaku.bili.httpdns.api;

import bolts.Task;
import com.bilibili.gripper.api.network.GHttpDnsProvider;
import com.bilibili.lib.foundation.FoundationAlias;
import dagger.hilt.EntryPoints;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.BR;

/* compiled from: AppHttpDns.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\b\u001a\u00020\u0001\u001a\u0006\u0010\t\u001a\u00020\u0001\u001a\b\u0010\n\u001a\u00020\u000bH\u0007\"\u001b\u0010\u0002\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"init", "", "selectedDns", "Lcom/bilibili/gripper/api/network/GHttpDnsProvider;", "getSelectedDns", "()Lcom/bilibili/gripper/api/network/GHttpDnsProvider;", "selectedDns$delegate", "Lkotlin/Lazy;", "prefetch", "clearCache", "getClientIp", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppHttpDnsKt {
    private static final Lazy selectedDns$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.httpdns.api.AppHttpDnsKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            GHttpDnsProvider selectedDns_delegate$lambda$0;
            selectedDns_delegate$lambda$0 = AppHttpDnsKt.selectedDns_delegate$lambda$0();
            return selectedDns_delegate$lambda$0;
        }
    });

    public static final void init() {
    }

    public static final GHttpDnsProvider getSelectedDns() {
        return (GHttpDnsProvider) selectedDns$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GHttpDnsProvider selectedDns_delegate$lambda$0() {
        return ((GHttpDnsProvider.Fetcher) EntryPoints.get(FoundationAlias.getFapp(), GHttpDnsProvider.Fetcher.class)).getSelectedDns();
    }

    public static final void prefetch() {
        getSelectedDns().prefetch();
    }

    public static final void clearCache() {
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.httpdns.api.AppHttpDnsKt$clearCache$1
            @Override // java.util.concurrent.Callable
            public final Void call() {
                AppHttpDnsKt.getSelectedDns().clearCache();
                return null;
            }
        });
    }

    public static final String getClientIp() {
        return getSelectedDns().getClientIp();
    }
}