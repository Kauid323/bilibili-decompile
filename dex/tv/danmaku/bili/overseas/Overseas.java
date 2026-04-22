package tv.danmaku.bili.overseas;

import android.app.Application;
import com.bilibili.app.preferences.fragment.PrefProvider;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.RawKV;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.overseas.internal.NetChange;
import tv.danmaku.bili.overseas.internal.httpdns.AppHttpDnsKt;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: Overseas.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\t¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/overseas/Overseas;", "", "<init>", "()V", "init", "", "app", "Landroid/app/Application;", "setSp", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "sp", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Overseas {
    public static final int $stable = 0;
    public static final Overseas INSTANCE = new Overseas();

    private Overseas() {
    }

    public final void init(Application app, Function1<? super String, Unit> function1) {
        PrefProvider pref;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(function1, "setSp");
        RawKV prefs = BLKV.getKvs(app, "network_msg", true, (int) MisakaHelper.MAX_REPORT_SIZE);
        boolean netAutoSelected = prefs.getBoolean("net_auto_selected", true);
        if (netAutoSelected) {
            NetChange.Companion.getInstance().init(app, function1);
            return;
        }
        try {
            pref = PrefProvider.valueOf(prefs.getString("user_select_service", "MAINLAND"));
        } catch (Exception e) {
            pref = PrefProvider.MAINLAND;
        }
        AppHttpDnsKt.setRuntimeProvier(pref, function1);
    }
}