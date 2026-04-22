package kntr.app.ad.domain.platformspec;

import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IAdPlatformSpec.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b/\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0005R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0005R\u0012\u0010 \u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0005R\u0014\u0010&\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0005R\u0014\u0010(\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0005R\u0014\u0010*\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0005R\u0014\u0010,\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0005R\u0014\u0010.\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0005R\u0014\u00100\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0005R\u0014\u00102\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0005R\u0014\u00104\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0005R\u0014\u00106\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0005R\u0014\u00108\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0005R\u0014\u0010:\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0005R\u0014\u0010<\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0005R\u0014\u0010>\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0005R\u0014\u0010@\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0005R\u0014\u0010B\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0005R\u0014\u0010D\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u0005R\u0014\u0010F\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0005R\u0014\u0010H\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u0005R\u0014\u0010J\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0005R\u0014\u0010L\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0005R\u0014\u0010N\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0005¨\u0006PÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/platformspec/IAdPlatformSpec;", RoomRecommendViewModel.EMPTY_CURSOR, "uaWeb", RoomRecommendViewModel.EMPTY_CURSOR, "getUaWeb", "()Ljava/lang/String;", "uaSys", "getUaSys", "bootMark", "getBootMark", "updateMark", "getUpdateMark", "networkV2", "getNetworkV2", ReportBuildInParam.NETWORK, "getNetwork", "userApps", "getUserApps", "storyShownIds", "getStoryShownIds", "dnsClientIp", "getDnsClientIp", "wxSdkVer", "getWxSdkVer", ReportBuildInParam.LNG, "getLng", ReportBuildInParam.LAT, "getLat", "lbsTs", "getLbsTs", "mobiApp", "getMobiApp", ReportBuildInParam.BUILD, RoomRecommendViewModel.EMPTY_CURSOR, "getBuild", "()I", ReportBuildInParam.MODEL, "getModel", "carrierName", "getCarrierName", "manufacturer", "getManufacturer", "osV", "getOsV", "screenSize", "getScreenSize", "androidId", "getAndroidId", ReportBuildInParam.IMEI, "getImei", ReportBuildInParam.OAID, "getOaid", "gameId", "getGameId", "wifiMacAddress", "getWifiMacAddress", ReportBuildInParam.BOOT_TIME_IN_SEC, "getBootTimeInSec", ReportBuildInParam.SYS_FILE_TIME, "getSysFileTime", "initialTime", "getInitialTime", "hardwareModel", "getHardwareModel", ReportBuildInParam.COUNTRY_CODE, "getCountryCode", ReportBuildInParam.DEVICE_NAME, "getDeviceName", ReportBuildInParam.LANGUAGE, "getLanguage", ReportBuildInParam.IDFA, "getIdfa", ReportBuildInParam.MACHINE, "getMachine", "totalDiskCapacity", "getTotalDiskCapacity", "totalMemory", "getTotalMemory", "timeZoneOffset", "getTimeZoneOffset", "platformspec_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAdPlatformSpec {
    String getAndroidId();

    String getBootMark();

    String getBootTimeInSec();

    int getBuild();

    String getCarrierName();

    String getCountryCode();

    String getDeviceName();

    String getDnsClientIp();

    String getGameId();

    String getHardwareModel();

    String getIdfa();

    String getImei();

    String getInitialTime();

    String getLanguage();

    String getLat();

    String getLbsTs();

    String getLng();

    String getMachine();

    String getManufacturer();

    String getMobiApp();

    String getModel();

    String getNetwork();

    String getNetworkV2();

    String getOaid();

    String getOsV();

    String getScreenSize();

    String getStoryShownIds();

    String getSysFileTime();

    String getTimeZoneOffset();

    String getTotalDiskCapacity();

    String getTotalMemory();

    String getUaSys();

    String getUaWeb();

    String getUpdateMark();

    String getUserApps();

    String getWifiMacAddress();

    String getWxSdkVer();
}