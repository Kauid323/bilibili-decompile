package c.t.m.g;

import com.tencent.map.geolocation.TencentPoi;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TML */
public class n6 implements TencentPoi {
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f74c;
    public double d;
    public String e;
    public double f;
    public double g;
    public String h;

    public n6(TencentPoi tencentPoi) {
        this.a = tencentPoi.getName();
        this.b = tencentPoi.getAddress();
        this.f74c = tencentPoi.getCatalog();
        this.d = tencentPoi.getDistance();
        this.e = tencentPoi.getUid();
        this.f = tencentPoi.getLatitude();
        this.g = tencentPoi.getLongitude();
        this.h = tencentPoi.getDirection();
    }

    public final void a(JSONObject jSONObject) {
        this.h = jSONObject.optString("direction", "");
        if (Double.isNaN(this.f)) {
            this.f = jSONObject.optDouble("pointy");
        }
        if (Double.isNaN(this.g)) {
            this.g = jSONObject.optDouble("pointx");
        }
    }

    public final void b(JSONObject jSONObject) throws JSONException {
        this.a = jSONObject.optString(com.alipay.sdk.m.h.c.e);
        this.b = jSONObject.optString("addr");
        this.f74c = jSONObject.optString("catalog");
        this.d = jSONObject.optDouble("dist");
        this.e = jSONObject.optString("uid");
        this.f = jSONObject.optDouble("latitude");
        this.g = jSONObject.optDouble("longitude");
        a(jSONObject);
    }

    public String getAddress() {
        return this.b;
    }

    public String getCatalog() {
        return this.f74c;
    }

    public String getDirection() {
        return this.h;
    }

    public double getDistance() {
        return this.d;
    }

    public double getLatitude() {
        return this.f;
    }

    public double getLongitude() {
        return this.g;
    }

    public String getName() {
        return this.a;
    }

    public String getUid() {
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PoiData{");
        sb.append("name=").append(this.a).append(",");
        sb.append("addr=").append(this.b).append(",");
        sb.append("catalog=").append(this.f74c).append(",");
        sb.append("dist=").append(this.d).append(",");
        sb.append("latitude=").append(this.f).append(",");
        sb.append("longitude=").append(this.g).append(",");
        sb.append("direction=").append(this.h).append(",");
        sb.append(com.alipay.sdk.m.q.h.d);
        return sb.toString();
    }

    public n6(JSONObject jSONObject) throws JSONException {
        b(jSONObject);
    }
}