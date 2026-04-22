package tv.danmaku.bili.report.biz.api.consume.consumer.misaka.apm.internal.model;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: Protocols.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"booleanToInStr", "", "v", "", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ProtocolsKt {
    public static final String booleanToInStr(boolean v) {
        if (v) {
            return "1";
        }
        return "0";
    }
}