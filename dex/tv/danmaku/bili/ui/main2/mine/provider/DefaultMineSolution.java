package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import android.net.Uri;
import com.bilibili.commons.StringUtils;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import tv.danmaku.bili.ui.IntentHelper;
import tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution;

public class DefaultMineSolution implements IMinePageInfo {
    private IMineMenuItemSolution mMenuSolution = new DefaultMineMenuSolution();
    private IMineMenuItemRedirection mRedirection = new IMineMenuItemRedirection() { // from class: tv.danmaku.bili.ui.main2.mine.provider.DefaultMineSolution.1
        public void redirect(Activity context, MenuGroup.Item menuData) {
            if (StringUtils.contains(menuData.uri, "www.bilibili.com/h5/customer-service")) {
                InfoEyesManager.getInstance().report2(false, "000225", new String[]{"myth_service_click"});
            }
            IntentHelper.intentTo(context, Uri.parse(menuData.uri));
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