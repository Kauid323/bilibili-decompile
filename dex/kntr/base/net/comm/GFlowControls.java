package kntr.base.net.comm;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: GFlowControls.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J/\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\f¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/base/net/comm/GFlowControls;", "", "hiltFlowControl", "", "host", "", "path", "updateFlowControl", "", "httpCode", "", "after", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "Companion", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface GFlowControls {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String HEADER_RETRY_AFTER = "x-bili-retry-after";
    public static final int HTTP_CODE_HTTP_SERVICE_UNAVAILABLE = 503;
    public static final int HTTP_CODE_INTERNAL_SERVER_ERROR = 500;
    public static final int HTTP_CODE_INVALID = -1;
    public static final int HTTP_CODE_TOO_MANY_REQUESTS = 429;

    boolean hiltFlowControl(String str, String str2);

    void updateFlowControl(String str, String str2, int i, Integer num);

    /* compiled from: GFlowControls.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/base/net/comm/GFlowControls$Companion;", "", "<init>", "()V", "HTTP_CODE_INVALID", "", "HTTP_CODE_TOO_MANY_REQUESTS", "HTTP_CODE_INTERNAL_SERVER_ERROR", "HTTP_CODE_HTTP_SERVICE_UNAVAILABLE", "HEADER_RETRY_AFTER", "", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String HEADER_RETRY_AFTER = "x-bili-retry-after";
        public static final int HTTP_CODE_HTTP_SERVICE_UNAVAILABLE = 503;
        public static final int HTTP_CODE_INTERNAL_SERVER_ERROR = 500;
        public static final int HTTP_CODE_INVALID = -1;
        public static final int HTTP_CODE_TOO_MANY_REQUESTS = 429;

        private Companion() {
        }
    }
}