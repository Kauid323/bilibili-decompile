package tv.danmaku.bili.ui.main2.mine;

import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.gripper.api.PreTrigger;
import com.bilibili.ogv.infra.account.BiliAccountsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.main2.AccountMineInfoManager;
import tv.danmaku.bili.ui.main2.api.AccountMine;

/* compiled from: HomeUserCenterViewModel.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\b\u0010\u0004\u001a\u00020\u0001H\u0007¨\u0006\u0005"}, d2 = {"mineLog", "", AuthResultCbHelper.ARGS_MSG, "", "preloadFromCache", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeUserCenterViewModelKt {
    public static final void mineLog(String msg) {
        Intrinsics.checkNotNullParameter(msg, AuthResultCbHelper.ARGS_MSG);
        BLog.i("mine_log", msg);
    }

    @PreTrigger(trigger = "OnMainIdle")
    public static final void preloadFromCache() {
        if (BiliAccountsKt.getBiliAccounts().isLogin()) {
            mineLog("preloadFromCache");
            AccountMineInfoManager.getInstance().getLocalMineInfo(FoundationAlias.getFapp().getBaseContext(), new AccountMineInfoManager.LocalMineInfoLoadListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterViewModelKt$$ExternalSyntheticLambda0
                @Override // tv.danmaku.bili.ui.main2.AccountMineInfoManager.LocalMineInfoLoadListener
                public final void onLoadMineInfoLoaded(AccountMine accountMine) {
                    HomeUserCenterViewModelKt.mineLog("preloadFromCache ready");
                }
            });
        }
    }
}