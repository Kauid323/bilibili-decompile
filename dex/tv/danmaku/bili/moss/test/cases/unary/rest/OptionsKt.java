package tv.danmaku.bili.moss.test.cases.unary.rest;

import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.CallOptionsKt;
import com.bilibili.lib.moss.api.RestReqContentType;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: Options.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0006\u001a\u00020\u0007H\u0000\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"formType", "", "getFormType", "()Z", "setFormType", "(Z)V", "contentTypeOptions", "Lcom/bilibili/lib/moss/api/CallOptions;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OptionsKt {
    private static boolean formType = true;

    public static final boolean getFormType() {
        return formType;
    }

    public static final void setFormType(boolean z) {
        formType = z;
    }

    public static final CallOptions contentTypeOptions() {
        if (formType) {
            return CallOptionsKt.getDEF_OPTIONS().withRestReqContentType(RestReqContentType.FORM);
        }
        return CallOptionsKt.getDEF_OPTIONS().withRestReqContentType(RestReqContentType.JSON);
    }
}