package im.session.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionPageExtraData.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"IMSessionPageExtraData", "Lim/session/model/IMSessionPageExtraData;", "response", "Lim/session/model/IMSessionPageData;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSessionPageExtraData_androidKt {
    public static final IMSessionPageExtraData IMSessionPageExtraData(IMSessionPageData response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return IMSessionPageExtraData.INSTANCE;
    }
}