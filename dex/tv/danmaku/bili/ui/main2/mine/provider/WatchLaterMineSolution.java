package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import android.net.Uri;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution;

public class WatchLaterMineSolution implements IMinePageInfo {
    private IMineMenuItemSolution mMenuSolution = new DefaultMineMenuSolution();
    private IMineMenuItemRedirection mRedirection = new IMineMenuItemRedirection() { // from class: tv.danmaku.bili.ui.main2.mine.provider.WatchLaterMineSolution.1
        public void redirect(Activity context, MenuGroup.Item menuData) {
            RouteRequest routeRequest = new RouteRequest.Builder(Uri.parse("bilibili://user_center/watch_later_v2")).build();
            BLRouter.routeTo(routeRequest, context);
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