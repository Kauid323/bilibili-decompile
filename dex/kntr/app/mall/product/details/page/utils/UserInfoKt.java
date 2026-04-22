package kntr.app.mall.product.details.page.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kntr.base.account.model.UserInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: UserInfo.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0004\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"getUserInfo", "Lkntr/base/account/model/UserInfo;", "getUserId", "", "()Ljava/lang/Long;", "isUserLoggedIn", "", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UserInfoKt {
    public static final UserInfo getUserInfo() {
        AccountState accountState = (AccountState) KAccountStoreKt.getAccountHolder().getState().getValue();
        if (accountState instanceof AccountState.Idle) {
            return null;
        }
        if (accountState instanceof AccountState.Logged) {
            return ((AccountState.Logged) accountState).getUserInfo();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Long getUserId() {
        UserInfo userInfo = getUserInfo();
        if (userInfo != null) {
            return Long.valueOf(userInfo.getMid());
        }
        return null;
    }

    public static final boolean isUserLoggedIn() {
        AccountState accountState = (AccountState) KAccountStoreKt.getAccountHolder().getState().getValue();
        return accountState instanceof AccountState.Logged;
    }
}