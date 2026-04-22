package tv.danmaku.bili.fullscreen.service;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: LoginReportService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"reportString", "", "", "getReportString", "(Z)Ljava/lang/String;", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginReportServiceKt {
    public static final String getReportString(boolean $this$reportString) {
        return $this$reportString ? "1" : "0";
    }
}