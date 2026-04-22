package kntr.common.upper.trace.config;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: TraceDefine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/common/upper/trace/config/AppKey;", "", "<init>", "()V", "SIDE", "", "VERSION", "VERSION_CODE", "BILI_APP_ID", "USER_STATUS", "UID", "APP_TRACE_ID", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AppKey {
    public static final String APP_TRACE_ID = "app_traceid";
    public static final String BILI_APP_ID = "bili_app_id";
    public static final AppKey INSTANCE = new AppKey();
    public static final String SIDE = "side";
    public static final String UID = "uid";
    public static final String USER_STATUS = "user_status";
    public static final String VERSION = "version";
    public static final String VERSION_CODE = "version_code";

    private AppKey() {
    }
}