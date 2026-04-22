package kntr.base.account.epoch.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.adapter.AccountStateNotifier;
import kotlin.Metadata;

/* compiled from: KAccount.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"provideAccount", "Lkntr/base/account/adapter/AccountStateNotifier;", "account_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KAccountKt {
    public static final AccountStateNotifier provideAccount() {
        return KAccount_androidKt.getMPlatformAccount();
    }
}