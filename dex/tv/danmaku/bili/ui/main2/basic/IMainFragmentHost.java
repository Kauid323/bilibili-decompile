package tv.danmaku.bili.ui.main2.basic;

import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageExtension;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageExtraInfo;
import com.bilibili.lib.ui.garb.Garb;

public interface IMainFragmentHost {
    void changeIsCustomTab(boolean z);

    void resetMainTopBg(long j);

    void updateEntranceMenu(int i);

    void updateMainTopBg(SecondaryPageExtension secondaryPageExtension, SecondaryPageExtraInfo secondaryPageExtraInfo, long j);

    void updateMainTopBgWithGarb(Garb garb, long j);
}