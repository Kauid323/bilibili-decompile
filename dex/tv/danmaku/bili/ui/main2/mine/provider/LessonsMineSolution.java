package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.teenagersmode.TeenagersMode;
import tv.danmaku.bili.ui.IntentHelper;
import tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution;

public class LessonsMineSolution implements IMinePageInfo {
    private IMineMenuItemSolution mMenuSolution = new DefaultMineMenuSolution() { // from class: tv.danmaku.bili.ui.main2.mine.provider.LessonsMineSolution.1
        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuCreated(Context context, MenuGroup.Item item) {
            super.onMenuCreated(context, item);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuItemUpdate(Context context, MenuGroup.Item item) {
            super.onMenuItemUpdate(context, item);
            if (TeenagersMode.getInstance().isEnable()) {
                setVisible(item, false);
            }
        }
    };
    private IMineMenuItemRedirection mRedirection = new IMineMenuItemRedirection() { // from class: tv.danmaku.bili.ui.main2.mine.provider.LessonsMineSolution.2
        public void redirect(Activity context, MenuGroup.Item menuData) {
            Neurons.reportClick(false, "main.lessonmodel.lesson-model.icon.click");
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