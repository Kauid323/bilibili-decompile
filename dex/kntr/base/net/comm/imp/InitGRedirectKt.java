package kntr.base.net.comm.imp;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.comm.GRedirect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitGRedirect.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"provideGRedirect", "Lkntr/base/net/GInterceptor;", "redirect", "Lkntr/base/net/comm/GRedirect;", "redirect_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitGRedirectKt {
    public static final GInterceptor provideGRedirect(GRedirect redirect) {
        Intrinsics.checkNotNullParameter(redirect, "redirect");
        return new InitGRedirectKt$provideGRedirect$1(redirect);
    }
}