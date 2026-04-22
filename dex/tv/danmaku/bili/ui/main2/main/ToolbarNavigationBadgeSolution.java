package tv.danmaku.bili.ui.main2.main;

import android.content.Context;
import com.bilibili.lib.accountinfo.model.OfficialVerify;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.homepage.startdust.INavigationUserInfoSolution;
import tv.danmaku.bili.ui.answer.AnswerHelper;
import tv.danmaku.bili.ui.main2.AccountMineInfoManager;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment;

public class ToolbarNavigationBadgeSolution implements INavigationUserInfoSolution {
    private AnswerHelper mAnswerHelper;
    private Context mContext;

    public ToolbarNavigationBadgeSolution(BaseMainFrameFragment fragment) {
        this.mContext = fragment.getActivity();
        this.mAnswerHelper = new AnswerHelper(this.mContext);
    }

    public void onCreate() {
    }

    public boolean isShowAccountBadge() {
        AccountMine mCache;
        boolean isLogin = BiliAccounts.get(this.mContext).isLogin();
        return isLogin && (mCache = AccountMineInfoManager.getInstance().getMemoryMineInfo()) != null && !mCache.isFormalAccount() && this.mAnswerHelper.shouldShowEntry();
    }

    public boolean isShowNoticeBadge() {
        boolean hasDrawerMenuRedDot = AccountMineInfoManager.getInstance().hasDrawerMenuRedDot();
        return !isShowAccountBadge() && hasDrawerMenuRedDot;
    }

    public String getAvatar() {
        AccountMine mCache = AccountMineInfoManager.getInstance().getMemoryMineInfo();
        if (mCache != null) {
            return mCache.face;
        }
        return null;
    }

    public OfficialVerify getOfficialVerify() {
        AccountMine mCache = AccountMineInfoManager.getInstance().getMemoryMineInfo();
        if (mCache != null) {
            return mCache.officialVerify;
        }
        return null;
    }

    public void onDestroy() {
    }
}