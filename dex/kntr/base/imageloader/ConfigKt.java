package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: Config.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\"\u0011\u0010\u0000\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"iosUseSkiko", "", "getIosUseSkiko", "()Z", "nativeMainSupportAvif", "getNativeMainSupportAvif", "maxMemoryCacheSize", "", "getMaxMemoryCacheSize", "()I", "maxDiskCacheSize", "getMaxDiskCacheSize", "imageloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ConfigKt {
    public static final boolean getIosUseSkiko() {
        return KConfig.INSTANCE.ff("bili_image_ios_skiko_enable", true);
    }

    public static final boolean getNativeMainSupportAvif() {
        return KConfig.INSTANCE.ff("bili_image_native_main_avif_enable", true);
    }

    public static final int getMaxMemoryCacheSize() {
        Integer intOrNull;
        String config = KConfig.INSTANCE.config("bili_image_memory_cache_size_mb", "50");
        if (config == null || (intOrNull = StringsKt.toIntOrNull(config)) == null) {
            return 50;
        }
        return intOrNull.intValue();
    }

    public static final int getMaxDiskCacheSize() {
        Integer intOrNull;
        String config = KConfig.INSTANCE.config("bili_image_disk_cache_size_mb", "200");
        if (config == null || (intOrNull = StringsKt.toIntOrNull(config)) == null) {
            return 200;
        }
        return intOrNull.intValue();
    }
}