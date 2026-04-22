package kntr.base.net.comm;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: GAurora.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/base/net/comm/GAurora;", "", "zone", "", "host", "path", "xtraceId", "eid", "mid", "guestId", "updateRoute", "", "pathRoute", "clearRoute", "Companion", "aurora_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface GAurora {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String HEADER_AURORA_EID = "x-bili-aurora-eid";
    public static final String HEADER_AURORA_PATH_ROUTE = "x-bili-aurora-path-route";
    public static final String HEADER_AURORA_ZONE = "x-bili-aurora-zone";
    public static final String HEADER_GUEST_ID = "GuestId";
    public static final String HEADER_MID = "x-bili-mid";
    public static final String HEADER_XTRACE_ID = "x-bili-trace-id";

    void clearRoute(String str, String str2);

    String eid();

    String guestId();

    String mid();

    void updateRoute(String str, String str2, String str3);

    String xtraceId();

    String zone(String str, String str2);

    /* compiled from: GAurora.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/base/net/comm/GAurora$Companion;", "", "<init>", "()V", "HEADER_XTRACE_ID", "", "HEADER_AURORA_EID", "HEADER_MID", "HEADER_AURORA_PATH_ROUTE", "HEADER_AURORA_ZONE", "HEADER_GUEST_ID", "aurora_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String HEADER_AURORA_EID = "x-bili-aurora-eid";
        public static final String HEADER_AURORA_PATH_ROUTE = "x-bili-aurora-path-route";
        public static final String HEADER_AURORA_ZONE = "x-bili-aurora-zone";
        public static final String HEADER_GUEST_ID = "GuestId";
        public static final String HEADER_MID = "x-bili-mid";
        public static final String HEADER_XTRACE_ID = "x-bili-trace-id";

        private Companion() {
        }
    }
}