package tv.danmaku.bili.bilow.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.bilow.lb.Lbs;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: RetriableGateway.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"isRetryableGatewayResponse", "", "response", "Lokhttp3/Response;", "isRetryableHttpCode", LoginReporterV2.Show.SIGNUP_KEY_CODE, "", "isRetryableHost", ReportEvent.Tag.HOST, "", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RetriableGatewayKt {
    public static final boolean isRetryableGatewayResponse(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        int code = response.code();
        if (isRetryableHttpCode(code)) {
            String host = response.request().url().host();
            Intrinsics.checkNotNull(host);
            return isRetryableHost(host);
        }
        return false;
    }

    private static final boolean isRetryableHttpCode(int code) {
        return code == 502 || code == 504 || code == 500;
    }

    private static final boolean isRetryableHost(String host) {
        return Lbs.INSTANCE.isLbHost(host);
    }
}