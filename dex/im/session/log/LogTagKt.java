package im.session.log;

import im.base.IMBroadcastManagerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogTag.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004\"\u0014\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004\"\u0014\u0010\t\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004\"\u0014\u0010\u000b\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0004\"\u0014\u0010\r\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0004\"\u0014\u0010\u000f\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0004\"\u0014\u0010\u0011\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0004\"\u0014\u0010\u0013\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0016"}, d2 = {"SessionLogTag", "", "SummaryLogTag", "getSummaryLogTag", "()Ljava/lang/String;", "UnreadLogTag", "getUnreadLogTag", "CacheLogTag", "getCacheLogTag", "BroadcastLogTag", "getBroadcastLogTag", "HomeLoadLogTag", "getHomeLoadLogTag", "SecondaryLoadLogTag", "getSecondaryLoadLogTag", "VMLogTag", "getVMLogTag", "UpdateLogTag", "getUpdateLogTag", "TechTrackLogTag", "getTechTrackLogTag", "type", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LogTagKt {
    public static final String SessionLogTag = "Session";
    private static final String SummaryLogTag = SessionLogTag("Summary");
    private static final String UnreadLogTag = SessionLogTag("Unread");
    private static final String CacheLogTag = SessionLogTag("Cache");
    private static final String BroadcastLogTag = SessionLogTag(IMBroadcastManagerKt.TAG);
    private static final String HomeLoadLogTag = SessionLogTag("HomeLoad");
    private static final String SecondaryLoadLogTag = SessionLogTag("SecondaryLoad");
    private static final String VMLogTag = SessionLogTag("VM");
    private static final String UpdateLogTag = SessionLogTag("Update");
    private static final String TechTrackLogTag = SessionLogTag("TechTrack");

    public static final String getSummaryLogTag() {
        return SummaryLogTag;
    }

    public static final String getUnreadLogTag() {
        return UnreadLogTag;
    }

    public static final String getCacheLogTag() {
        return CacheLogTag;
    }

    public static final String getBroadcastLogTag() {
        return BroadcastLogTag;
    }

    public static final String getHomeLoadLogTag() {
        return HomeLoadLogTag;
    }

    public static final String getSecondaryLoadLogTag() {
        return SecondaryLoadLogTag;
    }

    public static final String getVMLogTag() {
        return VMLogTag;
    }

    public static final String getUpdateLogTag() {
        return UpdateLogTag;
    }

    public static final String getTechTrackLogTag() {
        return TechTrackLogTag;
    }

    public static final String SessionLogTag(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return "Session-" + type;
    }
}