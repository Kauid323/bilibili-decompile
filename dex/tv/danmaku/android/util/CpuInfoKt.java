package tv.danmaku.android.util;

import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.CpuUtils;
import tv.danmaku.bili.BR;

/* compiled from: CpuInfo.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\b\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\u001a\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0002\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"'\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\t\u0010\n\"\u0011\u0010\f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0011\u0010\u000f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\"\u0011\u0010\u0011\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e\"\u0011\u0010\u0013\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\"\u0011\u0010\u0015\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000e\"\u0011\u0010\u0017\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000e¨\u0006\u001e"}, d2 = {"devicePrefArch", "Ltv/danmaku/android/util/CpuUtils$ARCH;", "getDevicePrefArch", "()Ltv/danmaku/android/util/CpuUtils$ARCH;", "devicePrefArch$delegate", "Lkotlin/Lazy;", "cpuInfo", "", "", "getCpuInfo", "()Ljava/util/Map;", "cpuInfo$delegate", "cpuModuleName", "getCpuModuleName", "()Ljava/lang/String;", "cpuImplementer", "getCpuImplementer", "cpuVendorId", "getCpuVendorId", "cpuHardWare", "getCpuHardWare", "cpuProcessor", "getCpuProcessor", "cpuFeatures", "getCpuFeatures", "internalGetDevicePrefArch", "parseCpuInfo", "isX86", "", "vendorId", "base_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CpuInfoKt {
    private static final Lazy devicePrefArch$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.android.util.CpuInfoKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            CpuUtils.ARCH devicePrefArch_delegate$lambda$0;
            devicePrefArch_delegate$lambda$0 = CpuInfoKt.devicePrefArch_delegate$lambda$0();
            return devicePrefArch_delegate$lambda$0;
        }
    });
    private static final Lazy cpuInfo$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.android.util.CpuInfoKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            Map cpuInfo_delegate$lambda$0;
            cpuInfo_delegate$lambda$0 = CpuInfoKt.cpuInfo_delegate$lambda$0();
            return cpuInfo_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final CpuUtils.ARCH devicePrefArch_delegate$lambda$0() {
        return internalGetDevicePrefArch();
    }

    public static final CpuUtils.ARCH getDevicePrefArch() {
        return (CpuUtils.ARCH) devicePrefArch$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map cpuInfo_delegate$lambda$0() {
        return parseCpuInfo();
    }

    private static final Map<String, String> getCpuInfo() {
        return (Map) cpuInfo$delegate.getValue();
    }

    public static final String getCpuModuleName() {
        String str = getCpuInfo().get("model name");
        return str == null ? "" : str;
    }

    public static final String getCpuImplementer() {
        String str = getCpuInfo().get("cpu implementer");
        return str == null ? "" : str;
    }

    public static final String getCpuVendorId() {
        String str = getCpuInfo().get("vendor_id");
        return str == null ? "" : str;
    }

    public static final String getCpuHardWare() {
        String str = getCpuInfo().get("hardware");
        return str == null ? "" : str;
    }

    public static final String getCpuProcessor() {
        String str = getCpuInfo().get("processor");
        return str == null ? "" : str;
    }

    public static final String getCpuFeatures() {
        String str = getCpuInfo().get("features");
        return str == null ? "" : str;
    }

    private static final CpuUtils.ARCH internalGetDevicePrefArch() {
        CpuUtils.ARCH arch = CpuUtils.ARCH.Unknown;
        try {
            String pref = Build.SUPPORTED_ABIS[0];
            Intrinsics.checkNotNull(pref);
            if (StringsKt.contains$default(pref, "64", false, 2, (Object) null)) {
                CpuUtils.ARCH myCpuArchByFile = CpuUtils.getMyCpuArchByFile(new File(Environment.getRootDirectory(), "lib64/libc.so"));
                Intrinsics.checkNotNullExpressionValue(myCpuArchByFile, "getMyCpuArchByFile(...)");
                arch = myCpuArchByFile;
            }
            if (arch != CpuUtils.ARCH.Unknown) {
                String value = arch.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                if (StringsKt.contains$default(value, "64", false, 2, (Object) null)) {
                    return arch;
                }
            }
            CpuUtils.ARCH arch2 = CpuUtils.getMyCpuArchByFile(new File(Environment.getRootDirectory(), "lib/libc.so"));
            Intrinsics.checkNotNullExpressionValue(arch2, "getMyCpuArchByFile(...)");
            return arch2;
        } catch (Exception e) {
            BLog.e(e.getMessage(), e);
            return arch;
        }
    }

    private static final Map<String, String> parseCpuInfo() {
        String str;
        final Map rawMap = new LinkedHashMap();
        boolean z = true;
        try {
            FilesKt.forEachLine$default(new File("/proc/cpuinfo"), (Charset) null, new Function1() { // from class: tv.danmaku.android.util.CpuInfoKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit parseCpuInfo$lambda$0;
                    parseCpuInfo$lambda$0 = CpuInfoKt.parseCpuInfo$lambda$0(rawMap, (String) obj);
                    return parseCpuInfo$lambda$0;
                }
            }, 1, (Object) null);
        } catch (Exception e) {
            BLog.e("fail to read cpu info", e);
        }
        String hardware = (String) rawMap.get("hardware");
        if (hardware == null) {
            hardware = "";
        }
        if (hardware.length() == 0) {
            String cpuModel = (String) rawMap.get("model name");
            if (cpuModel == null) {
                cpuModel = "";
            }
            String str2 = (String) rawMap.get("vendor_id");
            String vendorId = str2 != null ? str2 : "";
            if (isX86(vendorId)) {
                if (cpuModel.length() > 0) {
                    str = cpuModel;
                    rawMap.put("hardware", str);
                }
            }
            String str3 = Build.HARDWARE;
            if (str3 != null && str3.length() != 0) {
                z = false;
            }
            if (!z) {
                str = Build.HARDWARE;
            } else {
                str = "Unknown";
            }
            rawMap.put("hardware", str);
        }
        return rawMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit parseCpuInfo$lambda$0(Map $rawMap, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        List kv = StringsKt.split$default(StringsKt.trim(it).toString(), new char[]{':'}, false, 0, 6, (Object) null);
        if (kv.size() >= 2) {
            String k = StringsKt.trim((String) kv.get(0)).toString().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(k, "toLowerCase(...)");
            String v = StringsKt.trim((String) kv.get(1)).toString();
            if (Intrinsics.areEqual(k, "processor")) {
                if (StringsKt.toIntOrNull(v) == null) {
                    $rawMap.put(k, v);
                }
            } else {
                $rawMap.put(k, v);
            }
        }
        return Unit.INSTANCE;
    }

    private static final boolean isX86(String vendorId) {
        return Intrinsics.areEqual(vendorId, "GenuineIntel");
    }
}