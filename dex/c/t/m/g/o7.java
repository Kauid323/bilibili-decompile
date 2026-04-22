package c.t.m.g;

import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import java.util.List;

/* compiled from: TML */
public class o7 implements TencentLocation {
    public static final o7 b = new o7();
    public TencentLocation a;

    public o7() {
    }

    public float getAccuracy() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0.0f;
        }
        return tencentLocation.getAccuracy();
    }

    public String getAddress() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getAddress();
    }

    public double getAltitude() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0.0d;
        }
        return tencentLocation.getAltitude();
    }

    public Integer getAreaStat() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getAreaStat();
    }

    public float getBearing() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0.0f;
        }
        return tencentLocation.getBearing();
    }

    public String getCity() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getCity();
    }

    public String getCityCode() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getCityCode();
    }

    public String getCityPhoneCode() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getCityPhoneCode();
    }

    public int getCoordinateType() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0;
        }
        return tencentLocation.getCoordinateType();
    }

    public double getDirection() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0.0d;
        }
        return tencentLocation.getDirection();
    }

    public String getDistrict() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getDistrict();
    }

    public long getElapsedRealtime() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0L;
        }
        return tencentLocation.getElapsedRealtime();
    }

    public Bundle getExtra() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getExtra();
    }

    public float getFakeProbability() {
        return v4.a(getFakeReason());
    }

    public int getFakeReason() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0;
        }
        return tencentLocation.getFakeReason();
    }

    public int getGPSRssi() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0;
        }
        return tencentLocation.getGPSRssi();
    }

    public String getIndoorBuildingFloor() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getIndoorBuildingFloor();
    }

    public String getIndoorBuildingId() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getIndoorBuildingId();
    }

    public int getIndoorLocationType() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0;
        }
        return tencentLocation.getIndoorLocationType();
    }

    public double getLatitude() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0.0d;
        }
        return tencentLocation.getLatitude();
    }

    public double getLongitude() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0.0d;
        }
        return tencentLocation.getLongitude();
    }

    public String getName() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getName();
    }

    public String getNation() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getNation();
    }

    public int getNationCode() {
        return 0;
    }

    public List<TencentPoi> getPoiList() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getPoiList();
    }

    public String getProvider() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getProvider();
    }

    public String getProvince() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getProvince();
    }

    public String getSourceProvider() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getSourceProvider();
    }

    public float getSpeed() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0.0f;
        }
        return tencentLocation.getSpeed();
    }

    public String getStreet() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getStreet();
    }

    public String getStreetNo() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getStreetNo();
    }

    public long getTime() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0L;
        }
        return tencentLocation.getTime();
    }

    public String getTown() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getTown();
    }

    public String getVillage() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getVillage();
    }

    public String getadCode() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getadCode();
    }

    public int isMockGps() {
        TencentLocation tencentLocation = this.a;
        if (tencentLocation == null) {
            return 0;
        }
        return tencentLocation.isMockGps();
    }

    public o7(TencentLocation tencentLocation) {
        this.a = tencentLocation;
    }
}