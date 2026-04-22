package kntr.base.device.epoch.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.device.IDevice;
import kotlin.Metadata;

/* compiled from: KDevice.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"mPlatformDevice", "Lkntr/base/device/IDevice;", "getMPlatformDevice", "()Lkntr/base/device/IDevice;", "device_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KDevice_androidKt {
    private static final IDevice mPlatformDevice = new KDevice_androidKt$mPlatformDevice$1();

    public static final IDevice getMPlatformDevice() {
        return mPlatformDevice;
    }
}