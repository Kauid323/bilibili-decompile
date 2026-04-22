package tv.danmaku.bili.bilow;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.bilibili.base.BiliContext;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.droid.DeviceInfo;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.biliid.api.BiliIds;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.nativelibrary.LibBili;
import com.bilibili.nativelibrary.Rt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.util.AppBuildConfig;
import tv.danmaku.bili.BR;

/* compiled from: Defend.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0003¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/bilow/Defend;", "", "<init>", "()V", "init", "", "context", "Landroid/content/Context;", "doInit", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Defend {
    public static final int $stable = 0;
    public static final Defend INSTANCE = new Defend();

    private Defend() {
    }

    @JvmStatic
    public static final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HandlerThreads.postDelayed(2, new Runnable() { // from class: tv.danmaku.bili.bilow.Defend$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Defend.init$lambda$0();
            }
        }, 750L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0() {
        INSTANCE.doInit();
    }

    private final void doInit() {
        boolean isDefendEnabled;
        long interval;
        isDefendEnabled = DefendKt.isDefendEnabled();
        if (isDefendEnabled) {
            interval = DefendKt.interval();
            LibBili.d(interval, new Rt() { // from class: tv.danmaku.bili.bilow.Defend$doInit$1
                public String m() {
                    long mid = BiliAccounts.get(BiliContext.application()).mid();
                    if (mid > 0) {
                        return String.valueOf(mid);
                    }
                    return "";
                }

                public String b() {
                    return BuvidHelper.getBuvid();
                }

                public String u() {
                    String defaultFullUa = UserAgents.defaultFullUa();
                    Intrinsics.checkNotNullExpressionValue(defaultFullUa, "defaultFullUa(...)");
                    return defaultFullUa;
                }

                public int a() {
                    AppBuildConfig.Companion companion = AppBuildConfig.Companion;
                    Application application = BiliContext.application();
                    Intrinsics.checkNotNull(application);
                    return companion.getNeuronAppId(application);
                }

                public int v() {
                    return FoundationAlias.getFapps().getInternalVersionCode();
                }

                public String i() {
                    return FoundationAlias.getFapps().getFawkesBuildSN();
                }

                public int n() {
                    return ConnectivityMonitor.getInstance().getNetwork();
                }

                public String r() {
                    String str = Build.BRAND;
                    return str == null ? "" : str;
                }

                public String o() {
                    String str = Build.MODEL;
                    return str == null ? "" : str;
                }

                public long f() {
                    return EnvironmentManager.getInstance().getFirstRunTime();
                }

                public String p() {
                    String fingerprint = BiliIds.fingerprint();
                    Intrinsics.checkNotNullExpressionValue(fingerprint, "fingerprint(...)");
                    return fingerprint;
                }

                public String w() {
                    Application application = BiliContext.application();
                    Intrinsics.checkNotNull(application);
                    String wifiMacAddr = DeviceInfo.getWifiMacAddr(application);
                    return wifiMacAddr == null ? "" : wifiMacAddr;
                }
            });
        }
    }
}