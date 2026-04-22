package kntr.base.device;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: KDevice.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0012\u0010\u0010\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0012\u0010\u0012\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\tR\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\tR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0012\u0010(\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\tR\u0016\u0010*\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\tR\u0016\u0010,\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\tR\u0016\u0010.\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\tR\u0016\u00100\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\tR\u0016\u00102\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\t¨\u00064À\u0006\u0003"}, d2 = {"Lkntr/base/device/IDevice;", "", "deviceType", "Lkntr/base/device/DeviceType;", "getDeviceType", "()Lkntr/base/device/DeviceType;", "buvid", "", "getBuvid", "()Ljava/lang/String;", "manufacturer", "getManufacturer", "model", "getModel", "hardwareModel", "getHardwareModel", "systemVersion", "getSystemVersion", "timeZone", "getTimeZone", "timeZoneOffset", "", "getTimeZoneOffset", "()I", "countryCode", "getCountryCode", "carrierName", "getCarrierName", "deviceName", "getDeviceName", "screenDimensions", "Lkntr/base/device/ScreenDimensions;", "getScreenDimensions", "()Lkntr/base/device/ScreenDimensions;", "totalDiskCapacity", "", "getTotalDiskCapacity", "()J", "totalMemory", "getTotalMemory", "language", "getLanguage", "androidId", "getAndroidId", "androidImei", "getAndroidImei", "androidOaId", "getAndroidOaId", "iosIdfa", "getIosIdfa", "iosMachine", "getIosMachine", "device_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IDevice {
    String getAndroidId();

    String getAndroidImei();

    String getAndroidOaId();

    String getBuvid();

    String getCarrierName();

    String getCountryCode();

    String getDeviceName();

    DeviceType getDeviceType();

    String getHardwareModel();

    String getIosIdfa();

    String getIosMachine();

    String getLanguage();

    String getManufacturer();

    String getModel();

    ScreenDimensions getScreenDimensions();

    String getSystemVersion();

    String getTimeZone();

    int getTimeZoneOffset();

    long getTotalDiskCapacity();

    long getTotalMemory();

    /* compiled from: KDevice.kt */
    /* renamed from: kntr.base.device.IDevice$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static String $default$getAndroidId(IDevice _this) {
            return null;
        }

        public static String $default$getAndroidImei(IDevice _this) {
            return null;
        }

        public static String $default$getAndroidOaId(IDevice _this) {
            return null;
        }

        public static String $default$getIosIdfa(IDevice _this) {
            return null;
        }

        public static String $default$getIosMachine(IDevice _this) {
            return null;
        }
    }

    /* compiled from: KDevice.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static String getAndroidId(IDevice $this) {
            return CC.$default$getAndroidId($this);
        }

        @Deprecated
        public static String getAndroidImei(IDevice $this) {
            return CC.$default$getAndroidImei($this);
        }

        @Deprecated
        public static String getAndroidOaId(IDevice $this) {
            return CC.$default$getAndroidOaId($this);
        }

        @Deprecated
        public static String getIosIdfa(IDevice $this) {
            return CC.$default$getIosIdfa($this);
        }

        @Deprecated
        public static String getIosMachine(IDevice $this) {
            return CC.$default$getIosMachine($this);
        }
    }
}