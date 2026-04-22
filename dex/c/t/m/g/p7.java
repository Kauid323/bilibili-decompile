package c.t.m.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.alipay.sdk.app.OpenAuthTask;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import java.lang.ref.WeakReference;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public class p7 {
    public static final String i = "p7";
    public b a;
    public SensorManager b;

    /* renamed from: c  reason: collision with root package name */
    public q7 f83c;
    public r d;
    public r7 e;
    public boolean g;
    public boolean f = false;
    public final q1 h = new a();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a extends q1 {
        public a() {
        }

        @Override // c.t.m.g.q1
        public void a(p1 p1Var) {
            s1 s1Var;
            if (p1Var.a() == 10001 && (s1Var = (s1) p1Var) != null) {
                p3.b(p7.this.a, 4005, 0, 0, s1Var.a);
            }
        }
    }

    public p7(Context context) {
        this.g = true;
        try {
            r7 r7Var = new r7();
            this.e = r7Var;
            r7Var.a(context);
            this.b = (SensorManager) context.getSystemService("sensor");
            this.d = r.a(context);
            this.f83c = q7.b();
        } catch (Throwable th) {
            w3.b(i, "TencentDrLocationImpl init fail");
            this.g = false;
        }
    }

    public boolean c() {
        return this.f;
    }

    public boolean d() {
        return this.g;
    }

    public final boolean e() {
        SensorManager sensorManager = this.b;
        if (sensorManager == null) {
            w3.e("DR", "sen:" + (this.b == null));
            return false;
        }
        try {
            Sensor __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(sensorManager, 11);
            Sensor __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor2 = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(this.b, 1);
            Sensor __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor3 = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(this.b, 4);
            Sensor __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor4 = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(this.b, 2);
            w3.e("SEN", String.format(Locale.ENGLISH, "has:%.1b,%.1b,%.1b,%.1b,%.1b", Boolean.valueOf(__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor == null), Boolean.valueOf(__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor2 == null), Boolean.valueOf(__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor3 == null), Boolean.valueOf(__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor4 == null), Boolean.valueOf(__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(this.b, 9) == null)));
            if (__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor == null || __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor2 == null || __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor3 == null || __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor4 == null) {
                this.g = false;
            }
        } catch (Throwable th) {
            this.g = false;
        }
        return this.g;
    }

    public final void f() {
        this.d.c();
        this.d.a(this.a);
        this.d.a("set_ar_detect_cycle", "1000");
    }

    public final int g() {
        o1.a().a(this.h);
        return 0;
    }

    public final boolean h() {
        try {
            boolean registerListener = this.b.registerListener(this.a, __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(this.b, 11), 10000, this.a);
            boolean registerListener2 = this.b.registerListener(this.a, __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(this.b, 1), 10000, this.a);
            boolean registerListener3 = this.b.registerListener(this.a, __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(this.b, 4), 10000, this.a);
            boolean registerListener4 = this.b.registerListener(this.a, __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(this.b, 2), 10000, this.a);
            boolean registerListener5 = this.b.registerListener(this.a, __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(this.b, 9), 10000, this.a);
            w3.e("Sen", String.format(Locale.ENGLISH, "register:%.1b,%.1b,%.1b,%.1b,%.1b", Boolean.valueOf(registerListener), Boolean.valueOf(registerListener2), Boolean.valueOf(registerListener3), Boolean.valueOf(registerListener4), Boolean.valueOf(registerListener5)));
            return true;
        } catch (Throwable th) {
            w3.d("SEN_E", "REGISTER ERR");
            return false;
        }
    }

    public void i() {
        if (this.f) {
            w3.e("DR", "shutdown");
            this.b.unregisterListener(this.a);
            o1.a().b(this.h);
            this.d.b(this.a);
            this.d.b();
            a();
            this.f = false;
            this.e.a();
        }
    }

    public int a(int i2) {
        if (this.f) {
            return -2;
        }
        boolean e = e();
        this.g = e;
        if (e) {
            this.a = new b(n3.b("tc_pdr_thread").getLooper(), this);
            if (!h()) {
                a();
                return -3;
            }
            int g = g();
            if (g != 0) {
                a();
                return g;
            }
            w3.e("DR", "startup," + i2);
            f();
            p3.b(this.a, 4004, i2, 0, null);
            this.f = true;
            return 0;
        }
        return -1;
    }

    public double[] b() {
        if (this.f) {
            return this.f83c.c();
        }
        return null;
    }

    public final void a() {
        p3.b(this.a);
        p3.b(this.a, 4002);
        this.a = null;
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class b extends Handler implements SensorEventListener, s {
        public static final String i = b.class.getSimpleName();
        public final SparseArray<SensorEvent> a;
        public WeakReference<p7> b;

        /* renamed from: c  reason: collision with root package name */
        public final float[] f84c;
        public final float[] d;
        public final float[] e;
        public double f;
        public double g;
        public double h;

        public b(Looper looper, p7 p7Var) {
            super(looper);
            this.a = new SparseArray<>();
            this.f84c = new float[16];
            this.d = new float[16];
            this.e = new float[]{0.0f, 0.0f, 0.0f};
            this.f = 0.0d;
            this.g = 0.0d;
            this.h = 0.0d;
            this.b = new WeakReference<>(p7Var);
        }

        public final void a(Message message) {
            float[] fArr;
            switch (message.what) {
                case OpenAuthTask.NOT_INSTALLED /* 4001 */:
                    removeMessages(OpenAuthTask.NOT_INSTALLED);
                    sendEmptyMessageDelayed(OpenAuthTask.NOT_INSTALLED, 40L);
                    SensorEvent sensorEvent = this.a.get(1);
                    SensorEvent sensorEvent2 = this.a.get(4);
                    SensorEvent sensorEvent3 = this.a.get(2);
                    SensorEvent sensorEvent4 = this.a.get(11);
                    SensorEvent sensorEvent5 = this.a.get(9);
                    if (sensorEvent4 != null) {
                        SensorManager.getRotationMatrixFromVector(this.f84c, sensorEvent4.values);
                        boolean a = a(sensorEvent5);
                        if (a) {
                            SensorManager.remapCoordinateSystem(this.f84c, 1, 3, this.d);
                        }
                        if (!a) {
                            fArr = this.f84c;
                        } else {
                            fArr = this.d;
                        }
                        SensorManager.getOrientation(fArr, this.e);
                    }
                    if (sensorEvent == null || sensorEvent2 == null || sensorEvent3 == null || sensorEvent4 == null) {
                        return;
                    }
                    q7 q7Var = this.b.get().f83c;
                    long j = sensorEvent.timestamp;
                    float[] fArr2 = sensorEvent.values;
                    float f = fArr2[0];
                    float f2 = fArr2[1];
                    float f3 = fArr2[2];
                    long j2 = sensorEvent2.timestamp;
                    float[] fArr3 = sensorEvent2.values;
                    float f4 = fArr3[0];
                    float f5 = fArr3[1];
                    float f6 = fArr3[2];
                    long j3 = sensorEvent3.timestamp;
                    float[] fArr4 = sensorEvent3.values;
                    float f7 = fArr4[0];
                    float f8 = fArr4[1];
                    float f9 = fArr4[2];
                    long j4 = sensorEvent4.timestamp;
                    float[] fArr5 = this.e;
                    q7Var.a(j, f, f2, f3, j2, f4, f5, f6, j3, f7, f8, f9, j4, fArr5[0], fArr5[1], fArr5[2]);
                    return;
                case 4002:
                    this.b.get().f83c.a();
                    a();
                    removeCallbacksAndMessages(null);
                    n3.a("tc_pdr_thread");
                    return;
                case 4003:
                default:
                    return;
                case 4004:
                    int i2 = message.arg1;
                    this.b.get().f83c.d();
                    this.b.get().f83c.a((double[][]) null, i2);
                    p3.b(this, OpenAuthTask.NOT_INSTALLED);
                    return;
                case 4005:
                    Object obj = message.obj;
                    Location location = obj != null ? (Location) obj : null;
                    if (location != null) {
                        this.b.get().f83c.a(System.currentTimeMillis() / 1000.0d, location.getTime() / 1000.0d, location.getLatitude(), location.getLongitude(), location.hasAltitude() ? location.getAltitude() : 9999.0d, location.hasAccuracy() ? location.getAccuracy() : 9999.0d, location.hasSpeed() ? location.getSpeed() : 9999.0d, location.hasBearing() ? location.getBearing() : 9999.0d);
                        w3.c(i, "MSG_ID_GPS_UPDATE, " + location);
                        return;
                    }
                    return;
                case 4006:
                    Object obj2 = message.obj;
                    q qVar = obj2 != null ? (q) obj2 : null;
                    if (qVar != null) {
                        w3.e("AR", qVar.a() + "," + qVar.b());
                        this.b.get().f83c.a(qVar.a(), qVar.b());
                        return;
                    }
                    return;
            }
        }

        @Override // c.t.m.g.s
        public void a(q qVar) {
        }

        @Override // c.t.m.g.s
        public void b(q qVar) {
            Message obtainMessage = obtainMessage();
            obtainMessage.what = 4006;
            obtainMessage.obj = qVar;
            p3.a(this, obtainMessage);
        }

        @Override // c.t.m.g.s
        public void c(q qVar) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                a(message);
            } catch (Exception e) {
                w3.a(i, "handle message err", e);
                e.printStackTrace();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            synchronized (this.a) {
                sensorEvent.timestamp = System.currentTimeMillis();
                this.a.put(sensorEvent.sensor.getType(), sensorEvent);
            }
        }

        public final boolean a(SensorEvent sensorEvent) {
            if (sensorEvent == null) {
                return false;
            }
            float[] fArr = sensorEvent.values;
            double d = fArr[0] * fArr[0];
            double d2 = fArr[1] * fArr[1];
            double d3 = fArr[2] * fArr[2];
            double d4 = this.f;
            if (d4 != 0.0d) {
                d = (d * 0.1d) + (d4 * 0.9d);
            }
            this.f = d;
            double d5 = this.g;
            if (d5 != 0.0d) {
                d2 = (d2 * 0.1d) + (d5 * 0.9d);
            }
            this.g = d2;
            double d6 = this.h;
            if (d6 != 0.0d) {
                d3 = (d3 * 0.1d) + (d6 * 0.9d);
            }
            this.h = d3;
            return this.f + d3 < 25.0d || this.g + d3 < 25.0d;
        }

        public final void a() {
            synchronized (this.a) {
                this.a.clear();
            }
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