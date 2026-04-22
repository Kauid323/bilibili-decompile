package c.t.m.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Looper;
import android.os.Message;
import com.ashampoo.kim.format.jpeg.iptc.IptcConstants;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public class f0 extends m2 {
    public h0 h;
    public d0 i;
    public long e = 5000;
    public CopyOnWriteArrayList<s> j = new CopyOnWriteArrayList<>();
    public g0 f = new g0();
    public e0 g = new e0();

    public f0() {
        h();
    }

    @Override // c.t.m.g.p2
    public String a() {
        return "ArMgrImpl";
    }

    public boolean a(String str, String str2) {
        try {
            n0.a("ArMgrImpl", "setArData:" + str + "," + str2);
        } catch (Throwable th) {
        }
        if ("set_is_d".equals(str)) {
            m0.f63c = "true".equals(str2);
        } else if ("set_ar_detect_cycle".equals(str)) {
            this.e = a(Long.parseLong(str2), 1000L, 15000L);
        } else if ("set_ar_model_tran_p".equals(str)) {
            return a(o0.a, str2);
        } else {
            if ("set_ar_speed_model".equals(str)) {
                return a(o0.b, str2);
            }
            if ("set_ar_svm_coefs".equals(str)) {
                return a(z.d, str2);
            }
            if ("set_ar_svm_bias".equals(str)) {
                return a(z.e, str2);
            }
            if ("set_ar_lr_coefs".equals(str)) {
                return a(x.a, str2);
            }
            if ("set_ar_lr_bias".equals(str)) {
                return a(x.b, str2);
            }
            if ("set_ar_open_available_checker".equals(str)) {
                t.i = Boolean.parseBoolean(str2);
            } else {
                if ("set_ar_register_gps_type".equals(str)) {
                    this.g.a(Integer.parseInt(str2));
                }
                return false;
            }
        }
        return true;
    }

    public void b(s sVar) {
        if (sVar == null) {
            this.j.clear();
            n0.a("ArMgrImpl", "removeArListener:clear all");
            return;
        }
        this.j.remove(sVar);
        n0.a("ArMgrImpl", "removeArListener:" + sVar.getClass().getSimpleName() + "@" + Integer.toHexString(sVar.hashCode()));
    }

    @Override // c.t.m.g.p2
    public void c() {
        a(this.f, this.g, this.h);
        d0 d0Var = this.i;
        if (d0Var != null) {
            d0Var.e();
        }
        this.i = null;
        n0.a("ArMgrImpl", "status : [shutdown]");
    }

    @Override // c.t.m.g.m2
    public int g() {
        int b = b() ? 4 : b(b3.a());
        if (b == 0 || b == 6) {
            b = super.g();
            if (b < 0) {
                b = 100;
            }
            if (b != 0) {
                super.a(200L);
            }
        }
        n0.a("ArMgrImpl", "startup : " + b + ", ar : " + r.a() + ", common lib: " + b2.a());
        return b;
    }

    public final void h() {
        n0.a("ArMgrImpl", "set ar default settings.");
        for (Map.Entry<String, String> entry : o0.a().entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public final void b(q qVar) {
        Iterator<s> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().c(qVar);
        }
    }

    public static int b(Context context) {
        return a(context);
    }

    public final void c(q qVar) {
        Iterator<s> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().b(qVar);
        }
    }

    public final boolean a(double[][] dArr, String str) {
        String[] split = str.split(com.alipay.sdk.m.q.h.b);
        if (split.length != dArr.length) {
            return false;
        }
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, dArr.length, dArr[0].length);
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split(",");
            if (split2.length != dArr[i].length) {
                return false;
            }
            for (int i2 = 0; i2 < split2.length; i2++) {
                dArr2[i][i2] = Double.parseDouble(split2[i2]);
            }
        }
        f2.a(dArr, dArr2);
        return true;
    }

    public final boolean a(double[] dArr, String str) {
        String[] split = str.split(",");
        if (split.length != dArr.length) {
            return false;
        }
        double[] a = r2.a().a(dArr.length);
        for (int i = 0; i < a.length; i++) {
            a[i] = Double.parseDouble(split[i]);
        }
        System.arraycopy(a, 0, dArr, 0, dArr.length);
        r2.a().a(a);
        return true;
    }

    public final long a(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    @Override // c.t.m.g.p2
    public int a(Looper looper) {
        try {
            Looper looper2 = e() == null ? null : e().getLooper();
            if (looper2 == null) {
                return -1;
            }
            int b = b(b3.a());
            if (b == 0 || b == 6) {
                d0 d0Var = new d0();
                this.i = d0Var;
                d0Var.a(3, 25, 0.8f, o0.a, o0.b, z.d, z.e, b);
                a(this.f, looper2);
                a(this.g, looper2);
                a(this.h, looper2);
                a(IptcConstants.IMAGE_RESOURCE_BLOCK_MACINTOSH_PRINT_INFO, 2000L);
                n0.a("ArMgrImpl", "ar listeners size = " + this.j.size());
                return 0;
            }
            return -2;
        } catch (Throwable th) {
            n0.a("ArMgrImpl", "startupSubPro error.", th);
            return th instanceof UnsatisfiedLinkError ? 5 : -1;
        }
    }

    public final void a(n2 n2Var, Looper looper) {
        if (n2Var != null) {
            n2Var.a(looper);
        }
    }

    public final void a(n2... n2VarArr) {
        for (n2 n2Var : n2VarArr) {
            if (n2Var != null) {
                n2Var.c();
            }
        }
    }

    public void a(s sVar) {
        if (this.j.contains(sVar)) {
            return;
        }
        this.j.add(sVar);
        n0.a("ArMgrImpl", "addArListener:" + sVar.getClass().getSimpleName() + "@" + Integer.toHexString(sVar.hashCode()));
    }

    @Override // c.t.m.g.m2
    public void a(Message message) {
        double[] b;
        double[] a;
        if (d() != null && message.what == 1001) {
            a(IptcConstants.IMAGE_RESOURCE_BLOCK_MACINTOSH_PRINT_INFO, this.e);
            long currentTimeMillis = System.currentTimeMillis();
            j0 j0Var = new j0();
            if (m0.b && (a = this.i.a(currentTimeMillis)) != null) {
                j0Var.c(a);
                double[] a2 = this.i.a();
                if (w3.a()) {
                    w3.c("ArMgrImpl", "getArClassifyResultWithNoGpsFromJava," + Arrays.toString(a2));
                }
                j0Var.d(a2);
                a(j0Var);
            }
            j0 j0Var2 = new j0();
            if (m0.a && (b = this.i.b(currentTimeMillis)) != null) {
                double[] b2 = this.i.b();
                if (w3.a()) {
                    if (b2 == null) {
                        b2 = new double[7];
                    }
                    w3.c("TxFusionProvider", System.currentTimeMillis() + ",dar," + String.format(Locale.ENGLISH, "%d&&%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f&&%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f", 2, Double.valueOf(b[0]), Double.valueOf(b[1]), Double.valueOf(b[2]), Double.valueOf(b[3]), Double.valueOf(b[4]), Double.valueOf(b[5]), Double.valueOf(b[6]), Double.valueOf(b2[0]), Double.valueOf(b2[1]), Double.valueOf(b2[2]), Double.valueOf(b2[3]), Double.valueOf(b2[4]), Double.valueOf(b2[5]), Double.valueOf(b2[6])));
                }
                j0Var2.a(b);
                j0Var2.a(b2);
                this.i.a(System.currentTimeMillis(), b, b2);
                j0Var2.c(b);
                if (w3.a()) {
                    w3.c("ArMgrImpl", "getArClassifyResultWithNoGpsFromNative," + Arrays.toString(b2));
                }
                j0Var2.d(b2);
                b(j0Var2);
            }
            if (m0.b) {
                c(j0Var);
            } else if (m0.a) {
                c(j0Var2);
            }
        }
    }

    public final void a(q qVar) {
        Iterator<s> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a(qVar);
        }
    }

    public static int a(Context context) {
        int minDelay;
        int i = 6;
        if (m0.d) {
            return 6;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null) {
                w3.d("ar", "senMgr,null");
                return 2;
            }
            boolean z = true;
            Sensor __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(sensorManager, 1);
            Sensor __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor2 = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(sensorManager, 4);
            int i2 = 0;
            boolean z2 = (__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor == null || __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor.getName().toLowerCase(Locale.ENGLISH).contains("pseudo")) ? false : true;
            if (__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor2 == null || __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor2.getName().toLowerCase(Locale.ENGLISH).contains("pseudo")) {
                z = false;
            }
            w3.d("ar", "sen," + z2 + "," + z);
            if (z2 || z) {
                if (z2 && !z) {
                    i2 = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor.getMinDelay();
                    minDelay = 0;
                    if (__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor.getMinDelay() > 43478) {
                        i = 3;
                    }
                } else if (z2 || !z) {
                    minDelay = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor2.getMinDelay();
                    int minDelay2 = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor.getMinDelay();
                    if (minDelay2 <= 43478 && minDelay <= 43478) {
                        i = 0;
                        i2 = minDelay2;
                    }
                    i2 = minDelay2;
                    i = 3;
                }
                w3.d("ar", "min," + i2 + "," + minDelay);
                return i;
            }
            i = 2;
            minDelay = 0;
            w3.d("ar", "min," + i2 + "," + minDelay);
            return i;
        } catch (Throwable th) {
            return 100;
        }
    }

    @JvmStatic
    private static Sensor __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(SensorManager sm, int arg) {
        Intrinsics.checkNotNullParameter(sm, "sm");
        String $this$runOn$iv = "sm_get_default_sensor_" + arg;
        Object defaultReturnValue$iv = null;
        PrivacyHelper.CacheDuration defaultCacheTime$iv = PrivacyHelper.CacheDuration.Companion.getAlways();
        try {
            if (!PrivacyHelper.INSTANCE.hookEnable$privacy_debug($this$runOn$iv)) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "hook disable, tag: [" + $this$runOn$iv + "]", (Throwable) null, 4, (Object) null);
                Object defaultSensor = sm.getDefaultSensor(Integer.valueOf(arg).intValue());
                defaultReturnValue$iv = defaultSensor instanceof Sensor ? defaultSensor : null;
            } else if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug($this$runOn$iv)) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "user deny, tag: [" + $this$runOn$iv + "] defaultReturnValue = [" + ((Object) null) + "]", (Throwable) null, 4, (Object) null);
            } else if (PrivacyHelper.INSTANCE.forbiddenUse$privacy_debug($this$runOn$iv)) {
                ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "use forbidden, tag: [" + $this$runOn$iv + "] defaultReturnValue = [" + ((Object) null) + "]", (Throwable) null, 4, (Object) null);
            } else {
                Object it$iv = PrivacyHelper.access$hitPrivacyCache(PrivacyHelper.INSTANCE, $this$runOn$iv);
                if (it$iv == null) {
                    Object defaultSensor2 = sm.getDefaultSensor(Integer.valueOf(arg).intValue());
                    if (!(defaultSensor2 instanceof Sensor)) {
                        defaultSensor2 = null;
                    }
                    Object res$iv = defaultSensor2;
                    if (res$iv != null) {
                        PrivacyHelper.INSTANCE.getPrivacyCache().put($this$runOn$iv, new PrivacyHelper.Cache(res$iv, PrivacyHelper.access$getDDCacheTime(PrivacyHelper.INSTANCE, $this$runOn$iv, defaultCacheTime$iv)));
                    }
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "runOnPrivacyControl tag: " + $this$runOn$iv, (Throwable) null, 4, (Object) null);
                    defaultReturnValue$iv = res$iv;
                } else {
                    defaultReturnValue$iv = it$iv;
                }
            }
        } catch (Throwable t$iv) {
            if (!PrivacyHelper.access$getDebug$p()) {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: " + $this$runOn$iv + ", message = " + t$iv.getMessage(), (Throwable) null);
            } else {
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: " + $this$runOn$iv + ", message = " + t$iv.getMessage(), t$iv);
            }
        }
        return (Sensor) defaultReturnValue$iv;
    }
}