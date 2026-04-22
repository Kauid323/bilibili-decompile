package tv.danmaku.ijk.media.player.render.tools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.core.BiliImageOrientation;

public class BiliSensorEventHandler implements SensorEventListener {
    private static final float NS2S = 1.0E-9f;
    private static final String TAG = BiliSensorEventHandler.class.getName();
    private float[] angle;
    private SensorChangedListener mListener;
    private BiliImageOrientation mOrientation = BiliImageOrientation.Up;
    private BiliSensorEntity mSensorEntity;
    private SensorManager mSensorManager;
    private boolean mSensorRegistered;
    private long timestamp;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface SensorChangedListener {
        void sensorUpdateMatrix(BiliSensorEntity biliSensorEntity);
    }

    public void init(Context context) {
        Sensor sensorRot;
        if (context == null) {
            return;
        }
        this.mSensorRegistered = false;
        this.mSensorManager = (SensorManager) context.getSystemService("sensor");
        if (this.mSensorManager == null || (sensorRot = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getDefaultSensor(this.mSensorManager, 4)) == null) {
            return;
        }
        this.mSensorManager.registerListener(this, sensorRot, 1);
        this.mSensorRegistered = true;
        this.angle = new float[3];
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        if (this.angle == null || this.angle.length != 3) {
            BLog.w(TAG, "Are you sure init ?");
        } else if (event.sensor.getType() == 4) {
            if (this.mSensorEntity == null) {
                this.mSensorEntity = new BiliSensorEntity();
                this.mSensorEntity.orientation = this.mOrientation;
            }
            if (this.timestamp != 0) {
                double dT = ((float) (event.timestamp - this.timestamp)) * NS2S;
                this.angle[0] = (float) (fArr[0] + (event.values[0] * dT));
                this.angle[1] = (float) (fArr2[1] + (event.values[1] * dT));
                this.angle[2] = (float) (fArr3[2] + (event.values[2] * dT));
                float anglex = ((float) Math.toDegrees(this.angle[0])) % 360.0f;
                float angley = ((float) Math.toDegrees(this.angle[1])) % 360.0f;
                float anglez = ((float) Math.toDegrees(this.angle[2])) % 360.0f;
                if (this.mOrientation == BiliImageOrientation.Left) {
                    this.mSensorEntity.angleX = -angley;
                    this.mSensorEntity.angleY = anglex;
                    this.mSensorEntity.angleZ = anglez;
                } else if (this.mOrientation == BiliImageOrientation.Right) {
                    this.mSensorEntity.angleX = angley;
                    this.mSensorEntity.angleY = anglex;
                    this.mSensorEntity.angleZ = anglez;
                } else if (this.mOrientation == BiliImageOrientation.Down) {
                    this.mSensorEntity.angleX = anglex;
                    this.mSensorEntity.angleY = angley;
                    this.mSensorEntity.angleZ = anglez;
                } else {
                    this.mSensorEntity.angleX = anglex;
                    this.mSensorEntity.angleY = angley;
                    this.mSensorEntity.angleZ = anglez;
                }
            }
            this.timestamp = event.timestamp;
            if (this.mListener != null) {
                this.mListener.sensorUpdateMatrix(this.mSensorEntity);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        BLog.i(TAG, "[Sensor] sensor accuracy : " + accuracy);
    }

    public void resetAxis(int index) {
        if (this.angle == null || this.angle.length != 3) {
            return;
        }
        this.angle[index] = 0.0f;
    }

    public void releaseResources() {
        if (!this.mSensorRegistered || this.mSensorManager == null) {
            return;
        }
        this.mSensorManager.unregisterListener(this);
        this.mSensorRegistered = false;
        this.mSensorEntity = null;
        this.angle = null;
    }

    public void setOrientation(BiliImageOrientation orientation) {
        this.mOrientation = orientation;
        if (this.mSensorEntity != null) {
            this.mSensorEntity.orientation = this.mOrientation;
        }
    }

    public void setSensorChangedListener(SensorChangedListener listener) {
        this.mListener = listener;
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