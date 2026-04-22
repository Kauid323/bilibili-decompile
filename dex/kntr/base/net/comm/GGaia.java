package kntr.base.net.comm;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: GGaia.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/base/net/comm/GGaia;", "", "gaiaToken", "", "host", "path", "Companion", "gaia_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface GGaia {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String HEADER_GAIA_PARAMS = "x-bili-gaia-param";
    public static final String HEADER_GAIA_TOKEN = "x-bili-gaia-vtoken";
    public static final String HEADER_GAIA_VALUE_COLLECT = "fp_collect";
    public static final String HEADER_GAIA_VOUCHER = "x-bili-gaia-vvoucher";

    String gaiaToken(String str, String str2);

    /* compiled from: GGaia.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/base/net/comm/GGaia$Companion;", "", "<init>", "()V", "HEADER_GAIA_TOKEN", "", "HEADER_GAIA_VOUCHER", "HEADER_GAIA_PARAMS", "HEADER_GAIA_VALUE_COLLECT", "gaia_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String HEADER_GAIA_PARAMS = "x-bili-gaia-param";
        public static final String HEADER_GAIA_TOKEN = "x-bili-gaia-vtoken";
        public static final String HEADER_GAIA_VALUE_COLLECT = "fp_collect";
        public static final String HEADER_GAIA_VOUCHER = "x-bili-gaia-vvoucher";

        private Companion() {
        }
    }
}