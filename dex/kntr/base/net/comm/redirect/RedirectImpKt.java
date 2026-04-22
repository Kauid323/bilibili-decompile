package kntr.base.net.comm.redirect;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.KAccountStore;
import kntr.base.net.comm.GRedirect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RedirectImp.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"REDIRECT_KV_STORE", "", "REDIRECT_KV_CONFIG", "providesGRedirect", "Lkntr/base/net/comm/GRedirect;", "accountStore", "Lkntr/base/account/KAccountStore;", "redirect_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RedirectImpKt {
    public static final String REDIRECT_KV_CONFIG = "config";
    public static final String REDIRECT_KV_STORE = "redirect_store";

    public static final GRedirect providesGRedirect(KAccountStore accountStore) {
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        return new RedirectImp(accountStore);
    }
}