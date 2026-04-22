package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import android.content.Context;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.router.Router;
import com.bilibili.teenagersmode.TeenagersMode;
import tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution;
import tv.danmaku.bili.ui.uper.UperManager;
import tv.danmaku.bili.ui.uper.UperRepoter;
import tv.danmaku.bili.ui.uper.UperRouter;

public class UperCenterMineSolution implements IMinePageInfo {
    private IMineMenuItemSolution mMenuSolution = new UpperMenuItemSolution();
    private IMineMenuItemRedirection mRedirection = new IMineMenuItemRedirection() { // from class: tv.danmaku.bili.ui.main2.mine.provider.UperCenterMineSolution.1
        public void redirect(Activity context, MenuGroup.Item menuData) {
            Router.global().with(context).open("activity://uper/");
            UperRepoter.mythContributeCenterButtonClick(context);
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

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static class UpperMenuItemSolution extends DefaultMineMenuSolution {
        UpperMenuItemSolution() {
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onLoginStateChanged(Context context, MenuGroup.Item item) {
            if (!BiliAccounts.get(context).isLogin()) {
                UperManager.getInstance().reset();
                UperRouter.clearUpper(context);
            }
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuCreated(Context context, MenuGroup.Item item) {
            super.onMenuCreated(context, item);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuItemUpdate(Context context, MenuGroup.Item item) {
            super.onMenuItemUpdate(context, item);
            if (TeenagersMode.getInstance().getEntranceState("upper") == 0 || RestrictedMode.isEnable(RestrictedType.LESSONS, "uper")) {
                setVisible(item, false);
            }
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuDestroy(Context context) {
            super.onMenuDestroy(context);
            UperRouter.clearUpper(context);
        }
    }
}