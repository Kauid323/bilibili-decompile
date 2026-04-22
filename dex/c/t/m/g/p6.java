package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.map.geolocation.util.SoUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TML */
public class p6 implements TencentLocation, Parcelable {
    public static final Parcelable.Creator<TencentLocation> CREATOR = new a();
    public static final p6 q = new p6(-1);
    public m6 a;
    public l6 b;

    /* renamed from: c  reason: collision with root package name */
    public int f81c;
    public int d;
    public String e;
    public int f;
    public k6 g;
    public final Bundle h;
    public String i;
    public String j;
    public Location k;
    public final long l;
    public long m;
    public long n;
    public int o;
    public int p;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Parcelable.Creator<TencentLocation> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TencentLocation[] newArray(int i) {
            return new TencentLocation[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TencentLocation createFromParcel(Parcel parcel) {
            p6 p6Var = new p6(parcel.readInt(), (a) null);
            m6 m6Var = new m6();
            k6 k6Var = new k6();
            o6 o6Var = new o6();
            k6Var.f55c = o6Var;
            p6Var.i = parcel.readString();
            p6Var.j = parcel.readString();
            m6Var.a = parcel.readDouble();
            m6Var.b = parcel.readDouble();
            m6Var.d = parcel.readFloat();
            m6Var.f67c = parcel.readDouble();
            m6Var.g = parcel.readString();
            o6Var.a = parcel.readString();
            o6Var.e = parcel.readString();
            o6Var.f = parcel.readString();
            o6Var.g = parcel.readString();
            o6Var.j = parcel.readString();
            o6Var.k = parcel.readString();
            o6Var.b = parcel.readString();
            p6Var.a = m6Var;
            p6Var.g = k6Var;
            p6Var.m = parcel.readLong();
            p6Var.n = parcel.readLong();
            Bundle readBundle = parcel.readBundle();
            if (readBundle != null) {
                p6Var.h.putAll(readBundle);
            }
            return p6Var;
        }
    }

    public /* synthetic */ p6(int i, a aVar) {
        this(i);
    }

    public static p6 c(p6 p6Var) {
        p6 p6Var2 = new p6(-1);
        if (p6Var == null) {
            p6Var2.a = new m6();
        } else {
            p6Var2.a = m6.a(p6Var.a);
            p6Var2.f81c = p6Var.f81c;
            p6Var2.e = p6Var.e;
            p6Var2.g = k6.a(p6Var.g);
            if (p6Var.h.size() > 0) {
                p6Var2.h.putAll(p6Var.h);
            }
        }
        return p6Var2;
    }

    public static void d(p6 p6Var) throws JSONException {
        if (p6Var == q) {
            throw new JSONException("location failed");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getAccuracy() {
        m6 m6Var = this.a;
        if (m6Var != null) {
            return m6Var.d;
        }
        return 0.0f;
    }

    public String getAddress() {
        int i = this.f81c;
        if (i == 5) {
            return this.h.getString("addrdesp.name");
        }
        if (i == 3) {
            k6 k6Var = this.g;
            if (k6Var != null) {
                return k6Var.f55c.l;
            }
            return null;
        }
        m6 m6Var = this.a;
        if (m6Var != null) {
            return m6Var.g;
        }
        return null;
    }

    public double getAltitude() {
        m6 m6Var = this.a;
        if (m6Var != null) {
            return m6Var.f67c;
        }
        return 0.0d;
    }

    public Integer getAreaStat() {
        k6 k6Var = this.g;
        if (k6Var != null) {
            return Integer.valueOf(k6Var.a);
        }
        return null;
    }

    public float getBearing() {
        Location location = this.k;
        if (location == null) {
            return 0.0f;
        }
        return location.getBearing();
    }

    public String getCity() {
        k6 k6Var = this.g;
        if (k6Var != null) {
            return k6Var.f55c.f;
        }
        return null;
    }

    public String getCityCode() {
        k6 k6Var = this.g;
        if (k6Var != null) {
            return k6Var.f55c.f78c;
        }
        return null;
    }

    public String getCityPhoneCode() {
        k6 k6Var = this.g;
        if (k6Var != null) {
            return k6Var.f55c.d;
        }
        return null;
    }

    public int getCoordinateType() {
        return this.o;
    }

    public double getDirection() {
        Bundle bundle = this.h;
        if (bundle != null) {
            return bundle.getDouble("direction");
        }
        return Double.NaN;
    }

    public String getDistrict() {
        k6 k6Var = this.g;
        if (k6Var != null) {
            return k6Var.f55c.g;
        }
        return null;
    }

    public long getElapsedRealtime() {
        return this.l;
    }

    public Bundle getExtra() {
        return this.h;
    }

    public float getFakeProbability() {
        return v4.a(getFakeReason());
    }

    public int getFakeReason() {
        return this.p;
    }

    public int getGPSRssi() {
        Bundle extras;
        Location location = this.k;
        if (location == null || (extras = location.getExtras()) == null) {
            return 0;
        }
        return extras.getInt("rssi", 0);
    }

    public String getIndoorBuildingFloor() {
        l6 l6Var = this.b;
        return l6Var != null ? l6Var.b : "1000";
    }

    public String getIndoorBuildingId() {
        l6 l6Var = this.b;
        if (l6Var != null) {
            return l6Var.a;
        }
        return null;
    }

    public int getIndoorLocationType() {
        l6 l6Var = this.b;
        if (l6Var != null) {
            return l6Var.f60c;
        }
        return -1;
    }

    public double getLatitude() {
        m6 m6Var = this.a;
        if (m6Var != null) {
            return m6Var.a;
        }
        return 0.0d;
    }

    public double getLongitude() {
        m6 m6Var = this.a;
        if (m6Var != null) {
            return m6Var.b;
        }
        return 0.0d;
    }

    public String getName() {
        int i = this.f81c;
        if (i == 5) {
            return this.h.getString("addrdesp.name");
        }
        if (i == 3) {
            k6 k6Var = this.g;
            if (k6Var != null) {
                return k6Var.f55c.b;
            }
            return null;
        }
        m6 m6Var = this.a;
        if (m6Var != null) {
            return m6Var.f;
        }
        return null;
    }

    public String getNation() {
        k6 k6Var = this.g;
        if (k6Var != null) {
            return k6Var.f55c.a;
        }
        return null;
    }

    public int getNationCode() {
        return this.f;
    }

    public List<TencentPoi> getPoiList() {
        return this.g != null ? new ArrayList(this.g.b) : Collections.emptyList();
    }

    public String getProvider() {
        return this.i;
    }

    public String getProvince() {
        k6 k6Var = this.g;
        return k6Var != null ? k6Var.f55c.e : "";
    }

    public String getSourceProvider() {
        return this.j;
    }

    public float getSpeed() {
        Location location = this.k;
        if (location == null) {
            return 0.0f;
        }
        return location.getSpeed();
    }

    public String getStreet() {
        k6 k6Var = this.g;
        if (k6Var != null) {
            return k6Var.f55c.j;
        }
        return null;
    }

    public String getStreetNo() {
        k6 k6Var = this.g;
        if (k6Var != null) {
            return k6Var.f55c.k;
        }
        return null;
    }

    public long getTime() {
        return this.m;
    }

    public String getTown() {
        k6 k6Var = this.g;
        if (k6Var != null) {
            return k6Var.f55c.h;
        }
        return null;
    }

    public String getVillage() {
        k6 k6Var = this.g;
        if (k6Var != null) {
            return k6Var.f55c.i;
        }
        return null;
    }

    public String getadCode() {
        k6 k6Var = this.g;
        if (k6Var != null) {
            return k6Var.f55c.f78c;
        }
        return null;
    }

    public int isMockGps() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TxLocation{");
        sb.append("level=").append(this.f81c).append(",");
        sb.append("name=").append(getName()).append(",");
        sb.append("address=").append(getAddress()).append(",");
        sb.append("provider=").append(getProvider()).append(",");
        sb.append("latitude=").append(getLatitude()).append(",");
        sb.append("longitude=").append(getLongitude()).append(",");
        sb.append("altitude=").append(getAltitude()).append(",");
        sb.append("accuracy=").append(getAccuracy()).append(",");
        sb.append("speed=").append(getSpeed()).append(",");
        sb.append("bearing=").append(getBearing()).append(",");
        sb.append("time=").append(getTime()).append(",");
        sb.append("sourceProvider=").append(getSourceProvider()).append(",");
        sb.append("fakeReason=").append(getFakeReason()).append(",");
        sb.append("fakeProbability=").append(getFakeProbability()).append(",");
        sb.append("nationCode=").append(getNationCode()).append(",");
        sb.append("cityCode=").append(getCityCode()).append(",");
        sb.append("areaStat=").append(getAreaStat()).append(",");
        sb.append("nation=").append(getNation()).append(",");
        sb.append("province=").append(getProvince()).append(",");
        sb.append("city=").append(getCity()).append(",");
        sb.append("district=").append(getDistrict()).append(",");
        sb.append("street=").append(getStreet()).append(",");
        sb.append("streetNo=").append(getStreetNo()).append(",");
        sb.append("town=").append(getTown()).append(",");
        sb.append("village=").append(getVillage()).append(",");
        sb.append("poilist=[");
        for (TencentPoi tencentPoi : getPoiList()) {
            sb.append(tencentPoi).append(",");
        }
        sb.append("]");
        sb.append(com.alipay.sdk.m.q.h.d);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f81c);
        parcel.writeString(getProvider());
        parcel.writeDouble(getLatitude());
        parcel.writeDouble(getLongitude());
        parcel.writeDouble(getAccuracy());
        parcel.writeDouble(getAltitude());
        parcel.writeString(getAddress());
        parcel.writeString(getSourceProvider());
        parcel.writeString(getNation());
        parcel.writeString(getProvince());
        parcel.writeString(getCity());
        parcel.writeString(getDistrict());
        parcel.writeString(getStreet());
        parcel.writeString(getStreetNo());
        parcel.writeString(a());
        parcel.writeString(getName());
        parcel.writeLong(this.m);
        parcel.writeLong(this.n);
        parcel.writeBundle(this.h);
    }

    public /* synthetic */ p6(String str, a aVar) throws JSONException {
        this(str);
    }

    public p6(int i) {
        this.h = new Bundle(9);
        this.i = "network";
        this.j = "wifi";
        this.f81c = i;
        this.l = SystemClock.elapsedRealtime();
        this.m = System.currentTimeMillis();
    }

    public void b(Location location) {
        if (location == null || this.a == null) {
            return;
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        m6 m6Var = this.a;
        m6Var.a = Math.round(latitude * 1000000.0d) / 1000000.0d;
        m6Var.b = Math.round(longitude * 1000000.0d) / 1000000.0d;
        m6Var.f67c = location.getAltitude();
        this.a.d = location.getAccuracy();
    }

    public void a(double d, double d2) {
        this.a.a = Math.round(d * 1000000.0d) / 1000000.0d;
        this.a.b = Math.round(d2 * 1000000.0d) / 1000000.0d;
    }

    public void a(String str, Location location) {
        this.i = str;
        this.a.a = location.getLatitude();
        this.a.b = location.getLongitude();
        this.a.f67c = location.getAltitude();
        this.a.d = location.getAccuracy();
        a(location);
    }

    public void c(int i) {
        if ("gps".equals(getProvider())) {
            if (i != 0) {
                this.j = "fake";
            } else {
                this.j = "gps";
            }
        } else if (!"network".equals(getProvider())) {
            this.j = getProvider();
        } else if (i != 0) {
            this.j = "fake";
        } else if (getAccuracy() <= 150.0d) {
            this.j = "wifi";
        } else {
            this.j = "cell";
        }
        this.p = i;
    }

    public final p6 b(int i) {
        this.f81c = i;
        return this;
    }

    public long b() {
        return this.n;
    }

    public static p6 b(p6 p6Var, int i) {
        p6Var.o = i;
        return p6Var;
    }

    public void a(int i) {
        this.f = i;
    }

    public p6 a(String str) {
        this.i = str;
        return this;
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class b {
        public String a;
        public p6 b;

        /* renamed from: c  reason: collision with root package name */
        public int f82c;
        public String d = "network";
        public Location e;
        public Bundle f;

        public p6 a() {
            p6 p6Var;
            if (this.a != null) {
                try {
                    p6Var = new p6(this.a, (a) null);
                } catch (JSONException e) {
                    a7.a("TxLocation", "build: ", e);
                    return p6.q;
                }
            } else {
                p6Var = p6.c(this.b);
            }
            p6Var.b(this.f82c).a(this.d).a(this.e);
            if (this.f != null) {
                p6Var.h.putAll(this.f);
            }
            g6.a(p6Var, this.e);
            y2.a(p6Var.h, "lastNetLocationTimeStampUseWifi", new Long(g7.a), Long.class);
            y2.a(p6Var.h, "lastNetLocationTimeStampUseCellOnly", new Long(g7.b), Long.class);
            return p6Var;
        }

        public b b(String str) {
            this.d = str;
            return this;
        }

        public b a(String str) {
            this.a = str;
            return this;
        }

        public b a(p6 p6Var) {
            this.b = p6Var;
            return this;
        }

        public b a(int i) {
            this.f82c = i;
            return this;
        }

        public b a(Location location) {
            this.e = new Location(location);
            return this;
        }

        public b a(Bundle bundle) {
            this.f = bundle;
            return this;
        }
    }

    public final p6 a(Location location) {
        this.k = location;
        return this;
    }

    public String a() {
        k6 k6Var = this.g;
        if (k6Var != null) {
            return k6Var.f55c.f78c;
        }
        return null;
    }

    public static p6 a(p6 p6Var, boolean z) {
        String str;
        int i;
        if (p6Var != null && (str = p6Var.e) != null && !z) {
            if (str != null && str.split(",").length > 1) {
                i = Integer.parseInt(str.split(",")[1]);
            } else {
                i = 0;
            }
            m6 m6Var = p6Var.a;
            if (m6Var != null) {
                try {
                    a7.c("hh", "fun_r");
                    m6Var.d = (float) SoUtils.fun_r(m6Var.d, i, -70);
                } catch (UnsatisfiedLinkError e) {
                }
            }
        }
        return p6Var;
    }

    public p6(String str) throws JSONException {
        o6 o6Var;
        this.h = new Bundle(9);
        this.i = "network";
        this.j = "wifi";
        this.l = SystemClock.elapsedRealtime();
        this.m = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject(str);
        try {
            this.a = new m6(jSONObject.getJSONObject("location"));
            try {
                this.b = new l6(jSONObject.getJSONObject("indoorinfo"));
            } catch (Throwable th) {
            }
            this.e = jSONObject.optString("bearing");
            this.d = jSONObject.optInt("fackgps", 0);
            long optLong = jSONObject.optLong(com.alipay.sdk.m.p.a.k, System.currentTimeMillis());
            this.n = optLong;
            this.m = optLong;
            try {
                String optString = jSONObject.optString("icontrol");
                if (!TextUtils.isEmpty(optString)) {
                    this.h.putInt("icontrol", Integer.valueOf(optString.split(",")[0]).intValue());
                    a7.b("TxLocation", "TxLocation control:" + optString);
                }
            } catch (Exception e) {
                a7.b("TxLocation", "parse icontrol failed");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("details");
            if (optJSONObject != null) {
                try {
                    this.g = new k6(optJSONObject);
                } catch (JSONException e2) {
                    a7.a("TxLocation", "details object not found", e2);
                    throw e2;
                }
            } else {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("addrdesp");
                if (optJSONObject2 != null && optJSONObject2.has("detail")) {
                    this.g = new k6(optJSONObject2.optJSONObject("detail"));
                }
            }
            k6 k6Var = this.g;
            if (k6Var == null || (o6Var = k6Var.f55c) == null) {
                return;
            }
            this.h.putAll(o6Var.m);
        } catch (JSONException e3) {
            throw e3;
        }
    }

    public static p6 a(p6 p6Var, p6 p6Var2) {
        if (p6Var != null && p6Var2 != null) {
            m6 m6Var = p6Var2.a;
            if (m6Var != null) {
                m6 m6Var2 = p6Var.a;
                if (m6Var2 == null) {
                    m6Var2 = new m6();
                }
                m6Var2.f = m6Var.f;
                m6Var2.g = m6Var.g;
                p6Var.a = m6Var2;
            }
            p6Var.g = k6.a(p6Var2.g);
        }
        return p6Var;
    }
}