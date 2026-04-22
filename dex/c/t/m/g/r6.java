package c.t.m.g;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationBridge;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.util.SoUtils;

/* compiled from: TML */
public class r6 implements TencentLocationBridge {
    public m4 a;
    public i5 b;

    public r6(Context context) {
        init(context);
    }

    public void addLocationListener(TencentLocationListener tencentLocationListener) {
        this.b.a(tencentLocationListener);
    }

    public void changeCallbackInterval(long j) {
        this.b.a(j);
    }

    public String getBuild() {
        return "240119";
    }

    public int getCoordinateType() {
        return this.b.i();
    }

    public TencentLocation getLastKnownLocation() {
        return this.b.k();
    }

    public String getOaid() {
        return t0.b();
    }

    public TencentLocation getPosition() {
        return m7.a(this.a).a();
    }

    public String getVersion() {
        return "7.5.4.3.official_1";
    }

    public void init(Context context) {
        a7.a(context);
        b3.a(context);
        b3.a(true);
        this.a = m4.a(context);
        a7.c("NewTxLocationManagerImpl", "TencentLocationManager new TxLocationManagerImpl");
        this.b = new i5(this.a);
    }

    public boolean isSupport() {
        return m7.a(this.a).b();
    }

    public int isSupportBeiDou() {
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        return a5.a();
    }

    public void removeLocationListener(TencentLocationListener tencentLocationListener) {
        this.b.b(tencentLocationListener);
    }

    public void removeUpdates(TencentLocationListener tencentLocationListener) {
        this.b.c(tencentLocationListener);
    }

    public int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        return this.b.a(tencentLocationRequest, tencentLocationListener, looper);
    }

    public int requestLocationWithScene(int i, TencentLocationListener tencentLocationListener) {
        return this.b.a(i, tencentLocationListener);
    }

    public int requestSingleFreshLocation(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        return this.b.b(tencentLocationRequest, tencentLocationListener, looper);
    }

    public void setCoordinateType(int i) {
        this.b.c(i);
    }

    public void setDebuggable(boolean z) {
        d3.b("CONF_USER_DEBUGGABLE", Boolean.valueOf(z));
    }

    public void setDeviceID(Context context, String str) {
        e7.b("LocationSDK", "location_device_id", str);
        x3.c(str);
        w4.a(str);
    }

    public void setExtraData(String str, String str2) {
        this.b.a(str, str2);
    }

    public int startDrEngine(int i) {
        try {
            return m7.a(this.a).a(i);
        } catch (Exception e) {
            return -999;
        }
    }

    public boolean startIndoorLocation() {
        return this.b.p();
    }

    public boolean stopIndoorLocation() {
        return this.b.s();
    }

    public void stopLocationWithScene(int i, TencentLocationListener tencentLocationListener) {
        this.b.b(i, tencentLocationListener);
    }

    public void terminateDrEngine() {
        m7.a(this.a).d();
    }

    public void triggerCodeGuarder(boolean z) {
        SoUtils.fun_x(z);
    }
}