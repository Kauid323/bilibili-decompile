package kntr.app.ad.domain.platformspec;

import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IAdPlatformSpecProvider.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\t\u001a\u0004\u0018\u00010\nH'J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0017J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0017J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0017¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/platformspec/IAdPlatformSpecProvider;", RoomRecommendViewModel.EMPTY_CURSOR, "uaWeb", RoomRecommendViewModel.EMPTY_CURSOR, "uaSys", "bootMark", "updateMark", "userApps", "wxSdkVer", "location", "Lkntr/app/ad/domain/platformspec/AdLocation;", "networkV2", ReportBuildInParam.NETWORK, "storyShownIds", "dnsClientIp", ReportBuildInParam.OAID, "gameId", "wifiMacAddress", ReportBuildInParam.BOOT_TIME_IN_SEC, ReportBuildInParam.SYS_FILE_TIME, "initialTime", "platformspec_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAdPlatformSpecProvider {
    String bootMark();

    String bootTimeInSec();

    String dnsClientIp();

    String gameId();

    String initialTime();

    AdLocation location();

    String network();

    String networkV2();

    String oaid();

    String storyShownIds();

    String sysFileTime();

    String uaSys();

    String uaWeb();

    String updateMark();

    String userApps();

    String wifiMacAddress();

    String wxSdkVer();

    /* compiled from: IAdPlatformSpecProvider.kt */
    /* renamed from: kntr.app.ad.domain.platformspec.IAdPlatformSpecProvider$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static String $default$oaid(IAdPlatformSpecProvider _this) {
            return null;
        }

        public static String $default$gameId(IAdPlatformSpecProvider _this) {
            return null;
        }

        public static String $default$wifiMacAddress(IAdPlatformSpecProvider _this) {
            return null;
        }

        public static String $default$bootTimeInSec(IAdPlatformSpecProvider _this) {
            return null;
        }

        public static String $default$sysFileTime(IAdPlatformSpecProvider _this) {
            return null;
        }

        public static String $default$initialTime(IAdPlatformSpecProvider _this) {
            return null;
        }
    }

    /* compiled from: IAdPlatformSpecProvider.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static String oaid(IAdPlatformSpecProvider $this) {
            return CC.$default$oaid($this);
        }

        @Deprecated
        public static String gameId(IAdPlatformSpecProvider $this) {
            return CC.$default$gameId($this);
        }

        @Deprecated
        public static String wifiMacAddress(IAdPlatformSpecProvider $this) {
            return CC.$default$wifiMacAddress($this);
        }

        @Deprecated
        public static String bootTimeInSec(IAdPlatformSpecProvider $this) {
            return CC.$default$bootTimeInSec($this);
        }

        @Deprecated
        public static String sysFileTime(IAdPlatformSpecProvider $this) {
            return CC.$default$sysFileTime($this);
        }

        @Deprecated
        public static String initialTime(IAdPlatformSpecProvider $this) {
            return CC.$default$initialTime($this);
        }
    }
}