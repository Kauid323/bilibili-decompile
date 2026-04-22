package tv.danmaku.bili.ui.main2.api;

import com.bilibili.bus.IData;

public class TabDataUpdateEvent implements IData {
    public Boolean showTabBar;
    public boolean updateTab;

    public TabDataUpdateEvent(boolean showTabBar) {
        this.showTabBar = Boolean.valueOf(showTabBar);
    }

    public TabDataUpdateEvent(boolean showTabBar, boolean updateTab) {
        this.showTabBar = Boolean.valueOf(showTabBar);
        this.updateTab = updateTab;
    }
}