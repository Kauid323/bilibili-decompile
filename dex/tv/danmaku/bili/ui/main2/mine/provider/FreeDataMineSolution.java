package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import com.bilibili.fd_service.FreeDataConfig;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import tv.danmaku.bili.ui.freedata.FreeDataEntranceActivity;
import tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution;

public class FreeDataMineSolution implements IMinePageInfo {
    private IMineMenuItemSolution mMenuSolution = new DefaultMineMenuSolution();
    private IMineMenuItemRedirection mRedirection = new IMineMenuItemRedirection() { // from class: tv.danmaku.bili.ui.main2.mine.provider.FreeDataMineSolution.1
        public void redirect(Activity context, MenuGroup.Item menuData) {
            FreeDataConfig.getReporter().reportPageClick(1);
            FreeDataConfig.getReporter().reportFreeDataEntranceClick();
            BLRouter.routeTo(RouteRequestKt.toRouteRequest(FreeDataEntranceActivity.TARGET_WEB_SITE), context);
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