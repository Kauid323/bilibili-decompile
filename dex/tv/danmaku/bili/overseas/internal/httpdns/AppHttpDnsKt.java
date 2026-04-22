package tv.danmaku.bili.overseas.internal.httpdns;

import com.bilibili.app.preferences.fragment.PrefProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.httpdns.api.ConstsKt;
import tv.danmaku.bili.overseas.internal.NetChangeKt;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: AppHttpDns.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0005¨\u0006\n"}, d2 = {"setRuntimeProvier", "", "pref", "Lcom/bilibili/app/preferences/fragment/PrefProvider;", "setRuntimeProvider", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "sp", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppHttpDnsKt {
    public static final void setRuntimeProvier(PrefProvider pref, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(pref, "pref");
        Intrinsics.checkNotNullParameter(function1, "setRuntimeProvider");
        String provider = pref == PrefProvider.MAINLAND ? ConstsKt.SP_BILI : ConstsKt.SP_GOOGLE;
        function1.invoke(provider);
        BLog.i(NetChangeKt.TAG, "setProvider " + provider);
    }
}