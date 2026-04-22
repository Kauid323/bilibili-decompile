package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.LruCache;
import c.t.m.g.w5;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public class u6 {
    public static boolean a = false;
    public static SharedPreferences b;

    /* renamed from: c  reason: collision with root package name */
    public static final LruCache<String, Long> f106c = new LruCache<>(30);

    public static boolean a(int i, int i2, int i3, long j) {
        return i >= 0 && i2 >= 0 && i3 > 0 && i3 < 65535 && j > 0 && j < 65535 && i2 != 0;
    }

    public static boolean a(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on") == 1;
        } catch (Throwable th) {
            return false;
        }
    }

    public static CellLocation b(m4 m4Var) {
        TelephonyManager g = m4Var.g();
        if (g != null) {
            try {
                CellLocation __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getCellLocation = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getCellLocation(g);
                a7.c("Cells", "getCellLocation invoke");
                return __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getCellLocation;
            } catch (Exception e) {
                a7.a("CELL", "getCellLocation error.", e);
            }
        }
        return CellLocation.getEmpty();
    }

    public static boolean b(int i, int i2, int i3, long j) {
        int i4;
        int i5;
        return (i < 0 || i2 < 0 || i3 <= 0 || i3 == Integer.MAX_VALUE || j == 268435455 || j == 2147483647L || j == 50594049 || j == 65535 || j <= 0 || i4 == 0 || i5 <= 0) ? false : true;
    }

    public static boolean c(int i) {
        return (i == 85 || i == -1 || i == -115 || i == -88 || i >= 65535) ? false : true;
    }

    public static List<CellInfo> a(m4 m4Var) {
        try {
            List<CellInfo> __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getAllCellInfo = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getAllCellInfo(m4Var.g());
            if (__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getAllCellInfo != null) {
                return __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getAllCellInfo;
            }
        } catch (Throwable th) {
            a7.a("CELL", "getCellInfos error.", th);
        }
        return new ArrayList();
    }

    public static int a(CellLocation cellLocation) {
        if (cellLocation instanceof CdmaCellLocation) {
            return ((CdmaCellLocation) cellLocation).getBaseStationId();
        }
        try {
            return ((GsmCellLocation) cellLocation).getCid();
        } catch (Exception e) {
            return -1;
        }
    }

    public static boolean a(CellLocation cellLocation, CellLocation cellLocation2) {
        if (!c7.b(cellLocation, cellLocation2) && cellLocation.getClass() == cellLocation2.getClass()) {
            return cellLocation instanceof GsmCellLocation ? ((GsmCellLocation) cellLocation).getCid() == ((GsmCellLocation) cellLocation2).getCid() : (cellLocation instanceof CdmaCellLocation) && ((CdmaCellLocation) cellLocation).getBaseStationId() == ((CdmaCellLocation) cellLocation2).getBaseStationId();
        }
        return false;
    }

    public static int b(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        try {
            if (b(i)) {
                return signalStrength.getGsmSignalStrength() - signalStrength2.getGsmSignalStrength();
            }
            if (a(i)) {
                return signalStrength.getCdmaDbm() - signalStrength2.getCdmaDbm();
            }
            return 0;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static boolean b(int i) {
        return i != w5.a.CDMA.ordinal();
    }

    public static boolean a(w5 w5Var) {
        if (c7.a(w5Var)) {
            return false;
        }
        if (a(w5Var.a.ordinal())) {
            return a(w5Var.b, w5Var.f114c, w5Var.d, w5Var.f);
        }
        return b(w5Var.b, w5Var.f114c, w5Var.d, w5Var.f);
    }

    public static boolean a(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        if (signalStrength == null || signalStrength2 == null) {
            return true;
        }
        int abs = Math.abs(b(i, signalStrength, signalStrength2));
        return b(i) ? abs > 3 : a(i) && abs > 6;
    }

    public static boolean a(int i) {
        return i == w5.a.CDMA.ordinal();
    }

    public static synchronized boolean a(String str, w5 w5Var) {
        boolean z;
        synchronized (u6.class) {
            if (w5Var != null) {
                try {
                    if (c(w5Var.e)) {
                        if (b == null) {
                            b = h4.a("LocationSDK");
                        }
                        String string = b.getString(str, "");
                        if (string != null && !string.isEmpty()) {
                            a7.a("Cells", "old cell:" + string);
                            for (String str2 : string.split(com.alipay.sdk.m.q.h.b)) {
                                String[] split = str2.split("\\|");
                                if (split != null && split.length >= 2) {
                                    f106c.put(split[0], Long.valueOf(Long.parseLong(split[1])));
                                }
                            }
                        }
                        w3.a("Cells", "cell cache size = " + f106c.size());
                        w3.a("Cells", "txCellInfo.toBriefString() = " + w5Var.i());
                        Long l = f106c.get(w5Var.i());
                        if (l != null) {
                            w5Var.p = true;
                            w5Var.b(l.longValue());
                            w3.d("CELL", "old cell loc " + l);
                            z = true;
                        } else {
                            f106c.put(w5Var.i(), Long.valueOf(w5Var.e()));
                            z = false;
                        }
                        StringBuilder sb = new StringBuilder();
                        for (Map.Entry<String, Long> entry : f106c.snapshot().entrySet()) {
                            sb.append(entry.getKey()).append("|").append(entry.getValue()).append(com.alipay.sdk.m.q.h.b);
                        }
                        sb.deleteCharAt(sb.length() - 1);
                        SharedPreferences.Editor edit = b.edit();
                        edit.putString(str, sb.toString());
                        edit.apply();
                        return z;
                    }
                } catch (Throwable th) {
                    w3.a("Cells", "", th);
                }
            }
            return false;
        }
    }

    @JvmStatic
    private static List<CellInfo> __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getAllCellInfo(TelephonyManager tm) {
        Intrinsics.checkNotNullParameter(tm, "tm");
        Object defaultReturnValue$iv = CollectionsKt.emptyList();
        PrivacyHelper.CacheDuration defaultCacheTime$iv = PrivacyHelper.CacheDuration.Companion.getNever();
        try {
            if (!PrivacyHelper.INSTANCE.hookEnable$privacy_debug("tm_get_all_cell_info")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "hook disable, tag: [tm_get_all_cell_info]", (Throwable) null, 4, (Object) null);
                Object allCellInfo = tm.getAllCellInfo();
                defaultReturnValue$iv = allCellInfo instanceof List ? allCellInfo : null;
            } else if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("tm_get_all_cell_info")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "user deny, tag: [tm_get_all_cell_info] defaultReturnValue = [" + defaultReturnValue$iv + "]", (Throwable) null, 4, (Object) null);
            } else if (PrivacyHelper.INSTANCE.forbiddenUse$privacy_debug("tm_get_all_cell_info")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "use forbidden, tag: [tm_get_all_cell_info] defaultReturnValue = [" + defaultReturnValue$iv + "]", (Throwable) null, 4, (Object) null);
            } else {
                Object it$iv = PrivacyHelper.access$hitPrivacyCache(PrivacyHelper.INSTANCE, "tm_get_all_cell_info");
                if (it$iv == null) {
                    Object allCellInfo2 = tm.getAllCellInfo();
                    if (!(allCellInfo2 instanceof List)) {
                        allCellInfo2 = null;
                    }
                    Object res$iv = allCellInfo2;
                    if (res$iv != null) {
                        PrivacyHelper.INSTANCE.getPrivacyCache().put("tm_get_all_cell_info", new PrivacyHelper.Cache(res$iv, PrivacyHelper.access$getDDCacheTime(PrivacyHelper.INSTANCE, "tm_get_all_cell_info", defaultCacheTime$iv)));
                    }
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "runOnPrivacyControl tag: tm_get_all_cell_info", (Throwable) null, 4, (Object) null);
                    defaultReturnValue$iv = res$iv;
                } else {
                    defaultReturnValue$iv = it$iv;
                }
            }
        } catch (Throwable t$iv) {
            if (PrivacyHelper.access$getDebug$p()) {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: tm_get_all_cell_info, message = " + t$iv.getMessage(), t$iv);
            } else {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: tm_get_all_cell_info, message = " + t$iv.getMessage(), (Throwable) null);
            }
        }
        return (List) defaultReturnValue$iv;
    }

    @JvmStatic
    private static CellLocation __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getCellLocation(TelephonyManager tm) {
        Intrinsics.checkNotNullParameter(tm, "tm");
        Object defaultReturnValue$iv = CellLocation.getEmpty();
        PrivacyHelper.CacheDuration defaultCacheTime$iv = PrivacyHelper.CacheDuration.Companion.getNever();
        try {
            if (!PrivacyHelper.INSTANCE.hookEnable$privacy_debug("tm_get_cell_location")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "hook disable, tag: [tm_get_cell_location]", (Throwable) null, 4, (Object) null);
                Object cellLocation = tm.getCellLocation();
                defaultReturnValue$iv = cellLocation instanceof CellLocation ? cellLocation : null;
            } else if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("tm_get_cell_location")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "user deny, tag: [tm_get_cell_location] defaultReturnValue = [" + defaultReturnValue$iv + "]", (Throwable) null, 4, (Object) null);
            } else if (PrivacyHelper.INSTANCE.forbiddenUse$privacy_debug("tm_get_cell_location")) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "use forbidden, tag: [tm_get_cell_location] defaultReturnValue = [" + defaultReturnValue$iv + "]", (Throwable) null, 4, (Object) null);
            } else {
                Object it$iv = PrivacyHelper.access$hitPrivacyCache(PrivacyHelper.INSTANCE, "tm_get_cell_location");
                if (it$iv == null) {
                    Object cellLocation2 = tm.getCellLocation();
                    if (!(cellLocation2 instanceof CellLocation)) {
                        cellLocation2 = null;
                    }
                    Object res$iv = cellLocation2;
                    if (res$iv != null) {
                        PrivacyHelper.INSTANCE.getPrivacyCache().put("tm_get_cell_location", new PrivacyHelper.Cache(res$iv, PrivacyHelper.access$getDDCacheTime(PrivacyHelper.INSTANCE, "tm_get_cell_location", defaultCacheTime$iv)));
                    }
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "runOnPrivacyControl tag: tm_get_cell_location", (Throwable) null, 4, (Object) null);
                    defaultReturnValue$iv = res$iv;
                } else {
                    defaultReturnValue$iv = it$iv;
                }
            }
        } catch (Throwable t$iv) {
            if (PrivacyHelper.access$getDebug$p()) {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: tm_get_cell_location, message = " + t$iv.getMessage(), t$iv);
            } else {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: tm_get_cell_location, message = " + t$iv.getMessage(), (Throwable) null);
            }
        }
        return (CellLocation) defaultReturnValue$iv;
    }
}