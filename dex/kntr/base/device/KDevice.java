package kntr.base.device;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: KDevice.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0012\u0010\f\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0012\u0010\u0014\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u0012\u0010\u001e\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007R\u0012\u0010 \u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u0007R\u0012\u0010\"\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010\u0007R\u0012\u0010$\u001a\u00020%X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0012\u0010(\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010\u0007R\u0012\u0010*\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b+\u0010\u0007R\u0012\u0010,\u001a\u00020-X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0012\u00100\u001a\u000201X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00103R\u0012\u00104\u001a\u000201X\u0096\u0005¢\u0006\u0006\u001a\u0004\b5\u00103¨\u00066"}, d2 = {"Lkntr/base/device/KDevice;", "Lkntr/base/device/IDevice;", "<init>", "()V", "androidId", "", "getAndroidId", "()Ljava/lang/String;", "androidImei", "getAndroidImei", "androidOaId", "getAndroidOaId", "buvid", "getBuvid", "carrierName", "getCarrierName", "countryCode", "getCountryCode", "deviceName", "getDeviceName", "deviceType", "Lkntr/base/device/DeviceType;", "getDeviceType", "()Lkntr/base/device/DeviceType;", "hardwareModel", "getHardwareModel", "iosIdfa", "getIosIdfa", "iosMachine", "getIosMachine", "language", "getLanguage", "manufacturer", "getManufacturer", "model", "getModel", "screenDimensions", "Lkntr/base/device/ScreenDimensions;", "getScreenDimensions", "()Lkntr/base/device/ScreenDimensions;", "systemVersion", "getSystemVersion", "timeZone", "getTimeZone", "timeZoneOffset", "", "getTimeZoneOffset", "()I", "totalDiskCapacity", "", "getTotalDiskCapacity", "()J", "totalMemory", "getTotalMemory", "device_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KDevice implements IDevice {
    public static final KDevice INSTANCE = new KDevice();
    private final /* synthetic */ IDevice $$delegate_0 = KDeviceKt.getPlatformDevice();

    @Override // kntr.base.device.IDevice
    public String getAndroidId() {
        return this.$$delegate_0.getAndroidId();
    }

    @Override // kntr.base.device.IDevice
    public String getAndroidImei() {
        return this.$$delegate_0.getAndroidImei();
    }

    @Override // kntr.base.device.IDevice
    public String getAndroidOaId() {
        return this.$$delegate_0.getAndroidOaId();
    }

    @Override // kntr.base.device.IDevice
    public String getBuvid() {
        return this.$$delegate_0.getBuvid();
    }

    @Override // kntr.base.device.IDevice
    public String getCarrierName() {
        return this.$$delegate_0.getCarrierName();
    }

    @Override // kntr.base.device.IDevice
    public String getCountryCode() {
        return this.$$delegate_0.getCountryCode();
    }

    @Override // kntr.base.device.IDevice
    public String getDeviceName() {
        return this.$$delegate_0.getDeviceName();
    }

    @Override // kntr.base.device.IDevice
    public DeviceType getDeviceType() {
        return this.$$delegate_0.getDeviceType();
    }

    @Override // kntr.base.device.IDevice
    public String getHardwareModel() {
        return this.$$delegate_0.getHardwareModel();
    }

    @Override // kntr.base.device.IDevice
    public String getIosIdfa() {
        return this.$$delegate_0.getIosIdfa();
    }

    @Override // kntr.base.device.IDevice
    public String getIosMachine() {
        return this.$$delegate_0.getIosMachine();
    }

    @Override // kntr.base.device.IDevice
    public String getLanguage() {
        return this.$$delegate_0.getLanguage();
    }

    @Override // kntr.base.device.IDevice
    public String getManufacturer() {
        return this.$$delegate_0.getManufacturer();
    }

    @Override // kntr.base.device.IDevice
    public String getModel() {
        return this.$$delegate_0.getModel();
    }

    @Override // kntr.base.device.IDevice
    public ScreenDimensions getScreenDimensions() {
        return this.$$delegate_0.getScreenDimensions();
    }

    @Override // kntr.base.device.IDevice
    public String getSystemVersion() {
        return this.$$delegate_0.getSystemVersion();
    }

    @Override // kntr.base.device.IDevice
    public String getTimeZone() {
        return this.$$delegate_0.getTimeZone();
    }

    @Override // kntr.base.device.IDevice
    public int getTimeZoneOffset() {
        return this.$$delegate_0.getTimeZoneOffset();
    }

    @Override // kntr.base.device.IDevice
    public long getTotalDiskCapacity() {
        return this.$$delegate_0.getTotalDiskCapacity();
    }

    @Override // kntr.base.device.IDevice
    public long getTotalMemory() {
        return this.$$delegate_0.getTotalMemory();
    }

    private KDevice() {
    }
}