package tv.danmaku.bili.bilow.ignet.util;

import com.bilibili.ignet.exception.IgNetworkException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: IgException.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"K_IGHTTP_TIMEOUT_DOMAIN_DOWNGRADE_CODES", "", "K_IGHTTP_EXCEPTION_DOMAIN_DOWNGRADE_CODES", "ignetShouldTryDomainDowngrade", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class IgExceptionKt {
    public static final String K_IGHTTP_EXCEPTION_DOMAIN_DOWNGRADE_CODES = "ighttp_exception_domain_downgrage_codes";
    public static final String K_IGHTTP_TIMEOUT_DOMAIN_DOWNGRADE_CODES = "ighttp_timeout_domain_downgrage_codes";

    public static final boolean ignetShouldTryDomainDowngrade(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        IgNetworkException cause = e.getCause();
        IgNetworkException igNetworkException = cause instanceof IgNetworkException ? cause : null;
        Boolean shouldTry = igNetworkException != null ? Boolean.valueOf(igNetworkException.tryDomainDowngrade()) : null;
        if (shouldTry != null) {
            return shouldTry.booleanValue();
        }
        return false;
    }
}