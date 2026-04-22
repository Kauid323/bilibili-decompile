package kntr.base.KDownloader.KDownloader;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* compiled from: KDownloader.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"iDownloader", "Lkntr/base/KDownloader/KDownloader/IDownloader;", "getIDownloader", "()Lkntr/base/KDownloader/KDownloader/IDownloader;", "DOWNLOAD_DIR_PREFIX", "", "getDOWNLOAD_DIR_PREFIX", "()Ljava/lang/String;", "downloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KDownloaderKt {
    private static final String DOWNLOAD_DIR_PREFIX;
    private static final IDownloader iDownloader;

    static {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        iDownloader = ((IDownloaderEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(IDownloaderEntryPoint.class))).iDownloader();
        DOWNLOAD_DIR_PREFIX = "kntrbasedownloader";
    }

    public static final IDownloader getIDownloader() {
        return iDownloader;
    }

    public static final String getDOWNLOAD_DIR_PREFIX() {
        return DOWNLOAD_DIR_PREFIX;
    }
}