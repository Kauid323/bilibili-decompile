package kntr.base.upos.epoch.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.upos.UpOS;
import kotlin.Metadata;

/* compiled from: KUpOS.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"provideUpOS", "Lkntr/base/upos/UpOS;", "upos_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KUpOSKt {
    public static final UpOS provideUpOS() {
        return KUpOS_androidKt.getPlatformUpOS();
    }
}