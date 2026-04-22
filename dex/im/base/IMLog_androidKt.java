package im.base;

import com.tencent.matrix.report.Issue;
import com.xiaomi.mipush.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMLog.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¨\u0006\u0006"}, d2 = {"logTag", "", Issue.ISSUE_REPORT_TAG, "module", "logMessage", "message", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMLog_androidKt {
    public static final String logTag(String tag, String module) {
        Intrinsics.checkNotNullParameter(tag, Issue.ISSUE_REPORT_TAG);
        Intrinsics.checkNotNullParameter(module, "module");
        return tag + Constants.ACCEPT_TIME_SEPARATOR_SERVER + module;
    }

    public static final String logMessage(String module, String message) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(message, "message");
        return message;
    }
}