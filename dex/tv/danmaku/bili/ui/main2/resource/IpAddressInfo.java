package tv.danmaku.bili.ui.main2.resource;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.CountryCodeSelectActivity;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeIpAddressManager.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0083\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010 \u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020!H\u0007J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018Jb\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\bHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\"\u0010\n\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001a¨\u00060"}, d2 = {"Ltv/danmaku/bili/ui/main2/resource/IpAddressInfo;", "", "addr", "", LoginReporterV2.Click.SIGNUP_KEY_COUNTRY, "city", "isp", "zoneId", "", "province", "countryCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getAddr", "()Ljava/lang/String;", "setAddr", "(Ljava/lang/String;)V", "getCountry", "setCountry", "getCity", "setCity", "getIsp", "setIsp", "getZoneId", "()Ljava/lang/Integer;", "setZoneId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getProvince", "setProvince", "getCountryCode", "setCountryCode", "isInHkMoTw", "", "isOverseas", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Ltv/danmaku/bili/ui/main2/resource/IpAddressInfo;", "equals", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class IpAddressInfo {
    @JSONField(name = "addr")
    private String addr;
    @JSONField(name = "city")
    private String city;
    @JSONField(name = LoginReporterV2.Click.SIGNUP_KEY_COUNTRY)
    private String country;
    @JSONField(name = CountryCodeSelectActivity.KEY_COUNTRY_CODE)
    private Integer countryCode;
    @JSONField(name = "isp")
    private String isp;
    @JSONField(name = "province")
    private String province;
    @JSONField(name = "zone_id")
    private Integer zoneId;

    public IpAddressInfo() {
        this(null, null, null, null, null, null, null, BR.countdownTrackEnabled, null);
    }

    public static /* synthetic */ IpAddressInfo copy$default(IpAddressInfo ipAddressInfo, String str, String str2, String str3, String str4, Integer num, String str5, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ipAddressInfo.addr;
        }
        if ((i & 2) != 0) {
            str2 = ipAddressInfo.country;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = ipAddressInfo.city;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = ipAddressInfo.isp;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            num = ipAddressInfo.zoneId;
        }
        Integer num3 = num;
        if ((i & 32) != 0) {
            str5 = ipAddressInfo.province;
        }
        String str9 = str5;
        if ((i & 64) != 0) {
            num2 = ipAddressInfo.countryCode;
        }
        return ipAddressInfo.copy(str, str6, str7, str8, num3, str9, num2);
    }

    public final String component1() {
        return this.addr;
    }

    public final String component2() {
        return this.country;
    }

    public final String component3() {
        return this.city;
    }

    public final String component4() {
        return this.isp;
    }

    public final Integer component5() {
        return this.zoneId;
    }

    public final String component6() {
        return this.province;
    }

    public final Integer component7() {
        return this.countryCode;
    }

    public final IpAddressInfo copy(String str, String str2, String str3, String str4, Integer num, String str5, Integer num2) {
        return new IpAddressInfo(str, str2, str3, str4, num, str5, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IpAddressInfo) {
            IpAddressInfo ipAddressInfo = (IpAddressInfo) obj;
            return Intrinsics.areEqual(this.addr, ipAddressInfo.addr) && Intrinsics.areEqual(this.country, ipAddressInfo.country) && Intrinsics.areEqual(this.city, ipAddressInfo.city) && Intrinsics.areEqual(this.isp, ipAddressInfo.isp) && Intrinsics.areEqual(this.zoneId, ipAddressInfo.zoneId) && Intrinsics.areEqual(this.province, ipAddressInfo.province) && Intrinsics.areEqual(this.countryCode, ipAddressInfo.countryCode);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((this.addr == null ? 0 : this.addr.hashCode()) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.city == null ? 0 : this.city.hashCode())) * 31) + (this.isp == null ? 0 : this.isp.hashCode())) * 31) + (this.zoneId == null ? 0 : this.zoneId.hashCode())) * 31) + (this.province == null ? 0 : this.province.hashCode())) * 31) + (this.countryCode != null ? this.countryCode.hashCode() : 0);
    }

    public String toString() {
        String str = this.addr;
        String str2 = this.country;
        String str3 = this.city;
        String str4 = this.isp;
        Integer num = this.zoneId;
        String str5 = this.province;
        return "IpAddressInfo(addr=" + str + ", country=" + str2 + ", city=" + str3 + ", isp=" + str4 + ", zoneId=" + num + ", province=" + str5 + ", countryCode=" + this.countryCode + ")";
    }

    public IpAddressInfo(String addr, String country, String city, String isp, Integer zoneId, String province, Integer countryCode) {
        this.addr = addr;
        this.country = country;
        this.city = city;
        this.isp = isp;
        this.zoneId = zoneId;
        this.province = province;
        this.countryCode = countryCode;
    }

    public /* synthetic */ IpAddressInfo(String str, String str2, String str3, String str4, Integer num, String str5, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : num2);
    }

    public final String getAddr() {
        return this.addr;
    }

    public final void setAddr(String str) {
        this.addr = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getIsp() {
        return this.isp;
    }

    public final void setIsp(String str) {
        this.isp = str;
    }

    public final Integer getZoneId() {
        return this.zoneId;
    }

    public final void setZoneId(Integer num) {
        this.zoneId = num;
    }

    public final String getProvince() {
        return this.province;
    }

    public final void setProvince(String str) {
        this.province = str;
    }

    public final Integer getCountryCode() {
        return this.countryCode;
    }

    public final void setCountryCode(Integer num) {
        this.countryCode = num;
    }

    @JSONField(serialize = false)
    public final boolean isInHkMoTw() {
        Integer num;
        Integer num2;
        Integer num3 = this.zoneId;
        return (num3 != null && num3.intValue() == 1035993088) || ((num = this.zoneId) != null && num.intValue() == 1044381696) || ((num2 = this.zoneId) != null && num2.intValue() == 1040187392);
    }

    @JSONField(serialize = false)
    public final boolean isOverseas() {
        if (this.countryCode != null) {
            Integer num = this.countryCode;
            if (num != null && num.intValue() == 86) {
                return false;
            }
            return true;
        }
        return false;
    }
}