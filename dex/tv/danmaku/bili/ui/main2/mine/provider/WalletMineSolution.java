package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import android.content.Context;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.teenagersmode.TeenagersMode;
import tv.danmaku.bili.ui.mail.BiliPayIntentHelper;
import tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution;

public class WalletMineSolution implements IMinePageInfo {
    private static final String MISC_FLAG = "misc";
    private IMineMenuItemSolution mMenuSolution = new DefaultMineMenuSolution() { // from class: tv.danmaku.bili.ui.main2.mine.provider.WalletMineSolution.1
        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuCreated(Context context, MenuGroup.Item item) {
            super.onMenuCreated(context, item);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuItemUpdate(Context context, MenuGroup.Item item) {
            super.onMenuItemUpdate(context, item);
            if (TeenagersMode.getInstance().getEntranceState("pay") == 0 || RestrictedMode.isEnable(RestrictedType.LESSONS, WalletMineSolution.MISC_FLAG)) {
                setVisible(item, false);
            } else {
                setVisible(item, true);
            }
        }
    };
    private IMineMenuItemRedirection mRedirection = new IMineMenuItemRedirection() { // from class: tv.danmaku.bili.ui.main2.mine.provider.WalletMineSolution.2
        public void redirect(Activity context, MenuGroup.Item menuData) {
            BiliPayIntentHelper.toWallet(context);
        }

        public boolean isNeedLoginBeforeRedirect(MenuGroup.Item menuData) {
            return menuData.needLogin == 1;
        }
    };

    public IMineMenuItemSolution getMenuItemSolution() {
        return this.mMenuSolution;
    }

    public IMineMenuItemRedirection getRedirection() {
        return this.mRedirection;
    }
}