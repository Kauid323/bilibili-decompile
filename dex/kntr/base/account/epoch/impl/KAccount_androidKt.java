package kntr.base.account.epoch.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.adapter.AccountStateNotifier;
import kotlin.Metadata;

/* compiled from: KAccount.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"mPlatformAccount", "Lkntr/base/account/adapter/AccountStateNotifier;", "getMPlatformAccount", "()Lkntr/base/account/adapter/AccountStateNotifier;", "account_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KAccount_androidKt {
    private static final AccountStateNotifier mPlatformAccount = new KAccount_androidKt$mPlatformAccount$1();

    public static final AccountStateNotifier getMPlatformAccount() {
        return mPlatformAccount;
    }
}