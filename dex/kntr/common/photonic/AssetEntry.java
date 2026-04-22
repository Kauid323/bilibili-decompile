package kntr.common.photonic;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.photonic.compressor.AssetCompressorHolder;
import kntr.common.photonic.di.AssetEntryPoint;
import kntr.common.photonic.finder.AssetFinderHolder;
import kntr.common.photonic.shower.AssetShowerHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* compiled from: AssetEntry.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkntr/common/photonic/AssetEntry;", "", "<init>", "()V", "entryPoint", "Lkntr/common/photonic/di/AssetEntryPoint;", "finder", "Lkntr/common/photonic/finder/AssetFinderHolder;", "getFinder", "()Lkntr/common/photonic/finder/AssetFinderHolder;", "shower", "Lkntr/common/photonic/shower/AssetShowerHolder;", "getShower", "()Lkntr/common/photonic/shower/AssetShowerHolder;", "compressor", "Lkntr/common/photonic/compressor/AssetCompressorHolder;", "getCompressor", "()Lkntr/common/photonic/compressor/AssetCompressorHolder;", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetEntry {
    public static final int $stable;
    public static final AssetEntry INSTANCE = new AssetEntry();
    private static final AssetCompressorHolder compressor;
    private static final AssetEntryPoint entryPoint;
    private static final AssetFinderHolder finder;
    private static final AssetShowerHolder shower;

    private AssetEntry() {
    }

    static {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        entryPoint = (AssetEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(AssetEntryPoint.class));
        finder = entryPoint.getAssetFinderHolder();
        shower = entryPoint.getAssetShowerHolder();
        compressor = entryPoint.getAssetCompressorHolder();
        $stable = 8;
    }

    public final AssetFinderHolder getFinder() {
        return finder;
    }

    public final AssetShowerHolder getShower() {
        return shower;
    }

    public final AssetCompressorHolder getCompressor() {
        return compressor;
    }
}