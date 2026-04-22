package kntr.base.net.comm.imp;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.comm.GMultiDomain;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitGMultiDomain.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"HTTP_CODE_INTERNAL_SERVER_ERROR", "", "HTTP_CODE_HTTP_BAD_GATEWAY", "HTTP_CODE_HTTP_SERVICE_UNAVAILABLE", "HTTP_CODE_GATEWAY_TIMEOUT", "provideGMultiDomain", "Lkntr/base/net/GInterceptor;", "multiDomain", "Lkntr/base/net/comm/GMultiDomain;", "multi_domain_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitGMultiDomainKt {
    public static final int HTTP_CODE_GATEWAY_TIMEOUT = 504;
    public static final int HTTP_CODE_HTTP_BAD_GATEWAY = 502;
    public static final int HTTP_CODE_HTTP_SERVICE_UNAVAILABLE = 503;
    public static final int HTTP_CODE_INTERNAL_SERVER_ERROR = 500;

    public static final GInterceptor provideGMultiDomain(GMultiDomain multiDomain) {
        Intrinsics.checkNotNullParameter(multiDomain, "multiDomain");
        return new InitGMultiDomainKt$provideGMultiDomain$1(multiDomain);
    }
}