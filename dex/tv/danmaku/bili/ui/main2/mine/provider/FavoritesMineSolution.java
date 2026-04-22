package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution;

public class FavoritesMineSolution implements IMinePageInfo {
    private static final String ACTION_URL_FAVORITY = "bilibili://main/favorite";
    private IMineMenuItemSolution mMenuSolution = new DefaultMineMenuSolution();
    private IMineMenuItemRedirection mRedirection = new IMineMenuItemRedirection() { // from class: tv.danmaku.bili.ui.main2.mine.provider.FavoritesMineSolution.1
        public void redirect(Activity context, MenuGroup.Item menuData) {
            BLRouter.routeTo(RouteRequestKt.toRouteRequest(FavoritesMineSolution.ACTION_URL_FAVORITY), context);
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