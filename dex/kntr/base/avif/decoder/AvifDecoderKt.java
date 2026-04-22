package kntr.base.avif.decoder;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: AvifDecoder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"avifDecoderMaxThreadsCount", "", "getAvifDecoderMaxThreadsCount", "()I", "avif_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AvifDecoderKt {
    public static final int getAvifDecoderMaxThreadsCount() {
        Integer intOrNull;
        String config = KConfig.INSTANCE.config("bili_image_avif_decoder_max_threads_count", "2");
        if (config == null || (intOrNull = StringsKt.toIntOrNull(config)) == null) {
            return 2;
        }
        return intOrNull.intValue();
    }
}