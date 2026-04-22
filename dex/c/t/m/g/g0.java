package c.t.m.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public class g0 extends n2 {
    public a d = null;

    /* renamed from: c  reason: collision with root package name */
    public SensorManager f32c = (SensorManager) b3.a().getSystemService("sensor");

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class a extends Handler implements SensorEventListener {
        public volatile SensorEvent a;
        public volatile SensorEvent b;

        /* renamed from: c  reason: collision with root package name */
        public volatile long f33c;
        public long d;
        public long e;
        public long f;
        public int g;
        public volatile double h;

        public a(Looper looper) {
            super(looper);
            this.f33c = 0L;
            this.d = 0L;
            this.e = 0L;
            this.f = 0L;
            this.g = 0;
            this.h = 50.0d;
            this.d = 40L;
        }

        public final void a(Message message) {
            int i;
            if (message.what != 2001) {
                return;
            }
            removeMessages(2001);
            sendEmptyMessageDelayed(2001, 20L);
            long currentTimeMillis = System.currentTimeMillis();
            if ((this.a == null || this.b == null) && Math.abs(currentTimeMillis - this.f) >= 30000) {
                w3.d("AR", "acc:" + (this.a == null) + ",gyr:" + (this.b == null));
                this.f = currentTimeMillis;
            }
            if (currentTimeMillis - this.e < this.d) {
                return;
            }
            this.e = currentTimeMillis;
            if (this.a != null && this.b == null) {
                i = 1;
            } else if (this.a != null || this.b == null) {
                i = (this.a == null || this.b == null) ? 4 : 3;
            } else {
                i = 2;
            }
            if (i == 2 || i == 4) {
                return;
            }
            int i2 = m0.d ? 1 : i;
            float[] fArr = this.a.values;
            float[] fArr2 = i2 == 1 ? null : this.b.values;
            int i3 = this.a.accuracy;
            int i4 = i2 == 1 ? -1 : this.b.accuracy;
            if (Math.abs(currentTimeMillis - this.f) >= 30000) {
                w3.d("AR", "accuracy:acc=" + i3 + ", gyr=" + i4);
                this.f = currentTimeMillis;
            }
            if (d0.c() != null) {
                d0.c().a(currentTimeMillis, fArr, fArr2, i2);
            }
            if (currentTimeMillis - this.f33c > 2500 || this.h < 20.0d) {
                n0.a("SensorHandler", "Ar reset by sensor:" + (currentTimeMillis - this.f33c) + "," + b4.a(this.h, 2));
                if (d0.c() != null) {
                    d0.c().d();
                }
                this.b = null;
                this.a = null;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                a(message);
            } catch (Throwable th) {
                n0.a("SensorHandler", Thread.currentThread().getName() + " error.", th);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            w3.d("AR", "sensor accuracy changed," + sensor.getType() + "," + i + "," + sensor.getName());
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            if (type != 1) {
                if (type != 4) {
                    return;
                }
                this.b = sensorEvent;
                return;
            }
            this.a = sensorEvent;
            int i = this.g + 1;
            this.g = i;
            if (i == 25 || this.f33c == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f33c != 0) {
                    this.h = currentTimeMillis != this.f33c ? 1000.0d / ((currentTimeMillis - this.f33c) / 25.0d) : 50.0d;
                } else {
                    this.h = 50.0d;
                }
                this.f33c = currentTimeMillis;
                this.g = 0;
            }
        }
    }

    @Override // c.t.m.g.o2
    public String a() {
        return "ArSensorPro";
    }

    @Override // c.t.m.g.n2
    public int b(Looper looper) {
        if (this.f32c == null) {
            return -1;
        }
        a aVar = new a(looper);
        this.d = aVar;
        SensorManager sensorManager = this.f32c;
        sensorManager.registerListener(aVar, __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(sensorManager, 1), 1, this.d);
        SensorManager sensorManager2 = this.f32c;
        sensorManager2.registerListener(this.d, __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(sensorManager2, 4), 1, this.d);
        this.d.sendEmptyMessageDelayed(2001, 100L);
        n0.a("ArSensorPro", "status:[start]");
        return 0;
    }

    @Override // c.t.m.g.o2
    public void d() {
        this.f32c.unregisterListener(this.d);
        a aVar = this.d;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
        }
        this.d = null;
        n0.a("ArSensorPro", "status:[shutdown]");
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