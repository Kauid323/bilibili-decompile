package c.t.m.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public class f5 implements SensorEventListener {
    public static volatile f5 e;
    public final SensorManager a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29c;
    public double d;

    public f5(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.a = sensorManager;
        this.b = sensorManager != null;
    }

    public static f5 a(Context context) {
        if (e == null) {
            e = new f5(context);
        }
        return e;
    }

    public void b() {
        if (this.b && this.f29c) {
            this.f29c = false;
            synchronized (this) {
                this.d = Double.NaN;
            }
            this.a.unregisterListener(this);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 11) {
                float[] fArr = new float[16];
                float[] fArr2 = new float[3];
                SensorManager.getRotationMatrixFromVector(fArr, sensorEvent.values);
                SensorManager.getOrientation(fArr, fArr2);
                double d = fArr2[0];
                synchronized (this) {
                    this.d = (d * 180.0d) / 3.1415926d;
                }
            }
        } catch (Throwable th) {
        }
    }

    public void a(Handler handler) {
        if (this.b && !this.f29c) {
            try {
                Sensor __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(this.a, 11);
                if (__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor == null || handler == null) {
                    return;
                }
                this.a.registerListener(this, __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor, 3, handler);
                this.f29c = true;
            } catch (Throwable th) {
            }
        }
    }

    public double a() {
        double d;
        if (this.f29c) {
            synchronized (this) {
                d = this.d;
            }
            return d;
        }
        return Double.NaN;
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