package c.t.m.g;

import android.os.Bundle;
import com.alipay.alipaysecuritysdk.common.exception.ErrorCode;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import java.util.List;

/* compiled from: TML */
public class n7 implements TencentLocation {
    public static final String k = "n7";
    public static final n7 l = new n7();
    public int a;
    public TencentLocation b;

    /* renamed from: c  reason: collision with root package name */
    public double f75c;
    public double d;
    public float e;
    public float f;
    public float g;
    public float h;
    public String i;
    public long j;

    public n7() {
        this.b = o7.b;
        this.f75c = -91.0d;
        this.d = -181.0d;
        this.e = -9999.0f;
        this.f = -1.0f;
        this.g = -1.0f;
        this.h = -1.0f;
        this.j = -1L;
        this.a = ErrorCode.E_INVALID_ARGUMENT;
    }

    public void a(k7 k7Var) {
        try {
            this.a = k7Var.f() <= 0.0d ? 5 : 0;
            this.f75c = k7Var.d();
            this.d = k7Var.e();
            this.e = (float) k7Var.b();
            this.f = (float) k7Var.a();
            this.g = (float) k7Var.c();
            this.h = (float) k7Var.h();
            this.i = k7Var.g();
            this.j = k7Var.i();
        } catch (Exception e) {
            w3.b(k, "build obj from dr err");
        }
    }

    public float getAccuracy() {
        return this.j != -1 ? this.f : this.b.getAccuracy();
    }

    public String getAddress() {
        return this.b.getAddress();
    }

    public double getAltitude() {
        return this.j != -1 ? this.e : this.b.getAltitude();
    }

    public Integer getAreaStat() {
        return this.b.getAreaStat();
    }

    public float getBearing() {
        return this.j != -1 ? this.g : this.b.getBearing();
    }

    public String getCity() {
        return this.b.getCity();
    }

    public String getCityCode() {
        return this.b.getCityCode();
    }

    public String getCityPhoneCode() {
        return this.b.getCityPhoneCode();
    }

    public int getCoordinateType() {
        return this.b.getCoordinateType();
    }

    public double getDirection() {
        return this.b.getDirection();
    }

    public String getDistrict() {
        return this.b.getDistrict();
    }

    public long getElapsedRealtime() {
        return this.b.getElapsedRealtime();
    }

    public Bundle getExtra() {
        return this.b.getExtra();
    }

    public float getFakeProbability() {
        return v4.a(getFakeReason());
    }

    public int getFakeReason() {
        return 0;
    }

    public int getGPSRssi() {
        return this.b.getGPSRssi();
    }

    public String getIndoorBuildingFloor() {
        return this.b.getIndoorBuildingFloor();
    }

    public String getIndoorBuildingId() {
        return this.b.getIndoorBuildingId();
    }

    public int getIndoorLocationType() {
        return this.b.getIndoorLocationType();
    }

    public double getLatitude() {
        return this.j != -1 ? this.f75c : this.b.getLatitude();
    }

    public double getLongitude() {
        return this.j != -1 ? this.d : this.b.getLongitude();
    }

    public String getName() {
        return this.b.getName();
    }

    public String getNation() {
        return this.b.getNation();
    }

    public int getNationCode() {
        return 0;
    }

    public List<TencentPoi> getPoiList() {
        return this.b.getPoiList();
    }

    public String getProvider() {
        return this.j != -1 ? this.i : this.b.getProvider();
    }

    public String getProvince() {
        return this.b.getProvince();
    }

    public String getSourceProvider() {
        TencentLocation tencentLocation = this.b;
        if (tencentLocation == o7.b) {
            return null;
        }
        return tencentLocation.getSourceProvider();
    }

    public float getSpeed() {
        return this.j != -1 ? this.h : this.b.getSpeed();
    }

    public String getStreet() {
        return this.b.getStreet();
    }

    public String getStreetNo() {
        return this.b.getStreetNo();
    }

    public long getTime() {
        long j = this.j;
        return j != -1 ? j : this.b.getTime();
    }

    public String getTown() {
        return this.b.getTown();
    }

    public String getVillage() {
        return this.b.getVillage();
    }

    public String getadCode() {
        return this.b.getadCode();
    }

    public int isMockGps() {
        return this.b.isMockGps();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TencentLocation{");
        sb.append("name=").append(getName()).append(",");
        sb.append("address=").append(getAddress()).append(",");
        sb.append("provider=").append(getProvider()).append(",");
        sb.append("latitude=").append(getLatitude()).append(",");
        sb.append("longitude=").append(getLongitude()).append(",");
        sb.append("altitude=").append(getAltitude()).append(",");
        sb.append("accuracy=").append(getAccuracy()).append(",");
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
        sb.append("bearing=").append(getBearing()).append(",");
        sb.append("time=").append(getTime()).append(",");
        sb.append(com.alipay.sdk.m.q.h.d);
        return sb.toString();
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(TencentLocation tencentLocation) {
        this.b = tencentLocation;
    }

    public int a() {
        return this.a;
    }

    public n7(TencentLocation tencentLocation) {
        this.b = o7.b;
        this.f75c = -91.0d;
        this.d = -181.0d;
        this.e = -9999.0f;
        this.f = -1.0f;
        this.g = -1.0f;
        this.h = -1.0f;
        this.j = -1L;
        try {
            this.b = new o7(tencentLocation);
        } catch (Exception e) {
            w3.b(k, "build obj from txloc err");
        }
    }

    public n7(k7 k7Var) {
        this.b = o7.b;
        this.f75c = -91.0d;
        this.d = -181.0d;
        this.e = -9999.0f;
        this.f = -1.0f;
        this.g = -1.0f;
        this.h = -1.0f;
        this.j = -1L;
        a(k7Var);
    }
}