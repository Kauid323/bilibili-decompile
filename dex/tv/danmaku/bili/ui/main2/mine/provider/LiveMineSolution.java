package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import android.content.Context;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.live.LiveHybridOutService;
import com.bilibili.teenagersmode.TeenagersMode;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

public class LiveMineSolution implements IMinePageInfo {
    private IMineMenuItemSolution mMenuSolution = new LiveMenuSolution();
    private IMineMenuItemRedirection mRedirection = new IMineMenuItemRedirection() { // from class: tv.danmaku.bili.ui.main2.mine.provider.LiveMineSolution.1
        public void redirect(Activity context, MenuGroup.Item menuData) {
            LiveHybridOutService liveService = (LiveHybridOutService) BLRouter.INSTANCE.get(LiveHybridOutService.class, MineReporter.MINE_ICON_TYPE_DEFAULT);
            if (liveService != null) {
                liveService.goToLiveCenter(context, 0);
            }
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
    private static class LiveMenuSolution extends DefaultMineMenuSolution {
        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuCreated(Context context, MenuGroup.Item item) {
            super.onMenuCreated(context, item);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuItemUpdate(Context context, MenuGroup.Item item) {
            super.onMenuItemUpdate(context, item);
            if (TeenagersMode.getInstance().getEntranceState(AppConfig.HOST_LIVE) == 0 || RestrictedMode.isEnable(RestrictedType.LESSONS, "mine_live")) {
                setVisible(item, false);
            }
        }
    }
}